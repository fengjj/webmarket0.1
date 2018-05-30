package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

public class AtomQueryResourceTicketFeeInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="TICKET_ID",cons=ConsType.CT001,type="string",len="18",desc="µç×ÓÈ¯ID",memo="ÂÔ")
	private String ticketId;
	
	public void decode(MBean bean) {
		setTicketId(bean.getStr(getPathByProperName("ticketId")));
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

}
