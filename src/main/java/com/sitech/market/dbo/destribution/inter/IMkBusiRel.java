package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

public interface IMkBusiRel {
	
	public String selectRuleSerialIdByActId(String actId);
	
	/** 
	 * Create on 2015-7-2 
	 * @author: songxj
	 * @Title: selectMkBusiRel 
	 * @Description: 查询mk_busi_rel中所有信息
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note: 
	 */
	public List selectMkBusiRel(Map inMap);

}
