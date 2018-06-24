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

package com.sphms.common.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.service.persistence.Booking_HordingPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Booking_Hording in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Booking_Hording
 * @generated
 */
@ProviderType
public class Booking_HordingCacheModel implements CacheModel<Booking_Hording>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Booking_HordingCacheModel)) {
			return false;
		}

		Booking_HordingCacheModel booking_HordingCacheModel = (Booking_HordingCacheModel)obj;

		if (booking_HordingPK.equals(
					booking_HordingCacheModel.booking_HordingPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, booking_HordingPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{bookingId=");
		sb.append(bookingId);
		sb.append(", hordingId=");
		sb.append(hordingId);
		sb.append(", mountingCharge=");
		sb.append(mountingCharge);
		sb.append(", printingCharge=");
		sb.append(printingCharge);
		sb.append(", units=");
		sb.append(units);
		sb.append(", hsnNo=");
		sb.append(hsnNo);
		sb.append(", hordingBookingStartDate=");
		sb.append(hordingBookingStartDate);
		sb.append(", hordingBookingEndDate=");
		sb.append(hordingBookingEndDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Booking_Hording toEntityModel() {
		Booking_HordingImpl booking_HordingImpl = new Booking_HordingImpl();

		booking_HordingImpl.setBookingId(bookingId);
		booking_HordingImpl.setHordingId(hordingId);
		booking_HordingImpl.setMountingCharge(mountingCharge);
		booking_HordingImpl.setPrintingCharge(printingCharge);
		booking_HordingImpl.setUnits(units);

		if (hsnNo == null) {
			booking_HordingImpl.setHsnNo(StringPool.BLANK);
		}
		else {
			booking_HordingImpl.setHsnNo(hsnNo);
		}

		if (hordingBookingStartDate == Long.MIN_VALUE) {
			booking_HordingImpl.setHordingBookingStartDate(null);
		}
		else {
			booking_HordingImpl.setHordingBookingStartDate(new Date(
					hordingBookingStartDate));
		}

		if (hordingBookingEndDate == Long.MIN_VALUE) {
			booking_HordingImpl.setHordingBookingEndDate(null);
		}
		else {
			booking_HordingImpl.setHordingBookingEndDate(new Date(
					hordingBookingEndDate));
		}

		booking_HordingImpl.resetOriginalValues();

		return booking_HordingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookingId = objectInput.readLong();

		hordingId = objectInput.readLong();

		mountingCharge = objectInput.readDouble();

		printingCharge = objectInput.readDouble();

		units = objectInput.readInt();
		hsnNo = objectInput.readUTF();
		hordingBookingStartDate = objectInput.readLong();
		hordingBookingEndDate = objectInput.readLong();

		booking_HordingPK = new Booking_HordingPK(bookingId, hordingId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bookingId);

		objectOutput.writeLong(hordingId);

		objectOutput.writeDouble(mountingCharge);

		objectOutput.writeDouble(printingCharge);

		objectOutput.writeInt(units);

		if (hsnNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hsnNo);
		}

		objectOutput.writeLong(hordingBookingStartDate);
		objectOutput.writeLong(hordingBookingEndDate);
	}

	public long bookingId;
	public long hordingId;
	public double mountingCharge;
	public double printingCharge;
	public int units;
	public String hsnNo;
	public long hordingBookingStartDate;
	public long hordingBookingEndDate;
	public transient Booking_HordingPK booking_HordingPK;
}