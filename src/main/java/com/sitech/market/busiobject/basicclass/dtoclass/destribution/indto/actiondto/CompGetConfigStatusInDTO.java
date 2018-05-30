package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class CompGetConfigStatusInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="opId",cons=ConsType.CT001,type="String",len="20",desc="",memo="")
	private String opId;
	public String getOpId() {
		return opId;
	}
	public void setOpId(String opId) {
		this.opId = opId;
	}
	@Override
	public void decode(MBean arg0) {
		this.opId = arg0.getStr(getPathByProperName("opId"));
	}

}
