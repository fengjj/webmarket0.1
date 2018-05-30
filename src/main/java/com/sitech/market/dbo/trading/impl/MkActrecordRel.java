package com.sitech.market.dbo.trading.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBNosqlClass;
import com.sitech.market.dbo.trading.inter.IMkActrecordRel;
import com.sitech.util.Const;

public class MkActrecordRel extends DBNosqlClass implements IMkActrecordRel {

	/**
	 * 根据订购记录主表序列号（主键）查询分表序列号（主键）
	 * @param recordId
	 * @author hanzh_bj
	 * Create on 2015-03-09
	 */
	@Override
	public List selectSerialIdsByRecordId(String recordId) {
		List serialIdList = new ArrayList();
		JSONObject relObj = null;
		try{
			relObj = cassandraDao.query_by_key("mk_actrecord_rel", recordId);
		}catch(Exception e){
			e.printStackTrace();
			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","querySerialIdByRecordId");
		}
		
		if(null == relObj || relObj.size() < 1){
			return serialIdList;
		}
		JSONObject json = JSONObject.parseObject(relObj.getString(recordId));
		if(null == json || json.size() < 1){
			return serialIdList;
		}
		serialIdList.addAll(json.keySet());
		return serialIdList;
	}

	/**
     * 批量向MK_ACTRECORDREL_INFO表中插入相关数据
     * ROWKEY      = 主表serial_id|tableid
	 * COLUMN_NAME = 分表serial_id的值
     * Create on 2014-11-26
     * @author hanzh_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 修改日期:     修改人:     修改目的:
     */
	@Override
	public void insertBatchActRecordRel(String serialId, Map<String, String> relMap) {
		try{
			cassandraDao.insertMultiCloumAndSingleRow("mk_actrecord_rel", serialId, relMap);
		}catch(Exception e){
			e.printStackTrace();
			String returnCode = errorUtil.getErrorCode(Const.opCodeYXZX, Const.errcode_dberr,Const.errtype_systemerror);
			throw new BusiException(returnCode,"数据库操作错误","insertBatchActRecordRel");
		}
	}

	/**
	 * Create on 2015-7-16 
	 * @author: liuhaoa
	 * @Title: selectMkActrecordRel 
	 * @Description: 根据key查询MkActrecordRel成本总表与成本分表关系查询
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public JSONObject selectMkActrecordRel(String[] key) {
		JSONObject json = null;
		try{
			json = cassandraDao.query_by_key("mk_actrecord_rel", key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}

}
