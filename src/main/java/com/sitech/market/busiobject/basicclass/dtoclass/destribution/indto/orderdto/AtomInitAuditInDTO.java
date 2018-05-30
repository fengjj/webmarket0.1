package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.orderdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomInitAuditInDTO
* @Description： 自动打印入参参数
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomInitAuditInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="orderId",cons=ConsType.CT001,type="string",len="22",desc="工单ID",memo="略")
	private String orderId;
	@ParamDesc(path="disFlag",cons=ConsType.CT001,type="string",len="2",desc="操作标识",memo="0-新增，完全权限；1审批中，所有不可增删；2执行中（规则修改）")
	private String disFlag;
	@ParamDesc(path="mk_isUnique",cons=ConsType.CT001,type="string",len="2",desc="是否使用唯一编码",memo="0:不使用,1:使用")
	private String mkIsUnique;
	@ParamDesc(path="provinceGroup",cons=ConsType.CT001,type="string",len="20",desc="省份标识",memo="略")
	private String provinceGroup;
	@ParamDesc(path="groupId",cons=ConsType.CT001,type="string",len="20",desc="组织ID",memo="略")
	private String groupId;
	
	public void decode(MBean bean) {
		setOrderId(bean.getStr(getPathByProperName("orderId")));
		setDisFlag(bean.getStr(getPathByProperName("disFlag")));
		setMkIsUnique(bean.getStr(getPathByProperName("mkIsUnique")));
		setMkIsUnique(bean.getStr(getPathByProperName("provinceGroup")));
		setMkIsUnique(bean.getStr(getPathByProperName("groupId")));
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDisFlag() {
		return disFlag;
	}

	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}

	public String getMkIsUnique() {
		return mkIsUnique;
	}

	public void setMkIsUnique(String mkIsUnique) {
		this.mkIsUnique = mkIsUnique;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
