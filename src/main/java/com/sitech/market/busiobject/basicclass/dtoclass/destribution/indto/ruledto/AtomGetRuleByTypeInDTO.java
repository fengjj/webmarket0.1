package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-19 
 * @author: yugl
 * @Title: AtomGetRuleByTypeInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetRuleByTypeInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="RULE_TYPE",cons=ConsType.CT001,type="string",len="5",desc="规则大类",memo="略")
	private String ruleType;
	@ParamDesc(path="RULE_CLASS",cons=ConsType.QUES,type="string",len="5",desc="规则小类",memo="略")
	private String ruleClass;
	@ParamDesc(path="TEMPLATE_FLAG",cons=ConsType.QUES,type="string",len="5",desc="模板标识",memo="略")
	private String templateFlag;
	@ParamDesc(path="ACT_CLASS",cons=ConsType.QUES,type="string",len="5",desc="活动小类限制规则列表",memo="略")
	private String actClass;
	
	public void decode(MBean bean) {
		setRuleType(bean.getStr(getPathByProperName("ruleType")));
		setRuleClass(bean.getStr(getPathByProperName("ruleClass")));
		setTemplateFlag(bean.getStr(getPathByProperName("templateFlag")));
		setActClass(bean.getStr(getPathByProperName("actClass")));
	}

	
	
	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleClass() {
		return ruleClass;
	}

	public void setRuleClass(String ruleClass) {
		this.ruleClass = ruleClass;
	}



	public String getTemplateFlag() {
		return templateFlag;
	}



	public void setTemplateFlag(String templateFlag) {
		this.templateFlag = templateFlag;
	}



	public String getActClass() {
		return actClass;
	}



	public void setActClass(String actClass) {
		this.actClass = actClass;
	}

	
}
