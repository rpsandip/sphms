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

package com.sphms.common.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.sphms.common.service.model.Proposal_Hording;
import com.sphms.common.service.service.persistence.Proposal_HordingPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Proposal_Hording in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Proposal_Hording
 * @generated
 */
@ProviderType
public class Proposal_HordingCacheModel implements CacheModel<Proposal_Hording>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Proposal_HordingCacheModel)) {
			return false;
		}

		Proposal_HordingCacheModel proposal_HordingCacheModel = (Proposal_HordingCacheModel)obj;

		if (proposal_HordingPK.equals(
					proposal_HordingCacheModel.proposal_HordingPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, proposal_HordingPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{proposalId=");
		sb.append(proposalId);
		sb.append(", hordingId=");
		sb.append(hordingId);
		sb.append(", mountingCharge=");
		sb.append(mountingCharge);
		sb.append(", printingCharge=");
		sb.append(printingCharge);
		sb.append(", units=");
		sb.append(units);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Proposal_Hording toEntityModel() {
		Proposal_HordingImpl proposal_HordingImpl = new Proposal_HordingImpl();

		proposal_HordingImpl.setProposalId(proposalId);
		proposal_HordingImpl.setHordingId(hordingId);
		proposal_HordingImpl.setMountingCharge(mountingCharge);
		proposal_HordingImpl.setPrintingCharge(printingCharge);
		proposal_HordingImpl.setUnits(units);

		proposal_HordingImpl.resetOriginalValues();

		return proposal_HordingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		proposalId = objectInput.readLong();

		hordingId = objectInput.readLong();

		mountingCharge = objectInput.readDouble();

		printingCharge = objectInput.readDouble();

		units = objectInput.readInt();

		proposal_HordingPK = new Proposal_HordingPK(proposalId, hordingId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(proposalId);

		objectOutput.writeLong(hordingId);

		objectOutput.writeDouble(mountingCharge);

		objectOutput.writeDouble(printingCharge);

		objectOutput.writeInt(units);
	}

	public long proposalId;
	public long hordingId;
	public double mountingCharge;
	public double printingCharge;
	public int units;
	public transient Proposal_HordingPK proposal_HordingPK;
}