package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.combo;

import java.util.List;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-7-24
 * 
 * @author:
 * @Title: AtomQueryPrcidListInDTO
 * @Description： 套餐信息配置DTO
 * @version 1.0 update_data: update_author: update_note:
 */
public class AtomQueryPrcidListInDTO extends StandardInDTO {
	private static final long serialVersionUID = 1L;
	@ParamDesc(path = "SERIAL_ID", cons = ConsType.CT001, len = "30", type = "String", desc = "序列号", memo = "略")
	private String serialId;
	@ParamDesc(path = "PROD_ID", cons = ConsType.CT001, len = "30", type = "String", desc = "资费类型", memo = "略")
	private String prodId;
	@ParamDesc(path = "PRC_ID", cons = ConsType.CT001, len = "20", type = "String", desc = "资费ID", memo = "略")
	private String prcId;
	@ParamDesc(path = "PRC_NAME", cons = ConsType.CT001, len = "100", type = "String", desc = "资费名称", memo = "略")
	private String prcName;
	@ParamDesc(path = "RES_TYPE", cons = ConsType.STAR, len = "100", type = "List", desc = "资费类型", memo = "略")
	private List resType;
	@ParamDesc(path = "REGION_CODE", cons = ConsType.STAR, len = "100", type = "String", desc = "地市编码", memo = "略")
	private String regionCode;
	@ParamDesc(path = "BEGIN_NUM", cons = ConsType.CT001, len = "100", type = "String", desc = "开始数量", memo = "略")
	private String beginNum;
	@ParamDesc(path = "END_NUM", cons = ConsType.CT001, len = "100", type = "String", desc = "资费名称", memo = "略")
	private String endNum;
	@ParamDesc(path = "PAGE_SIZE", cons = ConsType.CT001, len = "20", type = "String", desc = "页面展示数量", memo = "略")
	private String pageSize;
	@ParamDesc(path = "CURRENT_PAGE_NUM", cons = ConsType.CT001, len = "20", type = "String", desc = "当前页码", memo = "略")
	private String currentPageNum;

	public void decode(MBean bean) {

		setSerialId(bean.getBodyStr("serialId"));
		setProdId(bean.getBodyStr("prodId"));
		setPrcId(bean.getBodyStr("prcId"));
		setPrcName(bean.getBodyStr("prcName"));
		setResType(bean.getBodyList("resType"));
		setRegionCode(bean.getBodyStr("regionCode"));
		setBeginNum(bean.getBodyStr("beginNum"));
		setEndNum(bean.getBodyStr("endNum"));
		setPageSize(bean.getBodyStr("pageSize"));
		setCurrentPageNum(bean.getBodyStr("currentPageNum"));
		System.out.println(bean.getBodyStr("serialId"));
		System.out.println(bean.getBodyStr("prodId"));
		System.out.println(bean.getBodyStr("prcId"));
		System.out.println(bean.getBodyStr("prcName"));
		System.out.println(bean.getBodyList("resType"));
		System.out.println(bean.getBodyStr("regionCode"));
		System.out.println(bean.getBodyStr("beginNum"));
		System.out.println(bean.getBodyStr("endNum"));
		System.out.println(bean.getBodyStr("pageSize"));
		System.out.println(bean.getBodyStr("currentPageNum"));
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(String beginNum) {
		this.beginNum = beginNum;
	}

	public String getEndNum() {
		return endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
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

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(String currentPageNum) {
		this.currentPageNum = currentPageNum;
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

	public List getResType() {
		return resType;
	}

	public void setResType(List resType) {
		this.resType = resType;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdId() {
		return prodId;
	}



}
