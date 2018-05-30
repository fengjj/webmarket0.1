package com.sitech.market.busiobject.basicclass.dtoclass.destribution.outdto.custgroupdto;


import java.util.List;
import java.util.Map;

import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.out.OutDTO;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;
import com.sitech.util.MBeanUtil;

public class AtomSaveCondOutDTO extends StandardOutDTO {

	private Map  saveCondMap;
	private Map  saveMeanMap;
	private Map  saveElementMap;
	@Override
	public MBean encode() {
		MBean resultBean = new MBean();
		resultBean.setBody("saveCondMap",getSaveCondMap());
		resultBean.setBody("saveMeanMap",getSaveMeanMap());
		resultBean.setBody("saveElementMap",getSaveElementMap());
		return resultBean;
	}
	public Map getSaveCondMap() {
		return saveCondMap;
	}
	public void setSaveCondMap(Map saveCondMap) {
		this.saveCondMap = saveCondMap;
	}
	public Map getSaveMeanMap() {
		return saveMeanMap;
	}
	public void setSaveMeanMap(Map saveMeanMap) {
		this.saveMeanMap = saveMeanMap;
	}
	public Map getSaveElementMap() {
		return saveElementMap;
	}
	public void setSaveElementMap(Map saveElementMap) {
		this.saveElementMap = saveElementMap;
	}
	
}
