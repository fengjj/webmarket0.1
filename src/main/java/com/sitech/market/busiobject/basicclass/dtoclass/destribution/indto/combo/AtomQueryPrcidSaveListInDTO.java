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
 * @Title: AtomQueryPrcidSaveListInDTO
 * @Description： 套餐配置保存DTO
 * @version 1.0 update_data: update_author: update_note:
 */
public class AtomQueryPrcidSaveListInDTO extends StandardInDTO {
	private static final long serialVersionUID = 1L;
	@ParamDesc(path = "SERIAL_ID", cons = ConsType.CT001, len = "30", type = "String", desc = "序列号", memo = "略")
	private String serialId;
	@ParamDesc(path = "PROD_ID", cons = ConsType.STAR, len = "200", type = "String", desc = "产品ID", memo = "略")
	private String prodId;
	@ParamDesc(path = "PROD_NAME", cons = ConsType.STAR, len = "2000", type = "String", desc = "产品名称", memo = "略")
	private String prodName;
	@ParamDesc(path = "PRC_ID", cons = ConsType.STAR, len = "200", type = "String", desc = "资费ID", memo = "略")
	private String prcId;
	@ParamDesc(path = "PRC_NAME", cons = ConsType.STAR, len = "2000", type = "String", desc = "资费名称", memo = "略")
	private String prcName;
	@ParamDesc(path = "RES_TYPE", cons = ConsType.STAR, len = "200", type = "String", desc = "资费类型", memo = "略")
	private String resType;
	@ParamDesc(path = "REGION_CODE", cons = ConsType.STAR, len = "100", type = "String", desc = "地市编码", memo = "略")
	private String regionCode;
	@ParamDesc(path = "OPER_NO", cons = ConsType.STAR, len = "100", type = "String", desc = "工号", memo = "略")
	private String operNo;
	@ParamDesc(path = "OPER_NAME", cons = ConsType.STAR, len = "100", type = "String", desc = "工号姓名", memo = "略")
	private String operName;
	

	public void decode(MBean bean) {

		setSerialId(bean.getBodyStr("serialId"));
		setProdId(bean.getBodyStr("prodId"));
		setProdName(bean.getBodyStr("prodName"));
		setPrcId(bean.getBodyStr("prcId"));
		setPrcName(bean.getBodyStr("prcName"));
		setResType(bean.getBodyStr("resType"));
		setRegionCode(bean.getBodyStr("regionCode"));
		setOperNo(bean.getBodyStr("operNo"));
		setOperName(bean.getBodyStr("operName"));
		System.out.println(bean.getBodyStr("serialId"));
		System.out.println(bean.getBodyStr("prodId"));
		System.out.println(bean.getBodyStr("prodName"));
		System.out.println(bean.getBodyStr("prcId"));
		System.out.println(bean.getBodyStr("prcName"));
		System.out.println(bean.getBodyStr("resType"));
		System.out.println(bean.getBodyStr("regionCode"));
		System.out.println(bean.getBodyStr("operNo"));
		System.out.println(bean.getBodyStr("operName"));
		
	}


	public String getRegionCode() {
		return regionCode;
	}


	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
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


	public String getPrcId() {
		return prcId;
	}

	public void setPrcId(String prcId) {
		this.prcId = prcId;
	}

	public String getPrcName() {
		return prcName;
	}

	public void setPrcName(String prcName) {
		this.prcName = prcName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getResType() {
		return resType;
	}


	public void setResType(String resType) {
		this.resType = resType;
	}


	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdId() {
		return prodId;
	}



}
