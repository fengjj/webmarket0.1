package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;
/**
 * 用户信息
 * @Create on 2015-7-22 
 * @author: wangdw
 * @Title: UserInfo 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public class UserInfo implements Encodeable ,Decodeable{
	
	@ParamDesc(path="CUST_INFO_LIST",cons=ConsType.STAR,len="100",desc="客户信息",type="Compx",memo="略")
	private List<Map> custInfoList;
	@ParamDesc(path="USER_INFO_LIST",cons=ConsType.STAR,len="100",desc="用户信息",type="Compx",memo="略")
	private List<Map> userInfoList;
	@ParamDesc(path="USER_PROD_LIST",cons=ConsType.STAR,len="100",desc="资费信息",type="Compx",memo="略")
	private List<Map> userProdList;
	@Override
	public void decode(Map in) {
		this.custInfoList = (List<Map>)in.get("CUST_INFO_LIST");
		this.userInfoList = (List<Map>)in.get("USER_INFO_LIST");
		this.userProdList = (List<Map>)in.get("USER_PROD_LIST");
	}
	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> userInfo = new HashMap();
		userInfo.put("CUST_INFO_LIST", custInfoList);
		userInfo.put("USER_INFO_LIST", userInfoList);
		userInfo.put("USER_PROD_LIST", userProdList);
		return userInfo;
	}

	public List getCustInfoList() {
		return custInfoList;
	}

	public void setCustInfoList(List custInfoList) {
		this.custInfoList = custInfoList;
	}

	public List getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List userInfoList) {
		this.userInfoList = userInfoList;
	}

	public List getUserProdList() {
		return userProdList;
	}

	public void setUserProdList(List userProdList) {
		this.userProdList = userProdList;
	}

	
}
