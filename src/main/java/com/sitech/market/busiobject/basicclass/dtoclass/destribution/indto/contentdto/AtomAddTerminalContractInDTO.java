package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

public class AtomAddTerminalContractInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CONTENT_TYPE",cons=ConsType.CT001,type="string",len="18",desc="内容类型",memo="略")
	private String contentType;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,type="string",len="18",desc="省份标识",memo="略")
	private String provinceGroup; 
	
	public void decode(MBean bean) {
		setContentType(bean.getStr(getPathByProperName("contentType")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

}
