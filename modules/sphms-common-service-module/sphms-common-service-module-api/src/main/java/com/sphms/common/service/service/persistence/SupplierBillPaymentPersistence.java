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

import com.sphms.common.service.exception.NoSuchSupplierBillPaymentException;
import com.sphms.common.service.model.SupplierBillPayment;

/**
 * The persistence interface for the supplier bill payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.SupplierBillPaymentPersistenceImpl
 * @see SupplierBillPaymentUtil
 * @generated
 */
@ProviderType
public interface SupplierBillPaymentPersistence extends BasePersistence<SupplierBillPayment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupplierBillPaymentUtil} to access the supplier bill payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the supplier bill payments where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @return the matching supplier bill payments
	*/
	public java.util.List<SupplierBillPayment> findBysupplierBillId(
		long supplierBillId);

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
	public java.util.List<SupplierBillPayment> findBysupplierBillId(
		long supplierBillId, int start, int end);

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
	public java.util.List<SupplierBillPayment> findBysupplierBillId(
		long supplierBillId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator);

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
	public java.util.List<SupplierBillPayment> findBysupplierBillId(
		long supplierBillId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier bill payment
	* @throws NoSuchSupplierBillPaymentException if a matching supplier bill payment could not be found
	*/
	public SupplierBillPayment findBysupplierBillId_First(long supplierBillId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator)
		throws NoSuchSupplierBillPaymentException;

	/**
	* Returns the first supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supplier bill payment, or <code>null</code> if a matching supplier bill payment could not be found
	*/
	public SupplierBillPayment fetchBysupplierBillId_First(
		long supplierBillId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator);

	/**
	* Returns the last supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier bill payment
	* @throws NoSuchSupplierBillPaymentException if a matching supplier bill payment could not be found
	*/
	public SupplierBillPayment findBysupplierBillId_Last(long supplierBillId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator)
		throws NoSuchSupplierBillPaymentException;

	/**
	* Returns the last supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supplier bill payment, or <code>null</code> if a matching supplier bill payment could not be found
	*/
	public SupplierBillPayment fetchBysupplierBillId_Last(long supplierBillId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator);

	/**
	* Returns the supplier bill payments before and after the current supplier bill payment in the ordered set where supplierBillId = &#63;.
	*
	* @param supplierBillPaymentId the primary key of the current supplier bill payment
	* @param supplierBillId the supplier bill ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supplier bill payment
	* @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	*/
	public SupplierBillPayment[] findBysupplierBillId_PrevAndNext(
		long supplierBillPaymentId, long supplierBillId,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator)
		throws NoSuchSupplierBillPaymentException;

	/**
	* Removes all the supplier bill payments where supplierBillId = &#63; from the database.
	*
	* @param supplierBillId the supplier bill ID
	*/
	public void removeBysupplierBillId(long supplierBillId);

	/**
	* Returns the number of supplier bill payments where supplierBillId = &#63;.
	*
	* @param supplierBillId the supplier bill ID
	* @return the number of matching supplier bill payments
	*/
	public int countBysupplierBillId(long supplierBillId);

	/**
	* Caches the supplier bill payment in the entity cache if it is enabled.
	*
	* @param supplierBillPayment the supplier bill payment
	*/
	public void cacheResult(SupplierBillPayment supplierBillPayment);

	/**
	* Caches the supplier bill payments in the entity cache if it is enabled.
	*
	* @param supplierBillPayments the supplier bill payments
	*/
	public void cacheResult(
		java.util.List<SupplierBillPayment> supplierBillPayments);

	/**
	* Creates a new supplier bill payment with the primary key. Does not add the supplier bill payment to the database.
	*
	* @param supplierBillPaymentId the primary key for the new supplier bill payment
	* @return the new supplier bill payment
	*/
	public SupplierBillPayment create(long supplierBillPaymentId);

	/**
	* Removes the supplier bill payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment that was removed
	* @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	*/
	public SupplierBillPayment remove(long supplierBillPaymentId)
		throws NoSuchSupplierBillPaymentException;

	public SupplierBillPayment updateImpl(
		SupplierBillPayment supplierBillPayment);

	/**
	* Returns the supplier bill payment with the primary key or throws a {@link NoSuchSupplierBillPaymentException} if it could not be found.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment
	* @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	*/
	public SupplierBillPayment findByPrimaryKey(long supplierBillPaymentId)
		throws NoSuchSupplierBillPaymentException;

	/**
	* Returns the supplier bill payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment, or <code>null</code> if a supplier bill payment with the primary key could not be found
	*/
	public SupplierBillPayment fetchByPrimaryKey(long supplierBillPaymentId);

	@Override
	public java.util.Map<java.io.Serializable, SupplierBillPayment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the supplier bill payments.
	*
	* @return the supplier bill payments
	*/
	public java.util.List<SupplierBillPayment> findAll();

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
	public java.util.List<SupplierBillPayment> findAll(int start, int end);

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
	public java.util.List<SupplierBillPayment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator);

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
	public java.util.List<SupplierBillPayment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupplierBillPayment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the supplier bill payments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of supplier bill payments.
	*
	* @return the number of supplier bill payments
	*/
	public int countAll();
}