package com.sphms.common.service.util;

public enum Billing_PO_Status {
 GENERATED(0,"Generated"), PUBLISH(1,"Published");
	
	private int value;
	private String label;
	
	private Billing_PO_Status(int value,String label){
		this.value = value;
		this.label = label;
	}
	
	public  static Billing_PO_Status findByValue(int value){
		Billing_PO_Status billingPOStatus=null;
		for(Billing_PO_Status status : Billing_PO_Status.values()){
			if(status.value==value){
				return status;
			}
		}
		return billingPOStatus;
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
