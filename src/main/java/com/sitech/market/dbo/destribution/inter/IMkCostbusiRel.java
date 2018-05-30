package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkCostbusiRel
* @Description： 成本关系
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkCostbusiRel {

	/**
	 * Create on 2015-7-16 
	 * @author: liuhaoa
	 * @Title: updateCostBusiRel 
	 * @Description: 修改成本业务关系表
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateCostBusiRel(Map inMap);
	
	/**
	 * Create on 2015-7-16 
	 * @author: liuhaoa
	 * @Title: selectCostBusiRel 
	 * @Description: 查询成本业务关系表
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectCostBusiRel(Map inMap);
}
