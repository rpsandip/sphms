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
 * Provides the local service utility for SupplierBillPayment. This utility wraps
 * {@link com.sphms.common.service.service.impl.SupplierBillPaymentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPaymentLocalService
 * @see com.sphms.common.service.service.base.SupplierBillPaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.SupplierBillPaymentLocalServiceImpl
 * @generated
 */
@ProviderType
public class SupplierBillPaymentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.SupplierBillPaymentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the supplier bill payment to the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPayment the supplier bill payment
	* @return the supplier bill payment that was added
	*/
	public static com.sphms.common.service.model.SupplierBillPayment addSupplierBillPayment(
		com.sphms.common.service.model.SupplierBillPayment supplierBillPayment) {
		return getService().addSupplierBillPayment(supplierBillPayment);
	}

	public static com.sphms.common.service.model.SupplierBillPayment addSupplierBillPayment(
		long supplierId, long supplierBillId, double amount, double gst,
		java.util.Date paymentDate, java.lang.String chequeNo, long createdBy) {
		return getService()
				   .addSupplierBillPayment(supplierId, supplierBillId, amount,
			gst, paymentDate, chequeNo, createdBy);
	}

	/**
	* Creates a new supplier bill payment with the primary key. Does not add the supplier bill payment to the database.
	*
	* @param supplierBillPaymentId the primary key for the new supplier bill payment
	* @return the new supplier bill payment
	*/
	public static com.sphms.common.service.model.SupplierBillPayment createSupplierBillPayment(
		long supplierBillPaymentId) {
		return getService().createSupplierBillPayment(supplierBillPaymentId);
	}

	/**
	* Deletes the supplier bill payment from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPayment the supplier bill payment
	* @return the supplier bill payment that was removed
	*/
	public static com.sphms.common.service.model.SupplierBillPayment deleteSupplierBillPayment(
		com.sphms.common.service.model.SupplierBillPayment supplierBillPayment) {
		return getService().deleteSupplierBillPayment(supplierBillPayment);
	}

	/**
	* Deletes the supplier bill payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment that was removed
	* @throws PortalException if a supplier bill payment with the primary key could not be found
	*/
	public static com.sphms.common.service.model.SupplierBillPayment deleteSupplierBillPayment(
		long supplierBillPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSupplierBillPayment(supplierBillPaymentId);
	}

	public static com.sphms.common.service.model.SupplierBillPayment fetchSupplierBillPayment(
		long supplierBillPaymentId) {
		return getService().fetchSupplierBillPayment(supplierBillPaymentId);
	}

	/**
	* Returns the supplier bill payment with the primary key.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment
	* @throws PortalException if a supplier bill payment with the primary key could not be found
	*/
	public static com.sphms.common.service.model.SupplierBillPayment getSupplierBillPayment(
		long supplierBillPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSupplierBillPayment(supplierBillPaymentId);
	}

	/**
	* Updates the supplier bill payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPayment the supplier bill payment
	* @return the supplier bill payment that was updated
	*/
	public static com.sphms.common.service.model.SupplierBillPayment updateSupplierBillPayment(
		com.sphms.common.service.model.SupplierBillPayment supplierBillPayment) {
		return getService().updateSupplierBillPayment(supplierBillPayment);
	}

	public static com.sphms.common.service.model.SupplierBillPayment updateSupplierBillPayment(
		long supplierBillPaymentId, long supplierId, long supplierBillId,
		double amount, double gst, java.util.Date paymentDate,
		java.lang.String chequeNo, long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateSupplierBillPayment(supplierBillPaymentId,
			supplierId, supplierBillId, amount, gst, paymentDate, chequeNo,
			createdBy);
	}

	/**
	* Returns the number of supplier bill payments.
	*
	* @return the number of supplier bill payments
	*/
	public static int getSupplierBillPaymentsCount() {
		return getService().getSupplierBillPaymentsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.sphms.common.service.model.SupplierBillPayment> getSupplierBillPaymentBySupplierBillId(
		long supplierBillId) {
		return getService()
				   .getSupplierBillPaymentBySupplierBillId(supplierBillId);
	}

	/**
	* Returns a range of all the supplier bill payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supplier bill payments
	* @param end the upper bound of the range of supplier bill payments (not inclusive)
	* @return the range of supplier bill payments
	*/
	public static java.util.List<com.sphms.common.service.model.SupplierBillPayment> getSupplierBillPayments(
		int start, int end) {
		return getService().getSupplierBillPayments(start, end);
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

	public static SupplierBillPaymentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SupplierBillPaymentLocalService, SupplierBillPaymentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SupplierBillPaymentLocalService.class);
}