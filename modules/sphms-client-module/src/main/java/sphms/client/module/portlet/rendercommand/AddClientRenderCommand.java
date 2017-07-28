package sphms.client.module.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.service.ClientLocalServiceUtil;

import sphms.client.module.portlet.util.ClientPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ClientPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_client"
	    },
	    service = MVCRenderCommand.class
)
public class AddClientRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddClientRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long clientId = ParamUtil.getLong(renderRequest, "clientId");
		try {
			Client client = ClientLocalServiceUtil.getClient(clientId);
			renderRequest.setAttribute("client", client);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		return "/client/add_client.jsp";
	}

}
