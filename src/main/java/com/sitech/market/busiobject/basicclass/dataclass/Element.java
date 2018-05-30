package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class Element implements Decodeable ,Encodeable{
	@ParamDesc(path="elementId",cons=ConsType.CT001,type="String",len="20",desc="元素ID",memo="")
	private String elementId;
	@ParamDesc(path="elementParId",cons=ConsType.CT001,type="String",len="20",desc="子元素ID",memo="")
	private String elementParId;
	@ParamDesc(path="elementParValue",cons=ConsType.CT001,type="String",len="20",desc="子元素值",memo="")
	private String elementParValue;
	@ParamDesc(path="elementBatchNo",cons=ConsType.CT001,type="String",len="20",desc="批次号",memo="")
	private String elementBatchNo;

	
	public void decode(final Map in) {
		this.elementId      = (String) in.get("elementId");
		this.elementParId    = (String) in.get("elementParId");
		this.elementParValue = (String) in.get("elementParValue");
		this.elementBatchNo = (String) in.get("elementBatchNo");
	}
	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> outMean = new HashMap<String, Object>();
		outMean.put("elementId",     getElementId());
		outMean.put("elementParId",   getElementParId());
		outMean.put("elementParValue",getElementParValue());
		outMean.put("elementBatchNo", getElementBatchNo());
		return outMean;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getElementParId() {
		return elementParId;
	}

	public void setElementParId(String elementParId) {
		this.elementParId = elementParId;
	}

	public String getElementParValue() {
		return elementParValue;
	}

	public void setElementParValue(String elementParValue) {
		this.elementParValue = elementParValue;
	}

	public String getElementBatchNo() {
		return elementBatchNo;
	}

	public void setElementBatchNo(String elementBatchNo) {
		this.elementBatchNo = elementBatchNo;
	}
	
	


}
