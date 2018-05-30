package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.meansdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomSaveMeansBasicInDTO extends InDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="REGION_CODE",cons=ConsType.CT001,len="20",type="String",desc="地市编码",memo="")
	private String regionCode;
	@ParamDesc(path="MEANS_NAME",cons=ConsType.CT001,len="20",type="String",desc="档次名称",memo="")
	private String meansName;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="20",type="String",desc="档次状态",memo="")
	private String statusCode;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="20",type="String",desc="操作人No",memo="")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,len="20",type="String",desc="操作人名称",memo="")
	private String operName;
	@ParamDesc(path="CHN_TYPE_STR",cons=ConsType.CT001,len="20",type="String",desc="活动ID",memo="")
	private String chnTypeStr;
	@ParamDesc(path="MEANS_ID",cons=ConsType.CT001,len="20",type="String",desc="档次ID",memo="")
	private String meansId;
	@ParamDesc(path="START_DATE",cons=ConsType.CT001,len="200",type="String",desc="开始时间",memo="")
	private String startDate;
	@ParamDesc(path="END_DATE",cons=ConsType.CT001,len="200",type="String",desc="结束时间",memo="")
	private String endDate;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="200",type="String",desc="业务编号",memo="")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="200",type="String",desc="业务类型",memo="")
	private String busiType;
	
	@Override
	public void decode(MBean bean) {
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setMeansName(bean.getStr(getPathByProperName("meansName")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setChnTypeStr(bean.getStr(getPathByProperName("chnTypeStr")));
		setMeansId(bean.getStr(getPathByProperName("meansId")));
		setStartDate(bean.getStr(getPathByProperName("startDate")));
		setEndDate(bean.getStr(getPathByProperName("endDate")));
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
	}
	
	public String getBusiId() {
		return busiId;
	}
	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getMeansName() {
		return meansName;
	}

	public void setMeansName(String meansName) {
		this.meansName = meansName;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getOperNo() {
		return operNo;
	}

	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getChnTypeStr() {
		return chnTypeStr;
	}

	public void setChnTypeStr(String chnTypeStr) {
		this.chnTypeStr = chnTypeStr;
	}

	public String getMeansId() {
		return meansId;
	}

	public void setMeansId(String meansId) {
		this.meansId = meansId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
