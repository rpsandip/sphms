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
 * This class is a wrapper for {@link Billing_Hording}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_Hording
 * @generated
 */
@ProviderType
public class Billing_HordingWrapper implements Billing_Hording,
	ModelWrapper<Billing_Hording> {
	public Billing_HordingWrapper(Billing_Hording billing_Hording) {
		_billing_Hording = billing_Hording;
	}

	@Override
	public Class<?> getModelClass() {
		return Billing_Hording.class;
	}

	@Override
	public String getModelClassName() {
		return Billing_Hording.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("billingId", getBillingId());
		attributes.put("hordingId", getHordingId());
		attributes.put("totalMountingCharge", getTotalMountingCharge());
		attributes.put("totalPrintingCharge", getTotalPrintingCharge());
		attributes.put("units", getUnits());
		attributes.put("totalHordingCharge", getTotalHordingCharge());
		attributes.put("hsnNo", getHsnNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		Long hordingId = (Long)attributes.get("hordingId");

		if (hordingId != null) {
			setHordingId(hordingId);
		}

		Double totalMountingCharge = (Double)attributes.get(
				"totalMountingCharge");

		if (totalMountingCharge != null) {
			setTotalMountingCharge(totalMountingCharge);
		}

		Double totalPrintingCharge = (Double)attributes.get(
				"totalPrintingCharge");

		if (totalPrintingCharge != null) {
			setTotalPrintingCharge(totalPrintingCharge);
		}

		Integer units = (Integer)attributes.get("units");

		if (units != null) {
			setUnits(units);
		}

		Double totalHordingCharge = (Double)attributes.get("totalHordingCharge");

		if (totalHordingCharge != null) {
			setTotalHordingCharge(totalHordingCharge);
		}

		String hsnNo = (String)attributes.get("hsnNo");

		if (hsnNo != null) {
			setHsnNo(hsnNo);
		}
	}

	@Override
	public Billing_Hording toEscapedModel() {
		return new Billing_HordingWrapper(_billing_Hording.toEscapedModel());
	}

	@Override
	public Billing_Hording toUnescapedModel() {
		return new Billing_HordingWrapper(_billing_Hording.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _billing_Hording.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _billing_Hording.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _billing_Hording.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _billing_Hording.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Billing_Hording> toCacheModel() {
		return _billing_Hording.toCacheModel();
	}

	/**
	* Returns the primary key of this billing_ hording.
	*
	* @return the primary key of this billing_ hording
	*/
	@Override
	public com.sphms.common.service.service.persistence.Billing_HordingPK getPrimaryKey() {
		return _billing_Hording.getPrimaryKey();
	}

	/**
	* Returns the total hording charge of this billing_ hording.
	*
	* @return the total hording charge of this billing_ hording
	*/
	@Override
	public double getTotalHordingCharge() {
		return _billing_Hording.getTotalHordingCharge();
	}

	/**
	* Returns the total mounting charge of this billing_ hording.
	*
	* @return the total mounting charge of this billing_ hording
	*/
	@Override
	public double getTotalMountingCharge() {
		return _billing_Hording.getTotalMountingCharge();
	}

	/**
	* Returns the total printing charge of this billing_ hording.
	*
	* @return the total printing charge of this billing_ hording
	*/
	@Override
	public double getTotalPrintingCharge() {
		return _billing_Hording.getTotalPrintingCharge();
	}

	@Override
	public int compareTo(Billing_Hording billing_Hording) {
		return _billing_Hording.compareTo(billing_Hording);
	}

	/**
	* Returns the units of this billing_ hording.
	*
	* @return the units of this billing_ hording
	*/
	@Override
	public int getUnits() {
		return _billing_Hording.getUnits();
	}

	@Override
	public int hashCode() {
		return _billing_Hording.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _billing_Hording.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Billing_HordingWrapper((Billing_Hording)_billing_Hording.clone());
	}

	/**
	* Returns the hsn no of this billing_ hording.
	*
	* @return the hsn no of this billing_ hording
	*/
	@Override
	public java.lang.String getHsnNo() {
		return _billing_Hording.getHsnNo();
	}

	@Override
	public java.lang.String toString() {
		return _billing_Hording.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _billing_Hording.toXmlString();
	}

	/**
	* Returns the billing ID of this billing_ hording.
	*
	* @return the billing ID of this billing_ hording
	*/
	@Override
	public long getBillingId() {
		return _billing_Hording.getBillingId();
	}

	/**
	* Returns the hording ID of this billing_ hording.
	*
	* @return the hording ID of this billing_ hording
	*/
	@Override
	public long getHordingId() {
		return _billing_Hording.getHordingId();
	}

	@Override
	public void persist() {
		_billing_Hording.persist();
	}

	/**
	* Sets the billing ID of this billing_ hording.
	*
	* @param billingId the billing ID of this billing_ hording
	*/
	@Override
	public void setBillingId(long billingId) {
		_billing_Hording.setBillingId(billingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_billing_Hording.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_billing_Hording.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_billing_Hording.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_billing_Hording.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hording ID of this billing_ hording.
	*
	* @param hordingId the hording ID of this billing_ hording
	*/
	@Override
	public void setHordingId(long hordingId) {
		_billing_Hording.setHordingId(hordingId);
	}

	/**
	* Sets the hsn no of this billing_ hording.
	*
	* @param hsnNo the hsn no of this billing_ hording
	*/
	@Override
	public void setHsnNo(java.lang.String hsnNo) {
		_billing_Hording.setHsnNo(hsnNo);
	}

	@Override
	public void setNew(boolean n) {
		_billing_Hording.setNew(n);
	}

	/**
	* Sets the primary key of this billing_ hording.
	*
	* @param primaryKey the primary key of this billing_ hording
	*/
	@Override
	public void setPrimaryKey(
		com.sphms.common.service.service.persistence.Billing_HordingPK primaryKey) {
		_billing_Hording.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_billing_Hording.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the total hording charge of this billing_ hording.
	*
	* @param totalHordingCharge the total hording charge of this billing_ hording
	*/
	@Override
	public void setTotalHordingCharge(double totalHordingCharge) {
		_billing_Hording.setTotalHordingCharge(totalHordingCharge);
	}

	/**
	* Sets the total mounting charge of this billing_ hording.
	*
	* @param totalMountingCharge the total mounting charge of this billing_ hording
	*/
	@Override
	public void setTotalMountingCharge(double totalMountingCharge) {
		_billing_Hording.setTotalMountingCharge(totalMountingCharge);
	}

	/**
	* Sets the total printing charge of this billing_ hording.
	*
	* @param totalPrintingCharge the total printing charge of this billing_ hording
	*/
	@Override
	public void setTotalPrintingCharge(double totalPrintingCharge) {
		_billing_Hording.setTotalPrintingCharge(totalPrintingCharge);
	}

	/**
	* Sets the units of this billing_ hording.
	*
	* @param units the units of this billing_ hording
	*/
	@Override
	public void setUnits(int units) {
		_billing_Hording.setUnits(units);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Billing_HordingWrapper)) {
			return false;
		}

		Billing_HordingWrapper billing_HordingWrapper = (Billing_HordingWrapper)obj;

		if (Objects.equals(_billing_Hording,
					billing_HordingWrapper._billing_Hording)) {
			return true;
		}

		return false;
	}

	@Override
	public Billing_Hording getWrappedModel() {
		return _billing_Hording;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _billing_Hording.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _billing_Hording.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_billing_Hording.resetOriginalValues();
	}

	private final Billing_Hording _billing_Hording;
}