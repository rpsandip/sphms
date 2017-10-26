package com.sphms.common.service.beans;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;

public class BillingPOBean {
	
	Log _log = LogFactoryUtil.getLog(BillingPOBean.class.getName());
	
	long billingId;
	long hordingId;
	String poNumber;
	String financialYear;
	double totalAmount;
	String hordingTitle;
	
	public BillingPOBean(Billing_PO billingPO, CustomCompany company){
		this.billingId = billingPO.getBillingId();
		this.hordingId = billingPO.getHordingId();
		this.poNumber = Billing_POLocalServiceUtil.getPONumber(billingPO, company);
		this.financialYear = billingPO.getFinancialYear();
		this.totalAmount = billingPO.getTotalAmount();
		
		if(this.hordingId>0){
			try {
				Hording hording = HordingLocalServiceUtil.getHording(this.hordingId);
				this.hordingTitle = hording.getTitle();
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
	
	
}
