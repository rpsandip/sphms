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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.LandLordPaymentBean;
import com.sphms.common.service.model.LandLordPayment;
import com.sphms.common.service.service.LandLordPaymentLocalServiceUtil;
import com.sphms.common.service.service.base.LandLordPaymentLocalServiceBaseImpl;

/**
 * The implementation of the land lord payment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.LandLordPaymentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.LandLordPaymentLocalServiceUtil
 */
@ProviderType
public class LandLordPaymentLocalServiceImpl
	extends LandLordPaymentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sphms.common.service.service.LandLordPaymentLocalServiceUtil} to access the land lord payment local service.
	 */
	
	/*
	 * Method for add Land Lord Payment
	 */
	public LandLordPayment addLandLordPayment(long landLordId, long hordingId, double amount, Date paymentDate, long createdBy){
	
		boolean isValidParam = validateParam(landLordId, hordingId, amount, paymentDate, createdBy);
		
		if(isValidParam){
		LandLordPayment landLordPayment = LandLordPaymentLocalServiceUtil.createLandLordPayment(CounterLocalServiceUtil.increment());
		landLordPayment.setLandLoadId(landLordId);
		landLordPayment.setHordingId(hordingId);
		landLordPayment.setAmount(amount);
		landLordPayment.setPaymentDate(paymentDate);
		landLordPayment.setCreateDate(new Date());
		landLordPayment.setCreatedBy(createdBy);
		landLordPayment = LandLordPaymentLocalServiceUtil.addLandLordPayment(landLordPayment);
		
		return landLordPayment;
		}else{
			return null;
		}
	}
	
	/*
	 * Method for update Land Lord Payment 
	 */
	public LandLordPayment updateLandLordPayment(long landLordPaymentId, long landLordId, long hordingId, double amount, Date paymentDate, long createdBy) throws PortalException{
		boolean isValidParam = validateParam(landLordId, hordingId, amount, paymentDate, createdBy);
		if(isValidParam){
			LandLordPayment landLordPayment = LandLordPaymentLocalServiceUtil.getLandLordPayment(landLordPaymentId);
			landLordPayment.setLandLoadId(landLordId);
			landLordPayment.setHordingId(hordingId);
			landLordPayment.setAmount(amount);
			landLordPayment.setPaymentDate(paymentDate);
			landLordPayment.setCreatedBy(createdBy);
			landLordPayment.setCreateDate(new Date());
			landLordPayment = LandLordPaymentLocalServiceUtil.updateLandLordPayment(landLordPayment);
			return landLordPayment;
		}else{
			return null;
		}
	}
	
	/*
	 * Method for get all LandLord Payments
	 * @see com.sphms.common.service.service.LandLordPaymentLocalService#getLandLordPayments(long)
	 */
	public List<LandLordPaymentBean> getLandLordPayments(long landLordId){
		List<LandLordPaymentBean> landLordPaymentBeansList = new ArrayList<LandLordPaymentBean>();
		List<LandLordPayment> landLordPaymentList = landLordPaymentPersistence.findBylandLordId(landLordId);
		for(LandLordPayment landLordPayment : landLordPaymentList){
			LandLordPaymentBean landLordPaymentBean = new LandLordPaymentBean(landLordPayment);
			landLordPaymentBeansList.add(landLordPaymentBean);
		}
		return landLordPaymentBeansList;
	}
	
	private boolean validateParam(long landLordId, long hordingId, double amount, Date paymentDate, long createdBy){
		boolean isValidParams = true;
		
		if(landLordId<=0 || hordingId<=0 || amount<=0 || Validator.isNull(paymentDate) || createdBy<=0){
			isValidParams=false;
		}
		
		return isValidParams;
	}
	
}