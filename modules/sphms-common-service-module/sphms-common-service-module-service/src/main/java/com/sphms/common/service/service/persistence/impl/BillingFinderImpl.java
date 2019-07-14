package com.sphms.common.service.service.persistence.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.sphms.common.service.service.persistence.BillingFinder;

public class BillingFinderImpl extends BillingFinderBaseImpl implements BillingFinder{
	
	@SuppressWarnings("unchecked")
	public List<Object> findCompanyBillsDetails(
		    long customCompanyId, String StartDate, String endDate) {

		    Session session = null;
		    try {
		        session = openSession();

		        String sql = getCompanyBillDetailQuery(customCompanyId, StartDate, endDate);

		        SQLQuery q = session.createSQLQuery(sql);
		        q.setCacheable(false);
		      
		        return (List<Object>) q.list();
		    }
		    catch (Exception e) {
		       throw new SystemException(e);
		    }
		    finally {
		        closeSession(session);
		    }
	}
	
	private String getCompanyBillDetailQuery(long customCompanyId, String startDate, String endDate){
		String query = "select b.billNo, ifnull(b.publishDate,b.createDate) as publishDate, c.clientName,"+
                 "ifnull(b.clientGSTNumber, c.gstNo) as clientGSTNo, c.state_ as state," +
                 "sum(bh.totalMountingCharge) as totalMountingCharge ,sum(bh.totalPrintingCharge) as totalPrintingCharge,"+
                 "sum(bh.totalHordingCharge) as totalHordingCharge, b.billingId "+
                 	"from SPHMS_Billing  b "+
                 	"inner join SPHMS_Billing_Hording bh on b.billingId=bh.billingId "+
                 	"left join SPHMS_Client c on c.clientId = b.clientId "+
                 	"where customCompanyId = "+ customCompanyId+ " and b.status=2 and " +
                 	 " ifnull(b.publishDate,b.createDate) between '"+ startDate+"' and '"+ endDate +"'" + " " +
                 	"group by b.billingId order by b.billNo asc;";	
		
		System.out.println(query);
		return query;
	}
}
