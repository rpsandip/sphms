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
 * Provides a wrapper for {@link Booking_HordingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Booking_HordingLocalService
 * @generated
 */
@ProviderType
public class Booking_HordingLocalServiceWrapper
	implements Booking_HordingLocalService,
		ServiceWrapper<Booking_HordingLocalService> {
	public Booking_HordingLocalServiceWrapper(
		Booking_HordingLocalService booking_HordingLocalService) {
		_booking_HordingLocalService = booking_HordingLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _booking_HordingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _booking_HordingLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _booking_HordingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _booking_HordingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _booking_HordingLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.sphms.common.service.model.Booking_Hording addBookingHoarding(
		long bookingId, long hordingId, double mountingCharge,
		double printingChrage, int units) {
		return _booking_HordingLocalService.addBookingHoarding(bookingId,
			hordingId, mountingCharge, printingChrage, units);
	}

	/**
	* Adds the booking_ hording to the database. Also notifies the appropriate model listeners.
	*
	* @param booking_Hording the booking_ hording
	* @return the booking_ hording that was added
	*/
	@Override
	public com.sphms.common.service.model.Booking_Hording addBooking_Hording(
		com.sphms.common.service.model.Booking_Hording booking_Hording) {
		return _booking_HordingLocalService.addBooking_Hording(booking_Hording);
	}

	/**
	* Creates a new booking_ hording with the primary key. Does not add the booking_ hording to the database.
	*
	* @param booking_HordingPK the primary key for the new booking_ hording
	* @return the new booking_ hording
	*/
	@Override
	public com.sphms.common.service.model.Booking_Hording createBooking_Hording(
		com.sphms.common.service.service.persistence.Booking_HordingPK booking_HordingPK) {
		return _booking_HordingLocalService.createBooking_Hording(booking_HordingPK);
	}

	/**
	* Deletes the booking_ hording from the database. Also notifies the appropriate model listeners.
	*
	* @param booking_Hording the booking_ hording
	* @return the booking_ hording that was removed
	*/
	@Override
	public com.sphms.common.service.model.Booking_Hording deleteBooking_Hording(
		com.sphms.common.service.model.Booking_Hording booking_Hording) {
		return _booking_HordingLocalService.deleteBooking_Hording(booking_Hording);
	}

	/**
	* Deletes the booking_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param booking_HordingPK the primary key of the booking_ hording
	* @return the booking_ hording that was removed
	* @throws PortalException if a booking_ hording with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Booking_Hording deleteBooking_Hording(
		com.sphms.common.service.service.persistence.Booking_HordingPK booking_HordingPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _booking_HordingLocalService.deleteBooking_Hording(booking_HordingPK);
	}

	@Override
	public com.sphms.common.service.model.Booking_Hording fetchBooking_Hording(
		com.sphms.common.service.service.persistence.Booking_HordingPK booking_HordingPK) {
		return _booking_HordingLocalService.fetchBooking_Hording(booking_HordingPK);
	}

	/**
	* Returns the booking_ hording with the primary key.
	*
	* @param booking_HordingPK the primary key of the booking_ hording
	* @return the booking_ hording
	* @throws PortalException if a booking_ hording with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Booking_Hording getBooking_Hording(
		com.sphms.common.service.service.persistence.Booking_HordingPK booking_HordingPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _booking_HordingLocalService.getBooking_Hording(booking_HordingPK);
	}

	/**
	* Updates the booking_ hording in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param booking_Hording the booking_ hording
	* @return the booking_ hording that was updated
	*/
	@Override
	public com.sphms.common.service.model.Booking_Hording updateBooking_Hording(
		com.sphms.common.service.model.Booking_Hording booking_Hording) {
		return _booking_HordingLocalService.updateBooking_Hording(booking_Hording);
	}

	/**
	* Returns the number of booking_ hordings.
	*
	* @return the number of booking_ hordings
	*/
	@Override
	public int getBooking_HordingsCount() {
		return _booking_HordingLocalService.getBooking_HordingsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _booking_HordingLocalService.getOSGiServiceIdentifier();
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
		return _booking_HordingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _booking_HordingLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _booking_HordingLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Booking_Hording> getBookingHordingsList(
		long bookingId) {
		return _booking_HordingLocalService.getBookingHordingsList(bookingId);
	}

	/**
	* Returns a range of all the booking_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of booking_ hordings
	* @param end the upper bound of the range of booking_ hordings (not inclusive)
	* @return the range of booking_ hordings
	*/
	@Override
	public java.util.List<com.sphms.common.service.model.Booking_Hording> getBooking_Hordings(
		int start, int end) {
		return _booking_HordingLocalService.getBooking_Hordings(start, end);
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
		return _booking_HordingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _booking_HordingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public Booking_HordingLocalService getWrappedService() {
		return _booking_HordingLocalService;
	}

	@Override
	public void setWrappedService(
		Booking_HordingLocalService booking_HordingLocalService) {
		_booking_HordingLocalService = booking_HordingLocalService;
	}

	private Booking_HordingLocalService _booking_HordingLocalService;
}