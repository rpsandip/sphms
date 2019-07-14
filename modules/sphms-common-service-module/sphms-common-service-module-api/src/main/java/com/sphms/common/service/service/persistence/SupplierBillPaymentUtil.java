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

import com.sphms.common.service.model.SupplierBillPayment;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the supplier bill payment service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.SupplierBillPaymentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPaymentPersistence
 * @see com.sphms.common.service.service.persistence.impl.SupplierBillPaymentPersistenceImpl
 * @generated
 */
@ProviderType
public class SupplierBillPaymentUtil {
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
	public static void clearCache(SupplierBillPayment supplierBillPayment) {
		getPersistence().clearCache(supplierBillPayment);
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
	public static List<SupplierBillPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SupplierBillPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SupplierBillPayment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SupplierBillPayment update(
		SupplierBillPayment supplierBillPayment) {
		return getPersistence().update(supplierBillPayment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SupplierBillPayment update(
		SupplierBillPayment supplierBillPayment, ServiceContext serviceContext) {
		return getPersistence().update(supplierBillPayment, serviceContext);
	}

	/**
	* Returns all the supplier bill payments where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @return the matching supplier bill payments
	*/
	public static List<SupplierBillPayment> findBysupplierBillId(
		long supplierBillId) {
		return getPersistence().findBysupplierBillId(supplierBillId);
	}

	/**
	* Returns a range of all the supplier bill payments where supplierBillId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param supplierBillId the supplier bill ID
	* @param start the lower bound of the range of supplier bill payments
	* @param end the upper bound of the range of supplier bill payments (not inclusive)
	* @return the range of matching supplier bill payments
	*/
	public static List<SupplierBillPayment> findBysupplierBillId(
		long supplierBillId, int start, int end) {
		return getPersistence().findBysupplierBillId(supplierBillId, start, end);
	}

	/**
	* Returns an ordered range of all the supplier bill payments where supplierBillId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param supplierBillId the supplier bill ID
	* @param start the lower bound of the range of supplier bill payments
	* @param end the upper bound of the range of supplier bill payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching supplier bill payments
	*/
	public static List<SupplierBillPayment> findBysupplierBillId(
		long supplierBillId, int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		return getPersistence()
				   .findBysupplierBillId(supplierBillId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the supplier bill payments where supplierBillId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param supplierBillId the supplier bill ID
	* @param start the lower bound of the range of supplier bill payments
	* @param end the upper bound of the range of supplier bill payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching supplier bill payments
	*/
	public static List<SupplierBillPayment> findBysupplierBillId(
		long supplierBillId, int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBysupplierBillId(supplierBillId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier bill payment
	* @throws NoSuchSupplierBillPaymentException if a matching supplier bill payment could not be found
	*/
	public static SupplierBillPayment findBysupplierBillId_First(
		long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierBillPaymentException {
		return getPersistence()
				   .findBysupplierBillId_First(supplierBillId, orderByComparator);
	}

	/**
	* Returns the first supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier bill payment, or <code>null</code> if a matching supplier bill payment could not be found
	*/
	public static SupplierBillPayment fetchBysupplierBillId_First(
		long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		return getPersistence()
				   .fetchBysupplierBillId_First(supplierBillId,
			orderByComparator);
	}

	/**
	* Returns the last supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier bill payment
	* @throws NoSuchSupplierBillPaymentException if a matching supplier bill payment could not be found
	*/
	public static SupplierBillPayment findBysupplierBillId_Last(
		long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierBillPaymentException {
		return getPersistence()
				   .findBysupplierBillId_Last(supplierBillId, orderByComparator);
	}

	/**
	* Returns the last supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier bill payment, or <code>null</code> if a matching supplier bill payment could not be found
	*/
	public static SupplierBillPayment fetchBysupplierBillId_Last(
		long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		return getPersistence()
				   .fetchBysupplierBillId_Last(supplierBillId, orderByComparator);
	}

	/**
	* Returns the supplier bill payments before and after the current supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillPaymentId the primary key of the current supplier bill payment
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supplier bill payment
	* @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	*/
	public static SupplierBillPayment[] findBysupplierBillId_PrevAndNext(
		long supplierBillPaymentId, long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierBillPaymentException {
		return getPersistence()
				   .findBysupplierBillId_PrevAndNext(supplierBillPaymentId,
			supplierBillId, orderByComparator);
	}

	/**
	* Removes all the supplier bill payments where supplierBillId = &#63; from the database.
	*
	* @param supplierBillId the supplier bill ID
	*/
	public static void removeBysupplierBillId(long supplierBillId) {
		getPersistence().removeBysupplierBillId(supplierBillId);
	}

	/**
	* Returns the number of supplier bill payments where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @return the number of matching supplier bill payments
	*/
	public static int countBysupplierBillId(long supplierBillId) {
		return getPersistence().countBysupplierBillId(supplierBillId);
	}

	/**
	* Caches the supplier bill payment in the entity cache if it is enabled.
	*
	* @param supplierBillPayment the supplier bill payment
	*/
	public static void cacheResult(SupplierBillPayment supplierBillPayment) {
		getPersistence().cacheResult(supplierBillPayment);
	}

	/**
	* Caches the supplier bill payments in the entity cache if it is enabled.
	*
	* @param supplierBillPayments the supplier bill payments
	*/
	public static void cacheResult(
		List<SupplierBillPayment> supplierBillPayments) {
		getPersistence().cacheResult(supplierBillPayments);
	}

	/**
	* Creates a new supplier bill payment with the primary key. Does not add the supplier bill payment to the database.
	*
	* @param supplierBillPaymentId the primary key for the new supplier bill payment
	* @return the new supplier bill payment
	*/
	public static SupplierBillPayment create(long supplierBillPaymentId) {
		return getPersistence().create(supplierBillPaymentId);
	}

	/**
	* Removes the supplier bill payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment that was removed
	* @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	*/
	public static SupplierBillPayment remove(long supplierBillPaymentId)
		throws com.sphms.common.service.exception.NoSuchSupplierBillPaymentException {
		return getPersistence().remove(supplierBillPaymentId);
	}

	public static SupplierBillPayment updateImpl(
		SupplierBillPayment supplierBillPayment) {
		return getPersistence().updateImpl(supplierBillPayment);
	}

	/**
	* Returns the supplier bill payment with the primary key or throws a {@link NoSuchSupplierBillPaymentException} if it could not be found.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment
	* @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	*/
	public static SupplierBillPayment findByPrimaryKey(
		long supplierBillPaymentId)
		throws com.sphms.common.service.exception.NoSuchSupplierBillPaymentException {
		return getPersistence().findByPrimaryKey(supplierBillPaymentId);
	}

	/**
	* Returns the supplier bill payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment, or <code>null</code> if a supplier bill payment with the primary key could not be found
	*/
	public static SupplierBillPayment fetchByPrimaryKey(
		long supplierBillPaymentId) {
		return getPersistence().fetchByPrimaryKey(supplierBillPaymentId);
	}

	public static java.util.Map<java.io.Serializable, SupplierBillPayment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the supplier bill payments.
	*
	* @return the supplier bill payments
	*/
	public static List<SupplierBillPayment> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the supplier bill payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supplier bill payments
	* @param end the upper bound of the range of supplier bill payments (not inclusive)
	* @return the range of supplier bill payments
	*/
	public static List<SupplierBillPayment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the supplier bill payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supplier bill payments
	* @param end the upper bound of the range of supplier bill payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of supplier bill payments
	*/
	public static List<SupplierBillPayment> findAll(int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the supplier bill payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supplier bill payments
	* @param end the upper bound of the range of supplier bill payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of supplier bill payments
	*/
	public static List<SupplierBillPayment> findAll(int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the supplier bill payments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of supplier bill payments.
	*
	* @return the number of supplier bill payments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SupplierBillPaymentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SupplierBillPaymentPersistence, SupplierBillPaymentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SupplierBillPaymentPersistence.class);
}