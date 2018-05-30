package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class ProcInfoOut implements Encodeable ,Decodeable{
	@ParamDesc(path="CHOOSE_TYPE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  chooseType;
	@ParamDesc(path="EFF_DATE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  effDate;
	@ParamDesc(path="EFF_TYPE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  effType;
	@ParamDesc(path="ELEMENT_BATCH_NO",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  elementBatchNo;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  elementId;
	@ParamDesc(path="EXP_DATE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  expDate;
	@ParamDesc(path="EXP_OFFSET_MONTH",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  expOffsetMonth;
	@ParamDesc(path="EXP_TYPE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  expType;
	@ParamDesc(path="IS_REBATE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  isRebate;
	@ParamDesc(path="PROD_PRCID",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  prodPrcid;
	@ParamDesc(path="PROD_PRC_NAME",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  prodPrcName;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String  serialId;
	@ParamDesc(path = "RELATION_ID", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String relationId;
	@ParamDesc(path = "PROD_TYPE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String prodType;
	@ParamDesc(path = "KB_MONTH", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String kbMonth;

	@Override
	public void decode(Map in) {
		setChooseType((String)(in.get("CHOOSE_TYPE")));
		setEffDate((String)(in.get("EFF_DATE")));
		setEffType((String)(in.get("EFF_TYPE")));
		setElementBatchNo((String)(in.get("ELEMENT_BATCH_NO")));
		setElementId((String)(in.get("ELEMENT_ID")));
		setExpDate((String)(in.get("EXP_DATE")));
		setExpOffsetMonth((String)(in.get("EXP_OFFSET_MONTH")));
		setExpType((String)(in.get("EXP_TYPE")));
		setIsRebate((String)(in.get("IS_REBATE")));
		setProdPrcid((String)(in.get("PROD_PRCID")));
		setProdPrcName((String)(in.get("PROD_PRC_NAME")));
		setSerialId((String)(in.get("SERIAL_ID")));
		setRelationId((String)(in.get("RELATION_ID")));
		setProdType((String) (in.get("PROD_TYPE")));
		setKbMonth((String)(in.get("KB_MONTH")));
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> procInfoOut = new HashMap<String, Object>();
		procInfoOut.put("CHOOSE_TYPE",getChooseType());
		procInfoOut.put("EFF_DATE",getEffDate());
		procInfoOut.put("EFF_TYPE",getEffType());
		procInfoOut.put("ELEMENT_BATCH_NO",getElementBatchNo());
		procInfoOut.put("ELEMENT_ID",getElementId());
		procInfoOut.put("EXP_DATE",getExpDate());
		procInfoOut.put("EXP_OFFSET_MONTH",getExpOffsetMonth());
		procInfoOut.put("EXP_TYPE",getExpType());
		procInfoOut.put("IS_REBATE",getIsRebate());
		procInfoOut.put("PROD_PRCID",getProdPrcid());
		procInfoOut.put("PROD_PRC_NAME",getProdPrcName());
		procInfoOut.put("SERIAL_ID",getSerialId());
		procInfoOut.put("RELATION_ID",getRelationId());
		procInfoOut.put("PROD_TYPE",getProdType());
		procInfoOut.put("KB_MONTH",getKbMonth());
		return procInfoOut;
	}
	
	public String getEffType() {
		return effType;
	}

	public void setEffType(String effType) {
		this.effType = effType;
	}
	public String getChooseType() {
		return chooseType;
	}
	public void setChooseType(String chooseType) {
		this.chooseType = chooseType;
	}
	public String getEffDate() {
		return effDate;
	}
	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}
	public String getElementBatchNo() {
		return elementBatchNo;
	}
	public void setElementBatchNo(String elementBatchNo) {
		this.elementBatchNo = elementBatchNo;
	}
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getExpOffsetMonth() {
		return expOffsetMonth;
	}
	public void setExpOffsetMonth(String expOffsetMonth) {
		this.expOffsetMonth = expOffsetMonth;
	}
	public String getExpType() {
		return expType;
	}
	public void setExpType(String expType) {
		this.expType = expType;
	}
	public String getIsRebate() {
		return isRebate;
	}
	public void setIsRebate(String isRebate) {
		this.isRebate = isRebate;
	}
	public String getProdPrcid() {
		return prodPrcid;
	}
	public void setProdPrcid(String prodPrcid) {
		this.prodPrcid = prodPrcid;
	}
	public String getProdPrcName() {
		return prodPrcName;
	}
	public void setProdPrcName(String prodPrcName) {
		this.prodPrcName = prodPrcName;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getKbMonth() {
		return kbMonth;
	}

	public void setKbMonth(String kbMonth) {
		this.kbMonth = kbMonth;
	}
	
	
}
