package com.sitech.market.dbo.destribution.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkChngroupDict;

/**
 * 
 * Create on 2015-6-15
 * @author: liuhaoa
 * @Title: IMkChngroupDict
 * @Description： 营销策划区域选择
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkChngroupDict extends DBMysqlClass implements IMkChngroupDict {

	/**
	 * Create on 2015-6-15
	 * @author: liuhaoa
	 * @Title: queryOrgs 
	 * @Description: 营销策划区域选择
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	@Override
	public List queryOrgs(Map inMap) {
		List list = new ArrayList();
		list = baseDao.queryForList("MkChngroupDict.selectMkChngroupDictByGroupId", inMap);
		return list;
	}

	/**
	 * 营销渠道区域选择
	 * Create on June 22, 2015 
	 * @author: liuhaoa
	 * @Title: queryGroupName 
	 * @Description: 营销渠道组织区域数据
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */	
	@Override
	public List queryGroupName(Map inMap) {
		Map pMap = new HashMap();
		pMap.put("rootDistance", inMap.get("rootDistance"));
		int i = Integer.parseInt((String)inMap.get("rootDistance")) - 1;
		pMap.put("root_distance", ""+i);
		List list = new ArrayList();
		list = baseDao.queryForList("MkChngroupDict.selectMkChngroupDictByRootDistance", pMap);
		return list;
	}
	
	/**
	 * 营销渠道区域选择
	 * Create on June 22, 2015 
	 * @author: liuhaoa
	 * @Title: selectMkChngroupDictById 
	 * @Description: 根据ID获取营销渠道组织区域数据
	 * @param inparam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkChngroupDictById(Map inMap){
		List list = new ArrayList();
		list = baseDao.queryForList("MkChngroupDict.selectMkChngroupDictById", inMap);
		System.out.println("========list=="+list);
		return list;
	}
}
