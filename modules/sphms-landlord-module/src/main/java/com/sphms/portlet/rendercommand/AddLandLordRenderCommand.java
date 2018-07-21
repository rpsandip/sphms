package com.sphms.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.portlet.util.LandLordPortletConstant;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+LandLordPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_land_lord"
	    },
	    service = MVCRenderCommand.class
)
public class AddLandLordRenderCommand implements MVCRenderCommand{
	Log _log = LogFactoryUtil.getLog(AddLandLordRenderCommand.class.getName());
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long landLordId = ParamUtil.getLong(renderRequest, "landLordId");
		
		try {
			LandLord landLord = LandLordLocalServiceUtil.getLandLord(landLordId);
			renderRequest.setAttribute("landLord", landLord);
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		
		return "/land-lord/add_land_lord.jsp";
	}

}
