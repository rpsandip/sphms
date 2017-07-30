package com.hording.portlet.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.hording.portlet.portlet.util.HordingPortletConstant;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.beans.HordingBean;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.HordingLocalServiceUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+HordingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/view_hording_detail"
	    },
	    service = MVCRenderCommand.class
)
public class ViewHordingDetailRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(ViewHordingDetailRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long hordingId = ParamUtil.getLong(renderRequest, "hordingId");
		
		try {
			Hording hording = HordingLocalServiceUtil.getHording(hordingId);
			HordingBean hordingBean = new HordingBean(hording);
			renderRequest.setAttribute("hordingBean", hordingBean);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		return "/hording/view_detail.jsp";
	}

}
