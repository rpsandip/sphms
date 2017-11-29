package sphms.client.module.portlet.actioncommand;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.model.CreditNote;
import com.sphms.common.service.service.CreditNoteLocalServiceUtil;

import sphms.client.module.portlet.util.ClientPortletConstant;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ClientPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_credit_note"
	    },
	    service = MVCActionCommand.class
	)
public class AddCrecitNoteActionCommand extends BaseMVCActionCommand {

	Log _log = LogFactoryUtil.getLog(AddCrecitNoteActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		long clientId = ParamUtil.getLong(actionRequest, "clientId");
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		double amount = ParamUtil.getDouble(actionRequest, "amount");
		double tax = ParamUtil.getDouble(actionRequest, "tax");
		String paymentDateStr = ParamUtil.getString(actionRequest, "paymentDate");
		Date paymentDate = df.parse(paymentDateStr);
		String chequeNo = ParamUtil.getString(actionRequest, "chequeNo");
		String bankName = ParamUtil.getString(actionRequest, "bankName");
		long creditNoteId = ParamUtil.getLong(actionRequest, "creditNoteId");
		
		if(creditNoteId==0){
			// Add Credit Note
			CreditNote creditNote = CreditNoteLocalServiceUtil.addCreditNote(clientId, billingId,amount, tax,
					chequeNo, bankName, paymentDate, themeDisplay.getUserId());
			
			if(Validator.isNotNull(creditNote)){
				SessionMessages.add(actionRequest, "credit-note-add-success");
			}else{
				SessionMessages.add(actionRequest, "credit-note-add-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_credit_note");
				actionResponse.setRenderParameter("clientId", String.valueOf(clientId));
			}
		}else{
			
			CreditNote creditNote = CreditNoteLocalServiceUtil.updateCreditNote(creditNoteId, billingId,amount, 
					tax, chequeNo, bankName, paymentDate, themeDisplay.getUserId());
			
			if(Validator.isNotNull(creditNote)){
				SessionMessages.add(actionRequest, "credit-note-update-success");
			}else{
				SessionMessages.add(actionRequest, "credit-note-update-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_credit_note");
				actionResponse.setRenderParameter("clientId", String.valueOf(clientId));
			}
		}
	}

}
