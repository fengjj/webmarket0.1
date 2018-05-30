package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusirulerelTrac;
/**
 * 业务规则关系轨迹
 * Create on 2015-5-26 
 * @author: wangdw
 * @Title: MkBusirulerelTrac 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkBusirulerelTrac extends DBMysqlClass implements
		IMkBusirulerelTrac {
	/**
	 * 批量插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: batchInsertMkBusirulerelTrac 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkBusirulerelTrac(List<Map> list) {
		baseDao.batchInsert("MkBusirulerelTrac.insertMkBusirulerelTrac", list);
	}
	/**
	 * 删除
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: deleteMkBusirulerelTrac 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusirulerelTrac(Map map) {
		baseDao.delete("MkBusirulerelTrac.deleteMkBusirulerelTrac", map);
	}
	/**
	 * 插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: insertMkBusirulerelTrac 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkBusirulerelTrac(Map map) {
		baseDao.insert("MkBusirulerelTrac.insertMkBusirulerelTrac", map);
	}
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusirulerelTracForBusiId 
	 * @Description: 
	 * @param map (newBusiId,oldBusiId)
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusirulerelTracForBusiId(Map map) {
		baseDao.update("MkBusirulerelTrac.updateMkBusirulerelTracForBusiId", map);
	}

}
