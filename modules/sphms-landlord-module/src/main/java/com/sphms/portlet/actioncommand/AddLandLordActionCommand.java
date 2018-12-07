package com.sphms.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webcache.WebCacheException;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.portlet.util.LandLordPortletConstant;;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + LandLordPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_land_lord"
	    },
	    service = MVCActionCommand.class
	)
public class AddLandLordActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long landLordId = ParamUtil.getLong(actionRequest, "landLordId");
		String fName = ParamUtil.getString(actionRequest, "firstName");
		String lName = ParamUtil.getString(actionRequest, "lastName");
		String location = ParamUtil.getString(actionRequest, "location");
		String city= ParamUtil.getString(actionRequest, "city");
		String state= ParamUtil.getString(actionRequest, "state");
		String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");
		String gstNo = ParamUtil.getString(actionRequest, "gstNo");
		
		// Adding land lord detail, pass 0 as status- active
		if(landLordId==0){
			LandLord landLord = LandLordLocalServiceUtil.addLandLordDetail(fName, lName, location, city, state,phoneNo,gstNo, 0, themeDisplay.getUserId());
			if(Validator.isNotNull(landLord)){
				SessionMessages.add(actionRequest, "land-lord-added-successfully");
			}else{
				SessionErrors.add(actionRequest, "err-add-land-lord");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add-land-lord");
			}
		}else{
			LandLord landLord = LandLordLocalServiceUtil.updateLandLord(landLordId, fName, lName, location, city, state,phoneNo,gstNo, 0, themeDisplay.getUserId());
			if(Validator.isNotNull(landLord)){
				SessionMessages.add(actionRequest, "land-lord-updated-successfully");
			}else{
				SessionErrors.add(actionRequest, "err-update-land-lord");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add-land-lord");
				actionResponse.setRenderParameter("landLordId", String.valueOf(landLordId));
			}
		}
	}

}
