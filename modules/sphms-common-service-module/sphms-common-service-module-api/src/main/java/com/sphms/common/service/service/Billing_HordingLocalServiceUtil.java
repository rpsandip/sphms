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
 * Provides the local service utility for Billing_Hording. This utility wraps
 * {@link com.sphms.common.service.service.impl.Billing_HordingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Billing_HordingLocalService
 * @see com.sphms.common.service.service.base.Billing_HordingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.Billing_HordingLocalServiceImpl
 * @generated
 */
@ProviderType
public class Billing_HordingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.Billing_HordingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.sphms.common.service.model.Billing_Hording addBillingHording(
		long billingId, long hordingId, double totalMountingCharge,
		double totalPrintingCharge, int units, double totalHordingCharge,
		java.lang.String hsnNo) {
		return getService()
				   .addBillingHording(billingId, hordingId,
			totalMountingCharge, totalPrintingCharge, units,
			totalHordingCharge, hsnNo);
	}

	/**
	* Adds the billing_ hording to the database. Also notifies the appropriate model listeners.
	*
	* @param billing_Hording the billing_ hording
	* @return the billing_ hording that was added
	*/
	public static com.sphms.common.service.model.Billing_Hording addBilling_Hording(
		com.sphms.common.service.model.Billing_Hording billing_Hording) {
		return getService().addBilling_Hording(billing_Hording);
	}

	/**
	* Creates a new billing_ hording with the primary key. Does not add the billing_ hording to the database.
	*
	* @param billing_HordingPK the primary key for the new billing_ hording
	* @return the new billing_ hording
	*/
	public static com.sphms.common.service.model.Billing_Hording createBilling_Hording(
		com.sphms.common.service.service.persistence.Billing_HordingPK billing_HordingPK) {
		return getService().createBilling_Hording(billing_HordingPK);
	}

	/**
	* Deletes the billing_ hording from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_Hording the billing_ hording
	* @return the billing_ hording that was removed
	*/
	public static com.sphms.common.service.model.Billing_Hording deleteBilling_Hording(
		com.sphms.common.service.model.Billing_Hording billing_Hording) {
		return getService().deleteBilling_Hording(billing_Hording);
	}

	/**
	* Deletes the billing_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_HordingPK the primary key of the billing_ hording
	* @return the billing_ hording that was removed
	* @throws PortalException if a billing_ hording with the primary key could not be found
	*/
	public static com.sphms.common.service.model.Billing_Hording deleteBilling_Hording(
		com.sphms.common.service.service.persistence.Billing_HordingPK billing_HordingPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBilling_Hording(billing_HordingPK);
	}

	public static com.sphms.common.service.model.Billing_Hording fetchBilling_Hording(
		com.sphms.common.service.service.persistence.Billing_HordingPK billing_HordingPK) {
		return getService().fetchBilling_Hording(billing_HordingPK);
	}

	/**
	* Returns the billing_ hording with the primary key.
	*
	* @param billing_HordingPK the primary key of the billing_ hording
	* @return the billing_ hording
	* @throws PortalException if a billing_ hording with the primary key could not be found
	*/
	public static com.sphms.common.service.model.Billing_Hording getBilling_Hording(
		com.sphms.common.service.service.persistence.Billing_HordingPK billing_HordingPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBilling_Hording(billing_HordingPK);
	}

	/**
	* Updates the billing_ hording in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param billing_Hording the billing_ hording
	* @return the billing_ hording that was updated
	*/
	public static com.sphms.common.service.model.Billing_Hording updateBilling_Hording(
		com.sphms.common.service.model.Billing_Hording billing_Hording) {
		return getService().updateBilling_Hording(billing_Hording);
	}

	/**
	* Returns the number of billing_ hordings.
	*
	* @return the number of billing_ hordings
	*/
	public static int getBilling_HordingsCount() {
		return getService().getBilling_HordingsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.sphms.common.service.model.Billing_Hording> getBillingHordingList(
		long billingId) {
		return getService().getBillingHordingList(billingId);
	}

	/**
	* Returns a range of all the billing_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ hordings
	* @param end the upper bound of the range of billing_ hordings (not inclusive)
	* @return the range of billing_ hordings
	*/
	public static java.util.List<com.sphms.common.service.model.Billing_Hording> getBilling_Hordings(
		int start, int end) {
		return getService().getBilling_Hordings(start, end);
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

	public static Billing_HordingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Billing_HordingLocalService, Billing_HordingLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Billing_HordingLocalService.class);
}