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

package com.sphms.common.service.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.service.base.LandLordLocalServiceBaseImpl;

/**
 * The implementation of the land lord local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.LandLordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLordLocalServiceBaseImpl
 * @see com.sphms.common.service.service.LandLordLocalServiceUtil
 */
@ProviderType
public class LandLordLocalServiceImpl extends LandLordLocalServiceBaseImpl {
	
	/*
	 * Method for add Land Lord Detail
	 */
	public LandLord addLandLordDetail(String fName, String lName, String location, String city, String phoneNo, int status, long createdBy){
		
		boolean isValidParams = isValidParam(fName, lName, location, city, phoneNo);
		if(isValidParams){
			LandLord landLord = LandLordLocalServiceUtil.createLandLord(CounterLocalServiceUtil.increment());
			landLord.setFirstName(fName);
			landLord.setLastName(lName);
			landLord.setLocation(location);
			landLord.setCity(city);
			landLord.setStatus(status);
			landLord.setPhoneNo(phoneNo);
			landLord.setCreateDate(new Date());
			landLord.setCreatedBy(createdBy);
			landLord = LandLordLocalServiceUtil.addLandLord(landLord);
			return landLord;
		}else{
			return null;
		}
	}
	
	/*
	 * Method for update Land Lord
	 */
	public LandLord updateLandLord(long landLordId, String fName, String lName, String location, String city, String phoneNo, int status, long createdBy) throws PortalException{
		
		boolean isValidParams = isValidParam(fName, lName, location, city, phoneNo);
		
		if(isValidParams){
		LandLord landLord = LandLordLocalServiceUtil.getLandLord(landLordId);
		landLord.setFirstName(fName);
		landLord.setLastName(lName);
		landLord.setLocation(location);
		landLord.setCity(city);
		landLord.setPhoneNo(phoneNo);
		landLord.setStatus(status);
		landLord.setCreateDate(new Date());
		landLord.setCreatedBy(createdBy);
		landLord = LandLordLocalServiceUtil.updateLandLord(landLord);
		return landLord;
		}else{
			return null;
		}
		
	}
	
	/*
	 * Get all actove Land Lords
	 * @see com.sphms.common.service.service.LandLordLocalService#getActiveLandLords(int, int)
	 */
	public List<LandLord> getActiveLandLords(int start, int end){
		List<LandLord> landLordList = new ArrayList<LandLord>();
		DynamicQuery dynamicQuery = LandLordLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(0));
		dynamicQuery.setLimit(start, end);
		landLordList = LandLordLocalServiceUtil.dynamicQuery(dynamicQuery);
		return landLordList;
	}
	
	private boolean isValidParam (String fName, String lName, String location, String city, String phoneNo){
		boolean isValidParam = true;
		if(Validator.isNull(fName) || Validator.isNull(lName) || Validator.isNull(location) || Validator.isNull(city) || Validator.isNull(phoneNo)){
			isValidParam = false;
		}
		return isValidParam;
	}
}