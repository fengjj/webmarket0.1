package com.sitech.market.busiobject.basicclass.dtoclass.destribution.indto.contentdto;

import com.sitech.jcfx.anno.ConsType;
import com.sitech.jcfx.anno.ParamDesc;
import com.sitech.jcfx.dt.MBean;
import com.sitech.market.busiobject.basicclass.dtoclass.StandardInDTO;

/**
 * ��ѯ����ģ�����
 * @Create on 2015-6-23 
 * @author: wangdw
 * @Title: AtomQueryContentTemplateListInDTO 
 * @Description�� 
 * @version 1.0 
 * update_date:      update_author:      update_note:
 */
public class AtomQueryContentTemplateListInDTO extends StandardInDTO {
	
	private static final long serialVersionUID = 1L;
	@ParamDesc(path="CONTENT_TYPE",cons=ConsType.QUES,type="string",len="3",desc="������ϸ����",memo="��")
	private String contentType;
	@ParamDesc(path="REGION_CODE",cons=ConsType.QUES,type="string",len="4",desc="���б���",memo="��")
	private String regionCode;
	@ParamDesc(path="PROVINCE_GROUP",cons=ConsType.QUES,type="string",len="4",desc="ʡ�ݴ���",memo="��")
	private String provinceGroup;
	@ParamDesc(path="CONTENT_NAME_STR",cons=ConsType.QUES,type="string",len="100",desc="��������",memo="��")
	private String contentNameStr;
	@ParamDesc(path="BUSI_ID",cons=ConsType.QUES,type="string",len="18",desc="ҵ�����",memo="��")
	private String busiId;
	@ParamDesc(path="BUSI_TYPE",cons=ConsType.CT001,type="string",len="18",desc="ҵ������",memo="��")
	private String busiType;
	
	//Ԥ��
	public void decode(MBean bean) {
		setContentType(bean.getStr(getPathByProperName("contentType")));
		setRegionCode(bean.getStr(getPathByProperName("regionCode")));
		setProvinceGroup(bean.getStr(getPathByProperName("provinceGroup")));
		setContentNameStr(bean.getStr(getPathByProperName("contentNameStr")));
		setBusiId(bean.getStr(getPathByProperName("busiId")));
		setBusiType(bean.getStr(getPathByProperName("busiType")));
	}
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
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

	public String getContentNameStr() {
		return contentNameStr;
	}

	public void setContentNameStr(String contentNameStr) {
		this.contentNameStr = contentNameStr;
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
	
}
