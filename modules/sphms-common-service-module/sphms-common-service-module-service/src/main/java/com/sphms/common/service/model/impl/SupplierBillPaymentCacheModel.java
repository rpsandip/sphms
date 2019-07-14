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

import com.sphms.common.service.model.SupplierBillPayment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SupplierBillPayment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPayment
 * @generated
 */
@ProviderType
public class SupplierBillPaymentCacheModel implements CacheModel<SupplierBillPayment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupplierBillPaymentCacheModel)) {
			return false;
		}

		SupplierBillPaymentCacheModel supplierBillPaymentCacheModel = (SupplierBillPaymentCacheModel)obj;

		if (supplierBillPaymentId == supplierBillPaymentCacheModel.supplierBillPaymentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, supplierBillPaymentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{supplierBillPaymentId=");
		sb.append(supplierBillPaymentId);
		sb.append(", supplierBillId=");
		sb.append(supplierBillId);
		sb.append(", supplierId=");
		sb.append(supplierId);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", gst=");
		sb.append(gst);
		sb.append(", chequeNo=");
		sb.append(chequeNo);
		sb.append(", paymentDate=");
		sb.append(paymentDate);
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
	public SupplierBillPayment toEntityModel() {
		SupplierBillPaymentImpl supplierBillPaymentImpl = new SupplierBillPaymentImpl();

		supplierBillPaymentImpl.setSupplierBillPaymentId(supplierBillPaymentId);
		supplierBillPaymentImpl.setSupplierBillId(supplierBillId);
		supplierBillPaymentImpl.setSupplierId(supplierId);
		supplierBillPaymentImpl.setAmount(amount);
		supplierBillPaymentImpl.setGst(gst);

		if (chequeNo == null) {
			supplierBillPaymentImpl.setChequeNo(StringPool.BLANK);
		}
		else {
			supplierBillPaymentImpl.setChequeNo(chequeNo);
		}

		if (paymentDate == Long.MIN_VALUE) {
			supplierBillPaymentImpl.setPaymentDate(null);
		}
		else {
			supplierBillPaymentImpl.setPaymentDate(new Date(paymentDate));
		}

		if (createDate == Long.MIN_VALUE) {
			supplierBillPaymentImpl.setCreateDate(null);
		}
		else {
			supplierBillPaymentImpl.setCreateDate(new Date(createDate));
		}

		supplierBillPaymentImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			supplierBillPaymentImpl.setModifiedDate(null);
		}
		else {
			supplierBillPaymentImpl.setModifiedDate(new Date(modifiedDate));
		}

		supplierBillPaymentImpl.setModifiedBy(modifiedBy);

		supplierBillPaymentImpl.resetOriginalValues();

		return supplierBillPaymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supplierBillPaymentId = objectInput.readLong();

		supplierBillId = objectInput.readLong();

		supplierId = objectInput.readLong();

		amount = objectInput.readDouble();

		gst = objectInput.readDouble();
		chequeNo = objectInput.readUTF();
		paymentDate = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(supplierBillPaymentId);

		objectOutput.writeLong(supplierBillId);

		objectOutput.writeLong(supplierId);

		objectOutput.writeDouble(amount);

		objectOutput.writeDouble(gst);

		if (chequeNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chequeNo);
		}

		objectOutput.writeLong(paymentDate);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long supplierBillPaymentId;
	public long supplierBillId;
	public long supplierId;
	public double amount;
	public double gst;
	public String chequeNo;
	public long paymentDate;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}