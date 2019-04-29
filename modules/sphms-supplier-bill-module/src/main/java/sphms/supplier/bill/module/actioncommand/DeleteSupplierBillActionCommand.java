package sphms.supplier.bill.module.actioncommand;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.model.SupplierBillPayment;
import com.sphms.common.service.service.SupplierBillLocalServiceUtil;
import com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil;

import sphms.supplier.bill.module.constants.SphmsSupplierBillModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SphmsSupplierBillModulePortletKeys.SphmsSupplierBillModule,
	        "mvc.command.name=delete_bill"
	    },
	    service = MVCActionCommand.class
)
public class DeleteSupplierBillActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(DeleteSupplierBillActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)  {

		long supplierBillId = ParamUtil.getLong(actionRequest, "supplierBillId");
		try {
			List<SupplierBillPayment> billPayments = SupplierBillPaymentLocalServiceUtil.getSupplierBillPaymentBySupplierBillId(supplierBillId);
			for(SupplierBillPayment supplierBillPayment : billPayments){
				SupplierBillPaymentLocalServiceUtil.deleteSupplierBillPayment(supplierBillPayment);
			}
			
			SupplierBillLocalServiceUtil.deleteSupplierBill(supplierBillId);
			
			SessionMessages.add(actionRequest, "delete-supplier-bill-success");
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "delete-supplier-bill-error");
			_log.error(e);
		}
		
	}

}
