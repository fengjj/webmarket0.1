package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-29
 * @author: liuhaoa
 * @Title: AtomAuditResultCountInDTO 
 * @Description： 审批列表总条数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomAuditResultCountInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_NAME",cons=ConsType.CT001,len="100",desc="活动名称",type="String",memo="略")
	private String busiName;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="100",desc="审批状态",type="String",memo="略")
	private String statusCode;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="100",desc="活动类型",type="String",memo="略")
	private String busiType;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="100",desc="审批工号",type="String",memo="略")
	private String operNo;
	
	public String getOperNo() {
		return operNo;
	}
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}
	public String getBusiName() {
		return busiName;
	}
	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	
	@Override
	public void decode(MBean bean){
		setBusiName(bean.getStr(getPathByProperName("busiName")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
	}
}