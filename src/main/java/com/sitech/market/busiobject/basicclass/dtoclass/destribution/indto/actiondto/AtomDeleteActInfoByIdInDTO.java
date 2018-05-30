package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class AtomDeleteActInfoByIdInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="actId",cons=ConsType.CT001,len="20",type="String",desc="活动id",memo="")
	private String actId;
	@ParamDesc(path="operNo",cons=ConsType.CT001,len="20",type="String",desc="操作人工号",memo="")
	private String operNo;
	@ParamDesc(path="operName",cons=ConsType.CT001,len="40",type="String",desc="操作人姓名",memo="")
	private String operName;
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getOperNo() {
		return operNo;
	}
	public void setOperNo(String operNo) {
		this.operNo = operNo;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	@Override
	public void decode(MBean arg0) {
		this.actId = arg0.getBodyStr("actId");
		this.operNo = arg0.getBodyStr("operNo");
		this.operName = arg0.getBodyStr("operName");
	}

}
