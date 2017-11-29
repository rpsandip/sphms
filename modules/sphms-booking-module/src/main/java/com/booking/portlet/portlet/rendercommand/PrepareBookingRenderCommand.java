package com.booking.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.booking.portlet.portlet.util.BookingPortletConstant;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.resiliency.spi.agent.AcceptorServlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sphms.common.service.beans.Booking_HordingBean;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.Booking_HordingLocalServiceUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+BookingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/prepare_booking"
	    },
	    service = MVCRenderCommand.class
)
public class PrepareBookingRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(PrepareBookingRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long bookingId = ParamUtil.getLong(renderRequest, "bookingId");
		renderRequest.setAttribute("bookingId", bookingId);
		String selectedHordingList = StringPool.BLANK;
		List<Booking_HordingBean> bookingHordingBeanList = new ArrayList<Booking_HordingBean>();
		
		if(bookingId>0){
			List<Booking_Hording> bookingHoridngList = Booking_HordingLocalServiceUtil.getBookingHordingsList(bookingId);
			
			for(Booking_Hording bookingHording : bookingHoridngList){
				Booking_HordingBean bookingHordingBean = new Booking_HordingBean(bookingHording);
				bookingHordingBeanList.add(bookingHordingBean);
				selectedHordingList += bookingHording.getHordingId()+StringPool.COMMA;
			}
			
			try {
				Booking booking = BookingLocalServiceUtil.getBooking(bookingId);
				renderRequest.setAttribute("booking", booking);
			} catch (PortalException e) {
				_log.error(e);
				return "/view.jsp";
			}
		}
		renderRequest.setAttribute("selectedHordings", selectedHordingList);
		renderRequest.setAttribute("bookingHordingBeanList", bookingHordingBeanList);
		return "/booking/prepare_booking.jsp";
	}

}
