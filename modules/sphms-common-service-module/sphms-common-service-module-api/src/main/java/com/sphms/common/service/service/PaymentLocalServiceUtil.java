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
 * Provides the local service utility for Payment. This utility wraps
 * {@link com.sphms.common.service.service.impl.PaymentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PaymentLocalService
 * @see com.sphms.common.service.service.base.PaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.PaymentLocalServiceImpl
 * @generated
 */
@ProviderType
public class PaymentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.PaymentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the payment to the database. Also notifies the appropriate model listeners.
	*
	* @param payment the payment
	* @return the payment that was added
	*/
	public static com.sphms.common.service.model.Payment addPayment(
		com.sphms.common.service.model.Payment payment) {
		return getService().addPayment(payment);
	}

	public static com.sphms.common.service.model.Payment addPayment(
		long billingId, double amount, java.lang.String chequeNo, double tds,
		double deduction, long createdBy) {
		return getService()
				   .addPayment(billingId, amount, chequeNo, tds, deduction,
			createdBy);
	}

	/**
	* Creates a new payment with the primary key. Does not add the payment to the database.
	*
	* @param paymentId the primary key for the new payment
	* @return the new payment
	*/
	public static com.sphms.common.service.model.Payment createPayment(
		long paymentId) {
		return getService().createPayment(paymentId);
	}

	/**
	* Deletes the payment from the database. Also notifies the appropriate model listeners.
	*
	* @param payment the payment
	* @return the payment that was removed
	*/
	public static com.sphms.common.service.model.Payment deletePayment(
		com.sphms.common.service.model.Payment payment) {
		return getService().deletePayment(payment);
	}

	/**
	* Deletes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param paymentId the primary key of the payment
	* @return the payment that was removed
	* @throws PortalException if a payment with the primary key could not be found
	*/
	public static com.sphms.common.service.model.Payment deletePayment(
		long paymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePayment(paymentId);
	}

	public static com.sphms.common.service.model.Payment fetchPayment(
		long paymentId) {
		return getService().fetchPayment(paymentId);
	}

	/**
	* Returns the payment with the primary key.
	*
	* @param paymentId the primary key of the payment
	* @return the payment
	* @throws PortalException if a payment with the primary key could not be found
	*/
	public static com.sphms.common.service.model.Payment getPayment(
		long paymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPayment(paymentId);
	}

	/**
	* Updates the payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param payment the payment
	* @return the payment that was updated
	*/
	public static com.sphms.common.service.model.Payment updatePayment(
		com.sphms.common.service.model.Payment payment) {
		return getService().updatePayment(payment);
	}

	public static com.sphms.common.service.model.Payment updatePayment(
		long paymentId, long billingId, double amount,
		java.lang.String chequeNo, double tds, double deduction, long modifiedBy) {
		return getService()
				   .updatePayment(paymentId, billingId, amount, chequeNo, tds,
			deduction, modifiedBy);
	}

	/**
	* Returns the number of payments.
	*
	* @return the number of payments
	*/
	public static int getPaymentsCount() {
		return getService().getPaymentsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of payments
	* @param end the upper bound of the range of payments (not inclusive)
	* @return the range of payments
	*/
	public static java.util.List<com.sphms.common.service.model.Payment> getPayments(
		int start, int end) {
		return getService().getPayments(start, end);
	}

	public static java.util.List<com.sphms.common.service.model.Payment> getPaymentsOfBill(
		long billingId) {
		return getService().getPaymentsOfBill(billingId);
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

	public static PaymentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PaymentLocalService, PaymentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PaymentLocalService.class);
}