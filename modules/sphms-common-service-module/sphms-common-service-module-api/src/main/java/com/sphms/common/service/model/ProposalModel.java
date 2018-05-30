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

package com.sphms.common.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Proposal service. Represents a row in the &quot;SPHMS_Proposal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sphms.common.service.model.impl.ProposalModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sphms.common.service.model.impl.ProposalImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal
 * @see com.sphms.common.service.model.impl.ProposalImpl
 * @see com.sphms.common.service.model.impl.ProposalModelImpl
 * @generated
 */
@ProviderType
public interface ProposalModel extends BaseModel<Proposal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a proposal model instance should use the {@link Proposal} interface instead.
	 */

	/**
	 * Returns the primary key of this proposal.
	 *
	 * @return the primary key of this proposal
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this proposal.
	 *
	 * @param primaryKey the primary key of this proposal
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the proposal ID of this proposal.
	 *
	 * @return the proposal ID of this proposal
	 */
	public long getProposalId();

	/**
	 * Sets the proposal ID of this proposal.
	 *
	 * @param proposalId the proposal ID of this proposal
	 */
	public void setProposalId(long proposalId);

	/**
	 * Returns the campaign title of this proposal.
	 *
	 * @return the campaign title of this proposal
	 */
	@AutoEscape
	public String getCampaignTitle();

	/**
	 * Sets the campaign title of this proposal.
	 *
	 * @param campaignTitle the campaign title of this proposal
	 */
	public void setCampaignTitle(String campaignTitle);

	/**
	 * Returns the client of this proposal.
	 *
	 * @return the client of this proposal
	 */
	public long getClient();

	/**
	 * Sets the client of this proposal.
	 *
	 * @param client the client of this proposal
	 */
	public void setClient(long client);

	/**
	 * Returns the ppt file ID of this proposal.
	 *
	 * @return the ppt file ID of this proposal
	 */
	public long getPptFileId();

	/**
	 * Sets the ppt file ID of this proposal.
	 *
	 * @param pptFileId the ppt file ID of this proposal
	 */
	public void setPptFileId(long pptFileId);

	/**
	 * Returns the xlsx file ID of this proposal.
	 *
	 * @return the xlsx file ID of this proposal
	 */
	public long getXlsxFileId();

	/**
	 * Sets the xlsx file ID of this proposal.
	 *
	 * @param xlsxFileId the xlsx file ID of this proposal
	 */
	public void setXlsxFileId(long xlsxFileId);

	/**
	 * Returns the start date of this proposal.
	 *
	 * @return the start date of this proposal
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this proposal.
	 *
	 * @param startDate the start date of this proposal
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this proposal.
	 *
	 * @return the end date of this proposal
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this proposal.
	 *
	 * @param endDate the end date of this proposal
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the create date of this proposal.
	 *
	 * @return the create date of this proposal
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this proposal.
	 *
	 * @param createDate the create date of this proposal
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this proposal.
	 *
	 * @return the created by of this proposal
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this proposal.
	 *
	 * @param createdBy the created by of this proposal
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this proposal.
	 *
	 * @return the modified date of this proposal
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this proposal.
	 *
	 * @param modifiedDate the modified date of this proposal
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this proposal.
	 *
	 * @return the modified by of this proposal
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this proposal.
	 *
	 * @param modifiedBy the modified by of this proposal
	 */
	public void setModifiedBy(long modifiedBy);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Proposal proposal);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Proposal> toCacheModel();

	@Override
	public Proposal toEscapedModel();

	@Override
	public Proposal toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}