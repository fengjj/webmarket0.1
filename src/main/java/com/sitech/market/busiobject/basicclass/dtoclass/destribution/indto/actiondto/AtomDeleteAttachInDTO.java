package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-14
 * @author: dongyh
 * @Title: AtomDeleteAttachInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomDeleteAttachInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ATTACH_ID",cons=ConsType.CT001,len="18",type="String",desc="附件ID",memo="略")
	private String attachId;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="20",type="String",desc="操作工号",memo="略")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,len="64",type="String",desc="操作工号姓名",memo="略")
	private String operName;
	
	public void decode(MBean bean){
		setAttachId(bean.getStr(getPathByProperName("attachId")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
	}

	public String getOperNo() {
		return operNo;
	}

	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}
}
