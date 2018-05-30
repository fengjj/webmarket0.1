package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.ruledto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-2
 * @author: xiongxin
 * @Title: AtomGetRuleContentInDTO
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetRuleContentInDTO extends StandardInDTO{

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ACT_TYPE",cons=ConsType.QUES,type="string",len="18",desc="综合类营销",memo="略")
	private String actType;
	@ParamDesc(path="ACT_CLASS",cons=ConsType.QUES,type="string",len="18",desc="条件赠费",memo="略")
	private String actClass;
	
	public void decode(MBean bean){
		setActType(bean.getStr(getPathByProperName("actType")));
		setActClass(bean.getStr(getPathByProperName("actClass")));
	}
	
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	public String getActClass() {
		return actClass;
	}
	public void setActClass(String actClass) {
		this.actClass = actClass;
	}
	
}
