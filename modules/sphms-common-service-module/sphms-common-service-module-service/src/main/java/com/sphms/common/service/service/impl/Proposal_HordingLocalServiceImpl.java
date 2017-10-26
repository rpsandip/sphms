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

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import com.sphms.common.service.model.Proposal_Hording;
import com.sphms.common.service.service.Proposal_HordingLocalServiceUtil;
import com.sphms.common.service.service.base.Proposal_HordingLocalServiceBaseImpl;
import com.sphms.common.service.service.persistence.Proposal_HordingPK;

/**
 * The implementation of the proposal_ hording local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.Proposal_HordingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal_HordingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.Proposal_HordingLocalServiceUtil
 */
@ProviderType
public class Proposal_HordingLocalServiceImpl
	extends Proposal_HordingLocalServiceBaseImpl {
	
	public Proposal_Hording addProposalHording(long proposalId, long hordingId, double mountingCharge, double printingChrage, int units){
		Proposal_HordingPK proposalHordingPK = new Proposal_HordingPK(proposalId, hordingId);
		Proposal_Hording proposalHording = Proposal_HordingLocalServiceUtil.createProposal_Hording(proposalHordingPK);
		proposalHording.setMountingCharge(mountingCharge);
		proposalHording.setPrintingCharge(printingChrage);
		proposalHording.setUnits(units);
		proposalHording = Proposal_HordingLocalServiceUtil.addProposal_Hording(proposalHording);
		
		return proposalHording;
	}
	
	public List<Proposal_Hording> getProposalHording(long proposalId){
		return proposal_HordingPersistence.findByproposalId(proposalId);
	}
}