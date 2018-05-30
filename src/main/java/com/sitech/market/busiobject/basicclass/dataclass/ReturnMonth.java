package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class ReturnMonth implements Decodeable,Encodeable{
	@ParamDesc(path="BATCH_NO",cons=ConsType.QUES,len="100",desc="资费批次号",type="String",memo="略")
	private String batchNo;

	public void decode(final Map in) {
		batchNo = (String) in.get("BATCH_NO");
		
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> rtn =new HashMap<String, Object>();
		rtn.put("BATCH_NO", getBatchNo());
		return rtn;
	}
	
	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	
}
