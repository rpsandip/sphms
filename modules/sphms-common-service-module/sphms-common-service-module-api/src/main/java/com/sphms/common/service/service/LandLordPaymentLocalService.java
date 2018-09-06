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
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sphms.common.service.beans.LandLordPaymentBean;
import com.sphms.common.service.model.LandLordPayment;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for LandLordPayment. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPaymentLocalServiceUtil
 * @see com.sphms.common.service.service.base.LandLordPaymentLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.LandLordPaymentLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LandLordPaymentLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LandLordPaymentLocalServiceUtil} to access the land lord payment local service. Add custom service methods to {@link com.sphms.common.service.service.impl.LandLordPaymentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	* Adds the land lord payment to the database. Also notifies the appropriate model listeners.
	*
	* @param landLordPayment the land lord payment
	* @return the land lord payment that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LandLordPayment addLandLordPayment(LandLordPayment landLordPayment);

	public LandLordPayment addLandLordPayment(long landLordId, long hordingId,
		double amount, Date paymentDate, java.lang.String chequeNo,
		java.lang.String bankName, java.lang.String description, long createdBy);

	/**
	* Creates a new land lord payment with the primary key. Does not add the land lord payment to the database.
	*
	* @param landLordPaymentId the primary key for the new land lord payment
	* @return the new land lord payment
	*/
	public LandLordPayment createLandLordPayment(long landLordPaymentId);

	/**
	* Deletes the land lord payment from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordPayment the land lord payment
	* @return the land lord payment that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public LandLordPayment deleteLandLordPayment(
		LandLordPayment landLordPayment);

	/**
	* Deletes the land lord payment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment that was removed
	* @throws PortalException if a land lord payment with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public LandLordPayment deleteLandLordPayment(long landLordPaymentId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LandLordPayment fetchLandLordPayment(long landLordPaymentId);

	/**
	* Returns the land lord payment with the primary key.
	*
	* @param landLordPaymentId the primary key of the land lord payment
	* @return the land lord payment
	* @throws PortalException if a land lord payment with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LandLordPayment getLandLordPayment(long landLordPaymentId)
		throws PortalException;

	/**
	* Updates the land lord payment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param landLordPayment the land lord payment
	* @return the land lord payment that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LandLordPayment updateLandLordPayment(
		LandLordPayment landLordPayment);

	public LandLordPayment updateLandLordPayment(long landLordPaymentId,
		long landLordId, long hordingId, double amount, Date paymentDate,
		java.lang.String chequeNo, java.lang.String bankName,
		java.lang.String description, long createdBy) throws PortalException;

	/**
	* Returns the number of land lord payments.
	*
	* @return the number of land lord payments
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLandLordPaymentsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns a range of all the land lord payments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lord payments
	* @param end the upper bound of the range of land lord payments (not inclusive)
	* @return the range of land lord payments
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LandLordPayment> getLandLordPayments(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LandLordPaymentBean> getLandLordPayments(long landLordId);

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
}