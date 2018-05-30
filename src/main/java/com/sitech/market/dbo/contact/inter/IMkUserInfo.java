package com.sitech.market.dbo.contact.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;



public interface IMkUserInfo {
	
	/**
	 * 根据idNo查询用户信息
	 * @param idNo
	 * @return
	 */
	public String getMasterSvcIdByIdNo(String idNo);
	
	/**
	 * 根据idNo查询用户归属groupId
	 * @param idNo
	 * @return
	 */
	public String geGroupIdByIdNo(String idNo);
	
	
	/**
	 * Create on 2015-7-8 
	 * @author:zhaoyue
	 * @Title: getUserInfo 
	 * @Description:根据idNo查询用户信息 
	 * @param idNo
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject getUserInfo(Map map);
	
	/**
	 * Create on 2015-4-18 
	 * @author: gengws
	 * @Title: queryMkUserInfo 
	 * @Description: 根据idNo查询mk_user_info
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryMkUserInfo(List list);
	
	/** 
	 * Create on 2015-6-23 
	 * @author: songxj
	 * @Title: getMkUserInfo 
	 * @Description: 根据idNo查询mk_user_info
	 * @param keys
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject getMkUserInfo(String[] idNos);
	
	
	/** 
	 * Create on 2015-7-14 
	 * @author: songxj
	 * @Title: insertMkUserInfo 
	 * @Description: 插入mk_user_info
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public void insertMkUserInfo(String idNo, Map data);
	
	/** 
	 * Create on 2015-8-27 
	 * @author: tangll
	 * @Title: deleteMkUserInfo 
	 * @Description: 删除mk_user_info
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public void deleteMkUserInfo(String idNo);
	
	/**
	 * 根据idNo集合，查询用户信息
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: queryUsersByIdNos 
	 * @Description: 
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public List<Map> queryUsersByIdNos(List<String> list) ;
}
