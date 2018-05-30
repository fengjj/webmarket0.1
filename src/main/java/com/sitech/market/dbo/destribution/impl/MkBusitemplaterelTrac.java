package com.sitech.market.dbo.destribution.impl;

import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusitemplaterelTrac;

/**
 * Create on 2015-5-9
 * @author: dongyh
 * @Title: MkBusitemplaterelTrac
 * @Description： 营销业务模板关联轨迹表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkBusitemplaterelTrac extends DBMysqlClass implements
		IMkBusitemplaterelTrac {

	/**
	 * Create on 2015-5-9 
	 * @author: dongyh
	 * @Title: insertMkBusitemplaterelTrac 
	 * @Description: 保存轨迹
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkBusitemplaterelTrac(Map map) {
		baseDao.insert("MkBusitemplaterelTrac.insertMkBusitemplaterelTrac", map);
	}

	/**
	 * 
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: deleteMkBusitemplaterelTrac 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusitemplaterelTrac(Map map) {
		baseDao.insert("MkBusitemplaterelTrac.deleteMkBusitemplaterelTrac", map);
	}
	
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusitemplaterelTracForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusitemplaterelTracForBusiId(Map map) {
		baseDao.update("MkBusitemplaterelTrac.updateMkBusitemplaterelTracForBusiId", map);
	}
	
}
