package com.proposal.portlet.portlet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.proposal.portlet.portlet.util.FileUtil;
import com.proposal.portlet.portlet.util.ProposalPortletConstant;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.ProposalLocalServiceUtil;
import com.sphms.common.service.service.Proposal_HordingLocalServiceUtil;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ProposalPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_proposal"
	    },
	    service = MVCActionCommand.class
	)
public class AddProposalActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(AddProposalActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String selectedHordings = ParamUtil.getString(actionRequest, "selectedHordingIds");
		String campaignTitle = ParamUtil.getString(actionRequest, "camapaignTitle");
		long clientId = ParamUtil.getLong(actionRequest, "clientId");
		Date startDate = ParamUtil.getDate(actionRequest, "startDate", dateFormat);
		Date endDate = ParamUtil.getDate(actionRequest, "endDate", dateFormat);
		List<Long> hordingIdList = new ArrayList<Long>();
		List<Hording> hordingList = new ArrayList<Hording>();
		for(String hordingId : selectedHordings.split(",")){
			if(Validator.isNotNull(hordingId)){
				hordingIdList.add(Long.parseLong(hordingId));
			}
		}
		
		Proposal proposal = ProposalLocalServiceUtil.addProposal(campaignTitle, clientId, startDate, endDate, hordingIdList,themeDisplay.getUserId(), themeDisplay.getUserId());
		
		if(Validator.isNotNull(proposal)){
			// Get hoarding list
			int hordingIndex=0;
			for(Long hordingId : hordingIdList){
				try {
					Hording hording = HordingLocalServiceUtil.getHording(hordingId);
					double mountingCharge = ParamUtil.getDouble(actionRequest, "moutingCharge"+hordingIndex);
					double printingCharge = ParamUtil.getDouble(actionRequest, "printingCharge"+hordingIndex);
					int units = ParamUtil.getInteger(actionRequest, "units"+hordingIndex);
					Proposal_HordingLocalServiceUtil.addProposalHording(proposal.getProposalId(), hordingId, mountingCharge,printingCharge,units);
					hordingList.add(hording);
				} catch (PortalException e) {
					_log.error(e);
				}
				hordingIndex++;
			}
			
			// Add PPT File
			FileEntry pptFileEntry = FileUtil.createProposalPPTFile(proposal, hordingList);
			if(Validator.isNotNull(pptFileEntry)){
				_log.info("Proposal PPT file created successfully->" + pptFileEntry.getFileEntryId());
			}
			
			// Add XlsX File
			FileEntry xlsxFileEntry = FileUtil.createProposalXlsxFile(proposal, hordingList);
			if(Validator.isNotNull(xlsxFileEntry)){
				_log.info("Proposal Xlsx file created successfully->" + xlsxFileEntry.getFileEntryId());
			}
			
			if(Validator.isNotNull(pptFileEntry)&&Validator.isNotNull(xlsxFileEntry)){
				proposal.setPptFileId(pptFileEntry.getFileEntryId());
				proposal.setXlsxFileId(xlsxFileEntry.getFileEntryId());
				
				ProposalLocalServiceUtil.updateProposal(proposal);
			}
			
			SessionMessages.add(actionRequest, "proposal-added-successfully");
		}else{
			SessionErrors.add(actionRequest, "err-add-proposal");
			actionResponse.setRenderParameter("mvcRenderCommandName", "/add_proposal");
			actionResponse.setRenderParameter("selectedHordingIds", selectedHordings);
		}
	}

}
