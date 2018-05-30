package com.sitech.market.dbo.destribution.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkBusimeansRel;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkBusimeansRel
* @Description： 营销档次关系
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkBusimeansRel extends DBMysqlClass implements IMkBusimeansRel {
	/**
	 * 根据营销方式id查询活动id
	 * 
	 * @author hanzh_bj Create on 2015-03-11
	 */
	@Override
	public String selectActIdByMeansId(String meanId) {
		String actId = "-1";
		try {
			actId = (String) baseDao.queryForObject("MkBusimeansRel.selectActIdByMeansId", meanId);
		} catch (Exception e) {
			throw new BusiException("-1","selectActIdByMeansId",  "亲,selectActIdByMeansId出异常了,到后台看看吧"+e);
		}
		return actId;
	}

	@Override
	public List selectMkBusimeansRel(Map inMap) {
		List list=baseDao.queryForList("MkBusimeansRel.selectMkBusimeansRel",inMap );
		return list;
	}

	@Override
	public void deleteAllMkBusimeansRelByMeansId(String means_id) {
		baseDao.delete("MkBusimeansRel.deleteAllMkBusimeansRelByMeansId",means_id );
	}

	@Override
	public void insertMkBusimeansRel(Map inMap) {
		baseDao.insert("MkBusimeansRel.insertMkBusimeansRel",inMap );
	}
	
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
	@Override
    public String selectMeansIdByActId(String actId) {
		String meansId = "-1";
		try {
			meansId = (String) baseDao.queryForObject("MkBusimeansRel.selectMeansIdByActId", actId);
		} catch (Exception e) {
			throw new BusiException("-1","selectMeansIdByActId",  "亲,selectMeansIdByActId出异常了,到后台看看吧"+e);
		}
		return meansId;
	}
	
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
	@Override
    public List<String> selectMeansIdListByActId(String actId) {
		List<String> meansIds = new ArrayList<String>();
		try {
			meansIds = baseDao.queryForList("MkBusimeansRel.selectMeansIdByActId", actId);
		} catch (Exception e) {
			throw new BusiException("-1","selectMeansIdListByActId",  "亲,selectMeansIdListByActId出异常了,到后台看看吧"+e);
		}
		return meansIds;
	}
	
	@Override
	public List selectActMeansRelInfo(Map inMap) {
		List list=baseDao.queryForList("MkBusimeansRel.selectActMeansRelInfo",inMap );
		return list;
	}

	@Override
	public void copyMkBusimeansRelByMeansId(Map inMap) {
		baseDao.insert("MkBusimeansRel.copyMkBusimeansRelByMeansId", inMap);
	}
	
}
