package com.hording.portlet.portlet;

import com.hording.portlet.portlet.util.HordingPortletUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

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
		"javax.portlet.display-name=SPHMS Hording Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HordingModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// Get all active hording List
		renderRequest.setAttribute("hordingBeanList", HordingPortletUtil.getAllHordingList());

		include(viewTemplate, renderRequest, renderResponse);
	}
}