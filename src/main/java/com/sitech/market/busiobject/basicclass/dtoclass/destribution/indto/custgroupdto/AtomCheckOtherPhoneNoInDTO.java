package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-8-25
 * @author: liuhaoa
 * @Title: AtomCheckOtherPhoneNoInDTO 
 * @Description： 温暖工程，它网手机号码校验
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomCheckOtherPhoneNoInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="PHONE_NO",cons=ConsType.CT001,len="100",desc="本网号码",type="String",memo="略")
	private String phoneNo;
	@ParamDesc(path="CHOICE_CODE",cons=ConsType.CT001,len="100",desc="选择模式",type="String",memo="略")
	private String choiceCode;
	@ParamDesc(path="OTHER_PHONE_NO",cons=ConsType.CT001,len="100",desc="它网号码",type="String",memo="略")
	private String otherPhoneNo;
	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,len="100",desc="活动小类",type="String",memo="略")
	private String actId;
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getChoiceCode() {
		return choiceCode;
	}
	public void setChoiceCode(String choiceCode) {
		this.choiceCode = choiceCode;
	}
	public String getOtherPhoneNo() {
		return otherPhoneNo;
	}
	public void setOtherPhoneNo(String otherPhoneNo) {
		this.otherPhoneNo = otherPhoneNo;
	}
	
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	@Override
	public void decode(MBean bean){
		setPhoneNo(bean.getStr(getPathByProperName("phoneNo")));
		setChoiceCode(bean.getStr(getPathByProperName("choiceCode")));
		setOtherPhoneNo(bean.getStr(getPathByProperName("otherPhoneNo")));
		setActId(bean.getStr(getPathByProperName("actId")));
	}
}