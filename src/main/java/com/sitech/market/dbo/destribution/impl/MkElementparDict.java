package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkElementparDict;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: MkElementparDict
 * @Description： 营销元素参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkElementparDict extends DBMysqlClass implements IMkElementparDict {

	/**
	 * Create on 2015-4-21 
	 * @author: dongyh
	 * @Title: selectMkElementparDict 
	 * @Description: 根据元素查询属性,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkElementparDictForSubId(Map inMap){
		return baseDao.queryForList("MkElementparDict.selectMkElementparDictForSubId",inMap);
	}
	
	/**
	 * Create on 2015-6-3 
	 * @author: qijh
	 * @Title: selectMkElementparDict 
	 * @Description: 根据元素查询规则属性,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkElementparDictForItemId(Map inMap){
		return baseDao.queryForList("MkElementparDict.selectMkElementparDictForItemId",inMap);
	}
	/**
	 * Create on 2015-6-3 
	 * @author: qijh
	 * @Title: selectMkElementparDict 
	 * @Description: 根据元素查询内容属性,用于加载页面
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectMkElementparDictForSubContentId(Map inMap) {
		// TODO Auto-generated method stub
		return baseDao.queryForList("MkElementparDict.selectMkElementparDictForSubContentId",inMap);
	}
	/**
	 * Create on 2015-6-21 
	 * @author: nidw
	 * @Title: selectMkElementparDictSyncForItemId 
	 * @Description: 查询规则内容详细
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkElementparDictSyncForItemId(Map inMap){
		return baseDao.queryForList("MkElementparDict.selectMkElementparDictSyncForItemId",inMap);
	}
}
