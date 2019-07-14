package com.report.portlet.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;

public class GSTReportUtil {
	
	private static final Log _log = LogFactoryUtil.getLog(GSTReportUtil.class.getName());

	public static File createGSTReport(long customCompanyId, String startDate, String endDate) throws IOException, PortalException {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		if(customCompanyId==-1){
			List<CustomCompany> customCompanyList = CustomCompanyLocalServiceUtil.getCustomCompanies(-1, -1);
			for(CustomCompany customCompany : customCompanyList){
				createCompanyXSSFSheetForGSTReport(wb, customCompany, startDate, endDate);
			}
		}else{
			CustomCompany customCompany = CustomCompanyLocalServiceUtil.getCustomCompany(customCompanyId);
			createCompanyXSSFSheetForGSTReport(wb, customCompany, startDate, endDate);
		}
				
		// Write the output to a file
		String fileName = "GST Report" + ".xlsx";
		File file = new File(System.getProperty("catalina.home") + "/temp/" + fileName);

		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();
		return file;
	}
	
	private static void createCompanyXSSFSheetForGSTReport(XSSFWorkbook wb, CustomCompany customCompany,
			String startDate, String endDate){
		
		JSONObject gstBillDetail = BillingLocalServiceUtil.getCompanyBillingDetail(customCompany.getCompanyId(),
				startDate, endDate);
		
		XSSFSheet sheet = wb.createSheet(customCompany.getName());
		
		int index = 1;
		
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setBold(true);
		font.setFontName("Arial");
		
		index = createCompanyRow(sheet, wb, index, customCompany);
		index = createHeaderForGSTReport(sheet, wb, index);
		
		JSONArray jsonArray = gstBillDetail.getJSONArray("billRows");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject detailObj = jsonArray.getJSONObject(i);
			index = createGSTReporttRow(sheet, wb, index, detailObj);
		}
		
		index = createTotalRow(sheet, wb, index, gstBillDetail.getDouble("totalNetAmount"),gstBillDetail.getDouble("totaliGST"),
				gstBillDetail.getDouble("totalcGST"), gstBillDetail.getDouble("totalsGST"), 
				gstBillDetail.getDouble("totalAmount"));
		
		sheet.setColumnWidth(1, 2500);
		sheet.setColumnWidth(2, 2500);
		sheet.setColumnWidth(3, 3500);
		sheet.setColumnWidth(4, 3000);
		sheet.setColumnWidth(5, 2000);
		sheet.setColumnWidth(6, 2500);
		sheet.setColumnWidth(7, 1500);
		sheet.setColumnWidth(8, 1500);
		sheet.setColumnWidth(9, 1500);
		sheet.setColumnWidth(10, 3000);

		sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
		sheet.setFitToPage(true);
	}
	
	
	private static int createCompanyRow(XSSFSheet sheet, XSSFWorkbook wb, int index, CustomCompany company) {
		XSSFRow companyNameRow = sheet.createRow(index);
		companyNameRow.setHeight((short) 1300);
		XSSFCellStyle style = getAllBorderStyle(wb);
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 48);
		font.setBold(true);
		font.setFontName("Trebuchet MS");
		style.setFont(font);
		font.setColor(IndexedColors.BLACK.getIndex());
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell1 = companyNameRow.createCell(1);
		cell1.setCellValue(company.getName());
		cell1.setCellStyle(style);

		XSSFCell cell2 = companyNameRow.createCell(2);
		cell2.setCellStyle(style);

		XSSFCell cell3 = companyNameRow.createCell(3);
		cell3.setCellStyle(style);

		XSSFCell cell4 = companyNameRow.createCell(4);
		cell4.setCellStyle(style);

		XSSFCell cell5 = companyNameRow.createCell(5);
		cell5.setCellStyle(style);

		XSSFCell cell6 = companyNameRow.createCell(6);
		cell6.setCellStyle(style);

		XSSFCell cell7 = companyNameRow.createCell(7);
		cell7.setCellStyle(style);

		XSSFCell cell8 = companyNameRow.createCell(8);
		cell8.setCellStyle(style);

		XSSFCell cell9 = companyNameRow.createCell(9);
		cell9.setCellStyle(style);
		
		XSSFCell cell10 = companyNameRow.createCell(10);
		cell10.setCellStyle(style);

		mergedRegion(index, index, 1, 10, sheet);

		index++;

		return index;
	}
	
	private static int createHeaderForGSTReport(XSSFSheet sheet, XSSFWorkbook wb, int index) {
		XSSFRow headerRow = sheet.createRow(index);
		headerRow.setHeight((short) 500);
		XSSFCellStyle style = getAllBorderStyle(wb);
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		font.setFontName("Arial");
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell12_1 = headerRow.createCell(1);
		cell12_1.setCellValue("Bill No.");
		cell12_1.setCellStyle(style);

		XSSFCell cell12_2 = headerRow.createCell(2);
		cell12_2.setCellValue("Bill Date");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_3 = headerRow.createCell(3);
		cell12_3.setCellValue("Client");
		cell12_3.setCellStyle(style);

		XSSFCell cell12_4 = headerRow.createCell(4);
		cell12_4.setCellValue("Client GST No.");
		cell12_4.setCellStyle(style);
		
		XSSFCell cell12_8 = headerRow.createCell(5);
		cell12_8.setCellValue("State");
		cell12_8.setCellStyle(style);

		XSSFCell cell12_5 = headerRow.createCell(6);
		cell12_5.setCellValue("Net Amount");
		cell12_5.setCellStyle(style);

		XSSFCell cell12_6 = headerRow.createCell(7);
		cell12_6.setCellValue("IGST 18%");
		cell12_6.setCellStyle(style);

		XSSFCell cell12_12 = headerRow.createCell(8);
		cell12_12.setCellValue("CGST 9%");
		cell12_12.setCellStyle(style);

		XSSFCell cell12_7 = headerRow.createCell(9);
		cell12_7.setCellValue("SGST 9%");
		cell12_7.setCellStyle(style);
		
		XSSFCell cell12_10 = headerRow.createCell(10);
		cell12_10.setCellValue("Total");
		cell12_10.setCellStyle(style);

		index++;
		return index;
	}
	
	
	private static int createGSTReporttRow(XSSFSheet sheet, XSSFWorkbook wb, int index, JSONObject detailRow) {
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Arial");

		XSSFRow outStandingDetail = sheet.createRow(index);
		XSSFCellStyle style = getRowStyle(outStandingDetail, wb);
		style.setFont(font);
		
		XSSFCellStyle firstCellStyle = getLeftBorderStyle(wb);
		firstCellStyle.setFont(font);

		XSSFCellStyle lastCellStyle = getRightBorderStyle(wb);
		lastCellStyle.setFont(font);


		XSSFCell cell1 = outStandingDetail.createCell(1);
		cell1.setCellValue(detailRow.getString("displayBillNo"));
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = outStandingDetail.createCell(2);
		cell2.setCellValue(detailRow.getString("billDate"));
		cell2.setCellStyle(style);

		XSSFCell cell3 = outStandingDetail.createCell(3);
		cell3.setCellValue(detailRow.getString("clientName"));
		cell3.setCellStyle(style);

		XSSFCell cell4 = outStandingDetail.createCell(4);
		cell4.setCellValue(detailRow.getString("clientGSTNo"));
		cell4.setCellStyle(style);
		
		XSSFCell cell9 = outStandingDetail.createCell(5);
		cell9.setCellValue(detailRow.getString("state"));
		cell9.setCellStyle(style);

		XSSFCell cell5 = outStandingDetail.createCell(6);
		cell5.setCellValue(Math.round(Double.parseDouble(detailRow.getString("netAmount"))));
		cell5.setCellStyle(style);

		XSSFCell cell6 = outStandingDetail.createCell(7);
		cell6.setCellValue(Math.round(Double.parseDouble(detailRow.getString("iGST"))));
		cell6.setCellStyle(style);

		XSSFCell cell7 = outStandingDetail.createCell(8);
		cell7.setCellValue(Math.round(Double.parseDouble(detailRow.getString("cGST"))));
		cell7.setCellStyle(style);

		XSSFCell cell8 = outStandingDetail.createCell(9);
		cell8.setCellValue(Math.round(Double.parseDouble(detailRow.getString("sGST"))));
		cell8.setCellStyle(style);
		
		XSSFCell cell10 = outStandingDetail.createCell(10);
		cell10.setCellValue(Math.round(Double.parseDouble(detailRow.getString("totalAmount"))));
		cell10.setCellStyle(lastCellStyle);

		index++;
		return index;

	}
	
	private static int createTotalRow(XSSFSheet sheet, XSSFWorkbook wb, int index, double totalNetAmount,
			double iGSTAmount, double cGStAmount, double sGSTAmount, double totalAmount) {

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setFontName("Arial");
		font.setColor(HSSFColor.WHITE.index);

		XSSFRow outStandingDetail = sheet.createRow(index);
		
		XSSFCellStyle allBorder = getAllBorderStyle(wb);
		allBorder.setFont(font);
		allBorder.setFillForegroundColor(IndexedColors.GREEN.index);
		allBorder.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		allBorder.setFont(font);
		allBorder.setAlignment(HorizontalAlignment.CENTER);
		allBorder.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell1 = outStandingDetail.createCell(1);
		cell1.setCellStyle(allBorder);
		cell1.setCellValue("Total");
		
		XSSFCell cell2 = outStandingDetail.createCell(2);
		cell2.setCellStyle(allBorder);
		XSSFCell cell3 = outStandingDetail.createCell(3);
	
		cell3.setCellStyle(allBorder);
		
		XSSFCell cell4 = outStandingDetail.createCell(4);
		cell4.setCellStyle(allBorder);
		XSSFCell cell5 = outStandingDetail.createCell(5);
		cell5.setCellStyle(allBorder);
	
		mergedRegion(index, index, 1, 5, sheet);
		
		XSSFCell cell7 = outStandingDetail.createCell(6);
		cell7.setCellValue(Math.round(Double.parseDouble(String.valueOf(totalNetAmount))));
		cell7.setCellStyle(allBorder);
		XSSFCell cell8 = outStandingDetail.createCell(7);
		cell8.setCellValue(Math.round(Double.parseDouble(String.valueOf(iGSTAmount))));
		cell8.setCellStyle(allBorder);
		XSSFCell cell9 = outStandingDetail.createCell(8);
		cell9.setCellValue(Math.round(Double.parseDouble(String.valueOf(cGStAmount))));
		cell9.setCellStyle(allBorder);
		
		XSSFCell cell10 = outStandingDetail.createCell(9);
		cell10.setCellValue(Math.round(Double.parseDouble(String.valueOf(sGSTAmount))));
		cell10.setCellStyle(allBorder);
		
		XSSFCell cell11 = outStandingDetail.createCell(10);
		cell11.setCellValue(Math.round(Double.parseDouble(String.valueOf(totalAmount))));
		cell11.setCellStyle(allBorder);
		
		index++;
		return index;
	}
	
	private static XSSFCellStyle getAllBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM);
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		return style;
	}

	private static XSSFCellStyle getRowStyle(XSSFRow row, XSSFWorkbook wb) {

		// Create a new font and alter it.
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		font.setFontName("Arial");

		// Set font into style
		XSSFCellStyle style = wb.createCellStyle();
		style.setFont(font);
		return style;
	}
	
	
	private static XSSFCellStyle getBottomBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.MEDIUM);
		return style;
	}

	private static XSSFCellStyle getLeftBottomBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		return style;
	}

	private static XSSFCellStyle getRightBottomBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		return style;
	}

	private static XSSFCellStyle getLeftBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderLeft(BorderStyle.MEDIUM);
		return style;
	}

	private static XSSFCellStyle getRightBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderRight(BorderStyle.MEDIUM);
		return style;
	}
	
	private static void mergedRegion(int rowStart, int rowEnd, int columnStart, int columnEnd, XSSFSheet sheet) {
		CellRangeAddress cellRnage = new CellRangeAddress(rowStart, rowEnd, columnStart, columnEnd);
		sheet.addMergedRegion(cellRnage);
	}

}
