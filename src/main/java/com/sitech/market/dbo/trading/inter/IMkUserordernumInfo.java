package com.sitech.market.dbo.trading.inter;

import com.alibaba.fastjson.JSONObject;

/**
 * Create on 2015-4-6 
 * @author: gengws
 * @Title: IMkUserordernumInfo 
 * @Description： MkUserordernumInfo 表dbo
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public interface IMkUserordernumInfo {

	/** 
	  * 向MK_USERORDERNUM_INFO表中增加营销业务订购次数
	  * Create on 2014-11-25
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	 * @throws Exception 
	  */
	public boolean insertUserOrderNum(String key, String columnName);

	/** 
	  * 回滚MK_USERORDERNUM_INFO表中营销业务订购次数
	  * Create on 2014-11-25 
	  * @author zhaiwt
	  * @version 1.0
	  * Copyright(c) 北京思特奇信息技术股份有限公司
	  * 修改日期:     修改人:     修改目的:
	  */
	public void rollbackUserOrderNum(String key, String columnName);

	/** 通过idNo查询preOrder记录
	 * Create on 2014-10-27
	 * @author sunliang
	 */
	public JSONObject queryUserordernumByIdNo(String idNo);

}
