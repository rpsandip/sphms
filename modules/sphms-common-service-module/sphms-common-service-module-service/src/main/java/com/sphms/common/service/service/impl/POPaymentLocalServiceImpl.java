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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.sphms.common.service.model.POPayment;
import com.sphms.common.service.service.POPaymentLocalServiceUtil;
import com.sphms.common.service.service.base.POPaymentLocalServiceBaseImpl;

/**
 * The implementation of the p o payment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.POPaymentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see POPaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.POPaymentLocalServiceUtil
 */
@ProviderType
public class POPaymentLocalServiceImpl extends POPaymentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sphms.common.service.service.POPaymentLocalServiceUtil} to access the p o payment local service.
	 */
	
	public POPayment addOPayment(long billingId, long landLoardId, double amount, double gst, String checqueNo,
			Date paymentDate, long userId){
		
		POPayment poPayment = POPaymentLocalServiceUtil.createPOPayment(CounterLocalServiceUtil.increment());
		
		poPayment.setAmount(amount);
		poPayment.setBillingId(billingId);
		poPayment.setLandLordId(landLoardId);
		poPayment.setGst(gst);
		poPayment.setChequeNo(checqueNo);
		poPayment.setPaymentDate(paymentDate);
		
		poPayment.setCreatedBy(userId);
		poPayment.setModifiedBy(userId);
		poPayment.setCreateDate(new Date());
		poPayment.setModifiedDate(new Date());
		
		poPayment = POPaymentLocalServiceUtil.addPOPayment(poPayment);
		
		return poPayment;
	}
	
	public POPayment updatePOPayment(long poPaymentId, long billingId, long landLoardId, double amount, double gst, String checqueNo,
			Date paymentDate, long userId) throws PortalException{
		
		POPayment poPayment = POPaymentLocalServiceUtil.getPOPayment(poPaymentId);
		
		poPayment.setAmount(amount);
		poPayment.setBillingId(billingId);
		poPayment.setLandLordId(landLoardId);
		poPayment.setGst(gst);
		poPayment.setChequeNo(checqueNo);
		poPayment.setPaymentDate(paymentDate);
		
		poPayment.setModifiedBy(userId);
		poPayment.setModifiedDate(new Date());
		
		poPayment = POPaymentLocalServiceUtil.updatePOPayment(poPayment);
		
		return poPayment;
	}
	
	
	public List<POPayment> getPOPaymnetByBillingIdAndHoardingId(long billingId, long landLoardId){
		return poPaymentPersistence.findBybillingIdAndLandLordId(billingId, landLoardId);
	}
 }