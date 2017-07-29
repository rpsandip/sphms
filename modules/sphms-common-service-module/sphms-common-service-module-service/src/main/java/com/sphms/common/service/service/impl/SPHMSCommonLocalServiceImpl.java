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

import java.io.File;

import org.omg.PortableServer.POAPackage.ServantAlreadyActive;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringParser;
import com.liferay.portal.kernel.util.StringPool;
import com.sphms.common.service.service.base.SPHMSCommonLocalServiceBaseImpl;

/**
 * The implementation of the s p h m s common local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.SPHMSCommonLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SPHMSCommonLocalServiceBaseImpl
 * @see com.sphms.common.service.service.SPHMSCommonLocalServiceUtil
 */
@ProviderType
public class SPHMSCommonLocalServiceImpl extends SPHMSCommonLocalServiceBaseImpl {
	
	private Log LOG = LogFactoryUtil.getLog(SPHMSCommonLocalServiceImpl.class.getName());
	
	public boolean isFolderExist(long groupId,long parentFolderId,String folderName){
		boolean folderExist = false;
		try { 
			DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName); 
			folderExist = true;
		} catch (Exception e) {	
			//LOG.error(e.getMessage(), e);
		} 
		return folderExist; 
	}
	
	public Folder getFolder(long groupId, long parentFolderId,String folderName) { 
		boolean defaultFolderExist = isFolderExist(groupId,parentFolderId,String.valueOf(folderName)); 
		Folder patientFolder=null;
		if (!defaultFolderExist) {
			long repositoryId = groupId;
			try {
				ServiceContext serviceContext = new ServiceContext(); 
				patientFolder = DLAppServiceUtil.addFolder(repositoryId,parentFolderId, folderName,"", serviceContext);
			} catch (PortalException e1) { 
				LOG.error(e1.getMessage(), e1);
			} catch (SystemException e1) {
				LOG.error(e1.getMessage(), e1);
			}	
		}else{
			try {
				patientFolder =	DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			} catch (PortalException e1) {
				LOG.error(e1.getMessage(), e1);
			}
		}
		return patientFolder;
	}
	
	public FileEntry addFileEntry(long groupId, long folderId, File file, String fileName) throws PortalException{
		ServiceContext serviceContext = new ServiceContext(); 
		return DLAppServiceUtil.addFileEntry(groupId, folderId, fileName, MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, "", file, serviceContext);
	}
	
	public FileEntry updateFileEntry(long fileEntryId,long groupId, long folderId, File file, String fileName) throws PortalException{
		ServiceContext serviceContext = new ServiceContext(); 
		return DLAppServiceUtil.updateFileEntry(fileEntryId, fileName, MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, "", true, file, serviceContext);
	}
	
	public long getGlobalGroupId(){
		try {
			return GroupLocalServiceUtil.getCompanyGroup(PortalUtil.getDefaultCompanyId()).getGroupId();
		} catch (PortalException e) {
		}
		return 0l;
	}
	
	public String getDLFileURL(DLFileEntry file) {
	       return "/documents/" + file.getGroupId() + StringPool.FORWARD_SLASH + file.getFolderId() + StringPool.FORWARD_SLASH
	            + file.getTitle() + StringPool.FORWARD_SLASH + file.getUuid();
	}
}