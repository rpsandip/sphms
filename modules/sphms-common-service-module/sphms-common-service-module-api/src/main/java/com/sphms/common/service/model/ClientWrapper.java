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

package com.sphms.common.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Client}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Client
 * @generated
 */
@ProviderType
public class ClientWrapper implements Client, ModelWrapper<Client> {
	public ClientWrapper(Client client) {
		_client = client;
	}

	@Override
	public Class<?> getModelClass() {
		return Client.class;
	}

	@Override
	public String getModelClassName() {
		return Client.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clientId", getClientId());
		attributes.put("clientName", getClientName());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("panNo", getPanNo());
		attributes.put("gstNo", getGstNo());
		attributes.put("state", getState());
		attributes.put("status", getStatus());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonEmail", getContactPersonEmail());
		attributes.put("contactPersonPhoneNo", getContactPersonPhoneNo());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String panNo = (String)attributes.get("panNo");

		if (panNo != null) {
			setPanNo(panNo);
		}

		String gstNo = (String)attributes.get("gstNo");

		if (gstNo != null) {
			setGstNo(gstNo);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonEmail = (String)attributes.get("contactPersonEmail");

		if (contactPersonEmail != null) {
			setContactPersonEmail(contactPersonEmail);
		}

		String contactPersonPhoneNo = (String)attributes.get(
				"contactPersonPhoneNo");

		if (contactPersonPhoneNo != null) {
			setContactPersonPhoneNo(contactPersonPhoneNo);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	@Override
	public Client toEscapedModel() {
		return new ClientWrapper(_client.toEscapedModel());
	}

	@Override
	public Client toUnescapedModel() {
		return new ClientWrapper(_client.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _client.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _client.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _client.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _client.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Client> toCacheModel() {
		return _client.toCacheModel();
	}

	@Override
	public int compareTo(Client client) {
		return _client.compareTo(client);
	}

	/**
	* Returns the status of this client.
	*
	* @return the status of this client
	*/
	@Override
	public int getStatus() {
		return _client.getStatus();
	}

	@Override
	public int hashCode() {
		return _client.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _client.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ClientWrapper((Client)_client.clone());
	}

	/**
	* Returns the address1 of this client.
	*
	* @return the address1 of this client
	*/
	@Override
	public java.lang.String getAddress1() {
		return _client.getAddress1();
	}

	/**
	* Returns the address2 of this client.
	*
	* @return the address2 of this client
	*/
	@Override
	public java.lang.String getAddress2() {
		return _client.getAddress2();
	}

	/**
	* Returns the city of this client.
	*
	* @return the city of this client
	*/
	@Override
	public java.lang.String getCity() {
		return _client.getCity();
	}

	/**
	* Returns the client name of this client.
	*
	* @return the client name of this client
	*/
	@Override
	public java.lang.String getClientName() {
		return _client.getClientName();
	}

	/**
	* Returns the contact person email of this client.
	*
	* @return the contact person email of this client
	*/
	@Override
	public java.lang.String getContactPersonEmail() {
		return _client.getContactPersonEmail();
	}

	/**
	* Returns the contact person name of this client.
	*
	* @return the contact person name of this client
	*/
	@Override
	public java.lang.String getContactPersonName() {
		return _client.getContactPersonName();
	}

	/**
	* Returns the contact person phone no of this client.
	*
	* @return the contact person phone no of this client
	*/
	@Override
	public java.lang.String getContactPersonPhoneNo() {
		return _client.getContactPersonPhoneNo();
	}

	/**
	* Returns the gst no of this client.
	*
	* @return the gst no of this client
	*/
	@Override
	public java.lang.String getGstNo() {
		return _client.getGstNo();
	}

	/**
	* Returns the pan no of this client.
	*
	* @return the pan no of this client
	*/
	@Override
	public java.lang.String getPanNo() {
		return _client.getPanNo();
	}

	/**
	* Returns the state of this client.
	*
	* @return the state of this client
	*/
	@Override
	public java.lang.String getState() {
		return _client.getState();
	}

	@Override
	public java.lang.String toString() {
		return _client.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _client.toXmlString();
	}

	/**
	* Returns the create date of this client.
	*
	* @return the create date of this client
	*/
	@Override
	public Date getCreateDate() {
		return _client.getCreateDate();
	}

	/**
	* Returns the client ID of this client.
	*
	* @return the client ID of this client
	*/
	@Override
	public long getClientId() {
		return _client.getClientId();
	}

	/**
	* Returns the created by of this client.
	*
	* @return the created by of this client
	*/
	@Override
	public long getCreatedBy() {
		return _client.getCreatedBy();
	}

	/**
	* Returns the primary key of this client.
	*
	* @return the primary key of this client
	*/
	@Override
	public long getPrimaryKey() {
		return _client.getPrimaryKey();
	}

	@Override
	public void persist() {
		_client.persist();
	}

	/**
	* Sets the address1 of this client.
	*
	* @param address1 the address1 of this client
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_client.setAddress1(address1);
	}

	/**
	* Sets the address2 of this client.
	*
	* @param address2 the address2 of this client
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_client.setAddress2(address2);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_client.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this client.
	*
	* @param city the city of this client
	*/
	@Override
	public void setCity(java.lang.String city) {
		_client.setCity(city);
	}

	/**
	* Sets the client ID of this client.
	*
	* @param clientId the client ID of this client
	*/
	@Override
	public void setClientId(long clientId) {
		_client.setClientId(clientId);
	}

	/**
	* Sets the client name of this client.
	*
	* @param clientName the client name of this client
	*/
	@Override
	public void setClientName(java.lang.String clientName) {
		_client.setClientName(clientName);
	}

	/**
	* Sets the contact person email of this client.
	*
	* @param contactPersonEmail the contact person email of this client
	*/
	@Override
	public void setContactPersonEmail(java.lang.String contactPersonEmail) {
		_client.setContactPersonEmail(contactPersonEmail);
	}

	/**
	* Sets the contact person name of this client.
	*
	* @param contactPersonName the contact person name of this client
	*/
	@Override
	public void setContactPersonName(java.lang.String contactPersonName) {
		_client.setContactPersonName(contactPersonName);
	}

	/**
	* Sets the contact person phone no of this client.
	*
	* @param contactPersonPhoneNo the contact person phone no of this client
	*/
	@Override
	public void setContactPersonPhoneNo(java.lang.String contactPersonPhoneNo) {
		_client.setContactPersonPhoneNo(contactPersonPhoneNo);
	}

	/**
	* Sets the create date of this client.
	*
	* @param createDate the create date of this client
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_client.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this client.
	*
	* @param createdBy the created by of this client
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_client.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_client.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_client.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_client.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gst no of this client.
	*
	* @param gstNo the gst no of this client
	*/
	@Override
	public void setGstNo(java.lang.String gstNo) {
		_client.setGstNo(gstNo);
	}

	@Override
	public void setNew(boolean n) {
		_client.setNew(n);
	}

	/**
	* Sets the pan no of this client.
	*
	* @param panNo the pan no of this client
	*/
	@Override
	public void setPanNo(java.lang.String panNo) {
		_client.setPanNo(panNo);
	}

	/**
	* Sets the primary key of this client.
	*
	* @param primaryKey the primary key of this client
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_client.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_client.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the state of this client.
	*
	* @param state the state of this client
	*/
	@Override
	public void setState(java.lang.String state) {
		_client.setState(state);
	}

	/**
	* Sets the status of this client.
	*
	* @param status the status of this client
	*/
	@Override
	public void setStatus(int status) {
		_client.setStatus(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientWrapper)) {
			return false;
		}

		ClientWrapper clientWrapper = (ClientWrapper)obj;

		if (Objects.equals(_client, clientWrapper._client)) {
			return true;
		}

		return false;
	}

	@Override
	public Client getWrappedModel() {
		return _client;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _client.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _client.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_client.resetOriginalValues();
	}

	private final Client _client;
}