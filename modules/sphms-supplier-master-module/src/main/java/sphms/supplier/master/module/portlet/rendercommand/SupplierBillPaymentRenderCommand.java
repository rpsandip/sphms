package sphms.supplier.master.module.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import sphms.supplier.master.module.portlet.constants.SupplierMasterModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SupplierMasterModulePortletKeys.SupplierMasterModule,
	        "mvc.command.name=/get_supplier_bill_payments"
	    },
	    service = MVCRenderCommand.class
)
public class SupplierBillPaymentRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		return "/";
	}

}
