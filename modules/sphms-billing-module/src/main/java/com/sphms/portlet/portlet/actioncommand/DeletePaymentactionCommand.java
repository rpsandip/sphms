package com.sphms.portlet.portlet.actioncommand;

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
import com.sphms.common.service.service.PaymentLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BillingConstant.PORTLET_ID,
	        "mvc.command.name=/delete_payment"
	    },
	    service = MVCActionCommand.class
	)
public class DeletePaymentactionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(DeletePaymentactionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		
		long paymentId=ParamUtil.getLong(actionRequest, "paymentId");
		if(paymentId>0){
			try {
				PaymentLocalServiceUtil.deletePayment(paymentId);
				SessionMessages.add(actionRequest, "payment-delete-scuccess");
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "payment-delete-error");
				_log.error(e);
			}
			
		}else{
			SessionErrors.add(actionRequest, "payment-delete-error");
		}
		
	}

}
