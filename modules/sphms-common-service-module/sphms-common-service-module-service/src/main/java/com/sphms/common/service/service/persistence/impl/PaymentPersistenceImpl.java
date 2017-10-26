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

import com.sphms.common.service.exception.NoSuchPaymentException;
import com.sphms.common.service.model.Payment;
import com.sphms.common.service.model.impl.PaymentImpl;
import com.sphms.common.service.model.impl.PaymentModelImpl;
import com.sphms.common.service.service.persistence.PaymentPersistence;

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
 * The persistence implementation for the payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PaymentPersistence
 * @see com.sphms.common.service.service.persistence.PaymentUtil
 * @generated
 */
@ProviderType
public class PaymentPersistenceImpl extends BasePersistenceImpl<Payment>
	implements PaymentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PaymentUtil} to access the payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PaymentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BILLINGID =
		new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybillingId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID =
		new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentModelImpl.FINDER_CACHE_ENABLED, PaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybillingId",
			new String[] { Long.class.getName() },
			PaymentModelImpl.BILLINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BILLINGID = new FinderPath(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybillingId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the payments where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @return the matching payments
	 */
	@Override
	public List<Payment> findBybillingId(long billingId) {
		return findBybillingId(billingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the payments where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of matching payments
	 */
	@Override
	public List<Payment> findBybillingId(long billingId, int start, int end) {
		return findBybillingId(billingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the payments where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching payments
	 */
	@Override
	public List<Payment> findBybillingId(long billingId, int start, int end,
		OrderByComparator<Payment> orderByComparator) {
		return findBybillingId(billingId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payments where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching payments
	 */
	@Override
	public List<Payment> findBybillingId(long billingId, int start, int end,
		OrderByComparator<Payment> orderByComparator, boolean retrieveFromCache) {
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

		List<Payment> list = null;

		if (retrieveFromCache) {
			list = (List<Payment>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Payment payment : list) {
					if ((billingId != payment.getBillingId())) {
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

			query.append(_SQL_SELECT_PAYMENT_WHERE);

			query.append(_FINDER_COLUMN_BILLINGID_BILLINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PaymentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(billingId);

				if (!pagination) {
					list = (List<Payment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Payment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first payment in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	@Override
	public Payment findBybillingId_First(long billingId,
		OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException {
		Payment payment = fetchBybillingId_First(billingId, orderByComparator);

		if (payment != null) {
			return payment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPaymentException(msg.toString());
	}

	/**
	 * Returns the first payment in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching payment, or <code>null</code> if a matching payment could not be found
	 */
	@Override
	public Payment fetchBybillingId_First(long billingId,
		OrderByComparator<Payment> orderByComparator) {
		List<Payment> list = findBybillingId(billingId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last payment in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment
	 * @throws NoSuchPaymentException if a matching payment could not be found
	 */
	@Override
	public Payment findBybillingId_Last(long billingId,
		OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException {
		Payment payment = fetchBybillingId_Last(billingId, orderByComparator);

		if (payment != null) {
			return payment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPaymentException(msg.toString());
	}

	/**
	 * Returns the last payment in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching payment, or <code>null</code> if a matching payment could not be found
	 */
	@Override
	public Payment fetchBybillingId_Last(long billingId,
		OrderByComparator<Payment> orderByComparator) {
		int count = countBybillingId(billingId);

		if (count == 0) {
			return null;
		}

		List<Payment> list = findBybillingId(billingId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the payments before and after the current payment in the ordered set where billingId = &#63;.
	 *
	 * @param paymentId the primary key of the current payment
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment[] findBybillingId_PrevAndNext(long paymentId,
		long billingId, OrderByComparator<Payment> orderByComparator)
		throws NoSuchPaymentException {
		Payment payment = findByPrimaryKey(paymentId);

		Session session = null;

		try {
			session = openSession();

			Payment[] array = new PaymentImpl[3];

			array[0] = getBybillingId_PrevAndNext(session, payment, billingId,
					orderByComparator, true);

			array[1] = payment;

			array[2] = getBybillingId_PrevAndNext(session, payment, billingId,
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

	protected Payment getBybillingId_PrevAndNext(Session session,
		Payment payment, long billingId,
		OrderByComparator<Payment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PAYMENT_WHERE);

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
			query.append(PaymentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(billingId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Payment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the payments where billingId = &#63; from the database.
	 *
	 * @param billingId the billing ID
	 */
	@Override
	public void removeBybillingId(long billingId) {
		for (Payment payment : findBybillingId(billingId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(payment);
		}
	}

	/**
	 * Returns the number of payments where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @return the number of matching payments
	 */
	@Override
	public int countBybillingId(long billingId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BILLINGID;

		Object[] finderArgs = new Object[] { billingId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PAYMENT_WHERE);

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

	private static final String _FINDER_COLUMN_BILLINGID_BILLINGID_2 = "payment.billingId = ?";

	public PaymentPersistenceImpl() {
		setModelClass(Payment.class);
	}

	/**
	 * Caches the payment in the entity cache if it is enabled.
	 *
	 * @param payment the payment
	 */
	@Override
	public void cacheResult(Payment payment) {
		entityCache.putResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentImpl.class, payment.getPrimaryKey(), payment);

		payment.resetOriginalValues();
	}

	/**
	 * Caches the payments in the entity cache if it is enabled.
	 *
	 * @param payments the payments
	 */
	@Override
	public void cacheResult(List<Payment> payments) {
		for (Payment payment : payments) {
			if (entityCache.getResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
						PaymentImpl.class, payment.getPrimaryKey()) == null) {
				cacheResult(payment);
			}
			else {
				payment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all payments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PaymentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the payment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Payment payment) {
		entityCache.removeResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentImpl.class, payment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Payment> payments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Payment payment : payments) {
			entityCache.removeResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
				PaymentImpl.class, payment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new payment with the primary key. Does not add the payment to the database.
	 *
	 * @param paymentId the primary key for the new payment
	 * @return the new payment
	 */
	@Override
	public Payment create(long paymentId) {
		Payment payment = new PaymentImpl();

		payment.setNew(true);
		payment.setPrimaryKey(paymentId);

		return payment;
	}

	/**
	 * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment that was removed
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment remove(long paymentId) throws NoSuchPaymentException {
		return remove((Serializable)paymentId);
	}

	/**
	 * Removes the payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the payment
	 * @return the payment that was removed
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment remove(Serializable primaryKey)
		throws NoSuchPaymentException {
		Session session = null;

		try {
			session = openSession();

			Payment payment = (Payment)session.get(PaymentImpl.class, primaryKey);

			if (payment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payment);
		}
		catch (NoSuchPaymentException nsee) {
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
	protected Payment removeImpl(Payment payment) {
		payment = toUnwrappedModel(payment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payment)) {
				payment = (Payment)session.get(PaymentImpl.class,
						payment.getPrimaryKeyObj());
			}

			if (payment != null) {
				session.delete(payment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payment != null) {
			clearCache(payment);
		}

		return payment;
	}

	@Override
	public Payment updateImpl(Payment payment) {
		payment = toUnwrappedModel(payment);

		boolean isNew = payment.isNew();

		PaymentModelImpl paymentModelImpl = (PaymentModelImpl)payment;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (payment.getCreateDate() == null)) {
			if (serviceContext == null) {
				payment.setCreateDate(now);
			}
			else {
				payment.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!paymentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				payment.setModifiedDate(now);
			}
			else {
				payment.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (payment.isNew()) {
				session.save(payment);

				payment.setNew(false);
			}
			else {
				payment = (Payment)session.merge(payment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PaymentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((paymentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						paymentModelImpl.getOriginalBillingId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID,
					args);

				args = new Object[] { paymentModelImpl.getBillingId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID,
					args);
			}
		}

		entityCache.putResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
			PaymentImpl.class, payment.getPrimaryKey(), payment, false);

		payment.resetOriginalValues();

		return payment;
	}

	protected Payment toUnwrappedModel(Payment payment) {
		if (payment instanceof PaymentImpl) {
			return payment;
		}

		PaymentImpl paymentImpl = new PaymentImpl();

		paymentImpl.setNew(payment.isNew());
		paymentImpl.setPrimaryKey(payment.getPrimaryKey());

		paymentImpl.setPaymentId(payment.getPaymentId());
		paymentImpl.setBillingId(payment.getBillingId());
		paymentImpl.setClientId(payment.getClientId());
		paymentImpl.setAmount(payment.getAmount());
		paymentImpl.setChequeNo(payment.getChequeNo());
		paymentImpl.setTds(payment.getTds());
		paymentImpl.setDeduction(payment.getDeduction());
		paymentImpl.setCreateDate(payment.getCreateDate());
		paymentImpl.setCreatedBy(payment.getCreatedBy());
		paymentImpl.setModifiedDate(payment.getModifiedDate());
		paymentImpl.setModifiedBy(payment.getModifiedBy());

		return paymentImpl;
	}

	/**
	 * Returns the payment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the payment
	 * @return the payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPaymentException {
		Payment payment = fetchByPrimaryKey(primaryKey);

		if (payment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payment;
	}

	/**
	 * Returns the payment with the primary key or throws a {@link NoSuchPaymentException} if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment
	 * @throws NoSuchPaymentException if a payment with the primary key could not be found
	 */
	@Override
	public Payment findByPrimaryKey(long paymentId)
		throws NoSuchPaymentException {
		return findByPrimaryKey((Serializable)paymentId);
	}

	/**
	 * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the payment
	 * @return the payment, or <code>null</code> if a payment with the primary key could not be found
	 */
	@Override
	public Payment fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
				PaymentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Payment payment = (Payment)serializable;

		if (payment == null) {
			Session session = null;

			try {
				session = openSession();

				payment = (Payment)session.get(PaymentImpl.class, primaryKey);

				if (payment != null) {
					cacheResult(payment);
				}
				else {
					entityCache.putResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
						PaymentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
					PaymentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payment;
	}

	/**
	 * Returns the payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param paymentId the primary key of the payment
	 * @return the payment, or <code>null</code> if a payment with the primary key could not be found
	 */
	@Override
	public Payment fetchByPrimaryKey(long paymentId) {
		return fetchByPrimaryKey((Serializable)paymentId);
	}

	@Override
	public Map<Serializable, Payment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Payment> map = new HashMap<Serializable, Payment>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Payment payment = fetchByPrimaryKey(primaryKey);

			if (payment != null) {
				map.put(primaryKey, payment);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
					PaymentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Payment)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PAYMENT_WHERE_PKS_IN);

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

			for (Payment payment : (List<Payment>)q.list()) {
				map.put(payment.getPrimaryKeyObj(), payment);

				cacheResult(payment);

				uncachedPrimaryKeys.remove(payment.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PaymentModelImpl.ENTITY_CACHE_ENABLED,
					PaymentImpl.class, primaryKey, nullModel);
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
	 * Returns all the payments.
	 *
	 * @return the payments
	 */
	@Override
	public List<Payment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @return the range of payments
	 */
	@Override
	public List<Payment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of payments
	 */
	@Override
	public List<Payment> findAll(int start, int end,
		OrderByComparator<Payment> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of payments
	 * @param end the upper bound of the range of payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of payments
	 */
	@Override
	public List<Payment> findAll(int start, int end,
		OrderByComparator<Payment> orderByComparator, boolean retrieveFromCache) {
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

		List<Payment> list = null;

		if (retrieveFromCache) {
			list = (List<Payment>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PAYMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYMENT;

				if (pagination) {
					sql = sql.concat(PaymentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Payment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Payment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the payments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Payment payment : findAll()) {
			remove(payment);
		}
	}

	/**
	 * Returns the number of payments.
	 *
	 * @return the number of payments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAYMENT);

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
		return PaymentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the payment persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PaymentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PAYMENT = "SELECT payment FROM Payment payment";
	private static final String _SQL_SELECT_PAYMENT_WHERE_PKS_IN = "SELECT payment FROM Payment payment WHERE paymentId IN (";
	private static final String _SQL_SELECT_PAYMENT_WHERE = "SELECT payment FROM Payment payment WHERE ";
	private static final String _SQL_COUNT_PAYMENT = "SELECT COUNT(payment) FROM Payment payment";
	private static final String _SQL_COUNT_PAYMENT_WHERE = "SELECT COUNT(payment) FROM Payment payment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Payment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Payment exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PaymentPersistenceImpl.class);
}