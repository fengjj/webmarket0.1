package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class PreStore implements Decodeable ,Encodeable{
	@ParamDesc(path="PAY_MONEY",cons=ConsType.QUES,len="100",desc="预存款",type="String",memo="略")
	private String payMoney;//PAY_MONEY
	public void decode(final Map in){
		payMoney = (String) in.get("PAY_MONEY");
	}
	
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> preStore = new HashMap<String,Object>();
		preStore.put("PAY_MONEY", payMoney);
		return preStore;
	}

	
}
