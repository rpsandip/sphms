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

import com.sphms.common.service.model.LandLordPayment;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the land lord payment service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.LandLordPaymentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPaymentPersistence
 * @see com.sphms.common.service.service.persistence.impl.LandLordPaymentPersistenceImpl
 * @generated
 */
@ProviderType
public class LandLordPaymentUtil {
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
	public static void clearCache(LandLordPayment landLordPayment) {
		getPersistence().clearCache(landLordPayment);
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
	public static List<LandLordPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LandLordPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LandLordPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LandLordPayment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LandLordPayment update(LandLordPayment landLordPayment) {
		return getPersistence().update(landLordPayment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LandLordPayment update(LandLordPayment landLordPayment,
		ServiceContext serviceContext) {
		return getPersistence().update(landLordPayment, serviceContext);
	}

	/**
	* Returns all the land lord payments where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @return the matching land lord payments
	*/
	public static List<LandLordPayment> findBylandLordId(long landLoadId) {
		return getPersistence().findBylandLordId(landLoadId);
	}

	/**
	* Returns a range of all the land lord payments where landLoadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLoadId the land load ID
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @return the range of matching land lord payments
	*/
	public static List<LandLordPayment> findBylandLordId(long landLoadId,
		int start, int end) {
		return getPersistence().findBylandLordId(landLoadId, start, end);
	}

	/**
	* Returns an ordered range of all the land lord payments where landLoadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLoadId the land load ID
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land lord payments
	*/
	public static List<LandLordPayment> findBylandLordId(long landLoadId,
		int start, int end, OrderByComparator<LandLordPayment> orderByComparator) {
		return getPersistence()
				   .findBylandLordId(landLoadId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the land lord payments where landLoadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLoadId the land load ID
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching land lord payments
	*/
	public static List<LandLordPayment> findBylandLordId(long landLoadId,
		int start, int end,
		OrderByComparator<LandLordPayment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBylandLordId(landLoadId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land lord payment
	* @throws NoSuchLandLordPaymentException if a matching land lord payment could not be found
	*/
	public static LandLordPayment findBylandLordId_First(long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchLandLordPaymentException {
		return getPersistence()
				   .findBylandLordId_First(landLoadId, orderByComparator);
	}

	/**
	* Returns the first land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land lord payment, or <code>null</code> if a matching land lord payment could not be found
	*/
	public static LandLordPayment fetchBylandLordId_First(long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator) {
		return getPersistence()
				   .fetchBylandLordId_First(landLoadId, orderByComparator);
	}

	/**
	* Returns the last land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land lord payment
	* @throws NoSuchLandLordPaymentException if a matching land lord payment could not be found
	*/
	public static LandLordPayment findBylandLordId_Last(long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchLandLordPaymentException {
		return getPersistence()
				   .findBylandLordId_Last(landLoadId, orderByComparator);
	}

	/**
	* Returns the last land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land lord payment, or <code>null</code> if a matching land lord payment could not be found
	*/
	public static LandLordPayment fetchBylandLordId_Last(long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator) {
		return getPersistence()
				   .fetchBylandLordId_Last(landLoadId, orderByComparator);
	}

	/**
	* Returns the land lord payments before and after the current land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLordPaymentId the primary key of the current land lord payment
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land lord payment
	* @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	*/
	public static LandLordPayment[] findBylandLordId_PrevAndNext(
		long landLordPaymentId, long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchLandLordPaymentException {
		return getPersistence()
				   .findBylandLordId_PrevAndNext(landLordPaymentId, landLoadId,
			orderByComparator);
	}

	/**
	* Removes all the land lord payments where landLoadId = &#63; from the database.
	*
	* @param landLoadId the land load ID
	*/
	public static void removeBylandLordId(long landLoadId) {
		getPersistence().removeBylandLordId(landLoadId);
	}

	/**
	* Returns the number of land lord payments where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @return the number of matching land lord payments
	*/
	public static int countBylandLordId(long landLoadId) {
		return getPersistence().countBylandLordId(landLoadId);
	}

	/**
	* Caches the land lord payment in the entity cache if it is enabled.
	*
	* @param landLordPayment the land lord payment
	*/
	public static void cacheResult(LandLordPayment landLordPayment) {
		getPersistence().cacheResult(landLordPayment);
	}

	/**
	* Caches the land lord payments in the entity cache if it is enabled.
	*
	* @param landLordPayments the land lord payments
	*/
	public static void cacheResult(List<LandLordPayment> landLordPayments) {
		getPersistence().cacheResult(landLordPayments);
	}

	/**
	* Creates a new land lord payment with the primary key. Does not add the land lord payment to the database.
	*
	* @param landLordPaymentId the primary key for the new land lord payment
	* @return the new land lord payment
	*/
	public static LandLordPayment create(long landLordPaymentId) {
		return getPersistence().create(landLordPaymentId);
	}

	/**
	* Removes the land lord payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment that was removed
	* @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	*/
	public static LandLordPayment remove(long landLordPaymentId)
		throws com.sphms.common.service.exception.NoSuchLandLordPaymentException {
		return getPersistence().remove(landLordPaymentId);
	}

	public static LandLordPayment updateImpl(LandLordPayment landLordPayment) {
		return getPersistence().updateImpl(landLordPayment);
	}

	/**
	* Returns the land lord payment with the primary key or throws a {@link NoSuchLandLordPaymentException} if it could not be found.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment
	* @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	*/
	public static LandLordPayment findByPrimaryKey(long landLordPaymentId)
		throws com.sphms.common.service.exception.NoSuchLandLordPaymentException {
		return getPersistence().findByPrimaryKey(landLordPaymentId);
	}

	/**
	* Returns the land lord payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment, or <code>null</code> if a land lord payment with the primary key could not be found
	*/
	public static LandLordPayment fetchByPrimaryKey(long landLordPaymentId) {
		return getPersistence().fetchByPrimaryKey(landLordPaymentId);
	}

	public static java.util.Map<java.io.Serializable, LandLordPayment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the land lord payments.
	*
	* @return the land lord payments
	*/
	public static List<LandLordPayment> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the land lord payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @return the range of land lord payments
	*/
	public static List<LandLordPayment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the land lord payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of land lord payments
	*/
	public static List<LandLordPayment> findAll(int start, int end,
		OrderByComparator<LandLordPayment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the land lord payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of land lord payments
	*/
	public static List<LandLordPayment> findAll(int start, int end,
		OrderByComparator<LandLordPayment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the land lord payments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of land lord payments.
	*
	* @return the number of land lord payments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LandLordPaymentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LandLordPaymentPersistence, LandLordPaymentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LandLordPaymentPersistence.class);
}