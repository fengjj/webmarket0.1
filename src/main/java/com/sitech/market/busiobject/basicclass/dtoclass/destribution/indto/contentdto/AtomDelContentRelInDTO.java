package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-2 
 * @author: jiaxla
 * @Title: AtomDelContentRelInDTO 
 * @Description£º 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomDelContentRelInDTO extends StandardInDTO {
		
	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="CONTENT_SERIAL_ID",cons=ConsType.CT001,type="string",len="5",desc="ÄÚÈÝ±àºÅ",memo="ÂÔ")
	private String contentSerialId;
	@ParamDesc(path="REL_ID",cons=ConsType.CT001,type="string",len="5",desc="ÄÚÈÝ±àºÅ",memo="ÂÔ")
	private String relId;
	@ParamDesc(path="CONTENT_TYPE",cons=ConsType.CT001,type="string",len="5",desc="ÄÚÈÝÀàÐÍ",memo="ÂÔ")
	private String contentType;
	
	public void decode(MBean bean) {
		setContentSerialId(bean.getStr(getPathByProperName("contentSerialId")));
		setRelId(bean.getStr(getPathByProperName("relId")));
	}
	
	public String getContentSerialId() {
		return contentSerialId;
	}
	public void setContentSerialId(String contentSerialId) {
		this.contentSerialId = contentSerialId;
	}
	public String getRelId() {
		return relId;
	}
	public void setRelId(String relId) {
		this.relId = relId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
