package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: IMkActInfo
* @Description： 营销活动
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public interface IMkActInfo {
	
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
	public List<Map> selectAllActInfoByParam(Map paramMap);
	
	public Map queryActionByMeansId(Map paramMap);
	
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
	public List<Map> selectMkActInfo(Map inMap);

	public String selectUniqueActId(String actId);
	
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
	
	public Map queryMkActInfoById(String actId);
	
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
	public void insertActInfo(Map paramMap);
	
	/**
	 * Create on 2015-5-5 
	 * @author: dongyh
	 * @Title: removeActInfo 
	 * @Description: 删除活动
	 * @param inMap 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void removeActInfo(Map inMap);
	
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
	public void updateActInfo(Map inMap) ;
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
	public void updateActInfoById(Map inMap);
	
	/**
	 * Create on 2015-5-29 
	 * @author: dongyh
	 * @Title: queryFuzzyActName 
	 * @Description: 活动策划首页,模糊查询活动
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryFuzzyActName(Map map);
	
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
	public List<Map> selectMkActInfoByFuzzyActNamePaging(Map inMap,int beginNum,int endNum);
	
	/**
	 * Create on 2015-6-7 
	 * @author: lixd_bj
	 * @Title: selectMkActInfoByFuzzyActNamePaging 
	 * @Description: 通过条件分页查询mk_act_info
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> quertActSumByActType(Map paramMap);
	
	public List queryActIdsByMap(Map paramMap);
	
	public Map queryMKsmscfgInfoById(Map inMap);
	public void insertSmscfg(Map paramMap);
	public void deleteMkSmscfgInfo(String busiId);
}
