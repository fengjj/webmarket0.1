package com.sitech.market.dbo.trading.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BusiException;
import com.sitech.jcfx.util.CodecUtil;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkCustInfo;
import com.sitech.util.CommonUtil;
import com.sitech.util.Const;
import com.alibaba.fastjson.JSONObject;

/**
 * Create on 2015-4-18 
 * @author: gengws
 * @Title: MkCustInfo 
 * @Description： 营销客户标签表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkCustInfo extends DBNosqlClass implements IMkCustInfo {

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
	@Override
	public List queryMkCustInfoByCustIds(List list) {
		log.info("mk_cust_info"+list.toString());
		
		//System.out.println("==001=mk_cust_info======"+list.toString());
		String[] keys=getMkCustInfoRowKeys(list);//得到mk_cust_info的rowkey集合
		System.out.println("==002=mk_cust_info======"+keys[0]);
		JSONObject mkCustInfo=queryMkCustInfo(keys);//查询mk_cust_info表中信息
		
		List records=getActRecord(list,mkCustInfo);//拼接订购记录信息
		
		return records;
	}
	
	/////////////////////////////////////////////
	//私有方法
	
	/**
	 * Create on 2015-4-18 
	 * @author: gengws
	 * @Title: getActRecord 
	 * @Description: 获得订购记录信息
	 * @param list
	 * @param json
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private List getActRecord(List list,JSONObject json){
		
		List records=new ArrayList();
		
		if(CommonUtil.isNotEmpty(list)&&CommonUtil.isNotEmpty(json)){
			
			for(int i=0;i<list.size();i++){
				
				Map record=(Map) list.get(i);
				String custId=(String) record.get("CUST_ID");
				
				JSONObject cust=(JSONObject) json.parse(json.getString(custId));
				if(CommonUtil.isNotEmpty(cust)){
					String custName = (String)cust.getString("cust_name");
					try {
						String decodeStr = new String(CodecUtil.decodeBASE64(custName.substring(2, custName.length())), "GBK");
						record.put("CUST_NAME", decodeStr);	
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
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
	 * @Title: queryMkCustInfo 
	 * @Description: 查询mk_cust_info表中信息
	 * @param keys
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private JSONObject queryMkCustInfo(String[] keys){
		
		JSONObject mkCustInfo=null;
		try {
			mkCustInfo=cassandraDao.query_by_key("mk_cust_info", keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mkCustInfo;
	}
	
	/**
	 * Create on 2015-4-18 
	 * @author: gengws
	 * @Title: getMkCustInfoRowKeys 
	 * @Description: 得到mk_cust_info的rowkey集合
	 * @param list
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	private String[] getMkCustInfoRowKeys(List list){
		System.out.println("==003=mk_cust_info======"+list);
		System.out.println("==003=mk_cust_info======"+list.size());
		String[] keys=new String[list.size()];
		System.out.println("==1003=mk_cust_info======"+keys.length);
		String tmp ="";
		if(CommonUtil.isNotEmpty(list)){
			for(int i=0;i<list.size();i++){
				Map map=(Map) list.get(i);
				String key=(String) map.get("CUST_ID");
				System.out.println("==00"+i+"===CUST_ID======"+key);
				if(key!=null&&!key.equals("")){
				System.out.println("==004=mk_cust_info======"+key);
					tmp= key;
				}
			}
			for(int i =0;i<list.size();i++){
				keys[i]=tmp;
			}
			
		}
		System.out.println("==005=mk_cust_info======"+keys);
		return keys;
	}
	/**
	 * Create on 2015-7-10 
	 * @author: zhaoyue
	 * @Title: getCustInfoByCustId 
	 * @Description: 根据custId查询客户标签数据
	 * @param custId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject getCustInfoByCustId(String custId) {
			JSONObject custInfoJson = null;
	      	try {
	      		custInfoJson = cassandraDao.query_by_key("mk_cust_info",custId);
	      		System.out.println("geGroupIdByIdNo.idNo======"+custId);
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
	  			throw new BusiException(returnCode,"亲,查询客户custInfo出问题了!","亲,查询客户custInfo出问题了!");
	  		}
		return custInfoJson;
	}
	
	
	public void insertMkCustInfo(String custId, Map data)
	{
			try {
				cassandraDao.insertMultiCloumnByRowKey("mk_cust_info", custId, data);
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusiException("-1", "亲,插入custInfo表出错啦!!!", "亲,请到后台看看吧!!!");
			}
	}
}
