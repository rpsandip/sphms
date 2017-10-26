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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CustomCompanySoap implements Serializable {
	public static CustomCompanySoap toSoapModel(CustomCompany model) {
		CustomCompanySoap soapModel = new CustomCompanySoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setName(model.getName());
		soapModel.setGSTNo(model.getGSTNo());
		soapModel.setPANNo(model.getPANNo());
		soapModel.setBankName(model.getBankName());
		soapModel.setAccountDetail(model.getAccountDetail());
		soapModel.setPoPrefix(model.getPoPrefix());

		return soapModel;
	}

	public static CustomCompanySoap[] toSoapModels(CustomCompany[] models) {
		CustomCompanySoap[] soapModels = new CustomCompanySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomCompanySoap[][] toSoapModels(CustomCompany[][] models) {
		CustomCompanySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomCompanySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomCompanySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomCompanySoap[] toSoapModels(List<CustomCompany> models) {
		List<CustomCompanySoap> soapModels = new ArrayList<CustomCompanySoap>(models.size());

		for (CustomCompany model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomCompanySoap[soapModels.size()]);
	}

	public CustomCompanySoap() {
	}

	public long getPrimaryKey() {
		return _companyId;
	}

	public void setPrimaryKey(long pk) {
		setCompanyId(pk);
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getGSTNo() {
		return _GSTNo;
	}

	public void setGSTNo(String GSTNo) {
		_GSTNo = GSTNo;
	}

	public String getPANNo() {
		return _PANNo;
	}

	public void setPANNo(String PANNo) {
		_PANNo = PANNo;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public String getAccountDetail() {
		return _accountDetail;
	}

	public void setAccountDetail(String accountDetail) {
		_accountDetail = accountDetail;
	}

	public String getPoPrefix() {
		return _poPrefix;
	}

	public void setPoPrefix(String poPrefix) {
		_poPrefix = poPrefix;
	}

	private long _companyId;
	private String _name;
	private String _GSTNo;
	private String _PANNo;
	private String _bankName;
	private String _accountDetail;
	private String _poPrefix;
}