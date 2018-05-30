package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusichnrelTrac;
/**
 * 业务渠道关系轨迹
 * Create on 2015-5-26 
 * @author: wangdw
 * @Title: MkBusichnrelTrac 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkBusichnrelTrac extends DBMysqlClass implements IMkBusichnrelTrac {
	/**
	 * 批量插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: batchInsertMkBusichnrelTrac 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkBusichnrelTrac(List<Map> list) {
		baseDao.batchInsert("MkBusichnrelTrac.insertMkBusichnrelTrac", list);
	}
	/**
	 * 插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: insertMkBusichnrelTrac 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkBusichnrelTrac(Map map) {
		baseDao.insert("MkBusichnrelTrac.insertMkBusichnrelTrac", map);
	}
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusichnrelTracForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusichnrelTracForBusiId(Map map) {
		baseDao.update("MkBusichnrelTrac.updateMkBusichnrelTracForBusiId", map);
	}

}
