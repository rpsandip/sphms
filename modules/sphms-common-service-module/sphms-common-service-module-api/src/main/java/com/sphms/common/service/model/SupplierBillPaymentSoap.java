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
public class SupplierBillPaymentSoap implements Serializable {
	public static SupplierBillPaymentSoap toSoapModel(SupplierBillPayment model) {
		SupplierBillPaymentSoap soapModel = new SupplierBillPaymentSoap();

		soapModel.setSupplierBillPaymentId(model.getSupplierBillPaymentId());
		soapModel.setSupplierBillId(model.getSupplierBillId());
		soapModel.setSupplierId(model.getSupplierId());
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

	public static SupplierBillPaymentSoap[] toSoapModels(
		SupplierBillPayment[] models) {
		SupplierBillPaymentSoap[] soapModels = new SupplierBillPaymentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SupplierBillPaymentSoap[][] toSoapModels(
		SupplierBillPayment[][] models) {
		SupplierBillPaymentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SupplierBillPaymentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SupplierBillPaymentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SupplierBillPaymentSoap[] toSoapModels(
		List<SupplierBillPayment> models) {
		List<SupplierBillPaymentSoap> soapModels = new ArrayList<SupplierBillPaymentSoap>(models.size());

		for (SupplierBillPayment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SupplierBillPaymentSoap[soapModels.size()]);
	}

	public SupplierBillPaymentSoap() {
	}

	public long getPrimaryKey() {
		return _supplierBillPaymentId;
	}

	public void setPrimaryKey(long pk) {
		setSupplierBillPaymentId(pk);
	}

	public long getSupplierBillPaymentId() {
		return _supplierBillPaymentId;
	}

	public void setSupplierBillPaymentId(long supplierBillPaymentId) {
		_supplierBillPaymentId = supplierBillPaymentId;
	}

	public long getSupplierBillId() {
		return _supplierBillId;
	}

	public void setSupplierBillId(long supplierBillId) {
		_supplierBillId = supplierBillId;
	}

	public long getSupplierId() {
		return _supplierId;
	}

	public void setSupplierId(long supplierId) {
		_supplierId = supplierId;
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

	private long _supplierBillPaymentId;
	private long _supplierBillId;
	private long _supplierId;
	private double _amount;
	private double _gst;
	private String _chequeNo;
	private Date _paymentDate;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}