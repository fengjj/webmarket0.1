package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-4-2
 * @author: dongyh
 * @Title: AtomQueryExeElementsInDTO
 * @Description�� �Զ���ӡ��β���
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetRuleitemInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="RULE_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="������ˮ",memo="��")
	private String ruleSerialId;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="18",desc="ʡ�ݱ���",memo="��")
	private String provinceGroup;
	
	public void decode(MBean bean) {
		setRuleSerialId(bean.getStr(getPathByProperName("ruleSerialId")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
	}

	
	public String getRuleSerialId() {
		return ruleSerialId;
	}
	public void setRuleSerialId(String ruleSerialId) {
		this.ruleSerialId = ruleSerialId;
	}


	public String getProvinceGroup() {
		return provinceGroup;
	}


	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	
	
}
