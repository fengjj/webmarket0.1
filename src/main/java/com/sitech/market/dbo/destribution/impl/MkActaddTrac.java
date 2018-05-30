package com.sitech.market.dbo.destribution.impl;

import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkActaddTrac;
/**
 * 营销活动附加信息轨迹表
 * Create on 2015-4-21 
 * @author: wangdw
 * @Title: MkActaddTrac 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkActaddTrac extends DBMysqlClass implements IMkActaddTrac {

	/**
	 * 营销活动附加信息轨迹表
	 * Create on 2015-4-21 
	 * @author: wangdw
	 * @Title: insertMkActaddTrac 
	 * @Description: 
	 * @param inparam 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkActaddTrac(Map inparam) {
		baseDao.insert("MkActaddTrac.insertMkActaddTrac",inparam);
	}

	/**
	 * 更新活动附加信息表
	 * Create on May 21, 2015 
	 * @author: wangdw
	 * @Title: updateMkActaddTracByTracId 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkActaddTracByTracId(Map inMap) {
		baseDao.queryForObject("MkActaddTrac.updateMkActaddTracByTracId",inMap);
	}
	
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkActaddTracForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkActaddTracForBusiId(Map map) {
		baseDao.update("MkActaddTrac.updateMkActaddTracForBusiId", map);
	}
}
