package com.sitech.market.dbo.destribution.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkAuditresultInfo;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkAuditresultInfo
* @Description： 审批结果
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkAuditresultInfo  extends DBMysqlClass implements IMkAuditresultInfo {

	/**
	 * 查询活动审批历史数据
	 * @author hanzh_bj
	 * Create on 2014-11-13 上午11:45:21
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 * 功能描述：
	 * 修改日期:     修改人:     修改目的:
	 */
	@Override
	public List<Map> queryAuditHisList(Map inParam) {
		List<Map> auditList =  baseDao.queryForList("MkAuditresultInfo.queryAuditHisList",inParam);
		return auditList;
	}
	
    /**
	 * 更新审批结果
	 * Create on 2014-11-13 上午11:45:21
	 * @author tianyy_bj
	 * @version 1.0
	 * Copyright(c) 北京思特奇信息技术股份有限公司
	 * 功能描述：
	 * 修改日期:     修改人:     修改目的:
	 */
	@Override
	public Map updateAuditResult(Map inParam) {
		Map result = new HashMap();
	    result.put("resultBean",baseDao.update("MkAuditresultInfo.updateMkAuditresultInfoById",inParam));
		return result;
	}

	/**
     * Create on 2015-5-11 
     * @author: dongyh
     * @Title: insertMkAuditresultInfo 
     * @Description: 保存提交审批
     * @param map 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
	public void insertMkAuditresultInfo(Map map) {
		baseDao.insert("MkAuditresultInfo.insertMkAuditresultInfo", map);
	}
	
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
	public List<Map> selectMkAuditresultInfo(Map map) {
		int beginNum = Integer.parseInt((String)map.get("beginNum"));
		int endNum = Integer.parseInt((String)map.get("endNum"));
		return baseDao.queryForListBeginEnd("MkAuditresultInfo.selectMkAuditresultInfo", map, beginNum, endNum);
	}

	public List<Map> selectMkAuditresultInfoName(Map map) {
		return baseDao.queryForList("MkAuditresultInfo.selectMkAuditresultInfo", map);
	}
	
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
	@Override
	public List<Map> selectMkAuditresultInfoCount(Map inMap) {
		List list = baseDao.queryForList("MkAuditresultInfo.selectMkAuditresultInfoCount", inMap);
		return list;
	}
}
