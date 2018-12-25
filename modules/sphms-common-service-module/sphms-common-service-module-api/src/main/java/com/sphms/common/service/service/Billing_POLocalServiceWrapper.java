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
 * Provides a wrapper for {@link Billing_POLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Billing_POLocalService
 * @generated
 */
@ProviderType
public class Billing_POLocalServiceWrapper implements Billing_POLocalService,
	ServiceWrapper<Billing_POLocalService> {
	public Billing_POLocalServiceWrapper(
		Billing_POLocalService billing_POLocalService) {
		_billing_POLocalService = billing_POLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _billing_POLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _billing_POLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _billing_POLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getBillingPOListForReport(
		long customComanyId, long landLoardId, java.util.Date startDate,
		java.util.Date endDate, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billing_POLocalService.getBillingPOListForReport(customComanyId,
			landLoardId, startDate, endDate, start, end);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billing_POLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billing_POLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.sphms.common.service.model.Billing_PO addBillingPO(
		long billingId, long hordingId, double totalAmount, long createdBy,
		com.sphms.common.service.model.CustomCompany company) {
		return _billing_POLocalService.addBillingPO(billingId, hordingId,
			totalAmount, createdBy, company);
	}

	/**
	* Adds the billing_ p o to the database. Also notifies the appropriate model listeners.
	*
	* @param billing_PO the billing_ p o
	* @return the billing_ p o that was added
	*/
	@Override
	public com.sphms.common.service.model.Billing_PO addBilling_PO(
		com.sphms.common.service.model.Billing_PO billing_PO) {
		return _billing_POLocalService.addBilling_PO(billing_PO);
	}

	/**
	* Creates a new billing_ p o with the primary key. Does not add the billing_ p o to the database.
	*
	* @param billing_POPK the primary key for the new billing_ p o
	* @return the new billing_ p o
	*/
	@Override
	public com.sphms.common.service.model.Billing_PO createBilling_PO(
		com.sphms.common.service.service.persistence.Billing_POPK billing_POPK) {
		return _billing_POLocalService.createBilling_PO(billing_POPK);
	}

	/**
	* Deletes the billing_ p o from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_PO the billing_ p o
	* @return the billing_ p o that was removed
	*/
	@Override
	public com.sphms.common.service.model.Billing_PO deleteBilling_PO(
		com.sphms.common.service.model.Billing_PO billing_PO) {
		return _billing_POLocalService.deleteBilling_PO(billing_PO);
	}

	/**
	* Deletes the billing_ p o with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_POPK the primary key of the billing_ p o
	* @return the billing_ p o that was removed
	* @throws PortalException if a billing_ p o with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Billing_PO deleteBilling_PO(
		com.sphms.common.service.service.persistence.Billing_POPK billing_POPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billing_POLocalService.deleteBilling_PO(billing_POPK);
	}

	@Override
	public com.sphms.common.service.model.Billing_PO fetchBilling_PO(
		com.sphms.common.service.service.persistence.Billing_POPK billing_POPK) {
		return _billing_POLocalService.fetchBilling_PO(billing_POPK);
	}

	/**
	* Returns the billing_ p o with the primary key.
	*
	* @param billing_POPK the primary key of the billing_ p o
	* @return the billing_ p o
	* @throws PortalException if a billing_ p o with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Billing_PO getBilling_PO(
		com.sphms.common.service.service.persistence.Billing_POPK billing_POPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billing_POLocalService.getBilling_PO(billing_POPK);
	}

	/**
	* Updates the billing_ p o in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param billing_PO the billing_ p o
	* @return the billing_ p o that was updated
	*/
	@Override
	public com.sphms.common.service.model.Billing_PO updateBilling_PO(
		com.sphms.common.service.model.Billing_PO billing_PO) {
		return _billing_POLocalService.updateBilling_PO(billing_PO);
	}

	/**
	* Returns the number of billing_ p os.
	*
	* @return the number of billing_ p os
	*/
	@Override
	public int getBilling_POsCount() {
		return _billing_POLocalService.getBilling_POsCount();
	}

	@Override
	public java.lang.String getNextPONumber(long billingId, long landLordId,
		long companyId) {
		return _billing_POLocalService.getNextPONumber(billingId, landLordId,
			companyId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _billing_POLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String getPONumber(
		com.sphms.common.service.model.Billing_PO billingPO,
		com.sphms.common.service.model.CustomCompany company) {
		return _billing_POLocalService.getPONumber(billingPO, company);
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
		return _billing_POLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _billing_POLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _billing_POLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Billing_PO> getBillingPOListByBillingId(
		long billingId) {
		return _billing_POLocalService.getBillingPOListByBillingId(billingId);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Billing_PO> getBilling_POByBillingIdAndLandLordId(
		long billingId, long landLordId) {
		return _billing_POLocalService.getBilling_POByBillingIdAndLandLordId(billingId,
			landLordId);
	}

	/**
	* Returns a range of all the billing_ p os.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of billing_ p os
	* @param end the upper bound of the range of billing_ p os (not inclusive)
	* @return the range of billing_ p os
	*/
	@Override
	public java.util.List<com.sphms.common.service.model.Billing_PO> getBilling_POs(
		int start, int end) {
		return _billing_POLocalService.getBilling_POs(start, end);
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
		return _billing_POLocalService.dynamicQueryCount(dynamicQuery);
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
		return _billing_POLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public Billing_POLocalService getWrappedService() {
		return _billing_POLocalService;
	}

	@Override
	public void setWrappedService(Billing_POLocalService billing_POLocalService) {
		_billing_POLocalService = billing_POLocalService;
	}

	private Billing_POLocalService _billing_POLocalService;
}