package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

public interface ICompActionDBO {

	/**
	 * Create on 2015-4-23 
	 * @author: yugl
	 * @Title: initDestributionPage 
	 * @Description: 初始化活动策划页面
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map getInitPageData(Map map);
	
	/**
	 * Create on 2015-4-25 
	 * @author: dongyh
	 * @Title: queryAllActType 
	 * @Description: 加载页面活动类型菜单
	 * @param map
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map queryAllActType(Map map);
	
	/**
	 * Create on 2015-5-18 
	 * @author: dongyh
	 * @Title: queryApprover 
	 * @Description: 查询审批人
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryApprover(Map inMap);
	
	/**
	 * Create on 2015-5-18 
	 * @author: dongyh
	 * @Title: queryReleasePhone 
	 * @Description: 查询预发布号码
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List<Map> queryReleasePhone(Map inMap);
	
	/**
	 * 保存发布
	 * Create on 2015-6-12 
	 * @author: wangdw
	 * @Title: saveRelease 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public Map saveRelease(Map inMap);
}
