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
 * Provides the local service utility for SupplierBill. This utility wraps
 * {@link com.sphms.common.service.service.impl.SupplierBillLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillLocalService
 * @see com.sphms.common.service.service.base.SupplierBillLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.SupplierBillLocalServiceImpl
 * @generated
 */
@ProviderType
public class SupplierBillLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.SupplierBillLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONObject getSupplierReportDetail(
		long customCompanyId, long supplierId, java.lang.String type,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getSupplierReportDetail(customCompanyId, supplierId, type,
			startDate, endDate);
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
	* Adds the supplier bill to the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBill the supplier bill
	* @return the supplier bill that was added
	*/
	public static com.sphms.common.service.model.SupplierBill addSupplierBill(
		com.sphms.common.service.model.SupplierBill supplierBill) {
		return getService().addSupplierBill(supplierBill);
	}

	public static com.sphms.common.service.model.SupplierBill addSupplierBill(
		long companyId, long supplierId, java.lang.String billNo,
		java.lang.String billDesc, java.lang.String billType,
		java.util.Date billDate, double amount, double gst, long createdBy) {
		return getService()
				   .addSupplierBill(companyId, supplierId, billNo, billDesc,
			billType, billDate, amount, gst, createdBy);
	}

	/**
	* Creates a new supplier bill with the primary key. Does not add the supplier bill to the database.
	*
	* @param supplierBillId the primary key for the new supplier bill
	* @return the new supplier bill
	*/
	public static com.sphms.common.service.model.SupplierBill createSupplierBill(
		long supplierBillId) {
		return getService().createSupplierBill(supplierBillId);
	}

	/**
	* Deletes the supplier bill from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBill the supplier bill
	* @return the supplier bill that was removed
	*/
	public static com.sphms.common.service.model.SupplierBill deleteSupplierBill(
		com.sphms.common.service.model.SupplierBill supplierBill) {
		return getService().deleteSupplierBill(supplierBill);
	}

	/**
	* Deletes the supplier bill with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill that was removed
	* @throws PortalException if a supplier bill with the primary key could not be found
	*/
	public static com.sphms.common.service.model.SupplierBill deleteSupplierBill(
		long supplierBillId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSupplierBill(supplierBillId);
	}

	public static com.sphms.common.service.model.SupplierBill fetchSupplierBill(
		long supplierBillId) {
		return getService().fetchSupplierBill(supplierBillId);
	}

	/**
	* Returns the supplier bill with the primary key.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill
	* @throws PortalException if a supplier bill with the primary key could not be found
	*/
	public static com.sphms.common.service.model.SupplierBill getSupplierBill(
		long supplierBillId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSupplierBill(supplierBillId);
	}

	/**
	* Updates the supplier bill in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supplierBill the supplier bill
	* @return the supplier bill that was updated
	*/
	public static com.sphms.common.service.model.SupplierBill updateSupplierBill(
		com.sphms.common.service.model.SupplierBill supplierBill) {
		return getService().updateSupplierBill(supplierBill);
	}

	public static com.sphms.common.service.model.SupplierBill updateSupplierBill(
		long supplierBillId, long companyId, long supplierId,
		java.lang.String billNo, java.lang.String billDesc,
		java.lang.String billType, java.util.Date billDate, double amount,
		double gst, long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateSupplierBill(supplierBillId, companyId, supplierId,
			billNo, billDesc, billType, billDate, amount, gst, createdBy);
	}

	/**
	* Returns the number of supplier bills.
	*
	* @return the number of supplier bills
	*/
	public static int getSupplierBillsCount() {
		return getService().getSupplierBillsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the supplier bills.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.SupplierBillModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supplier bills
	* @param end the upper bound of the range of supplier bills (not inclusive)
	* @return the range of supplier bills
	*/
	public static java.util.List<com.sphms.common.service.model.SupplierBill> getSupplierBills(
		int start, int end) {
		return getService().getSupplierBills(start, end);
	}

	public static java.util.List<com.sphms.common.service.model.SupplierBill> getSupplierBullListFromSearch(
		long supplierId, java.lang.String type, java.util.Date startDate,
		java.util.Date endDate, long customCompanyId, int start, int end) {
		return getService()
				   .getSupplierBullListFromSearch(supplierId, type, startDate,
			endDate, customCompanyId, start, end);
	}

	public static java.util.List<com.sphms.common.service.model.SupplierBill> getSupploerBillList(
		long supplierId) {
		return getService().getSupploerBillList(supplierId);
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

	public static SupplierBillLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SupplierBillLocalService, SupplierBillLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SupplierBillLocalService.class);
}