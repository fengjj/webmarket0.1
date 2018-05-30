package com.sitech.market.busiobject.basicclass.dtoclass.common.outDTO;

import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;

public class AtomSendMsgOutDTO extends StandardOutDTO {
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="RESULT_FLAG",cons=ConsType.CT001,len="100",type="String",desc="返回值",memo="0：成功，1：失败")
	private String reslutFalg;
	
	@Override
	public MBean encode() {
		MBean bean = new MBean();
		bean.setBody("RESULT_FLAG",reslutFalg);
		return bean;
	}

	public String getReslutFalg() {
		return reslutFalg;
	}

	public void setReslutFalg(String reslutFalg) {
		this.reslutFalg = reslutFalg;
	}

}
