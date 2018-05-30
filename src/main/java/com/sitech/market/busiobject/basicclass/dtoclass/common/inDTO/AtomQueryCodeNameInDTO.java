package com.sitech.market.busiobject.basicclass.dtoclass.common.inDTO;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;
/**
 * ��ѯ���codename��inDTO
 * Create on 2015-5-6 
 * @author: wangdw
 * @Title: AtomQueryCodeNameInDTO 
 * @Description�� 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomQueryCodeNameInDTO extends StandardInDTO {
	private static final long serialVersionUID = 1L;
	
	@ParamDesc(path="TABLE_EN_NAME",cons=ConsType.CT001,len="30",desc="����",type="String",memo="��")
	private String tableEnName;
	@ParamDesc(path="TABLE_CN_NAME",cons=ConsType.CT001,len="100",desc="����������",type="String",memo="��")
	private String tableCnName;
	@ParamDesc(path="FIELD_EN_NAME",cons=ConsType.CT001,len="50",desc="�ֶ���",type="String",memo="��")
	private String fieldEnName;
	@ParamDesc(path="FIELD_CN_NAME",cons=ConsType.CT001,len="100",desc="�ֶ���������",type="String",memo="��")
	private String fieldCnName;
	@ParamDesc(path="FIELD_VALUE",cons=ConsType.CT001,len="100",desc="�ֶ�ֵ",type="String",memo="��")
	private String fieldValue;
	@ParamDesc(path="FIELD_DESC",cons=ConsType.CT001,len="200",desc="�ֶ�ֵ˵��",type="String",memo="��")
	private String fieldDesc;
	@ParamDesc(path="FIELD_URL", cons=ConsType.CT001,len="200",desc="ͼƬURL",type="String",memo="��")
	private String fieldUrl;
	@ParamDesc(path="ASSI_TABLENNAME", cons=ConsType.CT001,len="30",desc="������������mk_codename_dict.table_en_name",type="String",memo="��")
	private String assiTableenname;
	@ParamDesc(path="ASSI_FIELDENNAME", cons=ConsType.CT001,len="50",desc="�������ֶ�����mk_codename_dict.field_cn_name",type="String",memo="��")
	private String assiFieldenname;
	@ParamDesc(path="ASSI_FIELDVALUE", cons=ConsType.CT001,len="100",desc="�������ֶ�ֵ������������С�࣬�����ûС��ʱ�����ֶ����û�����ֵ",type="String",memo="��")
	private String assiFieldvalue;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,len="20",desc="ʡ�ݱ�ʶ",type="String",memo="��")
	private String provinceGroup;
	@ParamDesc(path="OUT_FIELDENNAME",cons=ConsType.CT001,len="50",desc="��ϵͳ�ֶ���",type="String",memo="��")
	private String outFieldenname;
	@ParamDesc(path="OUT_FIELDCNNAME",cons=ConsType.CT001,len="100",desc="��ϵͳ�ֶ���������",type="String",memo="��")
	private String outFieldcnname;
	@ParamDesc(path="OUT_SYSTEM_TYPE",cons=ConsType.CT001,len="5",desc="��ϵͳ����,MK_OUTSYSTEMTYPE_DICT����OUT_FIELDENNAME OUT_FIELDCNNAME����ʹ��",type="String",memo="��")
	private String outSystemType;
	
	@Override
	public void decode(MBean arg0){
		setTableEnName(arg0.getStr(getPathByProperName("tableEnName")));
		setTableCnName(arg0.getStr(getPathByProperName("tableCnName")));
		setFieldEnName(arg0.getStr(getPathByProperName("fieldEnName")));
		setFieldCnName(arg0.getStr(getPathByProperName("fieldCnName")));
		setFieldValue(arg0.getStr(getPathByProperName("fieldValue")));
		setFieldDesc(arg0.getStr(getPathByProperName("fieldDesc")));
		setFieldUrl(arg0.getStr(getPathByProperName("fieldUrl")));
		setAssiTableenname(arg0.getStr(getPathByProperName("assiTableenname")));
		setAssiFieldenname(arg0.getStr(getPathByProperName("assiFieldenname")));
		setAssiFieldvalue(arg0.getStr(getPathByProperName("assiFieldvalue")));
		setProvinceGroup(arg0.getStr(getPathByProperName("provinceGroup")));
		setOutFieldenname(arg0.getStr(getPathByProperName("outFieldenname")));
		setOutFieldcnname(arg0.getStr(getPathByProperName("outFieldcnname")));
		setOutSystemType(arg0.getStr(getPathByProperName("outSystemType")));
	}

	public String getTableEnName() {
		return tableEnName;
	}

	public void setTableEnName(String tableEnName) {
		this.tableEnName = tableEnName;
	}

	public String getTableCnName() {
		return tableCnName;
	}

	public void setTableCnName(String tableCnName) {
		this.tableCnName = tableCnName;
	}

	public String getFieldEnName() {
		return fieldEnName;
	}

	public void setFieldEnName(String fieldEnName) {
		this.fieldEnName = fieldEnName;
	}

	public String getFieldCnName() {
		return fieldCnName;
	}

	public void setFieldCnName(String fieldCnName) {
		this.fieldCnName = fieldCnName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getFieldDesc() {
		return fieldDesc;
	}

	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}

	public String getFieldUrl() {
		return fieldUrl;
	}

	public void setFieldUrl(String fieldUrl) {
		this.fieldUrl = fieldUrl;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	public String getAssiTableenname() {
		return assiTableenname;
	}

	public void setAssiTableenname(String assiTableenname) {
		this.assiTableenname = assiTableenname;
	}

	public String getAssiFieldenname() {
		return assiFieldenname;
	}

	public void setAssiFieldenname(String assiFieldenname) {
		this.assiFieldenname = assiFieldenname;
	}

	public String getAssiFieldvalue() {
		return assiFieldvalue;
	}

	public void setAssiFieldvalue(String assiFieldvalue) {
		this.assiFieldvalue = assiFieldvalue;
	}

	public String getOutFieldenname() {
		return outFieldenname;
	}

	public void setOutFieldenname(String outFieldenname) {
		this.outFieldenname = outFieldenname;
	}

	public String getOutFieldcnname() {
		return outFieldcnname;
	}

	public void setOutFieldcnname(String outFieldcnname) {
		this.outFieldcnname = outFieldcnname;
	}

	public String getOutSystemType() {
		return outSystemType;
	}

	public void setOutSystemType(String outSystemType) {
		this.outSystemType = outSystemType;
	}
	
	
}
