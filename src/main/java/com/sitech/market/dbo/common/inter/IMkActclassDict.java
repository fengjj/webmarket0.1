package com.sitech.market.dbo.common.inter;


import java.util.List;
import java.util.Map;

public interface IMkActclassDict {
    /**
     * 查询mkActClassDict码表信息
     * Create on 2015-01-18
     * @author lixd_bj
     * @version 1.0
     * Copyright(c) 北京思特奇信息技术股份有限公司
     * 功能描述：
     * 修改日期: 修改人: 修改目的:
     */
    public List queryActClassDict(Map paramMap);

    /**
	 * 根据actClass查询营销活动大类、小类信息
	 * @param paramMap
	 * @return
	 * lixd_bj
	 * 2015-01-18
	 * 
	 */
	public List queryActClassInfo(Map paramMap);
}	
