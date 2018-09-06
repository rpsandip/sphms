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
 * This class is a wrapper for {@link Expense}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Expense
 * @generated
 */
@ProviderType
public class ExpenseWrapper implements Expense, ModelWrapper<Expense> {
	public ExpenseWrapper(Expense expense) {
		_expense = expense;
	}

	@Override
	public Class<?> getModelClass() {
		return Expense.class;
	}

	@Override
	public String getModelClassName() {
		return Expense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expenseId", getExpenseId());
		attributes.put("customCompanyId", getCustomCompanyId());
		attributes.put("type", getType());
		attributes.put("amount", getAmount());
		attributes.put("description", getDescription());
		attributes.put("expenseDate", getExpenseDate());
		attributes.put("chequeNo", getChequeNo());
		attributes.put("bankName", getBankName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expenseId = (Long)attributes.get("expenseId");

		if (expenseId != null) {
			setExpenseId(expenseId);
		}

		Long customCompanyId = (Long)attributes.get("customCompanyId");

		if (customCompanyId != null) {
			setCustomCompanyId(customCompanyId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date expenseDate = (Date)attributes.get("expenseDate");

		if (expenseDate != null) {
			setExpenseDate(expenseDate);
		}

		String chequeNo = (String)attributes.get("chequeNo");

		if (chequeNo != null) {
			setChequeNo(chequeNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
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
	public Expense toEscapedModel() {
		return new ExpenseWrapper(_expense.toEscapedModel());
	}

	@Override
	public Expense toUnescapedModel() {
		return new ExpenseWrapper(_expense.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _expense.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _expense.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _expense.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _expense.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Expense> toCacheModel() {
		return _expense.toCacheModel();
	}

	/**
	* Returns the amount of this expense.
	*
	* @return the amount of this expense
	*/
	@Override
	public double getAmount() {
		return _expense.getAmount();
	}

	@Override
	public int compareTo(Expense expense) {
		return _expense.compareTo(expense);
	}

	@Override
	public int hashCode() {
		return _expense.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expense.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ExpenseWrapper((Expense)_expense.clone());
	}

	/**
	* Returns the bank name of this expense.
	*
	* @return the bank name of this expense
	*/
	@Override
	public java.lang.String getBankName() {
		return _expense.getBankName();
	}

	/**
	* Returns the cheque no of this expense.
	*
	* @return the cheque no of this expense
	*/
	@Override
	public java.lang.String getChequeNo() {
		return _expense.getChequeNo();
	}

	/**
	* Returns the description of this expense.
	*
	* @return the description of this expense
	*/
	@Override
	public java.lang.String getDescription() {
		return _expense.getDescription();
	}

	/**
	* Returns the type of this expense.
	*
	* @return the type of this expense
	*/
	@Override
	public java.lang.String getType() {
		return _expense.getType();
	}

	@Override
	public java.lang.String toString() {
		return _expense.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _expense.toXmlString();
	}

	/**
	* Returns the create date of this expense.
	*
	* @return the create date of this expense
	*/
	@Override
	public Date getCreateDate() {
		return _expense.getCreateDate();
	}

	/**
	* Returns the expense date of this expense.
	*
	* @return the expense date of this expense
	*/
	@Override
	public Date getExpenseDate() {
		return _expense.getExpenseDate();
	}

	/**
	* Returns the modified date of this expense.
	*
	* @return the modified date of this expense
	*/
	@Override
	public Date getModifiedDate() {
		return _expense.getModifiedDate();
	}

	/**
	* Returns the created by of this expense.
	*
	* @return the created by of this expense
	*/
	@Override
	public long getCreatedBy() {
		return _expense.getCreatedBy();
	}

	/**
	* Returns the custom company ID of this expense.
	*
	* @return the custom company ID of this expense
	*/
	@Override
	public long getCustomCompanyId() {
		return _expense.getCustomCompanyId();
	}

	/**
	* Returns the expense ID of this expense.
	*
	* @return the expense ID of this expense
	*/
	@Override
	public long getExpenseId() {
		return _expense.getExpenseId();
	}

	/**
	* Returns the modified by of this expense.
	*
	* @return the modified by of this expense
	*/
	@Override
	public long getModifiedBy() {
		return _expense.getModifiedBy();
	}

	/**
	* Returns the primary key of this expense.
	*
	* @return the primary key of this expense
	*/
	@Override
	public long getPrimaryKey() {
		return _expense.getPrimaryKey();
	}

	@Override
	public void persist() {
		_expense.persist();
	}

	/**
	* Sets the amount of this expense.
	*
	* @param amount the amount of this expense
	*/
	@Override
	public void setAmount(double amount) {
		_expense.setAmount(amount);
	}

	/**
	* Sets the bank name of this expense.
	*
	* @param bankName the bank name of this expense
	*/
	@Override
	public void setBankName(java.lang.String bankName) {
		_expense.setBankName(bankName);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expense.setCachedModel(cachedModel);
	}

	/**
	* Sets the cheque no of this expense.
	*
	* @param chequeNo the cheque no of this expense
	*/
	@Override
	public void setChequeNo(java.lang.String chequeNo) {
		_expense.setChequeNo(chequeNo);
	}

	/**
	* Sets the create date of this expense.
	*
	* @param createDate the create date of this expense
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_expense.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this expense.
	*
	* @param createdBy the created by of this expense
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_expense.setCreatedBy(createdBy);
	}

	/**
	* Sets the custom company ID of this expense.
	*
	* @param customCompanyId the custom company ID of this expense
	*/
	@Override
	public void setCustomCompanyId(long customCompanyId) {
		_expense.setCustomCompanyId(customCompanyId);
	}

	/**
	* Sets the description of this expense.
	*
	* @param description the description of this expense
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_expense.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_expense.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_expense.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_expense.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the expense date of this expense.
	*
	* @param expenseDate the expense date of this expense
	*/
	@Override
	public void setExpenseDate(Date expenseDate) {
		_expense.setExpenseDate(expenseDate);
	}

	/**
	* Sets the expense ID of this expense.
	*
	* @param expenseId the expense ID of this expense
	*/
	@Override
	public void setExpenseId(long expenseId) {
		_expense.setExpenseId(expenseId);
	}

	/**
	* Sets the modified by of this expense.
	*
	* @param modifiedBy the modified by of this expense
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_expense.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this expense.
	*
	* @param modifiedDate the modified date of this expense
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_expense.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_expense.setNew(n);
	}

	/**
	* Sets the primary key of this expense.
	*
	* @param primaryKey the primary key of this expense
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expense.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_expense.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type of this expense.
	*
	* @param type the type of this expense
	*/
	@Override
	public void setType(java.lang.String type) {
		_expense.setType(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpenseWrapper)) {
			return false;
		}

		ExpenseWrapper expenseWrapper = (ExpenseWrapper)obj;

		if (Objects.equals(_expense, expenseWrapper._expense)) {
			return true;
		}

		return false;
	}

	@Override
	public Expense getWrappedModel() {
		return _expense;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _expense.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _expense.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_expense.resetOriginalValues();
	}

	private final Expense _expense;
}