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

import com.sphms.common.service.exception.NoSuchHordingException;
import com.sphms.common.service.model.Hording;

/**
 * The persistence interface for the hording service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sphms.common.service.service.persistence.impl.HordingPersistenceImpl
 * @see HordingUtil
 * @generated
 */
@ProviderType
public interface HordingPersistence extends BasePersistence<Hording> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HordingUtil} to access the hording persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the hordings where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @return the matching hordings
	*/
	public java.util.List<Hording> findBylandLordId(long landLordId, int status);

	/**
	* Returns a range of all the hordings where landLordId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @return the range of matching hordings
	*/
	public java.util.List<Hording> findBylandLordId(long landLordId,
		int status, int start, int end);

	/**
	* Returns an ordered range of all the hordings where landLordId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching hordings
	*/
	public java.util.List<Hording> findBylandLordId(long landLordId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator);

	/**
	* Returns an ordered range of all the hordings where landLordId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching hordings
	*/
	public java.util.List<Hording> findBylandLordId(long landLordId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hording
	* @throws NoSuchHordingException if a matching hording could not be found
	*/
	public Hording findBylandLordId_First(long landLordId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator)
		throws NoSuchHordingException;

	/**
	* Returns the first hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hording, or <code>null</code> if a matching hording could not be found
	*/
	public Hording fetchBylandLordId_First(long landLordId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator);

	/**
	* Returns the last hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hording
	* @throws NoSuchHordingException if a matching hording could not be found
	*/
	public Hording findBylandLordId_Last(long landLordId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator)
		throws NoSuchHordingException;

	/**
	* Returns the last hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hording, or <code>null</code> if a matching hording could not be found
	*/
	public Hording fetchBylandLordId_Last(long landLordId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator);

	/**
	* Returns the hordings before and after the current hording in the ordered set where landLordId = &#63; and status = &#63;.
	*
	* @param hordingId the primary key of the current hording
	* @param landLordId the land lord ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hording
	* @throws NoSuchHordingException if a hording with the primary key could not be found
	*/
	public Hording[] findBylandLordId_PrevAndNext(long hordingId,
		long landLordId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator)
		throws NoSuchHordingException;

	/**
	* Removes all the hordings where landLordId = &#63; and status = &#63; from the database.
	*
	* @param landLordId the land lord ID
	* @param status the status
	*/
	public void removeBylandLordId(long landLordId, int status);

	/**
	* Returns the number of hordings where landLordId = &#63; and status = &#63;.
	*
	* @param landLordId the land lord ID
	* @param status the status
	* @return the number of matching hordings
	*/
	public int countBylandLordId(long landLordId, int status);

	/**
	* Caches the hording in the entity cache if it is enabled.
	*
	* @param hording the hording
	*/
	public void cacheResult(Hording hording);

	/**
	* Caches the hordings in the entity cache if it is enabled.
	*
	* @param hordings the hordings
	*/
	public void cacheResult(java.util.List<Hording> hordings);

	/**
	* Creates a new hording with the primary key. Does not add the hording to the database.
	*
	* @param hordingId the primary key for the new hording
	* @return the new hording
	*/
	public Hording create(long hordingId);

	/**
	* Removes the hording with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hordingId the primary key of the hording
	* @return the hording that was removed
	* @throws NoSuchHordingException if a hording with the primary key could not be found
	*/
	public Hording remove(long hordingId) throws NoSuchHordingException;

	public Hording updateImpl(Hording hording);

	/**
	* Returns the hording with the primary key or throws a {@link NoSuchHordingException} if it could not be found.
	*
	* @param hordingId the primary key of the hording
	* @return the hording
	* @throws NoSuchHordingException if a hording with the primary key could not be found
	*/
	public Hording findByPrimaryKey(long hordingId)
		throws NoSuchHordingException;

	/**
	* Returns the hording with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hordingId the primary key of the hording
	* @return the hording, or <code>null</code> if a hording with the primary key could not be found
	*/
	public Hording fetchByPrimaryKey(long hordingId);

	@Override
	public java.util.Map<java.io.Serializable, Hording> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the hordings.
	*
	* @return the hordings
	*/
	public java.util.List<Hording> findAll();

	/**
	* Returns a range of all the hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @return the range of hordings
	*/
	public java.util.List<Hording> findAll(int start, int end);

	/**
	* Returns an ordered range of all the hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hordings
	*/
	public java.util.List<Hording> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator);

	/**
	* Returns an ordered range of all the hordings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HordingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hordings
	* @param end the upper bound of the range of hordings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of hordings
	*/
	public java.util.List<Hording> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hording> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the hordings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of hordings.
	*
	* @return the number of hordings
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}