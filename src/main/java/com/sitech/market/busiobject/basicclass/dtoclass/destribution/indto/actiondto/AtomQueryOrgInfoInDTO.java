package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomQueryOrgInfoInDTO extends InDTO {

	@ParamDesc(path="parentId",cons=ConsType.CT001,len="20",type="String",desc="组织机构父节点id",memo="")
	private String parentId;
	@ParamDesc(path="loginNo",cons=ConsType.CT001,len="20",type="String",desc="登陆账号",memo="")
	private String loginNo;
	public String getLoginNo() {
		return loginNo;
	}
	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Override
	public void decode(MBean arg0) {
		this.parentId = arg0.getStr(getPathByProperName("parentId"));
		this.loginNo = arg0.getStr(getPathByProperName("loginNo"));
	}

}
