package sphms.supplier.bill.module.resourcecommand;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.model.SupplierBill;
import com.sphms.common.service.service.SupplierBillLocalServiceUtil;

import sphms.supplier.bill.module.constants.SphmsSupplierBillModulePortletKeys;


@Component(
	    property = {
	    		"javax.portlet.name="+ SphmsSupplierBillModulePortletKeys.SphmsSupplierBillModule,
	        "mvc.command.name=/getSupplierBillList"
	    },
	    service = MVCResourceCommand.class
	)
public class GetSupplierBillResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetSupplierBillResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		int start = Integer.parseInt(httpRequest.getParameter("start"));
		int length = Integer.parseInt(httpRequest.getParameter("length"));
		String billType = ParamUtil.getString(resourceRequest, "billType");
		String startDateStr = ParamUtil.getString(resourceRequest, "searchStartDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "searchEndDate");
		long companyId = ParamUtil.getLong(resourceRequest, "companyId");
		long supplierId = ParamUtil.getLong(resourceRequest, "supplierId");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		Date startDate = null;
		Date endDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if(Validator.isNotNull(startDateStr) && Validator.isNotNull(endDateStr)){
			try {
				startDate = dateFormat.parse(startDateStr);
				endDate = dateFormat.parse(endDateStr);
			} catch (ParseException e) {
				_log.error(e);
			}
			
		}
		
		List<SupplierBill> supplierBillList = SupplierBillLocalServiceUtil.getSupplierBullListFromSearch(supplierId,
				billType, startDate, endDate, companyId, -1, -1);
		
		long totalSupplierBill = supplierBillList.size();
		
		for(SupplierBill supplierBill : supplierBillList){
			JSONObject supplierBillObj = JSONFactoryUtil.createJSONObject();
			supplierBillObj.put("billType", supplierBill.getSupplierBillType());
			supplierBillObj.put("billNo", supplierBill.getSupplierBillNo());
			supplierBillObj.put("desc", supplierBill.getSupplierBillDesc());
			supplierBillObj.put("billDate", dateFormat.format(supplierBill.getSupplierBillDate()));
			supplierBillObj.put("amount", supplierBill.getAmount());
			supplierBillObj.put("gst", supplierBill.getGst());
			supplierBillObj.put("supplierBillId", supplierBill.getSupplierBillId());
			supplierBillObj.put("supplierId", supplierBill.getSupplierId());
			dataArray.put(supplierBillObj);
		}
		responseObj.put("iTotalRecords", totalSupplierBill);
		 responseObj.put("iTotalDisplayRecords", totalSupplierBill);
		 responseObj.put("aaData", dataArray);
		    
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		
		return true;
	}

}
