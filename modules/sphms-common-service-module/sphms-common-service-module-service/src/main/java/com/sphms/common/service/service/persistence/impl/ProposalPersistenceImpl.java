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

package com.sphms.common.service.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchProposalException;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.model.impl.ProposalImpl;
import com.sphms.common.service.model.impl.ProposalModelImpl;
import com.sphms.common.service.service.persistence.ProposalPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the proposal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProposalPersistence
 * @see com.sphms.common.service.service.persistence.ProposalUtil
 * @generated
 */
@ProviderType
public class ProposalPersistenceImpl extends BasePersistenceImpl<Proposal>
	implements ProposalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProposalUtil} to access the proposal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProposalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProposalModelImpl.ENTITY_CACHE_ENABLED,
			ProposalModelImpl.FINDER_CACHE_ENABLED, ProposalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProposalModelImpl.ENTITY_CACHE_ENABLED,
			ProposalModelImpl.FINDER_CACHE_ENABLED, ProposalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProposalModelImpl.ENTITY_CACHE_ENABLED,
			ProposalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProposalPersistenceImpl() {
		setModelClass(Proposal.class);
	}

	/**
	 * Caches the proposal in the entity cache if it is enabled.
	 *
	 * @param proposal the proposal
	 */
	@Override
	public void cacheResult(Proposal proposal) {
		entityCache.putResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
			ProposalImpl.class, proposal.getPrimaryKey(), proposal);

		proposal.resetOriginalValues();
	}

	/**
	 * Caches the proposals in the entity cache if it is enabled.
	 *
	 * @param proposals the proposals
	 */
	@Override
	public void cacheResult(List<Proposal> proposals) {
		for (Proposal proposal : proposals) {
			if (entityCache.getResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
						ProposalImpl.class, proposal.getPrimaryKey()) == null) {
				cacheResult(proposal);
			}
			else {
				proposal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all proposals.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProposalImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the proposal.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Proposal proposal) {
		entityCache.removeResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
			ProposalImpl.class, proposal.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Proposal> proposals) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Proposal proposal : proposals) {
			entityCache.removeResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
				ProposalImpl.class, proposal.getPrimaryKey());
		}
	}

	/**
	 * Creates a new proposal with the primary key. Does not add the proposal to the database.
	 *
	 * @param proposalId the primary key for the new proposal
	 * @return the new proposal
	 */
	@Override
	public Proposal create(long proposalId) {
		Proposal proposal = new ProposalImpl();

		proposal.setNew(true);
		proposal.setPrimaryKey(proposalId);

		return proposal;
	}

	/**
	 * Removes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal that was removed
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal remove(long proposalId) throws NoSuchProposalException {
		return remove((Serializable)proposalId);
	}

	/**
	 * Removes the proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proposal
	 * @return the proposal that was removed
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal remove(Serializable primaryKey)
		throws NoSuchProposalException {
		Session session = null;

		try {
			session = openSession();

			Proposal proposal = (Proposal)session.get(ProposalImpl.class,
					primaryKey);

			if (proposal == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProposalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(proposal);
		}
		catch (NoSuchProposalException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Proposal removeImpl(Proposal proposal) {
		proposal = toUnwrappedModel(proposal);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(proposal)) {
				proposal = (Proposal)session.get(ProposalImpl.class,
						proposal.getPrimaryKeyObj());
			}

			if (proposal != null) {
				session.delete(proposal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (proposal != null) {
			clearCache(proposal);
		}

		return proposal;
	}

	@Override
	public Proposal updateImpl(Proposal proposal) {
		proposal = toUnwrappedModel(proposal);

		boolean isNew = proposal.isNew();

		ProposalModelImpl proposalModelImpl = (ProposalModelImpl)proposal;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (proposal.getCreateDate() == null)) {
			if (serviceContext == null) {
				proposal.setCreateDate(now);
			}
			else {
				proposal.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!proposalModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				proposal.setModifiedDate(now);
			}
			else {
				proposal.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (proposal.isNew()) {
				session.save(proposal);

				proposal.setNew(false);
			}
			else {
				proposal = (Proposal)session.merge(proposal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
			ProposalImpl.class, proposal.getPrimaryKey(), proposal, false);

		proposal.resetOriginalValues();

		return proposal;
	}

	protected Proposal toUnwrappedModel(Proposal proposal) {
		if (proposal instanceof ProposalImpl) {
			return proposal;
		}

		ProposalImpl proposalImpl = new ProposalImpl();

		proposalImpl.setNew(proposal.isNew());
		proposalImpl.setPrimaryKey(proposal.getPrimaryKey());

		proposalImpl.setProposalId(proposal.getProposalId());
		proposalImpl.setCampaignTitle(proposal.getCampaignTitle());
		proposalImpl.setClient(proposal.getClient());
		proposalImpl.setPptFileId(proposal.getPptFileId());
		proposalImpl.setXlsxFileId(proposal.getXlsxFileId());
		proposalImpl.setStartDate(proposal.getStartDate());
		proposalImpl.setEndDate(proposal.getEndDate());
		proposalImpl.setCreateDate(proposal.getCreateDate());
		proposalImpl.setCreatedBy(proposal.getCreatedBy());
		proposalImpl.setModifiedDate(proposal.getModifiedDate());
		proposalImpl.setModifiedBy(proposal.getModifiedBy());

		return proposalImpl;
	}

	/**
	 * Returns the proposal with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposal
	 * @return the proposal
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProposalException {
		Proposal proposal = fetchByPrimaryKey(primaryKey);

		if (proposal == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProposalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return proposal;
	}

	/**
	 * Returns the proposal with the primary key or throws a {@link NoSuchProposalException} if it could not be found.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal
	 * @throws NoSuchProposalException if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal findByPrimaryKey(long proposalId)
		throws NoSuchProposalException {
		return findByPrimaryKey((Serializable)proposalId);
	}

	/**
	 * Returns the proposal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposal
	 * @return the proposal, or <code>null</code> if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
				ProposalImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Proposal proposal = (Proposal)serializable;

		if (proposal == null) {
			Session session = null;

			try {
				session = openSession();

				proposal = (Proposal)session.get(ProposalImpl.class, primaryKey);

				if (proposal != null) {
					cacheResult(proposal);
				}
				else {
					entityCache.putResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
						ProposalImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
					ProposalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return proposal;
	}

	/**
	 * Returns the proposal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proposalId the primary key of the proposal
	 * @return the proposal, or <code>null</code> if a proposal with the primary key could not be found
	 */
	@Override
	public Proposal fetchByPrimaryKey(long proposalId) {
		return fetchByPrimaryKey((Serializable)proposalId);
	}

	@Override
	public Map<Serializable, Proposal> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Proposal> map = new HashMap<Serializable, Proposal>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Proposal proposal = fetchByPrimaryKey(primaryKey);

			if (proposal != null) {
				map.put(primaryKey, proposal);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
					ProposalImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Proposal)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROPOSAL_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Proposal proposal : (List<Proposal>)q.list()) {
				map.put(proposal.getPrimaryKeyObj(), proposal);

				cacheResult(proposal);

				uncachedPrimaryKeys.remove(proposal.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProposalModelImpl.ENTITY_CACHE_ENABLED,
					ProposalImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the proposals.
	 *
	 * @return the proposals
	 */
	@Override
	public List<Proposal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Proposal> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Proposal> findAll(int start, int end,
		OrderByComparator<Proposal> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Proposal> findAll(int start, int end,
		OrderByComparator<Proposal> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Proposal> list = null;

		if (retrieveFromCache) {
			list = (List<Proposal>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROPOSAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROPOSAL;

				if (pagination) {
					sql = sql.concat(ProposalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Proposal>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Proposal>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the proposals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Proposal proposal : findAll()) {
			remove(proposal);
		}
	}

	/**
	 * Returns the number of proposals.
	 *
	 * @return the number of proposals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROPOSAL);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProposalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the proposal persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProposalImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROPOSAL = "SELECT proposal FROM Proposal proposal";
	private static final String _SQL_SELECT_PROPOSAL_WHERE_PKS_IN = "SELECT proposal FROM Proposal proposal WHERE proposalId IN (";
	private static final String _SQL_COUNT_PROPOSAL = "SELECT COUNT(proposal) FROM Proposal proposal";
	private static final String _ORDER_BY_ENTITY_ALIAS = "proposal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Proposal exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ProposalPersistenceImpl.class);
}