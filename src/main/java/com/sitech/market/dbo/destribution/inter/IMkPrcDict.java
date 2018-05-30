package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

public interface IMkPrcDict {

	/**
	 * Create on 2015-9-6 
	 * @author: dongyh
	 * @Title: selectMkPrcDict 
	 * @Description: 查询资费
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkPrcDict(Map inMap);
	
	/**
	 * Create on 2015-9-7 
	 * @author: dongyh
	 * @Title: selectMkPrcDictByProd 
	 * @Description: 查询资费对应产品
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map selectMkPrcDictByProd(Map inMap);
}
