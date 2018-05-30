package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class CompPublishInDTO extends InDTO {

	@ParamDesc(path="orderId",cons=ConsType.CT001,type="String",len="20",desc="¹¤µ¥id",memo="")
	private String orderId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public void decode(MBean arg0) {
		// TODO Auto-generated method stub

	}

}
