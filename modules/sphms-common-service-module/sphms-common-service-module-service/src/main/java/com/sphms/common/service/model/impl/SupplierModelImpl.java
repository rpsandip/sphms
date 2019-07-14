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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.model.SupplierModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Supplier service. Represents a row in the &quot;SPHMS_Supplier&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link SupplierModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SupplierImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierImpl
 * @see Supplier
 * @see SupplierModel
 * @generated
 */
@ProviderType
public class SupplierModelImpl extends BaseModelImpl<Supplier>
	implements SupplierModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a supplier model instance should use the {@link Supplier} interface instead.
	 */
	public static final String TABLE_NAME = "SPHMS_Supplier";
	public static final Object[][] TABLE_COLUMNS = {
			{ "supplierId", Types.BIGINT },
			{ "supplierName", Types.VARCHAR },
			{ "address1", Types.VARCHAR },
			{ "address2", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "panNo", Types.VARCHAR },
			{ "gstNo", Types.VARCHAR },
			{ "state_", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "contactPersonName", Types.VARCHAR },
			{ "contactPersonEmail", Types.VARCHAR },
			{ "contactPersonPhoneNo", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "createdBy", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("supplierId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("supplierName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("panNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("gstNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("contactPersonName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonPhoneNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table SPHMS_Supplier (supplierId LONG not null primary key,supplierName VARCHAR(75) null,address1 VARCHAR(75) null,address2 VARCHAR(75) null,city VARCHAR(75) null,panNo VARCHAR(75) null,gstNo VARCHAR(75) null,state_ VARCHAR(75) null,status INTEGER,contactPersonName VARCHAR(75) null,contactPersonEmail VARCHAR(75) null,contactPersonPhoneNo VARCHAR(75) null,createDate DATE null,createdBy LONG)";
	public static final String TABLE_SQL_DROP = "drop table SPHMS_Supplier";
	public static final String ORDER_BY_JPQL = " ORDER BY supplier.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SPHMS_Supplier.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.sphms.common.service.model.Supplier"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.sphms.common.service.model.Supplier"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.sphms.common.service.model.Supplier"),
			true);
	public static final long STATUS_COLUMN_BITMASK = 1L;
	public static final long CREATEDATE_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.sphms.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.sphms.common.service.model.Supplier"));

	public SupplierModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _supplierId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSupplierId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supplierId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Supplier.class;
	}

	@Override
	public String getModelClassName() {
		return Supplier.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplierId", getSupplierId());
		attributes.put("supplierName", getSupplierName());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("panNo", getPanNo());
		attributes.put("gstNo", getGstNo());
		attributes.put("state", getState());
		attributes.put("status", getStatus());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonEmail", getContactPersonEmail());
		attributes.put("contactPersonPhoneNo", getContactPersonPhoneNo());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supplierId = (Long)attributes.get("supplierId");

		if (supplierId != null) {
			setSupplierId(supplierId);
		}

		String supplierName = (String)attributes.get("supplierName");

		if (supplierName != null) {
			setSupplierName(supplierName);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String panNo = (String)attributes.get("panNo");

		if (panNo != null) {
			setPanNo(panNo);
		}

		String gstNo = (String)attributes.get("gstNo");

		if (gstNo != null) {
			setGstNo(gstNo);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonEmail = (String)attributes.get("contactPersonEmail");

		if (contactPersonEmail != null) {
			setContactPersonEmail(contactPersonEmail);
		}

		String contactPersonPhoneNo = (String)attributes.get(
				"contactPersonPhoneNo");

		if (contactPersonPhoneNo != null) {
			setContactPersonPhoneNo(contactPersonPhoneNo);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
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
	public String getSupplierName() {
		if (_supplierName == null) {
			return StringPool.BLANK;
		}
		else {
			return _supplierName;
		}
	}

	@Override
	public void setSupplierName(String supplierName) {
		_supplierName = supplierName;
	}

	@Override
	public String getAddress1() {
		if (_address1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _address1;
		}
	}

	@Override
	public void setAddress1(String address1) {
		_address1 = address1;
	}

	@Override
	public String getAddress2() {
		if (_address2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _address2;
		}
	}

	@Override
	public void setAddress2(String address2) {
		_address2 = address2;
	}

	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@Override
	public String getPanNo() {
		if (_panNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _panNo;
		}
	}

	@Override
	public void setPanNo(String panNo) {
		_panNo = panNo;
	}

	@Override
	public String getGstNo() {
		if (_gstNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _gstNo;
		}
	}

	@Override
	public void setGstNo(String gstNo) {
		_gstNo = gstNo;
	}

	@Override
	public String getState() {
		if (_state == null) {
			return StringPool.BLANK;
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public String getContactPersonName() {
		if (_contactPersonName == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactPersonName;
		}
	}

	@Override
	public void setContactPersonName(String contactPersonName) {
		_contactPersonName = contactPersonName;
	}

	@Override
	public String getContactPersonEmail() {
		if (_contactPersonEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactPersonEmail;
		}
	}

	@Override
	public void setContactPersonEmail(String contactPersonEmail) {
		_contactPersonEmail = contactPersonEmail;
	}

	@Override
	public String getContactPersonPhoneNo() {
		if (_contactPersonPhoneNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactPersonPhoneNo;
		}
	}

	@Override
	public void setContactPersonPhoneNo(String contactPersonPhoneNo) {
		_contactPersonPhoneNo = contactPersonPhoneNo;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Supplier.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Supplier toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Supplier)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SupplierImpl supplierImpl = new SupplierImpl();

		supplierImpl.setSupplierId(getSupplierId());
		supplierImpl.setSupplierName(getSupplierName());
		supplierImpl.setAddress1(getAddress1());
		supplierImpl.setAddress2(getAddress2());
		supplierImpl.setCity(getCity());
		supplierImpl.setPanNo(getPanNo());
		supplierImpl.setGstNo(getGstNo());
		supplierImpl.setState(getState());
		supplierImpl.setStatus(getStatus());
		supplierImpl.setContactPersonName(getContactPersonName());
		supplierImpl.setContactPersonEmail(getContactPersonEmail());
		supplierImpl.setContactPersonPhoneNo(getContactPersonPhoneNo());
		supplierImpl.setCreateDate(getCreateDate());
		supplierImpl.setCreatedBy(getCreatedBy());

		supplierImpl.resetOriginalValues();

		return supplierImpl;
	}

	@Override
	public int compareTo(Supplier supplier) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), supplier.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Supplier)) {
			return false;
		}

		Supplier supplier = (Supplier)obj;

		long primaryKey = supplier.getPrimaryKey();

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
		SupplierModelImpl supplierModelImpl = this;

		supplierModelImpl._originalStatus = supplierModelImpl._status;

		supplierModelImpl._setOriginalStatus = false;

		supplierModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Supplier> toCacheModel() {
		SupplierCacheModel supplierCacheModel = new SupplierCacheModel();

		supplierCacheModel.supplierId = getSupplierId();

		supplierCacheModel.supplierName = getSupplierName();

		String supplierName = supplierCacheModel.supplierName;

		if ((supplierName != null) && (supplierName.length() == 0)) {
			supplierCacheModel.supplierName = null;
		}

		supplierCacheModel.address1 = getAddress1();

		String address1 = supplierCacheModel.address1;

		if ((address1 != null) && (address1.length() == 0)) {
			supplierCacheModel.address1 = null;
		}

		supplierCacheModel.address2 = getAddress2();

		String address2 = supplierCacheModel.address2;

		if ((address2 != null) && (address2.length() == 0)) {
			supplierCacheModel.address2 = null;
		}

		supplierCacheModel.city = getCity();

		String city = supplierCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			supplierCacheModel.city = null;
		}

		supplierCacheModel.panNo = getPanNo();

		String panNo = supplierCacheModel.panNo;

		if ((panNo != null) && (panNo.length() == 0)) {
			supplierCacheModel.panNo = null;
		}

		supplierCacheModel.gstNo = getGstNo();

		String gstNo = supplierCacheModel.gstNo;

		if ((gstNo != null) && (gstNo.length() == 0)) {
			supplierCacheModel.gstNo = null;
		}

		supplierCacheModel.state = getState();

		String state = supplierCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			supplierCacheModel.state = null;
		}

		supplierCacheModel.status = getStatus();

		supplierCacheModel.contactPersonName = getContactPersonName();

		String contactPersonName = supplierCacheModel.contactPersonName;

		if ((contactPersonName != null) && (contactPersonName.length() == 0)) {
			supplierCacheModel.contactPersonName = null;
		}

		supplierCacheModel.contactPersonEmail = getContactPersonEmail();

		String contactPersonEmail = supplierCacheModel.contactPersonEmail;

		if ((contactPersonEmail != null) && (contactPersonEmail.length() == 0)) {
			supplierCacheModel.contactPersonEmail = null;
		}

		supplierCacheModel.contactPersonPhoneNo = getContactPersonPhoneNo();

		String contactPersonPhoneNo = supplierCacheModel.contactPersonPhoneNo;

		if ((contactPersonPhoneNo != null) &&
				(contactPersonPhoneNo.length() == 0)) {
			supplierCacheModel.contactPersonPhoneNo = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			supplierCacheModel.createDate = createDate.getTime();
		}
		else {
			supplierCacheModel.createDate = Long.MIN_VALUE;
		}

		supplierCacheModel.createdBy = getCreatedBy();

		return supplierCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{supplierId=");
		sb.append(getSupplierId());
		sb.append(", supplierName=");
		sb.append(getSupplierName());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", panNo=");
		sb.append(getPanNo());
		sb.append(", gstNo=");
		sb.append(getGstNo());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", contactPersonName=");
		sb.append(getContactPersonName());
		sb.append(", contactPersonEmail=");
		sb.append(getContactPersonEmail());
		sb.append(", contactPersonPhoneNo=");
		sb.append(getContactPersonPhoneNo());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sphms.common.service.model.Supplier");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>supplierId</column-name><column-value><![CDATA[");
		sb.append(getSupplierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplierName</column-name><column-value><![CDATA[");
		sb.append(getSupplierName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address2</column-name><column-value><![CDATA[");
		sb.append(getAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>panNo</column-name><column-value><![CDATA[");
		sb.append(getPanNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gstNo</column-name><column-value><![CDATA[");
		sb.append(getGstNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonName</column-name><column-value><![CDATA[");
		sb.append(getContactPersonName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonEmail</column-name><column-value><![CDATA[");
		sb.append(getContactPersonEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonPhoneNo</column-name><column-value><![CDATA[");
		sb.append(getContactPersonPhoneNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Supplier.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Supplier.class
		};
	private long _supplierId;
	private String _supplierName;
	private String _address1;
	private String _address2;
	private String _city;
	private String _panNo;
	private String _gstNo;
	private String _state;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private String _contactPersonName;
	private String _contactPersonEmail;
	private String _contactPersonPhoneNo;
	private Date _createDate;
	private long _createdBy;
	private long _columnBitmask;
	private Supplier _escapedModel;
}