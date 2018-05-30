package com.sitech.market.busiobject.basicclass.dataclass;

import java.util.HashMap;
import java.util.Map;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;
/**
 * 券类outDTO对象
 * @Create on 2015-7-23 
 * @author: wangdw
 * @Title: TicketInfoOut 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public class TicketInfoOut implements Encodeable ,Decodeable {
	@ParamDesc(path="SERIAL_ID",cons=ConsType.CT001,len="100",desc="券内容流水id",type="String",memo="略")
	private String serialId;
	@ParamDesc(path="ELEMENT_BATCH_NO",cons=ConsType.CT001,len="100",desc="内容表contentSerialId",type="String",memo="略")
	private String elementBatchNo;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.CT001,len="100",desc="元素ID",type="String",memo="略")
	private String elementId;
	@ParamDesc(path="TICKET_ID",cons=ConsType.CT001,len="100",desc="电子券id",type="String",memo="略")
	private String ticketId;
	@ParamDesc(path="TICKET_TYPE",cons=ConsType.CT001,len="100",desc="券分类 0红包",type="String",memo="略")
	private String ticketType;
	@ParamDesc(path="TICKET_NAME",cons=ConsType.CT001,len="100",desc="券名称",type="String",memo="略")
	private String ticketName;
	@ParamDesc(path="TICKET_FEE",cons=ConsType.CT001,len="100",desc="券面额",type="String",memo="略")
	private String ticketFee;
	@ParamDesc(path="RELATION_ID",cons=ConsType.QUES,len="5",desc="mk_busicontent_rel关系表rel_id主键",type="String",memo="略")
	private String relationId;
	@ParamDesc(path="ASSIGN_ID",cons=ConsType.QUES,len="64",desc="券分配ID，mk_resourceticketassign_info表",type="String",memo="略")
	private String assignId;
	@ParamDesc(path="PHONE_NO",cons=ConsType.CT001,len="100",desc="手机号码",type="String",memo="略")
	private String  phoneNo;


	@Override
	public void decode(Map in) {
		this.serialId = (String) in.get("SERIAL_ID");
		this.elementBatchNo = (String) in.get("ELEMENT_BATCH_NO");;
		this.elementId = (String) in.get("ELEMENT_ID");
		this.ticketId = (String) in.get("TICKET_ID");
		this.ticketType = (String) in.get("TICKET_TYPE");
		this.ticketName = (String) in.get("TICKET_NAME");
		this.ticketFee = (String) in.get("TICKET_FEE");
		this.relationId = (String) in.get("RELATION_ID");
		this.assignId = (String) in.get("TICKET_ASSIGN_ID");
		this.phoneNo = (String) in.get("PHONE_NO");
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> ticketInfoOut = new HashMap<String, Object>();
		
		ticketInfoOut.put("SERIAL_ID", this.serialId);
		ticketInfoOut.put("ELEMENT_BATCH_NO", this.elementBatchNo);
		ticketInfoOut.put("ELEMENT_ID", this.elementId);
		ticketInfoOut.put("TICKET_ID", this.ticketId);
		ticketInfoOut.put("TICKET_TYPE", this.ticketType);
		ticketInfoOut.put("TICKET_NAME", this.ticketName);
		ticketInfoOut.put("TICKET_FEE", this.ticketFee);
		ticketInfoOut.put("RELATION_ID", this.relationId);
		ticketInfoOut.put("TICKET_ASSIGN_ID", this.assignId);
		ticketInfoOut.put("PHONE_NO", this.phoneNo);
		System.out.println("***************ticketInfoOut:"+ticketInfoOut);
		return ticketInfoOut;
	}


	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getElementBatchNo() {
		return elementBatchNo;
	}

	public void setElementBatchNo(String elementBatchNo) {
		this.elementBatchNo = elementBatchNo;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getTicketFee() {
		return ticketFee;
	}

	public void setTicketFee(String ticketFee) {
		this.ticketFee = ticketFee;
	}
	
	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getAssignId() {
		return assignId;
	}

	public void setAssignId(String assignId) {
		this.assignId = assignId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
