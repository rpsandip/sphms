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

import com.sphms.common.service.model.Client;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the client service. This utility wraps {@link com.sphms.common.service.service.persistence.impl.ClientPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientPersistence
 * @see com.sphms.common.service.service.persistence.impl.ClientPersistenceImpl
 * @generated
 */
@ProviderType
public class ClientUtil {
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
	public static void clearCache(Client client) {
		getPersistence().clearCache(client);
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
	public static List<Client> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Client> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Client> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Client> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Client update(Client client) {
		return getPersistence().update(client);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Client update(Client client, ServiceContext serviceContext) {
		return getPersistence().update(client, serviceContext);
	}

	/**
	* Returns all the clients where status = &#63;.
	*
	* @param status the status
	* @return the matching clients
	*/
	public static List<Client> findBystatus(int status) {
		return getPersistence().findBystatus(status);
	}

	/**
	* Returns a range of all the clients where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @return the range of matching clients
	*/
	public static List<Client> findBystatus(int status, int start, int end) {
		return getPersistence().findBystatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the clients where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching clients
	*/
	public static List<Client> findBystatus(int status, int start, int end,
		OrderByComparator<Client> orderByComparator) {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the clients where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching clients
	*/
	public static List<Client> findBystatus(int status, int start, int end,
		OrderByComparator<Client> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first client in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching client
	* @throws NoSuchClientException if a matching client could not be found
	*/
	public static Client findBystatus_First(int status,
		OrderByComparator<Client> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchClientException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the first client in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching client, or <code>null</code> if a matching client could not be found
	*/
	public static Client fetchBystatus_First(int status,
		OrderByComparator<Client> orderByComparator) {
		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last client in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching client
	* @throws NoSuchClientException if a matching client could not be found
	*/
	public static Client findBystatus_Last(int status,
		OrderByComparator<Client> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchClientException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last client in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching client, or <code>null</code> if a matching client could not be found
	*/
	public static Client fetchBystatus_Last(int status,
		OrderByComparator<Client> orderByComparator) {
		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the clients before and after the current client in the ordered set where status = &#63;.
	*
	* @param clientId the primary key of the current client
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next client
	* @throws NoSuchClientException if a client with the primary key could not be found
	*/
	public static Client[] findBystatus_PrevAndNext(long clientId, int status,
		OrderByComparator<Client> orderByComparator)
		throws com.sphms.common.service.exception.NoSuchClientException {
		return getPersistence()
				   .findBystatus_PrevAndNext(clientId, status, orderByComparator);
	}

	/**
	* Removes all the clients where status = &#63; from the database.
	*
	* @param status the status
	*/
	public static void removeBystatus(int status) {
		getPersistence().removeBystatus(status);
	}

	/**
	* Returns the number of clients where status = &#63;.
	*
	* @param status the status
	* @return the number of matching clients
	*/
	public static int countBystatus(int status) {
		return getPersistence().countBystatus(status);
	}

	/**
	* Caches the client in the entity cache if it is enabled.
	*
	* @param client the client
	*/
	public static void cacheResult(Client client) {
		getPersistence().cacheResult(client);
	}

	/**
	* Caches the clients in the entity cache if it is enabled.
	*
	* @param clients the clients
	*/
	public static void cacheResult(List<Client> clients) {
		getPersistence().cacheResult(clients);
	}

	/**
	* Creates a new client with the primary key. Does not add the client to the database.
	*
	* @param clientId the primary key for the new client
	* @return the new client
	*/
	public static Client create(long clientId) {
		return getPersistence().create(clientId);
	}

	/**
	* Removes the client with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientId the primary key of the client
	* @return the client that was removed
	* @throws NoSuchClientException if a client with the primary key could not be found
	*/
	public static Client remove(long clientId)
		throws com.sphms.common.service.exception.NoSuchClientException {
		return getPersistence().remove(clientId);
	}

	public static Client updateImpl(Client client) {
		return getPersistence().updateImpl(client);
	}

	/**
	* Returns the client with the primary key or throws a {@link NoSuchClientException} if it could not be found.
	*
	* @param clientId the primary key of the client
	* @return the client
	* @throws NoSuchClientException if a client with the primary key could not be found
	*/
	public static Client findByPrimaryKey(long clientId)
		throws com.sphms.common.service.exception.NoSuchClientException {
		return getPersistence().findByPrimaryKey(clientId);
	}

	/**
	* Returns the client with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clientId the primary key of the client
	* @return the client, or <code>null</code> if a client with the primary key could not be found
	*/
	public static Client fetchByPrimaryKey(long clientId) {
		return getPersistence().fetchByPrimaryKey(clientId);
	}

	public static java.util.Map<java.io.Serializable, Client> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the clients.
	*
	* @return the clients
	*/
	public static List<Client> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the clients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @return the range of clients
	*/
	public static List<Client> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the clients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of clients
	*/
	public static List<Client> findAll(int start, int end,
		OrderByComparator<Client> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the clients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of clients
	* @param end the upper bound of the range of clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of clients
	*/
	public static List<Client> findAll(int start, int end,
		OrderByComparator<Client> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the clients from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of clients.
	*
	* @return the number of clients
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ClientPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClientPersistence, ClientPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ClientPersistence.class);
}