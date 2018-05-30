package com.sitech.market.dbo.destribution.impl;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.destribution.inter.IMkUserLabelInfo;

public class MkUserLabelInfo extends DBNosqlClass implements IMkUserLabelInfo {
	/**
	 * 根据ID_NO查询用户标签和经分活动列表数据
	 * add by 20150810
	 */
	@Override
	public JSONObject queryUserLabelByIdNo(String rowKey) {
		JSONObject json = new JSONObject();
		try {
			json = cassandraDao.query_by_key("mk_userlabel_info", rowKey);
			System.out.println("=========================queryUserLabelByIdNo="+json);
			if (!cassandraDao.checkJsonForOneKey(json, rowKey)) {
				json = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1", "查询mk_importbusi_info失败!!!!", "请检查!");
		}
		return json;
	}
}
