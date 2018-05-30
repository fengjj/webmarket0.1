package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-11
 * @author: dongyh
 * @Title: AtomQueryApproverInDTO
 * @Description： 打印入参参数
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryApproverInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="REGION_CODE",cons=ConsType.CT001,len="5",desc="地市编码",type="String",memo="略")
	private String regionCode;
	@ParamDesc(path="AUDIT_LEVEL",cons=ConsType.CT001,len="11",desc="审批级别",type="String",memo="略")
	private String auditLevel;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,len="20",desc="省份标识",type="String",memo="略")
	private String provinceGroup;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="20",desc="活动大类",type="String",memo="略")
	private String busiType;
	@ParamDesc(path="BUSI_CLASS",cons=ConsType.CT001,len="100",desc="活动小类",type="String",memo="略")
	private String busiClass;
	@ParamDesc(path="CLASS_VALUE",cons=ConsType.CT001,len="100",desc="审批级别",type="String",memo="略")
	private String classValue;
	

	public void decode(MBean bean){
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setAuditLevel(bean.getStr(getPathByProperName("auditLevel")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setBusiClass(bean.getStr(getPathByProperName("busiClass")));
		setClassValue(bean.getStr(getPathByProperName("classValue")));
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getAuditLevel() {
		return auditLevel;
	}

	public void setAuditLevel(String auditLevel) {
		this.auditLevel = auditLevel;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	
	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getBusiClass() {
		return busiClass;
	}

	public void setBusiClass(String busiClass) {
		this.busiClass = busiClass;
	}

	public String getClassValue() {
		return classValue;
	}

	public void setClassValue(String classValue) {
		this.classValue = classValue;
	}
}
