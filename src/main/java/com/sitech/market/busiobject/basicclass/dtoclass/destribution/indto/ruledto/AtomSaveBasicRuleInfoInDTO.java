package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-25
 * @author: nidw
 * @Title: AtomSaveBasicRuleInfoInDTO
 * @Description： 自动打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveBasicRuleInfoInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,type="string",len="64",desc="活动id",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,type="string",len="64",desc="活动类型",memo="略")
	private String busiType;
	@ParamDesc(path="RULE_NAME",cons=ConsType.CT001,type="string",len="200",desc="规则名称",memo="略")
	private String ruleName;
	@ParamDesc(path="REGION_CODE",cons=ConsType.CT001,type="string",len="5",desc="区域编码",memo="略")
	private String regionCode;
	@ParamDesc(path="RULE_TYPE",cons=ConsType.CT001,type="string",len="18",desc="规则类型",memo="略")
	private String ruleType;
	@ParamDesc(path="RULE_DESC",cons=ConsType.CT001,type="string",len="200",desc="规则描述",memo="略")
	private String ruleDesc;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,type="string",len="20",desc="操作工号",memo="略")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,type="string",len="64",desc="操作人",memo="略")
	private String operName;

	
	public void decode(MBean bean) {
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setRuleName(bean.getStr(getPathByProperName("ruleName")));
		setRuleType(bean.getStr(getPathByProperName("ruleType")));
		setRuleDesc(bean.getStr(getPathByProperName("ruleDesc")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
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


	public String getBusiId() {
		return busiId;
	}




	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}




	public String getBusiType() {
		return busiType;
	}




	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}


	
	
}
