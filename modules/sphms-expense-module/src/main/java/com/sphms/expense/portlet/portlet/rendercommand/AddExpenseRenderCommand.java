package com.sphms.expense.portlet.portlet.rendercommand;

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
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Expense;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.ExpenseLocalServiceUtil;
import com.sphms.expense.portlet.portlet.util.ExpensePortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ExpensePortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_expense"
	    },
	    service = MVCRenderCommand.class
)
public class AddExpenseRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddExpenseRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long expenseId = ParamUtil.getLong(renderRequest, "expenseId");
		if(expenseId>0){
			try {
				Expense expense = ExpenseLocalServiceUtil.getExpense(expenseId);
				renderRequest.setAttribute("expense", expense);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		//Get Company List
		List<CustomCompany> companyList = CustomCompanyLocalServiceUtil.getCustomCompanies(-1, -1);
		renderRequest.setAttribute("companyList", companyList);
				
		
		renderRequest.setAttribute("expenseId", expenseId);
		return "/add_expense.jsp";
	}

}
