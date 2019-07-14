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

import com.sphms.common.service.model.POPayment;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the p o payment service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.POPaymentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see POPaymentPersistence
 * @see com.sphms.common.service.service.persistence.impl.POPaymentPersistenceImpl
 * @generated
 */
@ProviderType
public class POPaymentUtil {
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
	public static void clearCache(POPayment poPayment) {
		getPersistence().clearCache(poPayment);
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
	public static List<POPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<POPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<POPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<POPayment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static POPayment update(POPayment poPayment) {
		return getPersistence().update(poPayment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static POPayment update(POPayment poPayment,
		ServiceContext serviceContext) {
		return getPersistence().update(poPayment, serviceContext);
	}

	/**
	* Returns all the p o payments where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @return the matching p o payments
	*/
	public static List<POPayment> findBybillingIdAndLandLordId(long billingId,
		long landLordId) {
		return getPersistence()
				   .findBybillingIdAndLandLordId(billingId, landLordId);
	}

	/**
	* Returns a range of all the p o payments where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of p o payments
	* @param end the upper bound of the range of p o payments (not inclusive)
	* @return the range of matching p o payments
	*/
	public static List<POPayment> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end) {
		return getPersistence()
				   .findBybillingIdAndLandLordId(billingId, landLordId, start,
			end);
	}

	/**
	* Returns an ordered range of all the p o payments where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of p o payments
	* @param end the upper bound of the range of p o payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p o payments
	*/
	public static List<POPayment> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end,
		OrderByComparator<POPayment> orderByComparator) {
		return getPersistence()
				   .findBybillingIdAndLandLordId(billingId, landLordId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the p o payments where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of p o payments
	* @param end the upper bound of the range of p o payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching p o payments
	*/
	public static List<POPayment> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end,
		OrderByComparator<POPayment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBybillingIdAndLandLordId(billingId, landLordId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p o payment
	* @throws NoSuchPOPaymentException if a matching p o payment could not be found
	*/
	public static POPayment findBybillingIdAndLandLordId_First(long billingId,
		long landLordId, OrderByComparator<POPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchPOPaymentException {
		return getPersistence()
				   .findBybillingIdAndLandLordId_First(billingId, landLordId,
			orderByComparator);
	}

	/**
	* Returns the first p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p o payment, or <code>null</code> if a matching p o payment could not be found
	*/
	public static POPayment fetchBybillingIdAndLandLordId_First(
		long billingId, long landLordId,
		OrderByComparator<POPayment> orderByComparator) {
		return getPersistence()
				   .fetchBybillingIdAndLandLordId_First(billingId, landLordId,
			orderByComparator);
	}

	/**
	* Returns the last p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p o payment
	* @throws NoSuchPOPaymentException if a matching p o payment could not be found
	*/
	public static POPayment findBybillingIdAndLandLordId_Last(long billingId,
		long landLordId, OrderByComparator<POPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchPOPaymentException {
		return getPersistence()
				   .findBybillingIdAndLandLordId_Last(billingId, landLordId,
			orderByComparator);
	}

	/**
	* Returns the last p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p o payment, or <code>null</code> if a matching p o payment could not be found
	*/
	public static POPayment fetchBybillingIdAndLandLordId_Last(long billingId,
		long landLordId, OrderByComparator<POPayment> orderByComparator) {
		return getPersistence()
				   .fetchBybillingIdAndLandLordId_Last(billingId, landLordId,
			orderByComparator);
	}

	/**
	* Returns the p o payments before and after the current p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param poPaymentId the primary key of the current p o payment
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p o payment
	* @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	*/
	public static POPayment[] findBybillingIdAndLandLordId_PrevAndNext(
		long poPaymentId, long billingId, long landLordId,
		OrderByComparator<POPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchPOPaymentException {
		return getPersistence()
				   .findBybillingIdAndLandLordId_PrevAndNext(poPaymentId,
			billingId, landLordId, orderByComparator);
	}

	/**
	* Removes all the p o payments where billingId = &#63; and landLordId = &#63; from the database.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	*/
	public static void removeBybillingIdAndLandLordId(long billingId,
		long landLordId) {
		getPersistence().removeBybillingIdAndLandLordId(billingId, landLordId);
	}

	/**
	* Returns the number of p o payments where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @return the number of matching p o payments
	*/
	public static int countBybillingIdAndLandLordId(long billingId,
		long landLordId) {
		return getPersistence()
				   .countBybillingIdAndLandLordId(billingId, landLordId);
	}

	/**
	* Caches the p o payment in the entity cache if it is enabled.
	*
	* @param poPayment the p o payment
	*/
	public static void cacheResult(POPayment poPayment) {
		getPersistence().cacheResult(poPayment);
	}

	/**
	* Caches the p o payments in the entity cache if it is enabled.
	*
	* @param poPayments the p o payments
	*/
	public static void cacheResult(List<POPayment> poPayments) {
		getPersistence().cacheResult(poPayments);
	}

	/**
	* Creates a new p o payment with the primary key. Does not add the p o payment to the database.
	*
	* @param poPaymentId the primary key for the new p o payment
	* @return the new p o payment
	*/
	public static POPayment create(long poPaymentId) {
		return getPersistence().create(poPaymentId);
	}

	/**
	* Removes the p o payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param poPaymentId the primary key of the p o payment
	* @return the p o payment that was removed
	* @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	*/
	public static POPayment remove(long poPaymentId)
		throws com.sphms.common.service.exception.NoSuchPOPaymentException {
		return getPersistence().remove(poPaymentId);
	}

	public static POPayment updateImpl(POPayment poPayment) {
		return getPersistence().updateImpl(poPayment);
	}

	/**
	* Returns the p o payment with the primary key or throws a {@link NoSuchPOPaymentException} if it could not be found.
	*
	* @param poPaymentId the primary key of the p o payment
	* @return the p o payment
	* @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	*/
	public static POPayment findByPrimaryKey(long poPaymentId)
		throws com.sphms.common.service.exception.NoSuchPOPaymentException {
		return getPersistence().findByPrimaryKey(poPaymentId);
	}

	/**
	* Returns the p o payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param poPaymentId the primary key of the p o payment
	* @return the p o payment, or <code>null</code> if a p o payment with the primary key could not be found
	*/
	public static POPayment fetchByPrimaryKey(long poPaymentId) {
		return getPersistence().fetchByPrimaryKey(poPaymentId);
	}

	public static java.util.Map<java.io.Serializable, POPayment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the p o payments.
	*
	* @return the p o payments
	*/
	public static List<POPayment> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the p o payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p o payments
	* @param end the upper bound of the range of p o payments (not inclusive)
	* @return the range of p o payments
	*/
	public static List<POPayment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the p o payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p o payments
	* @param end the upper bound of the range of p o payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p o payments
	*/
	public static List<POPayment> findAll(int start, int end,
		OrderByComparator<POPayment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the p o payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p o payments
	* @param end the upper bound of the range of p o payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of p o payments
	*/
	public static List<POPayment> findAll(int start, int end,
		OrderByComparator<POPayment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the p o payments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p o payments.
	*
	* @return the number of p o payments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static POPaymentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<POPaymentPersistence, POPaymentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(POPaymentPersistence.class);
}