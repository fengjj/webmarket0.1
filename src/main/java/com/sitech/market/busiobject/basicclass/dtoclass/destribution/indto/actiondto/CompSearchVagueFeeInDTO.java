package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.actiondto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;

/**
 * Create on 2015-4-8 
 * @author: wangdw
 * @Title: CompSearchVagueFeeInDTO 
 * @Description： 自动打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CompSearchVagueFeeInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="OPR_INFO.LOGIN_NO",cons=ConsType.CT001,type="string",len="8",desc="登录工号",memo="略")
	private String loginNo;
	@ParamDesc(path="OPR_INFO.REGION_ID",cons=ConsType.CT001,type="string",len="8",desc="归属地市",memo="略")
	private String regionId;
	@ParamDesc(path="OPR_INFO.CONTACT_ID",cons=ConsType.CT001,type="string",len="8",desc="客户接触标识",memo="略")
	private String contactId;
	@ParamDesc(path="OPR_INFO.OP_CODE",cons=ConsType.CT001,type="string",len="8",desc="操作代码",memo="略")
	private String opCode;
	@ParamDesc(path="OPR_INFO.OP_NOTE",cons=ConsType.QUES,type="string",len="256",desc="操作备注",memo="略")
	private String opNote;
	@ParamDesc(path="BUSI_INFO.GROUP_ID",cons=ConsType.CT001,type="string",len="5",desc="组织节点",memo="略")
	private String groupId;
	@ParamDesc(path="BUSI_INFO.PROD_TYPE",cons=ConsType.CT001,type="string",len="16",desc="产品类型",memo="0标识主资费，1标识附加资费")
	private String prodType;
	@ParamDesc(path="BUSI_INFO.SP_FLAG",cons=ConsType.QUES,type="string",len="16",desc="SP资费标识",memo="1标识查询SP资费，传0或者不传表示非SP")
	private String psFlag;
	@ParamDesc(path="BUSI_INFO.PAGE_NUM",cons=ConsType.CT001,type="string",len="16",desc="查询页数，从0页开始",memo="略")
	private String pageNum;
	@ParamDesc(path="BUSI_INFO.PAGE_COUNT",cons=ConsType.CT001,type="string",len="16",desc="每页记录数",memo="略")
	private String pageCount;
	@ParamDesc(path="BUSI_INFO.SEARCH_STR",cons=ConsType.QUES,type="string",len="16",desc="按资费名称模糊搜索对应资费名称",memo="略")
	private String searchStr;
	@ParamDesc(path="BUSI_INFO.SEARCH_PRC",cons=ConsType.QUES,type="string",len="16",desc="按资费标识模糊搜索对应资费标识ID",memo="略")
	private String searchPrc;
	
	public void decode(MBean bean) {
		setLoginNo(bean.getStr(getPathByProperName("loginNo")));
		setRegionId(bean.getStr(getPathByProperName("regionId")));
		setContactId(bean.getStr(getPathByProperName("contactId")));
		setOpCode(bean.getStr(getPathByProperName("opCode")));
		setOpNote(bean.getStr(getPathByProperName("opNote")));
		setGroupId(bean.getStr(getPathByProperName("groupId")));
		setProdType(bean.getStr(getPathByProperName("prodType")));
		setPsFlag(bean.getStr(getPathByProperName("psFlag")));
		setPageNum(bean.getStr(getPathByProperName("pageNum")));
		setPageCount(bean.getStr(getPathByProperName("pageCount")));
		setSearchStr(bean.getStr(getPathByProperName("searchStr")));
		setSearchPrc(bean.getStr(getPathByProperName("searchPrc")));
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getOpNote() {
		return opNote;
	}

	public void setOpNote(String opNote) {
		this.opNote = opNote;
	}

	public String getPsFlag() {
		return psFlag;
	}

	public void setPsFlag(String psFlag) {
		this.psFlag = psFlag;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public String getSearchPrc() {
		return searchPrc;
	}

	public void setSearchPrc(String searchPrc) {
		this.searchPrc = searchPrc;
	}
	
}
