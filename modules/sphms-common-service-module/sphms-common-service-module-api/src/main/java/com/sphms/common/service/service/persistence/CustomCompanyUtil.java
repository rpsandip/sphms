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

package com.sphms.common.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sphms.common.service.model.CustomCompany;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom company service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.CustomCompanyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomCompanyPersistence
 * @see com.sphms.common.service.service.persistence.impl.CustomCompanyPersistenceImpl
 * @generated
 */
@ProviderType
public class CustomCompanyUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CustomCompany customCompany) {
		getPersistence().clearCache(customCompany);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CustomCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CustomCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CustomCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CustomCompany> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CustomCompany update(CustomCompany customCompany) {
		return getPersistence().update(customCompany);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CustomCompany update(CustomCompany customCompany,
		ServiceContext serviceContext) {
		return getPersistence().update(customCompany, serviceContext);
	}

	/**
	* Caches the custom company in the entity cache if it is enabled.
	*
	* @param customCompany the custom company
	*/
	public static void cacheResult(CustomCompany customCompany) {
		getPersistence().cacheResult(customCompany);
	}

	/**
	* Caches the custom companies in the entity cache if it is enabled.
	*
	* @param customCompanies the custom companies
	*/
	public static void cacheResult(List<CustomCompany> customCompanies) {
		getPersistence().cacheResult(customCompanies);
	}

	/**
	* Creates a new custom company with the primary key. Does not add the custom company to the database.
	*
	* @param companyId the primary key for the new custom company
	* @return the new custom company
	*/
	public static CustomCompany create(long companyId) {
		return getPersistence().create(companyId);
	}

	/**
	* Removes the custom company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyId the primary key of the custom company
	* @return the custom company that was removed
	* @throws NoSuchCustomCompanyException if a custom company with the primary key could not be found
	*/
	public static CustomCompany remove(long companyId)
		throws com.sphms.common.service.exception.NoSuchCustomCompanyException {
		return getPersistence().remove(companyId);
	}

	public static CustomCompany updateImpl(CustomCompany customCompany) {
		return getPersistence().updateImpl(customCompany);
	}

	/**
	* Returns the custom company with the primary key or throws a {@link NoSuchCustomCompanyException} if it could not be found.
	*
	* @param companyId the primary key of the custom company
	* @return the custom company
	* @throws NoSuchCustomCompanyException if a custom company with the primary key could not be found
	*/
	public static CustomCompany findByPrimaryKey(long companyId)
		throws com.sphms.common.service.exception.NoSuchCustomCompanyException {
		return getPersistence().findByPrimaryKey(companyId);
	}

	/**
	* Returns the custom company with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyId the primary key of the custom company
	* @return the custom company, or <code>null</code> if a custom company with the primary key could not be found
	*/
	public static CustomCompany fetchByPrimaryKey(long companyId) {
		return getPersistence().fetchByPrimaryKey(companyId);
	}

	public static java.util.Map<java.io.Serializable, CustomCompany> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the custom companies.
	*
	* @return the custom companies
	*/
	public static List<CustomCompany> findAll() {
		return getPersistence().findAll();
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
	public static List<CustomCompany> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<CustomCompany> findAll(int start, int end,
		OrderByComparator<CustomCompany> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<CustomCompany> findAll(int start, int end,
		OrderByComparator<CustomCompany> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the custom companies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of custom companies.
	*
	* @return the number of custom companies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomCompanyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CustomCompanyPersistence, CustomCompanyPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CustomCompanyPersistence.class);
}