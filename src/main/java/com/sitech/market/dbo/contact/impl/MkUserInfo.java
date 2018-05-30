package com.sitech.market.dbo.contact.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.contact.inter.IMkUserInfo;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;

public class MkUserInfo  extends DBNosqlClass implements IMkUserInfo {

	@Override
	public String getMasterSvcIdByIdNo(String idNo) {
		JSONObject userInfoJson = null;
		String mainSvcId ="";
      	try {
      		userInfoJson = cassandraDao.query_by_key("mk_user_info",idNo);
      		System.out.println("idNo======"+idNo);
      		System.out.println(userInfoJson);
      		JSONObject resObj=(JSONObject) JSONObject.parse(userInfoJson.getString(idNo));
      		System.out.println("resObj======"+resObj);
      		Set<String> set = resObj.keySet();
      		if(null == set || set.size() < 1 ){
      			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr);
      			throw new BusiException(returnCode,"亲,没有查询到"+idNo+"的userInfo!","MkUserInfo.getUserInfoByIdNo错误");
      		}
      		mainSvcId =resObj.getString("master_serv_id");
      		log.debug("mainSvcId=" + mainSvcId);
  		} catch (Exception e) {
  			e.printStackTrace();
  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
  			throw new BusiException(returnCode,"亲,查询用户userInfo出问题了!","MkUserInfo.getUserInfoByIdNo错误");
  		}
  		return mainSvcId;
	}
	
	
	@Override
	public String geGroupIdByIdNo(String idNo) {
		JSONObject userInfoJson = null;
		String groupId ="";
      	try {
      		userInfoJson = cassandraDao.query_by_key("mk_user_info",idNo);
      		System.out.println("geGroupIdByIdNo.idNo======"+idNo);
      		
      		JSONObject resObj=(JSONObject) JSONObject.parse(userInfoJson.getString(idNo));
      		System.out.println("geGroupIdByIdNo.resObj======"+resObj);
      		Set<String> set = resObj.keySet();
      		if(null == set || set.size() < 1 ){
      			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr);
      			throw new BusiException(returnCode,"亲,没有查询到"+idNo+"的userInfo!","MkUserInfo.getUserInfoByIdNo错误");
      		}
      		groupId =resObj.getString("group_id");
      		log.debug("geGroupIdByIdNo.groupId=" + groupId);
  		} catch (Exception e) {
  			e.printStackTrace();
  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
  			throw new BusiException(returnCode,"亲,查询用户userInfo出问题了!","MkUserInfo.getUserInfoByIdNo错误");
  		}
  		return groupId;
	}


	/**
	 * Create on 2015-4-18 
	 * @author: gengws
	 * @Title: queryMkUserInfo 
	 * @Description: 根据idNo查询mk_user_info
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryMkUserInfo(List list) {
		
		String[] keys=getMkUserInfoRowKeys(list);//获得mk_user_info的rowkey集合
		
		JSONObject mkUserInfo=queryMkUserInfo(keys);//查询mk_user_info表中的信息
		
		List record=getActRecord(list,mkUserInfo);//活动订购记录
		
		return record;
	}
	
	/////////////////////////////////////////
	//私有方法
	
	/**
	 * Create on 2015-4-18 
	 * @author: gengws
	 * @Title: getActRecord 
	 * @Description: 活动订购记录
	 * @param list
	 * @param json
	 * @return 
	 * @version 1.0 
	 * update_date:20150730       update_author:wangdw       update_note:多加了两个返回值，RUN_CODE和PHONE_NO
	 */
	private List getActRecord(List list,JSONObject json){
		
		List records=new ArrayList();
		
		if(CommonUtil.isNotEmpty(list)&&CommonUtil.isNotEmpty(json)){
			
			for(int i=0;i<list.size();i++){
				Map record=(Map) list.get(i);
				String idNo=(String) record.get("ID_NO");
				System.out.println("***********getActRecord.idNo:"+idNo+"******************************");
				JSONObject user=(JSONObject) json.parse(json.getString(idNo));
				if(CommonUtil.isNotEmpty(user)){
					record.put("brandId",  user.getString("brand_id"));
					record.put("RUN_CODE", user.getString("run_code"));
					record.put("PHONE_NO", user.getString("phone_no"));
					record.put("CUST_ID",  user.get("cust_id"));
				}
				records.add(record);
			}
		}
		else{
			return list;
		}
		
		
		return records;
	}
	
	/**
	 * Create on 2015-4-18 
	 * @author: gengws
	 * @Title: queryMkUserInfo 
	 * @Description: 查询mk_user_info表中的信息
	 * @param keys
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private JSONObject queryMkUserInfo(String[] keys){
		
		JSONObject json=null;
		
		try {
			json=cassandraDao.query_by_key("mk_user_info", keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}

	/**
	 * Create on 2015-4-18 
	 * @author: gengws
	 * @Title: getMkUserInfoRowKeys 
	 * @Description: 获得mk_user_info的rowkey集合
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private String[] getMkUserInfoRowKeys(List list){
		
		String[] keys=new String[list.size()];
		
		for(int i=0;i<list.size();i++){
			Map map=(Map) list.get(i);
			String idNo=(String) map.get("ID_NO");
			keys[i]=idNo;
			
		}
		
		
		return keys;
	}

	/** 
	 * Create on 2015-6-23 
	 * @author: songxj
	 * @Title: getMkUserInfo 
	 * @Description: 根据idNos查询mk_user_info,当表中没有id_no时,报异常
	 * @param idNos
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public JSONObject getMkUserInfo(String[] idNos) {
		JSONObject jsons = new JSONObject();
		try {
			if (null != idNos && idNos.length > 0) {
				jsons = cassandraDao.query_by_key("mk_user_info", idNos);
				if (!(cassandraDao.checkJsonForKeys(jsons, idNos))) {
					throw new BusiException("-1", "亲,查询mk_user_info获取run_code失败,表中没有该id_no!!!", "亲,请到后台看看吧!!!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("-1", "亲,查询mk_user_info获取run_code失败!!!", "亲,请到后台看看吧!!!");
		}
		return jsons;
	}

	/**
	 * Create on 2015-7-8 
	 * @author: zhaoyue
	 * @Title: getUserInfo 
	 * @Description: 根据idNO查询用户信息
	 * @param idNo
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject getUserInfo(Map map) {
		JSONObject userInfoJson = null;
		String idNo = (String)map.get("ID_NO");
      	try {
      		userInfoJson = cassandraDao.query_by_key("mk_user_info",idNo);
      		System.out.println("geGroupIdByIdNo.idNo======"+idNo);
      		
  		} catch (Exception e) {
  			e.printStackTrace();
  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
  			throw new BusiException(returnCode,"亲,查询用户userInfo出问题了!","MkUserInfo.getUserInfoByIdNo错误");
  		}
		return userInfoJson;
	}
	
	/** 
	 * Create on 2015-7-14 
	 * @author: songxj
	 * @Title: insertMkUserInfo 
	 * @Description: 插入mk_user_info
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	@Override
	public void insertMkUserInfo(String idNo, Map data) {
		if (CommonUtil.isNotEmpty(idNo)) {
			try {
				cassandraDao.insertMultiCloumnByRowKey("mk_user_info", idNo, data);
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusiException("-1", "亲,插入mk_user_info表出错啦!!!", "亲,请到后台看看吧!!!");
			}
		} else {
			throw new BusiException("-1", "亲,插入mk_user_info表ID_NO不能为空!!!", "亲,请到后台看看吧!!!");
		}
	}
	
	
	public void deleteMkUserInfo(String idNo)
	{
		String[] keys = new String[1];
		keys[0] = idNo;
		String[] columnNames = new String[13];
		columnNames[0] = "phone_no";
		columnNames[1] = "cust_id";
		columnNames[2] = "brand_id";
		columnNames[3] = "master_serv_id";
		columnNames[4] = "run_code";
		columnNames[5] = "contract_no";
		columnNames[6] = "credit_code";
		columnNames[7] = "big_flag";
		columnNames[8] = "credit_class";
		columnNames[9] = "group_id";
		columnNames[10] = "open_time";
		columnNames[11] = "op_code";
		columnNames[12] = "op_time";
		cassandraDao.deleteMultiByColumnAndKeys("mk_user_info", keys, columnNames);
	}
	/**
	 * 根据idNo集合，查询用户信息
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: queryUsersByIdNos 
	 * @Description: 
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public List<Map> queryUsersByIdNos(List<String> list) {
		String[] keys = new String[list.size()];
		keys = list.toArray(keys);
		List<Map> userInfos = new ArrayList<Map>();
		if(list.size() > 5000)
		{
			int size = 0;
			if(list.size()%5000 == 0)
			{
				size = list.size()/5000;
			}else
			{
				size = list.size()/5000 +1;
			}
			List<String> key_list = new ArrayList();
			for(int i  = 0 ; i < size ; i++)
			{
				if(i ==(size-1))
				{
					key_list = list.subList(i*5000, list.size());
					String[] key_temp = new String[key_list.size()];
					key_temp = key_list.toArray(key_temp);
					JSONObject mkUserInfo = queryMkUserInfo(key_temp);//查询mk_user_info表中的信息
					List<Map> ls = getUserInfos(key_list,mkUserInfo);//用户信息集合
					userInfos.addAll(ls);
				}else
				{
					key_list = list.subList(i*5000, (i+1)*5000-1);
					String[] key_temp = new String[key_list.size()];
					key_temp = key_list.toArray(key_temp);
					JSONObject mkUserInfo = queryMkUserInfo(key_temp);//查询mk_user_info表中的信息
					List<Map> ls = getUserInfos(key_list,mkUserInfo);//用户信息集合
					userInfos.addAll(ls);
				}
			}
			
		}else
		{
			JSONObject mkUserInfo = queryMkUserInfo(keys);//查询mk_user_info表中的信息
			List<Map> ls = getUserInfos(list,mkUserInfo);//用户信息集合
			userInfos.addAll(ls);
		}
		
		
		
		
		
		
		return userInfos;
	}
	
	/**
	 * 根据idNo集合获得idNo数组
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: getIdNosArr 
	 * @Description: 
	 * @param idNos
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	private String[] getIdNosArr(List<String> idNos) {
		int size = idNos.size();
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			arr[i] = idNos.get(i);
		}
		return arr;
	}
	/**
	 * 获得mk_user_info用户信息
	 * @Create on 2015-7-30 
	 * @author: wangdw
	 * @Title: getUserInfos 
	 * @Description: 
	 * @param list
	 * @param json
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	private List getUserInfos(List list,JSONObject json){
		List userInfos = new ArrayList();
		
		if(CommonUtil.isNotEmpty(list)&&CommonUtil.isNotEmpty(json)){
			for(int i=0;i<list.size();i++){
				String idNo=(String) list.get(i);
				JSONObject user=(JSONObject) json.parse(json.getString(idNo));
				if(CommonUtil.isNotEmpty(user)){
					Map userInfo = new HashMap();
					
					userInfo.put("ID_NO", 	 idNo);
					userInfo.put("BRAND_ID", user.getString("brand_id"));
					userInfo.put("RUN_CODE", user.getString("run_code"));
					userInfo.put("PHONE_NO", user.getString("phone_no"));
					
					userInfos.add(userInfo);
				}
			}
		}
		
		return userInfos;
	}
}
