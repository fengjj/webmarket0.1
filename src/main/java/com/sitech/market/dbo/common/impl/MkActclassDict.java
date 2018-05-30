package com.sitech.market.dbo.common.impl;


import java.util.List;
import java.util.Map;

import com.sitech.cache.Cache;
import com.sitech.cache.CacheHelper;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkActclassDict;

public class MkActclassDict extends DBMysqlClass implements IMkActclassDict {
    private Cache cache = CacheHelper.getInstance();
	/**
	 * 查询ActClassDict信息
	 * @param paramMap
	 * @return
	 * lixd_bj
	 * 2015-01-18
	 * 
	 */
	@Override
	public List queryActClassDict(Map paramMap) {
		List list = baseDao.queryForList("MkActclassDict.selectMkActclassDict", paramMap);
		return list;
	}
	/**
	 * 根据actClass查询营销活动大类、小类信息
	 * @param paramMap
	 * @return
	 * lixd_bj
	 * 2015-01-18
	 * 
	 */
	@Override
	public List queryActClassInfo(Map paramMap) {
		List list = baseDao.queryForList("MkActclassDict.selectActClassInfo", paramMap);
		return list;
	}
	
}
