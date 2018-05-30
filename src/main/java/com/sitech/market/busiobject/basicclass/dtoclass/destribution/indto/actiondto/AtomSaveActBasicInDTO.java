package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

/**
 * ����������Ϣ
 * Create on 2015-4-21 
 * @author: wangdw
 * @Title: AtomSaveActBasicInDTO 
 * @Description�� 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveActBasicInDTO extends InDTO {
	
	private static final long serialVersionUID = -7660260819813915008L;
	
	@ParamDesc(path = "ACT_ID", cons = ConsType.CT001, type = "String", len = "21", desc = "�ID", memo = "������")
	private String actId;
	@ParamDesc(path = "LOGIN_NO", cons = ConsType.CT001, type = "String", len = "40", desc = "��������", memo = "������")
	private String loginNo;
	@ParamDesc(path = "LOGIN_NAME", cons = ConsType.CT001, type = "String", len = "40", desc = "����������", memo = "������")
	private String loginName;// ������
	@ParamDesc(path = "REGION_CODE", cons = ConsType.CT001, type = "String", len = "20", desc = "��������", memo = "������")
	private String regionCode;
	@ParamDesc(path = "GROUP_ID", cons = ConsType.CT001, type = "String", len = "20", desc = "��֯����ID", memo = "������")
	private String groupId;
	@ParamDesc(path = "GROUP_NAME", cons = ConsType.CT001, type = "String", len = "20", desc = "��֯��������", memo = "������")
	private String groupName;
	@ParamDesc(path = "OUT_ACT_ID", cons = ConsType.QUES, type = "String", len = "20", desc = "OA���", memo = "��ϵͳ���ţ���ȫ��Ӫ����ĻID")
	private String outActId;
	@ParamDesc(path = "OUT_SYSTEM_TYPE", cons = ConsType.QUES, type = "String", len = "20", desc = "��ϵͳ����", memo = "��")
	private String outSystemType;
	@ParamDesc(path = "ACT_NAME", cons = ConsType.CT001, type = "String", len = "40", desc = "�����", memo = "�����ʮ�����ϳ��ȵ�����, ������")
	private String actName;
	@ParamDesc(path = "ACT_TYPE", cons = ConsType.CT001, type = "String", len = "2", desc = "�����", memo = "������")
	private String actType;
	@ParamDesc(path = "ACT_CLASS", cons = ConsType.CT001, type = "String", len = "5", desc = "�С��", memo = "������")
	private String actClass;
	@ParamDesc(path = "ACT_AIM_TYPE", cons = ConsType.CT001, type = "String", len = "5", desc = "�Ŀ��", memo = "")
	private String actAimType;
	@ParamDesc(path = "PRIORITY_CODE", cons = ConsType.CT001, type = "String", len = "2", desc = "���ȼ�", memo = "������")
	private String priorityCode;
	@ParamDesc(path = "START_DATE", cons = ConsType.CT001, type = "String", len = "20", desc = "���ʼʱ��", memo = "������")
	private String startDate;
	@ParamDesc(path = "END_DATE", cons = ConsType.CT001, type = "String", len = "20", desc = "�����ʱ��", memo = "������")
	private String endDate;
	@ParamDesc(path = "ACT_DESC", cons = ConsType.QUES, type = "String", len = "1000", desc = "�����", memo = "")
	private String actDesc;
	@ParamDesc(path = "MIX_FLAG", cons = ConsType.QUES, type = "String", len = "2", desc = "�Ƿ���ݿ���Ӫ��", memo = "Y���ݣ�N������")
	private String mixFlag;
	@ParamDesc(path = "ACT_ORIGN", cons = ConsType.QUES, type = "String", len = "255", desc = "���Դ", memo = "���Դ���������ţ�")
	private String actOrign;
	@ParamDesc(path = "ACT_MAX_COUNT", cons = ConsType.QUES, type = "String", len = "5", desc = "��μ����ƴ���", memo = "������")
	private String actMaxCount;
	@ParamDesc(path = "NOTE", cons = ConsType.QUES, type = "String", len = "500", desc = "��ע", memo = "")
	private String note;
	@ParamDesc(path = "ACT_LEVEL", cons = ConsType.QUES, type = "String", len = "5", desc = "������ȼ�", memo = "")
	private String actLevel;
	@ParamDesc(path = "UNIQUE_BUSI_ID", cons = ConsType.QUES, type = "String", len = "50", desc = "ͳһҵ�����", memo = "")
	private String uniqueBusiId;
	@ParamDesc(path = "UPDATE_TYPE", cons = ConsType.QUES, type = "String", len = "5", desc = "�켣���¼��������", memo = "������")
	private String updateType;
	@ParamDesc(path = "DIS_FLAG", cons = ConsType.QUES, type = "String", len = "5", desc = "0-��������ȫȨ�ޣ�1�����У����в�����ɾ��2ִ���У������޸ģ�", memo = "������")
	private String disFlag;
	@ParamDesc(path = "APPLY_PHONE", cons = ConsType.QUES, type = "String", len = "21", desc = "������Ա�������", memo = "������Ա�������")
	private String applyPhone;
	
	
	@Override
	public void decode(MBean actInfoBean) {
		this.actId = actInfoBean.getStr(getPathByProperName("actId"));
		this.loginNo = actInfoBean.getStr(getPathByProperName("loginNo"));
		this.loginName = actInfoBean.getStr(getPathByProperName("loginName"));
		this.regionCode = actInfoBean.getStr(getPathByProperName("regionCode"));
		this.groupId = actInfoBean.getStr(getPathByProperName("groupId"));
		this.groupName = actInfoBean.getStr(getPathByProperName("groupName"));
		this.outActId = actInfoBean.getStr(getPathByProperName("outActId"));
		this.outSystemType = actInfoBean.getStr(getPathByProperName("outSystemType"));
		this.actName = actInfoBean.getStr(getPathByProperName("actName"));
		this.actType = actInfoBean.getStr(getPathByProperName("actType"));
		this.actClass = actInfoBean.getStr(getPathByProperName("actClass"));
		this.actAimType = actInfoBean.getStr(getPathByProperName("actAimType"));
		this.priorityCode = actInfoBean.getStr(getPathByProperName("priorityCode"));
		this.startDate = actInfoBean.getStr(getPathByProperName("startDate"));
		this.endDate = actInfoBean.getStr(getPathByProperName("endDate"));
		this.actDesc = actInfoBean.getStr(getPathByProperName("actDesc"));
		this.mixFlag = actInfoBean.getStr(getPathByProperName("mixFlag"));
		this.actOrign = actInfoBean.getStr(getPathByProperName("actOrign"));
		this.actMaxCount = actInfoBean.getStr(getPathByProperName("actMaxCount"));
		this.note = actInfoBean.getStr(getPathByProperName("note"));
		this.actLevel = actInfoBean.getStr(getPathByProperName("actLevel"));
		this.uniqueBusiId = actInfoBean.getStr(getPathByProperName("uniqueBusiId"));
		this.updateType = actInfoBean.getStr(getPathByProperName("updateType"));
		this.disFlag = actInfoBean.getStr(getPathByProperName("disFlag"));
		this.applyPhone = actInfoBean.getStr(getPathByProperName("applyPhone"));
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
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getOutActId() {
		return outActId;
	}
	public void setOutActId(String outActId) {
		this.outActId = outActId;
	}
	public String getOutSystemType() {
		return outSystemType;
	}
	public void setOutSystemType(String outSystemType) {
		this.outSystemType = outSystemType;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
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
	public String getPriorityCode() {
		return priorityCode;
	}
	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getActDesc() {
		return actDesc;
	}
	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}
	public String getMixFlag() {
		return mixFlag;
	}
	public void setMixFlag(String mixFlag) {
		this.mixFlag = mixFlag;
	}
	public String getActOrign() {
		return actOrign;
	}
	public void setActOrign(String actOrign) {
		this.actOrign = actOrign;
	}
	public String getActMaxCount() {
		return actMaxCount;
	}
	public void setActMaxCount(String actMaxCount) {
		this.actMaxCount = actMaxCount;
	}
	public String getUpdateType() {
		return updateType;
	}
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getActLevel() {
		return actLevel;
	}
	public void setActLevel(String actLevel) {
		this.actLevel = actLevel;
	}
	public String getUniqueBusiId() {
		return uniqueBusiId;
	}
	public void setUniqueBusiId(String uniqueBusiId) {
		this.uniqueBusiId = uniqueBusiId;
	}
	public String getActAimType() {
		return actAimType;
	}
	public void setActAimType(String actAimType) {
		this.actAimType = actAimType;
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getDisFlag() {
		return disFlag;
	}
	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}
	public String getApplyPhone() {
		return applyPhone;
	}
	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}
	
}
