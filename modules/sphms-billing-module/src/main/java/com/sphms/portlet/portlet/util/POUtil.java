package com.sphms.portlet.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.HordingBean;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;

public class POUtil {

	private static final Log _log = LogFactoryUtil.getLog(POUtil.class.getName());

	public static File createPOFile(Billing billing, List<Billing_PO> billingPOList, Booking booking,
			CustomCompany company) throws IOException {

		int index = 2;

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setBold(true);
		font.setFontName("Arial");

		List<Double> totalHordingAmointList = new ArrayList<Double>();
		String landLordName = StringPool.BLANK;
		String gsTNo = StringPool.BLANK;
		String city = StringPool.BLANK;
		LandLord landLord = getLandLord(billingPOList);
		if (Validator.isNotNull(landLord)) {
			landLordName = landLord.getFirstName() + StringPool.SPACE + landLord.getLastName();
			gsTNo = landLord.getGstNo();
			city = landLord.getCity();
		}

		index = createClientNameRow(sheet, wb, index);
		index = poNumberRow(sheet, wb, index, font, company, billingPOList.get(0));
		index = poDateRow(sheet, wb, index, font, landLordName, billingPOList.get(0));
		index = cityRow(sheet, wb, index, font, city, gsTNo);
		index = blankRow(sheet, wb, index, font);
		index = displayRow(sheet, wb, index, font, billing);
		index = periodRow(sheet, wb, index, font, booking);
		index = blankRow(sheet, wb, index, font);
		index = createHordingTableHeader(sheet, wb, index);

		for (Billing_PO billingPO : billingPOList) {
			Hording hording;
			try {
				hording = HordingLocalServiceUtil.getHording(billingPO.getHordingId());
				HordingBean hordingBean = new HordingBean(hording);
				index = createHordingDataRow(sheet, wb, index, 0, 1, hordingBean, booking, totalHordingAmointList,
						billing.getBillingId(), billingPO);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}

		double totalAmount = Math.round(getTotalAmount(totalHordingAmointList));
		double subTotalAmount = totalAmount;

		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);

		index = createSubTotalAmountRow(sheet, wb, index, font, subTotalAmount, booking);

		double iGSTCharge = 0d;
		double cGSTCharge = 0d;
		double sGSTCharge = 0d;
		boolean isClientOutOfGuj = isLandLordOutOfGujrat(landLord);
		if (isClientOutOfGuj) {
			iGSTCharge = totalAmount * Double.parseDouble(PropsUtil.get("igst.rate"));
			totalAmount = totalAmount + iGSTCharge;
		} else {
			// Total amount
			// Considering CGST as 9%
			cGSTCharge = totalAmount * Double.parseDouble(PropsUtil.get("cgst.rate"));
			// Consideting SGST as 9%
			sGSTCharge = totalAmount * Double.parseDouble(PropsUtil.get("sgst.rate"));

			totalAmount = totalAmount + cGSTCharge + sGSTCharge;

		}

		index = createServiceTaxRow(sheet, wb, index, font, cGSTCharge, sGSTCharge, iGSTCharge, isClientOutOfGuj);
		index = createTotalAmountRow(sheet, wb, index, font, totalAmount, booking);
		index = blankRow(sheet, wb, index, font);
		index = createRegNoRow(sheet, wb, index, font, company);
		index = blankRow(sheet, wb, index, font);
		index = OwneNameRow(sheet, wb, index, font, landLordName, company);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);
		index = signatureRow(sheet, wb, index, font);
		index = blankRow(sheet, wb, index, font);

		index = createTermsAndConditionsRow(sheet, wb, index, font);

		for (int i = 1; i <= 6; i++) {
			sheet.autoSizeColumn(i);
		}
		sheet.setColumnWidth(1, 10000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 2000);
		sheet.setColumnWidth(4, 2000);
		sheet.setColumnWidth(5, 3000);
		sheet.setColumnWidth(6, 2000);

		sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
		sheet.setFitToPage(true);

		// Write the output to a file
		String fileName = booking.getCampaignTitle() + StringPool.UNDERLINE + "PO" + ".xlsx";
		File file = new File(System.getProperty("catalina.home") + "/temp/" + fileName);

		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();

