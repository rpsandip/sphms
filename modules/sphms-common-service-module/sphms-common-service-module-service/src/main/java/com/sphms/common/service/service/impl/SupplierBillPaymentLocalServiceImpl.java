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
import com.sphms.common.service.model.SupplierBillPayment;
import com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil;
import com.sphms.common.service.service.base.SupplierBillPaymentLocalServiceBaseImpl;

/**
 * The implementation of the supplier bill payment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.SupplierBillPaymentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil
 */
@ProviderType
public class SupplierBillPaymentLocalServiceImpl
	extends SupplierBillPaymentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil} to access the supplier bill payment local service.
	 */
	
	public SupplierBillPayment addSupplierBillPayment(long supplierId, long supplierBillId,double amount, double gst,
			Date paymentDate, String chequeNo, long createdBy){
		
		SupplierBillPayment payment = SupplierBillPaymentLocalServiceUtil.createSupplierBillPayment(CounterLocalServiceUtil.increment());
		payment.setSupplierId(supplierId);
		payment.setSupplierBillId(supplierBillId);
		payment.setAmount(amount);
		payment.setGst(gst);
		payment.setChequeNo(chequeNo);
		payment.setCreateDate(new Date());
		payment.setPaymentDate(paymentDate);
		payment.setModifiedDate(new Date());
		payment.setCreatedBy(createdBy);
		payment.setModifiedBy(createdBy);
		
		payment= SupplierBillPaymentLocalServiceUtil.addSupplierBillPayment(payment);
		
		return payment;
		
	}
	
	
	public SupplierBillPayment updateSupplierBillPayment(long supplierBillPaymentId, long supplierId, long supplierBillId,double amount, double gst,
			Date paymentDate, String chequeNo, long createdBy) throws PortalException{
		
		SupplierBillPayment payment = SupplierBillPaymentLocalServiceUtil.getSupplierBillPayment(supplierBillPaymentId);
		payment.setSupplierId(supplierId);
		payment.setSupplierBillId(supplierBillId);
		payment.setAmount(amount);
		payment.setGst(gst);
		payment.setChequeNo(chequeNo);
		payment.setPaymentDate(paymentDate);
		payment.setCreateDate(new Date());
		payment.setModifiedDate(new Date());
		payment.setCreatedBy(createdBy);
		payment.setModifiedBy(createdBy);
		
		payment= SupplierBillPaymentLocalServiceUtil.updateSupplierBillPayment(payment);
		
		return payment;
		
	}
	
	public List<SupplierBillPayment> getSupplierBillPaymentBySupplierBillId(long supplierBillId){
		return supplierBillPaymentPersistence.findBysupplierBillId(supplierBillId);
	}
}