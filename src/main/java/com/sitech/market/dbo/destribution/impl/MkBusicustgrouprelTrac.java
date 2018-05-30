package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusicustgrouprelTrac;
/**
 * 业务客户群轨迹
 * Create on 2015-5-26 
 * @author: wangdw
 * @Title: MkBusicustgrouprelTrac 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkBusicustgrouprelTrac extends DBMysqlClass implements
		IMkBusicustgrouprelTrac {

	/**
	 * 批量插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: batchInsertMkBusicustgrouprelTrac 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkBusicustgrouprelTrac(List<Map> list) {
		baseDao.batchInsert("MkBusicustgrouprelTrac.insertMkBusicustgrouprelTrac", list);
	}
	/**
	 * 插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: insertMkBusicustgrouprelTrac 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkBusicustgrouprelTrac(Map<Object, Object> inMap) {
		baseDao.insert("MkBusicustgrouprelTrac.insertMkBusicustgrouprelTrac", inMap);
	}
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusicustgrouprelTracForBusiId 
	 * @Description: 
	 * @param map (newBusiId,oldBusiId)
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusicustgrouprelTracForBusiId(Map map) {
		baseDao.update("MkBusicustgrouprelTrac.updateMkBusicustgrouprelTracForBusiId", map);
	}

}
