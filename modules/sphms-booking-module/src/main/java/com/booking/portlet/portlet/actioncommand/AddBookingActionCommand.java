package com.booking.portlet.portlet.actioncommand;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.booking.portlet.portlet.util.BookingPortletConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.beans.Billing_HordingBean;
import com.sphms.common.service.beans.Booking_HordingBean;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_Hording;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_HordingLocalServiceUtil;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BookingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_booking"
	    },
	    service = MVCActionCommand.class
	)
public class AddBookingActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(AddBookingActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long bookingId = ParamUtil.getLong(actionRequest, "bookingId");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String selectedHordings = ParamUtil.getString(actionRequest, "selectedHordingIds");
		String campaignTitle = ParamUtil.getString(actionRequest, "camapaignTitle");
		long clientId = ParamUtil.getLong(actionRequest, "clientId");
		long companyId = ParamUtil.getLong(actionRequest, "companyId");
		Date startDate = ParamUtil.getDate(actionRequest, "startDate", dateFormat);
		Date endDate = ParamUtil.getDate(actionRequest, "endDate", dateFormat);
		List<Hording> hordingList = new ArrayList<Hording>();
		List<Booking_HordingBean> bookingHordingBeanList = new ArrayList<Booking_HordingBean>();
		
		int hordingIndex=0;
		for(String hordingId : selectedHordings.split(",")){
			if(Validator.isNotNull(hordingId)){
				try {
					Hording hording = HordingLocalServiceUtil.getHording(Long.parseLong(hordingId));
					Booking_HordingBean bookingHordingBean = new Booking_HordingBean();
					bookingHordingBean.setHordingId(Long.parseLong(hordingId));
					bookingHordingBean.setMountingCharge(ParamUtil.getDouble(actionRequest, "moutingCharge"+hordingIndex));
					bookingHordingBean.setPrintingCharge(ParamUtil.getDouble(actionRequest, "printingCharge"+hordingIndex));
					bookingHordingBean.setUnits(ParamUtil.getInteger(actionRequest, "units"+hordingIndex));
					bookingHordingBean.setHsnNo(ParamUtil.getString(actionRequest,"hsnNo"+hordingIndex));
					bookingHordingBean.setHordingBookingStartDate(ParamUtil.getDate(actionRequest, "hordingStartDate"+hordingIndex, dateFormat));
					bookingHordingBean.setHordingbookingEndDate(ParamUtil.getDate(actionRequest, "hordingEndDate"+hordingIndex, dateFormat));
					bookingHordingBeanList.add(bookingHordingBean);
					hordingList.add(hording);
				} catch (NumberFormatException e) {
					_log.error(e);
				} catch (PortalException e) {
					_log.error(e);
				}
				
			}
			hordingIndex++;
		}
		
		if(bookingId==0){
			
			try{
				// Add Booking 
				Booking booking = BookingLocalServiceUtil.addBooking(campaignTitle, clientId, companyId,startDate, endDate, bookingHordingBeanList, themeDisplay.getUserId(), themeDisplay.getUserId());
				
				if(Validator.isNotNull(booking)){
					actionResponse.sendRedirect("/group/guest/booking?status=add-success");
				}else{
					SessionErrors.add(actionRequest, "err-add-booking");
					actionResponse.setRenderParameter("mvcRenderCommandName", "/add_booking");
					actionResponse.setRenderParameter("selectedHordingIds", selectedHordings);
				}
			}catch(PortalException e){
				_log.error(e);
				SessionErrors.add(actionRequest, "err-add-booking");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_booking");
				actionResponse.setRenderParameter("selectedHordingIds", selectedHordings);
			}
	  }else{
		   // Update booking
		  try {
			Booking booking = BookingLocalServiceUtil.updateBooking(bookingId, campaignTitle, clientId, companyId,startDate, endDate, bookingHordingBeanList, themeDisplay.getUserId());
			if(Validator.isNotNull(booking)){
				actionResponse.sendRedirect("/group/guest/booking?status=update-success");
			}else{
				SessionErrors.add(actionRequest, "err-add-booking");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_booking");
				actionResponse.setRenderParameter("selectedHordingIds", selectedHordings);
				actionResponse.setRenderParameter("bookingId", String.valueOf(bookingId));
				actionResponse.setRenderParameter("selectedBookingHordings", ParamUtil.getString(actionRequest, "selectedBookinghordings"));
			}
		  } catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(actionRequest, "err-update-booking");
			actionResponse.setRenderParameter("mvcRenderCommandName", "/add_booking");
			actionResponse.setRenderParameter("bookingId", String.valueOf(bookingId));
			actionResponse.setRenderParameter("selectedHordingIds", selectedHordings);
			actionResponse.setRenderParameter("selectedBookingHordings", ParamUtil.getString(actionRequest, "selectedBookinghordings"));
		  }
		  
	  }
		
	}

}
