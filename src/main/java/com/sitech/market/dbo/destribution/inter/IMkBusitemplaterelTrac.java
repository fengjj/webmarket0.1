package com.sitech.market.dbo.destribution.inter;

import java.util.Map;

/**
 * Create on 2015-5-9
 * @author: dongyh
 * @Title: IMkBusitemplaterelTrac
 * @Description： 营销业务模板关联轨迹表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusitemplaterelTrac {

	/**
	 * Create on 2015-5-9 
	 * @author: dongyh
	 * @Title: insertMkBusitemplaterelTrac 
	 * @Description: 保存轨迹
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkBusitemplaterelTrac(Map map);
	/**
	 * 删除业务模板关系轨迹表
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: deleteMkBusitemplaterelTrac 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusitemplaterelTrac(Map map);
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusitemplaterelTracForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusitemplaterelTracForBusiId(Map map);
}
