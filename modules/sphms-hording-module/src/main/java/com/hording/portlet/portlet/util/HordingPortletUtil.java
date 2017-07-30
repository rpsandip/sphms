package com.hording.portlet.portlet.util;

import java.util.ArrayList;
import java.util.List;

import com.sphms.common.service.beans.HordingBean;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.HordingLocalServiceUtil;

public class HordingPortletUtil {
	public static List<HordingBean> getAllHordingList(){
		 List<HordingBean> hordingBeanList = new ArrayList<HordingBean>();
		List<Hording> hordingList = HordingLocalServiceUtil.getActiveHoringList(-1, -1);
		for(Hording hording : hordingList){
			HordingBean hordingBean = new HordingBean(hording);
			hordingBeanList.add(hordingBean);
		}
		return hordingBeanList;
	}
}
