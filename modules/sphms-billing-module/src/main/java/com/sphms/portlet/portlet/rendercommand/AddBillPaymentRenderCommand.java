package com.sphms.portlet.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.xmlbeans.impl.tool.Extension.Param;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.model.Payment;
import com.sphms.common.service.service.PaymentLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+BillingConstant.PORTLET_ID,
	        "mvc.command.name=/add_bill_payment"
	    },
	    service = MVCRenderCommand.class
)
public class AddBillPaymentRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(Payment.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse){
		long paymentId = ParamUtil.getLong(renderRequest, "paymentId");
		long billingId = ParamUtil.getLong(renderRequest, "billingId");
		if(paymentId>0){
			try {
				Payment payment = PaymentLocalServiceUtil.getPayment(paymentId);
				renderRequest.setAttribute("payment", payment);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		renderRequest.setAttribute("billingId", billingId);
		renderRequest.setAttribute("paymentId", paymentId);
		return "/billing/add-payment.jsp";
	}

}
