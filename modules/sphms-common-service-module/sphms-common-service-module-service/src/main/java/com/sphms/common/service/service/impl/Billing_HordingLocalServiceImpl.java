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

package com.sphms.common.service.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.service.Billing_HordingLocalServiceUtil;
import com.sphms.common.service.service.base.Billing_HordingLocalServiceBaseImpl;
import com.sphms.common.service.service.persistence.Billing_HordingPK;

/**
 * The implementation of the billing_ hording local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.Billing_HordingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_HordingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.Billing_HordingLocalServiceUtil
 */
@ProviderType
public class Billing_HordingLocalServiceImpl
	extends Billing_HordingLocalServiceBaseImpl {
	
	/*
	 * Method for add Billing and Hording Detail
	 */
	
	public Billing_Hording addBillingHording(long billingId, long hordingId, double totalMountingCharge, double totalPrintingCharge, int units, double totalHordingCharge, String hsnNo, Date hordingBookingStartDate, Date hordingBookingEndDate){
		Billing_HordingPK billingHordingPK = new Billing_HordingPK(billingId, hordingId);
		Billing_Hording billingHording = Billing_HordingLocalServiceUtil.createBilling_Hording(billingHordingPK);
		billingHording.setTotalHordingCharge(totalHordingCharge);
		billingHording.setTotalMountingCharge(totalMountingCharge);
		billingHording.setTotalPrintingCharge(totalPrintingCharge);
		billingHording.setUnits(units);
		billingHording.setHsnNo(hsnNo);
		billingHording.setHordingBookingStartDate(hordingBookingStartDate);
		billingHording.setHordingBookingEndDate(hordingBookingEndDate);
		billingHording = Billing_HordingLocalServiceUtil.addBilling_Hording(billingHording);
		return billingHording;
	}
	
	public List<Billing_Hording> getBillingHordingList(long billingId){
		return billing_HordingPersistence.findBybillingId(billingId);
	}
	
	public Billing_Hording getBillingHording(long hordingId, long billingId){
		Billing_Hording billingHording = null;
		Billing_HordingPK billing_HordingPK = new Billing_HordingPK(billingId, hordingId);
		try {
			billingHording = Billing_HordingLocalServiceUtil.getBilling_Hording(billing_HordingPK);
		} catch (PortalException e) {
			e.getMessage();
		}
		return billingHording;
	}
}