package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;

public class ValidInfo implements Decodeable ,Encodeable{
	@ParamDesc(path="ACCTBOOK_ITEM",cons=ConsType.QUES,len="100",desc="账目项",type="String",memo="略")
	private String acctbookItem;
	@ParamDesc(path="ACCTBOOK_ITEM_NAME",cons=ConsType.QUES,len="100",desc="账目项名称",type="String",memo="略")
	private String acctbookItemName;
	@ParamDesc(path="BALANCE",cons=ConsType.QUES,len="100",desc="预存",type="String",memo="略")
	private long balance;
	@ParamDesc(path="BACK_FLAG",cons=ConsType.QUES,len="100",desc="可退不可退标识",type="String",memo="略")
	private int backFlag;
	@ParamDesc(path="BACK_FLAG_NAME",cons=ConsType.QUES,len="100",desc="可退不可退名称",type="String",memo="略")
	private String backFlagName;
	@ParamDesc(path="PAY_FLAG",cons=ConsType.QUES,len="100",desc="账本类型",type="String",memo="略")
	private int  payFlag;
	@ParamDesc(path="PAY_FLAG_NAME",cons=ConsType.QUES,len="100",desc="账本类型名称",type="String",memo="略")
	private String payFlagName;
	@ParamDesc(path="ACCTBOOK_ITEM_TYPE",cons=ConsType.QUES,len="100",desc="账目项类型",type="String",memo="略")
	private String  acctbookItemType;
	@ParamDesc(path="ACCTBOOK_ITEM_TYPE_NAME",cons=ConsType.QUES,len="100",desc="账目项类型名称",type="String",memo="略")
	private String acctbookItemTypeName;
	@ParamDesc(path="ACCTBOOK_EFF_DATE",cons=ConsType.QUES,len="100",desc="生效时间",type="String",memo="略")
	private String acctbookEffDate;
	@ParamDesc(path="ACCTBOOK_EXP_DATE",cons=ConsType.QUES,len="100",desc="失效时间",type="String",memo="略")
	private String acctbookExpDate;
	@ParamDesc(path="BALANCE_ID",cons=ConsType.QUES,len="100",desc="当前预存",type="String",memo="略")
	private long  balanceId;
	@ParamDesc(path="INIT_BALANCE",cons=ConsType.QUES,len="100",desc="初始预存",type="String",memo="略")
	private long  initBalance;
	@ParamDesc(path="PAY_SN",cons=ConsType.QUES,len="100",desc="缴费流水",type="String",memo="略")
	private String paySn;
	@ParamDesc(path="PRIORITY",cons=ConsType.QUES,len="100",desc="冲销优先级",type="String",memo="略")
	private String priority;
	@ParamDesc(path="CONTRACT_NO",cons=ConsType.QUES,len="100",desc="账户号码",type="String",memo="略")
	private String contractNo;
	@ParamDesc(path="MARKET_NAME",cons=ConsType.QUES,len="100",desc="营销活动名称",type="String",memo="略")
	private String marketName;
	@Override
	public Map<String, Object> encode(){
		Map retMap =  new HashMap();
		retMap.put("BACK_FLAG", this.backFlag);
		
		return retMap;
	}
	public void decode(final Map in){
		this.backFlag =Integer.parseInt(in.get("BACK_FLAG")+"");
		
	}
	public String getAcctbookItem() {
		return acctbookItem;
	}
	public void setAcctbookItem(String acctbookItem) {
		this.acctbookItem = acctbookItem;
	}
	public String getAcctbookItemName() {
		return acctbookItemName;
	}
	public void setAcctbookItemName(String acctbookItemName) {
		this.acctbookItemName = acctbookItemName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public int getBackFlag() {
		return backFlag;
	}
	public void setBackFlag(int backFlag) {
		this.backFlag = backFlag;
	}
	public String getBackFlagName() {
		return backFlagName;
	}
	public void setBackFlagName(String backFlagName) {
		this.backFlagName = backFlagName;
	}
	public int getPayFlag() {
		return payFlag;
	}
	public void setPayFlag(int payFlag) {
		this.payFlag = payFlag;
	}
	public String getPayFlagName() {
		return payFlagName;
	}
	public void setPayFlagName(String payFlagName) {
		this.payFlagName = payFlagName;
	}
	public String getAcctbookItemType() {
		return acctbookItemType;
	}
	public void setAcctbookItemType(String acctbookItemType) {
		this.acctbookItemType = acctbookItemType;
	}
	public String getAcctbookItemTypeName() {
		return acctbookItemTypeName;
	}
	public void setAcctbookItemTypeName(String acctbookItemTypeName) {
		this.acctbookItemTypeName = acctbookItemTypeName;
	}
	public String getAcctbookEffDate() {
		return acctbookEffDate;
	}
	public void setAcctbookEffDate(String acctbookEffDate) {
		this.acctbookEffDate = acctbookEffDate;
	}
	public String getAcctbookExpDate() {
		return acctbookExpDate;
	}
	public void setAcctbookExpDate(String acctbookExpDate) {
		this.acctbookExpDate = acctbookExpDate;
	}
	public long getBalanceId() {
		return balanceId;
	}
	public void setBalanceId(long balanceId) {
		this.balanceId = balanceId;
	}
	public long getInitBalance() {
		return initBalance;
	}
	public void setInitBalance(long initBalance) {
		this.initBalance = initBalance;
	}
	public String getPaySn() {
		return paySn;
	}
	public void setPaySn(String paySn) {
		this.paySn = paySn;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	
}
