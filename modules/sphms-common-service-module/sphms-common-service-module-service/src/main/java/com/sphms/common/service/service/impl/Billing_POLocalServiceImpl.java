/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sphms.common.service.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sphms.common.service.beans.BillingPOBean;
import com.sphms.common.service.beans.POBean;
import com.sphms.common.service.beans.POHordingDTO;
import com.sphms.common.service.exception.NoSuchBilling_POException;
import com.sphms.common.service.model.Billing;
import com.sphms.common.service.model.Billing_PO;
import com.sphms.common.service.model.CustomCompany;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.LandLord;
import com.sphms.common.service.model.POPayment;
import com.sphms.common.service.service.BillingLocalServiceUtil;
import com.sphms.common.service.service.Billing_POLocalServiceUtil;
import com.sphms.common.service.service.CustomCompanyLocalServiceUtil;
import com.sphms.common.service.service.HordingLocalServiceUtil;
import com.sphms.common.service.service.LandLordLocalServiceUtil;
import com.sphms.common.service.service.POPaymentLocalServiceUtil;
import com.sphms.common.service.service.SPHMSCommonLocalServiceUtil;
import com.sphms.common.service.service.base.Billing_POLocalServiceBaseImpl;
import com.sphms.common.service.service.persistence.Billing_POPK;
import com.sphms.common.service.util.BillingStatus;
import com.sphms.common.service.util.Billing_PO_Status;
import com.sphms.common.service.util.SPHMSConstant;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the billing_ p o local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sphms.common.service.service.Billing_POLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billing_POLocalServiceBaseImpl
 * @see com.sphms.common.service.service.Billing_POLocalServiceUtil
 */
