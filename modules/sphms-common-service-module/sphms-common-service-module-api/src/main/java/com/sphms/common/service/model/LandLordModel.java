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
 * The base model interface for the LandLord service. Represents a row in the &quot;SPHMS_LandLord&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sphms.common.service.model.impl.LandLordModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sphms.common.service.model.impl.LandLordImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLord
 * @see com.sphms.common.service.model.impl.LandLordImpl
 * @see com.sphms.common.service.model.impl.LandLordModelImpl
 * @generated
 */
@ProviderType
public interface LandLordModel extends BaseModel<LandLord> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a land lord model instance should use the {@link LandLord} interface instead.
	 */

	/**
	 * Returns the primary key of this land lord.
	 *
	 * @return the primary key of this land lord
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this land lord.
	 *
	 * @param primaryKey the primary key of this land lord
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the land lord ID of this land lord.
	 *
	 * @return the land lord ID of this land lord
	 */
	public long getLandLordId();

	/**
	 * Sets the land lord ID of this land lord.
	 *
	 * @param landLordId the land lord ID of this land lord
	 */
	public void setLandLordId(long landLordId);

	/**
	 * Returns the first name of this land lord.
	 *
	 * @return the first name of this land lord
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this land lord.
	 *
	 * @param firstName the first name of this land lord
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this land lord.
	 *
	 * @return the last name of this land lord
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this land lord.
	 *
	 * @param lastName the last name of this land lord
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the location of this land lord.
	 *
	 * @return the location of this land lord
	 */
	@AutoEscape
	public String getLocation();

	/**
	 * Sets the location of this land lord.
	 *
	 * @param location the location of this land lord
	 */
	public void setLocation(String location);

	/**
	 * Returns the city of this land lord.
	 *
	 * @return the city of this land lord
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this land lord.
	 *
	 * @param city the city of this land lord
	 */
	public void setCity(String city);

	/**
	 * Returns the statec of this land lord.
	 *
	 * @return the statec of this land lord
	 */
	@AutoEscape
	public String getStatec();

	/**
	 * Sets the statec of this land lord.
	 *
	 * @param statec the statec of this land lord
	 */
	public void setStatec(String statec);

	/**
	 * Returns the status of this land lord.
	 *
	 * @return the status of this land lord
	 */
	public int getStatus();

	/**
	 * Sets the status of this land lord.
	 *
	 * @param status the status of this land lord
	 */
	public void setStatus(int status);

	/**
	 * Returns the phone no of this land lord.
	 *
	 * @return the phone no of this land lord
	 */
	@AutoEscape
	public String getPhoneNo();

	/**
	 * Sets the phone no of this land lord.
	 *
	 * @param phoneNo the phone no of this land lord
	 */
	public void setPhoneNo(String phoneNo);

	/**
	 * Returns the gst no of this land lord.
	 *
	 * @return the gst no of this land lord
	 */
	@AutoEscape
	public String getGstNo();

	/**
	 * Sets the gst no of this land lord.
	 *
	 * @param gstNo the gst no of this land lord
	 */
	public void setGstNo(String gstNo);

	/**
	 * Returns the create date of this land lord.
	 *
	 * @return the create date of this land lord
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this land lord.
	 *
	 * @param createDate the create date of this land lord
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this land lord.
	 *
	 * @return the created by of this land lord
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this land lord.
	 *
	 * @param createdBy the created by of this land lord
	 */
	public void setCreatedBy(long createdBy);

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
	public int compareTo(LandLord landLord);

	@Override
	public int hashCode();

	@Override
	public CacheModel<LandLord> toCacheModel();

	@Override
	public LandLord toEscapedModel();

	@Override
	public LandLord toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}