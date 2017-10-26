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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sphms.common.service.model.Proposal;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the proposal service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.ProposalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalPersistence
 * @see com.sphms.common.service.service.persistence.impl.ProposalPersistenceImpl
 * @generated
 */
@ProviderType
public class ProposalUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Proposal proposal) {
		getPersistence().clearCache(proposal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Proposal> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Proposal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Proposal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Proposal> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Proposal update(Proposal proposal) {
		return getPersistence().update(proposal);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Proposal update(Proposal proposal,
		ServiceContext serviceContext) {
		return getPersistence().update(proposal, serviceContext);
	}

	/**
	* Caches the proposal in the entity cache if it is enabled.
	*
	* @param proposal the proposal
	*/
	public static void cacheResult(Proposal proposal) {
		getPersistence().cacheResult(proposal);
	}

	/**
	* Caches the proposals in the entity cache if it is enabled.
	*
	* @param proposals the proposals
	*/
	public static void cacheResult(List<Proposal> proposals) {
		getPersistence().cacheResult(proposals);
	}

	/**
	* Creates a new proposal with the primary key. Does not add the proposal to the database.
	*
	* @param proposalId the primary key for the new proposal
	* @return the new proposal
	*/
	public static Proposal create(long proposalId) {
		return getPersistence().create(proposalId);
	}

	/**
	* Removes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proposalId the primary key of the proposal
	* @return the proposal that was removed
	* @throws NoSuchProposalException if a proposal with the primary key could not be found
	*/
	public static Proposal remove(long proposalId)
		throws com.sphms.common.service.exception.NoSuchProposalException {
		return getPersistence().remove(proposalId);
	}

	public static Proposal updateImpl(Proposal proposal) {
		return getPersistence().updateImpl(proposal);
	}

	/**
	* Returns the proposal with the primary key or throws a {@link NoSuchProposalException} if it could not be found.
	*
	* @param proposalId the primary key of the proposal
	* @return the proposal
	* @throws NoSuchProposalException if a proposal with the primary key could not be found
	*/
	public static Proposal findByPrimaryKey(long proposalId)
		throws com.sphms.common.service.exception.NoSuchProposalException {
		return getPersistence().findByPrimaryKey(proposalId);
	}

	/**
	* Returns the proposal with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param proposalId the primary key of the proposal
	* @return the proposal, or <code>null</code> if a proposal with the primary key could not be found
	*/
	public static Proposal fetchByPrimaryKey(long proposalId) {
		return getPersistence().fetchByPrimaryKey(proposalId);
	}

	public static java.util.Map<java.io.Serializable, Proposal> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the proposals.
	*
	* @return the proposals
	*/
	public static List<Proposal> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Proposal> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Proposal> findAll(int start, int end,
		OrderByComparator<Proposal> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Proposal> findAll(int start, int end,
		OrderByComparator<Proposal> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the proposals from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of proposals.
	*
	* @return the number of proposals
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProposalPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProposalPersistence, ProposalPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ProposalPersistence.class);
}