package com.sitech.market.dbo.destribution.impl;

import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkAttachTrac;

/**
 * Create on 2015-5-14
 * @author: dongyh
 * @Title: IMkAttachTrac
 * @Description： 附件轨迹表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkAttachTrac extends DBMysqlClass implements IMkAttachTrac {

	/**
	 * Create on 2015-5-14 
	 * @author: dongyh
	 * @Title: saveMkAttachTrac 
	 * @Description: 保存附件轨迹
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void saveMkAttachTrac(Map map) {
		baseDao.insert("MkAttachTrac.insertMkAttachTrac", map);
	}
	
}
