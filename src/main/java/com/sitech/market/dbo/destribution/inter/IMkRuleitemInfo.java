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
public interface IMkRuleitemInfo{
	
	/**
	 * Create on 2015-5-11 
	 * @author: yugl
	 * @Title: selectMkRuleitemInfo 
	 * @Description: 查询规则明细
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkRuleitemInfo(Map map);
	
	/**
	 * Create on 2015-6-19 
	 * @author: yugl
	 * @Title: selectMkRuleitemInfoById 
	 * @Description: 根据主键查询
	 * @param itemId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkRuleitemInfoById(String itemId);
	
	/**
	 * Create on 2015-5-22 
	 * @author: lixd_bj
	 * @Title: selectRuleItemContentInfoBySerialId 
	 * @Description: 根据规则序列号查询奖项等明细信息
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectRuleItemContentInfoBySerialId(Map map);
	
	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: insertMkRuleitemInfo 
	 * @Description: 新增规则明细
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkRuleitemInfo(Map map);
	
	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: updateMkRuleitemInfo 
	 * @Description: 修改规则明细
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkRuleitemInfo(Map map);
	
	/**
	 * Create on 2015-6-17 
	 * @author: yugl
	 * @Title: selectMkRuleitemInfoForCodeName 
	 * @Description: 关联codename表查询活动规则明细
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkRuleitemInfoForCodeName(Map map);
	
	/**
	 * Create on 2015-6-17 
	 * @author: yugl
	 * @Title: deleteMkRuleitemInfoById 
	 * @Description: 根据主键删除
	 * @param itemId 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkRuleitemInfoById(String itemId);
	
	/**
	 * Create on 2015-6-19 
	 * @author: lixd_bj
	 * @Title: deleteMkRuleitemInfoByRuleSerialId 
	 * @Description: 根据ruleSerialIdList删除规则明细
	 * @param itemId 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkRuleitemInfoByRuleSerialId(Map map);

	public List selectMkRuleitemInfoForRuleType(Map map);
	/**
	 * Create on 2015-8-13
	 * @author: zhangchen
	 * @Title: selectRuleItemInfoBySerialId 
	 * @Description: 根据规则序列号查询奖项
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectRuleItemInfoBySerialId(Map map);
	
	/**
	 * Create on 2015-8-11 
	 * @author: wangpei
	 * @Title: copyMkRuleitemInfoByItemId
	 * @Description: 根据itemId复制规则明细
	 * @param itemId 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void copyMkRuleitemInfoByItemId(Map map);
}
