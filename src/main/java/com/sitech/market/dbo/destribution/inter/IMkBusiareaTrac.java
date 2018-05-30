package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;
/**
 * 业务区域轨迹表
 * @Create on 2015-6-23 
 * @author: wangdw
 * @Title: IMkBusiareaTrac 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public interface IMkBusiareaTrac {
	
	/**
	 * 根据busiId，更新busiId
	 * @Create on 2015-6-23 
	 * @author: wangdw
	 * @Title: updateMkBusiareaTracForBusiId 
	 * @Description: 
	 * @param map 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public void updateMkBusiareaTracForBusiId(Map map);
}
