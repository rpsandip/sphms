package com.report.portlet.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
import com.sphms.common.service.service.SupplierBillLocalServiceUtil;

public class SupplierOutStandingPurchageUtil {


	private static final Log _log = LogFactoryUtil.getLog(SupplierOutStandingPurchageUtil.class.getName());

	public static File createSupplierOutStadnigPurchangeFile(long customComanyId, long supplierId, String supplierType,
			Date startDate,Date endDate) throws IOException, PortalException {

		int index = 1;

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();

		// default fonts
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setBold(true);
		font.setFontName("Arial");

		// Create Lables
		index = createReportLable(sheet, wb, index, "Out Standing Payment");
		index++;
		// Create Header for Bill Detail
		index = createBillDetailHeader(sheet, wb, index);

		// fetch detail of outstanding detail
		_log.info("header of document is inserted");
		JSONObject supplierOutStandingPurchangeObj = SupplierBillLocalServiceUtil.getSupplierReportDetail(customComanyId,
				supplierId, supplierType, startDate, endDate);
			
		// fill detail of bill detail.
		JSONArray jsonArray = supplierOutStandingPurchangeObj.getJSONArray("supplierBills");
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject detailObj = jsonArray.getJSONObject(i);
			index = createOutStandingReportRow(sheet, wb, index, detailObj);
		}
		// adding 3 black row with left and right border after filling all
		// records
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);

		index = createTotalBillAmount(sheet, wb, index, supplierOutStandingPurchangeObj.getDouble("totalSupplierAmount"));
		index++;

		// payment received lable
		index = createReportLable(sheet, wb, index, "Payment Given");
		_log.info("detail of LandLoad are filled");
		index++;

		// create a header for payment received.
		index = createPaymentDetailHeader(sheet, wb, index);

		jsonArray = supplierOutStandingPurchangeObj.getJSONArray("supplierBillPaymentArray");
		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject detailObj = jsonArray.getJSONObject(i);
			index = createPaymentBillingReportRow(sheet, wb, index, detailObj);
		}

		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);

		// add total payment for payment received
		createTotalCheckPayment(sheet, wb, index, supplierOutStandingPurchangeObj.getDouble("totalSupplierPaymentGiven"), 
				supplierOutStandingPurchangeObj.getDouble("totalSupplierPaymentGStGiven"));

		index = index + 2;
		// add total outstandin ammount
		createTotalOutStandingTotalRow(sheet, wb, index, supplierOutStandingPurchangeObj.getDouble("totalSupplierAmount"),
				supplierOutStandingPurchangeObj.getDouble("totalSupplierPaymentGiven"));

		sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
		sheet.setFitToPage(true);

		for (int i = 1; i <= 20; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		String fileName = "OutStanding Supplier Purchange Report" + ".xlsx";
		File file = new File(System.getProperty("catalina.home") + "/temp/" + fileName);

		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();

		return file;

	}

	private static int createReportLable(XSSFSheet sheet, XSSFWorkbook wb, int index, String Label) {
		XSSFRow billDetailHeader = sheet.createRow(index);
		billDetailHeader.setHeight((short) 500);

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBold(true);
		font.setFontName("Arial");

		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell1 = billDetailHeader.createCell(1);
		cell1.setCellValue(Label);
		cell1.setCellStyle(style);
		
		XSSFCell cell2 = billDetailHeader.createCell(2);
		cell2.setCellStyle(style);
		
		XSSFCell cell3 = billDetailHeader.createCell(3);
		cell3.setCellStyle(style);
		
		XSSFCell cell4 = billDetailHeader.createCell(4);
		cell4.setCellStyle(style);
		
		XSSFCell cell5 = billDetailHeader.createCell(5);
		cell5.setCellStyle(style);
		
		XSSFCell cell6 = billDetailHeader.createCell(6);
		cell6.setCellStyle(style);

		sheet.addMergedRegion(new CellRangeAddress(index, index, 1, 6));
		
		index++;
		return index;
	}
	
	

	private static int createBillDetailHeader(XSSFSheet sheet, XSSFWorkbook wb, int index) {
		XSSFRow billDetailHeader = sheet.createRow(index);
		billDetailHeader.setHeight((short) 500);
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		font.setFontName("Arial");

		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell12_1 = billDetailHeader.createCell(1);
		cell12_1.setCellValue("Bill No");
		cell12_1.setCellStyle(style);

		XSSFCell cell12_2 = billDetailHeader.createCell(2);
		cell12_2.setCellValue("Bill Date");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_3 = billDetailHeader.createCell(3);
		cell12_3.setCellValue("Bill Amount");
		cell12_3.setCellStyle(style);

		XSSFCell cell12_4 = billDetailHeader.createCell(4);
		cell12_4.setCellValue("GST");
		cell12_4.setCellStyle(style);

		XSSFCell cell12_5 = billDetailHeader.createCell(5);
		cell12_5.setCellValue("Supplier Name");
		cell12_5.setCellStyle(style);

		XSSFCell cell12_6 = billDetailHeader.createCell(6);
		cell12_6.setCellValue("Description");
		cell12_6.setCellStyle(style);
		index++;
		return index;
	}

	private static int createOutStandingReportRow(XSSFSheet sheet, XSSFWorkbook wb, int index, JSONObject detailRow) {
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Arial");
		
		XSSFRow outStandingDetail = sheet.createRow(index);
		XSSFCellStyle style = getRowStyle(outStandingDetail, wb);
		style.setFont(font);

		XSSFCellStyle firstCellStyle = getLeftBorderStyle(wb);
		firstCellStyle.setFont(font);

		XSSFCellStyle lastcellStyle = getRightBorderStyle(wb);
		lastcellStyle.setFont(font);

		XSSFCell cell1 = outStandingDetail.createCell(1);
		cell1.setCellValue(detailRow.getString("billNo"));
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = outStandingDetail.createCell(2);
		cell2.setCellValue(detailRow.getString("billDate"));
		cell2.setCellStyle(style);
		XSSFCell cell3 = outStandingDetail.createCell(3);
		cell3.setCellValue(Math.round(detailRow.getDouble("billAmount")));
		cell3.setCellStyle(style);

		XSSFCell cell4 = outStandingDetail.createCell(4);
		cell4.setCellValue(Math.round(detailRow.getDouble("billAmountGST")));
		cell4.setCellStyle(style);

		XSSFCell cell5 = outStandingDetail.createCell(5);
		cell5.setCellValue(detailRow.getString("supplierName"));
		cell5.setCellStyle(style);

		XSSFCell cell6 = outStandingDetail.createCell(6);
		cell6.setCellValue(detailRow.getString("descrption"));
		cell6.setCellStyle(lastcellStyle);
		index++;
		return index;

	}

	private static int blankRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font) {
		XSSFRow cityRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);

		XSSFCell cell1 = cityRow.createCell(1);
		cell1.setCellStyle(style);

		XSSFCell cell6 = cityRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));

		// mergedRegion(index, index, 1, 6, sheet);

		index++;
		return index;
	}

	private static int createTotalBillAmount(XSSFSheet sheet, XSSFWorkbook wb, int index, double total) {

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBold(true);
		font.setFontName("Arial");
		font.setColor(HSSFColor.GREEN.index);

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
		cell3.setCellValue(Math.round((total)));
		cell3.setCellStyle(style);

		XSSFCell cell4 = billTotalRow.createCell(4);
		cell4.setCellStyle(style);

		XSSFCell cell5 = billTotalRow.createCell(5);
		cell5.setCellStyle(style);

		XSSFCell cell6 = billTotalRow.createCell(6);
		cell6.setCellStyle(lastCellStyle);

		index++;
		return index;

	}

	private static int createPaymentDetailHeader(XSSFSheet sheet, XSSFWorkbook wb, int index) {
		XSSFRow paymentDetail = sheet.createRow(index);
		paymentDetail.setHeight((short) 500);

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBold(true);
		font.setFontName("Arial");

		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell12_1 = paymentDetail.createCell(1);
		cell12_1.setCellValue("Supplier Name");
		cell12_1.setCellStyle(style);

		XSSFCell cell12_2 = paymentDetail.createCell(2);
		cell12_2.setCellValue("Bill No");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_3 = paymentDetail.createCell(3);
		cell12_3.setCellValue("Payment Date");
		cell12_3.setCellStyle(style);

		XSSFCell cell12_4 = paymentDetail.createCell(4);
		cell12_4.setCellValue("Amount");
		cell12_4.setCellStyle(style);

		XSSFCell cell12_5 = paymentDetail.createCell(5);
		cell12_5.setCellValue("GST");
		cell12_5.setCellStyle(style);

		XSSFCell cell12_6 = paymentDetail.createCell(6);
		cell12_6.setCellValue("Payment Type");
		cell12_6.setCellStyle(style);

		index++;
		return index;
	}

	private static int createPaymentBillingReportRow(XSSFSheet sheet, XSSFWorkbook wb, int index,
			JSONObject detailRow) {

		XSSFRow outStandingDetail = sheet.createRow(index);

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Arial");

		XSSFCellStyle firstCellStyle = getLeftBorderStyle(wb);
		firstCellStyle.setFont(font);

		XSSFCellStyle lastCellStyle = getRightBorderStyle(wb);
		lastCellStyle.setFont(font);

		XSSFCellStyle style = getRowStyle(outStandingDetail, wb);
		style.setFont(font);

		XSSFCell cell1 = outStandingDetail.createCell(1);
		cell1.setCellValue(detailRow.getString("supplierName"));
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = outStandingDetail.createCell(2);
		cell2.setCellValue(detailRow.getString("billNo"));
		cell2.setCellStyle(style);

		XSSFCell cell3 = outStandingDetail.createCell(3);
		cell3.setCellValue(detailRow.getString("paymentDate"));
		cell3.setCellStyle(style);

		XSSFCell cell4 = outStandingDetail.createCell(4);
		cell4.setCellValue(Math.round(detailRow.getDouble("supplierBillAmount")));
		cell4.setCellStyle(style);

		XSSFCell cell5 = outStandingDetail.createCell(5);
		cell5.setCellValue(Math.round(detailRow.getDouble("supplierBillAmountGST")));
		cell5.setCellStyle(style);

		XSSFCell cell6 = outStandingDetail.createCell(6);
		cell6.setCellValue(detailRow.getString("paymentType"));
		cell6.setCellStyle(lastCellStyle);

		index++;
		return index;

	}

	private static int createTotalCheckPayment(XSSFSheet sheet, XSSFWorkbook wb, int index, double totalPaymentGiven,
			double totalPaymentGivenGST) {
		XSSFRow paymentTotalRow = sheet.createRow(index);

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBold(true);
		font.setFontName("Arial");
		font.setColor(HSSFColor.GREEN.index);

		XSSFCellStyle style = getBottomBorderStyle(wb);
		style.setFont(font);
		XSSFCellStyle firstCellStyle = getLeftBottomBorderStyle(wb);
		firstCellStyle.setFont(font);
		XSSFCellStyle lastCellStyle = getRightBottomBorderStyle(wb);
		lastCellStyle.setFont(font);

		getAllBorderStyle(wb);
		XSSFCell cell1 = paymentTotalRow.createCell(1);
		cell1.setCellValue("Total");
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = paymentTotalRow.createCell(2);
		cell2.setCellStyle(style);

		XSSFCell cell3 = paymentTotalRow.createCell(3);
		cell3.setCellStyle(style);

		XSSFCell cell4 = paymentTotalRow.createCell(4);
		cell4.setCellValue(Math.round((totalPaymentGiven)));
		cell4.setCellStyle(style);

		XSSFCell cell5 = paymentTotalRow.createCell(5);
		cell5.setCellValue(Math.round(totalPaymentGivenGST));
		cell5.setCellStyle(style);

		XSSFCell cell6 = paymentTotalRow.createCell(6);
		cell6.setCellStyle(lastCellStyle);
		index++;
		return index;

	}

	private static int createTotalOutStandingTotalRow(XSSFSheet sheet, XSSFWorkbook wb, int index,
			double totalOutStandingAmount, double totalPaymentGiven) {
		double outStandingAmount = totalOutStandingAmount - (totalPaymentGiven);
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setFontName("Arial");
		font.setColor(HSSFColor.WHITE.index);

		XSSFRow totalPayment = sheet.createRow(index);
		totalPayment.setHeight((short) 500);
		
		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFillForegroundColor(IndexedColors.GREEN.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell1 = totalPayment.createCell(1);
		
		cell1.setCellStyle(style);
		
		XSSFCell cell2 = totalPayment.createCell(2);
		cell2.setCellStyle(style);
		
		sheet.addMergedRegion(new CellRangeAddress(index, index, 1, 2));
		cell1.setCellValue("Total OutStanding");
		
		XSSFCell cell3 = totalPayment.createCell(3);
		cell3.setCellStyle(style);
		
		XSSFCell cell4 = totalPayment.createCell(4);
		cell4.setCellStyle(style);
		XSSFCell cell5 = totalPayment.createCell(5);
		
		cell5.setCellStyle(style);
		XSSFCell cell6 = totalPayment.createCell(6);
		cell6.setCellStyle(style);
		sheet.addMergedRegion(new CellRangeAddress(index, index, 3, 6));
		cell3.setCellValue(Math.round(outStandingAmount));
		

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
