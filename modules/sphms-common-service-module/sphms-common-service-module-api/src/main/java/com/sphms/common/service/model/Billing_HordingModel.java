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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import com.sphms.common.service.service.persistence.Billing_HordingPK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Billing_Hording service. Represents a row in the &quot;SPHMS_Billing_Hording&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sphms.common.service.model.impl.Billing_HordingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sphms.common.service.model.impl.Billing_HordingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_Hording
 * @see com.sphms.common.service.model.impl.Billing_HordingImpl
 * @see com.sphms.common.service.model.impl.Billing_HordingModelImpl
 * @generated
 */
@ProviderType
public interface Billing_HordingModel extends BaseModel<Billing_Hording> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a billing_ hording model instance should use the {@link Billing_Hording} interface instead.
	 */

	/**
	 * Returns the primary key of this billing_ hording.
	 *
	 * @return the primary key of this billing_ hording
	 */
	public Billing_HordingPK getPrimaryKey();

	/**
	 * Sets the primary key of this billing_ hording.
	 *
	 * @param primaryKey the primary key of this billing_ hording
	 */
	public void setPrimaryKey(Billing_HordingPK primaryKey);

	/**
	 * Returns the billing ID of this billing_ hording.
	 *
	 * @return the billing ID of this billing_ hording
	 */
	public long getBillingId();

	/**
	 * Sets the billing ID of this billing_ hording.
	 *
	 * @param billingId the billing ID of this billing_ hording
	 */
	public void setBillingId(long billingId);

	/**
	 * Returns the hording ID of this billing_ hording.
	 *
	 * @return the hording ID of this billing_ hording
	 */
	public long getHordingId();

	/**
	 * Sets the hording ID of this billing_ hording.
	 *
	 * @param hordingId the hording ID of this billing_ hording
	 */
	public void setHordingId(long hordingId);

	/**
	 * Returns the total mounting charge of this billing_ hording.
	 *
	 * @return the total mounting charge of this billing_ hording
	 */
	public double getTotalMountingCharge();

	/**
	 * Sets the total mounting charge of this billing_ hording.
	 *
	 * @param totalMountingCharge the total mounting charge of this billing_ hording
	 */
	public void setTotalMountingCharge(double totalMountingCharge);

	/**
	 * Returns the total printing charge of this billing_ hording.
	 *
	 * @return the total printing charge of this billing_ hording
	 */
	public double getTotalPrintingCharge();

	/**
	 * Sets the total printing charge of this billing_ hording.
	 *
	 * @param totalPrintingCharge the total printing charge of this billing_ hording
	 */
	public void setTotalPrintingCharge(double totalPrintingCharge);

	/**
	 * Returns the units of this billing_ hording.
	 *
	 * @return the units of this billing_ hording
	 */
	public int getUnits();

	/**
	 * Sets the units of this billing_ hording.
	 *
	 * @param units the units of this billing_ hording
	 */
	public void setUnits(int units);

	/**
	 * Returns the total hording charge of this billing_ hording.
	 *
	 * @return the total hording charge of this billing_ hording
	 */
	public double getTotalHordingCharge();

	/**
	 * Sets the total hording charge of this billing_ hording.
	 *
	 * @param totalHordingCharge the total hording charge of this billing_ hording
	 */
	public void setTotalHordingCharge(double totalHordingCharge);

	/**
	 * Returns the hsn no of this billing_ hording.
	 *
	 * @return the hsn no of this billing_ hording
	 */
	@AutoEscape
	public String getHsnNo();

	/**
	 * Sets the hsn no of this billing_ hording.
	 *
	 * @param hsnNo the hsn no of this billing_ hording
	 */
	public void setHsnNo(String hsnNo);

	/**
	 * Returns the hording booking start date of this billing_ hording.
	 *
	 * @return the hording booking start date of this billing_ hording
	 */
	public Date getHordingBookingStartDate();

	/**
	 * Sets the hording booking start date of this billing_ hording.
	 *
	 * @param hordingBookingStartDate the hording booking start date of this billing_ hording
	 */
	public void setHordingBookingStartDate(Date hordingBookingStartDate);

	/**
	 * Returns the hording booking end date of this billing_ hording.
	 *
	 * @return the hording booking end date of this billing_ hording
	 */
	public Date getHordingBookingEndDate();

	/**
	 * Sets the hording booking end date of this billing_ hording.
	 *
	 * @param hordingBookingEndDate the hording booking end date of this billing_ hording
	 */
	public void setHordingBookingEndDate(Date hordingBookingEndDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Billing_Hording billing_Hording);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Billing_Hording> toCacheModel();

	@Override
	public Billing_Hording toEscapedModel();

	@Override
	public Billing_Hording toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}