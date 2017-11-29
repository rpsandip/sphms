package com.sphms.portlet.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
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
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;

public class POUtil {

	private static final Log _log = LogFactoryUtil.getLog(POUtil.class.getName());
	
	public static File createPOFile(Billing billing, List<Billing_PO> billingPOList, Booking booking, CustomCompany company) throws IOException{
		
		int index=1;
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();
		
		XSSFFont font = wb.createFont();
	    font.setFontHeightInPoints((short) 11);
	    font.setBold(true);
	    font.setFontName("Arial");
	    
	    List<Double> totalHordingAmointList = new ArrayList<Double>();
	    String landLordName = StringPool.BLANK;
	    String city = StringPool.BLANK;
	    LandLord landLord = getLandLord(billingPOList);
	    if(Validator.isNotNull(landLord)){
	    	landLordName = landLord.getFirstName()+StringPool.SPACE+landLord.getLastName();
	    	city = landLord.getCity();
	    }
	    
	    index = createMainHeaderRow(sheet, wb, index);
	    index = poNumberRow(sheet, wb, index, font, billingPOList.get(0), company);
	    index = poDateRow(sheet, wb, index, font, landLordName);
	    index = cityRow(sheet, wb, index, font, city);
	    index = blankRow(sheet, wb, index, font);
	    index = topBlankRow(sheet, wb, index, font);
	    index = displayRow(sheet, wb, index, font,billing);
	    index = periodRow(sheet, wb, index, font, booking);
	    index = blankRow(sheet, wb, index, font);
	    index = createHordingTableHeader(sheet, wb, index);
	    
	    for(Billing_PO billingPO : billingPOList){
	    	Hording hording;
			try {
				hording = HordingLocalServiceUtil.getHording(billingPO.getHordingId());
				HordingBean hordingBean = new HordingBean(hording);
		    	index =  createHordingDataRow(sheet, wb, index, 0,1, hordingBean, booking, totalHordingAmointList);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
	    }
	     double totalAmount = getTotalAmount(totalHordingAmointList);
	     
	     index = createTotalAmountRow(sheet, wb, index, font, totalAmount, booking);
	     index = topBlankRow(sheet, wb, index, font);
	     index = createRegNoRow(sheet, wb, index, font, company);
	     index = blankRow(sheet, wb, index, font);
	     index = createTermsAndConditionsRow(sheet, wb, index, font);
	     index = blankRow(sheet, wb, index, font);
	     index = OwneNameRow(sheet, wb, index, font, landLordName,company);
	     index = blankRow(sheet, wb, index, font);
	     index = blankRow(sheet, wb, index, font);
	     index = blankRow(sheet, wb, index, font);
	     index = signatureRow(sheet, wb, index, font);
	     
	    for(int i=1;i<=6;i++){
			sheet.autoSizeColumn(i);
		}
	    
	    
	 // Write the output to a file
 		String fileName = booking.getCampaignTitle()+ StringPool.UNDERLINE+ "PO" +".xlsx";
 		File file = new File(System.getProperty("catalina.home")+"/temp/"+fileName);
 		
 		FileOutputStream fileOut = new FileOutputStream(file);
 		wb.write(fileOut);
 		fileOut.close();
 		
 		return file;
		
	}
	
	
	private static int createMainHeaderRow(XSSFSheet sheet, XSSFWorkbook wb, int index){
		XSSFRow taxInvoiceRow = sheet.createRow(index);	
		taxInvoiceRow.setHeight((short)500);
		XSSFCellStyle style = getAllBorderStyle(wb);
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 14);
	    font.setBold(true);
	    font.setFontName("Arial");
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		
		XSSFCell cell1=  taxInvoiceRow.createCell(1);
		cell1.setCellValue("PURCHASE ORDER");
		cell1.setCellStyle(style);
		
		XSSFCell cell2=  taxInvoiceRow.createCell(2);
		cell2.setCellStyle(style);
		
		XSSFCell cell3=  taxInvoiceRow.createCell(3);
		cell3.setCellStyle(style);
		
		XSSFCell cell4=  taxInvoiceRow.createCell(4);
		cell4.setCellStyle(style);
		
		XSSFCell cell5=  taxInvoiceRow.createCell(5);
		cell5.setCellStyle(style);
		
		XSSFCell cell6=  taxInvoiceRow.createCell(6);
		cell6.setCellStyle(style);
		
		mergedRegion(index, index, 1, 6, sheet);
		
		index++;
		
		return index;
	}
	
