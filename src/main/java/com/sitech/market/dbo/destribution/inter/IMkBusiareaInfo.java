package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;
/**
 * Create on 2015-4-20 
 * @author: yugl
 * @Title: IMkBusiareaInfo 
 * @Description： 业务区域表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusiareaInfo {
	/**
	 * Create on 2015-4-20 
	 * @author: yugl
	 * @Title: selectMkBusiareaInfo 
	 * @Description: 查询业务区域表
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusiareaInfo(Map map);
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: batchInsertMkBusiareaInfo 
	 * @Description: 批量保存业务区域信息
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkBusiareaInfo(List<Map> list);
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: batchInsertMkBusiareaInfo 
	 * @Description: 根据busiId删除业务区域信息
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusiareaInfoByBusiId(Map map);
	
	/**
	 * 根据busiId，更新busiId
	 * @Create on 2015-6-23 
	 * @author: wangdw
	 * @Title: updateMkBusiareaInfoForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public void updateMkBusiareaInfoForBusiId(Map map);
}
