package com.sphms.portlet.portlet.actioncommand;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.xmlbeans.impl.tool.Extension.Param;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil.PACL;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.model.Payment;
import com.sphms.common.service.service.PaymentLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BillingConstant.PORTLET_ID,
	        "mvc.command.name=/add_bill_payment"
	    },
	    service = MVCActionCommand.class
	)
public class AddPaymentActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long paymentId=ParamUtil.getLong(actionRequest, "paymentId");
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		double amount = ParamUtil.getDouble(actionRequest, "amount");
		String chequeNo = ParamUtil.getString(actionRequest, "chequeNo");
		double tds = ParamUtil.getDouble(actionRequest, "tds");
		String description = ParamUtil.getString(actionRequest, "description");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date paymentDate = ParamUtil.getDate(actionRequest, "paymentDate", dateFormat);
		
		double deduction = ParamUtil.getDouble(actionRequest, "deduction");
		
		if(paymentId==0){
			Payment payment = PaymentLocalServiceUtil.addPayment(billingId, amount, chequeNo, tds, deduction, description, paymentDate,themDisplay.getUserId());
			if(Validator.isNotNull(payment)){
				SessionMessages.add(actionRequest, "payment-added-successfully");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/payment");
			}else{
				SessionErrors.add(actionRequest, "payment-add-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/payment");
				actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
				actionResponse.setRenderParameter("paymentId", String.valueOf(paymentId));
			}
		}else{
			Payment payment = PaymentLocalServiceUtil.updatePayment(paymentId, billingId, amount, chequeNo, tds, deduction, description, paymentDate,themDisplay.getUserId());
			if(Validator.isNotNull(payment)){
				SessionMessages.add(actionRequest, "payment-updated-successfully");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/payment");
			}else{
				SessionErrors.add(actionRequest, "paymenti-update-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/payment");
				actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
				actionResponse.setRenderParameter("paymentId", String.valueOf(paymentId));
			}
		}
	}

}
