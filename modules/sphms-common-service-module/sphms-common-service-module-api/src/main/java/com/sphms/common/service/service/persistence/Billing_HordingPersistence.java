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

import com.sphms.common.service.exception.NoSuchBilling_HordingException;
import com.sphms.common.service.model.Billing_Hording;

/**
 * The persistence interface for the billing_ hording service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.Billing_HordingPersistenceImpl
 * @see Billing_HordingUtil
 * @generated
 */
@ProviderType
public interface Billing_HordingPersistence extends BasePersistence<Billing_Hording> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Billing_HordingUtil} to access the billing_ hording persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the billing_ hordings where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @return the matching billing_ hordings
	*/
	public java.util.List<Billing_Hording> findBybillingId(long billingId);

	/**
	* Returns a range of all the billing_ hordings where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ hordings
	* @param end the upper bound of the range of billing_ hordings (not inclusive)
	* @return the range of matching billing_ hordings
	*/
	public java.util.List<Billing_Hording> findBybillingId(long billingId,
		int start, int end);

	/**
	* Returns an ordered range of all the billing_ hordings where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ hordings
	* @param end the upper bound of the range of billing_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching billing_ hordings
	*/
	public java.util.List<Billing_Hording> findBybillingId(long billingId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator);

	/**
	* Returns an ordered range of all the billing_ hordings where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ hordings
	* @param end the upper bound of the range of billing_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching billing_ hordings
	*/
	public java.util.List<Billing_Hording> findBybillingId(long billingId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first billing_ hording in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ hording
	* @throws NoSuchBilling_HordingException if a matching billing_ hording could not be found
	*/
	public Billing_Hording findBybillingId_First(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator)
		throws NoSuchBilling_HordingException;

	/**
	* Returns the first billing_ hording in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ hording, or <code>null</code> if a matching billing_ hording could not be found
	*/
	public Billing_Hording fetchBybillingId_First(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator);

	/**
	* Returns the last billing_ hording in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ hording
	* @throws NoSuchBilling_HordingException if a matching billing_ hording could not be found
	*/
	public Billing_Hording findBybillingId_Last(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator)
		throws NoSuchBilling_HordingException;

	/**
	* Returns the last billing_ hording in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ hording, or <code>null</code> if a matching billing_ hording could not be found
	*/
	public Billing_Hording fetchBybillingId_Last(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator);

	/**
	* Returns the billing_ hordings before and after the current billing_ hording in the ordered set where billingId = &#63;.
	*
	* @param billing_HordingPK the primary key of the current billing_ hording
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next billing_ hording
	* @throws NoSuchBilling_HordingException if a billing_ hording with the primary key could not be found
	*/
	public Billing_Hording[] findBybillingId_PrevAndNext(
		Billing_HordingPK billing_HordingPK, long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator)
		throws NoSuchBilling_HordingException;

	/**
	* Removes all the billing_ hordings where billingId = &#63; from the database.
	*
	* @param billingId the billing ID
	*/
	public void removeBybillingId(long billingId);

	/**
	* Returns the number of billing_ hordings where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @return the number of matching billing_ hordings
	*/
	public int countBybillingId(long billingId);

	/**
	* Returns the billing_ hording where billingId = &#63; and hordingId = &#63; or throws a {@link NoSuchBilling_HordingException} if it could not be found.
	*
	* @param billingId the billing ID
	* @param hordingId the hording ID
	* @return the matching billing_ hording
	* @throws NoSuchBilling_HordingException if a matching billing_ hording could not be found
	*/
	public Billing_Hording findBybillingIdAndHordingId(long billingId,
		long hordingId) throws NoSuchBilling_HordingException;

	/**
	* Returns the billing_ hording where billingId = &#63; and hordingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param billingId the billing ID
	* @param hordingId the hording ID
	* @return the matching billing_ hording, or <code>null</code> if a matching billing_ hording could not be found
	*/
	public Billing_Hording fetchBybillingIdAndHordingId(long billingId,
		long hordingId);

	/**
	* Returns the billing_ hording where billingId = &#63; and hordingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param billingId the billing ID
	* @param hordingId the hording ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching billing_ hording, or <code>null</code> if a matching billing_ hording could not be found
	*/
	public Billing_Hording fetchBybillingIdAndHordingId(long billingId,
		long hordingId, boolean retrieveFromCache);

	/**
	* Removes the billing_ hording where billingId = &#63; and hordingId = &#63; from the database.
	*
	* @param billingId the billing ID
	* @param hordingId the hording ID
	* @return the billing_ hording that was removed
	*/
	public Billing_Hording removeBybillingIdAndHordingId(long billingId,
		long hordingId) throws NoSuchBilling_HordingException;

	/**
	* Returns the number of billing_ hordings where billingId = &#63; and hordingId = &#63;.
	*
	* @param billingId the billing ID
	* @param hordingId the hording ID
	* @return the number of matching billing_ hordings
	*/
	public int countBybillingIdAndHordingId(long billingId, long hordingId);

	/**
	* Caches the billing_ hording in the entity cache if it is enabled.
	*
	* @param billing_Hording the billing_ hording
	*/
	public void cacheResult(Billing_Hording billing_Hording);

	/**
	* Caches the billing_ hordings in the entity cache if it is enabled.
	*
	* @param billing_Hordings the billing_ hordings
	*/
	public void cacheResult(java.util.List<Billing_Hording> billing_Hordings);

	/**
	* Creates a new billing_ hording with the primary key. Does not add the billing_ hording to the database.
	*
	* @param billing_HordingPK the primary key for the new billing_ hording
	* @return the new billing_ hording
	*/
	public Billing_Hording create(Billing_HordingPK billing_HordingPK);

	/**
	* Removes the billing_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_HordingPK the primary key of the billing_ hording
	* @return the billing_ hording that was removed
	* @throws NoSuchBilling_HordingException if a billing_ hording with the primary key could not be found
	*/
	public Billing_Hording remove(Billing_HordingPK billing_HordingPK)
		throws NoSuchBilling_HordingException;

	public Billing_Hording updateImpl(Billing_Hording billing_Hording);

	/**
	* Returns the billing_ hording with the primary key or throws a {@link NoSuchBilling_HordingException} if it could not be found.
	*
	* @param billing_HordingPK the primary key of the billing_ hording
	* @return the billing_ hording
	* @throws NoSuchBilling_HordingException if a billing_ hording with the primary key could not be found
	*/
	public Billing_Hording findByPrimaryKey(Billing_HordingPK billing_HordingPK)
		throws NoSuchBilling_HordingException;

	/**
	* Returns the billing_ hording with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param billing_HordingPK the primary key of the billing_ hording
	* @return the billing_ hording, or <code>null</code> if a billing_ hording with the primary key could not be found
	*/
	public Billing_Hording fetchByPrimaryKey(
		Billing_HordingPK billing_HordingPK);

	@Override
	public java.util.Map<java.io.Serializable, Billing_Hording> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the billing_ hordings.
	*
	* @return the billing_ hordings
	*/
	public java.util.List<Billing_Hording> findAll();

	/**
	* Returns a range of all the billing_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ hordings
	* @param end the upper bound of the range of billing_ hordings (not inclusive)
	* @return the range of billing_ hordings
	*/
	public java.util.List<Billing_Hording> findAll(int start, int end);

	/**
	* Returns an ordered range of all the billing_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ hordings
	* @param end the upper bound of the range of billing_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of billing_ hordings
	*/
	public java.util.List<Billing_Hording> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator);

	/**
	* Returns an ordered range of all the billing_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ hordings
	* @param end the upper bound of the range of billing_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of billing_ hordings
	*/
	public java.util.List<Billing_Hording> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_Hording> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the billing_ hordings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of billing_ hordings.
	*
	* @return the number of billing_ hordings
	*/
	public int countAll();
}