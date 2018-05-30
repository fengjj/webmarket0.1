package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-5-11
 * @author: yugl
 * @Title: IMkBusiruleRel 
 * @Description： 业务区域表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkRuleInfo{
	
	/**
	 * Create on 2015-5-12 
	 * @author: yugl
	 * @Title: selectMkRuleInfo 
	 * @Description: 查询规则表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkRuleInfo(Map map);
	
	/**
	 * Create on 2015-6-19 
	 * @author: yugl
	 * @Title: selectMkRuleInfoById 
	 * @Description: 根据主键查询
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkRuleInfoById(String serialId);
	
	/**
	 * Create on 2015-5-19 
	 * @author: yugl
	 * @Title: selectRuleByRuleClass 
	 * @Description: 关联规则明细表查询规则
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectRuleByRuleClass(Map map);
	
	/**
	 * Create on 2015-5-22 
	 * @author: lixd_bj
	 * @Title: queryRuleInfoByBusiId 
	 * @Description: 根据活动ID查询规则信息
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryRuleInfoByBusiId(Map map);
	
	/**
	 * Create on 2015-5-22 
	 * @author: qijh
	 * @Title: queryRuleInfoByBusiId 
	 * @Description: 删除档次规则关系
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusiRuleRelByBusiId(Map map);
	

	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: insertMkRuleInfo 
	 * @Description: 新增规则
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkRuleInfo(Map map);
	
	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: updateMkRuleInfo 
	 * @Description: 修改规则
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkRuleInfo(Map map);
	
	/**
	 * Create on 2015-6-19 
	 * @author: lixd_bj
	 * @Title: deleteMkRuleInfoBySerialIdList 
	 * @Description: 根据serialIdList删除规则信息
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkRuleInfoBySerialIdList(Map map);
	
	/**
	 * Create on 2015-6-19 
	 * @author: lixd_bj
	 * @Title: selectRuleInfoByRuleType 
	 * @Description: 根据ruleType查询规则列表
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectRuleInfoByRuleType(Map map);

	/**
	 * Create on 2015-7-25 
	 * @author: nidw
	 * @Title: delRuleInfoById 
	 * @Description: 根据serialId删除规则
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void delRuleInfoById(Map map);

	/**
	 * Create on 2015-8-11
	 * @author: wangpei
	 * @Title: copyRuleInfo 
	 * @Description: 根据serialId复制规则
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void copyRuleInfo(Map map);
	

	/**
	 * Create on 2015-8-3 
	 * @author: nidw
	 * @Title: queryRuleInfoAndRuleTypeNameByBusiId 
	 * @Description: 查询规则信息
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryRuleInfoAndRuleTypeNameByBusiId(Map map);
	
}
