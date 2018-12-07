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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchLandLordException;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.model.impl.LandLordImpl;
import com.sphms.common.service.model.impl.LandLordModelImpl;
import com.sphms.common.service.service.persistence.LandLordPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the land lord service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LandLordPersistence
 * @see com.sphms.common.service.service.persistence.LandLordUtil
 * @generated
 */
@ProviderType
public class LandLordPersistenceImpl extends BasePersistenceImpl<LandLord>
	implements LandLordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LandLordUtil} to access the land lord persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LandLordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LandLordModelImpl.ENTITY_CACHE_ENABLED,
			LandLordModelImpl.FINDER_CACHE_ENABLED, LandLordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LandLordModelImpl.ENTITY_CACHE_ENABLED,
			LandLordModelImpl.FINDER_CACHE_ENABLED, LandLordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LandLordModelImpl.ENTITY_CACHE_ENABLED,
			LandLordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LandLordPersistenceImpl() {
		setModelClass(LandLord.class);
	}

	/**
	 * Caches the land lord in the entity cache if it is enabled.
	 *
	 * @param landLord the land lord
	 */
	@Override
	public void cacheResult(LandLord landLord) {
		entityCache.putResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
			LandLordImpl.class, landLord.getPrimaryKey(), landLord);

		landLord.resetOriginalValues();
	}

	/**
	 * Caches the land lords in the entity cache if it is enabled.
	 *
	 * @param landLords the land lords
	 */
	@Override
	public void cacheResult(List<LandLord> landLords) {
		for (LandLord landLord : landLords) {
			if (entityCache.getResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
						LandLordImpl.class, landLord.getPrimaryKey()) == null) {
				cacheResult(landLord);
			}
			else {
				landLord.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all land lords.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LandLordImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the land lord.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LandLord landLord) {
		entityCache.removeResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
			LandLordImpl.class, landLord.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LandLord> landLords) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LandLord landLord : landLords) {
			entityCache.removeResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
				LandLordImpl.class, landLord.getPrimaryKey());
		}
	}

	/**
	 * Creates a new land lord with the primary key. Does not add the land lord to the database.
	 *
	 * @param landLordId the primary key for the new land lord
	 * @return the new land lord
	 */
	@Override
	public LandLord create(long landLordId) {
		LandLord landLord = new LandLordImpl();

		landLord.setNew(true);
		landLord.setPrimaryKey(landLordId);

		return landLord;
	}

	/**
	 * Removes the land lord with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param landLordId the primary key of the land lord
	 * @return the land lord that was removed
	 * @throws NoSuchLandLordException if a land lord with the primary key could not be found
	 */
	@Override
	public LandLord remove(long landLordId) throws NoSuchLandLordException {
		return remove((Serializable)landLordId);
	}

	/**
	 * Removes the land lord with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the land lord
	 * @return the land lord that was removed
	 * @throws NoSuchLandLordException if a land lord with the primary key could not be found
	 */
	@Override
	public LandLord remove(Serializable primaryKey)
		throws NoSuchLandLordException {
		Session session = null;

		try {
			session = openSession();

			LandLord landLord = (LandLord)session.get(LandLordImpl.class,
					primaryKey);

			if (landLord == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLandLordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(landLord);
		}
		catch (NoSuchLandLordException nsee) {
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
	protected LandLord removeImpl(LandLord landLord) {
		landLord = toUnwrappedModel(landLord);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(landLord)) {
				landLord = (LandLord)session.get(LandLordImpl.class,
						landLord.getPrimaryKeyObj());
			}

			if (landLord != null) {
				session.delete(landLord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (landLord != null) {
			clearCache(landLord);
		}

		return landLord;
	}

	@Override
	public LandLord updateImpl(LandLord landLord) {
		landLord = toUnwrappedModel(landLord);

		boolean isNew = landLord.isNew();

		Session session = null;

		try {
			session = openSession();

			if (landLord.isNew()) {
				session.save(landLord);

				landLord.setNew(false);
			}
			else {
				landLord = (LandLord)session.merge(landLord);
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

		entityCache.putResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
			LandLordImpl.class, landLord.getPrimaryKey(), landLord, false);

		landLord.resetOriginalValues();

		return landLord;
	}

	protected LandLord toUnwrappedModel(LandLord landLord) {
		if (landLord instanceof LandLordImpl) {
			return landLord;
		}

		LandLordImpl landLordImpl = new LandLordImpl();

		landLordImpl.setNew(landLord.isNew());
		landLordImpl.setPrimaryKey(landLord.getPrimaryKey());

		landLordImpl.setLandLordId(landLord.getLandLordId());
		landLordImpl.setFirstName(landLord.getFirstName());
		landLordImpl.setLastName(landLord.getLastName());
		landLordImpl.setLocation(landLord.getLocation());
		landLordImpl.setCity(landLord.getCity());
		landLordImpl.setStatec(landLord.getStatec());
		landLordImpl.setStatus(landLord.getStatus());
		landLordImpl.setPhoneNo(landLord.getPhoneNo());
		landLordImpl.setGstNo(landLord.getGstNo());
		landLordImpl.setCreateDate(landLord.getCreateDate());
		landLordImpl.setCreatedBy(landLord.getCreatedBy());

		return landLordImpl;
	}

	/**
	 * Returns the land lord with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the land lord
	 * @return the land lord
	 * @throws NoSuchLandLordException if a land lord with the primary key could not be found
	 */
	@Override
	public LandLord findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLandLordException {
		LandLord landLord = fetchByPrimaryKey(primaryKey);

		if (landLord == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLandLordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return landLord;
	}

	/**
	 * Returns the land lord with the primary key or throws a {@link NoSuchLandLordException} if it could not be found.
	 *
	 * @param landLordId the primary key of the land lord
	 * @return the land lord
	 * @throws NoSuchLandLordException if a land lord with the primary key could not be found
	 */
	@Override
	public LandLord findByPrimaryKey(long landLordId)
		throws NoSuchLandLordException {
		return findByPrimaryKey((Serializable)landLordId);
	}

	/**
	 * Returns the land lord with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the land lord
	 * @return the land lord, or <code>null</code> if a land lord with the primary key could not be found
	 */
	@Override
	public LandLord fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
				LandLordImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LandLord landLord = (LandLord)serializable;

		if (landLord == null) {
			Session session = null;

			try {
				session = openSession();

				landLord = (LandLord)session.get(LandLordImpl.class, primaryKey);

				if (landLord != null) {
					cacheResult(landLord);
				}
				else {
					entityCache.putResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
						LandLordImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
					LandLordImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return landLord;
	}

	/**
	 * Returns the land lord with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param landLordId the primary key of the land lord
	 * @return the land lord, or <code>null</code> if a land lord with the primary key could not be found
	 */
	@Override
	public LandLord fetchByPrimaryKey(long landLordId) {
		return fetchByPrimaryKey((Serializable)landLordId);
	}

	@Override
	public Map<Serializable, LandLord> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LandLord> map = new HashMap<Serializable, LandLord>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LandLord landLord = fetchByPrimaryKey(primaryKey);

			if (landLord != null) {
				map.put(primaryKey, landLord);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
					LandLordImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LandLord)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LANDLORD_WHERE_PKS_IN);

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

			for (LandLord landLord : (List<LandLord>)q.list()) {
				map.put(landLord.getPrimaryKeyObj(), landLord);

				cacheResult(landLord);

				uncachedPrimaryKeys.remove(landLord.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LandLordModelImpl.ENTITY_CACHE_ENABLED,
					LandLordImpl.class, primaryKey, nullModel);
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
	 * Returns all the land lords.
	 *
	 * @return the land lords
	 */
	@Override
	public List<LandLord> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the land lords.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of land lords
	 * @param end the upper bound of the range of land lords (not inclusive)
	 * @return the range of land lords
	 */
	@Override
	public List<LandLord> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the land lords.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of land lords
	 * @param end the upper bound of the range of land lords (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of land lords
	 */
	@Override
	public List<LandLord> findAll(int start, int end,
		OrderByComparator<LandLord> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the land lords.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LandLordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of land lords
	 * @param end the upper bound of the range of land lords (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of land lords
	 */
	@Override
	public List<LandLord> findAll(int start, int end,
		OrderByComparator<LandLord> orderByComparator, boolean retrieveFromCache) {
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

		List<LandLord> list = null;

		if (retrieveFromCache) {
			list = (List<LandLord>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LANDLORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANDLORD;

				if (pagination) {
					sql = sql.concat(LandLordModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LandLord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LandLord>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the land lords from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LandLord landLord : findAll()) {
			remove(landLord);
		}
	}

	/**
	 * Returns the number of land lords.
	 *
	 * @return the number of land lords
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LANDLORD);

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
		return LandLordModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the land lord persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LandLordImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LANDLORD = "SELECT landLord FROM LandLord landLord";
	private static final String _SQL_SELECT_LANDLORD_WHERE_PKS_IN = "SELECT landLord FROM LandLord landLord WHERE landLordId IN (";
	private static final String _SQL_COUNT_LANDLORD = "SELECT COUNT(landLord) FROM LandLord landLord";
	private static final String _ORDER_BY_ENTITY_ALIAS = "landLord.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LandLord exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(LandLordPersistenceImpl.class);
}