package com.sphms.common.service.beans;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;

public class DocumentBean {
	private String documentURL;
	private String fileName;
	
	public DocumentBean(DLFileEntry fileEntry){
		this.documentURL = SPHMSCommonLocalServiceUtil.getDLFileURL(fileEntry);
		this.fileName = fileEntry.getFileName();
	}
	
	public String getDocumentURL() {
		return documentURL;
	}
	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
