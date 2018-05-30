package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusiruleRel;

public class MkBusiruleRel extends DBMysqlClass implements IMkBusiruleRel {
	
	/**
	 * Create on 2015-5-11
	 * @author: yugl
	 * @Title: insertMkBusiruleRel 
	 * @Description: 保存营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkBusiruleRel(Map map) {
		baseDao.insert("MkBusiruleRel.insertMkBusiruleRel", map);
	}
	/**
	 * 批量插入
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: batchInsertMkBusiruleRel 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void batchInsertMkBusiruleRel(List<Map> list) {
		baseDao.batchInsert("MkBusiruleRel.insertMkBusiruleRel", list);
	}
	
	/**
	 * 查询业务规则信息
	 * Create on 2015-5-12 
	 * @author: wangdw
	 * @Title: selectBusirule 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectBusiRule(Map map) {
		List list = baseDao.queryForList("MkBusiruleRel.selectMkRuleInfo", map);
		return list;
	}
	
	
	/**
	 * Create on 2015-5-11
	 * @author: yugl
	 * @Title: insertMkBusiruleRel 
	 * @Description: 根据busiId删除营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusiruleRelByBusiId(Map map) {
		baseDao.delete("MkBusiruleRel.deleteMkBusiruleRelByBusiId", map);
	}
	/**
	 * 查询业务关系表
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: selectMkBusiruleRel 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusiruleRel(Map map) {
		List list = baseDao.queryForList("MkBusiruleRel.selectMkBusiruleRel", map);
		return list;
	}
	
	
	/**
	 * Create on 2015-7-16 
	 * @author:zhaoyue
	 * @Title: selectBusiIdList 
	 * @Description:关联查询全部的busiIdList 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectBusiIdList(Map map){
		List list = baseDao.queryForList("View.querybusiIdList", map);
		return list;
	}
	
	
	
	
	
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusiruleRelForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusiruleRelForBusiId(Map map) {
		baseDao.update("MkBusiruleRel.updateMkBusiruleRelForBusiId", map);
	}
	
	/**
	 * 查询业务规则信息
	 * Create on 2015-6-3 
	 * @author: qijh
	 * @Title: selectBusirule 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectBusiRuleInfo(Map map) {
		List list = baseDao.queryForList("MkBusiruleRel.selectBusiRuleInfo", map);
		return list;
	}	
	
	/**
	 * Create on 2015-6-4
	 * @author: qijh
	 * @Title: insertMkBusiruleRel 
	 * @Description: 根据relId删除营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusiruleRelByRelId(Map map) {
		baseDao.delete("MkBusiruleRel.deleteMkBusiruleRelById", map);
	}
	/**
	 * Create on 2015-6-24
	 * @author: lixd_bj
	 * @Title: deleteRuleRelByBusiId 
	 * @Description: 根据busiId删除营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteRuleRelByBusiId(Map map) {
		baseDao.delete("MkBusiruleRel.deleteRuleRelByBusiId", map);
	}

	/**
	 * Create on 2015-6-6
	 * @author: xiongxin
	 * @Title: selectMkBusiRuleRelByMeansId 
	 * @Description: 根据meansId查询营销规则
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkBusiRuleRelByMeansId(Map inMap) {
		return baseDao.queryForList("MkBusiruleRel.selectMkBusiRuleRelByMeansId",inMap);
	}
	@Override
	public List selectMkBusiRuleRelByBusiId(Map inMap) {
		return baseDao.queryForList("MkBusiruleRel.selectMkBusiRuleRelByBusiId",inMap);
	}
	
	/**
	 * Create on 2015-6-11
	 * @author: qijh
	 * @Title: copyMkBusiRuleRel 
	 * @Description: 复制营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void copyMkBusiRuleRel(Map map) {
		baseDao.insert("MkBusiruleRel.copyMkBusiRuleRel", map);
	}
	/**
	 * 查询业务规则信息
	 * Create on 2015-6-3 
	 * @author: qijh
	 * @Title: selectBusirule 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectActRuleInfo(Map map) {
		List list = baseDao.queryForList("MkBusiruleRel.selectActRuleInfo", map);
		return list;
	}
	/**
	 * Create on 2015-6-24
	 * @author: lixd_bj
	 * @Title: deleteRuleRelBySerialId 
	 * @Description: 根据SerialId删除营销规则与业务关系表
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteRuleRelBySerialId(Map map){
		baseDao.delete("MkBusiruleRel.deleteRuleRelBySerialId", map);
	}
	
	/**
	 * 根据关系表，查询ruleitem信息
	 * @Create on 2015-7-22 
	 * @author: wangdw
	 * @Title: selectBusiRuleItem 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectBusiRuleItem(Map map) {
		List<Map> list = baseDao.queryForList("MkBusiruleRel.selectBusiRuleItem", map);
		return list;
	}
	/**
	 * Create on 2015-7-8 
	 * @author: zhaoyue
	 * @Title: selectMkBusiRuleByBusiIdOrBusiType 
	 * @Description: 根据busiId,busiType查询mk_busifule_rel
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkBusiRuleByBusiIdOrBusiType(Map inMap) {
		return baseDao.queryForList("MkBusiruleRel.selectMkBusiRuleRelByBusiIdOrBusiType",inMap);
	}
}
