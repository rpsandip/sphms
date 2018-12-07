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

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.common.service.service.base.HordingLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the hording local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sphms.common.service.service.HordingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HordingLocalServiceBaseImpl
 * @see com.sphms.common.service.service.HordingLocalServiceUtil
 */
@ProviderType
public class HordingLocalServiceImpl extends HordingLocalServiceBaseImpl {

	Log _log = LogFactoryUtil.getLog(HordingLocalServiceImpl.class.getName());

	/*
	 * Method for add hording detail
	 * 
	 * @see
	 * com.sphms.common.service.service.HordingLocalService#addHording(java.lang
	 * .String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, double, java.io.File,
	 * java.lang.String, java.io.File, java.lang.String, java.io.File,
	 * java.lang.String, long, int, java.lang.String, double, double, long,
	 * long)
	 */
	public Hording addHording(String title, String location, String city, String district, String state,
			String hordingType, String mediaVehicle, String size, double pricePerMonth, File normalImage,
			String normalImageFileName, File shortImage, String shortImageFileName, File longImage,
			String longImageFileName, long landLordId, int ownerType, String upinNo, double mncTax,
			double oterExpPerYear, long createdBy, long modifiedBy) {

		Hording hording = HordingLocalServiceUtil.createHording(CounterLocalServiceUtil.increment());
		hording.setTitle(title);
		hording.setLocation(location);
		hording.setCity(city);
		hording.setDistrict(district);
		hording.setState(state);
		hording.setHordingType(hordingType);
		hording.setMediaVehicle(mediaVehicle);
		hording.setSize(size);
		hording.setPricePerMonth(pricePerMonth);
		hording.setLandLordId(landLordId);
		hording.setOwnerType(ownerType);
		hording.setUpinNo(upinNo);
		hording.setMncTax(mncTax);
		hording.setStatus(0);
		hording.setOtherExpYear(oterExpPerYear);
		hording.setCreatedBy(createdBy);
		hording.setCreateDate(new Date());
		hording.setModifiedBy(modifiedBy);
		hording.setModifiedDate(new Date());

		hording = HordingLocalServiceUtil.addHording(hording);

		if (Validator.isNotNull(hording)) {
			// Add normal, short, long ImageId
			addHordingImages(normalImage, normalImageFileName, shortImage, shortImageFileName, longImage,
					longImageFileName, hording);
		}

		// Update hording with image Id
		hording = HordingLocalServiceUtil.updateHording(hording);

		return hording;
	}

	/*
	 * Method for update hording detail
	 * 
	 * @see
	 * com.sphms.common.service.service.HordingLocalService#updateHording(long,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, double, java.io.File,
	 * java.lang.String, java.io.File, java.lang.String, java.io.File,
	 * java.lang.String, long, int, java.lang.String, double, double, long)
	 */
	public Hording updateHording(long hordingId, String title, String location, String city, String district,
			String state, String hordingType, String mediaVehicle, String size, double pricePerMonth, File normalImage,
			String normalImageFileName, File shortImage, String shortImageFileName, File longImage,
			String longImageFileName, long landLordId, int ownerType, String upinNo, double mncTax,
			double oterExpPerYear, long modifiedBy) {

		try {
			Hording hording = HordingLocalServiceUtil.getHording(hordingId);
			hording.setTitle(title);
			hording.setLocation(location);
			hording.setCity(city);
			hording.setDistrict(district);
			hording.setState(state);
			hording.setHordingType(hordingType);
			hording.setMediaVehicle(mediaVehicle);
			hording.setSize(size);
			hording.setPricePerMonth(pricePerMonth);
			hording.setLandLordId(landLordId);
			hording.setOwnerType(ownerType);
			hording.setUpinNo(upinNo);
			hording.setMncTax(mncTax);
			hording.setOtherExpYear(oterExpPerYear);
			hording.setModifiedBy(modifiedBy);
			hording.setModifiedDate(new Date());

			if (Validator.isNotNull(hording)) {
				// Update Hording images
				updateHordingImages(normalImage, normalImageFileName, shortImage, shortImageFileName, longImage,
						longImageFileName, hording);
			}

			// Update hording detai
			hording = HordingLocalServiceUtil.updateHording(hording);

			return hording;
		} catch (PortalException e) {
			_log.error(e);
			return null;
		}

	}

