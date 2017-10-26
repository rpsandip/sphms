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
 * This class is a wrapper for {@link Booking}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Booking
 * @generated
 */
@ProviderType
public class BookingWrapper implements Booking, ModelWrapper<Booking> {
	public BookingWrapper(Booking booking) {
		_booking = booking;
	}

	@Override
	public Class<?> getModelClass() {
		return Booking.class;
	}

	@Override
	public String getModelClassName() {
		return Booking.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookingId", getBookingId());
		attributes.put("customCompanyId", getCustomCompanyId());
		attributes.put("campaignTitle", getCampaignTitle());
		attributes.put("client", getClient());
		attributes.put("billId", getBillId());
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
		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Long customCompanyId = (Long)attributes.get("customCompanyId");

		if (customCompanyId != null) {
			setCustomCompanyId(customCompanyId);
		}

		String campaignTitle = (String)attributes.get("campaignTitle");

		if (campaignTitle != null) {
			setCampaignTitle(campaignTitle);
		}

		Long client = (Long)attributes.get("client");

		if (client != null) {
			setClient(client);
		}

		Long billId = (Long)attributes.get("billId");

		if (billId != null) {
			setBillId(billId);
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
	public Booking toEscapedModel() {
		return new BookingWrapper(_booking.toEscapedModel());
	}

	@Override
	public Booking toUnescapedModel() {
		return new BookingWrapper(_booking.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _booking.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _booking.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _booking.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _booking.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Booking> toCacheModel() {
		return _booking.toCacheModel();
	}

	@Override
	public int compareTo(Booking booking) {
		return _booking.compareTo(booking);
	}

	@Override
	public int hashCode() {
		return _booking.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _booking.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BookingWrapper((Booking)_booking.clone());
	}

	/**
	* Returns the campaign title of this booking.
	*
	* @return the campaign title of this booking
	*/
	@Override
	public java.lang.String getCampaignTitle() {
		return _booking.getCampaignTitle();
	}

	@Override
	public java.lang.String toString() {
		return _booking.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _booking.toXmlString();
	}

	/**
	* Returns the create date of this booking.
	*
	* @return the create date of this booking
	*/
	@Override
	public Date getCreateDate() {
		return _booking.getCreateDate();
	}

	/**
	* Returns the end date of this booking.
	*
	* @return the end date of this booking
	*/
	@Override
	public Date getEndDate() {
		return _booking.getEndDate();
	}

	/**
	* Returns the modified date of this booking.
	*
	* @return the modified date of this booking
	*/
	@Override
	public Date getModifiedDate() {
		return _booking.getModifiedDate();
	}

	/**
	* Returns the start date of this booking.
	*
	* @return the start date of this booking
	*/
	@Override
	public Date getStartDate() {
		return _booking.getStartDate();
	}

	/**
	* Returns the bill ID of this booking.
	*
	* @return the bill ID of this booking
	*/
	@Override
	public long getBillId() {
		return _booking.getBillId();
	}

	/**
	* Returns the booking ID of this booking.
	*
	* @return the booking ID of this booking
	*/
	@Override
	public long getBookingId() {
		return _booking.getBookingId();
	}

	/**
	* Returns the client of this booking.
	*
	* @return the client of this booking
	*/
	@Override
	public long getClient() {
		return _booking.getClient();
	}

	/**
	* Returns the created by of this booking.
	*
	* @return the created by of this booking
	*/
	@Override
	public long getCreatedBy() {
		return _booking.getCreatedBy();
	}

	/**
	* Returns the custom company ID of this booking.
	*
	* @return the custom company ID of this booking
	*/
	@Override
	public long getCustomCompanyId() {
		return _booking.getCustomCompanyId();
	}

	/**
	* Returns the modified by of this booking.
	*
	* @return the modified by of this booking
	*/
	@Override
	public long getModifiedBy() {
		return _booking.getModifiedBy();
	}

	/**
	* Returns the primary key of this booking.
	*
	* @return the primary key of this booking
	*/
	@Override
	public long getPrimaryKey() {
		return _booking.getPrimaryKey();
	}

	@Override
	public void persist() {
		_booking.persist();
	}

	/**
	* Sets the bill ID of this booking.
	*
	* @param billId the bill ID of this booking
	*/
	@Override
	public void setBillId(long billId) {
		_booking.setBillId(billId);
	}

	/**
	* Sets the booking ID of this booking.
	*
	* @param bookingId the booking ID of this booking
	*/
	@Override
	public void setBookingId(long bookingId) {
		_booking.setBookingId(bookingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_booking.setCachedModel(cachedModel);
	}

	/**
	* Sets the campaign title of this booking.
	*
	* @param campaignTitle the campaign title of this booking
	*/
	@Override
	public void setCampaignTitle(java.lang.String campaignTitle) {
		_booking.setCampaignTitle(campaignTitle);
	}

	/**
	* Sets the client of this booking.
	*
	* @param client the client of this booking
	*/
	@Override
	public void setClient(long client) {
		_booking.setClient(client);
	}

	/**
	* Sets the create date of this booking.
	*
	* @param createDate the create date of this booking
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_booking.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this booking.
	*
	* @param createdBy the created by of this booking
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_booking.setCreatedBy(createdBy);
	}

	/**
	* Sets the custom company ID of this booking.
	*
	* @param customCompanyId the custom company ID of this booking
	*/
	@Override
	public void setCustomCompanyId(long customCompanyId) {
		_booking.setCustomCompanyId(customCompanyId);
	}

	/**
	* Sets the end date of this booking.
	*
	* @param endDate the end date of this booking
	*/
	@Override
	public void setEndDate(Date endDate) {
		_booking.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_booking.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_booking.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_booking.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this booking.
	*
	* @param modifiedBy the modified by of this booking
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_booking.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this booking.
	*
	* @param modifiedDate the modified date of this booking
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_booking.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_booking.setNew(n);
	}

	/**
	* Sets the primary key of this booking.
	*
	* @param primaryKey the primary key of this booking
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_booking.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_booking.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start date of this booking.
	*
	* @param startDate the start date of this booking
	*/
	@Override
	public void setStartDate(Date startDate) {
		_booking.setStartDate(startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookingWrapper)) {
			return false;
		}

		BookingWrapper bookingWrapper = (BookingWrapper)obj;

		if (Objects.equals(_booking, bookingWrapper._booking)) {
			return true;
		}

		return false;
	}

	@Override
	public Booking getWrappedModel() {
		return _booking;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _booking.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _booking.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_booking.resetOriginalValues();
	}

	private final Booking _booking;
}