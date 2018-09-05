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

package com.sphms.common.service.service.persistence.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.sphms.common.service.service.persistence.LandLordFinder;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the reports local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.ReportsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportsLocalServiceBaseImpl
 * @see com.sphms.common.service.service.ReportsLocalServiceUtil
 */
@ProviderType
public class LandLordFinderImpl extends LandLordFinderBaseImpl implements LandLordFinder {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sphms.common.service.service.ReportsLocalServiceUtil} to access the reports local service.
	 */
	
	@SuppressWarnings("unchecked")
	public List<Object> findLandLoadDetailFilter(
		    long landLoadId, Date StartDate, Date endDate) {

		    Session session = null;
		    try {
		        session = openSession();

		        String sql = getLandLoadQuery(landLoadId, StartDate, endDate);

		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);
		      
		        return (List<Object>) q.list();
		    }
		    catch (Exception e) {
		       throw new SystemException(e);
		    }
		    finally {
		        closeSession(session);
		    }

		}
	
	private String getLandLoadQuery(long landLoadId,Date startDate,Date endDate){
		String selectQuery="select l.firstName, l.lastName, l.location, l.city, l.phoneNo, lp.amount, lp.chequeNo, lp.bankName, h.title, h.location, h.city";
		StringBuilder query=new StringBuilder(selectQuery + "FROM SPHMS_LandLord l");
		query.append("inner join SPHMS_LandLordPayment lp on l.landLordId=lp.landLoadId");
		query.append("inner join SPHMS_Hording h on lp.hordingId = h.hordingId");
		query.append("Where");
		query.append("l.landLordId"+landLoadId);
		query.append("and lp.paymentDate between"+startDate+ "and" +endDate);
		
		return selectQuery;
	}
	
	
}