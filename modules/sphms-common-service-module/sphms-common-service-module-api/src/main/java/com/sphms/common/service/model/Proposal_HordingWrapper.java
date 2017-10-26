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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Proposal_Hording}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal_Hording
 * @generated
 */
@ProviderType
public class Proposal_HordingWrapper implements Proposal_Hording,
	ModelWrapper<Proposal_Hording> {
	public Proposal_HordingWrapper(Proposal_Hording proposal_Hording) {
		_proposal_Hording = proposal_Hording;
	}

	@Override
	public Class<?> getModelClass() {
		return Proposal_Hording.class;
	}

	@Override
	public String getModelClassName() {
		return Proposal_Hording.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proposalId", getProposalId());
		attributes.put("hordingId", getHordingId());
		attributes.put("mountingCharge", getMountingCharge());
		attributes.put("printingCharge", getPrintingCharge());
		attributes.put("units", getUnits());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proposalId = (Long)attributes.get("proposalId");

		if (proposalId != null) {
			setProposalId(proposalId);
		}

		Long hordingId = (Long)attributes.get("hordingId");

		if (hordingId != null) {
			setHordingId(hordingId);
		}

		Double mountingCharge = (Double)attributes.get("mountingCharge");

		if (mountingCharge != null) {
			setMountingCharge(mountingCharge);
		}

		Double printingCharge = (Double)attributes.get("printingCharge");

		if (printingCharge != null) {
			setPrintingCharge(printingCharge);
		}

		Integer units = (Integer)attributes.get("units");

		if (units != null) {
			setUnits(units);
		}
	}

	@Override
	public Proposal_Hording toEscapedModel() {
		return new Proposal_HordingWrapper(_proposal_Hording.toEscapedModel());
	}

	@Override
	public Proposal_Hording toUnescapedModel() {
		return new Proposal_HordingWrapper(_proposal_Hording.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _proposal_Hording.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _proposal_Hording.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _proposal_Hording.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _proposal_Hording.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Proposal_Hording> toCacheModel() {
		return _proposal_Hording.toCacheModel();
	}

	/**
	* Returns the primary key of this proposal_ hording.
	*
	* @return the primary key of this proposal_ hording
	*/
	@Override
	public com.sphms.common.service.service.persistence.Proposal_HordingPK getPrimaryKey() {
		return _proposal_Hording.getPrimaryKey();
	}

	/**
	* Returns the mounting charge of this proposal_ hording.
	*
	* @return the mounting charge of this proposal_ hording
	*/
	@Override
	public double getMountingCharge() {
		return _proposal_Hording.getMountingCharge();
	}

	/**
	* Returns the printing charge of this proposal_ hording.
	*
	* @return the printing charge of this proposal_ hording
	*/
	@Override
	public double getPrintingCharge() {
		return _proposal_Hording.getPrintingCharge();
	}

	@Override
	public int compareTo(Proposal_Hording proposal_Hording) {
		return _proposal_Hording.compareTo(proposal_Hording);
	}

	/**
	* Returns the units of this proposal_ hording.
	*
	* @return the units of this proposal_ hording
	*/
	@Override
	public int getUnits() {
		return _proposal_Hording.getUnits();
	}

	@Override
	public int hashCode() {
		return _proposal_Hording.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _proposal_Hording.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Proposal_HordingWrapper((Proposal_Hording)_proposal_Hording.clone());
	}

	@Override
	public java.lang.String toString() {
		return _proposal_Hording.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _proposal_Hording.toXmlString();
	}

	/**
	* Returns the hording ID of this proposal_ hording.
	*
	* @return the hording ID of this proposal_ hording
	*/
	@Override
	public long getHordingId() {
		return _proposal_Hording.getHordingId();
	}

	/**
	* Returns the proposal ID of this proposal_ hording.
	*
	* @return the proposal ID of this proposal_ hording
	*/
	@Override
	public long getProposalId() {
		return _proposal_Hording.getProposalId();
	}

	@Override
	public void persist() {
		_proposal_Hording.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_proposal_Hording.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_proposal_Hording.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_proposal_Hording.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_proposal_Hording.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hording ID of this proposal_ hording.
	*
	* @param hordingId the hording ID of this proposal_ hording
	*/
	@Override
	public void setHordingId(long hordingId) {
		_proposal_Hording.setHordingId(hordingId);
	}

	/**
	* Sets the mounting charge of this proposal_ hording.
	*
	* @param mountingCharge the mounting charge of this proposal_ hording
	*/
	@Override
	public void setMountingCharge(double mountingCharge) {
		_proposal_Hording.setMountingCharge(mountingCharge);
	}

	@Override
	public void setNew(boolean n) {
		_proposal_Hording.setNew(n);
	}

	/**
	* Sets the primary key of this proposal_ hording.
	*
	* @param primaryKey the primary key of this proposal_ hording
	*/
	@Override
	public void setPrimaryKey(
		com.sphms.common.service.service.persistence.Proposal_HordingPK primaryKey) {
		_proposal_Hording.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_proposal_Hording.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the printing charge of this proposal_ hording.
	*
	* @param printingCharge the printing charge of this proposal_ hording
	*/
	@Override
	public void setPrintingCharge(double printingCharge) {
		_proposal_Hording.setPrintingCharge(printingCharge);
	}

	/**
	* Sets the proposal ID of this proposal_ hording.
	*
	* @param proposalId the proposal ID of this proposal_ hording
	*/
	@Override
	public void setProposalId(long proposalId) {
		_proposal_Hording.setProposalId(proposalId);
	}

	/**
	* Sets the units of this proposal_ hording.
	*
	* @param units the units of this proposal_ hording
	*/
	@Override
	public void setUnits(int units) {
		_proposal_Hording.setUnits(units);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Proposal_HordingWrapper)) {
			return false;
		}

		Proposal_HordingWrapper proposal_HordingWrapper = (Proposal_HordingWrapper)obj;

		if (Objects.equals(_proposal_Hording,
					proposal_HordingWrapper._proposal_Hording)) {
			return true;
		}

		return false;
	}

	@Override
	public Proposal_Hording getWrappedModel() {
		return _proposal_Hording;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _proposal_Hording.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _proposal_Hording.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_proposal_Hording.resetOriginalValues();
	}

	private final Proposal_Hording _proposal_Hording;
}