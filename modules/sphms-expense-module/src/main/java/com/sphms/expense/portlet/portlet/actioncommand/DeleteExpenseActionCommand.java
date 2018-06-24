package com.sphms.expense.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.service.ExpenseLocalServiceUtil;
import com.sphms.expense.portlet.portlet.util.ExpensePortletConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ExpensePortletConstant.PORTLET_ID,
	        "mvc.command.name=/delete_expense"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteExpenseActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(DeleteExpenseActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)  {

		long expenseId = ParamUtil.getLong(actionRequest, "expenseId");
		try {
			ExpenseLocalServiceUtil.deleteExpense(expenseId);
			SessionMessages.add(actionRequest, "delete-expense-success");
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "delete-expense-error");
			_log.error(e);
		}
		
	}

}
