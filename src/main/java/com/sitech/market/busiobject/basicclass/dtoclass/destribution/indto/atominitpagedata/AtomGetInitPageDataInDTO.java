package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.atominitpagedata;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: AtomQueryExeElementsInDTO
 * @Description： 自动打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetInitPageDataInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="SUB_ID",cons=ConsType.CT001,type="string",len="5",desc="元素配置类型",memo="0：策划界面 1：执行界面-活动列表查询 2：执行界面-活动办理")
	private String subId;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.QUES,type="string",len="18",desc="元素ID",memo="略")
	private String elementId;
	@ParamDesc(path="BUSI_STRING",cons=ConsType.QUES,type="string",len="18",desc="业务数据串",memo="略")
	private String busiString;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,type="string",len="20",desc="省份标识",memo="略")
	private String provinceGroup;
	@ParamDesc(path="DEL_NULL_ELE",cons=ConsType.QUES,type="string",len="20",desc="是否删除空元素",memo="略")
	private String delNullEle;
	
	
	
	public void decode(MBean bean) {
		setSubId(bean.getStr(getPathByProperName("subId")));
		setElementId(bean.getStr(getPathByProperName("elementId")));
		setBusiString(bean.getStr(getPathByProperName("busiString")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setDelNullEle(bean.getStr(getPathByProperName("delNullEle")));
	}
	
	public String getBusiString() {
        return busiString;
    }

    public void setBusiString(String busiString) {
        this.busiString = busiString;
    }

    public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
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
	
}
