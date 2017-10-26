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
 * Provides the local service utility for SPHMSCommon. This utility wraps
 * {@link com.sphms.common.service.service.impl.SPHMSCommonLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SPHMSCommonLocalService
 * @see com.sphms.common.service.service.base.SPHMSCommonLocalServiceBaseImpl
 * @see com.sphms.common.service.service.impl.SPHMSCommonLocalServiceImpl
 * @generated
 */
@ProviderType
public class SPHMSCommonLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sphms.common.service.service.impl.SPHMSCommonLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean isFolderExist(long groupId, long parentFolderId,
		java.lang.String folderName) {
		return getService().isFolderExist(groupId, parentFolderId, folderName);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry addFileEntry(
		long groupId, long folderId, java.io.File file,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addFileEntry(groupId, folderId, file, fileName);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry updateFileEntry(
		long fileEntryId, long groupId, long folderId, java.io.File file,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateFileEntry(fileEntryId, groupId, folderId, file,
			fileName);
	}

	public static com.liferay.portal.kernel.repository.model.Folder getFolder(
		long groupId, long parentFolderId, java.lang.String folderName) {
		return getService().getFolder(groupId, parentFolderId, folderName);
	}

	public static double getDisplayCharges(double pricePerMonth,
		long displayDurationDays) {
		return getService().getDisplayCharges(pricePerMonth, displayDurationDays);
	}

	public static int getTotalSqFt(java.lang.String[] heigthWidthArray) {
		return getService().getTotalSqFt(heigthWidthArray);
	}

	public static java.lang.String getDLFileURL(
		com.liferay.document.library.kernel.model.DLFileEntry file) {
		return getService().getDLFileURL(file);
	}

	public static java.lang.String getDateTimeDiff(java.util.Date startDate,
		java.util.Date endDate) {
		return getService().getDateTimeDiff(startDate, endDate);
	}

	public static java.lang.String getFinancialYear() {
		return getService().getFinancialYear();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String[] getHeightOrWidth(java.lang.String size) {
		return getService().getHeightOrWidth(size);
	}

	public static java.util.List<com.sphms.common.service.beans.HordingBean> searchHordings(
		java.lang.String keyword, java.lang.String city, int height, int width,
		java.util.Date startDate, java.util.Date endDate, int start, int end) {
		return getService()
				   .searchHordings(keyword, city, height, width, startDate,
			endDate, start, end);
	}

	public static long getDisplayDuration(java.util.Date startDate,
		java.util.Date endDate) {
		return getService().getDisplayDuration(startDate, endDate);
	}

	public static long getGlobalGroupId() {
		return getService().getGlobalGroupId();
	}

	public static SPHMSCommonLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SPHMSCommonLocalService, SPHMSCommonLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SPHMSCommonLocalService.class);
}