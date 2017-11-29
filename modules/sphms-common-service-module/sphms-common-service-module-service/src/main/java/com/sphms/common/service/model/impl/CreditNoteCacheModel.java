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

import com.sphms.common.service.model.CreditNote;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CreditNote in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CreditNote
 * @generated
 */
@ProviderType
public class CreditNoteCacheModel implements CacheModel<CreditNote>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditNoteCacheModel)) {
			return false;
		}

		CreditNoteCacheModel creditNoteCacheModel = (CreditNoteCacheModel)obj;

		if (creditNoteId == creditNoteCacheModel.creditNoteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, creditNoteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{creditNoteId=");
		sb.append(creditNoteId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", billingId=");
		sb.append(billingId);
		sb.append(", creditNoteNumber=");
		sb.append(creditNoteNumber);
		sb.append(", creditNoteAmount=");
		sb.append(creditNoteAmount);
		sb.append(", creditNoteTax=");
		sb.append(creditNoteTax);
		sb.append(", paymentDate=");
		sb.append(paymentDate);
		sb.append(", chequeNo=");
		sb.append(chequeNo);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", financialYear=");
		sb.append(financialYear);
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
	public CreditNote toEntityModel() {
		CreditNoteImpl creditNoteImpl = new CreditNoteImpl();

		creditNoteImpl.setCreditNoteId(creditNoteId);
		creditNoteImpl.setClientId(clientId);
		creditNoteImpl.setBillingId(billingId);

		if (creditNoteNumber == null) {
			creditNoteImpl.setCreditNoteNumber(StringPool.BLANK);
		}
		else {
			creditNoteImpl.setCreditNoteNumber(creditNoteNumber);
		}

		creditNoteImpl.setCreditNoteAmount(creditNoteAmount);
		creditNoteImpl.setCreditNoteTax(creditNoteTax);

		if (paymentDate == Long.MIN_VALUE) {
			creditNoteImpl.setPaymentDate(null);
		}
		else {
			creditNoteImpl.setPaymentDate(new Date(paymentDate));
		}

		if (chequeNo == null) {
			creditNoteImpl.setChequeNo(StringPool.BLANK);
		}
		else {
			creditNoteImpl.setChequeNo(chequeNo);
		}

		if (bankName == null) {
			creditNoteImpl.setBankName(StringPool.BLANK);
		}
		else {
			creditNoteImpl.setBankName(bankName);
		}

		if (financialYear == null) {
			creditNoteImpl.setFinancialYear(StringPool.BLANK);
		}
		else {
			creditNoteImpl.setFinancialYear(financialYear);
		}

		if (createDate == Long.MIN_VALUE) {
			creditNoteImpl.setCreateDate(null);
		}
		else {
			creditNoteImpl.setCreateDate(new Date(createDate));
		}

		creditNoteImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			creditNoteImpl.setModifiedDate(null);
		}
		else {
			creditNoteImpl.setModifiedDate(new Date(modifiedDate));
		}

		creditNoteImpl.setModifiedBy(modifiedBy);

		creditNoteImpl.resetOriginalValues();

		return creditNoteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		creditNoteId = objectInput.readLong();

		clientId = objectInput.readLong();

		billingId = objectInput.readLong();
		creditNoteNumber = objectInput.readUTF();

		creditNoteAmount = objectInput.readDouble();

		creditNoteTax = objectInput.readDouble();
		paymentDate = objectInput.readLong();
		chequeNo = objectInput.readUTF();
		bankName = objectInput.readUTF();
		financialYear = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(creditNoteId);

		objectOutput.writeLong(clientId);

		objectOutput.writeLong(billingId);

		if (creditNoteNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(creditNoteNumber);
		}

		objectOutput.writeDouble(creditNoteAmount);

		objectOutput.writeDouble(creditNoteTax);
		objectOutput.writeLong(paymentDate);

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

		if (financialYear == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(financialYear);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long creditNoteId;
	public long clientId;
	public long billingId;
	public String creditNoteNumber;
	public double creditNoteAmount;
	public double creditNoteTax;
	public long paymentDate;
	public String chequeNo;
	public String bankName;
	public String financialYear;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}