	/*
	 * Add hording images
	 */
	private void addHordingImages(File normalImage, String normalImageFileName, File shortImage,
			String shortImageFileName, File longImage, String longImageFileName, Hording hording) {
		long globalSiteGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		Folder hordingParentFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PropsUtil.get("hording.image.folder.name"));
		if (globalSiteGroupId != 0 && Validator.isNotNull(hordingParentFolder)) {
			Folder hordingFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId,
					hordingParentFolder.getFolderId(), String.valueOf(hording.getHordingId()));
			if (Validator.isNotNull(hordingFolder)) {

				// Upload normalImage
				try {
					if (Validator.isNotNull(normalImageFileName)) {
						FileEntry normalImageFileEntry = upLoadFile(globalSiteGroupId, normalImage, normalImageFileName,
								hordingFolder.getFolderId());
						hording.setNormalImageId(normalImageFileEntry.getFileEntryId());
					}
				} catch (PortalException e) {
					_log.error(e);
				}

				// Upload shortImage
				try {
					if (Validator.isNotNull(shortImageFileName)) {
						FileEntry shortImageFileEntry = upLoadFile(globalSiteGroupId, shortImage, shortImageFileName,
								hordingFolder.getFolderId());
						hording.setShortImageId(shortImageFileEntry.getFileEntryId());
					}
				} catch (PortalException e) {
					_log.error(e);
				}

				// Upload longImage
				try {
					if (Validator.isNotNull(longImageFileName)) {
						FileEntry longImageFileEntry = upLoadFile(globalSiteGroupId, longImage, longImageFileName,
								hordingFolder.getFolderId());
						hording.setLongImageId(longImageFileEntry.getFileEntryId());
					}
				} catch (PortalException e) {
					_log.error(e);
				}
			}
		}
	}

	/*
	 * Update horing images
	 */
	private void updateHordingImages(File normalImage, String normalImageFileName, File shortImage,
			String shortImageFileName, File longImage, String longImageFileName, Hording hording) {

		long globalSiteGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		Folder hordingParentFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PropsUtil.get("hording.image.folder.name"));
		if (globalSiteGroupId != 0 && Validator.isNotNull(hordingParentFolder)) {

			Folder hordingFolder = SPHMSCommonLocalServiceUtil.getFolder(globalSiteGroupId,
					hordingParentFolder.getFolderId(), String.valueOf(hording.getHordingId()));

			if (Validator.isNotNull(hordingFolder)) {

				// Upload normalImage
				try {
					if (Validator.isNotNull(normalImageFileName)) {
						if (hording.getNormalImageId() > 0) {
							FileEntry normalImageFileEntry = updateFile(hording.getNormalImageId(), globalSiteGroupId,
									normalImage, normalImageFileName, hordingFolder.getFolderId());
						} else {
							FileEntry normalImageFileEntry = upLoadFile(globalSiteGroupId, normalImage,
									normalImageFileName, hordingFolder.getFolderId());
							hording.setNormalImageId(normalImageFileEntry.getFileEntryId());
						}

					}
				} catch (PortalException e) {
					_log.error(e);
				}

				// Upload shortImage
				try {
					if (Validator.isNotNull(shortImageFileName)) {
						if (hording.getShortImageId() > 0) {
							FileEntry shortImageFileEntry = updateFile(hording.getShortImageId(), globalSiteGroupId,
									shortImage, shortImageFileName, hordingFolder.getFolderId());
						} else {
							FileEntry shortImageFileEntry = upLoadFile(globalSiteGroupId, shortImage,
									shortImageFileName, hordingFolder.getFolderId());
							hording.setShortImageId(shortImageFileEntry.getFileEntryId());
						}

					}
				} catch (PortalException e) {
					_log.error(e);
				}

				// Upload longImage
				try {
					if (Validator.isNotNull(longImageFileName)) {
						if (hording.getLongImageId() > 0) {
							FileEntry longImageFileEntry = updateFile(hording.getLongImageId(), globalSiteGroupId,
									longImage, longImageFileName, hordingFolder.getFolderId());
						} else {
							FileEntry longImageFileEntry = upLoadFile(globalSiteGroupId, longImage, longImageFileName,
									hordingFolder.getFolderId());
							hording.setLongImageId(longImageFileEntry.getFileEntryId());
						}

					}
				} catch (PortalException e) {
					_log.error(e);
				}
			}
		}
	}

	/*
	 * Method for get all active hording list
	 * 
	 * @see
	 * com.sphms.common.service.service.HordingLocalService#getActiveHoringList(
	 * int, int)
	 */
	public List<Hording> getActiveHoringList(int start, int end) {
		List<Hording> hordingList = new ArrayList<Hording>();
		DynamicQuery dynamicQuery = HordingLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(0));
		dynamicQuery.setLimit(start, end);
		Order defaultOrder = OrderFactoryUtil.desc("createDate");
		dynamicQuery.addOrder(defaultOrder);
		hordingList = HordingLocalServiceUtil.dynamicQuery(dynamicQuery);
		return hordingList;
	}

	/*
	 * Method for get active hordings of landlord.
	 */
	public List<Hording> getLandLordHordingList(long landLordId) {
		return hordingPersistence.findBylandLordId(landLordId, 0);
	}

	/**
	 * This method will a common method to reterive a hordings Report
	 * 
	 * @param landLoadId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public JSONObject getHordingsFilter(long hordingId, String startDate, String endDate) {

		List<Object> hordingDetail = hordingFinder.findHordingsFilter(hordingId, startDate, endDate);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		double sumOFTHCharg=0.0;
		double sumOFTPharg=0.0;
		double sumOfTMCharg=0.0;
		double sumOfgrandTotal=0.0;
		for (Object row : hordingDetail) {
			Object[] detailObj = (Object[]) row;
			JSONObject proposalJsonObj = JSONFactoryUtil.createJSONObject();
			proposalJsonObj.put("title", String.valueOf(detailObj[0]));
			proposalJsonObj.put("city", detailObj[1]);
			proposalJsonObj.put("display", detailObj[2]);
			proposalJsonObj.put("clientName", detailObj[3]);
			String[] size = StringUtil.split(String.valueOf(detailObj[4]), 'X');
			if (size.length > 0) {
				proposalJsonObj.put("size_X", size[0]);
				proposalJsonObj.put("size_Y", size[1]);
				float area= Float.parseFloat(size[0]) * Float.parseFloat(size[1]);
				proposalJsonObj.put("area", String.valueOf(area));
			} else {
				proposalJsonObj.put("size_X", "");
				proposalJsonObj.put("size_Y", "");
				proposalJsonObj.put("area", "");
			}
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				Date hordingStartDate = formatter.parse(String.valueOf(detailObj[7]));
				Date hordingEndDate = formatter.parse(String.valueOf(detailObj[8]));
				String displayDuration=sphmsCommonLocalService.getDateTimeDiff(hordingStartDate, hordingEndDate);
				proposalJsonObj.put("displayDuration", displayDuration);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				proposalJsonObj.put("displayDuration", "");
			}
			Double grandTotalVal=Double.valueOf(String.valueOf(detailObj[10])) + Double.valueOf(String.valueOf(detailObj[11])) + Double.valueOf(String.valueOf(detailObj[12]));
			proposalJsonObj.put("units", detailObj[5]);
			proposalJsonObj.put("hordingType", detailObj[6]);
			if(Validator.isNotNull(detailObj[7])){
				try{
					proposalJsonObj.put("hordingBookingStartDate", df.format(formatter.parse(String.valueOf(detailObj[7]))));
				}catch(ParseException e){
					_log.error("hordingBookingStartDate date parsing error ");
				}
			}else{
				proposalJsonObj.put("hordingBookingStartDate", "");
			}
			
			if(Validator.isNotNull(detailObj[8])){
				try{
					proposalJsonObj.put("hordingBookingEndDate", df.format(formatter.parse(String.valueOf(detailObj[8]))));
				}catch(ParseException e){
					_log.error("hordingBookingEndDate date parsing error ");
				}
			}else{
				proposalJsonObj.put("hordingBookingEndDate", "");
			}
		
			proposalJsonObj.put("pricePerMonth", detailObj[9]);
			proposalJsonObj.put("totalMountingCharge", detailObj[10]);
			proposalJsonObj.put("totalPrintingCharge", detailObj[11]);
			proposalJsonObj.put("totalHordingCharge", detailObj[12]);
			proposalJsonObj.put("grandTotal",grandTotalVal);
			

			sumOfTMCharg =sumOfTMCharg+Double.valueOf(String.valueOf(detailObj[10]));
			sumOFTPharg =sumOFTPharg+Double.valueOf(String.valueOf(detailObj[11]));
			sumOFTHCharg  =sumOFTHCharg+Double.valueOf(String.valueOf(detailObj[12]));
			sumOfgrandTotal = sumOfgrandTotal + grandTotalVal;
			dataArray.put(proposalJsonObj);
		}
		responseObj.put("sumOfTMCharg", Math.round(sumOfTMCharg));
		responseObj.put("sumOFTPharg", Math.round(sumOFTPharg));
		responseObj.put("sumOFTHCharg", Math.round(sumOFTHCharg));
		responseObj.put("sumOFTHCharg", Math.round(sumOFTHCharg));
		responseObj.put("sumOfgrandTotal", Math.round(sumOfgrandTotal));
		responseObj.put("hordingArray", dataArray);
		return responseObj;
	}

	private static FileEntry upLoadFile(long groupId, File file, String fileName, long folderId)
			throws PortalException {
		FileEntry fileEntry = SPHMSCommonLocalServiceUtil.addFileEntry(groupId, folderId, file, fileName);
		return fileEntry;
	}

	private static FileEntry updateFile(long fileEntryId, long groupId, File file, String fileName, long folderId)
			throws PortalException {
		FileEntry fileEntry = SPHMSCommonLocalServiceUtil.updateFileEntry(fileEntryId, groupId, folderId, file,
				fileName);
		return fileEntry;
	}
}