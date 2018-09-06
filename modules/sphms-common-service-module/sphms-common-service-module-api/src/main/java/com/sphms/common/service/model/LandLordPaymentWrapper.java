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
 * This class is a wrapper for {@link LandLordPayment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPayment
 * @generated
 */
@ProviderType
public class LandLordPaymentWrapper implements LandLordPayment,
	ModelWrapper<LandLordPayment> {
	public LandLordPaymentWrapper(LandLordPayment landLordPayment) {
		_landLordPayment = landLordPayment;
	}

	@Override
	public Class<?> getModelClass() {
		return LandLordPayment.class;
	}

	@Override
	public String getModelClassName() {
		return LandLordPayment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("landLordPaymentId", getLandLordPaymentId());
		attributes.put("landLoadId", getLandLoadId());
		attributes.put("hordingId", getHordingId());
		attributes.put("amount", getAmount());
		attributes.put("chequeNo", getChequeNo());
		attributes.put("bankName", getBankName());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("description", getDescription());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long landLordPaymentId = (Long)attributes.get("landLordPaymentId");

		if (landLordPaymentId != null) {
			setLandLordPaymentId(landLordPaymentId);
		}

		Long landLoadId = (Long)attributes.get("landLoadId");

		if (landLoadId != null) {
			setLandLoadId(landLoadId);
		}

		Long hordingId = (Long)attributes.get("hordingId");

		if (hordingId != null) {
			setHordingId(hordingId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String chequeNo = (String)attributes.get("chequeNo");

		if (chequeNo != null) {
			setChequeNo(chequeNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	public LandLordPayment toEscapedModel() {
		return new LandLordPaymentWrapper(_landLordPayment.toEscapedModel());
	}

	@Override
	public LandLordPayment toUnescapedModel() {
		return new LandLordPaymentWrapper(_landLordPayment.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _landLordPayment.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _landLordPayment.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _landLordPayment.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _landLordPayment.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LandLordPayment> toCacheModel() {
		return _landLordPayment.toCacheModel();
	}

	/**
	* Returns the amount of this land lord payment.
	*
	* @return the amount of this land lord payment
	*/
	@Override
	public double getAmount() {
		return _landLordPayment.getAmount();
	}

	@Override
	public int compareTo(LandLordPayment landLordPayment) {
		return _landLordPayment.compareTo(landLordPayment);
	}

	@Override
	public int hashCode() {
		return _landLordPayment.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _landLordPayment.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LandLordPaymentWrapper((LandLordPayment)_landLordPayment.clone());
	}

	/**
	* Returns the bank name of this land lord payment.
	*
	* @return the bank name of this land lord payment
	*/
	@Override
	public java.lang.String getBankName() {
		return _landLordPayment.getBankName();
	}

	/**
	* Returns the cheque no of this land lord payment.
	*
	* @return the cheque no of this land lord payment
	*/
	@Override
	public java.lang.String getChequeNo() {
		return _landLordPayment.getChequeNo();
	}

	/**
	* Returns the description of this land lord payment.
	*
	* @return the description of this land lord payment
	*/
	@Override
	public java.lang.String getDescription() {
		return _landLordPayment.getDescription();
	}

	@Override
	public java.lang.String toString() {
		return _landLordPayment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _landLordPayment.toXmlString();
	}

	/**
	* Returns the create date of this land lord payment.
	*
	* @return the create date of this land lord payment
	*/
	@Override
	public Date getCreateDate() {
		return _landLordPayment.getCreateDate();
	}

	/**
	* Returns the payment date of this land lord payment.
	*
	* @return the payment date of this land lord payment
	*/
	@Override
	public Date getPaymentDate() {
		return _landLordPayment.getPaymentDate();
	}

	/**
	* Returns the created by of this land lord payment.
	*
	* @return the created by of this land lord payment
	*/
	@Override
	public long getCreatedBy() {
		return _landLordPayment.getCreatedBy();
	}

	/**
	* Returns the hording ID of this land lord payment.
	*
	* @return the hording ID of this land lord payment
	*/
	@Override
	public long getHordingId() {
		return _landLordPayment.getHordingId();
	}

	/**
	* Returns the land load ID of this land lord payment.
	*
	* @return the land load ID of this land lord payment
	*/
	@Override
	public long getLandLoadId() {
		return _landLordPayment.getLandLoadId();
	}

	/**
	* Returns the land lord payment ID of this land lord payment.
	*
	* @return the land lord payment ID of this land lord payment
	*/
	@Override
	public long getLandLordPaymentId() {
		return _landLordPayment.getLandLordPaymentId();
	}

	/**
	* Returns the primary key of this land lord payment.
	*
	* @return the primary key of this land lord payment
	*/
	@Override
	public long getPrimaryKey() {
		return _landLordPayment.getPrimaryKey();
	}

	@Override
	public void persist() {
		_landLordPayment.persist();
	}

	/**
	* Sets the amount of this land lord payment.
	*
	* @param amount the amount of this land lord payment
	*/
	@Override
	public void setAmount(double amount) {
		_landLordPayment.setAmount(amount);
	}

	/**
	* Sets the bank name of this land lord payment.
	*
	* @param bankName the bank name of this land lord payment
	*/
	@Override
	public void setBankName(java.lang.String bankName) {
		_landLordPayment.setBankName(bankName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_landLordPayment.setCachedModel(cachedModel);
	}

	/**
	* Sets the cheque no of this land lord payment.
	*
	* @param chequeNo the cheque no of this land lord payment
	*/
	@Override
	public void setChequeNo(java.lang.String chequeNo) {
		_landLordPayment.setChequeNo(chequeNo);
	}

	/**
	* Sets the create date of this land lord payment.
	*
	* @param createDate the create date of this land lord payment
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_landLordPayment.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this land lord payment.
	*
	* @param createdBy the created by of this land lord payment
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_landLordPayment.setCreatedBy(createdBy);
	}

	/**
	* Sets the description of this land lord payment.
	*
	* @param description the description of this land lord payment
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_landLordPayment.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_landLordPayment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_landLordPayment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_landLordPayment.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hording ID of this land lord payment.
	*
	* @param hordingId the hording ID of this land lord payment
	*/
	@Override
	public void setHordingId(long hordingId) {
		_landLordPayment.setHordingId(hordingId);
	}

	/**
	* Sets the land load ID of this land lord payment.
	*
	* @param landLoadId the land load ID of this land lord payment
	*/
	@Override
	public void setLandLoadId(long landLoadId) {
		_landLordPayment.setLandLoadId(landLoadId);
	}

	/**
	* Sets the land lord payment ID of this land lord payment.
	*
	* @param landLordPaymentId the land lord payment ID of this land lord payment
	*/
	@Override
	public void setLandLordPaymentId(long landLordPaymentId) {
		_landLordPayment.setLandLordPaymentId(landLordPaymentId);
	}

	@Override
	public void setNew(boolean n) {
		_landLordPayment.setNew(n);
	}

	/**
	* Sets the payment date of this land lord payment.
	*
	* @param paymentDate the payment date of this land lord payment
	*/
	@Override
	public void setPaymentDate(Date paymentDate) {
		_landLordPayment.setPaymentDate(paymentDate);
	}

	/**
	* Sets the primary key of this land lord payment.
	*
	* @param primaryKey the primary key of this land lord payment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_landLordPayment.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_landLordPayment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LandLordPaymentWrapper)) {
			return false;
		}

		LandLordPaymentWrapper landLordPaymentWrapper = (LandLordPaymentWrapper)obj;

		if (Objects.equals(_landLordPayment,
					landLordPaymentWrapper._landLordPayment)) {
			return true;
		}

		return false;
	}

	@Override
	public LandLordPayment getWrappedModel() {
		return _landLordPayment;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _landLordPayment.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _landLordPayment.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_landLordPayment.resetOriginalValues();
	}

	private final LandLordPayment _landLordPayment;
}