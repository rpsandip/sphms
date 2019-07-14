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
 * Provides the local service utility for POPayment. This utility wraps
 * {@link com.sphms.common.service.service.impl.POPaymentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see POPaymentLocalService
 * @see com.sphms.common.service.service.base.POPaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.POPaymentLocalServiceImpl
 * @generated
 */
@ProviderType
public class POPaymentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.POPaymentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.sphms.common.service.model.POPayment addOPayment(
		long billingId, long landLoardId, double amount, double gst,
		java.lang.String checqueNo, java.util.Date paymentDate, long userId) {
		return getService()
				   .addOPayment(billingId, landLoardId, amount, gst, checqueNo,
			paymentDate, userId);
	}

	/**
	* Adds the p o payment to the database. Also notifies the appropriate model listeners.
	*
	* @param poPayment the p o payment
	* @return the p o payment that was added
	*/
	public static com.sphms.common.service.model.POPayment addPOPayment(
		com.sphms.common.service.model.POPayment poPayment) {
		return getService().addPOPayment(poPayment);
	}

	/**
	* Creates a new p o payment with the primary key. Does not add the p o payment to the database.
	*
	* @param poPaymentId the primary key for the new p o payment
	* @return the new p o payment
	*/
	public static com.sphms.common.service.model.POPayment createPOPayment(
		long poPaymentId) {
		return getService().createPOPayment(poPaymentId);
	}

	/**
	* Deletes the p o payment from the database. Also notifies the appropriate model listeners.
	*
	* @param poPayment the p o payment
	* @return the p o payment that was removed
	*/
	public static com.sphms.common.service.model.POPayment deletePOPayment(
		com.sphms.common.service.model.POPayment poPayment) {
		return getService().deletePOPayment(poPayment);
	}

	/**
	* Deletes the p o payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param poPaymentId the primary key of the p o payment
	* @return the p o payment that was removed
	* @throws PortalException if a p o payment with the primary key could not be found
	*/
	public static com.sphms.common.service.model.POPayment deletePOPayment(
		long poPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePOPayment(poPaymentId);
	}

	public static com.sphms.common.service.model.POPayment fetchPOPayment(
		long poPaymentId) {
		return getService().fetchPOPayment(poPaymentId);
	}

	/**
	* Returns the p o payment with the primary key.
	*
	* @param poPaymentId the primary key of the p o payment
	* @return the p o payment
	* @throws PortalException if a p o payment with the primary key could not be found
	*/
	public static com.sphms.common.service.model.POPayment getPOPayment(
		long poPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPOPayment(poPaymentId);
	}

	/**
	* Updates the p o payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param poPayment the p o payment
	* @return the p o payment that was updated
	*/
	public static com.sphms.common.service.model.POPayment updatePOPayment(
		com.sphms.common.service.model.POPayment poPayment) {
		return getService().updatePOPayment(poPayment);
	}

	public static com.sphms.common.service.model.POPayment updatePOPayment(
		long poPaymentId, long billingId, long landLoardId, double amount,
		double gst, java.lang.String checqueNo, java.util.Date paymentDate,
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updatePOPayment(poPaymentId, billingId, landLoardId,
			amount, gst, checqueNo, paymentDate, userId);
	}

	/**
	* Returns the number of p o payments.
	*
	* @return the number of p o payments
	*/
	public static int getPOPaymentsCount() {
		return getService().getPOPaymentsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the p o payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p o payments
	* @param end the upper bound of the range of p o payments (not inclusive)
	* @return the range of p o payments
	*/
	public static java.util.List<com.sphms.common.service.model.POPayment> getPOPayments(
		int start, int end) {
		return getService().getPOPayments(start, end);
	}

	public static java.util.List<com.sphms.common.service.model.POPayment> getPOPaymnetByBillingIdAndHoardingId(
		long billingId, long landLoardId) {
		return getService()
				   .getPOPaymnetByBillingIdAndHoardingId(billingId, landLoardId);
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

	public static POPaymentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<POPaymentLocalService, POPaymentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(POPaymentLocalService.class);
}