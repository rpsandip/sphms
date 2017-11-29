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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.sphms.common.service.model.CreditNote;
import com.sphms.common.service.service.CreditNoteLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.common.service.service.base.CreditNoteLocalServiceBaseImpl;

/**
 * The implementation of the credit note local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.CreditNoteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditNoteLocalServiceBaseImpl
 * @see com.sphms.common.service.service.CreditNoteLocalServiceUtil
 */
@ProviderType
public class CreditNoteLocalServiceImpl extends CreditNoteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sphms.common.service.service.CreditNoteLocalServiceUtil} to access the credit note local service.
	 */
	
	public CreditNote addCreditNote(long clientId, long billingId ,double creditNoteAmount, double creditNoteTax, String chequeNo,
			String bankName, Date paymentDate, long createdBy){
		
		CreditNote creditNote = CreditNoteLocalServiceUtil.createCreditNote(CounterLocalServiceUtil.increment());
		creditNote.setClientId(clientId);
		creditNote.setBillingId(billingId);
		creditNote.setCreditNoteAmount(creditNoteAmount);
		creditNote.setCreditNoteTax(creditNoteTax);
		creditNote.setCreditNoteNumber(getNextCreditNoteNumber());
		creditNote.setFinancialYear(SPHMSCommonLocalServiceUtil.getFinancialYear());
		creditNote.setChequeNo(chequeNo);
		creditNote.setBankName(bankName);
		creditNote.setPaymentDate(paymentDate);
		creditNote.setCreatedBy(createdBy);
		creditNote.setCreateDate(new Date());
		creditNote.setModifiedBy(createdBy);
		creditNote.setModifiedDate(new Date());
		
		creditNote = CreditNoteLocalServiceUtil.addCreditNote(creditNote);
		
		return creditNote;
	}
	
	public CreditNote updateCreditNote(long creditNoteId, long billingId,double creditNoteAmount, double creditNoteTax, String chequeNo,
			String bankName, Date paymentDate, long modifiedBy) throws PortalException{
		
		
		CreditNote creditNote = CreditNoteLocalServiceUtil.getCreditNote(creditNoteId);
		
		creditNote.setCreditNoteAmount(creditNoteAmount);
		creditNote.setCreditNoteTax(creditNoteTax);
		creditNote.setChequeNo(chequeNo);
		creditNote.setBillingId(billingId);
		creditNote.setBankName(bankName);
		creditNote.setFinancialYear(SPHMSCommonLocalServiceUtil.getFinancialYear());
		creditNote.setPaymentDate(paymentDate);
		creditNote.setModifiedBy(modifiedBy);
		creditNote.setModifiedDate(new Date());
		
		creditNote = CreditNoteLocalServiceUtil.updateCreditNote(creditNote);
		
		return creditNote;
	}
	
	
	public List<CreditNote> getClientCreditNoteList(long clientId){
		return creditNotePersistence.findByclientId(clientId);
	}
	
	public String getNextCreditNoteNumber(){
		DynamicQuery dynamicQuery = CreditNoteLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("financialYear", SPHMSCommonLocalServiceUtil.getFinancialYear()));
		Order defaultOrder = OrderFactoryUtil.desc("createDate");
		dynamicQuery.addOrder(defaultOrder);
		dynamicQuery.setLimit(0, 1);
		List<CreditNote> creditNoteList = CreditNoteLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		if(creditNoteList.size()==0){
			return String.format("%03d", 1);
		}else{
			return String.format("%03d", Integer.parseInt(creditNoteList.get(0).getCreditNoteNumber())+1);
		}
		
	}
}