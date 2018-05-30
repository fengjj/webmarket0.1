package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.orderdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomSaveOrderInDTO
* @Description： 自动打印入参参数
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomSaveOrderInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="disFlag",cons=ConsType.CT001,type="string",len="2",desc="操作标识",memo="0-新增，完全权限；1审批中，所有不可增删；2执行中（规则修改）")
	private String disFlag;
	@ParamDesc(path="orderId",cons=ConsType.QUES,type="string",len="22",desc="工单ID",memo="略")
	private String orderId;
	@ParamDesc(path="costId",cons=ConsType.CT001,type="string",len="18",desc="成本ID",memo="略")
	private String costId;
	@ParamDesc(path="mk_isUnique",cons=ConsType.CT001,type="string",len="2",desc="是否使用唯一编码",memo="0:不使用,1:使用")
	private String mkIsUnique;
	@ParamDesc(path="operNo",cons=ConsType.CT001,type="string",len="20",desc="操作工号",memo="略")
	private String operNo;
	@ParamDesc(path="operName",cons=ConsType.CT001,type="string",len="64",desc="操作人",memo="略")
	private String operName;
	@ParamDesc(path="updateNo",cons=ConsType.CT001,type="string",len="20",desc="修改工号",memo="略")
	private String updateNo;
	@ParamDesc(path="updateName",cons=ConsType.CT001,type="string",len="64",desc="修改人",memo="略")
	private String updateName;
	@ParamDesc(path="regionCode",cons=ConsType.CT001,type="string",len="5",desc="区域编码",memo="略")
	private String regionCode;
	@ParamDesc(path="orderName",cons=ConsType.CT001,type="string",len="256",desc="工单名称",memo="略")
	private String orderName;
	@ParamDesc(path="orderNo",cons=ConsType.CT001,type="string",len="256",desc="工单编号",memo="略")
	private String orderNo;
	@ParamDesc(path="orderType",cons=ConsType.CT001,type="string",len="5",desc="工单类型",memo="略")
	private String orderType;
	@ParamDesc(path="orderDepartment",cons=ConsType.QUES,type="string",len="5",desc="工单提出部门",memo="略")
	private String orderDepartment;
	@ParamDesc(path="costName",cons=ConsType.QUES,type="string",len="100",desc="成本名称",memo="略")
	private String costName;
	@ParamDesc(path="orderDesc",cons=ConsType.QUES,type="string",len="1024",desc="工单描述",memo="略")
	private String orderDesc;
	@ParamDesc(path="costControlType",cons=ConsType.CT001,type="string",len="5",desc="成本类型",memo="略")
	private String costControlType;
	
	public void decode(MBean bean) {
		setDisFlag(bean.getStr(getPathByProperName("disFlag")));
		setOrderId(bean.getStr(getPathByProperName("orderId")));
		setCostId(bean.getStr(getPathByProperName("costId")));
		setMkIsUnique(bean.getStr(getPathByProperName("mkIsUnique")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setUpdateNo(bean.getStr(getPathByProperName("updateNo")));
		setUpdateName(bean.getStr(getPathByProperName("updateName")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setOrderName(bean.getStr(getPathByProperName("orderName")));
		setOrderNo(bean.getStr(getPathByProperName("orderNo")));
		setOrderType(bean.getStr(getPathByProperName("orderType")));
		setOrderDepartment(bean.getStr(getPathByProperName("orderDepartment")));
		setCostName(bean.getStr(getPathByProperName("costName")));
		setOrderDesc(bean.getStr(getPathByProperName("orderDesc")));
		setCostControlType(bean.getStr(getPathByProperName("costControlType")));
	}
	
	public String getDisFlag() {
		return disFlag;
	}
	
	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getCostId() {
		return costId;
	}
	
	public void setCostId(String costId) {
		this.costId = costId;
	}
	
	public String getMkIsUnique() {
		return mkIsUnique;
	}
	
	public void setMkIsUnique(String mkIsUnique) {
		this.mkIsUnique = mkIsUnique;
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
	
	public String getRegionCode() {
		return regionCode;
	}
	
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	public String getOrderName() {
		return orderName;
	}
	
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getOrderType() {
		return orderType;
	}
	
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	public String getOrderDepartment() {
		return orderDepartment;
	}
	
	public void setOrderDepartment(String orderDepartment) {
		this.orderDepartment = orderDepartment;
	}
	
	public String getCostName() {
		return costName;
	}
	
	public void setCostName(String costName) {
		this.costName = costName;
	}
	
	public String getOrderDesc() {
		return orderDesc;
	}
	
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	
	public String getCostControlType() {
		return costControlType;
	}
	
	public void setCostControlType(String costControlType) {
		this.costControlType = costControlType;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
