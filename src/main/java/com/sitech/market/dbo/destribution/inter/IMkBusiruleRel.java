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
public interface IMkBusiruleRel{
	
	/**
	 * Create on 2015-5-11
	 * @author: yugl
	 * @Title: insertMkBusiruleRel
	 * @Description: 保存营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkBusiruleRel(Map map);
	
	/**
	 * 批量插入
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: batchInsertMkBusiruleRel 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkBusiruleRel(List<Map> list);
	
	/**
	 * 查询业务规则信息
	 * Create on 2015-5-12 
	 * @author: wangdw
	 * @Title: selectBusirule 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectBusiRule(Map map);
	
	/**
	 * Create on 2015-5-11
	 * @author: yugl
	 * @Title: insertMkBusiruleRel 
	 * @Description: 根据busiId删除营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusiruleRelByBusiId(Map map);
	
	/**
	 * 查询业务关系表
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: selectMkBusiruleRel 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusiruleRel(Map map) ;
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusiruleRelForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusiruleRelForBusiId(Map map);
	/**
	 * 根据busiId查询ruleInfo
	 * Create on 2015-6-3 
	 * @author: qijh
	 * @Title: selectActRuleInfo 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectBusiRuleInfo(Map map);
	
	/**
	 * Create on 2015-6-4
	 * @author: qijh
	 * @Title: deleteMkBusiruleRelByRelId 
	 * @Description: 根据relId删除营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusiruleRelByRelId(Map map);
	/**
	 * Create on 2015-6-5
	 * @author: xiongxin
	 * @Title: selectMkBusiRuleRelByMeansId 
	 * @Description: 根据meansId查询营销规则
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusiRuleRelByMeansId(Map inMap);
	
	public List selectMkBusiRuleRelByBusiId(Map inMap);
	
	/**
	 * Create on 2015-7-8 
	 * @author:zhaoyue
	 * @Title: selectMkBusiRuleByBusiIdOrBusiType 
	 * @Description: 根据busiId,busiType查询mk_busifule_rel
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusiRuleByBusiIdOrBusiType(Map inMap);
	
	/**
	 * Create on 2015-6-4
	 * @author: qijh
	 * @Title: copyMkBusiRuleRel 
	 * @Description: 复制营销规则与档次关系
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void copyMkBusiRuleRel(Map busiMeanMap);
	
	/**
	 * 根据busiId查询ruleInfo
	 * Create on 2015-6-3 
	 * @author: qijh
	 * @Title: selectActRuleInfo 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectActRuleInfo(Map map);
	
	/**
	 * Create on 2015-6-24
	 * @author: lixd_bj
	 * @Title: deleteRuleRelByBusiId 
	 * @Description: 根据busiId删除营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteRuleRelByBusiId(Map map);
	
	/**
	 * Create on 2015-6-24
	 * @author: lixd_bj
	 * @Title: deleteRuleRelBySerialId 
	 * @Description: 根据SerialId删除营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteRuleRelBySerialId(Map map);
	
	/**
	 * 根据关系表，查询ruleitem信息
	 * @Create on 2015-7-22 
	 * @author: wangdw
	 * @Title: selectBusiRuleItem 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public List<Map> selectBusiRuleItem(Map map);
	
	
	/**
	 * Create on 2015-7-16 
	 * @author:zhaoyue
	 * @Title: selectBusiIdList 
	 * @Description: 关联查询全部的busiIdList
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectBusiIdList(Map map);
	
}
