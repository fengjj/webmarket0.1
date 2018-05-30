package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomQueryCheckPhoneInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="actId",cons=ConsType.CT001,len="20",type="String",desc="活动id",memo="")
	private String actId;
	@ParamDesc(path="phoneNo",cons=ConsType.CT001,len="20",type="String",desc="电话号码",memo="")
	private String phoneNo;
	@Override
	public void decode(MBean arg0) {
		this.actId = arg0.getStr(getPathByProperName("actId"));
		this.phoneNo = arg0.getStr(getPathByProperName("phoneNo"));
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
