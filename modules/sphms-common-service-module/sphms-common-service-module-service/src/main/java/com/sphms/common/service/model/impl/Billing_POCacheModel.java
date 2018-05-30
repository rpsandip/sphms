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

import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.service.persistence.Billing_POPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Billing_PO in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Billing_PO
 * @generated
 */
@ProviderType
public class Billing_POCacheModel implements CacheModel<Billing_PO>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Billing_POCacheModel)) {
			return false;
		}

		Billing_POCacheModel billing_POCacheModel = (Billing_POCacheModel)obj;

		if (billing_POPK.equals(billing_POCacheModel.billing_POPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, billing_POPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{billingId=");
		sb.append(billingId);
		sb.append(", hordingId=");
		sb.append(hordingId);
		sb.append(", landLordId=");
		sb.append(landLordId);
		sb.append(", poNumber=");
		sb.append(poNumber);
		sb.append(", financialYear=");
		sb.append(financialYear);
		sb.append(", totalAmount=");
		sb.append(totalAmount);
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
	public Billing_PO toEntityModel() {
		Billing_POImpl billing_POImpl = new Billing_POImpl();

		billing_POImpl.setBillingId(billingId);
		billing_POImpl.setHordingId(hordingId);
		billing_POImpl.setLandLordId(landLordId);

		if (poNumber == null) {
			billing_POImpl.setPoNumber(StringPool.BLANK);
		}
		else {
			billing_POImpl.setPoNumber(poNumber);
		}

		if (financialYear == null) {
			billing_POImpl.setFinancialYear(StringPool.BLANK);
		}
		else {
			billing_POImpl.setFinancialYear(financialYear);
		}

		billing_POImpl.setTotalAmount(totalAmount);

		if (createDate == Long.MIN_VALUE) {
			billing_POImpl.setCreateDate(null);
		}
		else {
			billing_POImpl.setCreateDate(new Date(createDate));
		}

		billing_POImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			billing_POImpl.setModifiedDate(null);
		}
		else {
			billing_POImpl.setModifiedDate(new Date(modifiedDate));
		}

		billing_POImpl.setModifiedBy(modifiedBy);

		billing_POImpl.resetOriginalValues();

		return billing_POImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		billingId = objectInput.readLong();

		hordingId = objectInput.readLong();

		landLordId = objectInput.readLong();
		poNumber = objectInput.readUTF();
		financialYear = objectInput.readUTF();

		totalAmount = objectInput.readDouble();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		billing_POPK = new Billing_POPK(billingId, hordingId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(billingId);

		objectOutput.writeLong(hordingId);

		objectOutput.writeLong(landLordId);

		if (poNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(poNumber);
		}

		if (financialYear == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(financialYear);
		}

		objectOutput.writeDouble(totalAmount);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long billingId;
	public long hordingId;
	public long landLordId;
	public String poNumber;
	public String financialYear;
	public double totalAmount;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public transient Billing_POPK billing_POPK;
}