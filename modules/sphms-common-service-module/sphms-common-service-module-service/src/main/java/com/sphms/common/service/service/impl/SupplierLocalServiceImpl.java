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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.service.SupplierLocalServiceUtil;
import com.sphms.common.service.service.base.SupplierLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the supplier local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.SupplierLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierLocalServiceBaseImpl
 * @see com.sphms.common.service.service.SupplierLocalServiceUtil
 */
@ProviderType
public class SupplierLocalServiceImpl extends SupplierLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sphms.common.service.service.SupplierLocalServiceUtil} to access the supplier local service.
	 */
	
	public Supplier addSupplier(String supplierName, String address1, String address2, String city, String state,
			String contactPersonName, String contactPersonPhoneNo, String contactPersonEmail, String panNo, String gstNo,long createdBy){
		Supplier supplier = SupplierLocalServiceUtil.createSupplier(CounterLocalServiceUtil.increment());
		supplier.setSupplierName(supplierName);
		supplier.setAddress1(address1);
		supplier.setAddress2(address2);
		supplier.setCity(city);
		supplier.setState(state);
		supplier.setPanNo(panNo);
		supplier.setGstNo(gstNo);
		supplier.setStatus(0);
		supplier.setContactPersonName(contactPersonName);
		supplier.setContactPersonPhoneNo(contactPersonPhoneNo);
		supplier.setContactPersonEmail(contactPersonEmail);
		supplier.setCreateDate(new Date());
		supplier.setCreatedBy(createdBy);
		supplier = SupplierLocalServiceUtil.addSupplier(supplier);
		
		return supplier;
	}
	
	
	public Supplier updateSupplier(long supplierId,String supplierName, String address1, String address2, String city, String state,
			String contactPersonName, String contactPersonPhoneNo, String contactPersonEmail, String panNo, String gstNo,long createdBy) throws PortalException{
		Supplier supplier = SupplierLocalServiceUtil.getSupplier(supplierId);
		
		supplier.setSupplierName(supplierName);
		supplier.setAddress1(address1);
		supplier.setAddress2(address2);
		supplier.setCity(city);
		supplier.setState(state);
		supplier.setPanNo(panNo);
		supplier.setGstNo(gstNo);
		supplier.setContactPersonName(contactPersonName);
		supplier.setContactPersonPhoneNo(contactPersonPhoneNo);
		supplier.setContactPersonEmail(contactPersonEmail);
		supplier.setCreateDate(new Date());
		supplier.setCreatedBy(createdBy);
		
		supplier = SupplierLocalServiceUtil.updateSupplier(supplier);
		return supplier;
	}
	
	
	public Supplier deleteClient(long supplierId) throws PortalException{
		Supplier supplier = SupplierLocalServiceUtil.getSupplier(supplierId);
		supplier.setStatus(1);
		supplier = SupplierLocalServiceUtil.updateSupplier(supplier);
		return supplier;
	}
	
	public List<Supplier> getSuppliers(){
		return supplierPersistence.findBystatus(0);
	}
}