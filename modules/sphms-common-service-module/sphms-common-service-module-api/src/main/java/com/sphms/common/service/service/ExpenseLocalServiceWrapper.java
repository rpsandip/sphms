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

package com.sphms.common.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExpenseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExpenseLocalService
 * @generated
 */
@ProviderType
public class ExpenseLocalServiceWrapper implements ExpenseLocalService,
	ServiceWrapper<ExpenseLocalService> {
	public ExpenseLocalServiceWrapper(ExpenseLocalService expenseLocalService) {
		_expenseLocalService = expenseLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _expenseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expenseLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _expenseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the expense to the database. Also notifies the appropriate model listeners.
	*
	* @param expense the expense
	* @return the expense that was added
	*/
	@Override
	public com.sphms.common.service.model.Expense addExpense(
		com.sphms.common.service.model.Expense expense) {
		return _expenseLocalService.addExpense(expense);
	}

	@Override
	public com.sphms.common.service.model.Expense addExpense(
		java.lang.String type, double amount, java.lang.String description,
		java.util.Date expenseDate, long createdBy) {
		return _expenseLocalService.addExpense(type, amount, description,
			expenseDate, createdBy);
	}

	/**
	* Creates a new expense with the primary key. Does not add the expense to the database.
	*
	* @param expenseId the primary key for the new expense
	* @return the new expense
	*/
	@Override
	public com.sphms.common.service.model.Expense createExpense(long expenseId) {
		return _expenseLocalService.createExpense(expenseId);
	}

	/**
	* Deletes the expense from the database. Also notifies the appropriate model listeners.
	*
	* @param expense the expense
	* @return the expense that was removed
	*/
	@Override
	public com.sphms.common.service.model.Expense deleteExpense(
		com.sphms.common.service.model.Expense expense) {
		return _expenseLocalService.deleteExpense(expense);
	}

	/**
	* Deletes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseId the primary key of the expense
	* @return the expense that was removed
	* @throws PortalException if a expense with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Expense deleteExpense(long expenseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseLocalService.deleteExpense(expenseId);
	}

	@Override
	public com.sphms.common.service.model.Expense fetchExpense(long expenseId) {
		return _expenseLocalService.fetchExpense(expenseId);
	}

	/**
	* Returns the expense with the primary key.
	*
	* @param expenseId the primary key of the expense
	* @return the expense
	* @throws PortalException if a expense with the primary key could not be found
	*/
	@Override
	public com.sphms.common.service.model.Expense getExpense(long expenseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseLocalService.getExpense(expenseId);
	}

	/**
	* Updates the expense in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expense the expense
	* @return the expense that was updated
	*/
	@Override
	public com.sphms.common.service.model.Expense updateExpense(
		com.sphms.common.service.model.Expense expense) {
		return _expenseLocalService.updateExpense(expense);
	}

	@Override
	public com.sphms.common.service.model.Expense updateExpense(
		long expenseId, java.lang.String type, double amount,
		java.lang.String description, java.util.Date expenseDate,
		long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _expenseLocalService.updateExpense(expenseId, type, amount,
			description, expenseDate, modifiedBy);
	}

	/**
	* Returns the number of expenses.
	*
	* @return the number of expenses
	*/
	@Override
	public int getExpensesCount() {
		return _expenseLocalService.getExpensesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _expenseLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _expenseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _expenseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _expenseLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.sphms.common.service.model.Expense> getExpenseList(
		java.lang.String type, java.util.Date startDate,
		java.util.Date endDate, int start, int end) {
		return _expenseLocalService.getExpenseList(type, startDate, endDate,
			start, end);
	}

	/**
	* Returns a range of all the expenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sphms.common.service.model.impl.ExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of expenses
	* @param end the upper bound of the range of expenses (not inclusive)
	* @return the range of expenses
	*/
	@Override
	public java.util.List<com.sphms.common.service.model.Expense> getExpenses(
		int start, int end) {
		return _expenseLocalService.getExpenses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _expenseLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _expenseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public long getExpenseCount(java.lang.String type,
		java.util.Date startDate, java.util.Date endDate) {
		return _expenseLocalService.getExpenseCount(type, startDate, endDate);
	}

	@Override
	public ExpenseLocalService getWrappedService() {
		return _expenseLocalService;
	}

	@Override
	public void setWrappedService(ExpenseLocalService expenseLocalService) {
		_expenseLocalService = expenseLocalService;
	}

	private ExpenseLocalService _expenseLocalService;
}