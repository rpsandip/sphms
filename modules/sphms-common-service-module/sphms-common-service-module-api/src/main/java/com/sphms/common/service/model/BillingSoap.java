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
public class BillingSoap implements Serializable {
	public static BillingSoap toSoapModel(Billing model) {
		BillingSoap soapModel = new BillingSoap();

		soapModel.setBillingId(model.getBillingId());
		soapModel.setCustomCompanyId(model.getCustomCompanyId());
		soapModel.setBillNo(model.getBillNo());
		soapModel.setInternalBillNo(model.getInternalBillNo());
		soapModel.setBookingId(model.getBookingId());
		soapModel.setClientId(model.getClientId());
		soapModel.setBillFileEntryId(model.getBillFileEntryId());
		soapModel.setClientPANNo(model.getClientPANNo());
		soapModel.setClientPONumber(model.getClientPONumber());
		soapModel.setClientGSTNumber(model.getClientGSTNumber());
		soapModel.setDisplay(model.getDisplay());
		soapModel.setAccessAmount(model.getAccessAmount());
		soapModel.setPendingAmount(model.getPendingAmount());
		soapModel.setFinancialYear(model.getFinancialYear());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static BillingSoap[] toSoapModels(Billing[] models) {
		BillingSoap[] soapModels = new BillingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BillingSoap[][] toSoapModels(Billing[][] models) {
		BillingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BillingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BillingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BillingSoap[] toSoapModels(List<Billing> models) {
		List<BillingSoap> soapModels = new ArrayList<BillingSoap>(models.size());

		for (Billing model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BillingSoap[soapModels.size()]);
	}

	public BillingSoap() {
	}

	public long getPrimaryKey() {
		return _billingId;
	}

	public void setPrimaryKey(long pk) {
		setBillingId(pk);
	}

	public long getBillingId() {
		return _billingId;
	}

	public void setBillingId(long billingId) {
		_billingId = billingId;
	}

	public long getCustomCompanyId() {
		return _customCompanyId;
	}

	public void setCustomCompanyId(long customCompanyId) {
		_customCompanyId = customCompanyId;
	}

	public String getBillNo() {
		return _billNo;
	}

	public void setBillNo(String billNo) {
		_billNo = billNo;
	}

	public String getInternalBillNo() {
		return _internalBillNo;
	}

	public void setInternalBillNo(String internalBillNo) {
		_internalBillNo = internalBillNo;
	}

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public long getBillFileEntryId() {
		return _billFileEntryId;
	}

	public void setBillFileEntryId(long billFileEntryId) {
		_billFileEntryId = billFileEntryId;
	}

	public String getClientPANNo() {
		return _clientPANNo;
	}

	public void setClientPANNo(String clientPANNo) {
		_clientPANNo = clientPANNo;
	}

	public String getClientPONumber() {
		return _clientPONumber;
	}

	public void setClientPONumber(String clientPONumber) {
		_clientPONumber = clientPONumber;
	}

	public String getClientGSTNumber() {
		return _clientGSTNumber;
	}

	public void setClientGSTNumber(String clientGSTNumber) {
		_clientGSTNumber = clientGSTNumber;
	}

	public String getDisplay() {
		return _display;
	}

	public void setDisplay(String display) {
		_display = display;
	}

	public double getAccessAmount() {
		return _accessAmount;
	}

	public void setAccessAmount(double accessAmount) {
		_accessAmount = accessAmount;
	}

	public double getPendingAmount() {
		return _pendingAmount;
	}

	public void setPendingAmount(double pendingAmount) {
		_pendingAmount = pendingAmount;
	}

	public String getFinancialYear() {
		return _financialYear;
	}

	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
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

	private long _billingId;
	private long _customCompanyId;
	private String _billNo;
	private String _internalBillNo;
	private long _bookingId;
	private long _clientId;
	private long _billFileEntryId;
	private String _clientPANNo;
	private String _clientPONumber;
	private String _clientGSTNumber;
	private String _display;
	private double _accessAmount;
	private double _pendingAmount;
	private String _financialYear;
	private int _status;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}