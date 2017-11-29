package com.sphms.portlet.portlet.actioncommand;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Booking;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.BookingLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + BillingConstant.PORTLET_ID,
	        "mvc.command.name=/upload-po"
	    },
	    service = MVCActionCommand.class
	)

public class UploadPOActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(UploadPOActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

		long billingId = ParamUtil.getLong(actionRequest, "billingId");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long globalGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		
		Booking booking = null;
		Billing billing = null;
		try {
			billing = BillingLocalServiceUtil.getBilling(billingId);
			booking = BookingLocalServiceUtil.getBooking(billing.getBookingId());
			
		} catch (PortalException e) {
			_log.error(e);
		}
		
		FileEntry fileEntry  = null; 
		if(Validator.isNotNull(billing) && Validator.isNotNull(booking)){
			Folder bookingParentFolder = SPHMSCommonLocalServiceUtil.getFolder(globalGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PropsUtil.get("booking.document.folder"));
			Folder billingFolder = SPHMSCommonLocalServiceUtil.getFolder(globalGroupId, bookingParentFolder.getFolderId(), String.valueOf(billing.getBillingId()));
			Folder poFolder = SPHMSCommonLocalServiceUtil.getFolder(globalGroupId, billingFolder.getFolderId(), "PO");
			
			File poFile = uploadPortletRequest.getFile("uploadPOFile");
			String poFileName = uploadPortletRequest.getFileName("uploadPOFile");
			
			ServiceContext serviceContext = new ServiceContext(); 
			
			if(Validator.isNotNull(poFile)){
				try {
					 fileEntry = DLAppServiceUtil.addFileEntry(globalGroupId, poFolder.getFolderId(), poFileName, MimeTypesUtil.getContentType(poFile), poFileName, StringPool.BLANK , StringPool.BLANK, poFile, serviceContext);
				} catch (PortalException e) {
					_log.error(e);
				}
			}
		}
		
		if(Validator.isNotNull(fileEntry)){
			SessionMessages.add(actionRequest, "po-upload-success");
		}else{
			SessionErrors.add(actionRequest, "po-upload-error");
		}
		
		actionResponse.setRenderParameter("mvcRenderCommandName", "/upload_client_po");
		actionResponse.setRenderParameter("billingId", String.valueOf(billingId));
		
	}

}
