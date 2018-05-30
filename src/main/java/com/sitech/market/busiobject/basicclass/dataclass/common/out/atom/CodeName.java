package com.sitech.market.busiobject.basicclass.dataclass.common.out.atom;

import java.util.HashMap;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.market.busiobject.basicclass.dtoclass.Decodeable;
import com.sitech.market.busiobject.basicclass.dtoclass.Encodeable;
/**
 * mk_codename_dict对象
 * Create on 2015-5-6 
 * @author: wangdw
 * @Title: CodeName 
 * @Description： 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class CodeName implements Encodeable, Decodeable{

	@ParamDesc(path="TABLE_EN_NAME",cons=ConsType.CT001,len="30",desc="表名",type="String",memo="略")
	private String tableEnName;
	@ParamDesc(path="TABLE_CN_NAME",cons=ConsType.CT001,len="100",desc="表中文名称",type="String",memo="略")
	private String tableCnName;
	@ParamDesc(path="FIELD_EN_NAME",cons=ConsType.CT001,len="50",desc="字段名",type="String",memo="略")
	private String fieldEnName;
	@ParamDesc(path="FIELD_CN_NAME",cons=ConsType.CT001,len="100",desc="字段中文名称",type="String",memo="略")
	private String fieldCnName;
	@ParamDesc(path="FIELD_VALUE",cons=ConsType.CT001,len="100",desc="字段值",type="String",memo="略")
	private String fieldValue;
	@ParamDesc(path="FIELD_DESC",cons=ConsType.CT001,len="200",desc="字段值说明",type="String",memo="略")
	private String fieldDesc;
	@ParamDesc(path="FIELD_URL", cons=ConsType.CT001,len="200",desc="图片URL",type="String",memo="略")
	private String fieldUrl;
	@ParamDesc(path="ASSI_TABLENNAME", cons=ConsType.CT001,len="30",desc="主联动表名，mk_codename_dict.table_en_name",type="String",memo="略")
	private String assiTableenname;
	@ParamDesc(path="ASSI_FIELDENNAME", cons=ConsType.CT001,len="50",desc="主联动字段名，mk_codename_dict.field_cn_name",type="String",memo="略")
	private String assiFieldenname;
	@ParamDesc(path="ASSI_FIELD_VALUE", cons=ConsType.CT001,len="100",desc="主联动字段值，如活动大类联动小类，在配置活动小类时，此字段配置活动大类的值",type="String",memo="略")
	private String assiFieldValue;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,len="20",desc="省份标识",type="String",memo="略")
	private String provinceGroup;
	@ParamDesc(path="OUT_FIELDENNAME",cons=ConsType.CT001,len="50",desc="外系统字段名",type="String",memo="略")
	private String outFieldenname;
	@ParamDesc(path="OUT_FIELDCNNAME",cons=ConsType.CT001,len="100",desc="外系统字段中文名称",type="String",memo="略")
	private String outFieldcnname;
	@ParamDesc(path="OUT_SYSTEM_TYPE",cons=ConsType.CT001,len="5",desc="外系统类型,MK_OUTSYSTEMTYPE_DICT，与OUT_FIELDENNAME OUT_FIELDCNNAME搭配使用",type="String",memo="略")
	private String outSystemType;
	
	
	@Override
	public void decode(Map in) {
		this.tableEnName = (String)in.get("tableEnName");
		this.tableCnName = (String)in.get("tableCnName");
		this.fieldEnName = (String)in.get("fieldEnName");
		this.fieldCnName = (String)in.get("fieldCnName");
		this.fieldValue = (String)in.get("fieldValue");
		this.fieldDesc = (String)in.get("fieldDesc");
		this.fieldUrl = (String)in.get("fieldUrl");
		this.assiTableenname = (String)in.get("assiTableenname");
		this.assiFieldenname = (String)in.get("assiFieldenname");
		this.assiFieldValue = (String)in.get("assiFieldValue");
		this.provinceGroup = (String)in.get("provinceGroup");
		this.outFieldenname = (String)in.get("outFieldenname");
		this.outFieldcnname = (String)in.get("outFieldcnname");
		this.outSystemType = (String)in.get("outSystemType");
		
	}

	@Override
	public Map<String, Object> encode() {
		Map<String, Object> codeDict =new HashMap<String, Object>();
		codeDict.put("TABLE_EN_NAME",getTableEnName());
		codeDict.put("TABLE_CN_NAME",getTableCnName());
		codeDict.put("FIELD_EN_NAME",getFieldEnName());
		codeDict.put("FIELD_CN_NAME",getFieldCnName());
		codeDict.put("FIELD_VALUE", getFieldValue());
		codeDict.put("FIELD_DESC",  getFieldDesc());
		codeDict.put("FIELD_URL",   getFieldUrl());
		codeDict.put("ASSI_TABLENNAME",   getAssiTableenname());
		codeDict.put("ASSI_FIELDENNAME",   getAssiFieldenname());
		codeDict.put("ASSI_FIELD_VALUE",   getAssiFieldValue());
		codeDict.put("PROVINCE_GROUP",getProvinceGroup());
		codeDict.put("OUT_FIELDENNAME", getOutFieldenname());
		codeDict.put("OUT_FIELDCNNAME", getOutFieldcnname());
		codeDict.put("OUT_SYSTEM_TYPE", getOutSystemType());
		return codeDict;
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

	public String getAssiFieldValue() {
		return assiFieldValue;
	}

	public void setAssiFieldValue(String assiFieldValue) {
		this.assiFieldValue = assiFieldValue;
	}

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
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
