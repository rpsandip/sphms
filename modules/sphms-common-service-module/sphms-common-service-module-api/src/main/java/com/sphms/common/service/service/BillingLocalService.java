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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sphms.common.service.beans.BillingBean;
import com.sphms.common.service.beans.Billing_HordingBean;
import com.sphms.common.service.exception.NoSuchBillingException;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.CustomCompany;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for Billing. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BillingLocalServiceUtil
 * @see com.sphms.common.service.service.base.BillingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.BillingLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BillingLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BillingLocalServiceUtil} to access the billing local service. Add custom service methods to {@link com.sphms.common.service.service.impl.BillingLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public boolean publishBilling(long billingId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getBillingListForReport(long customComanyId,
		long clientId, int status, Date startDate, Date endDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getCompanyBillingDetail(long customCompanyId,
		java.lang.String startDate, java.lang.String endDate);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the billing to the database. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Billing addBilling(Billing billing);

	public Billing addBillingForBooking(Booking booking, long clientId,
		long companyId, java.lang.String clientPANum,
		java.lang.String clientPONum, java.lang.String clientGSTNum,
		java.lang.String display, double accessAmount, double pendingAmount,
		long createdBy) throws PortalException;

	/**
	* Creates a new billing with the primary key. Does not add the billing to the database.
	*
	* @param billingId the primary key for the new billing
	* @return the new billing
	*/
	public Billing createBilling(long billingId);

	/**
	* Deletes the billing from the database. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Billing deleteBilling(Billing billing);

	/**
	* Deletes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billingId the primary key of the billing
	* @return the billing that was removed
	* @throws PortalException if a billing with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Billing deleteBilling(long billingId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Billing fetchBilling(long billingId);

	/**
	* Returns the billing with the primary key.
	*
	* @param billingId the primary key of the billing
	* @return the billing
	* @throws PortalException if a billing with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Billing getBilling(long billingId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Billing getBillingFromBookingId(long bookingId)
		throws NoSuchBillingException;

	/**
	* Updates the billing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param billing the billing
	* @return the billing that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Billing updateBilling(Billing billing);

	public Billing updateBilling(long billingId, java.lang.String clientPANum,
		java.lang.String clientPONum, java.lang.String clientGSTNum,
		java.lang.String display, double accessAmount, double pendingAmount,
		List<Billing_HordingBean> billing_HordingBeanList, Date publishDate,
		long modifiedBy) throws PortalException;

	/**
	* Returns the number of billings.
	*
	* @return the number of billings
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBillingsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getDisplayBillNo(Billing billing);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Billing> getBillingList(long customComanyId, long clientId,
		int status, Date startDate, Date endDate, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Billing> getBillings(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BillingBean> getClientBillings(long clientId);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getBillingCount(long customCompanyId, long clientId,
		int status, Date startDate, Date endDate);

	public void updateBillingHordingWhileUpdateBooking(Billing billing,
		Booking booking) throws PortalException;

	public void updateBillingHordings(Billing billing, Booking booking,
		CustomCompany company) throws PortalException;
}