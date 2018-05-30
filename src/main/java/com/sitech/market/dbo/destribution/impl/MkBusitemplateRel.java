package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusitemplateRel;

/**
 * Create on 2015-5-8
 * @author: dongyh
 * @Title: IMkBusitemplaterelTrac
 * @Description： 营销业务模板关联轨迹表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkBusitemplateRel extends DBMysqlClass implements IMkBusitemplateRel {

	/**
	 * Create on 2015-5-8 
	 * @author: dongyh
	 * @Title: saveMkBusitemplaterelTrac 
	 * @Description: 选择模板，保存业务与模板关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkBusitemplateRel(Map map) {
		baseDao.insert("MkBusitemplateRel.insertMkBusitemplateRel", map);
	}

	/**
	 * 查询业务模板信息
	 * Create on 2015-5-9 
	 * @author: wangdw
	 * @Title: selectBusiTemplate 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectBusiTemplate(Map map) {
		List list = baseDao.queryForList("MkBusitemplateRel.selectMkTemplateInfo", map);
		return list;
	}
	/**
	 * 查询业务模板关系表
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: selectMkBusitemplateRel 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusitemplateRel(Map map) {
		List list = baseDao.queryForList("MkBusitemplateRel.selectMkBusitemplateRel", map);
		return list;
	}
	
	/**
	 * Create on 2015-5-26 
	 * @author: dongyh
	 * @Title: updateMkBusitemplateRel 
	 * @Description: 更新模板
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusitemplateRel(Map map){
		baseDao.update("MkBusitemplateRel.updateMkBusitemplateRel", map);
	}

	/**
	 * 删除业务模板关系表
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: deleteMkBusitemplateRel 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkBusitemplateRel(Map map) {
		baseDao.delete("MkBusitemplateRel.deleteMkBusitemplateRel", map);
	}
	
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusitemplateRel 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusitemplateRelForBusiId(Map map) {
		baseDao.update("MkBusitemplateRel.updateMkBusitemplateRelForBusiId", map);
	}
}
