package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.channeldto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-08-17
 * @author: husheng
 * @Title: AtomQueryChnRuleInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryChnRuleInDTO extends StandardInDTO  {
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,type="string",len="18",desc="业务编码",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,type="string",len="5",desc="业务类型",memo="略")
	private String busiType;
	
	public void decode(MBean arg0) {
		setBusiId(arg0.getStr(getPathByProperName("busiId")));
		setBusiType(arg0.getStr(getPathByProperName("busiType")));
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
}
