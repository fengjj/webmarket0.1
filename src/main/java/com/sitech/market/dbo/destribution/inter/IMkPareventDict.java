package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: IMkPareventDict
 * @Description： 营销元素参数事件
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkPareventDict {
	
	/**
	 * Create on 2015-4-2 
	 * @author: dongyh
	 * @Title: queryParevent 
	 * @Description: 查询全部属性事件,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkPareventDict(Map inMap);
}
