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

package com.sphms.common.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sphms.common.service.model.Hording;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the hording service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.HordingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HordingPersistence
 * @see com.sphms.common.service.service.persistence.impl.HordingPersistenceImpl
 * @generated
 */
@ProviderType
public class HordingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Hording hording) {
		getPersistence().clearCache(hording);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Hording> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Hording> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Hording> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Hording> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Hording update(Hording hording) {
		return getPersistence().update(hording);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Hording update(Hording hording, ServiceContext serviceContext) {
		return getPersistence().update(hording, serviceContext);
	}

	/**
	* Returns all the hordings where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @return the matching hordings
	*/
	public static List<Hording> findBylandLordId(long landLordId, int status) {
		return getPersistence().findBylandLordId(landLordId, status);
	}

	/**
	* Returns a range of all the hordings where landLordId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @return the range of matching hordings
	*/
	public static List<Hording> findBylandLordId(long landLordId, int status,
		int start, int end) {
		return getPersistence().findBylandLordId(landLordId, status, start, end);
	}

	/**
	* Returns an ordered range of all the hordings where landLordId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching hordings
	*/
	public static List<Hording> findBylandLordId(long landLordId, int status,
		int start, int end, OrderByComparator<Hording> orderByComparator) {
		return getPersistence()
				   .findBylandLordId(landLordId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the hordings where landLordId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching hordings
	*/
	public static List<Hording> findBylandLordId(long landLordId, int status,
		int start, int end, OrderByComparator<Hording> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBylandLordId(landLordId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hording
	* @throws NoSuchHordingException if a matching hording could not be found
	*/
	public static Hording findBylandLordId_First(long landLordId, int status,
		OrderByComparator<Hording> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchHordingException {
		return getPersistence()
				   .findBylandLordId_First(landLordId, status, orderByComparator);
	}

	/**
	* Returns the first hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hording, or <code>null</code> if a matching hording could not be found
	*/
	public static Hording fetchBylandLordId_First(long landLordId, int status,
		OrderByComparator<Hording> orderByComparator) {
		return getPersistence()
				   .fetchBylandLordId_First(landLordId, status,
			orderByComparator);
	}

	/**
	* Returns the last hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hording
	* @throws NoSuchHordingException if a matching hording could not be found
	*/
	public static Hording findBylandLordId_Last(long landLordId, int status,
		OrderByComparator<Hording> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchHordingException {
		return getPersistence()
				   .findBylandLordId_Last(landLordId, status, orderByComparator);
	}

	/**
	* Returns the last hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hording, or <code>null</code> if a matching hording could not be found
	*/
	public static Hording fetchBylandLordId_Last(long landLordId, int status,
		OrderByComparator<Hording> orderByComparator) {
		return getPersistence()
				   .fetchBylandLordId_Last(landLordId, status, orderByComparator);
	}

	/**
	* Returns the hordings before and after the current hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param hordingId the primary key of the current hording
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hording
	* @throws NoSuchHordingException if a hording with the primary key could not be found
	*/
	public static Hording[] findBylandLordId_PrevAndNext(long hordingId,
		long landLordId, int status,
		OrderByComparator<Hording> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchHordingException {
		return getPersistence()
				   .findBylandLordId_PrevAndNext(hordingId, landLordId, status,
			orderByComparator);
	}

	/**
	* Removes all the hordings where landLordId = &#63; and status = &#63; from the database.
	*
	* @param landLordId the land lord ID
	* @param status the status
	*/
	public static void removeBylandLordId(long landLordId, int status) {
		getPersistence().removeBylandLordId(landLordId, status);
	}

	/**
	* Returns the number of hordings where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @return the number of matching hordings
	*/
	public static int countBylandLordId(long landLordId, int status) {
		return getPersistence().countBylandLordId(landLordId, status);
	}

	/**
	* Caches the hording in the entity cache if it is enabled.
	*
	* @param hording the hording
	*/
	public static void cacheResult(Hording hording) {
		getPersistence().cacheResult(hording);
	}

	/**
	* Caches the hordings in the entity cache if it is enabled.
	*
	* @param hordings the hordings
	*/
	public static void cacheResult(List<Hording> hordings) {
		getPersistence().cacheResult(hordings);
	}

	/**
	* Creates a new hording with the primary key. Does not add the hording to the database.
	*
	* @param hordingId the primary key for the new hording
	* @return the new hording
	*/
	public static Hording create(long hordingId) {
		return getPersistence().create(hordingId);
	}

	/**
	* Removes the hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hordingId the primary key of the hording
	* @return the hording that was removed
	* @throws NoSuchHordingException if a hording with the primary key could not be found
	*/
	public static Hording remove(long hordingId)
		throws com.sphms.common.service.exception.NoSuchHordingException {
		return getPersistence().remove(hordingId);
	}

	public static Hording updateImpl(Hording hording) {
		return getPersistence().updateImpl(hording);
	}

	/**
	* Returns the hording with the primary key or throws a {@link NoSuchHordingException} if it could not be found.
	*
	* @param hordingId the primary key of the hording
	* @return the hording
	* @throws NoSuchHordingException if a hording with the primary key could not be found
	*/
	public static Hording findByPrimaryKey(long hordingId)
		throws com.sphms.common.service.exception.NoSuchHordingException {
		return getPersistence().findByPrimaryKey(hordingId);
	}

	/**
	* Returns the hording with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hordingId the primary key of the hording
	* @return the hording, or <code>null</code> if a hording with the primary key could not be found
	*/
	public static Hording fetchByPrimaryKey(long hordingId) {
		return getPersistence().fetchByPrimaryKey(hordingId);
	}

	public static java.util.Map<java.io.Serializable, Hording> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the hordings.
	*
	* @return the hordings
	*/
	public static List<Hording> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @return the range of hordings
	*/
	public static List<Hording> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hordings
	*/
	public static List<Hording> findAll(int start, int end,
		OrderByComparator<Hording> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of hordings
	*/
	public static List<Hording> findAll(int start, int end,
		OrderByComparator<Hording> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the hordings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of hordings.
	*
	* @return the number of hordings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static HordingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HordingPersistence, HordingPersistence> _serviceTracker =
		ServiceTrackerFactory.open(HordingPersistence.class);
}