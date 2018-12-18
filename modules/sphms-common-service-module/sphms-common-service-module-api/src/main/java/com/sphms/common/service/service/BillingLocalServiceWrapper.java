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
 * Provides a wrapper for {@link BillingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BillingLocalService
 * @generated
 */
@ProviderType
public class BillingLocalServiceWrapper implements BillingLocalService,
	ServiceWrapper<BillingLocalService> {
	public BillingLocalServiceWrapper(BillingLocalService billingLocalService) {
		_billingLocalService = billingLocalService;
	}

	@Override
	public boolean publishBilling(long billingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billingLocalService.publishBilling(billingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _billingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _billingLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _billingLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getBillingListForReport(
		long customComanyId, long clientId, int status,
		java.util.Date startDate, java.util.Date endDate) {
		return _billingLocalService.getBillingListForReport(customComanyId,
			clientId, status, startDate, endDate);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the billing to the database. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was added
	*/
	@Override
	public com.sphms.common.service.model.Billing addBilling(
		com.sphms.common.service.model.Billing billing) {
		return _billingLocalService.addBilling(billing);
	}

	@Override
	public com.sphms.common.service.model.Billing addBillingForBooking(
		com.sphms.common.service.model.Booking booking, long clientId,
		long companyId, java.lang.String clientPANum,
		java.lang.String clientPONum, java.lang.String clientGSTNum,
		java.lang.String display, double accessAmount, double pendingAmount,
		long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billingLocalService.addBillingForBooking(booking, clientId,
			companyId, clientPANum, clientPONum, clientGSTNum, display,
			accessAmount, pendingAmount, createdBy);
	}

	/**
	* Creates a new billing with the primary key. Does not add the billing to the database.
	*
	* @param billingId the primary key for the new billing
	* @return the new billing
	*/
	@Override
	public com.sphms.common.service.model.Billing createBilling(long billingId) {
		return _billingLocalService.createBilling(billingId);
	}

	/**
	* Deletes the billing from the database. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was removed
	*/
	@Override
	public com.sphms.common.service.model.Billing deleteBilling(
		com.sphms.common.service.model.Billing billing) {
		return _billingLocalService.deleteBilling(billing);
	}

	/**
	* Deletes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billingId the primary key of the billing
	* @return the billing that was removed
	* @throws PortalException if a billing with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Billing deleteBilling(long billingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billingLocalService.deleteBilling(billingId);
	}

	@Override
	public com.sphms.common.service.model.Billing fetchBilling(long billingId) {
		return _billingLocalService.fetchBilling(billingId);
	}

	/**
	* Returns the billing with the primary key.
	*
	* @param billingId the primary key of the billing
	* @return the billing
	* @throws PortalException if a billing with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Billing getBilling(long billingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billingLocalService.getBilling(billingId);
	}

	@Override
	public com.sphms.common.service.model.Billing getBillingFromBookingId(
		long bookingId)
		throws com.sphms.common.service.exception.NoSuchBillingException {
		return _billingLocalService.getBillingFromBookingId(bookingId);
	}

	/**
	* Updates the billing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was updated
	*/
	@Override
	public com.sphms.common.service.model.Billing updateBilling(
		com.sphms.common.service.model.Billing billing) {
		return _billingLocalService.updateBilling(billing);
	}

	@Override
	public com.sphms.common.service.model.Billing updateBilling(
		long billingId, java.lang.String clientPANum,
		java.lang.String clientPONum, java.lang.String clientGSTNum,
		java.lang.String display, double accessAmount, double pendingAmount,
		java.util.List<com.sphms.common.service.beans.Billing_HordingBean> billing_HordingBeanList,
		java.util.Date publishDate, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _billingLocalService.updateBilling(billingId, clientPANum,
			clientPONum, clientGSTNum, display, accessAmount, pendingAmount,
			billing_HordingBeanList, publishDate, modifiedBy);
	}

	/**
	* Returns the number of billings.
	*
	* @return the number of billings
	*/
	@Override
	public int getBillingsCount() {
		return _billingLocalService.getBillingsCount();
	}

	@Override
	public java.lang.String getDisplayBillNo(
		com.sphms.common.service.model.Billing billing) {
		return _billingLocalService.getDisplayBillNo(billing);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _billingLocalService.getOSGiServiceIdentifier();
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
		return _billingLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _billingLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _billingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Billing> getBillingList(
		long customComanyId, long clientId, int status,
		java.util.Date startDate, java.util.Date endDate, int start, int end) {
		return _billingLocalService.getBillingList(customComanyId, clientId,
			status, startDate, endDate, start, end);
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
	@Override
	public java.util.List<com.sphms.common.service.model.Billing> getBillings(
		int start, int end) {
		return _billingLocalService.getBillings(start, end);
	}

	@Override
	public java.util.List<com.sphms.common.service.beans.BillingBean> getClientBillings(
		long clientId) {
		return _billingLocalService.getClientBillings(clientId);
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
		return _billingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _billingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public long getBillingCount(long customCompanyId, long clientId,
		int status, java.util.Date startDate, java.util.Date endDate) {
		return _billingLocalService.getBillingCount(customCompanyId, clientId,
			status, startDate, endDate);
	}

	@Override
	public void updateBillingHordingWhileUpdateBooking(
		com.sphms.common.service.model.Billing billing,
		com.sphms.common.service.model.Booking booking)
		throws com.liferay.portal.kernel.exception.PortalException {
		_billingLocalService.updateBillingHordingWhileUpdateBooking(billing,
			booking);
	}

	@Override
	public void updateBillingHordings(
		com.sphms.common.service.model.Billing billing,
		com.sphms.common.service.model.Booking booking,
		com.sphms.common.service.model.CustomCompany company)
		throws com.liferay.portal.kernel.exception.PortalException {
		_billingLocalService.updateBillingHordings(billing, booking, company);
	}

	@Override
	public BillingLocalService getWrappedService() {
		return _billingLocalService;
	}

	@Override
	public void setWrappedService(BillingLocalService billingLocalService) {
		_billingLocalService = billingLocalService;
	}

	private BillingLocalService _billingLocalService;
}