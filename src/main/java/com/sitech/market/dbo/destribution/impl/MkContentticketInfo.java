package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkContentInfo;
import com.sitech.market.dbo.destribution.inter.IMkContentfeeInfo;
import com.sitech.market.dbo.destribution.inter.IMkContentticketInfo;

/**
 * Create on 2015-5-27 
 * @author: yugl
 * @Title: MkContentfeeInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkContentticketInfo extends DBMysqlClass implements IMkContentticketInfo {
	
	/**
	 * Create on 2015-5-27
	 * @author: yugl
	 * @Title: selectMkContentInfo 
	 * @Description: 查询券内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkContentticketInfo(Map map) {
		return baseDao.queryForList("MkContentticketInfo.selectMkContentticketInfo", map);
	}
	
	/**
	 * Create on 2015-6-4 
	 * @author: yugl
	 * @Title: selectMkContentticketInfoById 
	 * @Description: 根据主键查询
	 * @param serialId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map selectMkContentticketInfoById(String serialId) {
		return (Map)baseDao.queryForObject("MkContentticketInfo.selectMkContentticketInfoById", serialId);
	}
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: insertMkContentticketInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkContentticketInfo(Map map) {
		baseDao.insert("MkContentticketInfo.insertMkContentticketInfo", map);
	}
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: updateMkContentticketInfo 
	 * @Description: 更新数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int updateMkContentticketInfo(Map map) {
		return baseDao.update("MkContentticketInfo.updateMkContentticketInfoById", map);
	}
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: deleteMkContentticketInfoById 
	 * @Description: 删除数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public int delInfoById(Map map) {
		return baseDao.delete("MkContentticketInfo.deleteMkContentticketInfoById", map);
	}

	@Override
	public void insertInfo(Map map) {
		if ("A25".equals(map.get("elementId"))) {
			map.put("ticketType", "0");
		}
		baseDao.insert("MkContentticketInfo.insertMkContentticketInfo", map);
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
		baseDao.insert("MkContentticketInfo.copyMkContentticketInfo", map);
	} 
}
