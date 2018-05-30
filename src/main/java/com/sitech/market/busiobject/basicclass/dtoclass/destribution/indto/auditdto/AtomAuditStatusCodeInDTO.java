package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-8
 * @author: liuhaoa
 * @Title: AtomAuditStatusCodeInDTO 
 * @Description： 提交至待预发布状态
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomAuditStatusCodeInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,len="100",desc="活动ID",type="String",memo="略")
	private String actId;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.CT001,len="100",desc="发布状态",type="String",memo="略")
	private String statusCode;
	
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@Override
	public void decode(MBean bean){
		setActId(bean.getStr(getPathByProperName("actId")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
	}
}
