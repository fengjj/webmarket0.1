package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-25
 * @author: nidw
 * @Title: AtomDelBasicRuleInfoInDTO
 * @Description： 自动打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomDelBasicRuleInfoInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.QUES,type="string",len="18",desc="业务ID",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.QUES,type="string",len="18",desc="业务类型",memo="略")
	private String busiType;
	@ParamDesc(path="RULE_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="规则流水",memo="略")
	private String ruleSerialId;
	public void decode(MBean bean) {
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setRuleSerialId(bean.getStr(getPathByProperName("ruleSerialId")));
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

	public String getRuleSerialId() {
		return ruleSerialId;
	}

	public void setRuleSerialId(String ruleSerialId) {
		this.ruleSerialId = ruleSerialId;
	}

	
	
}
