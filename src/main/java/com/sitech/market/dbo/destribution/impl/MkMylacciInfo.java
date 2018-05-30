package com.sitech.market.dbo.destribution.impl;

import java.util.Map;

import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkMylacciInfo;

public class MkMylacciInfo extends DBMysqlClass implements IMkMylacciInfo{

	
	public boolean add(Map<String,Object> mkMylacciInfo){
		try {
			baseDao.insert("MkMylacciInfo.insertMkMylacciInfo", mkMylacciInfo);
			return true;
		} catch (RuntimeException e) {
			throw new  BusiException("1000",e.getMessage());
		}
	}
	
	public boolean deleteById(String id){
		try {
			return baseDao.delete("MkMylacciInfo.deleteMkMylacciInfoById", id)>0;
		} catch (RuntimeException e) {
			throw new BusiException("1002",e.getMessage());
		}
	}
	
}