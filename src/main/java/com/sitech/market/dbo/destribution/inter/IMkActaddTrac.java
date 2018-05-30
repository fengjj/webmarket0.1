package com.sitech.market.dbo.destribution.inter;

import java.util.Map;

/**
 * 营销活动附加信息轨迹表
 * Create on 2015-4-21 
 * @author: wangdw
 * @Title: IMkActaddTrac 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkActaddTrac {

	/**
	 * 入活动附加信息轨迹表
	 * Create on 2015-4-21 
	 * @author: wangdw
	 * @Title: insertMkActaddTrac 
	 * @Description: 
	 * @param inparam 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkActaddTrac(Map inparam);
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
	public void updateMkActaddTracByTracId(Map inMap);
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
	public void updateMkActaddTracForBusiId(Map map);
}
