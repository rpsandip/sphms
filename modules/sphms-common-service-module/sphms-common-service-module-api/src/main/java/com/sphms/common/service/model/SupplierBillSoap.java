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
public class SupplierBillSoap implements Serializable {
	public static SupplierBillSoap toSoapModel(SupplierBill model) {
		SupplierBillSoap soapModel = new SupplierBillSoap();

		soapModel.setSupplierBillId(model.getSupplierBillId());
		soapModel.setSupplierId(model.getSupplierId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setSupplierBillNo(model.getSupplierBillNo());
		soapModel.setSupplierBillDesc(model.getSupplierBillDesc());
		soapModel.setSupplierBillType(model.getSupplierBillType());
		soapModel.setSupplierBillDate(model.getSupplierBillDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setGst(model.getGst());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static SupplierBillSoap[] toSoapModels(SupplierBill[] models) {
		SupplierBillSoap[] soapModels = new SupplierBillSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SupplierBillSoap[][] toSoapModels(SupplierBill[][] models) {
		SupplierBillSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SupplierBillSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SupplierBillSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SupplierBillSoap[] toSoapModels(List<SupplierBill> models) {
		List<SupplierBillSoap> soapModels = new ArrayList<SupplierBillSoap>(models.size());

		for (SupplierBill model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SupplierBillSoap[soapModels.size()]);
	}

	public SupplierBillSoap() {
	}

	public long getPrimaryKey() {
		return _supplierBillId;
	}

	public void setPrimaryKey(long pk) {
		setSupplierBillId(pk);
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getSupplierBillNo() {
		return _supplierBillNo;
	}

	public void setSupplierBillNo(String supplierBillNo) {
		_supplierBillNo = supplierBillNo;
	}

	public String getSupplierBillDesc() {
		return _supplierBillDesc;
	}

	public void setSupplierBillDesc(String supplierBillDesc) {
		_supplierBillDesc = supplierBillDesc;
	}

	public String getSupplierBillType() {
		return _supplierBillType;
	}

	public void setSupplierBillType(String supplierBillType) {
		_supplierBillType = supplierBillType;
	}

	public Date getSupplierBillDate() {
		return _supplierBillDate;
	}

	public void setSupplierBillDate(Date supplierBillDate) {
		_supplierBillDate = supplierBillDate;
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

	private long _supplierBillId;
	private long _supplierId;
	private long _companyId;
	private String _supplierBillNo;
	private String _supplierBillDesc;
	private String _supplierBillType;
	private Date _supplierBillDate;
	private double _amount;
	private double _gst;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}