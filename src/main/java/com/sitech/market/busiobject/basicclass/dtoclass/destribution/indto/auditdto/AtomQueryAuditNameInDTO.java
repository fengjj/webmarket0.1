package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-1
 * @author: dongyh
 * @Title: AtomQueryAuditNameInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryAuditNameInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="20",type="String",desc="业务ID",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="20",type="String",desc="业务类型",memo="略")
	private String busiType;
	
	public void decode(MBean bean) {
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
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
