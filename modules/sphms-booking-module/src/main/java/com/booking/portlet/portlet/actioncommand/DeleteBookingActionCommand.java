package com.booking.portlet.portlet.actioncommand;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.util.BookingStatus;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BookingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/delete_booking"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteBookingActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(DeleteBookingActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		boolean isDeleted = false;
		long bookingId = ParamUtil.getLong(actionRequest, "bookingId");
		try {
			isDeleted = BookingLocalServiceUtil.updateBookingStatus(bookingId, BookingStatus.INACTIVE.getValue());
		} catch (PortalException e) {
			_log.error(e);
		}
		
		if(isDeleted){
			SessionMessages.add(actionRequest, "booking-delete-success");
		}else{
			SessionErrors.add(actionRequest, "booking-delete-error");
		}
	}

}
