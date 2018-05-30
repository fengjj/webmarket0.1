package com.sitech.market.dbo.common.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.common.inter.IMkMsgdealexpIntf;

/** 
 * Create on 2015-9-8 下午02:39:26
 * @author:  yangbao
 * @Title: MkMsgdealexpIntf 
 * @Description：
 * @version 1.0 
 * update_data:      update_author:      update_note: 
 */
public class MkMsgdealexpIntf extends DBMysqlClass implements IMkMsgdealexpIntf {

	@Override
	public void insertMkMsgdealexpIntf(Map inMap) {
		baseDao.insert("MkMsgdealexpIntf.insertMkMsgdealexpIntf", inMap);
	}

	@Override
	public List<Map> selectMkMsgdealexpIntf(Map inMap) {
		List<Map> list=baseDao.queryForList("MkMsgdealexpIntf.selectMkMsgdealexpIntf",inMap);
		return list;
	}

	@Override
	public void updateMkMsgdealexpIntf(Map inMap) {
		baseDao.update("MkMsgdealexpIntf.updateMkMsgdealexpIntf", inMap);
	}

	@Override
	public void deleteMkMsgdealexpIntf(Map inMap) {
		baseDao.delete("MkMsgdealexpIntf.deleteMkMsgdealexpIntf", inMap);
	}

}
