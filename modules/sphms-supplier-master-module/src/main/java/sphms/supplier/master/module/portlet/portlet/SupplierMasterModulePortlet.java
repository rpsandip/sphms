package sphms.supplier.master.module.portlet.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.service.SupplierLocalServiceUtil;

import sphms.supplier.master.module.portlet.constants.SupplierMasterModulePortletKeys;

/**
 * @author sandip
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SupplierMasterModulePortletKeys.SupplierMasterModule,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SupplierMasterModulePortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// Get all Client
		List<Supplier> supplierList = SupplierLocalServiceUtil.getSuppliers();
		renderRequest.setAttribute("supplierList", supplierList);
		
		include(viewTemplate, renderRequest, renderResponse);
	}
}