	private static int poNumberRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, Billing_PO billingPO, CustomCompany company){
		XSSFRow poNumberRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftTopBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell1 = poNumberRow.createCell(1);
		cell1.setCellValue("M/S");
		cell1.setCellStyle(style);
		
		XSSFCell cell2 = poNumberRow.createCell(2);
		cell2.setCellStyle(getTopBorderStyle(wb));
		
		XSSFCell cell3 = poNumberRow.createCell(3);
		cell3.setCellStyle(getTopBorderStyle(wb));
		
		XSSFCell cell4 = poNumberRow.createCell(4);
		XSSFCellStyle style2 = getTopBorderStyle(wb);
		style2.setFont(font);
		cell4.setCellStyle(style2);
		cell4.setCellValue("P.O. No : ");
		
		XSSFCell cell5 = poNumberRow.createCell(5);
		cell5.setCellValue(Billing_POLocalServiceUtil.getPONumber(billingPO,company));
		cell5.setCellStyle(getTopBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		
		XSSFCell cell6 = poNumberRow.createCell(6);
		cell6.setCellStyle(getRightTopBorderStyle(wb));
		
		index++;
		return index;
	}
	
	private static int poDateRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, String landLordName){
		XSSFRow poNumberRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell1 = poNumberRow.createCell(1);
		cell1.setCellValue(landLordName);
		cell1.setCellStyle(style);
		
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font);
		XSSFCell cell4 = poNumberRow.createCell(4);
		cell4.setCellValue("P.O. Date : ");
		cell4.setCellStyle(style2);
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		XSSFCell cell5 = poNumberRow.createCell(5);
		cell5.setCellValue(df.format(new Date()));
		
		mergedRegion(index, index, 1, 3, sheet);
		
		XSSFCell cell6 = poNumberRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));
		
		index++;
		return index;
	}
	
	private static int blankRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font){
		XSSFRow cityRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell1 = cityRow.createCell(1);
		cell1.setCellStyle(style);
	
		XSSFCell cell6 = cityRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));
		
		//mergedRegion(index, index, 1, 6, sheet);
		
		index++;
		return index;
	}
	
	private static int cityRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, String city){
		XSSFRow cityRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell1 = cityRow.createCell(1);
		cell1.setCellValue(city);
		cell1.setCellStyle(style);
		
		mergedRegion(index, index, 1, 3, sheet);
	
		XSSFCell cell6 = cityRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));
		
		index++;
		return index;
	}

	private static int topBlankRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font){
		XSSFRow cityRow = sheet.createRow(index);	

		XSSFCell cell1 = cityRow.createCell(1);
		cell1.setCellStyle(getLeftTopBorderStyle(wb));
		XSSFCell cell2 = cityRow.createCell(2);
		cell2.setCellStyle(getTopBorderStyle(wb));
		XSSFCell cell3 = cityRow.createCell(3);
		cell3.setCellStyle(getTopBorderStyle(wb));
		XSSFCell cell4 = cityRow.createCell(4);
		cell4.setCellStyle(getTopBorderStyle(wb));
		XSSFCell cell5 = cityRow.createCell(5);
		cell5.setCellStyle(getTopBorderStyle(wb));
		XSSFCell cell6 = cityRow.createCell(6);
		cell6.setCellStyle(getRightTopBorderStyle(wb));
		
		index++;
		return index;
	}
	
	private static int displayRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font,Billing billing){
		XSSFRow displayRow = sheet.createRow(index);	
		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFont(font);
		XSSFCell cell1 = displayRow.createCell(1);
		cell1.setCellStyle(style);
		cell1.setCellValue("Display:");
		
		XSSFCell cell2 = displayRow.createCell(2);
		cell2.setCellStyle(getAllBorderStyle(wb));
		cell2.setCellValue(billing.getDisplay());
		
		XSSFCell cell6 = displayRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));
		
		index++;
		return index;
	}
	
	private static int periodRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, Booking booking){

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		XSSFRow periodRow = sheet.createRow(index);	
		XSSFCellStyle style = getAllBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell11 = periodRow.createCell(1);
		cell11.setCellStyle(style);
		cell11.setCellValue("Period :");
		
		XSSFCell cell21 = periodRow.createCell(2);
		cell21.setCellStyle(getAllBorderStyle(wb));
		cell21.setCellValue(df.format(booking.getStartDate()) + " to "+ df.format(booking.getEndDate()));
		
		XSSFCell cell61 = periodRow.createCell(6);
		cell61.setCellStyle(getRightBorderStyle(wb));
		index++;
		return index;
	}
	
	private static int createHordingTableHeader(XSSFSheet sheet, XSSFWorkbook wb, int index){
		XSSFRow poTableRow = sheet.createRow(index);
		poTableRow.setHeight((short)500);
		XSSFCellStyle style = getAllBorderStyle(wb);
		XSSFFont font = wb.createFont();
	    font.setFontHeightInPoints((short) 14);
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
		cell12_2.setCellValue("Location/Client");
		cell12_2.setCellStyle(style);
		
		
		XSSFCell cell12_3 = poTableRow.createCell(3);
		cell12_3.setCellValue("Size");
		cell12_3.setCellStyle(style);
		
		XSSFCell cell12_4 = poTableRow.createCell(4);
		cell12_4.setCellValue("Rate Per Month");
		cell12_4.setCellStyle(style);
		
		XSSFCell cell12_5 = poTableRow.createCell(5);
		cell12_5.setCellValue("Period");
		cell12_5.setCellStyle(style);
		
		XSSFCell cell12_6 = poTableRow.createCell(6);
		cell12_6.setCellValue("Amount");
		cell12_6.setCellStyle(style);
		index++;
		return index;
	}
	
	private static int createHordingDataRow(XSSFSheet sheet, XSSFWorkbook wb, int index, int loopIndex,int totalList, HordingBean hordingBean, Booking booking, List<Double> totalHordingAmointList){
		
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
		if(loopIndex==(totalList-1)){
			cell1.setCellStyle(leftBottomStyle);
		}else{
			cell1.setCellStyle(leftStyle);
		}
		
		XSSFCell cell2 = hordingTableRow.createCell(2);
		cell2.setCellValue(hordingBean.getLocation());
		if(loopIndex==(totalList-1)){
			cell2.setCellStyle(bottomStyle);
		}
		
		XSSFCell cell3 = hordingTableRow.createCell(3);
		cell3.setCellValue(hordingBean.getSize());
		if(loopIndex==(totalList-1)){
			cell3.setCellStyle(bottomStyle);
		}
		
		XSSFCell cell4 = hordingTableRow.createCell(4);
		cell4.setCellValue(hordingBean.getPricePerMonth());
		if(loopIndex==(totalList-1)){
			cell4.setCellStyle(bottomStyle);
		}
		
		XSSFCell cell5 = hordingTableRow.createCell(5);
		cell5.setCellValue(SPHMSCommonLocalServiceUtil.getDateTimeDiff(booking.getStartDate(), booking.getEndDate()));
		if(loopIndex==(totalList-1)){
			cell5.setCellStyle(bottomStyle);
		}
		
		XSSFCell cell6 = hordingTableRow.createCell(6);
		cell6.setCellValue(SPHMSCommonLocalServiceUtil.getDisplayCharges(hordingBean.getPricePerMonth(), SPHMSCommonLocalServiceUtil.getDisplayDuration(booking.getStartDate(), booking.getEndDate())));
		if(loopIndex==(totalList-1)){
			cell6.setCellStyle(rightBottomStyle);
		}else{
			cell6.setCellStyle(rightStyle);
		}
		
		totalHordingAmointList.add(SPHMSCommonLocalServiceUtil.getDisplayCharges(hordingBean.getPricePerMonth(), SPHMSCommonLocalServiceUtil.getDisplayDuration(booking.getStartDate(), booking.getEndDate())));
		
		index++;
		return index;
		
	}
	
