package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-6
 * @author: liuhaoa
 * @Title: AtomGetActInfoByIdInDTO 
 * @Description： 根据活动id获取活动详细信息
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetActInfoByIdInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,len="100",desc="活动ID",type="String",memo="略")
	private String actId;
	
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	
	@Override
	public void decode(MBean bean){
		setActId(bean.getStr(getPathByProperName("actId")));
	}
}
