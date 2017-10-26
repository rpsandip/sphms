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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchBillingException;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.impl.BillingImpl;
import com.sphms.common.service.model.impl.BillingModelImpl;
import com.sphms.common.service.service.persistence.BillingPersistence;

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
 * The persistence implementation for the billing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BillingPersistence
 * @see com.sphms.common.service.service.persistence.BillingUtil
 * @generated
 */
@ProviderType
public class BillingPersistenceImpl extends BasePersistenceImpl<Billing>
	implements BillingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BillingUtil} to access the billing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BillingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, BillingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, BillingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_BOOKINGID = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, BillingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybookingId",
			new String[] { Long.class.getName() },
			BillingModelImpl.BOOKINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BOOKINGID = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybookingId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the billing where bookingId = &#63; or throws a {@link NoSuchBillingException} if it could not be found.
	 *
	 * @param bookingId the booking ID
	 * @return the matching billing
	 * @throws NoSuchBillingException if a matching billing could not be found
	 */
	@Override
	public Billing findBybookingId(long bookingId)
		throws NoSuchBillingException {
		Billing billing = fetchBybookingId(bookingId);

		if (billing == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bookingId=");
			msg.append(bookingId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBillingException(msg.toString());
		}

		return billing;
	}

	/**
	 * Returns the billing where bookingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bookingId the booking ID
	 * @return the matching billing, or <code>null</code> if a matching billing could not be found
	 */
	@Override
	public Billing fetchBybookingId(long bookingId) {
		return fetchBybookingId(bookingId, true);
	}

	/**
	 * Returns the billing where bookingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bookingId the booking ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching billing, or <code>null</code> if a matching billing could not be found
	 */
	@Override
	public Billing fetchBybookingId(long bookingId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { bookingId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_BOOKINGID,
					finderArgs, this);
		}

		if (result instanceof Billing) {
			Billing billing = (Billing)result;

			if ((bookingId != billing.getBookingId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BILLING_WHERE);

			query.append(_FINDER_COLUMN_BOOKINGID_BOOKINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bookingId);

				List<Billing> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKINGID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BillingPersistenceImpl.fetchBybookingId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Billing billing = list.get(0);

					result = billing;

					cacheResult(billing);

					if ((billing.getBookingId() != bookingId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKINGID,
							finderArgs, billing);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKINGID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Billing)result;
		}
	}

	/**
	 * Removes the billing where bookingId = &#63; from the database.
	 *
	 * @param bookingId the booking ID
	 * @return the billing that was removed
	 */
	@Override
	public Billing removeBybookingId(long bookingId)
		throws NoSuchBillingException {
		Billing billing = findBybookingId(bookingId);

		return remove(billing);
	}

	/**
	 * Returns the number of billings where bookingId = &#63;.
	 *
	 * @param bookingId the booking ID
	 * @return the number of matching billings
	 */
	@Override
	public int countBybookingId(long bookingId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BOOKINGID;

		Object[] finderArgs = new Object[] { bookingId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BILLING_WHERE);

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

	private static final String _FINDER_COLUMN_BOOKINGID_BOOKINGID_2 = "billing.bookingId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, BillingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByclientId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID =
		new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, BillingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByclientId",
			new String[] { Long.class.getName() },
			BillingModelImpl.CLIENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTID = new FinderPath(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByclientId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the billings where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching billings
	 */
	@Override
	public List<Billing> findByclientId(long clientId) {
		return findByclientId(clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the billings where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @return the range of matching billings
	 */
	@Override
	public List<Billing> findByclientId(long clientId, int start, int end) {
		return findByclientId(clientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the billings where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching billings
	 */
	@Override
	public List<Billing> findByclientId(long clientId, int start, int end,
		OrderByComparator<Billing> orderByComparator) {
		return findByclientId(clientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billings where clientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clientId the client ID
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching billings
	 */
	@Override
	public List<Billing> findByclientId(long clientId, int start, int end,
		OrderByComparator<Billing> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID;
			finderArgs = new Object[] { clientId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID;
			finderArgs = new Object[] { clientId, start, end, orderByComparator };
		}

		List<Billing> list = null;

		if (retrieveFromCache) {
			list = (List<Billing>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Billing billing : list) {
					if ((clientId != billing.getClientId())) {
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

			query.append(_SQL_SELECT_BILLING_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BillingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

				if (!pagination) {
					list = (List<Billing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Billing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first billing in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billing
	 * @throws NoSuchBillingException if a matching billing could not be found
	 */
	@Override
	public Billing findByclientId_First(long clientId,
		OrderByComparator<Billing> orderByComparator)
		throws NoSuchBillingException {
		Billing billing = fetchByclientId_First(clientId, orderByComparator);

		if (billing != null) {
			return billing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBillingException(msg.toString());
	}

	/**
	 * Returns the first billing in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billing, or <code>null</code> if a matching billing could not be found
	 */
	@Override
	public Billing fetchByclientId_First(long clientId,
		OrderByComparator<Billing> orderByComparator) {
		List<Billing> list = findByclientId(clientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last billing in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billing
	 * @throws NoSuchBillingException if a matching billing could not be found
	 */
	@Override
	public Billing findByclientId_Last(long clientId,
		OrderByComparator<Billing> orderByComparator)
		throws NoSuchBillingException {
		Billing billing = fetchByclientId_Last(clientId, orderByComparator);

		if (billing != null) {
			return billing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBillingException(msg.toString());
	}

	/**
	 * Returns the last billing in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billing, or <code>null</code> if a matching billing could not be found
	 */
	@Override
	public Billing fetchByclientId_Last(long clientId,
		OrderByComparator<Billing> orderByComparator) {
		int count = countByclientId(clientId);

		if (count == 0) {
			return null;
		}

		List<Billing> list = findByclientId(clientId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the billings before and after the current billing in the ordered set where clientId = &#63;.
	 *
	 * @param billingId the primary key of the current billing
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next billing
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing[] findByclientId_PrevAndNext(long billingId, long clientId,
		OrderByComparator<Billing> orderByComparator)
		throws NoSuchBillingException {
		Billing billing = findByPrimaryKey(billingId);

		Session session = null;

		try {
			session = openSession();

			Billing[] array = new BillingImpl[3];

			array[0] = getByclientId_PrevAndNext(session, billing, clientId,
					orderByComparator, true);

			array[1] = billing;

			array[2] = getByclientId_PrevAndNext(session, billing, clientId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Billing getByclientId_PrevAndNext(Session session,
		Billing billing, long clientId,
		OrderByComparator<Billing> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BILLING_WHERE);

		query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

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
			query.append(BillingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clientId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(billing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Billing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the billings where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	@Override
	public void removeByclientId(long clientId) {
		for (Billing billing : findByclientId(clientId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(billing);
		}
	}

	/**
	 * Returns the number of billings where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching billings
	 */
	@Override
	public int countByclientId(long clientId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTID;

		Object[] finderArgs = new Object[] { clientId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BILLING_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

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

	private static final String _FINDER_COLUMN_CLIENTID_CLIENTID_2 = "billing.clientId = ?";

	public BillingPersistenceImpl() {
		setModelClass(Billing.class);
	}

	/**
	 * Caches the billing in the entity cache if it is enabled.
	 *
	 * @param billing the billing
	 */
	@Override
	public void cacheResult(Billing billing) {
		entityCache.putResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingImpl.class, billing.getPrimaryKey(), billing);

		finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKINGID,
			new Object[] { billing.getBookingId() }, billing);

		billing.resetOriginalValues();
	}

	/**
	 * Caches the billings in the entity cache if it is enabled.
	 *
	 * @param billings the billings
	 */
	@Override
	public void cacheResult(List<Billing> billings) {
		for (Billing billing : billings) {
			if (entityCache.getResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
						BillingImpl.class, billing.getPrimaryKey()) == null) {
				cacheResult(billing);
			}
			else {
				billing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all billings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BillingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the billing.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Billing billing) {
		entityCache.removeResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingImpl.class, billing.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BillingModelImpl)billing);
	}

	@Override
	public void clearCache(List<Billing> billings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Billing billing : billings) {
			entityCache.removeResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
				BillingImpl.class, billing.getPrimaryKey());

			clearUniqueFindersCache((BillingModelImpl)billing);
		}
	}

	protected void cacheUniqueFindersCache(BillingModelImpl billingModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { billingModelImpl.getBookingId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_BOOKINGID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKINGID, args,
				billingModelImpl);
		}
		else {
			if ((billingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BOOKINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { billingModelImpl.getBookingId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_BOOKINGID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_BOOKINGID, args,
					billingModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(BillingModelImpl billingModelImpl) {
		Object[] args = new Object[] { billingModelImpl.getBookingId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKINGID, args);

		if ((billingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BOOKINGID.getColumnBitmask()) != 0) {
			args = new Object[] { billingModelImpl.getOriginalBookingId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BOOKINGID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BOOKINGID, args);
		}
	}

	/**
	 * Creates a new billing with the primary key. Does not add the billing to the database.
	 *
	 * @param billingId the primary key for the new billing
	 * @return the new billing
	 */
	@Override
	public Billing create(long billingId) {
		Billing billing = new BillingImpl();

		billing.setNew(true);
		billing.setPrimaryKey(billingId);

		return billing;
	}

	/**
	 * Removes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param billingId the primary key of the billing
	 * @return the billing that was removed
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing remove(long billingId) throws NoSuchBillingException {
		return remove((Serializable)billingId);
	}

	/**
	 * Removes the billing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the billing
	 * @return the billing that was removed
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing remove(Serializable primaryKey)
		throws NoSuchBillingException {
		Session session = null;

		try {
			session = openSession();

			Billing billing = (Billing)session.get(BillingImpl.class, primaryKey);

			if (billing == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBillingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(billing);
		}
		catch (NoSuchBillingException nsee) {
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
	protected Billing removeImpl(Billing billing) {
		billing = toUnwrappedModel(billing);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(billing)) {
				billing = (Billing)session.get(BillingImpl.class,
						billing.getPrimaryKeyObj());
			}

			if (billing != null) {
				session.delete(billing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (billing != null) {
			clearCache(billing);
		}

		return billing;
	}

	@Override
	public Billing updateImpl(Billing billing) {
		billing = toUnwrappedModel(billing);

		boolean isNew = billing.isNew();

		BillingModelImpl billingModelImpl = (BillingModelImpl)billing;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (billing.getCreateDate() == null)) {
			if (serviceContext == null) {
				billing.setCreateDate(now);
			}
			else {
				billing.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!billingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				billing.setModifiedDate(now);
			}
			else {
				billing.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (billing.isNew()) {
				session.save(billing);

				billing.setNew(false);
			}
			else {
				billing = (Billing)session.merge(billing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BillingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((billingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						billingModelImpl.getOriginalClientId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID,
					args);

				args = new Object[] { billingModelImpl.getClientId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CLIENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID,
					args);
			}
		}

		entityCache.putResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
			BillingImpl.class, billing.getPrimaryKey(), billing, false);

		clearUniqueFindersCache(billingModelImpl);
		cacheUniqueFindersCache(billingModelImpl, isNew);

		billing.resetOriginalValues();

		return billing;
	}

	protected Billing toUnwrappedModel(Billing billing) {
		if (billing instanceof BillingImpl) {
			return billing;
		}

		BillingImpl billingImpl = new BillingImpl();

		billingImpl.setNew(billing.isNew());
		billingImpl.setPrimaryKey(billing.getPrimaryKey());

		billingImpl.setBillingId(billing.getBillingId());
		billingImpl.setCustomCompanyId(billing.getCustomCompanyId());
		billingImpl.setBillNo(billing.getBillNo());
		billingImpl.setBookingId(billing.getBookingId());
		billingImpl.setClientId(billing.getClientId());
		billingImpl.setBillFileEntryId(billing.getBillFileEntryId());
		billingImpl.setClientPANNo(billing.getClientPANNo());
		billingImpl.setClientPONumber(billing.getClientPONumber());
		billingImpl.setClientGSTNumber(billing.getClientGSTNumber());
		billingImpl.setDisplay(billing.getDisplay());
		billingImpl.setAccessAmount(billing.getAccessAmount());
		billingImpl.setPendingAmount(billing.getPendingAmount());
		billingImpl.setFinancialYear(billing.getFinancialYear());
		billingImpl.setStatus(billing.getStatus());
		billingImpl.setCreateDate(billing.getCreateDate());
		billingImpl.setCreatedBy(billing.getCreatedBy());
		billingImpl.setModifiedDate(billing.getModifiedDate());
		billingImpl.setModifiedBy(billing.getModifiedBy());

		return billingImpl;
	}

	/**
	 * Returns the billing with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing
	 * @return the billing
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBillingException {
		Billing billing = fetchByPrimaryKey(primaryKey);

		if (billing == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBillingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return billing;
	}

	/**
	 * Returns the billing with the primary key or throws a {@link NoSuchBillingException} if it could not be found.
	 *
	 * @param billingId the primary key of the billing
	 * @return the billing
	 * @throws NoSuchBillingException if a billing with the primary key could not be found
	 */
	@Override
	public Billing findByPrimaryKey(long billingId)
		throws NoSuchBillingException {
		return findByPrimaryKey((Serializable)billingId);
	}

	/**
	 * Returns the billing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing
	 * @return the billing, or <code>null</code> if a billing with the primary key could not be found
	 */
	@Override
	public Billing fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
				BillingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Billing billing = (Billing)serializable;

		if (billing == null) {
			Session session = null;

			try {
				session = openSession();

				billing = (Billing)session.get(BillingImpl.class, primaryKey);

				if (billing != null) {
					cacheResult(billing);
				}
				else {
					entityCache.putResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
						BillingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
					BillingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return billing;
	}

	/**
	 * Returns the billing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param billingId the primary key of the billing
	 * @return the billing, or <code>null</code> if a billing with the primary key could not be found
	 */
	@Override
	public Billing fetchByPrimaryKey(long billingId) {
		return fetchByPrimaryKey((Serializable)billingId);
	}

	@Override
	public Map<Serializable, Billing> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Billing> map = new HashMap<Serializable, Billing>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Billing billing = fetchByPrimaryKey(primaryKey);

			if (billing != null) {
				map.put(primaryKey, billing);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
					BillingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Billing)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BILLING_WHERE_PKS_IN);

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

			for (Billing billing : (List<Billing>)q.list()) {
				map.put(billing.getPrimaryKeyObj(), billing);

				cacheResult(billing);

				uncachedPrimaryKeys.remove(billing.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BillingModelImpl.ENTITY_CACHE_ENABLED,
					BillingImpl.class, primaryKey, nullModel);
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
	 * Returns all the billings.
	 *
	 * @return the billings
	 */
	@Override
	public List<Billing> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the billings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @return the range of billings
	 */
	@Override
	public List<Billing> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the billings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of billings
	 */
	@Override
	public List<Billing> findAll(int start, int end,
		OrderByComparator<Billing> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BillingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billings
	 * @param end the upper bound of the range of billings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of billings
	 */
	@Override
	public List<Billing> findAll(int start, int end,
		OrderByComparator<Billing> orderByComparator, boolean retrieveFromCache) {
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

		List<Billing> list = null;

		if (retrieveFromCache) {
			list = (List<Billing>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BILLING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BILLING;

				if (pagination) {
					sql = sql.concat(BillingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Billing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Billing>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the billings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Billing billing : findAll()) {
			remove(billing);
		}
	}

	/**
	 * Returns the number of billings.
	 *
	 * @return the number of billings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BILLING);

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
		return BillingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the billing persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BillingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BILLING = "SELECT billing FROM Billing billing";
	private static final String _SQL_SELECT_BILLING_WHERE_PKS_IN = "SELECT billing FROM Billing billing WHERE billingId IN (";
	private static final String _SQL_SELECT_BILLING_WHERE = "SELECT billing FROM Billing billing WHERE ";
	private static final String _SQL_COUNT_BILLING = "SELECT COUNT(billing) FROM Billing billing";
	private static final String _SQL_COUNT_BILLING_WHERE = "SELECT COUNT(billing) FROM Billing billing WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "billing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Billing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Billing exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BillingPersistenceImpl.class);
}