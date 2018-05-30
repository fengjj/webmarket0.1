package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-18
 * @author: dongyh
 * @Title: AtomQueryPhoneInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryReleasePhoneInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="REGION_CODE",cons=ConsType.CT001,len="20",type="String",desc="归属地市",memo="略")
	private String regionCode;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="5",type="string",desc="业务类型",memo="略")
	private String busiType;

	public void decode(MBean bean){
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
	}
	
	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getBusiType() {
		return busiType;
	}
	
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
}
