package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusiPositionRel;

public class MkBusiPositionRel extends DBMysqlClass implements IMkBusiPositionRel {

	@Override
	public List<Map> getBusiPositionRel(Map inMap) {
		List resultList = baseDao.queryForList("MkBusiPositionRel.selectSeBusiPositionRel",inMap);
		return resultList;	
	}

	@Override
	public List<Map> getBusiPositionRelByCond(Map inMap,int startNum,int endNum) {		
		List resultList = baseDao.queryForListBeginEnd("MkBusiPositionRel.selectSeBusiPositionRel", inMap, startNum, endNum);
		return resultList;
	}

	@Override
	public List<Map> queryBusiPositionByCondTotal(Map inMap) {
		List resultList = baseDao.queryForList("MkBusiPositionRel.queryBusiPositionByCondTotal",inMap);
		return resultList;	
	}

	@Override
	public void updateBusiPosition(Map inMap) {
		baseDao.update("MkBusiPositionRel.updateBusiPosition",inMap);		
	}
	
}
