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
 * This class is a wrapper for {@link Payment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Payment
 * @generated
 */
@ProviderType
public class PaymentWrapper implements Payment, ModelWrapper<Payment> {
	public PaymentWrapper(Payment payment) {
		_payment = payment;
	}

	@Override
	public Class<?> getModelClass() {
		return Payment.class;
	}

	@Override
	public String getModelClassName() {
		return Payment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("paymentId", getPaymentId());
		attributes.put("billingId", getBillingId());
		attributes.put("clientId", getClientId());
		attributes.put("amount", getAmount());
		attributes.put("chequeNo", getChequeNo());
		attributes.put("tds", getTds());
		attributes.put("deduction", getDeduction());
		attributes.put("description", getDescription());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long paymentId = (Long)attributes.get("paymentId");

		if (paymentId != null) {
			setPaymentId(paymentId);
		}

		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String chequeNo = (String)attributes.get("chequeNo");

		if (chequeNo != null) {
			setChequeNo(chequeNo);
		}

		Double tds = (Double)attributes.get("tds");

		if (tds != null) {
			setTds(tds);
		}

		Double deduction = (Double)attributes.get("deduction");

		if (deduction != null) {
			setDeduction(deduction);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	public Payment toEscapedModel() {
		return new PaymentWrapper(_payment.toEscapedModel());
	}

	@Override
	public Payment toUnescapedModel() {
		return new PaymentWrapper(_payment.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _payment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _payment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _payment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _payment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Payment> toCacheModel() {
		return _payment.toCacheModel();
	}

	/**
	* Returns the amount of this payment.
	*
	* @return the amount of this payment
	*/
	@Override
	public double getAmount() {
		return _payment.getAmount();
	}

	/**
	* Returns the deduction of this payment.
	*
	* @return the deduction of this payment
	*/
	@Override
	public double getDeduction() {
		return _payment.getDeduction();
	}

	/**
	* Returns the tds of this payment.
	*
	* @return the tds of this payment
	*/
	@Override
	public double getTds() {
		return _payment.getTds();
	}

	@Override
	public int compareTo(Payment payment) {
		return _payment.compareTo(payment);
	}

	@Override
	public int hashCode() {
		return _payment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PaymentWrapper((Payment)_payment.clone());
	}

	/**
	* Returns the cheque no of this payment.
	*
	* @return the cheque no of this payment
	*/
	@Override
	public java.lang.String getChequeNo() {
		return _payment.getChequeNo();
	}

	/**
	* Returns the description of this payment.
	*
	* @return the description of this payment
	*/
	@Override
	public java.lang.String getDescription() {
		return _payment.getDescription();
	}

	@Override
	public java.lang.String toString() {
		return _payment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _payment.toXmlString();
	}

	/**
	* Returns the create date of this payment.
	*
	* @return the create date of this payment
	*/
	@Override
	public Date getCreateDate() {
		return _payment.getCreateDate();
	}

	/**
	* Returns the modified date of this payment.
	*
	* @return the modified date of this payment
	*/
	@Override
	public Date getModifiedDate() {
		return _payment.getModifiedDate();
	}

	/**
	* Returns the payment date of this payment.
	*
	* @return the payment date of this payment
	*/
	@Override
	public Date getPaymentDate() {
		return _payment.getPaymentDate();
	}

	/**
	* Returns the billing ID of this payment.
	*
	* @return the billing ID of this payment
	*/
	@Override
	public long getBillingId() {
		return _payment.getBillingId();
	}

	/**
	* Returns the client ID of this payment.
	*
	* @return the client ID of this payment
	*/
	@Override
	public long getClientId() {
		return _payment.getClientId();
	}

	/**
	* Returns the created by of this payment.
	*
	* @return the created by of this payment
	*/
	@Override
	public long getCreatedBy() {
		return _payment.getCreatedBy();
	}

	/**
	* Returns the modified by of this payment.
	*
	* @return the modified by of this payment
	*/
	@Override
	public long getModifiedBy() {
		return _payment.getModifiedBy();
	}

	/**
	* Returns the payment ID of this payment.
	*
	* @return the payment ID of this payment
	*/
	@Override
	public long getPaymentId() {
		return _payment.getPaymentId();
	}

	/**
	* Returns the primary key of this payment.
	*
	* @return the primary key of this payment
	*/
	@Override
	public long getPrimaryKey() {
		return _payment.getPrimaryKey();
	}

	@Override
	public void persist() {
		_payment.persist();
	}

	/**
	* Sets the amount of this payment.
	*
	* @param amount the amount of this payment
	*/
	@Override
	public void setAmount(double amount) {
		_payment.setAmount(amount);
	}

	/**
	* Sets the billing ID of this payment.
	*
	* @param billingId the billing ID of this payment
	*/
	@Override
	public void setBillingId(long billingId) {
		_payment.setBillingId(billingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payment.setCachedModel(cachedModel);
	}

	/**
	* Sets the cheque no of this payment.
	*
	* @param chequeNo the cheque no of this payment
	*/
	@Override
	public void setChequeNo(java.lang.String chequeNo) {
		_payment.setChequeNo(chequeNo);
	}

	/**
	* Sets the client ID of this payment.
	*
	* @param clientId the client ID of this payment
	*/
	@Override
	public void setClientId(long clientId) {
		_payment.setClientId(clientId);
	}

	/**
	* Sets the create date of this payment.
	*
	* @param createDate the create date of this payment
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_payment.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this payment.
	*
	* @param createdBy the created by of this payment
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_payment.setCreatedBy(createdBy);
	}

	/**
	* Sets the deduction of this payment.
	*
	* @param deduction the deduction of this payment
	*/
	@Override
	public void setDeduction(double deduction) {
		_payment.setDeduction(deduction);
	}

	/**
	* Sets the description of this payment.
	*
	* @param description the description of this payment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_payment.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_payment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_payment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_payment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this payment.
	*
	* @param modifiedBy the modified by of this payment
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_payment.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this payment.
	*
	* @param modifiedDate the modified date of this payment
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_payment.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_payment.setNew(n);
	}

	/**
	* Sets the payment date of this payment.
	*
	* @param paymentDate the payment date of this payment
	*/
	@Override
	public void setPaymentDate(Date paymentDate) {
		_payment.setPaymentDate(paymentDate);
	}

	/**
	* Sets the payment ID of this payment.
	*
	* @param paymentId the payment ID of this payment
	*/
	@Override
	public void setPaymentId(long paymentId) {
		_payment.setPaymentId(paymentId);
	}

	/**
	* Sets the primary key of this payment.
	*
	* @param primaryKey the primary key of this payment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_payment.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tds of this payment.
	*
	* @param tds the tds of this payment
	*/
	@Override
	public void setTds(double tds) {
		_payment.setTds(tds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PaymentWrapper)) {
			return false;
		}

		PaymentWrapper paymentWrapper = (PaymentWrapper)obj;

		if (Objects.equals(_payment, paymentWrapper._payment)) {
			return true;
		}

		return false;
	}

	@Override
	public Payment getWrappedModel() {
		return _payment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _payment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _payment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_payment.resetOriginalValues();
	}

	private final Payment _payment;
}