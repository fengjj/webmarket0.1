package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-23 
 * @author: yugl
 * @Title: AtomGetContentListInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomGetContentListInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CONTENT_TYPE",cons=ConsType.CT001,type="string",len="5",desc="内容类型",memo="略")
	private String contentType;
	@ParamDesc(path="TEMPLATE_FLAG",cons=ConsType.CT001,type="string",len="5",desc="模板标示",memo="略")
	private String templateFlag;
	
	public void decode(MBean bean) {
		setContentType(bean.getStr(getPathByProperName("contentType")));
		setTemplateFlag(bean.getStr(getPathByProperName("templateFlag")));
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getTemplateFlag() {
		return templateFlag;
	}

	public void setTemplateFlag(String templateFlag) {
		this.templateFlag = templateFlag;
	}

	
	
	
	
}
