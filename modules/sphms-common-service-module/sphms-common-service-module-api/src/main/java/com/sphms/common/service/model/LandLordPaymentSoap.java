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
public class LandLordPaymentSoap implements Serializable {
	public static LandLordPaymentSoap toSoapModel(LandLordPayment model) {
		LandLordPaymentSoap soapModel = new LandLordPaymentSoap();

		soapModel.setLandLordPaymentId(model.getLandLordPaymentId());
		soapModel.setLandLoadId(model.getLandLoadId());
		soapModel.setHordingId(model.getHordingId());
		soapModel.setAmount(model.getAmount());
		soapModel.setChequeNo(model.getChequeNo());
		soapModel.setBankName(model.getBankName());
		soapModel.setPaymentDate(model.getPaymentDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());

		return soapModel;
	}

	public static LandLordPaymentSoap[] toSoapModels(LandLordPayment[] models) {
		LandLordPaymentSoap[] soapModels = new LandLordPaymentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LandLordPaymentSoap[][] toSoapModels(
		LandLordPayment[][] models) {
		LandLordPaymentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LandLordPaymentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LandLordPaymentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LandLordPaymentSoap[] toSoapModels(
		List<LandLordPayment> models) {
		List<LandLordPaymentSoap> soapModels = new ArrayList<LandLordPaymentSoap>(models.size());

		for (LandLordPayment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LandLordPaymentSoap[soapModels.size()]);
	}

	public LandLordPaymentSoap() {
	}

	public long getPrimaryKey() {
		return _landLordPaymentId;
	}

	public void setPrimaryKey(long pk) {
		setLandLordPaymentId(pk);
	}

	public long getLandLordPaymentId() {
		return _landLordPaymentId;
	}

	public void setLandLordPaymentId(long landLordPaymentId) {
		_landLordPaymentId = landLordPaymentId;
	}

	public long getLandLoadId() {
		return _landLoadId;
	}

	public void setLandLoadId(long landLoadId) {
		_landLoadId = landLoadId;
	}

	public long getHordingId() {
		return _hordingId;
	}

	public void setHordingId(long hordingId) {
		_hordingId = hordingId;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public String getChequeNo() {
		return _chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		_chequeNo = chequeNo;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public Date getPaymentDate() {
		return _paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private long _landLordPaymentId;
	private long _landLoadId;
	private long _hordingId;
	private double _amount;
	private String _chequeNo;
	private String _bankName;
	private Date _paymentDate;
	private String _description;
	private Date _createDate;
	private long _createdBy;
}