package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomQueryPreviewInfoInDTO extends InDTO {

	@ParamDesc(path="actId",cons=ConsType.CT001,type="String",len="20",desc="活动id",memo="")
	private String actId;
	@ParamDesc(path="provinceGroup",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String provinceGroup;
	@Override
	public void decode(MBean arg0) {
		this.actId = arg0.getStr(getPathByProperName("actId"));
		this.provinceGroup = arg0.getStr(getPathByProperName("provinceGroup"));
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getProvinceGroup() {
		return provinceGroup;
	}
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

}
