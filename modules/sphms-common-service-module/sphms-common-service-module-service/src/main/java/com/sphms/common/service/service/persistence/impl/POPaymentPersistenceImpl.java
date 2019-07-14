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

import com.sphms.common.service.exception.NoSuchPOPaymentException;
import com.sphms.common.service.model.POPayment;
import com.sphms.common.service.model.impl.POPaymentImpl;
import com.sphms.common.service.model.impl.POPaymentModelImpl;
import com.sphms.common.service.service.persistence.POPaymentPersistence;

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
 * The persistence implementation for the p o payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see POPaymentPersistence
 * @see com.sphms.common.service.service.persistence.POPaymentUtil
 * @generated
 */
@ProviderType
public class POPaymentPersistenceImpl extends BasePersistenceImpl<POPayment>
	implements POPaymentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link POPaymentUtil} to access the p o payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = POPaymentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentModelImpl.FINDER_CACHE_ENABLED, POPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentModelImpl.FINDER_CACHE_ENABLED, POPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID =
		new FinderPath(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentModelImpl.FINDER_CACHE_ENABLED, POPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybillingIdAndLandLordId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID =
		new FinderPath(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentModelImpl.FINDER_CACHE_ENABLED, POPaymentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybillingIdAndLandLordId",
			new String[] { Long.class.getName(), Long.class.getName() },
			POPaymentModelImpl.BILLINGID_COLUMN_BITMASK |
			POPaymentModelImpl.LANDLORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BILLINGIDANDLANDLORDID = new FinderPath(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybillingIdAndLandLordId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p o payments where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @return the matching p o payments
	 */
	@Override
	public List<POPayment> findBybillingIdAndLandLordId(long billingId,
		long landLordId) {
		return findBybillingIdAndLandLordId(billingId, landLordId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p o payments where billingId = &#63; and landLordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param start the lower bound of the range of p o payments
	 * @param end the upper bound of the range of p o payments (not inclusive)
	 * @return the range of matching p o payments
	 */
	@Override
	public List<POPayment> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end) {
		return findBybillingIdAndLandLordId(billingId, landLordId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the p o payments where billingId = &#63; and landLordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param start the lower bound of the range of p o payments
	 * @param end the upper bound of the range of p o payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p o payments
	 */
	@Override
	public List<POPayment> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end,
		OrderByComparator<POPayment> orderByComparator) {
		return findBybillingIdAndLandLordId(billingId, landLordId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the p o payments where billingId = &#63; and landLordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param start the lower bound of the range of p o payments
	 * @param end the upper bound of the range of p o payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching p o payments
	 */
	@Override
	public List<POPayment> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end,
		OrderByComparator<POPayment> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID;
			finderArgs = new Object[] { billingId, landLordId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID;
			finderArgs = new Object[] {
					billingId, landLordId,
					
					start, end, orderByComparator
				};
		}

		List<POPayment> list = null;

		if (retrieveFromCache) {
			list = (List<POPayment>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (POPayment poPayment : list) {
					if ((billingId != poPayment.getBillingId()) ||
							(landLordId != poPayment.getLandLordId())) {
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

			query.append(_SQL_SELECT_POPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_BILLINGIDANDLANDLORDID_BILLINGID_2);

			query.append(_FINDER_COLUMN_BILLINGIDANDLANDLORDID_LANDLORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(POPaymentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(billingId);

				qPos.add(landLordId);

				if (!pagination) {
					list = (List<POPayment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<POPayment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p o payment
	 * @throws NoSuchPOPaymentException if a matching p o payment could not be found
	 */
	@Override
	public POPayment findBybillingIdAndLandLordId_First(long billingId,
		long landLordId, OrderByComparator<POPayment> orderByComparator)
		throws NoSuchPOPaymentException {
		POPayment poPayment = fetchBybillingIdAndLandLordId_First(billingId,
				landLordId, orderByComparator);

		if (poPayment != null) {
			return poPayment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(", landLordId=");
		msg.append(landLordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPOPaymentException(msg.toString());
	}

	/**
	 * Returns the first p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p o payment, or <code>null</code> if a matching p o payment could not be found
	 */
	@Override
	public POPayment fetchBybillingIdAndLandLordId_First(long billingId,
		long landLordId, OrderByComparator<POPayment> orderByComparator) {
		List<POPayment> list = findBybillingIdAndLandLordId(billingId,
				landLordId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p o payment
	 * @throws NoSuchPOPaymentException if a matching p o payment could not be found
	 */
	@Override
	public POPayment findBybillingIdAndLandLordId_Last(long billingId,
		long landLordId, OrderByComparator<POPayment> orderByComparator)
		throws NoSuchPOPaymentException {
		POPayment poPayment = fetchBybillingIdAndLandLordId_Last(billingId,
				landLordId, orderByComparator);

		if (poPayment != null) {
			return poPayment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(", landLordId=");
		msg.append(landLordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPOPaymentException(msg.toString());
	}

	/**
	 * Returns the last p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p o payment, or <code>null</code> if a matching p o payment could not be found
	 */
	@Override
	public POPayment fetchBybillingIdAndLandLordId_Last(long billingId,
		long landLordId, OrderByComparator<POPayment> orderByComparator) {
		int count = countBybillingIdAndLandLordId(billingId, landLordId);

		if (count == 0) {
			return null;
		}

		List<POPayment> list = findBybillingIdAndLandLordId(billingId,
				landLordId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p o payments before and after the current p o payment in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param poPaymentId the primary key of the current p o payment
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p o payment
	 * @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	 */
	@Override
	public POPayment[] findBybillingIdAndLandLordId_PrevAndNext(
		long poPaymentId, long billingId, long landLordId,
		OrderByComparator<POPayment> orderByComparator)
		throws NoSuchPOPaymentException {
		POPayment poPayment = findByPrimaryKey(poPaymentId);

		Session session = null;

		try {
			session = openSession();

			POPayment[] array = new POPaymentImpl[3];

			array[0] = getBybillingIdAndLandLordId_PrevAndNext(session,
					poPayment, billingId, landLordId, orderByComparator, true);

			array[1] = poPayment;

			array[2] = getBybillingIdAndLandLordId_PrevAndNext(session,
					poPayment, billingId, landLordId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected POPayment getBybillingIdAndLandLordId_PrevAndNext(
		Session session, POPayment poPayment, long billingId, long landLordId,
		OrderByComparator<POPayment> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_POPAYMENT_WHERE);

		query.append(_FINDER_COLUMN_BILLINGIDANDLANDLORDID_BILLINGID_2);

		query.append(_FINDER_COLUMN_BILLINGIDANDLANDLORDID_LANDLORDID_2);

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
			query.append(POPaymentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(billingId);

		qPos.add(landLordId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(poPayment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<POPayment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p o payments where billingId = &#63; and landLordId = &#63; from the database.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 */
	@Override
	public void removeBybillingIdAndLandLordId(long billingId, long landLordId) {
		for (POPayment poPayment : findBybillingIdAndLandLordId(billingId,
				landLordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(poPayment);
		}
	}

	/**
	 * Returns the number of p o payments where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @return the number of matching p o payments
	 */
	@Override
	public int countBybillingIdAndLandLordId(long billingId, long landLordId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BILLINGIDANDLANDLORDID;

		Object[] finderArgs = new Object[] { billingId, landLordId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_POPAYMENT_WHERE);

			query.append(_FINDER_COLUMN_BILLINGIDANDLANDLORDID_BILLINGID_2);

			query.append(_FINDER_COLUMN_BILLINGIDANDLANDLORDID_LANDLORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(billingId);

				qPos.add(landLordId);

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

	private static final String _FINDER_COLUMN_BILLINGIDANDLANDLORDID_BILLINGID_2 =
		"poPayment.billingId = ? AND ";
	private static final String _FINDER_COLUMN_BILLINGIDANDLANDLORDID_LANDLORDID_2 =
		"poPayment.landLordId = ?";

	public POPaymentPersistenceImpl() {
		setModelClass(POPayment.class);
	}

	/**
	 * Caches the p o payment in the entity cache if it is enabled.
	 *
	 * @param poPayment the p o payment
	 */
	@Override
	public void cacheResult(POPayment poPayment) {
		entityCache.putResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentImpl.class, poPayment.getPrimaryKey(), poPayment);

		poPayment.resetOriginalValues();
	}

	/**
	 * Caches the p o payments in the entity cache if it is enabled.
	 *
	 * @param poPayments the p o payments
	 */
	@Override
	public void cacheResult(List<POPayment> poPayments) {
		for (POPayment poPayment : poPayments) {
			if (entityCache.getResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
						POPaymentImpl.class, poPayment.getPrimaryKey()) == null) {
				cacheResult(poPayment);
			}
			else {
				poPayment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p o payments.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(POPaymentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p o payment.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(POPayment poPayment) {
		entityCache.removeResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentImpl.class, poPayment.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<POPayment> poPayments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (POPayment poPayment : poPayments) {
			entityCache.removeResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
				POPaymentImpl.class, poPayment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new p o payment with the primary key. Does not add the p o payment to the database.
	 *
	 * @param poPaymentId the primary key for the new p o payment
	 * @return the new p o payment
	 */
	@Override
	public POPayment create(long poPaymentId) {
		POPayment poPayment = new POPaymentImpl();

		poPayment.setNew(true);
		poPayment.setPrimaryKey(poPaymentId);

		return poPayment;
	}

	/**
	 * Removes the p o payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param poPaymentId the primary key of the p o payment
	 * @return the p o payment that was removed
	 * @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	 */
	@Override
	public POPayment remove(long poPaymentId) throws NoSuchPOPaymentException {
		return remove((Serializable)poPaymentId);
	}

	/**
	 * Removes the p o payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p o payment
	 * @return the p o payment that was removed
	 * @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	 */
	@Override
	public POPayment remove(Serializable primaryKey)
		throws NoSuchPOPaymentException {
		Session session = null;

		try {
			session = openSession();

			POPayment poPayment = (POPayment)session.get(POPaymentImpl.class,
					primaryKey);

			if (poPayment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPOPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(poPayment);
		}
		catch (NoSuchPOPaymentException nsee) {
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
	protected POPayment removeImpl(POPayment poPayment) {
		poPayment = toUnwrappedModel(poPayment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(poPayment)) {
				poPayment = (POPayment)session.get(POPaymentImpl.class,
						poPayment.getPrimaryKeyObj());
			}

			if (poPayment != null) {
				session.delete(poPayment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (poPayment != null) {
			clearCache(poPayment);
		}

		return poPayment;
	}

	@Override
	public POPayment updateImpl(POPayment poPayment) {
		poPayment = toUnwrappedModel(poPayment);

		boolean isNew = poPayment.isNew();

		POPaymentModelImpl poPaymentModelImpl = (POPaymentModelImpl)poPayment;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (poPayment.getCreateDate() == null)) {
			if (serviceContext == null) {
				poPayment.setCreateDate(now);
			}
			else {
				poPayment.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!poPaymentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				poPayment.setModifiedDate(now);
			}
			else {
				poPayment.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (poPayment.isNew()) {
				session.save(poPayment);

				poPayment.setNew(false);
			}
			else {
				poPayment = (POPayment)session.merge(poPayment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !POPaymentModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((poPaymentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						poPaymentModelImpl.getOriginalBillingId(),
						poPaymentModelImpl.getOriginalLandLordId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGIDANDLANDLORDID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID,
					args);

				args = new Object[] {
						poPaymentModelImpl.getBillingId(),
						poPaymentModelImpl.getLandLordId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGIDANDLANDLORDID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID,
					args);
			}
		}

		entityCache.putResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
			POPaymentImpl.class, poPayment.getPrimaryKey(), poPayment, false);

		poPayment.resetOriginalValues();

		return poPayment;
	}

	protected POPayment toUnwrappedModel(POPayment poPayment) {
		if (poPayment instanceof POPaymentImpl) {
			return poPayment;
		}

		POPaymentImpl poPaymentImpl = new POPaymentImpl();

		poPaymentImpl.setNew(poPayment.isNew());
		poPaymentImpl.setPrimaryKey(poPayment.getPrimaryKey());

		poPaymentImpl.setPoPaymentId(poPayment.getPoPaymentId());
		poPaymentImpl.setBillingId(poPayment.getBillingId());
		poPaymentImpl.setLandLordId(poPayment.getLandLordId());
		poPaymentImpl.setAmount(poPayment.getAmount());
		poPaymentImpl.setGst(poPayment.getGst());
		poPaymentImpl.setChequeNo(poPayment.getChequeNo());
		poPaymentImpl.setPaymentDate(poPayment.getPaymentDate());
		poPaymentImpl.setCreateDate(poPayment.getCreateDate());
		poPaymentImpl.setCreatedBy(poPayment.getCreatedBy());
		poPaymentImpl.setModifiedDate(poPayment.getModifiedDate());
		poPaymentImpl.setModifiedBy(poPayment.getModifiedBy());

		return poPaymentImpl;
	}

	/**
	 * Returns the p o payment with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p o payment
	 * @return the p o payment
	 * @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	 */
	@Override
	public POPayment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPOPaymentException {
		POPayment poPayment = fetchByPrimaryKey(primaryKey);

		if (poPayment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPOPaymentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return poPayment;
	}

	/**
	 * Returns the p o payment with the primary key or throws a {@link NoSuchPOPaymentException} if it could not be found.
	 *
	 * @param poPaymentId the primary key of the p o payment
	 * @return the p o payment
	 * @throws NoSuchPOPaymentException if a p o payment with the primary key could not be found
	 */
	@Override
	public POPayment findByPrimaryKey(long poPaymentId)
		throws NoSuchPOPaymentException {
		return findByPrimaryKey((Serializable)poPaymentId);
	}

	/**
	 * Returns the p o payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p o payment
	 * @return the p o payment, or <code>null</code> if a p o payment with the primary key could not be found
	 */
	@Override
	public POPayment fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
				POPaymentImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		POPayment poPayment = (POPayment)serializable;

		if (poPayment == null) {
			Session session = null;

			try {
				session = openSession();

				poPayment = (POPayment)session.get(POPaymentImpl.class,
						primaryKey);

				if (poPayment != null) {
					cacheResult(poPayment);
				}
				else {
					entityCache.putResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
						POPaymentImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
					POPaymentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return poPayment;
	}

	/**
	 * Returns the p o payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param poPaymentId the primary key of the p o payment
	 * @return the p o payment, or <code>null</code> if a p o payment with the primary key could not be found
	 */
	@Override
	public POPayment fetchByPrimaryKey(long poPaymentId) {
		return fetchByPrimaryKey((Serializable)poPaymentId);
	}

	@Override
	public Map<Serializable, POPayment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, POPayment> map = new HashMap<Serializable, POPayment>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			POPayment poPayment = fetchByPrimaryKey(primaryKey);

			if (poPayment != null) {
				map.put(primaryKey, poPayment);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
					POPaymentImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (POPayment)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_POPAYMENT_WHERE_PKS_IN);

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

			for (POPayment poPayment : (List<POPayment>)q.list()) {
				map.put(poPayment.getPrimaryKeyObj(), poPayment);

				cacheResult(poPayment);

				uncachedPrimaryKeys.remove(poPayment.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(POPaymentModelImpl.ENTITY_CACHE_ENABLED,
					POPaymentImpl.class, primaryKey, nullModel);
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
	 * Returns all the p o payments.
	 *
	 * @return the p o payments
	 */
	@Override
	public List<POPayment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p o payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p o payments
	 * @param end the upper bound of the range of p o payments (not inclusive)
	 * @return the range of p o payments
	 */
	@Override
	public List<POPayment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p o payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p o payments
	 * @param end the upper bound of the range of p o payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p o payments
	 */
	@Override
	public List<POPayment> findAll(int start, int end,
		OrderByComparator<POPayment> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the p o payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link POPaymentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p o payments
	 * @param end the upper bound of the range of p o payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of p o payments
	 */
	@Override
	public List<POPayment> findAll(int start, int end,
		OrderByComparator<POPayment> orderByComparator,
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

		List<POPayment> list = null;

		if (retrieveFromCache) {
			list = (List<POPayment>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_POPAYMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POPAYMENT;

				if (pagination) {
					sql = sql.concat(POPaymentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<POPayment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<POPayment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the p o payments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (POPayment poPayment : findAll()) {
			remove(poPayment);
		}
	}

	/**
	 * Returns the number of p o payments.
	 *
	 * @return the number of p o payments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_POPAYMENT);

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
		return POPaymentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the p o payment persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(POPaymentImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_POPAYMENT = "SELECT poPayment FROM POPayment poPayment";
	private static final String _SQL_SELECT_POPAYMENT_WHERE_PKS_IN = "SELECT poPayment FROM POPayment poPayment WHERE poPaymentId IN (";
	private static final String _SQL_SELECT_POPAYMENT_WHERE = "SELECT poPayment FROM POPayment poPayment WHERE ";
	private static final String _SQL_COUNT_POPAYMENT = "SELECT COUNT(poPayment) FROM POPayment poPayment";
	private static final String _SQL_COUNT_POPAYMENT_WHERE = "SELECT COUNT(poPayment) FROM POPayment poPayment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "poPayment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No POPayment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No POPayment exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(POPaymentPersistenceImpl.class);
}