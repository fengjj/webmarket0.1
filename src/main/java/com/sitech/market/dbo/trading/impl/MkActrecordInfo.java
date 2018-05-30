package com.sitech.market.dbo.trading.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkActrecordInfo;
import com.sitech.market.dbo.trading.inter.IMkIndextoqueryIdx;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;
import com.sitech.util.ErrorUtil;

/**
 * Create on 2015-4-6 
 * @author: gengws
 * @Title: MkActrecordInfo 
 * @Description： MkActrecordInfo表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkActrecordInfo extends DBNosqlClass implements IMkActrecordInfo {
	private IMkIndextoqueryIdx   idxToQuery;
	
	public void setIdxToQuery(IMkIndextoqueryIdx idxToQuery) {
		this.idxToQuery = idxToQuery;
	}

	/**
     * 将活动订购信息插入MK_ACTRECORD_INFO表中
     * Create on 2014-11-25
     * @author zhaiwt
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	@Override
	public boolean insertToActRecord(Map<String, String> datas, String recordId) {
		Map map = new HashMap<String,Object>();
		map.putAll(datas);
		try{
			insertActRecordIndexToQuery(datas);
			cassandraDao.insertMultiCloumAndSingleRow("mk_actrecord_info", recordId, map);
		}catch(Exception ex){
			ex.printStackTrace();
			rollbackActRecordIndexToQuery(datas);
			throw new BusiException("-1", "添加活动订购记录失败", "insertToActRecord failed");
		}
		return true;
	}
	
    /** 
     * Create on 2015-7-10 
     * @author: wenzt
     * @Title: insertToActRecordTrac 
     * @Description: 
     * @param datas
     * @param str
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note: 
     */
	@Override
	public boolean insertToActRecordTrac(Map<String,Map<String,Object>> datas) {
//		Map map = new HashMap<String,Object>();
//		map.putAll(datas);
		try{
			//insertActRecordIndexToQuery(datas);
			List<Map<String, Map<String, Object>>> RecordDatas = new ArrayList<Map<String, Map<String, Object>>>();
			RecordDatas.add(datas);
			cassandraDao.insertMultiCloumAndRows("mk_actrecord_trac",RecordDatas);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new BusiException("-1", "添加活动订购记录失败", "insertToActRecordTrac failed");
		}
		return true;
	}
	
	/**
	 * 向索引表添加活动订购记录的索引
	 * ROWKEY       = 100|actrecord|id_no
 	 * Column_name  = serial_id
 	 * Column_value = actid|meansid|orderid|status_code
	 * @author hanzh_bj
	 */
	private void insertActRecordIndexToQuery (Map<String, String> datas){
		Map inParam = new HashMap<String, String>();
		String idNo        = datas.get("id_no");
		String record_id   = datas.get("serial_id");
		String order_id    = datas.get("order_id");
		String act_id      = datas.get("act_id");
		String meansId     = datas.get("means_id");
		String statusCode  = datas.get("status_code");
		String subOrderId  = datas.get("sub_order_id");
		String act_class   = datas.get("actClass");
		String other_phone = datas.get("other_phone");
		String phone_no    = datas.get("phone_no");
		System.out.println("***************datasdatasdatasdatasdatasdatasdatas:"+datas+"****************");
		String key = Const.idNoFlag+Const.nosql_split+Const.mk_actRecord_info+Const.nosql_split+idNo;
		String columnValue = act_id+Const.nosql_split+meansId+Const.nosql_split+order_id+Const.nosql_split+
							statusCode+Const.nosql_split+subOrderId;
		inParam.put(record_id, columnValue);
		try{
			log.info("====insertActRecordIndexToQuery====key:"+key+",inParam:"+inParam);
			idxToQuery.insertIndexToQuery(key,inParam);
			if(act_class != null && !"".equals(act_class) && "02".equals(act_class)){
				key = Const.otherPhone + Const.nosql_split + Const.mk_actRecord_info + Const.nosql_split + other_phone;
				columnValue = act_id + Const.nosql_split + meansId + Const.nosql_split + order_id + Const.nosql_split + statusCode + Const.nosql_split + phone_no;
				Map<String, String> pMap = new HashMap<String, String>();
				pMap.put(record_id, columnValue);
				idxToQuery.insertIndexToQuery(key, pMap);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			String returnCode = ErrorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","insertActRecordIndexToQuery");
		
		}
		
	}
	
	/**
	 * 回退索引表添加de活动订购记录索引
	 * ROWKEY       = 100|actrecord|id_no
 	 * Column_name  = serial_id
 	 * Column_value = actid|meansid|orderid|status_code
	 * @author hanzh_bj
	 */
	private void rollbackActRecordIndexToQuery (Map<String, String> datas){
		Map inParam = new HashMap<String, Object>();
		String idNo        = datas.get("id_no");
		String record_id   = datas.get("serial_id");
		String order_id    = datas.get("order_id");
		String act_id      = datas.get("act_id");
		String meansId     = datas.get("means_id");
		String key = Const.idNoFlag+Const.nosql_split+Const.mk_actRecord_info+Const.nosql_split+idNo;
		String columnValue = act_id+Const.nosql_split+meansId+Const.nosql_split+order_id+Const.nosql_split+Const.failStatusCode;
		inParam.put(record_id, columnValue);
		idxToQuery.insertIndexToQuery(key,inParam);
		log.debug("rollbackActRecordIndexToQuery success!");
	}

	/** 
	  * 回滚MK_ACTRECORD_INFO表中的营销业务订购次数
	  * Create on 2014-11-27 
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	@Override
	public void rollbackActRecord(String recordId, Map<String, String> datas) {
		try{
			rollbackActRecordIndexToQuery(datas);
			cassandraDao.insertMultiCloumAndSingleRow("mk_actrecord_info", recordId, datas);
		}catch(Exception e){
			e.printStackTrace();
			String returnCode = ErrorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","rollbackActRecord");
		}
	}
	

	/**
	 * 
	 * Create on 2015年4月6日
	 * @author:fengjj
	 * @Title: getSerialId
	 * @Description: 根据用户标识查询索引表记录的serial_id 
	 * @param idNo
	 * @param tableId
	 * @return
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
    public JSONObject getSerialId(String idNo,String tableId){
        JSONObject recordIdObject = null;
        try{
          if(!"".equals(idNo) && null != idNo){
              JSONObject serialIdObject = cassandraDao.query_by_key("mk_indextoquery_idx", Const.idNoFlag+Const.nosql_split+tableId+Const.nosql_split+idNo);
              if(0 != serialIdObject.size()){
                  recordIdObject = JSONObject.parseObject(serialIdObject.getString(Const.idNoFlag+Const.nosql_split+tableId+Const.nosql_split+idNo));
              }
          }
        }catch(Exception e){
          e.printStackTrace();
          throw new BaseException("getSerialId","亲,query出异常了,到后台看看吧");
        }
        return recordIdObject;
    }
	/**
	 * Create on 2015年4月6日
	 * @author:fengjj
	 * @Title: getActrecordInfo
	 * @Description: 查询活动订购记录主表信息 
	 * @param tableId
	 * @param orderNoStr
	 * @param idNo
	 * @return
	 * @throws Exception
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */ 
    public JSONObject getActrecordInfo(String tableId,String orderNoStr, String idNo) throws Exception {
        //查索引表
        String tableName = CommonUtil.getTableNameByTableId(tableId);
        log.info("MkActrecordInfo.getActrecordInfo.tableId:"+tableId);
        log.info("MkActrecordInfo.getActrecordInfo.idNo:"+idNo);
        JSONObject json = idxToQuery.queryIndexByRowkey( Const.idNoFlag, tableId, idNo);
        log.info("MkActrecordInfo.getActrecordInfo.json:"+json);
        if (null != json && 0 != json.size()) {
            Set<String> set = json.keySet();
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                String key = it.next();
                String value = json.getString(key);
                log.info("&&&&&key:"+key+"&&&&&&&&&getActrecordInfo.value:"+value+"&&&&&&&&&&&&&&&&&&&&&&&");
                if(value!=null){
                    if(value.indexOf(orderNoStr)!=-1){
//                    	JSONObject rjson = cassandraDao.query_by_key("mk_actrecord_rel", key+"|003");
//                    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~rjson~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+rjson);
//                    	if(rjson != null && rjson.size() > 0){
//	                    	JSONObject rrecord = rjson.getJSONObject(key+"|003");
//	                    	Iterator iterator = rrecord.keySet().iterator();
//	                    	String rowKey = "";
//	                    	while(iterator.hasNext()){
//	                    		rowKey = (String)iterator.next();
//		                    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~rowKey~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+rowKey);
//		                    	JSONObject fjson = cassandraDao.query_by_key("mk_actrecordfee_info", rowKey);
//		                    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~fjson~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+fjson);
//		                    	String order_line_id = "";
//		                    	if(fjson != null && fjson.size() > 0){
//		                    		JSONObject frecord = fjson.getJSONObject(rowKey);
//		                    		order_line_id = frecord.getString("order_line_id");
//		                    	}
//		                    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~order_line_id~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+order_line_id);
//		                    	if(order_line_id != null && !"".equals(order_line_id)){
//		                    		JSONObject actJsonObj = cassandraDao.query_by_key(tableName, key);
//		                    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~actJsonObj~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+actJsonObj);
//		                    		return actJsonObj;
//		                    	}
//	                    	}
//                    	}
 //                   	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~key~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+key);
                    	JSONObject actJsonObj = cassandraDao.query_by_key(tableName, key);
  //                  	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~actJsonObj~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+actJsonObj);
                        //return cassandraDao.query_by_key(tableName, key);
                    	return actJsonObj;
                    }
                 }
                }
            }
        return null;
    }
	/**
	 * Create on 2015年8月11日
	 * @author:qijh
	 * @Title: getActrecordInfo
	 * @Description: 查询活动订购记录主表信息 
	 * @param tableId
	 * @param orderNoStr
	 * @param idNo
	 * @return
	 * @throws Exception
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */ 
    public JSONObject getActrecordInfo(String tableId,String orderNoStr, String idNo ,String contactId) throws Exception {
        //查索引表
        String tableName = CommonUtil.getTableNameByTableId(tableId);
        log.info("MkActrecordInfo.getActrecordInfo.tableId:"+tableId);
        log.info("MkActrecordInfo.getActrecordInfo.idNo:"+idNo);
        JSONObject json = idxToQuery.queryIndexByRowkey( Const.idNoFlag, tableId, idNo);
        log.info("MkActrecordInfo.getActrecordInfo.json:"+json);
        if (null != json && 0 != json.size()) {
            Set<String> set = json.keySet();
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
            	String key = it.next();
                String value = json.getString(key);
                log.info("&&&&&key:"+key+"&&&&&&&&&getActrecordInfo.value:"+value+"&&&&&&&&&&&&&&&&&&&&&&&");
                if(value!=null){
                    String[]index=value.split("\\|");
                    if(!index[2].equals("")&&!index[2].equals("null")){
	                	if(value.indexOf(orderNoStr)!=-1){
	                    	JSONObject actJsonObj = cassandraDao.query_by_key(tableName, key);
	                    	return actJsonObj;
	                    }
                	}else{
                		 JSONObject actJsonObj = cassandraDao.query_by_key(tableName, key);
                		 value = actJsonObj.toString();
                		 if(value.indexOf(contactId)!=-1){
                         	return actJsonObj;
                         }
                	}
                }
            }
        }
        return null;
    }
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: getOtherOrderInfo
     * @Description: 根据主键从关系表查分表数据 
     * @param tableId
     * @param serial
     * @return
     * @throws Exception
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public JSONObject getOtherOrderInfo(String tableId,String serial) throws Exception{
        JSONObject json = null;
        String relTable = "mk_actrecord_rel";
        String tableName = CommonUtil.getTableNameByTableId(tableId);
       if(tableName==null){
           String returnCode = ErrorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
           throw new BusiException(returnCode,"CommonUtil tableName未配置","getOtherOrderInfo");
       }
        //查关系表
        String key = serial+Const.nosql_split+tableId;
        JSONObject relJson = cassandraDao.query_by_key(relTable, key);
        relJson = CommonUtil.getJsonObjContext(relJson, key);
        if(relJson!=null){
            Set<String> set = relJson.keySet();
            String[] keys = new String[set.size()];
            int i=0;
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                keys[i] = it.next();
                i++;
            }
            json = cassandraDao.query_by_key(tableName, keys);
            
        }
        
        return json;
    }
    
    
    /**
     * 
     * Create on 2015年9月25日
     * @author:tangll
     * @Title: getOtherOrderInfo
     * @Description: 根据主键从关系表查分表数据 
     * @param tableId
     * @param serial
     * @return
     * @throws Exception
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public JSONObject getOtherUnOrderInfo(String tableId,String tablename,String serial) throws Exception{
        JSONObject json = null;
        String relTable = "mk_actrecord_rel";
       if(tablename==null){
           String returnCode = ErrorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
           throw new BusiException(returnCode,"CommonUtil tableName未配置","getOtherOrderInfo");
       }
        //查关系表
        String key = serial+Const.nosql_split+tableId;
        JSONObject relJson = cassandraDao.query_by_key(relTable, key);
        relJson = CommonUtil.getJsonObjContext(relJson, key);
        if(relJson!=null){
            Set<String> set = relJson.keySet();
            String[] keys = new String[set.size()];
            int i=0;
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                keys[i] = it.next();
                i++;
            }
            json = cassandraDao.query_by_key(tablename, keys);
            
        }
        
        return json;
    }
    
    
    
    /**
     * 
     * Create on 2015年4月6日
     * @author:fengjj
     * @Title: getMainInfo
     * @Description: 根据索引表列值--主键序列号 查主表 
     * @param tableName
     * @param key
     * @return
     * @throws Exception
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    @Override
    public JSONObject getMainInfo(String tableName,String key) throws Exception{
        JSONObject actRecord = cassandraDao.query_by_key(tableName, key);
        return CommonUtil.getJsonObjContext(actRecord, key);
    }
	
    /**
     * Create on 2015-4-6 
     * @author: gengws
     * @Title: getActRecordsByImei 
     * @Description: 根据IMEIS_NO查询订购记录 
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	@Override
	public List getActRecordsByImei(Map inMap) {
		
		List records=new ArrayList(); 
		
		Map termiInfo=getTermiInfo(inMap);//根据IMEI_NO去mk_actrecordtermi_info去查询信息

		String order_no=(String) termiInfo.get("ORDER_NO");//获得mk_actrecord_info的rowKey
		
		Map record=null;
		
		if(CommonUtil.isNotEmpty(order_no)){
			record=getActRecordInfo(termiInfo);//根据order_no作为mk_actrecord_info的rowKey去查询信息
			records.add(record);
		}else{
			records.add(termiInfo);
			log.info("mk_actrecordtermi_info表中order_no为空");
			throw new BusiException("-1", "无法根据IMEI_NO查询订购记录","无法根据IMEI_NO查询订购记录");
		}

		return records;
	}
	/**
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: getActRecordsByIdNo 
	 * @Description: 根据ID_NO查询订购记录
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List getActRecordsByIdNo(Map inMap) {
		
		String idNo=(String) inMap.get("ID_NO");//获得ID_NO
		
		String key=Const.idNoFlag+Const.nosql_split+Const.mk_actRecord_info+Const.nosql_split+idNo;//拼接mk_indextoquery_idx的rowKey
		
		String[] rowKeys=getActRecordRowKeys(key);//查询mk_actrecord_info所包含的rowKeys
		
		List records=getActRecordsByIdNos(rowKeys,inMap);//查询mk_actrecord_info中的信息
		
		return records;
	}
	/**
	 * 
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: getActRecordsByIdNos 
	 * @Description: 传入mk_actrecord_info的rowKey数组去查询所有信息
	 * @param rowKeys
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List getActRecordsByIdNos(String[] rowKeys,Map inMap){
		
		JSONObject jsons = null;
		List records=new ArrayList();
		try{
			jsons=cassandraDao.query_by_key("mk_actrecord_info", rowKeys);
			
			for(int i=0;i<rowKeys.length;i++){
			
				JSONObject record=(JSONObject) jsons.parse(jsons.getString(rowKeys[i]));
				
				if(!record.isEmpty()){
					
					Map actRecotrdInfo=new HashMap();
					String serialId = rowKeys[i];
//					actRecotrdInfo.put("SERIAL_NO", record.getString("serial_id"));
					actRecotrdInfo.put("SERIAL_NO",serialId);
					actRecotrdInfo.put("ACT_ID", record.getString("act_id"));
					actRecotrdInfo.put("ORDER_ID", record.getString("order_id"));
					actRecotrdInfo.put("MEANS_ID", record.getString("means_id"));
					actRecotrdInfo.put("CHN_TYPE", record.getString("chn_type"));
					actRecotrdInfo.put("FEE_SUM", record.getString("fee_sum"));
					actRecotrdInfo.put("CUST_ID", record.getString("cust_id"));
					actRecotrdInfo.put("PHONE_NO", record.getString("phone_no"));
					actRecotrdInfo.put("GROUP_ID", record.getString("group_id"));
					actRecotrdInfo.put("GROUP_NAME", record.getString("group_name"));
					actRecotrdInfo.put("OPER_NO", record.getString("oper_no"));
					actRecotrdInfo.put("OPER_NAME", record.getString("oper_name"));
					actRecotrdInfo.put("OPER_DATE", record.getString("oper_time"));
					actRecotrdInfo.put("REGION_CODE",record.get("region_code"));
					actRecotrdInfo.put("STATUS_CODE",record.get("status_code"));
					actRecotrdInfo.put("BUSI_ID",record.get("out_serial_id"));
					actRecotrdInfo.put("ID_NO",record.get("id_no"));
					
					records.add(actRecotrdInfo);
					
				}
			}
			log.debug("mk_actrecord_info所有信息："+records.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return records;
	}
	/**
	 * 
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: getActRecordRowKeys 
	 * @Description: 通过传参的rowkey查询出mk_actrecord_info对应的rowkeys(不确定条数)
	 * @param rowKey
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private String[] getActRecordRowKeys(String rowKey){
		
		JSONObject json = null;
		String[] rowKeys=null;
		try{
			json=cassandraDao.query_by_key("mk_indextoquery_idx",rowKey);
			
			JSONObject records=(JSONObject) json.parse(json.getString(rowKey));
			
			Set keys=records.keySet();
			rowKeys=new String[keys.size()];

			int i=0;
			for(Object key:keys){
				String columnName=(String) key;
				rowKeys[i]=columnName;
				i++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return rowKeys;
	}
	
	/**
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: getTermiInfo 
	 * @Description: 根据IMEI_NO去mk_actrecordtermi_info去查询信息
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private Map getTermiInfo(Map inMap){
		
		String imeiNo=(String) inMap.get("IMEI_NO");
		String phoneNo = CommonUtil.isEmpty(inMap.get("PHONE_NO"))?"":(String) inMap.get("PHONE_NO");
		String key=Const.imeiNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+imeiNo;
		JSONObject indexjson = null;//索引表json
		JSONObject json = null;//mk_actrecordtermi_info
		Map termiInfo=new HashMap();
		try{
			indexjson=cassandraDao.query_by_key("mk_indextoquery_idx",key);
			log.info("根据终端查询订购记录mk_indextoquery_idx的json=="+indexjson.toString());
			if(null !=indexjson && indexjson.size()>0){
				JSONObject ss=(JSONObject) JSONObject.parse(indexjson.getString(key));
				Set termiSet=ss.keySet();
				
				String rowkey=null;
				for(Object object:termiSet){
					rowkey=(String) object;
				}
				log.info("rowkey=="+rowkey);
				json=cassandraDao.query_by_key("mk_actrecordtermi_info",rowkey);
				log.info("根据终端查询订购记录mk_actrecordtermi_info的json=="+json.toString());
				if(null !=json && json.size()>0){
					
					JSONObject record=(JSONObject) JSONObject.parse(json.getString(rowkey));
					termiInfo.put("ORDER_NO",record.getString("order_no"));//订购记录主表主键
					//后补充字段
					termiInfo.put("IMEI_NO", record.getString("resource_no"));
					termiInfo.put("RESOURCE_COST_PRICE", record.getString("terminal_cost_price"));
					termiInfo.put("RESOURCE_REAL_PRICE", record.getString("terminal_real_fee"));
					termiInfo.put("RESOURCE_CODE", record.getString("resource_code"));
					termiInfo.put("RESOURCE_NAME", record.getString("resource_name"));
					termiInfo.put("START_DATE", record.getString("start_date"));
					termiInfo.put("END_DATE", record.getString("end_date"));
					termiInfo.put("PHONE_NO", phoneNo);
					
				}else{
					
					log.debug("IMEI_NO查询不到信息:"+imeiNo);
				}
			}
			
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return termiInfo;
	}
	/**
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: getActRecordInfo 
	 * @Description: 根据order_no作为mk_actrecord_info的rowKey去查询信息
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private Map getActRecordInfo(Map inMap){
		
		String order_no=(String) inMap.get("ORDER_NO");
		String phone_no=(String) inMap.get("PHONE_NO");
		
		JSONObject json = null;
		
		try{
			json=cassandraDao.query_by_key("mk_actrecord_info",order_no);
			log.info("根据IMEI_NO查询订购记录，主表查询=="+json.toJSONString());
			if(null!=json&&json.size()>0){
				
				JSONObject record=(JSONObject) JSONObject.parse(json.getString(order_no));
				
				if(CommonUtil.isEmpty(phone_no) || phone_no.equals(record.getString("phone_no"))){
					inMap.put("SERIAL_NO", record.getString("serial_id"));
					inMap.put("ACT_ID", record.getString("act_id"));
					inMap.put("ORDER_ID",record.get("order_id"));
					inMap.put("MEANS_ID", record.getString("means_id"));
					inMap.put("CHN_TYPE", record.getString("chn_type"));
					inMap.put("FEE_SUM", record.getString("fee_sum"));
					inMap.put("CUST_ID", record.getString("cust_id"));
					inMap.put("PHONE_NO", record.getString("phone_no"));
					inMap.put("GROUP_ID", record.getString("group_id"));
					inMap.put("GROUP_NAME", record.getString("group_name"));
					inMap.put("OPER_NO", record.getString("oper_no"));
					inMap.put("OPER_NAME", record.getString("oper_name"));
					inMap.put("OPER_DATE", record.getString("oper_time"));
					inMap.put("REGION_CODE",record.get("region_code"));
					inMap.put("STATUS_CODE",record.get("status_code"));
					inMap.put("BUSI_ID",record.get("out_serial_id"));
					inMap.put("ID_NO",record.get("id_no"));
				}
					
			}else{
				log.debug("根据order_no查询不到信息"+order_no);
			}
			
		}catch(Exception e){
			throw new BusiException("-1", "无法根据IMEI_NO查到订购记录");
		}
		
		return inMap;	
	}
	
	public Map queryActrecordBySerialIds(String... serialIds){
		Map result = null;
		try {
			result =  cassandraDao.query_by_key("mk_actrecord_info", serialIds);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1", "根据主键查询订购记录失败", "异常信息为：："+e);
		}
		return result;
	}
	/** 
	 * Create on 2015-7-13 
	 * @author: wenzt
	 * @Title: queryActrecordTracBySerialIds 
	 * @Description: 
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject queryActrecordTracBySerialIds(String serialId){
		JSONObject json = new JSONObject();
		try {
			json =  cassandraDao.query_by_key("mk_actrecord_trac", serialId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1", "根据主键查询订购记录轨迹表失败", "异常信息为：："+e);
		}
		return json;
		
	}
	
	@Override
	public JSONObject queryCheckPhone(Map<String,String> bean) {
        JSONObject actRecordJson = null;
		String actId = bean.get("actId");
		String phoneNo = bean.get("phoneNo");
		try {
			actRecordJson = cassandraDao.query_by_idx("mk_actrecord_info", "phone_no", phoneNo, "act_id", actId);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return actRecordJson;
    }
	
	/**
	 * 根据rowkey查询索引表
	 * @Create on 2015-7-15 
	 * @author: wangdw
	 * @Title: queryIndexByKey 
	 * @Description: 
	 * @param rowKey
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public List queryIndexByKey(String rowKey) {
		List indexList = new ArrayList();
		log.info("...in.queryIndexByKey..."+rowKey);
		try {
			JSONObject indexjson = cassandraDao.query_by_key("mk_indextoquery_idx",rowKey);
			if (CommonUtil.isNotEmpty(indexjson)) {
				log.info("根据终端串号查询订购记录mk_indextoquery_idx的json=="+indexjson.toString());
				JSONObject recordRels=(JSONObject) indexjson.parse(indexjson.getString(rowKey));
				
				Set keySet = recordRels.keySet();

				int i = 0;
				for(Object keyObj : keySet){
					String key = (String) keyObj;
					String value = recordRels.getString(key);
					
					Map indexMap = new HashMap();
					indexMap.put("key", key);
					indexMap.put("value", value);
					indexList.add(indexMap);
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1", "根据主键查询订购记录失败", "异常信息为：："+e);
		}
		return indexList;
	}

	/**
	 * Create on 2015-7-16 
	 * @author: liuhaoa
	 * @Title: selectMkActrecordInfo 
	 * @Description: 根据serail_id查询MkActrecordInfo成本总表信息
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject selectMkActrecordInfo(String serial_id) {
		JSONObject json = null;
		try{
			json = cassandraDao.query_by_key("mk_actrecord_info", serial_id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}



	@Override
	public JSONObject getActRecordsByKeys(String[] keys) {
		JSONObject json=null;
		
		try {
			json=cassandraDao.query_by_key("mk_actrecord_info", keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
}
