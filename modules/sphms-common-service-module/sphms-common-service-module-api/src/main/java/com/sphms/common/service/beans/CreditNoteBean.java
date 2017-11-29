package com.sphms.common.service.beans;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CreditNote;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.ClientLocalServiceUtil;

public class CreditNoteBean {
	
	Log _log = LogFactoryUtil.getLog(CreditNoteBean.class.getName());
	
	private long creditNoteId;
	private long clientId;
	private String clientName;
	private long billingId;
	private String billNo;
	private String creditNoteNumber;
	private double creditNoteAmount;
	private double creditNoteTax;
	private Date paymentDate;
	private String chequeNo;
	private String bankName;
	private String financialYear;
	private Date createDate;
	
	public CreditNoteBean(CreditNote creditNote){
		if(Validator.isNotNull(creditNote)){
			this.creditNoteId = creditNote.getCreditNoteId();
			this.clientId = creditNote.getClientId();
			this.billingId = creditNote.getBillingId();
			this.creditNoteNumber = creditNote.getCreditNoteNumber();
			this.creditNoteAmount = creditNote.getCreditNoteAmount();
			this.creditNoteTax =creditNote.getCreditNoteTax();
			this.paymentDate = creditNote.getPaymentDate();
			this.chequeNo = creditNote.getChequeNo();
			this.bankName = creditNote.getBankName();
			this.financialYear = creditNote.getFinancialYear();
			this.createDate = creditNote.getCreateDate();
			
			if(this.clientId>0){
				try {
					Client client = ClientLocalServiceUtil.getClient(this.clientId);
					this.clientName =client.getClientName();
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
			}
			
			if(this.billingId>0){
				try {
					Billing billing = BillingLocalServiceUtil.getBilling(this.billingId);
					this.billNo = billing.getBillNo();
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
			}
		}
	}
	
	
	
	public long getCreditNoteId() {
		return creditNoteId;
	}
	public void setCreditNoteId(long creditNoteId) {
		this.creditNoteId = creditNoteId;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public long getBillingId() {
		return billingId;
	}
	public void setBillingId(long billingId) {
		this.billingId = billingId;
	}
	public String getCreditNoteNumber() {
		return creditNoteNumber;
	}
	public void setCreditNoteNumber(String creditNoteNumber) {
		this.creditNoteNumber = creditNoteNumber;
	}
	public double getCreditNoteAmount() {
		return creditNoteAmount;
	}
	public void setCreditNoteAmount(double creditNoteAmount) {
		this.creditNoteAmount = creditNoteAmount;
	}
	public double getCreditNoteTax() {
		return creditNoteTax;
	}
	public void setCreditNoteTax(double creditNoteTax) {
		this.creditNoteTax = creditNoteTax;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String getClientName() {
		return clientName;
	}



	public void setClientName(String clientName) {
		this.clientName = clientName;
	}



	public String getBillNo() {
		return billNo;
	}



	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	
}
