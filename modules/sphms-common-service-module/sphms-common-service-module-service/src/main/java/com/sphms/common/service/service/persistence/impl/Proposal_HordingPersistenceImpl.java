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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchProposal_HordingException;
import com.sphms.common.service.model.Proposal_Hording;
import com.sphms.common.service.model.impl.Proposal_HordingImpl;
import com.sphms.common.service.model.impl.Proposal_HordingModelImpl;
import com.sphms.common.service.service.persistence.Proposal_HordingPK;
import com.sphms.common.service.service.persistence.Proposal_HordingPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the proposal_ hording service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Proposal_HordingPersistence
 * @see com.sphms.common.service.service.persistence.Proposal_HordingUtil
 * @generated
 */
@ProviderType
public class Proposal_HordingPersistenceImpl extends BasePersistenceImpl<Proposal_Hording>
	implements Proposal_HordingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Proposal_HordingUtil} to access the proposal_ hording persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Proposal_HordingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingModelImpl.FINDER_CACHE_ENABLED,
			Proposal_HordingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingModelImpl.FINDER_CACHE_ENABLED,
			Proposal_HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSALID =
		new FinderPath(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingModelImpl.FINDER_CACHE_ENABLED,
			Proposal_HordingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByproposalId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID =
		new FinderPath(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingModelImpl.FINDER_CACHE_ENABLED,
			Proposal_HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByproposalId",
			new String[] { Long.class.getName() },
			Proposal_HordingModelImpl.PROPOSALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROPOSALID = new FinderPath(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproposalId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the proposal_ hordings where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the matching proposal_ hordings
	 */
	@Override
	public List<Proposal_Hording> findByproposalId(long proposalId) {
		return findByproposalId(proposalId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Proposal_Hording> findByproposalId(long proposalId, int start,
		int end) {
		return findByproposalId(proposalId, start, end, null);
	}

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
	@Override
	public List<Proposal_Hording> findByproposalId(long proposalId, int start,
		int end, OrderByComparator<Proposal_Hording> orderByComparator) {
		return findByproposalId(proposalId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Proposal_Hording> findByproposalId(long proposalId, int start,
		int end, OrderByComparator<Proposal_Hording> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID;
			finderArgs = new Object[] { proposalId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSALID;
			finderArgs = new Object[] { proposalId, start, end, orderByComparator };
		}

		List<Proposal_Hording> list = null;

		if (retrieveFromCache) {
			list = (List<Proposal_Hording>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Proposal_Hording proposal_Hording : list) {
					if ((proposalId != proposal_Hording.getProposalId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PROPOSAL_HORDING_WHERE);

			query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Proposal_HordingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(proposalId);

				if (!pagination) {
					list = (List<Proposal_Hording>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Proposal_Hording>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first proposal_ hording in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal_ hording
	 * @throws NoSuchProposal_HordingException if a matching proposal_ hording could not be found
	 */
	@Override
	public Proposal_Hording findByproposalId_First(long proposalId,
		OrderByComparator<Proposal_Hording> orderByComparator)
		throws NoSuchProposal_HordingException {
		Proposal_Hording proposal_Hording = fetchByproposalId_First(proposalId,
				orderByComparator);

		if (proposal_Hording != null) {
			return proposal_Hording;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("proposalId=");
		msg.append(proposalId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProposal_HordingException(msg.toString());
	}

	/**
	 * Returns the first proposal_ hording in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal_ hording, or <code>null</code> if a matching proposal_ hording could not be found
	 */
	@Override
	public Proposal_Hording fetchByproposalId_First(long proposalId,
		OrderByComparator<Proposal_Hording> orderByComparator) {
		List<Proposal_Hording> list = findByproposalId(proposalId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposal_ hording in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal_ hording
	 * @throws NoSuchProposal_HordingException if a matching proposal_ hording could not be found
	 */
	@Override
	public Proposal_Hording findByproposalId_Last(long proposalId,
		OrderByComparator<Proposal_Hording> orderByComparator)
		throws NoSuchProposal_HordingException {
		Proposal_Hording proposal_Hording = fetchByproposalId_Last(proposalId,
				orderByComparator);

		if (proposal_Hording != null) {
			return proposal_Hording;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("proposalId=");
		msg.append(proposalId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProposal_HordingException(msg.toString());
	}

	/**
	 * Returns the last proposal_ hording in the ordered set where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal_ hording, or <code>null</code> if a matching proposal_ hording could not be found
	 */
	@Override
	public Proposal_Hording fetchByproposalId_Last(long proposalId,
		OrderByComparator<Proposal_Hording> orderByComparator) {
		int count = countByproposalId(proposalId);

		if (count == 0) {
			return null;
		}

		List<Proposal_Hording> list = findByproposalId(proposalId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposal_ hordings before and after the current proposal_ hording in the ordered set where proposalId = &#63;.
	 *
	 * @param proposal_HordingPK the primary key of the current proposal_ hording
	 * @param proposalId the proposal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposal_ hording
	 * @throws NoSuchProposal_HordingException if a proposal_ hording with the primary key could not be found
	 */
	@Override
	public Proposal_Hording[] findByproposalId_PrevAndNext(
		Proposal_HordingPK proposal_HordingPK, long proposalId,
		OrderByComparator<Proposal_Hording> orderByComparator)
		throws NoSuchProposal_HordingException {
		Proposal_Hording proposal_Hording = findByPrimaryKey(proposal_HordingPK);

		Session session = null;

		try {
			session = openSession();

			Proposal_Hording[] array = new Proposal_HordingImpl[3];

			array[0] = getByproposalId_PrevAndNext(session, proposal_Hording,
					proposalId, orderByComparator, true);

			array[1] = proposal_Hording;

			array[2] = getByproposalId_PrevAndNext(session, proposal_Hording,
					proposalId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Proposal_Hording getByproposalId_PrevAndNext(Session session,
		Proposal_Hording proposal_Hording, long proposalId,
		OrderByComparator<Proposal_Hording> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSAL_HORDING_WHERE);

		query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Proposal_HordingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(proposalId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposal_Hording);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Proposal_Hording> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proposal_ hordings where proposalId = &#63; from the database.
	 *
	 * @param proposalId the proposal ID
	 */
	@Override
	public void removeByproposalId(long proposalId) {
		for (Proposal_Hording proposal_Hording : findByproposalId(proposalId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(proposal_Hording);
		}
	}

	/**
	 * Returns the number of proposal_ hordings where proposalId = &#63;.
	 *
	 * @param proposalId the proposal ID
	 * @return the number of matching proposal_ hordings
	 */
	@Override
	public int countByproposalId(long proposalId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROPOSALID;

		Object[] finderArgs = new Object[] { proposalId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSAL_HORDING_WHERE);

			query.append(_FINDER_COLUMN_PROPOSALID_PROPOSALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(proposalId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROPOSALID_PROPOSALID_2 = "proposal_Hording.id.proposalId = ?";

	public Proposal_HordingPersistenceImpl() {
		setModelClass(Proposal_Hording.class);
	}

	/**
	 * Caches the proposal_ hording in the entity cache if it is enabled.
	 *
	 * @param proposal_Hording the proposal_ hording
	 */
	@Override
	public void cacheResult(Proposal_Hording proposal_Hording) {
		entityCache.putResult(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingImpl.class, proposal_Hording.getPrimaryKey(),
			proposal_Hording);

		proposal_Hording.resetOriginalValues();
	}

	/**
	 * Caches the proposal_ hordings in the entity cache if it is enabled.
	 *
	 * @param proposal_Hordings the proposal_ hordings
	 */
	@Override
	public void cacheResult(List<Proposal_Hording> proposal_Hordings) {
		for (Proposal_Hording proposal_Hording : proposal_Hordings) {
			if (entityCache.getResult(
						Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
						Proposal_HordingImpl.class,
						proposal_Hording.getPrimaryKey()) == null) {
				cacheResult(proposal_Hording);
			}
			else {
				proposal_Hording.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all proposal_ hordings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Proposal_HordingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the proposal_ hording.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Proposal_Hording proposal_Hording) {
		entityCache.removeResult(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingImpl.class, proposal_Hording.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Proposal_Hording> proposal_Hordings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Proposal_Hording proposal_Hording : proposal_Hordings) {
			entityCache.removeResult(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
				Proposal_HordingImpl.class, proposal_Hording.getPrimaryKey());
		}
	}

	/**
	 * Creates a new proposal_ hording with the primary key. Does not add the proposal_ hording to the database.
	 *
	 * @param proposal_HordingPK the primary key for the new proposal_ hording
	 * @return the new proposal_ hording
	 */
	@Override
	public Proposal_Hording create(Proposal_HordingPK proposal_HordingPK) {
		Proposal_Hording proposal_Hording = new Proposal_HordingImpl();

		proposal_Hording.setNew(true);
		proposal_Hording.setPrimaryKey(proposal_HordingPK);

		return proposal_Hording;
	}

	/**
	 * Removes the proposal_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposal_HordingPK the primary key of the proposal_ hording
	 * @return the proposal_ hording that was removed
	 * @throws NoSuchProposal_HordingException if a proposal_ hording with the primary key could not be found
	 */
	@Override
	public Proposal_Hording remove(Proposal_HordingPK proposal_HordingPK)
		throws NoSuchProposal_HordingException {
		return remove((Serializable)proposal_HordingPK);
	}

	/**
	 * Removes the proposal_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proposal_ hording
	 * @return the proposal_ hording that was removed
	 * @throws NoSuchProposal_HordingException if a proposal_ hording with the primary key could not be found
	 */
	@Override
	public Proposal_Hording remove(Serializable primaryKey)
		throws NoSuchProposal_HordingException {
		Session session = null;

		try {
			session = openSession();

			Proposal_Hording proposal_Hording = (Proposal_Hording)session.get(Proposal_HordingImpl.class,
					primaryKey);

			if (proposal_Hording == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProposal_HordingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(proposal_Hording);
		}
		catch (NoSuchProposal_HordingException nsee) {
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
	protected Proposal_Hording removeImpl(Proposal_Hording proposal_Hording) {
		proposal_Hording = toUnwrappedModel(proposal_Hording);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(proposal_Hording)) {
				proposal_Hording = (Proposal_Hording)session.get(Proposal_HordingImpl.class,
						proposal_Hording.getPrimaryKeyObj());
			}

			if (proposal_Hording != null) {
				session.delete(proposal_Hording);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (proposal_Hording != null) {
			clearCache(proposal_Hording);
		}

		return proposal_Hording;
	}

	@Override
	public Proposal_Hording updateImpl(Proposal_Hording proposal_Hording) {
		proposal_Hording = toUnwrappedModel(proposal_Hording);

		boolean isNew = proposal_Hording.isNew();

		Proposal_HordingModelImpl proposal_HordingModelImpl = (Proposal_HordingModelImpl)proposal_Hording;

		Session session = null;

		try {
			session = openSession();

			if (proposal_Hording.isNew()) {
				session.save(proposal_Hording);

				proposal_Hording.setNew(false);
			}
			else {
				proposal_Hording = (Proposal_Hording)session.merge(proposal_Hording);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Proposal_HordingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((proposal_HordingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						proposal_HordingModelImpl.getOriginalProposalId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROPOSALID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID,
					args);

				args = new Object[] { proposal_HordingModelImpl.getProposalId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROPOSALID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALID,
					args);
			}
		}

		entityCache.putResult(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Proposal_HordingImpl.class, proposal_Hording.getPrimaryKey(),
			proposal_Hording, false);

		proposal_Hording.resetOriginalValues();

		return proposal_Hording;
	}

	protected Proposal_Hording toUnwrappedModel(
		Proposal_Hording proposal_Hording) {
		if (proposal_Hording instanceof Proposal_HordingImpl) {
			return proposal_Hording;
		}

		Proposal_HordingImpl proposal_HordingImpl = new Proposal_HordingImpl();

		proposal_HordingImpl.setNew(proposal_Hording.isNew());
		proposal_HordingImpl.setPrimaryKey(proposal_Hording.getPrimaryKey());

		proposal_HordingImpl.setProposalId(proposal_Hording.getProposalId());
		proposal_HordingImpl.setHordingId(proposal_Hording.getHordingId());
		proposal_HordingImpl.setMountingCharge(proposal_Hording.getMountingCharge());
		proposal_HordingImpl.setPrintingCharge(proposal_Hording.getPrintingCharge());
		proposal_HordingImpl.setUnits(proposal_Hording.getUnits());

		return proposal_HordingImpl;
	}

	/**
	 * Returns the proposal_ hording with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposal_ hording
	 * @return the proposal_ hording
	 * @throws NoSuchProposal_HordingException if a proposal_ hording with the primary key could not be found
	 */
	@Override
	public Proposal_Hording findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProposal_HordingException {
		Proposal_Hording proposal_Hording = fetchByPrimaryKey(primaryKey);

		if (proposal_Hording == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProposal_HordingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return proposal_Hording;
	}

	/**
	 * Returns the proposal_ hording with the primary key or throws a {@link NoSuchProposal_HordingException} if it could not be found.
	 *
	 * @param proposal_HordingPK the primary key of the proposal_ hording
	 * @return the proposal_ hording
	 * @throws NoSuchProposal_HordingException if a proposal_ hording with the primary key could not be found
	 */
	@Override
	public Proposal_Hording findByPrimaryKey(
		Proposal_HordingPK proposal_HordingPK)
		throws NoSuchProposal_HordingException {
		return findByPrimaryKey((Serializable)proposal_HordingPK);
	}

	/**
	 * Returns the proposal_ hording with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposal_ hording
	 * @return the proposal_ hording, or <code>null</code> if a proposal_ hording with the primary key could not be found
	 */
	@Override
	public Proposal_Hording fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
				Proposal_HordingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Proposal_Hording proposal_Hording = (Proposal_Hording)serializable;

		if (proposal_Hording == null) {
			Session session = null;

			try {
				session = openSession();

				proposal_Hording = (Proposal_Hording)session.get(Proposal_HordingImpl.class,
						primaryKey);

				if (proposal_Hording != null) {
					cacheResult(proposal_Hording);
				}
				else {
					entityCache.putResult(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
						Proposal_HordingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Proposal_HordingModelImpl.ENTITY_CACHE_ENABLED,
					Proposal_HordingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return proposal_Hording;
	}

	/**
	 * Returns the proposal_ hording with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proposal_HordingPK the primary key of the proposal_ hording
	 * @return the proposal_ hording, or <code>null</code> if a proposal_ hording with the primary key could not be found
	 */
	@Override
	public Proposal_Hording fetchByPrimaryKey(
		Proposal_HordingPK proposal_HordingPK) {
		return fetchByPrimaryKey((Serializable)proposal_HordingPK);
	}

	@Override
	public Map<Serializable, Proposal_Hording> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Proposal_Hording> map = new HashMap<Serializable, Proposal_Hording>();

		for (Serializable primaryKey : primaryKeys) {
			Proposal_Hording proposal_Hording = fetchByPrimaryKey(primaryKey);

			if (proposal_Hording != null) {
				map.put(primaryKey, proposal_Hording);
			}
		}

		return map;
	}

	/**
	 * Returns all the proposal_ hordings.
	 *
	 * @return the proposal_ hordings
	 */
	@Override
	public List<Proposal_Hording> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Proposal_Hording> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Proposal_Hording> findAll(int start, int end,
		OrderByComparator<Proposal_Hording> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Proposal_Hording> findAll(int start, int end,
		OrderByComparator<Proposal_Hording> orderByComparator,
		boolean retrieveFromCache) {
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

		List<Proposal_Hording> list = null;

		if (retrieveFromCache) {
			list = (List<Proposal_Hording>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROPOSAL_HORDING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROPOSAL_HORDING;

				if (pagination) {
					sql = sql.concat(Proposal_HordingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Proposal_Hording>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Proposal_Hording>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the proposal_ hordings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Proposal_Hording proposal_Hording : findAll()) {
			remove(proposal_Hording);
		}
	}

	/**
	 * Returns the number of proposal_ hordings.
	 *
	 * @return the number of proposal_ hordings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROPOSAL_HORDING);

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
		return Proposal_HordingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the proposal_ hording persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Proposal_HordingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROPOSAL_HORDING = "SELECT proposal_Hording FROM Proposal_Hording proposal_Hording";
	private static final String _SQL_SELECT_PROPOSAL_HORDING_WHERE = "SELECT proposal_Hording FROM Proposal_Hording proposal_Hording WHERE ";
	private static final String _SQL_COUNT_PROPOSAL_HORDING = "SELECT COUNT(proposal_Hording) FROM Proposal_Hording proposal_Hording";
	private static final String _SQL_COUNT_PROPOSAL_HORDING_WHERE = "SELECT COUNT(proposal_Hording) FROM Proposal_Hording proposal_Hording WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "proposal_Hording.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Proposal_Hording exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Proposal_Hording exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Proposal_HordingPersistenceImpl.class);
}