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

import com.sphms.common.service.exception.NoSuchBooking_HordingException;
import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.model.impl.Booking_HordingImpl;
import com.sphms.common.service.model.impl.Booking_HordingModelImpl;
import com.sphms.common.service.service.persistence.Booking_HordingPK;
import com.sphms.common.service.service.persistence.Booking_HordingPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the booking_ hording service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Booking_HordingPersistence
 * @see com.sphms.common.service.service.persistence.Booking_HordingUtil
 * @generated
 */
@ProviderType
public class Booking_HordingPersistenceImpl extends BasePersistenceImpl<Booking_Hording>
	implements Booking_HordingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Booking_HordingUtil} to access the booking_ hording persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Booking_HordingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingModelImpl.FINDER_CACHE_ENABLED,
			Booking_HordingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingModelImpl.FINDER_CACHE_ENABLED,
			Booking_HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKINGID =
		new FinderPath(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingModelImpl.FINDER_CACHE_ENABLED,
			Booking_HordingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybookingId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID =
		new FinderPath(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingModelImpl.FINDER_CACHE_ENABLED,
			Booking_HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybookingId",
			new String[] { Long.class.getName() },
			Booking_HordingModelImpl.BOOKINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKINGID = new FinderPath(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookingId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the booking_ hordings where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the matching booking_ hordings
	 */
	@Override
	public List<Booking_Hording> findBybookingId(long bookingId) {
		return findBybookingId(bookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the booking_ hordings where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking_ hordings
	 * @param end the upper bound of the range of booking_ hordings (not inclusive)
	 * @return the range of matching booking_ hordings
	 */
	@Override
	public List<Booking_Hording> findBybookingId(long bookingId, int start,
		int end) {
		return findBybookingId(bookingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking_ hordings where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking_ hordings
	 * @param end the upper bound of the range of booking_ hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking_ hordings
	 */
	@Override
	public List<Booking_Hording> findBybookingId(long bookingId, int start,
		int end, OrderByComparator<Booking_Hording> orderByComparator) {
		return findBybookingId(bookingId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking_ hordings where bookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bookingId the booking ID
	 * @param start the lower bound of the range of booking_ hordings
	 * @param end the upper bound of the range of booking_ hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching booking_ hordings
	 */
	@Override
	public List<Booking_Hording> findBybookingId(long bookingId, int start,
		int end, OrderByComparator<Booking_Hording> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID;
			finderArgs = new Object[] { bookingId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BOOKINGID;
			finderArgs = new Object[] { bookingId, start, end, orderByComparator };
		}

		List<Booking_Hording> list = null;

		if (retrieveFromCache) {
			list = (List<Booking_Hording>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Booking_Hording booking_Hording : list) {
					if ((bookingId != booking_Hording.getBookingId())) {
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

			query.append(_SQL_SELECT_BOOKING_HORDING_WHERE);

			query.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Booking_HordingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookingId);

				if (!pagination) {
					list = (List<Booking_Hording>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Booking_Hording>)QueryUtil.list(q,
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
	 * Returns the first booking_ hording in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking_ hording
	 * @throws NoSuchBooking_HordingException if a matching booking_ hording could not be found
	 */
	@Override
	public Booking_Hording findBybookingId_First(long bookingId,
		OrderByComparator<Booking_Hording> orderByComparator)
		throws NoSuchBooking_HordingException {
		Booking_Hording booking_Hording = fetchBybookingId_First(bookingId,
				orderByComparator);

		if (booking_Hording != null) {
			return booking_Hording;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingId=");
		msg.append(bookingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBooking_HordingException(msg.toString());
	}

	/**
	 * Returns the first booking_ hording in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking_ hording, or <code>null</code> if a matching booking_ hording could not be found
	 */
	@Override
	public Booking_Hording fetchBybookingId_First(long bookingId,
		OrderByComparator<Booking_Hording> orderByComparator) {
		List<Booking_Hording> list = findBybookingId(bookingId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking_ hording in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking_ hording
	 * @throws NoSuchBooking_HordingException if a matching booking_ hording could not be found
	 */
	@Override
	public Booking_Hording findBybookingId_Last(long bookingId,
		OrderByComparator<Booking_Hording> orderByComparator)
		throws NoSuchBooking_HordingException {
		Booking_Hording booking_Hording = fetchBybookingId_Last(bookingId,
				orderByComparator);

		if (booking_Hording != null) {
			return booking_Hording;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bookingId=");
		msg.append(bookingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBooking_HordingException(msg.toString());
	}

	/**
	 * Returns the last booking_ hording in the ordered set where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking_ hording, or <code>null</code> if a matching booking_ hording could not be found
	 */
	@Override
	public Booking_Hording fetchBybookingId_Last(long bookingId,
		OrderByComparator<Booking_Hording> orderByComparator) {
		int count = countBybookingId(bookingId);

		if (count == 0) {
			return null;
		}

		List<Booking_Hording> list = findBybookingId(bookingId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking_ hordings before and after the current booking_ hording in the ordered set where bookingId = &#63;.
	 *
	 * @param booking_HordingPK the primary key of the current booking_ hording
	 * @param bookingId the booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking_ hording
	 * @throws NoSuchBooking_HordingException if a booking_ hording with the primary key could not be found
	 */
	@Override
	public Booking_Hording[] findBybookingId_PrevAndNext(
		Booking_HordingPK booking_HordingPK, long bookingId,
		OrderByComparator<Booking_Hording> orderByComparator)
		throws NoSuchBooking_HordingException {
		Booking_Hording booking_Hording = findByPrimaryKey(booking_HordingPK);

		Session session = null;

		try {
			session = openSession();

			Booking_Hording[] array = new Booking_HordingImpl[3];

			array[0] = getBybookingId_PrevAndNext(session, booking_Hording,
					bookingId, orderByComparator, true);

			array[1] = booking_Hording;

			array[2] = getBybookingId_PrevAndNext(session, booking_Hording,
					bookingId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Booking_Hording getBybookingId_PrevAndNext(Session session,
		Booking_Hording booking_Hording, long bookingId,
		OrderByComparator<Booking_Hording> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKING_HORDING_WHERE);

		query.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

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
			query.append(Booking_HordingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(bookingId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(booking_Hording);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Booking_Hording> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking_ hordings where bookingId = &#63; from the database.
	 *
	 * @param bookingId the booking ID
	 */
	@Override
	public void removeBybookingId(long bookingId) {
		for (Booking_Hording booking_Hording : findBybookingId(bookingId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(booking_Hording);
		}
	}

	/**
	 * Returns the number of booking_ hordings where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the number of matching booking_ hordings
	 */
	@Override
	public int countBybookingId(long bookingId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKINGID;

		Object[] finderArgs = new Object[] { bookingId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKING_HORDING_WHERE);

			query.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookingId);

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

	private static final String _FINDER_COLUMN_BOOKINGID_BOOKINGID_2 = "booking_Hording.id.bookingId = ?";

	public Booking_HordingPersistenceImpl() {
		setModelClass(Booking_Hording.class);
	}

	/**
	 * Caches the booking_ hording in the entity cache if it is enabled.
	 *
	 * @param booking_Hording the booking_ hording
	 */
	@Override
	public void cacheResult(Booking_Hording booking_Hording) {
		entityCache.putResult(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingImpl.class, booking_Hording.getPrimaryKey(),
			booking_Hording);

		booking_Hording.resetOriginalValues();
	}

	/**
	 * Caches the booking_ hordings in the entity cache if it is enabled.
	 *
	 * @param booking_Hordings the booking_ hordings
	 */
	@Override
	public void cacheResult(List<Booking_Hording> booking_Hordings) {
		for (Booking_Hording booking_Hording : booking_Hordings) {
			if (entityCache.getResult(
						Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
						Booking_HordingImpl.class,
						booking_Hording.getPrimaryKey()) == null) {
				cacheResult(booking_Hording);
			}
			else {
				booking_Hording.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all booking_ hordings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Booking_HordingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the booking_ hording.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Booking_Hording booking_Hording) {
		entityCache.removeResult(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingImpl.class, booking_Hording.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Booking_Hording> booking_Hordings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Booking_Hording booking_Hording : booking_Hordings) {
			entityCache.removeResult(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
				Booking_HordingImpl.class, booking_Hording.getPrimaryKey());
		}
	}

	/**
	 * Creates a new booking_ hording with the primary key. Does not add the booking_ hording to the database.
	 *
	 * @param booking_HordingPK the primary key for the new booking_ hording
	 * @return the new booking_ hording
	 */
	@Override
	public Booking_Hording create(Booking_HordingPK booking_HordingPK) {
		Booking_Hording booking_Hording = new Booking_HordingImpl();

		booking_Hording.setNew(true);
		booking_Hording.setPrimaryKey(booking_HordingPK);

		return booking_Hording;
	}

	/**
	 * Removes the booking_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param booking_HordingPK the primary key of the booking_ hording
	 * @return the booking_ hording that was removed
	 * @throws NoSuchBooking_HordingException if a booking_ hording with the primary key could not be found
	 */
	@Override
	public Booking_Hording remove(Booking_HordingPK booking_HordingPK)
		throws NoSuchBooking_HordingException {
		return remove((Serializable)booking_HordingPK);
	}

	/**
	 * Removes the booking_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking_ hording
	 * @return the booking_ hording that was removed
	 * @throws NoSuchBooking_HordingException if a booking_ hording with the primary key could not be found
	 */
	@Override
	public Booking_Hording remove(Serializable primaryKey)
		throws NoSuchBooking_HordingException {
		Session session = null;

		try {
			session = openSession();

			Booking_Hording booking_Hording = (Booking_Hording)session.get(Booking_HordingImpl.class,
					primaryKey);

			if (booking_Hording == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBooking_HordingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(booking_Hording);
		}
		catch (NoSuchBooking_HordingException nsee) {
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
	protected Booking_Hording removeImpl(Booking_Hording booking_Hording) {
		booking_Hording = toUnwrappedModel(booking_Hording);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(booking_Hording)) {
				booking_Hording = (Booking_Hording)session.get(Booking_HordingImpl.class,
						booking_Hording.getPrimaryKeyObj());
			}

			if (booking_Hording != null) {
				session.delete(booking_Hording);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (booking_Hording != null) {
			clearCache(booking_Hording);
		}

		return booking_Hording;
	}

	@Override
	public Booking_Hording updateImpl(Booking_Hording booking_Hording) {
		booking_Hording = toUnwrappedModel(booking_Hording);

		boolean isNew = booking_Hording.isNew();

		Booking_HordingModelImpl booking_HordingModelImpl = (Booking_HordingModelImpl)booking_Hording;

		Session session = null;

		try {
			session = openSession();

			if (booking_Hording.isNew()) {
				session.save(booking_Hording);

				booking_Hording.setNew(false);
			}
			else {
				booking_Hording = (Booking_Hording)session.merge(booking_Hording);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Booking_HordingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((booking_HordingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						booking_HordingModelImpl.getOriginalBookingId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID,
					args);

				args = new Object[] { booking_HordingModelImpl.getBookingId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BOOKINGID,
					args);
			}
		}

		entityCache.putResult(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Booking_HordingImpl.class, booking_Hording.getPrimaryKey(),
			booking_Hording, false);

		booking_Hording.resetOriginalValues();

		return booking_Hording;
	}

	protected Booking_Hording toUnwrappedModel(Booking_Hording booking_Hording) {
		if (booking_Hording instanceof Booking_HordingImpl) {
			return booking_Hording;
		}

		Booking_HordingImpl booking_HordingImpl = new Booking_HordingImpl();

		booking_HordingImpl.setNew(booking_Hording.isNew());
		booking_HordingImpl.setPrimaryKey(booking_Hording.getPrimaryKey());

		booking_HordingImpl.setBookingId(booking_Hording.getBookingId());
		booking_HordingImpl.setHordingId(booking_Hording.getHordingId());
		booking_HordingImpl.setMountingCharge(booking_Hording.getMountingCharge());
		booking_HordingImpl.setPrintingCharge(booking_Hording.getPrintingCharge());
		booking_HordingImpl.setUnits(booking_Hording.getUnits());

		return booking_HordingImpl;
	}

	/**
	 * Returns the booking_ hording with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking_ hording
	 * @return the booking_ hording
	 * @throws NoSuchBooking_HordingException if a booking_ hording with the primary key could not be found
	 */
	@Override
	public Booking_Hording findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBooking_HordingException {
		Booking_Hording booking_Hording = fetchByPrimaryKey(primaryKey);

		if (booking_Hording == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBooking_HordingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return booking_Hording;
	}

	/**
	 * Returns the booking_ hording with the primary key or throws a {@link NoSuchBooking_HordingException} if it could not be found.
	 *
	 * @param booking_HordingPK the primary key of the booking_ hording
	 * @return the booking_ hording
	 * @throws NoSuchBooking_HordingException if a booking_ hording with the primary key could not be found
	 */
	@Override
	public Booking_Hording findByPrimaryKey(Booking_HordingPK booking_HordingPK)
		throws NoSuchBooking_HordingException {
		return findByPrimaryKey((Serializable)booking_HordingPK);
	}

	/**
	 * Returns the booking_ hording with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking_ hording
	 * @return the booking_ hording, or <code>null</code> if a booking_ hording with the primary key could not be found
	 */
	@Override
	public Booking_Hording fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
				Booking_HordingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Booking_Hording booking_Hording = (Booking_Hording)serializable;

		if (booking_Hording == null) {
			Session session = null;

			try {
				session = openSession();

				booking_Hording = (Booking_Hording)session.get(Booking_HordingImpl.class,
						primaryKey);

				if (booking_Hording != null) {
					cacheResult(booking_Hording);
				}
				else {
					entityCache.putResult(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
						Booking_HordingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Booking_HordingModelImpl.ENTITY_CACHE_ENABLED,
					Booking_HordingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return booking_Hording;
	}

	/**
	 * Returns the booking_ hording with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param booking_HordingPK the primary key of the booking_ hording
	 * @return the booking_ hording, or <code>null</code> if a booking_ hording with the primary key could not be found
	 */
	@Override
	public Booking_Hording fetchByPrimaryKey(
		Booking_HordingPK booking_HordingPK) {
		return fetchByPrimaryKey((Serializable)booking_HordingPK);
	}

	@Override
	public Map<Serializable, Booking_Hording> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Booking_Hording> map = new HashMap<Serializable, Booking_Hording>();

		for (Serializable primaryKey : primaryKeys) {
			Booking_Hording booking_Hording = fetchByPrimaryKey(primaryKey);

			if (booking_Hording != null) {
				map.put(primaryKey, booking_Hording);
			}
		}

		return map;
	}

	/**
	 * Returns all the booking_ hordings.
	 *
	 * @return the booking_ hordings
	 */
	@Override
	public List<Booking_Hording> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking_ hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking_ hordings
	 * @param end the upper bound of the range of booking_ hordings (not inclusive)
	 * @return the range of booking_ hordings
	 */
	@Override
	public List<Booking_Hording> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking_ hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking_ hordings
	 * @param end the upper bound of the range of booking_ hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking_ hordings
	 */
	@Override
	public List<Booking_Hording> findAll(int start, int end,
		OrderByComparator<Booking_Hording> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking_ hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Booking_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking_ hordings
	 * @param end the upper bound of the range of booking_ hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of booking_ hordings
	 */
	@Override
	public List<Booking_Hording> findAll(int start, int end,
		OrderByComparator<Booking_Hording> orderByComparator,
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

		List<Booking_Hording> list = null;

		if (retrieveFromCache) {
			list = (List<Booking_Hording>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BOOKING_HORDING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKING_HORDING;

				if (pagination) {
					sql = sql.concat(Booking_HordingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Booking_Hording>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Booking_Hording>)QueryUtil.list(q,
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
	 * Removes all the booking_ hordings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Booking_Hording booking_Hording : findAll()) {
			remove(booking_Hording);
		}
	}

	/**
	 * Returns the number of booking_ hordings.
	 *
	 * @return the number of booking_ hordings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKING_HORDING);

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
		return Booking_HordingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the booking_ hording persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Booking_HordingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BOOKING_HORDING = "SELECT booking_Hording FROM Booking_Hording booking_Hording";
	private static final String _SQL_SELECT_BOOKING_HORDING_WHERE = "SELECT booking_Hording FROM Booking_Hording booking_Hording WHERE ";
	private static final String _SQL_COUNT_BOOKING_HORDING = "SELECT COUNT(booking_Hording) FROM Booking_Hording booking_Hording";
	private static final String _SQL_COUNT_BOOKING_HORDING_WHERE = "SELECT COUNT(booking_Hording) FROM Booking_Hording booking_Hording WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "booking_Hording.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Booking_Hording exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Booking_Hording exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Booking_HordingPersistenceImpl.class);
}