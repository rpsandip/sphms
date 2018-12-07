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

import com.sphms.common.service.service.persistence.Billing_POPK;

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
public class Billing_POSoap implements Serializable {
	public static Billing_POSoap toSoapModel(Billing_PO model) {
		Billing_POSoap soapModel = new Billing_POSoap();

		soapModel.setBillingId(model.getBillingId());
		soapModel.setHordingId(model.getHordingId());
		soapModel.setLandLordId(model.getLandLordId());
		soapModel.setSupplierBillNo(model.getSupplierBillNo());
		soapModel.setSupplierBillDate(model.getSupplierBillDate());
		soapModel.setSupplierTotalAmount(model.getSupplierTotalAmount());
		soapModel.setSupplierGstAmmount(model.getSupplierGstAmmount());
		soapModel.setPoNumber(model.getPoNumber());
		soapModel.setInternalPONumber(model.getInternalPONumber());
		soapModel.setFinancialYear(model.getFinancialYear());
		soapModel.setTotalAmount(model.getTotalAmount());
		soapModel.setCustomCompanyId(model.getCustomCompanyId());
		soapModel.setPaymentGiven(model.getPaymentGiven());
		soapModel.setPublishDate(model.getPublishDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static Billing_POSoap[] toSoapModels(Billing_PO[] models) {
		Billing_POSoap[] soapModels = new Billing_POSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Billing_POSoap[][] toSoapModels(Billing_PO[][] models) {
		Billing_POSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Billing_POSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Billing_POSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Billing_POSoap[] toSoapModels(List<Billing_PO> models) {
		List<Billing_POSoap> soapModels = new ArrayList<Billing_POSoap>(models.size());

		for (Billing_PO model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Billing_POSoap[soapModels.size()]);
	}

	public Billing_POSoap() {
	}

	public Billing_POPK getPrimaryKey() {
		return new Billing_POPK(_billingId, _hordingId);
	}

	public void setPrimaryKey(Billing_POPK pk) {
		setBillingId(pk.billingId);
		setHordingId(pk.hordingId);
	}

	public long getBillingId() {
		return _billingId;
	}

	public void setBillingId(long billingId) {
		_billingId = billingId;
	}

	public long getHordingId() {
		return _hordingId;
	}

	public void setHordingId(long hordingId) {
		_hordingId = hordingId;
	}

	public long getLandLordId() {
		return _landLordId;
	}

	public void setLandLordId(long landLordId) {
		_landLordId = landLordId;
	}

	public String getSupplierBillNo() {
		return _supplierBillNo;
	}

	public void setSupplierBillNo(String supplierBillNo) {
		_supplierBillNo = supplierBillNo;
	}

	public Date getSupplierBillDate() {
		return _supplierBillDate;
	}

	public void setSupplierBillDate(Date supplierBillDate) {
		_supplierBillDate = supplierBillDate;
	}

	public double getSupplierTotalAmount() {
		return _supplierTotalAmount;
	}

	public void setSupplierTotalAmount(double supplierTotalAmount) {
		_supplierTotalAmount = supplierTotalAmount;
	}

	public double getSupplierGstAmmount() {
		return _supplierGstAmmount;
	}

	public void setSupplierGstAmmount(double supplierGstAmmount) {
		_supplierGstAmmount = supplierGstAmmount;
	}

	public String getPoNumber() {
		return _poNumber;
	}

	public void setPoNumber(String poNumber) {
		_poNumber = poNumber;
	}

	public String getInternalPONumber() {
		return _internalPONumber;
	}

	public void setInternalPONumber(String internalPONumber) {
		_internalPONumber = internalPONumber;
	}

	public String getFinancialYear() {
		return _financialYear;
	}

	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
	}

	public double getTotalAmount() {
		return _totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		_totalAmount = totalAmount;
	}

	public long getCustomCompanyId() {
		return _customCompanyId;
	}

	public void setCustomCompanyId(long customCompanyId) {
		_customCompanyId = customCompanyId;
	}

	public String getPaymentGiven() {
		return _paymentGiven;
	}

	public void setPaymentGiven(String paymentGiven) {
		_paymentGiven = paymentGiven;
	}

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _billingId;
	private long _hordingId;
	private long _landLordId;
	private String _supplierBillNo;
	private Date _supplierBillDate;
	private double _supplierTotalAmount;
	private double _supplierGstAmmount;
	private String _poNumber;
	private String _internalPONumber;
	private String _financialYear;
	private double _totalAmount;
	private long _customCompanyId;
	private String _paymentGiven;
	private Date _publishDate;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
	private int _status;
}