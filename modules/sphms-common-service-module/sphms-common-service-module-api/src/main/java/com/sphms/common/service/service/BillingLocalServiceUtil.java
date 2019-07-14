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
 * Provides the local service utility for Billing. This utility wraps
 * {@link com.sphms.common.service.service.impl.BillingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BillingLocalService
 * @see com.sphms.common.service.service.base.BillingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.BillingLocalServiceImpl
 * @generated
 */
@ProviderType
public class BillingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.BillingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean publishBilling(long billingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().publishBilling(billingId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.json.JSONObject getBillingListForReport(
		long customComanyId, long clientId, int status,
		java.util.Date startDate, java.util.Date endDate) {
		return getService()
				   .getBillingListForReport(customComanyId, clientId, status,
			startDate, endDate);
	}

	public static com.liferay.portal.kernel.json.JSONObject getCompanyBillingDetail(
		long customCompanyId, java.lang.String startDate,
		java.lang.String endDate) {
		return getService()
				   .getCompanyBillingDetail(customCompanyId, startDate, endDate);
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
	* Adds the billing to the database. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was added
	*/
	public static com.sphms.common.service.model.Billing addBilling(
		com.sphms.common.service.model.Billing billing) {
		return getService().addBilling(billing);
	}

	public static com.sphms.common.service.model.Billing addBillingForBooking(
		com.sphms.common.service.model.Booking booking, long clientId,
		long companyId, java.lang.String clientPANum,
		java.lang.String clientPONum, java.lang.String clientGSTNum,
		java.lang.String display, double accessAmount, double pendingAmount,
		long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addBillingForBooking(booking, clientId, companyId,
			clientPANum, clientPONum, clientGSTNum, display, accessAmount,
			pendingAmount, createdBy);
	}

	/**
	* Creates a new billing with the primary key. Does not add the billing to the database.
	*
	* @param billingId the primary key for the new billing
	* @return the new billing
	*/
	public static com.sphms.common.service.model.Billing createBilling(
		long billingId) {
		return getService().createBilling(billingId);
	}

	/**
	* Deletes the billing from the database. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was removed
	*/
	public static com.sphms.common.service.model.Billing deleteBilling(
		com.sphms.common.service.model.Billing billing) {
		return getService().deleteBilling(billing);
	}

	/**
	* Deletes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billingId the primary key of the billing
	* @return the billing that was removed
	* @throws PortalException if a billing with the primary key could not be found
	*/
	public static com.sphms.common.service.model.Billing deleteBilling(
		long billingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBilling(billingId);
	}

	public static com.sphms.common.service.model.Billing fetchBilling(
		long billingId) {
		return getService().fetchBilling(billingId);
	}

	/**
	* Returns the billing with the primary key.
	*
	* @param billingId the primary key of the billing
	* @return the billing
	* @throws PortalException if a billing with the primary key could not be found
	*/
	public static com.sphms.common.service.model.Billing getBilling(
		long billingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBilling(billingId);
	}

	public static com.sphms.common.service.model.Billing getBillingFromBookingId(
		long bookingId)
		throws com.sphms.common.service.exception.NoSuchBillingException {
		return getService().getBillingFromBookingId(bookingId);
	}

	/**
	* Updates the billing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was updated
	*/
	public static com.sphms.common.service.model.Billing updateBilling(
		com.sphms.common.service.model.Billing billing) {
		return getService().updateBilling(billing);
	}

	public static com.sphms.common.service.model.Billing updateBilling(
		long billingId, java.lang.String clientPANum,
		java.lang.String clientPONum, java.lang.String clientGSTNum,
		java.lang.String display, double accessAmount, double pendingAmount,
		java.util.List<com.sphms.common.service.beans.Billing_HordingBean> billing_HordingBeanList,
		java.util.Date publishDate, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateBilling(billingId, clientPANum, clientPONum,
			clientGSTNum, display, accessAmount, pendingAmount,
			billing_HordingBeanList, publishDate, modifiedBy);
	}

	/**
	* Returns the number of billings.
	*
	* @return the number of billings
	*/
	public static int getBillingsCount() {
		return getService().getBillingsCount();
	}

	public static java.lang.String getDisplayBillNo(
		com.sphms.common.service.model.Billing billing) {
		return getService().getDisplayBillNo(billing);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.sphms.common.service.model.Billing> getBillingList(
		long customComanyId, long clientId, int status,
		java.util.Date startDate, java.util.Date endDate, int start, int end) {
		return getService()
				   .getBillingList(customComanyId, clientId, status, startDate,
			endDate, start, end);
	}

	/**
	* Returns a range of all the billings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billings
	* @param end the upper bound of the range of billings (not inclusive)
	* @return the range of billings
	*/
	public static java.util.List<com.sphms.common.service.model.Billing> getBillings(
		int start, int end) {
		return getService().getBillings(start, end);
	}

	public static java.util.List<com.sphms.common.service.beans.BillingBean> getClientBillings(
		long clientId) {
		return getService().getClientBillings(clientId);
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

	public static long getBillingCount(long customCompanyId, long clientId,
		int status, java.util.Date startDate, java.util.Date endDate) {
		return getService()
				   .getBillingCount(customCompanyId, clientId, status,
			startDate, endDate);
	}

	public static void updateBillingHordingWhileUpdateBooking(
		com.sphms.common.service.model.Billing billing,
		com.sphms.common.service.model.Booking booking)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateBillingHordingWhileUpdateBooking(billing, booking);
	}

	public static void updateBillingHordings(
		com.sphms.common.service.model.Billing billing,
		com.sphms.common.service.model.Booking booking,
		com.sphms.common.service.model.CustomCompany company)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().updateBillingHordings(billing, booking, company);
	}

	public static BillingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BillingLocalService, BillingLocalService> _serviceTracker =
		ServiceTrackerFactory.open(BillingLocalService.class);
}