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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.osgi.util.StringPlus;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.model.SupplierBill;
import com.sphms.common.service.model.SupplierBillPayment;
import com.sphms.common.service.service.SupplierBillLocalServiceUtil;
import com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil;
import com.sphms.common.service.service.SupplierLocalServiceUtil;
import com.sphms.common.service.service.base.SupplierBillLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the supplier bill local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.SupplierBillLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillLocalServiceBaseImpl
 * @see com.sphms.common.service.service.SupplierBillLocalServiceUtil
 */
@ProviderType
public class SupplierBillLocalServiceImpl
	extends SupplierBillLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sphms.common.service.service.SupplierBillLocalServiceUtil} to access the supplier bill local service.
	 */
	
	public SupplierBill addSupplierBill(long companyId, long supplierId, String billNo, String billDesc, String billType, Date billDate,
			double amount, double gst, long createdBy){
		SupplierBill supplierBill = SupplierBillLocalServiceUtil.createSupplierBill(CounterLocalServiceUtil.increment());
		supplierBill.setCompanyId(companyId);
		supplierBill.setSupplierId(supplierId);
		supplierBill.setSupplierBillNo(billNo);
		supplierBill.setSupplierBillDesc(billDesc);
		supplierBill.setSupplierBillType(billType);
		supplierBill.setSupplierBillDate(billDate);
		supplierBill.setAmount(amount);
		supplierBill.setGst(gst);
		supplierBill.setCreatedBy(createdBy);
		supplierBill.setModifiedBy(createdBy);
		supplierBill.setCreateDate(new Date());
		supplierBill.setModifiedDate(new Date());
		
		supplierBill = SupplierBillLocalServiceUtil.addSupplierBill(supplierBill);
		
		return supplierBill;
	}
	
	public SupplierBill updateSupplierBill(long supplierBillId,  long companyId, long supplierId, String billNo, String billDesc, String billType, Date billDate,
			double amount, double gst, long createdBy) throws PortalException{
		
		SupplierBill supplierBill = SupplierBillLocalServiceUtil.getSupplierBill(supplierBillId);
		supplierBill.setCompanyId(companyId);
		supplierBill.setSupplierId(supplierId);
		supplierBill.setSupplierBillNo(billNo);
		supplierBill.setSupplierBillDesc(billDesc);
		supplierBill.setSupplierBillType(billType);
		supplierBill.setSupplierBillDate(billDate);
		supplierBill.setAmount(amount);
		supplierBill.setGst(gst);
		supplierBill.setModifiedBy(createdBy);
		supplierBill.setModifiedDate(new Date());
		
		supplierBill = SupplierBillLocalServiceUtil.updateSupplierBill(supplierBill);
		
		return supplierBill;
	}
	
	public List<SupplierBill> getSupploerBillList(long supplierId){
		return supplierBillPersistence.findBysupplierId(supplierId);
	}
	
	public List<SupplierBill> getSupplierBullListFromSearch(long supplierId, String type, Date startDate, Date endDate, long customCompanyId, int start, int end){
		
		List<SupplierBill> supplierBillList = new ArrayList<SupplierBill>();
		
		DynamicQuery dynamicQuery = SupplierBillLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(type)){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("supplierBillType", type));
		}
		
		if(customCompanyId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", customCompanyId));
		}
		
		if(supplierId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("supplierId", supplierId));
		}
		
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			dynamicQuery.add(RestrictionsFactoryUtil.between("supplierBillDate", startDate, endDate));
		}
		
	
		Order order = OrderFactoryUtil.desc("createDate");
		dynamicQuery.addOrder(order);
		
		supplierBillList = SupplierBillLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return supplierBillList;
		
	}
	
	public JSONObject getSupplierReportDetail(long customCompanyId, long supplierId, String type, Date startDate, Date endDate) throws PortalException{
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		DateFormat df  = new SimpleDateFormat("dd/MM/yyyy");
		List<SupplierBill> supplierBillList = getSupplierBullListFromSearch(supplierId, type, startDate, endDate, customCompanyId, -1, -1);
		JSONArray supplierBillArray = JSONFactoryUtil.createJSONArray();
		JSONArray supplierBillPaymentArray = JSONFactoryUtil.createJSONArray();
		double totalSupplierAmount=0;
		double totalSupplierAmountGST=0;
		double totalSupplierPaymentGiven=0;
		double totalSupplierPaymentGStGiven=0;
		for(SupplierBill supplierBill : supplierBillList){
			Supplier	supplier = SupplierLocalServiceUtil.getSupplier(supplierBill.getSupplierId());
			JSONObject supplierBillObj = JSONFactoryUtil.createJSONObject();
			supplierBillObj.put("billNo", supplierBill.getSupplierBillNo());
			supplierBillObj.put("billDate", df.format(supplierBill.getSupplierBillDate()));
			supplierBillObj.put("billAmount", supplierBill.getAmount());
			supplierBillObj.put("billAmountGST", supplierBill.getGst());
			supplierBillObj.put("supplierName", supplier.getSupplierName());
			supplierBillObj.put("descrption", "("+supplierBill.getSupplierBillType()+")" + StringPool.SPACE + supplierBill.getSupplierBillDesc());
			supplierBillArray.put(supplierBillObj);
			totalSupplierAmount+=supplierBill.getAmount();
			totalSupplierAmountGST+=supplierBill.getGst();
			
			List<SupplierBillPayment> supplierBillPayments = SupplierBillPaymentLocalServiceUtil.getSupplierBillPaymentBySupplierBillId(supplierBill.getSupplierBillId());
			for(SupplierBillPayment supplierBillPayment :supplierBillPayments ){
				JSONObject supplierBillPaymentObj = JSONFactoryUtil.createJSONObject();
				supplierBillPaymentObj.put("supplierName", supplier.getSupplierName());
				supplierBillPaymentObj.put("billNo", supplierBill.getSupplierBillNo());
				supplierBillPaymentObj.put("supplierBillAmount", supplierBillPayment.getAmount());
				supplierBillPaymentObj.put("supplierBillAmountGST", supplierBillPayment.getGst());
				supplierBillPaymentObj.put("paymentDate",df.format(supplierBillPayment.getPaymentDate()));
				if(Validator.isNotNull(supplierBillPayment.getChequeNo())){
					supplierBillPaymentObj.put("paymentType", "Cheque No :" + supplierBillPayment.getChequeNo());
				}else{
					supplierBillPaymentObj.put("paymentType", "Cash");
				}
				supplierBillPaymentArray.put(supplierBillPaymentObj);
				totalSupplierPaymentGiven+=supplierBillPayment.getAmount();
				totalSupplierPaymentGStGiven+=supplierBillPayment.getGst();
			}		
		}
		
		jsonObject.put("supplierBills", supplierBillArray);
		jsonObject.put("supplierBillPaymentArray", supplierBillPaymentArray);
		jsonObject.put("totalSupplierAmount", totalSupplierAmount);
		jsonObject.put("totalSupplierAmountGST", totalSupplierAmountGST);
		jsonObject.put("totalSupplierPaymentGiven", totalSupplierPaymentGiven);
		jsonObject.put("totalSupplierPaymentGStGiven", totalSupplierPaymentGStGiven);
		
		return jsonObject;
	}
}