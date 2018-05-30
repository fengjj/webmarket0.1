package com.sitech.market.dbo.trading.impl;

import com.alibaba.fastjson.JSONObject;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkUseraccountoutInfo;

public class MkUseraccountoutInfo extends DBNosqlClass implements IMkUseraccountoutInfo {

	@Override
	public JSONObject selectMkUseraccountoutInfoByRowKye(String rowKey) {
		JSONObject json=null;
		try {
			json=cassandraDao.query_by_key("mk_useraccountout_info", rowKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@Override
	public String selectMkUseraccountoutInfo(String rowKey,String column){
		String retStr=null;
		try {
			retStr=cassandraDao.getSingleByKeyAndColumnName("mk_useraccountout_info", rowKey, column);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retStr;
	}
}
