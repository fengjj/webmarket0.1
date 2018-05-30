package com.sitech.market.busiobject.basicclass.dtoclass.common.inDTO;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomSendShortMsgInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="PHONE_NO",cons=ConsType.STAR,type="String",len="20",desc="服务号码",memo="非必填，短信发送必填")
	private String phoneNo;
	@ParamDesc(path="MSG_CONTENT",cons=ConsType.CT001,type="String",len="2000",desc="信息内容",memo="略")
	private String msgContent;
	
	@Override
	public void decode(MBean arg0) {
		this.phoneNo = arg0.getStr(getPathByProperName("phoneNo"));
		this.msgContent = arg0.getStr(getPathByProperName("msgContent"));
	}
	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

}
