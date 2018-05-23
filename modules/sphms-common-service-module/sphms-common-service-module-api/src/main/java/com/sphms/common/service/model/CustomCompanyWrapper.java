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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CustomCompany}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomCompany
 * @generated
 */
@ProviderType
public class CustomCompanyWrapper implements CustomCompany,
	ModelWrapper<CustomCompany> {
	public CustomCompanyWrapper(CustomCompany customCompany) {
		_customCompany = customCompany;
	}

	@Override
	public Class<?> getModelClass() {
		return CustomCompany.class;
	}

	@Override
	public String getModelClassName() {
		return CustomCompany.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("GSTNo", getGSTNo());
		attributes.put("PANNo", getPANNo());
		attributes.put("bankName", getBankName());
		attributes.put("accountDetail", getAccountDetail());
		attributes.put("poPrefix", getPoPrefix());
		attributes.put("shortName", getShortName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String GSTNo = (String)attributes.get("GSTNo");

		if (GSTNo != null) {
			setGSTNo(GSTNo);
		}

		String PANNo = (String)attributes.get("PANNo");

		if (PANNo != null) {
			setPANNo(PANNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String accountDetail = (String)attributes.get("accountDetail");

		if (accountDetail != null) {
			setAccountDetail(accountDetail);
		}

		String poPrefix = (String)attributes.get("poPrefix");

		if (poPrefix != null) {
			setPoPrefix(poPrefix);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}
	}

	@Override
	public CustomCompany toEscapedModel() {
		return new CustomCompanyWrapper(_customCompany.toEscapedModel());
	}

	@Override
	public CustomCompany toUnescapedModel() {
		return new CustomCompanyWrapper(_customCompany.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _customCompany.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _customCompany.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _customCompany.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _customCompany.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CustomCompany> toCacheModel() {
		return _customCompany.toCacheModel();
	}

	@Override
	public int compareTo(CustomCompany customCompany) {
		return _customCompany.compareTo(customCompany);
	}

	@Override
	public int hashCode() {
		return _customCompany.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customCompany.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CustomCompanyWrapper((CustomCompany)_customCompany.clone());
	}

	/**
	* Returns the account detail of this custom company.
	*
	* @return the account detail of this custom company
	*/
	@Override
	public java.lang.String getAccountDetail() {
		return _customCompany.getAccountDetail();
	}

	/**
	* Returns the bank name of this custom company.
	*
	* @return the bank name of this custom company
	*/
	@Override
	public java.lang.String getBankName() {
		return _customCompany.getBankName();
	}

	/**
	* Returns the g s t no of this custom company.
	*
	* @return the g s t no of this custom company
	*/
	@Override
	public java.lang.String getGSTNo() {
		return _customCompany.getGSTNo();
	}

	/**
	* Returns the name of this custom company.
	*
	* @return the name of this custom company
	*/
	@Override
	public java.lang.String getName() {
		return _customCompany.getName();
	}

	/**
	* Returns the p a n no of this custom company.
	*
	* @return the p a n no of this custom company
	*/
	@Override
	public java.lang.String getPANNo() {
		return _customCompany.getPANNo();
	}

	/**
	* Returns the po prefix of this custom company.
	*
	* @return the po prefix of this custom company
	*/
	@Override
	public java.lang.String getPoPrefix() {
		return _customCompany.getPoPrefix();
	}

	/**
	* Returns the short name of this custom company.
	*
	* @return the short name of this custom company
	*/
	@Override
	public java.lang.String getShortName() {
		return _customCompany.getShortName();
	}

	@Override
	public java.lang.String toString() {
		return _customCompany.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _customCompany.toXmlString();
	}

	/**
	* Returns the company ID of this custom company.
	*
	* @return the company ID of this custom company
	*/
	@Override
	public long getCompanyId() {
		return _customCompany.getCompanyId();
	}

	/**
	* Returns the primary key of this custom company.
	*
	* @return the primary key of this custom company
	*/
	@Override
	public long getPrimaryKey() {
		return _customCompany.getPrimaryKey();
	}

	@Override
	public void persist() {
		_customCompany.persist();
	}

	/**
	* Sets the account detail of this custom company.
	*
	* @param accountDetail the account detail of this custom company
	*/
	@Override
	public void setAccountDetail(java.lang.String accountDetail) {
		_customCompany.setAccountDetail(accountDetail);
	}

	/**
	* Sets the bank name of this custom company.
	*
	* @param bankName the bank name of this custom company
	*/
	@Override
	public void setBankName(java.lang.String bankName) {
		_customCompany.setBankName(bankName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_customCompany.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this custom company.
	*
	* @param companyId the company ID of this custom company
	*/
	@Override
	public void setCompanyId(long companyId) {
		_customCompany.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_customCompany.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_customCompany.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_customCompany.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the g s t no of this custom company.
	*
	* @param GSTNo the g s t no of this custom company
	*/
	@Override
	public void setGSTNo(java.lang.String GSTNo) {
		_customCompany.setGSTNo(GSTNo);
	}

	/**
	* Sets the name of this custom company.
	*
	* @param name the name of this custom company
	*/
	@Override
	public void setName(java.lang.String name) {
		_customCompany.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_customCompany.setNew(n);
	}

	/**
	* Sets the p a n no of this custom company.
	*
	* @param PANNo the p a n no of this custom company
	*/
	@Override
	public void setPANNo(java.lang.String PANNo) {
		_customCompany.setPANNo(PANNo);
	}

	/**
	* Sets the po prefix of this custom company.
	*
	* @param poPrefix the po prefix of this custom company
	*/
	@Override
	public void setPoPrefix(java.lang.String poPrefix) {
		_customCompany.setPoPrefix(poPrefix);
	}

	/**
	* Sets the primary key of this custom company.
	*
	* @param primaryKey the primary key of this custom company
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_customCompany.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_customCompany.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the short name of this custom company.
	*
	* @param shortName the short name of this custom company
	*/
	@Override
	public void setShortName(java.lang.String shortName) {
		_customCompany.setShortName(shortName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomCompanyWrapper)) {
			return false;
		}

		CustomCompanyWrapper customCompanyWrapper = (CustomCompanyWrapper)obj;

		if (Objects.equals(_customCompany, customCompanyWrapper._customCompany)) {
			return true;
		}

		return false;
	}

	@Override
	public CustomCompany getWrappedModel() {
		return _customCompany;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _customCompany.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _customCompany.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_customCompany.resetOriginalValues();
	}

	private final CustomCompany _customCompany;
}