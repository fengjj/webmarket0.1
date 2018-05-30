package com.sitech.market.dbo.destribution.impl;

import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkResourceTicketInfo;
/**
 * 资源信息表
 * Create on 2015-7-13 
 * @author: zhangxfa
 * @Title: MkResourceTicketInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkResourceTicketInfo extends DBMysqlClass implements IMkResourceTicketInfo {

	/**
	 * 保存资源信息
	 * Create on 2015-7-13 
	 * @author: zhangxfa
	 * @Title: insertMkActaddInfo 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkResourceTicketInfo(Map map) {
		
		System.out.println("map: "+map);
		baseDao.insert("MkResourcetempInfo.insertMkResourcetempInfo",map);
	}

	@Override
	public Map selectResourceInfoById(String resource_id) {
		Map map=  (Map)baseDao.queryForObject("MkResourcetempInfo.selectMkResourcetempInfoById",resource_id);
		return map;
	}

	@Override
	public void updateMkResourceTicketInfo(Map map) {
		System.out.println("map: "+map);
		baseDao.update("MkResourcetempInfo.updateMkResourcetempInfoById",map);
	}

	@Override
	public void deleteResourceInfoById(Map map) {
		baseDao.delete("MkResourcetempInfo.deleteMkResourcetempInfoById",map);
	}
	
	
	
}
