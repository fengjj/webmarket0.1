package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-7-24
* @author: 
* @Title: IMKPrcidListInfo
* @Description：套餐配置
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMKPrcidListInfo {
	
	/**
	 * Create on 2015-7-24 
	 * @author: 
	 * @Title: queryPrcidList 
	 * @Description: 查询地市与套餐绑定关系数据列表
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public List<Map> queryPrcidList(Map paramMap,int beginNum,int endNum);
	/**
	 * Create on 2015-7-24 
	 * @author: 
	 * @Title: queryPrcidListSum 
	 * @Description: 查询套餐数量
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public List queryPrcidListSum(Map paramMap);
	
	/**
	 * Create on 2015-7-31 
	 * @author: 
	 * @Title: addPrcidList 
	 * @Description: 查询套餐配置数据
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public List addPrcidList(Map paramMap);
	
	/**
	 * Create on 2015-7-31 
	 * @author: 
	 * @Title: addPrcidList 
	 * @Description: 查询套餐配置数据
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public List queryPrcidSum(Map paramMap);
	
	/**
	 * Create on 2015-7-31 
	 * @author: 
	 * @Title: savePrcidList 
	 * @Description: 查询套餐配置数据
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public void savePrcidList(Map paramMap);
	/**
	 * Create on 2015-7-31 
	 * @author: 
	 * @Title: delPrcidList 
	 * @Description: 套餐删除
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public void delPrcidList(Map paramMap);
}
