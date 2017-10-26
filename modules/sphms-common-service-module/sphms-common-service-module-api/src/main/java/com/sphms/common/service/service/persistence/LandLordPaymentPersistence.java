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

import com.sphms.common.service.exception.NoSuchLandLordPaymentException;
import com.sphms.common.service.model.LandLordPayment;

/**
 * The persistence interface for the land lord payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.LandLordPaymentPersistenceImpl
 * @see LandLordPaymentUtil
 * @generated
 */
@ProviderType
public interface LandLordPaymentPersistence extends BasePersistence<LandLordPayment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LandLordPaymentUtil} to access the land lord payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the land lord payments where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @return the matching land lord payments
	*/
	public java.util.List<LandLordPayment> findBylandLordId(long landLoadId);

	/**
	* Returns a range of all the land lord payments where landLoadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLoadId the land load ID
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @return the range of matching land lord payments
	*/
	public java.util.List<LandLordPayment> findBylandLordId(long landLoadId,
		int start, int end);

	/**
	* Returns an ordered range of all the land lord payments where landLoadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLoadId the land load ID
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching land lord payments
	*/
	public java.util.List<LandLordPayment> findBylandLordId(long landLoadId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator);

	/**
	* Returns an ordered range of all the land lord payments where landLoadId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLoadId the land load ID
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching land lord payments
	*/
	public java.util.List<LandLordPayment> findBylandLordId(long landLoadId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land lord payment
	* @throws NoSuchLandLordPaymentException if a matching land lord payment could not be found
	*/
	public LandLordPayment findBylandLordId_First(long landLoadId,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator)
		throws NoSuchLandLordPaymentException;

	/**
	* Returns the first land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching land lord payment, or <code>null</code> if a matching land lord payment could not be found
	*/
	public LandLordPayment fetchBylandLordId_First(long landLoadId,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator);

	/**
	* Returns the last land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land lord payment
	* @throws NoSuchLandLordPaymentException if a matching land lord payment could not be found
	*/
	public LandLordPayment findBylandLordId_Last(long landLoadId,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator)
		throws NoSuchLandLordPaymentException;

	/**
	* Returns the last land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching land lord payment, or <code>null</code> if a matching land lord payment could not be found
	*/
	public LandLordPayment fetchBylandLordId_Last(long landLoadId,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator);

	/**
	* Returns the land lord payments before and after the current land lord payment in the ordered set where landLoadId = &#63;.
	*
	* @param landLordPaymentId the primary key of the current land lord payment
	* @param landLoadId the land load ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next land lord payment
	* @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	*/
	public LandLordPayment[] findBylandLordId_PrevAndNext(
		long landLordPaymentId, long landLoadId,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator)
		throws NoSuchLandLordPaymentException;

	/**
	* Removes all the land lord payments where landLoadId = &#63; from the database.
	*
	* @param landLoadId the land load ID
	*/
	public void removeBylandLordId(long landLoadId);

	/**
	* Returns the number of land lord payments where landLoadId = &#63;.
	*
	* @param landLoadId the land load ID
	* @return the number of matching land lord payments
	*/
	public int countBylandLordId(long landLoadId);

	/**
	* Caches the land lord payment in the entity cache if it is enabled.
	*
	* @param landLordPayment the land lord payment
	*/
	public void cacheResult(LandLordPayment landLordPayment);

	/**
	* Caches the land lord payments in the entity cache if it is enabled.
	*
	* @param landLordPayments the land lord payments
	*/
	public void cacheResult(java.util.List<LandLordPayment> landLordPayments);

	/**
	* Creates a new land lord payment with the primary key. Does not add the land lord payment to the database.
	*
	* @param landLordPaymentId the primary key for the new land lord payment
	* @return the new land lord payment
	*/
	public LandLordPayment create(long landLordPaymentId);

	/**
	* Removes the land lord payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment that was removed
	* @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	*/
	public LandLordPayment remove(long landLordPaymentId)
		throws NoSuchLandLordPaymentException;

	public LandLordPayment updateImpl(LandLordPayment landLordPayment);

	/**
	* Returns the land lord payment with the primary key or throws a {@link NoSuchLandLordPaymentException} if it could not be found.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment
	* @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	*/
	public LandLordPayment findByPrimaryKey(long landLordPaymentId)
		throws NoSuchLandLordPaymentException;

	/**
	* Returns the land lord payment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment, or <code>null</code> if a land lord payment with the primary key could not be found
	*/
	public LandLordPayment fetchByPrimaryKey(long landLordPaymentId);

	@Override
	public java.util.Map<java.io.Serializable, LandLordPayment> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the land lord payments.
	*
	* @return the land lord payments
	*/
	public java.util.List<LandLordPayment> findAll();

	/**
	* Returns a range of all the land lord payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @return the range of land lord payments
	*/
	public java.util.List<LandLordPayment> findAll(int start, int end);

	/**
	* Returns an ordered range of all the land lord payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of land lord payments
	*/
	public java.util.List<LandLordPayment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator);

	/**
	* Returns an ordered range of all the land lord payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of land lord payments
	*/
	public java.util.List<LandLordPayment> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LandLordPayment> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the land lord payments from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of land lord payments.
	*
	* @return the number of land lord payments
	*/
	public int countAll();
}