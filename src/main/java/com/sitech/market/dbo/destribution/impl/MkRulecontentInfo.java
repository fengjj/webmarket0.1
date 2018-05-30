package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusiareaInfo;
import com.sitech.market.dbo.destribution.inter.IMkBusiruleRel;
import com.sitech.market.dbo.destribution.inter.IMkRuleInfo;
import com.sitech.market.dbo.destribution.inter.IMkRulecontentInfo;

public class MkRulecontentInfo extends DBMysqlClass implements IMkRulecontentInfo {
	
	/**
	 * Create on 2015-5-11 
	 * @author: yugl
	 * @Title: selectMkRulecontentInfo 
	 * @Description: 查询规则内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkRulecontentInfo(Map map){
		return baseDao.queryForList("MkRulecontentInfo.selectMkRulecontentInfo", map);
	}
	
	/**
	 * Create on 2015-5-11 
	 * @author: yugl
	 * @Title: selectMkRulecontentInfo 
	 * @Description: 关联mk_rulecode_dict查询规则内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectRulecontentJoinCodeName(Map map){
		return baseDao.queryForList("MkRulecontentInfo.selectRulecontentJoinCodeName", map);
	}

	/**
	 * Create on 2015-6-6 
	 * @author: xiongxin
	 * @Title: selectMkRulecontentByItemId 
	 * @Description: 通过itemId来查询规则内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectRuleContentByItemId(Map inMap) {
		return baseDao.queryForList("MkRulecontentInfo.selectRuleContentByItemId",inMap);
	}

	@Override
	public List queryItemIdBySerialId(Map inMap) {
		return baseDao.queryForList("MkRulecontentInfo.queryItemIdBySerialId",inMap);
	}
	
	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: batchInsertMkRulecontentInfo 
	 * @Description: 批量保存规则内容
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkRulecontentInfo(List list) {
		baseDao.batchInsert("MkRulecontentInfo.insertMkRulecontentInfo", list);
	}
	
	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: deleteMkRulecontentInfoByItemId 
	 * @Description: 根据itemId删除规则明细内容
	 * @param itemId 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkRulecontentInfoByItemId(String itemId){
		baseDao.delete("MkRulecontentInfo.deleteMkRulecontentInfoByItemId", itemId);
	}
	/**
	 * Create on 2015-6-18 
	 * @author: lixd_bj
	 * @Title: deleteMkRulecontentInfoByItemIdList 
	 * @Description: 根据itemIdList删除规则明细内容
	 * @param itemId 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkRulecontentInfoByItemIdList(Map map){
		baseDao.delete("MkRulecontentInfo.deleteMkRulecontentInfoByItemIdList", map);
	}
	/**
	 * Create on 2015-8-11
	 * @author: wangpei
	 * @Title: copyMkRulecontentInfo 
	 * @Description: 批量复制规则内容
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void copyMkRulecontentInfo(Map map) {
		baseDao.insert("MkRulecontentInfo.copyMkRulecontentInfo", map);
	}
	
}
