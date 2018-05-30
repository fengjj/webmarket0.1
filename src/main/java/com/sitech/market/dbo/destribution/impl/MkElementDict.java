package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkElementDict;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: MkElementDict
 * @Description： 营销元素
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkElementDict extends DBMysqlClass implements IMkElementDict {

	/**
	 * Create on 2015-4-21 
	 * @author: dongyh
	 * @Title: selectMkElementDict 
	 * @Description: 查询元素加载页面,SUB_ID：0 策划,1 执行
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkElementDict(Map inMap){
		return baseDao.queryForList("MkElementDict.selectMkElementDict", inMap);
	}
	/**
	 * Create on 2015-6-1 
	 * @author: zhangchen
	 * @Title: selectMkElementDictByContentType 
	 * @Description: 根据mk_contenttype_dict查询元素列表
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectMkElementDictByContentType(Map inMap){
		return baseDao.queryForList("MkElementDict.selectMkElementDictByContentType",inMap);
	}
	
	/**
	 * Create on 2015-7-20 
	 * @author nidw
	 * @Title: selectMkElementDictByContent 
	 * @Description: 查询内容元素列表
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectMkElementDictByContent(Map inMap){
		return baseDao.queryForList("MkElementDict.selectMkElementDictByContent",inMap);
	}
}
