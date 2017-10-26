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
 * Provides a wrapper for {@link HordingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HordingLocalService
 * @generated
 */
@ProviderType
public class HordingLocalServiceWrapper implements HordingLocalService,
	ServiceWrapper<HordingLocalService> {
	public HordingLocalServiceWrapper(HordingLocalService hordingLocalService) {
		_hordingLocalService = hordingLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _hordingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hordingLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _hordingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hordingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hordingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the hording to the database. Also notifies the appropriate model listeners.
	*
	* @param hording the hording
	* @return the hording that was added
	*/
	@Override
	public com.sphms.common.service.model.Hording addHording(
		com.sphms.common.service.model.Hording hording) {
		return _hordingLocalService.addHording(hording);
	}

	@Override
	public com.sphms.common.service.model.Hording addHording(
		java.lang.String title, java.lang.String location,
		java.lang.String city, java.lang.String district,
		java.lang.String state, java.lang.String hordingType,
		java.lang.String mediaVehicle, java.lang.String size,
		double pricePerMonth, java.io.File normalImage,
		java.lang.String normalImageFileName, java.io.File shortImage,
		java.lang.String shortImageFileName, java.io.File longImage,
		java.lang.String longImageFileName, long landLordId, int ownerType,
		java.lang.String upinNo, double mncTax, double oterExpPerYear,
		long createdBy, long modifiedBy) {
		return _hordingLocalService.addHording(title, location, city, district,
			state, hordingType, mediaVehicle, size, pricePerMonth, normalImage,
			normalImageFileName, shortImage, shortImageFileName, longImage,
			longImageFileName, landLordId, ownerType, upinNo, mncTax,
			oterExpPerYear, createdBy, modifiedBy);
	}

	/**
	* Creates a new hording with the primary key. Does not add the hording to the database.
	*
	* @param hordingId the primary key for the new hording
	* @return the new hording
	*/
	@Override
	public com.sphms.common.service.model.Hording createHording(long hordingId) {
		return _hordingLocalService.createHording(hordingId);
	}

	/**
	* Deletes the hording from the database. Also notifies the appropriate model listeners.
	*
	* @param hording the hording
	* @return the hording that was removed
	*/
	@Override
	public com.sphms.common.service.model.Hording deleteHording(
		com.sphms.common.service.model.Hording hording) {
		return _hordingLocalService.deleteHording(hording);
	}

	/**
	* Deletes the hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hordingId the primary key of the hording
	* @return the hording that was removed
	* @throws PortalException if a hording with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Hording deleteHording(long hordingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hordingLocalService.deleteHording(hordingId);
	}

	@Override
	public com.sphms.common.service.model.Hording fetchHording(long hordingId) {
		return _hordingLocalService.fetchHording(hordingId);
	}

	/**
	* Returns the hording with the primary key.
	*
	* @param hordingId the primary key of the hording
	* @return the hording
	* @throws PortalException if a hording with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Hording getHording(long hordingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hordingLocalService.getHording(hordingId);
	}

	/**
	* Updates the hording in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hording the hording
	* @return the hording that was updated
	*/
	@Override
	public com.sphms.common.service.model.Hording updateHording(
		com.sphms.common.service.model.Hording hording) {
		return _hordingLocalService.updateHording(hording);
	}

	@Override
	public com.sphms.common.service.model.Hording updateHording(
		long hordingId, java.lang.String title, java.lang.String location,
		java.lang.String city, java.lang.String district,
		java.lang.String state, java.lang.String hordingType,
		java.lang.String mediaVehicle, java.lang.String size,
		double pricePerMonth, java.io.File normalImage,
		java.lang.String normalImageFileName, java.io.File shortImage,
		java.lang.String shortImageFileName, java.io.File longImage,
		java.lang.String longImageFileName, long landLordId, int ownerType,
		java.lang.String upinNo, double mncTax, double oterExpPerYear,
		long modifiedBy) {
		return _hordingLocalService.updateHording(hordingId, title, location,
			city, district, state, hordingType, mediaVehicle, size,
			pricePerMonth, normalImage, normalImageFileName, shortImage,
			shortImageFileName, longImage, longImageFileName, landLordId,
			ownerType, upinNo, mncTax, oterExpPerYear, modifiedBy);
	}

	/**
	* Returns the number of hordings.
	*
	* @return the number of hordings
	*/
	@Override
	public int getHordingsCount() {
		return _hordingLocalService.getHordingsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _hordingLocalService.getOSGiServiceIdentifier();
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
		return _hordingLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _hordingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _hordingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Hording> getActiveHoringList(
		int start, int end) {
		return _hordingLocalService.getActiveHoringList(start, end);
	}

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
	@Override
	public java.util.List<com.sphms.common.service.model.Hording> getHordings(
		int start, int end) {
		return _hordingLocalService.getHordings(start, end);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Hording> getLandLordHordingList(
		long landLordId) {
		return _hordingLocalService.getLandLordHordingList(landLordId);
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
		return _hordingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _hordingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public HordingLocalService getWrappedService() {
		return _hordingLocalService;
	}

	@Override
	public void setWrappedService(HordingLocalService hordingLocalService) {
		_hordingLocalService = hordingLocalService;
	}

	private HordingLocalService _hordingLocalService;
}