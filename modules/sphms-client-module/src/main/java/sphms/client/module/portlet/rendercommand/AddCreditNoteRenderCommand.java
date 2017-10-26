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
import com.sphms.common.service.model.CreditNote;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.CreditNoteLocalServiceUtil;

import sphms.client.module.portlet.util.ClientPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ClientPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_credit_note"
	    },
	    service = MVCRenderCommand.class
)
public class AddCreditNoteRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddCreditNoteRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long clientId = ParamUtil.getLong(renderRequest, "clientId");
		long creditNoteId = ParamUtil.getLong(renderRequest, "creditNoteId");
		
		if(clientId>0){
			try {
				Client client = ClientLocalServiceUtil.getClient(clientId);
				renderRequest.setAttribute("client", client);
				renderRequest.setAttribute("clientId", clientId);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		if(creditNoteId>0){
			try {
				CreditNote creditNote = CreditNoteLocalServiceUtil.getCreditNote(creditNoteId);
				renderRequest.setAttribute("creditNote", creditNote);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		return "/client/add_credit_note.jsp";
	}

}
