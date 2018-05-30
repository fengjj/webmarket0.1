package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

public interface IMkBusichnRel {
    
	/**
	 * Create on 2015-4-21 
	 * @author: yugl
	 * @Title: queryBusiIdByChnType 
	 * @Description: 查询业务的渠道
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryBusiIdByChnType(Map paramMap);
	
	/**
	 * Create on 2015-7-1 
	 * @author: fengjj
	 * @Title: selectBusiIdWithoutChn 
	 * @Description: 查询没有渠道的活动，并返回
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectBusiIdWithoutChn(Map paramMap);
	
	/**
	 * Create on 2015-4-21 
	 * @author: yugl
	 * @Title: queryChnByMeansId 
	 * @Description: 查询营销方式所属渠道
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectChnByBusiId(Map paramMap);
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: deleteBusichnRel 
	 * @Description: 删除渠道关系表数据
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusichnRelByBusiId(Map map);
	
	/**
	 * Create on 2015-5-4 
	 * @author: yugl
	 * @Title: insertMkBusiareaInfo 
	 * @Description: 批量保存业务区域信息
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkBusichnRel(List<Map> list);
	
	/**
	 * Create on 2015-5-8 
	 * @author: yugl
	 * @Title: selectBusiChnTypeName 
	 * @Description: 查询业务渠道名称
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> selectBusiChnTypeName(Map paramMap);
	
	/**
	 * 查询业务关系表
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: selectMkBusichnRel 
	 * @Description: 
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusichnRel(Map paramMap);
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusichnRelForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusichnRelForBusiId(Map map) ;
	/**
	 * 根据busiId更新chnStatus
	 * Create on 2015-6-8 
	 * @author: wangdw
	 * @Title: updateStatusByBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateStatusByBusiId(Map map);
}
