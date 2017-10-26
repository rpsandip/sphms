package com.sphms.common.service.beans;

import java.util.Date;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;

public class BillingBean {
	
	Log _log = LogFactoryUtil.getLog(BillingBean.class.getName()); 
			
	
	private long billingId;
	private String billNo;
	private long bookingId;
	private long clientId;
	private String billDocumentURL;
	private String clientName;
	private String campaign;
	private String billFileURL;
	private long billFileEntryId;
	private String clientPANNo;
	private String clientPONumber;
	private String clientGSTNumber;
	private String display;
	private double accessAmount;
	private double pendingAmount;
	private String financialYear;
	private int status;
	private Date createDate;
	private Date bookingDate;
	private Date modifiedDate;
	private long createdBy;
	private long modifiedBy;
	
	public BillingBean(Billing billing){
		this.billingId = billing.getBillingId();
		this.billNo = billing.getBillNo();
		this.bookingId = billing.getBookingId();
		this.clientId = billing.getClientId();
		this.billFileEntryId = billing.getBillFileEntryId();
		this.clientPANNo = billing.getClientPANNo();
		this.clientPONumber = billing.getClientPONumber();
		this.clientGSTNumber = billing.getClientGSTNumber();
		this.display = billing.getDisplay();
		this.accessAmount = billing.getAccessAmount();
		this.pendingAmount = billing.getPendingAmount();
		this.financialYear = billing.getFinancialYear();
		this.status = billing.getStatus();
		this.createDate =billing.getCreateDate();
		this.createdBy = billing.getCreatedBy();
		this.modifiedDate = billing.getModifiedDate();
		this.modifiedBy = billing.getModifiedBy();
		
		if(this.clientId>0){
			try {
				Client client = ClientLocalServiceUtil.getClient(this.clientId);
				this.clientName = client.getClientName();
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		if(this.bookingId>0){
			try {
				Booking booking = BookingLocalServiceUtil.getBooking(this.bookingId);
				this.campaign = booking.getCampaignTitle();
				this.bookingDate = booking.getCreateDate();
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		if(this.billFileEntryId>0){
			try {
				DLFileEntry billFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(this.billFileEntryId);
				this.billDocumentURL = SPHMSCommonLocalServiceUtil.getDLFileURL(billFileEntry);
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
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getBillFileURL() {
		return billFileURL;
	}
	public void setBillFileURL(String billFileURL) {
		this.billFileURL = billFileURL;
	}
	public long getBillFileEntryId() {
		return billFileEntryId;
	}
	public void setBillFileEntryId(long billFileEntryId) {
		this.billFileEntryId = billFileEntryId;
	}
	public String getClientPANNo() {
		return clientPANNo;
	}
	public void setClientPANNo(String clientPANNo) {
		this.clientPANNo = clientPANNo;
	}
	public String getClientPONumber() {
		return clientPONumber;
	}
	public void setClientPONumber(String clientPONumber) {
		this.clientPONumber = clientPONumber;
	}
	public String getClientGSTNumber() {
		return clientGSTNumber;
	}
	public void setClientGSTNumber(String clientGSTNumber) {
		this.clientGSTNumber = clientGSTNumber;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public double getAccessAmount() {
		return accessAmount;
	}
	public void setAccessAmount(double accessAmount) {
		this.accessAmount = accessAmount;
	}
	public double getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBillDocumentURL() {
		return billDocumentURL;
	}
	public void setBillDocumentURL(String billDocumentURL) {
		this.billDocumentURL = billDocumentURL;
	}
	
}
