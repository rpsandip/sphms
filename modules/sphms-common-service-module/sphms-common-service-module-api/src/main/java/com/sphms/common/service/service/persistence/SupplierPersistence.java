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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sphms.common.service.exception.NoSuchSupplierException;
import com.sphms.common.service.model.Supplier;

/**
 * The persistence interface for the supplier service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.SupplierPersistenceImpl
 * @see SupplierUtil
 * @generated
 */
@ProviderType
public interface SupplierPersistence extends BasePersistence<Supplier> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupplierUtil} to access the supplier persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the suppliers where status = &#63;.
	*
	* @param status the status
	* @return the matching suppliers
	*/
	public java.util.List<Supplier> findBystatus(int status);

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
	public java.util.List<Supplier> findBystatus(int status, int start, int end);

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
	public java.util.List<Supplier> findBystatus(int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator);

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
	public java.util.List<Supplier> findBystatus(int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first supplier in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier
	* @throws NoSuchSupplierException if a matching supplier could not be found
	*/
	public Supplier findBystatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator)
		throws NoSuchSupplierException;

	/**
	* Returns the first supplier in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier, or <code>null</code> if a matching supplier could not be found
	*/
	public Supplier fetchBystatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator);

	/**
	* Returns the last supplier in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier
	* @throws NoSuchSupplierException if a matching supplier could not be found
	*/
	public Supplier findBystatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator)
		throws NoSuchSupplierException;

	/**
	* Returns the last supplier in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier, or <code>null</code> if a matching supplier could not be found
	*/
	public Supplier fetchBystatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator);

	/**
	* Returns the suppliers before and after the current supplier in the ordered set where status = &#63;.
	*
	* @param supplierId the primary key of the current supplier
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supplier
	* @throws NoSuchSupplierException if a supplier with the primary key could not be found
	*/
	public Supplier[] findBystatus_PrevAndNext(long supplierId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator)
		throws NoSuchSupplierException;

	/**
	* Removes all the suppliers where status = &#63; from the database.
	*
	* @param status the status
	*/
	public void removeBystatus(int status);

	/**
	* Returns the number of suppliers where status = &#63;.
	*
	* @param status the status
	* @return the number of matching suppliers
	*/
	public int countBystatus(int status);

	/**
	* Caches the supplier in the entity cache if it is enabled.
	*
	* @param supplier the supplier
	*/
	public void cacheResult(Supplier supplier);

	/**
	* Caches the suppliers in the entity cache if it is enabled.
	*
	* @param suppliers the suppliers
	*/
	public void cacheResult(java.util.List<Supplier> suppliers);

	/**
	* Creates a new supplier with the primary key. Does not add the supplier to the database.
	*
	* @param supplierId the primary key for the new supplier
	* @return the new supplier
	*/
	public Supplier create(long supplierId);

	/**
	* Removes the supplier with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierId the primary key of the supplier
	* @return the supplier that was removed
	* @throws NoSuchSupplierException if a supplier with the primary key could not be found
	*/
	public Supplier remove(long supplierId) throws NoSuchSupplierException;

	public Supplier updateImpl(Supplier supplier);

	/**
	* Returns the supplier with the primary key or throws a {@link NoSuchSupplierException} if it could not be found.
	*
	* @param supplierId the primary key of the supplier
	* @return the supplier
	* @throws NoSuchSupplierException if a supplier with the primary key could not be found
	*/
	public Supplier findByPrimaryKey(long supplierId)
		throws NoSuchSupplierException;

	/**
	* Returns the supplier with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param supplierId the primary key of the supplier
	* @return the supplier, or <code>null</code> if a supplier with the primary key could not be found
	*/
	public Supplier fetchByPrimaryKey(long supplierId);

	@Override
	public java.util.Map<java.io.Serializable, Supplier> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the suppliers.
	*
	* @return the suppliers
	*/
	public java.util.List<Supplier> findAll();

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
	public java.util.List<Supplier> findAll(int start, int end);

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
	public java.util.List<Supplier> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator);

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
	public java.util.List<Supplier> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Supplier> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the suppliers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of suppliers.
	*
	* @return the number of suppliers
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}