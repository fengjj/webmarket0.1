package com.sitech.market.dbo.common.impl;

import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkMsgdealInfo;

public class MkMsgdealInfo extends DBMysqlClass implements IMkMsgdealInfo {
	/**
	 * Create on Sep 22, 2015 
	 * @author: zhaoyue
	 * @Title: insertMkMsgdealInfo 
	 * @Description: 插入消息记录
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkMsgdealInfo(Map inMap) {
		baseDao.insert("MkMsgdealInfo.insertMkMsgdealInfo", inMap);
	}

}
