package com.sitech.market.busiobject.basicclass.dtoclass.common.inDTO;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomLoginInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="loginNo",cons=ConsType.CT001,type="String",len="20",desc="µÇÂ½¹¤ºÅ",memo="ÂÔ")
	private String loginNo;
	@ParamDesc(path="password",cons=ConsType.CT001,type="String",len="20",desc="µÇÂ½¹¤ºÅÃÜÂë",memo="ÂÔ")
	private String password;
	
	@Override
	public void decode(MBean arg0) {
		this.loginNo = arg0.getStr(getPathByProperName("loginNo"));
		this.password = arg0.getStr(getPathByProperName("password"));
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
