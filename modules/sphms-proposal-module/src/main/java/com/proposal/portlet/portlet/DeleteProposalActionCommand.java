package com.proposal.portlet.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.proposal.portlet.portlet.util.ProposalPortletConstant;
import com.sphms.common.service.service.ProposalLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ProposalPortletConstant.PORTLET_ID,
	        "mvc.command.name=/delete_proposal"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteProposalActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(DeleteProposalActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

		long proposalId = ParamUtil.getLong(actionRequest,"proposalId");
		try {
			ProposalLocalServiceUtil.deleteProposalDetail(proposalId);
			SessionMessages.add(actionRequest,"delete-proposal-successs");
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "delete-proposal-err");
			_log.error(e.getMessage());
		}
		
	}

}
