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

import com.sphms.common.service.service.persistence.Billing_HordingPK;

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
public class Billing_HordingSoap implements Serializable {
	public static Billing_HordingSoap toSoapModel(Billing_Hording model) {
		Billing_HordingSoap soapModel = new Billing_HordingSoap();

		soapModel.setBillingId(model.getBillingId());
		soapModel.setHordingId(model.getHordingId());
		soapModel.setTotalMountingCharge(model.getTotalMountingCharge());
		soapModel.setTotalPrintingCharge(model.getTotalPrintingCharge());
		soapModel.setUnits(model.getUnits());
		soapModel.setTotalHordingCharge(model.getTotalHordingCharge());
		soapModel.setHsnNo(model.getHsnNo());
		soapModel.setHordingBookingStartDate(model.getHordingBookingStartDate());
		soapModel.setHordingBookingEndDate(model.getHordingBookingEndDate());

		return soapModel;
	}

	public static Billing_HordingSoap[] toSoapModels(Billing_Hording[] models) {
		Billing_HordingSoap[] soapModels = new Billing_HordingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Billing_HordingSoap[][] toSoapModels(
		Billing_Hording[][] models) {
		Billing_HordingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Billing_HordingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Billing_HordingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Billing_HordingSoap[] toSoapModels(
		List<Billing_Hording> models) {
		List<Billing_HordingSoap> soapModels = new ArrayList<Billing_HordingSoap>(models.size());

		for (Billing_Hording model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Billing_HordingSoap[soapModels.size()]);
	}

	public Billing_HordingSoap() {
	}

	public Billing_HordingPK getPrimaryKey() {
		return new Billing_HordingPK(_billingId, _hordingId);
	}

	public void setPrimaryKey(Billing_HordingPK pk) {
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

	public double getTotalMountingCharge() {
		return _totalMountingCharge;
	}

	public void setTotalMountingCharge(double totalMountingCharge) {
		_totalMountingCharge = totalMountingCharge;
	}

	public double getTotalPrintingCharge() {
		return _totalPrintingCharge;
	}

	public void setTotalPrintingCharge(double totalPrintingCharge) {
		_totalPrintingCharge = totalPrintingCharge;
	}

	public int getUnits() {
		return _units;
	}

	public void setUnits(int units) {
		_units = units;
	}

	public double getTotalHordingCharge() {
		return _totalHordingCharge;
	}

	public void setTotalHordingCharge(double totalHordingCharge) {
		_totalHordingCharge = totalHordingCharge;
	}

	public String getHsnNo() {
		return _hsnNo;
	}

	public void setHsnNo(String hsnNo) {
		_hsnNo = hsnNo;
	}

	public Date getHordingBookingStartDate() {
		return _hordingBookingStartDate;
	}

	public void setHordingBookingStartDate(Date hordingBookingStartDate) {
		_hordingBookingStartDate = hordingBookingStartDate;
	}

	public Date getHordingBookingEndDate() {
		return _hordingBookingEndDate;
	}

	public void setHordingBookingEndDate(Date hordingBookingEndDate) {
		_hordingBookingEndDate = hordingBookingEndDate;
	}

	private long _billingId;
	private long _hordingId;
	private double _totalMountingCharge;
	private double _totalPrintingCharge;
	private int _units;
	private double _totalHordingCharge;
	private String _hsnNo;
	private Date _hordingBookingStartDate;
	private Date _hordingBookingEndDate;
}