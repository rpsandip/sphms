package sphms.supplier.bill.module.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil;

import sphms.supplier.bill.module.constants.SphmsSupplierBillModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SphmsSupplierBillModulePortletKeys.SphmsSupplierBillModule,
	        "mvc.command.name=/delete_payment"
	    },
	    service = MVCActionCommand.class
)
public class DeleteSupplierPaymentActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long supplierId = ParamUtil.getLong(actionRequest , "supplierId");
		long supplierBillId = ParamUtil.getLong(actionRequest , "supplierBillId");
		long supplierBillPaymentId = ParamUtil.getLong(actionRequest , "supplierBillPaymentId");
		
		if(supplierBillPaymentId>0){
			SupplierBillPaymentLocalServiceUtil.deleteSupplierBillPayment(supplierBillPaymentId);
			SessionMessages.add(actionRequest, "delete-supplier-patment-successs");
		}else{
			SessionErrors.add(actionRequest, "delete-supplier-patment-error");
		}
		
		actionResponse.setRenderParameter("mvcRenderCommandName", "/get_supplier_bill_payments");
		actionResponse.setRenderParameter("supplierBillId", String.valueOf(supplierBillId));
		actionResponse.setRenderParameter("supplierId", String.valueOf(supplierId));
		
	}

}
