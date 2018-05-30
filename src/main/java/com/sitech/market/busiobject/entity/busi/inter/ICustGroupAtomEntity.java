package com.sitech.market.busiobject.entity.busi.inter;

import java.util.List;
import java.util.Map;

public interface ICustGroupAtomEntity {
	
	/**
	 * Create on 2015-6-1 
	 * @author: yugl
	 * @Title: screenActionByCustGroup 
	 * @Description: 根据用户的客户群筛选出可办理活动
	 * @param actInfoList
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List screenActionByCustGroup(List actInfoList, Map inParam);

	/**
	 * 查询业务客户群信息
	 * Create on 2015-5-9 
	 * @author: wangdw
	 * @Title: selectBusiCustGroup 
	 * @Description: 入参[busiId 业务id,busiType 业务类型]
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectBusiCustGroup(Map<Object,Object> inMap);
	
	/**
	 * Create on 2015-6-6 
	 * @author: liuhaoa
	 * @Title: queryList 
	 * @Description: 目标客户群查询
	 * @param inDTO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	public List queryList(Map inMap);
	
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
	
	public String addCustGroupDetail();
	
	/**
	 * 保存附件客户群
	 * @Create on 2015-7-28 
	 * @author: wangdw
	 * @Title: saveFileCustGroup 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public Map saveFileCustGroup(Map inMap);
	
	
	/**
	 * @author: zhaojie
	 * @Title: updateCustGroupInfo
	 * @Description:更新目标客户群信息
	 * @return 
	 * @version 1.0 
	 * date:2016-5-3
	 */
	public void updateCustGroupInfo(Map inMap);
}
