package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.orderdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * 
* Create on 2015-4-2
* @author: dongyh
* @Title: AtomDeleteOrderInDTO
* @Description： 自动打印入参参数
* @version 1.0 
* update_data:      update_author:      update_note:
 */
public class AtomDeleteOrderInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="orderId",cons=ConsType.CT001,type="string",len="22",desc="工单ID",memo="略")
	private String orderId;
	@ParamDesc(path="operNo",cons=ConsType.CT001,type="string",len="20",desc="操作工号",memo="略")
	private String operNo;
	@ParamDesc(path="operName",cons=ConsType.CT001,type="string",len="64",desc="操作人",memo="略")
	private String operName;
	
	public void decode(MBean bean) {
		setOrderId(bean.getStr(getPathByProperName("orderId")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
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
}
