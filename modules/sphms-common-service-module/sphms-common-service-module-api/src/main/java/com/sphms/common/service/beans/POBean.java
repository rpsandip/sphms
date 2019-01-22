package com.sphms.common.service.beans;

import java.util.List;

import com.sphms.common.service.beans.POHordingDTO;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.LandLord;

public class POBean {
	private long billingId;
	private long landlordId;
	private long hordingId;
	private String status;
	private String supplierBillNo;
	private String landLordName;
	private List<POHordingDTO> hordingList;
	private String financialYear;
	private String poNumber;
	private int poSortingNumber;
	private String supplierPaymentGiven;
	private String campaign;
	private double totalOutStanding;
	private double totalPaymentGiven;
	private long companyId;
	private LandLord landLoard;

	
	
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
	public List<POHordingDTO> getHordingList() {
		return hordingList;
	}
	public void setHordingList(List<POHordingDTO> hordingList) {
		this.hordingList = hordingList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSupplierBillNo() {
		return supplierBillNo;
	}
	public void setSupplierBillNo(String supplierBillNo) {
		this.supplierBillNo = supplierBillNo;
	}
	public String getSupplierPaymentGiven() {
		return supplierPaymentGiven;
	}
	public void setSupplierPaymentGiven(String supplierPaymentGiven) {
		this.supplierPaymentGiven = supplierPaymentGiven;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public double getTotalOutStanding() {
		return totalOutStanding;
	}
	public void setTotalOutStanding(double totalOutStanding) {
		this.totalOutStanding = totalOutStanding;
	}
	public double getTotalPaymentGiven() {
		return totalPaymentGiven;
	}
	public void setTotalPaymentGiven(double totalPaymentGiven) {
		this.totalPaymentGiven = totalPaymentGiven;
	}
	public int getPoSortingNumber() {
		return poSortingNumber;
	}
	public void setPoSortingNumber(int poSortingNumber) {
		this.poSortingNumber = poSortingNumber;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public LandLord getLandLoard() {
		return landLoard;
	}
	public void setLandLoard(LandLord landLoard) {
		this.landLoard = landLoard;
	}

	
	
	
	
	
}
