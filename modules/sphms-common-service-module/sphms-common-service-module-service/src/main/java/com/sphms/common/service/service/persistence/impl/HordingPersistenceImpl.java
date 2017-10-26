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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchHordingException;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.impl.HordingImpl;
import com.sphms.common.service.model.impl.HordingModelImpl;
import com.sphms.common.service.service.persistence.HordingPersistence;

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
 * The persistence implementation for the hording service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HordingPersistence
 * @see com.sphms.common.service.service.persistence.HordingUtil
 * @generated
 */
@ProviderType
public class HordingPersistenceImpl extends BasePersistenceImpl<Hording>
	implements HordingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HordingUtil} to access the hording persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HordingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingModelImpl.FINDER_CACHE_ENABLED, HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingModelImpl.FINDER_CACHE_ENABLED, HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANDLORDID =
		new FinderPath(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingModelImpl.FINDER_CACHE_ENABLED, HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylandLordId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID =
		new FinderPath(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingModelImpl.FINDER_CACHE_ENABLED, HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylandLordId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			HordingModelImpl.LANDLORDID_COLUMN_BITMASK |
			HordingModelImpl.STATUS_COLUMN_BITMASK |
			HordingModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANDLORDID = new FinderPath(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylandLordId",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the hordings where landLordId = &#63; and status = &#63;.
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @return the matching hordings
	 */
	@Override
	public List<Hording> findBylandLordId(long landLordId, int status) {
		return findBylandLordId(landLordId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hordings where landLordId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @param start the lower bound of the range of hordings
	 * @param end the upper bound of the range of hordings (not inclusive)
	 * @return the range of matching hordings
	 */
	@Override
	public List<Hording> findBylandLordId(long landLordId, int status,
		int start, int end) {
		return findBylandLordId(landLordId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hordings where landLordId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @param start the lower bound of the range of hordings
	 * @param end the upper bound of the range of hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hordings
	 */
	@Override
	public List<Hording> findBylandLordId(long landLordId, int status,
		int start, int end, OrderByComparator<Hording> orderByComparator) {
		return findBylandLordId(landLordId, status, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hordings where landLordId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @param start the lower bound of the range of hordings
	 * @param end the upper bound of the range of hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching hordings
	 */
	@Override
	public List<Hording> findBylandLordId(long landLordId, int status,
		int start, int end, OrderByComparator<Hording> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID;
			finderArgs = new Object[] { landLordId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANDLORDID;
			finderArgs = new Object[] {
					landLordId, status,
					
					start, end, orderByComparator
				};
		}

		List<Hording> list = null;

		if (retrieveFromCache) {
			list = (List<Hording>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Hording hording : list) {
					if ((landLordId != hording.getLandLordId()) ||
							(status != hording.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_HORDING_WHERE);

			query.append(_FINDER_COLUMN_LANDLORDID_LANDLORDID_2);

			query.append(_FINDER_COLUMN_LANDLORDID_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HordingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(landLordId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Hording>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Hording>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first hording in the ordered set where landLordId = &#63; and status = &#63;.
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hording
	 * @throws NoSuchHordingException if a matching hording could not be found
	 */
	@Override
	public Hording findBylandLordId_First(long landLordId, int status,
		OrderByComparator<Hording> orderByComparator)
		throws NoSuchHordingException {
		Hording hording = fetchBylandLordId_First(landLordId, status,
				orderByComparator);

		if (hording != null) {
			return hording;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("landLordId=");
		msg.append(landLordId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHordingException(msg.toString());
	}

	/**
	 * Returns the first hording in the ordered set where landLordId = &#63; and status = &#63;.
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hording, or <code>null</code> if a matching hording could not be found
	 */
	@Override
	public Hording fetchBylandLordId_First(long landLordId, int status,
		OrderByComparator<Hording> orderByComparator) {
		List<Hording> list = findBylandLordId(landLordId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hording in the ordered set where landLordId = &#63; and status = &#63;.
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hording
	 * @throws NoSuchHordingException if a matching hording could not be found
	 */
	@Override
	public Hording findBylandLordId_Last(long landLordId, int status,
		OrderByComparator<Hording> orderByComparator)
		throws NoSuchHordingException {
		Hording hording = fetchBylandLordId_Last(landLordId, status,
				orderByComparator);

		if (hording != null) {
			return hording;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("landLordId=");
		msg.append(landLordId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHordingException(msg.toString());
	}

	/**
	 * Returns the last hording in the ordered set where landLordId = &#63; and status = &#63;.
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hording, or <code>null</code> if a matching hording could not be found
	 */
	@Override
	public Hording fetchBylandLordId_Last(long landLordId, int status,
		OrderByComparator<Hording> orderByComparator) {
		int count = countBylandLordId(landLordId, status);

		if (count == 0) {
			return null;
		}

		List<Hording> list = findBylandLordId(landLordId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hordings before and after the current hording in the ordered set where landLordId = &#63; and status = &#63;.
	 *
	 * @param hordingId the primary key of the current hording
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hording
	 * @throws NoSuchHordingException if a hording with the primary key could not be found
	 */
	@Override
	public Hording[] findBylandLordId_PrevAndNext(long hordingId,
		long landLordId, int status,
		OrderByComparator<Hording> orderByComparator)
		throws NoSuchHordingException {
		Hording hording = findByPrimaryKey(hordingId);

		Session session = null;

		try {
			session = openSession();

			Hording[] array = new HordingImpl[3];

			array[0] = getBylandLordId_PrevAndNext(session, hording,
					landLordId, status, orderByComparator, true);

			array[1] = hording;

			array[2] = getBylandLordId_PrevAndNext(session, hording,
					landLordId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Hording getBylandLordId_PrevAndNext(Session session,
		Hording hording, long landLordId, int status,
		OrderByComparator<Hording> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_HORDING_WHERE);

		query.append(_FINDER_COLUMN_LANDLORDID_LANDLORDID_2);

		query.append(_FINDER_COLUMN_LANDLORDID_STATUS_2);

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
			query.append(HordingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(landLordId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(hording);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Hording> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hordings where landLordId = &#63; and status = &#63; from the database.
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 */
	@Override
	public void removeBylandLordId(long landLordId, int status) {
		for (Hording hording : findBylandLordId(landLordId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(hording);
		}
	}

	/**
	 * Returns the number of hordings where landLordId = &#63; and status = &#63;.
	 *
	 * @param landLordId the land lord ID
	 * @param status the status
	 * @return the number of matching hordings
	 */
	@Override
	public int countBylandLordId(long landLordId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LANDLORDID;

		Object[] finderArgs = new Object[] { landLordId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HORDING_WHERE);

			query.append(_FINDER_COLUMN_LANDLORDID_LANDLORDID_2);

			query.append(_FINDER_COLUMN_LANDLORDID_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(landLordId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_LANDLORDID_LANDLORDID_2 = "hording.landLordId = ? AND ";
	private static final String _FINDER_COLUMN_LANDLORDID_STATUS_2 = "hording.status = ?";

	public HordingPersistenceImpl() {
		setModelClass(Hording.class);
	}

	/**
	 * Caches the hording in the entity cache if it is enabled.
	 *
	 * @param hording the hording
	 */
	@Override
	public void cacheResult(Hording hording) {
		entityCache.putResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingImpl.class, hording.getPrimaryKey(), hording);

		hording.resetOriginalValues();
	}

	/**
	 * Caches the hordings in the entity cache if it is enabled.
	 *
	 * @param hordings the hordings
	 */
	@Override
	public void cacheResult(List<Hording> hordings) {
		for (Hording hording : hordings) {
			if (entityCache.getResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
						HordingImpl.class, hording.getPrimaryKey()) == null) {
				cacheResult(hording);
			}
			else {
				hording.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hordings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HordingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hording.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Hording hording) {
		entityCache.removeResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingImpl.class, hording.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Hording> hordings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Hording hording : hordings) {
			entityCache.removeResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
				HordingImpl.class, hording.getPrimaryKey());
		}
	}

	/**
	 * Creates a new hording with the primary key. Does not add the hording to the database.
	 *
	 * @param hordingId the primary key for the new hording
	 * @return the new hording
	 */
	@Override
	public Hording create(long hordingId) {
		Hording hording = new HordingImpl();

		hording.setNew(true);
		hording.setPrimaryKey(hordingId);

		return hording;
	}

	/**
	 * Removes the hording with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hordingId the primary key of the hording
	 * @return the hording that was removed
	 * @throws NoSuchHordingException if a hording with the primary key could not be found
	 */
	@Override
	public Hording remove(long hordingId) throws NoSuchHordingException {
		return remove((Serializable)hordingId);
	}

	/**
	 * Removes the hording with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hording
	 * @return the hording that was removed
	 * @throws NoSuchHordingException if a hording with the primary key could not be found
	 */
	@Override
	public Hording remove(Serializable primaryKey)
		throws NoSuchHordingException {
		Session session = null;

		try {
			session = openSession();

			Hording hording = (Hording)session.get(HordingImpl.class, primaryKey);

			if (hording == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHordingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(hording);
		}
		catch (NoSuchHordingException nsee) {
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
	protected Hording removeImpl(Hording hording) {
		hording = toUnwrappedModel(hording);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(hording)) {
				hording = (Hording)session.get(HordingImpl.class,
						hording.getPrimaryKeyObj());
			}

			if (hording != null) {
				session.delete(hording);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (hording != null) {
			clearCache(hording);
		}

		return hording;
	}

	@Override
	public Hording updateImpl(Hording hording) {
		hording = toUnwrappedModel(hording);

		boolean isNew = hording.isNew();

		HordingModelImpl hordingModelImpl = (HordingModelImpl)hording;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (hording.getCreateDate() == null)) {
			if (serviceContext == null) {
				hording.setCreateDate(now);
			}
			else {
				hording.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!hordingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				hording.setModifiedDate(now);
			}
			else {
				hording.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (hording.isNew()) {
				session.save(hording);

				hording.setNew(false);
			}
			else {
				hording = (Hording)session.merge(hording);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HordingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((hordingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						hordingModelImpl.getOriginalLandLordId(),
						hordingModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LANDLORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID,
					args);

				args = new Object[] {
						hordingModelImpl.getLandLordId(),
						hordingModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LANDLORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID,
					args);
			}
		}

		entityCache.putResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
			HordingImpl.class, hording.getPrimaryKey(), hording, false);

		hording.resetOriginalValues();

		return hording;
	}

	protected Hording toUnwrappedModel(Hording hording) {
		if (hording instanceof HordingImpl) {
			return hording;
		}

		HordingImpl hordingImpl = new HordingImpl();

		hordingImpl.setNew(hording.isNew());
		hordingImpl.setPrimaryKey(hording.getPrimaryKey());

		hordingImpl.setHordingId(hording.getHordingId());
		hordingImpl.setTitle(hording.getTitle());
		hordingImpl.setLocation(hording.getLocation());
		hordingImpl.setCity(hording.getCity());
		hordingImpl.setDistrict(hording.getDistrict());
		hordingImpl.setState(hording.getState());
		hordingImpl.setHordingType(hording.getHordingType());
		hordingImpl.setMediaVehicle(hording.getMediaVehicle());
		hordingImpl.setSize(hording.getSize());
		hordingImpl.setPricePerMonth(hording.getPricePerMonth());
		hordingImpl.setNormalImageId(hording.getNormalImageId());
		hordingImpl.setShortImageId(hording.getShortImageId());
		hordingImpl.setLongImageId(hording.getLongImageId());
		hordingImpl.setLandLordId(hording.getLandLordId());
		hordingImpl.setOwnerType(hording.getOwnerType());
		hordingImpl.setUpinNo(hording.getUpinNo());
		hordingImpl.setMncTax(hording.getMncTax());
		hordingImpl.setOtherExpYear(hording.getOtherExpYear());
		hordingImpl.setStatus(hording.getStatus());
		hordingImpl.setCreateDate(hording.getCreateDate());
		hordingImpl.setCreatedBy(hording.getCreatedBy());
		hordingImpl.setModifiedDate(hording.getModifiedDate());
		hordingImpl.setModifiedBy(hording.getModifiedBy());

		return hordingImpl;
	}

	/**
	 * Returns the hording with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the hording
	 * @return the hording
	 * @throws NoSuchHordingException if a hording with the primary key could not be found
	 */
	@Override
	public Hording findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHordingException {
		Hording hording = fetchByPrimaryKey(primaryKey);

		if (hording == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHordingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return hording;
	}

	/**
	 * Returns the hording with the primary key or throws a {@link NoSuchHordingException} if it could not be found.
	 *
	 * @param hordingId the primary key of the hording
	 * @return the hording
	 * @throws NoSuchHordingException if a hording with the primary key could not be found
	 */
	@Override
	public Hording findByPrimaryKey(long hordingId)
		throws NoSuchHordingException {
		return findByPrimaryKey((Serializable)hordingId);
	}

	/**
	 * Returns the hording with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hording
	 * @return the hording, or <code>null</code> if a hording with the primary key could not be found
	 */
	@Override
	public Hording fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
				HordingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Hording hording = (Hording)serializable;

		if (hording == null) {
			Session session = null;

			try {
				session = openSession();

				hording = (Hording)session.get(HordingImpl.class, primaryKey);

				if (hording != null) {
					cacheResult(hording);
				}
				else {
					entityCache.putResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
						HordingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
					HordingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return hording;
	}

	/**
	 * Returns the hording with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hordingId the primary key of the hording
	 * @return the hording, or <code>null</code> if a hording with the primary key could not be found
	 */
	@Override
	public Hording fetchByPrimaryKey(long hordingId) {
		return fetchByPrimaryKey((Serializable)hordingId);
	}

	@Override
	public Map<Serializable, Hording> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Hording> map = new HashMap<Serializable, Hording>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Hording hording = fetchByPrimaryKey(primaryKey);

			if (hording != null) {
				map.put(primaryKey, hording);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
					HordingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Hording)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_HORDING_WHERE_PKS_IN);

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

			for (Hording hording : (List<Hording>)q.list()) {
				map.put(hording.getPrimaryKeyObj(), hording);

				cacheResult(hording);

				uncachedPrimaryKeys.remove(hording.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(HordingModelImpl.ENTITY_CACHE_ENABLED,
					HordingImpl.class, primaryKey, nullModel);
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
	 * Returns all the hordings.
	 *
	 * @return the hordings
	 */
	@Override
	public List<Hording> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hordings
	 * @param end the upper bound of the range of hordings (not inclusive)
	 * @return the range of hordings
	 */
	@Override
	public List<Hording> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hordings
	 * @param end the upper bound of the range of hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hordings
	 */
	@Override
	public List<Hording> findAll(int start, int end,
		OrderByComparator<Hording> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hordings
	 * @param end the upper bound of the range of hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of hordings
	 */
	@Override
	public List<Hording> findAll(int start, int end,
		OrderByComparator<Hording> orderByComparator, boolean retrieveFromCache) {
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

		List<Hording> list = null;

		if (retrieveFromCache) {
			list = (List<Hording>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_HORDING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HORDING;

				if (pagination) {
					sql = sql.concat(HordingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Hording>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Hording>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the hordings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Hording hording : findAll()) {
			remove(hording);
		}
	}

	/**
	 * Returns the number of hordings.
	 *
	 * @return the number of hordings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HORDING);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HordingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the hording persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(HordingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_HORDING = "SELECT hording FROM Hording hording";
	private static final String _SQL_SELECT_HORDING_WHERE_PKS_IN = "SELECT hording FROM Hording hording WHERE hordingId IN (";
	private static final String _SQL_SELECT_HORDING_WHERE = "SELECT hording FROM Hording hording WHERE ";
	private static final String _SQL_COUNT_HORDING = "SELECT COUNT(hording) FROM Hording hording";
	private static final String _SQL_COUNT_HORDING_WHERE = "SELECT COUNT(hording) FROM Hording hording WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "hording.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Hording exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Hording exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(HordingPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state", "size"
			});
}