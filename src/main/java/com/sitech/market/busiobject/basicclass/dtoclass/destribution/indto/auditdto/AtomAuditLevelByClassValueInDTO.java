package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-7
 * @author: liuhaoa
 * @Title: AtomAuditLevelByClassValueInDTO 
 * @Description： 获取下一级审批人
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomAuditLevelByClassValueInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CLASS_VALUE",cons=ConsType.CT001,len="100",desc="活动类型",type="String",memo="略")
	private String classValue;
	@ParamDesc(path="AUDIT_NO",cons=ConsType.CT001,len="100",desc="审批工号",type="String",memo="略")
	private String auditNo;
	
	public String getClassValue() {
		return classValue;
	}
	public void setClassValue(String classValue) {
		this.classValue = classValue;
	}
	public String getAuditNo() {
		return auditNo;
	}
	public void setAuditNo(String auditNo) {
		this.auditNo = auditNo;
	}
	
	@Override
	public void decode(MBean bean){
		setClassValue(bean.getStr(getPathByProperName("classValue")));
		setAuditNo(bean.getStr(getPathByProperName("auditNo")));
	}
}
