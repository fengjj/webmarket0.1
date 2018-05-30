package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomInitActBasicForupdateInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="actId",cons=ConsType.CT001,len="20",type="String",desc="活动id",memo="")
	private String actId;
	@ParamDesc(path="disFlag",cons=ConsType.CT001,len="2",type="String",desc="当前状态的操作标识",memo="")
	private String disFlag;
	@ParamDesc(path="actClass",cons=ConsType.CT001,len="5",type="String",desc="活动小类",memo="")
	private String actClass;
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getDisFlag() {
		return disFlag;
	}
	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}
	public String getActClass() {
		return actClass;
	}
	public void setActClass(String actClass) {
		this.actClass = actClass;
	}
	@Override
	public void decode(MBean arg0) {
		System.out.println(arg0);
		System.out.println(getPathByProperName("actId"));
		System.out.println(arg0.getStr(getPathByProperName("actId")));
		setActId(arg0.getStr(getPathByProperName("actId")));
		setActClass(arg0.getStr(getPathByProperName("actClass")));
		setDisFlag(arg0.getStr(getPathByProperName("disFlag")));
	}

}
