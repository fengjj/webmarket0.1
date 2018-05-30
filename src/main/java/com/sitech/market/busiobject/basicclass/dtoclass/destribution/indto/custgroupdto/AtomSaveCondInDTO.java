package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.custgroupdto;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.jcfx.dt.in.InDTO;
import com.sitech.market.busiobject.basicclass.dataclass.Element;

public class AtomSaveCondInDTO extends InDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="custGroupId",cons=ConsType.CT001,len="20",type="String",desc="活动id",memo="")
	private String custGroupId;
	
	@ParamDesc(path="custGroupName",cons=ConsType.CT001,len="2",type="String",desc="客户群关系表主键",memo="")
	private String custGroupName;
	
	@ParamDesc(path="custGroupDesc",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String custGroupDesc;
	
	@ParamDesc(path="operNo",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String operNo;
	
	@ParamDesc(path="operName",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String operName;
	
	@ParamDesc(path="operTime",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String operTime;
	
	@ParamDesc(path="regionCode",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String regionCode;
	
	@ParamDesc(path="actType",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String actType;
	
	@ParamDesc(path="serialId",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String serialId;
	
	@ParamDesc(path="actId",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String actId;
	
	@ParamDesc(path="busiType",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String busiType;
	
	@ParamDesc(path="choiceCode",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String choiceCode;
	
	@ParamDesc(path="recommendType",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String recommendType;
	
	@ParamDesc(path="meansId",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String meansId;
	
	@ParamDesc(path="meansName",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String meansName;
	
	@ParamDesc(path="outMeansId",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String outMeansId;
	
	@ParamDesc(path="uniqueActId",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String uniqueActId;
	
	
	@ParamDesc(path="backCode",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String backCode;
	
	@ParamDesc(path="actClass",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String actClass;
	
	@ParamDesc(path="endDate",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String endDate;
	
	@ParamDesc(path="startDate",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String startDate;
	
	@ParamDesc(path="statusCode",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String statusCode;
	
	@ParamDesc(path="preMaxnum",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String preMaxnum;
	
	//由于页面传入的chnList暂时为null，故暂时注释
	//@ParamDesc(path="chnList",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	//private List chnList;
	
	@ParamDesc(path="meansClass",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String meansClass;
	
	@ParamDesc(path="mkIsUnique",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String mkIsUnique;
	
	@ParamDesc(path="disFlag",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String disFlag;
	
	@ParamDesc(path="elementId",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String elementId;
	
	@ParamDesc(path="valueList",cons=ConsType.STAR,type="compx",len="1",desc="省份编码",memo="")
	private ArrayList<Element> valueList;
	
	@ParamDesc(path="provinceCode",cons=ConsType.CT001,type="String",len="20",desc="省份编码",memo="")
	private String provinceCode;
	
	
	

	@Override
	public void decode(MBean arg0) {
		System.out.println(arg0);
		System.out.println(getPathByProperName("actId"));
		System.out.println(arg0.getStr(getPathByProperName("actId")));
		setCustGroupId(arg0.getStr(getPathByProperName("custGroupId")));
		setCustGroupName(arg0.getStr(getPathByProperName("custGroupName")));
		setCustGroupDesc(arg0.getStr(getPathByProperName("custGroupDesc")));
		setOperNo(arg0.getStr(getPathByProperName("operNo")));
		setOperName(arg0.getStr(getPathByProperName("operName")));
		setOperTime(arg0.getStr(getPathByProperName("operTime")));
		setRegionCode(arg0.getStr(getPathByProperName("regionCode")));
		setActType(arg0.getStr(getPathByProperName("actType")));
		setSerialId(arg0.getStr(getPathByProperName("serialId")));
		setActId(arg0.getStr(getPathByProperName("actId")));
		setBusiType(arg0.getStr(getPathByProperName("busiType")));
		setChoiceCode(arg0.getStr(getPathByProperName("choiceCode")));
		setRecommendType(arg0.getStr(getPathByProperName("recommendType")));
		setMeansId(arg0.getStr(getPathByProperName("meansId")));
		setMeansName(arg0.getStr(getPathByProperName("meansName")));
		setOutMeansId(arg0.getStr(getPathByProperName("outMeansId")));
		setUniqueActId(arg0.getStr(getPathByProperName("uniqueActId")));
		setBackCode(arg0.getStr(getPathByProperName("backCode")));
		setActClass(arg0.getStr(getPathByProperName("actClass")));
		setEndDate(arg0.getStr(getPathByProperName("endDate")));
		setStartDate(arg0.getStr(getPathByProperName("startDate")));
		setStatusCode(arg0.getStr(getPathByProperName("statusCode")));
		setPreMaxnum(arg0.getStr(getPathByProperName("preMaxnum")));
		//setChnList(arg0.getList(getPathByProperName("chnList")));
		setMeansClass(arg0.getStr(getPathByProperName("meansClass")));
		setMkIsUnique(arg0.getStr(getPathByProperName("mkIsUnique")));
		setDisFlag(arg0.getStr(getPathByProperName("disFlag")));
		setElementId(arg0.getStr(getPathByProperName("elementId")));
		//setValueList((ArrayList<Element>)arg0.getList(getPathByProperName("valueList"), Map.class));
		setProvinceCode(arg0.getStr(getPathByProperName("provinceCode")));
		
		List<Map> elementList = arg0.getList(getPathByProperName("valueList"), Map.class);
		valueList = new ArrayList<Element>();
	    if(elementList!=null){
			for(Map<String, Object> elementIn : elementList){
				Element ele = new Element();
	        	ele.decode(elementIn);
	        	valueList.add(ele);
	        }
	    }
	}




	public String getCustGroupId() {
		return custGroupId;
	}




	public void setCustGroupId(String custGroupId) {
		this.custGroupId = custGroupId;
	}




	public String getCustGroupName() {
		return custGroupName;
	}




	public void setCustGroupName(String custGroupName) {
		this.custGroupName = custGroupName;
	}




	public String getCustGroupDesc() {
		return custGroupDesc;
	}




	public void setCustGroupDesc(String custGroupDesc) {
		this.custGroupDesc = custGroupDesc;
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




	public String getOperTime() {
		return operTime;
	}




	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}




	public String getRegionCode() {
		return regionCode;
	}




	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}




	public String getActType() {
		return actType;
	}




	public void setActType(String actType) {
		this.actType = actType;
	}




	public String getSerialId() {
		return serialId;
	}




	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}




	public String getActId() {
		return actId;
	}




	public void setActId(String actId) {
		this.actId = actId;
	}




	public String getBusiType() {
		return busiType;
	}




	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}




	public String getChoiceCode() {
		return choiceCode;
	}




	public void setChoiceCode(String choiceCode) {
		this.choiceCode = choiceCode;
	}




	public String getRecommendType() {
		return recommendType;
	}




	public void setRecommendType(String recommendType) {
		this.recommendType = recommendType;
	}




	public String getMeansId() {
		return meansId;
	}




	public void setMeansId(String meansId) {
		this.meansId = meansId;
	}




	public String getMeansName() {
		return meansName;
	}




	public void setMeansName(String meansName) {
		this.meansName = meansName;
	}




	public String getOutMeansId() {
		return outMeansId;
	}




	public void setOutMeansId(String outMeansId) {
		this.outMeansId = outMeansId;
	}




	public String getUniqueActId() {
		return uniqueActId;
	}




	public void setUniqueActId(String uniqueActId) {
		this.uniqueActId = uniqueActId;
	}




	public String getBackCode() {
		return backCode;
	}




	public void setBackCode(String backCode) {
		this.backCode = backCode;
	}




	public String getActClass() {
		return actClass;
	}




	public void setActClass(String actClass) {
		this.actClass = actClass;
	}




	public String getEndDate() {
		return endDate;
	}




	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}




	public String getStartDate() {
		return startDate;
	}




	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}




	public String getStatusCode() {
		return statusCode;
	}




	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}




	public String getPreMaxnum() {
		return preMaxnum;
	}




	public void setPreMaxnum(String preMaxnum) {
		this.preMaxnum = preMaxnum;
	}




	public String getMeansClass() {
		return meansClass;
	}




	public void setMeansClass(String meansClass) {
		this.meansClass = meansClass;
	}



	public String getMkIsUnique() {
		return mkIsUnique;
	}




	public void setMkIsUnique(String mkIsUnique) {
		this.mkIsUnique = mkIsUnique;
	}




	public String getDisFlag() {
		return disFlag;
	}




	public void setDisFlag(String disFlag) {
		this.disFlag = disFlag;
	}




	public String getElementId() {
		return elementId;
	}




	public void setElementId(String elementId) {
		this.elementId = elementId;
	}


	public ArrayList<Element> getValueList() {
		return valueList;
	}




	public void setValueList(ArrayList<Element> valueList) {
		this.valueList = valueList;
	}




	public String getProvinceCode() {
		return provinceCode;
	}




	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	
	
	

}
