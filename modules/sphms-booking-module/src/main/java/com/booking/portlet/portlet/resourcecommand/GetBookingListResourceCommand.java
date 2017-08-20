package com.booking.portlet.portlet.resourcecommand;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.booking.portlet.portlet.util.BookingPortletConstant;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.ClientLocalServiceUtil;

@Component(
	    property = {
	    		"javax.portlet.name="+BookingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/getBookingList"
	    },
	    service = MVCResourceCommand.class
	)
public class GetBookingListResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		Log _log = LogFactoryUtil.getLog(GetBookingListResourceCommand.class.getName());
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		int start = Integer.parseInt(httpRequest.getParameter("start"));
		int length = Integer.parseInt(httpRequest.getParameter("length"));
		long clientId = ParamUtil.getLong(resourceRequest, "clientId");
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
		
		
		List<Booking> proposalList = BookingLocalServiceUtil.getBookingList(clientId, startDate, endDate, start, start+length);
		long totalProposalList = BookingLocalServiceUtil.getBookingCount(clientId, startDate, endDate);
		for(Booking booking : proposalList){
			JSONObject proposalJsonObj = JSONFactoryUtil.createJSONObject();
			proposalJsonObj.put("campaign", booking.getCampaignTitle());
			String clienTitle = StringPool.BLANK;
			try {
				Client client = ClientLocalServiceUtil.getClient(booking.getClient());
				clienTitle = client.getClientName();
			} catch (PortalException e) {
				_log.error(e);
			}
			proposalJsonObj.put("campaign", booking.getCampaignTitle());
			proposalJsonObj.put("client", clienTitle);
			proposalJsonObj.put("bookingId", booking.getBookingId());
			proposalJsonObj.put("startDate", booking.getStartDate());
			proposalJsonObj.put("endDate",booking.getEndDate());
			
			dataArray.put(proposalJsonObj);
		}
		
		
		 responseObj.put("iTotalRecords", totalProposalList);
		 responseObj.put("iTotalDisplayRecords", totalProposalList);
		 responseObj.put("aaData", dataArray);
		    
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		    
		return true;
	}

}
