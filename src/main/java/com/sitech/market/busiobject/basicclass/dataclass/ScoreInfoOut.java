package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class ScoreInfoOut implements Encodeable ,Decodeable{
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,len="100",desc="分表流水",type="String",memo="略")
	private String  serialId;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.CT001,len="100",desc="元素id",type="String",memo="略")
	private String  elementId;
	@ParamDesc(path="ELEMENT_BATCH_NO",cons=ConsType.CT001,len="100",desc="元素批次",type="String",memo="略")
	private String  elementBatchNo;
	@ParamDesc(path="SCORE_VALUE",cons=ConsType.CT001,len="100",desc="积分值",type="String",memo="略")
	private String  scoreValue;
	@ParamDesc(path="PERCENT_VALUE",cons=ConsType.CT001,len="100",desc="积分最大额度",type="String",memo="略")
	private String  percentValue;
	@ParamDesc(path = "RELATION_ID", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String relationId;
	
	@Override
	public void decode(Map in) {
		setSerialId((String)in.get("SERIAL_ID"));
		setElementId((String)in.get("ELEMENT_ID"));
		setElementBatchNo((String)in.get("ELEMENT_BATCH_NO"));
		setScoreValue(in.get("SCORE_VALUE").toString());
		setPercentValue(in.get("PERCENT_VALUE").toString());
		setRelationId((String)in.get("RELATION_ID"));
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> preStoreOut = new HashMap<String, Object>();
		preStoreOut.put("SERIAL_ID",getSerialId());
		preStoreOut.put("ELEMENT_ID",getElementId());
		preStoreOut.put("ELEMENT_BATCH_NO",getElementBatchNo());
		preStoreOut.put("SCORE_VALUE",getScoreValue());
		preStoreOut.put("PERCENT_VALUE",getPercentValue());
		preStoreOut.put("RELATION_ID",getRelationId());
		return preStoreOut;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getElementBatchNo() {
		return elementBatchNo;
	}
	public void setElementBatchNo(String elementBatchNo) {
		this.elementBatchNo = elementBatchNo;
	}
	public String getScoreValue() {
		return scoreValue;
	}
	public void setScoreValue(String scoreValue) {
		this.scoreValue = scoreValue;
	}
	public String getPercentValue() {
		return percentValue;
	}
	public void setPercentValue(String percentValue) {
		this.percentValue = percentValue;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

}
