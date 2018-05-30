package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 内容dbo
 * Create on 2015-5-11 
 * @author: wangdw
 * @Title: IMkContentInfo 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkContentInfo {
	
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
	public Map selectMkContentInfoById(String contentSerialId);
	
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
	public List selectMkContentInfo(Map map);
	
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
	public List selectMkContentInfoByBusiId(Map map);
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
	public void insertMkContentInfo(Map map) ;
	
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
	public void insertBatchMkContentInfo(List<Map> list) ;
	
	/**
	 * Create on 2015-6-22
	 * @author: jiaxla
	 * @Title: deleteMkContentInfoById 
	 * @Description: 删除内容数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkContentInfoById(Map map) ;
	
	/**
	 * Create on 2015-6-22
	 * @author: jiaxla
	 * @Title: updateMkContentInfo 
	 * @Description: 更新内容数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkContentInfo(Map map) ;
	
	/**
	 * Create on 2015-6-22
	 * @author: jiaxla
	 * @Title: updateMkContentInfoById 
	 * @Description: 根据relid更新内容数据
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkContentInfoById(Map map) ;
	
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
	public void updateMkContentInfoNameById(Map map);
	

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
	public void copyMkContentInfo(Map map);
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
	public List queryMeansContentInfobymeansId(List means);
}
