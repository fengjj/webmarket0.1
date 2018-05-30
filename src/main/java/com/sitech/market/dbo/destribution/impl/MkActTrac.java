package com.sitech.market.dbo.destribution.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkActTrac;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkActTrac
* @Description： 营销活动日志
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkActTrac extends DBMysqlClass implements IMkActTrac {

	/**
	 * 入营销活动轨迹表
	 * Create on 2015-4-21 
	 * @author: wangdw
	 * @Title: insertMkActTrac 
	 * @Description: 
	 * @param inparam 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkActTrac(Map inparam) {
		baseDao.insert("MkActTrac.insertMkActTrac",inparam);
	}

	/**
	 * Create on 2015-5-13 
	 * @author: gengws
	 * @Title: selectMkActTrac 
	 * @Description: 查询营销活动轨迹表（所有条件）
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkActTrac(Map inMap) {
		List list=baseDao.queryForList("MkActTrac.selectMkActTrac", inMap);	
		return list;
	}

	/**
	 * Create on 2015-5-14 
	 * @author: gengws
	 * @Title: batchUpdateMkActTrac 
	 * @Description: 批量修改轨迹表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchUpdateMkActTrac(List list) {
		baseDao.batchUpdate("MkActTrac.updateMkActTracByTracId", list);
		
	}
	/**
	 * 根据活动id，查询最大uniqueBusiId
	 * Create on May 21, 2015 
	 * @author: wangdw
	 * @Title: selectMaxUniqueByActId 
	 * @Description: 
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public String selectMaxUniqueByActId(String actId) {
		return (String)baseDao.queryForObject("MkActTrac.selectMaxUniqueByActId", actId);
	}
	/**
	 * 根据活动id，查询最小uniqueBusiId
	 * Create on May 21, 2015 
	 * @author: wangdw
	 * @Title: selectMinUniqueByActId 
	 * @Description: 
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public String selectMinUniqueByActId(String actId) {
		return (String)baseDao.queryForObject("MkActTrac.selectMinUniqueByActId", actId);
	}
	/**
	 * 根据tracId，更新记录
	 * Create on May 21, 2015 
	 * @author: wangdw
	 * @Title: updateMkActTracByTracId 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkActTracByTracId(Map inMap) {
		baseDao.update("MkActTrac.updateMkActTracByTracId", inMap);
	}
	
	/**
	 * 查询活动轨迹，根据update_time降序排列
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: selectMkActTracOrderByUpdateTime 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkActTracOrderByUpdateTime(Map inMap) {
		List list=baseDao.queryForList("MkActTrac.selectMkActTracOrderByUpdateTime", inMap);	
		return list;
	}
}
