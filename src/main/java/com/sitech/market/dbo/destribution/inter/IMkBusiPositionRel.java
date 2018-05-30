package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

public interface IMkBusiPositionRel {
	/**
	 * Create on 
	 * @author: 
	 * @Title: 
	 * @Description: 运营信息
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> getBusiPositionRel(Map inMap);
	
	/**
	 * Create on 
	 * @author: 
	 * @Title: 
	 * @Description: 运营信息 分页
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> getBusiPositionRelByCond(Map inMap,int startNum,int endNum);
	
	/**
	 * Create on 
	 * @author: 
	 * @Title: 
	 * @Description: 运营信息 total
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryBusiPositionByCondTotal(Map inMap);
	
	/**
	 * Create on 
	 * @author: 
	 * @Title: 
	 * @Description: 更新运营位信息
	 * @param paramMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public void updateBusiPosition(Map inMap);
	
}
