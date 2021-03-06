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

import com.sphms.common.service.model.Billing_PO;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the billing_ p o service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.Billing_POPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_POPersistence
 * @see com.sphms.common.service.service.persistence.impl.Billing_POPersistenceImpl
 * @generated
 */
@ProviderType
public class Billing_POUtil {
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
	public static void clearCache(Billing_PO billing_PO) {
		getPersistence().clearCache(billing_PO);
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
	public static List<Billing_PO> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Billing_PO> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Billing_PO> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Billing_PO> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Billing_PO update(Billing_PO billing_PO) {
		return getPersistence().update(billing_PO);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Billing_PO update(Billing_PO billing_PO,
		ServiceContext serviceContext) {
		return getPersistence().update(billing_PO, serviceContext);
	}

	/**
	* Returns all the billing_ p os where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @return the matching billing_ p os
	*/
	public static List<Billing_PO> findBybillingId(long billingId) {
		return getPersistence().findBybillingId(billingId);
	}

	/**
	* Returns a range of all the billing_ p os where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @return the range of matching billing_ p os
	*/
	public static List<Billing_PO> findBybillingId(long billingId, int start,
		int end) {
		return getPersistence().findBybillingId(billingId, start, end);
	}

	/**
	* Returns an ordered range of all the billing_ p os where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching billing_ p os
	*/
	public static List<Billing_PO> findBybillingId(long billingId, int start,
		int end, OrderByComparator<Billing_PO> orderByComparator) {
		return getPersistence()
				   .findBybillingId(billingId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the billing_ p os where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching billing_ p os
	*/
	public static List<Billing_PO> findBybillingId(long billingId, int start,
		int end, OrderByComparator<Billing_PO> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybillingId(billingId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ p o
	* @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	*/
	public static Billing_PO findBybillingId_First(long billingId,
		OrderByComparator<Billing_PO> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchBilling_POException {
		return getPersistence()
				   .findBybillingId_First(billingId, orderByComparator);
	}

	/**
	* Returns the first billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	*/
	public static Billing_PO fetchBybillingId_First(long billingId,
		OrderByComparator<Billing_PO> orderByComparator) {
		return getPersistence()
				   .fetchBybillingId_First(billingId, orderByComparator);
	}

	/**
	* Returns the last billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ p o
	* @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	*/
	public static Billing_PO findBybillingId_Last(long billingId,
		OrderByComparator<Billing_PO> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchBilling_POException {
		return getPersistence()
				   .findBybillingId_Last(billingId, orderByComparator);
	}

	/**
	* Returns the last billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	*/
	public static Billing_PO fetchBybillingId_Last(long billingId,
		OrderByComparator<Billing_PO> orderByComparator) {
		return getPersistence()
				   .fetchBybillingId_Last(billingId, orderByComparator);
	}

	/**
	* Returns the billing_ p os before and after the current billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billing_POPK the primary key of the current billing_ p o
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next billing_ p o
	* @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	*/
	public static Billing_PO[] findBybillingId_PrevAndNext(
		Billing_POPK billing_POPK, long billingId,
		OrderByComparator<Billing_PO> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchBilling_POException {
		return getPersistence()
				   .findBybillingId_PrevAndNext(billing_POPK, billingId,
			orderByComparator);
	}

	/**
	* Removes all the billing_ p os where billingId = &#63; from the database.
	*
	* @param billingId the billing ID
	*/
	public static void removeBybillingId(long billingId) {
		getPersistence().removeBybillingId(billingId);
	}

	/**
	* Returns the number of billing_ p os where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @return the number of matching billing_ p os
	*/
	public static int countBybillingId(long billingId) {
		return getPersistence().countBybillingId(billingId);
	}

	/**
	* Returns all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @return the matching billing_ p os
	*/
	public static List<Billing_PO> findBybillingIdAndLandLordId(
		long billingId, long landLordId) {
		return getPersistence()
				   .findBybillingIdAndLandLordId(billingId, landLordId);
	}

	/**
	* Returns a range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @return the range of matching billing_ p os
	*/
	public static List<Billing_PO> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end) {
		return getPersistence()
				   .findBybillingIdAndLandLordId(billingId, landLordId, start,
			end);
	}

	/**
	* Returns an ordered range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching billing_ p os
	*/
	public static List<Billing_PO> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end,
		OrderByComparator<Billing_PO> orderByComparator) {
		return getPersistence()
				   .findBybillingIdAndLandLordId(billingId, landLordId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching billing_ p os
	*/
	public static List<Billing_PO> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end,
		OrderByComparator<Billing_PO> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybillingIdAndLandLordId(billingId, landLordId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ p o
	* @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	*/
	public static Billing_PO findBybillingIdAndLandLordId_First(
		long billingId, long landLordId,
		OrderByComparator<Billing_PO> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchBilling_POException {
		return getPersistence()
				   .findBybillingIdAndLandLordId_First(billingId, landLordId,
			orderByComparator);
	}

	/**
	* Returns the first billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	*/
	public static Billing_PO fetchBybillingIdAndLandLordId_First(
		long billingId, long landLordId,
		OrderByComparator<Billing_PO> orderByComparator) {
		return getPersistence()
				   .fetchBybillingIdAndLandLordId_First(billingId, landLordId,
			orderByComparator);
	}

	/**
	* Returns the last billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ p o
	* @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	*/
	public static Billing_PO findBybillingIdAndLandLordId_Last(long billingId,
		long landLordId, OrderByComparator<Billing_PO> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchBilling_POException {
		return getPersistence()
				   .findBybillingIdAndLandLordId_Last(billingId, landLordId,
			orderByComparator);
	}

	/**
	* Returns the last billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	*/
	public static Billing_PO fetchBybillingIdAndLandLordId_Last(
		long billingId, long landLordId,
		OrderByComparator<Billing_PO> orderByComparator) {
		return getPersistence()
				   .fetchBybillingIdAndLandLordId_Last(billingId, landLordId,
			orderByComparator);
	}

	/**
	* Returns the billing_ p os before and after the current billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billing_POPK the primary key of the current billing_ p o
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next billing_ p o
	* @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	*/
	public static Billing_PO[] findBybillingIdAndLandLordId_PrevAndNext(
		Billing_POPK billing_POPK, long billingId, long landLordId,
		OrderByComparator<Billing_PO> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchBilling_POException {
		return getPersistence()
				   .findBybillingIdAndLandLordId_PrevAndNext(billing_POPK,
			billingId, landLordId, orderByComparator);
	}

	/**
	* Removes all the billing_ p os where billingId = &#63; and landLordId = &#63; from the database.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	*/
	public static void removeBybillingIdAndLandLordId(long billingId,
		long landLordId) {
		getPersistence().removeBybillingIdAndLandLordId(billingId, landLordId);
	}

	/**
	* Returns the number of billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @return the number of matching billing_ p os
	*/
	public static int countBybillingIdAndLandLordId(long billingId,
		long landLordId) {
		return getPersistence()
				   .countBybillingIdAndLandLordId(billingId, landLordId);
	}

	/**
	* Caches the billing_ p o in the entity cache if it is enabled.
	*
	* @param billing_PO the billing_ p o
	*/
	public static void cacheResult(Billing_PO billing_PO) {
		getPersistence().cacheResult(billing_PO);
	}

	/**
	* Caches the billing_ p os in the entity cache if it is enabled.
	*
	* @param billing_POs the billing_ p os
	*/
	public static void cacheResult(List<Billing_PO> billing_POs) {
		getPersistence().cacheResult(billing_POs);
	}

	/**
	* Creates a new billing_ p o with the primary key. Does not add the billing_ p o to the database.
	*
	* @param billing_POPK the primary key for the new billing_ p o
	* @return the new billing_ p o
	*/
	public static Billing_PO create(Billing_POPK billing_POPK) {
		return getPersistence().create(billing_POPK);
	}

	/**
	* Removes the billing_ p o with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_POPK the primary key of the billing_ p o
	* @return the billing_ p o that was removed
	* @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	*/
	public static Billing_PO remove(Billing_POPK billing_POPK)
		throws com.sphms.common.service.exception.NoSuchBilling_POException {
		return getPersistence().remove(billing_POPK);
	}

	public static Billing_PO updateImpl(Billing_PO billing_PO) {
		return getPersistence().updateImpl(billing_PO);
	}

	/**
	* Returns the billing_ p o with the primary key or throws a {@link NoSuchBilling_POException} if it could not be found.
	*
	* @param billing_POPK the primary key of the billing_ p o
	* @return the billing_ p o
	* @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	*/
	public static Billing_PO findByPrimaryKey(Billing_POPK billing_POPK)
		throws com.sphms.common.service.exception.NoSuchBilling_POException {
		return getPersistence().findByPrimaryKey(billing_POPK);
	}

	/**
	* Returns the billing_ p o with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param billing_POPK the primary key of the billing_ p o
	* @return the billing_ p o, or <code>null</code> if a billing_ p o with the primary key could not be found
	*/
	public static Billing_PO fetchByPrimaryKey(Billing_POPK billing_POPK) {
		return getPersistence().fetchByPrimaryKey(billing_POPK);
	}

	public static java.util.Map<java.io.Serializable, Billing_PO> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the billing_ p os.
	*
	* @return the billing_ p os
	*/
	public static List<Billing_PO> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the billing_ p os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @return the range of billing_ p os
	*/
	public static List<Billing_PO> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the billing_ p os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of billing_ p os
	*/
	public static List<Billing_PO> findAll(int start, int end,
		OrderByComparator<Billing_PO> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the billing_ p os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of billing_ p os
	*/
	public static List<Billing_PO> findAll(int start, int end,
		OrderByComparator<Billing_PO> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the billing_ p os from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of billing_ p os.
	*
	* @return the number of billing_ p os
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Billing_POPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Billing_POPersistence, Billing_POPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Billing_POPersistence.class);
}