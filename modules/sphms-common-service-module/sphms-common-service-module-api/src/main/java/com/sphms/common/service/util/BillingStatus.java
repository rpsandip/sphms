package com.sphms.common.service.util;

public enum BillingStatus {
    CREATED(0,"Created"),PUBLISHED(2,"PUBLISH"), DELETE(1,"Deleted");
	
	private int value;
	private String label;
	
	private BillingStatus(int value,String label){
		this.value = value;
		this.label = label;
	}
	
	public  static BillingStatus findByValue(int value){
		BillingStatus bookingStatus=null;
		for(BillingStatus status : BillingStatus.values()){
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
