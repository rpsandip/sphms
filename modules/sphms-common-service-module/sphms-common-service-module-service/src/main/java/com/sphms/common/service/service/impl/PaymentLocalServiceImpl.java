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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Payment;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.PaymentLocalServiceUtil;
import com.sphms.common.service.service.base.PaymentLocalServiceBaseImpl;

/**
 * The implementation of the payment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.PaymentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.PaymentLocalServiceUtil
 */
@ProviderType
public class PaymentLocalServiceImpl extends PaymentLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(PaymentLocalServiceImpl.class.getName());
	
	/*
	 * Method for add payment of Bill
	 */
	public Payment addPayment(long billingId, double amount, String chequeNo, double tds, double deduction, String description,long createdBy){
		Payment payment = PaymentLocalServiceUtil.createPayment(CounterLocalServiceUtil.increment());
		payment.setBillingId(billingId);
		payment.setClientId(getClientId(billingId));
		payment.setAmount(amount);
		payment.setChequeNo(chequeNo);
		payment.setTds(tds);
		payment.setDeduction(deduction);
		payment.setCreateDate(new Date());
		payment.setDescription(description);
		payment.setCreatedBy(createdBy);
		payment.setModifiedBy(createdBy);
		payment.setModifiedDate(new Date());
		
		if(billingId>0 && amount>0){
			payment = PaymentLocalServiceUtil.addPayment(payment);
		}else{
			payment = null;
		}
		
		return payment;
	}
	
	
	/*
	 * Method for update payment of Bill
	 */
	public Payment updatePayment(long paymentId, long billingId, double amount, String chequeNo, double tds, double deduction, String description,long modifiedBy){
		Payment payment = null;
		try {
			 payment = PaymentLocalServiceUtil.getPayment(paymentId);
			 payment.setAmount(amount);
			 payment.setChequeNo(chequeNo);
			 payment.setTds(tds);
			 payment.setDeduction(deduction);
			 payment.setModifiedBy(modifiedBy);
			 payment.setDescription(description);
			 payment.setModifiedDate(new Date());
			 payment = PaymentLocalServiceUtil.updatePayment(payment);
			 
		} catch (PortalException e) {
			_log.error(e);
		}
		return payment;
	}
	
	public List<Payment> getPaymentsOfBill(long billingId){
		return paymentPersistence.findBybillingId(billingId);
	}
	
	private long getClientId(long billingId){
		long clientId=0;
		try {
			Billing billing = BillingLocalServiceUtil.getBilling(billingId);
			clientId = billing.getClientId();
		} catch (PortalException e) {
			_log.error(e);
		}
		return clientId;
	}
}