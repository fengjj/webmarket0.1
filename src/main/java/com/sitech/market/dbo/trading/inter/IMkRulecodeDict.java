package com.sitech.market.dbo.trading.inter;

import java.util.List;
import java.util.Map;

public interface IMkRulecodeDict {
	
	/**
	 * Create on 2015-7-9 
	 * @author:zhaoyue
	 * @Title: getRuleLabel 
	 * @Description:查询mk_rulecode_dict中的所有label标签 
	 * @return 
	 * @version 1.0 
	 * update_data:       update_author:       update_note:
	 */
	public List queryRuleCode(Map inMap);
	
	

}
