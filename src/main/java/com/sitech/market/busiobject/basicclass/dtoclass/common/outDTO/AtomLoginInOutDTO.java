package com.sitech.market.busiobject.basicclass.dtoclass.common.outDTO;

import java.util.List;
import java.util.Map;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;

public class AtomLoginInOutDTO extends StandardOutDTO {
	private static final long serialVersionUID = 1L;

	private Map loginMap;
	private List positions;
	public Map getLoginMap() {
		return loginMap;
	}
	public void setLoginMap(Map loginMap) {
		this.loginMap = loginMap;
	}
	public List getPositions() {
		return positions;
	}
	public void setPositions(List positions) {
		this.positions = positions;
	}
	@Override
	public MBean encode() {
		MBean bean = new MBean();
		bean.setBody("resultBean",getLoginMap());
		bean.setBody("positions",getPositions());
		return bean;
	}

}
