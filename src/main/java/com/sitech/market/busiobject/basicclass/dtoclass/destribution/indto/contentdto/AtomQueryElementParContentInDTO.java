package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

public class AtomQueryElementParContentInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.CT001,type="string",len="18",desc="ÔªËØID",memo="ÂÔ")
	private String elementId;
	@ParamDesc(path="PROD_TYPE",cons=ConsType.CT001,type="string",len="10",desc="Ì×²ÍÀàÐÍ",memo="ÂÔ")
	private String prodType;
	
	public void decode(MBean bean) {
		setElementId(bean.getStr(getPathByProperName("elementId")));
		setProdType(bean.getStr(getPathByProperName("prodType")));
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

}
