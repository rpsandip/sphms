package sphms.client.module.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.service.ClientLocalServiceUtil;

import sphms.client.module.portlet.util.ClientPortletConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ClientPortletConstant.PORTLET_ID,
	        "mvc.command.name=/delete_client"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteClientActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long clientId = ParamUtil.getLong(actionRequest, "clientId");
		if(clientId>0){
			ClientLocalServiceUtil.deleteClient(clientId);
			SessionMessages.add(actionRequest, "delete-client-success");
		}else{
			SessionErrors.add(actionRequest, "delete-client-error");
		}
	}

}
