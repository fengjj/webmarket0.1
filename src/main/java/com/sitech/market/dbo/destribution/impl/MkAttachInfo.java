package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkAttachInfo;

/**
 * Create on 2015-5-14
 * @author: dongyh
 * @Title: IMkAttachInfo
 * @Description： 附件表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkAttachInfo extends DBMysqlClass  implements IMkAttachInfo {

	/**
	 * Create on 2015-5-14 
	 * @author: dongyh
	 * @Title: saveMkAttachInfo 
	 * @Description:  保存附件
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void saveMkAttachInfo(Map map) {
		baseDao.insert("MkAttachInfo.insertMkAttachInfo", map);
	}
	
	/**
	 * Create on 2015-6-2 
	 * @author: dongyh
	 * @Title: selectMkAttachInfo 
	 * @Description: 根据附件ID查询
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkAttachInfoById(Map map){
		return baseDao.queryForList("MkAttachInfo.selectMkAttachInfoById", map);
	}
	
	/**
	 * Create on 2015-6-2 
	 * @author: dongyh
	 * @Title: selectMkAttachInfoByBusiId 
	 * @Description: 根据业务关系查询附件
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkAttachInfoByBusiId(Map map){
		return baseDao.queryForList("MkAttachInfo.selectMkAttachInfoByBusiId", map);
	}
	
	/**
	 * Create on 2015-6-14 
	 * @author: dongyh
	 * @Title: deleteMkAttachInfoById 
	 * @Description: 删除附件
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkAttachInfoById(Map map){
		baseDao.delete("MkAttachInfo.deleteMkAttachInfoById", map);
	}
	
}
