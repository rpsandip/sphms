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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchSupplierException;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.model.impl.SupplierImpl;
import com.sphms.common.service.model.impl.SupplierModelImpl;
import com.sphms.common.service.service.persistence.SupplierPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the supplier service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplierPersistence
 * @see com.sphms.common.service.service.persistence.SupplierUtil
 * @generated
 */
@ProviderType
public class SupplierPersistenceImpl extends BasePersistenceImpl<Supplier>
	implements SupplierPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SupplierUtil} to access the supplier persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SupplierImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierModelImpl.FINDER_CACHE_ENABLED, SupplierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierModelImpl.FINDER_CACHE_ENABLED, SupplierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierModelImpl.FINDER_CACHE_ENABLED, SupplierImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierModelImpl.FINDER_CACHE_ENABLED, SupplierImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Integer.class.getName() },
			SupplierModelImpl.STATUS_COLUMN_BITMASK |
			SupplierModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the suppliers where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching suppliers
	 */
	@Override
	public List<Supplier> findBystatus(int status) {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the suppliers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of suppliers
	 * @param end the upper bound of the range of suppliers (not inclusive)
	 * @return the range of matching suppliers
	 */
	@Override
	public List<Supplier> findBystatus(int status, int start, int end) {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the suppliers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of suppliers
	 * @param end the upper bound of the range of suppliers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching suppliers
	 */
	@Override
	public List<Supplier> findBystatus(int status, int start, int end,
		OrderByComparator<Supplier> orderByComparator) {
		return findBystatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the suppliers where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of suppliers
	 * @param end the upper bound of the range of suppliers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching suppliers
	 */
	@Override
	public List<Supplier> findBystatus(int status, int start, int end,
		OrderByComparator<Supplier> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<Supplier> list = null;

		if (retrieveFromCache) {
			list = (List<Supplier>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Supplier supplier : list) {
					if ((status != supplier.getStatus())) {
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

			query.append(_SQL_SELECT_SUPPLIER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SupplierModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<Supplier>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Supplier>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first supplier in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supplier
	 * @throws NoSuchSupplierException if a matching supplier could not be found
	 */
	@Override
	public Supplier findBystatus_First(int status,
		OrderByComparator<Supplier> orderByComparator)
		throws NoSuchSupplierException {
		Supplier supplier = fetchBystatus_First(status, orderByComparator);

		if (supplier != null) {
			return supplier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplierException(msg.toString());
	}

	/**
	 * Returns the first supplier in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supplier, or <code>null</code> if a matching supplier could not be found
	 */
	@Override
	public Supplier fetchBystatus_First(int status,
		OrderByComparator<Supplier> orderByComparator) {
		List<Supplier> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last supplier in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supplier
	 * @throws NoSuchSupplierException if a matching supplier could not be found
	 */
	@Override
	public Supplier findBystatus_Last(int status,
		OrderByComparator<Supplier> orderByComparator)
		throws NoSuchSupplierException {
		Supplier supplier = fetchBystatus_Last(status, orderByComparator);

		if (supplier != null) {
			return supplier;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplierException(msg.toString());
	}

	/**
	 * Returns the last supplier in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supplier, or <code>null</code> if a matching supplier could not be found
	 */
	@Override
	public Supplier fetchBystatus_Last(int status,
		OrderByComparator<Supplier> orderByComparator) {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<Supplier> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the suppliers before and after the current supplier in the ordered set where status = &#63;.
	 *
	 * @param supplierId the primary key of the current supplier
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next supplier
	 * @throws NoSuchSupplierException if a supplier with the primary key could not be found
	 */
	@Override
	public Supplier[] findBystatus_PrevAndNext(long supplierId, int status,
		OrderByComparator<Supplier> orderByComparator)
		throws NoSuchSupplierException {
		Supplier supplier = findByPrimaryKey(supplierId);

		Session session = null;

		try {
			session = openSession();

			Supplier[] array = new SupplierImpl[3];

			array[0] = getBystatus_PrevAndNext(session, supplier, status,
					orderByComparator, true);

			array[1] = supplier;

			array[2] = getBystatus_PrevAndNext(session, supplier, status,
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

	protected Supplier getBystatus_PrevAndNext(Session session,
		Supplier supplier, int status,
		OrderByComparator<Supplier> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPLIER_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(SupplierModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(supplier);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Supplier> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the suppliers where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBystatus(int status) {
		for (Supplier supplier : findBystatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(supplier);
		}
	}

	/**
	 * Returns the number of suppliers where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching suppliers
	 */
	@Override
	public int countBystatus(int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPLIER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "supplier.status = ?";

	public SupplierPersistenceImpl() {
		setModelClass(Supplier.class);
	}

	/**
	 * Caches the supplier in the entity cache if it is enabled.
	 *
	 * @param supplier the supplier
	 */
	@Override
	public void cacheResult(Supplier supplier) {
		entityCache.putResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierImpl.class, supplier.getPrimaryKey(), supplier);

		supplier.resetOriginalValues();
	}

	/**
	 * Caches the suppliers in the entity cache if it is enabled.
	 *
	 * @param suppliers the suppliers
	 */
	@Override
	public void cacheResult(List<Supplier> suppliers) {
		for (Supplier supplier : suppliers) {
			if (entityCache.getResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
						SupplierImpl.class, supplier.getPrimaryKey()) == null) {
				cacheResult(supplier);
			}
			else {
				supplier.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all suppliers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SupplierImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the supplier.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Supplier supplier) {
		entityCache.removeResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierImpl.class, supplier.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Supplier> suppliers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Supplier supplier : suppliers) {
			entityCache.removeResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
				SupplierImpl.class, supplier.getPrimaryKey());
		}
	}

	/**
	 * Creates a new supplier with the primary key. Does not add the supplier to the database.
	 *
	 * @param supplierId the primary key for the new supplier
	 * @return the new supplier
	 */
	@Override
	public Supplier create(long supplierId) {
		Supplier supplier = new SupplierImpl();

		supplier.setNew(true);
		supplier.setPrimaryKey(supplierId);

		return supplier;
	}

	/**
	 * Removes the supplier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supplierId the primary key of the supplier
	 * @return the supplier that was removed
	 * @throws NoSuchSupplierException if a supplier with the primary key could not be found
	 */
	@Override
	public Supplier remove(long supplierId) throws NoSuchSupplierException {
		return remove((Serializable)supplierId);
	}

	/**
	 * Removes the supplier with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the supplier
	 * @return the supplier that was removed
	 * @throws NoSuchSupplierException if a supplier with the primary key could not be found
	 */
	@Override
	public Supplier remove(Serializable primaryKey)
		throws NoSuchSupplierException {
		Session session = null;

		try {
			session = openSession();

			Supplier supplier = (Supplier)session.get(SupplierImpl.class,
					primaryKey);

			if (supplier == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupplierException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(supplier);
		}
		catch (NoSuchSupplierException nsee) {
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
	protected Supplier removeImpl(Supplier supplier) {
		supplier = toUnwrappedModel(supplier);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supplier)) {
				supplier = (Supplier)session.get(SupplierImpl.class,
						supplier.getPrimaryKeyObj());
			}

			if (supplier != null) {
				session.delete(supplier);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supplier != null) {
			clearCache(supplier);
		}

		return supplier;
	}

	@Override
	public Supplier updateImpl(Supplier supplier) {
		supplier = toUnwrappedModel(supplier);

		boolean isNew = supplier.isNew();

		SupplierModelImpl supplierModelImpl = (SupplierModelImpl)supplier;

		Session session = null;

		try {
			session = openSession();

			if (supplier.isNew()) {
				session.save(supplier);

				supplier.setNew(false);
			}
			else {
				supplier = (Supplier)session.merge(supplier);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SupplierModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((supplierModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						supplierModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { supplierModelImpl.getStatus() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
			SupplierImpl.class, supplier.getPrimaryKey(), supplier, false);

		supplier.resetOriginalValues();

		return supplier;
	}

	protected Supplier toUnwrappedModel(Supplier supplier) {
		if (supplier instanceof SupplierImpl) {
			return supplier;
		}

		SupplierImpl supplierImpl = new SupplierImpl();

		supplierImpl.setNew(supplier.isNew());
		supplierImpl.setPrimaryKey(supplier.getPrimaryKey());

		supplierImpl.setSupplierId(supplier.getSupplierId());
		supplierImpl.setSupplierName(supplier.getSupplierName());
		supplierImpl.setAddress1(supplier.getAddress1());
		supplierImpl.setAddress2(supplier.getAddress2());
		supplierImpl.setCity(supplier.getCity());
		supplierImpl.setPanNo(supplier.getPanNo());
		supplierImpl.setGstNo(supplier.getGstNo());
		supplierImpl.setState(supplier.getState());
		supplierImpl.setStatus(supplier.getStatus());
		supplierImpl.setContactPersonName(supplier.getContactPersonName());
		supplierImpl.setContactPersonEmail(supplier.getContactPersonEmail());
		supplierImpl.setContactPersonPhoneNo(supplier.getContactPersonPhoneNo());
		supplierImpl.setCreateDate(supplier.getCreateDate());
		supplierImpl.setCreatedBy(supplier.getCreatedBy());

		return supplierImpl;
	}

	/**
	 * Returns the supplier with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the supplier
	 * @return the supplier
	 * @throws NoSuchSupplierException if a supplier with the primary key could not be found
	 */
	@Override
	public Supplier findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupplierException {
		Supplier supplier = fetchByPrimaryKey(primaryKey);

		if (supplier == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupplierException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return supplier;
	}

	/**
	 * Returns the supplier with the primary key or throws a {@link NoSuchSupplierException} if it could not be found.
	 *
	 * @param supplierId the primary key of the supplier
	 * @return the supplier
	 * @throws NoSuchSupplierException if a supplier with the primary key could not be found
	 */
	@Override
	public Supplier findByPrimaryKey(long supplierId)
		throws NoSuchSupplierException {
		return findByPrimaryKey((Serializable)supplierId);
	}

	/**
	 * Returns the supplier with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the supplier
	 * @return the supplier, or <code>null</code> if a supplier with the primary key could not be found
	 */
	@Override
	public Supplier fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
				SupplierImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Supplier supplier = (Supplier)serializable;

		if (supplier == null) {
			Session session = null;

			try {
				session = openSession();

				supplier = (Supplier)session.get(SupplierImpl.class, primaryKey);

				if (supplier != null) {
					cacheResult(supplier);
				}
				else {
					entityCache.putResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
						SupplierImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
					SupplierImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return supplier;
	}

	/**
	 * Returns the supplier with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supplierId the primary key of the supplier
	 * @return the supplier, or <code>null</code> if a supplier with the primary key could not be found
	 */
	@Override
	public Supplier fetchByPrimaryKey(long supplierId) {
		return fetchByPrimaryKey((Serializable)supplierId);
	}

	@Override
	public Map<Serializable, Supplier> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Supplier> map = new HashMap<Serializable, Supplier>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Supplier supplier = fetchByPrimaryKey(primaryKey);

			if (supplier != null) {
				map.put(primaryKey, supplier);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
					SupplierImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Supplier)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SUPPLIER_WHERE_PKS_IN);

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

			for (Supplier supplier : (List<Supplier>)q.list()) {
				map.put(supplier.getPrimaryKeyObj(), supplier);

				cacheResult(supplier);

				uncachedPrimaryKeys.remove(supplier.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SupplierModelImpl.ENTITY_CACHE_ENABLED,
					SupplierImpl.class, primaryKey, nullModel);
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
	 * Returns all the suppliers.
	 *
	 * @return the suppliers
	 */
	@Override
	public List<Supplier> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the suppliers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of suppliers
	 * @param end the upper bound of the range of suppliers (not inclusive)
	 * @return the range of suppliers
	 */
	@Override
	public List<Supplier> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the suppliers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of suppliers
	 * @param end the upper bound of the range of suppliers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of suppliers
	 */
	@Override
	public List<Supplier> findAll(int start, int end,
		OrderByComparator<Supplier> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the suppliers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SupplierModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of suppliers
	 * @param end the upper bound of the range of suppliers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of suppliers
	 */
	@Override
	public List<Supplier> findAll(int start, int end,
		OrderByComparator<Supplier> orderByComparator, boolean retrieveFromCache) {
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

		List<Supplier> list = null;

		if (retrieveFromCache) {
			list = (List<Supplier>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUPPLIER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPLIER;

				if (pagination) {
					sql = sql.concat(SupplierModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Supplier>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Supplier>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the suppliers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Supplier supplier : findAll()) {
			remove(supplier);
		}
	}

	/**
	 * Returns the number of suppliers.
	 *
	 * @return the number of suppliers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUPPLIER);

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
		return SupplierModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the supplier persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SupplierImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SUPPLIER = "SELECT supplier FROM Supplier supplier";
	private static final String _SQL_SELECT_SUPPLIER_WHERE_PKS_IN = "SELECT supplier FROM Supplier supplier WHERE supplierId IN (";
	private static final String _SQL_SELECT_SUPPLIER_WHERE = "SELECT supplier FROM Supplier supplier WHERE ";
	private static final String _SQL_COUNT_SUPPLIER = "SELECT COUNT(supplier) FROM Supplier supplier";
	private static final String _SQL_COUNT_SUPPLIER_WHERE = "SELECT COUNT(supplier) FROM Supplier supplier WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "supplier.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Supplier exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Supplier exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SupplierPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
}