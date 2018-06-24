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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ExpenseSoap implements Serializable {
	public static ExpenseSoap toSoapModel(Expense model) {
		ExpenseSoap soapModel = new ExpenseSoap();

		soapModel.setExpenseId(model.getExpenseId());
		soapModel.setCustomCompanyId(model.getCustomCompanyId());
		soapModel.setType(model.getType());
		soapModel.setAmount(model.getAmount());
		soapModel.setDescription(model.getDescription());
		soapModel.setExpenseDate(model.getExpenseDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static ExpenseSoap[] toSoapModels(Expense[] models) {
		ExpenseSoap[] soapModels = new ExpenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpenseSoap[][] toSoapModels(Expense[][] models) {
		ExpenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpenseSoap[] toSoapModels(List<Expense> models) {
		List<ExpenseSoap> soapModels = new ArrayList<ExpenseSoap>(models.size());

		for (Expense model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpenseSoap[soapModels.size()]);
	}

	public ExpenseSoap() {
	}

	public long getPrimaryKey() {
		return _expenseId;
	}

	public void setPrimaryKey(long pk) {
		setExpenseId(pk);
	}

	public long getExpenseId() {
		return _expenseId;
	}

	public void setExpenseId(long expenseId) {
		_expenseId = expenseId;
	}

	public long getCustomCompanyId() {
		return _customCompanyId;
	}

	public void setCustomCompanyId(long customCompanyId) {
		_customCompanyId = customCompanyId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getExpenseDate() {
		return _expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		_expenseDate = expenseDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	private long _expenseId;
	private long _customCompanyId;
	private String _type;
	private double _amount;
	private String _description;
	private Date _expenseDate;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}