package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-11
 * @author: dongyh
 * @Title: AtomSaveAuditInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveAuditInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="18",desc="审批业务ID",type="String",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_NAME",cons=ConsType.CT001,len="200",desc="审批业务名称",type="String",memo="略")
	private String busiName;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="5",desc="审批业务类型",type="String",memo="略")
	private String busiType;
	@ParamDesc(path="BUSI_OPER_NO",cons=ConsType.CT001,len="20",desc="业务操作工号",type="String",memo="略")
	private String busiOperNo;
	@ParamDesc(path="AUDIT_FLAG",cons=ConsType.CT001,len="5",desc="审批类型标志",type="String",memo="略")
	private String auditFlag;
	@ParamDesc(path="AUDIT_ORDER",cons=ConsType.CT001,len="",desc="审批顺序",type="int",memo="略")
	private int auditOrder;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="5",desc="审批状态",type="String",memo="略")
	private String statusCode;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="20",desc="审批人工号",type="String",memo="略")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,len="64",desc="审批人名称",type="String",memo="略")
	private String operName;
	@ParamDesc(path="IS_FLAG",cons=ConsType.CT001,len="10",desc="短息发送标识",type="String",memo="略")
	private String isFlag;
	
	public void decode(MBean bean){
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiName(bean.getStr(getPathByProperName("busiName")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setBusiOperNo(bean.getStr(getPathByProperName("busiOperNo")));
		setAuditFlag(bean.getStr(getPathByProperName("auditFlag")));
		setAuditOrder(bean.getInt(getPathByProperName("auditOrder")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setIsFlag(bean.getStr(getPathByProperName("isFlag")));
	}
	
	public String getBusiId() {
		return busiId;
	}
	
	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}
	
	public String getBusiName() {
		return busiName;
	}
	
	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}
	public String getBusiType() {
		return busiType;
	}
	
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	
	public String getBusiOperNo() {
		return busiOperNo;
	}
	
	public void setBusiOperNo(String busiOperNo) {
		this.busiOperNo = busiOperNo;
	}
	
	public String getAuditFlag() {
		return auditFlag;
	}

	public void setAuditFlag(String auditFlag) {
		this.auditFlag = auditFlag;
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

	public int getAuditOrder() {
		return auditOrder;
	}

	public void setAuditOrder(int auditOrder) {
		this.auditOrder = auditOrder;
	}

	public String getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}
}
