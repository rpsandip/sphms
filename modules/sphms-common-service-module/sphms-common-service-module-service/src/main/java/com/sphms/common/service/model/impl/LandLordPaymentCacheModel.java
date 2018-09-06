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

import com.sphms.common.service.model.LandLordPayment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LandLordPayment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPayment
 * @generated
 */
@ProviderType
public class LandLordPaymentCacheModel implements CacheModel<LandLordPayment>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LandLordPaymentCacheModel)) {
			return false;
		}

		LandLordPaymentCacheModel landLordPaymentCacheModel = (LandLordPaymentCacheModel)obj;

		if (landLordPaymentId == landLordPaymentCacheModel.landLordPaymentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, landLordPaymentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{landLordPaymentId=");
		sb.append(landLordPaymentId);
		sb.append(", landLoadId=");
		sb.append(landLoadId);
		sb.append(", hordingId=");
		sb.append(hordingId);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", chequeNo=");
		sb.append(chequeNo);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", paymentDate=");
		sb.append(paymentDate);
		sb.append(", description=");
		sb.append(description);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LandLordPayment toEntityModel() {
		LandLordPaymentImpl landLordPaymentImpl = new LandLordPaymentImpl();

		landLordPaymentImpl.setLandLordPaymentId(landLordPaymentId);
		landLordPaymentImpl.setLandLoadId(landLoadId);
		landLordPaymentImpl.setHordingId(hordingId);
		landLordPaymentImpl.setAmount(amount);

		if (chequeNo == null) {
			landLordPaymentImpl.setChequeNo(StringPool.BLANK);
		}
		else {
			landLordPaymentImpl.setChequeNo(chequeNo);
		}

		if (bankName == null) {
			landLordPaymentImpl.setBankName(StringPool.BLANK);
		}
		else {
			landLordPaymentImpl.setBankName(bankName);
		}

		if (paymentDate == Long.MIN_VALUE) {
			landLordPaymentImpl.setPaymentDate(null);
		}
		else {
			landLordPaymentImpl.setPaymentDate(new Date(paymentDate));
		}

		if (description == null) {
			landLordPaymentImpl.setDescription(StringPool.BLANK);
		}
		else {
			landLordPaymentImpl.setDescription(description);
		}

		if (createDate == Long.MIN_VALUE) {
			landLordPaymentImpl.setCreateDate(null);
		}
		else {
			landLordPaymentImpl.setCreateDate(new Date(createDate));
		}

		landLordPaymentImpl.setCreatedBy(createdBy);

		landLordPaymentImpl.resetOriginalValues();

		return landLordPaymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		landLordPaymentId = objectInput.readLong();

		landLoadId = objectInput.readLong();

		hordingId = objectInput.readLong();

		amount = objectInput.readDouble();
		chequeNo = objectInput.readUTF();
		bankName = objectInput.readUTF();
		paymentDate = objectInput.readLong();
		description = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(landLordPaymentId);

		objectOutput.writeLong(landLoadId);

		objectOutput.writeLong(hordingId);

		objectOutput.writeDouble(amount);

		if (chequeNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chequeNo);
		}

		if (bankName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		objectOutput.writeLong(paymentDate);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
	}

	public long landLordPaymentId;
	public long landLoadId;
	public long hordingId;
	public double amount;
	public String chequeNo;
	public String bankName;
	public long paymentDate;
	public String description;
	public long createDate;
	public long createdBy;
}