package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomQueryActStatusCodeInDTO extends InDTO {

	private static final long serialVersionUID = 5321121349012184101L;
	@ParamDesc(path="actId",cons=ConsType.CT001,len="20",type="String",desc="»î¶¯id",memo="")
	private String actId;
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	@Override
	public void decode(MBean arg0) {
		this.actId = arg0.getStr(getPathByProperName("actId"));
	}

}
