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

import com.sphms.common.service.model.SupplierBill;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the supplier bill service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.SupplierBillPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPersistence
 * @see com.sphms.common.service.service.persistence.impl.SupplierBillPersistenceImpl
 * @generated
 */
@ProviderType
public class SupplierBillUtil {
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
	public static void clearCache(SupplierBill supplierBill) {
		getPersistence().clearCache(supplierBill);
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
	public static List<SupplierBill> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SupplierBill> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SupplierBill> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SupplierBill> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SupplierBill update(SupplierBill supplierBill) {
		return getPersistence().update(supplierBill);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SupplierBill update(SupplierBill supplierBill,
		ServiceContext serviceContext) {
		return getPersistence().update(supplierBill, serviceContext);
	}

	/**
	* Returns all the supplier bills where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @return the matching supplier bills
	*/
	public static List<SupplierBill> findBysupplierId(long supplierId) {
		return getPersistence().findBysupplierId(supplierId);
	}

	/**
	* Returns a range of all the supplier bills where supplierId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param supplierId the supplier ID
	* @param start the lower bound of the range of supplier bills
	* @param end the upper bound of the range of supplier bills (not inclusive)
	* @return the range of matching supplier bills
	*/
	public static List<SupplierBill> findBysupplierId(long supplierId,
		int start, int end) {
		return getPersistence().findBysupplierId(supplierId, start, end);
	}

	/**
	* Returns an ordered range of all the supplier bills where supplierId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param supplierId the supplier ID
	* @param start the lower bound of the range of supplier bills
	* @param end the upper bound of the range of supplier bills (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching supplier bills
	*/
	public static List<SupplierBill> findBysupplierId(long supplierId,
		int start, int end, OrderByComparator<SupplierBill> orderByComparator) {
		return getPersistence()
				   .findBysupplierId(supplierId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the supplier bills where supplierId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param supplierId the supplier ID
	* @param start the lower bound of the range of supplier bills
	* @param end the upper bound of the range of supplier bills (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching supplier bills
	*/
	public static List<SupplierBill> findBysupplierId(long supplierId,
		int start, int end, OrderByComparator<SupplierBill> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBysupplierId(supplierId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier bill
	* @throws NoSuchSupplierBillException if a matching supplier bill could not be found
	*/
	public static SupplierBill findBysupplierId_First(long supplierId,
		OrderByComparator<SupplierBill> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierBillException {
		return getPersistence()
				   .findBysupplierId_First(supplierId, orderByComparator);
	}

	/**
	* Returns the first supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier bill, or <code>null</code> if a matching supplier bill could not be found
	*/
	public static SupplierBill fetchBysupplierId_First(long supplierId,
		OrderByComparator<SupplierBill> orderByComparator) {
		return getPersistence()
				   .fetchBysupplierId_First(supplierId, orderByComparator);
	}

	/**
	* Returns the last supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier bill
	* @throws NoSuchSupplierBillException if a matching supplier bill could not be found
	*/
	public static SupplierBill findBysupplierId_Last(long supplierId,
		OrderByComparator<SupplierBill> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierBillException {
		return getPersistence()
				   .findBysupplierId_Last(supplierId, orderByComparator);
	}

	/**
	* Returns the last supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier bill, or <code>null</code> if a matching supplier bill could not be found
	*/
	public static SupplierBill fetchBysupplierId_Last(long supplierId,
		OrderByComparator<SupplierBill> orderByComparator) {
		return getPersistence()
				   .fetchBysupplierId_Last(supplierId, orderByComparator);
	}

	/**
	* Returns the supplier bills before and after the current supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierBillId the primary key of the current supplier bill
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supplier bill
	* @throws NoSuchSupplierBillException if a supplier bill with the primary key could not be found
	*/
	public static SupplierBill[] findBysupplierId_PrevAndNext(
		long supplierBillId, long supplierId,
		OrderByComparator<SupplierBill> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierBillException {
		return getPersistence()
				   .findBysupplierId_PrevAndNext(supplierBillId, supplierId,
			orderByComparator);
	}

	/**
	* Removes all the supplier bills where supplierId = &#63; from the database.
	*
	* @param supplierId the supplier ID
	*/
	public static void removeBysupplierId(long supplierId) {
		getPersistence().removeBysupplierId(supplierId);
	}

	/**
	* Returns the number of supplier bills where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @return the number of matching supplier bills
	*/
	public static int countBysupplierId(long supplierId) {
		return getPersistence().countBysupplierId(supplierId);
	}

	/**
	* Caches the supplier bill in the entity cache if it is enabled.
	*
	* @param supplierBill the supplier bill
	*/
	public static void cacheResult(SupplierBill supplierBill) {
		getPersistence().cacheResult(supplierBill);
	}

	/**
	* Caches the supplier bills in the entity cache if it is enabled.
	*
	* @param supplierBills the supplier bills
	*/
	public static void cacheResult(List<SupplierBill> supplierBills) {
		getPersistence().cacheResult(supplierBills);
	}

	/**
	* Creates a new supplier bill with the primary key. Does not add the supplier bill to the database.
	*
	* @param supplierBillId the primary key for the new supplier bill
	* @return the new supplier bill
	*/
	public static SupplierBill create(long supplierBillId) {
		return getPersistence().create(supplierBillId);
	}

	/**
	* Removes the supplier bill with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill that was removed
	* @throws NoSuchSupplierBillException if a supplier bill with the primary key could not be found
	*/
	public static SupplierBill remove(long supplierBillId)
		throws com.sphms.common.service.exception.NoSuchSupplierBillException {
		return getPersistence().remove(supplierBillId);
	}

	public static SupplierBill updateImpl(SupplierBill supplierBill) {
		return getPersistence().updateImpl(supplierBill);
	}

	/**
	* Returns the supplier bill with the primary key or throws a {@link NoSuchSupplierBillException} if it could not be found.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill
	* @throws NoSuchSupplierBillException if a supplier bill with the primary key could not be found
	*/
	public static SupplierBill findByPrimaryKey(long supplierBillId)
		throws com.sphms.common.service.exception.NoSuchSupplierBillException {
		return getPersistence().findByPrimaryKey(supplierBillId);
	}

	/**
	* Returns the supplier bill with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill, or <code>null</code> if a supplier bill with the primary key could not be found
	*/
	public static SupplierBill fetchByPrimaryKey(long supplierBillId) {
		return getPersistence().fetchByPrimaryKey(supplierBillId);
	}

	public static java.util.Map<java.io.Serializable, SupplierBill> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the supplier bills.
	*
	* @return the supplier bills
	*/
	public static List<SupplierBill> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the supplier bills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supplier bills
	* @param end the upper bound of the range of supplier bills (not inclusive)
	* @return the range of supplier bills
	*/
	public static List<SupplierBill> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the supplier bills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supplier bills
	* @param end the upper bound of the range of supplier bills (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of supplier bills
	*/
	public static List<SupplierBill> findAll(int start, int end,
		OrderByComparator<SupplierBill> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the supplier bills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supplier bills
	* @param end the upper bound of the range of supplier bills (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of supplier bills
	*/
	public static List<SupplierBill> findAll(int start, int end,
		OrderByComparator<SupplierBill> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the supplier bills from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of supplier bills.
	*
	* @return the number of supplier bills
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SupplierBillPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SupplierBillPersistence, SupplierBillPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SupplierBillPersistence.class);
}