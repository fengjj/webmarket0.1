package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkResourcepriceInfo;

public class MkResourcepriceInfo extends DBMysqlClass implements
		IMkResourcepriceInfo {

	/** 
	 * Create on 2015-6-6 
	 * @author: songxj
	 * @Title: selectMkResourcepriceInfo 
	 * @Description: 查询资源价格表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public List selectMkResourcepriceInfo(Map map) {
		return baseDao.queryForList("MkResourcepriceInfo.selectMkResourcepriceInfo", map);
	}

	/** 
	 * Create on 2015-6-6 
	 * @author: songxj
	 * @Title: selectMkResourcepriceInfoById 
	 * @Description: 根据主键查询资源价格表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public Map selectMkResourcepriceInfoById(Map map) {
		return (Map) baseDao.queryForObject("MkResourcepriceInfo.selectMkResourcepriceInfoById", map);
	}

	/**
	 * 批量插入
	 * @Create on 2015-6-29 
	 * @author: wangdw
	 * @Title: insertBatchMkResourcepriceInfo 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public void insertBatchMkResourcepriceInfo(List<Map> list) {
		baseDao.batchInsert("MkResourcepriceInfo.insertMkResourcepriceInfo", list);
	}
	
	/**
	 * Create on 2015-9-11 
	 * @author: dongyh
	 * @Title: insertMkResourcepriceInfo 
	 * @Description: 插入
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkResourcepriceInfo(Map map){
		baseDao.insert("MkResourcepriceInfo.insertMkResourcepriceInfo", map);
	}
	
	/**
	 * Create on 2015-9-13 
	 * @author: dongyh
	 * @Title: selectMkResourcepriceInfoByTermi 
	 * @Description: 插查终端品牌和价钱
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkResourcepriceInfoByTermi(Map map){
		return (Map) baseDao.queryForObject("MkResourcepriceInfo.selectMkResourcepriceInfoByTermi", map);
	}
}
