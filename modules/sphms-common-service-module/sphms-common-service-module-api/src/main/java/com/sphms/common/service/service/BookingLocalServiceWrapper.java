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

package com.sphms.common.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookingLocalService
 * @generated
 */
@ProviderType
public class BookingLocalServiceWrapper implements BookingLocalService,
	ServiceWrapper<BookingLocalService> {
	public BookingLocalServiceWrapper(BookingLocalService bookingLocalService) {
		_bookingLocalService = bookingLocalService;
	}

	@Override
	public boolean updateBookingStatus(long bookingId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingLocalService.updateBookingStatus(bookingId, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _bookingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookingLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _bookingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the booking to the database. Also notifies the appropriate model listeners.
	*
	* @param booking the booking
	* @return the booking that was added
	*/
	@Override
	public com.sphms.common.service.model.Booking addBooking(
		com.sphms.common.service.model.Booking booking) {
		return _bookingLocalService.addBooking(booking);
	}

	@Override
	public com.sphms.common.service.model.Booking addBooking(
		java.lang.String campaignTitle, long client, long companyId,
		java.util.Date startDate, java.util.Date endDate,
		java.util.List<com.sphms.common.service.beans.Booking_HordingBean> bookingHordingList,
		long createdBy, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingLocalService.addBooking(campaignTitle, client,
			companyId, startDate, endDate, bookingHordingList, createdBy,
			modifiedBy);
	}

	/**
	* Creates a new booking with the primary key. Does not add the booking to the database.
	*
	* @param bookingId the primary key for the new booking
	* @return the new booking
	*/
	@Override
	public com.sphms.common.service.model.Booking createBooking(long bookingId) {
		return _bookingLocalService.createBooking(bookingId);
	}

	/**
	* Deletes the booking from the database. Also notifies the appropriate model listeners.
	*
	* @param booking the booking
	* @return the booking that was removed
	*/
	@Override
	public com.sphms.common.service.model.Booking deleteBooking(
		com.sphms.common.service.model.Booking booking) {
		return _bookingLocalService.deleteBooking(booking);
	}

	/**
	* Deletes the booking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookingId the primary key of the booking
	* @return the booking that was removed
	* @throws PortalException if a booking with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Booking deleteBooking(long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingLocalService.deleteBooking(bookingId);
	}

	@Override
	public com.sphms.common.service.model.Booking fetchBooking(long bookingId) {
		return _bookingLocalService.fetchBooking(bookingId);
	}

	/**
	* Returns the booking with the primary key.
	*
	* @param bookingId the primary key of the booking
	* @return the booking
	* @throws PortalException if a booking with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Booking getBooking(long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingLocalService.getBooking(bookingId);
	}

	/**
	* Updates the booking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param booking the booking
	* @return the booking that was updated
	*/
	@Override
	public com.sphms.common.service.model.Booking updateBooking(
		com.sphms.common.service.model.Booking booking) {
		return _bookingLocalService.updateBooking(booking);
	}

	@Override
	public com.sphms.common.service.model.Booking updateBooking(
		long bookingId, java.lang.String campaignTitle, long client,
		long companyId, java.util.Date startDate, java.util.Date endDate,
		java.util.List<com.sphms.common.service.beans.Booking_HordingBean> bookingHordingList,
		long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookingLocalService.updateBooking(bookingId, campaignTitle,
			client, companyId, startDate, endDate, bookingHordingList,
			modifiedBy);
	}

	/**
	* Returns the number of bookings.
	*
	* @return the number of bookings
	*/
	@Override
	public int getBookingsCount() {
		return _bookingLocalService.getBookingsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _bookingLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _bookingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.BookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _bookingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.BookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _bookingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Booking> getBookingList(
		long customComanyId, long clientId, java.util.Date startDate,
		java.util.Date endDate, int start, int end, int status) {
		return _bookingLocalService.getBookingList(customComanyId, clientId,
			startDate, endDate, start, end, status);
	}

	/**
	* Returns a range of all the bookings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.BookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bookings
	* @param end the upper bound of the range of bookings (not inclusive)
	* @return the range of bookings
	*/
	@Override
	public java.util.List<com.sphms.common.service.model.Booking> getBookings(
		int start, int end) {
		return _bookingLocalService.getBookings(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _bookingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _bookingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public long getBookingCount(long customComanyId, long clientId,
		java.util.Date startDate, java.util.Date endDate, int status) {
		return _bookingLocalService.getBookingCount(customComanyId, clientId,
			startDate, endDate, status);
	}

	@Override
	public BookingLocalService getWrappedService() {
		return _bookingLocalService;
	}

	@Override
	public void setWrappedService(BookingLocalService bookingLocalService) {
		_bookingLocalService = bookingLocalService;
	}

	private BookingLocalService _bookingLocalService;
}