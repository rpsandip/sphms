package sphms.supplier.master.module.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.service.SupplierLocalServiceUtil;

import sphms.supplier.master.module.portlet.constants.SupplierMasterModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SupplierMasterModulePortletKeys.SupplierMasterModule,
	        "mvc.command.name=/add_supplier"
	    },
	    service = MVCRenderCommand.class
)
public class AddSupplierRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddSupplierRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long supplierId = ParamUtil.getLong(renderRequest, "supplierId");
		try {
			Supplier supplier = SupplierLocalServiceUtil.getSupplier(supplierId);
			renderRequest.setAttribute("supplier", supplier);
		} catch (PortalException e) {
			if(supplierId!=0){
				_log.error(e.getMessage());
			}
		}
		
		return "/supplier/add_supplier.jsp";
	}

}
