package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: IMkElementparDict
 * @Description： 营销元素参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkElementparDict {
	
	/**
	 * Create on 2015-4-21 
	 * @author: dongyh
	 * @Title: selectMkElementparDict 
	 * @Description: 根据元素查询属性,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkElementparDictForSubId(Map inMap);
	/**
	 * Create on 2015-6-3
	 * @author: qijh
	 * @Title: selectMkElementparDict 
	 * @Description: 根据元素查询规则属性,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkElementparDictForItemId(Map inMap);
	/**
	 * Create on 2015-6-3
	 * @author: qijh
	 * @Title: selectMkElementparDict 
	 * @Description: 根据元素查询内容属性,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:	
	 */
	public List<Map> selectMkElementparDictForSubContentId(Map inMap);
	/**
	 * Create on 2015-6-21
	 * @author: nidw
	 * @Title: selectMkElementparDictSyncForItemId 
	 * @Description: 查询规则详细内容
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkElementparDictSyncForItemId(Map inMap);
}
