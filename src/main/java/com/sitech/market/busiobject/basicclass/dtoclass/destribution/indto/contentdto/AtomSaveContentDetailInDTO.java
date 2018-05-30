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
 * @Description： 加上actClass
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveContentDetailInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="CONTENT_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="内容id",memo="略")
	private String contentSerialId;
	@ParamDesc(path="LOGIN_NO",cons=ConsType.QUES,type="string",len="18",desc="登陆工号",memo="略")
	private String loginNo;
	@ParamDesc(path="LOGIN_NAME",cons=ConsType.QUES,type="string",len="18",desc="登陆行吗",memo="略")
	private String loginName;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="18",desc="元素ID",memo="略")
	private String provinceGroup;
	@ParamDesc(path="ELEMENT_ID",cons=ConsType.QUES,type="string",len="18",desc="元素ID",memo="略")
	private String elementId;
	@ParamDesc(path="ELEMENT_PAR",cons=ConsType.QUES,type="string",len="9999",desc="内容明细",memo="略")
	private String  elementPar;
	@ParamDesc(path="SUB_CONTENT_ID",cons=ConsType.QUES,type="string",len="18",desc="内容明细ID",memo="略")
	private String subContentId;
	@ParamDesc(path="TICKET_NAME",cons=ConsType.QUES,type="string",len="18",desc="电子券名称",memo="略")
	private String ticketName;
	@ParamDesc(path="BUSI_ID",cons=ConsType.QUES,type="string",len="18",desc="活动或者档次ID",memo="略")
	private String busiId;
	@ParamDesc(path="CUST_GROUP_ID",cons=ConsType.QUES,type="string",len="18",desc="客户群ID",memo="略")
	private String custGroupId;
	@ParamDesc(path="CUST_REL_SERIAL_ID",cons=ConsType.QUES,type="string",len="18",desc="客户群ID",memo="略")
	private String custRelSerialId;
	@ParamDesc(path="ACT_CLASS",cons=ConsType.QUES,type="string",len="18",desc="客户群ID",memo="略")
	private String actClass;
	@ParamDesc(path="GROUP_ID",cons=ConsType.QUES,type="string",len="18",desc="GROUP_ID",memo="略")
	private String groupId;
	

	

	public void decode(MBean bean) {
		setContentSerialId(bean.getStr(getPathByProperName("contentSerialId")));
		setLoginNo(bean.getStr(getPathByProperName("loginNo")));
		setLoginName(bean.getStr(getPathByProperName("loginName")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setElementId(bean.getStr(getPathByProperName("elementId")));
		setElementPar(bean.getStr(getPathByProperName("elementPar")));
		setSubContentId(bean.getStr(getPathByProperName("subContentId")));
		setTicketName(bean.getStr(getPathByProperName("ticketName")));
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setCustGroupId(bean.getStr(getPathByProperName("custGroupId")));
		setCustRelSerialId(bean.getStr(getPathByProperName("custRelSerialId")));
		setActClass(bean.getStr(getPathByProperName("actClass")));
		setGroupId(bean.getStr(getPathByProperName("groupId")));
	}
	
	public String getActClass() {
		return actClass;
	}

	public void setActClass(String actClass) {
		this.actClass = actClass;
	}
	public String getCustRelSerialId() {
		return custRelSerialId;
	}

	public void setCustRelSerialId(String custRelSerialId) {
		this.custRelSerialId = custRelSerialId;
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getSubContentId() {
		return subContentId;
	}
	public void setSubContentId(String subContentId) {
		this.subContentId = subContentId;
	}
	public String getContentSerialId() {
		return contentSerialId;
	}
	public void setContentSerialId(String contentSerialId) {
		this.contentSerialId = contentSerialId;
	}
	public String getProvinceGroup() {
		return provinceGroup;
	}
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getElementPar() {
		return elementPar;
	}
	public void setElementPar(String elementPar) {
		this.elementPar = elementPar;
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

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getCustGroupId() {
		return custGroupId;
	}
	public void setCustGroupId(String custGroupId) {
		this.custGroupId = custGroupId;
	}
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
