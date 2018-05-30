package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.meansdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomGetRulclassListInDTO extends InDTO{

	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,len="20",type="String",desc="省份标识",memo="")
	private String provinceGroup;
	@ParamDesc(path="CLASS_VALUE",cons=ConsType.CT001,len="20",type="String",desc="省份标识",memo="")
	private String classValue;
	@Override
	public void decode(MBean bean) {
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setClassValue(bean.getStr(getPathByProperName("classValue")));
	}
	public String getProvinceGroup() {
		return provinceGroup;
	}
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	public String getClassValue() {
		return classValue;
	}
	public void setClassValue(String classValue) {
		this.classValue = classValue;
	}

	

}
