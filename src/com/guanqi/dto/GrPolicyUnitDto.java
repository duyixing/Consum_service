package com.guanqi.dto;

import java.math.BigDecimal;
import java.util.Date;

public class GrPolicyUnitDto {
	private String policyno;
	private String proposalno;
	private Date startdate;
	private BigDecimal grsprem;
	
	public GrPolicyUnitDto(String policyno, String proposalno, Date startdate,
			BigDecimal grsprem) {
		super();
		this.policyno = policyno;
		this.proposalno = proposalno;
		this.startdate = startdate;
		this.grsprem = grsprem;
	}
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getProposalno() {
		return proposalno;
	}
	public void setProposalno(String proposalno) {
		this.proposalno = proposalno;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public BigDecimal getGrsprem() {
		return grsprem;
	}
	public void setGrsprem(BigDecimal grsprem) {
		this.grsprem = grsprem;
	}
	@Override
	public String toString() {
		return "GrPolicyUnitDto [policyno=" + policyno + ", proposalno="
				+ proposalno + ", startdate=" + startdate + ", grsprem="
				+ grsprem + "]";
	}
	
}
