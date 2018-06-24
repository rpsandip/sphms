package com.sphms.common.service.beans;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.HordingLocalServiceUtil;

public class Booking_HordingBean {
	
	Log _log = LogFactoryUtil.getLog(Booking_HordingBean.class.getName());
	
	private long bookingId;
	private long hordingId;
	private String hordingTitle;
	private double mountingCharge;
	private double printingCharge;
	private int units;
	private Date hordingBookingStartDate;
	private Date hordingbookingEndDate;
	private String hsnNo;
	private Hording horing;
	private String hoardingCity;
	public  Booking_HordingBean(){
		
	}
	
	public Booking_HordingBean(Booking_Hording bookingHording){
		this.bookingId = bookingHording.getBookingId();
		this.hordingId = bookingHording.getHordingId();
		this.mountingCharge = bookingHording.getMountingCharge();
		this.printingCharge = bookingHording.getPrintingCharge();
		this.hordingBookingStartDate = bookingHording.getHordingBookingStartDate();
		this.hordingbookingEndDate  = bookingHording.getHordingBookingEndDate();
		this.units = bookingHording.getUnits();
		this.hsnNo = bookingHording.getHsnNo();
		
		try {
			Hording hording = HordingLocalServiceUtil.getHording(this.hordingId);
			this.hordingTitle = hording.getTitle();
			this.horing = hording;
			this.hoardingCity = hording.getCity();
		} catch (PortalException e) {
			_log.error(e);
		}		
	}
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public long getHordingId() {
		return hordingId;
	}
	public void setHordingId(long hordingId) {
		this.hordingId = hordingId;
	}
	public String getHordingTitle() {
		return hordingTitle;
	}
	public void setHordingTitle(String hordingTitle) {
		this.hordingTitle = hordingTitle;
	}
	public double getMountingCharge() {
		return mountingCharge;
	}
	public void setMountingCharge(double mountingCharge) {
		this.mountingCharge = mountingCharge;
	}
	public double getPrintingCharge() {
		return printingCharge;
	}
	public void setPrintingCharge(double printingCharge) {
		this.printingCharge = printingCharge;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}

	public Hording getHoring() {
		return horing;
	}

	public void setHoring(Hording horing) {
		this.horing = horing;
	}

	public String getHsnNo() {
		return hsnNo;
	}

	public void setHsnNo(String hsnNo) {
		this.hsnNo = hsnNo;
	}

	public Date getHordingBookingStartDate() {
		return hordingBookingStartDate;
	}

	public void setHordingBookingStartDate(Date hordingBookingStartDate) {
		this.hordingBookingStartDate = hordingBookingStartDate;
	}

	public Date getHordingbookingEndDate() {
		return hordingbookingEndDate;
	}

	public void setHordingbookingEndDate(Date hordingbookingEndDate) {
		this.hordingbookingEndDate = hordingbookingEndDate;
	}

	public String getHoardingCity() {
		return hoardingCity;
	}

	public void setHoardingCity(String hoardingCity) {
		this.hoardingCity = hoardingCity;
	}
	
	
	
}

