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

package com.sphms.common.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.sphms.common.service.model.CreditNote;
import com.sphms.common.service.model.CreditNoteModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CreditNote service. Represents a row in the &quot;SPHMS_CreditNote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CreditNoteModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CreditNoteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CreditNoteImpl
 * @see CreditNote
 * @see CreditNoteModel
 * @generated
 */
@ProviderType
public class CreditNoteModelImpl extends BaseModelImpl<CreditNote>
	implements CreditNoteModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a credit note model instance should use the {@link CreditNote} interface instead.
	 */
	public static final String TABLE_NAME = "SPHMS_CreditNote";
	public static final Object[][] TABLE_COLUMNS = {
			{ "creditNoteId", Types.BIGINT },
			{ "clientId", Types.BIGINT },
			{ "creditNoteAmount", Types.DOUBLE },
			{ "creditNoteTax", Types.DOUBLE },
			{ "paymentDate", Types.TIMESTAMP },
			{ "chequeNo", Types.VARCHAR },
			{ "bankName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "createdBy", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "modifiedBy", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("creditNoteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("clientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("creditNoteAmount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("creditNoteTax", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("paymentDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("chequeNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bankName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table SPHMS_CreditNote (creditNoteId LONG not null primary key,clientId LONG,creditNoteAmount DOUBLE,creditNoteTax DOUBLE,paymentDate DATE null,chequeNo VARCHAR(75) null,bankName VARCHAR(75) null,createDate DATE null,createdBy LONG,modifiedDate DATE null,modifiedBy LONG)";
	public static final String TABLE_SQL_DROP = "drop table SPHMS_CreditNote";
	public static final String ORDER_BY_JPQL = " ORDER BY creditNote.creditNoteId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPHMS_CreditNote.creditNoteId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.sphms.common.service.model.CreditNote"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.sphms.common.service.model.CreditNote"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.sphms.common.service.model.CreditNote"),
			true);
	public static final long CLIENTID_COLUMN_BITMASK = 1L;
	public static final long CREDITNOTEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.sphms.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.sphms.common.service.model.CreditNote"));

	public CreditNoteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _creditNoteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCreditNoteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _creditNoteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("creditNoteAmount", getCreditNoteAmount());
		attributes.put("creditNoteTax", getCreditNoteTax());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("chequeNo", getChequeNo());
		attributes.put("bankName", getBankName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public long getCreditNoteId() {
		return _creditNoteId;
	}

	@Override
	public void setCreditNoteId(long creditNoteId) {
		_creditNoteId = creditNoteId;
	}

	@Override
	public long getClientId() {
		return _clientId;
	}

	@Override
	public void setClientId(long clientId) {
		_columnBitmask |= CLIENTID_COLUMN_BITMASK;

		if (!_setOriginalClientId) {
			_setOriginalClientId = true;

			_originalClientId = _clientId;
		}

		_clientId = clientId;
	}

	public long getOriginalClientId() {
		return _originalClientId;
	}

	@Override
	public double getCreditNoteAmount() {
		return _creditNoteAmount;
	}

	@Override
	public void setCreditNoteAmount(double creditNoteAmount) {
		_creditNoteAmount = creditNoteAmount;
	}

	@Override
	public double getCreditNoteTax() {
		return _creditNoteTax;
	}

	@Override
	public void setCreditNoteTax(double creditNoteTax) {
		_creditNoteTax = creditNoteTax;
	}

	@Override
	public Date getPaymentDate() {
		return _paymentDate;
	}

	@Override
	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
	}

	@Override
	public String getChequeNo() {
		if (_chequeNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _chequeNo;
		}
	}

	@Override
	public void setChequeNo(String chequeNo) {
		_chequeNo = chequeNo;
	}

	@Override
	public String getBankName() {
		if (_bankName == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankName;
		}
	}

	@Override
	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CreditNote.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CreditNote toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CreditNote)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CreditNoteImpl creditNoteImpl = new CreditNoteImpl();

		creditNoteImpl.setCreditNoteId(getCreditNoteId());
		creditNoteImpl.setClientId(getClientId());
		creditNoteImpl.setCreditNoteAmount(getCreditNoteAmount());
		creditNoteImpl.setCreditNoteTax(getCreditNoteTax());
		creditNoteImpl.setPaymentDate(getPaymentDate());
		creditNoteImpl.setChequeNo(getChequeNo());
		creditNoteImpl.setBankName(getBankName());
		creditNoteImpl.setCreateDate(getCreateDate());
		creditNoteImpl.setCreatedBy(getCreatedBy());
		creditNoteImpl.setModifiedDate(getModifiedDate());
		creditNoteImpl.setModifiedBy(getModifiedBy());

		creditNoteImpl.resetOriginalValues();

		return creditNoteImpl;
	}

	@Override
	public int compareTo(CreditNote creditNote) {
		long primaryKey = creditNote.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditNote)) {
			return false;
		}

		CreditNote creditNote = (CreditNote)obj;

		long primaryKey = creditNote.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CreditNoteModelImpl creditNoteModelImpl = this;

		creditNoteModelImpl._originalClientId = creditNoteModelImpl._clientId;

		creditNoteModelImpl._setOriginalClientId = false;

		creditNoteModelImpl._setModifiedDate = false;

		creditNoteModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CreditNote> toCacheModel() {
		CreditNoteCacheModel creditNoteCacheModel = new CreditNoteCacheModel();

		creditNoteCacheModel.creditNoteId = getCreditNoteId();

		creditNoteCacheModel.clientId = getClientId();

		creditNoteCacheModel.creditNoteAmount = getCreditNoteAmount();

		creditNoteCacheModel.creditNoteTax = getCreditNoteTax();

		Date paymentDate = getPaymentDate();

		if (paymentDate != null) {
			creditNoteCacheModel.paymentDate = paymentDate.getTime();
		}
		else {
			creditNoteCacheModel.paymentDate = Long.MIN_VALUE;
		}

		creditNoteCacheModel.chequeNo = getChequeNo();

		String chequeNo = creditNoteCacheModel.chequeNo;

		if ((chequeNo != null) && (chequeNo.length() == 0)) {
			creditNoteCacheModel.chequeNo = null;
		}

		creditNoteCacheModel.bankName = getBankName();

		String bankName = creditNoteCacheModel.bankName;

		if ((bankName != null) && (bankName.length() == 0)) {
			creditNoteCacheModel.bankName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			creditNoteCacheModel.createDate = createDate.getTime();
		}
		else {
			creditNoteCacheModel.createDate = Long.MIN_VALUE;
		}

		creditNoteCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			creditNoteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			creditNoteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		creditNoteCacheModel.modifiedBy = getModifiedBy();

		return creditNoteCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{creditNoteId=");
		sb.append(getCreditNoteId());
		sb.append(", clientId=");
		sb.append(getClientId());
		sb.append(", creditNoteAmount=");
		sb.append(getCreditNoteAmount());
		sb.append(", creditNoteTax=");
		sb.append(getCreditNoteTax());
		sb.append(", paymentDate=");
		sb.append(getPaymentDate());
		sb.append(", chequeNo=");
		sb.append(getChequeNo());
		sb.append(", bankName=");
		sb.append(getBankName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sphms.common.service.model.CreditNote");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>creditNoteId</column-name><column-value><![CDATA[");
		sb.append(getCreditNoteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clientId</column-name><column-value><![CDATA[");
		sb.append(getClientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditNoteAmount</column-name><column-value><![CDATA[");
		sb.append(getCreditNoteAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditNoteTax</column-name><column-value><![CDATA[");
		sb.append(getCreditNoteTax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentDate</column-name><column-value><![CDATA[");
		sb.append(getPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chequeNo</column-name><column-value><![CDATA[");
		sb.append(getChequeNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankName</column-name><column-value><![CDATA[");
		sb.append(getBankName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CreditNote.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CreditNote.class
		};
	private long _creditNoteId;
	private long _clientId;
	private long _originalClientId;
	private boolean _setOriginalClientId;
	private double _creditNoteAmount;
	private double _creditNoteTax;
	private Date _paymentDate;
	private String _chequeNo;
	private String _bankName;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private long _columnBitmask;
	private CreditNote _escapedModel;
}