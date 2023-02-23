package com.project.test.vo;

public class StatVO {
	private String searchCon; // 분류 기준 (시간, 일, 월)
	private int issueCnt = 0; // 발급 건 수
	private String policyOid; // 증명서 종류
	
	   // 검색
	
	private String srcReqName = ""; // 요청자명
	
	private String srcDate = "";
	private String srcTimeFrom = "";
	private String srcTimeTo = "";
	   
	public String getSearchCon() {
		return searchCon;
	}
	public void setSearchCon(String searchCon) {
		this.searchCon = searchCon;
	}
	public int getIssueCnt() {
		return issueCnt;
	}
	public void setIssueCnt(int issueCnt) {
		this.issueCnt = issueCnt;
	}
	public String getPolicyOid() {
		return policyOid;
	}
	public void setPolicyOid(String policyOid) {
		this.policyOid = policyOid;
	}
	public String getSrcReqName() {
		return srcReqName;
	}
	public void setSrcReqName(String srcReqName) {
		this.srcReqName = srcReqName;
	}
	public String getSrcDate() {
		return srcDate;
	}
	public void setSrcDate(String srcDate) {
		this.srcDate = srcDate;
	}
	public String getSrcTimeFrom() {
		return srcTimeFrom;
	}
	public void setSrcTimeFrom(String srcTimeFrom) {
		this.srcTimeFrom = srcTimeFrom;
	}
	public String getSrcTimeTo() {
		return srcTimeTo;
	}
	public void setSrcTimeTo(String srcTimeTo) {
		this.srcTimeTo = srcTimeTo;
	}
	}
