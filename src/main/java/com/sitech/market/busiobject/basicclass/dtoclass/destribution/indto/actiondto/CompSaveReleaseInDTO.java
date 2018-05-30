package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

public class CompSaveReleaseInDTO extends InDTO {

	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,len="18",type="string",desc="活动ID",memo="略")
	private String actId;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.QUES,len="5",type="string",desc="活动状态,mk_actstatus_dict",memo="略")
	private String statusCode;
	@ParamDesc(path="UPDATE_NO",cons=ConsType.QUES,len="20",type="string",desc="修改人工号",memo="略")
	private String updateNo;
	@ParamDesc(path="UPDATE_NAME",cons=ConsType.QUES,len="64",type="string",desc="修改人姓名",memo="略")
	private String updateName;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,len="64",type="string",desc="省份代码",memo="略")
	private String provinceGroup;
	
	@Override
	public void decode(MBean arg0) {
		setActId(arg0.getStr(getPathByProperName("actId")));
		setStatusCode(arg0.getStr(getPathByProperName("statusCode")));
		setUpdateNo(arg0.getStr(getPathByProperName("updateNo")));
		setUpdateName(arg0.getStr(getPathByProperName("updateName")));
		setProvinceGroup(arg0.getStr(getPathByProperName("provinceGroup")));
	}

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getUpdateNo() {
		return updateNo;
	}

	public void setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

}
