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

import com.sphms.common.service.model.Supplier;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Supplier in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Supplier
 * @generated
 */
@ProviderType
public class SupplierCacheModel implements CacheModel<Supplier>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupplierCacheModel)) {
			return false;
		}

		SupplierCacheModel supplierCacheModel = (SupplierCacheModel)obj;

		if (supplierId == supplierCacheModel.supplierId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, supplierId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{supplierId=");
		sb.append(supplierId);
		sb.append(", supplierName=");
		sb.append(supplierName);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", panNo=");
		sb.append(panNo);
		sb.append(", gstNo=");
		sb.append(gstNo);
		sb.append(", state=");
		sb.append(state);
		sb.append(", status=");
		sb.append(status);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonEmail=");
		sb.append(contactPersonEmail);
		sb.append(", contactPersonPhoneNo=");
		sb.append(contactPersonPhoneNo);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Supplier toEntityModel() {
		SupplierImpl supplierImpl = new SupplierImpl();

		supplierImpl.setSupplierId(supplierId);

		if (supplierName == null) {
			supplierImpl.setSupplierName(StringPool.BLANK);
		}
		else {
			supplierImpl.setSupplierName(supplierName);
		}

		if (address1 == null) {
			supplierImpl.setAddress1(StringPool.BLANK);
		}
		else {
			supplierImpl.setAddress1(address1);
		}

		if (address2 == null) {
			supplierImpl.setAddress2(StringPool.BLANK);
		}
		else {
			supplierImpl.setAddress2(address2);
		}

		if (city == null) {
			supplierImpl.setCity(StringPool.BLANK);
		}
		else {
			supplierImpl.setCity(city);
		}

		if (panNo == null) {
			supplierImpl.setPanNo(StringPool.BLANK);
		}
		else {
			supplierImpl.setPanNo(panNo);
		}

		if (gstNo == null) {
			supplierImpl.setGstNo(StringPool.BLANK);
		}
		else {
			supplierImpl.setGstNo(gstNo);
		}

		if (state == null) {
			supplierImpl.setState(StringPool.BLANK);
		}
		else {
			supplierImpl.setState(state);
		}

		supplierImpl.setStatus(status);

		if (contactPersonName == null) {
			supplierImpl.setContactPersonName(StringPool.BLANK);
		}
		else {
			supplierImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonEmail == null) {
			supplierImpl.setContactPersonEmail(StringPool.BLANK);
		}
		else {
			supplierImpl.setContactPersonEmail(contactPersonEmail);
		}

		if (contactPersonPhoneNo == null) {
			supplierImpl.setContactPersonPhoneNo(StringPool.BLANK);
		}
		else {
			supplierImpl.setContactPersonPhoneNo(contactPersonPhoneNo);
		}

		if (createDate == Long.MIN_VALUE) {
			supplierImpl.setCreateDate(null);
		}
		else {
			supplierImpl.setCreateDate(new Date(createDate));
		}

		supplierImpl.setCreatedBy(createdBy);

		supplierImpl.resetOriginalValues();

		return supplierImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supplierId = objectInput.readLong();
		supplierName = objectInput.readUTF();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		panNo = objectInput.readUTF();
		gstNo = objectInput.readUTF();
		state = objectInput.readUTF();

		status = objectInput.readInt();
		contactPersonName = objectInput.readUTF();
		contactPersonEmail = objectInput.readUTF();
		contactPersonPhoneNo = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(supplierId);

		if (supplierName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplierName);
		}

		if (address1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (panNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(panNo);
		}

		if (gstNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gstNo);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeInt(status);

		if (contactPersonName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonName);
		}

		if (contactPersonEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonEmail);
		}

		if (contactPersonPhoneNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonPhoneNo);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
	}

	public long supplierId;
	public String supplierName;
	public String address1;
	public String address2;
	public String city;
	public String panNo;
	public String gstNo;
	public String state;
	public int status;
	public String contactPersonName;
	public String contactPersonEmail;
	public String contactPersonPhoneNo;
	public long createDate;
	public long createdBy;
}