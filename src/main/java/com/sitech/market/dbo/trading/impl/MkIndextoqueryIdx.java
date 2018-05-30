package com.sitech.market.dbo.trading.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkIndextoqueryIdx;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;

public class MkIndextoqueryIdx extends DBNosqlClass implements IMkIndextoqueryIdx {
	/**索引表查询
	 * create on 2014-10-27
	 * @author sunliang
	 */
	public static void main(String[] args) {
		MkIndextoqueryIdx a = new MkIndextoqueryIdx();
		a.queryIndexByRowkey("100", "001", "220400200033580090");
	}
	public JSONObject queryIndexByRowkey(String queryType, String tableId,
			String queryValue) {
		JSONObject serialJson = null;
		String queryStr = queryType+Const.nosql_split+tableId+Const.nosql_split+queryValue;
		log.info("queryStr="+queryStr);
		
		try{
 		   if(null != queryValue&&!"".equals(queryValue) ){
 			  JSONObject jo = cassandraDao.query_by_key("mk_indextoquery_idx",queryStr);
 			  if(0 != jo.size()){
 				 serialJson = JSONObject.parseObject(jo.getString(queryStr));
 			  }
 		   }
        }catch(Exception e){
			e.printStackTrace();
			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","MkIndextoqueryIdx.queryIndexByRowkey");
        }
        log.info("serialJson="+serialJson);
        return serialJson; 
	}
	
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
	@Override
	public JSONObject queryIndexByRowkey(String rowkey) {
		JSONObject serialJson = null;
		log.info("rowkey="+rowkey);
		try{
 		   if(null != rowkey&&!"".equals(rowkey) ){
 			  JSONObject jo = cassandraDao.query_by_key("mk_indextoquery_idx",rowkey);
 			  if(0 != jo.size()){
 				 serialJson = JSONObject.parseObject(jo.getString(rowkey));
 			  }
 		   }
        }catch(Exception e){
			e.printStackTrace();
			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","MkIndextoqueryIdx.queryIndexByRowkey");
        }
        log.info("serialJson="+serialJson);
        return serialJson; 
	}
	
	/**
     * 新增index数据
     * Create on 2014-11-27
     * @author fengjj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	@Override
	public void insertIndexToQuery(String key, Map<String, String> datas) {
		  try{
	    	 cassandraDao.insertMultiCloumAndSingleRow("mk_indextoquery_idx", key, datas);
			  //cassandraDao.insertMultiCloumnByRowKey("mk_indextoquery_idx", key, datas);
	   	  }catch(Exception e){
	   		  e.printStackTrace();
	   		  String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
	   		  throw new BusiException(returnCode,"数据库操作错误","insertIndexToQuery");
	   	  }
	}
	
	/**
	 * 批量向索引表添加活动订购记录的索引
	 * ROWKEY       = 100|actrecord|id_no
 	 * Column_name  = serial_id
 	 * Column_value = actid|meansid|orderid|status_code
	 * @author hanzh_bj
	 */
	@Override
	public void insertBatchIndexToQuery(List<Map<String, Map<String, Object>>> datas) {
		try{
			cassandraDao.insertMultiCloumAndRows("mk_indextoquery_idx", datas);
		}catch(Exception e){
			e.printStackTrace();
			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","insertBatchIndexToQuery");
		}
	}

	@Override
	public JSONObject selectMkIndextoqueryIdxByRowKey(String rowKey) {
		JSONObject json = null;
		try{
			json = cassandraDao.query_by_key("mk_indextoquery_idx", rowKey);
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}
	
	
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
	@Override
	public Map<String, Map<String, String>>  queryIndexByRowkey(String queryType, String tableId, List<String> queryValues) {
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String,String>>();
		
		String[] queryStrArr = null;
		if (CommonUtil.isNotEmpty(queryValues)) {
			// 拼装查询rowkey入参
			queryStrArr = new String[queryValues.size()];
			for (int i = 0; i < queryValues.size(); i++) {
				queryStrArr[i] = queryType+Const.nosql_split+tableId+Const.nosql_split+queryValues.get(i);
			}
			// 查询index表信息
			resultMap = queryIndexByRowkeys(queryStrArr);
		}
		
        return resultMap; 
	}
	
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
	@Override
	public Map<String, Map<String, String>> queryIndexByRowkeys(String[] rowkeys) {
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String,String>>();
		log.info("queryIndexByRowkeys.rowkeys:"+rowkeys.length);
		try {
			JSONObject jo = cassandraDao.query_by_key("mk_indextoquery_idx", rowkeys);
			log.info("queryIndexByRowkeys.jo:"+jo.size());
			// 拼装返回参数
			if (jo != null && 0 != jo.size()) {
				for (int i = 0; i < rowkeys.length; i++) {
					String rowKey = rowkeys[i];
					log.info("queryIndexByRowkeys.rowKey:"+rowKey);
					Map<String, String> oneMap = null;
					JSONObject json = JSONObject.parseObject(jo.getString(rowKey));
					if (json != null && json.size() != 0) {
						Iterator<String> it = json.keySet().iterator();
						while (it.hasNext()) {
							oneMap = new HashMap<String, String>();
							String columnName = it.next();
							String columnValue = json.getString(columnName);
							oneMap.put(columnName, columnValue);
						}
					}
					resultMap.put(rowKey, oneMap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr, Const.errtype_systemerror);
			throw new BusiException(returnCode, "数据库操作错误", "MkIndextoqueryIdx.queryIndexByRowkey");
		}
		log.info("queryIndexByRowkeys.resultMap:"+resultMap);
		return resultMap;
	}

}
