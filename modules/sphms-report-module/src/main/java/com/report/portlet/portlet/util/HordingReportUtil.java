package com.report.portlet.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;

public class HordingReportUtil {
	private static final Log _log = LogFactoryUtil.getLog(HordingReportUtil.class.getName());

	public static File createHordingReport(long hordingId, String startDate,String endDate) throws IOException {

		int index = 1;

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();

		// default fonts
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setBold(true);
		font.setFontName("Arial");

		// Create Lables
		index=createHeaderForHeadingReport(sheet, wb, index);
		// fetch detail of outstanding detail
		_log.info("header of document is inserted");
		JSONObject hordingsDetail = HordingLocalServiceUtil.getHordingsFilter(hordingId, startDate,endDate);
				

		// fill detail of bill detail.
		JSONArray jsonArray = hordingsDetail.getJSONArray("hordingArray");
		for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject detailObj = jsonArray.getJSONObject(i);
				index = createHeadingReportRow(sheet, wb, index, detailObj);
		}
		// adding 3 black row with left and right border after filling all
		// records
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		
		//total ammount colum
		createTotalBillAmount(sheet, wb, index,hordingsDetail);
	
		//index = createTotalBillAmount(sheet, wb, index, totalbillAmount);
		//index++;

		
		sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
		sheet.setFitToPage(true);

		for (int i = 1; i <= 20; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		String fileName = "Heading Report" + ".xlsx";
		File file = new File(System.getProperty("catalina.home") + "/temp/" + fileName);

		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();

		return file;

	}

	private static int createHeaderForHeadingReport(XSSFSheet sheet, XSSFWorkbook wb, int index) {
		XSSFRow poTableRow = sheet.createRow(index);
		poTableRow.setHeight((short) 500);
		XSSFCellStyle style = getAllBorderStyle(wb);
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		font.setFontName("Arial");
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell12_1 = poTableRow.createCell(1);
		cell12_1.setCellValue("Town");
		cell12_1.setCellStyle(style);

		XSSFCell cell12_2 = poTableRow.createCell(2);
		cell12_2.setCellValue("City");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_3 = poTableRow.createCell(3);
		cell12_3.setCellValue("Display");
		cell12_3.setCellStyle(style);

		XSSFCell cell12_4 = poTableRow.createCell(4);
		cell12_4.setCellValue("Booking Agency");
		cell12_4.setCellStyle(style);

		XSSFCell cell12_5 = poTableRow.createCell(5);
		cell12_5.setCellValue("Size(W)");
		cell12_5.setCellStyle(style);
		
		XSSFCell cell12_6 = poTableRow.createCell(6);
		cell12_6.setCellValue("Size(H)");
		cell12_6.setCellStyle(style);
		
		XSSFCell cell12_7 = poTableRow.createCell(7);
		cell12_7.setCellValue("Area");
		cell12_7.setCellStyle(style);
		

		XSSFCell cell12_8 = poTableRow.createCell(8);
		cell12_8.setCellValue("Units");
		cell12_8.setCellStyle(style);

		XSSFCell cell12_9 = poTableRow.createCell(9);
		cell12_9.setCellValue("Type");
		cell12_9.setCellStyle(style);

		XSSFCell cell12_10 = poTableRow.createCell(10);
		cell12_10.setCellValue("StartDate");
		cell12_10.setCellStyle(style);

		XSSFCell cell12_11 = poTableRow.createCell(11);
		cell12_11.setCellValue("EndDate");
		cell12_11.setCellStyle(style);

		XSSFCell cell12_12 = poTableRow.createCell(12);
		cell12_12.setCellValue("Total duration");
		cell12_12.setCellStyle(style);

		XSSFCell cell12_13 = poTableRow.createCell(13);
		cell12_13.setCellValue("PricePerMonth");
		cell12_13.setCellStyle(style);

		XSSFCell cell12_14 = poTableRow.createCell(14);
		cell12_14.setCellValue("Mounting");
		cell12_14.setCellStyle(style);
		
		
		XSSFCell cell12_15 = poTableRow.createCell(15);
		cell12_15.setCellValue("Printing");
		cell12_15.setCellStyle(style);

		XSSFCell cell12_16 = poTableRow.createCell(16);
		cell12_16.setCellValue("Amount");
		cell12_16.setCellStyle(style);

		index++;
		return index;
	}


