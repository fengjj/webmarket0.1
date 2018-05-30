package com.sitech.market.dbo.trading.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BaseException;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkUserordernumInfo;

/**
 * Create on 2015-4-6 
 * @author: gengws
 * @Title: MkUserordernumInfo 
 * @Description： MkUserordernumInfo 表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkUserordernumInfo extends DBNosqlClass implements IMkUserordernumInfo {

	/** 
	  * 向MK_USERORDERNUM_INFO表中增加营销业务订购次数
	  * Create on 2014-11-25
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	 * @throws Exception 
	  */
	@Override
	public boolean insertUserOrderNum(String key, String columnName) {
		boolean bool = false;
		JSONObject jsObject = null;
		try {
			jsObject = cassandraDao.query_by_key("mk_userordernum_info", key);
		} catch (Exception e) {
			throw new BusiException("-1", "亲,query出异常了,到后台看看吧 ", "MkUserordernumInfo.insertUserOrderNum");
		}
		if(null != jsObject && jsObject.size() > 0){
			JSONObject jObject = JSONObject.parseObject(jsObject.getString(key));
			if(null != jObject && jObject.size() > 0){
				String columnValue = jObject.getString(columnName);
				int num = 0;
				if(null != columnValue && !"".equals(columnValue)){
					num = Integer.parseInt(columnValue) + 1;
				}else{
					num = 1;
				}
				Map<String, String> datas = new HashMap<String, String>();
				datas.put(columnName, num+"");
				cassandraDao.insertMultiCloumAndSingleRow("mk_userordernum_info", key, datas);
				bool = true;
			}else{
				int num = 1;
				Map<String, String> datas = new HashMap<String, String>();
				datas.put(columnName, num+"");
				cassandraDao.insertMultiCloumAndSingleRow("mk_userordernum_info", key, datas);
				bool = true;
			}
		}else{
			int num = 1;
			Map<String, String> datas = new HashMap<String, String>();
			datas.put(columnName, num+"");
			cassandraDao.insertMultiCloumAndSingleRow("mk_userordernum_info", key, datas);
			bool = true;
		}
		return bool;
	}

	/** 
	  * 回滚MK_USERORDERNUM_INFO表中营销业务订购次数
	  * Create on 2014-11-25 
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	@Override
	public void rollbackUserOrderNum(String key, String columnName) {
		try {
			JSONObject jsObject = cassandraDao.query_by_key("mk_userordernum_info", key);
			if(null != jsObject && jsObject.size() > 0){
				JSONObject jObject = JSONObject.parseObject(jsObject.getString(key));
				if(null != jObject && jObject.size() > 0){
					String columnValue = jObject.getString(columnName);
					if(null != columnValue && !"".equals(columnValue)){
						int num = Integer.parseInt(columnValue);
						if(num > 0){
							num = num - 1;
						}
						Map<String, String> datas = new HashMap<String, String>();
						datas.put(columnName, num+"");
						cassandraDao.insertMultiCloumAndSingleRow("mk_userordernum_info", key, datas);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("rollbackUserOrderNum","亲,query出异常了,到后台看看吧");
		}
	}

	/**
     * 根据主键查询索引表
     * Create on 2014-10-24
     * @author yugl_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	public JSONObject queryUserordernumByIdNo(String rowKey) {
		JSONObject phoneObj = null;
		try{
			phoneObj = cassandraDao.query_by_key("mk_userordernum_info",rowKey);
		}catch(Exception e){
			e.printStackTrace();
			throw new BaseException("query_by_key","亲,query出异常了,到后台看看吧");
		}
		return phoneObj;
	}

}
