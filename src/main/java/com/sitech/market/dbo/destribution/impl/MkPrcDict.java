package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkPrcDict;

public class MkPrcDict extends DBMysqlClass implements IMkPrcDict {

	/**
	 * Create on 2015-9-6 
	 * @author: dongyh
	 * @Title: selectMkPrcDict 
	 * @Description: 查询资费
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkPrcDict(Map inMap) {
		return baseDao.queryForList("MkPrcDict.selectMkPrcDict", inMap);
	}
	
	/**
	 * Create on 2015-9-7 
	 * @author: dongyh
	 * @Title: selectMkPrcDictByProd 
	 * @Description: 查询资费对应产品
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkPrcDictByProd(Map inMap){
		return (Map) baseDao.queryForObject("MkPrcDict.selectMkPrcDictByProd", inMap);
	}

}
