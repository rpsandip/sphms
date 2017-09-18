package com.sphms.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.sphms.common.service.beans.BillingBean;
import com.sphms.common.service.beans.Billing_HordingBean;
import com.sphms.common.service.beans.Booking_HordingBean;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_HordingLocalServiceUtil;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.Booking_HordingLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+BillingConstant.PORTLET_ID,
	        "mvc.command.name=/edit-billing"
	    },
	    service = MVCRenderCommand.class
)
public class EditBillingRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(EditBillingRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long billingId = ParamUtil.getLong(renderRequest, "billingId");
		
		try {
			Billing billing = BillingLocalServiceUtil.getBilling(billingId);
			BillingBean billingBean = new BillingBean(billing);
			renderRequest.setAttribute("billingBean", billingBean);
			
			List<Billing_HordingBean> billingHordingBeanList= new ArrayList<Billing_HordingBean>();
			List<Billing_Hording> billingHordingList = Billing_HordingLocalServiceUtil.getBillingHordingList(billingId);
			
			for(Billing_Hording billingHording : billingHordingList){
				Billing_HordingBean billingHordingBean = new Billing_HordingBean(billingHording);
				billingHordingBeanList.add(billingHordingBean);
			}
			
			renderRequest.setAttribute("billingHordingBeanList", billingHordingBeanList);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		return "/billing/edit-billing.jsp";
	}

}
