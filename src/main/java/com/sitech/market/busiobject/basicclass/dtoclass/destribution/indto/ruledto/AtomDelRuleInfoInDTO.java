package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;


import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-18
 * @author: lixd_bj
 * @Title: AtomDelRuleINfoInDTO
 * @Description： 自动打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomDelRuleInfoInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.QUES,type="string",len="18",desc="业务ID",memo="略")
	private String busiId;
	@ParamDesc(path="REL_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="关系流水",memo="略")
	private String relSerialId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.QUES,type="string",len="18",desc="业务类型",memo="略")
	private String busiType;
	@ParamDesc(path="RULE_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="规则流水",memo="略")
	private String ruleSerialId;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="18",desc="省份编码",memo="略")
	private String provinceGroup;
	//FLAG-删除标识：1-根据业务ID删除规则信息；2-根据关系流水删除规则信息；3-根据规则流水删除规则信息；
	@ParamDesc(path="FLAG",cons=ConsType.QUES,type="string",len="18",desc="省份编码",memo="略")
	private String flag;
	public void decode(MBean bean) {
		setFlag(bean.getStr(getPathByProperName("flag")));
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setRelSerialId(bean.getStr(getPathByProperName("relSerialId")));
		setRuleSerialId(bean.getStr(getPathByProperName("ruleSerialId")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getRelSerialId() {
		return relSerialId;
	}


	public void setRelSerialId(String relSerialId) {
		this.relSerialId = relSerialId;
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

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
