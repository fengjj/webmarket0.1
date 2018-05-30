package com.sitech.market.dbo.destribution.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkParcontentDict;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: MkParcontentDict
 * @Description： 营销元素参数限定范围
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkParcontentDict extends DBMysqlClass implements IMkParcontentDict {

	/**
	 * Create on 2015-4-2 
	 * @author: dongyh
	 * @Title: queryParcontent 
	 * @Description: 查询全部属性内容,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkParcontentDict(Map inMap) {
		Map map = new HashMap();
		return baseDao.queryForList("MkParcontentDict.selectMkParcontentDict",inMap);
	}
}
