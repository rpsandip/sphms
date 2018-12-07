package com.sphms.portlet.portlet.actioncommand;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.persistence.Billing_POPK;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(immediate = true, property = { "javax.portlet.name=" + BillingConstant.PORTLET_ID,
		"mvc.command.name=/edit-po" }, service = MVCActionCommand.class)
public class EditPOActionCommand extends BaseMVCActionCommand {

	Log _log = LogFactoryUtil.getLog(EditPOActionCommand.class.getName());

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		long landLordId = ParamUtil.getLong(actionRequest, "landLordId");

		double supplierGstAmt = ParamUtil.getDouble(actionRequest, "supplierGstAmt");
		String supplierBillNo = ParamUtil.getString(actionRequest, "supplierBillNo");
		Date supplierBillDate = ParamUtil.getDate(actionRequest, "supplierBillDate", inputFormat);
		double supplierTotalAmt = ParamUtil.getDouble(actionRequest, "supplierTotalAmt");
		String supplierPaymentGiven = ParamUtil.getString(actionRequest, "paymentGiven");

		String[] hordingArray = ParamUtil.getParameterValues(actionRequest, "hordingId");
		String[] totalAmountArray = ParamUtil.getParameterValues(actionRequest, "totalAmount");
		int count = 0;
		for (int i = 0; i < hordingArray.length; i++) {
			long hordingId = Long.parseLong(hordingArray[i]);
			double totalAmount = Double.parseDouble(totalAmountArray[i]);

			Billing_POPK billing_POPK = new Billing_POPK(billingId, hordingId);
			try {
				Billing_PO billingPO = Billing_POLocalServiceUtil.getBilling_PO(billing_POPK);
				billingPO.setTotalAmount(totalAmount);
				billingPO.setSupplierBillNo(supplierBillNo);
				billingPO.setSupplierBillDate(supplierBillDate);
				billingPO.setSupplierGstAmmount(supplierGstAmt);
				billingPO.setSupplierTotalAmount(supplierTotalAmt);
				billingPO.setPaymentGiven(supplierPaymentGiven);
				Billing_POLocalServiceUtil.updateBilling_PO(billingPO);
				count++;

			} catch (PortalException e) {
				_log.error(e);
			}
		}

		if (count == hordingArray.length) {
			SessionMessages.add(actionRequest, "po-update-success");
		} else {
			SessionErrors.add(actionRequest, "po-update-error");
		}

		actionResponse.setRenderParameter("mvcRenderCommandName", "/po_detail");
		actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
		actionResponse.setRenderParameter("landLordId", String.valueOf(landLordId));

	}

}
