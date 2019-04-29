package sphms.supplier.bill.module.actioncommand;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.model.SupplierBillPayment;
import com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil;

import sphms.supplier.bill.module.constants.SphmsSupplierBillModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SphmsSupplierBillModulePortletKeys.SphmsSupplierBillModule,
	        "mvc.command.name=/add_supplier_bill_payment"
	    },
	    service = MVCActionCommand.class
)
public class AddSupplirtBillPaymentActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(AddSupplirtBillPaymentActionCommand.class.getName());	
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
			
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		long supplierId = ParamUtil.getLong(actionRequest , "supplierId");
		long supplierBillId = ParamUtil.getLong(actionRequest , "supplierBillId");
		long supplierBillPaymentId = ParamUtil.getLong(actionRequest , "supplierBillPaymentId");
		
		double amount = ParamUtil.getDouble(actionRequest,"amount");
		double gst = ParamUtil.getDouble(actionRequest, "gst");
		String chequeNo = ParamUtil.getString(actionRequest, "chequeNo");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date paymentDate = ParamUtil.getDate(actionRequest, "paymentDate", dateFormat);
		
		if(supplierBillPaymentId==0){
			SupplierBillPayment billPayment = SupplierBillPaymentLocalServiceUtil.addSupplierBillPayment(supplierId,
					supplierBillId, amount, gst, paymentDate, chequeNo, themeDisplay.getUserId());
			SessionMessages.add(actionRequest, "payment-add-success");
		}else{
			try {
				SupplierBillPayment billPayment = SupplierBillPaymentLocalServiceUtil.updateSupplierBillPayment(supplierBillPaymentId,
						supplierId, supplierBillId, amount, gst, paymentDate, chequeNo, themeDisplay.getUserId());
				SessionMessages.add(actionRequest, "payment-update-success");
			} catch (PortalException e) {
				_log.error(e);
			}
			
		}
		
		actionResponse.setRenderParameter("mvcRenderCommandName", "/get_supplier_bill_payments");
		actionResponse.setRenderParameter("supplierBillId", String.valueOf(supplierBillId));
		actionResponse.setRenderParameter("supplierId", String.valueOf(supplierId));
	}

}
