package com.sitech.market.dbo.common.inter;

import java.util.List;
import java.util.Map;

/**
 * Create on 2015-4-6 
 * @author: gengws
 * @Title: IMkCodenameDict 
 * @Description： MkCodenameDict表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkMsgdealexpIntf {

	/**
	 * 
	* Create on 2015-9-8 下午02:40:41
	* @author: yangbao
	* @Title: insertMkMsgdealexpIntf 
	* @Description: 
	* @param inMap 
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司 
	* update_data:       update_author:       update_note:
	 */
	public void insertMkMsgdealexpIntf(Map inMap);
	/**
	 * 
	* Create on 2015-9-8 下午07:55:57
	* @author: yangbao
	* @Title: selectMkMsgdealexpIntf 
	* @Description: 
	* @param inMap
	* @return 
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司 
	* update_data:       update_author:       update_note:
	 */
	public List<Map> selectMkMsgdealexpIntf(Map inMap);
	/**
	 * 
	* Create on 2015-9-8 下午07:56:19
	* @author: yangbao
	* @Title: updateMkMsgdealexpIntf 
	* @Description: 修改
	* @param inMap 
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司 
	* update_data:       update_author:       update_note:
	 */
	public void updateMkMsgdealexpIntf(Map inMap);
	/**
	 * 
	* Create on 2015-9-12 下午05:34:34
	* @author: yangbao
	* @Title: deleteMkMsgdealexpIntf 
	* @Description: 
	* @param inMap 
	* @version 1.0
	* Copyright(c) 北京思特奇信息技术股份有限公司 
	* update_data:       update_author:       update_note:
	 */
	public void deleteMkMsgdealexpIntf(Map inMap);
}
