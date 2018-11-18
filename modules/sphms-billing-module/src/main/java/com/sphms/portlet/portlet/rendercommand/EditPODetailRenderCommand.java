package com.sphms.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.beans.BillingPOBean;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.persistence.Billing_HordingPK;
import com.sphms.common.service.service.persistence.Billing_POPK;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+BillingConstant.PORTLET_ID,
	        "mvc.command.name=/edit_po"
	    },
	    service = MVCRenderCommand.class
)
public class EditPODetailRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(EditPODetailRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long billingId = ParamUtil.getLong(renderRequest, "billingId");
		long hordingId = ParamUtil.getLong(renderRequest, "hordingId");
		
		/*
		Billing_POPK billing_POPK = new Billing_POPK(billingId, hordingId);
		try {
			Billing billing = BillingLocalServiceUtil.getBilling(billingId);
			CustomCompany customCompany = CustomCompanyLocalServiceUtil.getCustomCompany(billing.getCustomCompanyId());
			Billing_PO  billingPO = Billing_POLocalServiceUtil.getBilling_PO(billing_POPK);
			BillingPOBean billingPOBean= new BillingPOBean(billingPO, customCompany);
			billingPOBean.setPoNumber(Billing_POLocalServiceUtil.getPONumber(billingPO,customCompany));
			renderRequest.setAttribute("billingPOBean", billingPOBean);
		} catch (PortalException e) {
			_log.error(e);
			return "/view.jsp";
		}*/
		
		List<BillingPOBean> billingPOBeanList = new ArrayList<BillingPOBean>();
		List<Billing_PO> billingPOList =  Billing_POLocalServiceUtil.getBillingPOListByBillingId(billingId);
		try {
			Billing billing = BillingLocalServiceUtil.getBilling(billingId);
			CustomCompany customCompany = CustomCompanyLocalServiceUtil.getCustomCompany(billing.getCustomCompanyId());
			for(Billing_PO billingPO : billingPOList){
				BillingPOBean billingPOBean= new BillingPOBean(billingPO, customCompany);
				billingPOBean.setPoNumber(Billing_POLocalServiceUtil.getPONumber(billingPO,customCompany));
				renderRequest.setAttribute("poNumber", Billing_POLocalServiceUtil.getPONumber(billingPO,customCompany));
				billingPOBeanList.add(billingPOBean);
			}
			
			renderRequest.setAttribute("billingPOBeanList", billingPOBeanList);
			renderRequest.setAttribute("billingId", billingId);
		} catch (PortalException e) {
			_log.error(e);
			return "/view.jsp";
		}	
		
		return "/billing/edit_po.jsp";
	}

}
