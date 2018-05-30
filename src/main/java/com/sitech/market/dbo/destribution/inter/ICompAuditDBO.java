package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 
 * Create on 2015-4-1 
 * @author: tianyy_bj
 * @Title: IAuditDBO
 * @Description：审批调用外系统服务dbo
 * @version 1.0  
 * update_data:     update_author:     update_note:
 */
public interface ICompAuditDBO {

	/**
	 * 
	 * Create on 2015-4-1
	 * @author:tianyy_bj
	 * @Title: getUpLoginByGroup
	 * @Description: 根据登陆信息获取上级工号 
	 * @param inParam
	 * @return
	 * @return Map
	 * @version 1.0
	 * update_data:     update_author:     update_note:
	 */
	public Map getUpLoginByGroup(Map inParam);
}
