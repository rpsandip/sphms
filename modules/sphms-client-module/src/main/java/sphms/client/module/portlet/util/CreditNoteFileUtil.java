package sphms.client.module.portlet.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CreditNote;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.CreditNoteLocalServiceUtil;
import com.sphms.common.service.util.SPHMSConstant;

public class CreditNoteFileUtil {
	
	private static Log _log = LogFactoryUtil.getLog(CreditNoteFileUtil.class.getName());
	
	public static File createCreditNoteFile(long creditNoteId, long clientId, long billingId) throws IOException{
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();
		
		XSSFFont boldFont = wb.createFont();
		boldFont.setFontHeightInPoints((short) 14);
		boldFont.setBold(true);
		boldFont.setFontName("Arial");
		
		XSSFFont normalFont = wb.createFont();
		boldFont.setFontHeightInPoints((short) 12);
		boldFont.setFontName("Arial");
		
		
		CreditNote creditNote = null;
		Billing billing = null;
		Client client = null;
		if(creditNoteId>0){
			try {
				 creditNote = CreditNoteLocalServiceUtil.getCreditNote(creditNoteId);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}
		
		if(clientId>0){
			try {
				client = ClientLocalServiceUtil.getClient(clientId);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}
		
		if(billingId>0){
			try {
				billing = BillingLocalServiceUtil.getBilling(billingId);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}
		
		if(Validator.isNotNull(creditNote) && Validator.isNotNull(client) && Validator.isNotNull(billing)){
			int index=0;
			index = createMainHeaderRow(sheet, wb, boldFont, index);
			index = createDataRow(sheet, wb, normalFont, creditNote, billing, client, index);
		}
		
		
		// Write the output to a file
 		String fileName = "credit_note.xlsx";
 		File file = new File(System.getProperty("catalina.home")+"/temp/"+fileName);
 		
 		FileOutputStream fileOut = new FileOutputStream(file);
 		wb.write(fileOut);
 		fileOut.close();
 		
 		return file; 
   }
	
	private static int createMainHeaderRow(XSSFSheet sheet, XSSFWorkbook wb, XSSFFont boldFont,int index){
		
		XSSFRow headerRow = sheet.createRow(index);	
		XSSFCellStyle style = wb.createCellStyle();
		style.setFont(boldFont);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		
		XSSFCell cell1=  headerRow.createCell(1);
		cell1.setCellValue("Credit Note Number");
		cell1.setCellStyle(style);
		
		XSSFCell cell2=  headerRow.createCell(2);
		cell2.setCellValue("Bill No");
		cell2.setCellStyle(style);
		
		XSSFCell cell3=  headerRow.createCell(3);
		cell3.setCellValue("Client Name");
		cell3.setCellStyle(style);
		
		XSSFCell cell4=  headerRow.createCell(4);
		cell4.setCellValue("Credit Amount");
		cell4.setCellStyle(style);
		
		
		XSSFCell cell5=  headerRow.createCell(5);
		cell5.setCellValue("Credit Tax");
		cell5.setCellStyle(style);
		
		XSSFCell cell6=  headerRow.createCell(6);
		cell6.setCellValue("Finance Year");
		cell6.setCellStyle(style);
		
		index++;
		return index;
	}	
	
	private static int createDataRow(XSSFSheet sheet, XSSFWorkbook wb, XSSFFont normalFont, CreditNote creditNote, Billing billing, Client client,int index){
		
		XSSFRow dataRow = sheet.createRow(index);
		XSSFCellStyle style = wb.createCellStyle();
		style.setFont(normalFont);
		
		XSSFCell cell1=  dataRow.createCell(1);
		cell1.setCellValue(SPHMSConstant.CREDIT_NOTE_PREFIX+StringPool.DASH+creditNote.getCreditNoteNumber()+StringPool.FORWARD_SLASH
				+ creditNote.getFinancialYear());
		cell1.setCellStyle(style);
		
		XSSFCell cell2=  dataRow.createCell(2);
		cell2.setCellValue(billing.getBillNo());
		cell2.setCellStyle(style);
		
		XSSFCell cell3=  dataRow.createCell(3);
		cell3.setCellValue(client.getClientName());
		cell3.setCellStyle(style);
		
		XSSFCell cell4=  dataRow.createCell(4);
		cell4.setCellValue(creditNote.getCreditNoteAmount());
		cell4.setCellStyle(style);
		
		
		XSSFCell cell5=  dataRow.createCell(5);
		cell5.setCellValue(creditNote.getCreditNoteTax());
		cell5.setCellStyle(style);
		
		XSSFCell cell6=  dataRow.createCell(6);
		cell6.setCellValue(creditNote.getFinancialYear());
		cell6.setCellStyle(style);
		
		index++;
		return index;
	}
}
