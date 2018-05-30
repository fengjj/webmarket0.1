package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-22
 * @author: liuhaoa
 * @Title: AtomQueryGroupNameInDTO 
 * @Description： 营销渠道组织区域数据
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryGroupNameInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ROOT_DISTANCE",cons=ConsType.CT001,len="100",desc="区域编码",type="String",memo="略")
	private String rootDistance;
	
	public String getRootDistance() {
		return rootDistance;
	}
	public void setRootDistance(String rootDistance) {
		this.rootDistance = rootDistance;
	}

	@Override
	public void decode(MBean bean){
		setRootDistance(bean.getStr(getPathByProperName("rootDistance")));
	}
}
