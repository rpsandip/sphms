package com.proposal.portlet.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.proposal.portlet.portlet.util.ProposalPortletConstant;
import com.sphms.common.service.beans.HordingBean;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;

@Component(
	    property = {
	    		"javax.portlet.name="+ProposalPortletConstant.PORTLET_ID,
	        "mvc.command.name=/search_hording"
	    },
	    service = MVCResourceCommand.class
	)
public class SearchHordingResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(SearchHordingResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			 {
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		String keyword  = ParamUtil.get(resourceRequest, "keyword", StringPool.BLANK);
		String city = ParamUtil.get(resourceRequest, "city", StringPool.BLANK);
		int height = ParamUtil.getInteger(resourceRequest, "height");
		int width = ParamUtil.getInteger(resourceRequest, "width");
		String startDateStr = ParamUtil.getString(resourceRequest, "startDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "endDate");
		int start = Integer.parseInt(httpRequest.getParameter("start"));
		int length = Integer.parseInt(httpRequest.getParameter("length"));
		Date startDate = null;
		Date endDate = null;
		
		if(Validator.isNotNull(startDateStr) && Validator.isNotNull(endDateStr)){
			try {
				startDate = dateFormat.parse(startDateStr);
				endDate = dateFormat.parse(endDateStr);
			} catch (ParseException e) {
				_log.error(e);
			} 
		}
		
		List<HordingBean> hordingBeanList = SPHMSCommonLocalServiceUtil.searchHordings(keyword, city, height, width, startDate, endDate, start, start+length);
		
		_log.info("hordingBeanList->" + hordingBeanList.size());
		
		for(HordingBean hordingBean : hordingBeanList){
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONObject hordingDetailObj = JSONFactoryUtil.createJSONObject();
			
			hordingDetailObj.put("hordingId", hordingBean.getHordingId());
			hordingDetailObj.put("title", hordingBean.getTitle());
			hordingDetailObj.put("city", hordingBean.getCity());
			hordingDetailObj.put("pricePerMonth", hordingBean.getPricePerMonth());
			hordingDetailObj.put("hordingType", hordingBean.getHordingType());
			hordingDetailObj.put("size", hordingBean.getSize());
			hordingDetailObj.put("landLordName", hordingBean.getLandLordName());
			hordingDetailObj.put("normalImageURL", hordingBean.getNormalImageURL());
			
			jsonObject.put("hording", hordingDetailObj);
			dataArray.put(jsonObject);
		}
		
	    responseObj.put("iTotalRecords", hordingBeanList.size());
	    responseObj.put("iTotalDisplayRecords", hordingBeanList.size());
	    responseObj.put("aaData", dataArray);
	    
	    try {
			resourceResponse.getWriter().write(responseObj.toString());
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		}

	    return true;
	}


}
