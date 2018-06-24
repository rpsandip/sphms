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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.sphms.common.service.exception.NoSuchExpenseException;
import com.sphms.common.service.model.Expense;
import com.sphms.common.service.model.impl.ExpenseImpl;
import com.sphms.common.service.model.impl.ExpenseModelImpl;
import com.sphms.common.service.service.persistence.ExpensePersistence;

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
 * The persistence implementation for the expense service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpensePersistence
 * @see com.sphms.common.service.service.persistence.ExpenseUtil
 * @generated
 */
@ProviderType
public class ExpensePersistenceImpl extends BasePersistenceImpl<Expense>
	implements ExpensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpenseUtil} to access the expense persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, ExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, ExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ExpensePersistenceImpl() {
		setModelClass(Expense.class);
	}

	/**
	 * Caches the expense in the entity cache if it is enabled.
	 *
	 * @param expense the expense
	 */
	@Override
	public void cacheResult(Expense expense) {
		entityCache.putResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseImpl.class, expense.getPrimaryKey(), expense);

		expense.resetOriginalValues();
	}

	/**
	 * Caches the expenses in the entity cache if it is enabled.
	 *
	 * @param expenses the expenses
	 */
	@Override
	public void cacheResult(List<Expense> expenses) {
		for (Expense expense : expenses) {
			if (entityCache.getResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
						ExpenseImpl.class, expense.getPrimaryKey()) == null) {
				cacheResult(expense);
			}
			else {
				expense.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all expenses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpenseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expense.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Expense expense) {
		entityCache.removeResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseImpl.class, expense.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Expense> expenses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Expense expense : expenses) {
			entityCache.removeResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
				ExpenseImpl.class, expense.getPrimaryKey());
		}
	}

	/**
	 * Creates a new expense with the primary key. Does not add the expense to the database.
	 *
	 * @param expenseId the primary key for the new expense
	 * @return the new expense
	 */
	@Override
	public Expense create(long expenseId) {
		Expense expense = new ExpenseImpl();

		expense.setNew(true);
		expense.setPrimaryKey(expenseId);

		return expense;
	}

	/**
	 * Removes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense that was removed
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense remove(long expenseId) throws NoSuchExpenseException {
		return remove((Serializable)expenseId);
	}

	/**
	 * Removes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expense
	 * @return the expense that was removed
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense remove(Serializable primaryKey)
		throws NoSuchExpenseException {
		Session session = null;

		try {
			session = openSession();

			Expense expense = (Expense)session.get(ExpenseImpl.class, primaryKey);

			if (expense == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expense);
		}
		catch (NoSuchExpenseException nsee) {
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
	protected Expense removeImpl(Expense expense) {
		expense = toUnwrappedModel(expense);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expense)) {
				expense = (Expense)session.get(ExpenseImpl.class,
						expense.getPrimaryKeyObj());
			}

			if (expense != null) {
				session.delete(expense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expense != null) {
			clearCache(expense);
		}

		return expense;
	}

	@Override
	public Expense updateImpl(Expense expense) {
		expense = toUnwrappedModel(expense);

		boolean isNew = expense.isNew();

		ExpenseModelImpl expenseModelImpl = (ExpenseModelImpl)expense;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (expense.getCreateDate() == null)) {
			if (serviceContext == null) {
				expense.setCreateDate(now);
			}
			else {
				expense.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!expenseModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				expense.setModifiedDate(now);
			}
			else {
				expense.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (expense.isNew()) {
				session.save(expense);

				expense.setNew(false);
			}
			else {
				expense = (Expense)session.merge(expense);
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

		entityCache.putResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
			ExpenseImpl.class, expense.getPrimaryKey(), expense, false);

		expense.resetOriginalValues();

		return expense;
	}

	protected Expense toUnwrappedModel(Expense expense) {
		if (expense instanceof ExpenseImpl) {
			return expense;
		}

		ExpenseImpl expenseImpl = new ExpenseImpl();

		expenseImpl.setNew(expense.isNew());
		expenseImpl.setPrimaryKey(expense.getPrimaryKey());

		expenseImpl.setExpenseId(expense.getExpenseId());
		expenseImpl.setCustomCompanyId(expense.getCustomCompanyId());
		expenseImpl.setType(expense.getType());
		expenseImpl.setAmount(expense.getAmount());
		expenseImpl.setDescription(expense.getDescription());
		expenseImpl.setExpenseDate(expense.getExpenseDate());
		expenseImpl.setCreateDate(expense.getCreateDate());
		expenseImpl.setCreatedBy(expense.getCreatedBy());
		expenseImpl.setModifiedDate(expense.getModifiedDate());
		expenseImpl.setModifiedBy(expense.getModifiedBy());

		return expenseImpl;
	}

	/**
	 * Returns the expense with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense
	 * @return the expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpenseException {
		Expense expense = fetchByPrimaryKey(primaryKey);

		if (expense == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expense;
	}

	/**
	 * Returns the expense with the primary key or throws a {@link NoSuchExpenseException} if it could not be found.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	@Override
	public Expense findByPrimaryKey(long expenseId)
		throws NoSuchExpenseException {
		return findByPrimaryKey((Serializable)expenseId);
	}

	/**
	 * Returns the expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense
	 * @return the expense, or <code>null</code> if a expense with the primary key could not be found
	 */
	@Override
	public Expense fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
				ExpenseImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Expense expense = (Expense)serializable;

		if (expense == null) {
			Session session = null;

			try {
				session = openSession();

				expense = (Expense)session.get(ExpenseImpl.class, primaryKey);

				if (expense != null) {
					cacheResult(expense);
				}
				else {
					entityCache.putResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
						ExpenseImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expense;
	}

	/**
	 * Returns the expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense, or <code>null</code> if a expense with the primary key could not be found
	 */
	@Override
	public Expense fetchByPrimaryKey(long expenseId) {
		return fetchByPrimaryKey((Serializable)expenseId);
	}

	@Override
	public Map<Serializable, Expense> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Expense> map = new HashMap<Serializable, Expense>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Expense expense = fetchByPrimaryKey(primaryKey);

			if (expense != null) {
				map.put(primaryKey, expense);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Expense)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXPENSE_WHERE_PKS_IN);

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

			for (Expense expense : (List<Expense>)q.list()) {
				map.put(expense.getPrimaryKeyObj(), expense);

				cacheResult(expense);

				uncachedPrimaryKeys.remove(expense.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExpenseModelImpl.ENTITY_CACHE_ENABLED,
					ExpenseImpl.class, primaryKey, nullModel);
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
	 * Returns all the expenses.
	 *
	 * @return the expenses
	 */
	@Override
	public List<Expense> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of expenses
	 */
	@Override
	public List<Expense> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expenses
	 */
	@Override
	public List<Expense> findAll(int start, int end,
		OrderByComparator<Expense> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of expenses
	 */
	@Override
	public List<Expense> findAll(int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean retrieveFromCache) {
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

		List<Expense> list = null;

		if (retrieveFromCache) {
			list = (List<Expense>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXPENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPENSE;

				if (pagination) {
					sql = sql.concat(ExpenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Expense>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Expense>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the expenses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Expense expense : findAll()) {
			remove(expense);
		}
	}

	/**
	 * Returns the number of expenses.
	 *
	 * @return the number of expenses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXPENSE);

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
		return ExpenseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the expense persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExpenseImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EXPENSE = "SELECT expense FROM Expense expense";
	private static final String _SQL_SELECT_EXPENSE_WHERE_PKS_IN = "SELECT expense FROM Expense expense WHERE expenseId IN (";
	private static final String _SQL_COUNT_EXPENSE = "SELECT COUNT(expense) FROM Expense expense";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expense.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Expense exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ExpensePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
}