package com.sphms.portlet.portlet.util;

import java.util.List;

import com.sphms.common.service.model.Hording;

public class POBean {
	private long billingId;
	private long landlordId;
	private long hordingId;
	private String landLordName;
	private List<String> hordingList;
	private String financialYear;
	private String poNumber;
	public long getBillingId() {
		return billingId;
	}
	public void setBillingId(long billingId) {
		this.billingId = billingId;
	}
	public long getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(long landlordId) {
		this.landlordId = landlordId;
	}
	public String getLandLordName() {
		return landLordName;
	}
	public void setLandLordName(String landLordName) {
		this.landLordName = landLordName;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public long getHordingId() {
		return hordingId;
	}
	public void setHordingId(long hordingId) {
		this.hordingId = hordingId;
	}
	public List<String> getHordingList() {
		return hordingList;
	}
	public void setHordingList(List<String> hordingList) {
		this.hordingList = hordingList;
	}
	
}