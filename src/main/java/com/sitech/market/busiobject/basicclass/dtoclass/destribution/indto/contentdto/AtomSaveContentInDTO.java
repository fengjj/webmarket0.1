package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import java.util.ArrayList;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-6
 * @author: zhangchen
 * @Title: AtomSaveContentDetailInDTO 
 * @Description�� 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveContentInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="CONTENT_ID",cons=ConsType.QUES,type="string",len="18",desc="���ݹ�ϵID",memo="��")
	private String contentId;
	@ParamDesc(path="LOGIN_NO",cons=ConsType.QUES,type="string",len="18",desc="��¼����",memo="��")
	private String loginNo;
	@ParamDesc(path="LOGIN_NAME",cons=ConsType.QUES,type="string",len="18",desc="��������",memo="��")
	private String loginName;
	@ParamDesc(path="CONTENT_TYPE",cons=ConsType.QUES,type="string",len="3",desc="������ϸ����",memo="��")
	private String contentType;
	@ParamDesc(path="CONTENT_NAME",cons=ConsType.QUES,type="string",len="50",desc="��������",memo="��")
	private String contentName;
	@ParamDesc(path="REGION_CODE",cons=ConsType.QUES,type="string",len="4",desc="����",memo="��")
	private String regionCode;
	@ParamDesc(path="START_DATE",cons=ConsType.QUES,type="string",len="20",desc="��ʼʱ��",memo="��")
	private String startDate;
	@ParamDesc(path="END_DATE",cons=ConsType.QUES,type="string",len="20",desc="����ʱ��",memo="��")
	private String endDate;
	
	
	//Ԥ��
	public void decode(MBean bean) {
		setContentId(bean.getStr((getPathByProperName("contentId"))));
		setContentType(bean.getStr(getPathByProperName("contentType")));
		setLoginNo(bean.getStr(getPathByProperName("loginNo")));
		setLoginName(bean.getStr(getPathByProperName("loginName")));
		setContentName(bean.getStr(getPathByProperName("contentName")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setStartDate(bean.getStr(getPathByProperName("startDate")));
		setEndDate(bean.getStr(getPathByProperName("endDate")));
	}
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
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
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
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
	
}
