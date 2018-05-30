package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkCostcontrolInfo
* @Description： 营销成本
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkCostcontrolInfo {
	
	/**
	 * Create on 2015-7-17 
	 * @author: liuhaoa
	 * @Title: selectMkCostcontrolInfo 
	 * @Description: 查询营销成本管控表
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkCostcontrolInfo(Map inMap);
	
	/**
	 * Create on 2015-7-17 
	 * @author: liuhaoa
	 * @Title: selectMkCostcontrolInfo 
	 * @Description: 更新营销成本管控表
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkCostcontrolInfo(Map inMap);
}
