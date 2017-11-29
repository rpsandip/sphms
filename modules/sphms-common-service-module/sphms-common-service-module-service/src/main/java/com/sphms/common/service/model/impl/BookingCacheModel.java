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

import com.sphms.common.service.model.Booking;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Booking in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Booking
 * @generated
 */
@ProviderType
public class BookingCacheModel implements CacheModel<Booking>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookingCacheModel)) {
			return false;
		}

		BookingCacheModel bookingCacheModel = (BookingCacheModel)obj;

		if (bookingId == bookingCacheModel.bookingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{bookingId=");
		sb.append(bookingId);
		sb.append(", customCompanyId=");
		sb.append(customCompanyId);
		sb.append(", campaignTitle=");
		sb.append(campaignTitle);
		sb.append(", client=");
		sb.append(client);
		sb.append(", billId=");
		sb.append(billId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Booking toEntityModel() {
		BookingImpl bookingImpl = new BookingImpl();

		bookingImpl.setBookingId(bookingId);
		bookingImpl.setCustomCompanyId(customCompanyId);

		if (campaignTitle == null) {
			bookingImpl.setCampaignTitle(StringPool.BLANK);
		}
		else {
			bookingImpl.setCampaignTitle(campaignTitle);
		}

		bookingImpl.setClient(client);
		bookingImpl.setBillId(billId);
		bookingImpl.setStatus(status);

		if (startDate == Long.MIN_VALUE) {
			bookingImpl.setStartDate(null);
		}
		else {
			bookingImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			bookingImpl.setEndDate(null);
		}
		else {
			bookingImpl.setEndDate(new Date(endDate));
		}

		if (createDate == Long.MIN_VALUE) {
			bookingImpl.setCreateDate(null);
		}
		else {
			bookingImpl.setCreateDate(new Date(createDate));
		}

		bookingImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			bookingImpl.setModifiedDate(null);
		}
		else {
			bookingImpl.setModifiedDate(new Date(modifiedDate));
		}

		bookingImpl.setModifiedBy(modifiedBy);

		bookingImpl.resetOriginalValues();

		return bookingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookingId = objectInput.readLong();

		customCompanyId = objectInput.readLong();
		campaignTitle = objectInput.readUTF();

		client = objectInput.readLong();

		billId = objectInput.readLong();

		status = objectInput.readInt();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bookingId);

		objectOutput.writeLong(customCompanyId);

		if (campaignTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(campaignTitle);
		}

		objectOutput.writeLong(client);

		objectOutput.writeLong(billId);

		objectOutput.writeInt(status);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long bookingId;
	public long customCompanyId;
	public String campaignTitle;
	public long client;
	public long billId;
	public int status;
	public long startDate;
	public long endDate;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}