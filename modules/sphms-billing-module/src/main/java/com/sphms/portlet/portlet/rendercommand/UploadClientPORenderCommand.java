package com.sphms.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.xmlbeans.impl.tool.Extension.Param;
import org.osgi.service.component.annotations.Component;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.sphms.common.service.beans.DocumentBean;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.portlet.portlet.util.BillingConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+BillingConstant.PORTLET_ID,
	        "mvc.command.name=/upload_client_po"
	    },
	    service = MVCRenderCommand.class
)
public class UploadClientPORenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(UploadClientPORenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
		
		long billingId = ParamUtil.getLong(renderRequest, "billingId");
		long globalGroupId = SPHMSCommonLocalServiceUtil.getGlobalGroupId();
		List<DLFileEntry> uploaedPOFileList  = new ArrayList<DLFileEntry>();
		List<DocumentBean> documentBeanList = new ArrayList<DocumentBean>();
		
		
		Folder bookingParentFolder = SPHMSCommonLocalServiceUtil.getFolder(globalGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PropsUtil.get("booking.document.folder"));
		Folder billingFolder = SPHMSCommonLocalServiceUtil.getFolder(globalGroupId, bookingParentFolder.getFolderId(), String.valueOf(billingId));
		Folder poFolder = SPHMSCommonLocalServiceUtil.getFolder(globalGroupId, billingFolder.getFolderId(), "PO");
		
		uploaedPOFileList  = DLFileEntryLocalServiceUtil.getFileEntries(globalGroupId, poFolder.getFolderId());
					
		for(DLFileEntry fileEntry : uploaedPOFileList){
			DocumentBean documentBean = new DocumentBean(fileEntry);
			documentBeanList.add(documentBean);
		}
		
		renderRequest.setAttribute("billingId", billingId);
		renderRequest.setAttribute("documentBeanList", documentBeanList);
		
		return "/billing/upload_po.jsp";
	}

}
