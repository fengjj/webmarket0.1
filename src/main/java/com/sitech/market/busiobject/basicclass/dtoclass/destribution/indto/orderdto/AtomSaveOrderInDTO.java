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
* @Description�� �Զ���ӡ��β���
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomSaveOrderInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="disFlag",cons=ConsType.CT001,type="string",len="2",desc="������ʶ",memo="0-��������ȫȨ�ޣ�1�����У����в�����ɾ��2ִ���У������޸ģ�")
	private String disFlag;
	@ParamDesc(path="orderId",cons=ConsType.QUES,type="string",len="22",desc="����ID",memo="��")
	private String orderId;
	@ParamDesc(path="costId",cons=ConsType.CT001,type="string",len="18",desc="�ɱ�ID",memo="��")
	private String costId;
	@ParamDesc(path="mk_isUnique",cons=ConsType.CT001,type="string",len="2",desc="�Ƿ�ʹ��Ψһ����",memo="0:��ʹ��,1:ʹ��")
	private String mkIsUnique;
	@ParamDesc(path="operNo",cons=ConsType.CT001,type="string",len="20",desc="��������",memo="��")
	private String operNo;
	@ParamDesc(path="operName",cons=ConsType.CT001,type="string",len="64",desc="������",memo="��")
	private String operName;
	@ParamDesc(path="updateNo",cons=ConsType.CT001,type="string",len="20",desc="�޸Ĺ���",memo="��")
	private String updateNo;
	@ParamDesc(path="updateName",cons=ConsType.CT001,type="string",len="64",desc="�޸���",memo="��")
	private String updateName;
	@ParamDesc(path="regionCode",cons=ConsType.CT001,type="string",len="5",desc="�������",memo="��")
	private String regionCode;
	@ParamDesc(path="orderName",cons=ConsType.CT001,type="string",len="256",desc="��������",memo="��")
	private String orderName;
	@ParamDesc(path="orderNo",cons=ConsType.CT001,type="string",len="256",desc="�������",memo="��")
	private String orderNo;
	@ParamDesc(path="orderType",cons=ConsType.CT001,type="string",len="5",desc="��������",memo="��")
	private String orderType;
	@ParamDesc(path="orderDepartment",cons=ConsType.QUES,type="string",len="5",desc="�����������",memo="��")
	private String orderDepartment;
	@ParamDesc(path="costName",cons=ConsType.QUES,type="string",len="100",desc="�ɱ�����",memo="��")
	private String costName;
	@ParamDesc(path="orderDesc",cons=ConsType.QUES,type="string",len="1024",desc="��������",memo="��")
	private String orderDesc;
	@ParamDesc(path="costControlType",cons=ConsType.CT001,type="string",len="5",desc="�ɱ�����",memo="��")
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
