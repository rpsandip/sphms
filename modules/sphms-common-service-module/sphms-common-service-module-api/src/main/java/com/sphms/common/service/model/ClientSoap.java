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
public class ClientSoap implements Serializable {
	public static ClientSoap toSoapModel(Client model) {
		ClientSoap soapModel = new ClientSoap();

		soapModel.setClientId(model.getClientId());
		soapModel.setClientName(model.getClientName());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setPanNo(model.getPanNo());
		soapModel.setGstNo(model.getGstNo());
		soapModel.setState(model.getState());
		soapModel.setStatus(model.getStatus());
		soapModel.setContactPersonName(model.getContactPersonName());
		soapModel.setContactPersonEmail(model.getContactPersonEmail());
		soapModel.setContactPersonPhoneNo(model.getContactPersonPhoneNo());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());

		return soapModel;
	}

	public static ClientSoap[] toSoapModels(Client[] models) {
		ClientSoap[] soapModels = new ClientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClientSoap[][] toSoapModels(Client[][] models) {
		ClientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClientSoap[] toSoapModels(List<Client> models) {
		List<ClientSoap> soapModels = new ArrayList<ClientSoap>(models.size());

		for (Client model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClientSoap[soapModels.size()]);
	}

	public ClientSoap() {
	}

	public long getPrimaryKey() {
		return _clientId;
	}

	public void setPrimaryKey(long pk) {
		setClientId(pk);
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public String getClientName() {
		return _clientName;
	}

	public void setClientName(String clientName) {
		_clientName = clientName;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getPanNo() {
		return _panNo;
	}

	public void setPanNo(String panNo) {
		_panNo = panNo;
	}

	public String getGstNo() {
		return _gstNo;
	}

	public void setGstNo(String gstNo) {
		_gstNo = gstNo;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getContactPersonName() {
		return _contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		_contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return _contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		_contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonPhoneNo() {
		return _contactPersonPhoneNo;
	}

	public void setContactPersonPhoneNo(String contactPersonPhoneNo) {
		_contactPersonPhoneNo = contactPersonPhoneNo;
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

	private long _clientId;
	private String _clientName;
	private String _address1;
	private String _address2;
	private String _city;
	private String _panNo;
	private String _gstNo;
	private String _state;
	private int _status;
	private String _contactPersonName;
	private String _contactPersonEmail;
	private String _contactPersonPhoneNo;
	private Date _createDate;
	private long _createdBy;
}