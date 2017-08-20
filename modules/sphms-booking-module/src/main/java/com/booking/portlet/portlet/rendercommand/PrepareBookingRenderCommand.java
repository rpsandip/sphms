package com.booking.portlet.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.booking.portlet.portlet.util.BookingPortletConstant;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

@Component(
	    property = {
	    	"javax.portlet.name="+BookingPortletConstant.PORTLET_ID,
	        "mvc.command.name=/prepare_booking"
	    },
	    service = MVCRenderCommand.class
)
public class PrepareBookingRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/booking/prepare_booking.jsp";
	}

}
