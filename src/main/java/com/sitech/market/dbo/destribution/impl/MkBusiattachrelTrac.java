package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusiattachrelTrac;

/**
 * Create on 2015-5-14
 * @author: dongyh
 * @Title: IMkBusiattachrelTrac
 * @Description： 附件与业务关系轨迹表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkBusiattachrelTrac extends DBMysqlClass implements
		IMkBusiattachrelTrac {

	/**
	 * Create on 2015-5-14 
	 * @author: dongyh
	 * @Title: saveMkBusiattachrelTrac 
	 * @Description: 保存附件与业务关系轨迹
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void saveMkBusiattachrelTrac(Map map) {
		baseDao.insert("MkBusiattachrelTrac.insertMkBusiattachrelTrac", map);
	}
	/**
	 * 批量插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: batchInsertMkBusiattachrelTrac 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkBusiattachrelTrac(List<Map> list) {
		baseDao.batchInsert("MkBusiattachrelTrac.insertMkBusiattachrelTrac", list);
	}
	
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusiattachrelTracForBusiId 
	 * @Description: 
	 * @param map (oldBusiId,newBusiId)
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusiattachrelTracForBusiId(Map map) {
		baseDao.update("MkBusiattachrelTrac.updateMkBusiattachrelTracForBusiId", map);
	}
}
