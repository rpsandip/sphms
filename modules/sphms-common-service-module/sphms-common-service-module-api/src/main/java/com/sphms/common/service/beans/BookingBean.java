package com.sphms.common.service.beans;

import java.util.Date;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;

public class BookingBean {
	Log _log = LogFactoryUtil.getLog(BookingBean.class.getName());
	
	private long bookingId;
	private String campaignTitle;
	private String client;
	private Date startDate;
	private Date endDate;
	private String billURL;
	
	public BookingBean(Booking booking){
		this.bookingId = booking.getBookingId();
		this.campaignTitle = booking.getCampaignTitle();
		this.startDate = booking.getStartDate();
		this.endDate = booking.getEndDate();
		
		if(booking.getClient()>0){
			try {
				Client client = ClientLocalServiceUtil.getClient(booking.getClient());
				this.client = client.getClientName();
			} catch (PortalException e) {
				_log.error(e);
				
			}
		}
		if(booking.getBillId()>0){
			try {
				DLFileEntry fileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(booking.getBillId());
				this.billURL = SPHMSCommonLocalServiceUtil.getDLFileURL(fileEntry);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
	}
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public String getCampaignTitle() {
		return campaignTitle;
	}
	public void setCampaignTitle(String campaignTitle) {
		this.campaignTitle = campaignTitle;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getBillURL() {
		return billURL;
	}
	public void setBillURL(String billURL) {
		this.billURL = billURL;
	}
	
	
}
