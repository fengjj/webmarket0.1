package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkBusicustgroupRel
* @Description： 客户群关系
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkBusicustgroupRel {
    /**
     * Create on 2015-5-4 
     * @author: fengjj
     * @Title: insertMkBusiareaInfo 
     * @Description: 保存活动客户群信息
     * @param list 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void insertIMkBusicustgroupRel(Map<Object, Object> inMap);
    
    /**
     * 批量插入
     * Create on 2015-5-22 
     * @author: wangdw
     * @Title: batchInsertIMkBusicustgroupRel 
     * @Description: 
     * @param list 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void batchInsertIMkBusicustgroupRel(List<Map> list);
    /**
     * Create on 2015-5-4 
     * @author: fengjj
     * @Title: insertMkBusiareaInfo 
     * @Description: 保存活动客户群信息
     * @param list 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List<Object> selectCustGroup(Map<Object, Object> inMap);
    /**
     * Create on 2015年5月9日
     * @author:fengjj
     * @Title: deleteIMkBusicustgroupRel
     * @Description: TODO 
     * @param inMap
     * @version 1.0
     * update_data:     update_author:     update_note:
     */
    public void deleteIMkBusicustgroupRel(String serialId);
    
    /**
     * 查询业务关系表
     * Create on 2015-5-22 
     * @author: wangdw
     * @Title: selectMkBusicustgroupRel 
     * @Description: 
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List selectMkBusicustgroupRel(Map inMap);
    /**
     * 根据busiId更新busiId
     * Create on 2015-5-26 
     * @author: wangdw
     * @Title: updateMkBusicustgroupRelForBusiId 
     * @Description: 
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void updateMkBusicustgroupRelForBusiId(Map map) ;
    /**
     * 根据busiId和busiType删除
     * Create on 2015-5-28 
     * @author: wangdw
     * @Title: deleteMkBusicustgroupRelByBusiId 
     * @Description: 
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void deleteMkBusicustgroupRelByBusiId(Map map);
    
    /** 
     * Create on 2015-6-24 
     * @author: songxj
     * @Title: updateMkBusicustgroupRelById 
     * @Description: 根据serialId更新mk_busicustgroup_rel表信息
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note: 
     */
    public void updateMkBusicustgroupRelById(Map map);
    /**
     * 根据业务id和业务type更新业务客户群关系表
     * @Create on 2015-7-30 
     * @author: wangdw
     * @Title: updateByBusi 
     * @Description: 
     * @param inParam 
     * @version 1.0 
     * update_date:       update_author:       update_note:
     */
    public void updateByBusi(Map inParam);
}
