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

import com.sphms.common.service.exception.NoSuchBooking_HordingException;
import com.sphms.common.service.model.Booking_Hording;

/**
 * The persistence interface for the booking_ hording service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.Booking_HordingPersistenceImpl
 * @see Booking_HordingUtil
 * @generated
 */
@ProviderType
public interface Booking_HordingPersistence extends BasePersistence<Booking_Hording> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Booking_HordingUtil} to access the booking_ hording persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the booking_ hordings where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the matching booking_ hordings
	*/
	public java.util.List<Booking_Hording> findBybookingId(long bookingId);

	/**
	* Returns a range of all the booking_ hordings where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking_ hordings
	* @param end the upper bound of the range of booking_ hordings (not inclusive)
	* @return the range of matching booking_ hordings
	*/
	public java.util.List<Booking_Hording> findBybookingId(long bookingId,
		int start, int end);

	/**
	* Returns an ordered range of all the booking_ hordings where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking_ hordings
	* @param end the upper bound of the range of booking_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching booking_ hordings
	*/
	public java.util.List<Booking_Hording> findBybookingId(long bookingId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator);

	/**
	* Returns an ordered range of all the booking_ hordings where bookingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bookingId the booking ID
	* @param start the lower bound of the range of booking_ hordings
	* @param end the upper bound of the range of booking_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching booking_ hordings
	*/
	public java.util.List<Booking_Hording> findBybookingId(long bookingId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first booking_ hording in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking_ hording
	* @throws NoSuchBooking_HordingException if a matching booking_ hording could not be found
	*/
	public Booking_Hording findBybookingId_First(long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator)
		throws NoSuchBooking_HordingException;

	/**
	* Returns the first booking_ hording in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching booking_ hording, or <code>null</code> if a matching booking_ hording could not be found
	*/
	public Booking_Hording fetchBybookingId_First(long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator);

	/**
	* Returns the last booking_ hording in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking_ hording
	* @throws NoSuchBooking_HordingException if a matching booking_ hording could not be found
	*/
	public Booking_Hording findBybookingId_Last(long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator)
		throws NoSuchBooking_HordingException;

	/**
	* Returns the last booking_ hording in the ordered set where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching booking_ hording, or <code>null</code> if a matching booking_ hording could not be found
	*/
	public Booking_Hording fetchBybookingId_Last(long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator);

	/**
	* Returns the booking_ hordings before and after the current booking_ hording in the ordered set where bookingId = &#63;.
	*
	* @param booking_HordingPK the primary key of the current booking_ hording
	* @param bookingId the booking ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next booking_ hording
	* @throws NoSuchBooking_HordingException if a booking_ hording with the primary key could not be found
	*/
	public Booking_Hording[] findBybookingId_PrevAndNext(
		Booking_HordingPK booking_HordingPK, long bookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator)
		throws NoSuchBooking_HordingException;

	/**
	* Removes all the booking_ hordings where bookingId = &#63; from the database.
	*
	* @param bookingId the booking ID
	*/
	public void removeBybookingId(long bookingId);

	/**
	* Returns the number of booking_ hordings where bookingId = &#63;.
	*
	* @param bookingId the booking ID
	* @return the number of matching booking_ hordings
	*/
	public int countBybookingId(long bookingId);

	/**
	* Caches the booking_ hording in the entity cache if it is enabled.
	*
	* @param booking_Hording the booking_ hording
	*/
	public void cacheResult(Booking_Hording booking_Hording);

	/**
	* Caches the booking_ hordings in the entity cache if it is enabled.
	*
	* @param booking_Hordings the booking_ hordings
	*/
	public void cacheResult(java.util.List<Booking_Hording> booking_Hordings);

	/**
	* Creates a new booking_ hording with the primary key. Does not add the booking_ hording to the database.
	*
	* @param booking_HordingPK the primary key for the new booking_ hording
	* @return the new booking_ hording
	*/
	public Booking_Hording create(Booking_HordingPK booking_HordingPK);

	/**
	* Removes the booking_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param booking_HordingPK the primary key of the booking_ hording
	* @return the booking_ hording that was removed
	* @throws NoSuchBooking_HordingException if a booking_ hording with the primary key could not be found
	*/
	public Booking_Hording remove(Booking_HordingPK booking_HordingPK)
		throws NoSuchBooking_HordingException;

	public Booking_Hording updateImpl(Booking_Hording booking_Hording);

	/**
	* Returns the booking_ hording with the primary key or throws a {@link NoSuchBooking_HordingException} if it could not be found.
	*
	* @param booking_HordingPK the primary key of the booking_ hording
	* @return the booking_ hording
	* @throws NoSuchBooking_HordingException if a booking_ hording with the primary key could not be found
	*/
	public Booking_Hording findByPrimaryKey(Booking_HordingPK booking_HordingPK)
		throws NoSuchBooking_HordingException;

	/**
	* Returns the booking_ hording with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param booking_HordingPK the primary key of the booking_ hording
	* @return the booking_ hording, or <code>null</code> if a booking_ hording with the primary key could not be found
	*/
	public Booking_Hording fetchByPrimaryKey(
		Booking_HordingPK booking_HordingPK);

	@Override
	public java.util.Map<java.io.Serializable, Booking_Hording> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the booking_ hordings.
	*
	* @return the booking_ hordings
	*/
	public java.util.List<Booking_Hording> findAll();

	/**
	* Returns a range of all the booking_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking_ hordings
	* @param end the upper bound of the range of booking_ hordings (not inclusive)
	* @return the range of booking_ hordings
	*/
	public java.util.List<Booking_Hording> findAll(int start, int end);

	/**
	* Returns an ordered range of all the booking_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking_ hordings
	* @param end the upper bound of the range of booking_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of booking_ hordings
	*/
	public java.util.List<Booking_Hording> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator);

	/**
	* Returns an ordered range of all the booking_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking_ hordings
	* @param end the upper bound of the range of booking_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of booking_ hordings
	*/
	public java.util.List<Booking_Hording> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Booking_Hording> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the booking_ hordings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of booking_ hordings.
	*
	* @return the number of booking_ hordings
	*/
	public int countAll();
}