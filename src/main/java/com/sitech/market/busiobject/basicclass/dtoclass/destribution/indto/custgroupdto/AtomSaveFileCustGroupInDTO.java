package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 保存附件客户群
 * @Create on 2015-7-28 
 * @author: wangdw
 * @Title: AtomSaveFileCustGroupInDTO 
 * @Description： 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
@SuppressWarnings("serial")
public class AtomSaveFileCustGroupInDTO extends StandardInDTO {
	
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,len="100",desc="业务ID",type="String",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="100",desc="业务类型",type="String",memo="略")
	private String busiType;
	@ParamDesc(path="CUST_GROUP_NAME",cons=ConsType.CT001,len="200",desc="客户群名称",type="String",memo="略")
	private String custGroupName;
	@ParamDesc(path="START_DATE",cons=ConsType.CT001,len="30",desc="开始时间",type="String",memo="略")
	private String startDate;
	@ParamDesc(path="CHOICE_CODE",cons=ConsType.CT001,len="2",desc="客户群选择模式",type="String",memo="略")
	private String choiceCode;
	@ParamDesc(path="CUST_GROUP_ID",cons=ConsType.QUES,len="18",desc="客户群ID",type="String",memo="略")
	private String custGroupId;
	@ParamDesc(path="CUST_REL_SERIAL_ID",cons=ConsType.QUES,len="18",desc="业务客户群关系ID",type="String",memo="略")
	private String custRelSerialId;
	@ParamDesc(path="LOGIN_NO",cons=ConsType.CT001,len="10",desc="操作工号",type="String",memo="略")
	private String loginNo;
	@ParamDesc(path="LOGIN_NAME",cons=ConsType.CT001,len="50",desc="操作名称",type="String",memo="略")
	private String loginName;
	@ParamDesc(path="REGION_CODE",cons=ConsType.QUES,len="10",desc="地市编码",type="String",memo="略")
	private String regionCode;
	
	@Override
	public void decode(MBean bean){
		this.busiId = bean.getStr(getPathByProperName("busiId"));
		this.busiType = bean.getStr(getPathByProperName("busiType"));
		this.custGroupName = bean.getStr(getPathByProperName("custGroupName"));
		this.startDate = bean.getStr(getPathByProperName("startDate"));
		this.choiceCode = bean.getStr(getPathByProperName("choiceCode"));
		this.custGroupId = bean.getStr(getPathByProperName("custGroupId"));
		this.loginNo = bean.getStr(getPathByProperName("loginNo"));
		this.loginName = bean.getStr(getPathByProperName("loginName"));	
		this.regionCode = bean.getStr(getPathByProperName("regionCode"));
		this.custRelSerialId = bean.getStr(getPathByProperName("custRelSerialId"));
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

	public String getCustGroupName() {
		return custGroupName;
	}

	public void setCustGroupName(String custGroupName) {
		this.custGroupName = custGroupName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getChoiceCode() {
		return choiceCode;
	}

	public void setChoiceCode(String choiceCode) {
		this.choiceCode = choiceCode;
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getCustGroupId() {
		return custGroupId;
	}

	public void setCustGroupId(String custGroupId) {
		this.custGroupId = custGroupId;
	}

	public String getCustRelSerialId() {
		return custRelSerialId;
	}

	public void setCustRelSerialId(String custRelSerialId) {
		this.custRelSerialId = custRelSerialId;
	}
	
}
