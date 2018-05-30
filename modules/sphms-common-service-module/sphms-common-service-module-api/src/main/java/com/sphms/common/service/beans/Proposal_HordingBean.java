package com.sphms.common.service.beans;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sphms.common.service.model.Hording;
import com.sphms.common.service.model.Proposal;
import com.sphms.common.service.model.Proposal_Hording;
import com.sphms.common.service.service.HordingLocalServiceUtil;

public class Proposal_HordingBean {
	
	Log _log = LogFactoryUtil.getLog(Proposal_HordingBean.class.getName());
	
	private long proposalId;
	private long hordingId;
	private String hordingTitle;
	private String hoardingCity;
	private double mountingCharge;
	private double printingCharge;
	private int units;
	
	public Proposal_HordingBean(Proposal proposal, Proposal_Hording proposalHording){
		this.proposalId = proposal.getProposalId();
		this.hordingId = proposalHording.getHordingId();
		this.mountingCharge = proposalHording.getMountingCharge();
		this.printingCharge = proposalHording.getPrintingCharge();
		this.units = proposalHording.getUnits();
		
		try {
			Hording hording = HordingLocalServiceUtil.getHording(this.hordingId);
			this.hordingTitle = hording.getTitle();
			this.hoardingCity = hording.getCity();
		} catch (PortalException e) {
			_log.error(e);
		}
	}
	
	public Proposal_HordingBean(){
		
	}
	
	public long getProposalId() {
		return proposalId;
	}
	public void setProposalId(long proposalId) {
		this.proposalId = proposalId;
	}
	public long getHordingId() {
		return hordingId;
	}
	public void setHordingId(long hordingId) {
		this.hordingId = hordingId;
	}
	public String getHordingTitle() {
		return hordingTitle;
	}
	public void setHordingTitle(String hordingTitle) {
		this.hordingTitle = hordingTitle;
	}
	public double getMountingCharge() {
		return mountingCharge;
	}
	public void setMountingCharge(double mountingCharge) {
		this.mountingCharge = mountingCharge;
	}
	public double getPrintingCharge() {
		return printingCharge;
	}
	public void setPrintingCharge(double printingCharge) {
		this.printingCharge = printingCharge;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}

	public String getHoardingCity() {
		return hoardingCity;
	}

	public void setHoardingCity(String hoardingCity) {
		this.hoardingCity = hoardingCity;
	}
	
	
	
	
}
