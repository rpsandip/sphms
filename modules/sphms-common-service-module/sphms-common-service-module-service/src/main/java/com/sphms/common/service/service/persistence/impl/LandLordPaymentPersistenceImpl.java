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

import com.sphms.common.service.exception.NoSuchLandLordPaymentException;
import com.sphms.common.service.model.LandLordPayment;
import com.sphms.common.service.model.impl.LandLordPaymentImpl;
import com.sphms.common.service.model.impl.LandLordPaymentModelImpl;
import com.sphms.common.service.service.persistence.LandLordPaymentPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the land lord payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPaymentPersistence
 * @see com.sphms.common.service.service.persistence.LandLordPaymentUtil
 * @generated
 */
@ProviderType
public class LandLordPaymentPersistenceImpl extends BasePersistenceImpl<LandLordPayment>
	implements LandLordPaymentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LandLordPaymentUtil} to access the land lord payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LandLordPaymentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentModelImpl.FINDER_CACHE_ENABLED,
			LandLordPaymentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentModelImpl.FINDER_CACHE_ENABLED,
			LandLordPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANDLORDID =
		new FinderPath(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentModelImpl.FINDER_CACHE_ENABLED,
			LandLordPaymentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBylandLordId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID =
		new FinderPath(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentModelImpl.FINDER_CACHE_ENABLED,
			LandLordPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylandLordId",
			new String[] { Long.class.getName() },
			LandLordPaymentModelImpl.LANDLOADID_COLUMN_BITMASK |
			LandLordPaymentModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANDLORDID = new FinderPath(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylandLordId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the land lord payments where landLoadId = &#63;.
	 *
	 * @param landLoadId the land load ID
	 * @return the matching land lord payments
	 */
	@Override
	public List<LandLordPayment> findBylandLordId(long landLoadId) {
		return findBylandLordId(landLoadId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land lord payments where landLoadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param landLoadId the land load ID
	 * @param start the lower bound of the range of land lord payments
	 * @param end the upper bound of the range of land lord payments (not inclusive)
	 * @return the range of matching land lord payments
	 */
	@Override
	public List<LandLordPayment> findBylandLordId(long landLoadId, int start,
		int end) {
		return findBylandLordId(landLoadId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the land lord payments where landLoadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param landLoadId the land load ID
	 * @param start the lower bound of the range of land lord payments
	 * @param end the upper bound of the range of land lord payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching land lord payments
	 */
	@Override
	public List<LandLordPayment> findBylandLordId(long landLoadId, int start,
		int end, OrderByComparator<LandLordPayment> orderByComparator) {
		return findBylandLordId(landLoadId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the land lord payments where landLoadId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param landLoadId the land load ID
	 * @param start the lower bound of the range of land lord payments
	 * @param end the upper bound of the range of land lord payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching land lord payments
	 */
	@Override
	public List<LandLordPayment> findBylandLordId(long landLoadId, int start,
		int end, OrderByComparator<LandLordPayment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID;
			finderArgs = new Object[] { landLoadId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANDLORDID;
			finderArgs = new Object[] { landLoadId, start, end, orderByComparator };
		}

		List<LandLordPayment> list = null;

		if (retrieveFromCache) {
			list = (List<LandLordPayment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LandLordPayment landLordPayment : list) {
					if ((landLoadId != landLordPayment.getLandLoadId())) {
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

			query.append(_SQL_SELECT_LANDLORDPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_LANDLORDID_LANDLOADID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LandLordPaymentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(landLoadId);

				if (!pagination) {
					list = (List<LandLordPayment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LandLordPayment>)QueryUtil.list(q,
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
	 * Returns the first land lord payment in the ordered set where landLoadId = &#63;.
	 *
	 * @param landLoadId the land load ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land lord payment
	 * @throws NoSuchLandLordPaymentException if a matching land lord payment could not be found
	 */
	@Override
	public LandLordPayment findBylandLordId_First(long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator)
		throws NoSuchLandLordPaymentException {
		LandLordPayment landLordPayment = fetchBylandLordId_First(landLoadId,
				orderByComparator);

		if (landLordPayment != null) {
			return landLordPayment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("landLoadId=");
		msg.append(landLoadId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandLordPaymentException(msg.toString());
	}

	/**
	 * Returns the first land lord payment in the ordered set where landLoadId = &#63;.
	 *
	 * @param landLoadId the land load ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching land lord payment, or <code>null</code> if a matching land lord payment could not be found
	 */
	@Override
	public LandLordPayment fetchBylandLordId_First(long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator) {
		List<LandLordPayment> list = findBylandLordId(landLoadId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last land lord payment in the ordered set where landLoadId = &#63;.
	 *
	 * @param landLoadId the land load ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land lord payment
	 * @throws NoSuchLandLordPaymentException if a matching land lord payment could not be found
	 */
	@Override
	public LandLordPayment findBylandLordId_Last(long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator)
		throws NoSuchLandLordPaymentException {
		LandLordPayment landLordPayment = fetchBylandLordId_Last(landLoadId,
				orderByComparator);

		if (landLordPayment != null) {
			return landLordPayment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("landLoadId=");
		msg.append(landLoadId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLandLordPaymentException(msg.toString());
	}

	/**
	 * Returns the last land lord payment in the ordered set where landLoadId = &#63;.
	 *
	 * @param landLoadId the land load ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching land lord payment, or <code>null</code> if a matching land lord payment could not be found
	 */
	@Override
	public LandLordPayment fetchBylandLordId_Last(long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator) {
		int count = countBylandLordId(landLoadId);

		if (count == 0) {
			return null;
		}

		List<LandLordPayment> list = findBylandLordId(landLoadId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the land lord payments before and after the current land lord payment in the ordered set where landLoadId = &#63;.
	 *
	 * @param landLordPaymentId the primary key of the current land lord payment
	 * @param landLoadId the land load ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next land lord payment
	 * @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	 */
	@Override
	public LandLordPayment[] findBylandLordId_PrevAndNext(
		long landLordPaymentId, long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator)
		throws NoSuchLandLordPaymentException {
		LandLordPayment landLordPayment = findByPrimaryKey(landLordPaymentId);

		Session session = null;

		try {
			session = openSession();

			LandLordPayment[] array = new LandLordPaymentImpl[3];

			array[0] = getBylandLordId_PrevAndNext(session, landLordPayment,
					landLoadId, orderByComparator, true);

			array[1] = landLordPayment;

			array[2] = getBylandLordId_PrevAndNext(session, landLordPayment,
					landLoadId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LandLordPayment getBylandLordId_PrevAndNext(Session session,
		LandLordPayment landLordPayment, long landLoadId,
		OrderByComparator<LandLordPayment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANDLORDPAYMENT_WHERE);

		query.append(_FINDER_COLUMN_LANDLORDID_LANDLOADID_2);

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
			query.append(LandLordPaymentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(landLoadId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(landLordPayment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LandLordPayment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the land lord payments where landLoadId = &#63; from the database.
	 *
	 * @param landLoadId the land load ID
	 */
	@Override
	public void removeBylandLordId(long landLoadId) {
		for (LandLordPayment landLordPayment : findBylandLordId(landLoadId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(landLordPayment);
		}
	}

	/**
	 * Returns the number of land lord payments where landLoadId = &#63;.
	 *
	 * @param landLoadId the land load ID
	 * @return the number of matching land lord payments
	 */
	@Override
	public int countBylandLordId(long landLoadId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LANDLORDID;

		Object[] finderArgs = new Object[] { landLoadId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANDLORDPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_LANDLORDID_LANDLOADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(landLoadId);

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

	private static final String _FINDER_COLUMN_LANDLORDID_LANDLOADID_2 = "landLordPayment.landLoadId = ?";

	public LandLordPaymentPersistenceImpl() {
		setModelClass(LandLordPayment.class);
	}

	/**
	 * Caches the land lord payment in the entity cache if it is enabled.
	 *
	 * @param landLordPayment the land lord payment
	 */
	@Override
	public void cacheResult(LandLordPayment landLordPayment) {
		entityCache.putResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentImpl.class, landLordPayment.getPrimaryKey(),
			landLordPayment);

		landLordPayment.resetOriginalValues();
	}

	/**
	 * Caches the land lord payments in the entity cache if it is enabled.
	 *
	 * @param landLordPayments the land lord payments
	 */
	@Override
	public void cacheResult(List<LandLordPayment> landLordPayments) {
		for (LandLordPayment landLordPayment : landLordPayments) {
			if (entityCache.getResult(
						LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
						LandLordPaymentImpl.class,
						landLordPayment.getPrimaryKey()) == null) {
				cacheResult(landLordPayment);
			}
			else {
				landLordPayment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all land lord payments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LandLordPaymentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the land lord payment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LandLordPayment landLordPayment) {
		entityCache.removeResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentImpl.class, landLordPayment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LandLordPayment> landLordPayments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LandLordPayment landLordPayment : landLordPayments) {
			entityCache.removeResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
				LandLordPaymentImpl.class, landLordPayment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new land lord payment with the primary key. Does not add the land lord payment to the database.
	 *
	 * @param landLordPaymentId the primary key for the new land lord payment
	 * @return the new land lord payment
	 */
	@Override
	public LandLordPayment create(long landLordPaymentId) {
		LandLordPayment landLordPayment = new LandLordPaymentImpl();

		landLordPayment.setNew(true);
		landLordPayment.setPrimaryKey(landLordPaymentId);

		return landLordPayment;
	}

	/**
	 * Removes the land lord payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param landLordPaymentId the primary key of the land lord payment
	 * @return the land lord payment that was removed
	 * @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	 */
	@Override
	public LandLordPayment remove(long landLordPaymentId)
		throws NoSuchLandLordPaymentException {
		return remove((Serializable)landLordPaymentId);
	}

	/**
	 * Removes the land lord payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the land lord payment
	 * @return the land lord payment that was removed
	 * @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	 */
	@Override
	public LandLordPayment remove(Serializable primaryKey)
		throws NoSuchLandLordPaymentException {
		Session session = null;

		try {
			session = openSession();

			LandLordPayment landLordPayment = (LandLordPayment)session.get(LandLordPaymentImpl.class,
					primaryKey);

			if (landLordPayment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLandLordPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(landLordPayment);
		}
		catch (NoSuchLandLordPaymentException nsee) {
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
	protected LandLordPayment removeImpl(LandLordPayment landLordPayment) {
		landLordPayment = toUnwrappedModel(landLordPayment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(landLordPayment)) {
				landLordPayment = (LandLordPayment)session.get(LandLordPaymentImpl.class,
						landLordPayment.getPrimaryKeyObj());
			}

			if (landLordPayment != null) {
				session.delete(landLordPayment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (landLordPayment != null) {
			clearCache(landLordPayment);
		}

		return landLordPayment;
	}

	@Override
	public LandLordPayment updateImpl(LandLordPayment landLordPayment) {
		landLordPayment = toUnwrappedModel(landLordPayment);

		boolean isNew = landLordPayment.isNew();

		LandLordPaymentModelImpl landLordPaymentModelImpl = (LandLordPaymentModelImpl)landLordPayment;

		Session session = null;

		try {
			session = openSession();

			if (landLordPayment.isNew()) {
				session.save(landLordPayment);

				landLordPayment.setNew(false);
			}
			else {
				landLordPayment = (LandLordPayment)session.merge(landLordPayment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LandLordPaymentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((landLordPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						landLordPaymentModelImpl.getOriginalLandLoadId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LANDLORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID,
					args);

				args = new Object[] { landLordPaymentModelImpl.getLandLoadId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LANDLORDID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANDLORDID,
					args);
			}
		}

		entityCache.putResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
			LandLordPaymentImpl.class, landLordPayment.getPrimaryKey(),
			landLordPayment, false);

		landLordPayment.resetOriginalValues();

		return landLordPayment;
	}

	protected LandLordPayment toUnwrappedModel(LandLordPayment landLordPayment) {
		if (landLordPayment instanceof LandLordPaymentImpl) {
			return landLordPayment;
		}

		LandLordPaymentImpl landLordPaymentImpl = new LandLordPaymentImpl();

		landLordPaymentImpl.setNew(landLordPayment.isNew());
		landLordPaymentImpl.setPrimaryKey(landLordPayment.getPrimaryKey());

		landLordPaymentImpl.setLandLordPaymentId(landLordPayment.getLandLordPaymentId());
		landLordPaymentImpl.setLandLoadId(landLordPayment.getLandLoadId());
		landLordPaymentImpl.setHordingId(landLordPayment.getHordingId());
		landLordPaymentImpl.setAmount(landLordPayment.getAmount());
		landLordPaymentImpl.setChequeNo(landLordPayment.getChequeNo());
		landLordPaymentImpl.setBankName(landLordPayment.getBankName());
		landLordPaymentImpl.setPaymentDate(landLordPayment.getPaymentDate());
		landLordPaymentImpl.setDescription(landLordPayment.getDescription());
		landLordPaymentImpl.setCreateDate(landLordPayment.getCreateDate());
		landLordPaymentImpl.setCreatedBy(landLordPayment.getCreatedBy());

		return landLordPaymentImpl;
	}

	/**
	 * Returns the land lord payment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the land lord payment
	 * @return the land lord payment
	 * @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	 */
	@Override
	public LandLordPayment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLandLordPaymentException {
		LandLordPayment landLordPayment = fetchByPrimaryKey(primaryKey);

		if (landLordPayment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLandLordPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return landLordPayment;
	}

	/**
	 * Returns the land lord payment with the primary key or throws a {@link NoSuchLandLordPaymentException} if it could not be found.
	 *
	 * @param landLordPaymentId the primary key of the land lord payment
	 * @return the land lord payment
	 * @throws NoSuchLandLordPaymentException if a land lord payment with the primary key could not be found
	 */
	@Override
	public LandLordPayment findByPrimaryKey(long landLordPaymentId)
		throws NoSuchLandLordPaymentException {
		return findByPrimaryKey((Serializable)landLordPaymentId);
	}

	/**
	 * Returns the land lord payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the land lord payment
	 * @return the land lord payment, or <code>null</code> if a land lord payment with the primary key could not be found
	 */
	@Override
	public LandLordPayment fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
				LandLordPaymentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LandLordPayment landLordPayment = (LandLordPayment)serializable;

		if (landLordPayment == null) {
			Session session = null;

			try {
				session = openSession();

				landLordPayment = (LandLordPayment)session.get(LandLordPaymentImpl.class,
						primaryKey);

				if (landLordPayment != null) {
					cacheResult(landLordPayment);
				}
				else {
					entityCache.putResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
						LandLordPaymentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
					LandLordPaymentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return landLordPayment;
	}

	/**
	 * Returns the land lord payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param landLordPaymentId the primary key of the land lord payment
	 * @return the land lord payment, or <code>null</code> if a land lord payment with the primary key could not be found
	 */
	@Override
	public LandLordPayment fetchByPrimaryKey(long landLordPaymentId) {
		return fetchByPrimaryKey((Serializable)landLordPaymentId);
	}

	@Override
	public Map<Serializable, LandLordPayment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LandLordPayment> map = new HashMap<Serializable, LandLordPayment>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LandLordPayment landLordPayment = fetchByPrimaryKey(primaryKey);

			if (landLordPayment != null) {
				map.put(primaryKey, landLordPayment);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
					LandLordPaymentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LandLordPayment)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LANDLORDPAYMENT_WHERE_PKS_IN);

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

			for (LandLordPayment landLordPayment : (List<LandLordPayment>)q.list()) {
				map.put(landLordPayment.getPrimaryKeyObj(), landLordPayment);

				cacheResult(landLordPayment);

				uncachedPrimaryKeys.remove(landLordPayment.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LandLordPaymentModelImpl.ENTITY_CACHE_ENABLED,
					LandLordPaymentImpl.class, primaryKey, nullModel);
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
	 * Returns all the land lord payments.
	 *
	 * @return the land lord payments
	 */
	@Override
	public List<LandLordPayment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land lord payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of land lord payments
	 * @param end the upper bound of the range of land lord payments (not inclusive)
	 * @return the range of land lord payments
	 */
	@Override
	public List<LandLordPayment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the land lord payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of land lord payments
	 * @param end the upper bound of the range of land lord payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of land lord payments
	 */
	@Override
	public List<LandLordPayment> findAll(int start, int end,
		OrderByComparator<LandLordPayment> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the land lord payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of land lord payments
	 * @param end the upper bound of the range of land lord payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of land lord payments
	 */
	@Override
	public List<LandLordPayment> findAll(int start, int end,
		OrderByComparator<LandLordPayment> orderByComparator,
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

		List<LandLordPayment> list = null;

		if (retrieveFromCache) {
			list = (List<LandLordPayment>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LANDLORDPAYMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANDLORDPAYMENT;

				if (pagination) {
					sql = sql.concat(LandLordPaymentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LandLordPayment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LandLordPayment>)QueryUtil.list(q,
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
	 * Removes all the land lord payments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LandLordPayment landLordPayment : findAll()) {
			remove(landLordPayment);
		}
	}

	/**
	 * Returns the number of land lord payments.
	 *
	 * @return the number of land lord payments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LANDLORDPAYMENT);

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
		return LandLordPaymentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the land lord payment persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LandLordPaymentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LANDLORDPAYMENT = "SELECT landLordPayment FROM LandLordPayment landLordPayment";
	private static final String _SQL_SELECT_LANDLORDPAYMENT_WHERE_PKS_IN = "SELECT landLordPayment FROM LandLordPayment landLordPayment WHERE landLordPaymentId IN (";
	private static final String _SQL_SELECT_LANDLORDPAYMENT_WHERE = "SELECT landLordPayment FROM LandLordPayment landLordPayment WHERE ";
	private static final String _SQL_COUNT_LANDLORDPAYMENT = "SELECT COUNT(landLordPayment) FROM LandLordPayment landLordPayment";
	private static final String _SQL_COUNT_LANDLORDPAYMENT_WHERE = "SELECT COUNT(landLordPayment) FROM LandLordPayment landLordPayment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "landLordPayment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LandLordPayment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LandLordPayment exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LandLordPaymentPersistenceImpl.class);
}