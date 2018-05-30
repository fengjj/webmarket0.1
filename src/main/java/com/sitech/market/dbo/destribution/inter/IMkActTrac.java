package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkActTrac
* @Description： 营销活动日志
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkActTrac {

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
	public void insertMkActTrac(Map inparam); 
	
	/**
	 * Create on 2015-5-13 
	 * @author: gengws
	 * @Title: selectMkActTrac 
	 * @Description: 查询营销活动轨迹表
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkActTrac(Map inMap);
	
	/**
	 * Create on 2015-5-14 
	 * @author: gengws
	 * @Title: batchUpdateMkActTrac 
	 * @Description: 批量修改轨迹表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchUpdateMkActTrac(List list);
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
	public String selectMaxUniqueByActId(String actId);
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
	public String selectMinUniqueByActId(String actId);
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
	public void updateMkActTracByTracId(Map inMap);
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
	public List selectMkActTracOrderByUpdateTime(Map inMap);
	
}
