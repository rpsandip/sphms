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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchBilling_HordingException;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.impl.Billing_HordingImpl;
import com.sphms.common.service.model.impl.Billing_HordingModelImpl;
import com.sphms.common.service.service.persistence.Billing_HordingPK;
import com.sphms.common.service.service.persistence.Billing_HordingPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the billing_ hording service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_HordingPersistence
 * @see com.sphms.common.service.service.persistence.Billing_HordingUtil
 * @generated
 */
@ProviderType
public class Billing_HordingPersistenceImpl extends BasePersistenceImpl<Billing_Hording>
	implements Billing_HordingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Billing_HordingUtil} to access the billing_ hording persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Billing_HordingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingModelImpl.FINDER_CACHE_ENABLED,
			Billing_HordingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingModelImpl.FINDER_CACHE_ENABLED,
			Billing_HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BILLINGID =
		new FinderPath(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingModelImpl.FINDER_CACHE_ENABLED,
			Billing_HordingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybillingId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID =
		new FinderPath(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingModelImpl.FINDER_CACHE_ENABLED,
			Billing_HordingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybillingId",
			new String[] { Long.class.getName() },
			Billing_HordingModelImpl.BILLINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BILLINGID = new FinderPath(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybillingId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the billing_ hordings where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @return the matching billing_ hordings
	 */
	@Override
	public List<Billing_Hording> findBybillingId(long billingId) {
		return findBybillingId(billingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the billing_ hordings where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of billing_ hordings
	 * @param end the upper bound of the range of billing_ hordings (not inclusive)
	 * @return the range of matching billing_ hordings
	 */
	@Override
	public List<Billing_Hording> findBybillingId(long billingId, int start,
		int end) {
		return findBybillingId(billingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the billing_ hordings where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of billing_ hordings
	 * @param end the upper bound of the range of billing_ hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching billing_ hordings
	 */
	@Override
	public List<Billing_Hording> findBybillingId(long billingId, int start,
		int end, OrderByComparator<Billing_Hording> orderByComparator) {
		return findBybillingId(billingId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billing_ hordings where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of billing_ hordings
	 * @param end the upper bound of the range of billing_ hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching billing_ hordings
	 */
	@Override
	public List<Billing_Hording> findBybillingId(long billingId, int start,
		int end, OrderByComparator<Billing_Hording> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID;
			finderArgs = new Object[] { billingId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BILLINGID;
			finderArgs = new Object[] { billingId, start, end, orderByComparator };
		}

		List<Billing_Hording> list = null;

		if (retrieveFromCache) {
			list = (List<Billing_Hording>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Billing_Hording billing_Hording : list) {
					if ((billingId != billing_Hording.getBillingId())) {
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

			query.append(_SQL_SELECT_BILLING_HORDING_WHERE);

			query.append(_FINDER_COLUMN_BILLINGID_BILLINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Billing_HordingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(billingId);

				if (!pagination) {
					list = (List<Billing_Hording>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Billing_Hording>)QueryUtil.list(q,
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
	 * Returns the first billing_ hording in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billing_ hording
	 * @throws NoSuchBilling_HordingException if a matching billing_ hording could not be found
	 */
	@Override
	public Billing_Hording findBybillingId_First(long billingId,
		OrderByComparator<Billing_Hording> orderByComparator)
		throws NoSuchBilling_HordingException {
		Billing_Hording billing_Hording = fetchBybillingId_First(billingId,
				orderByComparator);

		if (billing_Hording != null) {
			return billing_Hording;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBilling_HordingException(msg.toString());
	}

	/**
	 * Returns the first billing_ hording in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billing_ hording, or <code>null</code> if a matching billing_ hording could not be found
	 */
	@Override
	public Billing_Hording fetchBybillingId_First(long billingId,
		OrderByComparator<Billing_Hording> orderByComparator) {
		List<Billing_Hording> list = findBybillingId(billingId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last billing_ hording in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billing_ hording
	 * @throws NoSuchBilling_HordingException if a matching billing_ hording could not be found
	 */
	@Override
	public Billing_Hording findBybillingId_Last(long billingId,
		OrderByComparator<Billing_Hording> orderByComparator)
		throws NoSuchBilling_HordingException {
		Billing_Hording billing_Hording = fetchBybillingId_Last(billingId,
				orderByComparator);

		if (billing_Hording != null) {
			return billing_Hording;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBilling_HordingException(msg.toString());
	}

	/**
	 * Returns the last billing_ hording in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billing_ hording, or <code>null</code> if a matching billing_ hording could not be found
	 */
	@Override
	public Billing_Hording fetchBybillingId_Last(long billingId,
		OrderByComparator<Billing_Hording> orderByComparator) {
		int count = countBybillingId(billingId);

		if (count == 0) {
			return null;
		}

		List<Billing_Hording> list = findBybillingId(billingId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the billing_ hordings before and after the current billing_ hording in the ordered set where billingId = &#63;.
	 *
	 * @param billing_HordingPK the primary key of the current billing_ hording
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next billing_ hording
	 * @throws NoSuchBilling_HordingException if a billing_ hording with the primary key could not be found
	 */
	@Override
	public Billing_Hording[] findBybillingId_PrevAndNext(
		Billing_HordingPK billing_HordingPK, long billingId,
		OrderByComparator<Billing_Hording> orderByComparator)
		throws NoSuchBilling_HordingException {
		Billing_Hording billing_Hording = findByPrimaryKey(billing_HordingPK);

		Session session = null;

		try {
			session = openSession();

			Billing_Hording[] array = new Billing_HordingImpl[3];

			array[0] = getBybillingId_PrevAndNext(session, billing_Hording,
					billingId, orderByComparator, true);

			array[1] = billing_Hording;

			array[2] = getBybillingId_PrevAndNext(session, billing_Hording,
					billingId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Billing_Hording getBybillingId_PrevAndNext(Session session,
		Billing_Hording billing_Hording, long billingId,
		OrderByComparator<Billing_Hording> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BILLING_HORDING_WHERE);

		query.append(_FINDER_COLUMN_BILLINGID_BILLINGID_2);

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
			query.append(Billing_HordingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(billingId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(billing_Hording);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Billing_Hording> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the billing_ hordings where billingId = &#63; from the database.
	 *
	 * @param billingId the billing ID
	 */
	@Override
	public void removeBybillingId(long billingId) {
		for (Billing_Hording billing_Hording : findBybillingId(billingId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(billing_Hording);
		}
	}

	/**
	 * Returns the number of billing_ hordings where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @return the number of matching billing_ hordings
	 */
	@Override
	public int countBybillingId(long billingId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BILLINGID;

		Object[] finderArgs = new Object[] { billingId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BILLING_HORDING_WHERE);

			query.append(_FINDER_COLUMN_BILLINGID_BILLINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(billingId);

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

	private static final String _FINDER_COLUMN_BILLINGID_BILLINGID_2 = "billing_Hording.id.billingId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID = new FinderPath(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingModelImpl.FINDER_CACHE_ENABLED,
			Billing_HordingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBybillingIdAndHordingId",
			new String[] { Long.class.getName(), Long.class.getName() },
			Billing_HordingModelImpl.BILLINGID_COLUMN_BITMASK |
			Billing_HordingModelImpl.HORDINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BILLINGIDANDHORDINGID = new FinderPath(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybillingIdAndHordingId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the billing_ hording where billingId = &#63; and hordingId = &#63; or throws a {@link NoSuchBilling_HordingException} if it could not be found.
	 *
	 * @param billingId the billing ID
	 * @param hordingId the hording ID
	 * @return the matching billing_ hording
	 * @throws NoSuchBilling_HordingException if a matching billing_ hording could not be found
	 */
	@Override
	public Billing_Hording findBybillingIdAndHordingId(long billingId,
		long hordingId) throws NoSuchBilling_HordingException {
		Billing_Hording billing_Hording = fetchBybillingIdAndHordingId(billingId,
				hordingId);

		if (billing_Hording == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("billingId=");
			msg.append(billingId);

			msg.append(", hordingId=");
			msg.append(hordingId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBilling_HordingException(msg.toString());
		}

		return billing_Hording;
	}

	/**
	 * Returns the billing_ hording where billingId = &#63; and hordingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param billingId the billing ID
	 * @param hordingId the hording ID
	 * @return the matching billing_ hording, or <code>null</code> if a matching billing_ hording could not be found
	 */
	@Override
	public Billing_Hording fetchBybillingIdAndHordingId(long billingId,
		long hordingId) {
		return fetchBybillingIdAndHordingId(billingId, hordingId, true);
	}

	/**
	 * Returns the billing_ hording where billingId = &#63; and hordingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param billingId the billing ID
	 * @param hordingId the hording ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching billing_ hording, or <code>null</code> if a matching billing_ hording could not be found
	 */
	@Override
	public Billing_Hording fetchBybillingIdAndHordingId(long billingId,
		long hordingId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { billingId, hordingId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
					finderArgs, this);
		}

		if (result instanceof Billing_Hording) {
			Billing_Hording billing_Hording = (Billing_Hording)result;

			if ((billingId != billing_Hording.getBillingId()) ||
					(hordingId != billing_Hording.getHordingId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BILLING_HORDING_WHERE);

			query.append(_FINDER_COLUMN_BILLINGIDANDHORDINGID_BILLINGID_2);

			query.append(_FINDER_COLUMN_BILLINGIDANDHORDINGID_HORDINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(billingId);

				qPos.add(hordingId);

				List<Billing_Hording> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"Billing_HordingPersistenceImpl.fetchBybillingIdAndHordingId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Billing_Hording billing_Hording = list.get(0);

					result = billing_Hording;

					cacheResult(billing_Hording);

					if ((billing_Hording.getBillingId() != billingId) ||
							(billing_Hording.getHordingId() != hordingId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
							finderArgs, billing_Hording);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
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
			return (Billing_Hording)result;
		}
	}

	/**
	 * Removes the billing_ hording where billingId = &#63; and hordingId = &#63; from the database.
	 *
	 * @param billingId the billing ID
	 * @param hordingId the hording ID
	 * @return the billing_ hording that was removed
	 */
	@Override
	public Billing_Hording removeBybillingIdAndHordingId(long billingId,
		long hordingId) throws NoSuchBilling_HordingException {
		Billing_Hording billing_Hording = findBybillingIdAndHordingId(billingId,
				hordingId);

		return remove(billing_Hording);
	}

	/**
	 * Returns the number of billing_ hordings where billingId = &#63; and hordingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param hordingId the hording ID
	 * @return the number of matching billing_ hordings
	 */
	@Override
	public int countBybillingIdAndHordingId(long billingId, long hordingId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BILLINGIDANDHORDINGID;

		Object[] finderArgs = new Object[] { billingId, hordingId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BILLING_HORDING_WHERE);

			query.append(_FINDER_COLUMN_BILLINGIDANDHORDINGID_BILLINGID_2);

			query.append(_FINDER_COLUMN_BILLINGIDANDHORDINGID_HORDINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(billingId);

				qPos.add(hordingId);

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

	private static final String _FINDER_COLUMN_BILLINGIDANDHORDINGID_BILLINGID_2 =
		"billing_Hording.id.billingId = ? AND ";
	private static final String _FINDER_COLUMN_BILLINGIDANDHORDINGID_HORDINGID_2 =
		"billing_Hording.id.hordingId = ?";

	public Billing_HordingPersistenceImpl() {
		setModelClass(Billing_Hording.class);
	}

	/**
	 * Caches the billing_ hording in the entity cache if it is enabled.
	 *
	 * @param billing_Hording the billing_ hording
	 */
	@Override
	public void cacheResult(Billing_Hording billing_Hording) {
		entityCache.putResult(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingImpl.class, billing_Hording.getPrimaryKey(),
			billing_Hording);

		finderCache.putResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
			new Object[] {
				billing_Hording.getBillingId(), billing_Hording.getHordingId()
			}, billing_Hording);

		billing_Hording.resetOriginalValues();
	}

	/**
	 * Caches the billing_ hordings in the entity cache if it is enabled.
	 *
	 * @param billing_Hordings the billing_ hordings
	 */
	@Override
	public void cacheResult(List<Billing_Hording> billing_Hordings) {
		for (Billing_Hording billing_Hording : billing_Hordings) {
			if (entityCache.getResult(
						Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
						Billing_HordingImpl.class,
						billing_Hording.getPrimaryKey()) == null) {
				cacheResult(billing_Hording);
			}
			else {
				billing_Hording.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all billing_ hordings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Billing_HordingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the billing_ hording.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Billing_Hording billing_Hording) {
		entityCache.removeResult(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingImpl.class, billing_Hording.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((Billing_HordingModelImpl)billing_Hording);
	}

	@Override
	public void clearCache(List<Billing_Hording> billing_Hordings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Billing_Hording billing_Hording : billing_Hordings) {
			entityCache.removeResult(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
				Billing_HordingImpl.class, billing_Hording.getPrimaryKey());

			clearUniqueFindersCache((Billing_HordingModelImpl)billing_Hording);
		}
	}

	protected void cacheUniqueFindersCache(
		Billing_HordingModelImpl billing_HordingModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					billing_HordingModelImpl.getBillingId(),
					billing_HordingModelImpl.getHordingId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_BILLINGIDANDHORDINGID,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
				args, billing_HordingModelImpl);
		}
		else {
			if ((billing_HordingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						billing_HordingModelImpl.getBillingId(),
						billing_HordingModelImpl.getHordingId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_BILLINGIDANDHORDINGID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
					args, billing_HordingModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		Billing_HordingModelImpl billing_HordingModelImpl) {
		Object[] args = new Object[] {
				billing_HordingModelImpl.getBillingId(),
				billing_HordingModelImpl.getHordingId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGIDANDHORDINGID,
			args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
			args);

		if ((billing_HordingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID.getColumnBitmask()) != 0) {
			args = new Object[] {
					billing_HordingModelImpl.getOriginalBillingId(),
					billing_HordingModelImpl.getOriginalHordingId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGIDANDHORDINGID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BILLINGIDANDHORDINGID,
				args);
		}
	}

	/**
	 * Creates a new billing_ hording with the primary key. Does not add the billing_ hording to the database.
	 *
	 * @param billing_HordingPK the primary key for the new billing_ hording
	 * @return the new billing_ hording
	 */
	@Override
	public Billing_Hording create(Billing_HordingPK billing_HordingPK) {
		Billing_Hording billing_Hording = new Billing_HordingImpl();

		billing_Hording.setNew(true);
		billing_Hording.setPrimaryKey(billing_HordingPK);

		return billing_Hording;
	}

	/**
	 * Removes the billing_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param billing_HordingPK the primary key of the billing_ hording
	 * @return the billing_ hording that was removed
	 * @throws NoSuchBilling_HordingException if a billing_ hording with the primary key could not be found
	 */
	@Override
	public Billing_Hording remove(Billing_HordingPK billing_HordingPK)
		throws NoSuchBilling_HordingException {
		return remove((Serializable)billing_HordingPK);
	}

	/**
	 * Removes the billing_ hording with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the billing_ hording
	 * @return the billing_ hording that was removed
	 * @throws NoSuchBilling_HordingException if a billing_ hording with the primary key could not be found
	 */
	@Override
	public Billing_Hording remove(Serializable primaryKey)
		throws NoSuchBilling_HordingException {
		Session session = null;

		try {
			session = openSession();

			Billing_Hording billing_Hording = (Billing_Hording)session.get(Billing_HordingImpl.class,
					primaryKey);

			if (billing_Hording == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBilling_HordingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(billing_Hording);
		}
		catch (NoSuchBilling_HordingException nsee) {
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
	protected Billing_Hording removeImpl(Billing_Hording billing_Hording) {
		billing_Hording = toUnwrappedModel(billing_Hording);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(billing_Hording)) {
				billing_Hording = (Billing_Hording)session.get(Billing_HordingImpl.class,
						billing_Hording.getPrimaryKeyObj());
			}

			if (billing_Hording != null) {
				session.delete(billing_Hording);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (billing_Hording != null) {
			clearCache(billing_Hording);
		}

		return billing_Hording;
	}

	@Override
	public Billing_Hording updateImpl(Billing_Hording billing_Hording) {
		billing_Hording = toUnwrappedModel(billing_Hording);

		boolean isNew = billing_Hording.isNew();

		Billing_HordingModelImpl billing_HordingModelImpl = (Billing_HordingModelImpl)billing_Hording;

		Session session = null;

		try {
			session = openSession();

			if (billing_Hording.isNew()) {
				session.save(billing_Hording);

				billing_Hording.setNew(false);
			}
			else {
				billing_Hording = (Billing_Hording)session.merge(billing_Hording);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Billing_HordingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((billing_HordingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						billing_HordingModelImpl.getOriginalBillingId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID,
					args);

				args = new Object[] { billing_HordingModelImpl.getBillingId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID,
					args);
			}
		}

		entityCache.putResult(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
			Billing_HordingImpl.class, billing_Hording.getPrimaryKey(),
			billing_Hording, false);

		clearUniqueFindersCache(billing_HordingModelImpl);
		cacheUniqueFindersCache(billing_HordingModelImpl, isNew);

		billing_Hording.resetOriginalValues();

		return billing_Hording;
	}

	protected Billing_Hording toUnwrappedModel(Billing_Hording billing_Hording) {
		if (billing_Hording instanceof Billing_HordingImpl) {
			return billing_Hording;
		}

		Billing_HordingImpl billing_HordingImpl = new Billing_HordingImpl();

		billing_HordingImpl.setNew(billing_Hording.isNew());
		billing_HordingImpl.setPrimaryKey(billing_Hording.getPrimaryKey());

		billing_HordingImpl.setBillingId(billing_Hording.getBillingId());
		billing_HordingImpl.setHordingId(billing_Hording.getHordingId());
		billing_HordingImpl.setTotalMountingCharge(billing_Hording.getTotalMountingCharge());
		billing_HordingImpl.setTotalPrintingCharge(billing_Hording.getTotalPrintingCharge());
		billing_HordingImpl.setUnits(billing_Hording.getUnits());
		billing_HordingImpl.setTotalHordingCharge(billing_Hording.getTotalHordingCharge());
		billing_HordingImpl.setHsnNo(billing_Hording.getHsnNo());

		return billing_HordingImpl;
	}

	/**
	 * Returns the billing_ hording with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing_ hording
	 * @return the billing_ hording
	 * @throws NoSuchBilling_HordingException if a billing_ hording with the primary key could not be found
	 */
	@Override
	public Billing_Hording findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBilling_HordingException {
		Billing_Hording billing_Hording = fetchByPrimaryKey(primaryKey);

		if (billing_Hording == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBilling_HordingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return billing_Hording;
	}

	/**
	 * Returns the billing_ hording with the primary key or throws a {@link NoSuchBilling_HordingException} if it could not be found.
	 *
	 * @param billing_HordingPK the primary key of the billing_ hording
	 * @return the billing_ hording
	 * @throws NoSuchBilling_HordingException if a billing_ hording with the primary key could not be found
	 */
	@Override
	public Billing_Hording findByPrimaryKey(Billing_HordingPK billing_HordingPK)
		throws NoSuchBilling_HordingException {
		return findByPrimaryKey((Serializable)billing_HordingPK);
	}

	/**
	 * Returns the billing_ hording with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing_ hording
	 * @return the billing_ hording, or <code>null</code> if a billing_ hording with the primary key could not be found
	 */
	@Override
	public Billing_Hording fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
				Billing_HordingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Billing_Hording billing_Hording = (Billing_Hording)serializable;

		if (billing_Hording == null) {
			Session session = null;

			try {
				session = openSession();

				billing_Hording = (Billing_Hording)session.get(Billing_HordingImpl.class,
						primaryKey);

				if (billing_Hording != null) {
					cacheResult(billing_Hording);
				}
				else {
					entityCache.putResult(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
						Billing_HordingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Billing_HordingModelImpl.ENTITY_CACHE_ENABLED,
					Billing_HordingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return billing_Hording;
	}

	/**
	 * Returns the billing_ hording with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param billing_HordingPK the primary key of the billing_ hording
	 * @return the billing_ hording, or <code>null</code> if a billing_ hording with the primary key could not be found
	 */
	@Override
	public Billing_Hording fetchByPrimaryKey(
		Billing_HordingPK billing_HordingPK) {
		return fetchByPrimaryKey((Serializable)billing_HordingPK);
	}

	@Override
	public Map<Serializable, Billing_Hording> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Billing_Hording> map = new HashMap<Serializable, Billing_Hording>();

		for (Serializable primaryKey : primaryKeys) {
			Billing_Hording billing_Hording = fetchByPrimaryKey(primaryKey);

			if (billing_Hording != null) {
				map.put(primaryKey, billing_Hording);
			}
		}

		return map;
	}

	/**
	 * Returns all the billing_ hordings.
	 *
	 * @return the billing_ hordings
	 */
	@Override
	public List<Billing_Hording> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the billing_ hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing_ hordings
	 * @param end the upper bound of the range of billing_ hordings (not inclusive)
	 * @return the range of billing_ hordings
	 */
	@Override
	public List<Billing_Hording> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the billing_ hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing_ hordings
	 * @param end the upper bound of the range of billing_ hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of billing_ hordings
	 */
	@Override
	public List<Billing_Hording> findAll(int start, int end,
		OrderByComparator<Billing_Hording> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billing_ hordings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing_ hordings
	 * @param end the upper bound of the range of billing_ hordings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of billing_ hordings
	 */
	@Override
	public List<Billing_Hording> findAll(int start, int end,
		OrderByComparator<Billing_Hording> orderByComparator,
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

		List<Billing_Hording> list = null;

		if (retrieveFromCache) {
			list = (List<Billing_Hording>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BILLING_HORDING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BILLING_HORDING;

				if (pagination) {
					sql = sql.concat(Billing_HordingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Billing_Hording>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Billing_Hording>)QueryUtil.list(q,
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
	 * Removes all the billing_ hordings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Billing_Hording billing_Hording : findAll()) {
			remove(billing_Hording);
		}
	}

	/**
	 * Returns the number of billing_ hordings.
	 *
	 * @return the number of billing_ hordings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BILLING_HORDING);

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
		return Billing_HordingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the billing_ hording persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Billing_HordingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BILLING_HORDING = "SELECT billing_Hording FROM Billing_Hording billing_Hording";
	private static final String _SQL_SELECT_BILLING_HORDING_WHERE = "SELECT billing_Hording FROM Billing_Hording billing_Hording WHERE ";
	private static final String _SQL_COUNT_BILLING_HORDING = "SELECT COUNT(billing_Hording) FROM Billing_Hording billing_Hording";
	private static final String _SQL_COUNT_BILLING_HORDING_WHERE = "SELECT COUNT(billing_Hording) FROM Billing_Hording billing_Hording WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "billing_Hording.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Billing_Hording exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Billing_Hording exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Billing_HordingPersistenceImpl.class);
}