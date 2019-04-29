package sphms.supplier.module.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.service.POPaymentLocalServiceUtil;

import sphms.supplier.module.constants.SphmsSupplierModulePortletKeys;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + SphmsSupplierModulePortletKeys.SphmsSupplierModule,
		"mvc.command.name=/delete_po_payment" }, service = MVCActionCommand.class)
public class DeletePaymentActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

		long poPaymentId = ParamUtil.getLong(actionRequest, "poPaymentId");
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		long landLoardId = ParamUtil.getLong(actionRequest, "landLordId");
		long companyId = ParamUtil.getLong(actionRequest, "companyId");
		
		
		try {
			POPaymentLocalServiceUtil.deletePOPayment(poPaymentId);
			SessionMessages.add(actionRequest, "delet-po-success");
			
			actionResponse.setRenderParameter("mvcRenderCommandName", "/po_payment");
			actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
			actionResponse.setRenderParameter("landLordId", String.valueOf(landLoardId));
			actionResponse.setRenderParameter("companyId", String.valueOf(companyId));
			
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SessionMessages.add(actionRequest, "delete-po-error");
			
			actionResponse.setRenderParameter("mvcRenderCommandName", "/po_payment");
			actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
			actionResponse.setRenderParameter("landLordId", String.valueOf(landLoardId));
			actionResponse.setRenderParameter("companyId", String.valueOf(companyId));
		}
		
		
	}

}
