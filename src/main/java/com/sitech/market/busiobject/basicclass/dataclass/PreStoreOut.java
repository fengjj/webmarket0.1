package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class PreStoreOut implements Encodeable ,Decodeable{
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,len="100",desc="分表流水",type="String",memo="略")
	private String  serialId;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.CT001,len="100",desc="元素id",type="String",memo="略")
	private String  elementId;
	@ParamDesc(path="ELEMENT_BATCH_NO",cons=ConsType.CT001,len="100",desc="元素批次",type="String",memo="略")
	private String  elementBatchNo;
	@ParamDesc(path="PHONE_NO",cons=ConsType.CT001,len="100",desc="手机号码",type="String",memo="略")
	private String  phoneNo;
	@ParamDesc(path="ID_NO",cons=ConsType.CT001,len="100",desc="用户唯一标示",type="String",memo="略")
	private String  idNo;
	@ParamDesc(path="ACCOUNT_TYPE",cons=ConsType.CT001,len="100",desc="账户类型",type="String",memo="略")
	private String  accountType;
	@ParamDesc(path="FEE_TYPE",cons=ConsType.CT001,len="100",desc="费用类型",type="String",memo="略")
	private String  feeType;
	@ParamDesc(path="FEE_CODE",cons=ConsType.CT001,len="100",desc="费用编码",type="String",memo="略")
	private String  feeCode;
	@ParamDesc(path="FEE_NAME",cons=ConsType.CT001,len="100",desc="费用名称",type="String",memo="略")
	private String  feeName;
	@ParamDesc(path="PAY_MONEY",cons=ConsType.CT001,len="100",desc="缴费金额",type="String",memo="略")
	private String  payMoney;
	@ParamDesc(path="PAY_TYPE",cons=ConsType.CT001,len="100",desc="账本类型",type="String",memo="略")
	private String  payType;
	@ParamDesc(path="RECEIVE_FEE_TYPE",cons=ConsType.QUES,len="100",desc="收费方式： 1.前台营业收取、2.工作队收取、3.下月账务收取等、4.代办点买断、E.后台收费",type="String",memo="略")
	private String  receiveFeeType;
	@ParamDesc(path="IF_ONNET",cons=ConsType.QUES,len="6",desc="1:在网，2：离网 ,3：CRM销户退预存款传3	",type="String",memo="略")
	private String  ifOnnet;
	@ParamDesc(path="GOODPHONE_FLAG",cons=ConsType.QUES,len="6",desc="Y是优良号码抵扣操作	",type="String",memo="略")
	private String  goodphoneFlag;
	@ParamDesc(path="PAY_MODE",cons=ConsType.QUES,len="100",desc="外部接口缴费方式, 0: 现金, 1: 银行, 2: 信用卡, 9: 支票, v: 积分;非必填。后台缴费需要拼",type="String",memo="略")
	private String  payMode;
	@ParamDesc(path="MONTH_TYPE",cons=ConsType.QUES,len="100",desc="模式：0-预存 1-赠送 2-抵扣",type="String",memo="略")
	private String  monthType;


	@Override
	public void decode(Map in) {
		setSerialId((String)in.get("SERIAL_ID"));
		setElementId((String)in.get("ELEMENT_ID"));
		setElementBatchNo((String)in.get("ELEMENT_BATCH_NO"));
		setPhoneNo((String)in.get("PHONE_NO"));
		setIdNo((String)in.get("ID_NO"));
		setAccountType((String)in.get("ACCOUNT_TYPE"));
		setFeeType((String)in.get("FEE_TYPE"));
		setFeeCode((String)in.get("FEE_CODE"));
		setFeeName((String)in.get("FEE_NAME"));
		setPayMoney(in.get("PAY_MONEY").toString());
		setPayType((String)in.get("PAY_TYPE"));
		setReceiveFeeType((String)in.get("RECEIVE_FEE_TYPE"));
		setIfOnnet((String)in.get("IF_ONNET"));
		setGoodphoneFlag((String)in.get("GOODPHONE_FLAG"));
		setPayMode((String)in.get("PAY_MODE"));
		setMonthType((String)in.get("MONTH_TYPE"));
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> preStoreOut = new HashMap<String, Object>();
		preStoreOut.put("SERIAL_ID",		getSerialId());
		preStoreOut.put("ELEMENT_ID",		getElementId());
		preStoreOut.put("ELEMENT_BATCH_NO",	getElementBatchNo());
		preStoreOut.put("PHONE_NO",			getPhoneNo());
		preStoreOut.put("ID_NO",			getIdNo());
		preStoreOut.put("ACCOUNT_TYPE",		getAccountType());
		preStoreOut.put("FEE_TYPE",			getFeeType());
		preStoreOut.put("FEE_CODE",			getFeeCode());
		preStoreOut.put("FEE_NAME",			getFeeName());
		preStoreOut.put("PAY_MONEY",		getPayMoney());
		preStoreOut.put("PAY_TYPE",			getPayType());
		preStoreOut.put("RECEIVE_FEE_TYPE",	getReceiveFeeType());
		preStoreOut.put("IF_ONNET",			getIfOnnet());
		preStoreOut.put("GOODPHONE_FLAG", 	getGoodphoneFlag());
		preStoreOut.put("PAY_MODE", 		getPayMode());
		preStoreOut.put("MONTH_TYPE",		getMonthType());
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
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
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getReceiveFeeType() {
		return receiveFeeType;
	}

	public void setReceiveFeeType(String receiveFeeType) {
		this.receiveFeeType = receiveFeeType;
	}

	public String getIfOnnet() {
		return ifOnnet;
	}

	public void setIfOnnet(String ifOnnet) {
		this.ifOnnet = ifOnnet;
	}

	public String getGoodphoneFlag() {
		return goodphoneFlag;
	}

	public void setGoodphoneFlag(String goodphoneFlag) {
		this.goodphoneFlag = goodphoneFlag;
	}
	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getMonthType() {
		return monthType;
	}

	public void setMonthType(String monthType) {
		this.monthType = monthType;
	}
}
