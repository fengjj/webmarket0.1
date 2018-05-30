package com.sitech.market.dbo.destribution.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkCostcontrolInfo;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkCostcontrolInfo
* @Description： 营销成本
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkCostcontrolInfo extends DBMysqlClass implements IMkCostcontrolInfo {

	/**
	 * Create on 2015-7-17 
	 * @author: liuhaoa
	 * @Title: selectMkCostcontrolInfo 
	 * @Description: 查询营销成本管控表
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectMkCostcontrolInfo(Map inMap) {
		Map pMap = new HashMap();
		pMap.put("departmentId", inMap.get("departmentId"));
		List<Map> list = baseDao.queryForList("MkCostcontrolInfo.selectMkCostcontrolInfo", pMap);
		return list;
	}

	/**
	 * Create on 2015-7-17 
	 * @author: liuhaoa
	 * @Title: selectMkCostcontrolInfo 
	 * @Description: 更新营销成本管控表
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkCostcontrolInfo(Map inMap) {
		baseDao.update("MkCostcontrolInfo.updateMkCostcontrolInfo", inMap);
	}

}
