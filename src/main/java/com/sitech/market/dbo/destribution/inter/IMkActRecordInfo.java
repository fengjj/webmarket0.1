package com.sitech.market.dbo.destribution.inter;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IMkActRecordInfo {

	public JSONObject queryCheckPhone(Map<String,String> bean);
	
}
