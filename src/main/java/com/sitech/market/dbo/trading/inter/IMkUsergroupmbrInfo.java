package com.sitech.market.dbo.trading.inter;

import com.alibaba.fastjson.JSONObject;

public interface IMkUsergroupmbrInfo {
	
	public JSONObject selectMkUsergroupInfoByRowKye(String rowKey);
}
