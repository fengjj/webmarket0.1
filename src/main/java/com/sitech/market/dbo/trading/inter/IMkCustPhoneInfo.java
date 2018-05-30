package com.sitech.market.dbo.trading.inter;

import com.alibaba.fastjson.JSONObject;

/**
 * Create on 2015-8-25 
 * @author: liuhaoa
 * @Title: IMkCustPhoneInfo 
 * @Description： IMkCustPhoneInfo表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkCustPhoneInfo {

	/**
	 * Create on 2015-8-25 
	 * @author: liuhaoa
	 * @Title: selectMkCustPhoneInfo 
	 * @Description: 根据phone_no查询selectMkCustPhoneInfo成本总表信息
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject selectMkCustPhoneInfo(String phone_no);
}