	private static int createHeadingReportRow(XSSFSheet sheet, XSSFWorkbook wb, int index, JSONObject detailRow) {
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Arial");

		XSSFRow holdingDetail = sheet.createRow(index);
		XSSFCellStyle style = getRowStyle(holdingDetail, wb);
		style.setFont(font);

		XSSFCellStyle firstCellStyle = getLeftBorderStyle(wb);
		firstCellStyle.setFont(font);

		XSSFCellStyle lastcellStyle = getRightBorderStyle(wb);
		style.setFont(font);

		XSSFCell cell1 = holdingDetail.createCell(1);
		cell1.setCellValue(detailRow.getString("title"));
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = holdingDetail.createCell(2);
		cell2.setCellValue(detailRow.getString("city"));
		cell2.setCellStyle(style);
		XSSFCell cell3 = holdingDetail.createCell(3);
		cell3.setCellValue(detailRow.getString("display"));
		cell3.setCellStyle(style);

		XSSFCell cell4 = holdingDetail.createCell(4);
		cell4.setCellValue(detailRow.getString("clientName"));
		cell4.setCellStyle(style);

		XSSFCell cell5 = holdingDetail.createCell(5);
		cell5.setCellValue(detailRow.getString("size_X"));
		cell5.setCellStyle(style);
		
		XSSFCell cell6 = holdingDetail.createCell(6);
		cell6.setCellValue(detailRow.getString("size_Y"));
		cell6.setCellStyle(style);
		
		XSSFCell cell7 = holdingDetail.createCell(7);
		cell7.setCellValue(detailRow.getString("area"));
		cell7.setCellStyle(style);

		XSSFCell cell8 = holdingDetail.createCell(8);
		cell8.setCellValue(detailRow.getString("units"));
		cell8.setCellStyle(style);
		
		
		XSSFCell cell9 = holdingDetail.createCell(9);
		cell9.setCellValue(detailRow.getString("hordingType"));
		cell9.setCellStyle(style);
		
		
		XSSFCell cell10 = holdingDetail.createCell(10);
		cell10.setCellValue(detailRow.getString("hordingBookingStartDate"));
		cell10.setCellStyle(style);
		
		XSSFCell cell11 = holdingDetail.createCell(11);
		cell11.setCellValue(detailRow.getString("hordingBookingEndDate"));
		cell11.setCellStyle(style);
		
		XSSFCell cell12 = holdingDetail.createCell(12);
		cell12.setCellValue(detailRow.getString("displayDuration"));
		cell12.setCellStyle(style);
		
		XSSFCell cell13 = holdingDetail.createCell(13);
		cell13.setCellValue(detailRow.getString("pricePerMonth"));
		cell13.setCellStyle(style);
		
		
		XSSFCell cell14 = holdingDetail.createCell(14);
		cell14.setCellValue(detailRow.getString("totalMountingCharge"));
		cell14.setCellStyle(style);
		
		XSSFCell cell15 = holdingDetail.createCell(15);
		cell15.setCellValue(detailRow.getString("totalPrintingCharge"));
		cell15.setCellStyle(style);
		
		XSSFCell cell16 = holdingDetail.createCell(16);
		cell16.setCellValue(detailRow.getString("totalHordingCharge"));
		cell16.setCellStyle(lastcellStyle);
		
	
		index++;
		return index;

	}

	private static int blankRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font) {
		XSSFRow cityRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);

		XSSFCell cell1 = cityRow.createCell(1);
		cell1.setCellStyle(style);

		XSSFCell cell16 = cityRow.createCell(16);
		cell16.setCellStyle(getRightBorderStyle(wb));

		// mergedRegion(index, index, 1, 6, sheet);

		index++;
		return index;
	}

	private static int createTotalBillAmount(XSSFSheet sheet, XSSFWorkbook wb, int index,JSONObject totalObject) {

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBold(true);
		font.setFontName("Arial");
		font.setColor(HSSFColor.RED.index);

		XSSFRow billTotalRow = sheet.createRow(index);
		XSSFCellStyle style = getBottomBorderStyle(wb);
		style.setFont(font);

		XSSFCellStyle firstCellStyle = getLeftBottomBorderStyle(wb);
		firstCellStyle.setFont(font);

		XSSFCellStyle lastCellStyle = getRightBottomBorderStyle(wb);
		lastCellStyle.setFont(font);

		XSSFCell cell1 = billTotalRow.createCell(1);
		cell1.setCellValue("Total");
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = billTotalRow.createCell(2);
		cell2.setCellStyle(style);

		XSSFCell cell3 = billTotalRow.createCell(3);
		cell3.setCellStyle(style);

		XSSFCell cell4 = billTotalRow.createCell(4);
		cell4.setCellStyle(style);

		XSSFCell cell5 = billTotalRow.createCell(5);
		cell5.setCellStyle(style);

		XSSFCell cell6 = billTotalRow.createCell(6);
		cell6.setCellStyle(style);
		
		XSSFCell cell7 = billTotalRow.createCell(7);
		cell7.setCellStyle(style);
	
		XSSFCell cell8 = billTotalRow.createCell(8);
		cell8.setCellStyle(style);
		
		XSSFCell cell9 = billTotalRow.createCell(9);
		cell9.setCellStyle(style);
		
		XSSFCell cell10 = billTotalRow.createCell(10);
		cell10.setCellStyle(style);
		
		XSSFCell cell11 = billTotalRow.createCell(11);
		cell11.setCellStyle(style);
		
		XSSFCell cell12 = billTotalRow.createCell(12);
		cell12.setCellStyle(style);
		
		XSSFCell cell13 = billTotalRow.createCell(13);
		cell13.setCellStyle(style);
		
		XSSFCell cell14 = billTotalRow.createCell(14);
		cell14.setCellValue(totalObject.getString("sumOfTMCharg"));
		cell14.setCellStyle(style);
		
		XSSFCell cell15 = billTotalRow.createCell(15);
		cell15.setCellValue(totalObject.getString("sumOFTPharg"));
		cell15.setCellStyle(style);
		
		
		XSSFCell cell16 = billTotalRow.createCell(16);
		cell16.setCellValue(totalObject.getString("sumOFTHCharg"));
		cell16.setCellStyle(lastCellStyle);
	

		index++;
		return index;

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

}
