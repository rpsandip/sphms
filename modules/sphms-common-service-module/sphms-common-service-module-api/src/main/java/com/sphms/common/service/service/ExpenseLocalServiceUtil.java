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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Expense. This utility wraps
 * {@link com.sphms.common.service.service.impl.ExpenseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExpenseLocalService
 * @see com.sphms.common.service.service.base.ExpenseLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.ExpenseLocalServiceImpl
 * @generated
 */
@ProviderType
public class ExpenseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.ExpenseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the expense to the database. Also notifies the appropriate model listeners.
	*
	* @param expense the expense
	* @return the expense that was added
	*/
	public static com.sphms.common.service.model.Expense addExpense(
		com.sphms.common.service.model.Expense expense) {
		return getService().addExpense(expense);
	}

	public static com.sphms.common.service.model.Expense addExpense(
		java.lang.String type, double amount, java.lang.String description,
		java.util.Date expenseDate, long customCompanyId, long createdBy) {
		return getService()
				   .addExpense(type, amount, description, expenseDate,
			customCompanyId, createdBy);
	}

	/**
	* Creates a new expense with the primary key. Does not add the expense to the database.
	*
	* @param expenseId the primary key for the new expense
	* @return the new expense
	*/
	public static com.sphms.common.service.model.Expense createExpense(
		long expenseId) {
		return getService().createExpense(expenseId);
	}

	/**
	* Deletes the expense from the database. Also notifies the appropriate model listeners.
	*
	* @param expense the expense
	* @return the expense that was removed
	*/
	public static com.sphms.common.service.model.Expense deleteExpense(
		com.sphms.common.service.model.Expense expense) {
		return getService().deleteExpense(expense);
	}

	/**
	* Deletes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param expenseId the primary key of the expense
	* @return the expense that was removed
	* @throws PortalException if a expense with the primary key could not be found
	*/
	public static com.sphms.common.service.model.Expense deleteExpense(
		long expenseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteExpense(expenseId);
	}

	public static com.sphms.common.service.model.Expense fetchExpense(
		long expenseId) {
		return getService().fetchExpense(expenseId);
	}

	/**
	* Returns the expense with the primary key.
	*
	* @param expenseId the primary key of the expense
	* @return the expense
	* @throws PortalException if a expense with the primary key could not be found
	*/
	public static com.sphms.common.service.model.Expense getExpense(
		long expenseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getExpense(expenseId);
	}

	/**
	* Updates the expense in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param expense the expense
	* @return the expense that was updated
	*/
	public static com.sphms.common.service.model.Expense updateExpense(
		com.sphms.common.service.model.Expense expense) {
		return getService().updateExpense(expense);
	}

	public static com.sphms.common.service.model.Expense updateExpense(
		long expenseId, java.lang.String type, double amount,
		java.lang.String description, java.util.Date expenseDate,
		long customCompanyId, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateExpense(expenseId, type, amount, description,
			expenseDate, customCompanyId, modifiedBy);
	}

	/**
	* Returns the number of expenses.
	*
	* @return the number of expenses
	*/
	public static int getExpensesCount() {
		return getService().getExpensesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.sphms.common.service.model.Expense> getExpenseList(
		java.lang.String type, java.util.Date startDate,
		java.util.Date endDate, long customCompanyId, int start, int end) {
		return getService()
				   .getExpenseList(type, startDate, endDate, customCompanyId,
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
	public static java.util.List<com.sphms.common.service.model.Expense> getExpenses(
		int start, int end) {
		return getService().getExpenses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static long getExpenseCount(java.lang.String type,
		java.util.Date startDate, java.util.Date endDate, long customCompanyId) {
		return getService()
				   .getExpenseCount(type, startDate, endDate, customCompanyId);
	}

	public static ExpenseLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpenseLocalService, ExpenseLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ExpenseLocalService.class);
}