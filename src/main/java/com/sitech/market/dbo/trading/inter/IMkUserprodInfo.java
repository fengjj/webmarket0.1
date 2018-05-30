package com.sitech.market.dbo.trading.inter;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
/**
 * Create on 2015-6-3 
 * @author: gengws
 * @Title: IMkUserprodInfo 
 * @Description： 营销用户产品标签表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkUserprodInfo {
	
	/**
	 * Create on 2015-6-3 
	 * @author: gengws
	 * @Title: selectMkUserProdInfoByRowKye 
	 * @Description: 根据主键(idNo)查询营销用户产品标签表
	 * @param rowKey
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject selectMkUserProdInfoByRowKye(String rowKey);
	
	/** 
	 * Create on 2015-7-16 
	 * @author: songxj
	 * @Title: insertMkUserprodInfo 
	 * @Description: 根据主键(idNo)插入营销用户产品标签表
	 * @param rowkey
	 * @param data 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public void insertMkUserprodInfo(String rowkey, Map data);
}
