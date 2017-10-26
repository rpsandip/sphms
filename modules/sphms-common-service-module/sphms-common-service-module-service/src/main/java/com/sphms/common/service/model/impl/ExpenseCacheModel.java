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

import com.sphms.common.service.model.Expense;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Expense in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Expense
 * @generated
 */
@ProviderType
public class ExpenseCacheModel implements CacheModel<Expense>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpenseCacheModel)) {
			return false;
		}

		ExpenseCacheModel expenseCacheModel = (ExpenseCacheModel)obj;

		if (expenseId == expenseCacheModel.expenseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, expenseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{expenseId=");
		sb.append(expenseId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", description=");
		sb.append(description);
		sb.append(", expenseDate=");
		sb.append(expenseDate);
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
	public Expense toEntityModel() {
		ExpenseImpl expenseImpl = new ExpenseImpl();

		expenseImpl.setExpenseId(expenseId);

		if (type == null) {
			expenseImpl.setType(StringPool.BLANK);
		}
		else {
			expenseImpl.setType(type);
		}

		expenseImpl.setAmount(amount);

		if (description == null) {
			expenseImpl.setDescription(StringPool.BLANK);
		}
		else {
			expenseImpl.setDescription(description);
		}

		if (expenseDate == Long.MIN_VALUE) {
			expenseImpl.setExpenseDate(null);
		}
		else {
			expenseImpl.setExpenseDate(new Date(expenseDate));
		}

		if (createDate == Long.MIN_VALUE) {
			expenseImpl.setCreateDate(null);
		}
		else {
			expenseImpl.setCreateDate(new Date(createDate));
		}

		expenseImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			expenseImpl.setModifiedDate(null);
		}
		else {
			expenseImpl.setModifiedDate(new Date(modifiedDate));
		}

		expenseImpl.setModifiedBy(modifiedBy);

		expenseImpl.resetOriginalValues();

		return expenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expenseId = objectInput.readLong();
		type = objectInput.readUTF();

		amount = objectInput.readDouble();
		description = objectInput.readUTF();
		expenseDate = objectInput.readLong();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(expenseId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeDouble(amount);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(expenseDate);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long expenseId;
	public String type;
	public double amount;
	public String description;
	public long expenseDate;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}