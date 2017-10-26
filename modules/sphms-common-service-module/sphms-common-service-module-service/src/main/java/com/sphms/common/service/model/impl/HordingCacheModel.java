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

import com.sphms.common.service.model.Hording;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Hording in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Hording
 * @generated
 */
@ProviderType
public class HordingCacheModel implements CacheModel<Hording>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HordingCacheModel)) {
			return false;
		}

		HordingCacheModel hordingCacheModel = (HordingCacheModel)obj;

		if (hordingId == hordingCacheModel.hordingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, hordingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{hordingId=");
		sb.append(hordingId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", location=");
		sb.append(location);
		sb.append(", city=");
		sb.append(city);
		sb.append(", district=");
		sb.append(district);
		sb.append(", state=");
		sb.append(state);
		sb.append(", hordingType=");
		sb.append(hordingType);
		sb.append(", mediaVehicle=");
		sb.append(mediaVehicle);
		sb.append(", size=");
		sb.append(size);
		sb.append(", pricePerMonth=");
		sb.append(pricePerMonth);
		sb.append(", normalImageId=");
		sb.append(normalImageId);
		sb.append(", shortImageId=");
		sb.append(shortImageId);
		sb.append(", longImageId=");
		sb.append(longImageId);
		sb.append(", landLordId=");
		sb.append(landLordId);
		sb.append(", ownerType=");
		sb.append(ownerType);
		sb.append(", upinNo=");
		sb.append(upinNo);
		sb.append(", mncTax=");
		sb.append(mncTax);
		sb.append(", otherExpYear=");
		sb.append(otherExpYear);
		sb.append(", status=");
		sb.append(status);
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
	public Hording toEntityModel() {
		HordingImpl hordingImpl = new HordingImpl();

		hordingImpl.setHordingId(hordingId);

		if (title == null) {
			hordingImpl.setTitle(StringPool.BLANK);
		}
		else {
			hordingImpl.setTitle(title);
		}

		if (location == null) {
			hordingImpl.setLocation(StringPool.BLANK);
		}
		else {
			hordingImpl.setLocation(location);
		}

		if (city == null) {
			hordingImpl.setCity(StringPool.BLANK);
		}
		else {
			hordingImpl.setCity(city);
		}

		if (district == null) {
			hordingImpl.setDistrict(StringPool.BLANK);
		}
		else {
			hordingImpl.setDistrict(district);
		}

		if (state == null) {
			hordingImpl.setState(StringPool.BLANK);
		}
		else {
			hordingImpl.setState(state);
		}

		if (hordingType == null) {
			hordingImpl.setHordingType(StringPool.BLANK);
		}
		else {
			hordingImpl.setHordingType(hordingType);
		}

		if (mediaVehicle == null) {
			hordingImpl.setMediaVehicle(StringPool.BLANK);
		}
		else {
			hordingImpl.setMediaVehicle(mediaVehicle);
		}

		if (size == null) {
			hordingImpl.setSize(StringPool.BLANK);
		}
		else {
			hordingImpl.setSize(size);
		}

		hordingImpl.setPricePerMonth(pricePerMonth);
		hordingImpl.setNormalImageId(normalImageId);
		hordingImpl.setShortImageId(shortImageId);
		hordingImpl.setLongImageId(longImageId);
		hordingImpl.setLandLordId(landLordId);
		hordingImpl.setOwnerType(ownerType);

		if (upinNo == null) {
			hordingImpl.setUpinNo(StringPool.BLANK);
		}
		else {
			hordingImpl.setUpinNo(upinNo);
		}

		hordingImpl.setMncTax(mncTax);
		hordingImpl.setOtherExpYear(otherExpYear);
		hordingImpl.setStatus(status);

		if (createDate == Long.MIN_VALUE) {
			hordingImpl.setCreateDate(null);
		}
		else {
			hordingImpl.setCreateDate(new Date(createDate));
		}

		hordingImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			hordingImpl.setModifiedDate(null);
		}
		else {
			hordingImpl.setModifiedDate(new Date(modifiedDate));
		}

		hordingImpl.setModifiedBy(modifiedBy);

		hordingImpl.resetOriginalValues();

		return hordingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		hordingId = objectInput.readLong();
		title = objectInput.readUTF();
		location = objectInput.readUTF();
		city = objectInput.readUTF();
		district = objectInput.readUTF();
		state = objectInput.readUTF();
		hordingType = objectInput.readUTF();
		mediaVehicle = objectInput.readUTF();
		size = objectInput.readUTF();

		pricePerMonth = objectInput.readDouble();

		normalImageId = objectInput.readLong();

		shortImageId = objectInput.readLong();

		longImageId = objectInput.readLong();

		landLordId = objectInput.readLong();

		ownerType = objectInput.readInt();
		upinNo = objectInput.readUTF();

		mncTax = objectInput.readDouble();

		otherExpYear = objectInput.readDouble();

		status = objectInput.readInt();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(hordingId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (district == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(district);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (hordingType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hordingType);
		}

		if (mediaVehicle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mediaVehicle);
		}

		if (size == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(size);
		}

		objectOutput.writeDouble(pricePerMonth);

		objectOutput.writeLong(normalImageId);

		objectOutput.writeLong(shortImageId);

		objectOutput.writeLong(longImageId);

		objectOutput.writeLong(landLordId);

		objectOutput.writeInt(ownerType);

		if (upinNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(upinNo);
		}

		objectOutput.writeDouble(mncTax);

		objectOutput.writeDouble(otherExpYear);

		objectOutput.writeInt(status);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long hordingId;
	public String title;
	public String location;
	public String city;
	public String district;
	public String state;
	public String hordingType;
	public String mediaVehicle;
	public String size;
	public double pricePerMonth;
	public long normalImageId;
	public long shortImageId;
	public long longImageId;
	public long landLordId;
	public int ownerType;
	public String upinNo;
	public double mncTax;
	public double otherExpYear;
	public int status;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}