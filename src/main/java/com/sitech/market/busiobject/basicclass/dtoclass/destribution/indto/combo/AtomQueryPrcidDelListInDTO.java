package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.combo;

import java.util.List;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-8-1
 * 
 * @author:
 * @Title: AtomQueryPrcidDelListInDTO
 * @Description£º Ì×²ÍÉ¾³ýDTO
 * @version 1.0 update_data: update_author: update_note:
 */
public class AtomQueryPrcidDelListInDTO extends StandardInDTO {
	private static final long serialVersionUID = 1L;
	@ParamDesc(path = "REL_ID", cons = ConsType.STAR, len = "200", type = "String", desc = "¹ØÏµID", memo = "ÂÔ")
	private String relId;
	@ParamDesc(path = "OPER_NO", cons = ConsType.STAR, len = "100", type = "String", desc = "¹¤ºÅ", memo = "ÂÔ")
	private String operNo;
	@ParamDesc(path = "OPER_NAME", cons = ConsType.STAR, len = "100", type = "String", desc = "¹¤ºÅÐÕÃû", memo = "ÂÔ")
	private String operName;

	public void decode(MBean bean) {

		setRelId(bean.getBodyStr("relId"));
		setOperNo(bean.getBodyStr("operNo"));
		setOperName(bean.getBodyStr("operName"));

		System.out.println(bean.getBodyStr("relId"));
		System.out.println(bean.getBodyStr("operNo"));
		System.out.println(bean.getBodyStr("operName"));

	}


	public String getRelId() {
		return relId;
	}

	public void setRelId(String relId) {
		this.relId = relId;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
