package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;

import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkContentInfo;
/**
 * 内容dbo
 * Create on 2015-5-11 
 * @author: wangdw
 * @Title: MkContentInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
@SuppressWarnings("unchecked")
public class MkContentInfo extends DBMysqlClass implements IMkContentInfo {

	/**
	 * Create on 2015-5-21 
	 * @author: yugl
	 * @Title: selectMkContentInfoById 
	 * @Description: 根据主键查询内容表
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public Map selectMkContentInfoById(String contentSerialId) {
		return (Map)baseDao.queryForObject("MkContentInfo.selectMkContentInfoById", contentSerialId);
	}
	
	  /**
     * 根据meansId查询档次内容
     * Create on 2015-7-25
     * @Author wenzt
     * @Title queryMeansContentInfobymeansId
     * @param map 
     * @return 
     * @Throws 
     * @Version 1.0
     * update_data:      update_author:      update_note:
     */
	public List queryMeansContentInfobymeansId(List means){
		
		return null;
	}
	/**
	 * Create on 2015-5-21 
	 * @author: yugl
	 * @Title: selectMkContentInfo 
	 * @Description: 查询内容表
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkContentInfo(Map map) {
		return baseDao.queryForList("MkContentInfo.selectMkContentInfo", map);
	}
	
	/**
	 * Create on 2015-5-26 
	 * @author: yugl
	 * @Title: selectMkContentInfoByBusiId 
	 * @Description: 根据busiId查询业务下的内容表数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkContentInfoByBusiId(Map map) {
		return baseDao.queryForList("MkContentInfo.selectMkContentInfoByBusiId", map);
	}
	
	/**
	 * Create on 2015-6-6
	 * @author: zhangchen
	 * @Title: insertMkContentInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertMkContentInfo(Map map) {
		baseDao.insert("MkContentInfo.insertMkContentInfo", map);
	}
	
	/**
	 * 批量插入
	 * @Create on 2015-6-29 
	 * @author: wangdw
	 * @Title: insertBatchMkContentInfo 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public void insertBatchMkContentInfo(List<Map> list)  {
		baseDao.batchInsert("MkContentInfo.insertMkContentInfo", list);
	}
	
	/**
	 * Create on 2015-6-22
	 * @author: zhangchen
	 * @Title: insertMkContentInfo 
	 * @Description: 插入数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void deleteMkContentInfoById(Map map) {
		baseDao.insert("MkContentInfo.deleteMkContentInfoById", map);
	}
	
	/**
	 * Create on 2015-6-22
	 * @author: jiaxla
	 * @Title: updateMkContentInfo 
	 * @Description: 更新内容
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkContentInfo(Map map) {
		baseDao.update("MkContentInfo.updateMkContentInfoById", map);
	}
	
	/**
	 * Create on 2015-6-22
	 * @author: jiaxla
	 * @Title: updateMkContentInfoById 
	 * @Description: 更新内容根据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateMkContentInfoById(Map map) {
		baseDao.update("MkContentInfo.updateMkContentInfoById", map);
	}


    /**
     * 根据content_serial_id更新营销内容名称
     * Create on 2015-7-25
     * @Author wengpc 
     * @Title updateMkContentInfoNameById
     * @param map 
     * @return 
     * @Throws 
     * @Version 1.0
     * update_data:      update_author:      update_note:
     */
	@Override
	public void updateMkContentInfoNameById(Map map) {
		
		try{
		
		 baseDao.update("MkContentInfo.updateMkContentInfoNameById", map);
	
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	
	}
	

    /**
     * 根据content_serial_id复制营销详细内容名
     * Create on 2015-7-25
     * @Author wangpei
     * @Title copyMkContentInfo
     * @param map 
     * @return 
     * @Throws 
     * @Version 1.0
     * update_data:      update_author:      update_note:
     */
	@Override
	public void copyMkContentInfo(Map map){
		baseDao.insert("MkContentInfo.copyMkContentInfo", map);
	};

}
