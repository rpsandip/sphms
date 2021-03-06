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

import com.sphms.common.service.model.Hording;

import java.io.File;
import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Hording. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see HordingLocalServiceUtil
 * @see com.sphms.common.service.service.base.HordingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.HordingLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface HordingLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HordingLocalServiceUtil} to access the hording local service. Add custom service methods to {@link com.sphms.common.service.service.impl.HordingLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* This method will a common method to reterive a hordings Report
	*
	* @param landLoadId
	* @param startDate
	* @param endDate
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getHordingsFilter(long hordingId,
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
	* Adds the hording to the database. Also notifies the appropriate model listeners.
	*
	* @param hording the hording
	* @return the hording that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Hording addHording(Hording hording);

	public Hording addHording(java.lang.String title,
		java.lang.String location, java.lang.String city,
		java.lang.String district, java.lang.String state,
		java.lang.String hordingType, java.lang.String mediaVehicle,
		java.lang.String size, double pricePerMonth, File normalImage,
		java.lang.String normalImageFileName, File shortImage,
		java.lang.String shortImageFileName, File longImage,
		java.lang.String longImageFileName, long landLordId, int ownerType,
		java.lang.String upinNo, double mncTax, double oterExpPerYear,
		long createdBy, long modifiedBy);

	/**
	* Creates a new hording with the primary key. Does not add the hording to the database.
	*
	* @param hordingId the primary key for the new hording
	* @return the new hording
	*/
	public Hording createHording(long hordingId);

	/**
	* Deletes the hording from the database. Also notifies the appropriate model listeners.
	*
	* @param hording the hording
	* @return the hording that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Hording deleteHording(Hording hording);

	/**
	* Deletes the hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hordingId the primary key of the hording
	* @return the hording that was removed
	* @throws PortalException if a hording with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Hording deleteHording(long hordingId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hording fetchHording(long hordingId);

	/**
	* Returns the hording with the primary key.
	*
	* @param hordingId the primary key of the hording
	* @return the hording
	* @throws PortalException if a hording with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hording getHording(long hordingId) throws PortalException;

	/**
	* Updates the hording in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hording the hording
	* @return the hording that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Hording updateHording(Hording hording);

	public Hording updateHording(long hordingId, java.lang.String title,
		java.lang.String location, java.lang.String city,
		java.lang.String district, java.lang.String state,
		java.lang.String hordingType, java.lang.String mediaVehicle,
		java.lang.String size, double pricePerMonth, File normalImage,
		java.lang.String normalImageFileName, File shortImage,
		java.lang.String shortImageFileName, File longImage,
		java.lang.String longImageFileName, long landLordId, int ownerType,
		java.lang.String upinNo, double mncTax, double oterExpPerYear,
		long modifiedBy);

	/**
	* Returns the number of hordings.
	*
	* @return the number of hordings
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getHordingsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List<Hording> getActiveHoringList(int start, int end);

	/**
	* Returns a range of all the hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @return the range of hordings
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Hording> getHordings(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Hording> getLandLordHordingList(long landLordId);

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