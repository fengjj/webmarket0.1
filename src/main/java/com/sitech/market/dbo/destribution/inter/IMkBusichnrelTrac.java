package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;
/**
 * 业务渠道关系轨迹
 * Create on 2015-5-26 
 * @author: wangdw
 * @Title: IMkBusichnrelTrac 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusichnrelTrac {
    /**
     * 插入
     * Create on 2015-5-26 
     * @author: wangdw
     * @Title: insertMkBusichnrelTrac 
     * @Description: 
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	public void insertMkBusichnrelTrac(Map map) ;
	
	/**
	 * 批量插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: batchInsertMkBusichnrelTrac 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkBusichnrelTrac(List<Map> list);
	
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusichnrelTracForBusiId 
	 * @Description: 
	 * @param map （oldBusiId，newBusiId）
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusichnrelTracForBusiId(Map map);
}
