package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkContentprodInfo;

/**
 * Create on 2015-5-27 
 * @author: yugl
 * @Title: MkContentfeeInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkContentprodInfo extends DBMysqlClass implements IMkContentprodInfo {
	
	/**
	 * Create on 2015-5-27
	 * @author: yugl
	 * @Title: selectMkContentInfo 
	 * @Description: 查询产品内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkContentprodInfo(Map map) {
		return baseDao.queryForList("MkContentprodInfo.selectMkContentprodInfo", map);
	}
	
	/**
	 * Create on 2015-6-4 
	 * @author: yugl
	 * @Title: selectMkContentprodInfoById 
	 * @Description: 根据主键查询
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map selectMkContentprodInfoById(String serialId) {
		return (Map)baseDao.queryForObject("MkContentprodInfo.selectMkContentprodInfoById", serialId);
	}
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: insertMkContentprodInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkContentprodInfo(Map map) {
		baseDao.insert("MkContentprodInfo.insertMkContentprodInfo", map);
	}
	/**
	 * Create on 2015-9-9 
	 * @author: dongyh
	 * @Title: insertBatchMkContentprodInfo 
	 * @Description: 批量插入
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertBatchMkContentprodInfo(List<Map> list){
		baseDao.batchInsert("MkContentprodInfo.insertMkContentprodInfo", list);
	}
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: updateMkContentprodInfo 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int updateMkContentprodInfo(Map map) {
		return baseDao.update("MkContentprodInfo.updateMkContentprodInfoBySerialId", map);
	}
	
	/**
	 * Create on 2015-6-29
	 * @author: lixd_bj
	 * @Title: updateMkContentprodInfoBySerialId 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int updateMkContentprodInfoBySerialId(Map map) {
		return baseDao.update("MkContentprodInfo.updateMkContentprodInfoBySerialId", map);
	}
	
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: deleteMkContentprodInfoById 
	 * @Description: 删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int delInfoById(Map map) {
		return baseDao.delete("MkContentprodInfo.deleteMkContentprodInfoById", map);
	}
	
	/**
	 * Create on 2015-6-6
	 * @author: jiaxla
	 * @Title: deleteMkContentprodInfoByContentSerialId 
	 * @Description: 根据cotnentserialId删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int deleteMkContentprodInfoByContentSerialId(String cotnentserialId) {
		return baseDao.delete("MkContentprodInfo.deleteMkContentprodInfoByContentSerialId", cotnentserialId);
	}

	@Override
	public void insertInfo(Map map) {
		baseDao.insert("MkContentprodInfo.insertMkContentprodInfo", map);
	}
	/**
	 * Create on 2015-8-14
	 * @author: wangpei
	 * @Title: copyInfo 
	 * @Description: 复制数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void copyInfo(Map map){
		baseDao.insert("MkContentprodInfo.copyMkContentprodInfo",map);
	} ;
}
