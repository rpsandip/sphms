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

import com.sphms.common.service.exception.NoSuchLandLordException;
import com.sphms.common.service.model.LandLord;

/**
 * The persistence interface for the land lord service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.LandLordPersistenceImpl
 * @see LandLordUtil
 * @generated
 */
@ProviderType
public interface LandLordPersistence extends BasePersistence<LandLord> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LandLordUtil} to access the land lord persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the land lord in the entity cache if it is enabled.
	*
	* @param landLord the land lord
	*/
	public void cacheResult(LandLord landLord);

	/**
	* Caches the land lords in the entity cache if it is enabled.
	*
	* @param landLords the land lords
	*/
	public void cacheResult(java.util.List<LandLord> landLords);

	/**
	* Creates a new land lord with the primary key. Does not add the land lord to the database.
	*
	* @param landLordId the primary key for the new land lord
	* @return the new land lord
	*/
	public LandLord create(long landLordId);

	/**
	* Removes the land lord with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param landLordId the primary key of the land lord
	* @return the land lord that was removed
	* @throws NoSuchLandLordException if a land lord with the primary key could not be found
	*/
	public LandLord remove(long landLordId) throws NoSuchLandLordException;

	public LandLord updateImpl(LandLord landLord);

	/**
	* Returns the land lord with the primary key or throws a {@link NoSuchLandLordException} if it could not be found.
	*
	* @param landLordId the primary key of the land lord
	* @return the land lord
	* @throws NoSuchLandLordException if a land lord with the primary key could not be found
	*/
	public LandLord findByPrimaryKey(long landLordId)
		throws NoSuchLandLordException;

	/**
	* Returns the land lord with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param landLordId the primary key of the land lord
	* @return the land lord, or <code>null</code> if a land lord with the primary key could not be found
	*/
	public LandLord fetchByPrimaryKey(long landLordId);

	@Override
	public java.util.Map<java.io.Serializable, LandLord> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the land lords.
	*
	* @return the land lords
	*/
	public java.util.List<LandLord> findAll();

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
	public java.util.List<LandLord> findAll(int start, int end);

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
	public java.util.List<LandLord> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LandLord> orderByComparator);

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
	public java.util.List<LandLord> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LandLord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the land lords from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of land lords.
	*
	* @return the number of land lords
	*/
	public int countAll();
}