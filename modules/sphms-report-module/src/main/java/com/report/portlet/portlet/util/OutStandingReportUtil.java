package com.report.portlet.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
import com.sphms.common.service.service.BillingLocalServiceUtil;

public class OutStandingReportUtil {

	private static final Log _log = LogFactoryUtil.getLog(OutStandingReportUtil.class.getName());

	public static File createOutStandingReport(long customComanyId, long clientId, int status, Date startDate,
			Date endDate) throws IOException {

		int index = 2;

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();

		index = createHeaderForOutStandingReport(sheet, wb, index);
		_log.info("header of document is inserted");
		JSONObject outStandingReportDetail = BillingLocalServiceUtil.getBillingListForReport(customComanyId, clientId,
				status, startDate, endDate);

		JSONArray jsonArray = outStandingReportDetail.getJSONArray("bills");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject detailObj = jsonArray.getJSONObject(i);
			index = createOutStandingReportRow(sheet, wb, index, detailObj);
		}
		createLastRow(sheet, wb, index, outStandingReportDetail.getDouble("totalPayment"),
				outStandingReportDetail.getDouble("totalBillAmount"),
				outStandingReportDetail.getDouble("totalOutStanding"));
		_log.info("detail of outStanding are filled");

		sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
		sheet.setFitToPage(true);
		
		for(int i=1;i<=20;i++){
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		String fileName = "OutStanding Report" + ".xlsx";
		File file = new File(System.getProperty("catalina.home") + "/temp/" + fileName);

		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();
		return file;

	}

	private static int createHeaderForOutStandingReport(XSSFSheet sheet, XSSFWorkbook wb, int index) {
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
		cell12_1.setCellValue("Client");
		cell12_1.setCellStyle(style);

		XSSFCell cell12_2 = poTableRow.createCell(2);
		cell12_2.setCellValue("Campaign");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_3 = poTableRow.createCell(3);
		cell12_3.setCellValue("FinanceYear");
		cell12_3.setCellStyle(style);

		XSSFCell cell12_4 = poTableRow.createCell(4);
		cell12_4.setCellValue("Bill No");
		cell12_4.setCellStyle(style);
		
		XSSFCell cell12_8 = poTableRow.createCell(5);
		cell12_8.setCellValue("Client PO");
		cell12_8.setCellStyle(style);

		XSSFCell cell12_5 = poTableRow.createCell(6);
		cell12_5.setCellValue("Booking Date");
		cell12_5.setCellStyle(style);

		XSSFCell cell12_6 = poTableRow.createCell(7);
		cell12_6.setCellValue("Total Bill Amount");
		cell12_6.setCellStyle(style);

		XSSFCell cell12_12 = poTableRow.createCell(8);
		cell12_12.setCellValue("Total Payment");
		cell12_12.setCellStyle(style);

		XSSFCell cell12_7 = poTableRow.createCell(9);
		cell12_7.setCellValue("Total Out Standing");
		cell12_7.setCellStyle(style);

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

		XSSFCell cell1 = outStandingDetail.createCell(1);
		cell1.setCellValue(detailRow.getString("client"));

		XSSFCell cell2 = outStandingDetail.createCell(2);
		cell2.setCellValue(detailRow.getString("campaign"));

		XSSFCell cell3 = outStandingDetail.createCell(3);
		cell3.setCellValue(detailRow.getString("financeYear"));

		XSSFCell cell4 = outStandingDetail.createCell(4);
		cell4.setCellValue(detailRow.getString("billNo"));
		
		XSSFCell cell9 = outStandingDetail.createCell(5);
		cell9.setCellValue(detailRow.getString("clientPO"));

		XSSFCell cell5 = outStandingDetail.createCell(6);
		cell5.setCellValue(detailRow.getString("bookingDate"));

		XSSFCell cell6 = outStandingDetail.createCell(7);
		cell6.setCellValue(detailRow.getString("totalBillAmount"));

		XSSFCell cell7 = outStandingDetail.createCell(8);
		cell7.setCellValue(detailRow.getString("totalPayment"));

		XSSFCell cell8 = outStandingDetail.createCell(9);
		cell8.setCellValue(detailRow.getString("totalOutStanding"));

		index++;
		return index;

	}

	private static int createLastRow(XSSFSheet sheet, XSSFWorkbook wb, int index, double totalPayment,
			double totalBillAmount, double totalOutStanding) {

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		font.setFontName("Arial");

		XSSFRow outStandingDetail = sheet.createRow(index);
		XSSFCellStyle style = getRowStyle(outStandingDetail, wb);
		style.setFont(font);

		XSSFCell cell1 = outStandingDetail.createCell(1);
		cell1.setCellValue("Total");
		XSSFCell cell6 = outStandingDetail.createCell(7);
		cell6.setCellValue(String.valueOf(totalBillAmount));
		XSSFCell cell7 = outStandingDetail.createCell(8);
		cell7.setCellValue(String.valueOf(totalPayment));
		XSSFCell cell8 = outStandingDetail.createCell(9);
		cell8.setCellValue(String.valueOf(totalOutStanding));
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

}
