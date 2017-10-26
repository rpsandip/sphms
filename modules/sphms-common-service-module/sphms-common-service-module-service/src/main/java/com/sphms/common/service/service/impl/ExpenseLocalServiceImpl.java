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

package com.sphms.common.service.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.model.Expense;
import com.sphms.common.service.service.ExpenseLocalServiceUtil;
import com.sphms.common.service.service.base.ExpenseLocalServiceBaseImpl;

/**
 * The implementation of the expense local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.ExpenseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpenseLocalServiceBaseImpl
 * @see com.sphms.common.service.service.ExpenseLocalServiceUtil
 */
@ProviderType
public class ExpenseLocalServiceImpl extends ExpenseLocalServiceBaseImpl {
	
	/*
	 * Add Expense
	 */
	public Expense addExpense(String type, double amount, String description, Date expenseDate, long createdBy){
		Expense expense = ExpenseLocalServiceUtil.createExpense(CounterLocalServiceUtil.increment());
		expense.setType(type);
		expense.setDescription(description);
		expense.setAmount(amount);
		expense.setExpenseDate(expenseDate);
		expense.setCreatedBy(createdBy);
		expense.setModifiedBy(createdBy);
		expense.setCreateDate(new Date());
		expense.setModifiedDate(new Date());
		
		expense = ExpenseLocalServiceUtil.addExpense(expense);
		
		return expense;
	}
	
	/*
	 * Update Expense
	 */
	public Expense updateExpense(long expenseId,String type,double amount, String description, Date expenseDate, long modifiedBy) throws PortalException{
		Expense expense = ExpenseLocalServiceUtil.getExpense(expenseId);
		expense.setType(type);
		expense.setAmount(amount);
		expense.setDescription(description);
		expense.setExpenseDate(expenseDate);
		expense.setModifiedBy(modifiedBy);
		expense.setModifiedDate(new Date());
		
		expense = ExpenseLocalServiceUtil.updateExpense(expense);
		
		return expense;
	}
	
	/*
	 * Search Expense
	 */
	public List<Expense> getExpenseList(String type, Date startDate, Date endDate, int start, int end){
		List<Expense> expenseList = new ArrayList<Expense>();
		
		DynamicQuery dynamicQuery = ExpenseLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(type)){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("type", type));
		}
		
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			dynamicQuery.add(RestrictionsFactoryUtil.between("expenseDate", startDate, endDate));
		}
		dynamicQuery.setLimit(start, end);
		
		Order order = OrderFactoryUtil.desc("createDate");
		dynamicQuery.addOrder(order);
		
		expenseList = ExpenseLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return expenseList;
		
	}
	
	public long getExpenseCount(String type, Date startDate, Date endDate){
		return getExpenseList(type, startDate, endDate, -1, -1).size();
	}
}