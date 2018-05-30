package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class GiftInfo implements Decodeable ,Encodeable{
	@ParamDesc(path="BATCH_NO",cons=ConsType.QUES,len="100",desc="资费批次号",type="String",memo="略")
	private String batchNo;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.QUES,len="100",desc="分表序号",type="String",memo="略")
	private String serialId;
	
	@Override
	public void decode(final Map in) {
		batchNo = (String) in.get("BATCH_NO");
		serialId =(String) in.get("SERIAL_ID"); 
	}
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> gift = new  HashMap<String, Object>();
		gift.put("BATCH_NO", getBatchNo());
		return gift;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	
	

}
