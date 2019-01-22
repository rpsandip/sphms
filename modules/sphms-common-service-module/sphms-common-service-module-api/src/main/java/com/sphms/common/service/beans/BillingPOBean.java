package com.sphms.common.service.beans;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;

public class BillingPOBean {
	
	Log _log = LogFactoryUtil.getLog(BillingPOBean.class.getName());
	
	long billingId;
	long hordingId;
	long landLoardId;
	String supplierName;
	String poNumber;
	String financialYear;
	double totalAmount;
	String hordingTitle;
	String campaign;
	long companyId;
	
	public BillingPOBean(Billing_PO billingPO, CustomCompany company){
		this.billingId = billingPO.getBillingId();
		this.hordingId = billingPO.getHordingId();
		this.poNumber = Billing_POLocalServiceUtil.getPONumber(billingPO, company);
		this.financialYear = billingPO.getFinancialYear();
		this.totalAmount = Math.round(billingPO.getTotalAmount());
		
		if(this.hordingId>0){
			try {
				Hording hording = HordingLocalServiceUtil.getHording(this.hordingId);
				this.hordingTitle = hording.getTitle();
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		if(this.billingId>0){
			try {
				Billing billing = BillingLocalServiceUtil.getBilling(this.billingId);
				Booking bookign = BookingLocalServiceUtil.getBooking(billing.getBookingId());
				this.campaign = bookign.getCampaignTitle();
				this.companyId = billing.getCustomCompanyId();
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		if(landLoardId>0){
			try {
			LandLord landLoard = LandLordLocalServiceUtil.getLandLord(this.landLoardId);
			this.supplierName = landLoard.getFirstName()+" " + landLoard.getLastName();
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
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getHordingTitle() {
		return hordingTitle;
	}
	public void setHordingTitle(String hordingTitle) {
		this.hordingTitle = hordingTitle;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}


	public long getLandLoardId() {
		return landLoardId;
	}


	public void setLandLoardId(long landLoardId) {
		this.landLoardId = landLoardId;
	}


	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}




	public long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	
	
	
}
