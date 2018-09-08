package com.report.portlet.portlet;



import java.io.IOException;
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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.report.portlet.constants.SphmsReportModulePortletKeys;
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
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
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
				proposalJsonObj.put("landLoadchequeNo", detailObj[6]);
				proposalJsonObj.put("landLoadbankName", detailObj[7]);
				proposalJsonObj.put("hordingtitle", detailObj[8]);
				proposalJsonObj.put("hordinglocation", detailObj[9]);
				proposalJsonObj.put("hordingcity", detailObj[10]);
				dataArray.put(proposalJsonObj);
		}
		responseObj.put("aaData", dataArray);
		responseObj.put("iTotalRecords", dataArray.length());
		responseObj.put("iTotalDisplayRecords", dataArray.length());
		    
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		    
		return true;
	}

}
