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

import com.sphms.common.service.model.CustomCompany;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CustomCompany in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CustomCompany
 * @generated
 */
@ProviderType
public class CustomCompanyCacheModel implements CacheModel<CustomCompany>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomCompanyCacheModel)) {
			return false;
		}

		CustomCompanyCacheModel customCompanyCacheModel = (CustomCompanyCacheModel)obj;

		if (companyId == customCompanyCacheModel.companyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, companyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", GSTNo=");
		sb.append(GSTNo);
		sb.append(", PANNo=");
		sb.append(PANNo);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", accountDetail=");
		sb.append(accountDetail);
		sb.append(", poPrefix=");
		sb.append(poPrefix);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomCompany toEntityModel() {
		CustomCompanyImpl customCompanyImpl = new CustomCompanyImpl();

		customCompanyImpl.setCompanyId(companyId);

		if (name == null) {
			customCompanyImpl.setName(StringPool.BLANK);
		}
		else {
			customCompanyImpl.setName(name);
		}

		if (GSTNo == null) {
			customCompanyImpl.setGSTNo(StringPool.BLANK);
		}
		else {
			customCompanyImpl.setGSTNo(GSTNo);
		}

		if (PANNo == null) {
			customCompanyImpl.setPANNo(StringPool.BLANK);
		}
		else {
			customCompanyImpl.setPANNo(PANNo);
		}

		if (bankName == null) {
			customCompanyImpl.setBankName(StringPool.BLANK);
		}
		else {
			customCompanyImpl.setBankName(bankName);
		}

		if (accountDetail == null) {
			customCompanyImpl.setAccountDetail(StringPool.BLANK);
		}
		else {
			customCompanyImpl.setAccountDetail(accountDetail);
		}

		if (poPrefix == null) {
			customCompanyImpl.setPoPrefix(StringPool.BLANK);
		}
		else {
			customCompanyImpl.setPoPrefix(poPrefix);
		}

		if (shortName == null) {
			customCompanyImpl.setShortName(StringPool.BLANK);
		}
		else {
			customCompanyImpl.setShortName(shortName);
		}

		customCompanyImpl.resetOriginalValues();

		return customCompanyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();
		name = objectInput.readUTF();
		GSTNo = objectInput.readUTF();
		PANNo = objectInput.readUTF();
		bankName = objectInput.readUTF();
		accountDetail = objectInput.readUTF();
		poPrefix = objectInput.readUTF();
		shortName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(companyId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (GSTNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(GSTNo);
		}

		if (PANNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(PANNo);
		}

		if (bankName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (accountDetail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accountDetail);
		}

		if (poPrefix == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(poPrefix);
		}

		if (shortName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortName);
		}
	}

	public long companyId;
	public String name;
	public String GSTNo;
	public String PANNo;
	public String bankName;
	public String accountDetail;
	public String poPrefix;
	public String shortName;
}