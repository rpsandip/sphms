package sphms.supplier.master.module.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.service.SupplierLocalServiceUtil;

import sphms.supplier.master.module.portlet.constants.SupplierMasterModulePortletKeys;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + SupplierMasterModulePortletKeys.SupplierMasterModule,
	        "mvc.command.name=/add_supplier"
	    },
	    service = MVCActionCommand.class
	)
public class AddSupplierActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String supplierName = ParamUtil.getString(actionRequest, "supplierName");
		String address1= ParamUtil.getString(actionRequest, "address1");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
		String contactPersonEmail = ParamUtil.getString(actionRequest, "contactPersonEmail");
		String contactPersonPhoneNo = ParamUtil.getString(actionRequest, "contactPersonPhoneNo");
		String panNo = ParamUtil.getString(actionRequest, "panNo");
		String gstNo = ParamUtil.getString(actionRequest, "gstNo");
		long supplierId = ParamUtil.getLong(actionRequest, "supplierId");
		
		if(supplierId==0){
			// Add Client
			Supplier supplier = SupplierLocalServiceUtil.addSupplier(supplierName, address1, address2, city, state, contactPersonName, contactPersonPhoneNo, contactPersonEmail, panNo, gstNo,themeDisplay.getUserId());
			if(Validator.isNotNull(supplier)){
				SessionMessages.add(actionRequest, "supplier-added-successfully");
			}else{
				SessionErrors.add(actionRequest, "error-add-supplier");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_supplier");
				actionResponse.setRenderParameter("supplierId", String.valueOf(supplierId));
			}
		}else{
			// Update Client
			Supplier supplier = SupplierLocalServiceUtil.updateSupplier(supplierId, supplierName, address1, address2, city, state, contactPersonName, contactPersonPhoneNo, contactPersonEmail, panNo, gstNo,themeDisplay.getUserId());
			if(Validator.isNotNull(supplier)){
				SessionMessages.add(actionRequest, "supplier-updated-successfully");
			}else{
				SessionErrors.add(actionRequest, "error-supplier-supplier");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_supplier");
				actionResponse.setRenderParameter("supplierId", String.valueOf(supplierId));
			}
		}
		
	}

}
