package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkResbrandDict;

public class MkResbrandDict extends DBMysqlClass implements IMkResbrandDict {

	/**
	 * Create on 2015-9-9 
	 * @author: dongyh
	 * @Title: selectMkResbrandDict 
	 * @Description: 查询终端品牌
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkResbrandDict(Map inMap) {
		return baseDao.queryForList("MkResbrandDict.selectMkResbrandDict", inMap);
	}

}
