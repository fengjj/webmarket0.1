package com.sitech.market.dbo.trading.inter;

import com.alibaba.fastjson.JSONObject;

public interface IMkUseraccountoutInfo {
	public JSONObject selectMkUseraccountoutInfoByRowKye(String rowKey);

	public String selectMkUseraccountoutInfo(String rowKey, String column);
}
