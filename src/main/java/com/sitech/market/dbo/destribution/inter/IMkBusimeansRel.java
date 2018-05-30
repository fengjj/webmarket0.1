package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkBusimeansRel
* @Description： 营销档次关系
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkBusimeansRel {
    /**
     * 根据营销方式id查询活动id
     * 
     * @author hanzh_bj Create on 2015-03-11
     */
    public String selectActIdByMeansId(String meanId);
    
    /**
     * Create on 2015-5-30 
     * @author: gengws
     * @Title: selectMkBusimeansRel 
     * @Description: 所有条件查询MkBusimeansRel
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List selectMkBusimeansRel(Map inMap);
    
    /**
     * Create on 2015-6-4 
     * @author: durui
     * @Title: deleteMkBusimeansRelById 
     * @Description: 根据档次ID删除记录
     * @param means_id
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void deleteAllMkBusimeansRelByMeansId(String means_id);
    
    /**
     * Create on 2015-6-4 
     * @author: durui
     * @Title: insertMkBisimeansRel 
     * @Description: 将档次与活动的对应关系入关系表
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void insertMkBusimeansRel(Map inMap);
    /**
     * 根据活动ID查询方式ID
     * Create on 2015-6-8 
     * @author: wangdw
     * @Title: selectMeansIdByActId 
     * @Description: 
     * @param actId
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public String selectMeansIdByActId(String actId);
    /**
     * 根据活动ID查询方式ID
     * Create on 2015-6-8 
     * @author: wangdw
     * @Title: selectMeansIdByActId 
     * @Description: 
     * @param actId
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List selectMeansIdListByActId(String actId);
    /**
     * Create on 2015-6-4 
     * @author: qijh
     * @Title: insertMkBisimeansRel 
     * @Description: 查询档次列表
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	List selectActMeansRelInfo(Map inMap);

  

    /**
     * Create on 2015-6-4 
     * @author: qijh
     * @Title: copyMkBusimeansRelByMeansId 
     * @Description: 复制档次关系数据
     * @param inMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	public void copyMkBusimeansRelByMeansId(Map busiMeanMap);
}

