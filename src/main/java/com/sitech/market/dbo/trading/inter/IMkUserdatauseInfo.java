package com.sitech.market.dbo.trading.inter;

import com.alibaba.fastjson.JSONObject;

public interface IMkUserdatauseInfo {
	
	public JSONObject selectMkUserdataUseInfoByRowKye(String rowKey);
}
