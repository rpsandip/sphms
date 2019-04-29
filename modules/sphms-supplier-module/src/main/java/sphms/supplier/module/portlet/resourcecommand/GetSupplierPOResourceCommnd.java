package sphms.supplier.module.portlet.resourcecommand;

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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.POBean;
import com.sphms.common.service.beans.POHordingDTO;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;

import sphms.supplier.module.constants.SphmsSupplierModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + SphmsSupplierModulePortletKeys.SphmsSupplierModule,
	        "mvc.command.name=/getSupplierPOList"
	    },
	    service = MVCResourceCommand.class
	)
public class GetSupplierPOResourceCommnd implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		Log _log = LogFactoryUtil.getLog(GetSupplierPOResourceCommnd.class.getName());
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		int start = Integer.parseInt(httpRequest.getParameter("start"));
		int length = Integer.parseInt(httpRequest.getParameter("length"));
		long customCompanyId = ParamUtil.getLong(resourceRequest, "customCompany");
		long landlordId = ParamUtil.getLong(resourceRequest, "landlord");
		String startDateStr = ParamUtil.getString(resourceRequest, "searchStartDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "searchEndDate");
		String paymentStatus = ParamUtil.getString(resourceRequest, "status");
		String billNo = ParamUtil.getString(resourceRequest, "billNo");
		JSONObject responseObj = new JSONFactoryUtil().createJSONObject();
		
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
		
		try {
			JSONObject poDetailObj = Billing_POLocalServiceUtil.getAllBillingPOList(customCompanyId, landlordId,
					0, billNo, paymentStatus, startDate, endDate, start, start+length);
			List<POBean> poBeanList = (List<POBean>)poDetailObj.get("poList");
			JSONArray dataArray = JSONFactoryUtil.createJSONArray();
			
			for(POBean poBean : poBeanList){
				JSONObject dataObject = JSONFactoryUtil.createJSONObject();
				dataObject.put("campaign", poBean.getCampaign());
				dataObject.put("poNumber", poBean.getPoNumber());
				dataObject.put("supplierbillno", poBean.getSupplierBillNo());
				dataObject.put("supplierpaymentgiven", poBean.getSupplierPaymentGiven());
				dataObject.put("totalOutStanding", poBean.getTotalOutStanding());
				dataObject.put("totalPaymentGiven", poBean.getTotalPaymentGiven());
				dataObject.put("financialyear", poBean.getFinancialYear());
				dataObject.put("billingId", poBean.getBillingId());
				dataObject.put("landLordId", poBean.getLandlordId());
				dataObject.put("supplier", Validator.isNotNull(poBean.getLandLordName())?poBean.getLandLordName():"");
				dataObject.put("status", poBean.getStatus());
				dataObject.put("companyId", poBean.getCompanyId());
				dataArray.put(dataObject);
				
			}
		
			
			 responseObj.put("iTotalRecords", poDetailObj.get("totalPO"));
			 responseObj.put("iTotalDisplayRecords", poDetailObj.get("totalPO"));
			 responseObj.put("aaData", dataArray);
			 
			 
			
		} catch (PortalException e) {
			_log.error(e);
		}
		
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		
		return true;

	}

}
