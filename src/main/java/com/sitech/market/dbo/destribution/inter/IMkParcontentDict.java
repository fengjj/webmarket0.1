package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: IMkParcontentDict
 * @Description： 营销元素参数限定范围
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkParcontentDict {
	
	/**
	 * Create on 2015-4-2 
	 * @author: dongyh
	 * @Title: queryParcontent 
	 * @Description: 查询全部属性内容,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkParcontentDict(Map inMap);
}
