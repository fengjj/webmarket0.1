package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkCustGroupInfo
* @Description： 营销客户群
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkCustGroupInfo {
	
	/**
	 * Create on 2015-6-6 
	 * @author: liuhaoa
	 * @Title: queryList 
	 * @Description: 目标客户群查询
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public List queryList(Map inMap, int beginNum, int endNum);
	
	/**
	 * Create on 2015-6-8
	 * @author: liuhaoa
	 * @Title: insertCustGroupInfo 
	 * @Description: 目标客户群生成
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertCustGroupInfo(Map inMap);
	
	/**
	 * @author: liuhaoa
	 * @Title: deleteCustGroupInfo
	 * @Description:删除目标客户群明细
	 * @return 
	 * @version 1.0 
	 * date:2015-6-8
	 */
	public void deleteCustGroupInfo(Map inMap);
	
		/**
	 * @author: liuhaoa
	 * @Title: deleteCustGroupInfo
	 * @Description:目标客户群序列生成
	 * @return 
	 * @version 1.0 
	 * date:2015-6-8
	 */
	public String addCustGroupDetail();
	
	/**
	 * 根据主键更新客户群
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: updateMkCustgroupInfoById 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public void updateMkCustgroupInfoById(Map inMap) ;
}
