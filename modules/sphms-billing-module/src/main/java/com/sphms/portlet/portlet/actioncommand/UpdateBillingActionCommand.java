package com.sphms.portlet.portlet.actioncommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.booking.portlet.portlet.util.FileUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.beans.Billing_HordingBean;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_HordingLocalServiceUtil;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BillingConstant.PORTLET_ID,
	        "mvc.command.name=/edit-billing"
	    },
	    service = MVCActionCommand.class
	)
public class UpdateBillingActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(UpdateBillingActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String clientPANNo = ParamUtil.getString(actionRequest, "clientPANNo");
		String clientPONo = ParamUtil.getString(actionRequest, "clientPONo");
		String clientGSTNo = ParamUtil.getString(actionRequest, "clientGSTNo");
		String display = ParamUtil.getString(actionRequest, "display");
		double accessAmount = ParamUtil.getDouble(actionRequest, "accessAmount");
		double pendingAmount = ParamUtil.getDouble(actionRequest, "pendingAmount");
		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		
		int totalHordingCount = ParamUtil.getInteger(actionRequest, "totalHordingCount");
		List<Billing_HordingBean> bookingHordingBeanList = new ArrayList<Billing_HordingBean>();
		
		for(int i=0; i<totalHordingCount;i++){
			Billing_HordingBean billingHordingBean = new Billing_HordingBean();
			billingHordingBean.setHordingId(ParamUtil.getLong(actionRequest, "hordingId"+i));
			billingHordingBean.setBillingId(billingId);
			billingHordingBean.setTotalMountingCharge(ParamUtil.getDouble(actionRequest, "totalMountingCharge"+i));
			billingHordingBean.setTotalPrintingCharge(ParamUtil.getDouble(actionRequest, "totalPrintingCharge"+i));
			billingHordingBean.setTotalHordingCharge(ParamUtil.getDouble(actionRequest, "totalHordingCharge"+i));
			billingHordingBean.setHsnNo(ParamUtil.getString(actionRequest, "hsnNo"+i));
			bookingHordingBeanList.add(billingHordingBean);
		}
		
		// Update bill
		Billing billing=null;
		Booking booking=null;
		CustomCompany company = null;
		try {
			billing = BillingLocalServiceUtil.updateBilling(billingId, clientPANNo, clientPONo, clientGSTNo, display,
					accessAmount, pendingAmount, bookingHordingBeanList, themeDisplay.getUserId());
		
			booking = BookingLocalServiceUtil.getBooking(billing.getBookingId());
			
			company = CustomCompanyLocalServiceUtil.getCustomCompany(booking.getCustomCompanyId());
		} catch (PortalException e1) {
			_log.error(e1);
		}
		
		if(Validator.isNotNull(billing) && Validator.isNotNull(booking) && Validator.isNotNull(company)){
			
			// Update
			List<Billing_HordingBean> billing_HordingBeansList = new ArrayList<Billing_HordingBean>();
			List<Billing_Hording> billingHordingList = Billing_HordingLocalServiceUtil.getBillingHordingList(billing.getBillingId());
			for(Billing_Hording billingHording : billingHordingList){
				Billing_HordingBean billingHordingBean = new Billing_HordingBean(billingHording);
				billing_HordingBeansList.add(billingHordingBean);
			}
			
			FileEntry xlsxFileEntry= null;
			try {
				xlsxFileEntry = FileUtil.createBillXlsForBooking(booking, billing,billing_HordingBeansList, true, company);
			} catch (PortalException | IOException e) {
				_log.error(e);
			}
			
			SessionMessages.add(actionRequest, "billing-updated-successfully");
		}else{
			SessionErrors.add(actionRequest, "err-update-booking");
			actionResponse.setRenderParameter("mvcRenderCommandName", "/edit-billing");
			actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
		}
	}

}
