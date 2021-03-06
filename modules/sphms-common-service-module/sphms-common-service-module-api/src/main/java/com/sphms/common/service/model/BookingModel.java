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
 * The base model interface for the Booking service. Represents a row in the &quot;SPHMS_Booking&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sphms.common.service.model.impl.BookingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sphms.common.service.model.impl.BookingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Booking
 * @see com.sphms.common.service.model.impl.BookingImpl
 * @see com.sphms.common.service.model.impl.BookingModelImpl
 * @generated
 */
@ProviderType
public interface BookingModel extends BaseModel<Booking> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a booking model instance should use the {@link Booking} interface instead.
	 */

	/**
	 * Returns the primary key of this booking.
	 *
	 * @return the primary key of this booking
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this booking.
	 *
	 * @param primaryKey the primary key of this booking
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the booking ID of this booking.
	 *
	 * @return the booking ID of this booking
	 */
	public long getBookingId();

	/**
	 * Sets the booking ID of this booking.
	 *
	 * @param bookingId the booking ID of this booking
	 */
	public void setBookingId(long bookingId);

	/**
	 * Returns the custom company ID of this booking.
	 *
	 * @return the custom company ID of this booking
	 */
	public long getCustomCompanyId();

	/**
	 * Sets the custom company ID of this booking.
	 *
	 * @param customCompanyId the custom company ID of this booking
	 */
	public void setCustomCompanyId(long customCompanyId);

	/**
	 * Returns the campaign title of this booking.
	 *
	 * @return the campaign title of this booking
	 */
	@AutoEscape
	public String getCampaignTitle();

	/**
	 * Sets the campaign title of this booking.
	 *
	 * @param campaignTitle the campaign title of this booking
	 */
	public void setCampaignTitle(String campaignTitle);

	/**
	 * Returns the client of this booking.
	 *
	 * @return the client of this booking
	 */
	public long getClient();

	/**
	 * Sets the client of this booking.
	 *
	 * @param client the client of this booking
	 */
	public void setClient(long client);

	/**
	 * Returns the bill ID of this booking.
	 *
	 * @return the bill ID of this booking
	 */
	public long getBillId();

	/**
	 * Sets the bill ID of this booking.
	 *
	 * @param billId the bill ID of this booking
	 */
	public void setBillId(long billId);

	/**
	 * Returns the status of this booking.
	 *
	 * @return the status of this booking
	 */
	public int getStatus();

	/**
	 * Sets the status of this booking.
	 *
	 * @param status the status of this booking
	 */
	public void setStatus(int status);

	/**
	 * Returns the start date of this booking.
	 *
	 * @return the start date of this booking
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this booking.
	 *
	 * @param startDate the start date of this booking
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this booking.
	 *
	 * @return the end date of this booking
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this booking.
	 *
	 * @param endDate the end date of this booking
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the create date of this booking.
	 *
	 * @return the create date of this booking
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this booking.
	 *
	 * @param createDate the create date of this booking
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this booking.
	 *
	 * @return the created by of this booking
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this booking.
	 *
	 * @param createdBy the created by of this booking
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this booking.
	 *
	 * @return the modified date of this booking
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this booking.
	 *
	 * @param modifiedDate the modified date of this booking
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this booking.
	 *
	 * @return the modified by of this booking
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this booking.
	 *
	 * @param modifiedBy the modified by of this booking
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
	public int compareTo(Booking booking);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Booking> toCacheModel();

	@Override
	public Booking toEscapedModel();

	@Override
	public Booking toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}