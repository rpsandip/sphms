package sphms.client.module.portlet.rendercommand;

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
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CreditNote;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.CreditNoteLocalServiceUtil;

import sphms.client.module.portlet.util.ClientPortletConstant;


@Component(
	    property = {
	    	"javax.portlet.name="+ClientPortletConstant.PORTLET_ID,
	        "mvc.command.name=/credit_note"
	    },
	    service = MVCRenderCommand.class
)
public class CreditNoteListRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(CreditNoteListRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long clientId = ParamUtil.getLong(renderRequest, "clientId");
		renderRequest.setAttribute("clientId", clientId);

		List<CreditNote> creditNoteList = CreditNoteLocalServiceUtil.getClientCreditNoteList(clientId);
		
		renderRequest.setAttribute("creditNoteList", creditNoteList);
		
		try {
			Client client = ClientLocalServiceUtil.getClient(clientId);
			renderRequest.setAttribute("client", client);
		} catch (PortalException e) {
			_log.error(e);
		}
		
		
		return "/client/credit_notes.jsp";
		
	}

}