		return file;

	}

	private static int createClientNameRow(XSSFSheet sheet, XSSFWorkbook wb, int index) {
		XSSFRow taxInvoiceRow = sheet.createRow(index);
		XSSFCellStyle style = getAllBorderStyle(wb);
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 48);
		font.setBold(true);
		font.setFontName("Trebuchet MS");
		style.setFont(font);
		font.setColor(IndexedColors.ORANGE.getIndex());
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.OLIVE_GREEN.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell1 = taxInvoiceRow.createCell(1);
		cell1.setCellValue("Tulip Media Solutions");
		cell1.setCellStyle(style);

		XSSFCell cell2 = taxInvoiceRow.createCell(2);
		cell2.setCellStyle(style);

		XSSFCell cell3 = taxInvoiceRow.createCell(3);
		cell3.setCellStyle(style);

		XSSFCell cell4 = taxInvoiceRow.createCell(4);
		cell4.setCellStyle(style);

		XSSFCell cell5 = taxInvoiceRow.createCell(5);
		cell5.setCellStyle(style);

		XSSFCell cell6 = taxInvoiceRow.createCell(6);
		cell6.setCellStyle(style);

		XSSFCell cell7 = taxInvoiceRow.createCell(7);
		cell7.setCellStyle(style);

		XSSFCell cell8 = taxInvoiceRow.createCell(8);
		cell8.setCellStyle(style);

		XSSFCell cell9 = taxInvoiceRow.createCell(9);
		cell9.setCellStyle(style);

		mergedRegion(index, index, 1, 9, sheet);

		index++;

		return index;
	}

	private static int poNumberRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, CustomCompany company,
			Billing_PO billingPO) {
		XSSFRow poNumberRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftTopBorderStyle(wb);
		style.setFont(font);

		XSSFCellStyle style2 = getAllBorderStyle(wb);
		style2.setFont(font);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
		style2.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

		XSSFCellStyle style3 = getAllBorderStyle(wb);
		style3.setAlignment(HorizontalAlignment.CENTER);
		style3.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell1 = poNumberRow.createCell(1);
		cell1.setCellValue("To");
		cell1.setCellStyle(style);

		XSSFCell cell2 = poNumberRow.createCell(2);
		cell2.setCellStyle(getTopBorderStyle(wb));

		XSSFCell cell3 = poNumberRow.createCell(3);
		cell3.setCellStyle(getTopBorderStyle(wb));

		XSSFCell cell4 = poNumberRow.createCell(4);
		cell4.setCellStyle(getTopBorderStyle(wb));

		XSSFCell cell5 = poNumberRow.createCell(5);
		cell5.setCellValue("Order No :");
		cell5.setCellStyle(style2);

		XSSFCell cell6 = poNumberRow.createCell(6);
		cell6.setCellValue(billingPO.getInternalPONumber());
		cell6.setCellStyle(style3);

		XSSFCell cell7 = poNumberRow.createCell(7);
		cell7.setCellStyle(getAllBorderStyle(wb));

		XSSFCell cell8 = poNumberRow.createCell(8);
		cell8.setCellStyle(getAllBorderStyle(wb));

		XSSFCell cell9 = poNumberRow.createCell(9);
		cell9.setCellStyle(getAllBorderStyle(wb));

		mergedRegion(index, index, 1, 4, sheet);
		sheet.addMergedRegion(new CellRangeAddress(3, 4, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(3, 4, 6, 9));

		index++;
		return index;
	}

	private static int poDateRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, String landLordName,
			Billing_PO billingPO) {
		XSSFRow poNumberRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);

		XSSFCell cell1 = poNumberRow.createCell(1);
		cell1.setCellValue(landLordName);
		cell1.setCellStyle(style);

		XSSFCell cell2 = poNumberRow.createCell(5);
		cell2.setCellValue("Date : ");
		cell2.setCellStyle(getAllBorderStyle(wb));

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		XSSFCell cell3 = poNumberRow.createCell(6);
		if (Validator.isNotNull(billingPO.getPublishDate())) {
			cell3.setCellValue(df.format(billingPO.getPublishDate()));
		} else {
			cell3.setCellValue("");
		}

		mergedRegion(index, index, 1, 4, sheet);
		sheet.addMergedRegion(new CellRangeAddress(5, 6, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(5, 8, 6, 9));
		XSSFCell cell9 = poNumberRow.createCell(9);
		cell9.setCellStyle(getAllBorderStyle(wb));

		index++;
		return index;
	}

	private static int blankRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font) {
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

	private static int cityRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, String city, String gsTNo) {
		XSSFRow cityRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		
		XSSFFont font2 = wb.createFont();
		font2.setFontHeightInPoints((short) 11);
		font2.setBold(false);
		font2.setFontName("Arial");

		style.setFont(font2);
		
		XSSFCell cell1 = cityRow.createCell(1);
		cell1.setCellValue(city);
		cell1.setCellStyle(style);

		mergedRegion(index, index, 1, 4, sheet);

		XSSFCell cell9 = cityRow.createCell(9);
		cell9.setCellStyle(getRightBorderStyle(wb));

		index++;

		XSSFRow gstRow = sheet.createRow(index);

		XSSFCell gstCell1 = gstRow.createCell(1);
		gstCell1.setCellValue("GST No:" + gsTNo);
		gstCell1.setCellStyle(style);

		mergedRegion(index, index, 1, 4, sheet);

		XSSFCell gstCell9 = cityRow.createCell(9);
		gstCell9.setCellStyle(getRightBorderStyle(wb));

		index++;

		return index;
	}

	

	private static int displayRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, Billing billing) {
		XSSFRow displayRow = sheet.createRow(index);
		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

		XSSFCell cell1 = displayRow.createCell(1);
		cell1.setCellStyle(style);
		cell1.setCellValue("Display:");

		XSSFCell cell2 = displayRow.createCell(2);
		cell2.setCellStyle(getAllBorderStyle(wb));
		cell2.setCellValue(billing.getDisplay());

		XSSFCell cell9 = displayRow.createCell(9);
		cell9.setCellStyle(getRightBorderStyle(wb));

		index++;
		return index;
	}

	private static int periodRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, Booking booking) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		XSSFRow periodRow = sheet.createRow(index);
		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

		XSSFCell cell11 = periodRow.createCell(1);
		cell11.setCellStyle(style);
		cell11.setCellValue("Period :");

		XSSFCell cell21 = periodRow.createCell(2);
		cell21.setCellStyle(getAllBorderStyle(wb));
		cell21.setCellValue(df.format(booking.getStartDate()) + " to " + df.format(booking.getEndDate()));

		XSSFCell cell9 = periodRow.createCell(9);
		cell9.setCellStyle(getRightBorderStyle(wb));
		index++;
		return index;
	}

	private static int createHordingTableHeader(XSSFSheet sheet, XSSFWorkbook wb, int index) {
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
		cell12_2.setCellValue("Media");
		cell12_2.setCellStyle(style);

		XSSFCell cell12_3 = poTableRow.createCell(3);
		cell12_3.setCellValue("Location");
		cell12_3.setCellStyle(style);

		XSSFCell cell12_4 = poTableRow.createCell(4);
		cell12_4.setCellValue("Size(W)");
		cell12_4.setCellStyle(style);

		XSSFCell cell12_5 = poTableRow.createCell(5);
		cell12_5.setCellValue("Size(H)");
		cell12_5.setCellStyle(style);

		XSSFCell cell12_6 = poTableRow.createCell(6);
		cell12_6.setCellValue("Area");
		cell12_6.setCellStyle(style);

		XSSFCell cell12_7 = poTableRow.createCell(7);
		cell12_7.setCellValue("Start Date");
		cell12_7.setCellStyle(style);

		XSSFCell cell12_8 = poTableRow.createCell(8);
		cell12_8.setCellValue("End Date");
		cell12_8.setCellStyle(style);

		XSSFCell cell12_9 = poTableRow.createCell(9);
		cell12_9.setCellValue("Amount");
		cell12_9.setCellStyle(style);

		index++;
		return index;
	}

	private static int createHordingDataRow(XSSFSheet sheet, XSSFWorkbook wb, int index, int loopIndex, int totalList,
			HordingBean hordingBean, Booking booking, List<Double> totalHordingAmointList, long billingId,
			Billing_PO billingPO) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String startDate = df.format(booking.getStartDate());
		String endDate = df.format(booking.getEndDate());

		String size = hordingBean.getSize();
		float size_W = 0;
		float size_H = 0;

		if (Validator.isNotNull(size)) {
			String[] sizearry = size.split("X");
			size_W = Float.valueOf(sizearry[0]);
			size_H = Float.valueOf(sizearry[1]);
		}
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Arial");

		XSSFRow hordingTableRow = sheet.createRow(index);
		XSSFCellStyle style = getRowStyle(hordingTableRow, wb);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFont(font);

		XSSFCellStyle leftBottomStyle = getLeftBottomBorderStyle(wb);
		leftBottomStyle.setFont(font);
		XSSFCellStyle leftStyle = getLeftBorderStyle(wb);
		leftStyle.setFont(font);
		XSSFCellStyle bottomStyle = getBottomBorderStyle(wb);
		bottomStyle.setFont(font);
		XSSFCellStyle rightBottomStyle = getRightBottomBorderStyle(wb);
		rightBottomStyle.setFont(font);
		XSSFCellStyle rightStyle = getRightBorderStyle(wb);
		rightStyle.setFont(font);

		XSSFCell cell1 = hordingTableRow.createCell(1);
		cell1.setCellValue(hordingBean.getCity());
		if (loopIndex == (totalList - 1)) {
			cell1.setCellStyle(leftBottomStyle);
		} else {
			cell1.setCellStyle(leftStyle);
		}
		XSSFCell cell2 = hordingTableRow.createCell(2);
		cell2.setCellValue(hordingBean.getMediaVehicle());
		if (loopIndex == (totalList - 1)) {
			cell2.setCellStyle(bottomStyle);
		}

		XSSFCell cell3 = hordingTableRow.createCell(3);
		cell3.setCellValue(hordingBean.getLocation());
		if (loopIndex == (totalList - 1)) {
			cell3.setCellStyle(bottomStyle);
		}

		XSSFCell cell4 = hordingTableRow.createCell(4);
		cell4.setCellValue(size_W);
		if (loopIndex == (totalList - 1)) {
			cell4.setCellStyle(bottomStyle);
		}

		XSSFCell cell5 = hordingTableRow.createCell(5);
		cell5.setCellValue(size_H);
		if (loopIndex == (totalList - 1)) {
			cell5.setCellStyle(bottomStyle);
		}

		XSSFCell cell6 = hordingTableRow.createCell(6);
		cell6.setCellValue(size_W * size_H);
		if (loopIndex == (totalList - 1)) {
			cell6.setCellStyle(bottomStyle);
		}

		XSSFCell cell7 = hordingTableRow.createCell(7);
		cell7.setCellValue(startDate);
		if (loopIndex == (totalList - 1)) {
			cell7.setCellStyle(bottomStyle);
		}

		XSSFCell cell8 = hordingTableRow.createCell(8);
		cell8.setCellValue(endDate);
		if (loopIndex == (totalList - 1)) {
			cell8.setCellStyle(bottomStyle);
		}

		XSSFCell cell9 = hordingTableRow.createCell(9);
		cell9.setCellValue(billingPO.getTotalAmount());
		if (loopIndex == (totalList - 1)) {
			cell9.setCellStyle(rightBottomStyle);
		} else {
			cell9.setCellStyle(rightStyle);
		}

		totalHordingAmointList.add(Double.valueOf(Math.round(billingPO.getTotalAmount())));

		index++;
		return index;

	}

	private static int createSubTotalAmountRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font,
			double subTotalAmount, Booking booking) {

		XSSFRow totalSubAmountRow = sheet.createRow(index);

		XSSFCell cell1 = totalSubAmountRow.createCell(1);
		cell1.setCellStyle(getLeftBorderStyle(wb));
		cell1.setCellValue("Sub Total");

		mergedRegion(index, index, 1, 8, sheet);

		XSSFCell cell9 = totalSubAmountRow.createCell(9);
		cell9.setCellValue(Math.round(subTotalAmount));
		cell9.setCellStyle(getRightBorderStyle(wb));

		index++;
		return index;

	}

	private static int createServiceTaxRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, double cGST,
			double sGST, double iGST, boolean isClientOutOfGuj) {

		if (!isClientOutOfGuj) {

			XSSFRow cGSTROW = sheet.createRow(index);

			XSSFCell cell1 = cGSTROW.createCell(1);
			cell1.setCellStyle(getLeftBorderStyle(wb));
			cell1.setCellValue("CGST @ " + Double.parseDouble(PropsUtil.get("cgst.rate")) * 100 + "%");

			mergedRegion(index, index, 1, 8, sheet);

			XSSFCell cell9 = cGSTROW.createCell(9);
			cell9.setCellValue(Math.round(cGST));
			cell9.setCellStyle(getRightBorderStyle(wb));

			index++;

			XSSFRow sGSTROW = sheet.createRow(index);

			XSSFCell cell11 = sGSTROW.createCell(1);
			cell11.setCellStyle(getLeftBorderStyle(wb));
			cell11.setCellValue("SGST @ " + Double.parseDouble(PropsUtil.get("sgst.rate")) * 100 + "%");

			mergedRegion(index, index, 1, 8, sheet);

			XSSFCell cell61 = sGSTROW.createCell(9);
			cell61.setCellValue(Math.round(sGST));
			cell61.setCellStyle(getRightBorderStyle(wb));

			index++;

		} else {

			XSSFRow iGSTROW = sheet.createRow(index);

			XSSFCell cell1 = iGSTROW.createCell(1);
			cell1.setCellStyle(getLeftBorderStyle(wb));
			cell1.setCellValue("IGST @ " + Double.parseDouble(PropsUtil.get("igst.rate")) * 100 + "%");

			mergedRegion(index, index, 1, 8, sheet);

			XSSFCell cell9 = iGSTROW.createCell(9);
			cell9.setCellValue(Math.round(iGST));
			cell9.setCellStyle(getRightBorderStyle(wb));

			index++;

		}
		return index;
	}

	private static int createTotalAmountRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font,
			double totalAmount, Booking booking) {

		XSSFRow regNoRow = sheet.createRow(index);

		XSSFCell cell11 = regNoRow.createCell(1);
		cell11.setCellStyle(getLeftBottomBorderStyle(wb));
		XSSFCell cell21 = regNoRow.createCell(2);
		cell21.setCellStyle(getBottomBorderStyle(wb));
		XSSFCell cell31 = regNoRow.createCell(3);
		cell31.setCellStyle(getBottomBorderStyle(wb));
		XSSFCell cell41 = regNoRow.createCell(4);
		cell41.setCellStyle(getBottomBorderStyle(wb));
		XSSFCell cell51 = regNoRow.createCell(5);
		cell51.setCellStyle(getBottomBorderStyle(wb));
		XSSFCell cell61 = regNoRow.createCell(6);
		cell61.setCellStyle(getBottomBorderStyle(wb));
		XSSFCell cell71 = regNoRow.createCell(7);
		cell71.setCellStyle(getBottomBorderStyle(wb));
		XSSFCell cell81 = regNoRow.createCell(8);
		cell81.setCellStyle(getBottomBorderStyle(wb));
		XSSFCell cell91 = regNoRow.createCell(9);
		cell91.setCellStyle(getRightBottomBorderStyle(wb));

		index++;

		// Ruppes in words
		XSSFRow totalAmountRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBottomBorderStyle(wb);
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		XSSFCell cell1 = totalAmountRow.createCell(1);
		cell1.setCellValue("Rupees :" + NumberToWord.convertNumberToWords(totalAmount) + " Only");
		cell1.setCellStyle(style);

		XSSFCell cell2 = totalAmountRow.createCell(2);
		cell2.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell3 = totalAmountRow.createCell(3);
		cell3.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell4 = totalAmountRow.createCell(4);
		cell4.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell5 = totalAmountRow.createCell(5);
		cell5.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell6 = totalAmountRow.createCell(6);
		cell6.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell7 = totalAmountRow.createCell(7);
		cell7.setCellStyle(getBottomBorderStyle(wb));

		mergedRegion(index, index, 1, 7, sheet);

		XSSFCellStyle style2 = getAllBorderStyle(wb);
		style2.setFont(font);
		style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

		XSSFCell cell8 = totalAmountRow.createCell(8);
		cell8.setCellValue("Grand Total");
		cell8.setCellStyle(style2);

		XSSFCell cell9 = totalAmountRow.createCell(9);
		cell9.setCellValue(Math.round(totalAmount));
		cell9.setCellStyle(style2);

		index++;
		return index;

	}

	private static int createRegNoRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font,
			CustomCompany company) {
		XSSFRow regNoRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		
		XSSFFont font2 = wb.createFont();
		font2.setFontHeightInPoints((short) 11);
		font2.setBold(false);
		font2.setFontName("Arial");

		style.setFont(font2);

		XSSFCell cell1 = regNoRow.createCell(1);
		cell1.setCellValue("GST No: " + company.getGSTNo());
		cell1.setCellStyle(style);

		XSSFCell cell9 = regNoRow.createCell(9);
		cell9.setCellStyle(getRightBorderStyle(wb));

		mergedRegion(index, index, 1, 4, sheet);
		index++;

		XSSFRow serviceTaxRow = sheet.createRow(index);
		

		XSSFCell cell11 = serviceTaxRow.createCell(1);
		cell11.setCellValue("PAN No :" + company.getPANNo());
		cell11.setCellStyle(style);

		XSSFCell cell61 = serviceTaxRow.createCell(9);
		cell61.setCellStyle(getRightBorderStyle(wb));

		mergedRegion(index, index, 1, 4, sheet);
		index++;

		return index;
	}

	private static int createTermsAndConditionsRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font) {
		XSSFRow termsAndConditionsRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);

		XSSFCell cell1 = termsAndConditionsRow.createCell(1);
		cell1.setCellValue("Genral Terms:");
		cell1.setCellStyle(style);

		XSSFCell cell9 = termsAndConditionsRow.createCell(9);
		cell9.setCellStyle(getRightBorderStyle(wb));

		mergedRegion(index, index, 1, 9, sheet);
		index++;

		XSSFRow condition1Row = sheet.createRow(index);

		XSSFCell cell11 = condition1Row.createCell(1);
		cell11.setCellValue("1. Invoice to be in favour of  only.");
		cell11.setCellStyle(getLeftBorderStyle(wb));

		XSSFCell cell61 = condition1Row.createCell(9);
		cell61.setCellStyle(getRightBorderStyle(wb));

		mergedRegion(index, index, 1, 9, sheet);
		index++;

		XSSFRow condition2Row = sheet.createRow(index);

		XSSFCell cell12 = condition2Row.createCell(1);
		cell12.setCellValue("2. Kindly attached Start Dated and End Dated Photos along with Invoice");
		cell12.setCellStyle(getLeftBorderStyle(wb));

		XSSFCell cell92 = condition2Row.createCell(9);
		cell92.setCellStyle(getRightBorderStyle(wb));

		mergedRegion(index, index, 1, 9, sheet);
		index++;

		XSSFRow condition3Row = sheet.createRow(index);

		XSSFCell cell13 = condition3Row.createCell(1);
		cell13.setCellValue("3. Subject to Ahmedabad Jurisdiction.");
		cell13.setCellStyle(getLeftBorderStyle(wb));

		XSSFCell cell93 = condition3Row.createCell(9);
		cell93.setCellStyle(getRightBorderStyle(wb));

		mergedRegion(index, index, 1, 9, sheet);
		index++;

		XSSFRow condition4Row = sheet.createRow(index);

		XSSFCell cell14 = condition4Row.createCell(1);
		cell14.setCellValue("4. Kindly share the monthly invoice");
		cell14.setCellStyle(getLeftBorderStyle(wb));

		XSSFCell cell94 = condition4Row.createCell(9);
		cell94.setCellStyle(getRightBorderStyle(wb));

		mergedRegion(index, index, 1, 9, sheet);
		index++;

		XSSFRow lastRow = sheet.createRow(index);

		XSSFCell cell111 = lastRow.createCell(1);
		cell111.setCellStyle(getLeftBottomBorderStyle(wb));

		XSSFCell cell122 = lastRow.createCell(2);
		cell122.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell133 = lastRow.createCell(3);
		cell133.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell144 = lastRow.createCell(4);
		cell144.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell155 = lastRow.createCell(5);
		cell155.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell156 = lastRow.createCell(6);
		cell156.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell157 = lastRow.createCell(7);
		cell157.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell158 = lastRow.createCell(8);
		cell158.setCellStyle(getBottomBorderStyle(wb));

		XSSFCell cell19 = lastRow.createCell(9);
		cell19.setCellStyle(getRightBottomBorderStyle(wb));

		index++;

		return index;

	}

	private static int OwneNameRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, String landLordName,
			CustomCompany company) {

		font.setBold(true);
		XSSFRow acceptanceRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		XSSFCellStyle style2 = wb.createCellStyle();
		
		XSSFFont font2 = wb.createFont();
		font2.setFontHeightInPoints((short) 11);
		font2.setBold(true);
		font2.setFontName("Arial");

		style2.setFont(font2);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setVerticalAlignment(VerticalAlignment.CENTER);

		XSSFCell cell11 = acceptanceRow.createCell(1);
		cell11.setCellStyle(style);

		XSSFCell cell16 = acceptanceRow.createCell(2);
		cell16.setCellValue("For " + company.getName());
		cell16.setCellStyle(style2);

		XSSFCell cell15 = acceptanceRow.createCell(5);
		cell15.setCellValue("I hereby agree that I have noted all contents herewith and Agree to execute the job.");
		cell15.setCellStyle(style2);
		CellStyle newStyle = wb.createCellStyle();

		cell15.setCellStyle(newStyle);

		XSSFCell cell99 = acceptanceRow.createCell(9);
		cell99.setCellStyle(getRightBorderStyle(wb));

		index++;
		return index;
	}

	private static int signatureRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font) {
		XSSFRow singatureRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);

		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font);

		XSSFCell cell1 = singatureRow.createCell(1);
		cell1.setCellStyle(style);

		XSSFCell cell2 = singatureRow.createCell(2);
		cell2.setCellValue("Authorised Signatory");
		cell2.setCellStyle(style2);

		XSSFCell cell5 = singatureRow.createCell(5);
		cell5.setCellValue("Authorised Signatory");
		cell5.setCellStyle(style2);

		XSSFCell cell9 = singatureRow.createCell(9);
		cell9.setCellStyle(getRightBorderStyle(wb));

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

	private static XSSFCellStyle getLeftTopBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		return style;
	}

	private static XSSFCellStyle getRightTopBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		return style;
	}

	private static XSSFCellStyle getTopBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM);
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

	private static XSSFCellStyle getLeftRightBottomBorderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderRight(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		style.setBorderBottom(BorderStyle.MEDIUM);
		return style;
	}

	private static void mergedRegion(int rowStart, int rowEnd, int columnStart, int columnEnd, XSSFSheet sheet) {
		CellRangeAddress cellRnage = new CellRangeAddress(rowStart, rowEnd, columnStart, columnEnd);
		sheet.addMergedRegion(cellRnage);
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

	private static LandLord getLandLord(List<Billing_PO> billingPOList) {
		LandLord landLord = null;
		if (billingPOList.size() > 0) {
			try {
				landLord = LandLordLocalServiceUtil.getLandLord(billingPOList.get(0).getLandLordId());
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}

		}
		return landLord;
	}

	private static double getTotalAmount(List<Double> totalHordingAmointList) {
		double totalAmount = 0d;
		for (Double totalHordingAmount : totalHordingAmointList) {
			totalAmount += totalHordingAmount;
		}
		return totalAmount;
	}

	private static Client getClient(long clientId) {
		Client client = null;
		try {
			client = ClientLocalServiceUtil.getClient(clientId);
		} catch (PortalException e) {
			_log.error(e);
		}
		return client;
	}

	private static boolean isLandLordOutOfGujrat(LandLord landLord) {
		if (Validator.isNotNull(landLord) && Validator.isNotNull(landLord.getStatec())
				&& !landLord.getStatec().toLowerCase().equalsIgnoreCase("gujarat")) {
			return true;
		}
		return false;
	}
}
