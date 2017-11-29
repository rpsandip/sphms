package com.sphms.common.service.util;

public enum BookingStatus {
	ACTIVE(0,"Active"),INACTIVE(1,"InActive");
	
	private int value;
	private String label;
	
	private BookingStatus(int value,String label){
		this.value = value;
		this.label = label;
	}
	
	public  static BookingStatus findByValue(int value){
		BookingStatus bookingStatus=null;
		for(BookingStatus status : BookingStatus.values()){
			if(status.value==value){
				return status;
			}
		}
		return bookingStatus;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
