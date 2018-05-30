package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 营销业务类型级别关系字典表
 * Create on 2015-6-8 
 * @author: wangdw
 * @Title: IMkBusitypelevelrelDict 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkBusitypelevelrelDict {

	/**
	 * 查询
	 * Create on 2015-6-8 
	 * @author: wangdw
	 * @Title: selectMkBusitypelevelrelDict 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkBusitypelevelrelDict(Map map);
	/**
	 * 查询
	 * Create on 2015-8-11 
	 * @author: zhangchen
	 * @Title: getRuleclassList 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List getRuleclassList(Map map);
}
