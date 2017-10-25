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
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.Booking_HordingBean;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.Booking_Hording;
import com.sphms.common.service.model.Client;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.Booking_HordingLocalServiceUtil;
import com.sphms.common.service.service.ClientLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.persistence.Booking_HordingPK;


@Component(
	    property = {
	    	"javax.portlet.name="+BookingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_booking"
	    },
	    service = MVCRenderCommand.class
)
public class AddBookingRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddBookingRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		String selectedHordings = ParamUtil.getString(renderRequest, "selectedHordingIds");
		String selectedBookinghordings = ParamUtil.getString(renderRequest, "selectedBookingHordings");
		long bookingId = ParamUtil.getLong(renderRequest, "bookingId");
		
		// Get all active client list
		List<Client> allClientList = ClientLocalServiceUtil.getClients(-1, -1);
		renderRequest.setAttribute("allClientList", allClientList);
		
		//Get Company List
		List<CustomCompany> companyList = CustomCompanyLocalServiceUtil.getCustomCompanies(-1, -1);
		renderRequest.setAttribute("companyList", companyList);
		
		String[] selectedHordingIds = selectedHordings.split(",");
	
		
		if(bookingId==0){
			List<Hording> hordingList = new ArrayList<Hording>();
			for(String hordingId  : selectedHordingIds){
				if(Validator.isNotNull(hordingId)){
					try {
						Hording horing = HordingLocalServiceUtil.getHording(Long.parseLong(hordingId));
						hordingList.add(horing);
					} catch (NumberFormatException e) {
						_log.error(e);
					} catch (PortalException e) {
						_log.error(e);
					}
				}
			}
			renderRequest.setAttribute("hordindList", hordingList);
		}else{
			List<Booking_HordingBean> bookingHordingBeanList = new ArrayList<Booking_HordingBean>();
			for(String hordingId  : selectedHordingIds){
				if(Validator.isNotNull(hordingId) && Validator.isNotNull(bookingId) && selectedBookinghordings.indexOf(hordingId)>=0){
					Booking_HordingPK bookingHordingPK = new Booking_HordingPK(bookingId, Long.parseLong(hordingId));
					try {
						Booking_Hording bookingHording = Booking_HordingLocalServiceUtil.getBooking_Hording(bookingHordingPK);
						Booking_HordingBean bookingHordingBean = new Booking_HordingBean(bookingHording);
						bookingHordingBeanList.add(bookingHordingBean);
					} catch (PortalException e) {
						_log.error(e);
					}
				}else{
					if(Validator.isNotNull(hordingId)){
						Booking_HordingBean bookingHordingBean = new Booking_HordingBean();
						try {
							Hording hording = HordingLocalServiceUtil.getHording(Long.parseLong(hordingId));
							bookingHordingBean.setHordingId(hording.getHordingId());
							bookingHordingBean.setHordingTitle(hording.getTitle());
						} catch (NumberFormatException e) {
							_log.error(e);
						} catch (PortalException e) {
							_log.error(e);
						}
						bookingHordingBeanList.add(bookingHordingBean);
					}
				}
			}
			renderRequest.setAttribute("bookingHordingBeanList", bookingHordingBeanList);
			try {
				Booking booking = BookingLocalServiceUtil.getBooking(bookingId);
				renderRequest.setAttribute("booking", booking);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		renderRequest.setAttribute("bookingId", bookingId);
		renderRequest.setAttribute("selectedHordingIds", selectedHordings);
		renderRequest.setAttribute("selectedBookinghordings", selectedBookinghordings);
		return "/booking/add_booking.jsp";
	}

}
