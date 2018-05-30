package com.sitech.market.dbo.destribution.inter;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sitech.jcfx.dt.MBean;

public interface ITermResCodeDBO {
	
	/**
     * 调用资源服务，查询终端型号列表
     * Create on 2015-01-28
     * @author dangzh
     * Copyright(c) 北京思特奇信息技术股份有限公司 
     */
	@SuppressWarnings("unchecked")
	public List<Map> getTermResCodeList(Map bean);
	@SuppressWarnings("unchecked")
	public Map getTermResCodeInfo(Map bean);
	
}
