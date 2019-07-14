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

import com.sphms.common.service.model.POPayment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing POPayment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see POPayment
 * @generated
 */
@ProviderType
public class POPaymentCacheModel implements CacheModel<POPayment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof POPaymentCacheModel)) {
			return false;
		}

		POPaymentCacheModel poPaymentCacheModel = (POPaymentCacheModel)obj;

		if (poPaymentId == poPaymentCacheModel.poPaymentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, poPaymentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{poPaymentId=");
		sb.append(poPaymentId);
		sb.append(", billingId=");
		sb.append(billingId);
		sb.append(", landLordId=");
		sb.append(landLordId);
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
	public POPayment toEntityModel() {
		POPaymentImpl poPaymentImpl = new POPaymentImpl();

		poPaymentImpl.setPoPaymentId(poPaymentId);
		poPaymentImpl.setBillingId(billingId);
		poPaymentImpl.setLandLordId(landLordId);
		poPaymentImpl.setAmount(amount);
		poPaymentImpl.setGst(gst);

		if (chequeNo == null) {
			poPaymentImpl.setChequeNo(StringPool.BLANK);
		}
		else {
			poPaymentImpl.setChequeNo(chequeNo);
		}

		if (paymentDate == Long.MIN_VALUE) {
			poPaymentImpl.setPaymentDate(null);
		}
		else {
			poPaymentImpl.setPaymentDate(new Date(paymentDate));
		}

		if (createDate == Long.MIN_VALUE) {
			poPaymentImpl.setCreateDate(null);
		}
		else {
			poPaymentImpl.setCreateDate(new Date(createDate));
		}

		poPaymentImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			poPaymentImpl.setModifiedDate(null);
		}
		else {
			poPaymentImpl.setModifiedDate(new Date(modifiedDate));
		}

		poPaymentImpl.setModifiedBy(modifiedBy);

		poPaymentImpl.resetOriginalValues();

		return poPaymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		poPaymentId = objectInput.readLong();

		billingId = objectInput.readLong();

		landLordId = objectInput.readLong();

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
		objectOutput.writeLong(poPaymentId);

		objectOutput.writeLong(billingId);

		objectOutput.writeLong(landLordId);

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

	public long poPaymentId;
	public long billingId;
	public long landLordId;
	public double amount;
	public double gst;
	public String chequeNo;
	public long paymentDate;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}