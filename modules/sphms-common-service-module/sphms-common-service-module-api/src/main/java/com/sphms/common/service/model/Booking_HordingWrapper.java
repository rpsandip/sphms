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
 * This class is a wrapper for {@link Booking_Hording}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Booking_Hording
 * @generated
 */
@ProviderType
public class Booking_HordingWrapper implements Booking_Hording,
	ModelWrapper<Booking_Hording> {
	public Booking_HordingWrapper(Booking_Hording booking_Hording) {
		_booking_Hording = booking_Hording;
	}

	@Override
	public Class<?> getModelClass() {
		return Booking_Hording.class;
	}

	@Override
	public String getModelClassName() {
		return Booking_Hording.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookingId", getBookingId());
		attributes.put("hordingId", getHordingId());
		attributes.put("mountingCharge", getMountingCharge());
		attributes.put("printingCharge", getPrintingCharge());
		attributes.put("units", getUnits());
		attributes.put("hsnNo", getHsnNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
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

		String hsnNo = (String)attributes.get("hsnNo");

		if (hsnNo != null) {
			setHsnNo(hsnNo);
		}
	}

	@Override
	public Booking_Hording toEscapedModel() {
		return new Booking_HordingWrapper(_booking_Hording.toEscapedModel());
	}

	@Override
	public Booking_Hording toUnescapedModel() {
		return new Booking_HordingWrapper(_booking_Hording.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _booking_Hording.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _booking_Hording.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _booking_Hording.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _booking_Hording.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Booking_Hording> toCacheModel() {
		return _booking_Hording.toCacheModel();
	}

	/**
	* Returns the primary key of this booking_ hording.
	*
	* @return the primary key of this booking_ hording
	*/
	@Override
	public com.sphms.common.service.service.persistence.Booking_HordingPK getPrimaryKey() {
		return _booking_Hording.getPrimaryKey();
	}

	/**
	* Returns the mounting charge of this booking_ hording.
	*
	* @return the mounting charge of this booking_ hording
	*/
	@Override
	public double getMountingCharge() {
		return _booking_Hording.getMountingCharge();
	}

	/**
	* Returns the printing charge of this booking_ hording.
	*
	* @return the printing charge of this booking_ hording
	*/
	@Override
	public double getPrintingCharge() {
		return _booking_Hording.getPrintingCharge();
	}

	@Override
	public int compareTo(Booking_Hording booking_Hording) {
		return _booking_Hording.compareTo(booking_Hording);
	}

	/**
	* Returns the units of this booking_ hording.
	*
	* @return the units of this booking_ hording
	*/
	@Override
	public int getUnits() {
		return _booking_Hording.getUnits();
	}

	@Override
	public int hashCode() {
		return _booking_Hording.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _booking_Hording.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Booking_HordingWrapper((Booking_Hording)_booking_Hording.clone());
	}

	/**
	* Returns the hsn no of this booking_ hording.
	*
	* @return the hsn no of this booking_ hording
	*/
	@Override
	public java.lang.String getHsnNo() {
		return _booking_Hording.getHsnNo();
	}

	@Override
	public java.lang.String toString() {
		return _booking_Hording.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _booking_Hording.toXmlString();
	}

	/**
	* Returns the booking ID of this booking_ hording.
	*
	* @return the booking ID of this booking_ hording
	*/
	@Override
	public long getBookingId() {
		return _booking_Hording.getBookingId();
	}

	/**
	* Returns the hording ID of this booking_ hording.
	*
	* @return the hording ID of this booking_ hording
	*/
	@Override
	public long getHordingId() {
		return _booking_Hording.getHordingId();
	}

	@Override
	public void persist() {
		_booking_Hording.persist();
	}

	/**
	* Sets the booking ID of this booking_ hording.
	*
	* @param bookingId the booking ID of this booking_ hording
	*/
	@Override
	public void setBookingId(long bookingId) {
		_booking_Hording.setBookingId(bookingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_booking_Hording.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_booking_Hording.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_booking_Hording.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_booking_Hording.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hording ID of this booking_ hording.
	*
	* @param hordingId the hording ID of this booking_ hording
	*/
	@Override
	public void setHordingId(long hordingId) {
		_booking_Hording.setHordingId(hordingId);
	}

	/**
	* Sets the hsn no of this booking_ hording.
	*
	* @param hsnNo the hsn no of this booking_ hording
	*/
	@Override
	public void setHsnNo(java.lang.String hsnNo) {
		_booking_Hording.setHsnNo(hsnNo);
	}

	/**
	* Sets the mounting charge of this booking_ hording.
	*
	* @param mountingCharge the mounting charge of this booking_ hording
	*/
	@Override
	public void setMountingCharge(double mountingCharge) {
		_booking_Hording.setMountingCharge(mountingCharge);
	}

	@Override
	public void setNew(boolean n) {
		_booking_Hording.setNew(n);
	}

	/**
	* Sets the primary key of this booking_ hording.
	*
	* @param primaryKey the primary key of this booking_ hording
	*/
	@Override
	public void setPrimaryKey(
		com.sphms.common.service.service.persistence.Booking_HordingPK primaryKey) {
		_booking_Hording.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_booking_Hording.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the printing charge of this booking_ hording.
	*
	* @param printingCharge the printing charge of this booking_ hording
	*/
	@Override
	public void setPrintingCharge(double printingCharge) {
		_booking_Hording.setPrintingCharge(printingCharge);
	}

	/**
	* Sets the units of this booking_ hording.
	*
	* @param units the units of this booking_ hording
	*/
	@Override
	public void setUnits(int units) {
		_booking_Hording.setUnits(units);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Booking_HordingWrapper)) {
			return false;
		}

		Booking_HordingWrapper booking_HordingWrapper = (Booking_HordingWrapper)obj;

		if (Objects.equals(_booking_Hording,
					booking_HordingWrapper._booking_Hording)) {
			return true;
		}

		return false;
	}

	@Override
	public Booking_Hording getWrappedModel() {
		return _booking_Hording;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _booking_Hording.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _booking_Hording.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_booking_Hording.resetOriginalValues();
	}

	private final Booking_Hording _booking_Hording;
}