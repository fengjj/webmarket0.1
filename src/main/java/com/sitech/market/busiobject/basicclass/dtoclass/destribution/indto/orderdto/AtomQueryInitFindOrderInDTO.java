package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.orderdto;

import javax.ejb.Local;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomQueryInitFindOrderInDTO extends InDTO {
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="actId",cons=ConsType.CT001,len="20",type="String",desc="活动id",memo="")
	private String  actId;
	@ParamDesc(path="orderId",cons=ConsType.CT001,len="20",type="String",desc="工单id",memo="")
	private String orderId;
	@ParamDesc(path="opr",cons=ConsType.CT000,len="20",type="String",desc="操作类型",memo="")
	private String opr;
	@ParamDesc(path="provinceGroup",cons=ConsType.CT001,len="20",type="String",desc="省份编码",memo="")
	private String provinceGroup;
	@Override
	public void decode(MBean arg0) {
		this.actId = arg0.getStr(getPathByProperName("actId"));
		this.opr = arg0.getStr(getPathByProperName("opr"));
		this.orderId = arg0.getStr(getPathByProperName("orderId"));
		this.provinceGroup = arg0.getStr(getPathByProperName("provinceGroup"));
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOpr() {
		return opr;
	}
	public void setOpr(String opr) {
		this.opr = opr;
	}
	public String getProvinceGroup() {
		return provinceGroup;
	}
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

}
