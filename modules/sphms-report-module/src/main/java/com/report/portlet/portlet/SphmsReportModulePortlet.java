package com.report.portlet.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.report.portlet.constants.SphmsReportModulePortletKeys;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.service.SupplierLocalServiceUtil;

/**
 * @author ronakDhruv
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=sphms-report-module Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SphmsReportModulePortletKeys.SphmsReportModule,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SphmsReportModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<LandLord> landLoadList = LandLordLocalServiceUtil.getActiveLandLords(-1, -1);
		renderRequest.setAttribute("landLoadList", landLoadList);
		
		// get hording list
		List<Hording> hordingList = HordingLocalServiceUtil.getActiveHoringList(-1, -1);
		renderRequest.setAttribute("hordingList", hordingList);

		// get ClientList
		List<Client> clientList = ClientLocalServiceUtil.getClients();
		renderRequest.setAttribute("clientList", clientList);

		// Get Company List
		List<CustomCompany> companyList = CustomCompanyLocalServiceUtil.getCustomCompanies(-1, -1);
		renderRequest.setAttribute("companyList", companyList);
		
		List<Supplier> supplierList = SupplierLocalServiceUtil.getSuppliers();
		renderRequest.setAttribute("supplierList", supplierList);
		
		include(viewTemplate, renderRequest, renderResponse);
	}

}