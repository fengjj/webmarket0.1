package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-21
 * @author: nidw
 * @Title: AtomQueryActBasicInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQuerySyncActInfoInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,len="18",type="string",desc="活动ID",memo="略")
	private String actId;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,len="18",type="string",desc="省份代码",memo="略")
	private String provinceGroup;
	public void decode(MBean bean) {
		setActId(bean.getStr(getPathByProperName("actId")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
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
