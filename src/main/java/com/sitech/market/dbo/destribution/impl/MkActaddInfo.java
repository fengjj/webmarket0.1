package com.sitech.market.dbo.destribution.impl;

import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkActaddInfo;
/**
 * 营销活动附加表
 * Create on 2015-4-21 
 * @author: wangdw
 * @Title: MkActaddInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkActaddInfo extends DBMysqlClass implements IMkActaddInfo {

	/**
	 * 计入营销活动附加表
	 * Create on 2015-4-21 
	 * @author: wangdw
	 * @Title: insertMkActaddInfo 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkActaddInfo(Map inparam) {
		baseDao.insert("MkActaddInfo.insertMkActaddInfo",inparam);
	}
	
	/**
	 * Create on 2015-4-24 
	 * @author: yugl
	 * @Title: selectMkActaddInfoByActId 
	 * @Description: 根据活动id查询活动附加表
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map selectMkActaddInfoByActId(String actId){
		return (Map)baseDao.queryForObject("MkActaddInfo.selectMkActaddInfoByActId",actId);
	}
	/**
	 * 更新活动附加信息表
	 * Create on May 21, 2015 
	 * @author: wangdw
	 * @Title: updateMkActaddInfoByActId 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkActaddInfoByActId(Map inMap) {
		baseDao.update("MkActaddInfo.updateMkActaddInfoByActId",inMap);
	}
	
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkActaddInfo 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkActaddInfoForBusiId(Map map) {
		baseDao.update("MkActaddInfo.updateMkActaddInfoForBusiId", map);
	}
	
	/**
	 * 删除
	 * Create on 2015-5-28 
	 * @author: wangdw
	 * @Title: deleteMkActaddInfo 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkActaddInfo(Map map) {
		baseDao.delete("MkActaddInfo.deleteMkActaddInfo", map);
	}
}
