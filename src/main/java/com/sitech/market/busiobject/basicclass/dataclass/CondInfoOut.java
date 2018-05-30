package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;
import com.sitech.util.Const;

public class CondInfoOut implements Encodeable ,Decodeable { 
	@ParamDesc(path="ID_NO",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String idNo;
	@ParamDesc(path="FUNCTION_CODE",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String functionCode;
	@ParamDesc(path="PRODPRCINS_ID",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String prodprcinsId;
	@ParamDesc(path="EFF_DATE",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String effDate;
	@ParamDesc(path="OP_CODE",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String opCode;
	@ParamDesc(path="LIMIT_TYPE",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String limitType;
	@ParamDesc(path="LIMIT_FLAG",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String limitFlag;
	@ParamDesc(path="OPERATE_TYPE",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String operateType;
	@ParamDesc(path="LIMIT_LEVEL_ID",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String limitLevelId;
	@ParamDesc(path="LOGIN_NO",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String loginNo;
	@ParamDesc(path="MAX_VALUE",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String maxValue;
	@ParamDesc(path="MIN_VALUE",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String minValue;
	@ParamDesc(path="BRAND_ID",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String brandId;
	@ParamDesc(path="LIMIT_DETAILMSG",cons=ConsType.CT001,len="200",desc="",type="String",memo="略")
	private String limitDetailmsg;
	@ParamDesc(path="REMARK",cons=ConsType.CT001,len="50",desc="",type="String",memo="略")
	private String remark;
	@ParamDesc(path="LIMITINS_TYPE",cons=ConsType.QUES,len="5",desc="",type="",memo="略")
	private String limitinsType;
	@ParamDesc(path="LIMITINS_ID",cons=ConsType.QUES,len="50",desc="",type="",memo="略")
	private String limitinsId;
	@ParamDesc(path="EXP_FLAG",cons=ConsType.QUES,len="50",desc="",type="String",memo="略")
	private String  expFlag;
	@ParamDesc(path="PROD_PRCID",cons=ConsType.QUES,len="50",desc="",type="String",memo="略")
	private String  prodPrcid;
	@ParamDesc(path="EXP_VALUE",cons=ConsType.QUES,len="50",desc="",type="String",memo="略")
	private String  expValue;
	
	@Override
	public void decode(Map in) {
		setIdNo((String)in.get("ID_NO"));
		setFunctionCode((String)in.get("FUNCTION_CODE"));
		setProdprcinsId((String)in.get("PRODPRCINS_ID"));
		setEffDate((String)in.get("EFF_DATE"));
		setOpCode((String)in.get("OP_CODE"));
		setLimitType((String)in.get("LIMIT_TYPE"));
		setLimitFlag((String)in.get("LIMIT_FLAG"));
		setOperateType((String)in.get("OPERATE_TYPE"));
		setLimitLevelId((String)in.get("LIMIT_LEVEL_ID"));
		setLoginNo((String)in.get("LOGIN_NO"));
		setMaxValue((String)in.get("MAX_VALUE"));
		setMinValue((String)in.get("MIN_VALUE"));
		setBrandId((String)in.get("BRAND_ID"));
		setLimitDetailmsg((String)in.get("LIMIT_DETAILMSG"));
		setRemark((String)in.get("REMARK"));
		setLimitinsType((String)in.get("LIMITINS_TYPE"));
		setLimitinsId((String)in.get("LIMITINS_ID"));
		setExpFlag((String)in.get("EXP_FLAG"));
		setProdPrcid((String)in.get("PROD_PRCID"));
		setExpValue((String)in.get("EXP_VALUE"));
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> condInfoOut = new HashMap<String, Object>();
		condInfoOut.put("ID_NO", getIdNo());
		condInfoOut.put("FUNCTION_CODE", getFunctionCode());
		condInfoOut.put("PRODPRCINS_ID", getProdprcinsId());
		condInfoOut.put("EFF_DATE", getEffDate());
		condInfoOut.put("OP_CODE", getOpCode());
		condInfoOut.put("LIMIT_TYPE", getLimitType());
		condInfoOut.put("LIMIT_FLAG", getLimitFlag());
		condInfoOut.put("OPERATE_TYPE", getOperateType());
		condInfoOut.put("LIMIT_LEVEL_ID", getLimitLevelId());
		condInfoOut.put("LOGIN_NO", getLoginNo());
		condInfoOut.put("MAX_VALUE", getMaxValue());
		condInfoOut.put("MIN_VALUE", getMinValue());
		condInfoOut.put("BRAND_ID", getBrandId());
		condInfoOut.put("LIMIT_DETAILMSG", getLimitDetailmsg());
		condInfoOut.put("REMARK", getRemark());
		condInfoOut.put("LIMITINS_TYPE",getLimitinsType());
		condInfoOut.put("LIMITINS_ID", getLimitinsId());
		condInfoOut.put("EXP_FLAG", getExpFlag());
		condInfoOut.put("PROD_PRCID", getProdPrcid());
		condInfoOut.put("EXP_VALUE", getExpValue());
		
		System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;condInfoOut:"+condInfoOut);
		return condInfoOut;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getProdprcinsId() {
		return prodprcinsId;
	}

	public void setProdprcinsId(String prodprcinsId) {
		this.prodprcinsId = prodprcinsId;
	}

	public String getEffDate() {
		return effDate;
	}

	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getLimitType() {
		return limitType;
	}

	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}

	public String getLimitFlag() {
		return limitFlag;
	}

	public void setLimitFlag(String limitFlag) {
		this.limitFlag = limitFlag;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getLimitLevelId() {
		return limitLevelId;
	}

	public void setLimitLevelId(String limitLevelId) {
		this.limitLevelId = limitLevelId;
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getLimitDetailmsg() {
		return limitDetailmsg;
	}

	public void setLimitDetailmsg(String limitDetailmsg) {
		this.limitDetailmsg = limitDetailmsg;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLimitinsType() {
		return limitinsType;
	}

	public void setLimitinsType(String limitinsType) {
		this.limitinsType = limitinsType;
	}

	public String getLimitinsId() {
		return limitinsId;
	}

	public void setLimitinsId(String limitinsId) {
		this.limitinsId = limitinsId;
	}

	public String getExpFlag() {
		return expFlag;
	}

	public void setExpFlag(String expFlag) {
		this.expFlag = expFlag;
	}

	public String getProdPrcid() {
		return prodPrcid;
	}

	public void setProdPrcid(String prodPrcid) {
		this.prodPrcid = prodPrcid;
	}

	public String getExpValue() {
		return expValue;
	}

	public void setExpValue(String expValue) {
		this.expValue = expValue;
	}
	
	
}
