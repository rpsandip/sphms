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
public class CreditNoteSoap implements Serializable {
	public static CreditNoteSoap toSoapModel(CreditNote model) {
		CreditNoteSoap soapModel = new CreditNoteSoap();

		soapModel.setCreditNoteId(model.getCreditNoteId());
		soapModel.setClientId(model.getClientId());
		soapModel.setCreditNoteAmount(model.getCreditNoteAmount());
		soapModel.setCreditNoteTax(model.getCreditNoteTax());
		soapModel.setPaymentDate(model.getPaymentDate());
		soapModel.setChequeNo(model.getChequeNo());
		soapModel.setBankName(model.getBankName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static CreditNoteSoap[] toSoapModels(CreditNote[] models) {
		CreditNoteSoap[] soapModels = new CreditNoteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditNoteSoap[][] toSoapModels(CreditNote[][] models) {
		CreditNoteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreditNoteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditNoteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditNoteSoap[] toSoapModels(List<CreditNote> models) {
		List<CreditNoteSoap> soapModels = new ArrayList<CreditNoteSoap>(models.size());

		for (CreditNote model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreditNoteSoap[soapModels.size()]);
	}

	public CreditNoteSoap() {
	}

	public long getPrimaryKey() {
		return _creditNoteId;
	}

	public void setPrimaryKey(long pk) {
		setCreditNoteId(pk);
	}

	public long getCreditNoteId() {
		return _creditNoteId;
	}

	public void setCreditNoteId(long creditNoteId) {
		_creditNoteId = creditNoteId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public double getCreditNoteAmount() {
		return _creditNoteAmount;
	}

	public void setCreditNoteAmount(double creditNoteAmount) {
		_creditNoteAmount = creditNoteAmount;
	}

	public double getCreditNoteTax() {
		return _creditNoteTax;
	}

	public void setCreditNoteTax(double creditNoteTax) {
		_creditNoteTax = creditNoteTax;
	}

	public Date getPaymentDate() {
		return _paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
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

	private long _creditNoteId;
	private long _clientId;
	private double _creditNoteAmount;
	private double _creditNoteTax;
	private Date _paymentDate;
	private String _chequeNo;
	private String _bankName;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}