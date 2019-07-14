package com.report.portlet.portlet;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.report.portlet.constants.SphmsReportModulePortletKeys;
import com.report.portlet.portlet.util.OutStandingReportUtil;
import com.sphms.common.service.service.BillingLocalServiceUtil;

@Component(
	    property = {
	    		"javax.portlet.name="+SphmsReportModulePortletKeys.SphmsReportModule,
	        "mvc.command.name=/getOutstandingReport"
	    },
	    service = MVCResourceCommand.class
	)
public class GetOutStandingResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetOutStandingResourceCommand.class.getName());
	
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		
		long customComanyId = ParamUtil.getLong(resourceRequest, "customCompany");
		long clientId = ParamUtil.getLong(resourceRequest, "client");
		int status = ParamUtil.getInteger(resourceRequest, "status");
		String startDateStr = ParamUtil.getString(resourceRequest, "startDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "endDate");
		boolean isExportReport = ParamUtil.getBoolean(resourceRequest, "isExport"); 
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		
		Date startDate =null;
		Date endDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if(Validator.isNotNull(startDateStr) && Validator.isNotNull(endDateStr)){
		
			try {
				 startDate = dateFormat.parse(startDateStr);
				 endDate = dateFormat.parse(endDateStr);
				 Calendar c = Calendar.getInstance(); 
				 c.setTime(endDate); 
				 c.add(Calendar.DATE, 1);
				 endDate = c.getTime();
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		
		JSONObject billingDetail = BillingLocalServiceUtil.getBillingListForReport(customComanyId, clientId, status, startDate, endDate);
		
		if(!isExportReport){	
			responseObj.put("aaData", billingDetail.getJSONArray("bills"));
			responseObj.put("iTotalRecords", billingDetail.length());
			responseObj.put("iTotalDisplayRecords", billingDetail.length());
			    
			 try {
					resourceResponse.getWriter().write(responseObj.toString());
				} catch (IOException e) {
					_log.error(e.getMessage(), e);
				}
		}else{
			try {
				File file = OutStandingReportUtil.createOutStandingReport(customComanyId, clientId, status, startDate, endDate);
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
			}
		}
		return true;
	}
	
}
