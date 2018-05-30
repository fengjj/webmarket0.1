package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkRestermiattriInfo;

/**
 * Create on 2015-5-30 
 * @author: quyl
 * @Title: MkRestermiattriInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkRestermiattriInfo extends DBMysqlClass implements IMkRestermiattriInfo {
	
	/**
	 * Create on 2015-5-30 
	 * @author: quyl
	 * @Title: selectMkRestermiattriInfo 
	 * @Description: 查询内容明细表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkRestermiattriInfo(Map map) {
		return baseDao.queryForList("MkRestermiattriInfo.selectMkRestermiattriInfo", map);
	}
		
}
