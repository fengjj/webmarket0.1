package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.anno.ParamType;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomQueryCheckFeeInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="actId",cons=ConsType.CT001,type="String",len="20",desc="»î¶¯id",memo="")
	private String actId;
	@Override
	public void decode(MBean arg0) {
		this.actId = arg0.getStr(getPathByProperName("actId"));
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}

}
