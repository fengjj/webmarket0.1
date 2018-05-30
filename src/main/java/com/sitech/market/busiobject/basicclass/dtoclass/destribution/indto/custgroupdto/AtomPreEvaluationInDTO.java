package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 预评估批量业务的客户群
 * @Create on 2015-7-30 
 * @author: wangdw
 * @Title: AtomPreEvaluationInDTO 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
@SuppressWarnings("serial")
public class AtomPreEvaluationInDTO extends StandardInDTO {
	
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="100",desc="业务ID",type="String",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="6",desc="业务类型",type="String",memo="略")
	private String busiType;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,len="10",desc="省份代码",type="String",memo="略")
	private String provinceGroup;
	
	@Override
	public void decode(MBean bean){
		this.busiId = bean.getStr(getPathByProperName("busiId"));
		this.busiType = bean.getStr(getPathByProperName("busiType"));
		this.provinceGroup = bean.getStr(getPathByProperName("provinceGroup"));
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

}
