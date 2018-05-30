package com.sitech.market.dbo.destribution.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkMeanscontentInfo;
import com.sitech.util.CommonUtil;
/**
 * Create on 2015-4-6 
 * @author: hanzh_bj
 * @Title: IMkMeanscontentInfo 
 * @Description： 营销方式内容表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class MkMeanscontentInfo extends DBMysqlClass implements IMkMeanscontentInfo{

	/**
	 * Create on 2015-4-21 
	 * @author: yugl
	 * @Title: queryMkMeanscontentInfoAll 
	 * @Description: 查询档次内容
	 * @param bean
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryMkMeanscontentInfo(Map bean) {  
        return baseDao.queryForList("MkMeanscontentInfo.selectMkMeanscontentInfo",bean );
    }

	/**
     * Create on 2015-4-6 
     * @author: hanzh_bj
     * @Title: queryElementMaxBatchNoByMeansId 
     * @Description: 查询营销方式中各营销元素的最大批次号
     * @param inParamMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List queryElementMaxBatchNoByMeansId(Map<String,String> inParamMap) {
        List<Map> list = null;
        try {
            list =  baseDao.queryForList("MkMeanscontentInfo.selectElementMaxBatchNo",inParamMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException("MkMeanscontentInfo.selectElementMaxBatchNo", "报告大王，查询数据异常");
        }
        return list;
    }
    /**
     * Create on 2015-4-6 
     * @author: zhouwy
     * @Title: queryElementListByMeansId 
     * @Description: 查询营销方式所包含的营销元素
     * @param inParamMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List queryElementListByMeansId(Map inParamMap) {
        List list = null;
        try {
            list =  baseDao.queryForList("MkMeanscontentInfo.selectElementListByMeansId",inParamMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException("MkMeanscontentInfo.selectElementIdByMeansId", "报告大王，查询数据异常");
        }
        return list;
    }
    
    /**
     * Create on 2015-4-6 
     * @author: hanzh_bj
     * @Title: queryElementParInfo 
     * @Description:  查询每一种营销方式包含的营销元素
     * @param inParamMap
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List queryElementParInfo(Map inParamMap) {
        List list = null;
        try {
            list =  baseDao.queryForList("MkMeanscontentInfo.getElementParInfo",inParamMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException("MkMeanscontentInfo.getElementParInfo", "报告大王，查询数据异常");
        }
        return list;
    }
    
    /**
     * Create on 2015-4-6 
     * @author: hanzh_bj
     * @Title: queryMkMeanscontentInfoAll 
     * @Description: 根据meansid查询营销元素
     * @param bean
     * @return 
     * @version 1.0 
     * update_data:       update_author:       update_note:
     */
    public List queryMkMeanscontentInfoAll(Map bean) {  
        return baseDao.queryForList("MkMeanscontentInfo.selectMkMeanscontentInfoAll",bean );
    }
    
	/**
	 * Create on 2015-4-6 
	 * @author: hanzh_bj
	 * @Title: queryMkMeanscontentInfoByMeansId 
	 * @Description:  根据meanId查询档次内容
	 * @param meansId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
    public List queryMeansContentDetailInfo(Map inParam) {
        return baseDao.queryForList("MkMeanscontentInfo.selectMeansContentDetailInfo",inParam);
    }
    
}
