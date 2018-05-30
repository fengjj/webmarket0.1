package com.sitech.market.dbo.destribution.inter;

import java.util.Map;

/**
 * 营销活动附加表
 * Create on 2015-4-21 
 * @author: wangdw
 * @Title: IMkActaddInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkActaddInfo {

	/**
	 * 入活动附加表信息
	 * Create on 2015-4-21 
	 * @author: wangdw
	 * @Title: insertMkActaddInfo 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkActaddInfo(Map inparam);
	
	/**
	 * Create on 2015-4-24 
	 * @author: yugl
	 * @Title: selectMkActaddInfoByActId 
	 * @Description: 根据活动id查询活动附加表
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkActaddInfoByActId(String actId);
	
	/**
	 * 更新活动附加信息表
	 * Create on May 21, 2015 
	 * @author: wangdw
	 * @Title: updateMkActaddInfoByActId 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkActaddInfoByActId(Map inMap);
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkActaddInfo 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkActaddInfoForBusiId(Map map);
	
	/**
	 * 删除
	 * Create on 2015-5-28 
	 * @author: wangdw
	 * @Title: deleteMkActaddInfo 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkActaddInfo(Map map);
}
