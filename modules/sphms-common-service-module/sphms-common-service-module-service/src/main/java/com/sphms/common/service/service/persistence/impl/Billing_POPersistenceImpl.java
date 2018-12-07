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

import com.sphms.common.service.exception.NoSuchBilling_POException;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.impl.Billing_POImpl;
import com.sphms.common.service.model.impl.Billing_POModelImpl;
import com.sphms.common.service.service.persistence.Billing_POPK;
import com.sphms.common.service.service.persistence.Billing_POPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the billing_ p o service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_POPersistence
 * @see com.sphms.common.service.service.persistence.Billing_POUtil
 * @generated
 */
@ProviderType
public class Billing_POPersistenceImpl extends BasePersistenceImpl<Billing_PO>
	implements Billing_POPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Billing_POUtil} to access the billing_ p o persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Billing_POImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Billing_POImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Billing_POImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BILLINGID =
		new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Billing_POImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybillingId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID =
		new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Billing_POImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybillingId",
			new String[] { Long.class.getName() },
			Billing_POModelImpl.BILLINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BILLINGID = new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybillingId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the billing_ p os where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @return the matching billing_ p os
	 */
	@Override
	public List<Billing_PO> findBybillingId(long billingId) {
		return findBybillingId(billingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the billing_ p os where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @return the range of matching billing_ p os
	 */
	@Override
	public List<Billing_PO> findBybillingId(long billingId, int start, int end) {
		return findBybillingId(billingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the billing_ p os where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching billing_ p os
	 */
	@Override
	public List<Billing_PO> findBybillingId(long billingId, int start, int end,
		OrderByComparator<Billing_PO> orderByComparator) {
		return findBybillingId(billingId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billing_ p os where billingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching billing_ p os
	 */
	@Override
	public List<Billing_PO> findBybillingId(long billingId, int start, int end,
		OrderByComparator<Billing_PO> orderByComparator,
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

		List<Billing_PO> list = null;

		if (retrieveFromCache) {
			list = (List<Billing_PO>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Billing_PO billing_PO : list) {
					if ((billingId != billing_PO.getBillingId())) {
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

			query.append(_SQL_SELECT_BILLING_PO_WHERE);

			query.append(_FINDER_COLUMN_BILLINGID_BILLINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Billing_POModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(billingId);

				if (!pagination) {
					list = (List<Billing_PO>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Billing_PO>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first billing_ p o in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billing_ p o
	 * @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	 */
	@Override
	public Billing_PO findBybillingId_First(long billingId,
		OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException {
		Billing_PO billing_PO = fetchBybillingId_First(billingId,
				orderByComparator);

		if (billing_PO != null) {
			return billing_PO;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBilling_POException(msg.toString());
	}

	/**
	 * Returns the first billing_ p o in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	 */
	@Override
	public Billing_PO fetchBybillingId_First(long billingId,
		OrderByComparator<Billing_PO> orderByComparator) {
		List<Billing_PO> list = findBybillingId(billingId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last billing_ p o in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billing_ p o
	 * @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	 */
	@Override
	public Billing_PO findBybillingId_Last(long billingId,
		OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException {
		Billing_PO billing_PO = fetchBybillingId_Last(billingId,
				orderByComparator);

		if (billing_PO != null) {
			return billing_PO;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBilling_POException(msg.toString());
	}

	/**
	 * Returns the last billing_ p o in the ordered set where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	 */
	@Override
	public Billing_PO fetchBybillingId_Last(long billingId,
		OrderByComparator<Billing_PO> orderByComparator) {
		int count = countBybillingId(billingId);

		if (count == 0) {
			return null;
		}

		List<Billing_PO> list = findBybillingId(billingId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the billing_ p os before and after the current billing_ p o in the ordered set where billingId = &#63;.
	 *
	 * @param billing_POPK the primary key of the current billing_ p o
	 * @param billingId the billing ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next billing_ p o
	 * @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	 */
	@Override
	public Billing_PO[] findBybillingId_PrevAndNext(Billing_POPK billing_POPK,
		long billingId, OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException {
		Billing_PO billing_PO = findByPrimaryKey(billing_POPK);

		Session session = null;

		try {
			session = openSession();

			Billing_PO[] array = new Billing_POImpl[3];

			array[0] = getBybillingId_PrevAndNext(session, billing_PO,
					billingId, orderByComparator, true);

			array[1] = billing_PO;

			array[2] = getBybillingId_PrevAndNext(session, billing_PO,
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

	protected Billing_PO getBybillingId_PrevAndNext(Session session,
		Billing_PO billing_PO, long billingId,
		OrderByComparator<Billing_PO> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BILLING_PO_WHERE);

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
			query.append(Billing_POModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(billingId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(billing_PO);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Billing_PO> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the billing_ p os where billingId = &#63; from the database.
	 *
	 * @param billingId the billing ID
	 */
	@Override
	public void removeBybillingId(long billingId) {
		for (Billing_PO billing_PO : findBybillingId(billingId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(billing_PO);
		}
	}

	/**
	 * Returns the number of billing_ p os where billingId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @return the number of matching billing_ p os
	 */
	@Override
	public int countBybillingId(long billingId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BILLINGID;

		Object[] finderArgs = new Object[] { billingId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BILLING_PO_WHERE);

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

	private static final String _FINDER_COLUMN_BILLINGID_BILLINGID_2 = "billing_PO.id.billingId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID =
		new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Billing_POImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybillingIdAndLandLordId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID =
		new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Billing_POImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybillingIdAndLandLordId",
			new String[] { Long.class.getName(), Long.class.getName() },
			Billing_POModelImpl.BILLINGID_COLUMN_BITMASK |
			Billing_POModelImpl.LANDLORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BILLINGIDANDLANDLORDID = new FinderPath(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybillingIdAndLandLordId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @return the matching billing_ p os
	 */
	@Override
	public List<Billing_PO> findBybillingIdAndLandLordId(long billingId,
		long landLordId) {
		return findBybillingIdAndLandLordId(billingId, landLordId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @return the range of matching billing_ p os
	 */
	@Override
	public List<Billing_PO> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end) {
		return findBybillingIdAndLandLordId(billingId, landLordId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching billing_ p os
	 */
	@Override
	public List<Billing_PO> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end,
		OrderByComparator<Billing_PO> orderByComparator) {
		return findBybillingIdAndLandLordId(billingId, landLordId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billing_ p os where billingId = &#63; and landLordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching billing_ p os
	 */
	@Override
	public List<Billing_PO> findBybillingIdAndLandLordId(long billingId,
		long landLordId, int start, int end,
		OrderByComparator<Billing_PO> orderByComparator,
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

		List<Billing_PO> list = null;

		if (retrieveFromCache) {
			list = (List<Billing_PO>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Billing_PO billing_PO : list) {
					if ((billingId != billing_PO.getBillingId()) ||
							(landLordId != billing_PO.getLandLordId())) {
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

			query.append(_SQL_SELECT_BILLING_PO_WHERE);

			query.append(_FINDER_COLUMN_BILLINGIDANDLANDLORDID_BILLINGID_2);

			query.append(_FINDER_COLUMN_BILLINGIDANDLANDLORDID_LANDLORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Billing_POModelImpl.ORDER_BY_JPQL);
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
					list = (List<Billing_PO>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Billing_PO>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billing_ p o
	 * @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	 */
	@Override
	public Billing_PO findBybillingIdAndLandLordId_First(long billingId,
		long landLordId, OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException {
		Billing_PO billing_PO = fetchBybillingIdAndLandLordId_First(billingId,
				landLordId, orderByComparator);

		if (billing_PO != null) {
			return billing_PO;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(", landLordId=");
		msg.append(landLordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBilling_POException(msg.toString());
	}

	/**
	 * Returns the first billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	 */
	@Override
	public Billing_PO fetchBybillingIdAndLandLordId_First(long billingId,
		long landLordId, OrderByComparator<Billing_PO> orderByComparator) {
		List<Billing_PO> list = findBybillingIdAndLandLordId(billingId,
				landLordId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billing_ p o
	 * @throws NoSuchBilling_POException if a matching billing_ p o could not be found
	 */
	@Override
	public Billing_PO findBybillingIdAndLandLordId_Last(long billingId,
		long landLordId, OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException {
		Billing_PO billing_PO = fetchBybillingIdAndLandLordId_Last(billingId,
				landLordId, orderByComparator);

		if (billing_PO != null) {
			return billing_PO;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("billingId=");
		msg.append(billingId);

		msg.append(", landLordId=");
		msg.append(landLordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBilling_POException(msg.toString());
	}

	/**
	 * Returns the last billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billing_ p o, or <code>null</code> if a matching billing_ p o could not be found
	 */
	@Override
	public Billing_PO fetchBybillingIdAndLandLordId_Last(long billingId,
		long landLordId, OrderByComparator<Billing_PO> orderByComparator) {
		int count = countBybillingIdAndLandLordId(billingId, landLordId);

		if (count == 0) {
			return null;
		}

		List<Billing_PO> list = findBybillingIdAndLandLordId(billingId,
				landLordId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the billing_ p os before and after the current billing_ p o in the ordered set where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billing_POPK the primary key of the current billing_ p o
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next billing_ p o
	 * @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	 */
	@Override
	public Billing_PO[] findBybillingIdAndLandLordId_PrevAndNext(
		Billing_POPK billing_POPK, long billingId, long landLordId,
		OrderByComparator<Billing_PO> orderByComparator)
		throws NoSuchBilling_POException {
		Billing_PO billing_PO = findByPrimaryKey(billing_POPK);

		Session session = null;

		try {
			session = openSession();

			Billing_PO[] array = new Billing_POImpl[3];

			array[0] = getBybillingIdAndLandLordId_PrevAndNext(session,
					billing_PO, billingId, landLordId, orderByComparator, true);

			array[1] = billing_PO;

			array[2] = getBybillingIdAndLandLordId_PrevAndNext(session,
					billing_PO, billingId, landLordId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Billing_PO getBybillingIdAndLandLordId_PrevAndNext(
		Session session, Billing_PO billing_PO, long billingId,
		long landLordId, OrderByComparator<Billing_PO> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_BILLING_PO_WHERE);

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
			query.append(Billing_POModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(billingId);

		qPos.add(landLordId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(billing_PO);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Billing_PO> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the billing_ p os where billingId = &#63; and landLordId = &#63; from the database.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 */
	@Override
	public void removeBybillingIdAndLandLordId(long billingId, long landLordId) {
		for (Billing_PO billing_PO : findBybillingIdAndLandLordId(billingId,
				landLordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(billing_PO);
		}
	}

	/**
	 * Returns the number of billing_ p os where billingId = &#63; and landLordId = &#63;.
	 *
	 * @param billingId the billing ID
	 * @param landLordId the land lord ID
	 * @return the number of matching billing_ p os
	 */
	@Override
	public int countBybillingIdAndLandLordId(long billingId, long landLordId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BILLINGIDANDLANDLORDID;

		Object[] finderArgs = new Object[] { billingId, landLordId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BILLING_PO_WHERE);

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
		"billing_PO.id.billingId = ? AND ";
	private static final String _FINDER_COLUMN_BILLINGIDANDLANDLORDID_LANDLORDID_2 =
		"billing_PO.landLordId = ?";

	public Billing_POPersistenceImpl() {
		setModelClass(Billing_PO.class);
	}

	/**
	 * Caches the billing_ p o in the entity cache if it is enabled.
	 *
	 * @param billing_PO the billing_ p o
	 */
	@Override
	public void cacheResult(Billing_PO billing_PO) {
		entityCache.putResult(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POImpl.class, billing_PO.getPrimaryKey(), billing_PO);

		billing_PO.resetOriginalValues();
	}

	/**
	 * Caches the billing_ p os in the entity cache if it is enabled.
	 *
	 * @param billing_POs the billing_ p os
	 */
	@Override
	public void cacheResult(List<Billing_PO> billing_POs) {
		for (Billing_PO billing_PO : billing_POs) {
			if (entityCache.getResult(
						Billing_POModelImpl.ENTITY_CACHE_ENABLED,
						Billing_POImpl.class, billing_PO.getPrimaryKey()) == null) {
				cacheResult(billing_PO);
			}
			else {
				billing_PO.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all billing_ p os.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Billing_POImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the billing_ p o.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Billing_PO billing_PO) {
		entityCache.removeResult(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POImpl.class, billing_PO.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Billing_PO> billing_POs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Billing_PO billing_PO : billing_POs) {
			entityCache.removeResult(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
				Billing_POImpl.class, billing_PO.getPrimaryKey());
		}
	}

	/**
	 * Creates a new billing_ p o with the primary key. Does not add the billing_ p o to the database.
	 *
	 * @param billing_POPK the primary key for the new billing_ p o
	 * @return the new billing_ p o
	 */
	@Override
	public Billing_PO create(Billing_POPK billing_POPK) {
		Billing_PO billing_PO = new Billing_POImpl();

		billing_PO.setNew(true);
		billing_PO.setPrimaryKey(billing_POPK);

		return billing_PO;
	}

	/**
	 * Removes the billing_ p o with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param billing_POPK the primary key of the billing_ p o
	 * @return the billing_ p o that was removed
	 * @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	 */
	@Override
	public Billing_PO remove(Billing_POPK billing_POPK)
		throws NoSuchBilling_POException {
		return remove((Serializable)billing_POPK);
	}

	/**
	 * Removes the billing_ p o with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the billing_ p o
	 * @return the billing_ p o that was removed
	 * @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	 */
	@Override
	public Billing_PO remove(Serializable primaryKey)
		throws NoSuchBilling_POException {
		Session session = null;

		try {
			session = openSession();

			Billing_PO billing_PO = (Billing_PO)session.get(Billing_POImpl.class,
					primaryKey);

			if (billing_PO == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBilling_POException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(billing_PO);
		}
		catch (NoSuchBilling_POException nsee) {
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
	protected Billing_PO removeImpl(Billing_PO billing_PO) {
		billing_PO = toUnwrappedModel(billing_PO);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(billing_PO)) {
				billing_PO = (Billing_PO)session.get(Billing_POImpl.class,
						billing_PO.getPrimaryKeyObj());
			}

			if (billing_PO != null) {
				session.delete(billing_PO);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (billing_PO != null) {
			clearCache(billing_PO);
		}

		return billing_PO;
	}

	@Override
	public Billing_PO updateImpl(Billing_PO billing_PO) {
		billing_PO = toUnwrappedModel(billing_PO);

		boolean isNew = billing_PO.isNew();

		Billing_POModelImpl billing_POModelImpl = (Billing_POModelImpl)billing_PO;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (billing_PO.getCreateDate() == null)) {
			if (serviceContext == null) {
				billing_PO.setCreateDate(now);
			}
			else {
				billing_PO.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!billing_POModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				billing_PO.setModifiedDate(now);
			}
			else {
				billing_PO.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (billing_PO.isNew()) {
				session.save(billing_PO);

				billing_PO.setNew(false);
			}
			else {
				billing_PO = (Billing_PO)session.merge(billing_PO);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !Billing_POModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((billing_POModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						billing_POModelImpl.getOriginalBillingId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID,
					args);

				args = new Object[] { billing_POModelImpl.getBillingId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGID,
					args);
			}

			if ((billing_POModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						billing_POModelImpl.getOriginalBillingId(),
						billing_POModelImpl.getOriginalLandLordId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGIDANDLANDLORDID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID,
					args);

				args = new Object[] {
						billing_POModelImpl.getBillingId(),
						billing_POModelImpl.getLandLordId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BILLINGIDANDLANDLORDID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BILLINGIDANDLANDLORDID,
					args);
			}
		}

		entityCache.putResult(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
			Billing_POImpl.class, billing_PO.getPrimaryKey(), billing_PO, false);

		billing_PO.resetOriginalValues();

		return billing_PO;
	}

	protected Billing_PO toUnwrappedModel(Billing_PO billing_PO) {
		if (billing_PO instanceof Billing_POImpl) {
			return billing_PO;
		}

		Billing_POImpl billing_POImpl = new Billing_POImpl();

		billing_POImpl.setNew(billing_PO.isNew());
		billing_POImpl.setPrimaryKey(billing_PO.getPrimaryKey());

		billing_POImpl.setBillingId(billing_PO.getBillingId());
		billing_POImpl.setHordingId(billing_PO.getHordingId());
		billing_POImpl.setLandLordId(billing_PO.getLandLordId());
		billing_POImpl.setSupplierBillNo(billing_PO.getSupplierBillNo());
		billing_POImpl.setSupplierBillDate(billing_PO.getSupplierBillDate());
		billing_POImpl.setSupplierTotalAmount(billing_PO.getSupplierTotalAmount());
		billing_POImpl.setSupplierGstAmmount(billing_PO.getSupplierGstAmmount());
		billing_POImpl.setPoNumber(billing_PO.getPoNumber());
		billing_POImpl.setInternalPONumber(billing_PO.getInternalPONumber());
		billing_POImpl.setFinancialYear(billing_PO.getFinancialYear());
		billing_POImpl.setTotalAmount(billing_PO.getTotalAmount());
		billing_POImpl.setCustomCompanyId(billing_PO.getCustomCompanyId());
		billing_POImpl.setPaymentGiven(billing_PO.getPaymentGiven());
		billing_POImpl.setPublishDate(billing_PO.getPublishDate());
		billing_POImpl.setCreateDate(billing_PO.getCreateDate());
		billing_POImpl.setCreatedBy(billing_PO.getCreatedBy());
		billing_POImpl.setModifiedDate(billing_PO.getModifiedDate());
		billing_POImpl.setModifiedBy(billing_PO.getModifiedBy());
		billing_POImpl.setStatus(billing_PO.getStatus());

		return billing_POImpl;
	}

	/**
	 * Returns the billing_ p o with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing_ p o
	 * @return the billing_ p o
	 * @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	 */
	@Override
	public Billing_PO findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBilling_POException {
		Billing_PO billing_PO = fetchByPrimaryKey(primaryKey);

		if (billing_PO == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBilling_POException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return billing_PO;
	}

	/**
	 * Returns the billing_ p o with the primary key or throws a {@link NoSuchBilling_POException} if it could not be found.
	 *
	 * @param billing_POPK the primary key of the billing_ p o
	 * @return the billing_ p o
	 * @throws NoSuchBilling_POException if a billing_ p o with the primary key could not be found
	 */
	@Override
	public Billing_PO findByPrimaryKey(Billing_POPK billing_POPK)
		throws NoSuchBilling_POException {
		return findByPrimaryKey((Serializable)billing_POPK);
	}

	/**
	 * Returns the billing_ p o with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the billing_ p o
	 * @return the billing_ p o, or <code>null</code> if a billing_ p o with the primary key could not be found
	 */
	@Override
	public Billing_PO fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
				Billing_POImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Billing_PO billing_PO = (Billing_PO)serializable;

		if (billing_PO == null) {
			Session session = null;

			try {
				session = openSession();

				billing_PO = (Billing_PO)session.get(Billing_POImpl.class,
						primaryKey);

				if (billing_PO != null) {
					cacheResult(billing_PO);
				}
				else {
					entityCache.putResult(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
						Billing_POImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Billing_POModelImpl.ENTITY_CACHE_ENABLED,
					Billing_POImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return billing_PO;
	}

	/**
	 * Returns the billing_ p o with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param billing_POPK the primary key of the billing_ p o
	 * @return the billing_ p o, or <code>null</code> if a billing_ p o with the primary key could not be found
	 */
	@Override
	public Billing_PO fetchByPrimaryKey(Billing_POPK billing_POPK) {
		return fetchByPrimaryKey((Serializable)billing_POPK);
	}

	@Override
	public Map<Serializable, Billing_PO> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Billing_PO> map = new HashMap<Serializable, Billing_PO>();

		for (Serializable primaryKey : primaryKeys) {
			Billing_PO billing_PO = fetchByPrimaryKey(primaryKey);

			if (billing_PO != null) {
				map.put(primaryKey, billing_PO);
			}
		}

		return map;
	}

	/**
	 * Returns all the billing_ p os.
	 *
	 * @return the billing_ p os
	 */
	@Override
	public List<Billing_PO> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the billing_ p os.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @return the range of billing_ p os
	 */
	@Override
	public List<Billing_PO> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the billing_ p os.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of billing_ p os
	 */
	@Override
	public List<Billing_PO> findAll(int start, int end,
		OrderByComparator<Billing_PO> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the billing_ p os.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Billing_POModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing_ p os
	 * @param end the upper bound of the range of billing_ p os (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of billing_ p os
	 */
	@Override
	public List<Billing_PO> findAll(int start, int end,
		OrderByComparator<Billing_PO> orderByComparator,
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

		List<Billing_PO> list = null;

		if (retrieveFromCache) {
			list = (List<Billing_PO>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BILLING_PO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BILLING_PO;

				if (pagination) {
					sql = sql.concat(Billing_POModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Billing_PO>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Billing_PO>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the billing_ p os from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Billing_PO billing_PO : findAll()) {
			remove(billing_PO);
		}
	}

	/**
	 * Returns the number of billing_ p os.
	 *
	 * @return the number of billing_ p os
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BILLING_PO);

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
		return Billing_POModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the billing_ p o persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Billing_POImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BILLING_PO = "SELECT billing_PO FROM Billing_PO billing_PO";
	private static final String _SQL_SELECT_BILLING_PO_WHERE = "SELECT billing_PO FROM Billing_PO billing_PO WHERE ";
	private static final String _SQL_COUNT_BILLING_PO = "SELECT COUNT(billing_PO) FROM Billing_PO billing_PO";
	private static final String _SQL_COUNT_BILLING_PO_WHERE = "SELECT COUNT(billing_PO) FROM Billing_PO billing_PO WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "billing_PO.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Billing_PO exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Billing_PO exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Billing_POPersistenceImpl.class);
}