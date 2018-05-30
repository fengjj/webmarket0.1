package com.sitech.market.dbo.destribution.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkMeansInfo;
import com.sitech.util.Const;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkMeansInfo
* @Description： 营销方式
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkMeansInfo extends DBMysqlClass implements IMkMeansInfo {

	/**
	 * Create on 2015-4-21 
	 * @author: yugl
	 * @Title: selectMeansInfoJoinBusiRel 
	 * @Description: 关联busimeansrel表查询档次信息
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectMeansByBusiId(Map<String, String> paramMap) {
			return baseDao.queryForList("MkMeansInfo.selectMeansByBusiId",paramMap);
	}
	/**
     * 根据主键查询营销方式 Create on 2015-01-5
     * 
     * @author yugl
     * @version 1.0 Copyright(c) 北京思特奇信息技术股份有限公司 功能描述：根据主键查询营销方式 修改日期: 修改人:
     *          修改目的:
     */
    public Map selectMeansInfoById(String meansId) {
        Map meansMap = null;
        System.out.println("meansId==================="+meansId);
        try {
            meansMap = (Map) baseDao.queryForObject(
                    "MkMeansInfo.selectMkMeansInfoById", meansId);
        } catch (Exception e) {
            throw new BusiException("MkMeansInfo.selectMkMeansInfoById", e
                    + "报告大王，查询数据的时候出错了！");
        }
        System.out.println("meansMap======================="+meansMap);
        return meansMap;
    }
    /**
	 * Create on 2015-4-22 
	 * @author: gengws
	 * @Title: selectMkMeansInfo 
	 * @Description: 查询mk_means_info中的所有信息
	 * @param inMap
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkMeansInfo(Map inMap) {
		List list=baseDao.queryForList("MkMeansInfo.selectMkMeansInfo", inMap);
		return list;
	}
	/**
	 * Create on 2015-06-04
	 * @author: durui
	 * @Title: deleteMkMeansInfoById
	 * @Description: 删除营销档次
	 * @param String
	 * @return
	 * @version 1.0
	 * update_data:         update_author:          update_note
	 */
	@Override
	public void deleteMkMeansInfoById(String means_Id){
		baseDao.delete("MkMeansInfo.deleteMkMeansInfoById", means_Id);
	}
	
	/**
	 * Create on 2015-06-04
	 * @author: durui
	 * @Title: insertMkMeansInfo
	 * @Description: 保存档次基本信息
	 * @param String
	 * @return
	 * @version 1.0
	 * update_data:         update_author:          update_note
	 */
	@Override
	public void insertMkMeansInfo(Map inMap){
		baseDao.insert("MkMeansInfo.insertMkMeansInfo", inMap);
	}
	
	/**
	 * 批量保存
	 * @Create on 2015-6-29 
	 * @author: wangdw
	 * @Title: insertBatchMkMeansInfo 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	@Override
	public void insertBatchMkMeansInfo(List<Map> list) {
		baseDao.batchInsert("MkMeansInfo.insertMkMeansInfo", list);
	}
	
	/**
	 * Create on 2015-06-04
	 * @author: qijh
	 * @Title: insertMkMeansInfo
	 * @Description: 复制档次基本信息
	 * @param String
	 * @return
	 * @version 1.0
	 * update_data:         update_author:          update_note
	 */
	@Override
	public void copyMkMeansInfoByMeanId(Map inMap){
		baseDao.insert("MkMeansInfo.copyMkMeansInfoByMeanId", inMap);
	}
	
	/**
	 * Create on 2015-06-30
	 * @author: lixd_bj
	 * @Title: updateMkMeansInfoByMeansId
	 * @Description: 根据meansID更新档次信息
	 * @param inMap
	 * @return
	 * @version 1.0
	 * update_data:         update_author:          update_note
	 */
	public void updateMkMeansInfoByMeansId(Map inMap){
		baseDao.update("MkMeansInfo.updateMkMeansInfo", inMap);
	}
}
