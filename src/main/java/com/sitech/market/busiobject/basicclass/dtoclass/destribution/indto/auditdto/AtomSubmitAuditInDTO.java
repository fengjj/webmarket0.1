package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
/**
 * ��������ύinDTO
 * Create on 2015-5-7 
 * @author: wangdw
 * @Title: AtomSubmitAuditInDTO 
 * @Description�� 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSubmitAuditInDTO extends StandardInDTO {
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="100",desc="ҵ��ID",type="String",memo="��")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="6",desc="ҵ������mk_codename_dict.mk_busitype_dict",type="String",memo="��")
	private String busiType;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="6",desc="����״̬��mk_auditstatus_dict",type="String",memo="��")
	private String statusCode;
	@ParamDesc(path="AUDIT_DESC",cons=ConsType.CT001,len="1000",desc="�������",type="String",memo="��")
	private String auditDesc;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,len="21",desc="������ˮID",type="String",memo="��")
	private String serialId;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="10",desc="�����˹���",type="String",memo="��")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,len="100",desc="����������",type="String",memo="��")
	private String operName;
	@ParamDesc(path="BUSI_NAME",cons=ConsType.CT001,len="1000",desc="�����",type="String",memo="��")
	private String busiName;
	@ParamDesc(path="ISNOT_AUDIT",cons=ConsType.CT001,len="10",desc="�Ƿ��������",type="String",memo="��")
	private String isNotAudit;
	@ParamDesc(path="ACT_CLASS",cons=ConsType.CT001,len="10",desc="�С��",type="String",memo="��")
	private String actClass;
	

	@Override
	public void decode(MBean arg0){
		this.busiId = arg0.getStr(getPathByProperName("busiId"));
		this.busiType = arg0.getStr(getPathByProperName("busiType"));
		this.statusCode = arg0.getStr(getPathByProperName("statusCode"));
		this.auditDesc = arg0.getStr(getPathByProperName("auditDesc"));
		this.serialId = arg0.getStr(getPathByProperName("serialId"));
		this.operNo = arg0.getStr(getPathByProperName("operNo"));
		this.operName = arg0.getStr(getPathByProperName("operName"));
		this.busiName = arg0.getStr(getPathByProperName("busiName"));
		this.isNotAudit = arg0.getStr(getPathByProperName("isNotAudit"));
		this.actClass = arg0.getStr(getPathByProperName("actClass"));
	}


	public String getBusiName() {
		return busiName;
	}


	public void setBusiName(String busiName) {
		this.busiName = busiName;
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

	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getAuditDesc() {
		return auditDesc;
	}
	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	
	public String getIsNotAudit() {
		return isNotAudit;
	}

	public void setIsNotAudit(String isNotAudit) {
		this.isNotAudit = isNotAudit;
	}
	
	public String getActClass() {
		return actClass;
	}

	public void setActClass(String actClass) {
		this.actClass = actClass;
	}
}
