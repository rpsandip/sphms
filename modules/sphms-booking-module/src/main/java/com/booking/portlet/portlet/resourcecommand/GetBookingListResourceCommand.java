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

import org.apache.xmlbeans.impl.tool.Extension.Param;
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
import com.sphms.common.service.util.BookingStatus;

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
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		int start = Integer.parseInt(httpRequest.getParameter("start"));
		int length = Integer.parseInt(httpRequest.getParameter("length"));
		long clientId = ParamUtil.getLong(resourceRequest, "searchclient");
		long customCompanyId = ParamUtil.getLong(resourceRequest, "customCompany");
		String startDateStr = ParamUtil.getString(resourceRequest, "searchStartDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "searchEndDate");
		String statusStr = ParamUtil.getString(resourceRequest, "status");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		Date startDate = null;
		Date endDate = null;
		int status=-1;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if(Validator.isNotNull(startDateStr) && Validator.isNotNull(endDateStr)){
			try {
				startDate = dateFormat.parse(startDateStr);
				endDate = dateFormat.parse(endDateStr);
			} catch (ParseException e) {
				_log.error(e);
			}
			
		}
		if(Validator.isNotNull(statusStr)){
			status = Integer.parseInt(statusStr);
		}
		
		List<Booking> proposalList = BookingLocalServiceUtil.getBookingList(customCompanyId,clientId, startDate, endDate, start, start+length, status);
		long totalProposalList = BookingLocalServiceUtil.getBookingCount(customCompanyId, clientId, startDate, endDate, status);
		for(Booking booking : proposalList){
			JSONObject bookingObj = JSONFactoryUtil.createJSONObject();
			bookingObj.put("campaign", booking.getCampaignTitle());
			String clienTitle = StringPool.BLANK;
			try {
				Client client = ClientLocalServiceUtil.getClient(booking.getClient());
				clienTitle = client.getClientName();
			} catch (PortalException e) {
				_log.error(e);
			}
			bookingObj.put("campaign", booking.getCampaignTitle());
			bookingObj.put("client", clienTitle);
			bookingObj.put("bookingId",  booking.getBookingId());
			bookingObj.put("startDate", df.format(booking.getStartDate()));
			bookingObj.put("endDate", df.format(booking.getEndDate()));
			bookingObj.put("status", BookingStatus.findByValue(booking.getStatus()).getLabel());
			
			dataArray.put(bookingObj);
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
