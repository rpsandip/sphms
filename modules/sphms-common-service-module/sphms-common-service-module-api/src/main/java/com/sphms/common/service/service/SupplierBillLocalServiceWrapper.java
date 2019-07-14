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
 * Provides a wrapper for {@link SupplierBillLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillLocalService
 * @generated
 */
@ProviderType
public class SupplierBillLocalServiceWrapper implements SupplierBillLocalService,
	ServiceWrapper<SupplierBillLocalService> {
	public SupplierBillLocalServiceWrapper(
		SupplierBillLocalService supplierBillLocalService) {
		_supplierBillLocalService = supplierBillLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _supplierBillLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supplierBillLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _supplierBillLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getSupplierReportDetail(
		long customCompanyId, long supplierId, java.lang.String type,
		java.util.Date startDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillLocalService.getSupplierReportDetail(customCompanyId,
			supplierId, type, startDate, endDate);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the supplier bill to the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBill the supplier bill
	* @return the supplier bill that was added
	*/
	@Override
	public com.sphms.common.service.model.SupplierBill addSupplierBill(
		com.sphms.common.service.model.SupplierBill supplierBill) {
		return _supplierBillLocalService.addSupplierBill(supplierBill);
	}

	@Override
	public com.sphms.common.service.model.SupplierBill addSupplierBill(
		long companyId, long supplierId, java.lang.String billNo,
		java.lang.String billDesc, java.lang.String billType,
		java.util.Date billDate, double amount, double gst, long createdBy) {
		return _supplierBillLocalService.addSupplierBill(companyId, supplierId,
			billNo, billDesc, billType, billDate, amount, gst, createdBy);
	}

	/**
	* Creates a new supplier bill with the primary key. Does not add the supplier bill to the database.
	*
	* @param supplierBillId the primary key for the new supplier bill
	* @return the new supplier bill
	*/
	@Override
	public com.sphms.common.service.model.SupplierBill createSupplierBill(
		long supplierBillId) {
		return _supplierBillLocalService.createSupplierBill(supplierBillId);
	}

	/**
	* Deletes the supplier bill from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBill the supplier bill
	* @return the supplier bill that was removed
	*/
	@Override
	public com.sphms.common.service.model.SupplierBill deleteSupplierBill(
		com.sphms.common.service.model.SupplierBill supplierBill) {
		return _supplierBillLocalService.deleteSupplierBill(supplierBill);
	}

	/**
	* Deletes the supplier bill with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill that was removed
	* @throws PortalException if a supplier bill with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.SupplierBill deleteSupplierBill(
		long supplierBillId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillLocalService.deleteSupplierBill(supplierBillId);
	}

	@Override
	public com.sphms.common.service.model.SupplierBill fetchSupplierBill(
		long supplierBillId) {
		return _supplierBillLocalService.fetchSupplierBill(supplierBillId);
	}

	/**
	* Returns the supplier bill with the primary key.
	*
	* @param supplierBillId the primary key of the supplier bill
	* @return the supplier bill
	* @throws PortalException if a supplier bill with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.SupplierBill getSupplierBill(
		long supplierBillId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillLocalService.getSupplierBill(supplierBillId);
	}

	/**
	* Updates the supplier bill in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supplierBill the supplier bill
	* @return the supplier bill that was updated
	*/
	@Override
	public com.sphms.common.service.model.SupplierBill updateSupplierBill(
		com.sphms.common.service.model.SupplierBill supplierBill) {
		return _supplierBillLocalService.updateSupplierBill(supplierBill);
	}

	@Override
	public com.sphms.common.service.model.SupplierBill updateSupplierBill(
		long supplierBillId, long companyId, long supplierId,
		java.lang.String billNo, java.lang.String billDesc,
		java.lang.String billType, java.util.Date billDate, double amount,
		double gst, long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillLocalService.updateSupplierBill(supplierBillId,
			companyId, supplierId, billNo, billDesc, billType, billDate,
			amount, gst, createdBy);
	}

	/**
	* Returns the number of supplier bills.
	*
	* @return the number of supplier bills
	*/
	@Override
	public int getSupplierBillsCount() {
		return _supplierBillLocalService.getSupplierBillsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _supplierBillLocalService.getOSGiServiceIdentifier();
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
		return _supplierBillLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _supplierBillLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _supplierBillLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<com.sphms.common.service.model.SupplierBill> getSupplierBills(
		int start, int end) {
		return _supplierBillLocalService.getSupplierBills(start, end);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.SupplierBill> getSupplierBullListFromSearch(
		long supplierId, java.lang.String type, java.util.Date startDate,
		java.util.Date endDate, long customCompanyId, int start, int end) {
		return _supplierBillLocalService.getSupplierBullListFromSearch(supplierId,
			type, startDate, endDate, customCompanyId, start, end);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.SupplierBill> getSupploerBillList(
		long supplierId) {
		return _supplierBillLocalService.getSupploerBillList(supplierId);
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
		return _supplierBillLocalService.dynamicQueryCount(dynamicQuery);
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
		return _supplierBillLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public SupplierBillLocalService getWrappedService() {
		return _supplierBillLocalService;
	}

	@Override
	public void setWrappedService(
		SupplierBillLocalService supplierBillLocalService) {
		_supplierBillLocalService = supplierBillLocalService;
	}

	private SupplierBillLocalService _supplierBillLocalService;
}