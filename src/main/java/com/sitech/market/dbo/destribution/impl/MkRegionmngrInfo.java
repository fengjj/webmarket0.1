package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkRegionmngrInfo;

public class MkRegionmngrInfo extends DBMysqlClass implements IMkRegionmngrInfo{
    
	/**
     * Create on 2015-5-18 
     * @author: dongyh
     * @Title: queryRegmngrInfoByLoginNo 
     * @Description: 查询地市管理员信息
     * @param map
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	public List selectMkRegionmngrInfo(Map map){
        return baseDao.queryForList("MkRegionmngrInfo.selectMkRegionmngrInfo",map);
    }
	
}
