package com.sphms.portlet.portlet.actioncommand;

import java.util.List;

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
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.persistence.Billing_POPK;
import com.sphms.common.service.util.BillingStatus;
import com.sphms.common.service.util.Billing_PO_Status;
import com.sphms.portlet.portlet.util.BillingConstant;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BillingConstant.PORTLET_ID,
	        "mvc.command.name=/publish_PO"
	    },
	    service = MVCActionCommand.class
	)
public class PublishPOActionCommand  extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(PublishPOActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
	
		List<Billing_PO> billingPOList =  Billing_POLocalServiceUtil.getBillingPOListByBillingId(billingId);
		
		for(Billing_PO billingPO : billingPOList){
			
			try {
				
				Billing billing = BillingLocalServiceUtil.getBilling(billingId);
				if(billingPO.getStatus()==Billing_PO_Status.GENERATED.getValue()){
					long landLordId = billingPO.getLandLordId();
					String nextPONumber = Billing_POLocalServiceUtil.getNextPONumber(billingId, billingPO.getLandLordId(),billing.getCustomCompanyId());
					
					// Find other hording in same billings
					List<Billing_PO> otherHordingList = Billing_POLocalServiceUtil.getBilling_POByBillingIdAndLandLordId(billingId, landLordId);
					for(Billing_PO otherBillingPO : otherHordingList){
						otherBillingPO.setPoNumber(nextPONumber);
						otherBillingPO.setStatus(Billing_PO_Status.PUBLISH.getValue());
						Billing_POLocalServiceUtil.updateBilling_PO(otherBillingPO);
					}	
				}else{
					throw new PortalException();
				}
				SessionMessages.add(actionRequest, "po-publish-success");
				break;
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "error-po-publish");
				_log.error(e);
			}
		}
		
	}

}
