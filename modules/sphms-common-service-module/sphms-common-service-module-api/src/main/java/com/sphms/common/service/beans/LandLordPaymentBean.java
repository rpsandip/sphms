package com.sphms.common.service.beans;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.model.LandLordPayment;
import com.sphms.common.service.service.LandLordLocalServiceUtil;

public class LandLordPaymentBean {
	
	Log _log = LogFactoryUtil.getLog(LandLordPaymentBean.class.getName());
	
	private long landLordId;
	private long hordingId;
	private long landLordPaymentId;
	private double amount;
	private Date paymentDate;
	private String firstName;
	private String lastName;
	private String location;
	private String city;
	
	
	public LandLordPaymentBean(LandLordPayment landLordPayment){
		this.landLordId = landLordPayment.getLandLoadId();
		this.hordingId = landLordPayment.getHordingId();
		this.amount = landLordPayment.getAmount();
		this.paymentDate = landLordPayment.getPaymentDate();
		this.landLordPaymentId = landLordPayment.getLandLordPaymentId();
		
		try {
			LandLord landLord = LandLordLocalServiceUtil.getLandLord(landLordId);
			this.firstName = landLord.getFirstName();
			this.lastName = landLord.getLastName();
			this.location = landLord.getLocation();
			this.city = landLord.getCity();
		} catch (PortalException e) {
			_log.error(e);
		}
	}


	public long getLandLordId() {
		return landLordId;
	}


	public void setLandLordId(long landLordId) {
		this.landLordId = landLordId;
	}


	public long getHordingId() {
		return hordingId;
	}


	public void setHordingId(long hordingId) {
		this.hordingId = hordingId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public long getLandLordPaymentId() {
		return landLordPaymentId;
	}


	public void setLandLordPaymentId(long landLordPaymentId) {
		this.landLordPaymentId = landLordPaymentId;
	}
	
	
	
	
}
