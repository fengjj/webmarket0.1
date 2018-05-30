package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-26
 * @author: liuhaoa
 * @Title: AtomAuditListInDTO 
 * @Description�� �����б�
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomAuditListInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_NAME",cons=ConsType.CT001,len="100",desc="�����",type="String",memo="��")
	private String busiName;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="100",desc="����״̬",type="String",memo="��")
	private String statusCode;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="100",desc="�����",type="String",memo="��")
	private String busiType;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="100",desc="��������",type="String",memo="��")
	private String operNo;
	@ParamDesc(path="BEGIN_NUM",cons=ConsType.CT001,len="100",desc="ҳ��",type="String",memo="��")
	private String beginNum;
	@ParamDesc(path="END_NUM",cons=ConsType.CT001,len="100",desc="ÿҳ��ʾ������",type="String",memo="��")
	private String endNum;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="100",desc="�ID",type="String",memo="��")
	private String busiId;
	public String getBusiId() {
		return busiId;
	}
	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}
	public String getOperNo() {
		return operNo;
	}
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}
	public String getBeginNum() {
		return beginNum;
	}
	public void setBeginNum(String beginNum) {
		this.beginNum = beginNum;
	}
	public String getEndNum() {
		return endNum;
	}
	public void setEndNum(String endNum) {
		this.endNum = endNum;
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
		setBeginNum(bean.getStr(getPathByProperName("beginNum")));
		setEndNum(bean.getStr(getPathByProperName("endNum")));
		setBusiId(bean.getStr(getPathByProperName("busiId")));
	}
}