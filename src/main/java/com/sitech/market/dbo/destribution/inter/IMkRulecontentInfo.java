package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;
/**
 * Create on 2015-5-11
 * @author: yugl
 * @Title: IMkBusiruleRel 
 * @Description： 业务区域表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkRulecontentInfo{
	
	/**
	 * Create on 2015-5-11 
	 * @author: yugl
	 * @Title: selectMkRulecontentInfo 
	 * @Description: 查询规则内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkRulecontentInfo(Map map);
	
	/**
	 * Create on 2015-5-11 
	 * @author: yugl
	 * @Title: selectMkRulecontentInfo 
	 * @Description: 关联mk_rulecode_dict查询规则内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectRulecontentJoinCodeName(Map map);

    
	/**
	 * Create on 2015-6-6 
	 * @author: xiongxin
	 * @Title: selectMkRulecontentByItemId 
	 * @Description: 通过itemId来查询规则内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectRuleContentByItemId(Map inMap);
	public List queryItemIdBySerialId(Map inMap);

	
	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: batchInsertMkRulecontentInfo 
	 * @Description: 批量保存规则内容
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkRulecontentInfo(List list);
	
	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: deleteMkRulecontentInfoByItemId 
	 * @Description: 根据itemId删除规则明细内容
	 * @param itemId 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkRulecontentInfoByItemId(String itemId);
	/**
	 * Create on 2015-6-18 
	 * @author: lixd_bj
	 * @Title: deleteMkRulecontentInfoByItemIdList 
	 * @Description: 根据itemIdList删除规则明细内容
	 * @param itemId 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkRulecontentInfoByItemIdList(Map map);
	/**
	 * Create on 2015-8-11
	 * @author: wangpei
	 * @Title: copyMkRulecontentInfo 
	 * @Description: 批量复制规则内容
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void copyMkRulecontentInfo(Map map) ;
}
