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

package com.sphms.common.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sphms.common.service.exception.NoSuchProposalException;
import com.sphms.common.service.model.Proposal;

/**
 * The persistence interface for the proposal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.ProposalPersistenceImpl
 * @see ProposalUtil
 * @generated
 */
@ProviderType
public interface ProposalPersistence extends BasePersistence<Proposal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProposalUtil} to access the proposal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the proposal in the entity cache if it is enabled.
	*
	* @param proposal the proposal
	*/
	public void cacheResult(Proposal proposal);

	/**
	* Caches the proposals in the entity cache if it is enabled.
	*
	* @param proposals the proposals
	*/
	public void cacheResult(java.util.List<Proposal> proposals);

	/**
	* Creates a new proposal with the primary key. Does not add the proposal to the database.
	*
	* @param proposalId the primary key for the new proposal
	* @return the new proposal
	*/
	public Proposal create(long proposalId);

	/**
	* Removes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proposalId the primary key of the proposal
	* @return the proposal that was removed
	* @throws NoSuchProposalException if a proposal with the primary key could not be found
	*/
	public Proposal remove(long proposalId) throws NoSuchProposalException;

	public Proposal updateImpl(Proposal proposal);

	/**
	* Returns the proposal with the primary key or throws a {@link NoSuchProposalException} if it could not be found.
	*
	* @param proposalId the primary key of the proposal
	* @return the proposal
	* @throws NoSuchProposalException if a proposal with the primary key could not be found
	*/
	public Proposal findByPrimaryKey(long proposalId)
		throws NoSuchProposalException;

	/**
	* Returns the proposal with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param proposalId the primary key of the proposal
	* @return the proposal, or <code>null</code> if a proposal with the primary key could not be found
	*/
	public Proposal fetchByPrimaryKey(long proposalId);

	@Override
	public java.util.Map<java.io.Serializable, Proposal> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the proposals.
	*
	* @return the proposals
	*/
	public java.util.List<Proposal> findAll();

	/**
	* Returns a range of all the proposals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProposalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposals
	* @param end the upper bound of the range of proposals (not inclusive)
	* @return the range of proposals
	*/
	public java.util.List<Proposal> findAll(int start, int end);

	/**
	* Returns an ordered range of all the proposals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProposalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposals
	* @param end the upper bound of the range of proposals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of proposals
	*/
	public java.util.List<Proposal> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal> orderByComparator);

	/**
	* Returns an ordered range of all the proposals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProposalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposals
	* @param end the upper bound of the range of proposals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of proposals
	*/
	public java.util.List<Proposal> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the proposals from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of proposals.
	*
	* @return the number of proposals
	*/
	public int countAll();
}