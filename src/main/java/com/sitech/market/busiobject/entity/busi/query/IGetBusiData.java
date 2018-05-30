/**
 * 
 */
package com.sitech.market.busiobject.entity.busi.query;

import java.util.List;
import java.util.Map;

/** 
 * Create on 2015年5月11日 
 * @author: fengjj
 * @Title: IGetBusiData 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note: 
 */
public interface IGetBusiData {

    /**
     * 查询业务数据公共方法
     * Create on 2015年5月11日
     * @author:fengjj
     * @Title: getBusiData
     * @Description: 查询业务数据公共方法
     * @param inMap
     * @return
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public Map<String,Object> getBusiData(List<Map<Object,Object>> elementList,Map<Object,Object> inMap);
}
