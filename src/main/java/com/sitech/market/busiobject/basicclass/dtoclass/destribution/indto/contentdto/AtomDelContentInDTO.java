package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-29
 * @author: zhangchen
 * @Title: AtomDelContentInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomDelContentInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="CONTENT_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="内容关系ID",memo="略")
	private String contentSerialId;
	
	@ParamDesc(path="SUB_CONTENT_ID",cons=ConsType.QUES,type="string",len="18",desc="内容明细ID",memo="略")
	private String subContentId;
	
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.QUES,type="string",len="18",desc="元素ID",memo="略")
	private String elementId;
	
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="18",desc="元素ID",memo="略")
	private String provinceGroup;

	public void decode(MBean bean) {
		setContentSerialId(bean.getStr(getPathByProperName("contentSerialId")));
		setSubContentId(bean.getStr(getPathByProperName("subContentId")));
		setElementId(bean.getStr(getPathByProperName("elementId")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
	}
	public String getProvinceGroup() {
		return provinceGroup;
	}
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	public String getSubContentId() {
		return subContentId;
	}
	public void setSubContentId(String subContentId) {
		this.subContentId = subContentId;
	}
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getContentSerialId() {
		return contentSerialId;
	}
	public void setContentSerialId(String contentSerialId) {
		this.contentSerialId = contentSerialId;
	}
}
