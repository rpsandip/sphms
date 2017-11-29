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

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.Booking_HordingBean;
import com.sphms.common.service.exception.NoSuchBillingException;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_HordingLocalServiceUtil;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.Booking_HordingLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.base.BookingLocalServiceBaseImpl;
import com.sphms.common.service.util.BookingStatus;

/**
 * The implementation of the booking local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.BookingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.BookingLocalServiceUtil
 */
@ProviderType
public class BookingLocalServiceImpl extends BookingLocalServiceBaseImpl {

	Log _log = LogFactoryUtil.getLog(BookingLocalServiceImpl.class.getName());
	
	public Booking addBooking(String campaignTitle, long client, long companyId,Date startDate, Date endDate, List<Booking_HordingBean> bookingHordingList,long createdBy, long modifiedBy) throws PortalException{
	
		_log.info("Adding Booking ->" +  " campaignTitle->"+campaignTitle +" client ->" + client + " company ->"+ companyId +" dtartDate ->" + startDate + 
				"endDate ->" +endDate + " bookingHordingList ->" + bookingHordingList.size());
		
		
		Booking booking = BookingLocalServiceUtil.createBooking(CounterLocalServiceUtil.increment());
		booking.setCampaignTitle(campaignTitle);
		booking.setClient(client);
		booking.setCustomCompanyId(companyId);
		booking.setStartDate(startDate);
		booking.setEndDate(endDate);
		booking.setCreatedBy(createdBy);
		booking.setModifiedBy(modifiedBy);
		booking.setStatus(BookingStatus.ACTIVE.getValue());
		booking = BookingLocalServiceUtil.addBooking(booking);
		
		if(Validator.isNotNull(booking)){
			
			// Add hording detail of booking
			addBookingHordings(bookingHordingList, booking);
			
			// Add billing information
			// While adding billing information first time with booking we dont have info like client PAN Number, PO Number,
			// accessAmount, pendingAmount, creditNoteAmount, credingNoteTax. We can update these detail in Update method of billing
			// When we got all such inforamtion from Client offline.
			BillingLocalServiceUtil.addBillingForBooking(booking, booking.getClient(), companyId,StringPool.BLANK/*Firt time we dont have PAN Number*/,
					StringPool.BLANK/* First time we dont have PO Nunber */, StringPool.BLANK/* GSt Numbe*/, StringPool.BLANK/*display*/, 0d, 0d, createdBy);
		}
		
		return booking;
	}
	
	private void addBookingHordings(List<Booking_HordingBean> bookingHordingList, Booking booking){
		for(Booking_HordingBean bookingHording : bookingHordingList){
			bookingHording.setBookingId(booking.getBookingId());
			Booking_HordingLocalServiceUtil.addBookingHoarding(booking.getBookingId(), bookingHording.getHordingId(),
					bookingHording.getMountingCharge(), bookingHording.getPrintingCharge(), bookingHording.getUnits());
		}
	}
	
	
	public Booking updateBooking(long bookingId, String campaignTitle, long client, long companyId,Date startDate, Date endDate, List<Booking_HordingBean> bookingHordingList, long modifiedBy) throws PortalException{
		_log.info("Updating Bookign ->" +  " campaignTitle->"+campaignTitle +" client ->" + client + " dtartDate ->" + startDate + 
				"endDate ->" +endDate + " bookingHordingList ->" + bookingHordingList.size());
			Booking booking=null;
			booking = BookingLocalServiceUtil.getBooking(bookingId);
			booking.setCampaignTitle(campaignTitle);
			booking.setClient(client);
			booking.setCustomCompanyId(companyId);
			booking.setStartDate(startDate);
			booking.setEndDate(endDate);
			booking.setModifiedBy(modifiedBy);
			booking.setModifiedDate(new Date());
			
			booking = BookingLocalServiceUtil.updateBooking(booking);
			
			CustomCompany company = CustomCompanyLocalServiceUtil.getCustomCompany(booking.getCustomCompanyId());
			
			if(Validator.isNotNull(booking)){
				
				// Update Booking Hordings
				updateBookingHordings(bookingHordingList, booking);
				
				// Update billing for clientId
				Billing billing = BillingLocalServiceUtil.getBillingFromBookingId(booking.getBookingId());
				billing.setClientId(client);
				BillingLocalServiceUtil.updateBilling(billing);
				
				// Update Billing Hording units, total printing charge, total mounting charge.
				BillingLocalServiceUtil.updateBillingHordings(billing, booking, company);
				
			}
		
		return booking;
	}
	
	private void updateBookingHordings(List<Booking_HordingBean> bookingHordingList, Booking booking){
		// While update booking hording, we will delete all old entries and add new 
		List<Booking_Hording> bookingHordingDeleteList = Booking_HordingLocalServiceUtil.getBookingHordingsList(booking.getBookingId());
		for(Booking_Hording bookingHording : bookingHordingDeleteList){
			Booking_HordingLocalServiceUtil.deleteBooking_Hording(bookingHording);
		}
		// Add new hordings
		addBookingHordings(bookingHordingList, booking);
	}
	
	/*
	 * Method for get booking list based on search criteria
	 * @see com.sphms.common.service.service.BookingLocalService#getBookingList(long, java.util.Date, java.util.Date, int, int)
	 */
	public  List<Booking> getBookingList(long clientId, Date startDate, Date endDate, int start, int end){
		List<Booking> bookingList = new ArrayList<Booking>();
		DynamicQuery dynamicQuery = BookingLocalServiceUtil.dynamicQuery();
		
		if(clientId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("client", clientId));
		}
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			dynamicQuery.add(RestrictionsFactoryUtil.between("startDate", startDate, endDate));
		}
		dynamicQuery.setLimit(start, end);
		
		Order order = OrderFactoryUtil.desc("createDate");
		dynamicQuery.addOrder(order);
		
		bookingList = BookingLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return bookingList;
	}
	
	public long getBookingCount(long clientId, Date startDate, Date endDate){
		return getBookingList(clientId, startDate, endDate, -1, -1).size();
	}
	
	public boolean updateBookingStatus(long bookingId, int status) throws PortalException{
		
		Booking booking = BookingLocalServiceUtil.getBooking(bookingId);
		booking.setStatus(status);
		booking = BookingLocalServiceUtil.updateBooking(booking);
			
		Billing billing = BillingLocalServiceUtil.getBillingFromBookingId(bookingId);
		billing.setStatus(status);
		billing = BillingLocalServiceUtil.updateBilling(billing);
	
		return true;
	}
	
}