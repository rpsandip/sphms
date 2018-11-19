package com.sphms.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.xmlbeans.impl.tool.Extension.Param;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.beans.BillingPOBean;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.persistence.Billing_POPK;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BillingConstant.PORTLET_ID,
	        "mvc.command.name=/edit-po"
	    },
	    service = MVCActionCommand.class
	)
public class EditPOActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(EditPOActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		long landLordId = ParamUtil.getLong(actionRequest, "landLordId");
		
	
		String[] hordingArray = ParamUtil.getParameterValues(actionRequest, "hordingId");
		String[] totalAmountArray = ParamUtil.getParameterValues(actionRequest, "totalAmount");
		int count=0;
		for(int i=0; i<hordingArray.length;i++){
			long hordingId = Long.parseLong(hordingArray[i]);
			double totalAmount = Double.parseDouble(totalAmountArray[i]);
			
			Billing_POPK billing_POPK = new Billing_POPK(billingId, hordingId);
			try {
				Billing_PO billingPO = Billing_POLocalServiceUtil.getBilling_PO(billing_POPK);
				billingPO.setTotalAmount(totalAmount);
				Billing_POLocalServiceUtil.updateBilling_PO(billingPO);
				count++;
				
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		if(count==hordingArray.length){
			SessionMessages.add(actionRequest, "po-update-success");
		}else{
			SessionErrors.add(actionRequest, "po-update-error");
		}
		
		actionResponse.setRenderParameter("mvcRenderCommandName", "/po_detail");
	    actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
	    actionResponse.setRenderParameter("landLordId", String.valueOf(landLordId));
	    
		
	}

}
