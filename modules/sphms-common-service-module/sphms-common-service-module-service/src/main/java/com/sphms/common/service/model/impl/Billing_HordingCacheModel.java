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

import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.service.persistence.Billing_HordingPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Billing_Hording in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Billing_Hording
 * @generated
 */
@ProviderType
public class Billing_HordingCacheModel implements CacheModel<Billing_Hording>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Billing_HordingCacheModel)) {
			return false;
		}

		Billing_HordingCacheModel billing_HordingCacheModel = (Billing_HordingCacheModel)obj;

		if (billing_HordingPK.equals(
					billing_HordingCacheModel.billing_HordingPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, billing_HordingPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{billingId=");
		sb.append(billingId);
		sb.append(", hordingId=");
		sb.append(hordingId);
		sb.append(", totalMountingCharge=");
		sb.append(totalMountingCharge);
		sb.append(", totalPrintingCharge=");
		sb.append(totalPrintingCharge);
		sb.append(", units=");
		sb.append(units);
		sb.append(", totalHordingCharge=");
		sb.append(totalHordingCharge);
		sb.append(", hsnNo=");
		sb.append(hsnNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Billing_Hording toEntityModel() {
		Billing_HordingImpl billing_HordingImpl = new Billing_HordingImpl();

		billing_HordingImpl.setBillingId(billingId);
		billing_HordingImpl.setHordingId(hordingId);
		billing_HordingImpl.setTotalMountingCharge(totalMountingCharge);
		billing_HordingImpl.setTotalPrintingCharge(totalPrintingCharge);
		billing_HordingImpl.setUnits(units);
		billing_HordingImpl.setTotalHordingCharge(totalHordingCharge);

		if (hsnNo == null) {
			billing_HordingImpl.setHsnNo(StringPool.BLANK);
		}
		else {
			billing_HordingImpl.setHsnNo(hsnNo);
		}

		billing_HordingImpl.resetOriginalValues();

		return billing_HordingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		billingId = objectInput.readLong();

		hordingId = objectInput.readLong();

		totalMountingCharge = objectInput.readDouble();

		totalPrintingCharge = objectInput.readDouble();

		units = objectInput.readInt();

		totalHordingCharge = objectInput.readDouble();
		hsnNo = objectInput.readUTF();

		billing_HordingPK = new Billing_HordingPK(billingId, hordingId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(billingId);

		objectOutput.writeLong(hordingId);

		objectOutput.writeDouble(totalMountingCharge);

		objectOutput.writeDouble(totalPrintingCharge);

		objectOutput.writeInt(units);

		objectOutput.writeDouble(totalHordingCharge);

		if (hsnNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hsnNo);
		}
	}

	public long billingId;
	public long hordingId;
	public double totalMountingCharge;
	public double totalPrintingCharge;
	public int units;
	public double totalHordingCharge;
	public String hsnNo;
	public transient Billing_HordingPK billing_HordingPK;
}