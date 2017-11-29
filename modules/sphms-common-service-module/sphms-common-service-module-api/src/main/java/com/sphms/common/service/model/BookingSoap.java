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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class BookingSoap implements Serializable {
	public static BookingSoap toSoapModel(Booking model) {
		BookingSoap soapModel = new BookingSoap();

		soapModel.setBookingId(model.getBookingId());
		soapModel.setCustomCompanyId(model.getCustomCompanyId());
		soapModel.setCampaignTitle(model.getCampaignTitle());
		soapModel.setClient(model.getClient());
		soapModel.setBillId(model.getBillId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static BookingSoap[] toSoapModels(Booking[] models) {
		BookingSoap[] soapModels = new BookingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookingSoap[][] toSoapModels(Booking[][] models) {
		BookingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookingSoap[] toSoapModels(List<Booking> models) {
		List<BookingSoap> soapModels = new ArrayList<BookingSoap>(models.size());

		for (Booking model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookingSoap[soapModels.size()]);
	}

	public BookingSoap() {
	}

	public long getPrimaryKey() {
		return _bookingId;
	}

	public void setPrimaryKey(long pk) {
		setBookingId(pk);
	}

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	public long getCustomCompanyId() {
		return _customCompanyId;
	}

	public void setCustomCompanyId(long customCompanyId) {
		_customCompanyId = customCompanyId;
	}

	public String getCampaignTitle() {
		return _campaignTitle;
	}

	public void setCampaignTitle(String campaignTitle) {
		_campaignTitle = campaignTitle;
	}

	public long getClient() {
		return _client;
	}

	public void setClient(long client) {
		_client = client;
	}

	public long getBillId() {
		return _billId;
	}

	public void setBillId(long billId) {
		_billId = billId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	private long _bookingId;
	private long _customCompanyId;
	private String _campaignTitle;
	private long _client;
	private long _billId;
	private int _status;
	private Date _startDate;
	private Date _endDate;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}