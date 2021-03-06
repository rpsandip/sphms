package sphms.supplier.module.portlet;

import sphms.supplier.module.constants.SphmsSupplierModulePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author sandip
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.name=" + SphmsSupplierModulePortletKeys.SphmsSupplierModule,
		"javax.portlet.display-name=sphms-supplier-module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SphmsSupplierModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<LandLord> landLoadList = LandLordLocalServiceUtil.getActiveLandLords(-1, -1);
		renderRequest.setAttribute("landLoadList", landLoadList);
		
		// Get Company List
		List<CustomCompany> companyList = CustomCompanyLocalServiceUtil.getCustomCompanies(-1, -1);
		renderRequest.setAttribute("companyList", companyList);		
		
		include(viewTemplate, renderRequest, renderResponse);
	}
}