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

import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.model.LandLordModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the LandLord service. Represents a row in the &quot;SPHMS_LandLord&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LandLordModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LandLordImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLordImpl
 * @see LandLord
 * @see LandLordModel
 * @generated
 */
@ProviderType
public class LandLordModelImpl extends BaseModelImpl<LandLord>
	implements LandLordModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a land lord model instance should use the {@link LandLord} interface instead.
	 */
	public static final String TABLE_NAME = "SPHMS_LandLord";
	public static final Object[][] TABLE_COLUMNS = {
			{ "landLordId", Types.BIGINT },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "location", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "phoneNo", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "createdBy", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("landLordId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("location", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("phoneNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createdBy", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table SPHMS_LandLord (landLordId LONG not null primary key,firstName VARCHAR(100) null,lastName VARCHAR(100) null,location VARCHAR(100) null,city VARCHAR(75) null,status INTEGER,phoneNo VARCHAR(75) null,createDate DATE null,createdBy LONG)";
	public static final String TABLE_SQL_DROP = "drop table SPHMS_LandLord";
	public static final String ORDER_BY_JPQL = " ORDER BY landLord.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SPHMS_LandLord.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.sphms.common.service.model.LandLord"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.sphms.common.service.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.sphms.common.service.model.LandLord"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.sphms.common.service.service.util.PropsUtil.get(
				"lock.expiration.time.com.sphms.common.service.model.LandLord"));

	public LandLordModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _landLordId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLandLordId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _landLordId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LandLord.class;
	}

	@Override
	public String getModelClassName() {
		return LandLord.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("landLordId", getLandLordId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("location", getLocation());
		attributes.put("city", getCity());
		attributes.put("status", getStatus());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long landLordId = (Long)attributes.get("landLordId");

		if (landLordId != null) {
			setLandLordId(landLordId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String phoneNo = (String)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
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
	public long getLandLordId() {
		return _landLordId;
	}

	@Override
	public void setLandLordId(long landLordId) {
		_landLordId = landLordId;
	}

	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@Override
	public String getLocation() {
		if (_location == null) {
			return StringPool.BLANK;
		}
		else {
			return _location;
		}
	}

	@Override
	public void setLocation(String location) {
		_location = location;
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
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public String getPhoneNo() {
		if (_phoneNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _phoneNo;
		}
	}

	@Override
	public void setPhoneNo(String phoneNo) {
		_phoneNo = phoneNo;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			LandLord.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LandLord toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LandLord)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LandLordImpl landLordImpl = new LandLordImpl();

		landLordImpl.setLandLordId(getLandLordId());
		landLordImpl.setFirstName(getFirstName());
		landLordImpl.setLastName(getLastName());
		landLordImpl.setLocation(getLocation());
		landLordImpl.setCity(getCity());
		landLordImpl.setStatus(getStatus());
		landLordImpl.setPhoneNo(getPhoneNo());
		landLordImpl.setCreateDate(getCreateDate());
		landLordImpl.setCreatedBy(getCreatedBy());

		landLordImpl.resetOriginalValues();

		return landLordImpl;
	}

	@Override
	public int compareTo(LandLord landLord) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), landLord.getCreateDate());

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

		if (!(obj instanceof LandLord)) {
			return false;
		}

		LandLord landLord = (LandLord)obj;

		long primaryKey = landLord.getPrimaryKey();

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
	}

	@Override
	public CacheModel<LandLord> toCacheModel() {
		LandLordCacheModel landLordCacheModel = new LandLordCacheModel();

		landLordCacheModel.landLordId = getLandLordId();

		landLordCacheModel.firstName = getFirstName();

		String firstName = landLordCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			landLordCacheModel.firstName = null;
		}

		landLordCacheModel.lastName = getLastName();

		String lastName = landLordCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			landLordCacheModel.lastName = null;
		}

		landLordCacheModel.location = getLocation();

		String location = landLordCacheModel.location;

		if ((location != null) && (location.length() == 0)) {
			landLordCacheModel.location = null;
		}

		landLordCacheModel.city = getCity();

		String city = landLordCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			landLordCacheModel.city = null;
		}

		landLordCacheModel.status = getStatus();

		landLordCacheModel.phoneNo = getPhoneNo();

		String phoneNo = landLordCacheModel.phoneNo;

		if ((phoneNo != null) && (phoneNo.length() == 0)) {
			landLordCacheModel.phoneNo = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			landLordCacheModel.createDate = createDate.getTime();
		}
		else {
			landLordCacheModel.createDate = Long.MIN_VALUE;
		}

		landLordCacheModel.createdBy = getCreatedBy();

		return landLordCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{landLordId=");
		sb.append(getLandLordId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", phoneNo=");
		sb.append(getPhoneNo());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sphms.common.service.model.LandLord");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>landLordId</column-name><column-value><![CDATA[");
		sb.append(getLandLordId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNo</column-name><column-value><![CDATA[");
		sb.append(getPhoneNo());
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

	private static final ClassLoader _classLoader = LandLord.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			LandLord.class
		};
	private long _landLordId;
	private String _firstName;
	private String _lastName;
	private String _location;
	private String _city;
	private int _status;
	private String _phoneNo;
	private Date _createDate;
	private long _createdBy;
	private LandLord _escapedModel;
}