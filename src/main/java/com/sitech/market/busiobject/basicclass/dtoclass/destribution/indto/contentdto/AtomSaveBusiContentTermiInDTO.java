package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * Create on 2015-6-12 
 * @author: jiaxla
 * @Title: AtomSaveBusiContentTermiInDTO 
 * @Description�� 
 * @version 1.0 
 * update_data:      update_author:      update_note:
 */
public class AtomSaveBusiContentTermiInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="OPER_NO",cons=ConsType.CT001,type="string",len="18",desc="�����˹���",memo="��")
	private String operNo;
	@ParamDesc(path="OPER_NAME",cons=ConsType.CT001,type="string",len="18",desc="����������",memo="��")
	private String operName;
	@ParamDesc(path="REGION_CODE",cons=ConsType.CT001,type="string",len="18",desc="ҵ��������",memo="��")
	private String regionCode;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.CT001,type="string",len="18",desc="ʡ�ݴ���",memo="��")
	private String provinceGroup;
	@ParamDesc(path="BUSI_ID",cons=ConsType.CT001,type="string",len="18",desc="ҵ�����",memo="��")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,type="string",len="5",desc="ҵ������",memo="��")
	private String busiType;
	@ParamDesc(path="CONTENT_IDS",cons=ConsType.CT001,type="string",len="100000",desc="�ն����ݺţ��ն�����ID@��Լ��#�ն�����ID@��Լ��",memo="��")
	private String contentIds;
	@ParamDesc(path="CONTRACT_STR",cons=ConsType.CT001,type="string",len="100000",desc="��Լ��ˮ�Ŵ�",memo="��")
	private String contractStr;
	@ParamDesc(path="PHONE_TYPE",cons=ConsType.QUES,type="string",len="18",desc="��������",memo="��")
	private String phoneType;
	@ParamDesc(path="IMPOWER_FLAG",cons=ConsType.CT001,type="string",len="10",desc="��Ȩ��ʶ",memo="��")
	private String impowerFlag;
	
	public void decode(MBean bean) {
		setOperNo(bean.getStr(getPathByProperName("operNo")));
		setOperName(bean.getStr(getPathByProperName("operName")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
		setContentIds(bean.getStr(getPathByProperName("contentIds")));
		setContractStr(bean.getStr(getPathByProperName("contractStr")));
		setPhoneType(bean.getStr(getPathByProperName("phoneType")));
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

	public String getContractStr() {
		return contractStr;
	}

	public void setContractStr(String contractStr) {
		this.contractStr = contractStr;
	}	
	
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getContentIds() {
		return contentIds;
	}

	public void setContentIds(String contentIds) {
		this.contentIds = contentIds;
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

	public Object getContentSerialId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getImpowerFlag() {
		return impowerFlag;
	}

	public void setImpowerFlag(String impowerFlag) {
		this.impowerFlag = impowerFlag;
	}

	
}
