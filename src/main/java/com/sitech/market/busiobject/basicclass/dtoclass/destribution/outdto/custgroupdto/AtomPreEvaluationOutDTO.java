package com.sitech.market.busiobject.basicclass.dtoclass.destribution.outdto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardOutDTO;

/**
 * Ԥ��������DTO
 * @Create on 2015-7-30 
 * @author: wangdw
 * @Title: AtomPreEvaluationOutDTO 
 * @Description�� 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public class AtomPreEvaluationOutDTO extends StandardOutDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="ACT_ID",cons=ConsType.CT001,len="30",desc="�ID",type="String",memo="��")
	private String actId;
	@ParamDesc(path="ACT_NAME",cons=ConsType.CT001,len="200",desc="�����",type="String",memo="��")
	private String actName;
	@ParamDesc(path="APPLY_PHONE",cons=ConsType.CT001,len="30",desc="�������Ѻ���",type="String",memo="��")
	private String applyPhone;
	@ParamDesc(path="START_DATE",cons=ConsType.CT001,len="30",desc="��������",type="String",memo="��")
	private String startDate;
	@ParamDesc(path="SEND_MODEL",cons=ConsType.CT001,len="60",desc="����ģʽ",type="String",memo="��")
	private String sendModel;
	@ParamDesc(path="ACT_DESC",cons=ConsType.CT001,len="500",desc="�������Ӫ����������",type="String",memo="��")
	private String actDesc;
	@ParamDesc(path="SUM_NUM",cons=ConsType.CT001,len="30",desc="�ܼ�¼��",type="String",memo="��")
	private String sumNum;
	@ParamDesc(path="IN_NUM",cons=ConsType.CT001,len="30",desc="����¼��",type="String",memo="��")
	private String inNum;
	@ParamDesc(path="SUCCESS_NUM",cons=ConsType.CT001,len="30",desc="������¼��",type="String",memo="��")
	private String successNum;
	@ParamDesc(path="PRE_NUM",cons=ConsType.CT001,len="30",desc="Ԥ��Ԥ����",type="String",memo="��")
	private String preNum;
	@ParamDesc(path="EXP_NUM",cons=ConsType.CT001,len="30",desc="��������¼��",type="String",memo="��")
	private String expNum;
	@ParamDesc(path="PHONE_NUM",cons=ConsType.CT001,len="30",desc="Ԥ�����ͺ�����",type="String",memo="��")
	private String phoneNum;
	@ParamDesc(path="IN_MONEY",cons=ConsType.QUES,len="30",desc="����ܶ�",type="String",memo="��")
	private String inMoney;
	@ParamDesc(path="SEND_MONEY",cons=ConsType.QUES,len="30",desc="Ԥ�������ܶ�",type="String",memo="��")
	private String sendMoney;
	public MBean encode() {
		MBean resultBean = new MBean();
		resultBean.setBody("ACT_ID", this.actId);
		resultBean.setBody("ACT_NAME", this.actName);
		resultBean.setBody("APPLY_PHONE", this.applyPhone);
		resultBean.setBody("START_DATE", this.startDate);
		resultBean.setBody("SEND_MODEL", this.sendModel);
		resultBean.setBody("ACT_DESC", this.actDesc);
		resultBean.setBody("SUM_NUM", this.sumNum);
		resultBean.setBody("IN_NUM", this.inNum);
		resultBean.setBody("SUCCESS_NUM", this.successNum);
		resultBean.setBody("PRE_NUM", this.preNum);
		resultBean.setBody("EXP_NUM", this.expNum);
		resultBean.setBody("PHONE_NUM", this.phoneNum);
		resultBean.setBody("IN_MONEY", this.inMoney);
		resultBean.setBody("SEND_MONEY", this.sendMoney);
		return resultBean;
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getApplyPhone() {
		return applyPhone;
	}
	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getSendModel() {
		return sendModel;
	}
	public void setSendModel(String sendModel) {
		this.sendModel = sendModel;
	}
	public String getActDesc() {
		return actDesc;
	}
	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}
	public String getSumNum() {
		return sumNum;
	}
	public void setSumNum(String sumNum) {
		this.sumNum = sumNum;
	}
	public String getInNum() {
		return inNum;
	}
	public void setInNum(String inNum) {
		this.inNum = inNum;
	}
	public String getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(String successNum) {
		this.successNum = successNum;
	}
	public String getPreNum() {
		return preNum;
	}
	public void setPreNum(String preNum) {
		this.preNum = preNum;
	}
	public String getExpNum() {
		return expNum;
	}
	public void setExpNum(String expNum) {
		this.expNum = expNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getInMoney() {
		return inMoney;
	}
	public void setInMoney(String inMoney) {
		this.inMoney = inMoney;
	}
	public String getSendMoney() {
		return sendMoney;
	}
	public void setSendMoney(String sendMoney) {
		this.sendMoney = sendMoney;
	}

}
