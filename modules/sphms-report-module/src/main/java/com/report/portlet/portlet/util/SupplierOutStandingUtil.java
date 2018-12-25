package com.report.portlet.portlet.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;

public class SupplierOutStandingUtil {
	private static final Log _log = LogFactoryUtil.getLog(SupplierOutStandingUtil.class.getName());

	public static File createSupplierOutStandingReport(long customComanyId, long landLoardId,Date startDate,Date endDate) throws IOException, PortalException {
		JSONObject supplierOutObject = Billing_POLocalServiceUtil.getBillingPOListForReport(customComanyId,
				landLoardId, startDate, endDate, -1, -1);
		return null;
	}
}
