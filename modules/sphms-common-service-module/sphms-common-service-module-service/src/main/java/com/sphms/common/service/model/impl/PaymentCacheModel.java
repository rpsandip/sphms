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

import com.sphms.common.service.model.Payment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Payment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Payment
 * @generated
 */
@ProviderType
public class PaymentCacheModel implements CacheModel<Payment>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PaymentCacheModel)) {
			return false;
		}

		PaymentCacheModel paymentCacheModel = (PaymentCacheModel)obj;

		if (paymentId == paymentCacheModel.paymentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, paymentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{paymentId=");
		sb.append(paymentId);
		sb.append(", billingId=");
		sb.append(billingId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", chequeNo=");
		sb.append(chequeNo);
		sb.append(", tds=");
		sb.append(tds);
		sb.append(", deduction=");
		sb.append(deduction);
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
	public Payment toEntityModel() {
		PaymentImpl paymentImpl = new PaymentImpl();

		paymentImpl.setPaymentId(paymentId);
		paymentImpl.setBillingId(billingId);
		paymentImpl.setClientId(clientId);
		paymentImpl.setAmount(amount);

		if (chequeNo == null) {
			paymentImpl.setChequeNo(StringPool.BLANK);
		}
		else {
			paymentImpl.setChequeNo(chequeNo);
		}

		paymentImpl.setTds(tds);
		paymentImpl.setDeduction(deduction);

		if (createDate == Long.MIN_VALUE) {
			paymentImpl.setCreateDate(null);
		}
		else {
			paymentImpl.setCreateDate(new Date(createDate));
		}

		paymentImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			paymentImpl.setModifiedDate(null);
		}
		else {
			paymentImpl.setModifiedDate(new Date(modifiedDate));
		}

		paymentImpl.setModifiedBy(modifiedBy);

		paymentImpl.resetOriginalValues();

		return paymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		paymentId = objectInput.readLong();

		billingId = objectInput.readLong();

		clientId = objectInput.readLong();

		amount = objectInput.readDouble();
		chequeNo = objectInput.readUTF();

		tds = objectInput.readDouble();

		deduction = objectInput.readDouble();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(paymentId);

		objectOutput.writeLong(billingId);

		objectOutput.writeLong(clientId);

		objectOutput.writeDouble(amount);

		if (chequeNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chequeNo);
		}

		objectOutput.writeDouble(tds);

		objectOutput.writeDouble(deduction);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long paymentId;
	public long billingId;
	public long clientId;
	public double amount;
	public String chequeNo;
	public double tds;
	public double deduction;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}