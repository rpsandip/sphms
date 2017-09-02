package com.booking.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.booking.portlet.portlet.util.BookingPortletConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.beans.BookingBean;
import com.sphms.common.service.beans.Booking_HordingBean;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.Booking_HordingLocalServiceUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+BookingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/view-booking"
	    },
	    service = MVCRenderCommand.class
)
public class ViewBookingRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(ViewBookingRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		
		
		long bookingId = ParamUtil.getLong(renderRequest, "bookingId");
		Booking booking;
		try {
			booking = BookingLocalServiceUtil.getBooking(bookingId);
			BookingBean bookingBean = new BookingBean(booking);
			List<Booking_Hording> bookingHordingList = Booking_HordingLocalServiceUtil.getBookingHordingsList(bookingId);
			List<Booking_HordingBean> bookingHordingBeanList = new ArrayList<Booking_HordingBean>();
			for(Booking_Hording bookingHording : bookingHordingList){
				Booking_HordingBean bookingHordingBean = new Booking_HordingBean(bookingHording);
				bookingHordingBeanList.add(bookingHordingBean);
			}
			renderRequest.setAttribute("bookingBean", bookingBean);
			renderRequest.setAttribute("bookingHordingBeanList", bookingHordingBeanList);
			
		} catch (PortalException e) {
			_log.error(e);
		}
		
		
		
		return "/booking/view_booking.jsp";
	}

}
