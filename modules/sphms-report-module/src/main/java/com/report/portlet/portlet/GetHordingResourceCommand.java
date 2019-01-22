package com.report.portlet.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.report.portlet.constants.SphmsReportModulePortletKeys;
import com.report.portlet.portlet.util.HordingReportUtil;

@Component(property = { "javax.portlet.name=" + SphmsReportModulePortletKeys.SphmsReportModule,
		"mvc.command.name=/getHordingReport" }, service = MVCResourceCommand.class)
public class GetHordingResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		Log _log = LogFactoryUtil.getLog(GetHordingResourceCommand.class.getName());

		long activeHordingId = ParamUtil.getLong(resourceRequest, "activeHording");
		String startDateStr = ParamUtil.getString(resourceRequest, "hordingStartDate").toString();
		String endDateStr = ParamUtil.getString(resourceRequest, "endDate").toString();

		// first converting to date
		DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date inputStartdate = null;
		Date inputEnddate = null;
		try {
			inputStartdate = inputFormat.parse(startDateStr);
			inputEnddate = inputFormat.parse(endDateStr);

		} catch (ParseException e1) {
			_log.error(e1);
		}

		// Format date into output format
		String outputStartDate = outputFormat.format(inputStartdate);
		String outputEndDate = outputFormat.format(inputEnddate);

		_log.info("in side the out standing report");
		try {
			File file = HordingReportUtil.createHordingReport(activeHordingId, outputStartDate, outputEndDate);
			try {
				resourceResponse.setContentType("application/vnd.ms-excel");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;  filename=" + file.getName());

				OutputStream pos = resourceResponse.getPortletOutputStream();
				try {
					byte[] bytesArray = new byte[(int) file.length()];
					FileInputStream fis = new FileInputStream(file);
					fis.read(bytesArray); // read file into bytes[]
					fis.close();

					pos.write(bytesArray);
					pos.flush();

				} finally {
					pos.close();
				}
			} catch (IOException e) {
				_log.error(e);
			}

		} catch (FileNotFoundException e) {
			_log.error(e.getMessage());
		} catch (IOException e) {
			_log.error(e.getMessage());
		}
		return true;
	}

}
