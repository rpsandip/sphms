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

import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.service.persistence.Billing_HordingPK;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Billing_Hording. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see Billing_HordingLocalServiceUtil
 * @see com.sphms.common.service.service.base.Billing_HordingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.Billing_HordingLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface Billing_HordingLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Billing_HordingLocalServiceUtil} to access the billing_ hording local service. Add custom service methods to {@link com.sphms.common.service.service.impl.Billing_HordingLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public Billing_Hording addBillingHording(long billingId, long hordingId,
		double totalMountingCharge, double totalPrintingCharge, int units,
		double totalHordingCharge, java.lang.String hsnNo);

	/**
	* Adds the billing_ hording to the database. Also notifies the appropriate model listeners.
	*
	* @param billing_Hording the billing_ hording
	* @return the billing_ hording that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Billing_Hording addBilling_Hording(Billing_Hording billing_Hording);

	/**
	* Creates a new billing_ hording with the primary key. Does not add the billing_ hording to the database.
	*
	* @param billing_HordingPK the primary key for the new billing_ hording
	* @return the new billing_ hording
	*/
	public Billing_Hording createBilling_Hording(
		Billing_HordingPK billing_HordingPK);

	/**
	* Deletes the billing_ hording from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_Hording the billing_ hording
	* @return the billing_ hording that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Billing_Hording deleteBilling_Hording(
		Billing_Hording billing_Hording);

	/**
	* Deletes the billing_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param billing_HordingPK the primary key of the billing_ hording
	* @return the billing_ hording that was removed
	* @throws PortalException if a billing_ hording with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Billing_Hording deleteBilling_Hording(
		Billing_HordingPK billing_HordingPK) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Billing_Hording fetchBilling_Hording(
		Billing_HordingPK billing_HordingPK);

	/**
	* Returns the billing_ hording with the primary key.
	*
	* @param billing_HordingPK the primary key of the billing_ hording
	* @return the billing_ hording
	* @throws PortalException if a billing_ hording with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Billing_Hording getBilling_Hording(
		Billing_HordingPK billing_HordingPK) throws PortalException;

	/**
	* Updates the billing_ hording in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param billing_Hording the billing_ hording
	* @return the billing_ hording that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Billing_Hording updateBilling_Hording(
		Billing_Hording billing_Hording);

	/**
	* Returns the number of billing_ hordings.
	*
	* @return the number of billing_ hordings
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBilling_HordingsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List<Billing_Hording> getBillingHordingList(long billingId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Billing_Hording> getBilling_Hordings(int start, int end);

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