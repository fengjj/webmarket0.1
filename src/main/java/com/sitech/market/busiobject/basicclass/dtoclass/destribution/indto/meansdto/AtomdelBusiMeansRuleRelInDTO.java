package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.meansdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomdelBusiMeansRuleRelInDTO extends InDTO{
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="20",type="String",desc="操作工号",memo="")
	private String OPER_NO;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,len="20",type="String",desc="操作工号",memo="")
	private String OPER_NAME;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="20",type="String",desc="活动ID",memo="")
	private String BUSI_ID;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="20",type="String",desc="活动ID",memo="")
	private String BUSI_TYPE;
	@ParamDesc(path="MEANS_ID",cons=ConsType.CT001,len="20",type="String",desc="活动ID",memo="")
	private String MEANS_ID;
	@Override
	
	public void decode(MBean bean) {
		setMEANS_ID(bean.getStr(getPathByProperName("MEANS_ID")));
		setBUSI_ID(bean.getStr(getPathByProperName("BUSI_ID")));
		setBUSI_TYPE(bean.getStr(getPathByProperName("BUSI_TYPE")));
		setOPER_NO(bean.getStr(getPathByProperName("OPER_NO")));
		setOPER_NAME(bean.getStr(getPathByProperName("OPER_NAME")));
	}
	public String getBUSI_ID() {
		return BUSI_ID;
	}
	public void setBUSI_ID(String busi_id) {
		BUSI_ID = busi_id;
	}
	public String getBUSI_TYPE() {
		return BUSI_TYPE;
	}
	public void setBUSI_TYPE(String busi_type) {
		BUSI_TYPE = busi_type;
	}
	public String getMEANS_ID() {
		return MEANS_ID;
	}
	public void setMEANS_ID(String means_id) {
		MEANS_ID = means_id;
	}
	public String getOPER_NO() {
		return OPER_NO;
	}
	public void setOPER_NO(String oPER_NO) {
		OPER_NO = oPER_NO;
	}
	public String getOPER_NAME() {
		return OPER_NAME;
	}
	public void setOPER_NAME(String oPER_NAME) {
		OPER_NAME = oPER_NAME;
	}

}
