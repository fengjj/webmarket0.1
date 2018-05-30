package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;


import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomInitCondInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="actId",cons=ConsType.CT001,len="20",type="String",desc="活动id",memo="")
	private String actId;
	@ParamDesc(path="serialId",cons=ConsType.CT001,len="2",type="String",desc="客户群关系表主键",memo="")
	private String serialId;
	@ParamDesc(path="provinceGroup",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String provinceGroup;
	
	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	
	


	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	@Override
	public void decode(MBean arg0) {
		System.out.println(arg0);
		System.out.println(getPathByProperName("actId"));
		System.out.println(arg0.getStr(getPathByProperName("actId")));
		setActId(arg0.getStr(getPathByProperName("actId")));
		setSerialId(arg0.getStr(getPathByProperName("serialId")));
		setProvinceGroup(arg0.getStr(getPathByProperName("provinceGroup")));
	}

}
