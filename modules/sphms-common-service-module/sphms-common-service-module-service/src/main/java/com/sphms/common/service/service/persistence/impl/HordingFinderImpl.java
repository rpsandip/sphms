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

import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.service.persistence.HordingFinder;

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
public class HordingFinderImpl extends HordingFinderBaseImpl implements HordingFinder {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.sphms.common.service.service.ReportsLocalServiceUtil} to access the reports local service.
	 */
	
	@SuppressWarnings("unchecked")
	public List<Object> findHordingsFilter(
		    long hordingId, String StartDate, String endDate) {

		    Session session = null;
		    try {
		        session = openSession();

		        String sql = getHordingsQuery(hordingId, StartDate, endDate);

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
	
	private String getHordingsQuery(long hordingId, String startDate, String endDate){
		String selectQuery="select h.title,h.city, bl.display, cl.clientName, h.size, bh.units,h.hordingType, bh.hordingBookingStartDate, bh.hordingBookingEndDate,h.pricePerMonth, bh.totalMountingCharge, bh.totalPrintingCharge, bh.totalHordingCharge";
		
		StringBuilder query=new StringBuilder(selectQuery + " FROM SPHMS_Hording h ");
		query.append("inner join SPHMS_Billing_Hording bh on bh.hordingid = h.hordingid");
		query.append(" inner join SPHMS_Billing bl on bl.billingId = bh.billingId ");
		query.append(" inner join SPHMS_Client cl on cl.clientId = bl.clientId ");
		
		query.append(" Where ");
		query.append(" h.hordingid ="+hordingId);
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			query.append(" and bh.hordingBookingStartDate between '"+startDate+ "' and '" +endDate + "' ");
		}
		
		return query.toString();
	}
	
	
}