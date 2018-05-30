package com.sphms.portlet.portlet.resourceCommand;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.sphms.common.service.beans.BillingBean;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(
	    property = {
	    		"javax.portlet.name="+BillingConstant.PORTLET_ID,
	        "mvc.command.name=/getBillingList"
	    },
	    service = MVCResourceCommand.class
	)
public class GetBillingListResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		Log _log = LogFactoryUtil.getLog(GetBillingListResourceCommand.class.getName());
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		int start = Integer.parseInt(httpRequest.getParameter("start"));
		int length = Integer.parseInt(httpRequest.getParameter("length"));
		long clientId = ParamUtil.getLong(resourceRequest, "searchclient");
		String startDateStr = ParamUtil.getString(resourceRequest, "searchStartDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "searchEndDate");
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
		
		List<Billing> billingList = BillingLocalServiceUtil.getBillingList(clientId, startDate, endDate, start, start+length);
		long totalBillingList = BillingLocalServiceUtil.getBillingCount(clientId, startDate, endDate);
		
		for(Billing billing : billingList){
			JSONObject billingJsonObject = JSONFactoryUtil.createJSONObject();
			BillingBean billingBean = new BillingBean(billing);
			billingJsonObject.put("client", billingBean.getClientName());
			billingJsonObject.put("clientCity", billingBean.getClientCity());
			billingJsonObject.put("campaign", billingBean.getCampaign());
			billingJsonObject.put("financeYear", billingBean.getFinancialYear());
			billingJsonObject.put("billingId", billingBean.getBillingId());
			billingJsonObject.put("billDocumentURL", billingBean.getBillDocumentURL());
			billingJsonObject.put("bookingDate", dateFormat.format(billingBean.getBookingDate()));
			dataArray.put(billingJsonObject);
		}
		
		 responseObj.put("iTotalRecords", totalBillingList);
		 responseObj.put("iTotalDisplayRecords", totalBillingList);
		 responseObj.put("aaData", dataArray);
		    
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		
		return true;
	}

}
