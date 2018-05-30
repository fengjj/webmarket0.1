package com.sitech.market.dbo.common.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-4-29 
 * @author: yugl
 * @Title: ICommonDBO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface ICommonDBO {

	/**
	 * Create on 2015-4-29 
	 * @author: yugl
	 * @Title: queryListBySql 
	 * @Description: 
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryListBySql(String sql,Map map);
	/**
	 * 查询mk_codename_dict表
	 * Create on 2015-5-7 
	 * @author: wangdw
	 * @Title: queryCodeName 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryCodeName(Map inMap);
	/**
	 * 调用公共组件服务
	 * Create on 2015-5-7 
	 * @author: wangdw
	 * @Title: getInitPageData 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map getInitPageData(Map inMap);
	
	/**
	 * Create on 2015-6-17
	 * @author:jiaxla
	 * @Title: 标签查询list
	 * @Description:
	 * @return
	 * version 1.0
	 * update_date:            update_author:              update_note
	 */
	public Map queryForPagingList(Map inMap);
}
