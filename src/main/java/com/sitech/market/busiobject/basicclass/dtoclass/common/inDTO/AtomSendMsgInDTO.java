package com.sitech.market.busiobject.basicclass.dtoclass.common.inDTO;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomSendMsgInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="SERIAL_ID",cons=ConsType.STAR,type="String",len="50",desc="活动序列",memo="略")
	private String serialId;
	@ParamDesc(path="MSP_TOPIC",cons=ConsType.CT001,type="String",len="50",desc="消息主题",memo="略")
	private String mspTopic;
	@ParamDesc(path="MSP_ID",cons=ConsType.CT001,type="String",len="20",desc="消息ID",memo="略")
	private String mspId;
	@ParamDesc(path="TOPIC_TYPE",cons=ConsType.CT001,type="String",len="20",desc="消息类型，0-生产，1-消费",memo="略")
	private String topicType;
	@ParamDesc(path="PHONE_NO",cons=ConsType.STAR,type="String",len="20",desc="服务号码",memo="非必填，短信发送必填")
	private String phoneNo;
	@ParamDesc(path="MSG_CONTENT",cons=ConsType.CT001,type="String",len="2000",desc="信息内容",memo="略")
	private String msgContent;
	
	@Override
	public void decode(MBean arg0) {
		this.serialId = arg0.getStr(getPathByProperName("serialId"));
		this.mspTopic = arg0.getStr(getPathByProperName("mspTopic"));
		this.mspId = arg0.getStr(getPathByProperName("mspId"));
		this.topicType = arg0.getStr(getPathByProperName("topicType"));
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
	public String getMspTopic() {
		return mspTopic;
	}
	public void setMspTopic(String mspTopic) {
		this.mspTopic = mspTopic;
	}
	public String getMspId() {
		return mspId;
	}
	public void setMspId(String mspId) {
		this.mspId = mspId;
	}
	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	public String getTopicType() {
		return topicType;
	}
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

}
