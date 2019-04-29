package sphms.supplier.module.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.model.POPayment;
import com.sphms.common.service.service.POPaymentLocalServiceUtil;

import sphms.supplier.module.constants.SphmsSupplierModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + SphmsSupplierModulePortletKeys.SphmsSupplierModule,
	    	"mvc.command.name=/add_po_payment"
	    },
	    service = MVCRenderCommand.class
)
public class AddPOPaymentRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddPOPaymentRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long poPaymentId = ParamUtil.getLong(renderRequest, "poPaymentId");
		long billingId = ParamUtil.getLong(renderRequest, "billingId");
		long landLoardId = ParamUtil.getLong(renderRequest,"landLordId");
		long companyId = ParamUtil.getLong(renderRequest,"companyId");
		
		if(poPaymentId>0){
			try {
				POPayment poPayment = POPaymentLocalServiceUtil.getPOPayment(poPaymentId);
				renderRequest.setAttribute("poPayment", poPayment);
				
			} catch (PortalException e) {
				_log.error(e);
				return "/po_payment.jsp";
			}
		}
		
		renderRequest.setAttribute("billingId", billingId);
		renderRequest.setAttribute("landLordId", landLoardId);
		renderRequest.setAttribute("companyId", companyId);
		
		return "/add_po_payment.jsp";
	}

}
