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
 * This class is a wrapper for {@link Supplier}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Supplier
 * @generated
 */
@ProviderType
public class SupplierWrapper implements Supplier, ModelWrapper<Supplier> {
	public SupplierWrapper(Supplier supplier) {
		_supplier = supplier;
	}

	@Override
	public Class<?> getModelClass() {
		return Supplier.class;
	}

	@Override
	public String getModelClassName() {
		return Supplier.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplierId", getSupplierId());
		attributes.put("supplierName", getSupplierName());
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
		Long supplierId = (Long)attributes.get("supplierId");

		if (supplierId != null) {
			setSupplierId(supplierId);
		}

		String supplierName = (String)attributes.get("supplierName");

		if (supplierName != null) {
			setSupplierName(supplierName);
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
	public Supplier toEscapedModel() {
		return new SupplierWrapper(_supplier.toEscapedModel());
	}

	@Override
	public Supplier toUnescapedModel() {
		return new SupplierWrapper(_supplier.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _supplier.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _supplier.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _supplier.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _supplier.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Supplier> toCacheModel() {
		return _supplier.toCacheModel();
	}

	@Override
	public int compareTo(Supplier supplier) {
		return _supplier.compareTo(supplier);
	}

	/**
	* Returns the status of this supplier.
	*
	* @return the status of this supplier
	*/
	@Override
	public int getStatus() {
		return _supplier.getStatus();
	}

	@Override
	public int hashCode() {
		return _supplier.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supplier.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SupplierWrapper((Supplier)_supplier.clone());
	}

	/**
	* Returns the address1 of this supplier.
	*
	* @return the address1 of this supplier
	*/
	@Override
	public java.lang.String getAddress1() {
		return _supplier.getAddress1();
	}

	/**
	* Returns the address2 of this supplier.
	*
	* @return the address2 of this supplier
	*/
	@Override
	public java.lang.String getAddress2() {
		return _supplier.getAddress2();
	}

	/**
	* Returns the city of this supplier.
	*
	* @return the city of this supplier
	*/
	@Override
	public java.lang.String getCity() {
		return _supplier.getCity();
	}

	/**
	* Returns the contact person email of this supplier.
	*
	* @return the contact person email of this supplier
	*/
	@Override
	public java.lang.String getContactPersonEmail() {
		return _supplier.getContactPersonEmail();
	}

	/**
	* Returns the contact person name of this supplier.
	*
	* @return the contact person name of this supplier
	*/
	@Override
	public java.lang.String getContactPersonName() {
		return _supplier.getContactPersonName();
	}

	/**
	* Returns the contact person phone no of this supplier.
	*
	* @return the contact person phone no of this supplier
	*/
	@Override
	public java.lang.String getContactPersonPhoneNo() {
		return _supplier.getContactPersonPhoneNo();
	}

	/**
	* Returns the gst no of this supplier.
	*
	* @return the gst no of this supplier
	*/
	@Override
	public java.lang.String getGstNo() {
		return _supplier.getGstNo();
	}

	/**
	* Returns the pan no of this supplier.
	*
	* @return the pan no of this supplier
	*/
	@Override
	public java.lang.String getPanNo() {
		return _supplier.getPanNo();
	}

	/**
	* Returns the state of this supplier.
	*
	* @return the state of this supplier
	*/
	@Override
	public java.lang.String getState() {
		return _supplier.getState();
	}

	/**
	* Returns the supplier name of this supplier.
	*
	* @return the supplier name of this supplier
	*/
	@Override
	public java.lang.String getSupplierName() {
		return _supplier.getSupplierName();
	}

	@Override
	public java.lang.String toString() {
		return _supplier.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _supplier.toXmlString();
	}

	/**
	* Returns the create date of this supplier.
	*
	* @return the create date of this supplier
	*/
	@Override
	public Date getCreateDate() {
		return _supplier.getCreateDate();
	}

	/**
	* Returns the created by of this supplier.
	*
	* @return the created by of this supplier
	*/
	@Override
	public long getCreatedBy() {
		return _supplier.getCreatedBy();
	}

	/**
	* Returns the primary key of this supplier.
	*
	* @return the primary key of this supplier
	*/
	@Override
	public long getPrimaryKey() {
		return _supplier.getPrimaryKey();
	}

	/**
	* Returns the supplier ID of this supplier.
	*
	* @return the supplier ID of this supplier
	*/
	@Override
	public long getSupplierId() {
		return _supplier.getSupplierId();
	}

	@Override
	public void persist() {
		_supplier.persist();
	}

	/**
	* Sets the address1 of this supplier.
	*
	* @param address1 the address1 of this supplier
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_supplier.setAddress1(address1);
	}

	/**
	* Sets the address2 of this supplier.
	*
	* @param address2 the address2 of this supplier
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_supplier.setAddress2(address2);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_supplier.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this supplier.
	*
	* @param city the city of this supplier
	*/
	@Override
	public void setCity(java.lang.String city) {
		_supplier.setCity(city);
	}

	/**
	* Sets the contact person email of this supplier.
	*
	* @param contactPersonEmail the contact person email of this supplier
	*/
	@Override
	public void setContactPersonEmail(java.lang.String contactPersonEmail) {
		_supplier.setContactPersonEmail(contactPersonEmail);
	}

	/**
	* Sets the contact person name of this supplier.
	*
	* @param contactPersonName the contact person name of this supplier
	*/
	@Override
	public void setContactPersonName(java.lang.String contactPersonName) {
		_supplier.setContactPersonName(contactPersonName);
	}

	/**
	* Sets the contact person phone no of this supplier.
	*
	* @param contactPersonPhoneNo the contact person phone no of this supplier
	*/
	@Override
	public void setContactPersonPhoneNo(java.lang.String contactPersonPhoneNo) {
		_supplier.setContactPersonPhoneNo(contactPersonPhoneNo);
	}

	/**
	* Sets the create date of this supplier.
	*
	* @param createDate the create date of this supplier
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_supplier.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this supplier.
	*
	* @param createdBy the created by of this supplier
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_supplier.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_supplier.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_supplier.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_supplier.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gst no of this supplier.
	*
	* @param gstNo the gst no of this supplier
	*/
	@Override
	public void setGstNo(java.lang.String gstNo) {
		_supplier.setGstNo(gstNo);
	}

	@Override
	public void setNew(boolean n) {
		_supplier.setNew(n);
	}

	/**
	* Sets the pan no of this supplier.
	*
	* @param panNo the pan no of this supplier
	*/
	@Override
	public void setPanNo(java.lang.String panNo) {
		_supplier.setPanNo(panNo);
	}

	/**
	* Sets the primary key of this supplier.
	*
	* @param primaryKey the primary key of this supplier
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_supplier.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_supplier.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the state of this supplier.
	*
	* @param state the state of this supplier
	*/
	@Override
	public void setState(java.lang.String state) {
		_supplier.setState(state);
	}

	/**
	* Sets the status of this supplier.
	*
	* @param status the status of this supplier
	*/
	@Override
	public void setStatus(int status) {
		_supplier.setStatus(status);
	}

	/**
	* Sets the supplier ID of this supplier.
	*
	* @param supplierId the supplier ID of this supplier
	*/
	@Override
	public void setSupplierId(long supplierId) {
		_supplier.setSupplierId(supplierId);
	}

	/**
	* Sets the supplier name of this supplier.
	*
	* @param supplierName the supplier name of this supplier
	*/
	@Override
	public void setSupplierName(java.lang.String supplierName) {
		_supplier.setSupplierName(supplierName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupplierWrapper)) {
			return false;
		}

		SupplierWrapper supplierWrapper = (SupplierWrapper)obj;

		if (Objects.equals(_supplier, supplierWrapper._supplier)) {
			return true;
		}

		return false;
	}

	@Override
	public Supplier getWrappedModel() {
		return _supplier;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _supplier.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _supplier.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_supplier.resetOriginalValues();
	}

	private final Supplier _supplier;
}