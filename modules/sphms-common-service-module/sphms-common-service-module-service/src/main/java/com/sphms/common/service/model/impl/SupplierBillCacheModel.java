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

import com.sphms.common.service.model.SupplierBill;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SupplierBill in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBill
 * @generated
 */
@ProviderType
public class SupplierBillCacheModel implements CacheModel<SupplierBill>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupplierBillCacheModel)) {
			return false;
		}

		SupplierBillCacheModel supplierBillCacheModel = (SupplierBillCacheModel)obj;

		if (supplierBillId == supplierBillCacheModel.supplierBillId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, supplierBillId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{supplierBillId=");
		sb.append(supplierBillId);
		sb.append(", supplierId=");
		sb.append(supplierId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", supplierBillNo=");
		sb.append(supplierBillNo);
		sb.append(", supplierBillDesc=");
		sb.append(supplierBillDesc);
		sb.append(", supplierBillType=");
		sb.append(supplierBillType);
		sb.append(", supplierBillDate=");
		sb.append(supplierBillDate);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", gst=");
		sb.append(gst);
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
	public SupplierBill toEntityModel() {
		SupplierBillImpl supplierBillImpl = new SupplierBillImpl();

		supplierBillImpl.setSupplierBillId(supplierBillId);
		supplierBillImpl.setSupplierId(supplierId);
		supplierBillImpl.setCompanyId(companyId);

		if (supplierBillNo == null) {
			supplierBillImpl.setSupplierBillNo(StringPool.BLANK);
		}
		else {
			supplierBillImpl.setSupplierBillNo(supplierBillNo);
		}

		if (supplierBillDesc == null) {
			supplierBillImpl.setSupplierBillDesc(StringPool.BLANK);
		}
		else {
			supplierBillImpl.setSupplierBillDesc(supplierBillDesc);
		}

		if (supplierBillType == null) {
			supplierBillImpl.setSupplierBillType(StringPool.BLANK);
		}
		else {
			supplierBillImpl.setSupplierBillType(supplierBillType);
		}

		if (supplierBillDate == Long.MIN_VALUE) {
			supplierBillImpl.setSupplierBillDate(null);
		}
		else {
			supplierBillImpl.setSupplierBillDate(new Date(supplierBillDate));
		}

		supplierBillImpl.setAmount(amount);
		supplierBillImpl.setGst(gst);

		if (createDate == Long.MIN_VALUE) {
			supplierBillImpl.setCreateDate(null);
		}
		else {
			supplierBillImpl.setCreateDate(new Date(createDate));
		}

		supplierBillImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			supplierBillImpl.setModifiedDate(null);
		}
		else {
			supplierBillImpl.setModifiedDate(new Date(modifiedDate));
		}

		supplierBillImpl.setModifiedBy(modifiedBy);

		supplierBillImpl.resetOriginalValues();

		return supplierBillImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supplierBillId = objectInput.readLong();

		supplierId = objectInput.readLong();

		companyId = objectInput.readLong();
		supplierBillNo = objectInput.readUTF();
		supplierBillDesc = objectInput.readUTF();
		supplierBillType = objectInput.readUTF();
		supplierBillDate = objectInput.readLong();

		amount = objectInput.readDouble();

		gst = objectInput.readDouble();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(supplierBillId);

		objectOutput.writeLong(supplierId);

		objectOutput.writeLong(companyId);

		if (supplierBillNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplierBillNo);
		}

		if (supplierBillDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplierBillDesc);
		}

		if (supplierBillType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplierBillType);
		}

		objectOutput.writeLong(supplierBillDate);

		objectOutput.writeDouble(amount);

		objectOutput.writeDouble(gst);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long supplierBillId;
	public long supplierId;
	public long companyId;
	public String supplierBillNo;
	public String supplierBillDesc;
	public String supplierBillType;
	public long supplierBillDate;
	public double amount;
	public double gst;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}