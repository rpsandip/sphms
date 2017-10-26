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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchCustomCompanyException;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.impl.CustomCompanyImpl;
import com.sphms.common.service.model.impl.CustomCompanyModelImpl;
import com.sphms.common.service.service.persistence.CustomCompanyPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the custom company service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomCompanyPersistence
 * @see com.sphms.common.service.service.persistence.CustomCompanyUtil
 * @generated
 */
@ProviderType
public class CustomCompanyPersistenceImpl extends BasePersistenceImpl<CustomCompany>
	implements CustomCompanyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CustomCompanyUtil} to access the custom company persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CustomCompanyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
			CustomCompanyModelImpl.FINDER_CACHE_ENABLED,
			CustomCompanyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
			CustomCompanyModelImpl.FINDER_CACHE_ENABLED,
			CustomCompanyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
			CustomCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CustomCompanyPersistenceImpl() {
		setModelClass(CustomCompany.class);
	}

	/**
	 * Caches the custom company in the entity cache if it is enabled.
	 *
	 * @param customCompany the custom company
	 */
	@Override
	public void cacheResult(CustomCompany customCompany) {
		entityCache.putResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
			CustomCompanyImpl.class, customCompany.getPrimaryKey(),
			customCompany);

		customCompany.resetOriginalValues();
	}

	/**
	 * Caches the custom companies in the entity cache if it is enabled.
	 *
	 * @param customCompanies the custom companies
	 */
	@Override
	public void cacheResult(List<CustomCompany> customCompanies) {
		for (CustomCompany customCompany : customCompanies) {
			if (entityCache.getResult(
						CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
						CustomCompanyImpl.class, customCompany.getPrimaryKey()) == null) {
				cacheResult(customCompany);
			}
			else {
				customCompany.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all custom companies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomCompanyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom company.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomCompany customCompany) {
		entityCache.removeResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
			CustomCompanyImpl.class, customCompany.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CustomCompany> customCompanies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CustomCompany customCompany : customCompanies) {
			entityCache.removeResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
				CustomCompanyImpl.class, customCompany.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom company with the primary key. Does not add the custom company to the database.
	 *
	 * @param companyId the primary key for the new custom company
	 * @return the new custom company
	 */
	@Override
	public CustomCompany create(long companyId) {
		CustomCompany customCompany = new CustomCompanyImpl();

		customCompany.setNew(true);
		customCompany.setPrimaryKey(companyId);

		customCompany.setCompanyId(companyProvider.getCompanyId());

		return customCompany;
	}

	/**
	 * Removes the custom company with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyId the primary key of the custom company
	 * @return the custom company that was removed
	 * @throws NoSuchCustomCompanyException if a custom company with the primary key could not be found
	 */
	@Override
	public CustomCompany remove(long companyId)
		throws NoSuchCustomCompanyException {
		return remove((Serializable)companyId);
	}

	/**
	 * Removes the custom company with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom company
	 * @return the custom company that was removed
	 * @throws NoSuchCustomCompanyException if a custom company with the primary key could not be found
	 */
	@Override
	public CustomCompany remove(Serializable primaryKey)
		throws NoSuchCustomCompanyException {
		Session session = null;

		try {
			session = openSession();

			CustomCompany customCompany = (CustomCompany)session.get(CustomCompanyImpl.class,
					primaryKey);

			if (customCompany == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(customCompany);
		}
		catch (NoSuchCustomCompanyException nsee) {
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
	protected CustomCompany removeImpl(CustomCompany customCompany) {
		customCompany = toUnwrappedModel(customCompany);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customCompany)) {
				customCompany = (CustomCompany)session.get(CustomCompanyImpl.class,
						customCompany.getPrimaryKeyObj());
			}

			if (customCompany != null) {
				session.delete(customCompany);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (customCompany != null) {
			clearCache(customCompany);
		}

		return customCompany;
	}

	@Override
	public CustomCompany updateImpl(CustomCompany customCompany) {
		customCompany = toUnwrappedModel(customCompany);

		boolean isNew = customCompany.isNew();

		Session session = null;

		try {
			session = openSession();

			if (customCompany.isNew()) {
				session.save(customCompany);

				customCompany.setNew(false);
			}
			else {
				customCompany = (CustomCompany)session.merge(customCompany);
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

		entityCache.putResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
			CustomCompanyImpl.class, customCompany.getPrimaryKey(),
			customCompany, false);

		customCompany.resetOriginalValues();

		return customCompany;
	}

	protected CustomCompany toUnwrappedModel(CustomCompany customCompany) {
		if (customCompany instanceof CustomCompanyImpl) {
			return customCompany;
		}

		CustomCompanyImpl customCompanyImpl = new CustomCompanyImpl();

		customCompanyImpl.setNew(customCompany.isNew());
		customCompanyImpl.setPrimaryKey(customCompany.getPrimaryKey());

		customCompanyImpl.setCompanyId(customCompany.getCompanyId());
		customCompanyImpl.setName(customCompany.getName());
		customCompanyImpl.setGSTNo(customCompany.getGSTNo());
		customCompanyImpl.setPANNo(customCompany.getPANNo());
		customCompanyImpl.setBankName(customCompany.getBankName());
		customCompanyImpl.setAccountDetail(customCompany.getAccountDetail());
		customCompanyImpl.setPoPrefix(customCompany.getPoPrefix());

		return customCompanyImpl;
	}

	/**
	 * Returns the custom company with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom company
	 * @return the custom company
	 * @throws NoSuchCustomCompanyException if a custom company with the primary key could not be found
	 */
	@Override
	public CustomCompany findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomCompanyException {
		CustomCompany customCompany = fetchByPrimaryKey(primaryKey);

		if (customCompany == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return customCompany;
	}

	/**
	 * Returns the custom company with the primary key or throws a {@link NoSuchCustomCompanyException} if it could not be found.
	 *
	 * @param companyId the primary key of the custom company
	 * @return the custom company
	 * @throws NoSuchCustomCompanyException if a custom company with the primary key could not be found
	 */
	@Override
	public CustomCompany findByPrimaryKey(long companyId)
		throws NoSuchCustomCompanyException {
		return findByPrimaryKey((Serializable)companyId);
	}

	/**
	 * Returns the custom company with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom company
	 * @return the custom company, or <code>null</code> if a custom company with the primary key could not be found
	 */
	@Override
	public CustomCompany fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
				CustomCompanyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CustomCompany customCompany = (CustomCompany)serializable;

		if (customCompany == null) {
			Session session = null;

			try {
				session = openSession();

				customCompany = (CustomCompany)session.get(CustomCompanyImpl.class,
						primaryKey);

				if (customCompany != null) {
					cacheResult(customCompany);
				}
				else {
					entityCache.putResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
						CustomCompanyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
					CustomCompanyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return customCompany;
	}

	/**
	 * Returns the custom company with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyId the primary key of the custom company
	 * @return the custom company, or <code>null</code> if a custom company with the primary key could not be found
	 */
	@Override
	public CustomCompany fetchByPrimaryKey(long companyId) {
		return fetchByPrimaryKey((Serializable)companyId);
	}

	@Override
	public Map<Serializable, CustomCompany> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CustomCompany> map = new HashMap<Serializable, CustomCompany>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CustomCompany customCompany = fetchByPrimaryKey(primaryKey);

			if (customCompany != null) {
				map.put(primaryKey, customCompany);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
					CustomCompanyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CustomCompany)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOMCOMPANY_WHERE_PKS_IN);

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

			for (CustomCompany customCompany : (List<CustomCompany>)q.list()) {
				map.put(customCompany.getPrimaryKeyObj(), customCompany);

				cacheResult(customCompany);

				uncachedPrimaryKeys.remove(customCompany.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CustomCompanyModelImpl.ENTITY_CACHE_ENABLED,
					CustomCompanyImpl.class, primaryKey, nullModel);
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
	 * Returns all the custom companies.
	 *
	 * @return the custom companies
	 */
	@Override
	public List<CustomCompany> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the custom companies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom companies
	 * @param end the upper bound of the range of custom companies (not inclusive)
	 * @return the range of custom companies
	 */
	@Override
	public List<CustomCompany> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the custom companies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom companies
	 * @param end the upper bound of the range of custom companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom companies
	 */
	@Override
	public List<CustomCompany> findAll(int start, int end,
		OrderByComparator<CustomCompany> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the custom companies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom companies
	 * @param end the upper bound of the range of custom companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of custom companies
	 */
	@Override
	public List<CustomCompany> findAll(int start, int end,
		OrderByComparator<CustomCompany> orderByComparator,
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

		List<CustomCompany> list = null;

		if (retrieveFromCache) {
			list = (List<CustomCompany>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOMCOMPANY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMCOMPANY;

				if (pagination) {
					sql = sql.concat(CustomCompanyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CustomCompany>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CustomCompany>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the custom companies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomCompany customCompany : findAll()) {
			remove(customCompany);
		}
	}

	/**
	 * Returns the number of custom companies.
	 *
	 * @return the number of custom companies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOMCOMPANY);

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
		return CustomCompanyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom company persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CustomCompanyImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOMCOMPANY = "SELECT customCompany FROM CustomCompany customCompany";
	private static final String _SQL_SELECT_CUSTOMCOMPANY_WHERE_PKS_IN = "SELECT customCompany FROM CustomCompany customCompany WHERE companyId IN (";
	private static final String _SQL_COUNT_CUSTOMCOMPANY = "SELECT COUNT(customCompany) FROM CustomCompany customCompany";
	private static final String _ORDER_BY_ENTITY_ALIAS = "customCompany.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CustomCompany exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CustomCompanyPersistenceImpl.class);
}