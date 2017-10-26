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
public class HordingSoap implements Serializable {
	public static HordingSoap toSoapModel(Hording model) {
		HordingSoap soapModel = new HordingSoap();

		soapModel.setHordingId(model.getHordingId());
		soapModel.setTitle(model.getTitle());
		soapModel.setLocation(model.getLocation());
		soapModel.setCity(model.getCity());
		soapModel.setDistrict(model.getDistrict());
		soapModel.setState(model.getState());
		soapModel.setHordingType(model.getHordingType());
		soapModel.setMediaVehicle(model.getMediaVehicle());
		soapModel.setSize(model.getSize());
		soapModel.setPricePerMonth(model.getPricePerMonth());
		soapModel.setNormalImageId(model.getNormalImageId());
		soapModel.setShortImageId(model.getShortImageId());
		soapModel.setLongImageId(model.getLongImageId());
		soapModel.setLandLordId(model.getLandLordId());
		soapModel.setOwnerType(model.getOwnerType());
		soapModel.setUpinNo(model.getUpinNo());
		soapModel.setMncTax(model.getMncTax());
		soapModel.setOtherExpYear(model.getOtherExpYear());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static HordingSoap[] toSoapModels(Hording[] models) {
		HordingSoap[] soapModels = new HordingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HordingSoap[][] toSoapModels(Hording[][] models) {
		HordingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HordingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HordingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HordingSoap[] toSoapModels(List<Hording> models) {
		List<HordingSoap> soapModels = new ArrayList<HordingSoap>(models.size());

		for (Hording model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HordingSoap[soapModels.size()]);
	}

	public HordingSoap() {
	}

	public long getPrimaryKey() {
		return _hordingId;
	}

	public void setPrimaryKey(long pk) {
		setHordingId(pk);
	}

	public long getHordingId() {
		return _hordingId;
	}

	public void setHordingId(long hordingId) {
		_hordingId = hordingId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
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

	public String getDistrict() {
		return _district;
	}

	public void setDistrict(String district) {
		_district = district;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getHordingType() {
		return _hordingType;
	}

	public void setHordingType(String hordingType) {
		_hordingType = hordingType;
	}

	public String getMediaVehicle() {
		return _mediaVehicle;
	}

	public void setMediaVehicle(String mediaVehicle) {
		_mediaVehicle = mediaVehicle;
	}

	public String getSize() {
		return _size;
	}

	public void setSize(String size) {
		_size = size;
	}

	public double getPricePerMonth() {
		return _pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		_pricePerMonth = pricePerMonth;
	}

	public long getNormalImageId() {
		return _normalImageId;
	}

	public void setNormalImageId(long normalImageId) {
		_normalImageId = normalImageId;
	}

	public long getShortImageId() {
		return _shortImageId;
	}

	public void setShortImageId(long shortImageId) {
		_shortImageId = shortImageId;
	}

	public long getLongImageId() {
		return _longImageId;
	}

	public void setLongImageId(long longImageId) {
		_longImageId = longImageId;
	}

	public long getLandLordId() {
		return _landLordId;
	}

	public void setLandLordId(long landLordId) {
		_landLordId = landLordId;
	}

	public int getOwnerType() {
		return _ownerType;
	}

	public void setOwnerType(int ownerType) {
		_ownerType = ownerType;
	}

	public String getUpinNo() {
		return _upinNo;
	}

	public void setUpinNo(String upinNo) {
		_upinNo = upinNo;
	}

	public double getMncTax() {
		return _mncTax;
	}

	public void setMncTax(double mncTax) {
		_mncTax = mncTax;
	}

	public double getOtherExpYear() {
		return _otherExpYear;
	}

	public void setOtherExpYear(double otherExpYear) {
		_otherExpYear = otherExpYear;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
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

	private long _hordingId;
	private String _title;
	private String _location;
	private String _city;
	private String _district;
	private String _state;
	private String _hordingType;
	private String _mediaVehicle;
	private String _size;
	private double _pricePerMonth;
	private long _normalImageId;
	private long _shortImageId;
	private long _longImageId;
	private long _landLordId;
	private int _ownerType;
	private String _upinNo;
	private double _mncTax;
	private double _otherExpYear;
	private int _status;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}