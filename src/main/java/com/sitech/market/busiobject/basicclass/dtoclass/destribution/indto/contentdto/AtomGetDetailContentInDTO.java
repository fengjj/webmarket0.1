package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-23 
 * @author: yugl
 * @Title: AtomGetDetailContentInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetDetailContentInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CONTENT_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="内容流水号",memo="略")
	private String contentSerialId;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="18",desc="省份编码",memo="略")
	private String provinceGroup;
	@ParamDesc(path="DEL_NULL_ELE",cons=ConsType.QUES,type="string",len="5",desc="是否删除空元素",memo="略")
	private String delNullEle;
	@ParamDesc(path="SUB_ID",cons=ConsType.QUES,type="string",len="5",desc="数据订阅ID",memo="略")
	private String subId;
	
	public void decode(MBean bean) {
		setContentSerialId(bean.getStr(getPathByProperName("contentSerialId")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setDelNullEle(bean.getStr(getPathByProperName("delNullEle")));
		setSubId(bean.getStr(getPathByProperName("subId")));
	}

	public String getContentSerialId() {
		return contentSerialId;
	}
	
	public void setContentSerialId(String contentSerialId) {
		this.contentSerialId = contentSerialId;
	}
	
	public String getProvinceGroup() {
		return provinceGroup;
	}
	
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	
	public String getDelNullEle() {
		return delNullEle;
	}
	
	public void setDelNullEle(String delNullEle) {
		this.delNullEle = delNullEle;
	}
	
	public String getSubId() {
		return subId;
	}
	
	public void setSubId(String subId) {
		this.subId = subId;
	}
	
}
