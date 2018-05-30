package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.channeldto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-1 
 * @author: yugl
 * @Title: AtomSaveChnRelInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveChnRelInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,type="string",len="18",desc="业务编码",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,type="string",len="5",desc="业务类型",memo="略")
	private String busiType;
	@ParamDesc(path="CHN_TYPE",cons=ConsType.CT001,type="string",len="18",desc="渠道类型",memo="略")
	private String chnType;
	
	public void decode(MBean bean) {
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setChnType(bean.getStr(getPathByProperName("chnType")));
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getChnType() {
		return chnType;
	}

	public void setChnType(String chnType) {
		this.chnType = chnType;
	}
	
	
}
