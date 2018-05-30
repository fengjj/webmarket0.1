package com.sitech.market.dbo.destribution.inter;

import com.alibaba.fastjson.JSONObject;

public interface IMkUserLabelInfo {
	/** 
	 * Create on 2015-8-10
	 * @author: 
	 * @Title: queryUserLabelByIdNo 
	 * @Description: 根据rowkey查询mk_userlabel_info
	 * @param rowKey
	 * @param data 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject queryUserLabelByIdNo(String rowKey);
	
}
