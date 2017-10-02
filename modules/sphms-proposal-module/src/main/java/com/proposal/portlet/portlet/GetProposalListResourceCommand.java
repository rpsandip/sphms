package com.proposal.portlet.portlet;

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
import com.proposal.portlet.portlet.util.ProposalPortletConstant;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.ProposalLocalServiceUtil;

@Component(
	    property = {
	    		"javax.portlet.name="+ProposalPortletConstant.PORTLET_ID,
	        "mvc.command.name=/getProposalList"
	    },
	    service = MVCResourceCommand.class
	)
public class GetProposalListResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		Log _log = LogFactoryUtil.getLog(GetProposalListResourceCommand.class.getName());
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
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
		
		
		List<Proposal> proposalList = ProposalLocalServiceUtil.getProposalList(clientId, startDate, endDate, start, start+length);
		long totalProposalList = ProposalLocalServiceUtil.getProposalCount(clientId, startDate, endDate);
		for(Proposal proposal : proposalList){
			JSONObject proposalJsonObj = JSONFactoryUtil.createJSONObject();
			proposalJsonObj.put("campaign", proposal.getCampaignTitle());
			String clienTitle = StringPool.BLANK;
			try {
				Client client = ClientLocalServiceUtil.getClient(proposal.getClient());
				clienTitle = client.getClientName();
			} catch (PortalException e) {
				_log.error(e);
			}
			proposalJsonObj.put("campaign", proposal.getCampaignTitle());
			proposalJsonObj.put("client", clienTitle);
			proposalJsonObj.put("proposalId", proposal.getProposalId());
			proposalJsonObj.put("startDate", df.format(proposal.getStartDate()));
			proposalJsonObj.put("endDate", df.format(proposal.getEndDate()));
			
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
