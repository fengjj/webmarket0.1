package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import java.util.List;
import java.util.Map;
import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

public class AtomSaveTerminalInDTO extends StandardInDTO {

	private static final long serialVersionUID = 1L;
	@ParamDesc(path="BUSI_ID",cons=ConsType.QUES,type="string",len="18",desc="ҵ�����",memo="��")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.QUES,type="string",len="18",desc="ҵ������",memo="��")
	private String busiType;
	@ParamDesc(path="REGION_CODE",cons=ConsType.QUES,type="string",len="18",desc="����",memo="��")
	private String regionCode;
	@ParamDesc(path="OPER_NO",cons=ConsType.QUES,type="string",len="18",desc="����",memo="��")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.QUES,type="string",len="18",desc="����",memo="��")
	private String operName;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="18",desc="ʡ�ݱ�ʶ",memo="��")
	private String provinceGroup;
	@ParamDesc(path="CONTENT_TYPE",cons=ConsType.QUES,type="string",len="18",desc="��������",memo="��")
	private String contentType;
	@ParamDesc(path="BRAND_CODE",cons=ConsType.QUES,type="string",len="18",desc="�ն�Ʒ�Ʊ���",memo="��")
	private String brandCode;
	@ParamDesc(path="BRAND_NAME",cons=ConsType.QUES,type="string",len="18",desc="�ն�Ʒ��",memo="��")
	private String brandName;
	@ParamDesc(path="RESOURCE_CODE",cons=ConsType.QUES,type="string",len="18",desc="�ն��ͺű���",memo="��")
	private String resourceCode;
	@ParamDesc(path="RESOURCE_NAME",cons=ConsType.QUES,type="string",len="18",desc="�ն��ͺ�",memo="��")
	private String resourceName;
	@ParamDesc(path="RESOURCE_TYPE",cons=ConsType.QUES,type="string",len="18",desc="�ն��ͺ�����",memo="��")
	private String resourceType;
	@ParamDesc(path="FEE_CODE",cons=ConsType.QUES,type="string",len="18",desc="���ô���",memo="��")
	private String feeCode;
	@ParamDesc(path="ACT_PRICE",cons=ConsType.QUES,type="string",len="18",desc="��Լ�۸�",memo="��")
	private String actPrice;
	@ParamDesc(path="RESOURCE_PRICE",cons=ConsType.QUES,type="string",len="18",desc="����۸�",memo="��")
	private String resourcePrice;
	@ParamDesc(path="DETAIL_LIST",cons=ConsType.QUES,len="100",type="compx",desc="datail�ֱ����",memo="��")
	private List<Map> detailList;
	@ParamDesc(path="CONTRACT_NAME",cons=ConsType.QUES,type="string",len="18",desc="��Լ����",memo="��")
	private String contractName;
	@ParamDesc(path="CONTRACT_MONTH",cons=ConsType.QUES,type="string",len="18",desc="��Լ��",memo="��")
	private String contractMonth;
	@ParamDesc(path="RET_PRE_MONEY",cons=ConsType.QUES,type="string",len="18",desc="ÿ�·���",memo="��")
	private String retPreMoney;
	@ParamDesc(path="RET_TOTAL_MONEY",cons=ConsType.QUES,type="string",len="18",desc="�����ܶ�",memo="��")
	private String retTotalMoney;
	@ParamDesc(path="LOW_FEE",cons=ConsType.QUES,type="string",len="18",desc="��������",memo="��")
	private String lowFee;
	@ParamDesc(path="ALLOWANCE_TYPE",cons=ConsType.QUES,type="string",len="18",desc="��������",memo="��")
	private String allowanceType;
	@ParamDesc(path="PRC_ID",cons=ConsType.QUES,type="string",len="18",desc="�ʷ�ID",memo="��")
	private String prcId;
	@ParamDesc(path="IMPOWER_FLAG",cons=ConsType.QUES,type="string",len="18",desc="�ն���Ȩ",memo="��")
	private String impowerFlag;
	
	public void decode(MBean bean) {
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setContentType(bean.getStr(getPathByProperName("contentType")));
		setBrandCode(bean.getStr(getPathByProperName("brandCode")));
		setBrandName(bean.getStr(getPathByProperName("brandName")));
		setResourceCode(bean.getStr(getPathByProperName("resourceCode")));
		setResourceName(bean.getStr(getPathByProperName("resourceName")));
		setResourceType(bean.getStr(getPathByProperName("resourceType")));
		setFeeCode(bean.getStr(getPathByProperName("feeCode")));
		setActPrice(bean.getStr(getPathByProperName("actPrice")));
		setResourcePrice(bean.getStr(getPathByProperName("resourcePrice")));
		setDetailList(bean.getList(getPathByProperName("detailList")));
		setContractName(bean.getStr(getPathByProperName("contractName")));
		setContractMonth(bean.getStr(getPathByProperName("contractMonth")));
		setRetPreMoney(bean.getStr(getPathByProperName("retPreMoney")));
		setRetTotalMoney(bean.getStr(getPathByProperName("retTotalMoney")));
		setLowFee(bean.getStr(getPathByProperName("lowFee")));
		setAllowanceType(bean.getStr(getPathByProperName("allowanceType")));
		setPrcId(bean.getStr(getPathByProperName("prcId")));
		setImpowerFlag(bean.getStr(getPathByProperName("impowerFlag")));
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

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
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

	public String getProvinceGroup() {
		return provinceGroup;
	}

	public void setProvinceGroup(String provinceGroup) {
		this.provinceGroup = provinceGroup;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getFeeCode() {
		return feeCode;
	}

	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	public String getActPrice() {
		return actPrice;
	}

	public void setActPrice(String actPrice) {
		this.actPrice = actPrice;
	}

	public String getResourcePrice() {
		return resourcePrice;
	}

	public void setResourcePrice(String resourcePrice) {
		this.resourcePrice = resourcePrice;
	}

	public List getDetailList() {
		return detailList;
	}

	public void setDetailList(List detailList) {
		this.detailList = detailList;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractMonth() {
		return contractMonth;
	}

	public void setContractMonth(String contractMonth) {
		this.contractMonth = contractMonth;
	}

	public String getRetPreMoney() {
		return retPreMoney;
	}

	public void setRetPreMoney(String retPreMoney) {
		this.retPreMoney = retPreMoney;
	}

	public String getRetTotalMoney() {
		return retTotalMoney;
	}

	public void setRetTotalMoney(String retTotalMoney) {
		this.retTotalMoney = retTotalMoney;
	}

	public String getLowFee() {
		return lowFee;
	}

	public void setLowFee(String lowFee) {
		this.lowFee = lowFee;
	}

	public String getAllowanceType() {
		return allowanceType;
	}

	public void setAllowanceType(String allowanceType) {
		this.allowanceType = allowanceType;
	}

	public String getPrcId() {
		return prcId;
	}

	public void setPrcId(String prcId) {
		this.prcId = prcId;
	}

	public String getImpowerFlag() {
		return impowerFlag;
	}

	public void setImpowerFlag(String impowerFlag) {
		this.impowerFlag = impowerFlag;
	}
}
