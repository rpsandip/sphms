package com.sphms.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.BillingPOBean;
import com.sphms.common.service.beans.POHordingDTO;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.util.BillingStatus;
import com.sphms.common.service.util.Billing_PO_Status;
import com.sphms.portlet.portlet.util.BillingConstant;
import com.sphms.common.service.beans.POBean;

@Component(
	    property = {
	    	"javax.portlet.name="+BillingConstant.PORTLET_ID,
	        "mvc.command.name=/po_detail"
	    },
	    service = MVCRenderCommand.class
)
public class PODetailRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(PODetailRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long billingId = ParamUtil.getLong(renderRequest, "billingId");
	
	
		Map<Long, POBean> poBeanMap = new HashMap<Long,POBean>();
		
		if(billingId>0){
				List<Billing_PO> billingPOList = Billing_POLocalServiceUtil.getBillingPOListByBillingId(billingId);
				try{
				Billing billing = BillingLocalServiceUtil.getBilling(billingId);
				CustomCompany company = CustomCompanyLocalServiceUtil.getCustomCompany(billing.getCustomCompanyId());
				
				for(Billing_PO billingPO : billingPOList){
		
					BillingPOBean billingPOBean = new BillingPOBean(billingPO,company);
					
					if(Validator.isNull(poBeanMap.get(billingPO.getLandLordId()))){
						
						POBean poBean = new POBean();
						List<POHordingDTO> hordingList = new ArrayList<POHordingDTO>();
						POHordingDTO poHordingDTO = new POHordingDTO();
						poHordingDTO.setBillingId(billingId);
						poHordingDTO.setHordingId(billingPO.getHordingId());
						poHordingDTO.setStatus(billingPO.getStatus());
						poHordingDTO.setHordingTitle(billingPOBean.getHordingTitle());
						poBean.setBillingId(billingPO.getBillingId());
						poBean.setLandlordId(billingPO.getLandLordId());
						poBean.setPoNumber(Billing_POLocalServiceUtil.getPONumber(billingPO,company));
						poBean.setFinancialYear(billingPO.getFinancialYear());
						poBean.setHordingId(billingPO.getHordingId());
						poBean.setStatus(Billing_PO_Status.findByValue(billingPO.getStatus()).getLabel());
						hordingList.add(poHordingDTO);
						poBean.setHordingList(hordingList);
						poBean.setSupplierBillNo(billingPO.getSupplierBillNo());
						poBean.setSupplierPaymentGiven(billingPO.getPaymentGiven());
						poBeanMap.put(billingPO.getLandLordId(), poBean);
						
					}else{
						POBean poBean = poBeanMap.get(billingPO.getLandLordId());
						List<POHordingDTO> hordingList = poBean.getHordingList();
						POHordingDTO poHordingDTO = new POHordingDTO();
						poHordingDTO.setBillingId(billingId);
						poHordingDTO.setHordingId(billingPO.getHordingId());
						poHordingDTO.setStatus(billingPO.getStatus());
						poHordingDTO.setHordingTitle(billingPOBean.getHordingTitle());
						hordingList.add(poHordingDTO);
						poBean.setHordingList(hordingList);
						poBeanMap.put(billingPO.getLandLordId(), poBean);
					}
				}
			}catch(PortalException e){
				_log.error(e);
			}
		}
		renderRequest.setAttribute("poBeanMap", poBeanMap);
		
		return "/billing/po_detail.jsp";
	}

}
