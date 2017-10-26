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

import com.sphms.common.service.model.Client;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Client in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Client
 * @generated
 */
@ProviderType
public class ClientCacheModel implements CacheModel<Client>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientCacheModel)) {
			return false;
		}

		ClientCacheModel clientCacheModel = (ClientCacheModel)obj;

		if (clientId == clientCacheModel.clientId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clientId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{clientId=");
		sb.append(clientId);
		sb.append(", clientName=");
		sb.append(clientName);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonEmail=");
		sb.append(contactPersonEmail);
		sb.append(", contactPersonPhoneNo=");
		sb.append(contactPersonPhoneNo);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Client toEntityModel() {
		ClientImpl clientImpl = new ClientImpl();

		clientImpl.setClientId(clientId);

		if (clientName == null) {
			clientImpl.setClientName(StringPool.BLANK);
		}
		else {
			clientImpl.setClientName(clientName);
		}

		if (address1 == null) {
			clientImpl.setAddress1(StringPool.BLANK);
		}
		else {
			clientImpl.setAddress1(address1);
		}

		if (address2 == null) {
			clientImpl.setAddress2(StringPool.BLANK);
		}
		else {
			clientImpl.setAddress2(address2);
		}

		if (city == null) {
			clientImpl.setCity(StringPool.BLANK);
		}
		else {
			clientImpl.setCity(city);
		}

		if (state == null) {
			clientImpl.setState(StringPool.BLANK);
		}
		else {
			clientImpl.setState(state);
		}

		if (contactPersonName == null) {
			clientImpl.setContactPersonName(StringPool.BLANK);
		}
		else {
			clientImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonEmail == null) {
			clientImpl.setContactPersonEmail(StringPool.BLANK);
		}
		else {
			clientImpl.setContactPersonEmail(contactPersonEmail);
		}

		if (contactPersonPhoneNo == null) {
			clientImpl.setContactPersonPhoneNo(StringPool.BLANK);
		}
		else {
			clientImpl.setContactPersonPhoneNo(contactPersonPhoneNo);
		}

		if (createDate == Long.MIN_VALUE) {
			clientImpl.setCreateDate(null);
		}
		else {
			clientImpl.setCreateDate(new Date(createDate));
		}

		clientImpl.setCreatedBy(createdBy);

		clientImpl.resetOriginalValues();

		return clientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clientId = objectInput.readLong();
		clientName = objectInput.readUTF();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonEmail = objectInput.readUTF();
		contactPersonPhoneNo = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(clientId);

		if (clientName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientName);
		}

		if (address1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (contactPersonName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonName);
		}

		if (contactPersonEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonEmail);
		}

		if (contactPersonPhoneNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonPhoneNo);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
	}

	public long clientId;
	public String clientName;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String contactPersonName;
	public String contactPersonEmail;
	public String contactPersonPhoneNo;
	public long createDate;
	public long createdBy;
}