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
public class POPaymentSoap implements Serializable {
	public static POPaymentSoap toSoapModel(POPayment model) {
		POPaymentSoap soapModel = new POPaymentSoap();

		soapModel.setPoPaymentId(model.getPoPaymentId());
		soapModel.setBillingId(model.getBillingId());
		soapModel.setLandLordId(model.getLandLordId());
		soapModel.setAmount(model.getAmount());
		soapModel.setGst(model.getGst());
		soapModel.setChequeNo(model.getChequeNo());
		soapModel.setPaymentDate(model.getPaymentDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static POPaymentSoap[] toSoapModels(POPayment[] models) {
		POPaymentSoap[] soapModels = new POPaymentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static POPaymentSoap[][] toSoapModels(POPayment[][] models) {
		POPaymentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new POPaymentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new POPaymentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static POPaymentSoap[] toSoapModels(List<POPayment> models) {
		List<POPaymentSoap> soapModels = new ArrayList<POPaymentSoap>(models.size());

		for (POPayment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new POPaymentSoap[soapModels.size()]);
	}

	public POPaymentSoap() {
	}

	public long getPrimaryKey() {
		return _poPaymentId;
	}

	public void setPrimaryKey(long pk) {
		setPoPaymentId(pk);
	}

	public long getPoPaymentId() {
		return _poPaymentId;
	}

	public void setPoPaymentId(long poPaymentId) {
		_poPaymentId = poPaymentId;
	}

	public long getBillingId() {
		return _billingId;
	}

	public void setBillingId(long billingId) {
		_billingId = billingId;
	}

	public long getLandLordId() {
		return _landLordId;
	}

	public void setLandLordId(long landLordId) {
		_landLordId = landLordId;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public double getGst() {
		return _gst;
	}

	public void setGst(double gst) {
		_gst = gst;
	}

	public String getChequeNo() {
		return _chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		_chequeNo = chequeNo;
	}

	public Date getPaymentDate() {
		return _paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
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

	private long _poPaymentId;
	private long _billingId;
	private long _landLordId;
	private double _amount;
	private double _gst;
	private String _chequeNo;
	private Date _paymentDate;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}