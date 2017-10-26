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

import com.sphms.common.service.exception.NoSuchBillingException;
import com.sphms.common.service.model.Billing;

/**
 * The persistence interface for the billing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.BillingPersistenceImpl
 * @see BillingUtil
 * @generated
 */
@ProviderType
public interface BillingPersistence extends BasePersistence<Billing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BillingUtil} to access the billing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the billing where bookingId = &#63; or throws a {@link NoSuchBillingException} if it could not be found.
	*
	* @param bookingId the booking ID
	* @return the matching billing
	* @throws NoSuchBillingException if a matching billing could not be found
	*/
	public Billing findBybookingId(long bookingId)
		throws NoSuchBillingException;

	/**
	* Returns the billing where bookingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bookingId the booking ID
	* @return the matching billing, or <code>null</code> if a matching billing could not be found
	*/
	public Billing fetchBybookingId(long bookingId);

	/**
	* Returns the billing where bookingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bookingId the booking ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching billing, or <code>null</code> if a matching billing could not be found
	*/
	public Billing fetchBybookingId(long bookingId, boolean retrieveFromCache);

	/**
	* Removes the billing where bookingId = &#63; from the database.
	*
	* @param bookingId the booking ID
	* @return the billing that was removed
	*/
	public Billing removeBybookingId(long bookingId)
		throws NoSuchBillingException;

	/**
	* Returns the number of billings where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the number of matching billings
	*/
	public int countBybookingId(long bookingId);

	/**
	* Returns all the billings where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the matching billings
	*/
	public java.util.List<Billing> findByclientId(long clientId);

	/**
	* Returns a range of all the billings where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @return the range of matching billings
	*/
	public java.util.List<Billing> findByclientId(long clientId, int start,
		int end);

	/**
	* Returns an ordered range of all the billings where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching billings
	*/
	public java.util.List<Billing> findByclientId(long clientId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator);

	/**
	* Returns an ordered range of all the billings where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching billings
	*/
	public java.util.List<Billing> findByclientId(long clientId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first billing in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing
	* @throws NoSuchBillingException if a matching billing could not be found
	*/
	public Billing findByclientId_First(long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator)
		throws NoSuchBillingException;

	/**
	* Returns the first billing in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing, or <code>null</code> if a matching billing could not be found
	*/
	public Billing fetchByclientId_First(long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator);

	/**
	* Returns the last billing in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing
	* @throws NoSuchBillingException if a matching billing could not be found
	*/
	public Billing findByclientId_Last(long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator)
		throws NoSuchBillingException;

	/**
	* Returns the last billing in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing, or <code>null</code> if a matching billing could not be found
	*/
	public Billing fetchByclientId_Last(long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator);

	/**
	* Returns the billings before and after the current billing in the ordered set where clientId = &#63;.
	*
	* @param billingId the primary key of the current billing
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next billing
	* @throws NoSuchBillingException if a billing with the primary key could not be found
	*/
	public Billing[] findByclientId_PrevAndNext(long billingId, long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator)
		throws NoSuchBillingException;

	/**
	* Removes all the billings where clientId = &#63; from the database.
	*
	* @param clientId the client ID
	*/
	public void removeByclientId(long clientId);

	/**
	* Returns the number of billings where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the number of matching billings
	*/
	public int countByclientId(long clientId);

	/**
	* Caches the billing in the entity cache if it is enabled.
	*
	* @param billing the billing
	*/
	public void cacheResult(Billing billing);

	/**
	* Caches the billings in the entity cache if it is enabled.
	*
	* @param billings the billings
	*/
	public void cacheResult(java.util.List<Billing> billings);

	/**
	* Creates a new billing with the primary key. Does not add the billing to the database.
	*
	* @param billingId the primary key for the new billing
	* @return the new billing
	*/
	public Billing create(long billingId);

	/**
	* Removes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billingId the primary key of the billing
	* @return the billing that was removed
	* @throws NoSuchBillingException if a billing with the primary key could not be found
	*/
	public Billing remove(long billingId) throws NoSuchBillingException;

	public Billing updateImpl(Billing billing);

	/**
	* Returns the billing with the primary key or throws a {@link NoSuchBillingException} if it could not be found.
	*
	* @param billingId the primary key of the billing
	* @return the billing
	* @throws NoSuchBillingException if a billing with the primary key could not be found
	*/
	public Billing findByPrimaryKey(long billingId)
		throws NoSuchBillingException;

	/**
	* Returns the billing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param billingId the primary key of the billing
	* @return the billing, or <code>null</code> if a billing with the primary key could not be found
	*/
	public Billing fetchByPrimaryKey(long billingId);

	@Override
	public java.util.Map<java.io.Serializable, Billing> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the billings.
	*
	* @return the billings
	*/
	public java.util.List<Billing> findAll();

	/**
	* Returns a range of all the billings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @return the range of billings
	*/
	public java.util.List<Billing> findAll(int start, int end);

	/**
	* Returns an ordered range of all the billings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of billings
	*/
	public java.util.List<Billing> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator);

	/**
	* Returns an ordered range of all the billings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of billings
	*/
	public java.util.List<Billing> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the billings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of billings.
	*
	* @return the number of billings
	*/
	public int countAll();
}