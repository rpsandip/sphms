package com.booking.portlet.portlet.util;

import java.io.File;

import java.io.FileNotFoundException;
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

import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.Billing_HordingBean;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.booking.portlet.portlet.util.NumberToWord;

public class FileUtil {
	private static Log _log = LogFactoryUtil.getLog(FileUtil.class.getName());
	private static final int MAX_ColUMN=7;
	private static final int MIN_COLUMN=1;
	
	public static File createBillXlsForBooking(Booking booking, Billing billing,List<Billing_HordingBean> billiingHordingBeanList, CustomCompany company) throws FileNotFoundException, IOException, PortalException{
		//long globalSiteGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		//Folder bookingParentFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PropsUtil.get("booking.document.folder"));
		//FileEntry fileEntry = null;
		//if(globalSiteGroupId!=0 && Validator.isNotNull(bookingParentFolder)){																																
			//Folder billingFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, bookingParentFolder.getFolderId(), String.valueOf(billing.getBillingId()));
			//if(Validator.isNotNull(billingFolder)){
				File xlsxFile = createBillXlsFile(booking, billing,billiingHordingBeanList,company);
				/*
				ServiceContext serviceContext = new ServiceContext(); 
				if(!isEdit){
					try{
						 fileEntry = DLAppServiceUtil.addFileEntry(globalSiteGroupId, billingFolder.getFolderId(),  xlsxFile.getName(), MimeTypesUtil.getContentType(xlsxFile),  xlsxFile.getName(), StringPool.BLANK , StringPool.BLANK, xlsxFile, serviceContext);
					 }catch(DuplicateFileEntryException e){
						 String fileName = booking.getCampaignTitle()+StringPool.UNDERLINE+  new Date().getTime() + ".pptx";
						 fileEntry = DLAppServiceUtil.addFileEntry(globalSiteGroupId, billingFolder.getFolderId(), fileName, MimeTypesUtil.getContentType(xlsxFile), fileName, "", "", xlsxFile, serviceContext);
					 }
				}else{
					fileEntry = DLAppServiceUtil.updateFileEntry(booking.getBillId(), xlsxFile.getName(), MimeTypesUtil.getContentType(xlsxFile), xlsxFile.getName(),
							StringPool.BLANK, StringPool.BLANK, false, xlsxFile, serviceContext);
				}*/
			//}
		//}
		return xlsxFile;
	}
	
	
	private static File createBillXlsFile(Booking booking,  Billing billing,List<Billing_HordingBean> billingHordingList, CustomCompany company) throws IOException{
		
		int index=1;
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Bill");
		
		XSSFFont font = wb.createFont();
	    font.setFontHeightInPoints((short) 11);
	    font.setBold(true);
	    font.setFontName("Arial");
		
	    
	    // TAX INVOICE label
	    index = createTaxInvoiceLabelRow(sheet, wb, index);
	    
		// Address, Bill No and Date 
		index = createBillNoRow(sheet, wb, index, font, billing);
		index = createClientAddress(sheet, wb, index, font, booking.getClient(), billing);
		index = createBlankRow(sheet, wb,index);
		
		// Ad-Space lebel,
		int billTypeLabelRowindex = index;
		index = createAddSpaceChargeLabelRow(sheet,wb,index, font);
		
		//PO Number Section
		index = createPONumberRow(sheet, wb, index, font, booking, billing);
		index =  createBlankRow(sheet, wb,index);
		
		
		double totalHordingDisplayCharges = getTotalHordingDisplayCharges(billingHordingList);
		double totalPrintingCharge = getTotalPrintingChage(billingHordingList);
		double totalMoutingCharge = getTotalMountingChage(billingHordingList);
		
		String billType=StringPool.BLANK;
		
		if(totalHordingDisplayCharges>0){
			billType="ad";
		}else if(totalPrintingCharge>0 && totalMoutingCharge==0){
			billType="printing";
		}else if(totalMoutingCharge>0 && totalPrintingCharge==0){
			billType="mounting";
		}
		
		
		// Hoarding table header
		index = createHordingTableHeader(sheet, wb, index,billType);
		
		// Hoarding data
		for(int i=0;i<billingHordingList.size();i++){
			index =  createHordingDataRow(sheet, wb, index, i,billingHordingList.size(), billingHordingList.get(i).getHording(),booking, billingHordingList.get(i), billType);
		}
		
	
		
		if(totalPrintingCharge>0 && billType.equals("ad")){
			index = createPrintingChargeAmountRow(sheet, wb, index, totalPrintingCharge);
			totalHordingDisplayCharges +=totalPrintingCharge;
		}
		
		if(totalMoutingCharge>0 && billType.equals("ad")){
			index = createMountingAmountRow(sheet, wb, index, totalMoutingCharge);
			totalHordingDisplayCharges+=totalMoutingCharge;
		}
		
				
		//  Total amount
		index =  createSubTotalAmountRow(sheet, wb, index, totalHordingDisplayCharges);
		
		// Considering CGST as 9%
		double cGSTCharge = totalHordingDisplayCharges* Double.parseDouble(PropsUtil.get("cgst.rate"));
		// Consideting SGST as 9%
		double sGSTCharge = totalHordingDisplayCharges* Double.parseDouble(PropsUtil.get("sgst.rate"));
		
		// serviceTax
		index = createServiceTaxRow(sheet, wb, index, font,cGSTCharge, sGSTCharge);
		
		//Total amount
		double totalAmount = totalHordingDisplayCharges + cGSTCharge + sGSTCharge;
		
		index = createTotalAmountRow(sheet, wb, index, font, totalAmount);
		
		index = createBlankRow(sheet, wb,index);
		
		index = createGSTNoRow(sheet, wb, index, font, company);
		

		index = createBlankRow(sheet, wb,index);
		
		
		index = createFooterRow(sheet, wb, index);
		
		index = createBlankRow(sheet, wb,index);
		
		
		for(int i=1;i<=6;i++){
			sheet.autoSizeColumn(i);
		}
		
		// Write the output to a file
		String fileName = booking.getCampaignTitle()+".xlsx";
		File file = new File(System.getProperty("catalina.home")+"/temp/"+fileName);
		
		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();
		
		return file;

	}
	
