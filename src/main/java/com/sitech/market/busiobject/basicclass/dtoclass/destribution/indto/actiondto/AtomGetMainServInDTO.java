package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomGetMainServInDTO extends InDTO {

	@ParamDesc(path="actOrgCode",cons=ConsType.CT001,type="String",len="2",desc="区分移动铁通标志",memo="")
	private String actOrgCode;
	@ParamDesc(path="busiId",cons=ConsType.CT001,type="String",len="20",desc="业务id",memo="")
	private String busiId;
	@ParamDesc(path="loginType",cons=ConsType.CT001,type="String",len="2",desc="登陆类型",memo="")
	private String loginType;
	@ParamDesc(path="busiType",cons=ConsType.CT001,type="String",len="2",desc="业务类型",memo="")
	private String busiType;
	public String getActOrgCode() {
		return actOrgCode;
	}
	public void setActOrgCode(String actOrgCode) {
		this.actOrgCode = actOrgCode;
	}
	public String getBusiId() {
		return busiId;
	}
	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getBusiType() {
		return busiType;
	}
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	@Override
	public void decode(MBean arg0) {
		this.busiId = arg0.getStr(getPathByProperName("busiId"));
		this.busiType = arg0.getStr(getPathByProperName("busiType"));
		this.loginType = arg0.getStr(getPathByProperName("loginType"));
		this.actOrgCode = arg0.getStr(getPathByProperName("actOrgCode"));
	}

}
