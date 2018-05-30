package com.sitech.market.dbo.trading.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.trading.inter.IMkRulecodeDict;

public class MkRulecodeDict extends DBMysqlClass implements IMkRulecodeDict {

	/**
	 * Create on 2015-7-9 
	 * @author: zhaoyue
	 * @Title: getRuleLabel 
	 * @Description:查询mk_rulecode_dict中的所有label标签 
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryRuleCode(Map inMap ) {
		List list =baseDao.queryForList("MkRulecodeDict.selectMkRulecodeDictParam",inMap);
		return list;
	}

}
