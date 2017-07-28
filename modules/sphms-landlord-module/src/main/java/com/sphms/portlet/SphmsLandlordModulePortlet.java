package com.sphms.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.sphms.portlet.util.LandLoardPortletUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sphms",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=SPHMS Landlord Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SphmsLandlordModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// Get all LandLord
		renderRequest.setAttribute("landLordList", LandLoardPortletUtil.getAllActiveLandLord());
		include(viewTemplate, renderRequest, renderResponse);
	}
}