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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for LandLordPayment. This utility wraps
 * {@link com.sphms.common.service.service.impl.LandLordPaymentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPaymentLocalService
 * @see com.sphms.common.service.service.base.LandLordPaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.LandLordPaymentLocalServiceImpl
 * @generated
 */
@ProviderType
public class LandLordPaymentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.LandLordPaymentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the land lord payment to the database. Also notifies the appropriate model listeners.
	*
	* @param landLordPayment the land lord payment
	* @return the land lord payment that was added
	*/
	public static com.sphms.common.service.model.LandLordPayment addLandLordPayment(
		com.sphms.common.service.model.LandLordPayment landLordPayment) {
		return getService().addLandLordPayment(landLordPayment);
	}

	public static com.sphms.common.service.model.LandLordPayment addLandLordPayment(
		long landLordId, long hordingId, double amount,
		java.util.Date paymentDate, java.lang.String chequeNo,
		java.lang.String bankName, java.lang.String description, long createdBy) {
		return getService()
				   .addLandLordPayment(landLordId, hordingId, amount,
			paymentDate, chequeNo, bankName, description, createdBy);
	}

	/**
	* Creates a new land lord payment with the primary key. Does not add the land lord payment to the database.
	*
	* @param landLordPaymentId the primary key for the new land lord payment
	* @return the new land lord payment
	*/
	public static com.sphms.common.service.model.LandLordPayment createLandLordPayment(
		long landLordPaymentId) {
		return getService().createLandLordPayment(landLordPaymentId);
	}

	/**
	* Deletes the land lord payment from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordPayment the land lord payment
	* @return the land lord payment that was removed
	*/
	public static com.sphms.common.service.model.LandLordPayment deleteLandLordPayment(
		com.sphms.common.service.model.LandLordPayment landLordPayment) {
		return getService().deleteLandLordPayment(landLordPayment);
	}

	/**
	* Deletes the land lord payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment that was removed
	* @throws PortalException if a land lord payment with the primary key could not be found
	*/
	public static com.sphms.common.service.model.LandLordPayment deleteLandLordPayment(
		long landLordPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLandLordPayment(landLordPaymentId);
	}

	public static com.sphms.common.service.model.LandLordPayment fetchLandLordPayment(
		long landLordPaymentId) {
		return getService().fetchLandLordPayment(landLordPaymentId);
	}

	/**
	* Returns the land lord payment with the primary key.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment
	* @throws PortalException if a land lord payment with the primary key could not be found
	*/
	public static com.sphms.common.service.model.LandLordPayment getLandLordPayment(
		long landLordPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLandLordPayment(landLordPaymentId);
	}

	/**
	* Updates the land lord payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param landLordPayment the land lord payment
	* @return the land lord payment that was updated
	*/
	public static com.sphms.common.service.model.LandLordPayment updateLandLordPayment(
		com.sphms.common.service.model.LandLordPayment landLordPayment) {
		return getService().updateLandLordPayment(landLordPayment);
	}

	public static com.sphms.common.service.model.LandLordPayment updateLandLordPayment(
		long landLordPaymentId, long landLordId, long hordingId, double amount,
		java.util.Date paymentDate, java.lang.String chequeNo,
		java.lang.String bankName, java.lang.String description, long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateLandLordPayment(landLordPaymentId, landLordId,
			hordingId, amount, paymentDate, chequeNo, bankName, description,
			createdBy);
	}

	/**
	* Returns the number of land lord payments.
	*
	* @return the number of land lord payments
	*/
	public static int getLandLordPaymentsCount() {
		return getService().getLandLordPaymentsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the land lord payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @return the range of land lord payments
	*/
	public static java.util.List<com.sphms.common.service.model.LandLordPayment> getLandLordPayments(
		int start, int end) {
		return getService().getLandLordPayments(start, end);
	}

	public static java.util.List<com.sphms.common.service.beans.LandLordPaymentBean> getLandLordPayments(
		long landLordId) {
		return getService().getLandLordPayments(landLordId);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static LandLordPaymentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LandLordPaymentLocalService, LandLordPaymentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LandLordPaymentLocalService.class);
}