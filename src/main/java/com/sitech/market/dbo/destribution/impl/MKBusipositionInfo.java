package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusipositionInfo;

public class MKBusipositionInfo extends DBMysqlClass implements IMkBusipositionInfo {

	@Override
	public void batchInsertMkBusipositionInfo(List<Map> list) {
		baseDao.batchInsert("MkBusiposition.insertMkBusiposition", list);
	}

	@Override
	public void deleteMkBusipositionInfo(Map map) {
	    baseDao.delete("MkBusiposition.deleteMkBusiposition", map);

	}

	@Override
	public List selectBusipositionInfo(Map paraMap) {
		return baseDao.queryForList("MkBusiposition.selectBusipositionInfo",paraMap);
	}

	
}
