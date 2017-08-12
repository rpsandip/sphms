package com.proposal.portlet.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.proposal.portlet.portlet.util.ProposalPortletConstant;


@Component(
	    property = {
	    	"javax.portlet.name="+ProposalPortletConstant.PORTLET_ID,
	        "mvc.command.name=/prepare-proposal"
	    },
	    service = MVCRenderCommand.class
)
public class PrepareProposalRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/proposal/prepare_proposal.jsp";
	}

}
