package sphms.supplier.bill.module.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.model.SupplierBill;
import com.sphms.common.service.model.SupplierBillPayment;
import com.sphms.common.service.service.SupplierBillLocalServiceUtil;
import com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil;

import sphms.supplier.bill.module.constants.SphmsSupplierBillModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SphmsSupplierBillModulePortletKeys.SphmsSupplierBillModule,
	        "mvc.command.name=/add_supplier_bill_payment"
	    },
	    service = MVCRenderCommand.class
)
public class AddSupplierBillPaymentRenderCommand implements MVCRenderCommand{
	
	Log _log = LogFactoryUtil.getLog(AddSupplierBillPaymentRenderCommand.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long supplierBillId = ParamUtil.getLong(renderRequest, "supplierBillId");
		long supplierId = ParamUtil.getLong(renderRequest, "supplierId");
		long supplierBillPaymentId  = ParamUtil.getLong(renderRequest, "supplierBillPaymentId");
		
		if(supplierBillId>0){
			try {
				SupplierBill supplierBill = SupplierBillLocalServiceUtil.getSupplierBill(supplierBillId);
				renderRequest.setAttribute("supplierBill", supplierBill);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		if(supplierBillPaymentId>0){
			 SupplierBillPayment payment;
			try {
				payment = SupplierBillPaymentLocalServiceUtil.getSupplierBillPayment(supplierBillPaymentId);
				renderRequest.setAttribute("supplierBillPayment", payment);
			} catch (PortalException e) {
				_log.error(e);
			}
			
		}
		
		renderRequest.setAttribute("supplierBillId", supplierBillId);
		renderRequest.setAttribute("supplierId", supplierId);
		
		return "/add_supplier_bill_payment.jsp";
	}

}
