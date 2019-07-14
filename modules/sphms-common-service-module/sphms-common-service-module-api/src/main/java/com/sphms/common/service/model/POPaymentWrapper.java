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
 * This class is a wrapper for {@link POPayment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see POPayment
 * @generated
 */
@ProviderType
public class POPaymentWrapper implements POPayment, ModelWrapper<POPayment> {
	public POPaymentWrapper(POPayment poPayment) {
		_poPayment = poPayment;
	}

	@Override
	public Class<?> getModelClass() {
		return POPayment.class;
	}

	@Override
	public String getModelClassName() {
		return POPayment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("poPaymentId", getPoPaymentId());
		attributes.put("billingId", getBillingId());
		attributes.put("landLordId", getLandLordId());
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
		Long poPaymentId = (Long)attributes.get("poPaymentId");

		if (poPaymentId != null) {
			setPoPaymentId(poPaymentId);
		}

		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		Long landLordId = (Long)attributes.get("landLordId");

		if (landLordId != null) {
			setLandLordId(landLordId);
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
	public POPayment toEscapedModel() {
		return new POPaymentWrapper(_poPayment.toEscapedModel());
	}

	@Override
	public POPayment toUnescapedModel() {
		return new POPaymentWrapper(_poPayment.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _poPayment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _poPayment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _poPayment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _poPayment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<POPayment> toCacheModel() {
		return _poPayment.toCacheModel();
	}

	/**
	* Returns the amount of this p o payment.
	*
	* @return the amount of this p o payment
	*/
	@Override
	public double getAmount() {
		return _poPayment.getAmount();
	}

	/**
	* Returns the gst of this p o payment.
	*
	* @return the gst of this p o payment
	*/
	@Override
	public double getGst() {
		return _poPayment.getGst();
	}

	@Override
	public int compareTo(POPayment poPayment) {
		return _poPayment.compareTo(poPayment);
	}

	@Override
	public int hashCode() {
		return _poPayment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _poPayment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new POPaymentWrapper((POPayment)_poPayment.clone());
	}

	/**
	* Returns the cheque no of this p o payment.
	*
	* @return the cheque no of this p o payment
	*/
	@Override
	public java.lang.String getChequeNo() {
		return _poPayment.getChequeNo();
	}

	@Override
	public java.lang.String toString() {
		return _poPayment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _poPayment.toXmlString();
	}

	/**
	* Returns the create date of this p o payment.
	*
	* @return the create date of this p o payment
	*/
	@Override
	public Date getCreateDate() {
		return _poPayment.getCreateDate();
	}

	/**
	* Returns the modified date of this p o payment.
	*
	* @return the modified date of this p o payment
	*/
	@Override
	public Date getModifiedDate() {
		return _poPayment.getModifiedDate();
	}

	/**
	* Returns the payment date of this p o payment.
	*
	* @return the payment date of this p o payment
	*/
	@Override
	public Date getPaymentDate() {
		return _poPayment.getPaymentDate();
	}

	/**
	* Returns the billing ID of this p o payment.
	*
	* @return the billing ID of this p o payment
	*/
	@Override
	public long getBillingId() {
		return _poPayment.getBillingId();
	}

	/**
	* Returns the created by of this p o payment.
	*
	* @return the created by of this p o payment
	*/
	@Override
	public long getCreatedBy() {
		return _poPayment.getCreatedBy();
	}

	/**
	* Returns the land lord ID of this p o payment.
	*
	* @return the land lord ID of this p o payment
	*/
	@Override
	public long getLandLordId() {
		return _poPayment.getLandLordId();
	}

	/**
	* Returns the modified by of this p o payment.
	*
	* @return the modified by of this p o payment
	*/
	@Override
	public long getModifiedBy() {
		return _poPayment.getModifiedBy();
	}

	/**
	* Returns the po payment ID of this p o payment.
	*
	* @return the po payment ID of this p o payment
	*/
	@Override
	public long getPoPaymentId() {
		return _poPayment.getPoPaymentId();
	}

	/**
	* Returns the primary key of this p o payment.
	*
	* @return the primary key of this p o payment
	*/
	@Override
	public long getPrimaryKey() {
		return _poPayment.getPrimaryKey();
	}

	@Override
	public void persist() {
		_poPayment.persist();
	}

	/**
	* Sets the amount of this p o payment.
	*
	* @param amount the amount of this p o payment
	*/
	@Override
	public void setAmount(double amount) {
		_poPayment.setAmount(amount);
	}

	/**
	* Sets the billing ID of this p o payment.
	*
	* @param billingId the billing ID of this p o payment
	*/
	@Override
	public void setBillingId(long billingId) {
		_poPayment.setBillingId(billingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_poPayment.setCachedModel(cachedModel);
	}

	/**
	* Sets the cheque no of this p o payment.
	*
	* @param chequeNo the cheque no of this p o payment
	*/
	@Override
	public void setChequeNo(java.lang.String chequeNo) {
		_poPayment.setChequeNo(chequeNo);
	}

	/**
	* Sets the create date of this p o payment.
	*
	* @param createDate the create date of this p o payment
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_poPayment.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this p o payment.
	*
	* @param createdBy the created by of this p o payment
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_poPayment.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_poPayment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_poPayment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_poPayment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gst of this p o payment.
	*
	* @param gst the gst of this p o payment
	*/
	@Override
	public void setGst(double gst) {
		_poPayment.setGst(gst);
	}

	/**
	* Sets the land lord ID of this p o payment.
	*
	* @param landLordId the land lord ID of this p o payment
	*/
	@Override
	public void setLandLordId(long landLordId) {
		_poPayment.setLandLordId(landLordId);
	}

	/**
	* Sets the modified by of this p o payment.
	*
	* @param modifiedBy the modified by of this p o payment
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_poPayment.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this p o payment.
	*
	* @param modifiedDate the modified date of this p o payment
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_poPayment.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_poPayment.setNew(n);
	}

	/**
	* Sets the payment date of this p o payment.
	*
	* @param paymentDate the payment date of this p o payment
	*/
	@Override
	public void setPaymentDate(Date paymentDate) {
		_poPayment.setPaymentDate(paymentDate);
	}

	/**
	* Sets the po payment ID of this p o payment.
	*
	* @param poPaymentId the po payment ID of this p o payment
	*/
	@Override
	public void setPoPaymentId(long poPaymentId) {
		_poPayment.setPoPaymentId(poPaymentId);
	}

	/**
	* Sets the primary key of this p o payment.
	*
	* @param primaryKey the primary key of this p o payment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_poPayment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_poPayment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof POPaymentWrapper)) {
			return false;
		}

		POPaymentWrapper poPaymentWrapper = (POPaymentWrapper)obj;

		if (Objects.equals(_poPayment, poPaymentWrapper._poPayment)) {
			return true;
		}

		return false;
	}

	@Override
	public POPayment getWrappedModel() {
		return _poPayment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _poPayment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _poPayment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_poPayment.resetOriginalValues();
	}

	private final POPayment _poPayment;
}