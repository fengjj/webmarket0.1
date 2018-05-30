package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-8
 * @author: dongyh
 * @Title: AtomSaveActTemplateInDTO
 * @Description： 打印DTO对象
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveActTemplateInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;

	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="18",type="string",desc="业务ID",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="5",type="string",desc="业务类型",memo="略")
	private String busiType;
	@ParamDesc(path="TEMPLATE_ID",cons=ConsType.CT001,len="18",type="string",desc="营销模板ID",memo="略")
	private String templateId;
	@ParamDesc(path="UPDATE_NO",cons=ConsType.CT001,len="20",type="string",desc="更新人ID",memo="略")
	private String updateNo;
	@ParamDesc(path="UPDATE_NAME",cons=ConsType.CT001,len="64",type="string",desc="更新人姓名",memo="略")
	private String updateName;
	
	 
	public void decode(MBean bean){
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setTemplateId(bean.getStr(getPathByProperName("templateId")));
		setUpdateNo(bean.getStr(getPathByProperName("updateNo")));
		setUpdateName(bean.getStr(getPathByProperName("updateName")));
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


	public String getTemplateId() {
		return templateId;
	}


	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUpdateNo() {
		return updateNo;
	}

	public void setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
}
