package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 业务内容关系dbo
 * Create on 2015-5-11 
 * @author: wangdw
 * @Title: IMkBusicontentRel 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusicontentRel {

	/**
	 * 查询业务内容信息
	 * Create on 2015-5-11 
	 * @author: wangdw
	 * @Title: selectBusiContentInfo 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkBusicontentRelByName(Map inMap);
	
	/**
	 * Create on 2015-5-26 
	 * @author: yugl
	 * @Title: selectMkBusicontentRel 
	 * @Description: 查询业务内容关系
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusicontentRel(Map inMap);
	
	
	
	public List selectMkBusicontentRelById(String  rel_id);
	
	/**
	 * Create on 2015-5-23 
	 * @author: yugl
	 * @Title: insertMkBusicontentRel 
	 * @Description: 保存业务内容关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkBusicontentRel(Map map);
	/**
	 * Create on 2015-5-23 
	 * @author: jiaxla
	 * @Title: insertMkBusicontentRel 
	 * @Description: 保存业务内容关系(终端捆绑)
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertBatchMkBusicontentRel(List<Map> list);
	
	/**
	 * Create on 2015-5-23 
	 * @author: qijh
	 * @Title: insertMkBusicontentRel 
	 * @Description: 删除业务内容关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusiContentRelByBusiId(Map busiMeanMap);
	
	/**
	 * Create on 2015-6-22 
	 * @author: jiaxla
	 * @Title: deleteMkBusicontentRelById 
	 * @Description: 删除内容与业务关系（单条）
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusicontentRelById(Map map);
	
	/**
	 * Create on 2015-5-23 
	 * @author: qijh
	 * @Title: copyMkBusiContentRel 
	 * @Description:复制业务内容关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void copyMkBusiContentRel(Map busiMeanMap);
	
	/**
	 * Create on 2015-5-23 
	 * @author: qijh
	 * @Title: selectBusicontentInfo 
	 * @Description:根据活动id查询关联的内容包id
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectBusicontentInfo(Map<Object, Object> inMap);
	
	/**
	 * Create on 2015-5-23 
	 * @author: qijh
	 * @Title: copyMkBusiContentRel 
	 * @Description:删除
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void delBusicontentRel(Map map);
	
	/**
	 * Create on 2015-8-05 
	 * @author: lixd_bj
	 * @Title: selectRuleInfoByConSerialId 
	 * @Description:根据内容流水获取规则信息
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectRuleInfoByConSerialId(Map map);
	
	/**
	 * Create on 2015-8-05 
	 * @author: lixd_bj
	 * @Title: selectActIdByConSerialId 
	 * @Description:根据内容流水获取活动ID
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectActIdByConSerialId(Map map);
	
	
}
