package com.sitech.market.dbo.destribution.impl;

import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusiareaTrac;

public class MkBusiareaTrac extends DBMysqlClass implements IMkBusiareaTrac {
	/**
	 * 根据busiId，更新busiId
	 * @Create on 2015-6-23 
	 * @author: wangdw
	 * @Title: updateMkBusiareaTracForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public void updateMkBusiareaTracForBusiId(Map map) {
		baseDao.update("MkBusiareaTrac.updateMkBusiareaTracForBusiId", map);
	}
}
