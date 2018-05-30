package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

/**
 * Create on 2015-7-2 
 * @author: gengws
 * @Title: AtomGetElecContentSerialIdInDTO 
 * @Description： 根据电子卡的活动ID查询内容表的content_serial_id InDTO
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetElecContentSerialIdInDTO extends InDTO {

	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,type="String",len="64",desc="活动ID",memo="略")
	String actId;
	
	@Override
	public void decode(MBean bean) {
		this.actId=(String) bean.getObject(getPathByProperName("actId"));
	}

	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getActId() {
		return actId;
	}
	
	
}
