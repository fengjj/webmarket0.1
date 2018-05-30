package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.meansdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomdelBusiContentRelInDTO extends InDTO{
	
	@ParamDesc(path="CONTENT_SERIAL_ID",cons=ConsType.CT001,len="20",type="String",desc="档次ID",memo="")
	private String CONTENT_SERIAL_ID;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="20",type="String",desc="业务ID",memo="")
	private String BUSI_ID;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="20",type="String",desc="业务类型",memo="")
	private String BUSI_TYPE;
	
	@Override
	public void decode(MBean bean) {
		setCONTENT_SERIAL_ID(bean.getStr(getPathByProperName("CONTENT_SERIAL_ID")));
		setBUSI_ID(bean.getStr(getPathByProperName("BUSI_ID")));
		setBUSI_TYPE(bean.getStr(getPathByProperName("BUSI_TYPE")));
	}


	public String getCONTENT_SERIAL_ID() {
		return CONTENT_SERIAL_ID;
	}


	public void setCONTENT_SERIAL_ID(String content_serial_id) {
		CONTENT_SERIAL_ID = content_serial_id;
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
