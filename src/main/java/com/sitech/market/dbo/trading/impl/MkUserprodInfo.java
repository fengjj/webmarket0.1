package com.sitech.market.dbo.trading.impl;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkUserprodInfo;

/**
 * Create on 2015-6-3 
 * @author: gengws
 * @Title: IMkUserprodInfo 
 * @Description： 营销用户产品标签表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkUserprodInfo extends DBNosqlClass implements IMkUserprodInfo {
	
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
	@Override
	public JSONObject selectMkUserProdInfoByRowKye(String rowKey) {
		JSONObject json=null;
		try {
			json=cassandraDao.query_by_key("mk_userprod_info", rowKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

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
	@Override
	public void insertMkUserprodInfo(String rowkey, Map data) {
		try {
			cassandraDao.insertMultiCloumnByRowKey("mk_userprod_info", rowkey, data);
		} catch (Exception e) {
			throw new BusiException("-1", "插入mk_userprod_info表idNo不能为空.", "idNo为空" + e.getMessage());
		}
	}

}
