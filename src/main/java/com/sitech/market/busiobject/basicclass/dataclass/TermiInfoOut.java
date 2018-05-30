package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;
import com.sitech.util.Const;

public class TermiInfoOut implements Encodeable ,Decodeable { 
	@ParamDesc(path="BRAND_ID",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String beandId;
	@ParamDesc(path="CONTRACT_TIME",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String contractTime;
	@ParamDesc(path="ELEMENT_BATCH_NO",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String elementBatchNo;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String elementId;
	@ParamDesc(path="FEE_CODE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String feeCode;
	@ParamDesc(path="FEE_NAME",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String feeName;
	@ParamDesc(path="FEE_TYPE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String feeType;
	@ParamDesc(path="RESOURCE_CODE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String resourceCode;
	@ParamDesc(path="RESOURCE_COST_PRICE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String resourceCostPrice;
	@ParamDesc(path="RESOURCE_FEE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String resourceFee;
	@ParamDesc(path="RESOURCE_MODEL",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String resourceModel;
	@ParamDesc(path="RESOURCE_NAME",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String resourceName;
	@ParamDesc(path="RESOURCE_NO",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String resourceNo;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String serialId;
	@ParamDesc(path="TERMIN_TYPE",cons=ConsType.CT001,len="100",desc="",type="String",memo="略")
	private String terminType;
	@ParamDesc(path="RESOURCE_UNIT",cons=ConsType.QUES,len="100",desc="",type="单位",memo="略")
	private String resourceUnit;
	@ParamDesc(path="RESOURCE_NUM",cons=ConsType.QUES,len="100",desc="",type="数量",memo="略")
	private String resourceNum;
	@ParamDesc(path="RECEIVE_FEE_TYPE",cons=ConsType.QUES,len="100",desc="收费方式： 1.前台营业收取、2.工作队收取、3.下月账务收取等、4.代办点买断、E.后台收费",type="String",memo="略")
	private String  receiveFeeType;
	@ParamDesc(path="PAY_MODE",cons=ConsType.QUES,len="100",desc="外部接口缴费方式, 0: 现金, 1: 银行, 2: 信用卡, 9: 支票, v: 积分;非必填。后台缴费需要拼",type="String",memo="略")
	private String  payMode;
	@ParamDesc(path="PAY_TYPE",cons=ConsType.QUES,len="100",desc="账本类型",type="String",memo="略")
	private String  payType;
	@ParamDesc(path = "RELATION_ID", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String relationId;
	@ParamDesc(path = "RESOURCE_USE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String resourceuse;
	@ParamDesc(path = "START_DATE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String startDate;
	@ParamDesc(path = "END_DATE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String endDate;
	@ParamDesc(path = "BUSI_TYPE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String busiType;
	@ParamDesc(path = "IS_BAG", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String isBag;
	@ParamDesc(path = "TAX_RATE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String taxRate;
	@ParamDesc(path = "TAX_FEE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String taxFee;
	@ParamDesc(path = "CONTENT_REL_ID", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String contentRelId;
	@ParamDesc(path = "TERMI_TYPE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String termiType;
	@ParamDesc(path = "SEPARATE_MONTH", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String separateMonth;
	@ParamDesc(path = "ALLOWANCE_FEE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String allowanceFee;
	@ParamDesc(path = "MOBILE_ALLOWANCE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String mobileAllowance;
	@ParamDesc(path = "REPEATLIMIT_TIME", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String repeatlimitTime;
	@ParamDesc(path = "IS_ACTLIB", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String isActlib;
	
	@ParamDesc(path = "SUPPLY_ID", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String supplyId;
	@ParamDesc(path = "COST_PRICE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String costPrice;
	
	@ParamDesc(path = "RESOURCE_REAL_PRICE", cons = ConsType.CT001, len = "100", desc = "", type = "String", memo = "略")
	private String resourceRealPrice;
	
	
	public String getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(String supplyId) {
		this.supplyId = supplyId;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getTermiType() {
		return termiType;
	}

	public void setTermiType(String termiType) {
		this.termiType = termiType;
	}

	public String getSeparateMonth() {
		return separateMonth;
	}

	public void setSeparateMonth(String separateMonth) {
		this.separateMonth = separateMonth;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getTaxFee() {
		return taxFee;
	}

	public void setTaxFee(String taxFee) {
		this.taxFee = taxFee;
	}

	public String getContentRelId() {
		return contentRelId;
	}

	public void setContentRelId(String contentRelId) {
		this.contentRelId = contentRelId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getIsBag() {
		return isBag;
	}

	public void setIsBag(String isBag) {
		this.isBag = isBag;
	}

	@Override
	public void decode(Map in) {
		setBeandId((String)in.get("BRAND_ID"));
		setContractTime((String)in.get("CONTRACT_TIME"));
		setElementBatchNo((String)in.get("ELEMENT_BATCH_NO"));
		setElementId((String)in.get("ELEMENT_ID"));
		setFeeCode((String)in.get("FEE_CODE"));
		setFeeName((String)in.get("FEE_NAME"));
		setFeeType((String)in.get("FEE_TYPE"));
		setResourceCode((String)in.get("RESOURCE_CODE"));
		setResourceCostPrice((String)in.get("RESOURCE_COST_PRICE"));
		setResourceFee((String)in.get("RESOURCE_FEE"));
		setResourceModel((String)in.get("RESOURCE_MODEL"));
		setResourceName((String)in.get("RESOURCE_NAME"));
		setResourceNo((String)in.get("RESOURCE_NO"));
		setSerialId((String)in.get("SERIAL_ID"));
		setTerminType((String)in.get("TERMIN_TYPE"));
		setResourceUnit((String)in.get("RESOURCE_UNIT"));
		setResourceNum((String)in.get("RESOURCE_NUM"));
		setReceiveFeeType((String)in.get("RECEIVE_FEE_TYPE"));
		setPayMode((String)in.get("PAY_MODE"));
		setPayType((String)in.get("PAY_TYPE"));
		setRelationId((String)in.get("RELATION_ID"));
		setResourceuse((String)in.get("RESOURCE_USE"));
		
		setResourceRealPrice((String)in.get("RESOURCE_REAL_PRICE"));
		
		setStartDate((String)in.get("START_DATE"));
		setEndDate((String)in.get("END_DATE"));
		setBusiType((String)in.get("BUSI_TYPE"));
		setIsBag((String)in.get("IS_BAG"));
		
		
		setTaxRate(in.get("TAX_RATE")+"");
		setTaxFee(in.get("TAX_FEE")+"");
		setContentRelId((String)in.get("CONTENT_REL_ID"));
		setTermiType((String)in.get("TERMI_TYPE"));
		setSeparateMonth((String)in.get("SEPARATE_MONTH"));
		setAllowanceFee((String)in.get("ALLOWANCE_FEE"));
		setMobileAllowance((String)in.get("MOBILE_ALLOWANCE"));
		setRepeatlimitTime((String)in.get("REPEATLIMIT_TIME"));
		setIsActlib((String)in.get("IS_ACTLIB"));
		
		setSupplyId((String)in.get("SUPPLY_ID"));
		setCostPrice((String)in.get("COST_PRICE"));
		
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> termiInfoOut = new HashMap<String, Object>();
		termiInfoOut.put("BRAND_ID",getBeandId());
		termiInfoOut.put("CONTRACT_TIME",getContractTime());
		termiInfoOut.put("ELEMENT_BATCH_NO",getElementBatchNo());
		termiInfoOut.put("ELEMENT_ID",getElementId());
		termiInfoOut.put("FEE_CODE",getFeeCode());
		termiInfoOut.put("FEE_NAME",getFeeName());
		termiInfoOut.put("FEE_TYPE",getFeeType());
		termiInfoOut.put("RESOURCE_CODE",getResourceCode());
		termiInfoOut.put("RESOURCE_COST_PRICE",getResourceCostPrice());
		termiInfoOut.put("RESOURCE_FEE",getResourceFee());
		termiInfoOut.put("RESOURCE_MODEL",getResourceModel());
		termiInfoOut.put("RESOURCE_NAME",getResourceName());
		termiInfoOut.put("RESOURCE_NO",getResourceNo());
		termiInfoOut.put("SERIAL_ID",getSerialId());
		termiInfoOut.put("TERMIN_TYPE",getTerminType());
		termiInfoOut.put("RESOURCE_UNIT", getResourceUnit());
		termiInfoOut.put("RESOURCE_NUM", getResourceNum());
		termiInfoOut.put("RECEIVE_FEE_TYPE", getReceiveFeeType());
		termiInfoOut.put("PAY_MODE", getPayMode());
		termiInfoOut.put("PAY_TYPE", getPayType());
		termiInfoOut.put("RELATION_ID", getRelationId());
		termiInfoOut.put("RESOURCE_USE", getResourceuse());
		
		termiInfoOut.put("RESOURCE_REAL_PRICE", getResourceRealPrice());
		
		termiInfoOut.put("START_DATE", getStartDate());
		termiInfoOut.put("END_DATE", getEndDate());
		termiInfoOut.put("BUSI_TYPE", getBusiType());
		termiInfoOut.put("IS_BAG", getIsBag());
		
		termiInfoOut.put("TAX_RATE", getTaxRate());
		termiInfoOut.put("TAX_FEE", getTaxFee());
		termiInfoOut.put("CONTENT_REL_ID", getContentRelId());
		termiInfoOut.put("TERMI_TYPE", getTermiType());
		termiInfoOut.put("SEPARATE_MONTH", getSeparateMonth());
		termiInfoOut.put("ALLOWANCE_FEE", getAllowanceFee());
		termiInfoOut.put("MOBILE_ALLOWANCE", getMobileAllowance());
		termiInfoOut.put("REPEATLIMIT_TIME", getRepeatlimitTime());
		termiInfoOut.put("IS_ACTLIB", getIsActlib());
		
		termiInfoOut.put("SUPPLY_ID", getSupplyId());
		termiInfoOut.put("COST_PRICE", getCostPrice());
		
		System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;termiInfoOut:"+termiInfoOut);
		return termiInfoOut;
	}

	
	
	public String getResourceRealPrice() {
		return resourceRealPrice;
	}

	public void setResourceRealPrice(String resourceRealPrice) {
		this.resourceRealPrice = resourceRealPrice;
	}

	public String getBeandId() {
		return beandId;
	}
	public void setBeandId(String beandId) {
		this.beandId = beandId;
	}
	public String getContractTime() {
		return contractTime;
	}
	public void setContractTime(String contractTime) {
		this.contractTime = contractTime;
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
	public String getFeeCode() {
		return feeCode;
	}
	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}
	public String getFeeName() {
		return feeName;
	}
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	public String getResourceCostPrice() {
		return resourceCostPrice;
	}
	public void setResourceCostPrice(String resourceCostPrice) {
		this.resourceCostPrice = resourceCostPrice;
	}
	public String getResourceFee() {
		return resourceFee;
	}
	public void setResourceFee(String resourceFee) {
		this.resourceFee = resourceFee;
	}
	public String getResourceModel() {
		return resourceModel;
	}
	public void setResourceModel(String resourceModel) {
		this.resourceModel = resourceModel;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceNo() {
		return resourceNo;
	}
	public void setResourceNo(String resourceNo) {
		this.resourceNo = resourceNo;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getTerminType() {
		return terminType;
	}
	public void setTerminType(String terminType) {
		this.terminType = terminType;
	}

	public String getResourceUnit() {
		return resourceUnit;
	}

	public void setResourceUnit(String resourceUnit) {
		this.resourceUnit = resourceUnit;
	}

	public String getResourceNum() {
		return resourceNum;
	}

	public void setResourceNum(String resourceNum) {
		this.resourceNum = resourceNum;
	}

	public String getReceiveFeeType() {
		return receiveFeeType;
	}

	public void setReceiveFeeType(String receiveFeeType) {
		this.receiveFeeType = receiveFeeType;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public String getResourceuse() {
		return resourceuse;
	}

	public void setResourceuse(String resourceuse) {
		this.resourceuse = resourceuse;
	}

	public String getAllowanceFee() {
		return allowanceFee;
	}

	public void setAllowanceFee(String allowanceFee) {
		this.allowanceFee = allowanceFee;
	}

	public String getMobileAllowance() {
		return mobileAllowance;
	}

	public void setMobileAllowance(String mobileAllowance) {
		this.mobileAllowance = mobileAllowance;
	}

	public String getRepeatlimitTime() {
		return repeatlimitTime;
	}

	public void setRepeatlimitTime(String repeatlimitTime) {
		this.repeatlimitTime = repeatlimitTime;
	}

	public String getIsActlib() {
		return isActlib;
	}

	public void setIsActlib(String isActlib) {
		this.isActlib = isActlib;
	}
}
