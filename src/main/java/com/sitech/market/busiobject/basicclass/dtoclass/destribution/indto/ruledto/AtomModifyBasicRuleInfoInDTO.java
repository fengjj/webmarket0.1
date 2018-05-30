package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-25
 * @author: nidw
 * @Title: AtomModifyBasicRuleInfoInDTO
 * @Description： 自动打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomModifyBasicRuleInfoInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="RULE_NAME",cons=ConsType.QUES,type="string",len="200",desc="业务类型",memo="略")
	private String ruleName;
	@ParamDesc(path="RULE_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="规则流水",memo="略")
	private String ruleSerialId;
	public void decode(MBean bean) {
		setRuleSerialId(bean.getStr(getPathByProperName("ruleSerialId")));
		setRuleName(bean.getStr(getPathByProperName("ruleName")));
	}

	public String getRuleSerialId() {
		return ruleSerialId;
	}

	public void setRuleSerialId(String ruleSerialId) {
		this.ruleSerialId = ruleSerialId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	
	
}
