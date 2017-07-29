package com.sphms.common.service.beans;

import com.liferay.portal.kernel.util.StringPool;

public enum OwnerType {
	OWN(0, "Own"), TRADE(1,"Trade");
	private int value;
	private String title;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private OwnerType(int value, String title){
		this.value = value;
		this.title =  title;
	}
	
	public static String getTitle(int value){
		if(OWN.value==value){
			return OWN.title;
		}
		if(TRADE.value==value){
			return TRADE.title;
		}
		return StringPool.BLANK;
	}
}
