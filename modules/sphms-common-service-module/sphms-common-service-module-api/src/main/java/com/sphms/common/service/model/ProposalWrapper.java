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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Proposal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal
 * @generated
 */
@ProviderType
public class ProposalWrapper implements Proposal, ModelWrapper<Proposal> {
	public ProposalWrapper(Proposal proposal) {
		_proposal = proposal;
	}

	@Override
	public Class<?> getModelClass() {
		return Proposal.class;
	}

	@Override
	public String getModelClassName() {
		return Proposal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proposalId", getProposalId());
		attributes.put("campaignTitle", getCampaignTitle());
		attributes.put("client", getClient());
		attributes.put("pptFileId", getPptFileId());
		attributes.put("xlsxFileId", getXlsxFileId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proposalId = (Long)attributes.get("proposalId");

		if (proposalId != null) {
			setProposalId(proposalId);
		}

		String campaignTitle = (String)attributes.get("campaignTitle");

		if (campaignTitle != null) {
			setCampaignTitle(campaignTitle);
		}

		Long client = (Long)attributes.get("client");

		if (client != null) {
			setClient(client);
		}

		Long pptFileId = (Long)attributes.get("pptFileId");

		if (pptFileId != null) {
			setPptFileId(pptFileId);
		}

		Long xlsxFileId = (Long)attributes.get("xlsxFileId");

		if (xlsxFileId != null) {
			setXlsxFileId(xlsxFileId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public Proposal toEscapedModel() {
		return new ProposalWrapper(_proposal.toEscapedModel());
	}

	@Override
	public Proposal toUnescapedModel() {
		return new ProposalWrapper(_proposal.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _proposal.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _proposal.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _proposal.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _proposal.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Proposal> toCacheModel() {
		return _proposal.toCacheModel();
	}

	@Override
	public int compareTo(Proposal proposal) {
		return _proposal.compareTo(proposal);
	}

	@Override
	public int hashCode() {
		return _proposal.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _proposal.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ProposalWrapper((Proposal)_proposal.clone());
	}

	/**
	* Returns the campaign title of this proposal.
	*
	* @return the campaign title of this proposal
	*/
	@Override
	public java.lang.String getCampaignTitle() {
		return _proposal.getCampaignTitle();
	}

	@Override
	public java.lang.String toString() {
		return _proposal.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _proposal.toXmlString();
	}

	/**
	* Returns the create date of this proposal.
	*
	* @return the create date of this proposal
	*/
	@Override
	public Date getCreateDate() {
		return _proposal.getCreateDate();
	}

	/**
	* Returns the end date of this proposal.
	*
	* @return the end date of this proposal
	*/
	@Override
	public Date getEndDate() {
		return _proposal.getEndDate();
	}

	/**
	* Returns the modified date of this proposal.
	*
	* @return the modified date of this proposal
	*/
	@Override
	public Date getModifiedDate() {
		return _proposal.getModifiedDate();
	}

	/**
	* Returns the start date of this proposal.
	*
	* @return the start date of this proposal
	*/
	@Override
	public Date getStartDate() {
		return _proposal.getStartDate();
	}

	/**
	* Returns the client of this proposal.
	*
	* @return the client of this proposal
	*/
	@Override
	public long getClient() {
		return _proposal.getClient();
	}

	/**
	* Returns the created by of this proposal.
	*
	* @return the created by of this proposal
	*/
	@Override
	public long getCreatedBy() {
		return _proposal.getCreatedBy();
	}

	/**
	* Returns the modified by of this proposal.
	*
	* @return the modified by of this proposal
	*/
	@Override
	public long getModifiedBy() {
		return _proposal.getModifiedBy();
	}

	/**
	* Returns the ppt file ID of this proposal.
	*
	* @return the ppt file ID of this proposal
	*/
	@Override
	public long getPptFileId() {
		return _proposal.getPptFileId();
	}

	/**
	* Returns the primary key of this proposal.
	*
	* @return the primary key of this proposal
	*/
	@Override
	public long getPrimaryKey() {
		return _proposal.getPrimaryKey();
	}

	/**
	* Returns the proposal ID of this proposal.
	*
	* @return the proposal ID of this proposal
	*/
	@Override
	public long getProposalId() {
		return _proposal.getProposalId();
	}

	/**
	* Returns the xlsx file ID of this proposal.
	*
	* @return the xlsx file ID of this proposal
	*/
	@Override
	public long getXlsxFileId() {
		return _proposal.getXlsxFileId();
	}

	@Override
	public void persist() {
		_proposal.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_proposal.setCachedModel(cachedModel);
	}

	/**
	* Sets the campaign title of this proposal.
	*
	* @param campaignTitle the campaign title of this proposal
	*/
	@Override
	public void setCampaignTitle(java.lang.String campaignTitle) {
		_proposal.setCampaignTitle(campaignTitle);
	}

	/**
	* Sets the client of this proposal.
	*
	* @param client the client of this proposal
	*/
	@Override
	public void setClient(long client) {
		_proposal.setClient(client);
	}

	/**
	* Sets the create date of this proposal.
	*
	* @param createDate the create date of this proposal
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_proposal.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this proposal.
	*
	* @param createdBy the created by of this proposal
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_proposal.setCreatedBy(createdBy);
	}

	/**
	* Sets the end date of this proposal.
	*
	* @param endDate the end date of this proposal
	*/
	@Override
	public void setEndDate(Date endDate) {
		_proposal.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_proposal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_proposal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_proposal.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this proposal.
	*
	* @param modifiedBy the modified by of this proposal
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_proposal.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this proposal.
	*
	* @param modifiedDate the modified date of this proposal
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_proposal.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_proposal.setNew(n);
	}

	/**
	* Sets the ppt file ID of this proposal.
	*
	* @param pptFileId the ppt file ID of this proposal
	*/
	@Override
	public void setPptFileId(long pptFileId) {
		_proposal.setPptFileId(pptFileId);
	}

	/**
	* Sets the primary key of this proposal.
	*
	* @param primaryKey the primary key of this proposal
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_proposal.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_proposal.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the proposal ID of this proposal.
	*
	* @param proposalId the proposal ID of this proposal
	*/
	@Override
	public void setProposalId(long proposalId) {
		_proposal.setProposalId(proposalId);
	}

	/**
	* Sets the start date of this proposal.
	*
	* @param startDate the start date of this proposal
	*/
	@Override
	public void setStartDate(Date startDate) {
		_proposal.setStartDate(startDate);
	}

	/**
	* Sets the xlsx file ID of this proposal.
	*
	* @param xlsxFileId the xlsx file ID of this proposal
	*/
	@Override
	public void setXlsxFileId(long xlsxFileId) {
		_proposal.setXlsxFileId(xlsxFileId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProposalWrapper)) {
			return false;
		}

		ProposalWrapper proposalWrapper = (ProposalWrapper)obj;

		if (Objects.equals(_proposal, proposalWrapper._proposal)) {
			return true;
		}

		return false;
	}

	@Override
	public Proposal getWrappedModel() {
		return _proposal;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _proposal.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _proposal.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_proposal.resetOriginalValues();
	}

	private final Proposal _proposal;
}