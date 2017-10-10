package com.proposal.portlet.portlet.util;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.sl.usermodel.PictureData.PictureType;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
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
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.model.Proposal_Hording;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.Proposal_HordingLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.common.service.service.persistence.Proposal_HordingPK;

public class FileUtil {
	
	private static Log _log = LogFactoryUtil.getLog(FileUtil.class.getName());
	private static final int MAX_ColUMN=17;
	private static final int MIN_COLUMN=1;
	
	public static FileEntry createProposalPPTFile(Proposal proposal, List<Hording> hordingList) throws FileNotFoundException, IOException, PortalException{
		long globalSiteGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		Folder proposalParentFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PropsUtil.get("proposal.document.folder"));
		FileEntry fileEntry = null;
		if(globalSiteGroupId!=0 && Validator.isNotNull(proposalParentFolder)){
			Folder proposalFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, proposalParentFolder.getFolderId(), String.valueOf(proposal.getProposalId()));
			if(Validator.isNotNull(proposalFolder)){
				File pptFile = createPPTFile(hordingList, proposal);
				ServiceContext serviceContext = new ServiceContext(); 
				 try{
					 fileEntry = DLAppServiceUtil.addFileEntry(globalSiteGroupId, proposalFolder.getFolderId(),  pptFile.getName(), MimeTypesUtil.getContentType(pptFile),  pptFile.getName(), StringPool.BLANK , StringPool.BLANK, pptFile, serviceContext);
				 }catch(DuplicateFileEntryException e){
					 String fileName = proposal.getCampaignTitle()+StringPool.UNDERLINE+  new Date().getTime() + ".pptx";
					 fileEntry = DLAppServiceUtil.addFileEntry(globalSiteGroupId, proposalFolder.getFolderId(), fileName, MimeTypesUtil.getContentType(pptFile), fileName, StringPool.BLANK , StringPool.BLANK, pptFile, serviceContext);
				 }
			}
		}
		return fileEntry;
	}
	
	public static FileEntry createProposalXlsxFile(Proposal proposal, List<Hording> hordingList) throws FileNotFoundException, IOException, PortalException{
		FileEntry fileEntry = null;
		long globalSiteGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		Folder proposalParentFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PropsUtil.get("proposal.document.folder"));
		if(globalSiteGroupId!=0 && Validator.isNotNull(proposalParentFolder)){
			Folder proposalFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, proposalParentFolder.getFolderId(), String.valueOf(proposal.getProposalId()));
			if(Validator.isNotNull(proposalFolder)){
				File xlsxFile = createXlsxFile(hordingList, proposal);
				ServiceContext serviceContext = new ServiceContext(); 
				 try{
					 fileEntry = DLAppServiceUtil.addFileEntry(globalSiteGroupId, proposalFolder.getFolderId(),  xlsxFile.getName(), MimeTypesUtil.getContentType(xlsxFile),  xlsxFile.getName(), StringPool.BLANK , StringPool.BLANK, xlsxFile, serviceContext);
				 }catch(DuplicateFileEntryException e){
					 String fileName = proposal.getCampaignTitle()+StringPool.UNDERLINE+  new Date().getTime() + ".pptx";
					 fileEntry = DLAppServiceUtil.addFileEntry(globalSiteGroupId, proposalFolder.getFolderId(), fileName, MimeTypesUtil.getContentType(xlsxFile), fileName, "Patient Invoice", "", xlsxFile, serviceContext);
				 }
			}	
		}
		return fileEntry;
	}
	
	
	private static File createPPTFile(List<Hording> hordingList, Proposal proposal) throws FileNotFoundException, IOException{

		// get ppt object	
		XMLSlideShow ppt = new XMLSlideShow();
	        
		//getting the slide master object
		XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);

		//select a layout from specified list
		XSLFSlideLayout slidelayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);

		
		XSLFSlide firstSlide = createSlide(ppt, slideMaster, slidelayout);
		
		// Add first slide
		addFirstSlide(firstSlide);
		
		// Adding hoarding photos slides
		for(Hording hording : hordingList){
		
		//creating a slide in it 
		XSLFSlide slide = createSlide(ppt, slideMaster, slidelayout);
			
	    List<XSLFShape> shapes= slide.getShapes();
	 
	    setSlideTitle(shapes.get(0), hording.getTitle());

	    setSlidePicture(shapes.get(1), ppt, slide, hording);

		}

		String fileName = proposal.getCampaignTitle()+"_Proposal.pptx";
		File file = new File(System.getProperty("catalina.home")+"/temp/"+fileName);
		
	    //creating a file object 
		FileOutputStream out = new FileOutputStream(file);
		//saving the changes to a file
		ppt.write(out);
		out.close();	
		
		return file;
	}
	
	
	private static File createXlsxFile(List<Hording> hordingList, Proposal proposal) throws FileNotFoundException, IOException{

		int index=1;
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("Proposal");
		
		XSSFFont font = wb.createFont();
	    font.setFontHeightInPoints((short) 11);
	    font.setBold(true);
	    font.setFontName("Arial");
		
	    index = createDateRow(sheet, wb, index, font);
		
	    index = createClientRow(sheet,wb, index, font,proposal);
		
		index = createCampaignRow(sheet,wb, index, font,proposal);
		
		index = createTableHeader(sheet,wb, index);
		
		List<Double> hordingsTotalAmountList = new ArrayList<Double>();
		for(int i=0;i<hordingList.size();i++){
			index = createHoraingDetailRow(sheet, i,wb, hordingList.get(i),proposal, index, hordingList.size(), hordingsTotalAmountList);
		}
		
		// Total Amount 
		index = createTotalAmountRow(sheet, index, wb, font, hordingsTotalAmountList);
		
		createFooterText(sheet, index,wb, font);
		
		// Write the output to a file
		String fileName = proposal.getCampaignTitle()+"_Proposal.xlsx";
		File file = new File(System.getProperty("catalina.home")+"/temp/"+fileName);
		
		FileOutputStream fileOut = new FileOutputStream(file);
		wb.write(fileOut);
		fileOut.close();
		
		return file;

	}
	
	private static XSLFSlide createSlide(XMLSlideShow ppt, XSLFSlideMaster slideMaster, XSLFSlideLayout slidelayout){
		return ppt.createSlide(slidelayout);
	}
	
	private static void setSlideTitle(XSLFShape title, String hordingTitle){
		XSLFTextShape textShape = (XSLFTextShape) title;
        textShape.clearText();
        XSLFTextParagraph p = textShape.addNewTextParagraph();
        XSLFTextRun r1 = p.addNewTextRun();
        r1.setText(hordingTitle);
        r1.setFontColor(Color.BLACK);
        r1.setFontSize(24.);
	}
	
	private static void setSlidePicture(XSLFShape pic, XMLSlideShow ppt, XSLFSlide slide, Hording hording) throws FileNotFoundException, IOException{
        java.awt.geom.Rectangle2D anchor = pic.getAnchor();

        try {
			DLFileEntry hordingImage = DLFileEntryLocalServiceUtil.getDLFileEntry(hording.getNormalImageId());
			
			byte[] pictureData = IOUtils.toByteArray(hordingImage.getContentStream());
	        XSLFPictureData idx = ppt.addPicture(pictureData, PictureType.JPEG);
	          
	        XSLFPictureShape picture = slide.createPicture(idx);
	          slide.removeShape(pic);

	        picture.setAnchor(anchor);  
	        
		} catch (PortalException e) {
			_log.error(e);
		}
        
       

	}
	
	private static void addFirstSlide(XSLFSlide firstSlide){
		List<XSLFShape> shapes= firstSlide.getShapes();
		
		XSLFTextShape titleShpe = (XSLFTextShape) shapes.get(0);
		titleShpe.clearText();
		
		XSLFTextShape bodyShape = (XSLFTextShape) shapes.get(1);
		bodyShape.clearText();
        XSLFTextParagraph p = bodyShape.addNewTextParagraph();
        p.addLineBreak();p.addLineBreak();p.addLineBreak();
        p.setTextAlign(TextAlign.CENTER);
        p.setBullet(false);
        XSLFTextRun r1 = p.addNewTextRun();
        r1.setText("Photos");
        r1.setFontColor(Color.BLACK);
        r1.setFontSize(48d);
	}
	
	private static int createDateRow(XSSFSheet sheet, XSSFWorkbook wb, int index, XSSFFont font){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		_log.info("daterow at ->" + index);
		XSSFRow dateRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftTopBorderStyle(wb);
		style.setFont(font);
		XSSFCell cell = dateRow.createCell(1);
		cell.setCellStyle(style);
    	cell.setCellValue("Date: " + dateFormat.format(new Date()));
		
    	XSSFCellStyle style1 = getTopBorderStyle(wb);
    	XSSFCellStyle style2 = getRightTopBorderStyle(wb);
    	for(int i=2;i<=MAX_ColUMN;i++){
    		XSSFCell cell1 = dateRow.createCell(i);
    		if(i!=MAX_ColUMN){
    			cell1.setCellStyle(style1);
    		}else{
    			cell1.setCellStyle(style2);
    		}
    	}
    	//mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
    	index++;
    	return index;
	}
	
    private static int createClientRow(XSSFSheet sheet, XSSFWorkbook wb, int index,  XSSFFont font, Proposal proposal){
		
    	XSSFRow clientRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBorderStyle(wb);
		_log.info("clientrow at ->" + index);
		String clientTitle = StringPool.BLANK;
		try {
			Client client = ClientLocalServiceUtil.getClient(proposal.getClient());
			clientTitle = client.getClientName();
		} catch (PortalException e) {
			_log.error(e);
		}
		XSSFCell cell = clientRow.createCell(MIN_COLUMN);
		cell.setCellStyle(style);
		style.setFont(font);
    	cell.setCellValue("Client: " + clientTitle);
		
    	//mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
    	index++;
    	return index;
	}
    
    private static int createCampaignRow(XSSFSheet sheet, XSSFWorkbook wb,  int index,  XSSFFont font,Proposal proposal){
    	XSSFRow campaignRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftBottomBorderStyle(wb);
		style.setFont(font);
		
		XSSFCell cell = campaignRow.createCell(MIN_COLUMN);
		cell.setCellStyle(style);
    	cell.setCellValue("Campaign: " + proposal.getCampaignTitle());
		
    	XSSFCellStyle style1 = getBottomBorderStyle(wb);
    	XSSFCellStyle style2 = getRightBottomBorderStyle(wb);
    	
    	for(int i=2;i<=MAX_ColUMN;i++){
    		XSSFCell cell1 = campaignRow.createCell(i);
    		if(i!=MAX_ColUMN){
    			cell1.setCellStyle(style1);
    		}else{
    			cell1.setCellStyle(style2);
    		}
    	}
    	mergedRegion(index,index, MIN_COLUMN, MAX_ColUMN, sheet);
    	index++;
    	return index;
	}
    
    private static int createTableHeader(XSSFSheet sheet, XSSFWorkbook wb, int index){
		XSSFRow headerRow = sheet.createRow(index);
		headerRow.setHeight((short)300);
		XSSFCellStyle style = getAllBorderStyle(wb);
		XSSFFont font = wb.createFont();
	    font.setFontHeightInPoints((short) 12);
	    font.setBold(true);
	    font.setFontName("Arial");
	    style.setFont(font);
	    style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		
		XSSFCell cell1 = headerRow.createCell(MIN_COLUMN);
		cell1.setCellStyle(style);
    	cell1.setCellValue("Sr");
    	
    	XSSFCell cell2 = headerRow.createCell(2);
    	cell2.setCellStyle(style);
    	cell2.setCellValue("State");
    	
    	XSSFCell cell3 = headerRow.createCell(3);
		cell3.setCellStyle(style);
    	cell3.setCellValue("District");
    	
    	XSSFCell cell4 = headerRow.createCell(4);
		cell4.setCellStyle(style);
    	cell4.setCellValue("Town");
    	
    	XSSFCell cell5 = headerRow.createCell(5);
		cell5.setCellStyle(style);
    	cell5.setCellValue("Media Location");
    	
    	XSSFCell cell6 = headerRow.createCell(6);
		cell6.setCellStyle(style);
    	cell6.setCellValue("Media Vehicle");
    	
    	
    	XSSFCell cell7 = headerRow.createCell(7);
		cell7.setCellStyle(style);
    	cell7.setCellValue("Media Type");
    	
    	XSSFCell cell8 = headerRow.createCell(8);
		cell8.setCellStyle(style);
    	cell8.setCellValue("Width");
    	
    	XSSFCell cell9 = headerRow.createCell(9);
		cell9.setCellStyle(style);
    	cell9.setCellValue("Height");
    	
    	XSSFCell cell10 = headerRow.createCell(10);
		cell10.setCellStyle(style);
    	cell10.setCellValue("Units");
    	
    	XSSFCell cell11 = headerRow.createCell(11);
		cell11.setCellStyle(style);
    	cell11.setCellValue("Total sq.ft of display");
    	
    	XSSFCell cell12 = headerRow.createCell(12);
		cell12.setCellStyle(style);
    	cell12.setCellValue("Display Charges/month");
    	
    	XSSFCell cell13 = headerRow.createCell(13);
		cell13.setCellStyle(style);
    	cell13.setCellValue("Duration of display (days)");
    	
    	XSSFCell cell14 = headerRow.createCell(14);
		cell14.setCellStyle(style);
    	cell14.setCellValue("Display Charges as per duration");
    	
    	XSSFCell cell15 = headerRow.createCell(15);
		cell15.setCellStyle(style);
    	cell15.setCellValue("Mounting Charges");
    	
    	XSSFCell cell16 = headerRow.createCell(16);
		cell16.setCellStyle(style);
    	cell16.setCellValue("Printing Charges");
    	
    	XSSFCell cell17 = headerRow.createCell(17);
		cell17.setCellStyle(style);
    	cell17.setCellValue("Total Cost");
    	
    	index++;
		return index;

	}
    
    private static int createHoraingDetailRow(XSSFSheet sheet, int loopIndex, XSSFWorkbook wb, Hording hording, Proposal proposal, int index, int totalList, List<Double> hordingsTotalAmount){
		XSSFRow hordingRow = sheet.createRow(index);
		
		XSSFFont font = wb.createFont();
	    font.setFontName("Arial");

	    XSSFCellStyle commonStyle = wb.createCellStyle();
	    commonStyle.setFont(font);

		
	    XSSFCellStyle style = getRowStyle(hordingRow, wb);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFont(font);
		XSSFCell cell1 = hordingRow.createCell(MIN_COLUMN);
		cell1.setCellStyle(getLeftBorderStyle(wb));
    	cell1.setCellValue(loopIndex+1);
    	if(loopIndex==(totalList-1)){
			cell1.setCellStyle(getLeftBottomBorderStyle(wb));
		}else{
			cell1.setCellStyle(getLeftBorderStyle(wb));
		}
    	
    	// State
    	XSSFCellStyle style1 = getBottomBorderStyle(wb);
    	style1.setFont(font);
    	
    	XSSFCell cell2 = hordingRow.createCell(2);
    	cell2.setCellValue(hording.getState());
    	cell2.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell2.setCellStyle(style1);
		}
    	
    	//District
    	XSSFCell cell3 = hordingRow.createCell(3);
    	cell3.setCellValue(hording.getDistrict());
    	cell3.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell3.setCellStyle(style1);
		}
    	
    	// City
    	XSSFCell cell4 = hordingRow.createCell(4);
    	cell4.setCellValue(hording.getCity());
    	cell4.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell4.setCellStyle(style1);
		}
    	
    	
    	// Location
    	XSSFCell cell5 = hordingRow.createCell(5);
    	cell5.setCellValue(hording.getLocation());
    	cell5.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell5.setCellStyle(style1);
		}
    	
    	// Media vehicle
    	XSSFCell cell6 = hordingRow.createCell(6);
    	cell6.setCellValue(hording.getMediaVehicle());
    	cell6.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell6.setCellStyle(style1);
		}
    	
    	// Media Type
    	XSSFCell cell7 = hordingRow.createCell(7);
    	cell7.setCellValue(hording.getHordingType());
    	cell7.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell7.setCellStyle(style1);
		}
    	
    	
    	String[] heightWidthArray = SPHMSCommonLocalServiceUtil.getHeightOrWidth(hording.getSize());
    	
    	// Height
    	XSSFCell cell8 = hordingRow.createCell(8);
    	cell8.setCellValue(heightWidthArray[1]);
    	cell8.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell8.setCellStyle(style1);
		}
    	
    	// Width
    	XSSFCell cell9 = hordingRow.createCell(9);
    	cell9.setCellValue(heightWidthArray[0]);
    	cell9.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell9.setCellStyle(style1);
		}
    	
    	Proposal_Hording proposalHording = null;
    	try {
			proposalHording = getProposalHording(hording.getHordingId(), proposal.getProposalId());
		} catch (PortalException e) {
			_log.error(e);
		}
    	
    	// Units
    	XSSFCell cell10 = hordingRow.createCell(10);
    	int units = 0;
    	if(Validator.isNotNull(proposalHording)){
    		units = proposalHording.getUnits();
    	}
    	cell10.setCellValue(units);
    	cell10.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell10.setCellStyle(style1);
		}
    	
    	
    	// Sql Ft
    	int totalSqFt = SPHMSCommonLocalServiceUtil.getTotalSqFt(heightWidthArray);
    	XSSFCell cell11 = hordingRow.createCell(11);
    	cell11.setCellValue(totalSqFt);
    	cell11.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell11.setCellStyle(style1);
		}
    	
    	// PM price
    	XSSFCell cell12 = hordingRow.createCell(12);
    	cell12.setCellValue(hording.getPricePerMonth());
    	cell12.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell12.setCellStyle(style1);
		}
    	
    	// Day Durations
    	long displayDurationDays = SPHMSCommonLocalServiceUtil.getDisplayDuration(proposal.getStartDate(), proposal.getEndDate());
    	String displayDurationDaysString = SPHMSCommonLocalServiceUtil.getDateTimeDiff(proposal.getStartDate(), proposal.getEndDate());
    	XSSFCell cell13 = hordingRow.createCell(13);
    	cell13.setCellValue(displayDurationDaysString);
    	cell13.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell13.setCellStyle(style1);
		}
    	
    	// Display Charges
    	double displayCharges = SPHMSCommonLocalServiceUtil.getDisplayCharges(hording.getPricePerMonth(), displayDurationDays); 
    	XSSFCell cell14 = hordingRow.createCell(14);
    	cell14.setCellValue(displayCharges);
    	cell14.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell14.setCellStyle(style1);
		}
    	
    	// Mounting Charges
    	double mountingCharges = getMountingCharges(totalSqFt, proposalHording);
    	XSSFCell cell15 = hordingRow.createCell(15);
    	cell15.setCellValue(mountingCharges);
    	cell15.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell15.setCellStyle(style1);
		}
    	

    	// Printing Chrges
    	double printingCharges = getPrintingCharges(totalSqFt, proposalHording);
    	XSSFCell cell16 = hordingRow.createCell(16);
    	cell16.setCellValue(printingCharges);
    	cell16.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
			cell16.setCellStyle(style1);
		}

    	// Total Cost
    	XSSFCell cell17 = hordingRow.createCell(17);
    	cell17.setCellValue(displayCharges+mountingCharges+printingCharges);
    	cell17.setCellStyle(commonStyle);
    	if(loopIndex==(totalList-1)){
    		XSSFCellStyle style3 = getRightBottomBorderStyle(wb);
    		style3.setFont(font);
			cell17.setCellStyle(style3);
		}else{
			XSSFCellStyle style3 = getRightBorderStyle(wb);
    		style3.setFont(font);
			cell17.setCellStyle(style3);
		}
    	
    	hordingsTotalAmount.add(displayCharges+mountingCharges+printingCharges);

    	index++;
    	return index;
	}
    
    
    private static int createTotalAmountRow(XSSFSheet sheet, int index, XSSFWorkbook wb, XSSFFont font,List<Double> hordingsTotalAmountList ){
		XSSFRow totalAmountRow = sheet.createRow(index);
		totalAmountRow.setHeight((short)300);
		XSSFCellStyle style = getLeftBottomBorderStyle(wb);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		for(int i=1;i<MAX_ColUMN-2;i++){
			XSSFCell cell1 = totalAmountRow.createCell(i);
			if(i==1){
				cell1.setCellStyle(style);
			}else{
				cell1.setCellStyle(getBottomBorderStyle(wb));
			}
		}
		
		XSSFCell secondLastCell = totalAmountRow.createCell(MAX_ColUMN-1);
    	XSSFCellStyle allStyle = getAllBorderStyle(wb);
    	allStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    	allStyle.setAlignment(HorizontalAlignment.CENTER);
    	allStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    	allStyle.setFont(font);
    	secondLastCell.setCellStyle(allStyle);
    	secondLastCell.setCellValue("Total");
    	
    	XSSFCellStyle style2 = getRightBottomBorderStyle(wb);
    	style2.setFont(font);
    	style2.setAlignment(HorizontalAlignment.LEFT);
    	style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style2.setVerticalAlignment(VerticalAlignment.CENTER);
    	XSSFCell lastCell = totalAmountRow.createCell(MAX_ColUMN);
    	lastCell.setCellStyle(style2);
    	lastCell.setCellValue(getTotalAmount(hordingsTotalAmountList));
		
    	mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN-2, sheet);
    	
		index++;
		return index;
	}
    
    private static void createFooterText(XSSFSheet sheet, int index, XSSFWorkbook wb, XSSFFont font){

		// Notes ::
		XSSFRow footerRow = sheet.createRow(index);
		XSSFCellStyle style = getLeftTopBorderStyle(wb);
		style.setFont(font);
		XSSFCell cell = footerRow.createCell(1);
		cell.setCellStyle(style);
    	cell.setCellValue("Notes:");
		
    	XSSFCellStyle style1 = getTopBorderStyle(wb);
    	XSSFCellStyle style2 = getRightTopBorderStyle(wb);
    	for(int i=2;i<=MAX_ColUMN;i++){
    		XSSFCell cell1 = footerRow.createCell(i);
    		if(i!=MAX_ColUMN){
    			cell1.setCellStyle(style1);
    		}else{
    			cell1.setCellStyle(style2);
    		}
    	}
    	mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
    	index++;
    
    	
		// Notes2
		XSSFRow footerRow2 =  sheet.createRow(index);
		XSSFCellStyle style3 = getLeftBorderStyle(wb);
		style3.setFont(font);
		XSSFCell cell21 = footerRow2.createCell(MIN_COLUMN);
		cell21.setCellStyle(style3);
    	cell21.setCellValue("*All the above proposed media is subject to availability at the time of written confirmation.");
    	
    	XSSFCell cell22 = footerRow2.createCell(MAX_ColUMN);
		cell22.setCellStyle(getRightBorderStyle(wb));
		
		mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
    	index++;
		
    	
    	// Note3
		XSSFRow footerRow3 = sheet.createRow(index);
		
		XSSFCellStyle style4 = getLeftBottomBorderStyle(wb);
		XSSFCell cell31 = footerRow3.createCell(MIN_COLUMN);
		style4.setFont(font);
		cell31.setCellStyle(style4);
		cell31.setCellValue("*Government taxes (GST) will be charged extra.");
    	
		XSSFCellStyle style5 = getBottomBorderStyle(wb);
    	XSSFCellStyle style6 = getRightBottomBorderStyle(wb);
    	for(int i=2;i<=MAX_ColUMN;i++){
    		XSSFCell cell1 = footerRow3.createCell(i);
    		if(i!=MAX_ColUMN){
    			cell1.setCellStyle(style5);
    		}else{
    			cell1.setCellStyle(style6);
    		}
    	}
    	mergedRegion(index, index, MIN_COLUMN, MAX_ColUMN, sheet);
    	
    	
    	index++;	
		
	}

	private static double getMountingCharges(int totalSq, Proposal_Hording moutingCharges){
		if(Validator.isNotNull(moutingCharges)){
			return totalSq*moutingCharges.getMountingCharge();
		}else{
			return 0;
		}
	}
	
	private static double getPrintingCharges(int totalSq, Proposal_Hording printingCharges){
		if(Validator.isNotNull(printingCharges)){
			return totalSq*printingCharges.getPrintingCharge();
		}else{
			return 0;
		}
	}
	
	private static Proposal_Hording getProposalHording(long hordingId, long proposalId) throws PortalException{
		Proposal_HordingPK proposalHordingPK = new  Proposal_HordingPK(proposalId, hordingId);
		return Proposal_HordingLocalServiceUtil.getProposal_Hording(proposalHordingPK);
	}
	
	private static double getTotalAmount(List<Double> hordingsTotalAmountList){
		Double totalAmount=0d;
		for(Double hordingTotalAmount : hordingsTotalAmountList){
			totalAmount = totalAmount + hordingTotalAmount;
		}
		return  totalAmount;
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
		style.setBorderRight(BorderStyle.MEDIUM);
		style.setBorderBottom(BorderStyle.MEDIUM);
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
	
}
