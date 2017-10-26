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
public class ProposalSoap implements Serializable {
	public static ProposalSoap toSoapModel(Proposal model) {
		ProposalSoap soapModel = new ProposalSoap();

		soapModel.setProposalId(model.getProposalId());
		soapModel.setCampaignTitle(model.getCampaignTitle());
		soapModel.setClient(model.getClient());
		soapModel.setPptFileId(model.getPptFileId());
		soapModel.setXlsxFileId(model.getXlsxFileId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static ProposalSoap[] toSoapModels(Proposal[] models) {
		ProposalSoap[] soapModels = new ProposalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProposalSoap[][] toSoapModels(Proposal[][] models) {
		ProposalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProposalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProposalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProposalSoap[] toSoapModels(List<Proposal> models) {
		List<ProposalSoap> soapModels = new ArrayList<ProposalSoap>(models.size());

		for (Proposal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProposalSoap[soapModels.size()]);
	}

	public ProposalSoap() {
	}

	public long getPrimaryKey() {
		return _proposalId;
	}

	public void setPrimaryKey(long pk) {
		setProposalId(pk);
	}

	public long getProposalId() {
		return _proposalId;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
	}

	public String getCampaignTitle() {
		return _campaignTitle;
	}

	public void setCampaignTitle(String campaignTitle) {
		_campaignTitle = campaignTitle;
	}

	public long getClient() {
		return _client;
	}

	public void setClient(long client) {
		_client = client;
	}

	public long getPptFileId() {
		return _pptFileId;
	}

	public void setPptFileId(long pptFileId) {
		_pptFileId = pptFileId;
	}

	public long getXlsxFileId() {
		return _xlsxFileId;
	}

	public void setXlsxFileId(long xlsxFileId) {
		_xlsxFileId = xlsxFileId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
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

	private long _proposalId;
	private String _campaignTitle;
	private long _client;
	private long _pptFileId;
	private long _xlsxFileId;
	private Date _startDate;
	private Date _endDate;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}