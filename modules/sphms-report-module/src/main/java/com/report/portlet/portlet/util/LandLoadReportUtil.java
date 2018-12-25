package com.report.portlet.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.service.LandLordLocalServiceUtil;

public class LandLoadReportUtil {

	private static final Log _log = LogFactoryUtil.getLog(LandLoadReportUtil.class.getName());

	public static File createLandLoadReport(long landLoadId, String startDate, String endDate) throws IOException {

		int index = 2;

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();

		index = createLandLoadDetailHeader(sheet, wb, index);
		_log.info("header of document is inserted");
		List<Object> landLoadReportDetail = LandLordLocalServiceUtil.getLandLoadFilter(landLoadId, startDate, endDate);
		double total = 0.0;
		for (Object row : landLoadReportDetail) {
			Object[] detailObj = (Object[]) row;
			total = total + Double.valueOf(String.valueOf(detailObj[5]));
			index = createLandLoadRow(sheet, wb, index, detailObj);
		}
		
		blankRow(sheet, wb, index);
		blankRow(sheet, wb, index);
		
		createLastRow(sheet, wb, index, total);
		_log.info("detail of LandLoad are filled");

		sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
		sheet.setFitToPage(true);

		for (int i = 1; i <= 20; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write the output to a file
		String fileName = "LandLoad Report" + ".xlsx";
		File file = new File(System.getProperty("catalina.home") + "/temp/" + fileName);

		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();

		return file;

	}

	private static int createLandLoadDetailHeader(XSSFSheet sheet, XSSFWorkbook wb, int index) {
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
		cell12_1.setCellValue("First Name");
		cell12_1.setCellStyle(style);

		XSSFCell cell12_2 = poTableRow.createCell(2);
		cell12_2.setCellValue("Last Name");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_4 = poTableRow.createCell(3);
		cell12_4.setCellValue("City");
		cell12_4.setCellStyle(style);

		XSSFCell cell12_5 = poTableRow.createCell(4);
		cell12_5.setCellValue("Phone No");
		cell12_5.setCellStyle(style);

		XSSFCell cell12_6 = poTableRow.createCell(5);
		cell12_6.setCellValue("Amount");
		cell12_6.setCellStyle(style);

		XSSFCell cell12_12 = poTableRow.createCell(6);
		cell12_12.setCellValue("Payment Date");
		cell12_12.setCellStyle(style);

		XSSFCell cell12_7 = poTableRow.createCell(7);
		cell12_7.setCellValue("Payment Type");
		cell12_7.setCellStyle(style);

		XSSFCell cell12_9 = poTableRow.createCell(8);
		cell12_9.setCellValue("Hoarding");
		cell12_9.setCellStyle(style);

		index++;
		return index;
	}

	private static int createLandLoadRow(XSSFSheet sheet, XSSFWorkbook wb, int index, Object[] detailRow) {

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Arial");

		XSSFRow landLoadDetail = sheet.createRow(index);
		XSSFCellStyle style = getRowStyle(landLoadDetail, wb);
		style.setFont(font);
		

		XSSFCellStyle firstCellStyle = getLeftBorderStyle(wb);
		XSSFCellStyle lastcellStyle = getRightBorderStyle(wb);
		

		XSSFCell cell1 = landLoadDetail.createCell(1);
		cell1.setCellValue(String.valueOf(detailRow[0]));
		cell1.setCellStyle(firstCellStyle);
		
		XSSFCell cell2 = landLoadDetail.createCell(2);
		cell2.setCellValue(String.valueOf(detailRow[1]));
		cell2.setCellStyle(style);
		
		XSSFCell cell4 = landLoadDetail.createCell(3);
		cell4.setCellValue(String.valueOf(detailRow[3]));
		cell4.setCellStyle(style);
		
		XSSFCell cell5 = landLoadDetail.createCell(4);
		cell5.setCellValue(String.valueOf(detailRow[4]));
		cell5.setCellStyle(style);
		
		XSSFCell cell6 = landLoadDetail.createCell(5);
		cell6.setCellValue(String.valueOf(detailRow[5]));
		cell6.setCellStyle(style);
		
		XSSFCell cell7 = landLoadDetail.createCell(6);
		cell7.setCellValue(String.valueOf(detailRow[11]));
		cell7.setCellStyle(style);
		
		String paymentType = StringPool.BLANK;
		if (Validator.isNotNull(detailRow[6])) {
			paymentType = "Cheque No: " + detailRow[6] + "(" + detailRow[7] + " )";
		} else {
			paymentType = "Cash";
		}

		XSSFCell cell8 = landLoadDetail.createCell(7);
		cell8.setCellValue(paymentType);
		cell8.setCellStyle(style);
		
		XSSFCell cel9 = landLoadDetail.createCell(8);
		cel9.setCellValue(String.valueOf(detailRow[8]));
		cel9.setCellStyle(lastcellStyle);

		index++;
		return index;

	}

	private static int createLastRow(XSSFSheet sheet, XSSFWorkbook wb, int index, double total) {

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
		font.setBold(true);
		font.setFontName("Arial");
		font.setColor(HSSFColor.RED.index);
		
		
		XSSFCellStyle style = getBottomBorderStyle(wb);
		style.setFont(font);
		
		XSSFCellStyle firstCellStyle = getLeftBottomBorderStyle(wb);
		firstCellStyle.setFont(font);
		

		XSSFCellStyle lastCellStyle = getRightBottomBorderStyle(wb);
		lastCellStyle.setFont(font);

		XSSFRow landLoadDetail = sheet.createRow(index);
		

		XSSFCell cell1 = landLoadDetail.createCell(1);
		cell1.setCellValue("Total");
		cell1.setCellStyle(firstCellStyle);
		
		XSSFCell cell2 = landLoadDetail.createCell(2);
		cell2.setCellStyle(style);
		
		XSSFCell cell3 = landLoadDetail.createCell(3);
		cell3.setCellStyle(style);
		
		XSSFCell cell4 = landLoadDetail.createCell(4);
		cell4.setCellStyle(style);
		
		XSSFCell cell5 = landLoadDetail.createCell(5);
		cell5.setCellValue(String.valueOf(total));
		cell5.setCellStyle(style);
		
		XSSFCell cell6 = landLoadDetail.createCell(6);
		cell6.setCellStyle(style);
		
		XSSFCell cell7 = landLoadDetail.createCell(7);
		cell7.setCellStyle(style);
		
		XSSFCell cell8 = landLoadDetail.createCell(8);
		cell8.setCellStyle(style);
		
		XSSFCell cell9 = landLoadDetail.createCell(9);
		cell9.setCellStyle(lastCellStyle);
		

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
	private static int blankRow(XSSFSheet sheet, XSSFWorkbook wb, int index) {
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setBold(true);
		font.setFontName("Arial");
		
		XSSFRow cityRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);

		XSSFCell cell1 = cityRow.createCell(1);
		cell1.setCellStyle(style);

		XSSFCell cell9 = cityRow.createCell(9);
		cell9.setCellStyle(getRightBorderStyle(wb));

		// mergedRegion(index, index, 1, 6, sheet);

		index++;
		return index;
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
