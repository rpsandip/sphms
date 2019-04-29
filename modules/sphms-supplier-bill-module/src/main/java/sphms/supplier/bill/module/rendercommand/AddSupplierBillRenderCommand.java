package sphms.supplier.bill.module.rendercommand;

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
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Supplier;
import com.sphms.common.service.model.SupplierBill;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.SupplierBillLocalServiceUtil;
import com.sphms.common.service.service.SupplierLocalServiceUtil;

import sphms.supplier.bill.module.constants.SphmsSupplierBillModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+SphmsSupplierBillModulePortletKeys.SphmsSupplierBillModule,
	        "mvc.command.name=/add_supplier_bill"
	    },
	    service = MVCRenderCommand.class
)
public class AddSupplierBillRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddSupplierBillRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long supplierBillId = ParamUtil.getLong(renderRequest, "supplierBillId");
		long supplierId = ParamUtil.getLong(renderRequest, "supplierId");
		
		if(supplierBillId>0){
			try {
				SupplierBill supplierBill = SupplierBillLocalServiceUtil.getSupplierBill(supplierBillId);
				renderRequest.setAttribute("supplierBill", supplierBill);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		//Get Company List
		List<CustomCompany> companyList = CustomCompanyLocalServiceUtil.getCustomCompanies(-1, -1);
		renderRequest.setAttribute("companyList", companyList);
		
		//Get Company List
		List<Supplier> supplierList = SupplierLocalServiceUtil.getSuppliers();
		renderRequest.setAttribute("supplierList", supplierList);
				
		
		renderRequest.setAttribute("supplierBillId", supplierBillId);
		renderRequest.setAttribute("supplierId", supplierId);
		
		return "/add_supplier_bill.jsp";
	}

}