	private static int createTaxInvoiceLabelRow(XSSFSheet sheet, XSSFWorkbook wb, int index){
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
		cell1.setCellValue("TAX INVOICE");
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

		XSSFCell cell7=  taxInvoiceRow.createCell(7);
		cell7.setCellStyle(style);
		
		mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
		
		index++;
		
		return index;
	}
	
	private static int createBillNoRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, Billing  billing){
		XSSFRow billNoRow = sheet.createRow(index);	
		XSSFCellStyle style = getLeftTopBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell1 = billNoRow.createCell(MIN_COLUMN);
		cell1.setCellValue("M/S");
		cell1.setCellStyle(style);
		
		XSSFCell cell2 = billNoRow.createCell(2);
		cell2.setCellStyle(getTopBorderStyle(wb));
		
		XSSFCell cell3 = billNoRow.createCell(3);
		cell3.setCellStyle(getTopBorderStyle(wb));
		
		XSSFCell cell4 = billNoRow.createCell(4);
		XSSFCellStyle style2 = getTopBorderStyle(wb);
		style2.setFont(font);
		cell4.setCellStyle(style2);
		cell4.setCellValue("Bill No : " + BillingLocalServiceUtil.getDisplayBillNo(billing));
		mergedRegion(index, index, MIN_COLUMN, 3, sheet);
		mergedRegion(index, index, 4, MAX_ColUMN, sheet);
		
		XSSFCell cell5 = billNoRow.createCell(5);
		cell5.setCellStyle(getTopBorderStyle(wb));
		
		XSSFCell cell6 = billNoRow.createCell(6);
		cell6.setCellStyle(getTopBorderStyle(wb));
		
		XSSFCell cell7 = billNoRow.createCell(MAX_ColUMN);
		cell7.setCellStyle(getRightTopBorderStyle(wb));
		index++;
		return index;
	}
	
	private static int createClientAddress(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, long clientId, Billing billing){
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String clientName = StringPool.BLANK;
		String addess1 = StringPool.BLANK;
		String address2 = StringPool.BLANK;
		String city = StringPool.BLANK;;
		String state = StringPool.BLANK;
		
		
		Client client;
		try {
			client = ClientLocalServiceUtil.getClient(clientId);
			clientName = client.getClientName();
			addess1 = client.getAddress1();
			address2 = client.getAddress2();
			city = client.getCity();
			state = client.getState();
		} catch (PortalException e) {
			_log.error(e);
		}
		
		XSSFRow addressRow = sheet.createRow(index);	
		XSSFCell cell21 = addressRow.createCell(MIN_COLUMN);
		cell21.setCellValue(clientName);
		cell21.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCell cell27 = addressRow.createCell(MAX_ColUMN);
		cell27.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		XSSFRow addressRow2 = sheet.createRow(index);	
		XSSFCell cell31 = addressRow2.createCell(MIN_COLUMN);
		cell31.setCellValue(addess1+StringPool.COMMA + StringPool.SPACE + address2);
		cell31.setCellStyle(getLeftBorderStyle(wb));
		XSSFCell cell36 = addressRow2.createCell(MAX_ColUMN);
		cell36.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		XSSFRow addressRow3 = sheet.createRow(index);	
		XSSFCell cell41 = addressRow3.createCell(MIN_COLUMN);
		cell41.setCellValue(city + StringPool.COMMA + state);
		cell41.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCellStyle style = getRowStyle(addressRow3, wb);
		XSSFCell cell44 = addressRow3.createCell(4);
		cell44.setCellStyle(style);
		cell44.setCellValue("Date : " + dateformat.format(new Date()));
		
		XSSFCell cell46 = addressRow3.createCell(MAX_ColUMN);
		cell46.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index, index, MIN_COLUMN, 3, sheet);
		mergedRegion(index, index, 4, MAX_ColUMN, sheet);
		index++;
		
		// GST, PAN NO
		XSSFRow gstNoRow = sheet.createRow(index);
		XSSFCell cell11_1 = gstNoRow.createCell(MIN_COLUMN);
		XSSFCellStyle style2 = getLeftBottomBorderStyle(wb);
		style2.setFont(font);
		cell11_1.setCellValue("GST NO : "+ billing.getClientGSTNumber());
		cell11_1.setCellStyle(style2);
		
		XSSFCell cell12_2 = gstNoRow.createCell(2);
		XSSFCellStyle style3 = getBottomBorderStyle(wb);
		style3.setFont(font);
		cell12_2.setCellValue("PAN NO : " + billing.getClientPANNo());
		cell12_2.setCellStyle(style3);
		
		XSSFCell cell12_3 = gstNoRow.createCell(3);
		cell12_3.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_4 = gstNoRow.createCell(4);
		cell12_4.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_5 = gstNoRow.createCell(5);
		cell12_5.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_6 = gstNoRow.createCell(6);
		cell12_6.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_7 = gstNoRow.createCell(MAX_ColUMN);
		cell12_7.setCellStyle(getRightBottomBorderStyle(wb));
		mergedRegion(index, index, 3, MAX_ColUMN, sheet);
		index++;
		
		return index;
	}
	
	private static int createBlankRow(XSSFSheet sheet, XSSFWorkbook wb,int index){
		XSSFRow blankRow = sheet.createRow(index);
		
		XSSFCell cell12_1 = blankRow.createCell(MIN_COLUMN);
		cell12_1.setCellStyle(getLeftBottomBorderStyle(wb));
		
		XSSFCell cell12_2 = blankRow.createCell(2);
		cell12_2.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_3 = blankRow.createCell(3);
		cell12_3.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_4 = blankRow.createCell(4);
		cell12_4.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_5 = blankRow.createCell(5);
		cell12_5.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_6 = blankRow.createCell(6);
		cell12_6.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell12_7 = blankRow.createCell(MAX_ColUMN);
		cell12_7.setCellStyle(getRightBottomBorderStyle(wb));
		
		mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		return index;
		
	}
	
	private static int createAddSpaceChargeLabelRow(XSSFSheet sheet, XSSFWorkbook wb,int index, XSSFFont font){
		XSSFRow addSpaceRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setFont(font);
		XSSFCell cell61 = addSpaceRow.createCell(MIN_COLUMN);
		cell61.setCellValue("Ad-Space Charges");
		cell61.setCellStyle(style);
		
		XSSFCell cell62 = addSpaceRow.createCell(2);
		cell62.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell63 = addSpaceRow.createCell(3);
		cell63.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell64 = addSpaceRow.createCell(4);
		cell64.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell65 = addSpaceRow.createCell(5);
		cell65.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell66 = addSpaceRow.createCell(6);
		cell66.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell67 = addSpaceRow.createCell(MAX_ColUMN);
		cell67.setCellStyle(getRightBottomBorderStyle(wb));
		
		mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		return index;
	}
	
	private static int createPONumberRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, Booking booking, Billing billing){
		XSSFRow poNumberRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftTopBorderStyle(wb);
		style.setFont(font);
		// PO NUMBER
		XSSFCell cell71 = poNumberRow.createCell(MIN_COLUMN);
		cell71.setCellValue("P O Number:");
		cell71.setCellStyle(style);
		
		XSSFCell cell72 = poNumberRow.createCell(2);
		cell72.setCellValue(billing.getClientPONumber());

		XSSFCell cell76 = poNumberRow.createCell(MAX_ColUMN);
		cell76.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index, index, 2, MAX_ColUMN, sheet);
		index++;
		
		// BIlling Period
		XSSFRow billingPeriodRow = sheet.createRow(index);
		XSSFCell cell81 = billingPeriodRow.createCell(MIN_COLUMN);
		XSSFCellStyle style2 = getLeftBorderStyle(wb);
		style2.setFont(font);
		cell81.setCellValue("Billing Period:");
		cell81.setCellStyle(style2);
		
		XSSFCell cell82 = billingPeriodRow.createCell(2);
		cell82.setCellValue(SPHMSCommonLocalServiceUtil.getDateTimeDiff(booking.getStartDate(), booking.getEndDate()));
		
		XSSFCell cell86 = billingPeriodRow.createCell(MAX_ColUMN);
		cell86.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 2, MAX_ColUMN, sheet);
		index++;
		
		// Display
		XSSFRow displayRow = sheet.createRow(index);
		XSSFCell cell91 = displayRow.createCell(MIN_COLUMN);
		XSSFCellStyle style3 = getLeftBottomBorderStyle(wb);
		style3.setFont(font);
		cell91.setCellValue("Display : ");
		cell91.setCellStyle(style3);
		
		XSSFCell cell92 = displayRow.createCell(2);
		cell92.setCellValue(billing.getDisplay());
		cell92.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell93 = displayRow.createCell(3);
		cell93.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell94 = displayRow.createCell(4);
		cell94.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell95 = displayRow.createCell(5);
		cell95.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell96 = displayRow.createCell(6);
		cell96.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell97 = displayRow.createCell(MAX_ColUMN);
		cell97.setCellStyle(getRightBottomBorderStyle(wb));
		
		mergedRegion(index, index, 2, MAX_ColUMN, sheet);
		index++;
		
		return index;
		
	}
	
	private static int createHordingTableHeader(XSSFSheet sheet, XSSFWorkbook wb, int index,String billType){
		XSSFRow hordingTableRow = sheet.createRow(index);
		hordingTableRow.setHeight((short)500);
		XSSFCellStyle style = getAllBorderStyle(wb);
		XSSFFont font = wb.createFont();
	    font.setFontHeightInPoints((short) 14);
	    font.setBold(true);
	    font.setFontName("Arial");
	    style.setFont(font);
	    style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		
		XSSFCell cell12_1 = hordingTableRow.createCell(MIN_COLUMN);
		cell12_1.setCellValue("Town");
		cell12_1.setCellStyle(style);
		
		XSSFCell cell12_2 = hordingTableRow.createCell(2);
		cell12_2.setCellValue("Location");
		cell12_2.setCellStyle(style);
		
		XSSFCell cell12_3 = hordingTableRow.createCell(3);
		cell12_3.setCellValue("HSN/SAC Code");
		cell12_3.setCellStyle(style);
		
		
		XSSFCell cell12_4 = hordingTableRow.createCell(4);
		cell12_4.setCellValue("Size");
		cell12_4.setCellStyle(style);
		
		if(billType.equals("add")){
			XSSFCell cell12_5 = hordingTableRow.createCell(5);
			cell12_5.setCellValue("Rate Per Month");
			cell12_5.setCellStyle(style);
		}else{
			XSSFCell cell12_5 = hordingTableRow.createCell(5);
			cell12_5.setCellValue("Sq.ft");
			cell12_5.setCellStyle(style);
		}
		
		if(billType.equals("add")){
			XSSFCell cell12_6 = hordingTableRow.createCell(6);
			cell12_6.setCellValue("Period");
			cell12_6.setCellStyle(style);
		}else{
			XSSFCell cell12_6 = hordingTableRow.createCell(6);
			cell12_6.setCellValue("Rate");
			cell12_6.setCellStyle(style);
		}
		
		XSSFCell cell12_7 = hordingTableRow.createCell(MAX_ColUMN);
		cell12_7.setCellValue("Amount");
		cell12_7.setCellStyle(style);
		index++;
		return index;
	}
	
	
	private static int createHordingDataRow(XSSFSheet sheet, XSSFWorkbook wb, int index, int loopIndex,int totalList, Hording hording, Booking booking, Billing_HordingBean billingHordingBean, String billType){
		XSSFRow hordingTableRow = sheet.createRow(index);
		XSSFCellStyle style = getRowStyle(hordingTableRow, wb);
		style.setAlignment(HorizontalAlignment.CENTER);
		
		XSSFCell cell1 = hordingTableRow.createCell(MIN_COLUMN);
		cell1.setCellValue(hording.getCity());
		cell1.setCellStyle(getLeftBorderStyle(wb));
		if(loopIndex==(totalList-1)){
			cell1.setCellStyle(getLeftBottomBorderStyle(wb));
		}else{
			cell1.setCellStyle(getLeftBorderStyle(wb));
		}
		
		XSSFCell cell2 = hordingTableRow.createCell(2);
		cell2.setCellValue(hording.getLocation());
		if(loopIndex==(totalList-1)){
			cell2.setCellStyle(getBottomBorderStyle(wb));
		}
		
		XSSFCell cell3 = hordingTableRow.createCell(3);
		cell3.setCellValue(billingHordingBean.getHsnNo());
		if(loopIndex==(totalList-1)){
			cell3.setCellStyle(getBottomBorderStyle(wb));
		}
		
		
		XSSFCell cell4 = hordingTableRow.createCell(4);
		cell4.setCellValue(hording.getSize());
		if(loopIndex==(totalList-1)){
			cell4.setCellStyle(getBottomBorderStyle(wb));
		}
		
		if(billType.equals("ad")){
			XSSFCell cell5 = hordingTableRow.createCell(5);
			cell5.setCellValue(hording.getPricePerMonth());
			if(loopIndex==(totalList-1)){
				cell5.setCellStyle(getBottomBorderStyle(wb));
			}
		}else{
			XSSFCell cell5 = hordingTableRow.createCell(5);
			String[] heightWidthArray = SPHMSCommonLocalServiceUtil.getHeightOrWidth(hording.getSize());
			cell5.setCellValue(SPHMSCommonLocalServiceUtil.getTotalSqFt(heightWidthArray));
			if(loopIndex==(totalList-1)){
				cell5.setCellStyle(getBottomBorderStyle(wb));
			}
		}
		
		if(billType.equals("ad")){
			XSSFCell cell6 = hordingTableRow.createCell(6);
			cell6.setCellValue(SPHMSCommonLocalServiceUtil.getDateTimeDiff(booking.getStartDate(), booking.getEndDate()));
			if(loopIndex==(totalList-1)){
				cell6.setCellStyle(getBottomBorderStyle(wb));
			}
		}else{
			XSSFCell cell6 = hordingTableRow.createCell(6);
			if(billType.equals("printing")){
				cell6.setCellValue(billingHordingBean.getTotalPrintingCharge());
			}else{
				cell6.setCellValue(billingHordingBean.getTotalMountingCharge());
			}
			if(loopIndex==(totalList-1)){
				cell6.setCellStyle(getBottomBorderStyle(wb));
			}
		}
		
		
		double displayCharges =  billingHordingBean.getTotalHordingCharge();  //SPHMSCommonLocalServiceUtil.getDisplayCharges(hording.getPricePerMonth(), displayDurationDays); 
		XSSFCell cell7 = hordingTableRow.createCell(MAX_ColUMN);
		cell7.setCellValue(displayCharges);
		if(loopIndex==(totalList-1)){
			cell7.setCellStyle(getRightBottomBorderStyle(wb));
		}else{
			cell7.setCellStyle(getRightBorderStyle(wb));
		}
		
		index++;
		return index;
		
	}
	
	
	private static int createPrintingChargeAmountRow(XSSFSheet sheet, XSSFWorkbook wb, int index, double totalPrintingCharge){
		XSSFRow totalAmountRow = sheet.createRow(index);
		
		XSSFCell cell1 = totalAmountRow.createCell(MIN_COLUMN);
		cell1.setCellStyle(getLeftBottomBorderStyle(wb));
		
		XSSFCell cell2 = totalAmountRow.createCell(2);
		cell2.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell3 = totalAmountRow.createCell(3);
		cell3.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell4 = totalAmountRow.createCell(4);
		cell4.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell5 = totalAmountRow.createCell(5);
		cell5.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell6 = totalAmountRow.createCell(6);
		cell6.setCellValue("Printing Charge: ");
		cell6.setCellStyle(getAllBorderStyle(wb));
		
		XSSFCell cell7 = totalAmountRow.createCell(MAX_ColUMN);
		cell7.setCellValue(totalPrintingCharge);
		XSSFCellStyle style = getRightBottomBorderStyle(wb);
		style.setAlignment(HorizontalAlignment.LEFT);
		cell7.setCellStyle(style);
		
		mergedRegion(index, index, MIN_COLUMN, 5, sheet);
		index++;
		return index;
	}
	
	private static int createMountingAmountRow(XSSFSheet sheet, XSSFWorkbook wb, int index, double totalMountingCharge){
		XSSFRow totalAmountRow = sheet.createRow(index);
		
		XSSFCell cell1 = totalAmountRow.createCell(MIN_COLUMN);
		cell1.setCellStyle(getLeftBottomBorderStyle(wb));
		
		XSSFCell cell2 = totalAmountRow.createCell(2);
		cell2.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell3 = totalAmountRow.createCell(3);
		cell3.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell4 = totalAmountRow.createCell(4);
		cell4.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell5 = totalAmountRow.createCell(5);
		cell5.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell6 = totalAmountRow.createCell(6);
		cell6.setCellValue("Mounting Charge: ");
		cell6.setCellStyle(getAllBorderStyle(wb));
		
		XSSFCell cell7 = totalAmountRow.createCell(MAX_ColUMN);
		cell7.setCellValue(totalMountingCharge);
		XSSFCellStyle style = getRightBottomBorderStyle(wb);
		style.setAlignment(HorizontalAlignment.LEFT);
		cell7.setCellStyle(style);
		
		mergedRegion(index, index, MIN_COLUMN, 5, sheet);
		index++;
		return index;
	}
	
	
	private static int createSubTotalAmountRow(XSSFSheet sheet, XSSFWorkbook wb, int index, double totalHordingDisplayCharges){
		XSSFRow totalAmountRow = sheet.createRow(index);
		
		XSSFCell cell1 = totalAmountRow.createCell(MIN_COLUMN);
		cell1.setCellStyle(getLeftBottomBorderStyle(wb));
		
		XSSFCell cell2 = totalAmountRow.createCell(2);
		cell2.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell3 = totalAmountRow.createCell(3);
		cell3.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell4 = totalAmountRow.createCell(4);
		cell4.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell5 = totalAmountRow.createCell(5);
		cell5.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell6 = totalAmountRow.createCell(6);
		cell6.setCellValue("Sub Total: ");
		cell6.setCellStyle(getAllBorderStyle(wb));
		
		XSSFCell cell7 = totalAmountRow.createCell(MAX_ColUMN);
		cell7.setCellValue(totalHordingDisplayCharges);
		XSSFCellStyle style = getRightBottomBorderStyle(wb);
		style.setAlignment(HorizontalAlignment.LEFT);
		cell7.setCellStyle(style);
		
		mergedRegion(index, index, MIN_COLUMN, 5, sheet);
		index++;
		return index;
	}
	
	private static int createServiceTaxRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, double cGST, double sGST){
		
		// Service tax
		XSSFRow cgstRow = sheet.createRow(index);
		XSSFCellStyle style =  wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.RIGHT);
		
		XSSFCell cell1 = cgstRow.createCell(MIN_COLUMN);
		cell1.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCell cell2 = cgstRow.createCell(6);
		cell2.setCellValue("CGST @ " + Double.parseDouble(PropsUtil.get("cgst.rate"))*100 + "%");
		
		
		XSSFCell cell7 = cgstRow.createCell(MAX_ColUMN);
		XSSFCellStyle style2 = getRightBorderStyle(wb);
		cell7.setCellValue(cGST);
		cell7.setCellStyle(style2);
		
		mergedRegion(index, index, MIN_COLUMN, 5, sheet);
		index++;
		
		// Swathc bharat Cess
		XSSFRow sgstRow = sheet.createRow(index);
		XSSFCellStyle style1 = getBottomBorderStyle( wb);
		style.setAlignment(HorizontalAlignment.RIGHT);
		
		XSSFCell cell11 = sgstRow.createCell(MIN_COLUMN);
		cell11.setCellStyle(getLeftBottomBorderStyle(wb));
		
		XSSFCell cell12 = sgstRow.createCell(2);
		cell12.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell13 = sgstRow.createCell(3);
		cell13.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell14 = sgstRow.createCell(4);
		cell14.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell15 = sgstRow.createCell(5);
		cell15.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell26 = sgstRow.createCell(6);
		cell26.setCellValue("SGST @ "+ Double.parseDouble(PropsUtil.get("sgst.rate"))*100+ "%");
		cell26.setCellStyle(style1);
		
		XSSFCell cell66 = sgstRow.createCell(MAX_ColUMN);
		XSSFCellStyle style11 = getRightBottomBorderStyle( wb);
		cell66.setCellValue(sGST);
		cell66.setCellStyle(style11);
		
		mergedRegion(index, index, MIN_COLUMN, 5, sheet);
		index++;
		
		return index;
	}
	
	private static int createTotalAmountRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, double totalAmount){
		
		// Ruppes in words
		XSSFRow totalAmountRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBottomBorderStyle(wb);
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		XSSFCell cell1 = totalAmountRow.createCell(MIN_COLUMN);
		cell1.setCellValue("Rupees :"+ NumberToWord.convertNumberToWords(totalAmount));
		cell1.setCellStyle(style);
		
		XSSFCell cell2 = totalAmountRow.createCell(2);
		cell2.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell3 = totalAmountRow.createCell(3);
		cell3.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell4 = totalAmountRow.createCell(4);
		cell4.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell5 = totalAmountRow.createCell(5);
		cell5.setCellStyle(getBottomBorderStyle(wb));
		
		mergedRegion(index, index, MIN_COLUMN, 5, sheet);
		
		XSSFCellStyle style2 = getLeftRightBottomBorderStyle(wb);
		style2.setFont(font);
		style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		
		XSSFCell cell6 = totalAmountRow.createCell(6);
		cell6.setCellValue("Total");
		cell6.setCellStyle(style2);
		
		
		XSSFCell cell7 = totalAmountRow.createCell(MAX_ColUMN);
		cell7.setCellValue(totalAmount);
		cell7.setCellStyle(style2);
		
		index++;
		return index;
		
		
	}
	
	
	private static int createGSTNoRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font, CustomCompany company){
		
		// GST Row
		XSSFRow gstNoRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		style.setAlignment(HorizontalAlignment.LEFT);
		style.setFont(font);
		XSSFCell cell1 = gstNoRow.createCell(1);
		cell1.setCellValue("GST No   : "+ company.getGSTNo());
		cell1.setCellStyle(style);
		
		XSSFCell cell6 = gstNoRow.createCell(6);
		cell6.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		// GST Row
		XSSFRow panNoRow = sheet.createRow(index);
		style.setAlignment(HorizontalAlignment.LEFT);
		
		XSSFCell cell11 = panNoRow.createCell(MIN_COLUMN);
		cell11.setCellValue("PAN No : " + company.getPANNo() + "  (For "+ company.getName()+" )");
		cell11.setCellStyle(style);
		
		XSSFCell cell66 = panNoRow.createCell(MAX_ColUMN);
		cell66.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		// Bank Row
		XSSFRow bankrow = sheet.createRow(index);
		style.setAlignment(HorizontalAlignment.LEFT);
		
		XSSFCell cell26_1 = bankrow.createCell(MIN_COLUMN);
		cell26_1.setCellValue("Bank Details :");
		cell26_1.setCellStyle(style);
		
		XSSFCell cell26_2 = bankrow.createCell(2);
		XSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font);
		cell26_2.setCellValue(company.getBankName());
		cell26_2.setCellStyle(style2);
		
		XSSFCell cell26_6 = bankrow.createCell(MAX_ColUMN);
		cell26_6.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, 2, MAX_ColUMN, sheet);
		index++;
		
		
		// Bank Row
		XSSFRow bankrow2 = sheet.createRow(index);
		style.setAlignment(HorizontalAlignment.LEFT);
		
		XSSFCell cell27_1 = bankrow2.createCell(1);
		cell27_1.setCellStyle(getLeftBottomBorderStyle(wb));
		
		XSSFCell cell27_2 = bankrow2.createCell(2);
		XSSFCellStyle style1 = getBottomBorderStyle(wb);
		style1.setFont(font);
		cell27_2.setCellValue(company.getAccountDetail());
		cell27_2.setCellStyle(style1);
		
		XSSFCell cell27_3 = bankrow2.createCell(3);
		cell27_3.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell27_4 = bankrow2.createCell(4);
		cell27_4.setCellStyle(getBottomBorderStyle(wb));
		
		
		XSSFCell cell27_5 = bankrow2.createCell(5);
		cell27_5.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell27_6 = bankrow2.createCell(6);
		cell27_6.setCellStyle(getBottomBorderStyle(wb));
		
		XSSFCell cell27_7 = bankrow2.createCell(MAX_ColUMN);
		cell27_7.setCellStyle(getRightBottomBorderStyle(wb));
		
		
		mergedRegion(index, index, 2, MAX_ColUMN, sheet);
		index++;
		
		return index;
	}	
	
	private static int createFooterRow(XSSFSheet sheet, XSSFWorkbook wb, int index){
		// GST Row
		XSSFRow footerRow1 = sheet.createRow(index);
		XSSFCell cell1_1 = footerRow1.createCell(MIN_COLUMN);
		cell1_1.setCellValue("1. The Payment of bill should be made immediately on receipt of the bill.");
		cell1_1.setCellStyle(getLeftBorderStyle(wb));
		XSSFCell cell1_6 = footerRow1.createCell(MAX_ColUMN);
		cell1_6.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		XSSFRow footerRow2 = sheet.createRow(index);
		XSSFCell cell2_1 = footerRow2.createCell(MIN_COLUMN);
		cell2_1.setCellValue("2. Cheque to be drawn in favour of '' Search Publicity '' only.");
		cell2_1.setCellStyle(getLeftBorderStyle(wb));

		XSSFCell cell2_6 = footerRow2.createCell(MAX_ColUMN);
		cell2_6.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		XSSFRow footerRow3 = sheet.createRow(index);
		XSSFCell cell3_1 = footerRow3.createCell(MIN_COLUMN);
		cell3_1.setCellValue("3. Any Complain about this bill should be reported within a week from the ");
		cell3_1.setCellStyle(getLeftBorderStyle(wb));
		XSSFCell cell3_6 = footerRow3.createCell(MAX_ColUMN);
		cell3_6.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		
		XSSFRow footerRow4 = sheet.createRow(index);
		XSSFCell cell4_1 = footerRow4.createCell(MIN_COLUMN);
		cell4_1.setCellValue("     date of bill and thereafter no complaint will be entertained. ");
		cell4_1.setCellStyle(getLeftBorderStyle(wb));
		XSSFCell cell4_6 = footerRow4.createCell(MAX_ColUMN);
		cell4_6.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		
		XSSFRow footerRow5 = sheet.createRow(index);
		XSSFCell cell5_1 = footerRow5.createCell(MIN_COLUMN);
		cell5_1.setCellValue("4. Govt. Service Tax and statatory leavy if any extra as applicable at the ");
		cell5_1.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCell cell2_4 = footerRow5.createCell(6);
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setFontName("Arial");
	    font.setFontHeightInPoints((short) 12);
	    font.setBold(true);
	    style.setFont(font);
		cell2_4.setCellValue("Authorised Signatory");
		cell2_4.setCellStyle(style);
		
		XSSFCell cell5_6 = footerRow5.createCell(MAX_ColUMN);
		cell5_6.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index,index, MIN_COLUMN, 5, sheet);
		mergedRegion(index,index, 6, MAX_ColUMN, sheet);
		index++;
		
		XSSFRow footerRow6 = sheet.createRow(index);
		XSSFCell cell6_1 = footerRow6.createCell(MIN_COLUMN);
		cell6_1.setCellValue("     time of billing");
		cell6_1.setCellStyle(getLeftBorderStyle(wb));
		XSSFCell cell6_6 = footerRow6.createCell(MAX_ColUMN);
		cell6_6.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		
		XSSFRow footerRow7 = sheet.createRow(index);
		XSSFCell cell7_1 = footerRow7.createCell(MIN_COLUMN);
		cell7_1.setCellValue("5. Subject to Ahmedabad Jurisdiction.");
		cell7_1.setCellStyle(getLeftBorderStyle(wb));
		
		XSSFCell cell7_6 = footerRow7.createCell(MAX_ColUMN);
		cell7_6.setCellStyle(getRightBorderStyle(wb));
		mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
		index++;
		return index;
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
	
	private static double getTotalHordingDisplayCharges(List<Billing_HordingBean> billingHordingList){
		double totalHordingDisplayCharges=0d;
		for(Billing_HordingBean billingHording : billingHordingList){
			totalHordingDisplayCharges+=billingHording.getTotalHordingCharge();
		}
		return totalHordingDisplayCharges;
	}
	
	private static double getTotalPrintingChage(List<Billing_HordingBean> billingHordingList){
		double totalPrintingChargeList =0d;
		for(Billing_HordingBean billingHording : billingHordingList){
			totalPrintingChargeList+=billingHording.getTotalPrintingCharge();
		}
		return totalPrintingChargeList;
	}
	
	private static double getTotalMountingChage(List<Billing_HordingBean> billingHordingList){
		double totalMoutingChargeList =0d;
		for(Billing_HordingBean billingHording : billingHordingList){
			totalMoutingChargeList+=billingHording.getTotalMountingCharge();
		}
		return totalMoutingChargeList;
	}
	
	
	
	private static long getDisplayDuration(Date startDate, Date endDate){
	    long diff = endDate.getTime() - startDate.getTime();
	    // Need to add 1 days because for same start and end date below equiation gives 0 and we have to consider 
	    // as 1. Same for other dates.
	    return (diff / (1000*60*60*24))+1;
	}
}
