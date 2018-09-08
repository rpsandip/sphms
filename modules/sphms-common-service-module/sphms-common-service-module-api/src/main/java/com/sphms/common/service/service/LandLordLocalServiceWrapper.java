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
 * Provides a wrapper for {@link LandLordLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LandLordLocalService
 * @generated
 */
@ProviderType
public class LandLordLocalServiceWrapper implements LandLordLocalService,
	ServiceWrapper<LandLordLocalService> {
	public LandLordLocalServiceWrapper(
		LandLordLocalService landLordLocalService) {
		_landLordLocalService = landLordLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _landLordLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _landLordLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _landLordLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _landLordLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _landLordLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the land lord to the database. Also notifies the appropriate model listeners.
	*
	* @param landLord the land lord
	* @return the land lord that was added
	*/
	@Override
	public com.sphms.common.service.model.LandLord addLandLord(
		com.sphms.common.service.model.LandLord landLord) {
		return _landLordLocalService.addLandLord(landLord);
	}

	@Override
	public com.sphms.common.service.model.LandLord addLandLordDetail(
		java.lang.String fName, java.lang.String lName,
		java.lang.String location, java.lang.String city,
		java.lang.String state, java.lang.String phoneNo, int status,
		long createdBy) {
		return _landLordLocalService.addLandLordDetail(fName, lName, location,
			city, state, phoneNo, status, createdBy);
	}

	/**
	* Creates a new land lord with the primary key. Does not add the land lord to the database.
	*
	* @param landLordId the primary key for the new land lord
	* @return the new land lord
	*/
	@Override
	public com.sphms.common.service.model.LandLord createLandLord(
		long landLordId) {
		return _landLordLocalService.createLandLord(landLordId);
	}

	/**
	* Deletes the land lord from the database. Also notifies the appropriate model listeners.
	*
	* @param landLord the land lord
	* @return the land lord that was removed
	*/
	@Override
	public com.sphms.common.service.model.LandLord deleteLandLord(
		com.sphms.common.service.model.LandLord landLord) {
		return _landLordLocalService.deleteLandLord(landLord);
	}

	/**
	* Deletes the land lord with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordId the primary key of the land lord
	* @return the land lord that was removed
	* @throws PortalException if a land lord with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.LandLord deleteLandLord(
		long landLordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _landLordLocalService.deleteLandLord(landLordId);
	}

	@Override
	public com.sphms.common.service.model.LandLord fetchLandLord(
		long landLordId) {
		return _landLordLocalService.fetchLandLord(landLordId);
	}

	/**
	* Returns the land lord with the primary key.
	*
	* @param landLordId the primary key of the land lord
	* @return the land lord
	* @throws PortalException if a land lord with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.LandLord getLandLord(long landLordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _landLordLocalService.getLandLord(landLordId);
	}

	/**
	* Updates the land lord in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param landLord the land lord
	* @return the land lord that was updated
	*/
	@Override
	public com.sphms.common.service.model.LandLord updateLandLord(
		com.sphms.common.service.model.LandLord landLord) {
		return _landLordLocalService.updateLandLord(landLord);
	}

	@Override
	public com.sphms.common.service.model.LandLord updateLandLord(
		long landLordId, java.lang.String fName, java.lang.String lName,
		java.lang.String location, java.lang.String city,
		java.lang.String state, java.lang.String phoneNo, int status,
		long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _landLordLocalService.updateLandLord(landLordId, fName, lName,
			location, city, state, phoneNo, status, createdBy);
	}

	/**
	* Returns the number of land lords.
	*
	* @return the number of land lords
	*/
	@Override
	public int getLandLordsCount() {
		return _landLordLocalService.getLandLordsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _landLordLocalService.getOSGiServiceIdentifier();
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
		return _landLordLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _landLordLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _landLordLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.LandLord> getActiveLandLords(
		int start, int end) {
		return _landLordLocalService.getActiveLandLords(start, end);
	}

	/**
	* This method will a common method to retrive a LandLoad Report
	*
	* @param landLoadId
	* @param startDate
	* @param endDate
	* @return
	*/
	@Override
	public java.util.List<java.lang.Object> getLandLoadFilter(long landLoadId,
		java.lang.String startDate, java.lang.String endDate) {
		return _landLordLocalService.getLandLoadFilter(landLoadId, startDate,
			endDate);
	}

	/**
	* Returns a range of all the land lords.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of land lords
	* @param end the upper bound of the range of land lords (not inclusive)
	* @return the range of land lords
	*/
	@Override
	public java.util.List<com.sphms.common.service.model.LandLord> getLandLords(
		int start, int end) {
		return _landLordLocalService.getLandLords(start, end);
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
		return _landLordLocalService.dynamicQueryCount(dynamicQuery);
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
		return _landLordLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public LandLordLocalService getWrappedService() {
		return _landLordLocalService;
	}

	@Override
	public void setWrappedService(LandLordLocalService landLordLocalService) {
		_landLordLocalService = landLordLocalService;
	}

	private LandLordLocalService _landLordLocalService;
}