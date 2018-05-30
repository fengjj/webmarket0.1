package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-2
 * @author: dongyh
 * @Title: AtomQueryBusiAttachInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryBusiAttachInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.QUES,len="18",type="string",desc="业务ID",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.QUES,len="5",type="string",desc="业务类型",memo="略")
	private String busiType;
	@ParamDesc(path="ATTACH_ID",cons=ConsType.QUES,len="18",type="string",desc="附件ID",memo="略")
	private String attachId;
	@ParamDesc(path="ORIGINAL_NAME",cons=ConsType.QUES,len="255",type="String",desc="附件原始文件名",memo="略")
	private String originalName;

	public void decode(MBean bean){
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setAttachId(bean.getStr(getPathByProperName("attachId")));
		setOriginalName(bean.getStr(getPathByProperName("originalName")));
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
}
