package com.report.portlet.portlet.resourceCommand;

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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.report.portlet.constants.SphmsReportModulePortletKeys;
import com.report.portlet.portlet.util.LandLoadReportUtil;

@Component(
	    property = {
	    		"javax.portlet.name="+SphmsReportModulePortletKeys.SphmsReportModule,
	        "mvc.command.name=/generate-landLoadReport"
	    },
	    service = MVCResourceCommand.class
	)
public class GenerateLandLoadReportResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GenerateLandLoadReportResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
				long landLoadId = ParamUtil.getLong(resourceRequest, "landLoadId");
				String startDateStr = ParamUtil.getString(resourceRequest, "startDate");
				String endDateStr = ParamUtil.getString(resourceRequest, "endDate");
				Date startDate = null;
				Date endDate = null;
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				if(Validator.isNotNull(startDateStr) && Validator.isNotNull(endDateStr)){
					try {
						startDate = dateFormat.parse(startDateStr);
						endDate = dateFormat.parse(endDateStr);
					} catch (ParseException e) {
						_log.error(e);
					}
				}
				if(Validator.isNull(startDateStr)){
					Calendar previousYearDate = Calendar.getInstance();
					previousYearDate.setTime(new Date());
					previousYearDate.add(Calendar.YEAR, -1);
					Date date=previousYearDate.getTime();
					try {
						startDate = dateFormat.parse(dateFormat.format(date));
					} catch (ParseException e) {
						_log.error(e);
					}
				}
				if(Validator.isNull(endDate)){
					try {
						endDate= dateFormat.parse(dateFormat.format(new Date()));
					} catch (ParseException e) {
						_log.error(e);
					}
				}
			
				try {
				File file = LandLoadReportUtil.createLandLoadReport(landLoadId, startDate, endDate);
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
	
		
		return true;
	}

}
