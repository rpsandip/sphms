package sphms.client.module.portlet.actioncommand;

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
import com.sphms.common.service.model.Client;
import com.sphms.common.service.service.ClientLocalServiceUtil;

import sphms.client.module.portlet.util.ClientPortletConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ClientPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_client"
	    },
	    service = MVCActionCommand.class
	)
public class AddClientActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String clientName = ParamUtil.getString(actionRequest, "clientName");
		String address1= ParamUtil.getString(actionRequest, "address1");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
		String contactPersonEmail = ParamUtil.getString(actionRequest, "contactPersonEmail");
		String contactPersonPhoneNo = ParamUtil.getString(actionRequest, "contactPersonPhoneNo");
		String panNo = ParamUtil.getString(actionRequest, "panNo");
		String gstNo = ParamUtil.getString(actionRequest, "gstNo");
		long clientId = ParamUtil.getLong(actionRequest, "clientId");
		
		if(clientId==0){
			// Add Client
			Client client = ClientLocalServiceUtil.addClient(clientName, address1, address2, city, state, contactPersonName, contactPersonPhoneNo, contactPersonEmail, panNo, gstNo,themeDisplay.getUserId());
			if(Validator.isNotNull(client)){
				SessionMessages.add(actionRequest, "client-added-successfully");
			}else{
				SessionErrors.add(actionRequest, "error-add-client");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_client");
				actionResponse.setRenderParameter("clientId", String.valueOf(clientId));
			}
		}else{
			// Update Client
			Client client = ClientLocalServiceUtil.updateClient(clientId, clientName, address1, address2, city, state, contactPersonName, contactPersonPhoneNo, contactPersonEmail, panNo, gstNo,themeDisplay.getUserId());
			if(Validator.isNotNull(client)){
				SessionMessages.add(actionRequest, "client-updated-successfully");
			}else{
				SessionErrors.add(actionRequest, "error-update-client");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_client");
				actionResponse.setRenderParameter("clientId", String.valueOf(clientId));
			}
		}
		
	}

}
