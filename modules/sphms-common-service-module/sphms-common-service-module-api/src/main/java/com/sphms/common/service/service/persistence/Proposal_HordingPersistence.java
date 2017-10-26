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

import com.sphms.common.service.exception.NoSuchProposal_HordingException;
import com.sphms.common.service.model.Proposal_Hording;

/**
 * The persistence interface for the proposal_ hording service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.Proposal_HordingPersistenceImpl
 * @see Proposal_HordingUtil
 * @generated
 */
@ProviderType
public interface Proposal_HordingPersistence extends BasePersistence<Proposal_Hording> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Proposal_HordingUtil} to access the proposal_ hording persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the proposal_ hordings where proposalId = &#63;.
	*
	* @param proposalId the proposal ID
	* @return the matching proposal_ hordings
	*/
	public java.util.List<Proposal_Hording> findByproposalId(long proposalId);

	/**
	* Returns a range of all the proposal_ hordings where proposalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param proposalId the proposal ID
	* @param start the lower bound of the range of proposal_ hordings
	* @param end the upper bound of the range of proposal_ hordings (not inclusive)
	* @return the range of matching proposal_ hordings
	*/
	public java.util.List<Proposal_Hording> findByproposalId(long proposalId,
		int start, int end);

	/**
	* Returns an ordered range of all the proposal_ hordings where proposalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param proposalId the proposal ID
	* @param start the lower bound of the range of proposal_ hordings
	* @param end the upper bound of the range of proposal_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposal_ hordings
	*/
	public java.util.List<Proposal_Hording> findByproposalId(long proposalId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator);

	/**
	* Returns an ordered range of all the proposal_ hordings where proposalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param proposalId the proposal ID
	* @param start the lower bound of the range of proposal_ hordings
	* @param end the upper bound of the range of proposal_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching proposal_ hordings
	*/
	public java.util.List<Proposal_Hording> findByproposalId(long proposalId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first proposal_ hording in the ordered set where proposalId = &#63;.
	*
	* @param proposalId the proposal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal_ hording
	* @throws NoSuchProposal_HordingException if a matching proposal_ hording could not be found
	*/
	public Proposal_Hording findByproposalId_First(long proposalId,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator)
		throws NoSuchProposal_HordingException;

	/**
	* Returns the first proposal_ hording in the ordered set where proposalId = &#63;.
	*
	* @param proposalId the proposal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal_ hording, or <code>null</code> if a matching proposal_ hording could not be found
	*/
	public Proposal_Hording fetchByproposalId_First(long proposalId,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator);

	/**
	* Returns the last proposal_ hording in the ordered set where proposalId = &#63;.
	*
	* @param proposalId the proposal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal_ hording
	* @throws NoSuchProposal_HordingException if a matching proposal_ hording could not be found
	*/
	public Proposal_Hording findByproposalId_Last(long proposalId,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator)
		throws NoSuchProposal_HordingException;

	/**
	* Returns the last proposal_ hording in the ordered set where proposalId = &#63;.
	*
	* @param proposalId the proposal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal_ hording, or <code>null</code> if a matching proposal_ hording could not be found
	*/
	public Proposal_Hording fetchByproposalId_Last(long proposalId,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator);

	/**
	* Returns the proposal_ hordings before and after the current proposal_ hording in the ordered set where proposalId = &#63;.
	*
	* @param proposal_HordingPK the primary key of the current proposal_ hording
	* @param proposalId the proposal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposal_ hording
	* @throws NoSuchProposal_HordingException if a proposal_ hording with the primary key could not be found
	*/
	public Proposal_Hording[] findByproposalId_PrevAndNext(
		Proposal_HordingPK proposal_HordingPK, long proposalId,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator)
		throws NoSuchProposal_HordingException;

	/**
	* Removes all the proposal_ hordings where proposalId = &#63; from the database.
	*
	* @param proposalId the proposal ID
	*/
	public void removeByproposalId(long proposalId);

	/**
	* Returns the number of proposal_ hordings where proposalId = &#63;.
	*
	* @param proposalId the proposal ID
	* @return the number of matching proposal_ hordings
	*/
	public int countByproposalId(long proposalId);

	/**
	* Caches the proposal_ hording in the entity cache if it is enabled.
	*
	* @param proposal_Hording the proposal_ hording
	*/
	public void cacheResult(Proposal_Hording proposal_Hording);

	/**
	* Caches the proposal_ hordings in the entity cache if it is enabled.
	*
	* @param proposal_Hordings the proposal_ hordings
	*/
	public void cacheResult(java.util.List<Proposal_Hording> proposal_Hordings);

	/**
	* Creates a new proposal_ hording with the primary key. Does not add the proposal_ hording to the database.
	*
	* @param proposal_HordingPK the primary key for the new proposal_ hording
	* @return the new proposal_ hording
	*/
	public Proposal_Hording create(Proposal_HordingPK proposal_HordingPK);

	/**
	* Removes the proposal_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proposal_HordingPK the primary key of the proposal_ hording
	* @return the proposal_ hording that was removed
	* @throws NoSuchProposal_HordingException if a proposal_ hording with the primary key could not be found
	*/
	public Proposal_Hording remove(Proposal_HordingPK proposal_HordingPK)
		throws NoSuchProposal_HordingException;

	public Proposal_Hording updateImpl(Proposal_Hording proposal_Hording);

	/**
	* Returns the proposal_ hording with the primary key or throws a {@link NoSuchProposal_HordingException} if it could not be found.
	*
	* @param proposal_HordingPK the primary key of the proposal_ hording
	* @return the proposal_ hording
	* @throws NoSuchProposal_HordingException if a proposal_ hording with the primary key could not be found
	*/
	public Proposal_Hording findByPrimaryKey(
		Proposal_HordingPK proposal_HordingPK)
		throws NoSuchProposal_HordingException;

	/**
	* Returns the proposal_ hording with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param proposal_HordingPK the primary key of the proposal_ hording
	* @return the proposal_ hording, or <code>null</code> if a proposal_ hording with the primary key could not be found
	*/
	public Proposal_Hording fetchByPrimaryKey(
		Proposal_HordingPK proposal_HordingPK);

	@Override
	public java.util.Map<java.io.Serializable, Proposal_Hording> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the proposal_ hordings.
	*
	* @return the proposal_ hordings
	*/
	public java.util.List<Proposal_Hording> findAll();

	/**
	* Returns a range of all the proposal_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposal_ hordings
	* @param end the upper bound of the range of proposal_ hordings (not inclusive)
	* @return the range of proposal_ hordings
	*/
	public java.util.List<Proposal_Hording> findAll(int start, int end);

	/**
	* Returns an ordered range of all the proposal_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposal_ hordings
	* @param end the upper bound of the range of proposal_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of proposal_ hordings
	*/
	public java.util.List<Proposal_Hording> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator);

	/**
	* Returns an ordered range of all the proposal_ hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Proposal_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposal_ hordings
	* @param end the upper bound of the range of proposal_ hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of proposal_ hordings
	*/
	public java.util.List<Proposal_Hording> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Proposal_Hording> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the proposal_ hordings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of proposal_ hordings.
	*
	* @return the number of proposal_ hordings
	*/
	public int countAll();
}