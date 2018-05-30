package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class CondInfo implements Decodeable ,Encodeable{
	@ParamDesc(path="SERIAL_ID",cons=ConsType.QUES,len="100",desc="分表序号",type="String",memo="略")
	private String serialId;
	
	@Override
	public void decode(final Map in) {
		serialId =(String) in.get("SERIAL_ID"); 
	}
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> cond = new  HashMap<String, Object>();
		cond.put("SERIAL_ID", getSerialId());
		return cond;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	
}
