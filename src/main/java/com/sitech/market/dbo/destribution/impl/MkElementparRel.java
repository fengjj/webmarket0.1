package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkElementparRel;

/**
 * Create on 2015-4-10 
 * @author: yugl
 * @Title: MkElementparRel 
 * @Description： 元素参数关系表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkElementparRel extends DBMysqlClass implements IMkElementparRel {

	/**
	 * Create on 2015-4-10 
	 * @author: yugl
	 * @Title: selectMkElementparRel 
	 * @Description: 查询MkElementparRel表
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkElementparRel(Map inParam) {
		return baseDao.queryForList("MkElementparRel.selectMkElementparRel",inParam);
	}
	
	/**
	 * Create on 2015-5-22 
	 * @author: yugl
	 * @Title: selectAimEngName 
	 * @Description: 
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectAimEngName(Map inParam) {
		return baseDao.queryForList("MkElementparRel.selectAimEngName",inParam);
	}

}
