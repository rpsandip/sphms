package com.sphms.expense.portlet.portlet.actioncommand;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ThemeDisplayModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.model.Expense;
import com.sphms.common.service.service.ExpenseLocalServiceUtil;
import com.sphms.expense.portlet.portlet.ExpenseModulePortlet;
import com.sphms.expense.portlet.portlet.util.ExpensePortletConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ExpensePortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_expense"
	    },
	    service = MVCActionCommand.class
	)
public class AddExpenseActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(AddExpenseActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long expenseId = ParamUtil.getLong(actionRequest, "expenseId");
			String type = ParamUtil.getString(actionRequest, "type");
			double amount = ParamUtil.getDouble(actionRequest, "amount");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date expenseDate = ParamUtil.getDate(actionRequest, "expenseDate", dateFormat);
			long customCompanyId = ParamUtil.getLong(actionRequest, "customCustomId");
			String chequeNo = ParamUtil.getString(actionRequest, "chequeNo");
			String bankName = ParamUtil.getString(actionRequest, "bankName");
			
			String description = ParamUtil.getString(actionRequest, "description");
			
			if(expenseId==0){
				if(Validator.isNotNull(expenseDate)){
					Expense expense = ExpenseLocalServiceUtil.addExpense(type, amount, description, expenseDate, chequeNo,bankName,customCompanyId,themeDisplay.getUserId());
					if(Validator.isNotNull(expense)){
						SessionMessages.add(actionRequest, "expnese-add-suceess");
					}else{
						SessionErrors.add(actionRequest, "expense-add-error");
						actionResponse.setRenderParameter("mvcRenderCommandName", "/add_expense");
						actionResponse.setRenderParameter("expenseId", String.valueOf(expenseId));
					}
				}else{
					SessionErrors.add(actionRequest, "expense-add-error");
					actionResponse.setRenderParameter("mvcRenderCommandName", "/add_expense");
					actionResponse.setRenderParameter("expenseId", String.valueOf(expenseId));
				}
			}else{
				Expense expense = null;
				if(Validator.isNotNull(expenseDate)){
					try {
						expense = ExpenseLocalServiceUtil.updateExpense(expenseId, type, amount, description, expenseDate, chequeNo, bankName,customCompanyId,themeDisplay.getUserId());
					} catch (PortalException e) {
						_log.error(e);
					}
					if(Validator.isNotNull(expense)){
						SessionMessages.add(actionRequest, "expense-update-success");
					}else{
						SessionErrors.add(actionRequest, "expense-update-error");
						actionResponse.setRenderParameter("mvcRenderCommandName", "/add_expense");
						actionResponse.setRenderParameter("expenseId", String.valueOf(expenseId));
					}
				}else{
					SessionErrors.add(actionRequest, "expense-update-error");
					actionResponse.setRenderParameter("mvcRenderCommandName", "/add_expense");
					actionResponse.setRenderParameter("expenseId", String.valueOf(expenseId));
				}
			}
	}

}
