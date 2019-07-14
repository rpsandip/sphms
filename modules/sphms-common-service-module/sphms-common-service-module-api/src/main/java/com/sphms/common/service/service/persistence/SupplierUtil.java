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

import com.sphms.common.service.model.Supplier;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the supplier service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.SupplierPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierPersistence
 * @see com.sphms.common.service.service.persistence.impl.SupplierPersistenceImpl
 * @generated
 */
@ProviderType
public class SupplierUtil {
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
	public static void clearCache(Supplier supplier) {
		getPersistence().clearCache(supplier);
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
	public static List<Supplier> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Supplier> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Supplier> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Supplier> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Supplier update(Supplier supplier) {
		return getPersistence().update(supplier);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Supplier update(Supplier supplier,
		ServiceContext serviceContext) {
		return getPersistence().update(supplier, serviceContext);
	}

	/**
	* Returns all the suppliers where status = &#63;.
	*
	* @param status the status
	* @return the matching suppliers
	*/
	public static List<Supplier> findBystatus(int status) {
		return getPersistence().findBystatus(status);
	}

	/**
	* Returns a range of all the suppliers where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of suppliers
	* @param end the upper bound of the range of suppliers (not inclusive)
	* @return the range of matching suppliers
	*/
	public static List<Supplier> findBystatus(int status, int start, int end) {
		return getPersistence().findBystatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the suppliers where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of suppliers
	* @param end the upper bound of the range of suppliers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching suppliers
	*/
	public static List<Supplier> findBystatus(int status, int start, int end,
		OrderByComparator<Supplier> orderByComparator) {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the suppliers where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of suppliers
	* @param end the upper bound of the range of suppliers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching suppliers
	*/
	public static List<Supplier> findBystatus(int status, int start, int end,
		OrderByComparator<Supplier> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first supplier in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier
	* @throws NoSuchSupplierException if a matching supplier could not be found
	*/
	public static Supplier findBystatus_First(int status,
		OrderByComparator<Supplier> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the first supplier in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier, or <code>null</code> if a matching supplier could not be found
	*/
	public static Supplier fetchBystatus_First(int status,
		OrderByComparator<Supplier> orderByComparator) {
		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last supplier in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier
	* @throws NoSuchSupplierException if a matching supplier could not be found
	*/
	public static Supplier findBystatus_Last(int status,
		OrderByComparator<Supplier> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last supplier in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier, or <code>null</code> if a matching supplier could not be found
	*/
	public static Supplier fetchBystatus_Last(int status,
		OrderByComparator<Supplier> orderByComparator) {
		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the suppliers before and after the current supplier in the ordered set where status = &#63;.
	*
	* @param supplierId the primary key of the current supplier
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supplier
	* @throws NoSuchSupplierException if a supplier with the primary key could not be found
	*/
	public static Supplier[] findBystatus_PrevAndNext(long supplierId,
		int status, OrderByComparator<Supplier> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchSupplierException {
		return getPersistence()
				   .findBystatus_PrevAndNext(supplierId, status,
			orderByComparator);
	}

	/**
	* Removes all the suppliers where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeBystatus(int status) {
		getPersistence().removeBystatus(status);
	}

	/**
	* Returns the number of suppliers where status = &#63;.
	*
	* @param status the status
	* @return the number of matching suppliers
	*/
	public static int countBystatus(int status) {
		return getPersistence().countBystatus(status);
	}

	/**
	* Caches the supplier in the entity cache if it is enabled.
	*
	* @param supplier the supplier
	*/
	public static void cacheResult(Supplier supplier) {
		getPersistence().cacheResult(supplier);
	}

	/**
	* Caches the suppliers in the entity cache if it is enabled.
	*
	* @param suppliers the suppliers
	*/
	public static void cacheResult(List<Supplier> suppliers) {
		getPersistence().cacheResult(suppliers);
	}

	/**
	* Creates a new supplier with the primary key. Does not add the supplier to the database.
	*
	* @param supplierId the primary key for the new supplier
	* @return the new supplier
	*/
	public static Supplier create(long supplierId) {
		return getPersistence().create(supplierId);
	}

	/**
	* Removes the supplier with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierId the primary key of the supplier
	* @return the supplier that was removed
	* @throws NoSuchSupplierException if a supplier with the primary key could not be found
	*/
	public static Supplier remove(long supplierId)
		throws com.sphms.common.service.exception.NoSuchSupplierException {
		return getPersistence().remove(supplierId);
	}

	public static Supplier updateImpl(Supplier supplier) {
		return getPersistence().updateImpl(supplier);
	}

	/**
	* Returns the supplier with the primary key or throws a {@link NoSuchSupplierException} if it could not be found.
	*
	* @param supplierId the primary key of the supplier
	* @return the supplier
	* @throws NoSuchSupplierException if a supplier with the primary key could not be found
	*/
	public static Supplier findByPrimaryKey(long supplierId)
		throws com.sphms.common.service.exception.NoSuchSupplierException {
		return getPersistence().findByPrimaryKey(supplierId);
	}

	/**
	* Returns the supplier with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param supplierId the primary key of the supplier
	* @return the supplier, or <code>null</code> if a supplier with the primary key could not be found
	*/
	public static Supplier fetchByPrimaryKey(long supplierId) {
		return getPersistence().fetchByPrimaryKey(supplierId);
	}

	public static java.util.Map<java.io.Serializable, Supplier> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the suppliers.
	*
	* @return the suppliers
	*/
	public static List<Supplier> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the suppliers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of suppliers
	* @param end the upper bound of the range of suppliers (not inclusive)
	* @return the range of suppliers
	*/
	public static List<Supplier> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the suppliers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of suppliers
	* @param end the upper bound of the range of suppliers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of suppliers
	*/
	public static List<Supplier> findAll(int start, int end,
		OrderByComparator<Supplier> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the suppliers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of suppliers
	* @param end the upper bound of the range of suppliers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of suppliers
	*/
	public static List<Supplier> findAll(int start, int end,
		OrderByComparator<Supplier> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the suppliers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of suppliers.
	*
	* @return the number of suppliers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SupplierPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SupplierPersistence, SupplierPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SupplierPersistence.class);
}