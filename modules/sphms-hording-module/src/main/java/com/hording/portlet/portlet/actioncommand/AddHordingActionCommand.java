package com.hording.portlet.portlet.actioncommand;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.hording.portlet.portlet.util.HordingPortletConstant;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.HordingLocalServiceUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+HordingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_hording"
	    },
	    service = MVCActionCommand.class
)
public class AddHordingActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		 long hordingId = ParamUtil.getLong(actionRequest, "hordingId");
		 String title = ParamUtil.getString(actionRequest, "title");
		 long landLordId = ParamUtil.getShort(actionRequest, "landLordId");
		 String location = ParamUtil.getString(actionRequest, "location");
		 String city = ParamUtil.getString(actionRequest, "city");
		 String district = ParamUtil.getString(actionRequest, "district");
		 String state = ParamUtil.getString(actionRequest, "state");
		 String hordingType = ParamUtil.getString(actionRequest, "type");
		 String mediaVehicle = ParamUtil.getString(actionRequest, "mediaVehicle");
		 int height = ParamUtil.getInteger(actionRequest, "height");
		 int width = ParamUtil.getInteger(actionRequest, "width");
		 int ownerType = ParamUtil.getInteger(actionRequest, "owerType");
		 String upinNo = ParamUtil.getString(actionRequest, "upinNo");
		 double mncTax = ParamUtil.getDouble(actionRequest, "mncTax");
		 double pricePerMonth = ParamUtil.getDouble(actionRequest, "pricePerMonth");
		 double otherExpYear= ParamUtil.getDouble(actionRequest, "otherExpYear");
		 
		 // Images
		 UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		 File normalImage = uploadPortletRequest.getFile("normalImage");
		 File shortImage = uploadPortletRequest.getFile("shortImage");
		 File longImage = uploadPortletRequest.getFile("longImage");
		 
		 String normalImageFileName = uploadPortletRequest.getFileName("normalImage");
		 String shortImageFileName = uploadPortletRequest.getFileName("shortImage");
		 String longImageFileName = uploadPortletRequest.getFileName("longImage");
		 
		 if(hordingId==0){
			 Hording hording = HordingLocalServiceUtil.addHording(title, location, city, district,state, hordingType, mediaVehicle,String.valueOf(height)+"X"+String.valueOf(width),
					 pricePerMonth, normalImage, normalImageFileName,shortImage, shortImageFileName,longImage, longImageFileName,
					 landLordId, ownerType, upinNo,mncTax, otherExpYear, themeDisplay.getUserId(), themeDisplay.getUserId());
			 
			 if(Validator.isNotNull(hording)){
				 SessionMessages.add(actionRequest, "hording-added-successfully");
			 }else{
				 SessionErrors.add(actionRequest, "error-add-hording");
					actionResponse.setRenderParameter("mvcRenderCommandName", "/add_hording");
					actionResponse.setRenderParameter("hordingId", String.valueOf(hordingId));
			 }
		 }else{
			 Hording hording = HordingLocalServiceUtil.updateHording(hordingId, title, location, city, district,state, hordingType, mediaVehicle,String.valueOf(height)+"X"+String.valueOf(width), pricePerMonth, normalImage,
					 normalImageFileName, shortImage, shortImageFileName, longImage, longImageFileName, landLordId, ownerType, upinNo, mncTax, otherExpYear, themeDisplay.getUserId());
			 if(Validator.isNotNull(hording)){
				 SessionMessages.add(actionRequest, "hording-updated-successfully");
			 }else{
				 SessionErrors.add(actionRequest, "error-update-hording");
					actionResponse.setRenderParameter("mvcRenderCommandName", "/add_hording");
					actionResponse.setRenderParameter("hordingId", String.valueOf(hordingId));
			 }
		 }
	}

}
