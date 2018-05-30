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
import com.sitech.market.dbo.trading.inter.IMkActrecordRel;
import com.sitech.market.dbo.trading.inter.IMkActrecordtermiInfo;
import com.sitech.market.dbo.trading.inter.IMkIndextoqueryIdx;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;
import com.sitech.util.ParamUtil;

public class MkActrecordtermiInfo extends DBNosqlClass implements IMkActrecordtermiInfo {
	
	private IMkIndextoqueryIdx    mkIndextoqueryIdx;
	private IMkActrecordRel       mkActrecordRel;

	
	
	
	
	
	/**
	 * Create on 2015-4-22 
	 * @author: zhaoyue
	 * @Title: queryMkActRecordTermiInfoBySerialId 
	 * @Description: 根据分表的serial_id去查询mk_actrecordter_info
	 * @param keys
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 * @throws Exception 
	 */
	@Override
	public JSONObject queryMkActRecordTermiInfoBySerialId(List interList,String[] keys)  {
		
		JSONObject  termiInfo = null;
		try {
			termiInfo = cassandraDao.query_by_key("mk_actrecordtermi_info", keys);
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1","亲，出错了！","查询终端分表出现异常！");
		}
		log.info("*************查询终端分表结果："+termiInfo.toString());
		return termiInfo;
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
	 * Create on 2015-7-10 
	 * @author: wenzt
	 * @Title: queryActRecordTermiTracBySerialIds 
	 * @Description: 
	 * @param serialIds
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject queryActRecordTermiTracBySerialIds(String serialId){
		JSONObject  termiInfo = null;
		try {
			termiInfo = cassandraDao.query_by_key("mk_actrecordtermi_trac", serialId);
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1","亲，出错了！","查询终端分表出现异常！");
		}
		log.info("*************查询终端分表结果："+termiInfo.toString());
		return termiInfo;
		
	}

	
	
	/**
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: updateImei 
	 * @Description: 更新IMEI_NO
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateImei(Map inMap) {	
		
		//在mk_indextoquery_idx获得mk_actrecordtermi_info的rowKey
		String rowKey=queryRowKey( (String) inMap.get("OLD_IMEI_NO") );
		String loginAccept = (String)inMap.get("LOGIN_ACCEPT");
		
		if(CommonUtil.isNotEmpty(rowKey)){
			
			//更新mk_actrecordtermi_info的imei信息
			updateIMEI_NO(rowKey,(String) inMap.get("NEW_IMEI_NO"));
			System.out.println("~~~~~~~~~~~~~~~~~~更新NEW_IMEI_NO");
			
			//更新mk_actrecordtermi_info的login_accept信息
			Map<String,Object> columns=new HashMap<String,Object>();
			columns.put("login_accept", loginAccept);
			cassandraDao.insertMultiCloumnByRowKey("mk_actrecordtermi_info", rowKey, columns);
			System.out.println("~~~~~~~~~~~~~~~~~~更新login_accept");
			
			//更新mk_actrecordtermi_info的status_code信息
			Map<String,Object> columns1=new HashMap<String,Object>();
			columns1.put("status_code","10");
			cassandraDao.insertMultiCloumnByRowKey("mk_actrecordtermi_info", rowKey, columns1);
			System.out.println("~~~~~~~~~~~~~~~~~~更新status");
			
			//更新mk_indextoquery_idx索引
			updateIndex(rowKey,(String) inMap.get("NEW_IMEI_NO"));
			System.out.println("~~~~~~~~~~~~~~~~~~更新status");
			
			//删除旧的imei号的订购记录
			String oldImeiNo = (String) inMap.get("OLD_IMEI_NO");
			String index=Const.imeiNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+oldImeiNo;
			System.out.println("index~~~~~~~~~~~~~~~~~~删除oldImei:::"+index);
			
			String[] indxKeys = new String[]{index};
			String[] indxColumns = new String[]{rowKey,"value"};
			System.out.println("rowKey~~~~~~~~~~~~~~~~~~删除oldImei:::"+rowKey);
			cassandraDao.deleteMultiByColumnAndKeys("mk_indextoquery_idx", indxKeys, indxColumns);

			System.out.println("~~~~~~~~~~~~~~~~~~删除oldImei");
		}
		else{
			log.debug("无法根据OLD_IMEI_NO查询出信息");
		}

	}
	
	
	/**
	 * Create on 2015-4-16 
	 * @author: gengws
	 * @Title: queryActRecordTermi 
	 * @Description: 通过主表的serialId去查询mk_actrecord_info
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryActRecordTermi(List list) {
		System.out.println("查询终端开始==="+list.toString());
		
		String[] keys=queryMkRecordList(list);//mk_actrecord_rel的rowKey集合
		
		JSONObject termiInfo=queryMkActRecordTermiInfo(keys);//查询mk_actrecordtermi_info中的信息
		
		List reList=queryActRecord(list, termiInfo);//查询mk_actrecordtermi_info中的信息与原有信息结合	
		
		return reList;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	//私有方法
	
	/**
	 * Create on 2015-4-17 
	 * @author: gengws
	 * @Title: queryActRecord 
	 * @Description: 
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List queryActRecord(List list,JSONObject json){
		
		List reList=new ArrayList();//返回记录
		
		if(!CommonUtil.isEmpty(list)&&!CommonUtil.isEmpty(json)){//2015-4-18修改
			
			log.info("终端订购记录信息1212="+json.toString());
			
			log.info("终端订购记主表条数="+list.size());
			Set keys=json.keySet();
			String[] rowKeys=new String[keys.size()];//存放mk_actrecordtermi_info的主键
			
			
			for(int i=0;i<list.size();i++){
				JSONObject termiIfo;
				Map record=(Map) list.get(i);
				String serialId=(String) record.get("SERIAL_NO");
				for(Object key:keys ){
					termiIfo=(JSONObject) json.parse(json.getString( (String) key ));
					String orderNo=termiIfo.getString("order_no");
					if(serialId.equals(orderNo)){
						record.put("RESOURCE_COST_PRICE", termiIfo.getString("terminal_cost_price"));
						record.put("RESOURCE_REAL_PRICE", termiIfo.getString("terminal_real_price"));
						record.put("RESOURCE_CODE", termiIfo.getString("resource_code"));
						record.put("RESOURCE_NAME", termiIfo.getString("resource_name"));
						record.put("IMEI_NO", termiIfo.getString("resource_no"));
						record.put("IMEI_NO", termiIfo.getString("resource_no"));
						record.put("START_DATE", termiIfo.getString("start_date"));
						record.put("END_DATE", termiIfo.getString("end_date"));
					}
				}
				reList.add(record);
			}
		}
			
//			for(int i=0;i<list.size();i++){
//				Map record=(Map) list.get(i);
//				String serialId=(String) record.get("SERIAL_NO");
//				
//				for(int j=0;j<rowKeys.length;i++){
//					JSONObject termiIfo=(JSONObject) json.parse(json.getString(rowKeys[i]));
//					
//					log.info("termiIfo====="+termiIfo.toString());
//					
//					if(!CommonUtil.isEmpty(termiIfo)){
//						String orderNo=termiIfo.getString("order_no");
//						if(!CommonUtil.isEmpty(orderNo)&&orderNo.equals(serialId)){
//							record.put("RESOURCE_COST_PRICE", termiIfo.getString("terminal_cost_price"));
//							record.put("RESOURCE_REAL_PRICE", termiIfo.getString("terminal_real_price"));
//							record.put("RESOURCE_CODE", termiIfo.getString("resource_code"));
//							record.put("RESOURCE_NAME", termiIfo.getString("resource_name"));
//							record.put("IMEI_NO", termiIfo.getString("resource_no"));
//							record.put("IMEI_NO", termiIfo.getString("resource_no"));
//							record.put("START_DATE", termiIfo.getString("start_date"));
//							record.put("END_DATE", termiIfo.getString("end_date"));
//							
//							reList.add(record);
//						}
//						else{
//							reList.add(record);
//						}
//					}	
//					else{
//						reList.add(record);
//					}
//				}
//			}
			
		
		System.out.println("第二步返回数据==="+reList.toString());
		return reList;
	}
	/**
	 * Create on 2015-4-17 
	 * @author: gengws
	 * @Title: queryMkActRecordTermiInfo 
	 * @Description: 查询mk_actrecordtermi_info中的信息
	 * @param keys
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private JSONObject queryMkActRecordTermiInfo(String[] keys){
		
		JSONObject jsons=null;//mk_actrecord_rel表中的信息
		
		String[] termiKeys=new String[keys.length];//mk_actrecordtermi_info表中的主键
		
		JSONObject termiInfo=null;
		
		if(!CommonUtil.isEmpty(keys)){
			try {
				
				jsons=cassandraDao.query_by_key("mk_actrecord_rel", keys);
				
				for(int i=0;i<keys.length;i++){
					JSONObject rel=(JSONObject) jsons.parse(jsons.getString(keys[i]));
					
					if(!CommonUtil.isEmpty(rel)){
						
						Set key=rel.keySet();
						for(Object rowkey:key){
							termiKeys[i]=(String) rowkey;
						}
					}
				}
				
				termiInfo=cassandraDao.query_by_key("mk_actrecordtermi_info", termiKeys);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return termiInfo;
	}
	
	/**
	 * Create on 2015-4-17 
	 * @author: gengws
	 * @Title: queryMkRecordList 
	 * @Description: 通过主表查询查询分表先查询mk_actrecord_rel
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private String[] queryMkRecordList(List list ){
		String[] keys=new String[list.size()];//存入mk_actrecord_rel的rowKey
		
		if(!CommonUtil.isEmpty(list)){
			for(int i=0;i<list.size();i++){
				Map record=(Map) list.get(i);
				String serilId=(String) record.get("SERIAL_NO");
				String key=serilId+Const.nosql_split+Const.mk_actRecordTermi_info;
				keys[i]=key;
			}
		}
		
		return keys;
		
	}
	
	/**
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: queryRowKey 
	 * @Description: 根据OLD_IMEI_NO查询表mk_indextoquery_idx获得mk_actrecordtermi_info的rowKey
	 * @param OLD_IMEI_NO
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private String queryRowKey(String OLD_IMEI_NO){
		String key=Const.imeiNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+OLD_IMEI_NO;
		
		JSONObject json = null;
		String rowKey=null;
		try {
			json=cassandraDao.query_by_key("mk_indextoquery_idx",key);
			
			JSONObject termi=(JSONObject) json.parse(json.getString(key));
			if(null!=json){
				Set set=termi.keySet();
				String columnValue=null;
				for(Object columnNameObj:set){
					rowKey =(String) columnNameObj;
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1","","");
		}
		return rowKey;
	}
	/**
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: updateIMEI_NO 
	 * @Description: 在mk_actrecordtermi_info表中的imei_no更新
	 * @param rowKey
	 * @param NEW_IMEI_NO 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private void updateIMEI_NO(String rowKey,String NEW_IMEI_NO){
		
		Map<String,Object> columns=new HashMap<String,Object>();
		columns.put("resource_no", NEW_IMEI_NO);
		cassandraDao.insertMultiCloumnByRowKey("mk_actrecordtermi_info", rowKey, columns);
	}
	
	/**
	 * 
	 * Create on 2015-4-6 
	 * @author: gengws
	 * @Title: updateIndex 
	 * @Description: 更新mk_indextoquery_idx
	 * @param rowKey
	 * @param NEW_INEI_NO 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private void updateIndex(String rowKey,String NEW_INEI_NO){
		
		Map<String,Object> columns=new HashMap<String,Object>();
		columns.put(rowKey,"");
		String index=Const.imeiNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+NEW_INEI_NO;
		cassandraDao.insertMultiCloumnByRowKey("mk_indextoquery_idx",index,columns);				
	}
	
	

	/**
     * 批量向MK_ACTRECORDTERMI_INFO表中插入相关数据
     * Create on 2014-11-26
     * @author hanzh_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	@Override
	public void insertBatchToActRecordTermi(Map<String, Map<String, Object>> termiRecordMap) {
		saveBatchTermiRecordToActRecordRel(termiRecordMap);
		insertTermiRecordIndexToQuery(termiRecordMap);
		insertTermiRecordIndexToQueryByIdNo(termiRecordMap);
		try{
			List list = new ArrayList();
			list.add(termiRecordMap);
			log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~list~~~~~~~~~~~~~~~~~~~~~~~~~~~"+list);
			cassandraDao.insertMultiCloumAndRows("mk_actrecordtermi_info", list);
		}catch(Exception e){
			e.printStackTrace();
			rollbackTermiRecordIndexToQuery(termiRecordMap);
			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","insertBatchToActRecordTermi");
		}
	}
	
	/**
     * 退订订购记录改变状态
     * Create on 2014-11-25
     * @author wenzt
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	@Override
	public void insertActRecordTermi(Map<String, String> datas, String recordId) {
		//批量保存rel,cassandra数据库特性
		try{
		cassandraDao.insertMultiCloumAndSingleRow("mk_actrecordtermi_info",recordId, datas);
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException("insertActRecordGift","亲,insertActRecordGift出异常了,到后台看看吧");
		}
	}
	
	/** 
	 * Create on 2015-7-10 
	 * @author: wenzt
	 * @Title: insertToActRecordProdTrac 
	 * @Description: 
	 * @param datas
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public boolean insertToActRecordTermiTrac(Map<String, Map<String,Object>> datas){
		try{
			List<Map<String, Map<String,Object>>> recordList = new ArrayList<Map<String, Map<String,Object>>>();
			recordList.add(datas);
			cassandraDao.insertMultiCloumAndRows("mk_actrecordtermi_trac",recordList);
			}catch(Exception e){
				e.printStackTrace();
				throw new BaseException("insertToActRecordTermiTrac","亲,insertToActRecordTermiTrac出异常了,到后台看看吧");
			}
		return true;
	}
	/** 
	 * Create on 2015-7-10 
	 * @author: wenzt
	 * @Title: queryActRecordTermiBySerialIds 
	 * @Description: 
	 * @param serialIds
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public JSONObject queryActRecordTermiBySerialIds(String serialId){
		JSONObject json = new JSONObject();
		try {
			json =  cassandraDao.query_by_key("mk_actrecordtermi_info", serialId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1", "根据主键查询订购记录终端表失败", "异常信息为：："+e);
		}
		return json;
	}

	/**
	 * 向索引表添加终端订购记录的索引
	 * ROWKEY      = 101|actrecordtermi|imei_no的值
	 * Column_name = serial_id,
	 * Column_value = actid|meansid|orderid|status_code;
	 * @param inParam
	 * @author hanzh_bj
	 * @param inParam
	 * @author hanzh_bj
	 */
	private void insertTermiRecordIndexToQuery(Map<String, Map<String, Object>> termiRecordMap){
		List<Map<String, Map<String, Object>>> idxlist = new ArrayList<Map<String, Map<String, Object>>>();
		for(String serialId : termiRecordMap.keySet()){
			Map<String, Object> record = termiRecordMap.get(serialId);
			String imeiNo     = (String) record.get("resource_no");
			String orderId    = (String) record.get("order_id");
			String actId      = (String) record.get("act_id");
			String meansId    = (String) record.get("means_id");
			String statusCode = (String) record.get("status_code");
			if(CommonUtil.isEmpty(imeiNo)){
				continue;
			}
			String key = Const.imeiNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+imeiNo;
			String columnValue = actId+Const.nosql_split+meansId+Const.nosql_split+orderId+Const.nosql_split+statusCode;
			Map<String, Object> datas = new HashMap<String, Object>();
			datas.put(serialId, columnValue);
			Map<String, Map<String, Object>> dataMap =new HashMap<String, Map<String, Object>>();
			dataMap.put(key, datas);
			idxlist.add(dataMap);
		}
		if(CommonUtil.isEmpty(idxlist)){
			return;
		}
		
		mkIndextoqueryIdx.insertBatchIndexToQuery(idxlist);
	}
	
	/**
	 * 向索引表添加终端订购记录的索引
	 * ROWKEY      = 101|actrecordtermi|id_no的值
	 * Column_name = serial_id,
	 * Column_value = actid|meansid|orderid|status_code|end_date;
	 * Create on 2015-8-15
	 * @author: durui
	 * @Ttile: insertTermiRecordIndexToQueryByIdNo
	 * @Description: 
	 * @param termiRecordMap
	 * @version: 1.0
	 * update_date:      update_author:        update_note:
	 */
	private void insertTermiRecordIndexToQueryByIdNo(Map<String, Map<String, Object>> termiRecordMap){
		List<Map<String, Map<String, Object>>> idxlist = new ArrayList<Map<String, Map<String, Object>>>();
		for(String serialId : termiRecordMap.keySet()){
			Map<String, Object> record = termiRecordMap.get(serialId);
			String idNo       = (String) record.get("id_no");
			String orderId    = (String) record.get("order_id");
			String actId      = (String) record.get("act_id");
			String meansId    = (String) record.get("means_id");
			String statusCode = (String) record.get("status_code");
			String endDate    = (String) record.get("end_date");
			if(CommonUtil.isEmpty(idNo)){
				continue;
			}
			String key = Const.idNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+idNo;
			String columnValue = actId+Const.nosql_split+meansId+Const.nosql_split+orderId+Const.nosql_split+statusCode+Const.nosql_split+endDate;
			Map<String, Object> datas = new HashMap<String, Object>();
			datas.put(serialId, columnValue);
			Map<String, Map<String, Object>> dataMap = new HashMap<String, Map<String, Object>>();
			dataMap.put(key, datas);
			idxlist.add(dataMap);
		}
		if(CommonUtil.isEmpty(idxlist)){
			return;
		}
		mkIndextoqueryIdx.insertBatchIndexToQuery(idxlist);
	}
	
	//新增订购记录主表与费用记录关联
	//ROWKEY      = 主表serial_id|tableid
	//COLUMN_NAME = 分表serial_id的值
	//COLUMN_VALUE 暂时不启用
	private void saveBatchTermiRecordToActRecordRel(Map<String, Map<String, Object>> feeRecordMap){
		Map<String, String> relMap = new  HashMap<String, String>();
		String orderNo ="";     					   //主表订购流水serial_id
		Set<String> serialIds = feeRecordMap.keySet(); //分表serial_id
		for(String serialId:serialIds){
			relMap.put(serialId, "");
			Map<String, Object> datas = feeRecordMap.get(serialId);
			orderNo = (String) datas.get("order_no");                        
		}
		if(CommonUtil.isEmpty(orderNo)){
			return;
		}
		//生成关系表主键
		String key = orderNo+Const.nosql_split+Const.mk_actRecordTermi_info; 
		mkActrecordRel.insertBatchActRecordRel(key,relMap);
	}
		
		
	/**
	 * 向索引表回退终端订购记录的索引
	 * ROWKEY      = 101|actrecordtermi|imei_no的值
	 * Column_name = serial_id,
	 * Column_value = actid|meansid|orderid|status_code;
	 * @param inParam
	 * @author hanzh_bj
	 * @param inParam
	 * @author hanzh_bj
	 */
	private void rollbackTermiRecordIndexToQuery(Map<String, Map<String, Object>> termiRecordMap){
		List<Map<String, Map<String, Object>>> indexInfo = new ArrayList<Map<String, Map<String, Object>>>();
		for(String serialId : termiRecordMap.keySet()){
			Map<String, Object> record = termiRecordMap.get(serialId);
			String imeiNo     = (String) record.get("resource_no");
			String orderId    = (String) record.get("order_id");
			String actId      = (String) record.get("act_id");
			String meansId    = (String) record.get("means_id");
			String key = Const.imeiNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+imeiNo;
			String columnValue = actId+Const.nosql_split+meansId+Const.nosql_split+orderId+Const.nosql_split+Const.failStatusCode;
			Map<String, Object> datas = new HashMap<String, Object>();
			datas.put(serialId, columnValue);
			Map<String, Map<String, Object>> dataMap =new HashMap<String, Map<String, Object>>();
			dataMap.put(key, datas);
			indexInfo.add(dataMap);
		}
		mkIndextoqueryIdx.insertBatchIndexToQuery(indexInfo);
	}

	//ROWKEY = 主表serial_id|tableid
	//COLUMN_NAME = 分表serial_id的值
	//COLUMN_VALUE 未启用
	private void saveBatchActRecordRel(Map<String, Map<String, Object>> termiRecordMap) {
		Map<String, String> relMap = new  HashMap<String, String>();
		String orderNo = "";
		for(String  serialId:termiRecordMap.keySet()){
			relMap.put(serialId, "");
			orderNo = (String) termiRecordMap.get(serialId).get("orderNo");
		}
		String key = orderNo+Const.nosql_split+Const.mk_actRecordTermi_info;
		mkActrecordRel.insertBatchActRecordRel(key,relMap);
   }
	
	public void setMkIndextoqueryIdx(IMkIndextoqueryIdx mkIndextoqueryIdx) {
		this.mkIndextoqueryIdx = mkIndextoqueryIdx;
	}

	public void setMkActrecordRel(IMkActrecordRel mkActrecordRel) {
		this.mkActrecordRel = mkActrecordRel;
	}


	/**
	 * Create on 2015-6-2
	 * @author:liuhaoa
	 * @Title: getActIMEIRecordList
	 * @Description: 终端IMEI使用信息查询
	 * @param inParam
	 * @return OutDTO
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	@Override
	public List getActIMEIRecordList(Map inMap) {
		Map dataMap = new HashMap();
		List dataList = new ArrayList();
		dataMap.put("PHONE_NO", "13604323332");
		dataMap.put("USER_ID", "10200083155147");
		dataMap.put("ATOM_NO", "1040602602");
		dataMap.put("IMEI_NO", "86749001");
		dataMap.put("DEAL_DATE", "2015-02-04 00:00:00");
		dataList.add(dataMap);
		return dataList;
	}

	/**
	 * Create on 2015-6-3
	 * @author:liuhaoa
	 * @Title: getAtomPhoneNoList
	 * @Description: 终端捆绑备用号码管理
	 * @param inParam
	 * @return OutDTO
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	@Override
	public List getAtomPhoneNoList(Map inMap) {
		Map pMap = new HashMap();
		List dataList = new ArrayList();
		pMap.put("USER_NAME", "g**");
		pMap.put("PHONE_NO", "13844827463");
		pMap.put("PHONE_CNO", "123456784000873");
		pMap.put("BPHONE_NO", "15904426335");
		pMap.put("DEAL_DATE", "2013-06-20 17:13:16");
		dataList.add(pMap);
		return dataList;
	}

	/**
	 * @author: liuhaoa
	 * @Title: getAtomUnIMEIList 
	 * @Description:终端取消捆绑IMEI登记
	 * @return 
	 * @version 1.0 
	 * date:2015-6-4
	 */
	@Override
	public List getAtomUnIMEIList(Map inMap) {
		List list = new ArrayList();
		Map pMap = new HashMap();
		pMap.put("TWO_PHONE_NO", "");										//2号卡号码
		pMap.put("TWO_USER_ID", "");										//2号卡用户ID
		pMap.put("IMEI_NO", "359817008421020");								//IMEI号
		pMap.put("TYPE_NO", "三星-I9308");									//型号
		pMap.put("DEAL_MONTHS", "18");										//绑定月数
		pMap.put("CONTACT_ID", "21305150452");								//流水
		pMap.put("GIVE_MONTHS", "");										//赠送月数
		pMap.put("EARCH_GIVE_MONEY", "");									//每月赠送金额
		pMap.put("GIVE_MONEYS", "");										//已赠送金额
		pMap.put("GIVE_END_DATE", "2018-06-20 00:00:00");					//赠送结束日期
		pMap.put("EARCH_MONTH_COUNT", "");									//分月存入月数
		pMap.put("EARCH_MONTH_MONEY", "0");									//每月存入金额
		pMap.put("GIVE_MONTH_MONEY", "0");									//已经存入金额
		pMap.put("GIVE_MONEY_END_DATE", "2018-05-20 00:00:00");				//存入结束日期
		list.add(pMap);
		return list;
	}

	/**
	 * @author: liuhaoa
	 * @Title: getAtomIMEISyList 
	 * @Description:终端IMEI捆绑顺延登记
	 * @return 
	 * @version 1.0 
	 * date:2015-6-4
	 */
	@Override
	public List getAtomIMEISyList(Map inMap) {
		List list = new ArrayList();
		Map pMap = new HashMap();
		pMap.put("TWO_PHONE_NO", "13504307217");							//2号卡号码
		pMap.put("TWO_USER_ID", "10113504307217");							//2号卡用户ID
		pMap.put("IMEI_NO", "860024008229386");								//IMEI号
		pMap.put("TYPE_NO", "DOPOD-S700-T");								//型号
		pMap.put("DEAL_MONTHS", "12");										//绑定月数
		pMap.put("CONTACT_ID", "6507622945");								//流水
		pMap.put("GIVE_MONTHS", "");										//赠送月数
		pMap.put("EARCH_GIVE_MONEY", "");									//每月赠送金额
		pMap.put("GIVE_MONEYS", "100");										//已赠送金额
		pMap.put("GIVE_END_DATE", "2018-06-20 00:00:00");					//赠送结束日期
		pMap.put("EARCH_MONTH_COUNT", "36");								//分月存入月数
		pMap.put("EARCH_MONTH_MONEY", "10");								//每月存入金额
		pMap.put("GIVE_MONTH_MONEY", "60");									//已经存入金额
		pMap.put("GIVE_MONEY_END_DATE", "2018-05-20 00:00:00");				//存入结束日期
		list.add(pMap);
		return list;
	}

	/**
	 * @author: liuhaoa
	 * @Title: getAtomIMEIUnSyList 
	 * @Description:终端IMEI捆绑顺延登记取消
	 * @return 
	 * @version 1.0 
	 * date:2015-6-4
	 */
	@Override
	public List getAtomIMEIUnSyList(Map inMap) {
		List dataList = new ArrayList();
		Map pMap = new HashMap();
		pMap.put("IMEI_NO", "356754042956336");			//IMEI号
		pMap.put("TYPE_NO", "三星-S5820");				//型号
		pMap.put("LOGIN_NO", "aa021A");					//操作工号
		pMap.put("DEAL_DATE", "20140611 19:13:00");		//登记时间
		pMap.put("CONTACT_ID", "11676987836");			//流水
		dataList.add(pMap);
		return dataList;
	}



	/**
	 * Create on 2015-6-18 
	 * @author: gengws
	 * @Title: getTermiRecordByIdNo 
	 * @Description: 通过ID_NO去查询mk_indextoquery_idx,mk_actrecordtermi_info
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List getTermiRecordByIdNo(Map inMap) {
		
		List reList=new ArrayList();
//		//拼接索引表rowKey先查询索引表进行筛选
//		String idNo=(String) inMap.get("idNo");
//		String idx=Const.idNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+idNo;
		
		List rowKeys=(List) inMap.get("rowKeys");
		log.info("终端订购记录表rowkeys="+rowKeys.toString());
		if(CommonUtil.isNotEmpty(rowKeys)){
			reList=getTermiRecords(rowKeys);
		}else{
			throw new BaseException("-1","终端订购记录表没有查到数据入表异常");
		}
		
		return reList;
	}
	
	/**
	 * Create on 2015-6-19 
	 * @author: gengws
	 * @Title: getTermiRecords 
	 * @Description: 查询mk_actrecordtermi_info,订购记录分表
	 * @param rowkeys
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List getTermiRecords(List rowkeys){
		List reList=new ArrayList();
		String[] keys=new String[rowkeys.size()];
		for(int i=0;i<rowkeys.size();i++){
			keys[i]=(String) rowkeys.get(i);
		}
		JSONObject jsons=null;
		try {
			jsons=cassandraDao.query_by_key("mk_actrecordtermi_info", keys);
			for(int i=0;i<keys.length;i++){
				JSONObject json=(JSONObject) jsons.parse(jsons.getString(keys[i]));
				log.info(i+"=json"+json.toString());
				Map record=new HashMap();
				Set set=json.keySet();
				
				for(Object colnum:set){
					record.put(colnum, json.get(colnum));
				}
				
				log.info("record=="+record.toString());
				reList.add(record);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reList;
	}
	/**
	 * Create on 2015-6-19 
	 * @author: gengws
	 * @Title: getTermiRecords 
	 * @Description: 查询索引表通过，并进行筛选
	 * @param rowKey
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List getIndexToQuery(String rowKey){
		List list=new ArrayList();
		JSONObject jsons=null;
		
		try {
			jsons=cassandraDao.query_by_key("mk_indextoquery_idx", rowKey);
			JSONObject json=jsons.getJSONObject(rowKey);
			Set set=json.keySet();
			for(Object key:set){
				list.add(key);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return list;
	}


	/**
	 * Create on 2015-7-17 
	 * @author: liuhaoa
	 * @Title: selectMkActrecordRel 
	 * @Description: 根据key查询MkActrecordtermiInfo成本终端分表
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject selectMkActrecordtermiInfo(String[] keys) {
		JSONObject json = null;
		try{
			json = cassandraDao.query_by_key("mk_actrecordtermi_info", keys);
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 获得终端订购记录表
	 * @Create on 2015-7-15 
	 * @author: wangdw
	 * @Title: getActRecordTermList 
	 * @Description: 
	 * @param termKeys
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public List<Map> getActRecordTermList(String[] termKeys) {
		List<Map> termList = new ArrayList<Map>();
		
		try {
			JSONObject termJsons=cassandraDao.query_by_key("mk_actrecordtermi_info", termKeys);
			log.info("===========getActRecordTermList.termJsons"+termJsons);
			if (CommonUtil.isNotEmpty(termJsons)){
				for(int i = 0; i < termKeys.length; i++){
					Map termMap = new HashMap();
					termMap.put("term_key", termKeys[i]);
					JSONObject termJson = (JSONObject)termJsons.parse(termJsons.getString(termKeys[i]));
					log.info("======termJson:"+termJson);
					
					if (CommonUtil.isNotEmpty(termJson)) {
						Set termSet = termJson.keySet();
						Iterator termIt = termSet.iterator();
						while (termIt.hasNext()) {
							String name = (String)termIt.next();
							String value = (String)termJson.get(name);
							termMap.put(name, value);
						}
					}
					termList.add(termMap);
				}
			}
		} catch (Exception e) {
			throw new BusiException("-1", "查询终端订购记录表失败" , "查询mk_actrecordterm_info失败，" + e);
		}
		
		termList = (List)ParamUtil.parseHump2Capital(termList);
		return termList;
	}



	/**
	 * Create on 2015-7-17 
	 * @author: gengws
	 * @Title: getActRecordTermiByImeiNo
	 * @Description: 根据IMEI_NO查询订购记录
	 * @param  
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject getActRecordTermiByImeiNo(String imeiNo) {
		
		List reList=new ArrayList();
		JSONObject termiRecordJson=null;//mk_actrecordtermi_info内容
		String rowKey=Const.imeiNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+imeiNo;
		try {
			log.info("ROKWEY==="+rowKey);
			JSONObject indexJson=cassandraDao.query_by_key("mk_indextoquery_idx", rowKey);
			if(CommonUtil.isEmpty(indexJson)){
				throw new BusiException("-1", imeiNo+"查询不到订购记录" , imeiNo+"查询不到订购记录");
			}else{
				log.info("indexJson==="+indexJson.toString());
				JSONObject json=(JSONObject) indexJson.get(rowKey);
				
				Set keySet=json.keySet();
				String[] keys=new String[keySet.size()];
				int i=0;
				for(Object key:keySet){
					keys[i]=(String) key;
					i++;
				}
				termiRecordJson=cassandraDao.query_by_key("mk_actrecordtermi_info", keys);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return termiRecordJson;
	}
	
	
	@Override
	public void updateMkActrecordtermiInfo(Map<String, String> map) {
		
		String OLD_IMEI_NO=map.get("OLD_IMEI_NO");//获得旧号码
		
		String rowKey=queryKey(OLD_IMEI_NO);//根据旧号码查询mk_actrecordtermi_info的rowKey
		
		if(rowKey.isEmpty()){//判断OLD_IMEI_NO能否查出mk_actrecordtermi_info的rowKey
			
			log.info("OLD_IMEI_NO查找不存在");
			
		}else{
			
			 updateIMEI_NO(rowKey,map.get("NEW_IMEI_NO"));//更新imei_no在mk_actrecordtermi_info表中
			 updateIndex(rowKey,map.get("NEW_IMEI_NO"));//新建索引在mk_indextoquery_idx
		}
	}

	/**
	 * gws 2015-03-03
	 * 根据就IMEI_NO查询rowKey
	 * @param OLD_IMEI_NO
	 * @return rowKey
	 */
	private String queryKey(String OLD_IMEI_NO){
		
		String key=Const.imeiNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+OLD_IMEI_NO;//拼接查询的rowKey
		
		JSONObject json = null;
		String rowKey=null;
		try {
			json=cassandraDao.query_by_key("mk_indextoquery_idx",key);
			if(null!=json){
				Set set=json.keySet();
				String columnValue=null;
				for(Object columnNameObj:set){
					String  columnName = (String) columnNameObj;
					columnValue = json.getString(columnName);
				}
				if(columnValue.isEmpty()){
					return null;
				}
				else{
					String[] keys=columnValue.split("\"");
					if(keys.length>2){
						rowKey=keys[1];
					}
				}
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowKey;
	}

	/**
	 * Create on 2015-7-27 
	 * @author: zhaoyue
	 * @Title: queryActrecordTermiInfoByIdNo 
	 * @Description: 根据idNO查询mk_actrecordtermi_info数据
	 * @param idNo
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryActrecordTermiInfoByIdNo(String idNo) {
		String key=Const.idNoFlag+Const.nosql_split+Const.mk_actRecordTermi_info+Const.nosql_split+idNo;//拼接mk_indextoquery_idx的rowKey
		String[] rowKeys=getActRecordTermiRowKeys1(key);//查询mk_actrecordtermi_info所包含的rowKeys
		List records=getActRecordsTermiByIdNos(rowKeys);//查询mk_actrecord_info中的信息
		return records;
	}
	/**
	 * Create on 2015-7-27 
	 * @author:zhaoyue
	 * @Title: getActRecordTermiRowKeys 
	 * @Description: 查询mk_actrecordtermi_info所包含的rowKeys
	 * @param rowKey
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
    private String[] getActRecordTermiRowKeys(String rowKey){
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
    
    private String[] getActRecordTermiRowKeys1(String rowKey){
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
				String str = records.getString(columnName);
				if(CommonUtil.isNotEmpty(str)){
					String [] str1 = str.split("\\|");
					String status = str1[3];
					if(!status.equals("01")&&!status.equals("04")){
						rowKeys[i]=columnName;
						i++;
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rowKeys;
	}
    
    
	/**
	 * Create on 2015-7-27 
	 * @author:zhaoyue
	 * @Title: getActRecordsTermiByIdNos 
	 * @Description: 查询mk_actrecordtermi_info数据
	 * @param rowKeys
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List getActRecordsTermiByIdNos(String[] rowKeys){
		
		JSONObject jsons = null;
		List records=new ArrayList();
		try{
			jsons=cassandraDao.query_by_key("mk_actrecordtermi_info", rowKeys);
			for(int i=0;i<rowKeys.length;i++){
				JSONObject record=(JSONObject) jsons.parse(jsons.getString(rowKeys[i]));
				if(!record.isEmpty()){
					records.add(record);
				}
			}
			log.debug("mk_actrecord_info所有信息："+records.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return records;
	}
}
