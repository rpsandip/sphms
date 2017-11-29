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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.BillingBean;
import com.sphms.common.service.beans.Billing_HordingBean;
import com.sphms.common.service.beans.Booking_HordingBean;
import com.sphms.common.service.beans.OwnerType;
import com.sphms.common.service.exception.NoSuchBillingException;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_HordingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.Booking_HordingLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.common.service.service.base.BillingLocalServiceBaseImpl;
import com.sphms.common.service.service.persistence.Billing_HordingPK;
import com.sphms.common.service.service.persistence.Billing_POPK;
import com.sphms.common.service.service.persistence.Booking_HordingPK;

/**
 * The implementation of the billing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.BillingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BillingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.BillingLocalServiceUtil
 */
@ProviderType
public class BillingLocalServiceImpl extends BillingLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(BillingLocalServiceImpl.class.getName());
	
	/*
	 * Method for add initial information of bill after creation of booking
	 */
	public Billing addBillingForBooking(Booking booking, long clientId, long companyId, String clientPANum, String clientPONum, String clientGSTNum,String display,
			double accessAmount, double pendingAmount,long createdBy) throws PortalException
		{ 
			Billing billing = BillingLocalServiceUtil.createBilling(CounterLocalServiceUtil.increment());
			billing.setBookingId(booking.getBookingId());
			billing.setClientId(booking.getClient());
			billing.setCustomCompanyId(companyId);
			billing.setClientPANNo(clientPANum);
			billing.setClientPONumber(clientPONum);
			billing.setDisplay(display);
			billing.setAccessAmount(accessAmount);
			billing.setPendingAmount(pendingAmount);
			billing.setClientGSTNumber(clientGSTNum);
			billing.setBillNo(getNextBillNo());
			billing.setFinancialYear(SPHMSCommonLocalServiceUtil.getFinancialYear());
			billing.setCreatedBy(createdBy);
			billing.setModifiedBy(createdBy);
			billing.setCreateDate(new Date());
			billing.setModifiedDate(new Date());
			billing.setStatus(0);
			
			billing = BillingLocalServiceUtil.addBilling(billing);
			
			// Add Billing Hording detail
			if(Validator.isNotNull(billing)){
				addBillingHordings(billing, booking);
			}
			
			return billing;
	}
	
	private void addBillingHordings(Billing billing, Booking booking) throws PortalException{
		List<Booking_Hording> bookingHordingList = Booking_HordingLocalServiceUtil.getBookingHordingsList(booking.getBookingId());
		CustomCompany company = CustomCompanyLocalServiceUtil.getCustomCompany(billing.getCustomCompanyId());
		for(Booking_Hording bookingHording : bookingHordingList){
			Booking_HordingBean bookingHordingBean = new Booking_HordingBean(bookingHording);
			double totalMountingCharge =  bookingHording.getUnits()*(bookingHording.getMountingCharge()*SPHMSCommonLocalServiceUtil.getTotalSqFt(SPHMSCommonLocalServiceUtil.getHeightOrWidth(bookingHordingBean.getHoring().getSize())));
			double totalPrintingCharge = bookingHording.getUnits()*(bookingHording.getPrintingCharge()*SPHMSCommonLocalServiceUtil.getTotalSqFt(SPHMSCommonLocalServiceUtil.getHeightOrWidth(bookingHordingBean.getHoring().getSize())));
			long displayDurationDays = SPHMSCommonLocalServiceUtil.getDisplayDuration(booking.getStartDate(), booking.getEndDate());
			double displayCharge = bookingHording.getUnits() * SPHMSCommonLocalServiceUtil.getDisplayCharges(bookingHordingBean.getHoring().getPricePerMonth(), displayDurationDays);
			Billing_HordingLocalServiceUtil.addBillingHording(billing.getBillingId(), bookingHording.getHordingId(), totalMountingCharge,
					totalPrintingCharge, bookingHordingBean.getUnits(), displayCharge/*+totalMountingCharge+totalPrintingCharge*/);
			
			// If hoarding is not own then Need to generate PO for Billing.
			if(bookingHordingBean.getHoring().getOwnerType()==OwnerType.TRADE.getValue()){
				Billing_POLocalServiceUtil.addBillingPO(billing.getBillingId(), bookingHordingBean.getHordingId(), 
						displayCharge, billing.getCreatedBy(), company);
			}
		
		}
	}
	
	public void updateBillingHordings(Billing billing, Booking booking, CustomCompany company) throws PortalException{
		
		List<Booking_Hording> bookingHordingList = Booking_HordingLocalServiceUtil.getBookingHordingsList(booking.getBookingId());
		List<Long> bookingHordingIdList = new ArrayList<Long>();
		
		// Update Existing billing hoardings which are exist in booking hoardngs. 
		for(Booking_Hording bookingHording : bookingHordingList){
			
			Booking_HordingBean bookingHordingBean = new Booking_HordingBean(bookingHording);
			double totalMountingCharge =  bookingHording.getUnits()*(bookingHording.getMountingCharge()*SPHMSCommonLocalServiceUtil.getTotalSqFt(SPHMSCommonLocalServiceUtil.getHeightOrWidth(bookingHordingBean.getHoring().getSize())));
			double totalPrintingCharge = bookingHording.getUnits()*(bookingHording.getPrintingCharge()*SPHMSCommonLocalServiceUtil.getTotalSqFt(SPHMSCommonLocalServiceUtil.getHeightOrWidth(bookingHordingBean.getHoring().getSize())));
			long displayDurationDays = SPHMSCommonLocalServiceUtil.getDisplayDuration(booking.getStartDate(), booking.getEndDate());
			double displayCharge = bookingHording.getUnits() * SPHMSCommonLocalServiceUtil.getDisplayCharges(bookingHordingBean.getHoring().getPricePerMonth(), displayDurationDays);
			bookingHordingIdList.add(bookingHording.getHordingId());
			
			Billing_HordingPK billingHordingPK = new Billing_HordingPK(billing.getBillingId(),bookingHording.getHordingId());
			
			try {
				Billing_Hording billingHording = Billing_HordingLocalServiceUtil.getBilling_Hording(billingHordingPK);
				billingHording.setUnits(bookingHordingBean.getUnits());
				billingHording.setTotalMountingCharge(totalMountingCharge);
				billingHording.setTotalPrintingCharge(totalPrintingCharge);
				billingHording.setTotalHordingCharge(displayCharge);
				
				Billing_HordingLocalServiceUtil.updateBilling_Hording(billingHording);
				
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		// Get billing hoardings Ids 
		List<Long> billingHordingsIdList = new ArrayList<Long>();
		List<Billing_Hording> billingHordingList = Billing_HordingLocalServiceUtil.getBillingHordingList(billing.getBillingId());
		for(Billing_Hording billingHording : billingHordingList){
			billingHordingsIdList.add(billingHording.getHordingId());
		}
		
		// Find booking hording which are not in billing hordings list and need to add it
		for(Long bookingHordingId : bookingHordingIdList){
			if(!billingHordingsIdList.contains(bookingHordingId)){
				// Need to add in Billing Hording
				Booking_HordingPK bookingHordingPK = new Booking_HordingPK(booking.getBookingId(),bookingHordingId);
				Booking_Hording bookingHording = Booking_HordingLocalServiceUtil.getBooking_Hording(bookingHordingPK);
				Booking_HordingBean bookingHordingBean = new Booking_HordingBean(bookingHording);
				double totalMountingCharge =  bookingHording.getUnits()*(bookingHording.getMountingCharge()*SPHMSCommonLocalServiceUtil.getTotalSqFt(SPHMSCommonLocalServiceUtil.getHeightOrWidth(bookingHordingBean.getHoring().getSize())));
				double totalPrintingCharge = bookingHording.getUnits()*(bookingHording.getPrintingCharge()*SPHMSCommonLocalServiceUtil.getTotalSqFt(SPHMSCommonLocalServiceUtil.getHeightOrWidth(bookingHordingBean.getHoring().getSize())));
				long displayDurationDays = SPHMSCommonLocalServiceUtil.getDisplayDuration(booking.getStartDate(), booking.getEndDate());
				double displayCharge = bookingHording.getUnits() * SPHMSCommonLocalServiceUtil.getDisplayCharges(bookingHordingBean.getHoring().getPricePerMonth(), displayDurationDays);
				Billing_HordingLocalServiceUtil.addBillingHording(billing.getBillingId(), bookingHording.getHordingId(), totalMountingCharge,
						totalPrintingCharge, bookingHordingBean.getUnits(), displayCharge/*+totalMountingCharge+totalPrintingCharge*/);
			
				// If hoarding is not own then Need to generate PO for Billing.
				if(bookingHordingBean.getHoring().getOwnerType()==OwnerType.TRADE.getValue()){
					Billing_POLocalServiceUtil.addBillingPO(billing.getBillingId(), bookingHordingBean.getHordingId(), 
							displayCharge, billing.getCreatedBy(), company);
				}
			}
		}
		
		
		// Find Billing hording which are not in booking hording and need to delete it.
		for(Long billingHordingId : billingHordingsIdList){
			if(!bookingHordingIdList.contains(billingHordingId)){
				// Need to delete in Billing Hording
				Billing_HordingPK billing_HordingPK = new Billing_HordingPK(billing.getBillingId(), billingHordingId);
				try {
					Billing_Hording billingHording = Billing_HordingLocalServiceUtil.getBilling_Hording(billing_HordingPK);
					Billing_HordingLocalServiceUtil.deleteBilling_Hording(billingHording);
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
				
				// Need to delete repsective Billing PO
				Billing_POPK billingPOPK = new Billing_POPK(billing.getBillingId(), billingHordingId);
				try{
					Billing_PO billingPO = Billing_POLocalServiceUtil.getBilling_PO(billingPOPK);
					Billing_POLocalServiceUtil.deleteBilling_PO(billingPO);
				}catch(PortalException e){
					_log.error(e.getMessage());
				}
			}
		}
	}
	
	/*
	 * Update Billing 
	 */
	public Billing updateBilling(long billingId, String clientPANum, String clientPONum, String clientGSTNum,String display,
			double accessAmount, double pendingAmount, List<Billing_HordingBean> billing_HordingBeanList,long modifiedBy) throws PortalException{
		
		Billing billing = BillingLocalServiceUtil.getBilling(billingId);
		billing.setClientPANNo(clientPANum);
		billing.setClientPONumber(clientPONum);
		billing.setClientGSTNumber(clientGSTNum);
		billing.setDisplay(display);
		billing.setAccessAmount(accessAmount);
		billing.setPendingAmount(pendingAmount);
		billing.setModifiedBy(modifiedBy);
		billing.setModifiedDate(new Date());
		
		billing = BillingLocalServiceUtil.updateBilling(billing);
		
		// Update Billing Hording
		for(Billing_HordingBean billingHordingBean : billing_HordingBeanList){
			Billing_HordingPK billingHordingPK = new Billing_HordingPK(billingId, billingHordingBean.getHordingId());
			try {
				Billing_Hording billingHording = Billing_HordingLocalServiceUtil.getBilling_Hording(billingHordingPK);
				billingHording.setTotalPrintingCharge(billingHordingBean.getTotalPrintingCharge());
				billingHording.setTotalMountingCharge(billingHordingBean.getTotalMountingCharge());
				billingHording.setTotalHordingCharge(billingHordingBean.getTotalHordingCharge());
				billingHording.setHsnNo(billingHordingBean.getHsnNo());
				Billing_HordingLocalServiceUtil.updateBilling_Hording(billingHording);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		return billing;
	}
	
	public void updateBillingHordingWhileUpdateBooking(Billing billing, Booking booking) throws PortalException{
		// While update billing hording, we will delete all old entries and add new 
		List<Billing_Hording> billingHordingList = Billing_HordingLocalServiceUtil.getBillingHordingList(billing.getBillingId());
		for(Billing_Hording billingHording : billingHordingList){
			Billing_HordingLocalServiceUtil.deleteBilling_Hording(billingHording);
		}
		
		// Delete billing Billing_PO
		List<Billing_PO> billingPOList = Billing_POLocalServiceUtil.getBillingPOListByBillingId(billing.getBillingId());
		for(Billing_PO billingPO : billingPOList){
			Billing_POLocalServiceUtil.deleteBilling_PO(billingPO);
		}
		
		// Add new billing hordings
		addBillingHordings(billing, booking);
	}
	
	
	public Billing getBillingFromBookingId(long bookingId) throws NoSuchBillingException{
		return billingPersistence.findBybookingId(bookingId);
	}
	
	/*
	 * Method for get billing list based on search criteria 
	 * @see com.sphms.common.service.service.BillingLocalService#getBillingList(long, java.util.Date, java.util.Date, int, int)
	 */
	public List<Billing> getBillingList(long clientId, Date startDate, Date endDate, int start, int end){
		List<Billing> billingList = new ArrayList<Billing>();
		
		DynamicQuery dynamicQuery = BillingLocalServiceUtil.dynamicQuery();
		
		if(clientId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("clientId", clientId));
		}
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			dynamicQuery.add(RestrictionsFactoryUtil.between("modifiedDate", startDate, endDate));
		}
		dynamicQuery.setLimit(start, end);
		
		Order order = OrderFactoryUtil.desc("modifiedDate");
		dynamicQuery.addOrder(order);
		
		billingList = BillingLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return billingList;
	}
	
	public long getBillingCount(long clientId, Date startDate, Date endDate){
		return getBillingList(clientId, startDate, endDate, -1, -1).size();
	}
	
	private String getNextBillNo(){
		DynamicQuery dynamicQuery = BillingLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(RestrictionsFactoryUtil.eq("financialYear", SPHMSCommonLocalServiceUtil.getFinancialYear()));
		Order defaultOrder = OrderFactoryUtil.desc("createDate");
		dynamicQuery.addOrder(defaultOrder);
		dynamicQuery.setLimit(0, 1);
		List<Billing> billingList = BillingLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		if(billingList.size()==0){
			String baseYear = "2017"; //PropsUtil.get("base.year.bill.no");
			String prefix = "9"; // PropsUtil.get("base.prefix.bill.no");
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int yearDiff= (year-Integer.parseInt(baseYear));
			int prefixDiff = Integer.parseInt(prefix)+yearDiff;
			return prefixDiff+String.format("%04d", 1);
		}else{
			return String.format("%04d", Integer.parseInt(billingList.get(0).getBillNo())+1);
		}
	}
	
	public List<BillingBean> getClientBillings(long clientId){
		List<BillingBean> billingBeanList = new ArrayList<BillingBean>();
		List<Billing> billingList = billingPersistence.findByclientId(clientId);
		for(Billing billing : billingList){
			BillingBean billingBean = new BillingBean(billing);
			billingBeanList.add(billingBean);
		}
		return billingBeanList;
	}
}