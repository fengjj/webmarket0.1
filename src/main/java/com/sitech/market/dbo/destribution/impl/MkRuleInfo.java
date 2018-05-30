package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkRuleInfo;

public class MkRuleInfo extends DBMysqlClass implements IMkRuleInfo {
	
	/**
	 * Create on 2015-5-12 
	 * @author: yugl
	 * @Title: selectMkRuleInfo 
	 * @Description: 查询规则表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkRuleInfo(Map map){
		return baseDao.queryForList("MkRuleInfo.selectMkRuleInfo", map);
	}
	
	/**
	 * Create on 2015-6-19 
	 * @author: yugl
	 * @Title: selectMkRuleInfoById 
	 * @Description: 根据主键查询
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map selectMkRuleInfoById(String serialId){
		return (Map)baseDao.queryForObject("MkRuleInfo.selectMkRuleInfoById", serialId);
	}
	
	/**
	 * Create on 2015-5-19 
	 * @author: yugl
	 * @Title: selectRuleByRuleClass 
	 * @Description: 关联规则明细表查询规则
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectRuleByRuleClass(Map map){
		return baseDao.queryForList("MkRuleInfo.selectRuleByRuleClass", map);
	}
	
	/**
	 * Create on 2015-5-22 
	 * @author: lixd_bj
	 * @Title: queryRuleInfoByBusiId 
	 * @Description: 根据活动ID查询规则信息
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryRuleInfoByBusiId(Map map){
		return baseDao.queryForList("MkRuleInfo.selectRuleInfoByBusiId", map);
	}
	
	/**
	 * Create on 2015-8-3 
	 * @author: nidw
	 * @Title: queryRuleInfoAndRuleTypeNameByBusiId 
	 * @Description: 根据活动ID查询规则信息
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryRuleInfoAndRuleTypeNameByBusiId(Map map){
		return baseDao.queryForList("MkRuleInfo.selectRuleInfoAndRuleTypeNameByBusiId", map);
	}
	
	/**
	 * Create on 2015-5-22 
	 * @author: qijh
	 * @Title: deleteMkBusiRuleRelByBusiId 
	 * @Description: 删除规则关系
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusiRuleRelByBusiId(Map map) {
		// TODO Auto-generated method stub
		baseDao.delete("MkBusiruleRel.deleteMkBusiRuleRelByBusiId",map);
	}
/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: insertMkRuleInfo 
	 * @Description: 新增规则
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkRuleInfo(Map map) {
		baseDao.insert("MkRuleInfo.insertMkRuleInfo",map);
	}
	

	/**
	 * Create on 2015-6-16 
	 * @author: yugl
	 * @Title: updateMkRuleInfo 
	 * @Description: 修改规则
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkRuleInfo(Map map) {
		baseDao.insert("MkRuleInfo.updateMkRuleInfo",map);
	}

	/**
	 * Create on 2015-6-19 
	 * @author: lixd_bj
	 * @Title: deleteMkRuleInfoBySerialIdList 
	 * @Description: 根据serialIdList删除规则信息
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkRuleInfoBySerialIdList(Map map){
		baseDao.delete("MkRuleInfo.deleteMkRuleInfoBySerialIdList",map);
	}
	
	/**
	 * Create on 2015-6-19 
	 * @author: jiaxla
	 * @Title: selectRuleInfoByRuleType 
	 * @Description: 根据规则类型查询规则列表
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectRuleInfoByRuleType(Map map){
		return baseDao.queryForList("MkRuleInfo.selectRuleInfoByRuleType",map);
	}
	
	/**
	 * Create on 2015-7-25 
	 * @author: nidw
	 * @Title: delRuleInfoById 
	 * @Description: 根据serialId删除规则
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void delRuleInfoById(Map map){
		baseDao.delete("MkRuleInfo.deleteMkRuleInfoById",map);
	}
	/**
	 * Create on 2015-8-11
	 * @author: wangpei
	 * @Title: copyRuleInfo 
	 * @Description: 根据serialId复制规则
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void copyRuleInfo(Map map){
		baseDao.insert("MkRuleInfo.copyMkRuleInfo",map);
	}
	
}
