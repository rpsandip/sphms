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
import aQute.bnd.properties.GapTextStore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
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
	
	Log _log = LogFactoryUtil.getLog(ClientLocalServiceImpl.class.getName());
	
	/*
	 * Method for add Client detail
	 */
	public Client addClient(String clientName, String address1, String address2, String city, String state,
			String contactPersonName, String contactPersonPhoneNo, String contactPersonEmail, String panNo, String gstNo,long createdBy){
		
		_log.info("Adding Client :: clientName->" + clientName + " Address1->" + address1 + " Address2->" + address2 +
				" city->" + city + " state ->" + state + " contactPersonName ->" + contactPersonName + " contactPersonEmail ->" +
				contactPersonEmail + " contactPersonPhoneNo->" + contactPersonPhoneNo); 
		
		boolean isValidParams = isValidParam(clientName, address1, city, state, contactPersonName, contactPersonPhoneNo, contactPersonEmail);
		
		if(isValidParams){
		Client client = ClientLocalServiceUtil.createClient(CounterLocalServiceUtil.increment());
		client.setClientName(clientName);
		client.setAddress1(address1);
		client.setAddress2(address2);
		client.setCity(city);
		client.setState(state);
		client.setPanNo(panNo);
		client.setGstNo(gstNo);
		client.setStatus(0);
		client.setContactPersonName(contactPersonName);
		client.setContactPersonPhoneNo(contactPersonPhoneNo);
		client.setContactPersonEmail(contactPersonEmail);
		client.setCreateDate(new Date());
		client.setCreatedBy(createdBy);
		client = ClientLocalServiceUtil.addClient(client);
		
		return client;
		
		}else{
			return null;
		}
	}
	
	
	/*
	 * Method for update client detail
	 */
	public Client updateClient(long clientId,String clientName, String address1, String address2, String city, String state,
			String contactPersonName, String contactPersonPhoneNo, String contactPersonEmail, String panNo, String gstNo,long createdBy) throws PortalException{
		
		_log.info("Updating Client :: clientName->" + clientName + " Address1->" + address1 + " Address2->" + address2 +
				" city->" + city + " state ->" + state + " contactPersonName ->" + contactPersonName + " contactPersonEmail ->" +
				contactPersonEmail + " contactPersonPhoneNo->" + contactPersonPhoneNo); 
		
		
		boolean isValidParams = isValidParam(clientName, address1, city, state, contactPersonName, contactPersonPhoneNo, contactPersonEmail);
		
		if(isValidParams){
		Client client = ClientLocalServiceUtil.getClient(clientId);
		client.setClientName(clientName);
		client.setAddress1(address1);
		client.setAddress2(address2);
		client.setCity(city);
		client.setState(state);
		client.setPanNo(panNo);
		client.setGstNo(gstNo);
		client.setContactPersonName(contactPersonName);
		client.setContactPersonPhoneNo(contactPersonPhoneNo);
		client.setContactPersonEmail(contactPersonEmail);
		client.setCreateDate(new Date());
		client.setCreatedBy(createdBy);
		
		client = ClientLocalServiceUtil.updateClient(client);
		
		return client;
		
		}else{
			return null;
		}
	}
	
	public Client deleteClient(long clientId) throws PortalException{
		Client client = ClientLocalServiceUtil.getClient(clientId);
		client.setStatus(1);
		client = ClientLocalServiceUtil.updateClient(client);
		return client;
	}
	
	
	public List<Client> getClients(){
		return clientPersistence.findBystatus(0);
	}
	
	private boolean isValidParam (String clientName, String address1, String city, String state, String contactPersonName, String contactPersonPhoneNo, String contactPersonEmail){
		boolean isValidParams = false;
		if(Validator.isNotNull(clientName) && Validator.isNotNull(address1) && Validator.isNotNull(city) &&
				Validator.isNotNull(state) && Validator.isNotNull(contactPersonName) && Validator.isNotNull(contactPersonPhoneNo) && Validator.isNotNull(contactPersonEmail)){
			isValidParams = true;
		}
		return isValidParams;
	}
}