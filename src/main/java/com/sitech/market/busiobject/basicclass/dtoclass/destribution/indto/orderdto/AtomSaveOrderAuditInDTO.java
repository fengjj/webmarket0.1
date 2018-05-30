package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.orderdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomSaveOrderAuditInDTO
* @Description： 自动打印入参参数
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomSaveOrderAuditInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="orderId",cons=ConsType.CT001,type="string",len="22",desc="工单ID",memo="略")
	private String orderId;
	@ParamDesc(path="operNo",cons=ConsType.CT001,type="string",len="20",desc="操作工号",memo="略")
	private String operNo;
	@ParamDesc(path="operName",cons=ConsType.CT001,type="string",len="64",desc="操作人",memo="略")
	private String operName;
	@ParamDesc(path="disFlag",cons=ConsType.CT001,type="string",len="2",desc="操作标识",memo="0-新增，完全权限；1审批中，所有不可增删；2执行中（规则修改）")
	private String disFlag;
	
	public void decode(MBean bean) {
		setOrderId(bean.getStr(getPathByProperName("orderId")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setDisFlag(bean.getStr(getPathByProperName("disFlag")));
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getDisFlag() {
		return disFlag;
	}

	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}

}
