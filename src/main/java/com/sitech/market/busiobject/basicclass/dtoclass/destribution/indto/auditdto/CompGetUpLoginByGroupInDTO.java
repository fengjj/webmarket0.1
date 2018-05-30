package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
/**
 * 
 * Create on 2015-4-1 
 * @author: tianyy_bj
 * @Title: CompGetUpLoginByGroupInDTO
 * @Description：根据当前组织机构查询上级工号服务入参dto
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public class CompGetUpLoginByGroupInDTO extends InDTO {

	private static final long serialVersionUID = 1L;

	@ParamDesc(path="provinceGroup",cons=ConsType.CT001,len="8",desc="省份代码",type="String",memo="略")
	private String provinceGroup;
	
	@ParamDesc(path="operNo",cons=ConsType.CT001,len="8",desc="登陆工号",type="String",memo="略")
	private String operNo;
	
	@ParamDesc(path="groupId",cons=ConsType.CT001,len="8",desc="组织机构id",type="String",memo="略")
	private String groupId;
	@Override
	public void decode(MBean arg0) {
		this.operNo = arg0.getStr(getPathByProperName("operNo"));
		this.groupId = arg0.getStr(getPathByProperName("groupId"));
		this.provinceGroup = arg0.getStr(getPathByProperName("provinceGroup"));
	}
	public String getGroupId() {
		return groupId;
	}
	public String getOperNo() {
		return operNo;
	}
	public String getProvinceGroup() {
		return provinceGroup;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

}
