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
 * Provides a wrapper for {@link Proposal_HordingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Proposal_HordingLocalService
 * @generated
 */
@ProviderType
public class Proposal_HordingLocalServiceWrapper
	implements Proposal_HordingLocalService,
		ServiceWrapper<Proposal_HordingLocalService> {
	public Proposal_HordingLocalServiceWrapper(
		Proposal_HordingLocalService proposal_HordingLocalService) {
		_proposal_HordingLocalService = proposal_HordingLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _proposal_HordingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _proposal_HordingLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _proposal_HordingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _proposal_HordingLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _proposal_HordingLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.sphms.common.service.model.Proposal_Hording addProposalHording(
		long proposalId, long hordingId, double mountingCharge,
		double printingChrage, int units) {
		return _proposal_HordingLocalService.addProposalHording(proposalId,
			hordingId, mountingCharge, printingChrage, units);
	}

	/**
	* Adds the proposal_ hording to the database. Also notifies the appropriate model listeners.
	*
	* @param proposal_Hording the proposal_ hording
	* @return the proposal_ hording that was added
	*/
	@Override
	public com.sphms.common.service.model.Proposal_Hording addProposal_Hording(
		com.sphms.common.service.model.Proposal_Hording proposal_Hording) {
		return _proposal_HordingLocalService.addProposal_Hording(proposal_Hording);
	}

	/**
	* Creates a new proposal_ hording with the primary key. Does not add the proposal_ hording to the database.
	*
	* @param proposal_HordingPK the primary key for the new proposal_ hording
	* @return the new proposal_ hording
	*/
	@Override
	public com.sphms.common.service.model.Proposal_Hording createProposal_Hording(
		com.sphms.common.service.service.persistence.Proposal_HordingPK proposal_HordingPK) {
		return _proposal_HordingLocalService.createProposal_Hording(proposal_HordingPK);
	}

	/**
	* Deletes the proposal_ hording from the database. Also notifies the appropriate model listeners.
	*
	* @param proposal_Hording the proposal_ hording
	* @return the proposal_ hording that was removed
	*/
	@Override
	public com.sphms.common.service.model.Proposal_Hording deleteProposal_Hording(
		com.sphms.common.service.model.Proposal_Hording proposal_Hording) {
		return _proposal_HordingLocalService.deleteProposal_Hording(proposal_Hording);
	}

	/**
	* Deletes the proposal_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proposal_HordingPK the primary key of the proposal_ hording
	* @return the proposal_ hording that was removed
	* @throws PortalException if a proposal_ hording with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Proposal_Hording deleteProposal_Hording(
		com.sphms.common.service.service.persistence.Proposal_HordingPK proposal_HordingPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _proposal_HordingLocalService.deleteProposal_Hording(proposal_HordingPK);
	}

	@Override
	public com.sphms.common.service.model.Proposal_Hording fetchProposal_Hording(
		com.sphms.common.service.service.persistence.Proposal_HordingPK proposal_HordingPK) {
		return _proposal_HordingLocalService.fetchProposal_Hording(proposal_HordingPK);
	}

	/**
	* Returns the proposal_ hording with the primary key.
	*
	* @param proposal_HordingPK the primary key of the proposal_ hording
	* @return the proposal_ hording
	* @throws PortalException if a proposal_ hording with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Proposal_Hording getProposal_Hording(
		com.sphms.common.service.service.persistence.Proposal_HordingPK proposal_HordingPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _proposal_HordingLocalService.getProposal_Hording(proposal_HordingPK);
	}

	/**
	* Updates the proposal_ hording in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param proposal_Hording the proposal_ hording
	* @return the proposal_ hording that was updated
	*/
	@Override
	public com.sphms.common.service.model.Proposal_Hording updateProposal_Hording(
		com.sphms.common.service.model.Proposal_Hording proposal_Hording) {
		return _proposal_HordingLocalService.updateProposal_Hording(proposal_Hording);
	}

	/**
	* Returns the number of proposal_ hordings.
	*
	* @return the number of proposal_ hordings
	*/
	@Override
	public int getProposal_HordingsCount() {
		return _proposal_HordingLocalService.getProposal_HordingsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _proposal_HordingLocalService.getOSGiServiceIdentifier();
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
		return _proposal_HordingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _proposal_HordingLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _proposal_HordingLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Proposal_Hording> getProposalHording(
		long proposalId) {
		return _proposal_HordingLocalService.getProposalHording(proposalId);
	}

	/**
	* Returns a range of all the proposal_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposal_ hordings
	* @param end the upper bound of the range of proposal_ hordings (not inclusive)
	* @return the range of proposal_ hordings
	*/
	@Override
	public java.util.List<com.sphms.common.service.model.Proposal_Hording> getProposal_Hordings(
		int start, int end) {
		return _proposal_HordingLocalService.getProposal_Hordings(start, end);
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
		return _proposal_HordingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _proposal_HordingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public Proposal_HordingLocalService getWrappedService() {
		return _proposal_HordingLocalService;
	}

	@Override
	public void setWrappedService(
		Proposal_HordingLocalService proposal_HordingLocalService) {
		_proposal_HordingLocalService = proposal_HordingLocalService;
	}

	private Proposal_HordingLocalService _proposal_HordingLocalService;
}