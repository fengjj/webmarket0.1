package com.sitech.market.dbo.trading.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/** 
 * Create on 2014-10-27
 * @author sunliang
 */
public interface IMkIndextoqueryIdx {
	/** 
	 * Create on 2014-10-27
	 * @author sunliang
	 */
	public JSONObject queryIndexByRowkey(String queryType, String tableId,String queryValue);
	
	/**
	 * 根据一个key查询index表的json值
	 * @Create on 2015-8-24 
	 * @author: wangdw
	 * @Title: queryIndexByRowkey 
	 * @Description: 
	 * @param rowkey
	 * @return 
	 * @version 1.0 
	 * update_date: update_author: update_note:
	 */
	public JSONObject queryIndexByRowkey(String rowkey);
	
	/**
	 * 向索引表添加活动订购记录的索引
	 * ROWKEY       = 100|actrecord|id_no
 	 * Column_name  = serial_id
 	 * Column_value = actid|meansid|orderid|status_code
	 * @author hanzh_bj
	 */
	//public void insertIndexToQuery(String key, Map<String, Object> datas);
	
	 public void insertIndexToQuery(String key ,Map<String, String> datas);
	
	/**
	 * 批量向索引表添加活动订购记录的索引
	 * ROWKEY       = 100|actrecord|id_no
 	 * Column_name  = serial_id
 	 * Column_value = actid|meansid|orderid|status_code
	 * @author hanzh_bj
	 */
	public void insertBatchIndexToQuery(List<Map<String, Map<String, Object>>> datas);

	/**
	 * Create on 2015-7-19
	 * @author: liuhaoa
	 * @Title: getIndextoqueryIdx 
	 * @Description: 获取serial_id通过rowkey
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public JSONObject selectMkIndextoqueryIdxByRowKey(String rowKey);
	
	/**
	 * 索引表查询
	 * @Create on 2015-8-6 
	 * @author: wangdw
	 * @Title: queryIndexByRowkeys 
	 * @Description: 
	 * @param queryType
	 * @param tableId
	 * @param queryValue
	 * @return {rowKey:{columnName:columnValue}}
	 * @version 1.0 
	 * update_date: update_author: update_note:
	 */
	public Map<String, Map<String, String>>  queryIndexByRowkey(String queryType, String tableId, List<String> queryValues) ;
	
	/**
	 * 根据数据rowkeys查询index表
	 * @Create on 2015-8-6 
	 * @author: wangdw
	 * @Title: queryIndexByRowkeys 
	 * @Description: 
	 * @param rowkeys
	 * @return {rowKey:{columnName:columnValue}}
	 * @version 1.0 
	 * update_date: update_author: update_note:
	 */
	public Map<String, Map<String, String>> queryIndexByRowkeys(String[] rowkeys);
}
