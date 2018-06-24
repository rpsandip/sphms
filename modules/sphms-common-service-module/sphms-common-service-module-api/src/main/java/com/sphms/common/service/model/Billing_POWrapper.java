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
 * This class is a wrapper for {@link Billing_PO}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_PO
 * @generated
 */
@ProviderType
public class Billing_POWrapper implements Billing_PO, ModelWrapper<Billing_PO> {
	public Billing_POWrapper(Billing_PO billing_PO) {
		_billing_PO = billing_PO;
	}

	@Override
	public Class<?> getModelClass() {
		return Billing_PO.class;
	}

	@Override
	public String getModelClassName() {
		return Billing_PO.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("billingId", getBillingId());
		attributes.put("hordingId", getHordingId());
		attributes.put("landLordId", getLandLordId());
		attributes.put("poNumber", getPoNumber());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("totalAmount", getTotalAmount());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		Long hordingId = (Long)attributes.get("hordingId");

		if (hordingId != null) {
			setHordingId(hordingId);
		}

		Long landLordId = (Long)attributes.get("landLordId");

		if (landLordId != null) {
			setLandLordId(landLordId);
		}

		String poNumber = (String)attributes.get("poNumber");

		if (poNumber != null) {
			setPoNumber(poNumber);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Double totalAmount = (Double)attributes.get("totalAmount");

		if (totalAmount != null) {
			setTotalAmount(totalAmount);
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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Billing_PO toEscapedModel() {
		return new Billing_POWrapper(_billing_PO.toEscapedModel());
	}

	@Override
	public Billing_PO toUnescapedModel() {
		return new Billing_POWrapper(_billing_PO.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _billing_PO.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _billing_PO.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _billing_PO.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _billing_PO.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Billing_PO> toCacheModel() {
		return _billing_PO.toCacheModel();
	}

	/**
	* Returns the primary key of this billing_ p o.
	*
	* @return the primary key of this billing_ p o
	*/
	@Override
	public com.sphms.common.service.service.persistence.Billing_POPK getPrimaryKey() {
		return _billing_PO.getPrimaryKey();
	}

	/**
	* Returns the total amount of this billing_ p o.
	*
	* @return the total amount of this billing_ p o
	*/
	@Override
	public double getTotalAmount() {
		return _billing_PO.getTotalAmount();
	}

	@Override
	public int compareTo(Billing_PO billing_PO) {
		return _billing_PO.compareTo(billing_PO);
	}

	/**
	* Returns the status of this billing_ p o.
	*
	* @return the status of this billing_ p o
	*/
	@Override
	public int getStatus() {
		return _billing_PO.getStatus();
	}

	@Override
	public int hashCode() {
		return _billing_PO.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _billing_PO.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Billing_POWrapper((Billing_PO)_billing_PO.clone());
	}

	/**
	* Returns the financial year of this billing_ p o.
	*
	* @return the financial year of this billing_ p o
	*/
	@Override
	public java.lang.String getFinancialYear() {
		return _billing_PO.getFinancialYear();
	}

	/**
	* Returns the po number of this billing_ p o.
	*
	* @return the po number of this billing_ p o
	*/
	@Override
	public java.lang.String getPoNumber() {
		return _billing_PO.getPoNumber();
	}

	@Override
	public java.lang.String toString() {
		return _billing_PO.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _billing_PO.toXmlString();
	}

	/**
	* Returns the create date of this billing_ p o.
	*
	* @return the create date of this billing_ p o
	*/
	@Override
	public Date getCreateDate() {
		return _billing_PO.getCreateDate();
	}

	/**
	* Returns the modified date of this billing_ p o.
	*
	* @return the modified date of this billing_ p o
	*/
	@Override
	public Date getModifiedDate() {
		return _billing_PO.getModifiedDate();
	}

	/**
	* Returns the billing ID of this billing_ p o.
	*
	* @return the billing ID of this billing_ p o
	*/
	@Override
	public long getBillingId() {
		return _billing_PO.getBillingId();
	}

	/**
	* Returns the created by of this billing_ p o.
	*
	* @return the created by of this billing_ p o
	*/
	@Override
	public long getCreatedBy() {
		return _billing_PO.getCreatedBy();
	}

	/**
	* Returns the hording ID of this billing_ p o.
	*
	* @return the hording ID of this billing_ p o
	*/
	@Override
	public long getHordingId() {
		return _billing_PO.getHordingId();
	}

	/**
	* Returns the land lord ID of this billing_ p o.
	*
	* @return the land lord ID of this billing_ p o
	*/
	@Override
	public long getLandLordId() {
		return _billing_PO.getLandLordId();
	}

	/**
	* Returns the modified by of this billing_ p o.
	*
	* @return the modified by of this billing_ p o
	*/
	@Override
	public long getModifiedBy() {
		return _billing_PO.getModifiedBy();
	}

	@Override
	public void persist() {
		_billing_PO.persist();
	}

	/**
	* Sets the billing ID of this billing_ p o.
	*
	* @param billingId the billing ID of this billing_ p o
	*/
	@Override
	public void setBillingId(long billingId) {
		_billing_PO.setBillingId(billingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_billing_PO.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this billing_ p o.
	*
	* @param createDate the create date of this billing_ p o
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_billing_PO.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this billing_ p o.
	*
	* @param createdBy the created by of this billing_ p o
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_billing_PO.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_billing_PO.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_billing_PO.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_billing_PO.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the financial year of this billing_ p o.
	*
	* @param financialYear the financial year of this billing_ p o
	*/
	@Override
	public void setFinancialYear(java.lang.String financialYear) {
		_billing_PO.setFinancialYear(financialYear);
	}

	/**
	* Sets the hording ID of this billing_ p o.
	*
	* @param hordingId the hording ID of this billing_ p o
	*/
	@Override
	public void setHordingId(long hordingId) {
		_billing_PO.setHordingId(hordingId);
	}

	/**
	* Sets the land lord ID of this billing_ p o.
	*
	* @param landLordId the land lord ID of this billing_ p o
	*/
	@Override
	public void setLandLordId(long landLordId) {
		_billing_PO.setLandLordId(landLordId);
	}

	/**
	* Sets the modified by of this billing_ p o.
	*
	* @param modifiedBy the modified by of this billing_ p o
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_billing_PO.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this billing_ p o.
	*
	* @param modifiedDate the modified date of this billing_ p o
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_billing_PO.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_billing_PO.setNew(n);
	}

	/**
	* Sets the po number of this billing_ p o.
	*
	* @param poNumber the po number of this billing_ p o
	*/
	@Override
	public void setPoNumber(java.lang.String poNumber) {
		_billing_PO.setPoNumber(poNumber);
	}

	/**
	* Sets the primary key of this billing_ p o.
	*
	* @param primaryKey the primary key of this billing_ p o
	*/
	@Override
	public void setPrimaryKey(
		com.sphms.common.service.service.persistence.Billing_POPK primaryKey) {
		_billing_PO.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_billing_PO.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this billing_ p o.
	*
	* @param status the status of this billing_ p o
	*/
	@Override
	public void setStatus(int status) {
		_billing_PO.setStatus(status);
	}

	/**
	* Sets the total amount of this billing_ p o.
	*
	* @param totalAmount the total amount of this billing_ p o
	*/
	@Override
	public void setTotalAmount(double totalAmount) {
		_billing_PO.setTotalAmount(totalAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Billing_POWrapper)) {
			return false;
		}

		Billing_POWrapper billing_POWrapper = (Billing_POWrapper)obj;

		if (Objects.equals(_billing_PO, billing_POWrapper._billing_PO)) {
			return true;
		}

		return false;
	}

	@Override
	public Billing_PO getWrappedModel() {
		return _billing_PO;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _billing_PO.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _billing_PO.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_billing_PO.resetOriginalValues();
	}

	private final Billing_PO _billing_PO;
}