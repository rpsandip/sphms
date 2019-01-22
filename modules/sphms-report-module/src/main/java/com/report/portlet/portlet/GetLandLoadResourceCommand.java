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
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.report.portlet.constants.SphmsReportModulePortletKeys;
import com.report.portlet.portlet.util.LandLoadReportUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;

@Component(
	    property = {
	    		"javax.portlet.name="+SphmsReportModulePortletKeys.SphmsReportModule,
	        "mvc.command.name=/getLandLoadReport"
	    },
	    service = MVCResourceCommand.class
	)
public class GetLandLoadResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		Log _log = LogFactoryUtil.getLog(GetLandLoadResourceCommand.class.getName());
		
		long landLoadId = ParamUtil.getLong(resourceRequest, "landLoadId");
		String startDateStr = ParamUtil.getString(resourceRequest, "startDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "endDate");
		boolean isExportReport = ParamUtil.getBoolean(resourceRequest, "isExport"); 
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		
		String startDate =null;
		String endDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		if(Validator.isNotNull(startDateStr) && Validator.isNotNull(endDateStr)){
		
			try {
				Date stDate = dateFormat.parse(startDateStr);
				Date edDate = dateFormat.parse(endDateStr);
				
				startDate = dateFormat2.format(stDate);
				endDate = dateFormat2.format(edDate);
				
				 Calendar c = Calendar.getInstance(); 
				 c.setTime(edDate); 
				 c.add(Calendar.DATE, 1);
				 edDate = c.getTime();
			} catch (ParseException e) {
				_log.error(e);
			}
		}
		
		
		List<Object> lanLoadDetail = LandLordLocalServiceUtil.getLandLoadFilter(landLoadId, startDate, endDate);
			for (Object row : lanLoadDetail) {
				Object[] detailObj = (Object[]) row;
				JSONObject proposalJsonObj = JSONFactoryUtil.createJSONObject();
				proposalJsonObj.put("landLoadfirstName", String.valueOf(detailObj[0]));
				proposalJsonObj.put("landLoadlastName", detailObj[1]);
				proposalJsonObj.put("landLoadlocation", detailObj[2]);
				proposalJsonObj.put("landLoadcity", detailObj[3]);
				proposalJsonObj.put("landLoadphoneNo",detailObj[4]);
				proposalJsonObj.put("landLoadamount", detailObj[5]);
				proposalJsonObj.put("hordingtitle", detailObj[8]);
				proposalJsonObj.put("hordinglocation", detailObj[9]);
				proposalJsonObj.put("hordingcity", detailObj[10]);
				DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
				Date date = null;
				try {
					date = inputFormat.parse(String.valueOf(detailObj[11]));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Format date into output format
				DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
				String outputString = outputFormat.format(date);
				proposalJsonObj.put("paymentDate", outputString);
				
				if(Validator.isNotNull(detailObj[6])){
					proposalJsonObj.put("paymenttype", "Cheque No: " + detailObj[6] + "(" + detailObj[7] + " )");
				}else{
					proposalJsonObj.put("paymenttype","Cash");
				}
				
				dataArray.put(proposalJsonObj);
		}
		
		if(!isExportReport){	
			responseObj.put("aaData", dataArray);
			responseObj.put("iTotalRecords", dataArray.length());
			responseObj.put("iTotalDisplayRecords", dataArray.length());
			    
			 try {
					resourceResponse.getWriter().write(responseObj.toString());
				} catch (IOException e) {
					_log.error(e.getMessage(), e);
				}
		}else{
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
		}
		return true;
	}

}
