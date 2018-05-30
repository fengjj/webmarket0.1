package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;
/**
 * 业务规则轨迹
 * Create on 2015-5-26 
 * @author: wangdw
 * @Title: IMkBusirulerelTrac 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusirulerelTrac{
	
	/**
	 * 插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: insertMkBusirulerelTrac 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertMkBusirulerelTrac(Map map);
	
	/**
	 * 批量插入
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: batchInsertMkBusirulerelTrac 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkBusirulerelTrac(List<Map> list);
	
	
	/**
	 * 删除
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: deleteMkBusirulerelTrac 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusirulerelTrac(Map map);
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusirulerelTracForBusiId 
	 * @Description: 
	 * @param map (newBusiId,oldBusiId)
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusirulerelTracForBusiId(Map map);
}
