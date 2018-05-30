/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sphms.common.service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.Proposal_HordingBean;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.model.Proposal_Hording;
import com.sphms.common.service.service.ProposalLocalServiceUtil;
import com.sphms.common.service.service.Proposal_HordingLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.common.service.service.base.ProposalLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the proposal local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.ProposalLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalLocalServiceBaseImpl
 * @see com.sphms.common.service.service.ProposalLocalServiceUtil
 */
@ProviderType
public class ProposalLocalServiceImpl extends ProposalLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(ProposalLocalServiceImpl.class.getName());
	
	public Proposal addProposal(String campaignTitle, long client, Date startDate, Date endDate,List<Proposal_HordingBean> proposalHordingBeanList, long createdBy, long modifiedBy){
		
		_log.info("Adding Proposal ->" +  " campaignTitle->"+campaignTitle +" client ->" + client + " dtartDate ->" + startDate + 
				"endDate ->" +endDate + " proposalHordingBeanList ->" + proposalHordingBeanList.size());
		
		Proposal proposal = ProposalLocalServiceUtil.createProposal(CounterLocalServiceUtil.increment());
		proposal.setCampaignTitle(campaignTitle);
		proposal.setClient(client);
		proposal.setStartDate(startDate);
		proposal.setEndDate(endDate);
		proposal.setCreateDate(new Date());
		proposal.setModifiedDate(new Date());
		proposal.setCreatedBy(createdBy);
		proposal.setModifiedBy(modifiedBy);
		proposal = ProposalLocalServiceUtil.addProposal(proposal);
		
		if(Validator.isNotNull(proposal)){
			addProposalHording(proposalHordingBeanList, proposal);
		}
		return proposal;
	}
	
	
	private void addProposalHording(List<Proposal_HordingBean> proposalHordingBeanList, Proposal proposal){
		for(Proposal_HordingBean proposalHoringBean : proposalHordingBeanList){
			proposalHoringBean.setProposalId(proposal.getProposalId());
			Proposal_HordingLocalServiceUtil.addProposalHording(proposal.getProposalId(), proposalHoringBean.getHordingId() , proposalHoringBean.getMountingCharge(),proposalHoringBean.getPrintingCharge(),proposalHoringBean.getUnits());
		}
	}
	
	
	public boolean deleteProposalDetail(long proposalId) throws PortalException{
		
		boolean isDeleted = false;
		
		// Delete Proposal Hording
		List<Proposal_Hording>  proposalHordingList  = Proposal_HordingLocalServiceUtil.getProposalHording(proposalId);
		for(Proposal_Hording proposalHoridng : proposalHordingList){
			Proposal_HordingLocalServiceUtil.deleteProposal_Hording(proposalHoridng);
		}
		
		// Delete Proposal Folder
		long globalSiteGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		Folder proposalParentFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PropsUtil.get("proposal.document.folder"));
		DLAppServiceUtil.deleteFolder(proposalParentFolder.getFolderId());
		
		// Delete Proposal
		ProposalLocalServiceUtil.deleteProposal(proposalId);
		
		return isDeleted;
	}
	
	public List<Proposal> getProposalList(long clientId, Date startDate, Date endDate, int start, int end){
		List<Proposal> proposalList = new ArrayList<Proposal>();
		
		DynamicQuery dynamicQuery = ProposalLocalServiceUtil.dynamicQuery();
		if(clientId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("client", clientId));
		}
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			dynamicQuery.add(RestrictionsFactoryUtil.between("startDate", startDate, endDate));
		}
		dynamicQuery.setLimit(start, end);
		
		Order order = OrderFactoryUtil.desc("createDate");
		dynamicQuery.addOrder(order);
		
		proposalList = ProposalLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return proposalList;
	}
	
	public long getProposalCount(long clientId, Date startDate, Date endDate){
		List<Proposal> proposalList = getProposalList(clientId, startDate, endDate, -1, -1);
		return proposalList.size();
	}
}