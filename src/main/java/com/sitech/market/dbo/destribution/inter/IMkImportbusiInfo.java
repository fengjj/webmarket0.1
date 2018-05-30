package com.sitech.market.dbo.destribution.inter;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IMkImportbusiInfo {
	
	/** 
	 * Create on 2015-6-24 
	 * @author: songxj
	 * @Title: insertMkImportbusiInfo 
	 * @Description: 根据rowkey插入mk_importbusi_info
	 * @param rowKey
	 * @param data 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public void insertMkImportbusiInfo(String rowKey, Map data);
	
	/** 
	 * Create on 2015-7-3 
	 * @author: songxj
	 * @Title: getMkImportbusiInfo 
	 * @Description: 根据rowkey查询mk_importbusi_info
	 * @param rowKey
	 * @param data 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject getMkImportbusiInfo(String rowKey);
	
}
