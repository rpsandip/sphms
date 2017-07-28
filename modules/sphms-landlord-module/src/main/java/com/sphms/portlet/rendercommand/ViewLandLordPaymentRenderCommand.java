package com.sphms.portlet.rendercommand;

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
import com.sphms.common.service.beans.LandLordPaymentBean;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.service.LandLordPaymentLocalServiceUtil;
import com.sphms.portlet.util.LandLordPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+LandLordPortletConstant.PORTLET_ID,
	        "mvc.command.name=/viewPayment"
	    },
	    service = MVCRenderCommand.class
)
public class ViewLandLordPaymentRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(ViewLandLordPaymentRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long landLordId = ParamUtil.getLong(renderRequest, "landLordId");
		try {
			LandLord landLord = LandLordLocalServiceUtil.getLandLord(landLordId);
			List<LandLordPaymentBean> landLordPaymentBeanList = LandLordPaymentLocalServiceUtil.getLandLordPayments(landLordId);
			renderRequest.setAttribute("landLordPaymentBeanList", landLordPaymentBeanList);
			renderRequest.setAttribute("landLord", landLord);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		
		return "/payment/view_payment.jsp";
	}

}
