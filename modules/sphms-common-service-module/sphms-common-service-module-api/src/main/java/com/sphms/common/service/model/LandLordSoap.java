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
public class LandLordSoap implements Serializable {
	public static LandLordSoap toSoapModel(LandLord model) {
		LandLordSoap soapModel = new LandLordSoap();

		soapModel.setLandLordId(model.getLandLordId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setLocation(model.getLocation());
		soapModel.setCity(model.getCity());
		soapModel.setStatus(model.getStatus());
		soapModel.setPhoneNo(model.getPhoneNo());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());

		return soapModel;
	}

	public static LandLordSoap[] toSoapModels(LandLord[] models) {
		LandLordSoap[] soapModels = new LandLordSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LandLordSoap[][] toSoapModels(LandLord[][] models) {
		LandLordSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LandLordSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LandLordSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LandLordSoap[] toSoapModels(List<LandLord> models) {
		List<LandLordSoap> soapModels = new ArrayList<LandLordSoap>(models.size());

		for (LandLord model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LandLordSoap[soapModels.size()]);
	}

	public LandLordSoap() {
	}

	public long getPrimaryKey() {
		return _landLordId;
	}

	public void setPrimaryKey(long pk) {
		setLandLordId(pk);
	}

	public long getLandLordId() {
		return _landLordId;
	}

	public void setLandLordId(long landLordId) {
		_landLordId = landLordId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getPhoneNo() {
		return _phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		_phoneNo = phoneNo;
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

	private long _landLordId;
	private String _firstName;
	private String _lastName;
	private String _location;
	private String _city;
	private int _status;
	private String _phoneNo;
	private Date _createDate;
	private long _createdBy;
}