@ProviderType
public class Billing_POLocalServiceImpl extends Billing_POLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(Billing_POLocalServiceImpl.class.getName());
	
	/*
	 * Add Bill PO detail
	 */
	public Billing_PO addBillingPO(long billingId, long hordingId, double totalAmount, long createdBy, CustomCompany company){
		long landLordId = getLandLordId(hordingId);
		Billing_POPK billingPOPK = new Billing_POPK(billingId, hordingId);
		Billing_PO billingPO = Billing_POLocalServiceUtil.createBilling_PO(billingPOPK);
		billingPO.setTotalAmount(totalAmount);
		billingPO.setPoNumber(StringPool.BLANK);
		billingPO.setInternalPONumber(getNextInternalPONumber(billingId,landLordId,company.getCompanyId()));
		billingPO.setLandLordId(landLordId);
		billingPO.setFinancialYear(SPHMSCommonLocalServiceUtil.getFinancialYear());
		billingPO.setCreateDate(new Date());
		billingPO.setCreatedBy(createdBy);
		billingPO.setModifiedBy(createdBy);
		billingPO.setPaymentGiven("NO");
		billingPO.setCustomCompanyId(company.getCompanyId());
		billingPO.setStatus(Billing_PO_Status.GENERATED.getValue());
		billingPO.setModifiedDate(new Date());
		
		billingPO = Billing_POLocalServiceUtil.addBilling_PO(billingPO);
		
		return billingPO;
	}
	
	public List<Billing_PO> getBillingPOListByBillingId(long billingId){
		return billing_POPersistence.findBybillingId(billingId);
	}
	
	public List<Billing_PO> getBilling_POByBillingIdAndLandLordId(long billingId, long landLordId){
		return billing_POPersistence.findBybillingIdAndLandLordId(billingId, landLordId);
	}
	
	private long getLandLordId(long hordingId){
		long landlordId=0;
		try {
			Hording hording = HordingLocalServiceUtil.getHording(hordingId);
			landlordId = hording.getLandLordId();
		} catch (PortalException e) {
			_log.error(e);
		}
		return landlordId;
	}
	
	
	public String getNextPONumber(long billingId, long landLordId, long companyId){
		
		       // Check same Owner has hording or not for same booking
				List<Billing_PO> billingPOList = getBilling_POByBillingIdAndLandLordId(billingId, landLordId);
				
				if(billingPOList.size()!=0){
					// Generate next po number
					DynamicQuery dynamicQuery = Billing_POLocalServiceUtil.dynamicQuery();
					dynamicQuery.add(RestrictionsFactoryUtil.eq("financialYear", SPHMSCommonLocalServiceUtil.getFinancialYear()));
					dynamicQuery.add(RestrictionsFactoryUtil.isNotNull("poNumber"));
					dynamicQuery.add(RestrictionsFactoryUtil.eq("customCompanyId", companyId));
					Order defaultOrder = OrderFactoryUtil.desc("poNumber");
					dynamicQuery.addOrder(defaultOrder);
					dynamicQuery.setLimit(0, 1);
					List<Billing_PO> poList = Billing_POLocalServiceUtil.dynamicQuery(dynamicQuery);
					
					if(poList.size()==0){
						return "001";
					}else{
						String latestNumber = poList.get(0).getPoNumber();
						int newNum = (Integer.parseInt(latestNumber)+1);
						return String.format("%03d", newNum);
					}
				}else{
					// return PO number of other hoarding of same owner.
					return billingPOList.get(0).getPoNumber();
				}
		
	}
	
	private String getNextInternalPONumber(long billingId, long landLordId, long companyId){
		// Check same Owner has hording or not for same booking
				List<Billing_PO> billingPOList = getBilling_POByBillingIdAndLandLordId(billingId, landLordId);
				
				if(billingPOList.size()==0){
					// Generate next po number
					DynamicQuery dynamicQuery = Billing_POLocalServiceUtil.dynamicQuery();
					dynamicQuery.add(RestrictionsFactoryUtil.eq("financialYear", SPHMSCommonLocalServiceUtil.getFinancialYear()));
					Order defaultOrder = OrderFactoryUtil.desc("createDate");
					dynamicQuery.add(RestrictionsFactoryUtil.eq("customCompanyId", companyId));
					dynamicQuery.addOrder(defaultOrder);
					dynamicQuery.setLimit(0, 1);
					List<Billing_PO> poList = Billing_POLocalServiceUtil.dynamicQuery(dynamicQuery);
					
					if(poList.size()==0){
						return "001";
					}else{
						String latestNumber = poList.get(0).getInternalPONumber();
						int newNum = (Integer.parseInt(latestNumber)+1);
						return String.format("%03d", newNum);
					}
				}else{
					// return PO number of other hoarding of same owner.
					return billingPOList.get(0).getInternalPONumber();
				}
	}
	
	public JSONObject getBillingPOListForReport(long customComanyId, long landLoardId,Date startDate, Date endDate, int start, int end) throws PortalException{
		
		JSONObject finalObject = JSONFactoryUtil.createJSONObject();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		CustomCompany company = CustomCompanyLocalServiceUtil.getCustomCompany(customComanyId);
		LandLord landLoard = LandLordLocalServiceUtil.getLandLord(landLoardId);
		
		DynamicQuery dynamicQuery = Billing_POLocalServiceUtil.dynamicQuery();
		
		if(customComanyId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("customCompanyId", customComanyId));
		}
		
		if(landLoardId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("landLordId", landLoardId));
		}
		
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			dynamicQuery.add(RestrictionsFactoryUtil.between("createDate", startDate, endDate));
		}
		
	
		dynamicQuery.add(RestrictionsFactoryUtil.eq("paymentGiven", "NO"));
			
		dynamicQuery.setLimit(start, end);
		
		Order order = OrderFactoryUtil.desc("modifiedDate");
		dynamicQuery.addOrder(order);
		
		List<Billing_PO> outStandingPOList = Billing_POLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		
		
		DynamicQuery dynamicQuery1 = Billing_POLocalServiceUtil.dynamicQuery();
		
		if(customComanyId>0){
			dynamicQuery1.add(RestrictionsFactoryUtil.eq("customCompanyId", customComanyId));
		}
		
		if(landLoardId>0){
			dynamicQuery1.add(RestrictionsFactoryUtil.eq("landLordId", landLoardId));
		}
		
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			dynamicQuery1.add(RestrictionsFactoryUtil.between("createDate", startDate, endDate));
		}
		
	
		dynamicQuery1.add(RestrictionsFactoryUtil.eq("paymentGiven", "YES"));
	
		
		dynamicQuery1.setLimit(start, end);
	
		dynamicQuery1.addOrder(order);
		
		List<Billing_PO> submittedPOList = Billing_POLocalServiceUtil.dynamicQuery(dynamicQuery1);
		
		
		JSONArray outStandingJSONArray = JSONFactoryUtil.createJSONArray();
		double totalOustandingAmount = 0;
		for(Billing_PO billingPO : outStandingPOList){
			JSONObject billigPOJSONObject = JSONFactoryUtil.createJSONObject();
			double totalAmount = Math.round(getTotalPOAmount(billingPO, landLoard));
			BillingPOBean billlingPOBean = new BillingPOBean(billingPO, company);
			billigPOJSONObject.put("poNumber", billlingPOBean.getPoNumber());
			if(Validator.isNotNull(billingPO.getPublishDate())){
				billigPOJSONObject.put("billDate", df.format(billingPO.getPublishDate()));
			}else{
				billigPOJSONObject.put("billDate", "-");
			}
			
			billigPOJSONObject.put("totalAmount", totalAmount);
			billigPOJSONObject.put("Supplier", landLoard.getFirstName() + " " + landLoard.getLastName());
			billigPOJSONObject.put("campaign", billlingPOBean.getCampaign());
			billigPOJSONObject.put("hoarding", billlingPOBean.getHordingTitle());
			totalOustandingAmount+=totalAmount;
			outStandingJSONArray.put(billigPOJSONObject);
		}
		
		finalObject.put("outStandingPOs", outStandingJSONArray);
		finalObject.put("outStandingTotalAmount", Math.round(totalOustandingAmount));
		
		JSONArray submittedPOJSONArray = JSONFactoryUtil.createJSONArray();
		double totalPaymentSubmitted = 0;
		for(Billing_PO billingPO : submittedPOList){
			JSONObject billigPOJSONObject = JSONFactoryUtil.createJSONObject();
			double totalAmount = billingPO.getSupplierTotalAmount() + billingPO.getSupplierGstAmmount();
			BillingPOBean billlingPOBean = new BillingPOBean(billingPO, company);
			billigPOJSONObject.put("poNumber", billlingPOBean.getPoNumber());
			if(Validator.isNotNull(billingPO.getPublishDate())){
				billigPOJSONObject.put("billDate", df.format(billingPO.getPublishDate()));
			}else{
				billigPOJSONObject.put("billDate", "-");
			}
			
			billigPOJSONObject.put("totalAmount", Math.round(totalAmount));
			billigPOJSONObject.put("Supplier", landLoard.getFirstName() + " " + landLoard.getLastName());
			billigPOJSONObject.put("campaign", billlingPOBean.getCampaign());
			billigPOJSONObject.put("hoarding", billlingPOBean.getHordingTitle());
			totalPaymentSubmitted+=totalAmount;
			submittedPOJSONArray.put(billigPOJSONObject);
		}
		
		finalObject.put("submittedPOs", submittedPOJSONArray);
		finalObject.put("totalSubmittedAmount", Math.round(totalPaymentSubmitted));		
		
		
		return finalObject;
	}
	
	public  JSONObject getAllBillingPOList(long customComanyId, long landLoardId,  long billingId, String poNumber, String paymentStatus, Date startDate, Date endDate,int start, int end) throws PortalException{
		
		JSONObject finalJSONObject = JSONFactoryUtil.createJSONObject();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		CustomCompany company = CustomCompanyLocalServiceUtil.getCustomCompany(customComanyId);
		LandLord landLord = LandLordLocalServiceUtil.getLandLord(landLoardId);
		
		DynamicQuery dynamicQuery = Billing_POLocalServiceUtil.dynamicQuery();
		
		if(customComanyId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("customCompanyId", customComanyId));
		}
		
		if(landLoardId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("landLordId", landLoardId));
		}
		
		if(billingId>0){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("billingId", landLoardId));
		}
		
		if(paymentStatus.equals("YES") || paymentStatus.equals("NO")){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("paymentGiven", paymentStatus));
		}
		
		if(Validator.isNotNull(startDate) && Validator.isNotNull(endDate)){
			dynamicQuery.add(RestrictionsFactoryUtil.between("createDate", startDate, endDate));
		}
		
		if(Validator.isNotNull(poNumber)){
			dynamicQuery.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("poNumber", poNumber),
					RestrictionsFactoryUtil.eq("internalPONumber", poNumber)));
		}
					
		//dynamicQuery.setLimit(start, end);
		
		Order order = OrderFactoryUtil.desc("poNumber");
		dynamicQuery.addOrder(order);
		
		List<Billing_PO> poList = Billing_POLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		Map<String, POBean> poBeanMap = new HashMap<String,POBean>();
		
		for(Billing_PO billingPO : poList){
			
			try{
				
				
				BillingPOBean billingPOBean = new BillingPOBean(billingPO,company);
				LandLord landLoard = LandLordLocalServiceUtil.getLandLord(billingPO.getLandLordId());
				
				if(Validator.isNull(poBeanMap.get(billingPO.getLandLordId()+":"+billingPO.getBillingId()))){
					
					POBean poBean = new POBean();
					List<POHordingDTO> hordingList = new ArrayList<POHordingDTO>();
					POHordingDTO poHordingDTO = new POHordingDTO();
					poHordingDTO.setHordingTitle(billingPOBean.getHordingTitle());
					poBean.setBillingId(billingPO.getBillingId());
					poBean.setLandlordId(billingPO.getLandLordId());
					poBean.setLandLordName(landLord.getFirstName()+" " + landLord.getLastName());
					poBean.setPoNumber(Billing_POLocalServiceUtil.getPONumber(billingPO,company));
					poBean.setFinancialYear(billingPO.getFinancialYear());
					poBean.setStatus(Billing_PO_Status.findByValue(billingPO.getStatus()).getLabel());
					hordingList.add(poHordingDTO);
					poBean.setHordingList(hordingList);
					poBean.setSupplierBillNo(billingPO.getSupplierBillNo());
					poBean.setSupplierPaymentGiven(Validator.isNotNull(billingPO.getPaymentGiven())?billingPO.getPaymentGiven():"NO");
					poBean.setPoSortingNumber(Validator.isNotNull(billingPO.getPoNumber())?Integer.parseInt(billingPO.getPoNumber()):0);
					poBean.setCampaign(billingPOBean.getCampaign());
					// Total OustStanding;
					poBean.setTotalOutStanding(Math.round(billingPO.getTotalAmount()));
					poBean.setTotalPaymentGiven(Math.round(getTotalPOPayment(billingPO.getBillingId(), billingPO.getLandLordId())));
					poBean.setCompanyId(billingPOBean.getCompanyId());					
					poBeanMap.put(billingPO.getLandLordId()+":"+billingPO.getBillingId(), poBean);
					
					
				}else{
					POBean poBean = poBeanMap.get(billingPO.getLandLordId()+":"+billingPO.getBillingId());
					
					List<POHordingDTO> hordingList = poBean.getHordingList();
					POHordingDTO poHordingDTO = new POHordingDTO();
					poHordingDTO.setHordingTitle(billingPOBean.getHordingTitle());
					hordingList.add(poHordingDTO);
					poBean.setHordingList(hordingList);
					
					poBean.setTotalOutStanding(Math.round(poBean.getTotalOutStanding()+billingPO.getTotalAmount()));
					poBean.setTotalPaymentGiven(Math.round(getTotalPOPayment(billingPO.getBillingId(), billingPO.getLandLordId())));
					poBean.setPoSortingNumber(Validator.isNotNull(billingPO.getPoNumber())?Integer.parseInt(billingPO.getPoNumber()):0);
					
					poBeanMap.put(billingPO.getLandLordId()+":"+billingPO.getBillingId(), poBean);
				}
			}catch(Exception e){
				_log.error(e);
			}
		}
		
		List<POBean> allPOBeanList = new ArrayList<POBean>();
		for(Map.Entry<String, POBean> entry : poBeanMap.entrySet()){
			POBean poBean = entry.getValue();
			double totalAmountWithGST = getTotalAmountWithGST(landLord, poBean.getTotalOutStanding());
			poBean.setTotalOutStanding(Math.round(totalAmountWithGST));
			allPOBeanList.add(entry.getValue());
		}
		
		Collections.sort(allPOBeanList, new Comparator<POBean>() {
            public int compare(POBean po1, POBean po2) {
                // avoiding NullPointerException in case name is null
                Integer idea1 = po1.getPoSortingNumber();
                Integer idea2 = po2.getPoSortingNumber();
                return idea2.compareTo(idea1);
            }
        });
		
		
       if(allPOBeanList.size()>end){
    	   finalJSONObject.put("poList", allPOBeanList.subList(start, end));
       }else{
    	   finalJSONObject.put("poList", allPOBeanList.subList(start, start+allPOBeanList.size()));
       }
		
       finalJSONObject.put("totalPO", allPOBeanList.size());
	
		return finalJSONObject;
	}
	
	private double getTotalPOAmount(Billing_PO billingPO, LandLord landLord){
			
		double iGSTCharge = 0d;
		double cGSTCharge = 0d;
		double sGSTCharge = 0d;
		double totalAmount = billingPO.getTotalAmount();
		boolean isClientOutOfGuj = isLandLordOutOfGujrat(landLord);
		if(isClientOutOfGuj){
			iGSTCharge = totalAmount*Double.parseDouble(PropsUtil.get("igst.rate"));
			totalAmount = totalAmount + iGSTCharge;
		}else{
			//Total amount
			// Considering CGST as 9%
			 cGSTCharge = totalAmount* Double.parseDouble(PropsUtil.get("cgst.rate"));
			// Consideting SGST as 9%
			 sGSTCharge = totalAmount* Double.parseDouble(PropsUtil.get("sgst.rate"));
			
			totalAmount = totalAmount + cGSTCharge + sGSTCharge;
		}
		
		return totalAmount;
	}
	
	private  boolean isLandLordOutOfGujrat(LandLord landLord){
		if(Validator.isNotNull(landLord) && Validator.isNotNull(landLord.getStatec()) && !landLord.getStatec().toLowerCase().equalsIgnoreCase("gujarat")){
			return true;
		}
		return false;
	}
	
	public String getPONumber(Billing_PO billingPO, CustomCompany company){
		String displayPONo = StringPool.BLANK;
		if(Validator.isNotNull(billingPO) && billingPO.getStatus()==Billing_PO_Status.GENERATED.getValue()){
			return SPHMSConstant.INTERNAL_BILL_PREFIX +StringPool.SLASH + company.getShortName()+ "-"+ billingPO.getInternalPONumber() +"/"+ billingPO.getFinancialYear();
		}else if(Validator.isNotNull(billingPO) && billingPO.getStatus()==Billing_PO_Status.PUBLISH.getValue()){
			return company.getShortName()+ "-"+ billingPO.getPoNumber() +"/"+ billingPO.getFinancialYear();
		}
		 
		return displayPONo;
	}
	
	public double getTotalPOPayment(long billingId, long landlordId){
		double totalAmount = 0;
		List<POPayment> poPaymentList = POPaymentLocalServiceUtil.getPOPaymnetByBillingIdAndHoardingId(billingId, landlordId);
		for(POPayment poPayment :poPaymentList){
			totalAmount += poPayment.getAmount();
			totalAmount += poPayment.getGst();
		}
		
		return totalAmount;
	}
	
	public double getTotalAmountWithGST(LandLord loadLoard, double totalAmount){
		double iGSTCharge = 0d;
		double cGSTCharge = 0d;
		double sGSTCharge = 0d;
		boolean isClientOutOfGuj = isLandLordOutOfGujrat(loadLoard);
		if(isClientOutOfGuj){
			iGSTCharge = totalAmount*Double.parseDouble(PropsUtil.get("igst.rate"));
			totalAmount = totalAmount + iGSTCharge;
		}else{
			//Total amount
			// Considering CGST as 9%
			 cGSTCharge = totalAmount* Double.parseDouble(PropsUtil.get("cgst.rate"));
			// Consideting SGST as 9%
			 sGSTCharge = totalAmount* Double.parseDouble(PropsUtil.get("sgst.rate"));
			
			totalAmount = totalAmount + cGSTCharge + sGSTCharge;
			
		}
		
		return totalAmount;
	}
}