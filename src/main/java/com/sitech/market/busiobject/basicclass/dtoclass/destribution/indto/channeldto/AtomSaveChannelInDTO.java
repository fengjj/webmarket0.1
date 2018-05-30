package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.channeldto;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.market.busiobject.basicclass.dataclass.Element;

public class AtomSaveChannelInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="busiId",cons=ConsType.CT001,len="20",type="String",desc="ҵ��id",memo="")
	private String busiId;
	
	@ParamDesc(path="busiType",cons=ConsType.CT001,len="20",type="String",desc="ҵ��id",memo="")
	private String busiType;
	
	@ParamDesc(path="regions",cons=ConsType.CT001,len="1",type="compx",desc="��������",memo="")
	private String regions;
	
	@ParamDesc(path="operNo",cons=ConsType.CT001,type="String",len="20",desc="����Ա����",memo="")
	private String operNo;
	
	@ParamDesc(path="operName",cons=ConsType.CT001,type="String",len="20",desc="����Ա����",memo="")
	private String operName;
	
	@ParamDesc(path="regionCode",cons=ConsType.CT001,type="String",len="20",desc="���б���",memo="")
	private String regionCode;
	
	@ParamDesc(path="provinceGroup",cons=ConsType.CT001,type="String",len="20",desc="ʡ�ݱ���",memo="")
	private String provinceGroup;
	
	@ParamDesc(path="busiChnJson",cons=ConsType.QUES,type="String",len="20",desc="ҵ������",memo="")
	private String busiChnJson;
	
	@ParamDesc(path="custConfigJson",cons=ConsType.QUES,type="String",len="20",desc="�ͻ�������",memo="")
	private String custConfigJson;
	
	@ParamDesc(path="opConfigJson",cons=ConsType.QUES,type="String",len="20",desc="��Ӫλ����",memo="")
	private String opConfigJson;

	@Override
	public void decode(MBean arg0) {
		setBusiId(arg0.getStr(getPathByProperName("busiId")));
		setBusiType(arg0.getStr(getPathByProperName("busiType")));
		setRegions(arg0.getStr(getPathByProperName("regions")));
		setOperNo(arg0.getStr(getPathByProperName("operNo")));
		setOperName(arg0.getStr(getPathByProperName("operName")));
		setRegionCode(arg0.getStr(getPathByProperName("regionCode")));
		setProvinceGroup(arg0.getStr(getPathByProperName("provinceGroup")));
		setBusiChnJson(arg0.getStr(getPathByProperName("busiChnJson")));
		setCustConfigJson(arg0.getStr(getPathByProperName("custConfigJson")));
		setOpConfigJson(arg0.getStr(getPathByProperName("opConfigJson")));
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
	public String getRegions() {
		return regions;
	}
	public void setRegions(String regions) {
		this.regions = regions;
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
	public String getProvinceGroup() {
		return provinceGroup;
	}
	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}
	public String getBusiChnJson() {
		return busiChnJson;
	}
	public void setBusiChnJson(String busiChnJson) {
		this.busiChnJson = busiChnJson;
	}
	public void setCustConfigJson(String custConfigJson) {
		this.custConfigJson = custConfigJson;
	}
	public String getCustConfigJson() {
		return custConfigJson;
	}
	public void setOpConfigJson(String opConfigJson) {
		this.opConfigJson = opConfigJson;
	}
	public String getOpConfigJson() {
		return opConfigJson;
	}
	
}
