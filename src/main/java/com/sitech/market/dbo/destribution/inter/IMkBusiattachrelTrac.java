package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-5-14
 * @author: dongyh
 * @Title: IMkBusiattachrelTrac
 * @Description： 附件与业务关系轨迹表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusiattachrelTrac {

	/**
	 * Create on 2015-5-14 
	 * @author: dongyh
	 * @Title: saveMkBusiattachrelTrac 
	 * @Description: 保存附件与业务关系轨迹
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void saveMkBusiattachrelTrac(Map map);
	
	/**
	 * 批量插入
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: batchInsertMkBusiattachrelTrac 
	 * @Description: 
	 * @param list 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void batchInsertMkBusiattachrelTrac(List<Map> list);
	/**
	 * 根据busiId更新busiId
	 * Create on 2015-5-26 
	 * @author: wangdw
	 * @Title: updateMkBusiattachrelTracForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateMkBusiattachrelTracForBusiId(Map map);
}
