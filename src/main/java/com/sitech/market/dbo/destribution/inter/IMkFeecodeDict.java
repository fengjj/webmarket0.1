package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

/**
 * 行业部or_feecode_dict fee_code，fee_type码表查询
 * @Create on 2015-7-18 
 * @author: wangdw
 * @Title: IMkFeecodeDict 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public interface IMkFeecodeDict {
	/**
	 * 查询
	 * @Create on 2015-7-18 
	 * @author: wangdw
	 * @Title: selectMkFeecodeDict 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public List<Map> selectMkFeecodeDict(Map inMap);
	/**
	 * 根据主键fee_code查询
	 * @Create on 2015-7-18 
	 * @author: wangdw
	 * @Title: selectMkFeecodeDictById 
	 * @Description: 
	 * @param inMap
	 * @return 
	 * @version 1.0 
	 * update_date:       update_author:       update_note:
	 */
	public Map selectMkFeecodeDictById(Map inMap);
}
