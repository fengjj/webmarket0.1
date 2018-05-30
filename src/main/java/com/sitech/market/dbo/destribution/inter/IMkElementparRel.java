package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-4-10 
 * @author: yugl
 * @Title: IMkElementparRel 
 * @Description： 元素参数关系表
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkElementparRel {

	/**
	 * 
	 * Create on 2015-4-10 
	 * @author: yugl
	 * @Title: selectMkElementparRel 
	 * @Description: 查询MkElementparRel表
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectMkElementparRel(Map inParam);
	
	/**
	 * Create on 2015-5-22 
	 * @author: yugl
	 * @Title: selectAimEngName 
	 * @Description: 
	 * @param inParam
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List selectAimEngName(Map inParam);
	
}
