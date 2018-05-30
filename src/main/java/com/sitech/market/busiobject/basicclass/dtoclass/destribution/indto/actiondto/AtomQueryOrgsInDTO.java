package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-13
 * @author: liuhaoa
 * @Title: AtomQueryOrgsInDTO 
 * @Description： 营销渠道区域选择
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryOrgsInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="GROUP_ID",cons=ConsType.CT001,len="100",desc="区域ID",type="String",memo="略")
	private String groupId;
	@ParamDesc(path="ROOT_DISTANCE",cons=ConsType.CT001,len="100",desc="区域编码",type="String",memo="略")
	private String rootDistance;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getRootDistance() {
		return rootDistance;
	}
	public void setRootDistance(String rootDistance) {
		this.rootDistance = rootDistance;
	}
	
	@Override
	public void decode(MBean bean){
		setGroupId(bean.getStr(getPathByProperName("groupId")));
		setRootDistance(bean.getStr(getPathByProperName("rootDistance")));
	}
}