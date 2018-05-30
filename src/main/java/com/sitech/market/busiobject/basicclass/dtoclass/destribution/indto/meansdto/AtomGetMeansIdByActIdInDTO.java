package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.meansdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomGetMeansIdByActIdInDTO extends InDTO{

	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,len="20",type="String",desc="»î¶¯ID",memo="")
	private String actId;
	@Override
	public void decode(MBean bean) {
		setActId(bean.getStr(getPathByProperName("actId")));
		
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	
	

}
