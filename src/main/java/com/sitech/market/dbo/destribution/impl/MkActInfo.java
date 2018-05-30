package com.sitech.market.dbo.destribution.impl;

import java.util.List;
import java.util.Map;
import com.sitech.jcf.core.exception.BusiException;
import com.sitech.market.busiobject.basicclass.dbclass.DBMysqlClass;
import com.sitech.market.dbo.destribution.inter.IMkActInfo;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: MkActInfo
* @Description： 营销活动
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class MkActInfo extends DBMysqlClass implements IMkActInfo {
	/**
	 * Create on 2015-4-21 
	 * @author: yugl
	 * @Title: queryAllActInfoByParam 
	 * @Description: 关联目标客户群查询营销活动列表
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectAllActInfoByParam(Map paramMap) {
		return baseDao.queryForList("MkActInfo.selectAllActInfoByParam", paramMap);
	}

	public String selectUniqueActId(String actId) {
		String uniqueId = "";
		System.out.println("getUniqueActId.actId=" + actId);
		if (null != actId && !"".equals(actId)) {
			Map map = queryMkActInfoById(actId);
			if (null != map && map.size() > 0) {
				uniqueId = (String) map.get("uniqueActId");
			}
			System.out.println("getUniqueActId.uniqueId=" + uniqueId);
		}
		return uniqueId;
	}
	
	/**
	 * Create on 2015-4-22 
	 * @author: yugl
	 * @Title: queryMkActInfoById 
	 * @Description: 根据主键查询活动信息
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryMkActInfoById(String actId) {
		return (Map) baseDao.queryForObject("MkActInfo.selectMkActInfoById", actId);
	}
	
	public Map queryActionByMeansId(Map paramMap) {
        Map map = null;
        try {
            map = (Map) baseDao.queryForObject(
                    "MkActInfo.selectActionByMeansId", paramMap);
        } catch (Exception e) {
            throw new BusiException("MkActInfo.selectActInfoByMeansIdArr", e
                    + "报告大王，查询数据的时候出错了！");
        }
        return map;
    }
	
	/**
	 * Create on 2015-4-22 
	 * @author: gengws
	 * @Title: selectMkActInfo 
	 * @Description: 通过所有条件查询mk_act_info
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List selectMkActInfo(Map inMap) {

		List list=baseDao.queryForList("MkActInfo.selectMkActInfo", inMap);
		
		return list;
	}
	
	/**
	 * Create on 2015-5-29 
	 * @author: dongyh
	 * @Title: queryFuzzyActName 
	 * @Description: 活动策划首页,模糊查询活动
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryFuzzyActName(Map map){
		return baseDao.queryForList("MkActInfo.selectMkActInfoByFuzzyActName", map);
	}

	/**
	 * 插入活动基本信息
	 * Create on 2015-4-21 
	 * @author: wangdw
	 * @Title: insertActInfo 
	 * @Description: 
	 * @param paramMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void insertActInfo(Map paramMap) {
		baseDao.insert("MkActInfo.insertMkActInfo",paramMap);
	}

	/**
	 * Create on 2015-5-5 
	 * @author: dongyh
	 * @Title: removeActInfo 
	 * @Description: 删除活动
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void removeActInfo(Map inMap) {
		String actId = (String) inMap.get("actId");
		baseDao.delete("MkActInfo.deleteMkActInfoById", actId);
	}
	/**
	 * 更新活动
	 * Create on 2015-5-7 
	 * @author: wangdw
	 * @Title: updateActInfo 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateActInfo(Map inMap) {
		baseDao.update("MkActInfo.updateMkActInfo", inMap);
	}
	/**
	 * 根据活动id更新活动信息
	 * Create on 2015-5-17 
	 * @author: wangdw
	 * @Title: updateActInfoById 
	 * @Description: 
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public void updateActInfoById(Map inMap) {
		baseDao.update("MkActInfo.updateMkActInfoById", inMap);
	}

	/**
	 * Create on 2015-6-2 
	 * @author: lixd_bj
	 * @Title: selectMkActInfoByFuzzyActNamePaging 
	 * @Description: 通过条件分页查询mk_act_info
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> selectMkActInfoByFuzzyActNamePaging(Map inMap,int beginNum,int endNum) {
		List list=baseDao.queryForListBeginEnd("MkActInfo.selectMkActInfoByFuzzyActName", inMap,beginNum,endNum);
		return list;
	}
	
	/**
	 * Create on 2015-6-2 
	 * @author: lixd_bj
	 * @Title: selectMkActInfoByFuzzyActNamePaging 
	 * @Description: 通过条件分页查询mk_act_info
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List<Map> quertActSumByActType(Map paramMap){
		return baseDao.queryForList("MkActInfo.selectActSumByActType",paramMap);
	}
    
	/**
	 * Create on 2015-6-5 
	 * @author: xiongxin
	 * @Title: selectActIdsByMap 
	 * @Description: 根据actClass及其actType来确定actId的值
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	@Override
	public List queryActIdsByMap(Map paramMap) {
		return	baseDao.queryForList("MkActInfo.selectActIdsByMap",paramMap);
	}
	
	/**
	 * Create on 2015-4-22 
	 * @author: yugl
	 * @Title: queryMkActInfoById 
	 * @Description: 根据主键查询活动信息
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryMKsmscfgInfoById(Map paramMap) {
		return (Map) baseDao.queryForObject("MkActInfo.selectMKsmscfgInfoById", paramMap);
	}
	
	/**
	 * Create on 2015-09-12 
	 * @author: tangll
	 * @Title: queryMkActInfoById 
	 * @Description: 
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void insertSmscfg(Map paramMap) {
		baseDao.insert("MkActInfo.insertMkSmscfgInfo",paramMap);
	}
	
	
	/**
	 * Create on 2015-09-15 
	 * @author: tangll
	 * @Title: insertSmscfg 
	 * @Description: 
	 * @param actId
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkSmscfgInfo(String busiId) {
		baseDao.delete("MkActInfo.deleteMkSmscfgInfo",busiId);
	}
}
