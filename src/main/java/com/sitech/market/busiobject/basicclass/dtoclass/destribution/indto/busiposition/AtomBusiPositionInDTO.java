package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.busiposition;



import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomBusiPositionInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="rel_id",cons=ConsType.CT001,len="20",type="String",desc="关系ID",memo="")
	private String relId;
	
	@ParamDesc(path="busi_id",cons=ConsType.CT001,len="20",type="String",desc="业务ID",memo="")
	private String busiId;
	
	@ParamDesc(path="busi_Type",cons=ConsType.CT001,len="20",type="String",desc="活动类型 ",memo="")
	private String busiType;
	
	@ParamDesc(path="chn_type",cons=ConsType.CT001,len="1",type="compx",desc="渠道类型",memo="")
	private String chnType;
	
	@ParamDesc(path="operposition_id",cons=ConsType.CT001,type="String",len="20",desc="运营位ID",memo="")
	private String operpositionId;
	
	@ParamDesc(path="reason",cons=ConsType.CT001,type="String",len="20",desc="申请理由",memo="")
	private String reason;
	
	@ParamDesc(path="start_time",cons=ConsType.CT001,type="String",len="20",desc="展示开始时间",memo="")
	private String startTime;
	
	@ParamDesc(path="end_time",cons=ConsType.CT001,type="String",len="20",desc="展示结束时间",memo="")
	private String endTime;
	
	@ParamDesc(path="status_code",cons=ConsType.CT001,type="String",len="20",desc="状态",memo="")
	private String statusCode;
	
	@ParamDesc(path="oper_no",cons=ConsType.CT001,type="String",len="20",desc="工号",memo="")
	private String operNo;
	
	@ParamDesc(path="oper_name",cons=ConsType.CT001,type="String",len="20",desc="工号姓名",memo="")
	private String operName;
	
	@ParamDesc(path="oper_time",cons=ConsType.CT001,type="String",len="20",desc="操作时间",memo="")
	private String operTime;
	
	@ParamDesc(path="PAGE_NUM",cons=ConsType.CT001,type="String",len="20",desc="当前页",memo="")
	private String pageNum;
	
	@ParamDesc(path="PAGE_SIZE",cons=ConsType.CT001,type="String",len="20",desc="每页记录数",memo="")
	private String pageSize;
	
	
	@Override
	public void decode(MBean arg0) {
		setBusiId(arg0.getStr(getPathByProperName("busiId")));
		setBusiType(arg0.getStr(getPathByProperName("busiType")));		
		setOperNo(arg0.getStr(getPathByProperName("operNo")));
		setOperName(arg0.getStr(getPathByProperName("operName")));	
		setRelId(arg0.getStr(getPathByProperName("relId")));
		setEndTime(arg0.getStr(getPathByProperName("endTime")));
		setStatusCode(arg0.getStr(getPathByProperName("statusCode")));
		setOperTime(arg0.getStr(getPathByProperName("operTime")));
		
		setStartTime(arg0.getStr(getPathByProperName("startTime")));	
		setChnType(arg0.getStr(getPathByProperName("chnType")));
		setReason(arg0.getStr(getPathByProperName("reason")));
		setOperpositionId(arg0.getStr(getPathByProperName("operpositionId")));
		
		setPageSize(arg0.getStr(getPathByProperName("pageSize")));
		setPageNum(arg0.getStr(getPathByProperName("pageNum")));
	}

	public String getRelId() {
		return relId;
	}

	public void setRelId(String relId) {
		this.relId = relId;
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

	public String getChnType() {
		return chnType;
	}

	public void setChnType(String chnType) {
		this.chnType = chnType;
	}

	public String getOperpositionId() {
		return operpositionId;
	}

	public void setOperpositionId(String operpositionId) {
		this.operpositionId = operpositionId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
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

	public String getOperTime() {
		return operTime;
	}

	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}	
	
}
