package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.meansdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomSaveBusiMeansRelInDTO extends InDTO{
	
	@ParamDesc(path="MEANS_ID",cons=ConsType.CT001,len="20",type="String",desc="档次ID",memo="")
	private String MEANS_ID;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="20",type="String",desc="业务ID",memo="")
	private String BUSI_ID;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="20",type="String",desc="业务类型",memo="")
	private String BUSI_TYPE;
	
	@Override
	public void decode(MBean bean) {
		setMEANS_ID(bean.getStr(getPathByProperName("MEANS_ID")));
		setBUSI_ID(bean.getStr(getPathByProperName("BUSI_ID")));
		setBUSI_TYPE(bean.getStr(getPathByProperName("BUSI_TYPE")));
	}

	public String getMEANS_ID() {
		return MEANS_ID;
	}

	public void setMEANS_ID(String means_id) {
		MEANS_ID = means_id;
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

	
	
}
