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

package com.sphms.common.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CreditNote}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditNote
 * @generated
 */
@ProviderType
public class CreditNoteWrapper implements CreditNote, ModelWrapper<CreditNote> {
	public CreditNoteWrapper(CreditNote creditNote) {
		_creditNote = creditNote;
	}

	@Override
	public Class<?> getModelClass() {
		return CreditNote.class;
	}

	@Override
	public String getModelClassName() {
		return CreditNote.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("creditNoteId", getCreditNoteId());
		attributes.put("clientId", getClientId());
		attributes.put("billingId", getBillingId());
		attributes.put("creditNoteNumber", getCreditNoteNumber());
		attributes.put("creditNoteAmount", getCreditNoteAmount());
		attributes.put("creditNoteTax", getCreditNoteTax());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("chequeNo", getChequeNo());
		attributes.put("bankName", getBankName());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long creditNoteId = (Long)attributes.get("creditNoteId");

		if (creditNoteId != null) {
			setCreditNoteId(creditNoteId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		String creditNoteNumber = (String)attributes.get("creditNoteNumber");

		if (creditNoteNumber != null) {
			setCreditNoteNumber(creditNoteNumber);
		}

		Double creditNoteAmount = (Double)attributes.get("creditNoteAmount");

		if (creditNoteAmount != null) {
			setCreditNoteAmount(creditNoteAmount);
		}

		Double creditNoteTax = (Double)attributes.get("creditNoteTax");

		if (creditNoteTax != null) {
			setCreditNoteTax(creditNoteTax);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		String chequeNo = (String)attributes.get("chequeNo");

		if (chequeNo != null) {
			setChequeNo(chequeNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public CreditNote toEscapedModel() {
		return new CreditNoteWrapper(_creditNote.toEscapedModel());
	}

	@Override
	public CreditNote toUnescapedModel() {
		return new CreditNoteWrapper(_creditNote.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _creditNote.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _creditNote.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _creditNote.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _creditNote.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CreditNote> toCacheModel() {
		return _creditNote.toCacheModel();
	}

	/**
	* Returns the credit note amount of this credit note.
	*
	* @return the credit note amount of this credit note
	*/
	@Override
	public double getCreditNoteAmount() {
		return _creditNote.getCreditNoteAmount();
	}

	/**
	* Returns the credit note tax of this credit note.
	*
	* @return the credit note tax of this credit note
	*/
	@Override
	public double getCreditNoteTax() {
		return _creditNote.getCreditNoteTax();
	}

	@Override
	public int compareTo(CreditNote creditNote) {
		return _creditNote.compareTo(creditNote);
	}

	@Override
	public int hashCode() {
		return _creditNote.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _creditNote.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CreditNoteWrapper((CreditNote)_creditNote.clone());
	}

	/**
	* Returns the bank name of this credit note.
	*
	* @return the bank name of this credit note
	*/
	@Override
	public java.lang.String getBankName() {
		return _creditNote.getBankName();
	}

	/**
	* Returns the cheque no of this credit note.
	*
	* @return the cheque no of this credit note
	*/
	@Override
	public java.lang.String getChequeNo() {
		return _creditNote.getChequeNo();
	}

	/**
	* Returns the credit note number of this credit note.
	*
	* @return the credit note number of this credit note
	*/
	@Override
	public java.lang.String getCreditNoteNumber() {
		return _creditNote.getCreditNoteNumber();
	}

	/**
	* Returns the financial year of this credit note.
	*
	* @return the financial year of this credit note
	*/
	@Override
	public java.lang.String getFinancialYear() {
		return _creditNote.getFinancialYear();
	}

	@Override
	public java.lang.String toString() {
		return _creditNote.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _creditNote.toXmlString();
	}

	/**
	* Returns the create date of this credit note.
	*
	* @return the create date of this credit note
	*/
	@Override
	public Date getCreateDate() {
		return _creditNote.getCreateDate();
	}

	/**
	* Returns the modified date of this credit note.
	*
	* @return the modified date of this credit note
	*/
	@Override
	public Date getModifiedDate() {
		return _creditNote.getModifiedDate();
	}

	/**
	* Returns the payment date of this credit note.
	*
	* @return the payment date of this credit note
	*/
	@Override
	public Date getPaymentDate() {
		return _creditNote.getPaymentDate();
	}

	/**
	* Returns the billing ID of this credit note.
	*
	* @return the billing ID of this credit note
	*/
	@Override
	public long getBillingId() {
		return _creditNote.getBillingId();
	}

	/**
	* Returns the client ID of this credit note.
	*
	* @return the client ID of this credit note
	*/
	@Override
	public long getClientId() {
		return _creditNote.getClientId();
	}

	/**
	* Returns the created by of this credit note.
	*
	* @return the created by of this credit note
	*/
	@Override
	public long getCreatedBy() {
		return _creditNote.getCreatedBy();
	}

	/**
	* Returns the credit note ID of this credit note.
	*
	* @return the credit note ID of this credit note
	*/
	@Override
	public long getCreditNoteId() {
		return _creditNote.getCreditNoteId();
	}

	/**
	* Returns the modified by of this credit note.
	*
	* @return the modified by of this credit note
	*/
	@Override
	public long getModifiedBy() {
		return _creditNote.getModifiedBy();
	}

	/**
	* Returns the primary key of this credit note.
	*
	* @return the primary key of this credit note
	*/
	@Override
	public long getPrimaryKey() {
		return _creditNote.getPrimaryKey();
	}

	@Override
	public void persist() {
		_creditNote.persist();
	}

	/**
	* Sets the bank name of this credit note.
	*
	* @param bankName the bank name of this credit note
	*/
	@Override
	public void setBankName(java.lang.String bankName) {
		_creditNote.setBankName(bankName);
	}

	/**
	* Sets the billing ID of this credit note.
	*
	* @param billingId the billing ID of this credit note
	*/
	@Override
	public void setBillingId(long billingId) {
		_creditNote.setBillingId(billingId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_creditNote.setCachedModel(cachedModel);
	}

	/**
	* Sets the cheque no of this credit note.
	*
	* @param chequeNo the cheque no of this credit note
	*/
	@Override
	public void setChequeNo(java.lang.String chequeNo) {
		_creditNote.setChequeNo(chequeNo);
	}

	/**
	* Sets the client ID of this credit note.
	*
	* @param clientId the client ID of this credit note
	*/
	@Override
	public void setClientId(long clientId) {
		_creditNote.setClientId(clientId);
	}

	/**
	* Sets the create date of this credit note.
	*
	* @param createDate the create date of this credit note
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_creditNote.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this credit note.
	*
	* @param createdBy the created by of this credit note
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_creditNote.setCreatedBy(createdBy);
	}

	/**
	* Sets the credit note amount of this credit note.
	*
	* @param creditNoteAmount the credit note amount of this credit note
	*/
	@Override
	public void setCreditNoteAmount(double creditNoteAmount) {
		_creditNote.setCreditNoteAmount(creditNoteAmount);
	}

	/**
	* Sets the credit note ID of this credit note.
	*
	* @param creditNoteId the credit note ID of this credit note
	*/
	@Override
	public void setCreditNoteId(long creditNoteId) {
		_creditNote.setCreditNoteId(creditNoteId);
	}

	/**
	* Sets the credit note number of this credit note.
	*
	* @param creditNoteNumber the credit note number of this credit note
	*/
	@Override
	public void setCreditNoteNumber(java.lang.String creditNoteNumber) {
		_creditNote.setCreditNoteNumber(creditNoteNumber);
	}

	/**
	* Sets the credit note tax of this credit note.
	*
	* @param creditNoteTax the credit note tax of this credit note
	*/
	@Override
	public void setCreditNoteTax(double creditNoteTax) {
		_creditNote.setCreditNoteTax(creditNoteTax);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_creditNote.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_creditNote.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_creditNote.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the financial year of this credit note.
	*
	* @param financialYear the financial year of this credit note
	*/
	@Override
	public void setFinancialYear(java.lang.String financialYear) {
		_creditNote.setFinancialYear(financialYear);
	}

	/**
	* Sets the modified by of this credit note.
	*
	* @param modifiedBy the modified by of this credit note
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_creditNote.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this credit note.
	*
	* @param modifiedDate the modified date of this credit note
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_creditNote.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_creditNote.setNew(n);
	}

	/**
	* Sets the payment date of this credit note.
	*
	* @param paymentDate the payment date of this credit note
	*/
	@Override
	public void setPaymentDate(Date paymentDate) {
		_creditNote.setPaymentDate(paymentDate);
	}

	/**
	* Sets the primary key of this credit note.
	*
	* @param primaryKey the primary key of this credit note
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_creditNote.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_creditNote.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditNoteWrapper)) {
			return false;
		}

		CreditNoteWrapper creditNoteWrapper = (CreditNoteWrapper)obj;

		if (Objects.equals(_creditNote, creditNoteWrapper._creditNote)) {
			return true;
		}

		return false;
	}

	@Override
	public CreditNote getWrappedModel() {
		return _creditNote;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _creditNote.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _creditNote.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_creditNote.resetOriginalValues();
	}

	private final CreditNote _creditNote;
}