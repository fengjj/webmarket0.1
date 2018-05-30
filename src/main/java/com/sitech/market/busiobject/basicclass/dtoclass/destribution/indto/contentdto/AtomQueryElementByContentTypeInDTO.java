package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-2 
 * @author: zhangchen
 * @Title: AtomGetContentListInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryElementByContentTypeInDTO extends StandardInDTO {
		
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,type="string",len="18",desc="省份",memo="略")
	private String provinceGroup;
	@ParamDesc(path="SUB_ID",cons=ConsType.CT001,type="string",len="18",desc="省份",memo="略")
	private String subId;

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	public void decode(MBean bean) {
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setSubId(bean.getStr(getPathByProperName("subId")));

	}

	

	
	
	
}
