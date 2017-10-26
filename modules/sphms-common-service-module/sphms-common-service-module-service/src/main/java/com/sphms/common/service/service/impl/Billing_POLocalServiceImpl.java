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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.exception.NoSuchBilling_POException;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.common.service.service.base.Billing_POLocalServiceBaseImpl;
import com.sphms.common.service.service.persistence.Billing_POPK;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the billing_ p o local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.Billing_POLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_POLocalServiceBaseImpl
 * @see com.sphms.common.service.service.Billing_POLocalServiceUtil
 */
@ProviderType
public class Billing_POLocalServiceImpl extends Billing_POLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(Billing_POLocalServiceImpl.class.getName());
	
	/*
	 * Add Bill PO detail
	 */
	public Billing_PO addBillingPO(long billingId, long hordingId, double totalAmount, long createdBy, CustomCompany company){
		long landLordId = getLandLordId(hordingId);
		Billing_POPK billingPOPK = new Billing_POPK(billingId, hordingId);
		Billing_PO billingPO = Billing_POLocalServiceUtil.createBilling_PO(billingPOPK);
		billingPO.setTotalAmount(totalAmount);
		billingPO.setPoNumber(getNextPONumber(billingId,landLordId));
		billingPO.setLandLordId(landLordId);
		billingPO.setFinancialYear(SPHMSCommonLocalServiceUtil.getFinancialYear());
		billingPO.setCreateDate(new Date());
		billingPO.setCreatedBy(createdBy);
		billingPO.setModifiedBy(createdBy);
		billingPO.setModifiedDate(new Date());
		
		billingPO = Billing_POLocalServiceUtil.addBilling_PO(billingPO);
		
		return billingPO;
	}
	
	public List<Billing_PO> getBillingPOListByBillingId(long billingId){
		return billing_POPersistence.findBybillingId(billingId);
	}
	
	public List<Billing_PO> getBilling_POByBillingIdAndLandLordId(long billingId, long landLordId){
		return billing_POPersistence.findBybillingIdAndLandLordId(billingId, landLordId);
	}
	
	private long getLandLordId(long hordingId){
		long landlordId=0;
		try {
			Hording hording = HordingLocalServiceUtil.getHording(hordingId);
			landlordId = hording.getLandLordId();
		} catch (PortalException e) {
			_log.error(e);
		}
		return landlordId;
	}
	
	
	private String getNextPONumber(long billingId, long landLordId){
		
		// Check same Owner has hording or not for same booking
		List<Billing_PO> billingPOList = getBilling_POByBillingIdAndLandLordId(billingId, landLordId);
		
		if(billingPOList.size()==0){
			// Generate next po number
			DynamicQuery dynamicQuery = Billing_POLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(RestrictionsFactoryUtil.eq("financialYear", SPHMSCommonLocalServiceUtil.getFinancialYear()));
			Order defaultOrder = OrderFactoryUtil.desc("createDate");
			dynamicQuery.addOrder(defaultOrder);
			dynamicQuery.setLimit(0, 1);
			List<Billing_PO> poList = Billing_POLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			if(poList.size()==0){
				return "001";
			}else{
				String latestNumber = poList.get(0).getPoNumber();
				int newNum = (Integer.parseInt(latestNumber)+1);
				return String.format("%03d", newNum);
			}
		}else{
			// return PO number of other hoarding of same owner.
			return billingPOList.get(0).getPoNumber();
		}
		
	}
	
	public String getPONumber(Billing_PO billingPO, CustomCompany company){
		return company.getPoPrefix()+ "-"+ billingPO.getPoNumber() +"/"+ billingPO.getFinancialYear();
	}
}