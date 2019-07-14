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
 * This class is a wrapper for {@link SupplierBillPayment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPayment
 * @generated
 */
@ProviderType
public class SupplierBillPaymentWrapper implements SupplierBillPayment,
	ModelWrapper<SupplierBillPayment> {
	public SupplierBillPaymentWrapper(SupplierBillPayment supplierBillPayment) {
		_supplierBillPayment = supplierBillPayment;
	}

	@Override
	public Class<?> getModelClass() {
		return SupplierBillPayment.class;
	}

	@Override
	public String getModelClassName() {
		return SupplierBillPayment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplierBillPaymentId", getSupplierBillPaymentId());
		attributes.put("supplierBillId", getSupplierBillId());
		attributes.put("supplierId", getSupplierId());
		attributes.put("amount", getAmount());
		attributes.put("gst", getGst());
		attributes.put("chequeNo", getChequeNo());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supplierBillPaymentId = (Long)attributes.get(
				"supplierBillPaymentId");

		if (supplierBillPaymentId != null) {
			setSupplierBillPaymentId(supplierBillPaymentId);
		}

		Long supplierBillId = (Long)attributes.get("supplierBillId");

		if (supplierBillId != null) {
			setSupplierBillId(supplierBillId);
		}

		Long supplierId = (Long)attributes.get("supplierId");

		if (supplierId != null) {
			setSupplierId(supplierId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Double gst = (Double)attributes.get("gst");

		if (gst != null) {
			setGst(gst);
		}

		String chequeNo = (String)attributes.get("chequeNo");

		if (chequeNo != null) {
			setChequeNo(chequeNo);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
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
	public SupplierBillPayment toEscapedModel() {
		return new SupplierBillPaymentWrapper(_supplierBillPayment.toEscapedModel());
	}

	@Override
	public SupplierBillPayment toUnescapedModel() {
		return new SupplierBillPaymentWrapper(_supplierBillPayment.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _supplierBillPayment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _supplierBillPayment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _supplierBillPayment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _supplierBillPayment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SupplierBillPayment> toCacheModel() {
		return _supplierBillPayment.toCacheModel();
	}

	/**
	* Returns the amount of this supplier bill payment.
	*
	* @return the amount of this supplier bill payment
	*/
	@Override
	public double getAmount() {
		return _supplierBillPayment.getAmount();
	}

	/**
	* Returns the gst of this supplier bill payment.
	*
	* @return the gst of this supplier bill payment
	*/
	@Override
	public double getGst() {
		return _supplierBillPayment.getGst();
	}

	@Override
	public int compareTo(SupplierBillPayment supplierBillPayment) {
		return _supplierBillPayment.compareTo(supplierBillPayment);
	}

	@Override
	public int hashCode() {
		return _supplierBillPayment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supplierBillPayment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SupplierBillPaymentWrapper((SupplierBillPayment)_supplierBillPayment.clone());
	}

	/**
	* Returns the cheque no of this supplier bill payment.
	*
	* @return the cheque no of this supplier bill payment
	*/
	@Override
	public java.lang.String getChequeNo() {
		return _supplierBillPayment.getChequeNo();
	}

	@Override
	public java.lang.String toString() {
		return _supplierBillPayment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _supplierBillPayment.toXmlString();
	}

	/**
	* Returns the create date of this supplier bill payment.
	*
	* @return the create date of this supplier bill payment
	*/
	@Override
	public Date getCreateDate() {
		return _supplierBillPayment.getCreateDate();
	}

	/**
	* Returns the modified date of this supplier bill payment.
	*
	* @return the modified date of this supplier bill payment
	*/
	@Override
	public Date getModifiedDate() {
		return _supplierBillPayment.getModifiedDate();
	}

	/**
	* Returns the payment date of this supplier bill payment.
	*
	* @return the payment date of this supplier bill payment
	*/
	@Override
	public Date getPaymentDate() {
		return _supplierBillPayment.getPaymentDate();
	}

	/**
	* Returns the created by of this supplier bill payment.
	*
	* @return the created by of this supplier bill payment
	*/
	@Override
	public long getCreatedBy() {
		return _supplierBillPayment.getCreatedBy();
	}

	/**
	* Returns the modified by of this supplier bill payment.
	*
	* @return the modified by of this supplier bill payment
	*/
	@Override
	public long getModifiedBy() {
		return _supplierBillPayment.getModifiedBy();
	}

	/**
	* Returns the primary key of this supplier bill payment.
	*
	* @return the primary key of this supplier bill payment
	*/
	@Override
	public long getPrimaryKey() {
		return _supplierBillPayment.getPrimaryKey();
	}

	/**
	* Returns the supplier bill ID of this supplier bill payment.
	*
	* @return the supplier bill ID of this supplier bill payment
	*/
	@Override
	public long getSupplierBillId() {
		return _supplierBillPayment.getSupplierBillId();
	}

	/**
	* Returns the supplier bill payment ID of this supplier bill payment.
	*
	* @return the supplier bill payment ID of this supplier bill payment
	*/
	@Override
	public long getSupplierBillPaymentId() {
		return _supplierBillPayment.getSupplierBillPaymentId();
	}

	/**
	* Returns the supplier ID of this supplier bill payment.
	*
	* @return the supplier ID of this supplier bill payment
	*/
	@Override
	public long getSupplierId() {
		return _supplierBillPayment.getSupplierId();
	}

	@Override
	public void persist() {
		_supplierBillPayment.persist();
	}

	/**
	* Sets the amount of this supplier bill payment.
	*
	* @param amount the amount of this supplier bill payment
	*/
	@Override
	public void setAmount(double amount) {
		_supplierBillPayment.setAmount(amount);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_supplierBillPayment.setCachedModel(cachedModel);
	}

	/**
	* Sets the cheque no of this supplier bill payment.
	*
	* @param chequeNo the cheque no of this supplier bill payment
	*/
	@Override
	public void setChequeNo(java.lang.String chequeNo) {
		_supplierBillPayment.setChequeNo(chequeNo);
	}

	/**
	* Sets the create date of this supplier bill payment.
	*
	* @param createDate the create date of this supplier bill payment
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_supplierBillPayment.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this supplier bill payment.
	*
	* @param createdBy the created by of this supplier bill payment
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_supplierBillPayment.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_supplierBillPayment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_supplierBillPayment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_supplierBillPayment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gst of this supplier bill payment.
	*
	* @param gst the gst of this supplier bill payment
	*/
	@Override
	public void setGst(double gst) {
		_supplierBillPayment.setGst(gst);
	}

	/**
	* Sets the modified by of this supplier bill payment.
	*
	* @param modifiedBy the modified by of this supplier bill payment
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_supplierBillPayment.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this supplier bill payment.
	*
	* @param modifiedDate the modified date of this supplier bill payment
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_supplierBillPayment.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_supplierBillPayment.setNew(n);
	}

	/**
	* Sets the payment date of this supplier bill payment.
	*
	* @param paymentDate the payment date of this supplier bill payment
	*/
	@Override
	public void setPaymentDate(Date paymentDate) {
		_supplierBillPayment.setPaymentDate(paymentDate);
	}

	/**
	* Sets the primary key of this supplier bill payment.
	*
	* @param primaryKey the primary key of this supplier bill payment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_supplierBillPayment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_supplierBillPayment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the supplier bill ID of this supplier bill payment.
	*
	* @param supplierBillId the supplier bill ID of this supplier bill payment
	*/
	@Override
	public void setSupplierBillId(long supplierBillId) {
		_supplierBillPayment.setSupplierBillId(supplierBillId);
	}

	/**
	* Sets the supplier bill payment ID of this supplier bill payment.
	*
	* @param supplierBillPaymentId the supplier bill payment ID of this supplier bill payment
	*/
	@Override
	public void setSupplierBillPaymentId(long supplierBillPaymentId) {
		_supplierBillPayment.setSupplierBillPaymentId(supplierBillPaymentId);
	}

	/**
	* Sets the supplier ID of this supplier bill payment.
	*
	* @param supplierId the supplier ID of this supplier bill payment
	*/
	@Override
	public void setSupplierId(long supplierId) {
		_supplierBillPayment.setSupplierId(supplierId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupplierBillPaymentWrapper)) {
			return false;
		}

		SupplierBillPaymentWrapper supplierBillPaymentWrapper = (SupplierBillPaymentWrapper)obj;

		if (Objects.equals(_supplierBillPayment,
					supplierBillPaymentWrapper._supplierBillPayment)) {
			return true;
		}

		return false;
	}

	@Override
	public SupplierBillPayment getWrappedModel() {
		return _supplierBillPayment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _supplierBillPayment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _supplierBillPayment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_supplierBillPayment.resetOriginalValues();
	}

	private final SupplierBillPayment _supplierBillPayment;
}