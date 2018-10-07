package com.sphms.expense.portlet.portlet.util;

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

public class ExpenseReportUtil {
	private static final Log _log = LogFactoryUtil.getLog(ExpenseReportUtil.class.getName());

	public static File createExpenseReport(JSONArray dataArray) throws IOException {

		int index = 1;

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();

		// default fonts
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setBold(true);
		font.setFontName("Arial");

		// Create Lables
		index = createReportLable(sheet, wb, index, "Expense List");
		index++;
		// Create Header for Bill Detail
		index = createExpenseHeader(sheet, wb, index);

		// fetch detail of outstanding detail
		_log.info("header of document is inserted");

		// fill detail of bill detail.
		double totalExpenseAmount = 0.0;
		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject detailObj = dataArray.getJSONObject(i);
			double amount = Double.parseDouble(dataArray.getJSONObject(i).get("amount").toString());
			totalExpenseAmount = totalExpenseAmount + amount;
			index = createExpenseReportRow(sheet, wb, index, detailObj);
		}
		// adding 3 black row with left and right border after filling all
		// records
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);

		index = createTotalExpenseAmount(sheet, wb, index, totalExpenseAmount);
		index++;

		sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
		sheet.setFitToPage(true);

		for (int i = 1; i <= 20; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		String fileName = "Expense Report" + ".xlsx";
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

	private static int createExpenseHeader(XSSFSheet sheet, XSSFWorkbook wb, int index) {
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
		cell12_1.setCellValue("Type");
		cell12_1.setCellStyle(style);

		XSSFCell cell12_2 = billDetailHeader.createCell(2);
		cell12_2.setCellValue("Amount");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_3 = billDetailHeader.createCell(3);
		cell12_3.setCellValue("Payment Type");
		cell12_3.setCellStyle(style);

		XSSFCell cell12_4 = billDetailHeader.createCell(4);
		cell12_4.setCellValue("Description");
		cell12_4.setCellStyle(style);

		XSSFCell cell12_5 = billDetailHeader.createCell(5);
		cell12_5.setCellValue("Expense Date");
		cell12_5.setCellStyle(style);

		index++;
		return index;
	}

	private static int createExpenseReportRow(XSSFSheet sheet, XSSFWorkbook wb, int index, JSONObject detailRow) {
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
		cell1.setCellValue(detailRow.getString("expenseType"));
		cell1.setCellStyle(firstCellStyle);

		XSSFCell cell2 = outStandingDetail.createCell(2);
		cell2.setCellValue(detailRow.getString("amount"));
		cell2.setCellStyle(style);
		XSSFCell cell3 = outStandingDetail.createCell(3);
		cell3.setCellValue(detailRow.getString("paymenttype"));
		cell3.setCellStyle(style);

		XSSFCell cell4 = outStandingDetail.createCell(4);
		cell4.setCellValue(detailRow.getString("description"));
		cell4.setCellStyle(style);

		XSSFCell cell5 = outStandingDetail.createCell(5);
		cell5.setCellValue(detailRow.getString("expenseDate"));
		cell5.setCellStyle(lastcellStyle);

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

	private static int createTotalExpenseAmount(XSSFSheet sheet, XSSFWorkbook wb, int index, double total) {

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
		cell2.setCellValue(String.valueOf(total));
		cell2.setCellStyle(style);

		XSSFCell cell3 = billTotalRow.createCell(3);
		cell3.setCellStyle(style);

		XSSFCell cell4 = billTotalRow.createCell(4);
		cell4.setCellStyle(style);

		XSSFCell cell5 = billTotalRow.createCell(5);
		cell5.setCellStyle(lastCellStyle);

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
