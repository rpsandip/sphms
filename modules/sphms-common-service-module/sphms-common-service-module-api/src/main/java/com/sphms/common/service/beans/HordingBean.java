package com.sphms.common.service.beans;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;

public class HordingBean {
	
	private Log _log = LogFactoryUtil.getLog(HordingBean.class.getName());
	
	private long hordingId;
	private String title;
	private String location;
	private String city;
	private String state;
	private String district;
	private long landLordId;
	private String hordingType;
	private String mediaVehicle;
	private String size;
	private float height;
	private float width;
	private double pricePerMonth;
	private long normalImageId;
	private long shortImageId;
	private long longImageId;
	private String ownerType;
	private int ownerTypeInt;
	private String upinNo;
	private double mncTax;
	private double otherExpYear;
	private int status;
	private String landLordName;
	private String normalImageURL;
	private String shortImageURL;
	private String longImageURL;
	
	
	public HordingBean(Hording hording){
		this.hordingId = hording.getHordingId();
		this.title= hording.getTitle();
		this.location = hording.getLocation();
		this.city = hording.getCity();
		this.district = hording.getDistrict();
		this.state = hording.getState();
		this.landLordId = hording.getLandLordId();
		this.hordingType = hording.getHordingType();
		this.mediaVehicle = hording.getMediaVehicle();
		this.size = hording.getSize();
		this.ownerTypeInt = hording.getOwnerType();
		this.pricePerMonth = hording.getPricePerMonth();
		this.normalImageId = hording.getNormalImageId();
		this.shortImageId = hording.getShortImageId();
		this.longImageId = hording.getLongImageId();
		this.ownerType =  OwnerType.getTitle(hording.getOwnerType());
		this.upinNo = hording.getUpinNo();
		this.mncTax = hording.getMncTax();
		this.otherExpYear = hording.getOtherExpYear();
		this.status = hording.getStatus();
		
		if(this.normalImageId>0){
			try {
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(this.normalImageId);
				this.normalImageURL = SPHMSCommonLocalServiceUtil.getDLFileURL(fileEntry);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		if(this.shortImageId>0){
			try {
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(this.shortImageId);
				this.shortImageURL = SPHMSCommonLocalServiceUtil.getDLFileURL(fileEntry);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		if(this.longImageId>0){
			try {
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(this.longImageId);
				this.longImageURL = SPHMSCommonLocalServiceUtil.getDLFileURL(fileEntry);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		if(this.landLordId>0){
			try {
				LandLord landLord = LandLordLocalServiceUtil.getLandLord(this.getLandLordId());
				this.landLordName = landLord.getFirstName() + StringPool.SPACE + landLord.getLastName();
			} catch (PortalException e) {
			}
		}
		if(this.size.indexOf("X")>0){
			String[] sizeArray = this.size.split("X");
			this.height = Float.parseFloat(sizeArray[1]);
			this.width = Float.parseFloat(sizeArray[0]);
		}
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getLandLordId() {
		return landLordId;
	}
	public void setLandLordId(long landLordId) {
		this.landLordId = landLordId;
	}
	public String getHordingType() {
		return hordingType;
	}
	public void setHordingType(String hordingType) {
		this.hordingType = hordingType;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPricePerMonth() {
		return pricePerMonth;
	}
	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}
	public long getNormalImageId() {
		return normalImageId;
	}
	public void setNormalImageId(long normalImageId) {
		this.normalImageId = normalImageId;
	}
	public long getShortImageId() {
		return shortImageId;
	}
	public void setShortImageId(long shortImageId) {
		this.shortImageId = shortImageId;
	}
	public long getLongImageId() {
		return longImageId;
	}
	public void setLongImageId(long longImageId) {
		this.longImageId = longImageId;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public String getUpinNo() {
		return upinNo;
	}
	public void setUpinNo(String upinNo) {
		this.upinNo = upinNo;
	}
	public double getMncTax() {
		return mncTax;
	}
	public void setMncTax(double mncTax) {
		this.mncTax = mncTax;
	}
	public double getOtherExpYear() {
		return otherExpYear;
	}
	public void setOtherExpYear(double otherExpYear) {
		this.otherExpYear = otherExpYear;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNormalImageURL() {
		return normalImageURL;
	}
	public void setNormalImageURL(String normalImageURL) {
		this.normalImageURL = normalImageURL;
	}
	public String getShortImageURL() {
		return shortImageURL;
	}
	public void setShortImageURL(String shortImageURL) {
		this.shortImageURL = shortImageURL;
	}
	public String getLongImageURL() {
		return longImageURL;
	}
	public void setLongImageURL(String longImageURL) {
		this.longImageURL = longImageURL;
	}
	public long getHordingId() {
		return hordingId;
	}
	public void setHordingId(long hordingId) {
		this.hordingId = hordingId;
	}
	public String getLandLordName() {
		return landLordName;
	}
	public void setLandLordName(String landLordName) {
		this.landLordName = landLordName;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public int getOwnerTypeInt() {
		return ownerTypeInt;
	}
	public void setOwnerTypeInt(int ownerTypeInt) {
		this.ownerTypeInt = ownerTypeInt;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getMediaVehicle() {
		return mediaVehicle;
	}
	public void setMediaVehicle(String mediaVehicle) {
		this.mediaVehicle = mediaVehicle;
	}



	public float getHeight() {
		return height;
	}



	public void setHeight(float height) {
		this.height = height;
	}



	public float getWidth() {
		return width;
	}



	public void setWidth(float width) {
		this.width = width;
	}
	
	
	
}
