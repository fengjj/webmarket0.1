package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
 * Create on 2015-6-15
 * @author: liuhaoa
 * @Title: IMkChngroupDict
 * @Description： 营销策划区域选择
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkChngroupDict {

	/**
	 * Create on 2015-6-15
	 * @author: liuhaoa
	 * @Title: queryOrgs 
	 * @Description: 营销策划区域选择
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public List queryOrgs(Map inMap);
	
	/**
	 * 营销渠道区域选择
	 * Create on June 22, 2015 
	 * @author: liuhaoa
	 * @Title: queryGroupName 
	 * @Description: 营销渠道组织区域数据
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public List queryGroupName(Map inMap);
	
	/**
	 * 营销渠道区域选择
	 * Create on June 22, 2015 
	 * @author: liuhaoa
	 * @Title: selectMkChngroupDictById 
	 * @Description: 根据ID获取营销渠道组织区域数据
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkChngroupDictById(Map inMap);
}
