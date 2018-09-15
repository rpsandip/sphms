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

import com.liferay.document.library.kernel.model.DLFileEntry;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.sphms.common.service.beans.Billing_HordingBean;
import com.sphms.common.service.beans.HordingBean;
import com.sphms.common.service.model.Client;

import java.io.File;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for SPHMSCommon. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SPHMSCommonLocalServiceUtil
 * @see com.sphms.common.service.service.base.SPHMSCommonLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.SPHMSCommonLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPHMSCommonLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPHMSCommonLocalServiceUtil} to access the s p h m s common local service. Add custom service methods to {@link com.sphms.common.service.service.impl.SPHMSCommonLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isClientOutOfGujrat(Client client);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isFolderExist(long groupId, long parentFolderId,
		java.lang.String folderName);

	public FileEntry addFileEntry(long groupId, long folderId, File file,
		java.lang.String fileName) throws PortalException;

	public FileEntry updateFileEntry(long fileEntryId, long groupId,
		long folderId, File file, java.lang.String fileName)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Folder getFolder(long groupId, long parentFolderId,
		java.lang.String folderName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Client getClient(long clientId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getDisplayCharges(double pricePerMonth,
		long displayDurationDays);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalHordingDisplayCharges(
		List<Billing_HordingBean> billingHordingList);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalMountingChage(
		List<Billing_HordingBean> billingHordingList);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getTotalPrintingChage(
		List<Billing_HordingBean> billingHordingList);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public float getTotalSqFt(java.lang.String[] heigthWidthArray);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getDLFileURL(DLFileEntry file);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getDateTimeDiff(Date startDate, Date endDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getFinancialYear();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String[] getHeightOrWidth(java.lang.String size);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<HordingBean> searchHordings(java.lang.String keyword,
		java.lang.String city, java.lang.String distinct, int height,
		int width, Date startDate, Date endDate, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDisplayDuration(Date startDate, Date endDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getGlobalGroupId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long searchHordingCount(java.lang.String keyword,
		java.lang.String city, java.lang.String distinct, int height,
		int width, Date startDate, Date endDate);
}