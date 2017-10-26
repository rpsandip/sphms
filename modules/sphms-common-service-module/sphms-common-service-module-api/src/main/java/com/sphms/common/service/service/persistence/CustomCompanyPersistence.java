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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sphms.common.service.exception.NoSuchCustomCompanyException;
import com.sphms.common.service.model.CustomCompany;

/**
 * The persistence interface for the custom company service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.CustomCompanyPersistenceImpl
 * @see CustomCompanyUtil
 * @generated
 */
@ProviderType
public interface CustomCompanyPersistence extends BasePersistence<CustomCompany> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomCompanyUtil} to access the custom company persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the custom company in the entity cache if it is enabled.
	*
	* @param customCompany the custom company
	*/
	public void cacheResult(CustomCompany customCompany);

	/**
	* Caches the custom companies in the entity cache if it is enabled.
	*
	* @param customCompanies the custom companies
	*/
	public void cacheResult(java.util.List<CustomCompany> customCompanies);

	/**
	* Creates a new custom company with the primary key. Does not add the custom company to the database.
	*
	* @param companyId the primary key for the new custom company
	* @return the new custom company
	*/
	public CustomCompany create(long companyId);

	/**
	* Removes the custom company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyId the primary key of the custom company
	* @return the custom company that was removed
	* @throws NoSuchCustomCompanyException if a custom company with the primary key could not be found
	*/
	public CustomCompany remove(long companyId)
		throws NoSuchCustomCompanyException;

	public CustomCompany updateImpl(CustomCompany customCompany);

	/**
	* Returns the custom company with the primary key or throws a {@link NoSuchCustomCompanyException} if it could not be found.
	*
	* @param companyId the primary key of the custom company
	* @return the custom company
	* @throws NoSuchCustomCompanyException if a custom company with the primary key could not be found
	*/
	public CustomCompany findByPrimaryKey(long companyId)
		throws NoSuchCustomCompanyException;

	/**
	* Returns the custom company with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyId the primary key of the custom company
	* @return the custom company, or <code>null</code> if a custom company with the primary key could not be found
	*/
	public CustomCompany fetchByPrimaryKey(long companyId);

	@Override
	public java.util.Map<java.io.Serializable, CustomCompany> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the custom companies.
	*
	* @return the custom companies
	*/
	public java.util.List<CustomCompany> findAll();

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
	public java.util.List<CustomCompany> findAll(int start, int end);

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
	public java.util.List<CustomCompany> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomCompany> orderByComparator);

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
	public java.util.List<CustomCompany> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomCompany> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the custom companies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of custom companies.
	*
	* @return the number of custom companies
	*/
	public int countAll();
}