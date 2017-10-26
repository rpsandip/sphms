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

import com.sphms.common.service.model.LandLord;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LandLord in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LandLord
 * @generated
 */
@ProviderType
public class LandLordCacheModel implements CacheModel<LandLord>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LandLordCacheModel)) {
			return false;
		}

		LandLordCacheModel landLordCacheModel = (LandLordCacheModel)obj;

		if (landLordId == landLordCacheModel.landLordId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, landLordId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{landLordId=");
		sb.append(landLordId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", location=");
		sb.append(location);
		sb.append(", city=");
		sb.append(city);
		sb.append(", status=");
		sb.append(status);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LandLord toEntityModel() {
		LandLordImpl landLordImpl = new LandLordImpl();

		landLordImpl.setLandLordId(landLordId);

		if (firstName == null) {
			landLordImpl.setFirstName(StringPool.BLANK);
		}
		else {
			landLordImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			landLordImpl.setLastName(StringPool.BLANK);
		}
		else {
			landLordImpl.setLastName(lastName);
		}

		if (location == null) {
			landLordImpl.setLocation(StringPool.BLANK);
		}
		else {
			landLordImpl.setLocation(location);
		}

		if (city == null) {
			landLordImpl.setCity(StringPool.BLANK);
		}
		else {
			landLordImpl.setCity(city);
		}

		landLordImpl.setStatus(status);

		if (phoneNo == null) {
			landLordImpl.setPhoneNo(StringPool.BLANK);
		}
		else {
			landLordImpl.setPhoneNo(phoneNo);
		}

		if (createDate == Long.MIN_VALUE) {
			landLordImpl.setCreateDate(null);
		}
		else {
			landLordImpl.setCreateDate(new Date(createDate));
		}

		landLordImpl.setCreatedBy(createdBy);

		landLordImpl.resetOriginalValues();

		return landLordImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		landLordId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		location = objectInput.readUTF();
		city = objectInput.readUTF();

		status = objectInput.readInt();
		phoneNo = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(landLordId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
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

		objectOutput.writeInt(status);

		if (phoneNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNo);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
	}

	public long landLordId;
	public String firstName;
	public String lastName;
	public String location;
	public String city;
	public int status;
	public String phoneNo;
	public long createDate;
	public long createdBy;
}