package com.report.portlet.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.report.portlet.constants.SphmsReportModulePortletKeys;
import com.report.portlet.portlet.util.GSTReportUtil;
import com.report.portlet.portlet.util.OutStandingClientReportUtil;
import com.sphms.common.service.service.BillingLocalServiceUtil;

@Component(property = { "javax.portlet.name=" + SphmsReportModulePortletKeys.SphmsReportModule,
"mvc.command.name=/getGSTReport" }, service = MVCResourceCommand.class)
public class GetGSTReportResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetGSTReportResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		long customComanyId = ParamUtil.getLong(resourceRequest, "customCompany");
		String startDateStr = ParamUtil.getString(resourceRequest, "startDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "endDate");
		
		if(Validator.isNotNull(startDateStr) && Validator.isNotNull(endDateStr)){
			
			DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
			DateFormat df1 = new SimpleDateFormat("yyyy-mm-dd");
			try {
				Date endDate = df.parse(endDateStr);
				Date startDae = df.parse(startDateStr);
				startDateStr = df1.format(startDae);
				endDateStr = df1.format(endDate);
				
			} catch (ParseException e) {
				_log.error(e);
			}
			
			startDateStr = startDateStr + " 00:00:00";
			endDateStr =  endDateStr + " 23:59:59";
			
		}
		
		try {
			File file = GSTReportUtil.createGSTReport(customComanyId, startDateStr, endDateStr);
			try {
	        	resourceResponse.setContentType("application/vnd.ms-excel");
	        	resourceResponse.addProperty(
	                    HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename="+ file.getName());

	            OutputStream pos = resourceResponse.getPortletOutputStream();
	            try {
	            	byte[] bytesArray = new byte[(int) file.length()];
	            	FileInputStream fis = new FileInputStream(file);
	            	fis.read(bytesArray); //read file into bytes[]
	            	fis.close();

	                pos.write(bytesArray);
	                pos.flush();
	                
	            } finally {
	                pos.close();
	            }
	        } catch(IOException e){
	        	_log.error(e);
	        }
			
		} catch (FileNotFoundException e) {
			_log.error(e.getMessage());
		} catch (IOException e) {
			_log.error(e.getMessage());
		} catch (PortalException e1) {
			_log.error(e1.getMessage());
		}
		
		return false;
	}

}
