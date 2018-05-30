package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkAuditresultInfo
* @Description： 审批结果
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkAuditresultInfo {
	/**
	 * 查询活动审批历史数据
	 *  Create on 2014-11-13 上午11:45:21
	 * @author tianyy_bj
	 * @version 1.0
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 * 功能描述：
	 * 修改日期:     修改人:     修改目的:
	 */
	public List<Map> queryAuditHisList(Map inParam);

    /**
	 * 更新审批结果
	 * Create on 2014-11-13 上午11:45:21
	 * @author tianyy_bj
	 * @version 1.0
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 * 功能描述：
	 * 修改日期:     修改人:     修改目的:
	 */
    public Map updateAuditResult(Map auditMap);
    
    /**
     * Create on 2015-5-11 
     * @author: dongyh
     * @Title: insertMkAuditresultInfo 
     * @Description: 保存提交审批
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public void insertMkAuditresultInfo(Map map);
    
    /**
	 * Create on 2015-6-1 
	 * @author: dongyh
	 * @Title: selectMkAuditresultInfo 
	 * @Description: 查询活动审批
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkAuditresultInfo(Map map);
	
	public List<Map> selectMkAuditresultInfoName(Map map);

    /**
	 * Create on 2015-6-26
	 * @author: liuhaoa
	 * @Title: selectMkAuditresultInfo 
	 * @Description: 查询活动审批总条数
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkAuditresultInfoCount(Map inMap);
}
