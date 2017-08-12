package com.proposal.portlet.portlet;

import java.util.ArrayList;
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
import com.liferay.portal.kernel.util.Validator;
import com.proposal.portlet.portlet.util.ProposalPortletConstant;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+ProposalPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_proposal"
	    },
	    service = MVCRenderCommand.class
)
public class AddProposalRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddProposalRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		String selectedHordings = ParamUtil.getString(renderRequest, "selectedHordingIds");
		
		// Get all active client list
		List<Client> allClientList = ClientLocalServiceUtil.getClients(-1, -1);
		renderRequest.setAttribute("allClientList", allClientList);
		
		String[] selectedHordingIds = selectedHordings.split(",");
		List<Hording> hordingList = new ArrayList<Hording>();
		for(String hordingId  : selectedHordingIds){
			if(Validator.isNotNull(hordingId)){
				try {
					Hording horing = HordingLocalServiceUtil.getHording(Long.parseLong(hordingId));
					hordingList.add(horing);
				} catch (NumberFormatException e) {
					_log.error(e);
				} catch (PortalException e) {
					_log.error(e);
				}
			}
		}
		
		renderRequest.setAttribute("hordindList", hordingList);
		renderRequest.setAttribute("selectedHordingIds", selectedHordings);
		return "/proposal/add_proposal.jsp";
	}

}
