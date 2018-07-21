package com.booking.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=sphms-booking-module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BookongModulePortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		
		HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String bookingStatus = httpServletRequest.getParameter("status");
		if(Validator.isNotNull(bookingStatus)){
			if(bookingStatus.equals("add-success")){
				SessionMessages.add(renderRequest, "booking-added-successfully");
			}else if(bookingStatus.equals("update-success")){
				SessionMessages.add(renderRequest, "booking-updated-successfully");
			}
		}
		
		// get ClientList
		List<Client> clientList = ClientLocalServiceUtil.getClients(-1, -1);
		renderRequest.setAttribute("clientList", clientList);
		
		//Get Company List
		List<CustomCompany> companyList = CustomCompanyLocalServiceUtil.getCustomCompanies(-1, -1);
		renderRequest.setAttribute("companyList", companyList);

		include(viewTemplate, renderRequest, renderResponse);
	}
}