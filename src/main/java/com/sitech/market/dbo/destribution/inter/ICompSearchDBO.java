package com.sitech.market.dbo.destribution.inter;

import java.util.Map;

/**
 * Create on 2015-4-8 
 * @author: wangdw
 * @Title: ICompSearchDBO 
 * @Description： 查询DBO
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface ICompSearchDBO {

	/**
	 * Create on 2015-4-8 
	 * @author: wangdw
	 * @Title: searchVagueFee 
	 * @Description: 资费模糊查询
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map searchVagueFee(Map inMap);
}
