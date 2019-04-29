package sphms.supplier.module.portlet.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.beans.BillingPOBean;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.model.POPayment;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.service.POPaymentLocalServiceUtil;

import sphms.supplier.module.constants.SphmsSupplierModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + SphmsSupplierModulePortletKeys.SphmsSupplierModule,
	    	"mvc.command.name=/po_payment"
	    },
	    service = MVCRenderCommand.class
)
public class ViewPOPaymentRenderCommnad implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(ViewPOPaymentRenderCommnad.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long billingId = ParamUtil.getLong(renderRequest, "billingId");
		long landLordId = ParamUtil.getLong(renderRequest, "landLordId");
		long companyId = ParamUtil.getLong(renderRequest, "companyId");
		
		
		try {
			
			CustomCompany customCompany = CustomCompanyLocalServiceUtil.getCustomCompany(companyId);
			LandLord landLoard = LandLordLocalServiceUtil.getLandLord(landLordId);
			
			List<Billing_PO> billingPOList = Billing_POLocalServiceUtil.getBilling_POByBillingIdAndLandLordId(billingId, landLordId);
			for(Billing_PO billingPO : billingPOList){
					BillingPOBean billingPOBean  = new BillingPOBean(billingPO, customCompany);
					renderRequest.setAttribute("billingPOBean", billingPOBean);
			}
			
			List<POPayment> poPayments = POPaymentLocalServiceUtil.getPOPaymnetByBillingIdAndHoardingId(billingId, landLordId);
			renderRequest.setAttribute("poPayments", poPayments);
			renderRequest.setAttribute("billingId", billingId);
			renderRequest.setAttribute("landLordId", landLordId);
			renderRequest.setAttribute("companyId", companyId);
			renderRequest.setAttribute("supplierName", landLoard.getFirstName()+" " + landLoard.getLastName());
			
			
			return "/po_payment.jsp";
		} catch (PortalException e) {
			_log.error(e);
		}
		
		return "/view.jsp";
	}

}
