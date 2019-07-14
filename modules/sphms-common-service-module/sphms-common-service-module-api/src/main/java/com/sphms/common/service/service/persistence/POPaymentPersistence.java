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

import com.sphms.common.service.exception.NoSuchPOPaymentException;
import com.sphms.common.service.model.POPayment;

/**
 * The persistence interface for the p o payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.POPaymentPersistenceImpl
 * @see POPaymentUtil
 * @generated
 */
@ProviderType
public interface POPaymentPersistence extends BasePersistence<POPayment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link POPaymentUtil} to access the p o payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p o payments where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @return the matching p o payments
	*/
	public java.util.List<POPayment> findBybillingIdAndLandLordId(
		long billingId, long landLordId);

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
	public java.util.List<POPayment> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end);

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
	public java.util.List<POPayment> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator);

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
	public java.util.List<POPayment> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p o payment
	* @throws NoSuchPOPaymentException if a matching p o payment could not be found
	*/
	public POPayment findBybillingIdAndLandLordId_First(long billingId,
		long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator)
		throws NoSuchPOPaymentException;

	/**
	* Returns the first p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p o payment, or <code>null</code> if a matching p o payment could not be found
	*/
	public POPayment fetchBybillingIdAndLandLordId_First(long billingId,
		long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator);

	/**
	* Returns the last p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p o payment
	* @throws NoSuchPOPaymentException if a matching p o payment could not be found
	*/
	public POPayment findBybillingIdAndLandLordId_Last(long billingId,
		long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator)
		throws NoSuchPOPaymentException;

	/**
	* Returns the last p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p o payment, or <code>null</code> if a matching p o payment could not be found
	*/
	public POPayment fetchBybillingIdAndLandLordId_Last(long billingId,
		long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator);

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
	public POPayment[] findBybillingIdAndLandLordId_PrevAndNext(
		long poPaymentId, long billingId, long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator)
		throws NoSuchPOPaymentException;

	/**
	* Removes all the p o payments where billingId = &#63; and landLordId = &#63; from the database.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	*/
	public void removeBybillingIdAndLandLordId(long billingId, long landLordId);

	/**
	* Returns the number of p o payments where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @return the number of matching p o payments
	*/
	public int countBybillingIdAndLandLordId(long billingId, long landLordId);

	/**
	* Caches the p o payment in the entity cache if it is enabled.
	*
	* @param poPayment the p o payment
	*/
	public void cacheResult(POPayment poPayment);

	/**
	* Caches the p o payments in the entity cache if it is enabled.
	*
	* @param poPayments the p o payments
	*/
	public void cacheResult(java.util.List<POPayment> poPayments);

	/**
	* Creates a new p o payment with the primary key. Does not add the p o payment to the database.
	*
	* @param poPaymentId the primary key for the new p o payment
	* @return the new p o payment
	*/
	public POPayment create(long poPaymentId);

	/**
	* Removes the p o payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param poPaymentId the primary key of the p o payment
	* @return the p o payment that was removed
	* @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	*/
	public POPayment remove(long poPaymentId) throws NoSuchPOPaymentException;

	public POPayment updateImpl(POPayment poPayment);

	/**
	* Returns the p o payment with the primary key or throws a {@link NoSuchPOPaymentException} if it could not be found.
	*
	* @param poPaymentId the primary key of the p o payment
	* @return the p o payment
	* @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	*/
	public POPayment findByPrimaryKey(long poPaymentId)
		throws NoSuchPOPaymentException;

	/**
	* Returns the p o payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param poPaymentId the primary key of the p o payment
	* @return the p o payment, or <code>null</code> if a p o payment with the primary key could not be found
	*/
	public POPayment fetchByPrimaryKey(long poPaymentId);

	@Override
	public java.util.Map<java.io.Serializable, POPayment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the p o payments.
	*
	* @return the p o payments
	*/
	public java.util.List<POPayment> findAll();

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
	public java.util.List<POPayment> findAll(int start, int end);

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
	public java.util.List<POPayment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator);

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
	public java.util.List<POPayment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<POPayment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the p o payments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of p o payments.
	*
	* @return the number of p o payments
	*/
	public int countAll();
}