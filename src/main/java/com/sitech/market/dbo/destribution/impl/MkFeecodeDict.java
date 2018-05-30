package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkFeecodeDict;
/**
 * 行业部or_feecode_dict fee_code，fee_type码表查询
 * @Create on 2015-7-18 
 * @author: wangdw
 * @Title: MkFeecodeDict 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public class MkFeecodeDict extends DBMysqlClass implements IMkFeecodeDict {

	/**
	 * 查询
	 * @Create on 2015-7-18 
	 * @author: wangdw
	 * @Title: selectMkFeecodeDict 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectMkFeecodeDict(Map inMap) {
		return baseDao.queryForList("MkFeecodeDict.selectMkFeecodeDict", inMap);
	}

	/**
	 * 根据主键查询
	 * @Create on 2015-7-18 
	 * @author: wangdw
	 * @Title: selectMkFeecodeDictById 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public Map selectMkFeecodeDictById(Map inMap) {
		return (Map)baseDao.queryForObject("MkFeecodeDict.selectMkFeecodeDictById", inMap);
	}

}
