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
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchSupplierBillPaymentException;
import com.sphms.common.service.model.SupplierBillPayment;
import com.sphms.common.service.model.impl.SupplierBillPaymentImpl;
import com.sphms.common.service.model.impl.SupplierBillPaymentModelImpl;
import com.sphms.common.service.service.persistence.SupplierBillPaymentPersistence;

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
 * The persistence implementation for the supplier bill payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierBillPaymentPersistence
 * @see com.sphms.common.service.service.persistence.SupplierBillPaymentUtil
 * @generated
 */
@ProviderType
public class SupplierBillPaymentPersistenceImpl extends BasePersistenceImpl<SupplierBillPayment>
	implements SupplierBillPaymentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SupplierBillPaymentUtil} to access the supplier bill payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SupplierBillPaymentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentModelImpl.FINDER_CACHE_ENABLED,
			SupplierBillPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentModelImpl.FINDER_CACHE_ENABLED,
			SupplierBillPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUPPLIERBILLID =
		new FinderPath(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentModelImpl.FINDER_CACHE_ENABLED,
			SupplierBillPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysupplierBillId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLIERBILLID =
		new FinderPath(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentModelImpl.FINDER_CACHE_ENABLED,
			SupplierBillPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysupplierBillId",
			new String[] { Long.class.getName() },
			SupplierBillPaymentModelImpl.SUPPLIERBILLID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUPPLIERBILLID = new FinderPath(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysupplierBillId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the supplier bill payments where supplierBillId = &#63;.
	 *
	 * @param supplierBillId the supplier bill ID
	 * @return the matching supplier bill payments
	 */
	@Override
	public List<SupplierBillPayment> findBysupplierBillId(long supplierBillId) {
		return findBysupplierBillId(supplierBillId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the supplier bill payments where supplierBillId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supplierBillId the supplier bill ID
	 * @param start the lower bound of the range of supplier bill payments
	 * @param end the upper bound of the range of supplier bill payments (not inclusive)
	 * @return the range of matching supplier bill payments
	 */
	@Override
	public List<SupplierBillPayment> findBysupplierBillId(long supplierBillId,
		int start, int end) {
		return findBysupplierBillId(supplierBillId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the supplier bill payments where supplierBillId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supplierBillId the supplier bill ID
	 * @param start the lower bound of the range of supplier bill payments
	 * @param end the upper bound of the range of supplier bill payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching supplier bill payments
	 */
	@Override
	public List<SupplierBillPayment> findBysupplierBillId(long supplierBillId,
		int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		return findBysupplierBillId(supplierBillId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the supplier bill payments where supplierBillId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supplierBillId the supplier bill ID
	 * @param start the lower bound of the range of supplier bill payments
	 * @param end the upper bound of the range of supplier bill payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching supplier bill payments
	 */
	@Override
	public List<SupplierBillPayment> findBysupplierBillId(long supplierBillId,
		int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLIERBILLID;
			finderArgs = new Object[] { supplierBillId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUPPLIERBILLID;
			finderArgs = new Object[] {
					supplierBillId,
					
					start, end, orderByComparator
				};
		}

		List<SupplierBillPayment> list = null;

		if (retrieveFromCache) {
			list = (List<SupplierBillPayment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SupplierBillPayment supplierBillPayment : list) {
					if ((supplierBillId != supplierBillPayment.getSupplierBillId())) {
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

			query.append(_SQL_SELECT_SUPPLIERBILLPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_SUPPLIERBILLID_SUPPLIERBILLID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SupplierBillPaymentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supplierBillId);

				if (!pagination) {
					list = (List<SupplierBillPayment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupplierBillPayment>)QueryUtil.list(q,
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
	 * Returns the first supplier bill payment in the ordered set where supplierBillId = &#63;.
	 *
	 * @param supplierBillId the supplier bill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supplier bill payment
	 * @throws NoSuchSupplierBillPaymentException if a matching supplier bill payment could not be found
	 */
	@Override
	public SupplierBillPayment findBysupplierBillId_First(long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator)
		throws NoSuchSupplierBillPaymentException {
		SupplierBillPayment supplierBillPayment = fetchBysupplierBillId_First(supplierBillId,
				orderByComparator);

		if (supplierBillPayment != null) {
			return supplierBillPayment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supplierBillId=");
		msg.append(supplierBillId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplierBillPaymentException(msg.toString());
	}

	/**
	 * Returns the first supplier bill payment in the ordered set where supplierBillId = &#63;.
	 *
	 * @param supplierBillId the supplier bill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supplier bill payment, or <code>null</code> if a matching supplier bill payment could not be found
	 */
	@Override
	public SupplierBillPayment fetchBysupplierBillId_First(
		long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		List<SupplierBillPayment> list = findBysupplierBillId(supplierBillId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last supplier bill payment in the ordered set where supplierBillId = &#63;.
	 *
	 * @param supplierBillId the supplier bill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supplier bill payment
	 * @throws NoSuchSupplierBillPaymentException if a matching supplier bill payment could not be found
	 */
	@Override
	public SupplierBillPayment findBysupplierBillId_Last(long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator)
		throws NoSuchSupplierBillPaymentException {
		SupplierBillPayment supplierBillPayment = fetchBysupplierBillId_Last(supplierBillId,
				orderByComparator);

		if (supplierBillPayment != null) {
			return supplierBillPayment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supplierBillId=");
		msg.append(supplierBillId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplierBillPaymentException(msg.toString());
	}

	/**
	 * Returns the last supplier bill payment in the ordered set where supplierBillId = &#63;.
	 *
	 * @param supplierBillId the supplier bill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supplier bill payment, or <code>null</code> if a matching supplier bill payment could not be found
	 */
	@Override
	public SupplierBillPayment fetchBysupplierBillId_Last(long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		int count = countBysupplierBillId(supplierBillId);

		if (count == 0) {
			return null;
		}

		List<SupplierBillPayment> list = findBysupplierBillId(supplierBillId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the supplier bill payments before and after the current supplier bill payment in the ordered set where supplierBillId = &#63;.
	 *
	 * @param supplierBillPaymentId the primary key of the current supplier bill payment
	 * @param supplierBillId the supplier bill ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next supplier bill payment
	 * @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	 */
	@Override
	public SupplierBillPayment[] findBysupplierBillId_PrevAndNext(
		long supplierBillPaymentId, long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator)
		throws NoSuchSupplierBillPaymentException {
		SupplierBillPayment supplierBillPayment = findByPrimaryKey(supplierBillPaymentId);

		Session session = null;

		try {
			session = openSession();

			SupplierBillPayment[] array = new SupplierBillPaymentImpl[3];

			array[0] = getBysupplierBillId_PrevAndNext(session,
					supplierBillPayment, supplierBillId, orderByComparator, true);

			array[1] = supplierBillPayment;

			array[2] = getBysupplierBillId_PrevAndNext(session,
					supplierBillPayment, supplierBillId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SupplierBillPayment getBysupplierBillId_PrevAndNext(
		Session session, SupplierBillPayment supplierBillPayment,
		long supplierBillId,
		OrderByComparator<SupplierBillPayment> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPLIERBILLPAYMENT_WHERE);

		query.append(_FINDER_COLUMN_SUPPLIERBILLID_SUPPLIERBILLID_2);

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
			query.append(SupplierBillPaymentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(supplierBillId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(supplierBillPayment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SupplierBillPayment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the supplier bill payments where supplierBillId = &#63; from the database.
	 *
	 * @param supplierBillId the supplier bill ID
	 */
	@Override
	public void removeBysupplierBillId(long supplierBillId) {
		for (SupplierBillPayment supplierBillPayment : findBysupplierBillId(
				supplierBillId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(supplierBillPayment);
		}
	}

	/**
	 * Returns the number of supplier bill payments where supplierBillId = &#63;.
	 *
	 * @param supplierBillId the supplier bill ID
	 * @return the number of matching supplier bill payments
	 */
	@Override
	public int countBysupplierBillId(long supplierBillId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUPPLIERBILLID;

		Object[] finderArgs = new Object[] { supplierBillId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPLIERBILLPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_SUPPLIERBILLID_SUPPLIERBILLID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supplierBillId);

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

	private static final String _FINDER_COLUMN_SUPPLIERBILLID_SUPPLIERBILLID_2 = "supplierBillPayment.supplierBillId = ?";

	public SupplierBillPaymentPersistenceImpl() {
		setModelClass(SupplierBillPayment.class);
	}

	/**
	 * Caches the supplier bill payment in the entity cache if it is enabled.
	 *
	 * @param supplierBillPayment the supplier bill payment
	 */
	@Override
	public void cacheResult(SupplierBillPayment supplierBillPayment) {
		entityCache.putResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentImpl.class, supplierBillPayment.getPrimaryKey(),
			supplierBillPayment);

		supplierBillPayment.resetOriginalValues();
	}

	/**
	 * Caches the supplier bill payments in the entity cache if it is enabled.
	 *
	 * @param supplierBillPayments the supplier bill payments
	 */
	@Override
	public void cacheResult(List<SupplierBillPayment> supplierBillPayments) {
		for (SupplierBillPayment supplierBillPayment : supplierBillPayments) {
			if (entityCache.getResult(
						SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
						SupplierBillPaymentImpl.class,
						supplierBillPayment.getPrimaryKey()) == null) {
				cacheResult(supplierBillPayment);
			}
			else {
				supplierBillPayment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all supplier bill payments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SupplierBillPaymentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the supplier bill payment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SupplierBillPayment supplierBillPayment) {
		entityCache.removeResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentImpl.class, supplierBillPayment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SupplierBillPayment> supplierBillPayments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SupplierBillPayment supplierBillPayment : supplierBillPayments) {
			entityCache.removeResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
				SupplierBillPaymentImpl.class,
				supplierBillPayment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new supplier bill payment with the primary key. Does not add the supplier bill payment to the database.
	 *
	 * @param supplierBillPaymentId the primary key for the new supplier bill payment
	 * @return the new supplier bill payment
	 */
	@Override
	public SupplierBillPayment create(long supplierBillPaymentId) {
		SupplierBillPayment supplierBillPayment = new SupplierBillPaymentImpl();

		supplierBillPayment.setNew(true);
		supplierBillPayment.setPrimaryKey(supplierBillPaymentId);

		return supplierBillPayment;
	}

	/**
	 * Removes the supplier bill payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supplierBillPaymentId the primary key of the supplier bill payment
	 * @return the supplier bill payment that was removed
	 * @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	 */
	@Override
	public SupplierBillPayment remove(long supplierBillPaymentId)
		throws NoSuchSupplierBillPaymentException {
		return remove((Serializable)supplierBillPaymentId);
	}

	/**
	 * Removes the supplier bill payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the supplier bill payment
	 * @return the supplier bill payment that was removed
	 * @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	 */
	@Override
	public SupplierBillPayment remove(Serializable primaryKey)
		throws NoSuchSupplierBillPaymentException {
		Session session = null;

		try {
			session = openSession();

			SupplierBillPayment supplierBillPayment = (SupplierBillPayment)session.get(SupplierBillPaymentImpl.class,
					primaryKey);

			if (supplierBillPayment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupplierBillPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(supplierBillPayment);
		}
		catch (NoSuchSupplierBillPaymentException nsee) {
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
	protected SupplierBillPayment removeImpl(
		SupplierBillPayment supplierBillPayment) {
		supplierBillPayment = toUnwrappedModel(supplierBillPayment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supplierBillPayment)) {
				supplierBillPayment = (SupplierBillPayment)session.get(SupplierBillPaymentImpl.class,
						supplierBillPayment.getPrimaryKeyObj());
			}

			if (supplierBillPayment != null) {
				session.delete(supplierBillPayment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supplierBillPayment != null) {
			clearCache(supplierBillPayment);
		}

		return supplierBillPayment;
	}

	@Override
	public SupplierBillPayment updateImpl(
		SupplierBillPayment supplierBillPayment) {
		supplierBillPayment = toUnwrappedModel(supplierBillPayment);

		boolean isNew = supplierBillPayment.isNew();

		SupplierBillPaymentModelImpl supplierBillPaymentModelImpl = (SupplierBillPaymentModelImpl)supplierBillPayment;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (supplierBillPayment.getCreateDate() == null)) {
			if (serviceContext == null) {
				supplierBillPayment.setCreateDate(now);
			}
			else {
				supplierBillPayment.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!supplierBillPaymentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				supplierBillPayment.setModifiedDate(now);
			}
			else {
				supplierBillPayment.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (supplierBillPayment.isNew()) {
				session.save(supplierBillPayment);

				supplierBillPayment.setNew(false);
			}
			else {
				supplierBillPayment = (SupplierBillPayment)session.merge(supplierBillPayment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SupplierBillPaymentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((supplierBillPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLIERBILLID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						supplierBillPaymentModelImpl.getOriginalSupplierBillId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SUPPLIERBILLID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLIERBILLID,
					args);

				args = new Object[] {
						supplierBillPaymentModelImpl.getSupplierBillId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SUPPLIERBILLID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLIERBILLID,
					args);
			}
		}

		entityCache.putResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
			SupplierBillPaymentImpl.class, supplierBillPayment.getPrimaryKey(),
			supplierBillPayment, false);

		supplierBillPayment.resetOriginalValues();

		return supplierBillPayment;
	}

	protected SupplierBillPayment toUnwrappedModel(
		SupplierBillPayment supplierBillPayment) {
		if (supplierBillPayment instanceof SupplierBillPaymentImpl) {
			return supplierBillPayment;
		}

		SupplierBillPaymentImpl supplierBillPaymentImpl = new SupplierBillPaymentImpl();

		supplierBillPaymentImpl.setNew(supplierBillPayment.isNew());
		supplierBillPaymentImpl.setPrimaryKey(supplierBillPayment.getPrimaryKey());

		supplierBillPaymentImpl.setSupplierBillPaymentId(supplierBillPayment.getSupplierBillPaymentId());
		supplierBillPaymentImpl.setSupplierBillId(supplierBillPayment.getSupplierBillId());
		supplierBillPaymentImpl.setSupplierId(supplierBillPayment.getSupplierId());
		supplierBillPaymentImpl.setAmount(supplierBillPayment.getAmount());
		supplierBillPaymentImpl.setGst(supplierBillPayment.getGst());
		supplierBillPaymentImpl.setChequeNo(supplierBillPayment.getChequeNo());
		supplierBillPaymentImpl.setPaymentDate(supplierBillPayment.getPaymentDate());
		supplierBillPaymentImpl.setCreateDate(supplierBillPayment.getCreateDate());
		supplierBillPaymentImpl.setCreatedBy(supplierBillPayment.getCreatedBy());
		supplierBillPaymentImpl.setModifiedDate(supplierBillPayment.getModifiedDate());
		supplierBillPaymentImpl.setModifiedBy(supplierBillPayment.getModifiedBy());

		return supplierBillPaymentImpl;
	}

	/**
	 * Returns the supplier bill payment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the supplier bill payment
	 * @return the supplier bill payment
	 * @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	 */
	@Override
	public SupplierBillPayment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupplierBillPaymentException {
		SupplierBillPayment supplierBillPayment = fetchByPrimaryKey(primaryKey);

		if (supplierBillPayment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupplierBillPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return supplierBillPayment;
	}

	/**
	 * Returns the supplier bill payment with the primary key or throws a {@link NoSuchSupplierBillPaymentException} if it could not be found.
	 *
	 * @param supplierBillPaymentId the primary key of the supplier bill payment
	 * @return the supplier bill payment
	 * @throws NoSuchSupplierBillPaymentException if a supplier bill payment with the primary key could not be found
	 */
	@Override
	public SupplierBillPayment findByPrimaryKey(long supplierBillPaymentId)
		throws NoSuchSupplierBillPaymentException {
		return findByPrimaryKey((Serializable)supplierBillPaymentId);
	}

	/**
	 * Returns the supplier bill payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the supplier bill payment
	 * @return the supplier bill payment, or <code>null</code> if a supplier bill payment with the primary key could not be found
	 */
	@Override
	public SupplierBillPayment fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
				SupplierBillPaymentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SupplierBillPayment supplierBillPayment = (SupplierBillPayment)serializable;

		if (supplierBillPayment == null) {
			Session session = null;

			try {
				session = openSession();

				supplierBillPayment = (SupplierBillPayment)session.get(SupplierBillPaymentImpl.class,
						primaryKey);

				if (supplierBillPayment != null) {
					cacheResult(supplierBillPayment);
				}
				else {
					entityCache.putResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
						SupplierBillPaymentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
					SupplierBillPaymentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return supplierBillPayment;
	}

	/**
	 * Returns the supplier bill payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supplierBillPaymentId the primary key of the supplier bill payment
	 * @return the supplier bill payment, or <code>null</code> if a supplier bill payment with the primary key could not be found
	 */
	@Override
	public SupplierBillPayment fetchByPrimaryKey(long supplierBillPaymentId) {
		return fetchByPrimaryKey((Serializable)supplierBillPaymentId);
	}

	@Override
	public Map<Serializable, SupplierBillPayment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SupplierBillPayment> map = new HashMap<Serializable, SupplierBillPayment>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SupplierBillPayment supplierBillPayment = fetchByPrimaryKey(primaryKey);

			if (supplierBillPayment != null) {
				map.put(primaryKey, supplierBillPayment);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
					SupplierBillPaymentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SupplierBillPayment)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SUPPLIERBILLPAYMENT_WHERE_PKS_IN);

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

			for (SupplierBillPayment supplierBillPayment : (List<SupplierBillPayment>)q.list()) {
				map.put(supplierBillPayment.getPrimaryKeyObj(),
					supplierBillPayment);

				cacheResult(supplierBillPayment);

				uncachedPrimaryKeys.remove(supplierBillPayment.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SupplierBillPaymentModelImpl.ENTITY_CACHE_ENABLED,
					SupplierBillPaymentImpl.class, primaryKey, nullModel);
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
	 * Returns all the supplier bill payments.
	 *
	 * @return the supplier bill payments
	 */
	@Override
	public List<SupplierBillPayment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the supplier bill payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of supplier bill payments
	 * @param end the upper bound of the range of supplier bill payments (not inclusive)
	 * @return the range of supplier bill payments
	 */
	@Override
	public List<SupplierBillPayment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the supplier bill payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of supplier bill payments
	 * @param end the upper bound of the range of supplier bill payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of supplier bill payments
	 */
	@Override
	public List<SupplierBillPayment> findAll(int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the supplier bill payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierBillPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of supplier bill payments
	 * @param end the upper bound of the range of supplier bill payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of supplier bill payments
	 */
	@Override
	public List<SupplierBillPayment> findAll(int start, int end,
		OrderByComparator<SupplierBillPayment> orderByComparator,
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

		List<SupplierBillPayment> list = null;

		if (retrieveFromCache) {
			list = (List<SupplierBillPayment>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUPPLIERBILLPAYMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPLIERBILLPAYMENT;

				if (pagination) {
					sql = sql.concat(SupplierBillPaymentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SupplierBillPayment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupplierBillPayment>)QueryUtil.list(q,
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
	 * Removes all the supplier bill payments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SupplierBillPayment supplierBillPayment : findAll()) {
			remove(supplierBillPayment);
		}
	}

	/**
	 * Returns the number of supplier bill payments.
	 *
	 * @return the number of supplier bill payments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUPPLIERBILLPAYMENT);

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
		return SupplierBillPaymentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the supplier bill payment persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SupplierBillPaymentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SUPPLIERBILLPAYMENT = "SELECT supplierBillPayment FROM SupplierBillPayment supplierBillPayment";
	private static final String _SQL_SELECT_SUPPLIERBILLPAYMENT_WHERE_PKS_IN = "SELECT supplierBillPayment FROM SupplierBillPayment supplierBillPayment WHERE supplierBillPaymentId IN (";
	private static final String _SQL_SELECT_SUPPLIERBILLPAYMENT_WHERE = "SELECT supplierBillPayment FROM SupplierBillPayment supplierBillPayment WHERE ";
	private static final String _SQL_COUNT_SUPPLIERBILLPAYMENT = "SELECT COUNT(supplierBillPayment) FROM SupplierBillPayment supplierBillPayment";
	private static final String _SQL_COUNT_SUPPLIERBILLPAYMENT_WHERE = "SELECT COUNT(supplierBillPayment) FROM SupplierBillPayment supplierBillPayment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "supplierBillPayment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SupplierBillPayment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SupplierBillPayment exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SupplierBillPaymentPersistenceImpl.class);
}