package sphms.client.module.portlet.resourcecommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;

import sphms.client.module.portlet.util.ClientPortletConstant;
import sphms.client.module.portlet.util.CreditNoteFileUtil;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + ClientPortletConstant.PORTLET_ID,
	        "mvc.command.name=/generateCreditNote"
	    },
	    service = MVCResourceCommand.class
	)
public class GenerateCreditNoteResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GenerateCreditNoteResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		long creditNoteId = ParamUtil.getLong(resourceRequest, "creditNoteId");
		long clientId = ParamUtil.getLong(resourceRequest, "clientId");
		long billingId = ParamUtil.getLong(resourceRequest, "billingId");
		
		
		try {
        	resourceResponse.setContentType("application/vnd.ms-excel");
        	resourceResponse.addProperty(
                    HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename=credit_note.xlsx");

        	File file = CreditNoteFileUtil.createCreditNoteFile(creditNoteId, clientId, billingId);
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
		
		return true;
	}

}
