package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusicontentRel;
/**
 * 业务内容关系dbo
 * Create on 2015-5-11 
 * @author: wangdw
 * @Title: MkBusicontentRel 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkBusicontentRel extends DBMysqlClass implements IMkBusicontentRel {

	/**
	 * 查询业务内容信息
	 * Create on 2015-5-11 
	 * @author: wangdw
	 * @Title: selectBusiContentInfo 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkBusicontentRelByName(Map inMap) {
		return baseDao.queryForList("MkBusicontentRel.selectMkBusicontentRelByName", inMap);
	}
	
	/**
	 * Create on 2015-5-26 
	 * @author: yugl
	 * @Title: selectMkBusicontentRel 
	 * @Description: 查询业务内容关系
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusicontentRel(Map inMap) {
		return baseDao.queryForList("MkBusicontentRel.selectMkBusicontentRel", inMap);
	}
	
	public List selectMkBusicontentRelById(String rel_id) {
		return baseDao.queryForList("MkBusicontentRel.selectMkBusicontentRelById", rel_id);
	}
	/**
	 * Create on 2015-5-23 
	 * @author: yugl
	 * @Title: insertMkBusicontentRel 
	 * @Description: 保存业务内容关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkBusicontentRel(Map map) {
		baseDao.insert("MkBusicontentRel.insertMkBusicontentRel", map);
	}
	/**
	 * Create on 2015-5-23 
	 * @author: yugl
	 * @Title: insertMkBusicontentRel 
	 * @Description: 保存业务内容关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertBatchMkBusicontentRel(List<Map> list) {
		baseDao.batchInsert("MkBusicontentRel.insertMkBusicontentRel", list);
	}
	
	/**
	 * Create on 2015-5-23 
	 * @author: qijh
	 * @Title: insertMkBusicontentRel 
	 * @Description: 删除业务内容关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusiContentRelByBusiId(Map map) {
		// TODO Auto-generated method stub
		baseDao.delete("MkBusicontentRel.deleteMkBusiContentRelByBusiId", map);
	}
	
	/**
	 * Create on 2015-6-22 
	 * @author: jiaxla
	 * @Title: deleteMkBusicontentRelById 
	 * @Description: 删除内容与业务关系（单条）
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusicontentRelById(Map map) {
		// TODO Auto-generated method stub
		baseDao.delete("MkBusicontentRel.deleteMkBusicontentRelById", map);
	}
	
	/**
	 * Create on 2015-5-23 
	 * @author: qijh
	 * @Title: insertMkBusicontentRel 
	 * @Description: 复制业务内容关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void copyMkBusiContentRel(Map map) {
		// TODO Auto-generated method stub
		baseDao.insert("MkBusicontentRel.copyMkBusiContentRel", map);
	}
	
	/**
	 * Create on 2015-5-23 
	 * @author: qijh
	 * @Title: selectBusicontentInfo 
	 * @Description:根据活动id查询关联的内容包id
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectBusicontentInfo(Map<Object, Object> inMap) {
		// TODO Auto-generated method stub
		return baseDao.queryForList("MkBusicontentRel.selectBusicontentInfo", inMap);
	}
	
	/**
	 * Create on 2015-5-23 
	 * @author: qijh
	 * @Title: insertMkBusicontentRel 
	 * @Description: 删除业务内容关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void delBusicontentRel(Map map) {
		// TODO Auto-generated method stub
		baseDao.delete("MkBusicontentRel.delBusicontentRel", map);
	}
	/**
	 * Create on 2015-8-05 
	 * @author: lixd_bj
	 * @Title: selectRuleInfoByConSerialId 
	 * @Description:根据内容流水获取规则信息
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectRuleInfoByConSerialId(Map map){
		return baseDao.queryForList("MkBusicontentRel.selectRuleInfoByConSerialId", map);
	}
	
	/**
	 * Create on 2015-8-05 
	 * @author: lixd_bj
	 * @Title: selectActIdByConSerialId 
	 * @Description:根据内容流水获取活动ID
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectActIdByConSerialId(Map map){
		return baseDao.queryForList("MkBusicontentRel.selectActIdByConSerialId", map);
	}
}
