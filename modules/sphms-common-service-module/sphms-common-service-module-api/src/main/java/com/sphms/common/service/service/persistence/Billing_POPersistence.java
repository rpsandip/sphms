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

import com.sphms.common.service.exception.NoSuchBilling_POException;
import com.sphms.common.service.model.Billing_PO;

/**
 * The persistence interface for the billing_ p o service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.Billing_POPersistenceImpl
 * @see Billing_POUtil
 * @generated
 */
@ProviderType
public interface Billing_POPersistence extends BasePersistence<Billing_PO> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Billing_POUtil} to access the billing_ p o persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the billing_ p os where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @return the matching billing_ p os
	*/
	public java.util.List<Billing_PO> findBybillingId(long billingId);

	/**
	* Returns a range of all the billing_ p os where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @return the range of matching billing_ p os
	*/
	public java.util.List<Billing_PO> findBybillingId(long billingId,
		int start, int end);

	/**
	* Returns an ordered range of all the billing_ p os where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching billing_ p os
	*/
	public java.util.List<Billing_PO> findBybillingId(long billingId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator);

	/**
	* Returns an ordered range of all the billing_ p os where billingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching billing_ p os
	*/
	public java.util.List<Billing_PO> findBybillingId(long billingId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ p o
	* @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	*/
	public Billing_PO findBybillingId_First(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException;

	/**
	* Returns the first billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	*/
	public Billing_PO fetchBybillingId_First(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator);

	/**
	* Returns the last billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ p o
	* @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	*/
	public Billing_PO findBybillingId_Last(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException;

	/**
	* Returns the last billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	*/
	public Billing_PO fetchBybillingId_Last(long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator);

	/**
	* Returns the billing_ p os before and after the current billing_ p o in the ordered set where billingId = &#63;.
	*
	* @param billing_POPK the primary key of the current billing_ p o
	* @param billingId the billing ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next billing_ p o
	* @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	*/
	public Billing_PO[] findBybillingId_PrevAndNext(Billing_POPK billing_POPK,
		long billingId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException;

	/**
	* Removes all the billing_ p os where billingId = &#63; from the database.
	*
	* @param billingId the billing ID
	*/
	public void removeBybillingId(long billingId);

	/**
	* Returns the number of billing_ p os where billingId = &#63;.
	*
	* @param billingId the billing ID
	* @return the number of matching billing_ p os
	*/
	public int countBybillingId(long billingId);

	/**
	* Returns all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @return the matching billing_ p os
	*/
	public java.util.List<Billing_PO> findBybillingIdAndLandLordId(
		long billingId, long landLordId);

	/**
	* Returns a range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @return the range of matching billing_ p os
	*/
	public java.util.List<Billing_PO> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end);

	/**
	* Returns an ordered range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching billing_ p os
	*/
	public java.util.List<Billing_PO> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator);

	/**
	* Returns an ordered range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching billing_ p os
	*/
	public java.util.List<Billing_PO> findBybillingIdAndLandLordId(
		long billingId, long landLordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ p o
	* @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	*/
	public Billing_PO findBybillingIdAndLandLordId_First(long billingId,
		long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException;

	/**
	* Returns the first billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	*/
	public Billing_PO fetchBybillingIdAndLandLordId_First(long billingId,
		long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator);

	/**
	* Returns the last billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ p o
	* @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	*/
	public Billing_PO findBybillingIdAndLandLordId_Last(long billingId,
		long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException;

	/**
	* Returns the last billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	*/
	public Billing_PO fetchBybillingIdAndLandLordId_Last(long billingId,
		long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator);

	/**
	* Returns the billing_ p os before and after the current billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	*
	* @param billing_POPK the primary key of the current billing_ p o
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next billing_ p o
	* @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	*/
	public Billing_PO[] findBybillingIdAndLandLordId_PrevAndNext(
		Billing_POPK billing_POPK, long billingId, long landLordId,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException;

	/**
	* Removes all the billing_ p os where billingId = &#63; and landLordId = &#63; from the database.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	*/
	public void removeBybillingIdAndLandLordId(long billingId, long landLordId);

	/**
	* Returns the number of billing_ p os where billingId = &#63; and landLordId = &#63;.
	*
	* @param billingId the billing ID
	* @param landLordId the land lord ID
	* @return the number of matching billing_ p os
	*/
	public int countBybillingIdAndLandLordId(long billingId, long landLordId);

	/**
	* Caches the billing_ p o in the entity cache if it is enabled.
	*
	* @param billing_PO the billing_ p o
	*/
	public void cacheResult(Billing_PO billing_PO);

	/**
	* Caches the billing_ p os in the entity cache if it is enabled.
	*
	* @param billing_POs the billing_ p os
	*/
	public void cacheResult(java.util.List<Billing_PO> billing_POs);

	/**
	* Creates a new billing_ p o with the primary key. Does not add the billing_ p o to the database.
	*
	* @param billing_POPK the primary key for the new billing_ p o
	* @return the new billing_ p o
	*/
	public Billing_PO create(Billing_POPK billing_POPK);

	/**
	* Removes the billing_ p o with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_POPK the primary key of the billing_ p o
	* @return the billing_ p o that was removed
	* @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	*/
	public Billing_PO remove(Billing_POPK billing_POPK)
		throws NoSuchBilling_POException;

	public Billing_PO updateImpl(Billing_PO billing_PO);

	/**
	* Returns the billing_ p o with the primary key or throws a {@link NoSuchBilling_POException} if it could not be found.
	*
	* @param billing_POPK the primary key of the billing_ p o
	* @return the billing_ p o
	* @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	*/
	public Billing_PO findByPrimaryKey(Billing_POPK billing_POPK)
		throws NoSuchBilling_POException;

	/**
	* Returns the billing_ p o with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param billing_POPK the primary key of the billing_ p o
	* @return the billing_ p o, or <code>null</code> if a billing_ p o with the primary key could not be found
	*/
	public Billing_PO fetchByPrimaryKey(Billing_POPK billing_POPK);

	@Override
	public java.util.Map<java.io.Serializable, Billing_PO> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the billing_ p os.
	*
	* @return the billing_ p os
	*/
	public java.util.List<Billing_PO> findAll();

	/**
	* Returns a range of all the billing_ p os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @return the range of billing_ p os
	*/
	public java.util.List<Billing_PO> findAll(int start, int end);

	/**
	* Returns an ordered range of all the billing_ p os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of billing_ p os
	*/
	public java.util.List<Billing_PO> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator);

	/**
	* Returns an ordered range of all the billing_ p os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of billing_ p os
	*/
	public java.util.List<Billing_PO> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billing_PO> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the billing_ p os from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of billing_ p os.
	*
	* @return the number of billing_ p os
	*/
	public int countAll();
}