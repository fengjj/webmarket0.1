package com.sitech.market.dbo.common.inter;

import java.util.List;
import java.util.Map;

public interface IMkAuditroleDict {
   /**
	* 审批角色查询
	* Create on 2014-11-13 上午11:45:21
	* @author tianyy_bj
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司
	* 功能描述：
	* 修改日期:     修改人:     修改目的:
	*/
	public List selectMkAuditroleDict(Map inParam);

	/**
	 * 查询角色最高级别
	 * @author hanzh_bj
	 * @param paraMap
	 * @return
	 */
	public String selectMaxRoleLevel(Map inParam);
}
