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

package com.sphms.common.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.sphms.common.service.model.Proposal;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Proposal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Proposal
 * @generated
 */
@ProviderType
public class ProposalCacheModel implements CacheModel<Proposal>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProposalCacheModel)) {
			return false;
		}

		ProposalCacheModel proposalCacheModel = (ProposalCacheModel)obj;

		if (proposalId == proposalCacheModel.proposalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, proposalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{proposalId=");
		sb.append(proposalId);
		sb.append(", campaignTitle=");
		sb.append(campaignTitle);
		sb.append(", client=");
		sb.append(client);
		sb.append(", pptFileId=");
		sb.append(pptFileId);
		sb.append(", xlsxFileId=");
		sb.append(xlsxFileId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Proposal toEntityModel() {
		ProposalImpl proposalImpl = new ProposalImpl();

		proposalImpl.setProposalId(proposalId);

		if (campaignTitle == null) {
			proposalImpl.setCampaignTitle(StringPool.BLANK);
		}
		else {
			proposalImpl.setCampaignTitle(campaignTitle);
		}

		proposalImpl.setClient(client);
		proposalImpl.setPptFileId(pptFileId);
		proposalImpl.setXlsxFileId(xlsxFileId);

		if (startDate == Long.MIN_VALUE) {
			proposalImpl.setStartDate(null);
		}
		else {
			proposalImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			proposalImpl.setEndDate(null);
		}
		else {
			proposalImpl.setEndDate(new Date(endDate));
		}

		if (createDate == Long.MIN_VALUE) {
			proposalImpl.setCreateDate(null);
		}
		else {
			proposalImpl.setCreateDate(new Date(createDate));
		}

		proposalImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			proposalImpl.setModifiedDate(null);
		}
		else {
			proposalImpl.setModifiedDate(new Date(modifiedDate));
		}

		proposalImpl.setModifiedBy(modifiedBy);

		proposalImpl.resetOriginalValues();

		return proposalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		proposalId = objectInput.readLong();
		campaignTitle = objectInput.readUTF();

		client = objectInput.readLong();

		pptFileId = objectInput.readLong();

		xlsxFileId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(proposalId);

		if (campaignTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(campaignTitle);
		}

		objectOutput.writeLong(client);

		objectOutput.writeLong(pptFileId);

		objectOutput.writeLong(xlsxFileId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long proposalId;
	public String campaignTitle;
	public long client;
	public long pptFileId;
	public long xlsxFileId;
	public long startDate;
	public long endDate;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}