package sphms.supplier.module.portlet.resourcecommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;

import sphms.supplier.module.constants.SphmsSupplierModulePortletKeys;
import sphms.supplier.module.portlet.util.POUtil;


@Component(
	    property = {
	    	"javax.portlet.name=" + SphmsSupplierModulePortletKeys.SphmsSupplierModule,
	        "mvc.command.name=/download-po"
	    },
	    service = MVCResourceCommand.class
	)
public class DownloadPOResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(DownloadPOResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		
		long billingId = ParamUtil.getLong(resourceRequest, "billingId");
		long landLordId = ParamUtil.getLong(resourceRequest, "landlordId");
		
		
		if(billingId>0 && landLordId>0){
			Billing billing;
			try {
				billing = BillingLocalServiceUtil.getBilling(billingId);
				Booking booking = BookingLocalServiceUtil.getBooking(billing.getBookingId());
				List<Billing_PO> billingPOList = Billing_POLocalServiceUtil.getBilling_POByBillingIdAndLandLordId(billingId, landLordId);
				CustomCompany company = CustomCompanyLocalServiceUtil.getCustomCompany(booking.getCustomCompanyId());
				try {
					File file = POUtil.createPOFile(billing, billingPOList, booking, company);
					
			        try {
			        	resourceResponse.setContentType("application/vnd.ms-excel");
			        	resourceResponse.addProperty(
			                    HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename="+ file.getName());

			            OutputStream pos = resourceResponse.getPortletOutputStream();
			            try {
			            	byte[] bytesArray = new byte[(int) file.length()];
			            	FileInputStream fis = new FileInputStream(file);
			            	fis.read(bytesArray); //read file into bytes[]
			            	fis.close();

			                pos.write(bytesArray);
			                pos.flush();
			            } finally {
			                pos.close();
			            }
			        } catch(IOException e){
			        	_log.error(e);
			        }
				} catch (IOException e) {
					_log.error(e);
				}
			} catch (PortalException e) {
				_log.error(e);
			}
			
		} 
		
		return true;
	}

}
