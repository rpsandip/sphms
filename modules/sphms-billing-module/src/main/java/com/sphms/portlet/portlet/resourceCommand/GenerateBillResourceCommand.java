package com.sphms.portlet.portlet.resourceCommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.booking.portlet.portlet.util.FileUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
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
	    property = {
	    		"javax.portlet.name="+BillingConstant.PORTLET_ID,
	        "mvc.command.name=/download-bill"
	    },
	    service = MVCResourceCommand.class
	)
public class GenerateBillResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GenerateBillResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		long billingId = ParamUtil.getLong(resourceRequest, "billingId");
		String billType = ParamUtil.getString(resourceRequest, "billType");
		
		Billing billing = null;
		Booking booking = null;
		CustomCompany company = null;
		if(billingId>0){
			try {
				billing = BillingLocalServiceUtil.getBilling(billingId);
				booking = BookingLocalServiceUtil.getBooking(billing.getBookingId());
				company = CustomCompanyLocalServiceUtil.getCustomCompany(booking.getCustomCompanyId());
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}
		
		if(Validator.isNotNull(billType) && Validator.isNotNull(booking)){
			
			List<Billing_HordingBean> billing_HordingBeansList = new ArrayList<Billing_HordingBean>();
			List<Billing_Hording> billingHordingList = Billing_HordingLocalServiceUtil.getBillingHordingList(billing.getBillingId());
			for(Billing_Hording billingHording : billingHordingList){
				Billing_HordingBean billingHordingBean = new Billing_HordingBean(billingHording);
				billing_HordingBeansList.add(billingHordingBean);
			}
			
			try {
				File file = FileUtil.createBillXlsForBooking(booking, billing, billing_HordingBeansList, company);
				
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
				
			} catch (FileNotFoundException e) {
				_log.error(e.getMessage());
			} catch (PortalException e) {
				_log.error(e.getMessage());
			} catch (IOException e) {
				_log.error(e.getMessage());
			}
		}
		
		return true;
	}

}
