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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Dummy;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.Billing_HordingBean;
import com.sphms.common.service.beans.HordingBean;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.Booking_HordingLocalServiceUtil;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.base.SPHMSCommonLocalServiceBaseImpl;
import com.sphms.common.service.util.BookingStatus;

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
	
	public List<HordingBean> searchHordings(String keyword, String city, String distinct,int height, int width, Date startDate, Date endDate, int start, int end){
		List<HordingBean> searchedHordingList = new ArrayList<HordingBean>();
		
		DynamicQuery dynamicQuery = getDynamicQueryForSearchHording(keyword, city, distinct,height, width, startDate, endDate, start, end);
		
		List<Hording> hordingList = HordingLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		for(Hording hording : hordingList){
			HordingBean hordingBean = new HordingBean(hording);
			searchedHordingList.add(hordingBean);
		}
		
		return searchedHordingList;
	}
	
	public long searchHordingCount(String keyword, String city, String distinct,int height, int width, Date startDate, Date endDate){
		
		long totalHording=0;
		
		DynamicQuery dynamicQuery = getDynamicQueryForSearchHording(keyword, city, distinct,height, width, startDate, endDate, -1, -1);
		
		totalHording = HordingLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		
		return totalHording;
	}
	
	
	private DynamicQuery getDynamicQueryForSearchHording(String keyword, String city, String distinct,int height, int width, Date startDate, Date endDate, int start, int end){
		
		DynamicQuery dynamicQuery = HordingLocalServiceUtil.dynamicQuery();

		Criterion criterion = RestrictionsFactoryUtil.like("title", StringPool.PERCENT +keyword+StringPool.PERCENT);
		
		if(Validator.isNotNull(city)){
			Criterion cityCriterion = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.like("city", StringPool.PERCENT +city+StringPool.PERCENT),
					RestrictionsFactoryUtil.like("location", StringPool.PERCENT +city+StringPool.PERCENT));
			criterion = RestrictionsFactoryUtil.and(criterion, cityCriterion);
		}
		
		if(Validator.isNotNull(distinct)){
			criterion = RestrictionsFactoryUtil.and(criterion ,RestrictionsFactoryUtil.like("district",StringPool.PERCENT +distinct+StringPool.PERCENT));
		}
		
		if(height!=0){
			criterion = RestrictionsFactoryUtil.and(criterion ,RestrictionsFactoryUtil.like("size",StringPool.PERCENT+"X"+height));
		}
		if(width!=0){
			criterion = RestrictionsFactoryUtil.and(criterion ,RestrictionsFactoryUtil.like("size",width+"X"+StringPool.PERCENT));
		}
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			 // TODO :: need to check hording in booking table
			
			DynamicQuery bookingQuery = BookingLocalServiceUtil.dynamicQuery();
			bookingQuery.setProjection(ProjectionFactoryUtil.property("bookingId"));
			Criterion dateCriteria = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.between("startDate", startDate, endDate),
					RestrictionsFactoryUtil.between("endDate", startDate, endDate));
			
			Criterion dateCriteria2 =  RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.le("startDate", startDate), RestrictionsFactoryUtil.le("startDate", endDate)),
					RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.ge("endDate", startDate), RestrictionsFactoryUtil.ge("endDate", endDate)));
			
			Criterion dateCriteria3 = RestrictionsFactoryUtil.or(dateCriteria, dateCriteria2);
			

			Criterion statusCriteria = RestrictionsFactoryUtil.eq("status", BookingStatus.ACTIVE.getValue());
			
			Criterion finalCriteria = RestrictionsFactoryUtil.and(dateCriteria3, statusCriteria);
			
			
			bookingQuery.add(finalCriteria);
			
			
			DynamicQuery bookingHordingQuery = Booking_HordingLocalServiceUtil.dynamicQuery();
			bookingHordingQuery.setProjection(ProjectionFactoryUtil.property("primaryKey.hordingId"));
			bookingHordingQuery.add(PropertyFactoryUtil.forName("primaryKey.bookingId").in(bookingQuery));
			
			Criterion finalDateCriteria = PropertyFactoryUtil.forName("hordingId").notIn(bookingHordingQuery);
			
			criterion = RestrictionsFactoryUtil.and(criterion, finalDateCriteria);
		}
		
		if(Validator.isNotNull(criterion)){
			dynamicQuery.add(criterion);
		}
		
		if(start!=-1 && end!=-1){
			dynamicQuery.setLimit(start, end);
		}
		
		return dynamicQuery;
	}
	
	@Override
	  public String getDateTimeDiff(Date startDate, Date endDate) {
	    String finalTime = "";
	    long timeDifInMillis = endDate.getTime() - startDate.getTime();

	    Date dateDiff = new Date(timeDifInMillis);
	    Calendar diffCal = Calendar.getInstance();
	    diffCal.setTime(dateDiff);
	    int daysDiff = diffCal.get(Calendar.DAY_OF_MONTH);
	    int monthDiff = diffCal.get(Calendar.MONTH);
	    int yearDiff = (diffCal.get(Calendar.YEAR)-1970);
	  
	    if(timeDifInMillis>0){
	    	if(yearDiff==1){
	    		finalTime = finalTime + yearDiff + " year ";
	    	}else if(yearDiff>0){
	    		finalTime = finalTime + yearDiff + " years ";
	    	}
	    	if(monthDiff==1){
	    		finalTime = finalTime + monthDiff + " month ";
	    	}else if(monthDiff>0){
	    		finalTime = finalTime + monthDiff + " months ";
	    	}
	    	if(daysDiff==1){
	    		finalTime = finalTime + daysDiff + " day ";
	    	}else if(daysDiff>0){
	    		finalTime = finalTime + daysDiff + " days ";
	    	}
	    }else{
	    	finalTime = finalTime + " 1 day";
	    }
	    
	    return finalTime;
	}
	
	public String getFinancialYear(){
			String financialYear = StringPool.BLANK;
			int year = Calendar.getInstance().get(Calendar.YEAR);

		    int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		    System.out.println("Financial month : " + month);
		    if (month < 3) {
		    	financialYear = (year - 1) + "-" + getLastDigitOfFinanceYear();
		    } else {
		    	financialYear =  year + "-" + (Integer.parseInt(getLastDigitOfFinanceYear())+ 1);
		    }
		    return financialYear;
	}
	
	private String getLastDigitOfFinanceYear(){
		DateFormat df = new SimpleDateFormat("yy"); // Just the year, with 2 digits
		String formattedDate = df.format(Calendar.getInstance().getTime());
		return formattedDate;
	}
	
	public  String[] getHeightOrWidth(String size){
		String[] sizeArray = new String[2];
		if(size.indexOf("X")>0){
			 sizeArray = size.split("X");
		}
		return sizeArray;
	}
	
	public float getTotalSqFt(String[] heigthWidthArray){
		float height = Float.parseFloat(heigthWidthArray[1]);
		float width  = Float.parseFloat(heigthWidthArray[0]);
		return height*width;
	}
	
	public  long getDisplayDuration(Date startDate, Date endDate){
	    long diff = endDate.getTime() - startDate.getTime();
	    // Need to add 1 days because for same start and end date below equiation gives 0 and we have to consider 
	    // as 1. Same for other dates.
	    return (diff / (1000*60*60*24))+1;
	}
	
	public  double getDisplayCharges(double pricePerMonth, long displayDurationDays){
		// Considering month days are 30.
		return Math.round((pricePerMonth/30)*displayDurationDays);
	}
	
	public  double getTotalHordingDisplayCharges(List<Billing_HordingBean> billingHordingList){
		double totalHordingDisplayCharges=0d;
		for(Billing_HordingBean billingHording : billingHordingList){
			totalHordingDisplayCharges+=billingHording.getTotalHordingCharge();
		}
		return Math.round(totalHordingDisplayCharges);
	}
	
	public  double getTotalPrintingChage(List<Billing_HordingBean> billingHordingList){
		double totalPrintingChargeList =0d;
		for(Billing_HordingBean billingHording : billingHordingList){
			totalPrintingChargeList+=billingHording.getTotalPrintingCharge();
		}
		return Math.round(totalPrintingChargeList);
	}
	
	public  double getTotalMountingChage(List<Billing_HordingBean> billingHordingList){
		double totalMoutingChargeList =0d;
		for(Billing_HordingBean billingHording : billingHordingList){
			totalMoutingChargeList+=billingHording.getTotalMountingCharge();
		}
		return Math.round(totalMoutingChargeList);
	}
	
	public  Client getClient(long clientId){
		Client client = null;
		try {
			client = ClientLocalServiceUtil.getClient(clientId);
		} catch (PortalException e) {
			LOG.error(e);
		}
		return client;
	}
	
	public  boolean isClientOutOfGujrat(Client client){
		if(Validator.isNotNull(client) && Validator.isNotNull(client.getState()) && !client.getState().toLowerCase().equalsIgnoreCase("gujarat")){
			return true;
		}
		return false;
	}
}