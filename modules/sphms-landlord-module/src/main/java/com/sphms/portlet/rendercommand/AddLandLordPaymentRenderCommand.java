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
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.model.LandLordPayment;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.service.LandLordPaymentLocalServiceUtil;
import com.sphms.portlet.util.LandLordPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+LandLordPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_land_lord_payment"
	    },
	    service = MVCRenderCommand.class
)
public class AddLandLordPaymentRenderCommand implements MVCRenderCommand{
	Log _log = LogFactoryUtil.getLog(AddLandLordPaymentRenderCommand.class.getName());
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long landLordId = ParamUtil.getLong(renderRequest, "landLordId");
		long landLordPaymentId = ParamUtil.getLong(renderRequest, "landLordPaymentId");
		
		List<Hording> landLordHordingList = HordingLocalServiceUtil.getLandLordHordingList(landLordId);
		renderRequest.setAttribute("landLordHordingList", landLordHordingList);
		
		if(landLordPaymentId>0){
			try {
				LandLordPayment landLordPayment = LandLordPaymentLocalServiceUtil.getLandLordPayment(landLordPaymentId);
				renderRequest.setAttribute("landLordPayment", landLordPayment);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		try {
			LandLord landLord = LandLordLocalServiceUtil.getLandLord(landLordId);
			renderRequest.setAttribute("landLord", landLord);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		renderRequest.setAttribute("landLordId", landLordId);
		return "/payment/land_lord_payment.jsp";
	}

}
