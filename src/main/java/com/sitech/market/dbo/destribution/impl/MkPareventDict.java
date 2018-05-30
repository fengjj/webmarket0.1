package com.sitech.market.dbo.destribution.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkPareventDict;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: MkPareventDict
 * @Description： 营销元素参数事件
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkPareventDict extends DBMysqlClass implements IMkPareventDict {

	/**
	 * Create on 2015-4-2 
	 * @author: dongyh
	 * @Title: queryParevent 
	 * @Description: 查询全部属性事件,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkPareventDict(Map inMap) {
		return baseDao.queryForList("MkPareventDict.selectMkPareventDict",inMap);
	}
}
