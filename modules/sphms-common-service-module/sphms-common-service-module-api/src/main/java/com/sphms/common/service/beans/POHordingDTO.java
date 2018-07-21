package com.sphms.common.service.beans;

public class POHordingDTO {
	
	private long billingId;
	private long hordingId;
	private String hordingTitle;
	private int status;
	public long getBillingId() {
		return billingId;
	}
	public void setBillingId(long billingId) {
		this.billingId = billingId;
	}
	public long getHordingId() {
		return hordingId;
	}
	public void setHordingId(long hordingId) {
		this.hordingId = hordingId;
	}
	public String getHordingTitle() {
		return hordingTitle;
	}
	public void setHordingTitle(String hordingTitle) {
		this.hordingTitle = hordingTitle;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}	
