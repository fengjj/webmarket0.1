package com.sitech.market.dbo.trading.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


/**
 * Create on 2015-4-18 
 * @author: gengws
 * @Title: IMkCustInfo 
 * @Description： 营销客户标签表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkCustInfo {
	
	/**
	 * Create on 2015-4-18 
	 * @author: gengws
	 * @Title: queryMkCustInfoByCustIds 
	 * @Description: 查询营销客户标签表的信息
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryMkCustInfoByCustIds(List list); 
	
	
	/**
	 * Create on 2015-7-10 
	 * @author:zhaoyue
	 * @Title: getCustInfoByCustId 
	 * @Description: 根据custId查询客户标签数据
	 * @param custId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject getCustInfoByCustId(String custId);
	
	
	public void insertMkCustInfo(String custId, Map data);
	
}
