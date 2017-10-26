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

import com.sphms.common.service.model.LandLord;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the land lord service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.LandLordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPersistence
 * @see com.sphms.common.service.service.persistence.impl.LandLordPersistenceImpl
 * @generated
 */
@ProviderType
public class LandLordUtil {
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
	public static void clearCache(LandLord landLord) {
		getPersistence().clearCache(landLord);
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
	public static List<LandLord> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LandLord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LandLord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LandLord> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LandLord update(LandLord landLord) {
		return getPersistence().update(landLord);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LandLord update(LandLord landLord,
		ServiceContext serviceContext) {
		return getPersistence().update(landLord, serviceContext);
	}

	/**
	* Caches the land lord in the entity cache if it is enabled.
	*
	* @param landLord the land lord
	*/
	public static void cacheResult(LandLord landLord) {
		getPersistence().cacheResult(landLord);
	}

	/**
	* Caches the land lords in the entity cache if it is enabled.
	*
	* @param landLords the land lords
	*/
	public static void cacheResult(List<LandLord> landLords) {
		getPersistence().cacheResult(landLords);
	}

	/**
	* Creates a new land lord with the primary key. Does not add the land lord to the database.
	*
	* @param landLordId the primary key for the new land lord
	* @return the new land lord
	*/
	public static LandLord create(long landLordId) {
		return getPersistence().create(landLordId);
	}

	/**
	* Removes the land lord with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordId the primary key of the land lord
	* @return the land lord that was removed
	* @throws NoSuchLandLordException if a land lord with the primary key could not be found
	*/
	public static LandLord remove(long landLordId)
		throws com.sphms.common.service.exception.NoSuchLandLordException {
		return getPersistence().remove(landLordId);
	}

	public static LandLord updateImpl(LandLord landLord) {
		return getPersistence().updateImpl(landLord);
	}

	/**
	* Returns the land lord with the primary key or throws a {@link NoSuchLandLordException} if it could not be found.
	*
	* @param landLordId the primary key of the land lord
	* @return the land lord
	* @throws NoSuchLandLordException if a land lord with the primary key could not be found
	*/
	public static LandLord findByPrimaryKey(long landLordId)
		throws com.sphms.common.service.exception.NoSuchLandLordException {
		return getPersistence().findByPrimaryKey(landLordId);
	}

	/**
	* Returns the land lord with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param landLordId the primary key of the land lord
	* @return the land lord, or <code>null</code> if a land lord with the primary key could not be found
	*/
	public static LandLord fetchByPrimaryKey(long landLordId) {
		return getPersistence().fetchByPrimaryKey(landLordId);
	}

	public static java.util.Map<java.io.Serializable, LandLord> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the land lords.
	*
	* @return the land lords
	*/
	public static List<LandLord> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the land lords.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lords
	* @param end the upper bound of the range of land lords (not inclusive)
	* @return the range of land lords
	*/
	public static List<LandLord> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the land lords.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lords
	* @param end the upper bound of the range of land lords (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of land lords
	*/
	public static List<LandLord> findAll(int start, int end,
		OrderByComparator<LandLord> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the land lords.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lords
	* @param end the upper bound of the range of land lords (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of land lords
	*/
	public static List<LandLord> findAll(int start, int end,
		OrderByComparator<LandLord> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the land lords from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of land lords.
	*
	* @return the number of land lords
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LandLordPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LandLordPersistence, LandLordPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LandLordPersistence.class);
}