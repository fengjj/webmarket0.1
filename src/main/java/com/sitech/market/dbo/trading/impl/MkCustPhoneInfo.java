package com.sitech.market.dbo.trading.impl;

import com.alibaba.fastjson.JSONObject;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkCustPhoneInfo;

/**
 * Create on 2015-8-25 
 * @author: liuhaoa
 * @Title: MkCustPhoneInfo 
 * @Description： MkCustPhoneInfo表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkCustPhoneInfo extends DBNosqlClass implements IMkCustPhoneInfo {

	/**
	 * Create on 2015-8-25 
	 * @author: liuhaoa
	 * @Title: selectMkCustPhoneInfo 
	 * @Description: 根据phone_no查询selectMkCustPhoneInfo成本总表信息
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject selectMkCustPhoneInfo(String phone_no) {
		JSONObject json = null;
		try{
			json = cassandraDao.query_by_key("mk_custphone_info", phone_no);
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}

}
