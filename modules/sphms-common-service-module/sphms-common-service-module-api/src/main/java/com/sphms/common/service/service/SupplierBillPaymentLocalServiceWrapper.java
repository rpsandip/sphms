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
 * Provides a wrapper for {@link SupplierBillPaymentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPaymentLocalService
 * @generated
 */
@ProviderType
public class SupplierBillPaymentLocalServiceWrapper
	implements SupplierBillPaymentLocalService,
		ServiceWrapper<SupplierBillPaymentLocalService> {
	public SupplierBillPaymentLocalServiceWrapper(
		SupplierBillPaymentLocalService supplierBillPaymentLocalService) {
		_supplierBillPaymentLocalService = supplierBillPaymentLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _supplierBillPaymentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supplierBillPaymentLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _supplierBillPaymentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillPaymentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillPaymentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the supplier bill payment to the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPayment the supplier bill payment
	* @return the supplier bill payment that was added
	*/
	@Override
	public com.sphms.common.service.model.SupplierBillPayment addSupplierBillPayment(
		com.sphms.common.service.model.SupplierBillPayment supplierBillPayment) {
		return _supplierBillPaymentLocalService.addSupplierBillPayment(supplierBillPayment);
	}

	@Override
	public com.sphms.common.service.model.SupplierBillPayment addSupplierBillPayment(
		long supplierId, long supplierBillId, double amount, double gst,
		java.util.Date paymentDate, java.lang.String chequeNo, long createdBy) {
		return _supplierBillPaymentLocalService.addSupplierBillPayment(supplierId,
			supplierBillId, amount, gst, paymentDate, chequeNo, createdBy);
	}

	/**
	* Creates a new supplier bill payment with the primary key. Does not add the supplier bill payment to the database.
	*
	* @param supplierBillPaymentId the primary key for the new supplier bill payment
	* @return the new supplier bill payment
	*/
	@Override
	public com.sphms.common.service.model.SupplierBillPayment createSupplierBillPayment(
		long supplierBillPaymentId) {
		return _supplierBillPaymentLocalService.createSupplierBillPayment(supplierBillPaymentId);
	}

	/**
	* Deletes the supplier bill payment from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPayment the supplier bill payment
	* @return the supplier bill payment that was removed
	*/
	@Override
	public com.sphms.common.service.model.SupplierBillPayment deleteSupplierBillPayment(
		com.sphms.common.service.model.SupplierBillPayment supplierBillPayment) {
		return _supplierBillPaymentLocalService.deleteSupplierBillPayment(supplierBillPayment);
	}

	/**
	* Deletes the supplier bill payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment that was removed
	* @throws PortalException if a supplier bill payment with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.SupplierBillPayment deleteSupplierBillPayment(
		long supplierBillPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillPaymentLocalService.deleteSupplierBillPayment(supplierBillPaymentId);
	}

	@Override
	public com.sphms.common.service.model.SupplierBillPayment fetchSupplierBillPayment(
		long supplierBillPaymentId) {
		return _supplierBillPaymentLocalService.fetchSupplierBillPayment(supplierBillPaymentId);
	}

	/**
	* Returns the supplier bill payment with the primary key.
	*
	* @param supplierBillPaymentId the primary key of the supplier bill payment
	* @return the supplier bill payment
	* @throws PortalException if a supplier bill payment with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.SupplierBillPayment getSupplierBillPayment(
		long supplierBillPaymentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillPaymentLocalService.getSupplierBillPayment(supplierBillPaymentId);
	}

	/**
	* Updates the supplier bill payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supplierBillPayment the supplier bill payment
	* @return the supplier bill payment that was updated
	*/
	@Override
	public com.sphms.common.service.model.SupplierBillPayment updateSupplierBillPayment(
		com.sphms.common.service.model.SupplierBillPayment supplierBillPayment) {
		return _supplierBillPaymentLocalService.updateSupplierBillPayment(supplierBillPayment);
	}

	@Override
	public com.sphms.common.service.model.SupplierBillPayment updateSupplierBillPayment(
		long supplierBillPaymentId, long supplierId, long supplierBillId,
		double amount, double gst, java.util.Date paymentDate,
		java.lang.String chequeNo, long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supplierBillPaymentLocalService.updateSupplierBillPayment(supplierBillPaymentId,
			supplierId, supplierBillId, amount, gst, paymentDate, chequeNo,
			createdBy);
	}

	/**
	* Returns the number of supplier bill payments.
	*
	* @return the number of supplier bill payments
	*/
	@Override
	public int getSupplierBillPaymentsCount() {
		return _supplierBillPaymentLocalService.getSupplierBillPaymentsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _supplierBillPaymentLocalService.getOSGiServiceIdentifier();
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
		return _supplierBillPaymentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _supplierBillPaymentLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _supplierBillPaymentLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.SupplierBillPayment> getSupplierBillPaymentBySupplierBillId(
		long supplierBillId) {
		return _supplierBillPaymentLocalService.getSupplierBillPaymentBySupplierBillId(supplierBillId);
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
	@Override
	public java.util.List<com.sphms.common.service.model.SupplierBillPayment> getSupplierBillPayments(
		int start, int end) {
		return _supplierBillPaymentLocalService.getSupplierBillPayments(start,
			end);
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
		return _supplierBillPaymentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _supplierBillPaymentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public SupplierBillPaymentLocalService getWrappedService() {
		return _supplierBillPaymentLocalService;
	}

	@Override
	public void setWrappedService(
		SupplierBillPaymentLocalService supplierBillPaymentLocalService) {
		_supplierBillPaymentLocalService = supplierBillPaymentLocalService;
	}

	private SupplierBillPaymentLocalService _supplierBillPaymentLocalService;
}