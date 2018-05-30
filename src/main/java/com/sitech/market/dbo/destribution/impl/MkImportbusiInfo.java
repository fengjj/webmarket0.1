package com.sitech.market.dbo.destribution.impl;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.destribution.inter.IMkImportbusiInfo;

public class MkImportbusiInfo extends DBNosqlClass implements IMkImportbusiInfo {

	/** 
	 * Create on 2015-6-24 
	 * @author: songxj
	 * @Title: insertMkImportbusiInfo 
	 * @Description: 根据rowKey插入mk_importbusi_info表
	 * @param rowKey
	 * @param data 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public void insertMkImportbusiInfo(String rowKey, Map data) {
		try {
			cassandraDao.insertMultiCloumnByRowKey("mk_importbusi_info", rowKey, data);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1", "插入mk_importbusi_info失败!!!!", "请到后台看看吧!!!");
		}
	}

	/** 
	 * Create on 2015-7-3 
	 * @author: songxj
	 * @Title: getMkImportbusiInfo 
	 * @Description: 根据rowkey查询mk_importbusi_info
	 * @param rowKey
	 * @param data 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public JSONObject getMkImportbusiInfo(String rowKey) {
		JSONObject json = new JSONObject();
		try {
			json = cassandraDao.query_by_key("mk_importbusi_info", rowKey);
			if (!cassandraDao.checkJsonForOneKey(json, rowKey)) {
				json = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1", "查询mk_importbusi_info失败!!!!", "请到后台看看吧!!!");
		}
		return json;
	}
}
