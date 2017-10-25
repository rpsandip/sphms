package com.sphms.portlet.actioncommand;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.sphms.common.service.model.LandLordPayment;
import com.sphms.common.service.service.LandLordPaymentLocalServiceUtil;
import com.sphms.portlet.util.LandLordPortletConstant;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + LandLordPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_land_lord_payment"
	    },
	    service = MVCActionCommand.class
	)
public class AddLandLordPaymentActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long landLordPaymentId = ParamUtil.getLong(actionRequest, "landLordPaymentId");
		long hordingId = ParamUtil.getLong(actionRequest,"hordingId");
		long landLordId = ParamUtil.getLong(actionRequest, "landLordId");
		double amount = ParamUtil.getDouble(actionRequest, "amount");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date paymentDate = ParamUtil.getDate(actionRequest, "paymentDate", dateFormat);
		String chequeNo = ParamUtil.getString(actionRequest, "chequeNo");
		String bankName = ParamUtil.getString(actionRequest, "bankName");
		
		
		if(landLordPaymentId==0){
			// Addling payment
			LandLordPayment landLordPayment = LandLordPaymentLocalServiceUtil.addLandLordPayment(landLordId, hordingId, amount, paymentDate, chequeNo, bankName,themeDisplay.getUserId());
			
			if(Validator.isNotNull(landLordPayment)){
				SessionMessages.add(actionRequest, "add-land-lord-payment-successfully");
			}else{
				SessionErrors.add(actionRequest, "err-add-land-lord-payment");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_land_lord_payment");
				actionResponse.setRenderParameter("landLordId", String.valueOf(landLordId));
			}
			
		}else{
			// Update payment
			LandLordPayment landLordPayment = LandLordPaymentLocalServiceUtil.updateLandLordPayment(landLordPaymentId, landLordId, hordingId, amount, paymentDate, chequeNo, bankName,themeDisplay.getUserId());
			if(Validator.isNotNull(landLordPayment)){
				SessionMessages.add(actionRequest, "update-land-lord-payment-successfully");
			}else{
				SessionErrors.add(actionRequest, "err-update-land-lord-payment");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_land_lord_payment");
				actionResponse.setRenderParameter("landLordId", String.valueOf(landLordId));
				actionResponse.setRenderParameter("landLordPaymentId", String.valueOf(landLordPaymentId));
			}
		}
		
	}

}
