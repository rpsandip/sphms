package com.sphms.expense.portlet.portlet.resourcecommand;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
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
public class GetExpenseResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetExpenseResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		List<Expense> expenseList = ExpenseLocalServiceUtil.getExpenses(-1, -1);
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		for(Expense expense : expenseList){
			JSONObject expenseObj = JSONFactoryUtil.createJSONObject();
			expenseObj.put("expenseId", expense.getExpenseId());
			expenseObj.put("type", expense.getType());
			expenseObj.put("amount", expense.getAmount());
			expenseObj.put("description", expense.getDescription());
			expenseObj.put("expenseDate",df.format(expense.getExpenseDate()));
			dataArray.put(expenseObj);
		}
		 responseObj.put("iTotalRecords", expenseList.size());
		 responseObj.put("iTotalDisplayRecords", expenseList.size());
		 responseObj.put("aaData", dataArray);
		    
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
			}
		 
		return true;
	}

}
