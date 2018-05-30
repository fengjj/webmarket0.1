package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusitypelevelrelDict;
/**
 * 营销业务类型级别关系字典表
 * Create on 2015-6-8 
 * @author: wangdw
 * @Title: MkBusitypelevelrelDict 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkBusitypelevelrelDict extends DBMysqlClass implements IMkBusitypelevelrelDict {

	/**
	 * 查询
	 * Create on 2015-6-8 
	 * @author: wangdw
	 * @Title: selectMkBusitypelevelrelDict 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkBusitypelevelrelDict(Map map) {
		List list=baseDao.queryForList("MkBusitypelevelrelDict.selectMkBusitypelevelrelDict",map);
		return list;
	}
	/**
	 * 查询
	 * Create on 2015-8-11 
	 * @author: zhangchen
	 * @Title: getRuleclassList 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List getRuleclassList(Map map) {
		List list=baseDao.queryForList("MkBusitypelevelrelDict.selectRuleClassByMkBusitypelevelrelDict",map);
		return list;
	}
}
