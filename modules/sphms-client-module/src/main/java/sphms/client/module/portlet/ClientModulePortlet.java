package sphms.client.module.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.service.ClientLocalServiceUtil;

import java.io.IOException;
import java.util.List;

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
		"javax.portlet.display-name=sphms-client-module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ClientModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// Get all Client
		List<Client> clientList = ClientLocalServiceUtil.getClients(-1, -1);
		renderRequest.setAttribute("clientList", clientList);
		
		include(viewTemplate, renderRequest, renderResponse);
	}
}