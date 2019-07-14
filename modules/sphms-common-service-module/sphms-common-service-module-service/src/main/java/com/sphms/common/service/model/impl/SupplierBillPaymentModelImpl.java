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

import com.sphms.common.service.model.SupplierBillPayment;
import com.sphms.common.service.model.SupplierBillPaymentModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SupplierBillPayment service. Represents a row in the &quot;SPHMS_SupplierBillPayment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link SupplierBillPaymentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SupplierBillPaymentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPaymentImpl
 * @see SupplierBillPayment
 * @see SupplierBillPaymentModel
 * @generated
 */
@ProviderType
public class SupplierBillPaymentModelImpl extends BaseModelImpl<SupplierBillPayment>
	implements SupplierBillPaymentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a supplier bill payment model instance should use the {@link SupplierBillPayment} interface instead.
	 */
	public static final String TABLE_NAME = "SPHMS_SupplierBillPayment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "supplierBillPaymentId", Types.BIGINT },
			{ "supplierBillId", Types.BIGINT },
			{ "supplierId", Types.BIGINT },
			{ "amount", Types.DOUBLE },
			{ "gst", Types.DOUBLE },
			{ "chequeNo", Types.VARCHAR },
			{ "paymentDate", Types.TIMESTAMP },
			{ "createDate", Types.TIMESTAMP },
			{ "createdBy", Types.BIGINT },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "modifiedBy", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("supplierBillPaymentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("supplierBillId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("supplierId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("amount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("gst", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("chequeNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("paymentDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table SPHMS_SupplierBillPayment (supplierBillPaymentId LONG not null primary key,supplierBillId LONG,supplierId LONG,amount DOUBLE,gst DOUBLE,chequeNo VARCHAR(75) null,paymentDate DATE null,createDate DATE null,createdBy LONG,modifiedDate DATE null,modifiedBy LONG)";
	public static final String TABLE_SQL_DROP = "drop table SPHMS_SupplierBillPayment";
	public static final String ORDER_BY_JPQL = " ORDER BY supplierBillPayment.supplierBillPaymentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPHMS_SupplierBillPayment.supplierBillPaymentId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.sphms.common.service.model.SupplierBillPayment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.sphms.common.service.model.SupplierBillPayment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.sphms.common.service.model.SupplierBillPayment"),
			true);
	public static final long SUPPLIERBILLID_COLUMN_BITMASK = 1L;
	public static final long SUPPLIERBILLPAYMENTID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.sphms.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.sphms.common.service.model.SupplierBillPayment"));

	public SupplierBillPaymentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _supplierBillPaymentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSupplierBillPaymentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supplierBillPaymentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SupplierBillPayment.class;
	}

	@Override
	public String getModelClassName() {
		return SupplierBillPayment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplierBillPaymentId", getSupplierBillPaymentId());
		attributes.put("supplierBillId", getSupplierBillId());
		attributes.put("supplierId", getSupplierId());
		attributes.put("amount", getAmount());
		attributes.put("gst", getGst());
		attributes.put("chequeNo", getChequeNo());
		attributes.put("paymentDate", getPaymentDate());
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
		Long supplierBillPaymentId = (Long)attributes.get(
				"supplierBillPaymentId");

		if (supplierBillPaymentId != null) {
			setSupplierBillPaymentId(supplierBillPaymentId);
		}

		Long supplierBillId = (Long)attributes.get("supplierBillId");

		if (supplierBillId != null) {
			setSupplierBillId(supplierBillId);
		}

		Long supplierId = (Long)attributes.get("supplierId");

		if (supplierId != null) {
			setSupplierId(supplierId);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Double gst = (Double)attributes.get("gst");

		if (gst != null) {
			setGst(gst);
		}

		String chequeNo = (String)attributes.get("chequeNo");

		if (chequeNo != null) {
			setChequeNo(chequeNo);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
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
	public long getSupplierBillPaymentId() {
		return _supplierBillPaymentId;
	}

	@Override
	public void setSupplierBillPaymentId(long supplierBillPaymentId) {
		_supplierBillPaymentId = supplierBillPaymentId;
	}

	@Override
	public long getSupplierBillId() {
		return _supplierBillId;
	}

	@Override
	public void setSupplierBillId(long supplierBillId) {
		_columnBitmask |= SUPPLIERBILLID_COLUMN_BITMASK;

		if (!_setOriginalSupplierBillId) {
			_setOriginalSupplierBillId = true;

			_originalSupplierBillId = _supplierBillId;
		}

		_supplierBillId = supplierBillId;
	}

	public long getOriginalSupplierBillId() {
		return _originalSupplierBillId;
	}

	@Override
	public long getSupplierId() {
		return _supplierId;
	}

	@Override
	public void setSupplierId(long supplierId) {
		_supplierId = supplierId;
	}

	@Override
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;
	}

	@Override
	public double getGst() {
		return _gst;
	}

	@Override
	public void setGst(double gst) {
		_gst = gst;
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
	public Date getPaymentDate() {
		return _paymentDate;
	}

	@Override
	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
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
			SupplierBillPayment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SupplierBillPayment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SupplierBillPayment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SupplierBillPaymentImpl supplierBillPaymentImpl = new SupplierBillPaymentImpl();

		supplierBillPaymentImpl.setSupplierBillPaymentId(getSupplierBillPaymentId());
		supplierBillPaymentImpl.setSupplierBillId(getSupplierBillId());
		supplierBillPaymentImpl.setSupplierId(getSupplierId());
		supplierBillPaymentImpl.setAmount(getAmount());
		supplierBillPaymentImpl.setGst(getGst());
		supplierBillPaymentImpl.setChequeNo(getChequeNo());
		supplierBillPaymentImpl.setPaymentDate(getPaymentDate());
		supplierBillPaymentImpl.setCreateDate(getCreateDate());
		supplierBillPaymentImpl.setCreatedBy(getCreatedBy());
		supplierBillPaymentImpl.setModifiedDate(getModifiedDate());
		supplierBillPaymentImpl.setModifiedBy(getModifiedBy());

		supplierBillPaymentImpl.resetOriginalValues();

		return supplierBillPaymentImpl;
	}

	@Override
	public int compareTo(SupplierBillPayment supplierBillPayment) {
		long primaryKey = supplierBillPayment.getPrimaryKey();

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

		if (!(obj instanceof SupplierBillPayment)) {
			return false;
		}

		SupplierBillPayment supplierBillPayment = (SupplierBillPayment)obj;

		long primaryKey = supplierBillPayment.getPrimaryKey();

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
		SupplierBillPaymentModelImpl supplierBillPaymentModelImpl = this;

		supplierBillPaymentModelImpl._originalSupplierBillId = supplierBillPaymentModelImpl._supplierBillId;

		supplierBillPaymentModelImpl._setOriginalSupplierBillId = false;

		supplierBillPaymentModelImpl._setModifiedDate = false;

		supplierBillPaymentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SupplierBillPayment> toCacheModel() {
		SupplierBillPaymentCacheModel supplierBillPaymentCacheModel = new SupplierBillPaymentCacheModel();

		supplierBillPaymentCacheModel.supplierBillPaymentId = getSupplierBillPaymentId();

		supplierBillPaymentCacheModel.supplierBillId = getSupplierBillId();

		supplierBillPaymentCacheModel.supplierId = getSupplierId();

		supplierBillPaymentCacheModel.amount = getAmount();

		supplierBillPaymentCacheModel.gst = getGst();

		supplierBillPaymentCacheModel.chequeNo = getChequeNo();

		String chequeNo = supplierBillPaymentCacheModel.chequeNo;

		if ((chequeNo != null) && (chequeNo.length() == 0)) {
			supplierBillPaymentCacheModel.chequeNo = null;
		}

		Date paymentDate = getPaymentDate();

		if (paymentDate != null) {
			supplierBillPaymentCacheModel.paymentDate = paymentDate.getTime();
		}
		else {
			supplierBillPaymentCacheModel.paymentDate = Long.MIN_VALUE;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			supplierBillPaymentCacheModel.createDate = createDate.getTime();
		}
		else {
			supplierBillPaymentCacheModel.createDate = Long.MIN_VALUE;
		}

		supplierBillPaymentCacheModel.createdBy = getCreatedBy();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			supplierBillPaymentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			supplierBillPaymentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		supplierBillPaymentCacheModel.modifiedBy = getModifiedBy();

		return supplierBillPaymentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{supplierBillPaymentId=");
		sb.append(getSupplierBillPaymentId());
		sb.append(", supplierBillId=");
		sb.append(getSupplierBillId());
		sb.append(", supplierId=");
		sb.append(getSupplierId());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", gst=");
		sb.append(getGst());
		sb.append(", chequeNo=");
		sb.append(getChequeNo());
		sb.append(", paymentDate=");
		sb.append(getPaymentDate());
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
		sb.append("com.sphms.common.service.model.SupplierBillPayment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>supplierBillPaymentId</column-name><column-value><![CDATA[");
		sb.append(getSupplierBillPaymentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplierBillId</column-name><column-value><![CDATA[");
		sb.append(getSupplierBillId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplierId</column-name><column-value><![CDATA[");
		sb.append(getSupplierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gst</column-name><column-value><![CDATA[");
		sb.append(getGst());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chequeNo</column-name><column-value><![CDATA[");
		sb.append(getChequeNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentDate</column-name><column-value><![CDATA[");
		sb.append(getPaymentDate());
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

	private static final ClassLoader _classLoader = SupplierBillPayment.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			SupplierBillPayment.class
		};
	private long _supplierBillPaymentId;
	private long _supplierBillId;
	private long _originalSupplierBillId;
	private boolean _setOriginalSupplierBillId;
	private long _supplierId;
	private double _amount;
	private double _gst;
	private String _chequeNo;
	private Date _paymentDate;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _modifiedBy;
	private long _columnBitmask;
	private SupplierBillPayment _escapedModel;
}