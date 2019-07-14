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

import com.sphms.common.service.exception.NoSuchSupplierBillException;
import com.sphms.common.service.model.SupplierBill;

/**
 * The persistence interface for the supplier bill service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.SupplierBillPersistenceImpl
 * @see SupplierBillUtil
 * @generated
 */
@ProviderType
public interface SupplierBillPersistence extends BasePersistence<SupplierBill> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupplierBillUtil} to access the supplier bill persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the supplier bills where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @return the matching supplier bills
	*/
	public java.util.List<SupplierBill> findBysupplierId(long supplierId);

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
	public java.util.List<SupplierBill> findBysupplierId(long supplierId,
		int start, int end);

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
	public java.util.List<SupplierBill> findBysupplierId(long supplierId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator);

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
	public java.util.List<SupplierBill> findBysupplierId(long supplierId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier bill
	* @throws NoSuchSupplierBillException if a matching supplier bill could not be found
	*/
	public SupplierBill findBysupplierId_First(long supplierId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator)
		throws NoSuchSupplierBillException;

	/**
	* Returns the first supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier bill, or <code>null</code> if a matching supplier bill could not be found
	*/
	public SupplierBill fetchBysupplierId_First(long supplierId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator);

	/**
	* Returns the last supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier bill
	* @throws NoSuchSupplierBillException if a matching supplier bill could not be found
	*/
	public SupplierBill findBysupplierId_Last(long supplierId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator)
		throws NoSuchSupplierBillException;

	/**
	* Returns the last supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier bill, or <code>null</code> if a matching supplier bill could not be found
	*/
	public SupplierBill fetchBysupplierId_Last(long supplierId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator);

	/**
	* Returns the supplier bills before and after the current supplier bill in the ordered set where supplierId = &#63;.
	*
	* @param supplierBillId the primary key of the current supplier bill
	* @param supplierId the supplier ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supplier bill
	* @throws NoSuchSupplierBillException if a supplier bill with the primary key could not be found
	*/
	public SupplierBill[] findBysupplierId_PrevAndNext(long supplierBillId,
		long supplierId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator)
		throws NoSuchSupplierBillException;

	/**
	* Removes all the supplier bills where supplierId = &#63; from the database.
	*
	* @param supplierId the supplier ID
	*/
	public void removeBysupplierId(long supplierId);

	/**
	* Returns the number of supplier bills where supplierId = &#63;.
	*
	* @param supplierId the supplier ID
	* @return the number of matching supplier bills
	*/
	public int countBysupplierId(long supplierId);

	/**
	* Caches the supplier bill in the entity cache if it is enabled.
	*
	* @param supplierBill the supplier bill
	*/
	public void cacheResult(SupplierBill supplierBill);

	/**
	* Caches the supplier bills in the entity cache if it is enabled.
	*
	* @param supplierBills the supplier bills
	*/
	public void cacheResult(java.util.List<SupplierBill> supplierBills);

	/**
	* Creates a new supplier bill with the primary key. Does not add the supplier bill to the database.
	*
	* @param supplierBillId the primary key for the new supplier bill
	* @return the new supplier bill
	*/
	public SupplierBill create(long supplierBillId);

	/**
	* Removes the supplier bill with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill that was removed
	* @throws NoSuchSupplierBillException if a supplier bill with the primary key could not be found
	*/
	public SupplierBill remove(long supplierBillId)
		throws NoSuchSupplierBillException;

	public SupplierBill updateImpl(SupplierBill supplierBill);

	/**
	* Returns the supplier bill with the primary key or throws a {@link NoSuchSupplierBillException} if it could not be found.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill
	* @throws NoSuchSupplierBillException if a supplier bill with the primary key could not be found
	*/
	public SupplierBill findByPrimaryKey(long supplierBillId)
		throws NoSuchSupplierBillException;

	/**
	* Returns the supplier bill with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill, or <code>null</code> if a supplier bill with the primary key could not be found
	*/
	public SupplierBill fetchByPrimaryKey(long supplierBillId);

	@Override
	public java.util.Map<java.io.Serializable, SupplierBill> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the supplier bills.
	*
	* @return the supplier bills
	*/
	public java.util.List<SupplierBill> findAll();

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
	public java.util.List<SupplierBill> findAll(int start, int end);

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
	public java.util.List<SupplierBill> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator);

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
	public java.util.List<SupplierBill> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBill> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the supplier bills from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of supplier bills.
	*
	* @return the number of supplier bills
	*/
	public int countAll();
}