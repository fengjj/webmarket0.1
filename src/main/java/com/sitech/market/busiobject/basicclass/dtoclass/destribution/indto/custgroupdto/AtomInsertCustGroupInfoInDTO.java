package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-8
 * @author: liuhaoa
 * @Title: AtomInsertCustGroupInfoInDTO 
 * @Description： 目标客户群生成
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomInsertCustGroupInfoInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CUST_GROUP_ID",cons=ConsType.CT001,len="100",desc="客户群ID",type="String",memo="略")
	private String custGroupId;
	@ParamDesc(path="CUST_GROUP_NAME",cons=ConsType.CT001,len="100",desc="客户群名称",type="String",memo="略")
	private String custGroupName;
	@ParamDesc(path="CUST_GROUP_DESC",cons=ConsType.CT001,len="100",desc="客户群描述",type="String",memo="略")
	private String custGroupDesc;
	@ParamDesc(path="CHOICE_CODE",cons=ConsType.CT001,len="100",desc="选择模式",type="String",memo="略")
	private String choiceCode;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,len="100",desc="操作员工号",type="String",memo="略")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,len="100",desc="操作员名称",type="String",memo="略")
	private String operName;
	@ParamDesc(path="CUST_TYPE",cons=ConsType.CT001,len="100",desc="客户类型",type="String",memo="略")
	private String custType;
	@ParamDesc(path="FILE_PATH",cons=ConsType.CT001,len="100",desc="客户群文件路径",type="String",memo="略")
	private String filePath;
	
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustGroupId() {
		return custGroupId;
	}
	public void setCustGroupId(String custGroupId) {
		this.custGroupId = custGroupId;
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
	public String getChoiceCode() {
		return choiceCode;
	}
	public void setChoiceCode(String choiceCode) {
		this.choiceCode = choiceCode;
	}
	public String getCustGroupName() {
		return custGroupName;
	}
	public void setCustGroupName(String custGroupName) {
		this.custGroupName = custGroupName;
	}
	public String getCustGroupDesc() {
		return custGroupDesc;
	}
	public void setCustGroupDesc(String custGroupDesc) {
		this.custGroupDesc = custGroupDesc;
	}
	
	@Override
	public void decode(MBean bean){
		setCustGroupId(bean.getStr(getPathByProperName("custGroupId")));
		setCustGroupName(bean.getStr(getPathByProperName("custGroupName")));
		setCustGroupDesc(bean.getStr(getPathByProperName("custGroupDesc")));
		setChoiceCode(bean.getStr(getPathByProperName("choiceCode")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setCustType(bean.getStr(getPathByProperName("custType")));
		setFilePath(bean.getStr(getPathByProperName("filePath")));
	}
	
}
