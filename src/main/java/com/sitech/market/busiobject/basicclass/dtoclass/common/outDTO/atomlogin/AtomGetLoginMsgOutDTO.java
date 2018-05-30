package com.sitech.market.busiobject.basicclass.dtoclass.common.outDTO.atomlogin;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
/**
 * Create on 2015-5-30 
 * @author: gengws
 * @Title: AtomGetLoginMsgOutDTO 
 * @Description： 根据工号查询数据OutDTO
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetLoginMsgOutDTO extends StandardOutDTO{
	
	@ParamDesc(path="GROUP_ID",cons=ConsType.CT001,type="string",len="10",desc="组织机构代码",memo="略")
	private String groupId;
	@ParamDesc(path="REGION_ID",cons=ConsType.CT001,type="string",len="10",desc="略",memo="略")
	private String regionId;
	
	@Override
	public MBean encode() {
		
		MBean bean=new MBean();
		
		bean.addBody("GROUP_ID", groupId);
		bean.addBody("REGION_ID", regionId);
		return bean;
	}

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	

}
