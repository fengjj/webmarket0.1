package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusiareaInfo;

public class MkBusiareaInfo extends DBMysqlClass implements IMkBusiareaInfo {
	/**
	 * Create on 2015-4-20 
	 * @author: yugl
	 * @Title: selectMkBusiareaInfo 
	 * @Description: 查询业务区域表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkBusiareaInfo(Map map) {
		return baseDao.queryForList("MkBusiareaInfo.selectMkBusiareaInfo", map);
	}
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: batchInsertMkBusiareaInfo 
	 * @Description: 批量保存业务区域信息
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkBusiareaInfo(List<Map> list) {
		baseDao.batchInsert("MkBusiareaInfo.insertMkBusiareaInfo", list);
	}
	
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: batchInsertMkBusiareaInfo 
	 * @Description: 根据busiId删除业务区域信息
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusiareaInfoByBusiId(Map map) {
		baseDao.delete("MkBusiareaInfo.deleteMkBusiareaInfoByBusiId", map);
	}
	/**
	 * 根据busiId，更新busiId
	 * @Create on 2015-6-23 
	 * @author: wangdw
	 * @Title: updateMkBusiareaInfoForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusiareaInfoForBusiId(Map map) {
		baseDao.update("MkBusiareaInfo.updateMkBusiareaInfoForBusiId", map);
	}
}
