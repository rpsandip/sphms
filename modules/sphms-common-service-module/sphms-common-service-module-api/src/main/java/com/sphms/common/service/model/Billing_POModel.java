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

import com.sphms.common.service.service.persistence.Billing_POPK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Billing_PO service. Represents a row in the &quot;SPHMS_Billing_PO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sphms.common.service.model.impl.Billing_POModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sphms.common.service.model.impl.Billing_POImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_PO
 * @see com.sphms.common.service.model.impl.Billing_POImpl
 * @see com.sphms.common.service.model.impl.Billing_POModelImpl
 * @generated
 */
@ProviderType
public interface Billing_POModel extends BaseModel<Billing_PO> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a billing_ p o model instance should use the {@link Billing_PO} interface instead.
	 */

	/**
	 * Returns the primary key of this billing_ p o.
	 *
	 * @return the primary key of this billing_ p o
	 */
	public Billing_POPK getPrimaryKey();

	/**
	 * Sets the primary key of this billing_ p o.
	 *
	 * @param primaryKey the primary key of this billing_ p o
	 */
	public void setPrimaryKey(Billing_POPK primaryKey);

	/**
	 * Returns the billing ID of this billing_ p o.
	 *
	 * @return the billing ID of this billing_ p o
	 */
	public long getBillingId();

	/**
	 * Sets the billing ID of this billing_ p o.
	 *
	 * @param billingId the billing ID of this billing_ p o
	 */
	public void setBillingId(long billingId);

	/**
	 * Returns the hording ID of this billing_ p o.
	 *
	 * @return the hording ID of this billing_ p o
	 */
	public long getHordingId();

	/**
	 * Sets the hording ID of this billing_ p o.
	 *
	 * @param hordingId the hording ID of this billing_ p o
	 */
	public void setHordingId(long hordingId);

	/**
	 * Returns the land lord ID of this billing_ p o.
	 *
	 * @return the land lord ID of this billing_ p o
	 */
	public long getLandLordId();

	/**
	 * Sets the land lord ID of this billing_ p o.
	 *
	 * @param landLordId the land lord ID of this billing_ p o
	 */
	public void setLandLordId(long landLordId);

	/**
	 * Returns the supplier bill no of this billing_ p o.
	 *
	 * @return the supplier bill no of this billing_ p o
	 */
	@AutoEscape
	public String getSupplierBillNo();

	/**
	 * Sets the supplier bill no of this billing_ p o.
	 *
	 * @param supplierBillNo the supplier bill no of this billing_ p o
	 */
	public void setSupplierBillNo(String supplierBillNo);

	/**
	 * Returns the supplier bill date of this billing_ p o.
	 *
	 * @return the supplier bill date of this billing_ p o
	 */
	public Date getSupplierBillDate();

	/**
	 * Sets the supplier bill date of this billing_ p o.
	 *
	 * @param supplierBillDate the supplier bill date of this billing_ p o
	 */
	public void setSupplierBillDate(Date supplierBillDate);

	/**
	 * Returns the supplier total amount of this billing_ p o.
	 *
	 * @return the supplier total amount of this billing_ p o
	 */
	public double getSupplierTotalAmount();

	/**
	 * Sets the supplier total amount of this billing_ p o.
	 *
	 * @param supplierTotalAmount the supplier total amount of this billing_ p o
	 */
	public void setSupplierTotalAmount(double supplierTotalAmount);

	/**
	 * Returns the supplier gst ammount of this billing_ p o.
	 *
	 * @return the supplier gst ammount of this billing_ p o
	 */
	public double getSupplierGstAmmount();

	/**
	 * Sets the supplier gst ammount of this billing_ p o.
	 *
	 * @param supplierGstAmmount the supplier gst ammount of this billing_ p o
	 */
	public void setSupplierGstAmmount(double supplierGstAmmount);

	/**
	 * Returns the po number of this billing_ p o.
	 *
	 * @return the po number of this billing_ p o
	 */
	@AutoEscape
	public String getPoNumber();

	/**
	 * Sets the po number of this billing_ p o.
	 *
	 * @param poNumber the po number of this billing_ p o
	 */
	public void setPoNumber(String poNumber);

	/**
	 * Returns the internal p o number of this billing_ p o.
	 *
	 * @return the internal p o number of this billing_ p o
	 */
	@AutoEscape
	public String getInternalPONumber();

	/**
	 * Sets the internal p o number of this billing_ p o.
	 *
	 * @param internalPONumber the internal p o number of this billing_ p o
	 */
	public void setInternalPONumber(String internalPONumber);

	/**
	 * Returns the financial year of this billing_ p o.
	 *
	 * @return the financial year of this billing_ p o
	 */
	@AutoEscape
	public String getFinancialYear();

	/**
	 * Sets the financial year of this billing_ p o.
	 *
	 * @param financialYear the financial year of this billing_ p o
	 */
	public void setFinancialYear(String financialYear);

	/**
	 * Returns the total amount of this billing_ p o.
	 *
	 * @return the total amount of this billing_ p o
	 */
	public double getTotalAmount();

	/**
	 * Sets the total amount of this billing_ p o.
	 *
	 * @param totalAmount the total amount of this billing_ p o
	 */
	public void setTotalAmount(double totalAmount);

	/**
	 * Returns the custom company ID of this billing_ p o.
	 *
	 * @return the custom company ID of this billing_ p o
	 */
	public long getCustomCompanyId();

	/**
	 * Sets the custom company ID of this billing_ p o.
	 *
	 * @param customCompanyId the custom company ID of this billing_ p o
	 */
	public void setCustomCompanyId(long customCompanyId);

	/**
	 * Returns the payment given of this billing_ p o.
	 *
	 * @return the payment given of this billing_ p o
	 */
	@AutoEscape
	public String getPaymentGiven();

	/**
	 * Sets the payment given of this billing_ p o.
	 *
	 * @param paymentGiven the payment given of this billing_ p o
	 */
	public void setPaymentGiven(String paymentGiven);

	/**
	 * Returns the publish date of this billing_ p o.
	 *
	 * @return the publish date of this billing_ p o
	 */
	public Date getPublishDate();

	/**
	 * Sets the publish date of this billing_ p o.
	 *
	 * @param publishDate the publish date of this billing_ p o
	 */
	public void setPublishDate(Date publishDate);

	/**
	 * Returns the create date of this billing_ p o.
	 *
	 * @return the create date of this billing_ p o
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this billing_ p o.
	 *
	 * @param createDate the create date of this billing_ p o
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this billing_ p o.
	 *
	 * @return the created by of this billing_ p o
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this billing_ p o.
	 *
	 * @param createdBy the created by of this billing_ p o
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this billing_ p o.
	 *
	 * @return the modified date of this billing_ p o
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this billing_ p o.
	 *
	 * @param modifiedDate the modified date of this billing_ p o
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this billing_ p o.
	 *
	 * @return the modified by of this billing_ p o
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this billing_ p o.
	 *
	 * @param modifiedBy the modified by of this billing_ p o
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the status of this billing_ p o.
	 *
	 * @return the status of this billing_ p o
	 */
	public int getStatus();

	/**
	 * Sets the status of this billing_ p o.
	 *
	 * @param status the status of this billing_ p o
	 */
	public void setStatus(int status);

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
	public int compareTo(Billing_PO billing_PO);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Billing_PO> toCacheModel();

	@Override
	public Billing_PO toEscapedModel();

	@Override
	public Billing_PO toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}