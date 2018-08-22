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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPHMSCommonLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SPHMSCommonLocalService
 * @generated
 */
@ProviderType
public class SPHMSCommonLocalServiceWrapper implements SPHMSCommonLocalService,
	ServiceWrapper<SPHMSCommonLocalService> {
	public SPHMSCommonLocalServiceWrapper(
		SPHMSCommonLocalService sphmsCommonLocalService) {
		_sphmsCommonLocalService = sphmsCommonLocalService;
	}

	@Override
	public boolean isFolderExist(long groupId, long parentFolderId,
		java.lang.String folderName) {
		return _sphmsCommonLocalService.isFolderExist(groupId, parentFolderId,
			folderName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry addFileEntry(
		long groupId, long folderId, java.io.File file,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sphmsCommonLocalService.addFileEntry(groupId, folderId, file,
			fileName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry updateFileEntry(
		long fileEntryId, long groupId, long folderId, java.io.File file,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _sphmsCommonLocalService.updateFileEntry(fileEntryId, groupId,
			folderId, file, fileName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder getFolder(
		long groupId, long parentFolderId, java.lang.String folderName) {
		return _sphmsCommonLocalService.getFolder(groupId, parentFolderId,
			folderName);
	}

	@Override
	public double getDisplayCharges(double pricePerMonth,
		long displayDurationDays) {
		return _sphmsCommonLocalService.getDisplayCharges(pricePerMonth,
			displayDurationDays);
	}

	@Override
	public float getTotalSqFt(java.lang.String[] heigthWidthArray) {
		return _sphmsCommonLocalService.getTotalSqFt(heigthWidthArray);
	}

	@Override
	public java.lang.String getDLFileURL(
		com.liferay.document.library.kernel.model.DLFileEntry file) {
		return _sphmsCommonLocalService.getDLFileURL(file);
	}

	@Override
	public java.lang.String getDateTimeDiff(java.util.Date startDate,
		java.util.Date endDate) {
		return _sphmsCommonLocalService.getDateTimeDiff(startDate, endDate);
	}

	@Override
	public java.lang.String getFinancialYear() {
		return _sphmsCommonLocalService.getFinancialYear();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _sphmsCommonLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String[] getHeightOrWidth(java.lang.String size) {
		return _sphmsCommonLocalService.getHeightOrWidth(size);
	}

	@Override
	public java.util.List<com.sphms.common.service.beans.HordingBean> searchHordings(
		java.lang.String keyword, java.lang.String city,
		java.lang.String distinct, int height, int width,
		java.util.Date startDate, java.util.Date endDate, int start, int end) {
		return _sphmsCommonLocalService.searchHordings(keyword, city, distinct,
			height, width, startDate, endDate, start, end);
	}

	@Override
	public long getDisplayDuration(java.util.Date startDate,
		java.util.Date endDate) {
		return _sphmsCommonLocalService.getDisplayDuration(startDate, endDate);
	}

	@Override
	public long getGlobalGroupId() {
		return _sphmsCommonLocalService.getGlobalGroupId();
	}

	@Override
	public long searchHordingCount(java.lang.String keyword,
		java.lang.String city, java.lang.String distinct, int height,
		int width, java.util.Date startDate, java.util.Date endDate) {
		return _sphmsCommonLocalService.searchHordingCount(keyword, city,
			distinct, height, width, startDate, endDate);
	}

	@Override
	public SPHMSCommonLocalService getWrappedService() {
		return _sphmsCommonLocalService;
	}

	@Override
	public void setWrappedService(
		SPHMSCommonLocalService sphmsCommonLocalService) {
		_sphmsCommonLocalService = sphmsCommonLocalService;
	}

	private SPHMSCommonLocalService _sphmsCommonLocalService;
}