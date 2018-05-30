package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 客户群关系推挤
 * Create on 2015-5-26 
 * @author: wangdw
 * @Title: IMkBusicustgrouprelTrac 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusicustgrouprelTrac {
    /**
     * 插入
     * Create on 2015-5-26 
     * @author: wangdw
     * @Title: insertMkBusicustgrouprelTrac 
     * @Description: 
     * @param inMap 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void insertMkBusicustgrouprelTrac(Map<Object, Object> inMap);
    
    /**
     * 批量插入
     * Create on 2015-5-26 
     * @author: wangdw
     * @Title: batchInsertMkBusicustgrouprelTral 
     * @Description: 
     * @param list 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void batchInsertMkBusicustgrouprelTrac(List<Map> list);
    /**
     * 根据busiId修改busiId
     * Create on 2015-5-26 
     * @author: wangdw
     * @Title: updateMkBusicustgrouprelTracForBusiId 
     * @Description: 
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void updateMkBusicustgrouprelTracForBusiId(Map map);
}
