package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkContentInfo;
import com.sitech.market.dbo.destribution.inter.IMkContentfeeInfo;

/**
 * Create on 2015-5-27 
 * @author: yugl
 * @Title: MkContentfeeInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkContentfeeInfo extends DBMysqlClass implements IMkContentfeeInfo {
	
	/**
	 * Create on 2015-5-27
	 * @author: yugl
	 * @Title: selectMkContentInfo 
	 * @Description: 查询费用内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkContentfeeInfo(Map map) {
		return baseDao.queryForList("MkContentfeeInfo.selectMkContentfeeInfo", map);
	}
	
	/**
	 * Create on 2015-5-30 
	 * @author: yugl
	 * @Title: selectMkContentfeeInfoById 
	 * @Description: 根据主键查询
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map selectMkContentfeeInfoById(String serialId) {
		return (Map)baseDao.queryForObject("MkContentfeeInfo.selectMkContentfeeInfoById", serialId);
	}
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: insertMkContentfeeInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkContentfeeInfo(Map map) {
		baseDao.insert("MkContentfeeInfo.insertMkContentfeeInfo", map);
	}
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: updateMkContentfeeInfo 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int updateMkContentfeeInfo(Map map) {
		return baseDao.update("MkContentfeeInfo.updateMkContentfeeInfoById", map);
	}
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: deleteMkContentfeeInfoById 
	 * @Description: 删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int delInfoById(Map map) {
		return baseDao.delete("MkContentfeeInfo.deleteMkContentfeeInfoById", map);
	}
	/**
	 * Create on 2015-6-6
	 * @author: jiaxla
	 * @Title: deleteMkContentfeeInfoByContentSerialId 
	 * @Description: 删除数据
	 * @param contentSerialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int deleteMkContentfeeInfoByContentSerialId(String contentSerialId) {
		return baseDao.delete("MkContentfeeInfo.deleteMkContentfeeInfoByContentSerialId", contentSerialId);
	}

	@Override
	public void insertInfo(Map map) {
		baseDao.insert("MkContentfeeInfo.insertMkContentfeeInfo", map);
	}
	@Override
	public void copyInfo(Map map) {
		baseDao.insert("MkContentfeeInfo.copyMkContentfeeInfo", map);
	}
}
