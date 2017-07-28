package com.sphms.portlet.util;

import java.util.List;

import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.LandLordLocalServiceUtil;

public class LandLoardPortletUtil {
	public static List<LandLord> getAllActiveLandLord(){
		List<LandLord> landLordList = LandLordLocalServiceUtil.getActiveLandLords(-1, -1);
		return landLordList;
	}
}
