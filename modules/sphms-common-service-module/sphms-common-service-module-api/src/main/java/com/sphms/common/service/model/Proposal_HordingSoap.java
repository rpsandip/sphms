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

import com.sphms.common.service.service.persistence.Proposal_HordingPK;

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
public class Proposal_HordingSoap implements Serializable {
	public static Proposal_HordingSoap toSoapModel(Proposal_Hording model) {
		Proposal_HordingSoap soapModel = new Proposal_HordingSoap();

		soapModel.setProposalId(model.getProposalId());
		soapModel.setHordingId(model.getHordingId());
		soapModel.setMountingCharge(model.getMountingCharge());
		soapModel.setPrintingCharge(model.getPrintingCharge());
		soapModel.setUnits(model.getUnits());

		return soapModel;
	}

	public static Proposal_HordingSoap[] toSoapModels(Proposal_Hording[] models) {
		Proposal_HordingSoap[] soapModels = new Proposal_HordingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Proposal_HordingSoap[][] toSoapModels(
		Proposal_Hording[][] models) {
		Proposal_HordingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Proposal_HordingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Proposal_HordingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Proposal_HordingSoap[] toSoapModels(
		List<Proposal_Hording> models) {
		List<Proposal_HordingSoap> soapModels = new ArrayList<Proposal_HordingSoap>(models.size());

		for (Proposal_Hording model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Proposal_HordingSoap[soapModels.size()]);
	}

	public Proposal_HordingSoap() {
	}

	public Proposal_HordingPK getPrimaryKey() {
		return new Proposal_HordingPK(_proposalId, _hordingId);
	}

	public void setPrimaryKey(Proposal_HordingPK pk) {
		setProposalId(pk.proposalId);
		setHordingId(pk.hordingId);
	}

	public long getProposalId() {
		return _proposalId;
	}

	public void setProposalId(long proposalId) {
		_proposalId = proposalId;
	}

	public long getHordingId() {
		return _hordingId;
	}

	public void setHordingId(long hordingId) {
		_hordingId = hordingId;
	}

	public double getMountingCharge() {
		return _mountingCharge;
	}

	public void setMountingCharge(double mountingCharge) {
		_mountingCharge = mountingCharge;
	}

	public double getPrintingCharge() {
		return _printingCharge;
	}

	public void setPrintingCharge(double printingCharge) {
		_printingCharge = printingCharge;
	}

	public int getUnits() {
		return _units;
	}

	public void setUnits(int units) {
		_units = units;
	}

	private long _proposalId;
	private long _hordingId;
	private double _mountingCharge;
	private double _printingCharge;
	private int _units;
}