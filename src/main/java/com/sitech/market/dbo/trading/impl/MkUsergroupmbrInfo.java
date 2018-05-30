package com.sitech.market.dbo.trading.impl;

import com.alibaba.fastjson.JSONObject;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkUsergroupmbrInfo;

public class MkUsergroupmbrInfo extends DBNosqlClass implements IMkUsergroupmbrInfo {
	/**
	 * Create on 2015-7-22 
	 * @author: zhaoyue
	 * @Title: selectMkUsergroupInfoByRowKye 
	 * @Description:查询mk_useroupmbr_info数据 
	 * @param rowKey
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject selectMkUsergroupInfoByRowKye(String rowKey) {
		JSONObject json=null;
		try {
			json=cassandraDao.query_by_key("mk_usergroupmbr_info", rowKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