private static int createTotalAmountRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, double totalAmount, Booking booking){
		
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
		cell61.setCellStyle(getRightBottomBorderStyle(wb));
		
		index++;
		
		// Ruppes in words
		XSSFRow totalAmountRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBottomBorderStyle(wb);
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		XSSFCell cell1 = totalAmountRow.createCell(1);
		cell1.setCellValue("Rupees :" + NumberToWord.convertNumberToWords(totalAmount));
		cell1.setCellStyle(style);
		
		XSSFCell cell2 = totalAmountRow.createCell(2);
		cell2.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell3 = totalAmountRow.createCell(3);
		cell3.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell4 = totalAmountRow.createCell(4);
		cell4.setCellStyle(getBottomBorderStyle(wb));
		
		mergedRegion(index, index, 1, 4, sheet);
		
		XSSFCellStyle style2 = getAllBorderStyle(wb);
		style2.setFont(font);
		style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		
		XSSFCell cell5 = totalAmountRow.createCell(5);
		cell5.setCellValue("Total");
		cell5.setCellStyle(style2);
		
		
		XSSFCell cell6 = totalAmountRow.createCell(6);
		cell6.setCellValue(totalAmount);
		cell6.setCellStyle(style2);
		
		index++;
		return index;
		
		
	}

	private static int createRegNoRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, CustomCompany company){
		XSSFRow regNoRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell1 = regNoRow.createCell(1);
		cell1.setCellValue("GST No: " + company.getGSTNo());
		cell1.setCellStyle(style);
		
		XSSFCell cell6 = regNoRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;
		

		XSSFRow serviceTaxRow = sheet.createRow(index);	
		style.setFont(font);
		
		XSSFCell cell11 = serviceTaxRow.createCell(1);
		cell11.setCellValue("PAN No :" + company.getPANNo());
		cell11.setCellStyle(style);
		
		XSSFCell cell61 = serviceTaxRow.createCell(6);
		cell61.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;
		
		XSSFRow panRow = sheet.createRow(index);	
		style.setFont(font);
		
		XSSFCell cell12 = panRow.createCell(1);
		cell12.setCellValue("PAN No : " + company.getPANNo());
		cell12.setCellStyle(style);
		
		XSSFCell cell62 = panRow.createCell(6);
		cell62.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;
		return index;
	}
	
	private static int createTermsAndConditionsRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font){
		XSSFRow termsAndConditionsRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell1 = termsAndConditionsRow.createCell(1);
		cell1.setCellValue("Terms & Conditions");
		cell1.setCellStyle(style);
		
		XSSFCell cell6 = termsAndConditionsRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;

		
		XSSFRow condition1Row = sheet.createRow(index);	
		
		XSSFCell cell11 = condition1Row.createCell(1);
		cell11.setCellValue("1.Rates Mention in this Purchase Order are net Rates. ");
		cell11.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCell cell61 = condition1Row.createCell(6);
		cell61.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;
		
		XSSFRow condition2Row = sheet.createRow(index);	
		
		XSSFCell cell12 = condition2Row.createCell(1);
		cell12.setCellValue("2.Govt.Service Tax will be extra as per applicable.");
		cell12.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCell cell62 = condition2Row.createCell(6);
		cell62.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;

		
		XSSFRow condition3Row = sheet.createRow(index);	
		
		XSSFCell cell13 = condition3Row.createCell(1);
		cell13.setCellValue("3. Please Mention Your Service Tax No & This Purchase Order No on your Bill");
		cell13.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCell cell63 = condition3Row.createCell(6);
		cell63.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;
		
		XSSFRow condition4Row = sheet.createRow(index);	
		
		XSSFCell cell14 = condition4Row.createCell(1);
		cell14.setCellValue("4.A copy of this Purchase Order with stamp & sign should be attached with your Bill");
		cell14.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCell cell64 = condition4Row.createCell(6);
		cell64.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;

		XSSFRow blankRow = sheet.createRow(index);	
		
		XSSFCell cell15 = blankRow.createCell(1);
		cell15.setCellStyle(getLeftBorderStyle(wb));
	
		XSSFCell cell65 = blankRow.createCell(6);
		cell65.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 6, sheet);
		index++;
		
		XSSFRow acceptanceRow = sheet.createRow(index);	
		
		XSSFCell cell16 = acceptanceRow.createCell(1);
		cell16.setCellValue("We Accept above jobs and agree to execute as per the spacifications");
		cell16.setCellStyle(style);
		
		XSSFCell cell66 = acceptanceRow.createCell(6);
		cell66.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 1, 3, sheet);
		index++;
		
		return index;
		
	}

	private static int OwneNameRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, String landLordName, CustomCompany company){
		XSSFRow acceptanceRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell16 = acceptanceRow.createCell(1);
		cell16.setCellValue("For " + company.getName());
		cell16.setCellStyle(style);
		
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font);
		XSSFCell cell14 = acceptanceRow.createCell(4);
		cell14.setCellValue("For "+ landLordName);
		cell14.setCellStyle(style2);
		
		XSSFCell cell66 = acceptanceRow.createCell(6);
		cell66.setCellStyle(getRightBorderStyle(wb));
		
		index++;
		return index;
	}
	
	private static int signatureRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font){
		XSSFRow singatureRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell1 = singatureRow.createCell(1);
		cell1.setCellValue("Authorised Signatory");
		cell1.setCellStyle(style);
		
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font);
		XSSFCell cell4 = singatureRow.createCell(4);
		cell4.setCellValue("Authorised Signatory");
		cell4.setCellStyle(style2);
		
		XSSFCell cell6 = singatureRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));
		
		index++;
		
		XSSFRow lastRow = sheet.createRow(index);	

		XSSFCell cell11 = lastRow.createCell(1);
		cell11.setCellStyle(getLeftBottomBorderStyle(wb));
		
		XSSFCell cell12 = lastRow.createCell(2);
		cell12.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell13 = lastRow.createCell(3);
		cell13.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell14 = lastRow.createCell(4);
		cell14.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell15 = lastRow.createCell(5);
		cell15.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell16 = lastRow.createCell(6);
		cell16.setCellStyle(getRightBottomBorderStyle(wb));
		
		index++;
		
		return index;
	}
	
	
	private static  XSSFCellStyle getAllBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM);
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  XSSFCellStyle getLeftTopBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  XSSFCellStyle getRightTopBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  XSSFCellStyle getTopBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderTop(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  XSSFCellStyle getBottomBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  XSSFCellStyle getLeftBottomBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  XSSFCellStyle getRightBottomBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  XSSFCellStyle getLeftBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderLeft(BorderStyle.MEDIUM);
		return style;
	}

	private static  XSSFCellStyle getRightBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderRight(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  XSSFCellStyle getLeftRightBottomBorderStyle(XSSFWorkbook workbook){
		XSSFCellStyle style = workbook.createCellStyle();
		style.setBorderRight(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		style.setBorderBottom(BorderStyle.MEDIUM);
		return style;
	}
	
	private static  void mergedRegion(int rowStart, int rowEnd, int columnStart, int columnEnd, XSSFSheet sheet){
		CellRangeAddress cellRnage = new CellRangeAddress(rowStart, rowEnd, columnStart, columnEnd);
		sheet.addMergedRegion(cellRnage);
	}
	
	private  static XSSFCellStyle getRowStyle(XSSFRow row, XSSFWorkbook wb){
		
		 //Create a new font and alter it.
	     XSSFFont font = wb.createFont();
	     font.setFontHeightInPoints((short) 12);
	     font.setBold(true);
	     font.setFontName("Arial");
	     
	     //Set font into style
	     XSSFCellStyle style = wb.createCellStyle();
	     style.setFont(font);
	    return style;
	}
	
	private static LandLord getLandLord(List<Billing_PO> billingPOList){
		LandLord landLord = null;
		if(billingPOList.size()>0){
			try {
				landLord = LandLordLocalServiceUtil.getLandLord(billingPOList.get(0).getLandLordId());
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
			
		}
		return landLord;
	}
	
	private static double getTotalAmount(List<Double> totalHordingAmointList){
		double totalAmount=0d;
		for(Double totalHordingAmount : totalHordingAmointList){
			totalAmount+=totalHordingAmount;
		}
		return totalAmount;
	}
}
