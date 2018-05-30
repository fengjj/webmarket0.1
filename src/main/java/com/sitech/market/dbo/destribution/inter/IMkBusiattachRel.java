package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-5-14
 * @author: dongyh
 * @Title: IMkBusiattachRel
 * @Description： 附件与业务关系表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusiattachRel {

	/**
	 * Create on 2015-5-14 
	 * @author: dongyh
	 * @Title: saveMkBusiattachRel 
	 * @Description: 保存附件与业务关系
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void saveMkBusiattachRel(Map map);
	/**
	 * 批量插入
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: batchInsertMkBusiattachRel 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkBusiattachRel(List<Map> list);
	
	/**
	 * 查询业务关系表信息
	 * Create on 2015-5-22 
	 * @author: wangdw
	 * @Title: selectMkBusiattachRel 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusiattachRel(Map map);
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusiattachRelForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusiattachRelForBusiId(Map map);
	
	/**
	 * 删除
	 * Create on 2015-5-28 
	 * @author: wangdw
	 * @Title: deleteMkBusiattachRel 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void deleteMkBusiattachRel(Map map) ;
}
