package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-5-7
 * @author: dongyh
 * @Title: IMkTemplateInfo
 * @Description： 营销模板表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkTemplateInfo {
	
	/**
	 * Create on 2015-5-7 
	 * @author: dongyh
	 * @Title: selectMkTemplateInfo 
	 * @Description: 查询营销模板
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkTemplateInfo(Map inMap);
	
	/**
	 * Create on 2015-5-22 
	 * @author: lixd_bj
	 * @Title: selectMkTemplateInfoByBusiId 
	 * @Description: 根据活动ID查询营销模板信息
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkTemplateInfoByBusiId(Map inMap);
}
