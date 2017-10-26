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
 * This class is a wrapper for {@link Hording}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Hording
 * @generated
 */
@ProviderType
public class HordingWrapper implements Hording, ModelWrapper<Hording> {
	public HordingWrapper(Hording hording) {
		_hording = hording;
	}

	@Override
	public Class<?> getModelClass() {
		return Hording.class;
	}

	@Override
	public String getModelClassName() {
		return Hording.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hordingId", getHordingId());
		attributes.put("title", getTitle());
		attributes.put("location", getLocation());
		attributes.put("city", getCity());
		attributes.put("district", getDistrict());
		attributes.put("state", getState());
		attributes.put("hordingType", getHordingType());
		attributes.put("mediaVehicle", getMediaVehicle());
		attributes.put("size", getSize());
		attributes.put("pricePerMonth", getPricePerMonth());
		attributes.put("normalImageId", getNormalImageId());
		attributes.put("shortImageId", getShortImageId());
		attributes.put("longImageId", getLongImageId());
		attributes.put("landLordId", getLandLordId());
		attributes.put("ownerType", getOwnerType());
		attributes.put("upinNo", getUpinNo());
		attributes.put("mncTax", getMncTax());
		attributes.put("otherExpYear", getOtherExpYear());
		attributes.put("status", getStatus());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long hordingId = (Long)attributes.get("hordingId");

		if (hordingId != null) {
			setHordingId(hordingId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String district = (String)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String hordingType = (String)attributes.get("hordingType");

		if (hordingType != null) {
			setHordingType(hordingType);
		}

		String mediaVehicle = (String)attributes.get("mediaVehicle");

		if (mediaVehicle != null) {
			setMediaVehicle(mediaVehicle);
		}

		String size = (String)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		Double pricePerMonth = (Double)attributes.get("pricePerMonth");

		if (pricePerMonth != null) {
			setPricePerMonth(pricePerMonth);
		}

		Long normalImageId = (Long)attributes.get("normalImageId");

		if (normalImageId != null) {
			setNormalImageId(normalImageId);
		}

		Long shortImageId = (Long)attributes.get("shortImageId");

		if (shortImageId != null) {
			setShortImageId(shortImageId);
		}

		Long longImageId = (Long)attributes.get("longImageId");

		if (longImageId != null) {
			setLongImageId(longImageId);
		}

		Long landLordId = (Long)attributes.get("landLordId");

		if (landLordId != null) {
			setLandLordId(landLordId);
		}

		Integer ownerType = (Integer)attributes.get("ownerType");

		if (ownerType != null) {
			setOwnerType(ownerType);
		}

		String upinNo = (String)attributes.get("upinNo");

		if (upinNo != null) {
			setUpinNo(upinNo);
		}

		Double mncTax = (Double)attributes.get("mncTax");

		if (mncTax != null) {
			setMncTax(mncTax);
		}

		Double otherExpYear = (Double)attributes.get("otherExpYear");

		if (otherExpYear != null) {
			setOtherExpYear(otherExpYear);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public Hording toEscapedModel() {
		return new HordingWrapper(_hording.toEscapedModel());
	}

	@Override
	public Hording toUnescapedModel() {
		return new HordingWrapper(_hording.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _hording.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _hording.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _hording.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _hording.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Hording> toCacheModel() {
		return _hording.toCacheModel();
	}

	/**
	* Returns the mnc tax of this hording.
	*
	* @return the mnc tax of this hording
	*/
	@Override
	public double getMncTax() {
		return _hording.getMncTax();
	}

	/**
	* Returns the other exp year of this hording.
	*
	* @return the other exp year of this hording
	*/
	@Override
	public double getOtherExpYear() {
		return _hording.getOtherExpYear();
	}

	/**
	* Returns the price per month of this hording.
	*
	* @return the price per month of this hording
	*/
	@Override
	public double getPricePerMonth() {
		return _hording.getPricePerMonth();
	}

	@Override
	public int compareTo(Hording hording) {
		return _hording.compareTo(hording);
	}

	/**
	* Returns the owner type of this hording.
	*
	* @return the owner type of this hording
	*/
	@Override
	public int getOwnerType() {
		return _hording.getOwnerType();
	}

	/**
	* Returns the status of this hording.
	*
	* @return the status of this hording
	*/
	@Override
	public int getStatus() {
		return _hording.getStatus();
	}

	@Override
	public int hashCode() {
		return _hording.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hording.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new HordingWrapper((Hording)_hording.clone());
	}

	/**
	* Returns the city of this hording.
	*
	* @return the city of this hording
	*/
	@Override
	public java.lang.String getCity() {
		return _hording.getCity();
	}

	/**
	* Returns the district of this hording.
	*
	* @return the district of this hording
	*/
	@Override
	public java.lang.String getDistrict() {
		return _hording.getDistrict();
	}

	/**
	* Returns the hording type of this hording.
	*
	* @return the hording type of this hording
	*/
	@Override
	public java.lang.String getHordingType() {
		return _hording.getHordingType();
	}

	/**
	* Returns the location of this hording.
	*
	* @return the location of this hording
	*/
	@Override
	public java.lang.String getLocation() {
		return _hording.getLocation();
	}

	/**
	* Returns the media vehicle of this hording.
	*
	* @return the media vehicle of this hording
	*/
	@Override
	public java.lang.String getMediaVehicle() {
		return _hording.getMediaVehicle();
	}

	/**
	* Returns the size of this hording.
	*
	* @return the size of this hording
	*/
	@Override
	public java.lang.String getSize() {
		return _hording.getSize();
	}

	/**
	* Returns the state of this hording.
	*
	* @return the state of this hording
	*/
	@Override
	public java.lang.String getState() {
		return _hording.getState();
	}

	/**
	* Returns the title of this hording.
	*
	* @return the title of this hording
	*/
	@Override
	public java.lang.String getTitle() {
		return _hording.getTitle();
	}

	/**
	* Returns the upin no of this hording.
	*
	* @return the upin no of this hording
	*/
	@Override
	public java.lang.String getUpinNo() {
		return _hording.getUpinNo();
	}

	@Override
	public java.lang.String toString() {
		return _hording.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _hording.toXmlString();
	}

	/**
	* Returns the create date of this hording.
	*
	* @return the create date of this hording
	*/
	@Override
	public Date getCreateDate() {
		return _hording.getCreateDate();
	}

	/**
	* Returns the modified date of this hording.
	*
	* @return the modified date of this hording
	*/
	@Override
	public Date getModifiedDate() {
		return _hording.getModifiedDate();
	}

	/**
	* Returns the created by of this hording.
	*
	* @return the created by of this hording
	*/
	@Override
	public long getCreatedBy() {
		return _hording.getCreatedBy();
	}

	/**
	* Returns the hording ID of this hording.
	*
	* @return the hording ID of this hording
	*/
	@Override
	public long getHordingId() {
		return _hording.getHordingId();
	}

	/**
	* Returns the land lord ID of this hording.
	*
	* @return the land lord ID of this hording
	*/
	@Override
	public long getLandLordId() {
		return _hording.getLandLordId();
	}

	/**
	* Returns the long image ID of this hording.
	*
	* @return the long image ID of this hording
	*/
	@Override
	public long getLongImageId() {
		return _hording.getLongImageId();
	}

	/**
	* Returns the modified by of this hording.
	*
	* @return the modified by of this hording
	*/
	@Override
	public long getModifiedBy() {
		return _hording.getModifiedBy();
	}

	/**
	* Returns the normal image ID of this hording.
	*
	* @return the normal image ID of this hording
	*/
	@Override
	public long getNormalImageId() {
		return _hording.getNormalImageId();
	}

	/**
	* Returns the primary key of this hording.
	*
	* @return the primary key of this hording
	*/
	@Override
	public long getPrimaryKey() {
		return _hording.getPrimaryKey();
	}

	/**
	* Returns the short image ID of this hording.
	*
	* @return the short image ID of this hording
	*/
	@Override
	public long getShortImageId() {
		return _hording.getShortImageId();
	}

	@Override
	public void persist() {
		_hording.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_hording.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this hording.
	*
	* @param city the city of this hording
	*/
	@Override
	public void setCity(java.lang.String city) {
		_hording.setCity(city);
	}

	/**
	* Sets the create date of this hording.
	*
	* @param createDate the create date of this hording
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_hording.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this hording.
	*
	* @param createdBy the created by of this hording
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_hording.setCreatedBy(createdBy);
	}

	/**
	* Sets the district of this hording.
	*
	* @param district the district of this hording
	*/
	@Override
	public void setDistrict(java.lang.String district) {
		_hording.setDistrict(district);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_hording.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_hording.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_hording.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hording ID of this hording.
	*
	* @param hordingId the hording ID of this hording
	*/
	@Override
	public void setHordingId(long hordingId) {
		_hording.setHordingId(hordingId);
	}

	/**
	* Sets the hording type of this hording.
	*
	* @param hordingType the hording type of this hording
	*/
	@Override
	public void setHordingType(java.lang.String hordingType) {
		_hording.setHordingType(hordingType);
	}

	/**
	* Sets the land lord ID of this hording.
	*
	* @param landLordId the land lord ID of this hording
	*/
	@Override
	public void setLandLordId(long landLordId) {
		_hording.setLandLordId(landLordId);
	}

	/**
	* Sets the location of this hording.
	*
	* @param location the location of this hording
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_hording.setLocation(location);
	}

	/**
	* Sets the long image ID of this hording.
	*
	* @param longImageId the long image ID of this hording
	*/
	@Override
	public void setLongImageId(long longImageId) {
		_hording.setLongImageId(longImageId);
	}

	/**
	* Sets the media vehicle of this hording.
	*
	* @param mediaVehicle the media vehicle of this hording
	*/
	@Override
	public void setMediaVehicle(java.lang.String mediaVehicle) {
		_hording.setMediaVehicle(mediaVehicle);
	}

	/**
	* Sets the mnc tax of this hording.
	*
	* @param mncTax the mnc tax of this hording
	*/
	@Override
	public void setMncTax(double mncTax) {
		_hording.setMncTax(mncTax);
	}

	/**
	* Sets the modified by of this hording.
	*
	* @param modifiedBy the modified by of this hording
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_hording.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this hording.
	*
	* @param modifiedDate the modified date of this hording
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_hording.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_hording.setNew(n);
	}

	/**
	* Sets the normal image ID of this hording.
	*
	* @param normalImageId the normal image ID of this hording
	*/
	@Override
	public void setNormalImageId(long normalImageId) {
		_hording.setNormalImageId(normalImageId);
	}

	/**
	* Sets the other exp year of this hording.
	*
	* @param otherExpYear the other exp year of this hording
	*/
	@Override
	public void setOtherExpYear(double otherExpYear) {
		_hording.setOtherExpYear(otherExpYear);
	}

	/**
	* Sets the owner type of this hording.
	*
	* @param ownerType the owner type of this hording
	*/
	@Override
	public void setOwnerType(int ownerType) {
		_hording.setOwnerType(ownerType);
	}

	/**
	* Sets the price per month of this hording.
	*
	* @param pricePerMonth the price per month of this hording
	*/
	@Override
	public void setPricePerMonth(double pricePerMonth) {
		_hording.setPricePerMonth(pricePerMonth);
	}

	/**
	* Sets the primary key of this hording.
	*
	* @param primaryKey the primary key of this hording
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_hording.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_hording.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the short image ID of this hording.
	*
	* @param shortImageId the short image ID of this hording
	*/
	@Override
	public void setShortImageId(long shortImageId) {
		_hording.setShortImageId(shortImageId);
	}

	/**
	* Sets the size of this hording.
	*
	* @param size the size of this hording
	*/
	@Override
	public void setSize(java.lang.String size) {
		_hording.setSize(size);
	}

	/**
	* Sets the state of this hording.
	*
	* @param state the state of this hording
	*/
	@Override
	public void setState(java.lang.String state) {
		_hording.setState(state);
	}

	/**
	* Sets the status of this hording.
	*
	* @param status the status of this hording
	*/
	@Override
	public void setStatus(int status) {
		_hording.setStatus(status);
	}

	/**
	* Sets the title of this hording.
	*
	* @param title the title of this hording
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_hording.setTitle(title);
	}

	/**
	* Sets the upin no of this hording.
	*
	* @param upinNo the upin no of this hording
	*/
	@Override
	public void setUpinNo(java.lang.String upinNo) {
		_hording.setUpinNo(upinNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HordingWrapper)) {
			return false;
		}

		HordingWrapper hordingWrapper = (HordingWrapper)obj;

		if (Objects.equals(_hording, hordingWrapper._hording)) {
			return true;
		}

		return false;
	}

	@Override
	public Hording getWrappedModel() {
		return _hording;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _hording.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _hording.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_hording.resetOriginalValues();
	}

	private final Hording _hording;
}