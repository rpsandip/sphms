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
 * This class is a wrapper for {@link SupplierBill}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBill
 * @generated
 */
@ProviderType
public class SupplierBillWrapper implements SupplierBill,
	ModelWrapper<SupplierBill> {
	public SupplierBillWrapper(SupplierBill supplierBill) {
		_supplierBill = supplierBill;
	}

	@Override
	public Class<?> getModelClass() {
		return SupplierBill.class;
	}

	@Override
	public String getModelClassName() {
		return SupplierBill.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplierBillId", getSupplierBillId());
		attributes.put("supplierId", getSupplierId());
		attributes.put("companyId", getCompanyId());
		attributes.put("supplierBillNo", getSupplierBillNo());
		attributes.put("supplierBillDesc", getSupplierBillDesc());
		attributes.put("supplierBillType", getSupplierBillType());
		attributes.put("supplierBillDate", getSupplierBillDate());
		attributes.put("amount", getAmount());
		attributes.put("gst", getGst());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supplierBillId = (Long)attributes.get("supplierBillId");

		if (supplierBillId != null) {
			setSupplierBillId(supplierBillId);
		}

		Long supplierId = (Long)attributes.get("supplierId");

		if (supplierId != null) {
			setSupplierId(supplierId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String supplierBillNo = (String)attributes.get("supplierBillNo");

		if (supplierBillNo != null) {
			setSupplierBillNo(supplierBillNo);
		}

		String supplierBillDesc = (String)attributes.get("supplierBillDesc");

		if (supplierBillDesc != null) {
			setSupplierBillDesc(supplierBillDesc);
		}

		String supplierBillType = (String)attributes.get("supplierBillType");

		if (supplierBillType != null) {
			setSupplierBillType(supplierBillType);
		}

		Date supplierBillDate = (Date)attributes.get("supplierBillDate");

		if (supplierBillDate != null) {
			setSupplierBillDate(supplierBillDate);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Double gst = (Double)attributes.get("gst");

		if (gst != null) {
			setGst(gst);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public SupplierBill toEscapedModel() {
		return new SupplierBillWrapper(_supplierBill.toEscapedModel());
	}

	@Override
	public SupplierBill toUnescapedModel() {
		return new SupplierBillWrapper(_supplierBill.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _supplierBill.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _supplierBill.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _supplierBill.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _supplierBill.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SupplierBill> toCacheModel() {
		return _supplierBill.toCacheModel();
	}

	/**
	* Returns the amount of this supplier bill.
	*
	* @return the amount of this supplier bill
	*/
	@Override
	public double getAmount() {
		return _supplierBill.getAmount();
	}

	/**
	* Returns the gst of this supplier bill.
	*
	* @return the gst of this supplier bill
	*/
	@Override
	public double getGst() {
		return _supplierBill.getGst();
	}

	@Override
	public int compareTo(SupplierBill supplierBill) {
		return _supplierBill.compareTo(supplierBill);
	}

	@Override
	public int hashCode() {
		return _supplierBill.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supplierBill.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SupplierBillWrapper((SupplierBill)_supplierBill.clone());
	}

	/**
	* Returns the supplier bill desc of this supplier bill.
	*
	* @return the supplier bill desc of this supplier bill
	*/
	@Override
	public java.lang.String getSupplierBillDesc() {
		return _supplierBill.getSupplierBillDesc();
	}

	/**
	* Returns the supplier bill no of this supplier bill.
	*
	* @return the supplier bill no of this supplier bill
	*/
	@Override
	public java.lang.String getSupplierBillNo() {
		return _supplierBill.getSupplierBillNo();
	}

	/**
	* Returns the supplier bill type of this supplier bill.
	*
	* @return the supplier bill type of this supplier bill
	*/
	@Override
	public java.lang.String getSupplierBillType() {
		return _supplierBill.getSupplierBillType();
	}

	@Override
	public java.lang.String toString() {
		return _supplierBill.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _supplierBill.toXmlString();
	}

	/**
	* Returns the create date of this supplier bill.
	*
	* @return the create date of this supplier bill
	*/
	@Override
	public Date getCreateDate() {
		return _supplierBill.getCreateDate();
	}

	/**
	* Returns the modified date of this supplier bill.
	*
	* @return the modified date of this supplier bill
	*/
	@Override
	public Date getModifiedDate() {
		return _supplierBill.getModifiedDate();
	}

	/**
	* Returns the supplier bill date of this supplier bill.
	*
	* @return the supplier bill date of this supplier bill
	*/
	@Override
	public Date getSupplierBillDate() {
		return _supplierBill.getSupplierBillDate();
	}

	/**
	* Returns the company ID of this supplier bill.
	*
	* @return the company ID of this supplier bill
	*/
	@Override
	public long getCompanyId() {
		return _supplierBill.getCompanyId();
	}

	/**
	* Returns the created by of this supplier bill.
	*
	* @return the created by of this supplier bill
	*/
	@Override
	public long getCreatedBy() {
		return _supplierBill.getCreatedBy();
	}

	/**
	* Returns the modified by of this supplier bill.
	*
	* @return the modified by of this supplier bill
	*/
	@Override
	public long getModifiedBy() {
		return _supplierBill.getModifiedBy();
	}

	/**
	* Returns the primary key of this supplier bill.
	*
	* @return the primary key of this supplier bill
	*/
	@Override
	public long getPrimaryKey() {
		return _supplierBill.getPrimaryKey();
	}

	/**
	* Returns the supplier bill ID of this supplier bill.
	*
	* @return the supplier bill ID of this supplier bill
	*/
	@Override
	public long getSupplierBillId() {
		return _supplierBill.getSupplierBillId();
	}

	/**
	* Returns the supplier ID of this supplier bill.
	*
	* @return the supplier ID of this supplier bill
	*/
	@Override
	public long getSupplierId() {
		return _supplierBill.getSupplierId();
	}

	@Override
	public void persist() {
		_supplierBill.persist();
	}

	/**
	* Sets the amount of this supplier bill.
	*
	* @param amount the amount of this supplier bill
	*/
	@Override
	public void setAmount(double amount) {
		_supplierBill.setAmount(amount);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_supplierBill.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this supplier bill.
	*
	* @param companyId the company ID of this supplier bill
	*/
	@Override
	public void setCompanyId(long companyId) {
		_supplierBill.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this supplier bill.
	*
	* @param createDate the create date of this supplier bill
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_supplierBill.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this supplier bill.
	*
	* @param createdBy the created by of this supplier bill
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_supplierBill.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_supplierBill.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_supplierBill.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_supplierBill.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gst of this supplier bill.
	*
	* @param gst the gst of this supplier bill
	*/
	@Override
	public void setGst(double gst) {
		_supplierBill.setGst(gst);
	}

	/**
	* Sets the modified by of this supplier bill.
	*
	* @param modifiedBy the modified by of this supplier bill
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_supplierBill.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this supplier bill.
	*
	* @param modifiedDate the modified date of this supplier bill
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_supplierBill.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_supplierBill.setNew(n);
	}

	/**
	* Sets the primary key of this supplier bill.
	*
	* @param primaryKey the primary key of this supplier bill
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_supplierBill.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_supplierBill.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the supplier bill date of this supplier bill.
	*
	* @param supplierBillDate the supplier bill date of this supplier bill
	*/
	@Override
	public void setSupplierBillDate(Date supplierBillDate) {
		_supplierBill.setSupplierBillDate(supplierBillDate);
	}

	/**
	* Sets the supplier bill desc of this supplier bill.
	*
	* @param supplierBillDesc the supplier bill desc of this supplier bill
	*/
	@Override
	public void setSupplierBillDesc(java.lang.String supplierBillDesc) {
		_supplierBill.setSupplierBillDesc(supplierBillDesc);
	}

	/**
	* Sets the supplier bill ID of this supplier bill.
	*
	* @param supplierBillId the supplier bill ID of this supplier bill
	*/
	@Override
	public void setSupplierBillId(long supplierBillId) {
		_supplierBill.setSupplierBillId(supplierBillId);
	}

	/**
	* Sets the supplier bill no of this supplier bill.
	*
	* @param supplierBillNo the supplier bill no of this supplier bill
	*/
	@Override
	public void setSupplierBillNo(java.lang.String supplierBillNo) {
		_supplierBill.setSupplierBillNo(supplierBillNo);
	}

	/**
	* Sets the supplier bill type of this supplier bill.
	*
	* @param supplierBillType the supplier bill type of this supplier bill
	*/
	@Override
	public void setSupplierBillType(java.lang.String supplierBillType) {
		_supplierBill.setSupplierBillType(supplierBillType);
	}

	/**
	* Sets the supplier ID of this supplier bill.
	*
	* @param supplierId the supplier ID of this supplier bill
	*/
	@Override
	public void setSupplierId(long supplierId) {
		_supplierBill.setSupplierId(supplierId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupplierBillWrapper)) {
			return false;
		}

		SupplierBillWrapper supplierBillWrapper = (SupplierBillWrapper)obj;

		if (Objects.equals(_supplierBill, supplierBillWrapper._supplierBill)) {
			return true;
		}

		return false;
	}

	@Override
	public SupplierBill getWrappedModel() {
		return _supplierBill;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _supplierBill.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _supplierBill.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_supplierBill.resetOriginalValues();
	}

	private final SupplierBill _supplierBill;
}