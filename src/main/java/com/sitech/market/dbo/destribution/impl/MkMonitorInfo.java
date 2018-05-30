package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkMonitorInfo;
/**
 * 营销活动附加表
 * Create on 2015-4-21 
 * @author: wangdw
 * @Title: MkActaddInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkMonitorInfo extends DBMysqlClass implements IMkMonitorInfo {

	@Override
	public Object insertMkEventmonitorInfo(Map inMap){
		return baseDao.insert("MkEventmonitorInfo.insertMkEventmonitorInfo",inMap);
	}
	
	
	@Override
	public List<Map> queryMonitorGBetype(Map inMap) {
		return baseDao.queryForList("MkMonitorInfo.queryMonitorGBetype",inMap);
	}

	@Override
	public List<Map> queryMonitorGBtopic(Map inMap) {
		return baseDao.queryForList("MkMonitorInfo.queryMonitorGBtopic",inMap);
	}

	@Override
	public List<Map> queryMonitorGBeventId(Map inMap) {
		return baseDao.queryForList("MkMonitorInfo.queryMonitorGBeventId",inMap);
	}

	
}
