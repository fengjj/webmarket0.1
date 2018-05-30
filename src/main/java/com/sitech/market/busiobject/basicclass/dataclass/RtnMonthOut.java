package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;
import com.sitech.util.CommonUtil;

public class RtnMonthOut implements Encodeable ,Decodeable{
	@ParamDesc(path="SERIAL_ID",cons=ConsType.QUES,len="100",desc="分表流水",type="String",memo="略")
	private String  serialId;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.QUES,len="100",desc="元素id",type="String",memo="略")
	private String  elementId;
	@ParamDesc(path="ELEMENT_BATCH_NO",cons=ConsType.QUES,len="100",desc="元素批次",type="String",memo="略")
	private String  elementBatchNo;
	@ParamDesc(path="PHONE_NO",cons=ConsType.QUES,len="100",desc="手机号码",type="String",memo="略")
	private String  phoneNo;
	@ParamDesc(path="ID_NO",cons=ConsType.QUES,len="100",desc="用户唯一标示",type="String",memo="略")
	private String  idNo;
	@ParamDesc(path="FEE_TYPE",cons=ConsType.QUES,len="100",desc="费用类型",type="String",memo="略")
	private String  feeType;
	@ParamDesc(path="FEE_CODE",cons=ConsType.QUES,len="100",desc="用户唯一标示",type="String",memo="略")
	private String  feeCode;
	@ParamDesc(path="FEE_NAME",cons=ConsType.QUES,len="100",desc="费用名称",type="String",memo="略")
	private String  feeName;
	@ParamDesc(path="OFFSET_TYPE",cons=ConsType.QUES,len="100",desc="失效类型，0指定日期失效，1有效月数（使用FAILURE_MONTH），2年底失效，3失效月份（使用FAILURE_THEMONTH）",type="String",memo="略")
	private String  offsetType;
	@ParamDesc(path="FAILURE_DATE",cons=ConsType.QUES,len="100",desc="失效日期",type="String",memo="略")
	private String  failureDate;
	@ParamDesc(path="FAILURE_MONTH",cons=ConsType.QUES,len="100",desc="有效月数",type="String",memo="略")
	private String  failureMonth;
	@ParamDesc(path="FAILURE_THEMONTH",cons=ConsType.QUES,len="100",desc="失效月份",type="String",memo="略")
	private String  failureThemonth;
	@ParamDesc(path="OFFSET_MONTH",cons=ConsType.QUES,len="100",desc="生效延迟月数",type="String",memo="略")
	private String  offsetMonth;
	@ParamDesc(path="PAY_TYPE",cons=ConsType.QUES,len="100",desc="账本类型",type="String",memo="略")
	private String  payType;
	@ParamDesc(path="SHOW_TYPE",cons=ConsType.QUES,len="100",desc="",type="String",memo="略")
	private String  showType;
	@ParamDesc(path="STAGES_MONEY",cons=ConsType.QUES,len="100",desc="",type="String",memo="略")
	private String  stagesMoney;
	@ParamDesc(path="STAGES_MONTH",cons=ConsType.QUES,len="100",desc="",type="String",memo="略")
	private String  stagesMonth;
	@ParamDesc(path="TOTAL_MONEY",cons=ConsType.QUES,len="100",desc="",type="String",memo="略")
	private String  totalMoney;
	@ParamDesc(path="EFF_DATE",cons=ConsType.QUES,len="100",desc="第一次返费日期",type="String",memo="略")
	private String  effDate;
	@ParamDesc(path="LAST_RETURN_DATE",cons=ConsType.QUES,len="100",desc="最后一次返费日期",type="String",memo="略")
	private String  lastReturnDate;
	@ParamDesc(path="EFF_TYPE",cons=ConsType.QUES,len="100",desc="生效方式",type="String",memo="略")
	private String  effType;
	@ParamDesc(path="RECEIVE_FEE_TYPE",cons=ConsType.QUES,len="100",desc="收费方式： 1.前台营业收取、2.工作队收取、3.下月账务收取等、4.代办点买断、E.后台收费",type="String",memo="略")
	private String  receiveFeeType;
	@ParamDesc(path="PAY_MODE",cons=ConsType.QUES,len="100",desc="外部接口缴费方式, 0: 现金, 1: 银行, 2: 信用卡, 9: 支票, v: 积分;非必填。后台缴费需要拼",type="String",memo="略")
	private String  payMode;
	@ParamDesc(path="BOSS_ACT_TYPE",cons=ConsType.QUES,len="5",desc="传给BOSS计费的返费类型 0:所有都是有条件返费（第一笔 + 后面所有笔;1:第一笔无条件返费，后面几笔有条件返费;2:所有都是无条件返费",type="String",memo="略")
	private String  bossActType;
	@ParamDesc(path="IS_COMPLEX",cons=ConsType.QUES,len="5",desc="是否复杂赠费，Y是，N否",type="String",memo="略")
	private String  isComplex;
	@ParamDesc(path="RELATION_ID",cons=ConsType.QUES,len="5",desc="mk_busicontent_rel关系表rel_id主键",type="String",memo="略")
	private String  relationId;
	@ParamDesc(path="RETURN_PRE_FEE",cons=ConsType.QUES,len="5",desc="分返费用串",type="String",memo="略")
	private String  returnPreFee;
	@ParamDesc(path="BOSS_RULE_ID",cons=ConsType.QUES,len="8",desc="boss返还时间规则代码",type="String",memo="略")
	private String  bossRuleId;
	@ParamDesc(path="CONTRACT_NO",cons=ConsType.QUES,len="30",desc="分返的具体账户编号",type="String",memo="略")
	private String  contractNo;
	
	@Override
	public void decode(Map in) {
		String stagesMoney = CommonUtil.isNotEmpty(in.get("STAGES_MONEY")) ? in.get("STAGES_MONEY").toString() : null;
		String stagesMonth = CommonUtil.isNotEmpty(in.get("STAGES_MONTH")) ? in.get("STAGES_MONTH").toString() : null;
		String totalMoney = CommonUtil.isNotEmpty(in.get("TOTAL_MONEY")) ? in.get("TOTAL_MONEY").toString() : null;
		
		setSerialId((String)in.get("SERIAL_ID"));
		setElementId((String)in.get("ELEMENT_ID"));
		setElementBatchNo((String)in.get("ELEMENT_BATCH_NO"));
		setPhoneNo((String)in.get("PHONE_NO"));
		setIdNo((String)in.get("ID_NO"));
		setFeeType((String)in.get("FEE_TYPE"));
		setFeeCode((String)in.get("FEE_CODE"));
		setFeeName((String)in.get("FEE_NAME"));
		setOffsetType((String)in.get("OFFSET_TYPE"));
		setFailureDate((String)in.get("FAILURE_DATE"));
		setFailureMonth((String)in.get("FAILURE_MONTH"));
		setFailureThemonth((String)in.get("FAILURE_THEMONTH"));
		setOffsetMonth((String)in.get("OFFSET_MONTH"));
		setPayType((String)in.get("PAY_TYPE"));
		setShowType((String)in.get("SHOW_TYPE"));
		setStagesMoney(stagesMoney);
		setStagesMonth(stagesMonth);
		setTotalMoney(totalMoney);
		setEffDate((String)in.get("EFF_DATE"));
		setLastReturnDate((String)in.get("LAST_RETURN_DATE"));
		setEffType((String)in.get("EFF_TYPE"));
		setReceiveFeeType((String)in.get("RECEIVE_FEE_TYPE"));
		setPayMode((String)in.get("PAY_MODE"));
		setRelationId((String)in.get("RELATION_ID"));
		setBossActType((String)in.get("BOSS_ACT_TYPE"));
		setIsComplex((String)in.get("IS_COMPLEX"));
		setRelationId((String)in.get("RELATION_ID"));
		setReturnPreFee((String)in.get("RETURN_PRE_FEE"));
		setBossRuleId((String)in.get("BOSS_RULE_ID"));
		setContractNo((String)in.get("CONTRACT_NO"));
	}

	
	@Override
	public Map<String, Object> encode() {
		Map<String, Object> rtnMonthOut = new HashMap<String, Object>();
		rtnMonthOut.put("SERIAL_ID",getSerialId());
		rtnMonthOut.put("ELEMENT_ID",getElementId());
		rtnMonthOut.put("ELEMENT_BATCH_NO",getElementBatchNo());
		rtnMonthOut.put("PHONE_NO",getPhoneNo());
		rtnMonthOut.put("ID_NO",getIdNo());
		rtnMonthOut.put("FEE_TYPE",getFeeType());
		rtnMonthOut.put("FEE_CODE",getFeeCode());
		rtnMonthOut.put("FEE_NAME",getFeeName());
		rtnMonthOut.put("OFFSET_TYPE", getOffsetType());
		rtnMonthOut.put("FAILURE_DATE",getFailureDate());
		rtnMonthOut.put("FAILURE_MONTH",getFailureMonth());
		rtnMonthOut.put("FAILURE_THEMONTH", getFailureThemonth());
		rtnMonthOut.put("OFFSET_MONTH",getOffsetMonth());
		rtnMonthOut.put("PAY_TYPE",getPayType());
		rtnMonthOut.put("SHOW_TYPE",getShowType());
		rtnMonthOut.put("STAGES_MONEY",getStagesMoney());
		rtnMonthOut.put("STAGES_MONTH",getStagesMonth());
		rtnMonthOut.put("TOTAL_MONEY",getTotalMoney());
		rtnMonthOut.put("EFF_DATE",getEffDate());
		rtnMonthOut.put("LAST_RETURN_DATE",getLastReturnDate());
		rtnMonthOut.put("EFF_TYPE",getEffType());
		rtnMonthOut.put("RECEIVE_FEE_TYPE", getReceiveFeeType());
		rtnMonthOut.put("PAY_MODE", getPayMode());
		rtnMonthOut.put("RELATION_ID", getRelationId());
		rtnMonthOut.put("BOSS_ACT_TYPE", getBossActType());
		rtnMonthOut.put("IS_COMPLEX", getIsComplex());
		rtnMonthOut.put("RELATION_ID", getRelationId());
		rtnMonthOut.put("RETURN_PRE_FEE", getReturnPreFee());
		rtnMonthOut.put("BOSS_RULE_ID", getBossRuleId());
		rtnMonthOut.put("CONTRACT_NO", getContractNo());
		return rtnMonthOut;
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
	public String getFailureDate() {
		return failureDate;
	}
	public void setFailureDate(String failureDate) {
		this.failureDate = failureDate;
	}
	public String getFailureMonth() {
		return failureMonth;
	}
	public void setFailureMonth(String failureMonth) {
		this.failureMonth = failureMonth;
	}
	public String getOffsetMonth() {
		return offsetMonth;
	}
	public void setOffsetMonth(String offsetMonth) {
		this.offsetMonth = offsetMonth;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getStagesMoney() {
		return stagesMoney;
	}
	public void setStagesMoney(String stagesMoney) {
		this.stagesMoney = stagesMoney;
	}
	public String getStagesMonth() {
		return stagesMonth;
	}
	public void setStagesMonth(String stagesMonth) {
		this.stagesMonth = stagesMonth;
	}
	public String getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getEffDate() {
		return effDate;
	}
	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}
	public String getEffType() {
		return effType;
	}
	public void setEffType(String effType) {
		this.effType = effType;
	}

	public String getFailureThemonth() {
		return failureThemonth;
	}

	public void setFailureThemonth(String failureThemonth) {
		this.failureThemonth = failureThemonth;
	}

	public String getOffsetType() {
		return offsetType;
	}

	public void setOffsetType(String offsetType) {
		this.offsetType = offsetType;
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


	public String getLastReturnDate() {
		return lastReturnDate;
	}

	public void setLastReturnDate(String lastReturnDate) {
		this.lastReturnDate = lastReturnDate;
	}

	public String getBossActType() {
		return bossActType;
	}

	public void setBossActType(String bossActType) {
		this.bossActType = bossActType;
	}

	public String getIsComplex() {
		return isComplex;
	}

	public void setIsComplex(String isComplex) {
		this.isComplex = isComplex;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getReturnPreFee() {
		return returnPreFee;
	}

	public void setReturnPreFee(String returnPreFee) {
		this.returnPreFee = returnPreFee;
	}
	public String getBossRuleId() {
		return bossRuleId;
	}

	public void setBossRuleId(String bossRuleId) {
		this.bossRuleId = bossRuleId;
	}


	public String getContractNo() {
		return contractNo;
	}


	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

}
