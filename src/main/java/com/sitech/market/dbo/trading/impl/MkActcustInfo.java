package com.sitech.market.dbo.trading.impl;

import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkActcustInfo;
import com.sitech.util.Const;
import com.alibaba.fastjson.JSONObject;
public class MkActcustInfo extends DBNosqlClass implements IMkActcustInfo{
	
	/**
	 * Create on 2015-7-30 
	 * @author: zhaoyue
	 * @Title: queryMkActcustInfo 
	 * @Description: 根据id_no+group_id拼串 查询mk_actcust_info 数据获取目标客户信息
	 * @param idNo
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject queryMkActcustInfo(String idNo) {
	    JSONObject actCust = null;
      	try {
      		actCust = cassandraDao.query_by_key("mk_actcust_info",idNo);
  		} catch (Exception e) {
  			e.printStackTrace();
  			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
  			throw new BusiException(returnCode,"亲,查询actcustInfo出问题了!","亲,查询actcustInfo出问题了!");
  		}
		return actCust;
	}

}
