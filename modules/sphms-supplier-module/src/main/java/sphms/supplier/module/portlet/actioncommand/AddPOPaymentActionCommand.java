package sphms.supplier.module.portlet.actioncommand;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.service.POPaymentLocalServiceUtil;

import sphms.supplier.module.constants.SphmsSupplierModulePortletKeys;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + SphmsSupplierModulePortletKeys.SphmsSupplierModule,
		"mvc.command.name=/add_PO_payment" }, service = MVCActionCommand.class)
public class AddPOPaymentActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){

	Log _log = LogFactoryUtil.getLog(AddPOPaymentActionCommand.class.getName());	
		
	ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long poPaymentId = ParamUtil.getLong(actionRequest, "poPaymentId");
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		long landLoardId = ParamUtil.getLong(actionRequest, "landLordId");
		long companyId = ParamUtil.getLong(actionRequest, "companyId");
		
		
		try{
		if(poPaymentId==0){
			double amount = ParamUtil.getDouble(actionRequest,"amount");
			double gst = ParamUtil.getDouble(actionRequest, "gst");
			String chequeNo = ParamUtil.getString(actionRequest, "chequeNo");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date paymentDate = ParamUtil.getDate(actionRequest, "paymentDate", dateFormat);
			
			POPaymentLocalServiceUtil.addOPayment(billingId, landLoardId, amount, gst, chequeNo, paymentDate, themeDisplay.getUserId());
			
			SessionMessages.add(actionRequest, "po-payment-add-success");
			
			actionResponse.setRenderParameter("mvcRenderCommandName", "/po_payment");
			actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
			actionResponse.setRenderParameter("landLordId", String.valueOf(landLoardId));
			actionResponse.setRenderParameter("companyId", String.valueOf(companyId));
			
		}else{
			
			double amount = ParamUtil.getDouble(actionRequest,"amount");
			double gst = ParamUtil.getDouble(actionRequest, "gst");
			String chequeNo = ParamUtil.getString(actionRequest, "chequeNo");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date paymentDate = ParamUtil.getDate(actionRequest, "paymentDate", dateFormat);
			
			POPaymentLocalServiceUtil.updatePOPayment(poPaymentId, billingId, landLoardId, amount, gst, chequeNo, paymentDate, themeDisplay.getUserId());
			
			SessionMessages.add(actionRequest, "po-payment-update-success");
			
			actionResponse.setRenderParameter("mvcRenderCommandName", "/po_payment");
			actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
			actionResponse.setRenderParameter("landLordId", String.valueOf(landLoardId));
			actionResponse.setRenderParameter("companyId", String.valueOf(companyId));
			
			
		}
		}catch(Exception e){
			_log.error(e);
		}
		
	}

}
