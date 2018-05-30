package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMKPrcidListInfo;
import com.sitech.market.dbo.destribution.inter.IMkActInfo;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkActInfo
* @Description： 营销活动
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkPrcidListInfo extends DBMysqlClass implements IMKPrcidListInfo {

	/**
	 * Create on 2015-7-24 
	 * @author: 
	 * @Title: queryPrcidList 
	 * @Description: 按地市查询已配置套餐列表
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> queryPrcidList(Map paramMap,int beginNum,int endNum) {
		return baseDao.queryForListBeginEnd("MkRegionprcRel.queryPrcidListByParam", paramMap,beginNum, endNum);
	}

	/**
	 * Create on 2015-7-24 
	 * @author: 
	 * @Title: queryPrcidList 
	 * @Description: 按地市查询已配置套餐数量
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryPrcidListSum(Map paramMap) {
		return baseDao.queryForList("MkRegionprcRel.queryPrcidListSumByParam", paramMap);
	}
	
	/**
	 * 查询套餐原始配置表数据
	 */
	@Override
	public List addPrcidList(Map paramMap) {
		return baseDao.queryForList("MkPrcDict.queryPrcidList", paramMap);
	}
	
	/**
	 * 按类型查询地市已配置的每种套餐数量
	 */
	@Override
	public List queryPrcidSum(Map paramMap) {
		return baseDao.queryForList("MkRegionprcRel.queryPrcidListSum", paramMap);
	}
	
	/**
	 * 保存套餐配置
	 */
	@Override
	public void savePrcidList(Map paramMap) {
		baseDao.insert("MkRegionprcRel.insertMkRegionprcRel", paramMap);
	}

	/**
	 * 删除套餐配置
	 */
	@Override
	public void delPrcidList(Map paramMap) {
		baseDao.insert("MkRegionprcTrac.insertMkRegionprcTracById", paramMap);
		baseDao.delete("MkRegionprcRel.deleteMkRegionprcRelById", paramMap);
		
	}
	
}
