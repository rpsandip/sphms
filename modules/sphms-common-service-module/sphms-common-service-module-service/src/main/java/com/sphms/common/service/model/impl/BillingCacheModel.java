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

import com.sphms.common.service.model.Billing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Billing in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Billing
 * @generated
 */
@ProviderType
public class BillingCacheModel implements CacheModel<Billing>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BillingCacheModel)) {
			return false;
		}

		BillingCacheModel billingCacheModel = (BillingCacheModel)obj;

		if (billingId == billingCacheModel.billingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, billingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{billingId=");
		sb.append(billingId);
		sb.append(", customCompanyId=");
		sb.append(customCompanyId);
		sb.append(", billNo=");
		sb.append(billNo);
		sb.append(", internalBillNo=");
		sb.append(internalBillNo);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", billFileEntryId=");
		sb.append(billFileEntryId);
		sb.append(", clientPANNo=");
		sb.append(clientPANNo);
		sb.append(", clientPONumber=");
		sb.append(clientPONumber);
		sb.append(", clientGSTNumber=");
		sb.append(clientGSTNumber);
		sb.append(", display=");
		sb.append(display);
		sb.append(", accessAmount=");
		sb.append(accessAmount);
		sb.append(", pendingAmount=");
		sb.append(pendingAmount);
		sb.append(", financialYear=");
		sb.append(financialYear);
		sb.append(", status=");
		sb.append(status);
		sb.append(", publishDate=");
		sb.append(publishDate);
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
	public Billing toEntityModel() {
		BillingImpl billingImpl = new BillingImpl();

		billingImpl.setBillingId(billingId);
		billingImpl.setCustomCompanyId(customCompanyId);

		if (billNo == null) {
			billingImpl.setBillNo(StringPool.BLANK);
		}
		else {
			billingImpl.setBillNo(billNo);
		}

		if (internalBillNo == null) {
			billingImpl.setInternalBillNo(StringPool.BLANK);
		}
		else {
			billingImpl.setInternalBillNo(internalBillNo);
		}

		billingImpl.setBookingId(bookingId);
		billingImpl.setClientId(clientId);
		billingImpl.setBillFileEntryId(billFileEntryId);

		if (clientPANNo == null) {
			billingImpl.setClientPANNo(StringPool.BLANK);
		}
		else {
			billingImpl.setClientPANNo(clientPANNo);
		}

		if (clientPONumber == null) {
			billingImpl.setClientPONumber(StringPool.BLANK);
		}
		else {
			billingImpl.setClientPONumber(clientPONumber);
		}

		if (clientGSTNumber == null) {
			billingImpl.setClientGSTNumber(StringPool.BLANK);
		}
		else {
			billingImpl.setClientGSTNumber(clientGSTNumber);
		}

		if (display == null) {
			billingImpl.setDisplay(StringPool.BLANK);
		}
		else {
			billingImpl.setDisplay(display);
		}

		billingImpl.setAccessAmount(accessAmount);
		billingImpl.setPendingAmount(pendingAmount);

		if (financialYear == null) {
			billingImpl.setFinancialYear(StringPool.BLANK);
		}
		else {
			billingImpl.setFinancialYear(financialYear);
		}

		billingImpl.setStatus(status);

		if (publishDate == Long.MIN_VALUE) {
			billingImpl.setPublishDate(null);
		}
		else {
			billingImpl.setPublishDate(new Date(publishDate));
		}

		if (createDate == Long.MIN_VALUE) {
			billingImpl.setCreateDate(null);
		}
		else {
			billingImpl.setCreateDate(new Date(createDate));
		}

		billingImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			billingImpl.setModifiedDate(null);
		}
		else {
			billingImpl.setModifiedDate(new Date(modifiedDate));
		}

		billingImpl.setModifiedBy(modifiedBy);

		billingImpl.resetOriginalValues();

		return billingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		billingId = objectInput.readLong();

		customCompanyId = objectInput.readLong();
		billNo = objectInput.readUTF();
		internalBillNo = objectInput.readUTF();

		bookingId = objectInput.readLong();

		clientId = objectInput.readLong();

		billFileEntryId = objectInput.readLong();
		clientPANNo = objectInput.readUTF();
		clientPONumber = objectInput.readUTF();
		clientGSTNumber = objectInput.readUTF();
		display = objectInput.readUTF();

		accessAmount = objectInput.readDouble();

		pendingAmount = objectInput.readDouble();
		financialYear = objectInput.readUTF();

		status = objectInput.readInt();
		publishDate = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(billingId);

		objectOutput.writeLong(customCompanyId);

		if (billNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(billNo);
		}

		if (internalBillNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(internalBillNo);
		}

		objectOutput.writeLong(bookingId);

		objectOutput.writeLong(clientId);

		objectOutput.writeLong(billFileEntryId);

		if (clientPANNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientPANNo);
		}

		if (clientPONumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientPONumber);
		}

		if (clientGSTNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientGSTNumber);
		}

		if (display == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(display);
		}

		objectOutput.writeDouble(accessAmount);

		objectOutput.writeDouble(pendingAmount);

		if (financialYear == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(financialYear);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(publishDate);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long billingId;
	public long customCompanyId;
	public String billNo;
	public String internalBillNo;
	public long bookingId;
	public long clientId;
	public long billFileEntryId;
	public String clientPANNo;
	public String clientPONumber;
	public String clientGSTNumber;
	public String display;
	public double accessAmount;
	public double pendingAmount;
	public String financialYear;
	public int status;
	public long publishDate;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}