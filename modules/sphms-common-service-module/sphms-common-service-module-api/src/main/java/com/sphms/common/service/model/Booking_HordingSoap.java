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

import com.sphms.common.service.service.persistence.Booking_HordingPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class Booking_HordingSoap implements Serializable {
	public static Booking_HordingSoap toSoapModel(Booking_Hording model) {
		Booking_HordingSoap soapModel = new Booking_HordingSoap();

		soapModel.setBookingId(model.getBookingId());
		soapModel.setHordingId(model.getHordingId());
		soapModel.setMountingCharge(model.getMountingCharge());
		soapModel.setPrintingCharge(model.getPrintingCharge());
		soapModel.setUnits(model.getUnits());

		return soapModel;
	}

	public static Booking_HordingSoap[] toSoapModels(Booking_Hording[] models) {
		Booking_HordingSoap[] soapModels = new Booking_HordingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Booking_HordingSoap[][] toSoapModels(
		Booking_Hording[][] models) {
		Booking_HordingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Booking_HordingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Booking_HordingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Booking_HordingSoap[] toSoapModels(
		List<Booking_Hording> models) {
		List<Booking_HordingSoap> soapModels = new ArrayList<Booking_HordingSoap>(models.size());

		for (Booking_Hording model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Booking_HordingSoap[soapModels.size()]);
	}

	public Booking_HordingSoap() {
	}

	public Booking_HordingPK getPrimaryKey() {
		return new Booking_HordingPK(_bookingId, _hordingId);
	}

	public void setPrimaryKey(Booking_HordingPK pk) {
		setBookingId(pk.bookingId);
		setHordingId(pk.hordingId);
	}

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	public long getHordingId() {
		return _hordingId;
	}

	public void setHordingId(long hordingId) {
		_hordingId = hordingId;
	}

	public double getMountingCharge() {
		return _mountingCharge;
	}

	public void setMountingCharge(double mountingCharge) {
		_mountingCharge = mountingCharge;
	}

	public double getPrintingCharge() {
		return _printingCharge;
	}

	public void setPrintingCharge(double printingCharge) {
		_printingCharge = printingCharge;
	}

	public int getUnits() {
		return _units;
	}

	public void setUnits(int units) {
		_units = units;
	}

	private long _bookingId;
	private long _hordingId;
	private double _mountingCharge;
	private double _printingCharge;
	private int _units;
}