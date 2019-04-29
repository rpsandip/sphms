package sphms.supplier.bill.module.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.model.SupplierBillPayment;
import com.sphms.common.service.service.SupplierBillPaymentLocalServiceUtil;
import com.sphms.common.service.service.SupplierLocalServiceUtil;

import sphms.supplier.bill.module.constants.SphmsSupplierBillModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SphmsSupplierBillModulePortletKeys.SphmsSupplierBillModule,
	        "mvc.command.name=/get_supplier_bill_payments"
	    },
	    service = MVCRenderCommand.class
)
public class SupplierBillPaymentRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long supplierBillId = ParamUtil.getLong(renderRequest, "supplierBillId");
		long supplierId = ParamUtil.getLong(renderRequest, "supplierId");
		
		List<SupplierBillPayment> billPayments = SupplierBillPaymentLocalServiceUtil.getSupplierBillPaymentBySupplierBillId(supplierBillId);
		renderRequest.setAttribute("billPayments", billPayments);
		
		String supplierName="";
		try {
			Supplier supplier = SupplierLocalServiceUtil.getSupplier(supplierId);
			supplierName = supplier.getSupplierName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		renderRequest.setAttribute("supplierBillId", supplierBillId);
		renderRequest.setAttribute("supplierId", supplierId);
		renderRequest.setAttribute("supplierName", supplierName);
		
		return "/supplier_bill_payments.jsp";
	}

}
