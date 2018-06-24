package com.sphms.common.service.beans;

import java.util.Date;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;

public class ProposalBean {
	
	Log _log = LogFactoryUtil.getLog(ProposalBean.class.getName());
	
	private long proposalId;
	private String campaignTitle;
	private String client;
	private Date startDate;
	private Date endDate;
	private String pptFileURL;
	private String xlsxFileURL;
	
	public ProposalBean(Proposal proposal){
		this.proposalId = proposal.getProposalId();
		this.campaignTitle = proposal.getCampaignTitle();
		this.startDate = proposal.getStartDate();
		this.endDate = proposal.getEndDate();
		
		if(proposal.getPptFileId()>0){
			try {
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(proposal.getPptFileId());
				this.pptFileURL = SPHMSCommonLocalServiceUtil.getDLFileURL(fileEntry);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}
		
		if(proposal.getXlsxFileId()>0){
			try {
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(proposal.getXlsxFileId());
				this.xlsxFileURL = SPHMSCommonLocalServiceUtil.getDLFileURL(fileEntry);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}
		
		if(proposal.getClient()>0){
			try {
				Client client = ClientLocalServiceUtil.getClient(proposal.getClient());
				this.client = client.getClientName();
			} catch (PortalException e) {
				_log.error(e);
				
			}
		}
		
	}
	
	
	public long getProposalId() {
		return proposalId;
	}
	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}
	public String getCampaignTitle() {
		return campaignTitle;
	}
	public void setCampaignTitle(String campaignTitle) {
		this.campaignTitle = campaignTitle;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPptFileURL() {
		return pptFileURL;
	}
	public void setPptFileURL(String pptFileURL) {
		this.pptFileURL = pptFileURL;
	}
	public String getXlsxFileURL() {
		return xlsxFileURL;
	}
	public void setXlsxFileURL(String xlsxFileURL) {
		this.xlsxFileURL = xlsxFileURL;
	}
	
	
	
}
