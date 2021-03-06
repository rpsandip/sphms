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

import com.sphms.common.service.exception.NoSuchPaymentException;
import com.sphms.common.service.model.Payment;

/**
 * The persistence interface for the payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.PaymentPersistenceImpl
 * @see PaymentUtil
 * @generated
 */
@ProviderType
public interface PaymentPersistence extends BasePersistence<Payment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PaymentUtil} to access the payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the payments where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @return the matching payments
	*/
	public java.util.List<Payment> findBybillingId(long billingId);

	/**
	* Returns a range of all the payments where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of payments
	* @param end the upper bound of the range of payments (not inclusive)
	* @return the range of matching payments
	*/
	public java.util.List<Payment> findBybillingId(long billingId, int start,
		int end);

	/**
	* Returns an ordered range of all the payments where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of payments
	* @param end the upper bound of the range of payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching payments
	*/
	public java.util.List<Payment> findBybillingId(long billingId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator);

	/**
	* Returns an ordered range of all the payments where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of payments
	* @param end the upper bound of the range of payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching payments
	*/
	public java.util.List<Payment> findBybillingId(long billingId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first payment in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payment
	* @throws NoSuchPaymentException if a matching payment could not be found
	*/
	public Payment findBybillingId_First(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException;

	/**
	* Returns the first payment in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching payment, or <code>null</code> if a matching payment could not be found
	*/
	public Payment fetchBybillingId_First(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator);

	/**
	* Returns the last payment in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payment
	* @throws NoSuchPaymentException if a matching payment could not be found
	*/
	public Payment findBybillingId_Last(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException;

	/**
	* Returns the last payment in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching payment, or <code>null</code> if a matching payment could not be found
	*/
	public Payment fetchBybillingId_Last(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator);

	/**
	* Returns the payments before and after the current payment in the ordered set where billingId = &#63;.
	*
	* @param paymentId the primary key of the current payment
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next payment
	* @throws NoSuchPaymentException if a payment with the primary key could not be found
	*/
	public Payment[] findBybillingId_PrevAndNext(long paymentId,
		long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException;

	/**
	* Removes all the payments where billingId = &#63; from the database.
	*
	* @param billingId the billing ID
	*/
	public void removeBybillingId(long billingId);

	/**
	* Returns the number of payments where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @return the number of matching payments
	*/
	public int countBybillingId(long billingId);

	/**
	* Caches the payment in the entity cache if it is enabled.
	*
	* @param payment the payment
	*/
	public void cacheResult(Payment payment);

	/**
	* Caches the payments in the entity cache if it is enabled.
	*
	* @param payments the payments
	*/
	public void cacheResult(java.util.List<Payment> payments);

	/**
	* Creates a new payment with the primary key. Does not add the payment to the database.
	*
	* @param paymentId the primary key for the new payment
	* @return the new payment
	*/
	public Payment create(long paymentId);

	/**
	* Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param paymentId the primary key of the payment
	* @return the payment that was removed
	* @throws NoSuchPaymentException if a payment with the primary key could not be found
	*/
	public Payment remove(long paymentId) throws NoSuchPaymentException;

	public Payment updateImpl(Payment payment);

	/**
	* Returns the payment with the primary key or throws a {@link NoSuchPaymentException} if it could not be found.
	*
	* @param paymentId the primary key of the payment
	* @return the payment
	* @throws NoSuchPaymentException if a payment with the primary key could not be found
	*/
	public Payment findByPrimaryKey(long paymentId)
		throws NoSuchPaymentException;

	/**
	* Returns the payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param paymentId the primary key of the payment
	* @return the payment, or <code>null</code> if a payment with the primary key could not be found
	*/
	public Payment fetchByPrimaryKey(long paymentId);

	@Override
	public java.util.Map<java.io.Serializable, Payment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the payments.
	*
	* @return the payments
	*/
	public java.util.List<Payment> findAll();

	/**
	* Returns a range of all the payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payments
	* @param end the upper bound of the range of payments (not inclusive)
	* @return the range of payments
	*/
	public java.util.List<Payment> findAll(int start, int end);

	/**
	* Returns an ordered range of all the payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payments
	* @param end the upper bound of the range of payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of payments
	*/
	public java.util.List<Payment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator);

	/**
	* Returns an ordered range of all the payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payments
	* @param end the upper bound of the range of payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of payments
	*/
	public java.util.List<Payment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Payment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the payments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of payments.
	*
	* @return the number of payments
	*/
	public int countAll();
}