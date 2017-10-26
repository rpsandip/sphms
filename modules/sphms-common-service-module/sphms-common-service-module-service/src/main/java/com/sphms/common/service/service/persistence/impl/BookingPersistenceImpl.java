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

import com.sphms.common.service.exception.NoSuchBookingException;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.impl.BookingImpl;
import com.sphms.common.service.model.impl.BookingModelImpl;
import com.sphms.common.service.service.persistence.BookingPersistence;

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
 * The persistence implementation for the booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingPersistence
 * @see com.sphms.common.service.service.persistence.BookingUtil
 * @generated
 */
@ProviderType
public class BookingPersistenceImpl extends BasePersistenceImpl<Booking>
	implements BookingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookingUtil} to access the booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookingModelImpl.ENTITY_CACHE_ENABLED,
			BookingModelImpl.FINDER_CACHE_ENABLED, BookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookingModelImpl.ENTITY_CACHE_ENABLED,
			BookingModelImpl.FINDER_CACHE_ENABLED, BookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookingModelImpl.ENTITY_CACHE_ENABLED,
			BookingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BookingPersistenceImpl() {
		setModelClass(Booking.class);
	}

	/**
	 * Caches the booking in the entity cache if it is enabled.
	 *
	 * @param booking the booking
	 */
	@Override
	public void cacheResult(Booking booking) {
		entityCache.putResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
			BookingImpl.class, booking.getPrimaryKey(), booking);

		booking.resetOriginalValues();
	}

	/**
	 * Caches the bookings in the entity cache if it is enabled.
	 *
	 * @param bookings the bookings
	 */
	@Override
	public void cacheResult(List<Booking> bookings) {
		for (Booking booking : bookings) {
			if (entityCache.getResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
						BookingImpl.class, booking.getPrimaryKey()) == null) {
				cacheResult(booking);
			}
			else {
				booking.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bookings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the booking.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Booking booking) {
		entityCache.removeResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
			BookingImpl.class, booking.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Booking> bookings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Booking booking : bookings) {
			entityCache.removeResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
				BookingImpl.class, booking.getPrimaryKey());
		}
	}

	/**
	 * Creates a new booking with the primary key. Does not add the booking to the database.
	 *
	 * @param bookingId the primary key for the new booking
	 * @return the new booking
	 */
	@Override
	public Booking create(long bookingId) {
		Booking booking = new BookingImpl();

		booking.setNew(true);
		booking.setPrimaryKey(bookingId);

		return booking;
	}

	/**
	 * Removes the booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking that was removed
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking remove(long bookingId) throws NoSuchBookingException {
		return remove((Serializable)bookingId);
	}

	/**
	 * Removes the booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking
	 * @return the booking that was removed
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking remove(Serializable primaryKey)
		throws NoSuchBookingException {
		Session session = null;

		try {
			session = openSession();

			Booking booking = (Booking)session.get(BookingImpl.class, primaryKey);

			if (booking == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(booking);
		}
		catch (NoSuchBookingException nsee) {
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
	protected Booking removeImpl(Booking booking) {
		booking = toUnwrappedModel(booking);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(booking)) {
				booking = (Booking)session.get(BookingImpl.class,
						booking.getPrimaryKeyObj());
			}

			if (booking != null) {
				session.delete(booking);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (booking != null) {
			clearCache(booking);
		}

		return booking;
	}

	@Override
	public Booking updateImpl(Booking booking) {
		booking = toUnwrappedModel(booking);

		boolean isNew = booking.isNew();

		BookingModelImpl bookingModelImpl = (BookingModelImpl)booking;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (booking.getCreateDate() == null)) {
			if (serviceContext == null) {
				booking.setCreateDate(now);
			}
			else {
				booking.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!bookingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				booking.setModifiedDate(now);
			}
			else {
				booking.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (booking.isNew()) {
				session.save(booking);

				booking.setNew(false);
			}
			else {
				booking = (Booking)session.merge(booking);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
			BookingImpl.class, booking.getPrimaryKey(), booking, false);

		booking.resetOriginalValues();

		return booking;
	}

	protected Booking toUnwrappedModel(Booking booking) {
		if (booking instanceof BookingImpl) {
			return booking;
		}

		BookingImpl bookingImpl = new BookingImpl();

		bookingImpl.setNew(booking.isNew());
		bookingImpl.setPrimaryKey(booking.getPrimaryKey());

		bookingImpl.setBookingId(booking.getBookingId());
		bookingImpl.setCustomCompanyId(booking.getCustomCompanyId());
		bookingImpl.setCampaignTitle(booking.getCampaignTitle());
		bookingImpl.setClient(booking.getClient());
		bookingImpl.setBillId(booking.getBillId());
		bookingImpl.setStartDate(booking.getStartDate());
		bookingImpl.setEndDate(booking.getEndDate());
		bookingImpl.setCreateDate(booking.getCreateDate());
		bookingImpl.setCreatedBy(booking.getCreatedBy());
		bookingImpl.setModifiedDate(booking.getModifiedDate());
		bookingImpl.setModifiedBy(booking.getModifiedBy());

		return bookingImpl;
	}

	/**
	 * Returns the booking with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking
	 * @return the booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookingException {
		Booking booking = fetchByPrimaryKey(primaryKey);

		if (booking == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return booking;
	}

	/**
	 * Returns the booking with the primary key or throws a {@link NoSuchBookingException} if it could not be found.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking
	 * @throws NoSuchBookingException if a booking with the primary key could not be found
	 */
	@Override
	public Booking findByPrimaryKey(long bookingId)
		throws NoSuchBookingException {
		return findByPrimaryKey((Serializable)bookingId);
	}

	/**
	 * Returns the booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking
	 * @return the booking, or <code>null</code> if a booking with the primary key could not be found
	 */
	@Override
	public Booking fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
				BookingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Booking booking = (Booking)serializable;

		if (booking == null) {
			Session session = null;

			try {
				session = openSession();

				booking = (Booking)session.get(BookingImpl.class, primaryKey);

				if (booking != null) {
					cacheResult(booking);
				}
				else {
					entityCache.putResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
						BookingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
					BookingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return booking;
	}

	/**
	 * Returns the booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the booking
	 * @return the booking, or <code>null</code> if a booking with the primary key could not be found
	 */
	@Override
	public Booking fetchByPrimaryKey(long bookingId) {
		return fetchByPrimaryKey((Serializable)bookingId);
	}

	@Override
	public Map<Serializable, Booking> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Booking> map = new HashMap<Serializable, Booking>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Booking booking = fetchByPrimaryKey(primaryKey);

			if (booking != null) {
				map.put(primaryKey, booking);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
					BookingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Booking)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BOOKING_WHERE_PKS_IN);

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

			for (Booking booking : (List<Booking>)q.list()) {
				map.put(booking.getPrimaryKeyObj(), booking);

				cacheResult(booking);

				uncachedPrimaryKeys.remove(booking.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BookingModelImpl.ENTITY_CACHE_ENABLED,
					BookingImpl.class, primaryKey, nullModel);
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
	 * Returns all the bookings.
	 *
	 * @return the bookings
	 */
	@Override
	public List<Booking> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @return the range of bookings
	 */
	@Override
	public List<Booking> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bookings
	 */
	@Override
	public List<Booking> findAll(int start, int end,
		OrderByComparator<Booking> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookings
	 * @param end the upper bound of the range of bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bookings
	 */
	@Override
	public List<Booking> findAll(int start, int end,
		OrderByComparator<Booking> orderByComparator, boolean retrieveFromCache) {
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

		List<Booking> list = null;

		if (retrieveFromCache) {
			list = (List<Booking>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BOOKING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKING;

				if (pagination) {
					sql = sql.concat(BookingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Booking>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Booking>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bookings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Booking booking : findAll()) {
			remove(booking);
		}
	}

	/**
	 * Returns the number of bookings.
	 *
	 * @return the number of bookings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKING);

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
		return BookingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the booking persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BookingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BOOKING = "SELECT booking FROM Booking booking";
	private static final String _SQL_SELECT_BOOKING_WHERE_PKS_IN = "SELECT booking FROM Booking booking WHERE bookingId IN (";
	private static final String _SQL_COUNT_BOOKING = "SELECT COUNT(booking) FROM Booking booking";
	private static final String _ORDER_BY_ENTITY_ALIAS = "booking.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Booking exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(BookingPersistenceImpl.class);
}