package com.sphms.common.service.beans;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.HordingLocalServiceUtil;

public class Billing_HordingBean {
	
	Log _log = LogFactoryUtil.getLog(Billing_HordingBean.class.getName());
	
	private long billingId;
	private long hordingId;
	private Hording hording;
	private double totalMountingCharge;
	private double totalPrintingCharge;
	private int units;
	private double totalHordingCharge;
	private String hsnNo;
	private Date hordingBookingStartDate;
	private Date hordingbookingEndDate;
	
	public Billing_HordingBean(){
		
	}
	
	public Billing_HordingBean(Billing_Hording billingHording){
		this.billingId = billingHording.getBillingId();
		this.hordingId = billingHording.getHordingId();
		this.totalPrintingCharge = billingHording.getTotalPrintingCharge();
		this.totalMountingCharge = billingHording.getTotalMountingCharge();
		this.totalHordingCharge = billingHording.getTotalHordingCharge();
		this.units = billingHording.getUnits();
		this.hsnNo = billingHording.getHsnNo();
		this.hordingBookingStartDate = billingHording.getHordingBookingStartDate();
		this.hordingbookingEndDate = billingHording.getHordingBookingEndDate();
		if(this.hordingId>0){
			try {
				Hording hording = HordingLocalServiceUtil.getHording(hordingId);
				this.hording = hording;
			} catch (PortalException e) {
				_log.error(e);
			}
		}
	}
	
	public long getBillingId() {
		return billingId;
	}
	public void setBillingId(long billingId) {
		this.billingId = billingId;
	}
	public long getHordingId() {
		return hordingId;
	}
	public void setHordingId(long hordingId) {
		this.hordingId = hordingId;
	}
	public double getTotalMountingCharge() {
		return totalMountingCharge;
	}
	public void setTotalMountingCharge(double totalMountingCharge) {
		this.totalMountingCharge = totalMountingCharge;
	}
	public double getTotalPrintingCharge() {
		return totalPrintingCharge;
	}
	public void setTotalPrintingCharge(double totalPrintingCharge) {
		this.totalPrintingCharge = totalPrintingCharge;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getTotalHordingCharge() {
		return totalHordingCharge;
	}
	public void setTotalHordingCharge(double totalHordingCharge) {
		this.totalHordingCharge = totalHordingCharge;
	}
	public String getHsnNo() {
		return hsnNo;
	}

	public void setHsnNo(String hsnNo) {
		this.hsnNo = hsnNo;
	}

	public Hording getHording() {
		return hording;
	}

	public void setHording(Hording hording) {
		this.hording = hording;
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
	
	
	
	
}
