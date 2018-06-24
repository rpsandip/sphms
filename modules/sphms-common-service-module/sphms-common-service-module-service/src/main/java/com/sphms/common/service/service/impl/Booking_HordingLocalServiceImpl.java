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

import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.service.Booking_HordingLocalServiceUtil;
import com.sphms.common.service.service.base.Booking_HordingLocalServiceBaseImpl;
import com.sphms.common.service.service.persistence.Booking_HordingPK;

/**
 * The implementation of the booking_ hording local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.Booking_HordingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Booking_HordingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.Booking_HordingLocalServiceUtil
 */
@ProviderType
public class Booking_HordingLocalServiceImpl
	extends Booking_HordingLocalServiceBaseImpl {
	
	public Booking_Hording addBookingHoarding(long bookingId, long hordingId, double mountingCharge, double printingChrage, int units, String hsnNo, Date hordingBookingStartDate, Date hordingBookingEndDate){
		Booking_HordingPK booking_HordingPK = new Booking_HordingPK(bookingId, hordingId);
		Booking_Hording bookingHording = Booking_HordingLocalServiceUtil.createBooking_Hording(booking_HordingPK);
		bookingHording.setMountingCharge(mountingCharge);
		bookingHording.setPrintingCharge(printingChrage);
		bookingHording.setUnits(units);
		bookingHording.setHsnNo(hsnNo);
		bookingHording.setHordingBookingStartDate(hordingBookingStartDate);
		bookingHording.setHordingBookingEndDate(hordingBookingEndDate);
		bookingHording = Booking_HordingLocalServiceUtil.addBooking_Hording(bookingHording);
		return bookingHording;
	}
	
	public List<Booking_Hording> getBookingHordingsList(long bookingId){
		return booking_HordingPersistence.findBybookingId(bookingId);
	}
}