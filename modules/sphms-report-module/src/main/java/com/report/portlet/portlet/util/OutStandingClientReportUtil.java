package com.report.portlet.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
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
import com.sphms.common.service.service.BillingLocalServiceUtil;

public class OutStandingClientReportUtil {
	private static final Log _log = LogFactoryUtil.getLog(OutStandingClientReportUtil.class.getName());

	public static File createOutStandingClientBillingReport(long customComanyId, long clientId) throws IOException {

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
		index = createReportLable(sheet, wb, index, "Bill Given");
		index++;
		// Create Header for Bill Detail
		index = createBillDetailHeader(sheet, wb, index);

		// fetch detail of outstanding detail
		_log.info("header of document is inserted");
		JSONObject outStandingReportDetail = BillingLocalServiceUtil.getBillingListForReport(customComanyId, clientId,
				-1, null, null);

		// fill detail of bill detail.
		JSONArray jsonArray = outStandingReportDetail.getJSONArray("bills");
		double totalbillAmount = 0.0;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject detailObj = jsonArray.getJSONObject(i);
			double totalOutStanding = Double.parseDouble(jsonArray.getJSONObject(i).get("totalOutStanding").toString());
			if (totalOutStanding > 0) {
				double billAmount = Double.parseDouble(jsonArray.getJSONObject(i).get("totalBillAmount").toString());
				totalbillAmount = totalbillAmount + billAmount;
				index = createOutStandingReportRow(sheet, wb, index, detailObj);
			}
		}
		// adding 3 black row with left and right border after filling all
		// records
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);

		index = createTotalBillAmount(sheet, wb, index, totalbillAmount);
		index++;

		// payment received lable
		index = createReportLable(sheet, wb, index, "Payment Received");
		_log.info("detail of LandLoad are filled");
		index++;

		// create a header for payment received.
		index = createPaymentDetailHeader(sheet, wb, index);

		double totalDeducationAmount = 0.0;
		double totalAmount = 0.0;
		for (int i = 0; i < jsonArray.length(); i++) {
			double totalOutStanding = Double.valueOf(jsonArray.getJSONObject(i).get("totalOutStanding").toString());
			if (totalOutStanding > 0) {
				JSONArray paymentJsonArray = jsonArray.getJSONObject(i).getJSONArray("payments");
				for (int j = 0; j < paymentJsonArray.length(); j++) {

					JSONObject paymentObj = paymentJsonArray.getJSONObject(j);
					double deducation = Double
							.valueOf(paymentJsonArray.getJSONObject(j).get("totalDeduction").toString());
					totalDeducationAmount = totalDeducationAmount + deducation;

					double amount = Double.valueOf(paymentJsonArray.getJSONObject(j).get("amount").toString());
					totalAmount = totalAmount + amount;
					// add detail of paid bill
					index = createPaymentBillingReportRow(sheet, wb, index, paymentObj);
				}
			}
		}

		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);

		// add total payment for payment received
		createTotalCheckPayment(sheet, wb, index, totalDeducationAmount, totalAmount);

		index = index + 2;
		// add total outstandin ammount
		createTotalOutStandingTotalRow(sheet, wb, index, totalbillAmount, totalDeducationAmount, totalAmount);

		sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
		sheet.setFitToPage(true);

		for (int i = 1; i <= 20; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		String fileName = "OutStanding Clinet Report" + ".xlsx";
		File file = new File(System.getProperty("catalina.home") + "/temp/" + fileName);

		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();

		return file;

	}

	private static int createReportLable(XSSFSheet sheet, XSSFWorkbook wb, int index, String Label) {
		sheet.addMergedRegion(new CellRangeAddress(index, index, 1, 6));
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

		XSSFCell cell12_1 = billDetailHeader.createCell(1);
		cell12_1.setCellValue(Label);
		cell12_1.setCellStyle(style);

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
		cell12_4.setCellValue("Client");
		cell12_4.setCellStyle(style);

		XSSFCell cell12_5 = billDetailHeader.createCell(5);
		cell12_5.setCellValue("Place");
		cell12_5.setCellStyle(style);

		XSSFCell cell12_6 = billDetailHeader.createCell(6);
		cell12_6.setCellValue("Display Month");
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
		style.setFont(font);

		XSSFCell cell1 = outStandingDetail.createCell(1);
		cell1.setCellValue(detailRow.getString("billNo"));
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = outStandingDetail.createCell(2);
		cell2.setCellValue(detailRow.getString("bookingDate"));
		cell2.setCellStyle(style);
		XSSFCell cell3 = outStandingDetail.createCell(3);
		cell3.setCellValue(detailRow.getString("totalBillAmount"));
		cell3.setCellStyle(style);

		XSSFCell cell4 = outStandingDetail.createCell(4);
		cell4.setCellValue(detailRow.getString("client"));
		cell4.setCellStyle(style);

		XSSFCell cell5 = outStandingDetail.createCell(5);
		cell5.setCellValue(detailRow.getString("campaign"));
		cell5.setCellStyle(style);

		XSSFCell cell6 = outStandingDetail.createCell(6);
		cell6.setCellValue(detailRow.getString("displayDate"));
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
		cell3.setCellValue(String.valueOf(total));
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
		cell12_1.setCellValue("Bill No");
		cell12_1.setCellStyle(style);

		XSSFCell cell12_2 = paymentDetail.createCell(2);
		cell12_2.setCellValue("Check No(Payment Type)");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_3 = paymentDetail.createCell(3);
		cell12_3.setCellValue("T.D.S Deducted");
		cell12_3.setCellStyle(style);

		XSSFCell cell12_4 = paymentDetail.createCell(4);
		cell12_4.setCellValue("Other Deduction");
		cell12_4.setCellStyle(style);

		XSSFCell cell12_5 = paymentDetail.createCell(5);
		cell12_5.setCellValue("Total Deducation");
		cell12_5.setCellStyle(style);

		XSSFCell cell12_6 = paymentDetail.createCell(6);
		cell12_6.setCellValue("Amount");
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
		cell1.setCellValue(detailRow.getString("billNo"));
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = outStandingDetail.createCell(2);
		cell2.setCellValue(detailRow.getString("chequeNo") + "(" + detailRow.getString("paymenttype") + ")");
		cell2.setCellStyle(style);

		XSSFCell cell3 = outStandingDetail.createCell(3);
		cell3.setCellValue(detailRow.getString("tds"));
		cell3.setCellStyle(style);

		XSSFCell cell4 = outStandingDetail.createCell(4);
		cell4.setCellValue(detailRow.getString("deduction"));
		cell4.setCellStyle(style);

		XSSFCell cell5 = outStandingDetail.createCell(5);
		cell5.setCellValue(detailRow.getString("totalDeduction"));
		cell5.setCellStyle(style);

		XSSFCell cell6 = outStandingDetail.createCell(6);
		cell6.setCellValue(detailRow.getString("amount"));
		cell6.setCellStyle(lastCellStyle);

		index++;
		return index;

	}

	private static int createTotalCheckPayment(XSSFSheet sheet, XSSFWorkbook wb, int index, double totalDeducation,
			double totalAmount) {
		XSSFRow paymentTotalRow = sheet.createRow(index);

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBold(true);
		font.setFontName("Arial");
		font.setColor(HSSFColor.RED.index);

		XSSFCellStyle style = getBottomBorderStyle(wb);
		style.setFont(font);
		XSSFCellStyle firstCellStyle = getLeftBottomBorderStyle(wb);
		firstCellStyle.setFont(font);
		XSSFCellStyle lastCellStyle = getRightBorderStyle(wb);
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
		cell4.setCellStyle(style);

		XSSFCell cell5 = paymentTotalRow.createCell(5);
		cell5.setCellValue(String.valueOf(totalDeducation));
		cell5.setCellStyle(style);

		XSSFCell cell6 = paymentTotalRow.createCell(6);
		cell6.setCellValue(String.valueOf(totalAmount));
		cell6.setCellStyle(lastCellStyle);
		index++;
		return index;

	}

	private static int createTotalOutStandingTotalRow(XSSFSheet sheet, XSSFWorkbook wb, int index,
			double totalbillAmount, double totalDeducationAmount, double totalAmount) {
		sheet.addMergedRegion(new CellRangeAddress(index, index, 1, 2));
		sheet.addMergedRegion(new CellRangeAddress(index, index, 3, 6));
		double outStandingAmount = totalbillAmount + (totalDeducationAmount - totalAmount);
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setFontName("Arial");
		font.setColor(HSSFColor.BLACK.index);

		XSSFRow landLoadDetail = sheet.createRow(index);
		landLoadDetail.setHeight((short) 500);
		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFillForegroundColor(HSSFColor.GREEN.index);
		style.setFont(font);

		XSSFCell cell1 = landLoadDetail.createCell(1);
		cell1.setCellValue("Total OutStanding");
		cell1.setCellStyle(style);

		XSSFCell cell2 = landLoadDetail.createCell(3);
		cell2.setCellValue(String.valueOf(outStandingAmount));
		cell2.setCellStyle(style);

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
