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
 * Provides a wrapper for {@link ProposalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProposalLocalService
 * @generated
 */
@ProviderType
public class ProposalLocalServiceWrapper implements ProposalLocalService,
	ServiceWrapper<ProposalLocalService> {
	public ProposalLocalServiceWrapper(
		ProposalLocalService proposalLocalService) {
		_proposalLocalService = proposalLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _proposalLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _proposalLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _proposalLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _proposalLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _proposalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the proposal to the database. Also notifies the appropriate model listeners.
	*
	* @param proposal the proposal
	* @return the proposal that was added
	*/
	@Override
	public com.sphms.common.service.model.Proposal addProposal(
		com.sphms.common.service.model.Proposal proposal) {
		return _proposalLocalService.addProposal(proposal);
	}

	@Override
	public com.sphms.common.service.model.Proposal addProposal(
		java.lang.String campaignTitle, long client, java.util.Date startDate,
		java.util.Date endDate,
		java.util.List<com.sphms.common.service.beans.Proposal_HordingBean> proposalHordingBeanList,
		long createdBy, long modifiedBy) {
		return _proposalLocalService.addProposal(campaignTitle, client,
			startDate, endDate, proposalHordingBeanList, createdBy, modifiedBy);
	}

	/**
	* Creates a new proposal with the primary key. Does not add the proposal to the database.
	*
	* @param proposalId the primary key for the new proposal
	* @return the new proposal
	*/
	@Override
	public com.sphms.common.service.model.Proposal createProposal(
		long proposalId) {
		return _proposalLocalService.createProposal(proposalId);
	}

	/**
	* Deletes the proposal from the database. Also notifies the appropriate model listeners.
	*
	* @param proposal the proposal
	* @return the proposal that was removed
	*/
	@Override
	public com.sphms.common.service.model.Proposal deleteProposal(
		com.sphms.common.service.model.Proposal proposal) {
		return _proposalLocalService.deleteProposal(proposal);
	}

	/**
	* Deletes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proposalId the primary key of the proposal
	* @return the proposal that was removed
	* @throws PortalException if a proposal with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Proposal deleteProposal(
		long proposalId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _proposalLocalService.deleteProposal(proposalId);
	}

	@Override
	public com.sphms.common.service.model.Proposal fetchProposal(
		long proposalId) {
		return _proposalLocalService.fetchProposal(proposalId);
	}

	/**
	* Returns the proposal with the primary key.
	*
	* @param proposalId the primary key of the proposal
	* @return the proposal
	* @throws PortalException if a proposal with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Proposal getProposal(long proposalId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _proposalLocalService.getProposal(proposalId);
	}

	/**
	* Updates the proposal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param proposal the proposal
	* @return the proposal that was updated
	*/
	@Override
	public com.sphms.common.service.model.Proposal updateProposal(
		com.sphms.common.service.model.Proposal proposal) {
		return _proposalLocalService.updateProposal(proposal);
	}

	/**
	* Returns the number of proposals.
	*
	* @return the number of proposals
	*/
	@Override
	public int getProposalsCount() {
		return _proposalLocalService.getProposalsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _proposalLocalService.getOSGiServiceIdentifier();
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
		return _proposalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.ProposalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _proposalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.ProposalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _proposalLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Proposal> getProposalList(
		long clientId, java.util.Date startDate, java.util.Date endDate,
		int start, int end) {
		return _proposalLocalService.getProposalList(clientId, startDate,
			endDate, start, end);
	}

	/**
	* Returns a range of all the proposals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.ProposalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposals
	* @param end the upper bound of the range of proposals (not inclusive)
	* @return the range of proposals
	*/
	@Override
	public java.util.List<com.sphms.common.service.model.Proposal> getProposals(
		int start, int end) {
		return _proposalLocalService.getProposals(start, end);
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
		return _proposalLocalService.dynamicQueryCount(dynamicQuery);
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
		return _proposalLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public long getProposalCount(long clientId, java.util.Date startDate,
		java.util.Date endDate) {
		return _proposalLocalService.getProposalCount(clientId, startDate,
			endDate);
	}

	@Override
	public ProposalLocalService getWrappedService() {
		return _proposalLocalService;
	}

	@Override
	public void setWrappedService(ProposalLocalService proposalLocalService) {
		_proposalLocalService = proposalLocalService;
	}

	private ProposalLocalService _proposalLocalService;
}