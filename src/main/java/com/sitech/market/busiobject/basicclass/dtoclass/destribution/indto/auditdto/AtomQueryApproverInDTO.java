package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.auditdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-5-11
 * @author: dongyh
 * @Title: AtomQueryApproverInDTO
 * @Description�� ��ӡ��β���
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryApproverInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="REGION_CODE",cons=ConsType.CT001,len="5",desc="���б���",type="String",memo="��")
	private String regionCode;
	@ParamDesc(path="AUDIT_LEVEL",cons=ConsType.CT001,len="11",desc="��������",type="String",memo="��")
	private String auditLevel;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,len="20",desc="ʡ�ݱ�ʶ",type="String",memo="��")
	private String provinceGroup;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,len="20",desc="�����",type="String",memo="��")
	private String busiType;
	@ParamDesc(path="BUSI_CLASS",cons=ConsType.CT001,len="100",desc="�С��",type="String",memo="��")
	private String busiClass;
	@ParamDesc(path="CLASS_VALUE",cons=ConsType.CT001,len="100",desc="��������",type="String",memo="��")
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
