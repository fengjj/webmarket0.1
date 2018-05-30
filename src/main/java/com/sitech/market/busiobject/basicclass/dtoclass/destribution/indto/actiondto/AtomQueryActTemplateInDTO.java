package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-7
 * @author: dongyh
 * @Title: AtomQueryActTemplateInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryActTemplateInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="TEMPLATE_TYPE",cons=ConsType.CT001,len="5",type="String",desc="模板分类",memo="略")
	private String templateType;

	public void decode(MBean bean) {
		setTemplateType(bean.getStr(getPathByProperName("templateType")));
	}
	
	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
}
