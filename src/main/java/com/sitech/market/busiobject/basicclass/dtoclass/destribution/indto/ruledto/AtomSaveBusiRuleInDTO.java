package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-5 
 * @author: yugl
 * @Title: AtomSaveBusiRuleInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveBusiRuleInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID_STR",cons=ConsType.CT001,type="string",len="800",desc="业务ID字符串",memo="略")
	private String busiIdStr;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,type="string",len="5",desc="业务类型",memo="略")
	private String busiType;
	@ParamDesc(path="RULE_SERIAL_ID",cons=ConsType.CT001,type="string",len="18",desc="规则流水",memo="略")
	private String ruleSerialId;
	
	@ParamDesc(path="SAVE_FLAG",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String saveFlag;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String serialId;
	@ParamDesc(path="RULE_ID",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String ruleId;
	@ParamDesc(path="RULE_NAME",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String ruleName;
	@ParamDesc(path="RULE_TYPE",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String ruleType;
	@ParamDesc(path="RULE_DESC",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String ruleDesc;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String statusCode;
	@ParamDesc(path="ITEM_ID",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String itemId;
	@ParamDesc(path="ITEM_NAME",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String itemName;
	@ParamDesc(path="ITEM_DESC",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String itemDesc;
	@ParamDesc(path="RULE_CLASS",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String ruleClass;
	@ParamDesc(path="RULE_CONTENT_JSON",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String ruleContentJson;
	@ParamDesc(path="ITEM_CONTENT_JSON",cons=ConsType.PLUS,type="string",len="18",desc="流水号",memo="略")
	private String itemContentJson;
	
	@ParamDesc(path="OPER_NO",cons=ConsType.PLUS,type="string",len="20",desc="操作工号",memo="略")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.PLUS,type="string",len="64",desc="操作人",memo="略")
	private String operName;
	@ParamDesc(path="REGION_CODE",cons=ConsType.PLUS,type="string",len="5",desc="区域编码",memo="略")
	private String regionCode;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.PLUS,type="string",len="5",desc="省份编码",memo="略")
	private String provinceGroup;
	@ParamDesc(path="OPER_FLAG",cons=ConsType.PLUS,type="string",len="5",desc="操作标识",memo="略")
	private String operFlag;
	
	public void decode(MBean bean) {
		setBusiIdStr(bean.getStr(getPathByProperName("busiIdStr")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setRuleSerialId(bean.getStr(getPathByProperName("ruleSerialId")));
		
		setSaveFlag(bean.getStr(getPathByProperName("saveFlag")));
		setSerialId(bean.getStr(getPathByProperName("serialId")));
		setRuleId(bean.getStr(getPathByProperName("ruleId")));
		setRuleName(bean.getStr(getPathByProperName("ruleName")));
		setRuleType(bean.getStr(getPathByProperName("ruleType")));
		setRuleDesc(bean.getStr(getPathByProperName("ruleDesc")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
		setItemId(bean.getStr(getPathByProperName("itemId")));
		setItemName(bean.getStr(getPathByProperName("itemName")));
		setItemDesc(bean.getStr(getPathByProperName("itemDesc")));
		setRuleClass(bean.getStr(getPathByProperName("ruleClass")));
		setRuleContentJson(bean.getStr(getPathByProperName("ruleContentJson")));
		setItemContentJson(bean.getStr(getPathByProperName("itemContentJson")));
		
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setOperFlag(bean.getStr(getPathByProperName("operFlag")));
		
	}

	public String getRuleSerialId() {
		return ruleSerialId;
	}

	public void setRuleSerialId(String ruleSerialId) {
		this.ruleSerialId = ruleSerialId;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getBusiIdStr() {
		return busiIdStr;
	}

	public void setBusiIdStr(String busiIdStr) {
		this.busiIdStr = busiIdStr;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getRuleClass() {
		return ruleClass;
	}

	public void setRuleClass(String ruleClass) {
		this.ruleClass = ruleClass;
	}

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

	public String getRuleContentJson() {
		return ruleContentJson;
	}

	public void setRuleContentJson(String ruleContentJson) {
		this.ruleContentJson = ruleContentJson;
	}

	public String getItemContentJson() {
		return itemContentJson;
	}

	public void setItemContentJson(String itemContentJson) {
		this.itemContentJson = itemContentJson;
	}

	public String getOperNo() {
		return operNo;
	}

	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	
	
}
