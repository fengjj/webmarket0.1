package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-19
 * @author: dongyh
 * @Title: AtomUpdateActInfoInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomUpdateActInfoInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,len="18",type="string",desc="活动ID",memo="略")
	private String actId;
	@ParamDesc(path="STATUS_CODE",cons=ConsType.QUES,len="5",type="string",desc="活动状态,mk_actstatus_dict",memo="略")
	private String statusCode;
	@ParamDesc(path="UPDATE_NO",cons=ConsType.QUES,len="20",type="string",desc="修改人工号",memo="略")
	private String updateNo;
	@ParamDesc(path="UPDATE_NAME",cons=ConsType.QUES,len="64",type="string",desc="修改人姓名",memo="略")
	private String updateName;
	@ParamDesc(path="ACT_TYPE",cons=ConsType.CT001,len="8",type="string",desc="活动大类型编码",memo="略")
	private String actType;
	@ParamDesc(path="ACT_CLASS",cons=ConsType.CT001,len="8",type="string",desc="活动小类型编码",memo="略")
	private String actClass;
	@ParamDesc(path="DIS_FLAG",cons=ConsType.QUES,len="2",type="string",desc="0-新增，完全权限；1审批中，所有不可增删；2执行中（规则修改）",memo="略")
	private String disFlag;
	@ParamDesc(path="BUSI_NAME",cons=ConsType.QUES,len="200",type="string",desc="活动名称",memo="略")
	private String busiName;
	
	public void decode(MBean bean) {
		setActId(bean.getStr(getPathByProperName("actId")));
		setStatusCode(bean.getStr(getPathByProperName("statusCode")));
		setUpdateNo(bean.getStr(getPathByProperName("updateNo")));
		setUpdateName(bean.getStr(getPathByProperName("updateName")));
		setActType(bean.getStr(getPathByProperName("actType")));
		setActClass(bean.getStr(getPathByProperName("actClass")));
		setDisFlag(bean.getStr(getPathByProperName("disFlag")));
		setBusiName(bean.getStr(getPathByProperName("busiName")));
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

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getActClass() {
		return actClass;
	}

	public void setActClass(String actClass) {
		this.actClass = actClass;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getDisFlag() {
		return disFlag;
	}

	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}

	public String getBusiName() {
		return busiName;
	}

	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}
	
}
