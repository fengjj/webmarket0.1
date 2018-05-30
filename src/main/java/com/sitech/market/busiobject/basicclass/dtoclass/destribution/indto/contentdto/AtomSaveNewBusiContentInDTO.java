package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-8-5 
 * @author: nidw
 * @Title: AtomSaveNewBusiContentInDTO 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveNewBusiContentInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,type="string",len="18",desc="业务编码",memo="略")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,type="string",len="5",desc="业务类型",memo="略")
	private String busiType;
	@ParamDesc(path="CONTENT_SERIAL_ID",cons=ConsType.CT001,type="string",len="18",desc="内容流水号",memo="略")
	private String contentSerialId;
	@ParamDesc(path="PHONE_TYPE",cons=ConsType.QUES,type="string",len="18",desc="号码类型",memo="略")
	private String phoneType;
	@ParamDesc(path="CONTENT_DETAIL",cons=ConsType.CT001,type="string",len="",desc="内容详情串",memo="略")
	private String contentDetail;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,type="string",len="18",desc="工号",memo="略")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,type="string",len="18",desc="工号名称",memo="略")
	private String operName;
	@ParamDesc(path="REGION_CODE",cons=ConsType.CT001,type="string",len="18",desc="区域编码",memo="略")
	private String regionCode;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,type="string",len="18",desc="省份编码",memo="略")
	private String provinceGroup;
	@ParamDesc(path="OPER_FLAG",cons=ConsType.CT001,type="string",len="5",desc="操作标示",memo="略")
	private String operFlag;
	
	public void decode(MBean bean) {
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setContentSerialId(bean.getStr(getPathByProperName("contentSerialId")));
		setPhoneType(bean.getStr(getPathByProperName("phoneType")));
		setContentDetail(bean.getStr(getPathByProperName("contentDetail")));
		setOperFlag(bean.getStr(getPathByProperName("operFlag")));
		
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getContentSerialId() {
		return contentSerialId;
	}

	public void setContentSerialId(String contentSerialId) {
		this.contentSerialId = contentSerialId;
	}
	
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getContentDetail() {
		return contentDetail;
	}

	public void setContentDetail(String contentDetail) {
		this.contentDetail = contentDetail;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
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

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

}
