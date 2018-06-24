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
 * This class is a wrapper for {@link Billing}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing
 * @generated
 */
@ProviderType
public class BillingWrapper implements Billing, ModelWrapper<Billing> {
	public BillingWrapper(Billing billing) {
		_billing = billing;
	}

	@Override
	public Class<?> getModelClass() {
		return Billing.class;
	}

	@Override
	public String getModelClassName() {
		return Billing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("billingId", getBillingId());
		attributes.put("customCompanyId", getCustomCompanyId());
		attributes.put("billNo", getBillNo());
		attributes.put("internalBillNo", getInternalBillNo());
		attributes.put("bookingId", getBookingId());
		attributes.put("clientId", getClientId());
		attributes.put("billFileEntryId", getBillFileEntryId());
		attributes.put("clientPANNo", getClientPANNo());
		attributes.put("clientPONumber", getClientPONumber());
		attributes.put("clientGSTNumber", getClientGSTNumber());
		attributes.put("display", getDisplay());
		attributes.put("accessAmount", getAccessAmount());
		attributes.put("pendingAmount", getPendingAmount());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("status", getStatus());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		Long customCompanyId = (Long)attributes.get("customCompanyId");

		if (customCompanyId != null) {
			setCustomCompanyId(customCompanyId);
		}

		String billNo = (String)attributes.get("billNo");

		if (billNo != null) {
			setBillNo(billNo);
		}

		String internalBillNo = (String)attributes.get("internalBillNo");

		if (internalBillNo != null) {
			setInternalBillNo(internalBillNo);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Long billFileEntryId = (Long)attributes.get("billFileEntryId");

		if (billFileEntryId != null) {
			setBillFileEntryId(billFileEntryId);
		}

		String clientPANNo = (String)attributes.get("clientPANNo");

		if (clientPANNo != null) {
			setClientPANNo(clientPANNo);
		}

		String clientPONumber = (String)attributes.get("clientPONumber");

		if (clientPONumber != null) {
			setClientPONumber(clientPONumber);
		}

		String clientGSTNumber = (String)attributes.get("clientGSTNumber");

		if (clientGSTNumber != null) {
			setClientGSTNumber(clientGSTNumber);
		}

		String display = (String)attributes.get("display");

		if (display != null) {
			setDisplay(display);
		}

		Double accessAmount = (Double)attributes.get("accessAmount");

		if (accessAmount != null) {
			setAccessAmount(accessAmount);
		}

		Double pendingAmount = (Double)attributes.get("pendingAmount");

		if (pendingAmount != null) {
			setPendingAmount(pendingAmount);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public Billing toEscapedModel() {
		return new BillingWrapper(_billing.toEscapedModel());
	}

	@Override
	public Billing toUnescapedModel() {
		return new BillingWrapper(_billing.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _billing.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _billing.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _billing.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _billing.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Billing> toCacheModel() {
		return _billing.toCacheModel();
	}

	/**
	* Returns the access amount of this billing.
	*
	* @return the access amount of this billing
	*/
	@Override
	public double getAccessAmount() {
		return _billing.getAccessAmount();
	}

	/**
	* Returns the pending amount of this billing.
	*
	* @return the pending amount of this billing
	*/
	@Override
	public double getPendingAmount() {
		return _billing.getPendingAmount();
	}

	@Override
	public int compareTo(Billing billing) {
		return _billing.compareTo(billing);
	}

	/**
	* Returns the status of this billing.
	*
	* @return the status of this billing
	*/
	@Override
	public int getStatus() {
		return _billing.getStatus();
	}

	@Override
	public int hashCode() {
		return _billing.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _billing.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BillingWrapper((Billing)_billing.clone());
	}

	/**
	* Returns the bill no of this billing.
	*
	* @return the bill no of this billing
	*/
	@Override
	public java.lang.String getBillNo() {
		return _billing.getBillNo();
	}

	/**
	* Returns the client g s t number of this billing.
	*
	* @return the client g s t number of this billing
	*/
	@Override
	public java.lang.String getClientGSTNumber() {
		return _billing.getClientGSTNumber();
	}

	/**
	* Returns the client p a n no of this billing.
	*
	* @return the client p a n no of this billing
	*/
	@Override
	public java.lang.String getClientPANNo() {
		return _billing.getClientPANNo();
	}

	/**
	* Returns the client p o number of this billing.
	*
	* @return the client p o number of this billing
	*/
	@Override
	public java.lang.String getClientPONumber() {
		return _billing.getClientPONumber();
	}

	/**
	* Returns the display of this billing.
	*
	* @return the display of this billing
	*/
	@Override
	public java.lang.String getDisplay() {
		return _billing.getDisplay();
	}

	/**
	* Returns the financial year of this billing.
	*
	* @return the financial year of this billing
	*/
	@Override
	public java.lang.String getFinancialYear() {
		return _billing.getFinancialYear();
	}

	/**
	* Returns the internal bill no of this billing.
	*
	* @return the internal bill no of this billing
	*/
	@Override
	public java.lang.String getInternalBillNo() {
		return _billing.getInternalBillNo();
	}

	@Override
	public java.lang.String toString() {
		return _billing.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _billing.toXmlString();
	}

	/**
	* Returns the create date of this billing.
	*
	* @return the create date of this billing
	*/
	@Override
	public Date getCreateDate() {
		return _billing.getCreateDate();
	}

	/**
	* Returns the modified date of this billing.
	*
	* @return the modified date of this billing
	*/
	@Override
	public Date getModifiedDate() {
		return _billing.getModifiedDate();
	}

	/**
	* Returns the bill file entry ID of this billing.
	*
	* @return the bill file entry ID of this billing
	*/
	@Override
	public long getBillFileEntryId() {
		return _billing.getBillFileEntryId();
	}

	/**
	* Returns the billing ID of this billing.
	*
	* @return the billing ID of this billing
	*/
	@Override
	public long getBillingId() {
		return _billing.getBillingId();
	}

	/**
	* Returns the booking ID of this billing.
	*
	* @return the booking ID of this billing
	*/
	@Override
	public long getBookingId() {
		return _billing.getBookingId();
	}

	/**
	* Returns the client ID of this billing.
	*
	* @return the client ID of this billing
	*/
	@Override
	public long getClientId() {
		return _billing.getClientId();
	}

	/**
	* Returns the created by of this billing.
	*
	* @return the created by of this billing
	*/
	@Override
	public long getCreatedBy() {
		return _billing.getCreatedBy();
	}

	/**
	* Returns the custom company ID of this billing.
	*
	* @return the custom company ID of this billing
	*/
	@Override
	public long getCustomCompanyId() {
		return _billing.getCustomCompanyId();
	}

	/**
	* Returns the modified by of this billing.
	*
	* @return the modified by of this billing
	*/
	@Override
	public long getModifiedBy() {
		return _billing.getModifiedBy();
	}

	/**
	* Returns the primary key of this billing.
	*
	* @return the primary key of this billing
	*/
	@Override
	public long getPrimaryKey() {
		return _billing.getPrimaryKey();
	}

	@Override
	public void persist() {
		_billing.persist();
	}

	/**
	* Sets the access amount of this billing.
	*
	* @param accessAmount the access amount of this billing
	*/
	@Override
	public void setAccessAmount(double accessAmount) {
		_billing.setAccessAmount(accessAmount);
	}

	/**
	* Sets the bill file entry ID of this billing.
	*
	* @param billFileEntryId the bill file entry ID of this billing
	*/
	@Override
	public void setBillFileEntryId(long billFileEntryId) {
		_billing.setBillFileEntryId(billFileEntryId);
	}

	/**
	* Sets the bill no of this billing.
	*
	* @param billNo the bill no of this billing
	*/
	@Override
	public void setBillNo(java.lang.String billNo) {
		_billing.setBillNo(billNo);
	}

	/**
	* Sets the billing ID of this billing.
	*
	* @param billingId the billing ID of this billing
	*/
	@Override
	public void setBillingId(long billingId) {
		_billing.setBillingId(billingId);
	}

	/**
	* Sets the booking ID of this billing.
	*
	* @param bookingId the booking ID of this billing
	*/
	@Override
	public void setBookingId(long bookingId) {
		_billing.setBookingId(bookingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_billing.setCachedModel(cachedModel);
	}

	/**
	* Sets the client g s t number of this billing.
	*
	* @param clientGSTNumber the client g s t number of this billing
	*/
	@Override
	public void setClientGSTNumber(java.lang.String clientGSTNumber) {
		_billing.setClientGSTNumber(clientGSTNumber);
	}

	/**
	* Sets the client ID of this billing.
	*
	* @param clientId the client ID of this billing
	*/
	@Override
	public void setClientId(long clientId) {
		_billing.setClientId(clientId);
	}

	/**
	* Sets the client p a n no of this billing.
	*
	* @param clientPANNo the client p a n no of this billing
	*/
	@Override
	public void setClientPANNo(java.lang.String clientPANNo) {
		_billing.setClientPANNo(clientPANNo);
	}

	/**
	* Sets the client p o number of this billing.
	*
	* @param clientPONumber the client p o number of this billing
	*/
	@Override
	public void setClientPONumber(java.lang.String clientPONumber) {
		_billing.setClientPONumber(clientPONumber);
	}

	/**
	* Sets the create date of this billing.
	*
	* @param createDate the create date of this billing
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_billing.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this billing.
	*
	* @param createdBy the created by of this billing
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_billing.setCreatedBy(createdBy);
	}

	/**
	* Sets the custom company ID of this billing.
	*
	* @param customCompanyId the custom company ID of this billing
	*/
	@Override
	public void setCustomCompanyId(long customCompanyId) {
		_billing.setCustomCompanyId(customCompanyId);
	}

	/**
	* Sets the display of this billing.
	*
	* @param display the display of this billing
	*/
	@Override
	public void setDisplay(java.lang.String display) {
		_billing.setDisplay(display);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_billing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_billing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_billing.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the financial year of this billing.
	*
	* @param financialYear the financial year of this billing
	*/
	@Override
	public void setFinancialYear(java.lang.String financialYear) {
		_billing.setFinancialYear(financialYear);
	}

	/**
	* Sets the internal bill no of this billing.
	*
	* @param internalBillNo the internal bill no of this billing
	*/
	@Override
	public void setInternalBillNo(java.lang.String internalBillNo) {
		_billing.setInternalBillNo(internalBillNo);
	}

	/**
	* Sets the modified by of this billing.
	*
	* @param modifiedBy the modified by of this billing
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_billing.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this billing.
	*
	* @param modifiedDate the modified date of this billing
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_billing.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_billing.setNew(n);
	}

	/**
	* Sets the pending amount of this billing.
	*
	* @param pendingAmount the pending amount of this billing
	*/
	@Override
	public void setPendingAmount(double pendingAmount) {
		_billing.setPendingAmount(pendingAmount);
	}

	/**
	* Sets the primary key of this billing.
	*
	* @param primaryKey the primary key of this billing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_billing.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_billing.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this billing.
	*
	* @param status the status of this billing
	*/
	@Override
	public void setStatus(int status) {
		_billing.setStatus(status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BillingWrapper)) {
			return false;
		}

		BillingWrapper billingWrapper = (BillingWrapper)obj;

		if (Objects.equals(_billing, billingWrapper._billing)) {
			return true;
		}

		return false;
	}

	@Override
	public Billing getWrappedModel() {
		return _billing;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _billing.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _billing.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_billing.resetOriginalValues();
	}

	private final Billing _billing;
}