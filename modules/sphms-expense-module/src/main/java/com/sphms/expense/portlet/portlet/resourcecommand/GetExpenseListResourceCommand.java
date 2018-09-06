package com.sphms.expense.portlet.portlet.resourcecommand;

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
import com.sphms.common.service.model.Expense;
import com.sphms.common.service.service.ExpenseLocalServiceUtil;
import com.sphms.expense.portlet.portlet.util.ExpensePortletConstant;


@Component(
	    property = {
	    		"javax.portlet.name="+ ExpensePortletConstant.PORTLET_ID,
	        "mvc.command.name=/getExpenseList"
	    },
	    service = MVCResourceCommand.class
	)
public class GetExpenseListResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetExpenseListResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		int start = Integer.parseInt(httpRequest.getParameter("start"));
		int length = Integer.parseInt(httpRequest.getParameter("length"));
		String expenseType = ParamUtil.getString(resourceRequest, "expenseType");
		String startDateStr = ParamUtil.getString(resourceRequest, "searchStartDate");
		String endDateStr = ParamUtil.getString(resourceRequest, "searchEndDate");
		long companyId = ParamUtil.getLong(resourceRequest, "companyId");
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
		
		List<Expense> expenseList = ExpenseLocalServiceUtil.getExpenseList(expenseType, startDate, endDate, companyId,start, start+length);
		long totalExpenseCount = ExpenseLocalServiceUtil.getExpenseCount(expenseType, startDate, endDate, companyId);
		
		for(Expense expense : expenseList){
			JSONObject expenseObj = JSONFactoryUtil.createJSONObject();
			expenseObj.put("expenseType", expense.getType());
			expenseObj.put("amount", expense.getAmount());
			expenseObj.put("description", expense.getDescription());
			expenseObj.put("expenseDate", dateFormat.format(expense.getExpenseDate()));
			expenseObj.put("expenseId", expense.getExpenseId());
			if(Validator.isNotNull(expense.getChequeNo())){
				expenseObj.put("paymenttype", "Cheque No: " + expense.getChequeNo() + "(" + expense.getBankName() + " )");
			}else{
				expenseObj.put("paymenttype","Cash");
			}
			
			dataArray.put(expenseObj);
		}
		
		responseObj.put("iTotalRecords", totalExpenseCount);
		 responseObj.put("iTotalDisplayRecords", totalExpenseCount);
		 responseObj.put("aaData", dataArray);
		    
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		
		return true;
	}

}
