package com.sitech.market.dbo.contact.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.contact.inter.IMkPhoneInfo;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;

/**
 * create on 2014-11-05
 * @author sunliang
 */
public class MkPhoneInfo extends DBNosqlClass implements IMkPhoneInfo {
	/**
	 * create on 2014-11-05
	 * @author sunliang
	 */
	public String getIdNoByPhoneNo(String phoneNo){
		String idNo = null;
		JSONObject userInfoJson = null;
      	try {
      		userInfoJson = cassandraDao.query_by_key("mk_phone_info",phoneNo);
      		System.out.println("phoneNo======"+phoneNo);
      		JSONObject resObj=(JSONObject) JSONObject.parse(userInfoJson.getString(phoneNo));
      		System.out.println("resObj======"+resObj);
      		Set<String> set = resObj.keySet();
      		if(null == set || set.size() < 1 ){
      			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr);
      			throw new BusiException(returnCode,"亲,没有查询到"+phoneNo+"的ID_NO!","MkPhoneInfo.getIdNoByPhoneNo错误");
      		}
      		idNo =resObj.getString("id_no");
      		log.debug("idNo=" + idNo);
  		} catch (Exception e) {
  			e.printStackTrace();
  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
  			throw new BusiException(returnCode,"亲,查询用户ID出问题了!","MkPhoneInfo.getIdNoByPhoneNo错误");
  		}
  		return idNo;
	}
	
	
	public List<String> getIdNoByPhoneNos(List<String> phoneList){
		if(CommonUtil.isEmpty(phoneList)){
			throw new BusiException("-1","没有输入任何手机号","phoneList = "+phoneList);
		}
		
		String[] phoneNos = new String[phoneList.size()];
		
		phoneNos = phoneList.toArray(phoneNos);
		
		List<String> idNos = new ArrayList<String>() ;
		try {
			JSONObject resMap = cassandraDao.query_by_key("mk_phone_info", phoneNos);
			for(String phoneNo :phoneList){
				JSONObject resObj=(JSONObject) JSONObject.parse(resMap.getString(phoneNo));
				System.out.println("resObj======"+resObj);
	      		Set<String> set = resObj.keySet();
	      		if(null == set || set.size() < 1 ){
	      			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr);
	      			throw new BusiException(returnCode,"亲,没有查询到"+phoneNo+"的ID_NO!","MkPhoneInfo.getIdNoByPhoneNo错误");
	      		}
	      		String idNo =resObj.getString("id_no");
	      		log.debug("idNo=" + idNo);
	      		idNos.add(idNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
  			throw new BusiException(returnCode,"亲,查询用户ID出问题了!","MkPhoneInfo.getIdNoByPhoneNo错误");
		}
		return idNos;
	}


	/**
	 * @Description:根据phoneNo服务号码查询信息
	 * create on 2015-7-19
	 * @Title:selectMkPhoneInfoByPhoneNo
	 * @param phoneNo
	 * @return
	 */
	@Override
	public JSONObject selectMkPhoneInfoByPhoneNo(String phoneNo) {
		JSONObject json = null;
		try{
			json = cassandraDao.query_by_key("mk_phone_info", phoneNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * @Description:根据phoneNo服务号码查询信息
	 * create on 2015-7-19
	 * @Title:selectMkPhoneInfoByPhoneNo
	 * @param phoneNo
	 * @return
	 */
	@Override
	public JSONObject selectMkPhoneInfoByIdNo(String IdNo) {
		JSONObject json = null;
		try{
			json = cassandraDao.query_by_idx("mk_phone_info", "id_no:"+IdNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}
	/**
	 * 根据电话号集合，查询idNo集合
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: getIdNosByPhoneNos 
	 * @Description: 
	 * @param phoneList
	 * @return Map<String, String>类型，其中：key=phoneNo，value=idNo。
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public Map<String, String> getIdNosByPhoneNos(List<String> phoneList){
		if(CommonUtil.isEmpty(phoneList)){
			throw new BusiException("-1","没有输入任何手机号","phoneList = "+phoneList);
		}
		Map<String, String> idNos = new HashMap<String, String>() ;
		String[] phoneNos = new String[phoneList.size()];
		phoneNos = phoneList.toArray(phoneNos);
		
		try {
			JSONObject resMap = cassandraDao.query_by_key("mk_phone_info", phoneNos);
			for(String phoneNo :phoneList){
				JSONObject resObj=(JSONObject) JSONObject.parse(resMap.getString(phoneNo));
				//System.out.println("resObj======"+resObj);
				String idNo = null;
	      		Set<String> set = resObj.keySet();
	      		if(CommonUtil.isNotEmpty(set)){
	      			idNo = resObj.getString("id_no");
	      		}
	      		idNos.put(phoneNo, idNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
  			throw new BusiException(returnCode,"亲,查询用户ID出问题了!","MkPhoneInfo.getIdNoByPhoneNo错误");
		}
		return idNos;
	}
	
	/**
	 * 查询idNos，查询不出不报异常
	 * @Create on 2015-7-29 
	 * @author: wangdw
	 * @Title: getIdNosWithNoExp 
	 * @Description: 
	 * @param phoneList
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public List<String> getIdNosWithNoExp(List<String> phoneList){
		if(CommonUtil.isEmpty(phoneList)){
			throw new BusiException("-1","没有输入任何手机号","phoneList = "+phoneList);
		}
		
		String[] phoneNos = new String[phoneList.size()];
		
		phoneNos = phoneList.toArray(phoneNos);
		
		List<String> idNos = new ArrayList<String>() ;
		
		
		if(phoneList.size() > 5000)
		{
			int size = 0;
			if(phoneList.size()%5000 == 0)
			{
				size = phoneList.size()/5000;
			}else
			{
				size = phoneList.size()/5000 +1;
			}
			List<String> phone_list = new ArrayList();
			for(int i  = 0 ; i < size ; i++)
			{
				if(i ==(size-1))
				{
					phone_list = phoneList.subList(i*5000, phoneList.size());
					String[] phone_nos = new String[phone_list.size()];
					phone_nos = phone_list.toArray(phone_nos);
					try {
						JSONObject resMap = cassandraDao.query_by_key("mk_phone_info", phone_nos);
						for(String phoneNo :phone_list){
							JSONObject resObj=(JSONObject) JSONObject.parse(resMap.getString(phoneNo));
							//System.out.println("resObj======"+resObj);
				      		Set<String> set = resObj.keySet();
				      		String idNo = null;
				      		if(CommonUtil.isNotEmpty(set)){
				      			idNo = resObj.getString("id_no");
				      		}
				      		//log.debug("idNo=" + idNo);
				      		idNos.add(idNo);
						}
					} catch (Exception e) {
						e.printStackTrace();
			  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			  			throw new BusiException(returnCode,"亲,查询用户ID出问题了!","MkPhoneInfo.getIdNoByPhoneNo错误");
			  			
					}
				}else
				{
					phone_list = phoneList.subList(i*5000, (i+1)*5000-1);
					String[] phone_nos = new String[phone_list.size()];
					phone_nos = phone_list.toArray(phone_nos);
					try {
						JSONObject resMap = cassandraDao.query_by_key("mk_phone_info", phone_nos);
						for(String phoneNo :phone_list){
							JSONObject resObj=(JSONObject) JSONObject.parse(resMap.getString(phoneNo));
							//System.out.println("resObj======"+resObj);
				      		Set<String> set = resObj.keySet();
				      		String idNo = null;
				      		if(CommonUtil.isNotEmpty(set)){
				      			idNo = resObj.getString("id_no");
				      		}
				      		//log.debug("idNo=" + idNo);
				      		idNos.add(idNo);
						}
					} catch (Exception e) {
						e.printStackTrace();
			  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			  			throw new BusiException(returnCode,"亲,查询用户ID出问题了!","MkPhoneInfo.getIdNoByPhoneNo错误");
					}
				}
				
			}
		}else
		{
			try {
				JSONObject resMap = cassandraDao.query_by_key("mk_phone_info", phoneNos);
				for(String phoneNo :phoneList){
					JSONObject resObj=(JSONObject) JSONObject.parse(resMap.getString(phoneNo));
					//System.out.println("resObj======"+resObj);
		      		Set<String> set = resObj.keySet();
		      		String idNo = null;
		      		if(CommonUtil.isNotEmpty(set)){
		      			idNo = resObj.getString("id_no");
		      		}
		      		//log.debug("idNo=" + idNo);
		      		idNos.add(idNo);
				}
			} catch (Exception e) {
				e.printStackTrace();
	  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
	  			throw new BusiException(returnCode,"亲,查询用户ID出问题了!","MkPhoneInfo.getIdNoByPhoneNo错误");
			}
		}

		return idNos;
	}
	
	
	public void insertMkPhoneInfo(String phone,String id_no)
	{
		Map date = new HashMap();
		date.put("id_no", id_no);
		cassandraDao.insertMultiCloumnByRowKey("mk_phone_info",phone ,date);
	}
	
	public void deleteMkPhoneInfo(String phone)
	{
		String[] keys = new String[1];
		keys[0] = phone;
		String[] columnNames = new String[1];
		columnNames[0] = "id_no";
		cassandraDao.deleteMultiByColumnAndKeys("mk_phone_info", keys, columnNames);
	}
	
	
}
