package com.sphms.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BillingConstant.PORTLET_ID,
	        "mvc.command.name=/publish_bill"
	    },
	    service = MVCActionCommand.class
	)
public class PublishBillActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(PublishBillActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
			long billingId = ParamUtil.getLong(actionRequest, "billingId");
			try {
				BillingLocalServiceUtil.publishBilling(billingId);
				SessionMessages.add(actionRequest, "publish-bill-success");
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "publish-bill-err");
				_log.error(e);
			}
	}

}
