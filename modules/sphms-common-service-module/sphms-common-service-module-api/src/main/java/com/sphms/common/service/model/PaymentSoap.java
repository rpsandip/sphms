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
public class PaymentSoap implements Serializable {
	public static PaymentSoap toSoapModel(Payment model) {
		PaymentSoap soapModel = new PaymentSoap();

		soapModel.setPaymentId(model.getPaymentId());
		soapModel.setBillingId(model.getBillingId());
		soapModel.setClientId(model.getClientId());
		soapModel.setAmount(model.getAmount());
		soapModel.setChequeNo(model.getChequeNo());
		soapModel.setTds(model.getTds());
		soapModel.setDeduction(model.getDeduction());
		soapModel.setDescription(model.getDescription());
		soapModel.setPaymentDate(model.getPaymentDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static PaymentSoap[] toSoapModels(Payment[] models) {
		PaymentSoap[] soapModels = new PaymentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PaymentSoap[][] toSoapModels(Payment[][] models) {
		PaymentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PaymentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PaymentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PaymentSoap[] toSoapModels(List<Payment> models) {
		List<PaymentSoap> soapModels = new ArrayList<PaymentSoap>(models.size());

		for (Payment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PaymentSoap[soapModels.size()]);
	}

	public PaymentSoap() {
	}

	public long getPrimaryKey() {
		return _paymentId;
	}

	public void setPrimaryKey(long pk) {
		setPaymentId(pk);
	}

	public long getPaymentId() {
		return _paymentId;
	}

	public void setPaymentId(long paymentId) {
		_paymentId = paymentId;
	}

	public long getBillingId() {
		return _billingId;
	}

	public void setBillingId(long billingId) {
		_billingId = billingId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
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

	public double getTds() {
		return _tds;
	}

	public void setTds(double tds) {
		_tds = tds;
	}

	public double getDeduction() {
		return _deduction;
	}

	public void setDeduction(double deduction) {
		_deduction = deduction;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private long _paymentId;
	private long _billingId;
	private long _clientId;
	private double _amount;
	private String _chequeNo;
	private double _tds;
	private double _deduction;
	private String _description;
	private Date _paymentDate;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}