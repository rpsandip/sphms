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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.model.SupplierBill;
import com.sphms.common.service.service.SupplierBillLocalServiceUtil;

import sphms.supplier.bill.module.constants.SphmsSupplierBillModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SphmsSupplierBillModulePortletKeys.SphmsSupplierBillModule,
	        "mvc.command.name=add_bill"
	    },
	    service = MVCActionCommand.class
)
public class AddSupplierBillActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(AddSupplierBillActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long supplierBillId = ParamUtil.getLong(actionRequest, "supplierBillId");
		String supplierBillNo = ParamUtil.getString(actionRequest, "supplierBillNo");
		String type = ParamUtil.getString(actionRequest, "type");
		double amount = ParamUtil.getDouble(actionRequest, "amount");
		double gst = ParamUtil.getDouble(actionRequest, "gst");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date billDate = ParamUtil.getDate(actionRequest, "billDate", dateFormat);
		long customCompanyId = ParamUtil.getLong(actionRequest, "customCustomId");
		long supplierId = ParamUtil.getLong(actionRequest, "supplierId");
		String description = ParamUtil.getString(actionRequest, "description");
		
		if(supplierBillId==0){
			if(Validator.isNotNull(billDate)){
				SupplierBill supplierBill	 = SupplierBillLocalServiceUtil.addSupplierBill(customCompanyId, supplierId, supplierBillNo,
						description, type, billDate, amount, gst, themeDisplay.getUserId());
				if(Validator.isNotNull(supplierBill)){
					SessionMessages.add(actionRequest, "supplier-bill-add-suceess");
				}else{
					SessionErrors.add(actionRequest, "supplier-bill-add-error");
					actionResponse.setRenderParameter("mvcRenderCommandName", "/add_supplier_bill");
					actionResponse.setRenderParameter("supplierBillId", String.valueOf(supplierBillId));
				}
			}else{
				SessionErrors.add(actionRequest, "supplier-bill-add-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_supplier_bill");
				actionResponse.setRenderParameter("supplierBillId", String.valueOf(supplierBillId));
			}
		}else{
			SupplierBill supplierBill = null;
			if(Validator.isNotNull(billDate)){
				try {
					supplierBill = SupplierBillLocalServiceUtil.updateSupplierBill(supplierBillId, customCompanyId,
							supplierId, supplierBillNo, description, type, billDate, amount, gst, themeDisplay.getUserId());
				} catch (PortalException e) {
					_log.error(e);
				}
				if(Validator.isNotNull(supplierBill)){
					SessionMessages.add(actionRequest, "supplier-bill-update-success");
				}else{
					SessionErrors.add(actionRequest, "supplier-bill-update-error");
					actionResponse.setRenderParameter("mvcRenderCommandName", "/add_supplier_bill");
					actionResponse.setRenderParameter("supplierBillId", String.valueOf(supplierBillId));
				}
			}else{
				SessionErrors.add(actionRequest, "supplier-bill-update-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_supplier_bill");
				actionResponse.setRenderParameter("supplierBillId", String.valueOf(supplierBillId));
			}
		}
		
	}

}
