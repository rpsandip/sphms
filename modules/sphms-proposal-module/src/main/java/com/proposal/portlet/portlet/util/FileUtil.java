package com.proposal.portlet.portlet.util;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.sl.usermodel.PictureData.PictureType;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
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
	
	public static FileEntry createProposalPPTFile(Proposal proposal, List<Hording> hordingList) throws FileNotFoundException, IOException, PortalException{
		long globalSiteGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		FileEntry fileEntry = null;
		if(globalSiteGroupId!=0){
			Folder proposalFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, String.valueOf(proposal.getProposalId()));
			if(Validator.isNotNull(proposalFolder)){
				File pptFile = createPPTFile(hordingList, proposal);
				ServiceContext serviceContext = new ServiceContext(); 
				 try{
					 fileEntry = DLAppServiceUtil.addFileEntry(globalSiteGroupId, proposalFolder.getFolderId(),  pptFile.getName(), MimeTypesUtil.getContentType(pptFile),  pptFile.getName(), StringPool.BLANK , StringPool.BLANK, pptFile, serviceContext);
				 }catch(DuplicateFileEntryException e){
					 String fileName = proposal.getCampaignTitle()+StringPool.UNDERLINE+  new Date().getTime() + ".pptx";
					 fileEntry = DLAppServiceUtil.addFileEntry(globalSiteGroupId, proposalFolder.getFolderId(), fileName, MimeTypesUtil.getContentType(pptFile), fileName, "Patient Invoice", "", pptFile, serviceContext);
				 }
			}
		}
		return fileEntry;
	}
	
	public static FileEntry createProposalXlsxFile(Proposal proposal, List<Hording> hordingList) throws FileNotFoundException, IOException, PortalException{
		FileEntry fileEntry = null;
		long globalSiteGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		if(globalSiteGroupId!=0){
			Folder proposalFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, String.valueOf(proposal.getProposalId()));
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
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("Proposal");
		
		//createBlankRow(sheet,0);
		
		createDateRow(sheet, wb);
		
		createClientRow(sheet,wb, proposal);
		
		createCampaignRow(sheet,wb, proposal);
		
		createTableHeader(sheet,wb);
		
		for(int i=0;i<hordingList.size();i++){
			createHoraingDetailRow(sheet, i+5,wb, hordingList.get(i),proposal);
		}
		
		//createBlankRow(sheet,9);
		
		createFooterText(sheet, 6+hordingList.size(),wb);
		
		CellRangeAddress cellRnage = new CellRangeAddress(0, 0, 1, 16);
		sheet.addMergedRegion(cellRnage);
		
		cellRnage = new CellRangeAddress(0, 8+hordingList.size(), 0, 0);
		sheet.addMergedRegion(cellRnage);
		
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
	
	private static void createDateRow(XSSFSheet sheet, XSSFWorkbook wb){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		XSSFRow dateRow = sheet.createRow(1);
		XSSFCellStyle style = getRowStyle(dateRow, wb);
		
		dateRow.createCell(0).setCellValue("");
		
		XSSFCell cell = dateRow.createCell(1);
		cell.setCellStyle(style);
    	cell.setCellValue("Date: " + dateFormat.format(new Date()));
		
		CellRangeAddress cellRnage = new CellRangeAddress(1, 1, 1, 19);
		sheet.addMergedRegion(cellRnage);
	}
	
    private static void createClientRow(XSSFSheet sheet, XSSFWorkbook wb, Proposal proposal){
		
		XSSFRow clientRow = sheet.createRow(2);
		XSSFCellStyle style = getRowStyle(clientRow, wb);
		
		clientRow.createCell(0).setCellValue("");
		
		String clientTitle = StringPool.BLANK;
		try {
			Client client = ClientLocalServiceUtil.getClient(proposal.getClient());
			clientTitle = client.getClientName();
		} catch (PortalException e) {
			_log.error(e);
		}
		
		XSSFCell cell = clientRow.createCell(1);
		cell.setCellStyle(style);
    	cell.setCellValue("Client: " + clientTitle);
		
		CellRangeAddress cellRnage = new CellRangeAddress(2, 2, 1, 19);
		sheet.addMergedRegion(cellRnage);
	}
    
    private static void createCampaignRow(XSSFSheet sheet, XSSFWorkbook wb, Proposal proposal){
		XSSFRow campaignRow = sheet.createRow(3);
		XSSFCellStyle style = getRowStyle(campaignRow, wb);
		
		campaignRow.createCell(0).setCellValue("");
		
		XSSFCell cell = campaignRow.createCell(1);
		cell.setCellStyle(style);
    	cell.setCellValue("Campaign: " + proposal.getCampaignTitle());
		
		CellRangeAddress cellRnage = new CellRangeAddress(3, 3, 1, 19);
		sheet.addMergedRegion(cellRnage);
	}
    
    private static void createTableHeader(XSSFSheet sheet, XSSFWorkbook wb){
		XSSFRow headerRow = sheet.createRow(4);
		
		XSSFCellStyle style = getRowStyle(headerRow, wb);
		
		headerRow.createCell(0).setCellValue("");
		
		XSSFCell cell1 = headerRow.createCell(1);
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

	}
    
    private static void createHoraingDetailRow(XSSFSheet sheet, int rowIndex, XSSFWorkbook wb, Hording hording, Proposal proposal){
		XSSFRow hordingRow = sheet.createRow(rowIndex);
		hordingRow.createCell(0).setCellValue("");
		
		XSSFCellStyle style = getRowStyle(hordingRow, wb);
		
		XSSFCell cell1 = hordingRow.createCell(1);
		cell1.setCellStyle(style);
    	cell1.setCellValue(rowIndex-5);
    	
    	// State
    	XSSFCell cell2 = hordingRow.createCell(2);
    	cell2.setCellValue(hording.getState());
    	
    	XSSFCell cell3 = hordingRow.createCell(3);
    	cell3.setCellValue(hording.getDistrict());
    	
    	// City
    	XSSFCell cell4 = hordingRow.createCell(4);
    	cell4.setCellValue(hording.getCity());
    	
    	// Location
    	XSSFCell cell5 = hordingRow.createCell(5);
    	cell5.setCellValue(hording.getLocation());
    	
    	XSSFCell cell6 = hordingRow.createCell(6);
    	cell6.setCellValue(hording.getMediaVehicle());
    	
    	// Media Type
    	XSSFCell cell7 = hordingRow.createCell(7);
    	cell7.setCellValue(hording.getHordingType());
    	
    	String[] heightWidthArray = getHeightOrWidth(hording.getSize());
    	
    	// Height
    	XSSFCell cell8 = hordingRow.createCell(8);
    	cell8.setCellValue(heightWidthArray[0]);
    	
    	// Width
    	XSSFCell cell9 = hordingRow.createCell(9);
    	cell9.setCellValue(heightWidthArray[1]);
    	
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
    	
    	// Sql Ft
    	int totalSqFt = getTotalSqFt(heightWidthArray);
    	XSSFCell cell11 = hordingRow.createCell(11);
    	cell11.setCellValue(totalSqFt);
    	
    	// PM price
    	XSSFCell cell12 = hordingRow.createCell(12);
    	cell12.setCellValue(hording.getPricePerMonth());
    	
    	// Day Durations
    	long displayDurationDays = getDisplayDuration(proposal.getStartDate(), proposal.getEndDate());
    	XSSFCell cell13 = hordingRow.createCell(13);
    	cell13.setCellValue(displayDurationDays);
    	
    	// Display Charges
    	double displayCharges = getDisplayCharges(hording.getPricePerMonth(), displayDurationDays); 
    	XSSFCell cell14 = hordingRow.createCell(14);
    	cell14.setCellValue(displayCharges);
    	
    	// Mounting Charges
    	double mountingCharges = getMountingCharges(totalSqFt, proposalHording);
    	XSSFCell cell15 = hordingRow.createCell(15);
    	cell15.setCellValue(mountingCharges);

    	// Printing Chrges
    	double printingCharges = getPrintingCharges(totalSqFt, proposalHording);
    	XSSFCell cell16 = hordingRow.createCell(16);
    	cell16.setCellValue(printingCharges);

    	// Total Cost
    	XSSFCell cell17 = hordingRow.createCell(17);
    	cell17.setCellValue(displayCharges+mountingCharges+printingCharges);

		
	}
    
    
private static void createFooterText(XSSFSheet sheet, int rowIndex, XSSFWorkbook wb){
		
		XSSFRow footerRow = sheet.createRow(rowIndex);
		
		XSSFCellStyle style = getRowStyle(footerRow, wb);
		
		footerRow.createCell(0).setCellValue("");
		
		XSSFCell cell11 = footerRow.createCell(1);
		cell11.setCellStyle(style);
    	cell11.setCellValue("Notes:");
		
		CellRangeAddress cellRnage = new CellRangeAddress(rowIndex, rowIndex, 1, 19);
		sheet.addMergedRegion(cellRnage);
		
		XSSFRow footerRow2 =  sheet.createRow(rowIndex+1);
		footerRow2.createCell(0).setCellValue("");
		
		XSSFCell cell21 = footerRow2.createCell(1);
		cell21.setCellStyle(style);
    	cell21.setCellValue("*All the above proposed media is subject to availability at the time of written confirmation.");
		
		cellRnage = new CellRangeAddress(rowIndex+1, rowIndex+1, 1, 19);
		sheet.addMergedRegion(cellRnage);
		
		XSSFRow footerRow3 = sheet.createRow(rowIndex+2);
		footerRow3.createCell(0).setCellValue("");
		
		XSSFCell cell31 = footerRow3.createCell(1);
		cell31.setCellStyle(style);
		cell31.setCellValue("*Government taxes (GST) will be charged extra.");
		
		cellRnage = new CellRangeAddress(rowIndex+2, rowIndex+2, 1, 19);
		sheet.addMergedRegion(cellRnage);
		
	}

	private  static XSSFCellStyle getRowStyle(XSSFRow row, XSSFWorkbook wb){
		
		 //Create a new font and alter it.
	     XSSFFont font = wb.createFont();
	     font.setFontHeightInPoints((short) 11);
	     font.setBold(true);
	     
	     //Set font into style
	     XSSFCellStyle style = wb.createCellStyle();
	     style.setFont(font);
	     
	    return style;
	}
	
	private static String[] getHeightOrWidth(String size){
		String[] sizeArray = new String[2];
		if(size.indexOf("X")>0){
			 sizeArray = size.split("X");
		}
		return sizeArray;
	}
	
	private static int getTotalSqFt(String[] heigthWidthArray){
		int height = Integer.parseInt(heigthWidthArray[0]);
		int width  = Integer.parseInt(heigthWidthArray[1]);
		return height*width;
	}
	
	private static long getDisplayDuration(Date startDate, Date endDate){
	    long diff = endDate.getTime() - startDate.getTime();
	    // Need to add 1 days because for same start and end date below equiation gives 0 and we have to consider 
	    // as 1. Same for other dates.
	    return (diff / (1000*60*60*24))+1;
	}
	
	private static double getDisplayCharges(double pricePerMonth, long displayDurationDays){
		// Considering month days are 30.
		return (pricePerMonth/30)*displayDurationDays;
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
	
}
