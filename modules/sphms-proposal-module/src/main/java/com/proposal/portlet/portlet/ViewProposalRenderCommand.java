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
import com.proposal.portlet.portlet.util.ProposalPortletConstant;
import com.sphms.common.service.beans.ProposalBean;
import com.sphms.common.service.beans.Proposal_HordingBean;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.model.Proposal_Hording;
import com.sphms.common.service.service.ProposalLocalServiceUtil;
import com.sphms.common.service.service.Proposal_HordingLocalServiceUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+ProposalPortletConstant.PORTLET_ID,
	        "mvc.command.name=/view-proposal"
	    },
	    service = MVCRenderCommand.class
)
public class ViewProposalRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(ViewProposalRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long proposalId = ParamUtil.getLong(renderRequest, "proposalId");
		try {
			Proposal proposal = ProposalLocalServiceUtil.getProposal(proposalId);
			ProposalBean proposalBean = new  ProposalBean(proposal);
			List<Proposal_Hording> proposalHordingList = Proposal_HordingLocalServiceUtil.getProposalHording(proposalId);
			List<Proposal_HordingBean> proposalHordingBeaList = new ArrayList<Proposal_HordingBean>();
			for(Proposal_Hording proposalHording : proposalHordingList){
				Proposal_HordingBean proposalHordingBean = new Proposal_HordingBean(proposal, proposalHording);
				proposalHordingBeaList.add(proposalHordingBean);
			}
			
			renderRequest.setAttribute("proposalBean", proposalBean);
			renderRequest.setAttribute("proposalHordingBeaList", proposalHordingBeaList);
		} catch (PortalException e) {
			_log.error(e);
		}
		return "/proposal/view_proposal.jsp";
	}

}
