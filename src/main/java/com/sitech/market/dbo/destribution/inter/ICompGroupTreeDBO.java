package com.sitech.market.dbo.destribution.inter;

import java.util.Map;

/**
 * Create on 2015-4-7
 * @author: dongyh
 * @Title: ICompGroupTreeDBO
 * @Description： 查询组织树
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface ICompGroupTreeDBO {

	/**
	 * Create on 2015-4-7 
	 * @author: dongyh
	 * @Title: queryGroupTree 
	 * @Description: 获取工号组织结构查询组织树
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryGroupTree(Map inParam);
}
