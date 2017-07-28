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

import java.util.Date;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.base.ClientLocalServiceBaseImpl;

/**
 * The implementation of the client local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.ClientLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClientLocalServiceBaseImpl
 * @see com.sphms.common.service.service.ClientLocalServiceUtil
 */
@ProviderType
public class ClientLocalServiceImpl extends ClientLocalServiceBaseImpl {
	
	
	/*
	 * Method for add Client detail
	 */
	public Client addClient(String clientName, String address1, String address2, String city, String state,
			String contactPersonName, String contactPersonPhoneNo, String contactPersonEmail, long createdBy){
		
		Client client = ClientLocalServiceUtil.createClient(CounterLocalServiceUtil.increment());
		client.setClientName(clientName);
		client.setAddress1(address1);
		client.setAddress2(address2);
		client.setCity(city);
		client.setState(state);
		client.setContactPersonName(contactPersonName);
		client.setContactPersonPhoneNo(contactPersonPhoneNo);
		client.setContactPersonEmail(contactPersonEmail);
		client.setCreateDate(new Date());
		client.setCreatedBy(createdBy);
		client = ClientLocalServiceUtil.addClient(client);
		
		return client;
	}
	
	
	/*
	 * Method for update client detail
	 */
	public Client updateClient(long clientId,String clientName, String address1, String address2, String city, String state,
			String contactPersonName, String contactPersonPhoneNo, String contactPersonEmail, long createdBy) throws PortalException{
		
		Client client = ClientLocalServiceUtil.getClient(clientId);
		client.setClientName(clientName);
		client.setAddress1(address1);
		client.setAddress2(address2);
		client.setCity(city);
		client.setState(state);
		client.setContactPersonName(contactPersonName);
		client.setContactPersonPhoneNo(contactPersonPhoneNo);
		client.setContactPersonEmail(contactPersonEmail);
		client.setCreateDate(new Date());
		client.setCreatedBy(createdBy);
		
		client = ClientLocalServiceUtil.updateClient(client);
		
		return client;
	}
}