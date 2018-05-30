package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusievalInfo;
/**
 * 业务评估信息
 * Create on 2015-5-11 
 * @author: wangdw
 * @Title: MkBusievalInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkBusievalInfo extends DBMysqlClass implements IMkBusievalInfo {

	/**
	 * 查询业务评估信息
	 * Create on 2015-5-9 
	 * @author: wangdw
	 * @Title: selectMkBusievalInfo 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkBusievalInfo(Map map) {
		return baseDao.queryForList("MkBusievalInfo.selectMkBusievalInfo", map);
	} 
}
