package com.sphms.portlet.portlet.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.beans.BillingBean;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Payment;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.PaymentLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+BillingConstant.PORTLET_ID,
	        "mvc.command.name=/payment"
	    },
	    service = MVCRenderCommand.class
)
public class PaymentRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(PaymentRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse){

		long billingId = ParamUtil.getLong(renderRequest, "billingId");
		
		try {
			Billing billing = BillingLocalServiceUtil.getBilling(billingId);
			BillingBean billingBean = new BillingBean(billing);
			renderRequest.setAttribute("billingBean", billingBean);
			
			List<Payment> billPaymentList = PaymentLocalServiceUtil.getPaymentsOfBill(billingId);
			renderRequest.setAttribute("billPaymentList", billPaymentList);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		return "/billing/view-payment.jsp";
	}

}
