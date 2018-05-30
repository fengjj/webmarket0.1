package com.sitech.market.busiobject.basicclass.dtoclass.destribution.outdto.custgroupdto;


import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
import com.sitech.util.MBeanUtil;

public class AtomInitCondOutDTO extends StandardOutDTO {

	private Map  actMap;
	private Map  actCondMap;
	private List<Map>  busiCustGroupRelList;
	private List<Map>  actTypelist;
	@Override
	public MBean encode() {
		MBean resultBean = new MBean();
		resultBean.setBody("actMap",getActMap());
		resultBean.setBody("actCondMap",getActCondMap());
		resultBean.setBody("busiCustGroupRelList",getBusiCustGroupRelList());
		resultBean.setBody("actTypelist",getActTypelist());
		return resultBean;
	}
	public Map getActMap() {
		return actMap;
	}
	public void setActMap(Map actMap) {
		this.actMap = actMap;
	}
	public Map getActCondMap() {
		return actCondMap;
	}
	public void setActCondMap(Map actCondMap) {
		this.actCondMap = actCondMap;
	}
	public List<Map> getBusiCustGroupRelList() {
		return busiCustGroupRelList;
	}
	public void setBusiCustGroupRelList(List<Map> busiCustGroupRelList) {
		this.busiCustGroupRelList = busiCustGroupRelList;
	}
	public List<Map> getActTypelist() {
		return actTypelist;
	}
	public void setActTypelist(List<Map> actTypelist) {
		this.actTypelist = actTypelist;
	}
	
	

}
