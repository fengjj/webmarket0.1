package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.alibaba.fastjson.JSONArray;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class CompSyncActInfoInDTO extends InDTO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,type="String",len="40",desc="活动id",memo="略")
	private String actId;
	@ParamDesc(path="USER_ID",cons=ConsType.CT001,type="String",len="20",desc="用户标识",memo="")
	private String userId;
	@ParamDesc(path="QUERY_TYPE",cons=ConsType.CT001,type="Integer",len="10",desc="触发事件",memo="" )
	private Integer queryType;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,type="String",len="10",desc="省份编码",memo="" )
	private String provinceGroup;
	
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getQueryType() {
		return queryType;
	}
	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}
	public String getProvinceGroup() {
		return provinceGroup;
	}
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	@Override
	public void decode(MBean arg0) {
		// TODO Auto-generated method stub
		this.actId = arg0.getStr(getPathByProperName("actId"));
		this.userId = arg0.getStr(getPathByProperName("userId"));
		this.queryType = arg0.getInt(getPathByProperName("queryType"));
		this.provinceGroup = arg0.getStr(getPathByProperName("provinceGroup"));
	}
	
	
}
