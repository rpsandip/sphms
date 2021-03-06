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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.Billing_HordingModel;
import com.sphms.common.service.service.persistence.Billing_HordingPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Billing_Hording service. Represents a row in the &quot;SPHMS_Billing_Hording&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link Billing_HordingModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Billing_HordingImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_HordingImpl
 * @see Billing_Hording
 * @see Billing_HordingModel
 * @generated
 */
@ProviderType
public class Billing_HordingModelImpl extends BaseModelImpl<Billing_Hording>
	implements Billing_HordingModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a billing_ hording model instance should use the {@link Billing_Hording} interface instead.
	 */
	public static final String TABLE_NAME = "SPHMS_Billing_Hording";
	public static final Object[][] TABLE_COLUMNS = {
			{ "billingId", Types.BIGINT },
			{ "hordingId", Types.BIGINT },
			{ "totalMountingCharge", Types.DOUBLE },
			{ "totalPrintingCharge", Types.DOUBLE },
			{ "units", Types.INTEGER },
			{ "totalHordingCharge", Types.DOUBLE },
			{ "hsnNo", Types.VARCHAR },
			{ "hordingBookingStartDate", Types.TIMESTAMP },
			{ "hordingBookingEndDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("billingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("hordingId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalMountingCharge", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("totalPrintingCharge", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("units", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("totalHordingCharge", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("hsnNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("hordingBookingStartDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("hordingBookingEndDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table SPHMS_Billing_Hording (billingId LONG not null,hordingId LONG not null,totalMountingCharge DOUBLE,totalPrintingCharge DOUBLE,units INTEGER,totalHordingCharge DOUBLE,hsnNo VARCHAR(75) null,hordingBookingStartDate DATE null,hordingBookingEndDate DATE null,primary key (billingId, hordingId))";
	public static final String TABLE_SQL_DROP = "drop table SPHMS_Billing_Hording";
	public static final String ORDER_BY_JPQL = " ORDER BY billing_Hording.id.billingId ASC, billing_Hording.id.hordingId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPHMS_Billing_Hording.billingId ASC, SPHMS_Billing_Hording.hordingId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.sphms.common.service.model.Billing_Hording"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.sphms.common.service.model.Billing_Hording"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.sphms.common.service.model.Billing_Hording"),
			true);
	public static final long BILLINGID_COLUMN_BITMASK = 1L;
	public static final long HORDINGID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.sphms.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.sphms.common.service.model.Billing_Hording"));

	public Billing_HordingModelImpl() {
	}

	@Override
	public Billing_HordingPK getPrimaryKey() {
		return new Billing_HordingPK(_billingId, _hordingId);
	}

	@Override
	public void setPrimaryKey(Billing_HordingPK primaryKey) {
		setBillingId(primaryKey.billingId);
		setHordingId(primaryKey.hordingId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new Billing_HordingPK(_billingId, _hordingId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((Billing_HordingPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Billing_Hording.class;
	}

	@Override
	public String getModelClassName() {
		return Billing_Hording.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("billingId", getBillingId());
		attributes.put("hordingId", getHordingId());
		attributes.put("totalMountingCharge", getTotalMountingCharge());
		attributes.put("totalPrintingCharge", getTotalPrintingCharge());
		attributes.put("units", getUnits());
		attributes.put("totalHordingCharge", getTotalHordingCharge());
		attributes.put("hsnNo", getHsnNo());
		attributes.put("hordingBookingStartDate", getHordingBookingStartDate());
		attributes.put("hordingBookingEndDate", getHordingBookingEndDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long billingId = (Long)attributes.get("billingId");

		if (billingId != null) {
			setBillingId(billingId);
		}

		Long hordingId = (Long)attributes.get("hordingId");

		if (hordingId != null) {
			setHordingId(hordingId);
		}

		Double totalMountingCharge = (Double)attributes.get(
				"totalMountingCharge");

		if (totalMountingCharge != null) {
			setTotalMountingCharge(totalMountingCharge);
		}

		Double totalPrintingCharge = (Double)attributes.get(
				"totalPrintingCharge");

		if (totalPrintingCharge != null) {
			setTotalPrintingCharge(totalPrintingCharge);
		}

		Integer units = (Integer)attributes.get("units");

		if (units != null) {
			setUnits(units);
		}

		Double totalHordingCharge = (Double)attributes.get("totalHordingCharge");

		if (totalHordingCharge != null) {
			setTotalHordingCharge(totalHordingCharge);
		}

		String hsnNo = (String)attributes.get("hsnNo");

		if (hsnNo != null) {
			setHsnNo(hsnNo);
		}

		Date hordingBookingStartDate = (Date)attributes.get(
				"hordingBookingStartDate");

		if (hordingBookingStartDate != null) {
			setHordingBookingStartDate(hordingBookingStartDate);
		}

		Date hordingBookingEndDate = (Date)attributes.get(
				"hordingBookingEndDate");

		if (hordingBookingEndDate != null) {
			setHordingBookingEndDate(hordingBookingEndDate);
		}
	}

	@Override
	public long getBillingId() {
		return _billingId;
	}

	@Override
	public void setBillingId(long billingId) {
		_columnBitmask |= BILLINGID_COLUMN_BITMASK;

		if (!_setOriginalBillingId) {
			_setOriginalBillingId = true;

			_originalBillingId = _billingId;
		}

		_billingId = billingId;
	}

	public long getOriginalBillingId() {
		return _originalBillingId;
	}

	@Override
	public long getHordingId() {
		return _hordingId;
	}

	@Override
	public void setHordingId(long hordingId) {
		_columnBitmask |= HORDINGID_COLUMN_BITMASK;

		if (!_setOriginalHordingId) {
			_setOriginalHordingId = true;

			_originalHordingId = _hordingId;
		}

		_hordingId = hordingId;
	}

	public long getOriginalHordingId() {
		return _originalHordingId;
	}

	@Override
	public double getTotalMountingCharge() {
		return _totalMountingCharge;
	}

	@Override
	public void setTotalMountingCharge(double totalMountingCharge) {
		_totalMountingCharge = totalMountingCharge;
	}

	@Override
	public double getTotalPrintingCharge() {
		return _totalPrintingCharge;
	}

	@Override
	public void setTotalPrintingCharge(double totalPrintingCharge) {
		_totalPrintingCharge = totalPrintingCharge;
	}

	@Override
	public int getUnits() {
		return _units;
	}

	@Override
	public void setUnits(int units) {
		_units = units;
	}

	@Override
	public double getTotalHordingCharge() {
		return _totalHordingCharge;
	}

	@Override
	public void setTotalHordingCharge(double totalHordingCharge) {
		_totalHordingCharge = totalHordingCharge;
	}

	@Override
	public String getHsnNo() {
		if (_hsnNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _hsnNo;
		}
	}

	@Override
	public void setHsnNo(String hsnNo) {
		_hsnNo = hsnNo;
	}

	@Override
	public Date getHordingBookingStartDate() {
		return _hordingBookingStartDate;
	}

	@Override
	public void setHordingBookingStartDate(Date hordingBookingStartDate) {
		_hordingBookingStartDate = hordingBookingStartDate;
	}

	@Override
	public Date getHordingBookingEndDate() {
		return _hordingBookingEndDate;
	}

	@Override
	public void setHordingBookingEndDate(Date hordingBookingEndDate) {
		_hordingBookingEndDate = hordingBookingEndDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Billing_Hording toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Billing_Hording)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Billing_HordingImpl billing_HordingImpl = new Billing_HordingImpl();

		billing_HordingImpl.setBillingId(getBillingId());
		billing_HordingImpl.setHordingId(getHordingId());
		billing_HordingImpl.setTotalMountingCharge(getTotalMountingCharge());
		billing_HordingImpl.setTotalPrintingCharge(getTotalPrintingCharge());
		billing_HordingImpl.setUnits(getUnits());
		billing_HordingImpl.setTotalHordingCharge(getTotalHordingCharge());
		billing_HordingImpl.setHsnNo(getHsnNo());
		billing_HordingImpl.setHordingBookingStartDate(getHordingBookingStartDate());
		billing_HordingImpl.setHordingBookingEndDate(getHordingBookingEndDate());

		billing_HordingImpl.resetOriginalValues();

		return billing_HordingImpl;
	}

	@Override
	public int compareTo(Billing_Hording billing_Hording) {
		Billing_HordingPK primaryKey = billing_Hording.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Billing_Hording)) {
			return false;
		}

		Billing_Hording billing_Hording = (Billing_Hording)obj;

		Billing_HordingPK primaryKey = billing_Hording.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		Billing_HordingModelImpl billing_HordingModelImpl = this;

		billing_HordingModelImpl._originalBillingId = billing_HordingModelImpl._billingId;

		billing_HordingModelImpl._setOriginalBillingId = false;

		billing_HordingModelImpl._originalHordingId = billing_HordingModelImpl._hordingId;

		billing_HordingModelImpl._setOriginalHordingId = false;

		billing_HordingModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Billing_Hording> toCacheModel() {
		Billing_HordingCacheModel billing_HordingCacheModel = new Billing_HordingCacheModel();

		billing_HordingCacheModel.billing_HordingPK = getPrimaryKey();

		billing_HordingCacheModel.billingId = getBillingId();

		billing_HordingCacheModel.hordingId = getHordingId();

		billing_HordingCacheModel.totalMountingCharge = getTotalMountingCharge();

		billing_HordingCacheModel.totalPrintingCharge = getTotalPrintingCharge();

		billing_HordingCacheModel.units = getUnits();

		billing_HordingCacheModel.totalHordingCharge = getTotalHordingCharge();

		billing_HordingCacheModel.hsnNo = getHsnNo();

		String hsnNo = billing_HordingCacheModel.hsnNo;

		if ((hsnNo != null) && (hsnNo.length() == 0)) {
			billing_HordingCacheModel.hsnNo = null;
		}

		Date hordingBookingStartDate = getHordingBookingStartDate();

		if (hordingBookingStartDate != null) {
			billing_HordingCacheModel.hordingBookingStartDate = hordingBookingStartDate.getTime();
		}
		else {
			billing_HordingCacheModel.hordingBookingStartDate = Long.MIN_VALUE;
		}

		Date hordingBookingEndDate = getHordingBookingEndDate();

		if (hordingBookingEndDate != null) {
			billing_HordingCacheModel.hordingBookingEndDate = hordingBookingEndDate.getTime();
		}
		else {
			billing_HordingCacheModel.hordingBookingEndDate = Long.MIN_VALUE;
		}

		return billing_HordingCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{billingId=");
		sb.append(getBillingId());
		sb.append(", hordingId=");
		sb.append(getHordingId());
		sb.append(", totalMountingCharge=");
		sb.append(getTotalMountingCharge());
		sb.append(", totalPrintingCharge=");
		sb.append(getTotalPrintingCharge());
		sb.append(", units=");
		sb.append(getUnits());
		sb.append(", totalHordingCharge=");
		sb.append(getTotalHordingCharge());
		sb.append(", hsnNo=");
		sb.append(getHsnNo());
		sb.append(", hordingBookingStartDate=");
		sb.append(getHordingBookingStartDate());
		sb.append(", hordingBookingEndDate=");
		sb.append(getHordingBookingEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sphms.common.service.model.Billing_Hording");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>billingId</column-name><column-value><![CDATA[");
		sb.append(getBillingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hordingId</column-name><column-value><![CDATA[");
		sb.append(getHordingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalMountingCharge</column-name><column-value><![CDATA[");
		sb.append(getTotalMountingCharge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalPrintingCharge</column-name><column-value><![CDATA[");
		sb.append(getTotalPrintingCharge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>units</column-name><column-value><![CDATA[");
		sb.append(getUnits());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalHordingCharge</column-name><column-value><![CDATA[");
		sb.append(getTotalHordingCharge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hsnNo</column-name><column-value><![CDATA[");
		sb.append(getHsnNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hordingBookingStartDate</column-name><column-value><![CDATA[");
		sb.append(getHordingBookingStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hordingBookingEndDate</column-name><column-value><![CDATA[");
		sb.append(getHordingBookingEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Billing_Hording.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Billing_Hording.class
		};
	private long _billingId;
	private long _originalBillingId;
	private boolean _setOriginalBillingId;
	private long _hordingId;
	private long _originalHordingId;
	private boolean _setOriginalHordingId;
	private double _totalMountingCharge;
	private double _totalPrintingCharge;
	private int _units;
	private double _totalHordingCharge;
	private String _hsnNo;
	private Date _hordingBookingStartDate;
	private Date _hordingBookingEndDate;
	private long _columnBitmask;
	private Billing_Hording _escapedModel;
}