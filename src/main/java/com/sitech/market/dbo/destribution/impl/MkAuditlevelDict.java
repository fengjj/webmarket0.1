package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkAuditlevelDict;

/**
 * Create on 2015-5-11
 * @author: dongyh
 * @Title: IMkAuditlevelDict
 * @Description： 审核层级字典表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkAuditlevelDict extends DBMysqlClass implements IMkAuditlevelDict {

	/**
	 * Create on 2015-5-11 
	 * @author: dongyh
	 * @Title: selectMkAuditlevelDict 
	 * @Description: 查询审批人
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkAuditlevelDict(Map map) {
		return baseDao.queryForList("MkAuditlevelDict.selectMkAuditlevelDict", map);
	}

}
