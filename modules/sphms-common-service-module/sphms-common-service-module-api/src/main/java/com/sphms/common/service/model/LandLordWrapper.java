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
 * This class is a wrapper for {@link LandLord}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLord
 * @generated
 */
@ProviderType
public class LandLordWrapper implements LandLord, ModelWrapper<LandLord> {
	public LandLordWrapper(LandLord landLord) {
		_landLord = landLord;
	}

	@Override
	public Class<?> getModelClass() {
		return LandLord.class;
	}

	@Override
	public String getModelClassName() {
		return LandLord.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("landLordId", getLandLordId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("location", getLocation());
		attributes.put("city", getCity());
		attributes.put("statec", getStatec());
		attributes.put("status", getStatus());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long landLordId = (Long)attributes.get("landLordId");

		if (landLordId != null) {
			setLandLordId(landLordId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String statec = (String)attributes.get("statec");

		if (statec != null) {
			setStatec(statec);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String phoneNo = (String)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	@Override
	public LandLord toEscapedModel() {
		return new LandLordWrapper(_landLord.toEscapedModel());
	}

	@Override
	public LandLord toUnescapedModel() {
		return new LandLordWrapper(_landLord.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _landLord.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _landLord.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _landLord.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _landLord.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LandLord> toCacheModel() {
		return _landLord.toCacheModel();
	}

	@Override
	public int compareTo(LandLord landLord) {
		return _landLord.compareTo(landLord);
	}

	/**
	* Returns the status of this land lord.
	*
	* @return the status of this land lord
	*/
	@Override
	public int getStatus() {
		return _landLord.getStatus();
	}

	@Override
	public int hashCode() {
		return _landLord.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _landLord.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LandLordWrapper((LandLord)_landLord.clone());
	}

	/**
	* Returns the city of this land lord.
	*
	* @return the city of this land lord
	*/
	@Override
	public java.lang.String getCity() {
		return _landLord.getCity();
	}

	/**
	* Returns the first name of this land lord.
	*
	* @return the first name of this land lord
	*/
	@Override
	public java.lang.String getFirstName() {
		return _landLord.getFirstName();
	}

	/**
	* Returns the last name of this land lord.
	*
	* @return the last name of this land lord
	*/
	@Override
	public java.lang.String getLastName() {
		return _landLord.getLastName();
	}

	/**
	* Returns the location of this land lord.
	*
	* @return the location of this land lord
	*/
	@Override
	public java.lang.String getLocation() {
		return _landLord.getLocation();
	}

	/**
	* Returns the phone no of this land lord.
	*
	* @return the phone no of this land lord
	*/
	@Override
	public java.lang.String getPhoneNo() {
		return _landLord.getPhoneNo();
	}

	/**
	* Returns the statec of this land lord.
	*
	* @return the statec of this land lord
	*/
	@Override
	public java.lang.String getStatec() {
		return _landLord.getStatec();
	}

	@Override
	public java.lang.String toString() {
		return _landLord.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _landLord.toXmlString();
	}

	/**
	* Returns the create date of this land lord.
	*
	* @return the create date of this land lord
	*/
	@Override
	public Date getCreateDate() {
		return _landLord.getCreateDate();
	}

	/**
	* Returns the created by of this land lord.
	*
	* @return the created by of this land lord
	*/
	@Override
	public long getCreatedBy() {
		return _landLord.getCreatedBy();
	}

	/**
	* Returns the land lord ID of this land lord.
	*
	* @return the land lord ID of this land lord
	*/
	@Override
	public long getLandLordId() {
		return _landLord.getLandLordId();
	}

	/**
	* Returns the primary key of this land lord.
	*
	* @return the primary key of this land lord
	*/
	@Override
	public long getPrimaryKey() {
		return _landLord.getPrimaryKey();
	}

	@Override
	public void persist() {
		_landLord.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_landLord.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this land lord.
	*
	* @param city the city of this land lord
	*/
	@Override
	public void setCity(java.lang.String city) {
		_landLord.setCity(city);
	}

	/**
	* Sets the create date of this land lord.
	*
	* @param createDate the create date of this land lord
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_landLord.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this land lord.
	*
	* @param createdBy the created by of this land lord
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_landLord.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_landLord.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_landLord.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_landLord.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this land lord.
	*
	* @param firstName the first name of this land lord
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_landLord.setFirstName(firstName);
	}

	/**
	* Sets the land lord ID of this land lord.
	*
	* @param landLordId the land lord ID of this land lord
	*/
	@Override
	public void setLandLordId(long landLordId) {
		_landLord.setLandLordId(landLordId);
	}

	/**
	* Sets the last name of this land lord.
	*
	* @param lastName the last name of this land lord
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_landLord.setLastName(lastName);
	}

	/**
	* Sets the location of this land lord.
	*
	* @param location the location of this land lord
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_landLord.setLocation(location);
	}

	@Override
	public void setNew(boolean n) {
		_landLord.setNew(n);
	}

	/**
	* Sets the phone no of this land lord.
	*
	* @param phoneNo the phone no of this land lord
	*/
	@Override
	public void setPhoneNo(java.lang.String phoneNo) {
		_landLord.setPhoneNo(phoneNo);
	}

	/**
	* Sets the primary key of this land lord.
	*
	* @param primaryKey the primary key of this land lord
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_landLord.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_landLord.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the statec of this land lord.
	*
	* @param statec the statec of this land lord
	*/
	@Override
	public void setStatec(java.lang.String statec) {
		_landLord.setStatec(statec);
	}

	/**
	* Sets the status of this land lord.
	*
	* @param status the status of this land lord
	*/
	@Override
	public void setStatus(int status) {
		_landLord.setStatus(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LandLordWrapper)) {
			return false;
		}

		LandLordWrapper landLordWrapper = (LandLordWrapper)obj;

		if (Objects.equals(_landLord, landLordWrapper._landLord)) {
			return true;
		}

		return false;
	}

	@Override
	public LandLord getWrappedModel() {
		return _landLord;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _landLord.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _landLord.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_landLord.resetOriginalValues();
	}

	private final LandLord _landLord;
}